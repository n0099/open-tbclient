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
public class VideoPlayFragment extends BaseFragment implements a.InterfaceC0432a {
    public ImageView aor;
    private boolean cYp;
    private e dkB;
    private String dol;
    private n ePc;
    private AlphaAnimation eRV;
    private boolean fqG;
    private View gzr;
    private int hab;
    private boolean isNewPlayer;
    public com.baidu.tieba.play.a.a keZ;
    private j.b kfV;
    private QuickVideoView.c kgn;
    private TbImageView lrR;
    public ImageView lrS;
    public HeadImageView lrT;
    public LinearLayout lrU;
    public LinearLayout lrV;
    public LinearLayout lrW;
    public ImageView lrX;
    public ImageView lrY;
    public ImageView lrZ;
    public ExpandableTextView lsa;
    public TextView lsb;
    public TextView lsc;
    public TextView lsd;
    public TextView lse;
    public ImageView lsf;
    private LinearLayout lsg;
    public LinearLayout lsh;
    public LinearLayout lsi;
    public VideoItemData lsj;
    private TextView lsk;
    public ImageView lsl;
    public TextView lsm;
    private View lsn;
    private TextView lso;
    private int lsp;
    private int lsq;
    private com.baidu.tieba.view.a lsr;
    protected Animation lss;
    private boolean lst;
    private AnimatorSet lsu;
    private RelativeLayout.LayoutParams lsv;
    private com.baidu.tieba.videoplay.editor.a lsx;
    com.baidu.tbadk.core.dialog.a lsy;
    private String mFrom;
    private String mFromPage;
    private boolean mHasInit;
    private Rect mRect;
    public View mRootView;
    private String mVideoUrl;
    private int lrP = 0;
    private int lrQ = 1;
    private ForumManageModel gqa = null;
    private com.baidu.tbadk.baseEditMark.a jtv = null;
    private com.baidu.tbadk.coreExtra.model.a dzD = null;
    private BdUniqueId afA = BdUniqueId.gen();
    private boolean lsw = false;
    private int playTime = 1;
    private CustomMessageListener dzH = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (VideoPlayFragment.this.lsj != null && VideoPlayFragment.this.lsj.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.lsj.author_info.user_id) && data != null && VideoPlayFragment.this.lsj.author_info.user_id.equals(data.toUid)) {
                    boolean z = true;
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    z = (message == null || message.getTag() == null || !message.getTag().equals(VideoPlayFragment.this.afA)) ? false : false;
                    if (data.dOo == null) {
                        if (!data.isSucc) {
                            if (z && !"0".equals(VideoPlayFragment.this.lsj.author_info.is_follow)) {
                                l.showToast(VideoPlayFragment.this.getActivity(), (int) R.string.attention_fail);
                                VideoPlayFragment.this.lsj.author_info.is_follow = "0";
                                VideoPlayFragment.this.ded();
                            }
                        } else if (updateAttentionMessage.isAttention()) {
                            if (VideoPlayFragment.this.cYp) {
                                if (z) {
                                    l.showToast(VideoPlayFragment.this.getActivity(), (int) R.string.attention_success);
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_AGREE_LOVE, VideoPlayFragment.this.lsj));
                                    return;
                                }
                                VideoPlayFragment.this.lsj.author_info.is_follow = "1";
                                VideoPlayFragment.this.ded();
                            }
                        } else {
                            VideoPlayFragment.this.lsj.author_info.is_follow = "0";
                            VideoPlayFragment.this.ded();
                        }
                    }
                }
            }
        }
    };
    private final CustomMessageListener dkS = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof NetWorkChangedMessage) && customResponsedMessage.getCmd() == 2000994 && !customResponsedMessage.hasError()) {
                VideoPlayFragment.this.dee();
            }
        }
    };
    private CustomMessageListener dDu = new CustomMessageListener(2016528) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                AgreeData agreeData = ((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData()).agreeData;
                if (VideoPlayFragment.this.lsj != null && agreeData != null) {
                    String str = agreeData.nid;
                    if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                        if (VideoPlayFragment.this.lsj.baijiahaoData != null && TextUtils.equals(str, VideoPlayFragment.this.lsj.baijiahaoData.oriUgcNid)) {
                            VideoPlayFragment.this.lsj.agree_num = String.valueOf(agreeData.agreeNum);
                            VideoPlayFragment.this.lsj.is_agreed = agreeData.hasAgree ? "1" : "0";
                            VideoPlayFragment.this.dec();
                            return;
                        }
                        return;
                    }
                    String str2 = agreeData.threadId;
                    String str3 = VideoPlayFragment.this.lsj.thread_id;
                    if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                        VideoPlayFragment.this.lsj.agree_num = String.valueOf(agreeData.agreeNum);
                        VideoPlayFragment.this.lsj.is_agreed = agreeData.hasAgree ? "1" : "0";
                        VideoPlayFragment.this.dec();
                    }
                }
            }
        }
    };
    private g.e lsz = new g.e() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.25
        @Override // com.baidu.tieba.play.g.e
        public boolean onInfo(g gVar, int i, int i2) {
            if (VideoPlayFragment.this.cYp) {
                if ((i == 3 || i == 904) && VideoPlayFragment.this.lrR.getVisibility() == 0) {
                    VideoPlayFragment.this.lrR.clearAnimation();
                    VideoPlayFragment.this.lrR.startAnimation(VideoPlayFragment.this.eRV);
                    return true;
                }
                return true;
            }
            return true;
        }
    };
    private g.a lsA = new g.a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.26
        @Override // com.baidu.tieba.play.g.a
        public void onCompletion(g gVar) {
            if (VideoPlayFragment.this.keZ != null) {
                VideoPlayFragment.this.keZ.cJM();
                VideoPlayFragment.this.keZ.seekTo(0);
                VideoPlayFragment.this.keZ.start();
                VideoPlayFragment.this.bEG();
                VideoPlayFragment.z(VideoPlayFragment.this);
                if (VideoPlayFragment.this.playTime == 3) {
                    VideoPlayFragment.this.ddW();
                }
            }
        }
    };
    private g.f lsB = new g.f() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.27
        @Override // com.baidu.tieba.play.g.f
        public void onPrepared(g gVar) {
            if (VideoPlayFragment.this.keZ != null) {
                VideoPlayFragment.this.keZ.setVolume(1.0f, 1.0f);
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
        registerListener(this.dDu);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle arguments = getArguments();
        this.lsj = (VideoItemData) arguments.get(VideoPlayActivityConfig.VIDEO_DATA);
        this.mRect = (Rect) arguments.getParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT);
        this.lsq = arguments.getInt(VideoPlayActivityConfig.VIDEO_INDEX);
        this.mFrom = arguments.getString(VideoPlayActivityConfig.PAGE_FROM);
        this.mFromPage = arguments.getString("from");
        this.dol = arguments.getString("obj_id");
        if (this.lsj != null && this.lsj.author_info != null && String.valueOf(TbadkCoreApplication.getCurrentAccountId()).equals(this.lsj.author_info.user_id)) {
            this.fqG = true;
        }
        this.ePc = new n(getActivity());
        this.ePc.a(this.lsj);
        this.ePc.a(new j.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.28
            @Override // com.baidu.tieba.play.j.b
            public void bE(int i, int i2) {
                if (VideoPlayFragment.this.kfV != null) {
                    VideoPlayFragment.this.kfV.bE(i, i2);
                }
            }
        });
        this.mRootView = layoutInflater.inflate(R.layout.video_play_view, (ViewGroup) null);
        this.isNewPlayer = b.sV("cyber_player_test") || b.sU("cyber_player_test");
        this.keZ = com.baidu.tieba.play.a.b.A(getContext(), this.isNewPlayer ? 1 : 0);
        dei();
        this.lrR = (TbImageView) this.mRootView.findViewById(R.id.video_cover);
        this.lrR.setPlaceHolder(4);
        this.lrR.setDefaultErrorResource(R.drawable.icon_play_bg);
        if (com.baidu.tbadk.core.util.g.aOf()) {
            this.gzr = this.mRootView.findViewById(R.id.top_container);
            int statusBarHeight = UtilHelper.getStatusBarHeight();
            if (this.gzr.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.gzr.getLayoutParams()).topMargin = statusBarHeight;
            }
        }
        this.aor = (ImageView) this.mRootView.findViewById(R.id.back_btn);
        this.lrS = (ImageView) this.mRootView.findViewById(R.id.more_btn);
        this.lrT = (HeadImageView) this.mRootView.findViewById(R.id.author_portrait);
        this.lrT.setDefaultResource(17170445);
        this.lrT.setPlaceHolder(2);
        this.lrT.setIsRound(true);
        this.lrX = (ImageView) this.mRootView.findViewById(R.id.love_btn);
        this.lsl = (ImageView) this.mRootView.findViewById(R.id.agree_img);
        this.lsa = (ExpandableTextView) this.mRootView.findViewById(R.id.video_title);
        this.lsb = (TextView) this.mRootView.findViewById(R.id.video_activity);
        this.lrV = (LinearLayout) this.mRootView.findViewById(R.id.comment_container);
        this.lsc = (TextView) this.mRootView.findViewById(R.id.comment_num);
        this.lrU = (LinearLayout) this.mRootView.findViewById(R.id.agree_container);
        this.lsd = (TextView) this.mRootView.findViewById(R.id.agree_num);
        this.lse = (TextView) this.mRootView.findViewById(R.id.share_num);
        this.lrY = (ImageView) this.mRootView.findViewById(R.id.share_img);
        this.lrZ = (ImageView) this.mRootView.findViewById(R.id.share_img_changed);
        ddX();
        this.lsf = (ImageView) this.mRootView.findViewById(R.id.play_btn);
        this.lsg = (LinearLayout) this.mRootView.findViewById(R.id.video_act_private_container);
        this.lsh = (LinearLayout) this.mRootView.findViewById(R.id.video_activity_container);
        this.lsi = (LinearLayout) this.mRootView.findViewById(R.id.video_private);
        this.lrW = (LinearLayout) this.mRootView.findViewById(R.id.share_container);
        this.lsm = (TextView) this.mRootView.findViewById(R.id.video_author_name);
        this.lsn = this.mRootView.findViewById(R.id.quick_reply_comment_layout);
        this.lsn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.29
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.a(VideoPlayFragment.this.getPageContext(), 11001)) {
                    VideoPlayFragment.this.lsn.setVisibility(4);
                    if (VideoPlayFragment.this.lsx != null && VideoPlayFragment.this.lsx.aWP() != null) {
                        VideoPlayFragment.this.lsx.aWP().display();
                        if (VideoPlayFragment.this.lsj != null) {
                            VideoPlayFragment.this.lsx.c(VideoPlayFragment.this.lsj);
                        }
                    }
                    if (VideoPlayFragment.this.lsj != null) {
                        an anVar = new an("c13025");
                        anVar.cI("tid", VideoPlayFragment.this.lsj.thread_id);
                        anVar.t("uid", TbadkCoreApplication.getCurrentAccountId());
                        anVar.cI("fid", VideoPlayFragment.this.lsj.forum_id);
                        TiebaStatic.log(anVar);
                    }
                }
            }
        });
        this.lso = (TextView) this.mRootView.findViewById(R.id.quick_reply_comment_text);
        this.lsk = (TextView) this.mRootView.findViewById(R.id.download_nani_guide_txt);
        this.lsk.setVisibility(8);
        String string = com.baidu.tbadk.core.sharedPref.b.aNV().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.lsk.setText(string);
        }
        final String string2 = com.baidu.tbadk.core.sharedPref.b.aNV().getString("nani_key_download_link_url", null);
        this.lsk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.30
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(string2)) {
                    ba.aOY().a((TbPageContext) i.T(VideoPlayFragment.this.getPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        deb();
        this.lrT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.31
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.lsj != null && VideoPlayFragment.this.lsj.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.lsj.author_info.user_id) && VideoPlayFragment.this.lsj != null && VideoPlayFragment.this.lsj.author_info != null) {
                    long j = com.baidu.adp.lib.f.b.toLong(VideoPlayFragment.this.lsj.author_info.user_id, 0L);
                    long j2 = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                    boolean z = j == j2;
                    if (j == 0 && j2 == 0) {
                        z = false;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(VideoPlayFragment.this.getActivity()).createNormalConfig(j, z, false)));
                    an anVar = new an("c12798");
                    anVar.cI("tid", VideoPlayFragment.this.lsj.thread_id);
                    anVar.t("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(anVar);
                }
            }
        });
        this.lsh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.32
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.lsj != null && VideoPlayFragment.this.lsj.act_info != null) {
                    com.baidu.tbadk.browser.a.startInternalWebActivity(VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.lsj.act_info.link_url);
                    an anVar = new an("c12799");
                    anVar.cI("tid", VideoPlayFragment.this.lsj.thread_id);
                    anVar.t("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(anVar);
                }
            }
        });
        this.lsa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.33
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.ddZ();
            }
        });
        this.aor.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.lsj != null && !StringUtils.isNull(VideoPlayFragment.this.lsj.thread_id)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_INDEX, VideoPlayFragment.this.lsj.thread_id));
                }
                VideoPlayFragment.this.getActivity().finish();
            }
        });
        this.lrS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.dea();
            }
        });
        this.lrV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!AntiHelper.a(VideoPlayFragment.this.getPageContext(), VideoPlayFragment.this.lsj)) {
                    VideoPlayFragment.this.ddZ();
                    an anVar = new an("c12796");
                    anVar.cI("tid", VideoPlayFragment.this.lsj.thread_id);
                    anVar.t("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(anVar);
                }
            }
        });
        this.lrU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.Ez(VideoPlayFragment.this.lrP);
            }
        });
        this.lrW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.aQD();
                an anVar = new an("c12797");
                anVar.cI("tid", VideoPlayFragment.this.lsj.thread_id);
                anVar.t("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(anVar);
                an anVar2 = new an(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                anVar2.cI("tid", VideoPlayFragment.this.lsj.thread_id);
                anVar2.cI("uid", TbadkCoreApplication.getCurrentAccount());
                anVar2.af("obj_locate", 19);
                TiebaStatic.log(anVar2);
            }
        });
        this.lrX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bc.checkUpIsLogin(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.lsj != null && VideoPlayFragment.this.lsj.author_info != null) {
                    VideoPlayFragment.this.dzD.a(true, VideoPlayFragment.this.lsj.author_info.portrait, VideoPlayFragment.this.lsj.author_info.user_id, false, "6", VideoPlayFragment.this.afA, VideoPlayFragment.this.lsj.forum_id, "0");
                    VideoPlayFragment.this.lsj.author_info.is_follow = "1";
                    VideoPlayFragment.this.ded();
                }
            }
        });
        this.eRV = new AlphaAnimation(1.0f, 0.0f);
        this.eRV.setDuration(100L);
        this.eRV.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.8
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoPlayFragment.this.lrR != null) {
                    VideoPlayFragment.this.lrR.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        if (this.mRect != null) {
            this.lsp = this.mRect.right - this.mRect.left;
            this.hab = this.mRect.bottom - this.mRect.top;
            this.lrR.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9
                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    int i2;
                    float f;
                    float f2 = 1.0f;
                    int width = VideoPlayFragment.this.lrR.getWidth();
                    int height = VideoPlayFragment.this.lrR.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.lsj.video_height, 0) > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.lsj.video_width, 0) > 0) {
                        float f3 = width / height;
                        float f4 = com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.lsj.video_width, 0.0f) / com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.lsj.video_height, 0.0f);
                        if (f4 > 0.0f && Math.abs(f4 - f3) > 0.05d) {
                            if (f4 > f3) {
                                i = (int) (width / f4);
                                i2 = width;
                            } else {
                                i2 = (int) (height * f4);
                                i = height;
                            }
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(VideoPlayFragment.this.lsp, VideoPlayFragment.this.hab);
                            layoutParams.leftMargin = VideoPlayFragment.this.mRect.left;
                            layoutParams.topMargin = VideoPlayFragment.this.mRect.top;
                            VideoPlayFragment.this.lrR.setLayoutParams(layoutParams);
                            if (VideoPlayFragment.this.hab > 0 || VideoPlayFragment.this.lsp <= 0) {
                                f = 1.0f;
                            } else {
                                f2 = i2 / VideoPlayFragment.this.lsp;
                                f = i / VideoPlayFragment.this.hab;
                            }
                            VideoPlayFragment.this.lrR.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                            VideoPlayFragment.this.lrR.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (VideoPlayFragment.this.cYp) {
                                        VideoPlayFragment.this.startPlay();
                                        VideoPlayFragment.this.mRect = null;
                                    }
                                }
                            }, 200L);
                        }
                    }
                    i = height;
                    i2 = width;
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(VideoPlayFragment.this.lsp, VideoPlayFragment.this.hab);
                    layoutParams2.leftMargin = VideoPlayFragment.this.mRect.left;
                    layoutParams2.topMargin = VideoPlayFragment.this.mRect.top;
                    VideoPlayFragment.this.lrR.setLayoutParams(layoutParams2);
                    if (VideoPlayFragment.this.hab > 0) {
                    }
                    f = 1.0f;
                    VideoPlayFragment.this.lrR.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                    VideoPlayFragment.this.lrR.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoPlayFragment.this.cYp) {
                                VideoPlayFragment.this.startPlay();
                                VideoPlayFragment.this.mRect = null;
                            }
                        }
                    }, 200L);
                }
            });
        } else {
            this.lrR.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.10
                @Override // java.lang.Runnable
                public void run() {
                    int width = VideoPlayFragment.this.lrR.getWidth();
                    int height = VideoPlayFragment.this.lrR.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.lsj.video_height, 0) > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.lsj.video_width, 0) > 0) {
                        float f = width / height;
                        float f2 = com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.lsj.video_width, 0.0f) / com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.lsj.video_height, 0.0f);
                        if (f2 > 0.0f && Math.abs(f2 - f) > 0.05d) {
                            if (f2 > f) {
                                height = (int) (width / f2);
                            } else {
                                width = (int) (height * f2);
                            }
                        }
                        ViewGroup.LayoutParams layoutParams = VideoPlayFragment.this.lrR.getLayoutParams();
                        layoutParams.height = height;
                        layoutParams.width = width;
                        VideoPlayFragment.this.lrR.setLayoutParams(layoutParams);
                    }
                }
            });
        }
        cqO();
        if (this.cYp) {
            ddY();
        }
        if (this.lsj != null && !StringUtils.isNull(this.lsj.video_url)) {
            setVideoInfo(this.lsj.video_url);
        }
        return this.mRootView;
    }

    public boolean cIV() {
        return !this.isNewPlayer && (this.keZ instanceof QuickVideoView);
    }

    public void a(j.b bVar) {
        this.kfV = bVar;
    }

    public void setVideoStatusListener(QuickVideoView.c cVar) {
        this.kgn = cVar;
    }

    private void cqO() {
        this.lsx = (com.baidu.tieba.videoplay.editor.a) new com.baidu.tieba.videoplay.editor.b().dI(getActivity());
        if (this.lsx != null && this.lsj != null) {
            this.lsx.a(getPageContext());
            this.lsx.av(this.lsj.thread_id, this.lsj.forum_id, this.lsj.forum_name);
            this.lsx.a(new a.InterfaceC0670a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.11
                @Override // com.baidu.tieba.videoplay.editor.a.InterfaceC0670a
                public void uH(boolean z) {
                    VideoPlayFragment.this.lsn.setVisibility(0);
                    if (z) {
                        VideoPlayFragment.this.lso.setText(R.string.reply_something);
                    } else {
                        VideoPlayFragment.this.lso.setText(StringUtils.isNull(((c) VideoPlayFragment.this.lsx.aWP().mD(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
                    }
                    if (VideoPlayFragment.this.lsj != null && z) {
                        long j = com.baidu.adp.lib.f.b.toLong(VideoPlayFragment.this.lsj.comment_num, 0L) + 1;
                        VideoPlayFragment.this.lsj.comment_num = String.valueOf(j);
                        VideoPlayFragment.this.lsc.setText(aq.numFormatOverWan(j));
                    }
                }
            });
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            ((RelativeLayout) this.mRootView).addView(this.lsx.aWP(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQD() {
        String str;
        String str2;
        if (this.lsj != null) {
            String str3 = this.lsj.forum_id;
            String str4 = this.lsj.forum_name;
            String str5 = this.lsj.title;
            if (this.lsj.baijiahaoData != null) {
                str = this.lsj.baijiahaoData.oriUgcTid;
                str2 = "?share=9105&fr=dshare&dtype=" + this.lsj.baijiahaoData.oriUgcType + "&dvid=" + this.lsj.baijiahaoData.oriUgcVid + "&nid=" + this.lsj.baijiahaoData.oriUgcNid;
            } else {
                str = this.lsj.thread_id;
                str2 = "?share=9105&fr=share";
            }
            String str6 = "http://tieba.baidu.com/p/" + str + str2;
            String str7 = this.lsj.thumbnail_url;
            String format = (!this.lsj.isBjhVideo || this.lsj.author_info == null) ? MessageFormat.format(getResources().getString(R.string.share_content_tpl), str5, "") : MessageFormat.format(getResources().getString(R.string.default_share_content_tpl), this.lsj.author_info.name_show, getResources().getString(R.string.default_share_content_tpl_suffix));
            Uri parse = str7 == null ? null : Uri.parse(str7);
            ShareItem shareItem = new ShareItem();
            shareItem.title = str5;
            shareItem.content = format;
            if (this.lsj.baijiahaoData == null) {
                shareItem.readCount = this.lsj.play_count;
            }
            if (this.lsj.isBjhVideo) {
                shareItem.dQv = format;
            } else {
                shareItem.dQv = "";
            }
            shareItem.linkUrl = str6;
            shareItem.dua = 2;
            shareItem.extData = str;
            shareItem.dQy = 3;
            shareItem.fid = str3;
            shareItem.fName = str4;
            shareItem.tid = str;
            shareItem.dQl = true;
            shareItem.dQx = 12;
            shareItem.dQC = 2;
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            if (this.lsj.isBjhVideo) {
                shareItem.canShareBySmartApp = false;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = this.lsj.thumbnail_url;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = this.lsj.title;
            originalThreadInfo.threadId = this.lsj.thread_id;
            originalThreadInfo.oriUgcInfo = this.lsj.baijiahaoData;
            shareItem.dQF = OriginalThreadInfo.ShareInfo.generateShareInfo(originalThreadInfo);
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.dQy);
            bundle.putInt("obj_type", shareItem.dQC);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.dua);
            shareItem.Y(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getActivity(), shareItem, true, true);
            shareDialogConfig.setIsAlaLive(false);
            shareDialogConfig.setFrom(ShareDialogConfig.From.VideoMiddlePageVertical);
            com.baidu.tieba.c.e.bGe().b(shareDialogConfig);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.fqG) {
            this.gqa = new ForumManageModel(getPageContext());
            this.gqa.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.13
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (obj != null) {
                        switch (VideoPlayFragment.this.gqa.getLoadDataMode()) {
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
        this.jtv = com.baidu.tbadk.baseEditMark.a.a(getBaseFragmentActivity());
        if (this.jtv != null) {
            this.jtv.a(new a.InterfaceC0404a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.14
                @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0404a
                public void c(boolean z, boolean z2, String str) {
                    if (z) {
                        if (VideoPlayFragment.this.jtv != null) {
                            VideoPlayFragment.this.jtv.gk(z2);
                        }
                        if (VideoPlayFragment.this.lsj != null) {
                            if (z2) {
                                VideoPlayFragment.this.lsj.mark_id = VideoPlayFragment.this.lsj.post_id;
                            } else {
                                VideoPlayFragment.this.lsj.mark_id = null;
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
        this.dzD = new com.baidu.tbadk.coreExtra.model.a(null);
        registerListener(this.dzH);
        registerListener(this.dkS);
        if (Build.VERSION.SDK_INT >= 24 && getBaseFragmentActivity().isInMultiWindowMode()) {
            this.lsw = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        deb();
        dej();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ddW() {
        if (this.lrZ != null && this.lrY != null) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(300L);
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation2.setDuration(300L);
            this.lrY.clearAnimation();
            this.lrZ.clearAnimation();
            this.lrY.setVisibility(8);
            this.lrZ.setVisibility(0);
            this.lrZ.startAnimation(scaleAnimation2);
            this.lrY.startAnimation(scaleAnimation);
        }
    }

    private void ddX() {
        if (this.lrZ != null && this.lrY != null) {
            this.lrY.clearAnimation();
            this.lrZ.clearAnimation();
            this.lrY.setVisibility(0);
            this.lrZ.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ez(int i) {
        int i2;
        if (bc.checkUpIsLogin(getActivity()) && this.lsj != null) {
            if (i == this.lrP) {
                if ("1".equals(this.lsj.is_agreed)) {
                    i2 = 1;
                    this.lsj.agree_num = String.valueOf(com.baidu.adp.lib.f.b.toInt(this.lsj.agree_num, 0) - 1);
                    this.lsj.is_agreed = "0";
                } else {
                    this.lsj.agree_num = String.valueOf(com.baidu.adp.lib.f.b.toInt(this.lsj.agree_num, 0) + 1);
                    this.lsj.is_agreed = "1";
                    i2 = 0;
                }
            } else {
                this.lsj.agree_num = String.valueOf(com.baidu.adp.lib.f.b.toInt(this.lsj.agree_num, 0) + 1);
                this.lsj.is_agreed = "1";
                i2 = 0;
            }
            an anVar = new an("c12795");
            anVar.cI("tid", this.lsj.thread_id);
            anVar.t("uid", TbadkCoreApplication.getCurrentAccountId());
            if (i == this.lrP) {
                anVar.af("obj_type", i2);
            } else {
                anVar.af("obj_type", 2);
            }
            TiebaStatic.log(anVar);
            deb();
            if (this.lsl != null && i2 == 0) {
                this.lsl.startAnimation(getScaleAnimation());
            }
            HttpMessage httpMessage = new HttpMessage(1001601);
            httpMessage.addParam("thread_id", this.lsj.thread_id);
            httpMessage.addParam("op_type", i2);
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            httpMessage.addHeader("needSig", "1");
            if (this.lsj.baijiahaoData != null) {
                httpMessage.addParam("ori_ugc_tid", this.lsj.baijiahaoData.oriUgcTid);
                httpMessage.addParam("ori_ugc_nid", this.lsj.baijiahaoData.oriUgcNid);
                httpMessage.addParam("ori_ugc_vid", this.lsj.baijiahaoData.oriUgcVid);
                httpMessage.addParam("ori_ugc_type", this.lsj.baijiahaoData.oriUgcType);
            }
            sendMessage(httpMessage);
            com.baidu.tieba.tbadkCore.data.e eVar = new com.baidu.tieba.tbadkCore.data.e();
            AgreeData agreeData = new AgreeData();
            agreeData.agreeNum = Long.valueOf(this.lsj.agree_num).longValue();
            agreeData.agreeType = 2;
            agreeData.hasAgree = "1".equals(this.lsj.is_agreed);
            eVar.agreeData = agreeData;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, eVar));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_AGREE_LOVE, this.lsj));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (!TbSingleton.getInstance().isNotchScreen(getActivity()) && !TbSingleton.getInstance().isCutoutScreen(getActivity())) {
            this.mRootView.setSystemUiVisibility(4);
        }
        if (this.lsj != null && !StringUtils.isNull(this.lsj.video_url)) {
            this.mHasInit = true;
            if (this.cYp) {
                bEG();
                aso();
                if (this.lsj != null && this.mRect != null) {
                    an anVar = new an("c12794");
                    anVar.cI("tid", this.lsj.thread_id);
                    anVar.t("uid", TbadkCoreApplication.getCurrentAccountId());
                    anVar.af("obj_type", 0);
                    TiebaStatic.log(anVar);
                    return;
                }
                return;
            }
            asn();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        asn();
        if (this.lsx != null && this.lsx.aWP() != null) {
            this.lsx.aWP().hide();
            this.lsn.setVisibility(0);
            this.lso.setText(StringUtils.isNull(((c) this.lsx.aWP().mD(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
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
        MessageManager.getInstance().unRegisterListener(this.dDu);
        if (this.lsx != null) {
            this.lsx.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.cYp = z;
        if (!z && this.lsx != null) {
            this.lso.setText(R.string.reply_something);
            this.lsx.des();
        }
        if (this.mHasInit) {
            if (this.cYp && (!this.lsw || Build.VERSION.SDK_INT < 24 || !getBaseFragmentActivity().isInMultiWindowMode())) {
                if (this.lsj != null && this.mRect == null) {
                    an anVar = new an("c12794");
                    anVar.cI("tid", this.lsj.thread_id);
                    anVar.t("uid", TbadkCoreApplication.getCurrentAccountId());
                    anVar.af("obj_type", 1);
                    TiebaStatic.log(anVar);
                }
                startPlay();
                ddY();
                this.lsw = false;
                return;
            }
            ddX();
            this.playTime = 1;
            asn();
        }
    }

    private void ddY() {
        if (this.lsj != null) {
            an anVar = new an("c12590");
            anVar.cI("tid", this.lsj.thread_id);
            anVar.cI("fid", this.lsj.forum_id);
            anVar.t("uid", TbadkCoreApplication.getCurrentAccountId());
            anVar.af("obj_locate", this.lsq);
            anVar.af(TiebaInitialize.Params.OBJ_PARAM2, 1);
            anVar.cI("obj_param1", aq.isEmpty(this.lsj.mRecomWeight) ? "0" : this.lsj.mRecomWeight);
            anVar.cI("extra", aq.isEmpty(this.lsj.mRecomExtra) ? "0" : this.lsj.mRecomExtra);
            anVar.cI("obj_id", this.dol);
            anVar.cI(TiebaInitialize.Params.AB_TAG, aq.isEmpty(this.lsj.mRecomAbTag) ? "0" : this.lsj.mRecomAbTag);
            anVar.cI("obj_source", aq.isEmpty(this.lsj.mRecomSource) ? "0" : this.lsj.mRecomSource);
            anVar.cI("obj_type", this.mFromPage);
            anVar.af("is_vertical", 1);
            if (this.lsj.baijiahaoData != null) {
                anVar.cI("obj_param4", this.lsj.baijiahaoData.oriUgcNid);
                anVar.cI("obj_param6", this.lsj.baijiahaoData.oriUgcVid);
                if (this.lsj.baijiahaoData.oriUgcType == 4) {
                    anVar.af("obj_param5", 2);
                } else if (this.lsj.baijiahaoData.oriUgcType == 2) {
                    anVar.af("obj_param5", 3);
                }
            } else {
                anVar.af("obj_param5", 1);
            }
            TiebaStatic.log(anVar);
        }
    }

    private void setVideoInfo(String str) {
        if (this.keZ != null && str != null && !str.equals(this.mVideoUrl)) {
            if (cIV()) {
                ((QuickVideoView) this.keZ).setRecoveryState(0);
            }
            this.keZ.setVideoPath(str, this.lsj.thread_id);
            this.mVideoUrl = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay() {
        if (!dee()) {
            cJh();
            if (this.lsf != null) {
                this.lsf.setVisibility(8);
            }
            if (Build.VERSION.SDK_INT < 17 && this.lrR.getVisibility() == 0) {
                this.lrR.clearAnimation();
                this.lrR.startAnimation(this.eRV);
            }
            if (this.keZ != null) {
                if (TbVideoViewSet.cKw().IM(this.mVideoUrl) == null || TbVideoViewSet.cKw().IM(this.mVideoUrl) != this.keZ) {
                    this.keZ.setVideoPath(this.mVideoUrl, this.lsj.thread_id);
                }
                this.keZ.start();
                bEG();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEG() {
        if (this.lsj != null) {
            y yVar = new y();
            yVar.mLocate = "nani_midpage";
            yVar.ahL = this.lsj.thread_id;
            yVar.eQf = this.lsj.forum_id + "";
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.mSource = this.lsj.mRecomSource;
            yVar.kin = this.lsj.mRecomAbTag;
            yVar.kio = this.lsj.mRecomWeight;
            yVar.kip = "";
            yVar.dol = "";
            yVar.kis = this.lsj.mMd5;
            if (this.mRect != null) {
                yVar.kit = "1";
            } else {
                yVar.kit = "2";
            }
            if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                yVar.kiu = "1";
                yVar.mLocate = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                yVar.kip = "index";
            }
            com.baidu.tieba.play.l.a(this.lsj.mMd5, "", "1", yVar);
        }
    }

    private void cJh() {
        if (com.baidu.adp.lib.util.j.isMobileNet()) {
            com.baidu.tieba.video.g.day().fp(getContext());
        }
    }

    private void asn() {
        if (this.keZ != null) {
            this.keZ.pause();
        }
    }

    private void stopPlay() {
        if (this.keZ != null) {
            if (cIV()) {
                ((QuickVideoView) this.keZ).setRecoveryState(5);
            }
            this.keZ.stopPlayback();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ddZ() {
        PbActivityConfig createNormalCfg = new PbActivityConfig(getActivity()).createNormalCfg(this.lsj.thread_id, this.lsj.post_id, "");
        createNormalCfg.setForumId(String.valueOf(this.lsj.forum_id));
        createNormalCfg.setForumName(this.lsj.forum_name);
        createNormalCfg.setVideo_source("nani_midpage");
        createNormalCfg.setJumpToCommentArea(true);
        createNormalCfg.setBjhData(this.lsj.baijiahaoData);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dea() {
        if (this.dkB == null) {
            this.lsr = new com.baidu.tieba.view.a(getActivity());
            this.dkB = new e(getActivity(), this.lsr.aNj());
            this.dkB.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.15
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (!TbSingleton.getInstance().isNotchScreen(VideoPlayFragment.this.getActivity()) && !TbSingleton.getInstance().isCutoutScreen(VideoPlayFragment.this.getActivity())) {
                        VideoPlayFragment.this.keZ.getView().setSystemUiVisibility(4);
                    }
                }
            });
        }
        if (this.lsr != null) {
            ArrayList arrayList = new ArrayList();
            a.C0671a c0671a = new a.C0671a(this.lsr);
            c0671a.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.16
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    if (!bc.checkUpIsLogin(VideoPlayFragment.this.getContext())) {
                        VideoPlayFragment.this.dkB.dismiss();
                        return;
                    }
                    VideoPlayFragment.this.dkB.dismiss();
                    if (VideoPlayFragment.this.lsj != null) {
                        boolean z = VideoPlayFragment.this.lsj.post_id != null && VideoPlayFragment.this.lsj.post_id.equals(VideoPlayFragment.this.lsj.mark_id);
                        MarkData markData = new MarkData();
                        Date date = new Date();
                        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
                        markData.setThreadId(VideoPlayFragment.this.lsj.thread_id);
                        markData.setPostId(VideoPlayFragment.this.lsj.post_id);
                        markData.setTime(date.getTime());
                        markData.setHostMode(false);
                        markData.setId(VideoPlayFragment.this.lsj.thread_id);
                        markData.setForumId(VideoPlayFragment.this.lsj.forum_id);
                        if (VideoPlayFragment.this.jtv != null) {
                            VideoPlayFragment.this.jtv.a(markData);
                            if (!z) {
                                VideoPlayFragment.this.jtv.aHb();
                            } else {
                                VideoPlayFragment.this.jtv.aHa();
                            }
                        }
                    }
                }
            });
            boolean z = false;
            if (this.lsj != null && this.lsj.post_id != null && this.lsj.post_id.equals(this.lsj.mark_id)) {
                z = true;
            }
            if (z) {
                c0671a.setText(getResources().getString(R.string.remove_mark));
            } else {
                c0671a.setText(getResources().getString(R.string.mark));
            }
            if (this.lsj != null && !this.lsj.isBjhVideo) {
                arrayList.add(c0671a);
            }
            a.C0671a c0671a2 = new a.C0671a(getActivity().getString(R.string.delete), this.lsr);
            c0671a2.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.17
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    VideoPlayFragment.this.dkB.dismiss();
                    if (bc.checkUpIsLogin(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.lsj != null) {
                        String str = VideoPlayFragment.this.lsj.thread_id;
                        String str2 = VideoPlayFragment.this.lsj.forum_id;
                        String string = VideoPlayFragment.this.getResources().getString(R.string.web_view_report_title);
                        String str3 = "http://tieba.baidu.com/mo/q/postreport?fid=" + str2 + "&tid=" + str + "&pid=" + VideoPlayFragment.this.lsj.post_id;
                        if (VideoPlayFragment.this.lsj.isBjhVideo) {
                            str3 = String.format(TbConfig.URL_BJH_REPORT, str, VideoPlayFragment.this.lsj.post_id) + "&channelid=33840";
                            string = "";
                        }
                        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(VideoPlayFragment.this.getPageContext().getPageActivity(), string, str3, true);
                        if (VideoPlayFragment.this.lsj.isBjhVideo) {
                            tbWebViewActivityConfig.setFixTitle(true);
                        }
                        VideoPlayFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
                    }
                }
            });
            c0671a2.setText(getResources().getString(R.string.report_text));
            arrayList.add(c0671a2);
            if (this.fqG) {
                a.C0671a c0671a3 = new a.C0671a(getActivity().getString(R.string.delete), this.lsr);
                c0671a3.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.18
                    @Override // com.baidu.tieba.view.a.c
                    public void onClick() {
                        VideoPlayFragment.this.dkB.dismiss();
                        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(VideoPlayFragment.this.getActivity());
                        aVar.kd(R.string.del_thread_confirm);
                        aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.18.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar.dismiss();
                                if (VideoPlayFragment.this.lsj != null) {
                                    VideoPlayFragment.this.gqa.a(VideoPlayFragment.this.lsj.forum_id, VideoPlayFragment.this.lsj.forum_name, VideoPlayFragment.this.lsj.thread_id, VideoPlayFragment.this.lsj.post_id, 0, 0, VideoPlayFragment.this.fqG, null);
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
                        aVar.aMU();
                    }
                });
                c0671a3.setText(getResources().getString(R.string.delete));
                arrayList.add(c0671a3);
            }
            this.lsr.aI(arrayList);
        }
        this.dkB.show();
    }

    private void deb() {
        if (this.lsj != null) {
            this.lrR.startLoad(this.lsj.thumbnail_url, 10, false);
            Matcher matcher = Pattern.compile("^我发表了?一(篇|个)视频贴(，|,).+$").matcher(this.lsj.title);
            if (StringUtils.isNull(this.lsj.title) || matcher.matches()) {
                this.lsa.setVisibility(8);
            } else {
                this.lsa.setVisibility(0);
                this.lsa.setTextSize(l.getDimens(getContext(), R.dimen.tbfontsize40));
                this.lsa.setTextColor(R.color.cp_cont_a);
                this.lsa.setLineSpacingExtra(l.getDimens(getContext(), R.dimen.tbds14));
                this.lsa.setExpandable(true);
                this.lsa.setOnStatusChangedListener(new ExpandableTextView.a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.19
                    @Override // com.baidu.tieba.view.expandable.ExpandableTextView.a
                    public void nw(boolean z) {
                        VideoPlayFragment.this.lsj.isTitleExpanded = z;
                    }
                });
                this.lsa.setData(this.lsj.title, this.lsj.isTitleExpanded);
            }
            this.lsc.setText(aq.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.lsj.comment_num, 0L)));
            this.lsd.setText(aq.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.lsj.agree_num, 0L)));
            this.lse.setText(aq.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.lsj.share_num, 0L)));
            if (this.lsj.author_info != null) {
                if (!TextUtils.isEmpty(this.lsj.author_info.bjhAvatar)) {
                    this.lrT.startLoad(this.lsj.author_info.bjhAvatar, 12, false);
                } else if (!StringUtils.isNull(this.lsj.author_info.portrait) && this.lsj.author_info.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.lrT.startLoad(this.lsj.author_info.portrait, 10, false);
                } else {
                    this.lrT.startLoad(this.lsj.author_info.portrait, 12, false);
                }
                if (StringUtils.isNull(this.lsj.author_info.dau())) {
                    this.lsm.setVisibility(8);
                } else {
                    this.lsm.setVisibility(0);
                    this.lsm.setText(UgcConstant.AT_RULE_TAG + this.lsj.author_info.dau());
                }
            }
            if ("1".equals(this.lsj.is_private) && this.lsk.getVisibility() != 0) {
                this.lsi.setVisibility(0);
            } else {
                this.lsi.setVisibility(8);
            }
            if ("1".equals(this.lsj.is_agreed)) {
                am.setImageResource(this.lsl, R.drawable.icon_card_like_white_full_s);
            } else {
                am.setImageResource(this.lsl, R.drawable.btn_video_agree);
            }
            if (this.lsj.act_info != null && !StringUtils.isNull(this.lsj.act_info.activity_name) && this.lsk.getVisibility() != 0) {
                this.lsh.setVisibility(0);
                this.lsb.setText(this.lsj.act_info.activity_name);
            } else {
                this.lsh.setVisibility(8);
            }
            ded();
            if (this.lsj.isBjhVideo) {
                this.lrS.setVisibility(8);
            } else {
                this.lrS.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dec() {
        if (this.lsj != null) {
            if ("1".equals(this.lsj.is_agreed)) {
                am.setImageResource(this.lsl, R.drawable.icon_card_like_white_full_s);
            } else {
                am.setImageResource(this.lsl, R.drawable.btn_video_agree);
            }
            this.lsd.setText(aq.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.lsj.agree_num, 0L)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ded() {
        if (this.fqG || (this.lsj.author_info != null && !"0".equals(this.lsj.author_info.is_follow))) {
            this.lrX.setVisibility(4);
            this.lrX.setClickable(false);
            return;
        }
        this.lrX.setVisibility(0);
        this.lrX.setClickable(true);
    }

    private void bCV() {
        if (getActivity() != null) {
            if (this.lsy == null || !this.lsy.isShowing()) {
                this.lsy = new com.baidu.tbadk.core.dialog.a(getActivity());
                View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.video_no_wifi_dialog, (ViewGroup) null);
                ((TextView) inflate.findViewById(R.id.tv_title)).setText(R.string.confirm_title);
                ((TextView) inflate.findViewById(R.id.tv_msg)).setText(R.string.enter_video_center_page_no_wifi_tip);
                ((TextView) inflate.findViewById(R.id.tv_open_free_data)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.20
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        com.baidu.tbadk.browser.a.startWebActivity(true, (Context) VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.getResources().getString(R.string.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
                    }
                });
                SvgManager.aOU().a((ImageView) inflate.findViewById(R.id.open_free_data_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
                this.lsy.aP(inflate);
                this.lsy.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.21
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        TbSingleton.getInstance().setHasAgreeToPlay(true);
                        VideoPlayFragment.this.startPlay();
                    }
                });
                this.lsy.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.22
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                    }
                });
                this.lsy.kg(1);
                this.lsy.ke(R.color.cp_cont_b);
                this.lsy.gE(true);
                this.lsy.b(getPageContext());
                this.lsy.aMU();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dee() {
        if (TbSingleton.getInstance().hasAgreeToPlay() || com.baidu.tieba.video.g.day().daz() || TbadkCoreApplication.getInst().getVideoAutoPlay() == 2 || !com.baidu.adp.lib.util.j.isMobileNet() || !this.cYp) {
            return false;
        }
        if (this.lsf != null) {
            this.lsf.setVisibility(0);
        }
        asn();
        bCV();
        return true;
    }

    private void aso() {
        if (!dee() && this.keZ != null && this.lsf != null && this.lsj != null) {
            if (this.keZ.getParent() == null) {
                dei();
                dej();
            }
            if (TbVideoViewSet.cKw().IM(this.mVideoUrl) == null || TbVideoViewSet.cKw().IM(this.mVideoUrl) != this.keZ) {
                this.keZ.setVideoPath(this.mVideoUrl, this.lsj.thread_id);
            }
            this.keZ.b(null);
            this.lsf.setVisibility(8);
            cJh();
            if (this.kgn != null) {
                this.kgn.onStart();
            }
        }
    }

    protected Animation getScaleAnimation() {
        if (this.lss == null) {
            this.lss = AnimationUtils.loadAnimation(getContext(), R.anim.scale_zoom_in_and_out_anim);
        }
        return this.lss;
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0432a
    public void bdA() {
        if (this.keZ.isPlaying()) {
            this.keZ.pause();
            this.lsf.setVisibility(0);
        } else if (!dee()) {
            this.keZ.start();
            this.lsf.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0432a
    public void t(float f, float f2) {
        if (bc.checkUpIsLogin(getActivity()) && !this.lst) {
            def();
            if (this.lsj != null && "0".equals(this.lsj.is_agreed)) {
                Ez(this.lrQ);
            }
        }
    }

    private void def() {
        if (this.mRootView != null) {
            this.lst = true;
            final ImageView imageView = new ImageView(this.mRootView.getContext());
            imageView.setImageResource(R.drawable.icon_video_like);
            if (this.lsv == null) {
                this.lsv = new RelativeLayout.LayoutParams(-2, -2);
                this.lsv.addRule(13);
            }
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(imageView, this.lsv);
            }
            if (this.lsu == null) {
                this.lsu = new AnimatorSet();
                this.lsu.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.24
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        VideoPlayFragment.this.lst = false;
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
            this.lsu.setTarget(imageView);
            this.lsu.playSequentially(ofPropertyValuesHolder, ofPropertyValuesHolder2);
            this.lsu.start();
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0432a
    public void bdB() {
        if (this.lsj != null && this.lsj.author_info != null) {
            long j = com.baidu.adp.lib.f.b.toLong(this.lsj.author_info.user_id, 0L);
            long j2 = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
            boolean z = j == j2;
            if (j == 0 && j2 == 0) {
                z = false;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(getActivity()).createNormalConfig(j, z, false)));
        }
    }

    public List<String> getMediaIDs() {
        if (cIV()) {
            return ((QuickVideoView) this.keZ).getMediaIDs();
        }
        return null;
    }

    public String deg() {
        if (cIV()) {
            return ((QuickVideoView) this.keZ).getMediaId();
        }
        return null;
    }

    public boolean deh() {
        if (this.lsx == null || this.lsx.aWP() == null || !this.lsx.aWP().isVisible()) {
            return false;
        }
        this.lsx.aWP().hide();
        this.lsn.setVisibility(0);
        if ((this.lsx.aWP().mD(28) instanceof c) && ((c) this.lsx.aWP().mD(28)).getInputView() != null && ((c) this.lsx.aWP().mD(28)).getInputView().getText() != null) {
            this.lso.setText(StringUtils.isNull(((c) this.lsx.aWP().mD(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
        }
        return true;
    }

    public void c(int i, int i2, Intent intent) {
        if (this.lsx != null) {
            this.lsx.onActivityResult(i, i2, intent);
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
        if (this.lsx != null && this.lsx.aWP() != null) {
            this.lsx.aWP().onChangeSkinType(i);
        }
        SvgManager.aOU().a(this.aor, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
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

    public void dei() {
        if (this.keZ != null && this.keZ.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            ((ViewGroup) this.mRootView).addView(this.keZ.getView(), 0);
            this.keZ.getView().setLayoutParams(layoutParams);
            if (cIV()) {
                ((QuickVideoView) this.keZ).setNeedRecovery(true);
            }
            if (this.lsj != null) {
                y yVar = new y();
                yVar.mUid = TbadkCoreApplication.getCurrentAccount();
                yVar.ahL = this.lsj.thread_id;
                yVar.eQf = this.lsj.forum_id;
                yVar.kis = this.lsj.mMd5;
                yVar.dol = "";
                yVar.mSource = this.lsj.mRecomSource;
                yVar.kir = this.lsj.mRecomAbTag;
                yVar.kiq = 1;
                if (this.lsj.baijiahaoData != null) {
                    if (this.lsj.baijiahaoData.oriUgcType == 2) {
                        yVar.kiq = 3;
                    } else if (this.lsj.baijiahaoData.oriUgcType == 4) {
                        yVar.kiq = 2;
                    }
                }
                yVar.kio = this.lsj.mRecomWeight;
                if (this.mRect != null) {
                    yVar.kit = "1";
                } else {
                    yVar.kit = "2";
                }
                if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                    yVar.kiu = "1";
                    yVar.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                    yVar.kip = this.mFromPage;
                    yVar.dol = this.dol;
                    yVar.kin = this.lsj.mRecomWeight;
                } else {
                    yVar.mLocate = "14";
                }
                this.ePc.setVideoStatsData(yVar);
                this.ePc.kho = true;
            }
            this.keZ.setContinuePlayEnable(true);
            this.keZ.setBusiness(this.ePc);
        }
    }

    private void dej() {
        if (Build.VERSION.SDK_INT >= 17) {
            this.keZ.setOnPreparedListener(this.lsB);
        }
        this.keZ.setOnCompletionListener(this.lsA);
        this.keZ.setOnOutInfoListener(this.lsz);
    }
}
