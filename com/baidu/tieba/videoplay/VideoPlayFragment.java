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
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
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
/* loaded from: classes8.dex */
public class VideoPlayFragment extends BaseFragment implements a.InterfaceC0387a {
    public ImageView Ug;
    private e cGR;
    private String cKC;
    private boolean eGA;
    private n egK;
    private AlphaAnimation eiU;
    private View fOa;
    private boolean isNewPlayer;
    private j.b jpV;
    public com.baidu.tieba.play.a.a jpa;
    private QuickVideoView.c jqm;
    public TextView kBA;
    public TextView kBB;
    public ImageView kBC;
    private LinearLayout kBD;
    public LinearLayout kBE;
    public LinearLayout kBF;
    public VideoItemData kBG;
    private TextView kBH;
    public ImageView kBI;
    public TextView kBJ;
    private View kBK;
    private TextView kBL;
    private int kBM;
    private com.baidu.tieba.view.a kBN;
    protected Animation kBO;
    private boolean kBP;
    private AnimatorSet kBQ;
    private RelativeLayout.LayoutParams kBR;
    private com.baidu.tieba.videoplay.editor.a kBT;
    com.baidu.tbadk.core.dialog.a kBU;
    private TbImageView kBo;
    public ImageView kBp;
    public HeadImageView kBq;
    public LinearLayout kBr;
    public LinearLayout kBs;
    public LinearLayout kBt;
    public ImageView kBu;
    public ImageView kBv;
    public ImageView kBw;
    public ExpandableTextView kBx;
    public TextView kBy;
    public TextView kBz;
    private String mFrom;
    private String mFromPage;
    private boolean mHasInit;
    private boolean mIsVisible;
    private int mOriginHeight;
    private int mOriginWidth;
    private Rect mRect;
    public View mRootView;
    private String mVideoUrl;
    private int kBm = 0;
    private int kBn = 1;
    private ForumManageModel fEP = null;
    private com.baidu.tbadk.baseEditMark.a iCr = null;
    private com.baidu.tbadk.coreExtra.model.a cVO = null;
    private BdUniqueId Mh = BdUniqueId.gen();
    private boolean kBS = false;
    private int playTime = 1;
    private CustomMessageListener cVS = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (VideoPlayFragment.this.kBG != null && VideoPlayFragment.this.kBG.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.kBG.author_info.user_id) && data != null && VideoPlayFragment.this.kBG.author_info.user_id.equals(data.toUid)) {
                    boolean z = true;
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    z = (message == null || message.getTag() == null || !message.getTag().equals(VideoPlayFragment.this.Mh)) ? false : false;
                    if (data.djy == null) {
                        if (!data.isSucc) {
                            if (z && !"0".equals(VideoPlayFragment.this.kBG.author_info.is_follow)) {
                                l.showToast(VideoPlayFragment.this.getActivity(), (int) R.string.attention_fail);
                                VideoPlayFragment.this.kBG.author_info.is_follow = "0";
                                VideoPlayFragment.this.cQu();
                            }
                        } else if (updateAttentionMessage.isAttention()) {
                            if (VideoPlayFragment.this.mIsVisible) {
                                if (z) {
                                    l.showToast(VideoPlayFragment.this.getActivity(), (int) R.string.attention_success);
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_AGREE_LOVE, VideoPlayFragment.this.kBG));
                                    return;
                                }
                                VideoPlayFragment.this.kBG.author_info.is_follow = "1";
                                VideoPlayFragment.this.cQu();
                            }
                        } else {
                            VideoPlayFragment.this.kBG.author_info.is_follow = "0";
                            VideoPlayFragment.this.cQu();
                        }
                    }
                }
            }
        }
    };
    private final CustomMessageListener cHi = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof NetWorkChangedMessage) && customResponsedMessage.getCmd() == 2000994 && !customResponsedMessage.hasError()) {
                VideoPlayFragment.this.cQv();
            }
        }
    };
    private g.e kBV = new g.e() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.24
        @Override // com.baidu.tieba.play.g.e
        public boolean onInfo(g gVar, int i, int i2) {
            if (VideoPlayFragment.this.mIsVisible) {
                if ((i == 3 || i == 904) && VideoPlayFragment.this.kBo.getVisibility() == 0) {
                    VideoPlayFragment.this.kBo.clearAnimation();
                    VideoPlayFragment.this.kBo.startAnimation(VideoPlayFragment.this.eiU);
                    return true;
                }
                return true;
            }
            return true;
        }
    };
    private g.a kBW = new g.a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.25
        @Override // com.baidu.tieba.play.g.a
        public void onCompletion(g gVar) {
            if (VideoPlayFragment.this.jpa != null) {
                VideoPlayFragment.this.jpa.seekTo(0);
                VideoPlayFragment.this.jpa.start();
                VideoPlayFragment.this.bsg();
                VideoPlayFragment.y(VideoPlayFragment.this);
                if (VideoPlayFragment.this.playTime == 3 && !VideoPlayFragment.this.kBG.isBjhVideo) {
                    VideoPlayFragment.this.cQo();
                }
            }
        }
    };
    private g.f kBX = new g.f() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.26
        @Override // com.baidu.tieba.play.g.f
        public void onPrepared(g gVar) {
            if (VideoPlayFragment.this.jpa != null) {
                VideoPlayFragment.this.jpa.setVolume(1.0f, 1.0f);
            }
        }
    };

    static /* synthetic */ int y(VideoPlayFragment videoPlayFragment) {
        int i = videoPlayFragment.playTime;
        videoPlayFragment.playTime = i + 1;
        return i;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle arguments = getArguments();
        this.kBG = (VideoItemData) arguments.get(VideoPlayActivityConfig.VIDEO_DATA);
        this.mRect = (Rect) arguments.getParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT);
        this.kBM = arguments.getInt(VideoPlayActivityConfig.VIDEO_INDEX);
        this.mFrom = arguments.getString(VideoPlayActivityConfig.PAGE_FROM);
        this.mFromPage = arguments.getString("from");
        this.cKC = arguments.getString("obj_id");
        if (this.kBG != null && this.kBG.author_info != null && String.valueOf(TbadkCoreApplication.getCurrentAccountId()).equals(this.kBG.author_info.user_id)) {
            this.eGA = true;
        }
        this.egK = new n(getActivity());
        this.egK.a(this.kBG);
        this.egK.a(new j.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.23
            @Override // com.baidu.tieba.play.j.b
            public void by(int i, int i2) {
                if (VideoPlayFragment.this.jpV != null) {
                    VideoPlayFragment.this.jpV.by(i, i2);
                }
            }
        });
        this.mRootView = layoutInflater.inflate(R.layout.video_play_view, (ViewGroup) null);
        this.isNewPlayer = b.rp("cyber_player_test");
        this.jpa = com.baidu.tieba.play.a.b.E(getContext(), this.isNewPlayer ? 1 : 0);
        cQz();
        this.kBo = (TbImageView) this.mRootView.findViewById(R.id.video_cover);
        this.kBo.setPlaceHolder(3);
        this.kBo.setDefaultErrorResource(R.drawable.icon_play_bg);
        if (com.baidu.tbadk.core.util.g.aDi()) {
            this.fOa = this.mRootView.findViewById(R.id.top_container);
            int statusBarHeight = UtilHelper.getStatusBarHeight();
            if (this.fOa.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.fOa.getLayoutParams()).topMargin = statusBarHeight;
            }
        }
        this.Ug = (ImageView) this.mRootView.findViewById(R.id.back_btn);
        this.kBp = (ImageView) this.mRootView.findViewById(R.id.more_btn);
        this.kBq = (HeadImageView) this.mRootView.findViewById(R.id.author_portrait);
        this.kBq.setDefaultResource(17170445);
        this.kBq.setPlaceHolder(2);
        this.kBq.setIsRound(true);
        this.kBu = (ImageView) this.mRootView.findViewById(R.id.love_btn);
        this.kBI = (ImageView) this.mRootView.findViewById(R.id.agree_img);
        this.kBx = (ExpandableTextView) this.mRootView.findViewById(R.id.video_title);
        this.kBy = (TextView) this.mRootView.findViewById(R.id.video_activity);
        this.kBs = (LinearLayout) this.mRootView.findViewById(R.id.comment_container);
        this.kBz = (TextView) this.mRootView.findViewById(R.id.comment_num);
        this.kBr = (LinearLayout) this.mRootView.findViewById(R.id.agree_container);
        this.kBA = (TextView) this.mRootView.findViewById(R.id.agree_num);
        this.kBB = (TextView) this.mRootView.findViewById(R.id.share_num);
        this.kBv = (ImageView) this.mRootView.findViewById(R.id.share_img);
        this.kBw = (ImageView) this.mRootView.findViewById(R.id.share_img_changed);
        cQp();
        this.kBC = (ImageView) this.mRootView.findViewById(R.id.play_btn);
        this.kBD = (LinearLayout) this.mRootView.findViewById(R.id.video_act_private_container);
        this.kBE = (LinearLayout) this.mRootView.findViewById(R.id.video_activity_container);
        this.kBF = (LinearLayout) this.mRootView.findViewById(R.id.video_private);
        this.kBt = (LinearLayout) this.mRootView.findViewById(R.id.share_container);
        this.kBt.setVisibility(8);
        this.kBJ = (TextView) this.mRootView.findViewById(R.id.video_author_name);
        this.kBK = this.mRootView.findViewById(R.id.quick_reply_comment_layout);
        this.kBK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.27
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.kBG.isBjhVideo) {
                    VideoPlayFragment.this.cQr();
                } else if (VideoPlayFragment.this.a(VideoPlayFragment.this.getPageContext(), 11001)) {
                    VideoPlayFragment.this.kBK.setVisibility(4);
                    if (VideoPlayFragment.this.kBT != null && VideoPlayFragment.this.kBT.aLC() != null) {
                        VideoPlayFragment.this.kBT.aLC().lw();
                    }
                    if (VideoPlayFragment.this.kBG != null) {
                        an anVar = new an("c13025");
                        anVar.cp("tid", VideoPlayFragment.this.kBG.thread_id);
                        anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                        anVar.cp("fid", VideoPlayFragment.this.kBG.forum_id);
                        TiebaStatic.log(anVar);
                    }
                }
            }
        });
        this.kBL = (TextView) this.mRootView.findViewById(R.id.quick_reply_comment_text);
        this.kBH = (TextView) this.mRootView.findViewById(R.id.download_nani_guide_txt);
        this.kBH.setVisibility(8);
        String string = com.baidu.tbadk.core.sharedPref.b.aCY().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.kBH.setText(string);
        }
        final String string2 = com.baidu.tbadk.core.sharedPref.b.aCY().getString("nani_key_download_link_url", null);
        this.kBH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.28
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(string2)) {
                    ba.aEa().a((TbPageContext) i.ab(VideoPlayFragment.this.getPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        cQt();
        this.kBq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.29
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.kBG != null && VideoPlayFragment.this.kBG.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.kBG.author_info.user_id) && VideoPlayFragment.this.kBG != null && VideoPlayFragment.this.kBG.author_info != null) {
                    long j = com.baidu.adp.lib.f.b.toLong(VideoPlayFragment.this.kBG.author_info.user_id, 0L);
                    long j2 = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                    boolean z = j == j2;
                    if (j == 0 && j2 == 0) {
                        z = false;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(VideoPlayFragment.this.getActivity()).createNormalConfig(j, z, false)));
                    an anVar = new an("c12798");
                    anVar.cp("tid", VideoPlayFragment.this.kBG.thread_id);
                    anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(anVar);
                }
            }
        });
        this.kBE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.30
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.kBG != null && VideoPlayFragment.this.kBG.act_info != null) {
                    com.baidu.tbadk.browser.a.startInternalWebActivity(VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.kBG.act_info.link_url);
                    an anVar = new an("c12799");
                    anVar.cp("tid", VideoPlayFragment.this.kBG.thread_id);
                    anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(anVar);
                }
            }
        });
        this.kBx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.31
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.cQr();
            }
        });
        this.Ug.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.32
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.kBG != null && !StringUtils.isNull(VideoPlayFragment.this.kBG.thread_id)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_INDEX, VideoPlayFragment.this.kBG.thread_id));
                }
                VideoPlayFragment.this.getActivity().finish();
            }
        });
        this.kBp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.cQs();
            }
        });
        this.kBs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.cQr();
                an anVar = new an("c12796");
                anVar.cp("tid", VideoPlayFragment.this.kBG.thread_id);
                anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(anVar);
            }
        });
        this.kBr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.DD(VideoPlayFragment.this.kBm);
            }
        });
        this.kBt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.aFs();
                an anVar = new an("c12797");
                anVar.cp("tid", VideoPlayFragment.this.kBG.thread_id);
                anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(anVar);
            }
        });
        this.kBu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bc.checkUpIsLogin(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.kBG != null && VideoPlayFragment.this.kBG.author_info != null) {
                    VideoPlayFragment.this.cVO.a(true, VideoPlayFragment.this.kBG.author_info.portrait, VideoPlayFragment.this.kBG.author_info.user_id, false, "6", VideoPlayFragment.this.Mh, VideoPlayFragment.this.kBG.forum_id, "0");
                    VideoPlayFragment.this.kBG.author_info.is_follow = "1";
                    VideoPlayFragment.this.cQu();
                }
            }
        });
        this.eiU = new AlphaAnimation(1.0f, 0.0f);
        this.eiU.setDuration(100L);
        this.eiU.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.7
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoPlayFragment.this.kBo != null) {
                    VideoPlayFragment.this.kBo.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        if (this.mRect != null) {
            this.mOriginWidth = this.mRect.right - this.mRect.left;
            this.mOriginHeight = this.mRect.bottom - this.mRect.top;
            this.kBo.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.8
                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    int i2;
                    float f;
                    float f2 = 1.0f;
                    int width = VideoPlayFragment.this.kBo.getWidth();
                    int height = VideoPlayFragment.this.kBo.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.kBG.video_height, 0) > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.kBG.video_width, 0) > 0) {
                        float f3 = width / height;
                        float f4 = com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.kBG.video_width, 0.0f) / com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.kBG.video_height, 0.0f);
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
                            VideoPlayFragment.this.kBo.setLayoutParams(layoutParams);
                            if (VideoPlayFragment.this.mOriginHeight > 0 || VideoPlayFragment.this.mOriginWidth <= 0) {
                                f = 1.0f;
                            } else {
                                f2 = i2 / VideoPlayFragment.this.mOriginWidth;
                                f = i / VideoPlayFragment.this.mOriginHeight;
                            }
                            VideoPlayFragment.this.kBo.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                            VideoPlayFragment.this.kBo.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.8.1
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
                    VideoPlayFragment.this.kBo.setLayoutParams(layoutParams2);
                    if (VideoPlayFragment.this.mOriginHeight > 0) {
                    }
                    f = 1.0f;
                    VideoPlayFragment.this.kBo.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                    VideoPlayFragment.this.kBo.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.8.1
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
            this.kBo.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9
                @Override // java.lang.Runnable
                public void run() {
                    int width = VideoPlayFragment.this.kBo.getWidth();
                    int height = VideoPlayFragment.this.kBo.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.kBG.video_height, 0) > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.kBG.video_width, 0) > 0) {
                        float f = width / height;
                        float f2 = com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.kBG.video_width, 0.0f) / com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.kBG.video_height, 0.0f);
                        if (f2 > 0.0f && Math.abs(f2 - f) > 0.05d) {
                            if (f2 > f) {
                                height = (int) (width / f2);
                            } else {
                                width = (int) (height * f2);
                            }
                        }
                        ViewGroup.LayoutParams layoutParams = VideoPlayFragment.this.kBo.getLayoutParams();
                        layoutParams.height = height;
                        layoutParams.width = width;
                        VideoPlayFragment.this.kBo.setLayoutParams(layoutParams);
                    }
                }
            });
        }
        ccX();
        if (this.mIsVisible) {
            cQq();
        }
        if (this.kBG != null && !StringUtils.isNull(this.kBG.video_url)) {
            Kf(this.kBG.video_url);
        }
        return this.mRootView;
    }

    public boolean cvs() {
        return !this.isNewPlayer && (this.jpa instanceof QuickVideoView);
    }

    public void a(j.b bVar) {
        this.jpV = bVar;
    }

    public void setVideoStatusListener(QuickVideoView.c cVar) {
        this.jqm = cVar;
    }

    private void ccX() {
        this.kBT = (com.baidu.tieba.videoplay.editor.a) new com.baidu.tieba.videoplay.editor.b().dR(getActivity());
        if (this.kBT != null && this.kBG != null) {
            this.kBT.a(getPageContext());
            this.kBT.av(this.kBG.thread_id, this.kBG.forum_id, this.kBG.forum_name);
            this.kBT.a(new a.InterfaceC0615a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.10
                @Override // com.baidu.tieba.videoplay.editor.a.InterfaceC0615a
                public void tj(boolean z) {
                    VideoPlayFragment.this.kBK.setVisibility(0);
                    if (z) {
                        VideoPlayFragment.this.kBL.setText(R.string.reply_something);
                    } else {
                        VideoPlayFragment.this.kBL.setText(StringUtils.isNull(((c) VideoPlayFragment.this.kBT.aLC().lX(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
                    }
                    if (VideoPlayFragment.this.kBG != null && z) {
                        long j = com.baidu.adp.lib.f.b.toLong(VideoPlayFragment.this.kBG.comment_num, 0L) + 1;
                        VideoPlayFragment.this.kBG.comment_num = String.valueOf(j);
                        VideoPlayFragment.this.kBz.setText(aq.numFormatOverWan(j));
                    }
                }
            });
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            ((RelativeLayout) this.mRootView).addView(this.kBT.aLC(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFs() {
        if (this.kBG != null) {
            if (this.kBG.isBjhVideo && !TbadkCoreApplication.isLogin()) {
                bc.skipToLoginActivity(getContext());
                return;
            }
            String str = this.kBG.forum_id;
            String str2 = this.kBG.forum_name;
            String str3 = this.kBG.title;
            String str4 = this.kBG.thread_id;
            String str5 = "http://tieba.baidu.com/p/" + str4 + "?share=9105&fr=share";
            String str6 = this.kBG.thumbnail_url;
            String format = MessageFormat.format(getResources().getString(R.string.share_content_tpl), str3, "");
            Uri parse = str6 == null ? null : Uri.parse(str6);
            ShareItem shareItem = new ShareItem();
            shareItem.title = str3;
            shareItem.content = format;
            shareItem.dlC = "";
            shareItem.linkUrl = str5;
            shareItem.cQo = 2;
            shareItem.extData = str4;
            shareItem.dlF = 3;
            shareItem.fid = str;
            shareItem.fName = str2;
            shareItem.tid = str4;
            shareItem.dlt = true;
            shareItem.dlE = 0;
            shareItem.dlJ = 2;
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            if (this.kBG.isBjhVideo) {
                shareItem.dlP = false;
                shareItem.canShareBySmartApp = false;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = this.kBG.thumbnail_url;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = this.kBG.title;
            originalThreadInfo.threadId = this.kBG.thread_id;
            originalThreadInfo.oriUgcInfo = this.kBG.baijiahaoData;
            shareItem.dlM = OriginalThreadInfo.ShareInfo.generateShareInfo(originalThreadInfo);
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.dlF);
            bundle.putInt("obj_type", shareItem.dlJ);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.cQo);
            shareItem.Y(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getActivity(), shareItem, true, true);
            shareDialogConfig.setIsAlaLive(false);
            com.baidu.tieba.c.e.btE().a(shareDialogConfig);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.eGA) {
            this.fEP = new ForumManageModel(getPageContext());
            this.fEP.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.11
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (obj != null) {
                        switch (VideoPlayFragment.this.fEP.getLoadDataMode()) {
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
        this.iCr = com.baidu.tbadk.baseEditMark.a.a(getBaseFragmentActivity());
        if (this.iCr != null) {
            this.iCr.a(new a.InterfaceC0362a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.13
                @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0362a
                public void c(boolean z, boolean z2, String str) {
                    if (z) {
                        if (VideoPlayFragment.this.iCr != null) {
                            VideoPlayFragment.this.iCr.fa(z2);
                        }
                        if (VideoPlayFragment.this.kBG != null) {
                            if (z2) {
                                VideoPlayFragment.this.kBG.mark_id = VideoPlayFragment.this.kBG.post_id;
                            } else {
                                VideoPlayFragment.this.kBG.mark_id = null;
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
        this.cVO = new com.baidu.tbadk.coreExtra.model.a(null);
        registerListener(this.cVS);
        registerListener(this.cHi);
        if (Build.VERSION.SDK_INT >= 24 && getBaseFragmentActivity().isInMultiWindowMode()) {
            this.kBS = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        cQt();
        cQA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQo() {
        if (this.kBw != null && this.kBv != null) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(300L);
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation2.setDuration(300L);
            this.kBv.clearAnimation();
            this.kBw.clearAnimation();
            this.kBv.setVisibility(8);
            this.kBw.setVisibility(0);
            this.kBw.startAnimation(scaleAnimation2);
            this.kBv.startAnimation(scaleAnimation);
        }
    }

    private void cQp() {
        if (this.kBw != null && this.kBv != null) {
            this.kBv.clearAnimation();
            this.kBw.clearAnimation();
            this.kBv.setVisibility(0);
            this.kBw.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DD(int i) {
        int i2;
        if (bc.checkUpIsLogin(getActivity()) && this.kBG != null) {
            if (i == this.kBm) {
                if ("1".equals(this.kBG.is_agreed)) {
                    i2 = 1;
                    this.kBG.agree_num = String.valueOf(com.baidu.adp.lib.f.b.toInt(this.kBG.agree_num, 0) - 1);
                    this.kBG.is_agreed = "0";
                } else {
                    this.kBG.agree_num = String.valueOf(com.baidu.adp.lib.f.b.toInt(this.kBG.agree_num, 0) + 1);
                    this.kBG.is_agreed = "1";
                    i2 = 0;
                }
            } else {
                this.kBG.agree_num = String.valueOf(com.baidu.adp.lib.f.b.toInt(this.kBG.agree_num, 0) + 1);
                this.kBG.is_agreed = "1";
                i2 = 0;
            }
            an anVar = new an("c12795");
            anVar.cp("tid", this.kBG.thread_id);
            anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
            if (i == this.kBm) {
                anVar.Z("obj_type", i2);
            } else {
                anVar.Z("obj_type", 2);
            }
            TiebaStatic.log(anVar);
            cQt();
            if (this.kBI != null && i2 == 0) {
                this.kBI.startAnimation(getScaleAnimation());
            }
            HttpMessage httpMessage = new HttpMessage(1001601);
            httpMessage.addParam("thread_id", this.kBG.thread_id);
            httpMessage.addParam("op_type", i2);
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            httpMessage.addHeader("needSig", "1");
            sendMessage(httpMessage);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_AGREE_LOVE, this.kBG));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (!TbSingleton.getInstance().isNotchScreen(getActivity()) && !TbSingleton.getInstance().isCutoutScreen(getActivity())) {
            this.mRootView.setSystemUiVisibility(4);
        }
        if (this.kBG != null && !StringUtils.isNull(this.kBG.video_url)) {
            this.mHasInit = true;
            if (this.mIsVisible) {
                bsg();
                ahr();
                if (this.kBG != null && this.mRect != null) {
                    an anVar = new an("c12794");
                    anVar.cp("tid", this.kBG.thread_id);
                    anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                    anVar.Z("obj_type", 0);
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
        if (this.kBT != null && this.kBT.aLC() != null) {
            this.kBT.aLC().hide();
            this.kBK.setVisibility(0);
            this.kBL.setText(StringUtils.isNull(((c) this.kBT.aLC().lX(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
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
        if (this.kBT != null) {
            this.kBT.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.mIsVisible = z;
        if (this.mHasInit) {
            if (this.mIsVisible && (!this.kBS || Build.VERSION.SDK_INT < 24 || !getBaseFragmentActivity().isInMultiWindowMode())) {
                if (this.kBG != null && this.mRect == null) {
                    an anVar = new an("c12794");
                    anVar.cp("tid", this.kBG.thread_id);
                    anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                    anVar.Z("obj_type", 1);
                    TiebaStatic.log(anVar);
                }
                startPlay();
                cQq();
                this.kBS = false;
                return;
            }
            cQp();
            this.playTime = 1;
            pausePlay();
        }
    }

    private void cQq() {
        if (this.kBG != null) {
            an anVar = new an("c12590");
            anVar.cp("tid", this.kBG.thread_id);
            anVar.cp("fid", this.kBG.forum_id);
            anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
            anVar.Z("obj_locate", this.kBM);
            anVar.Z(TiebaInitialize.Params.OBJ_PARAM2, 1);
            anVar.cp("obj_param1", aq.isEmpty(this.kBG.mRecomWeight) ? "0" : this.kBG.mRecomWeight);
            anVar.cp("extra", aq.isEmpty(this.kBG.mRecomExtra) ? "0" : this.kBG.mRecomExtra);
            anVar.cp("obj_id", this.cKC);
            anVar.cp(TiebaInitialize.Params.AB_TAG, aq.isEmpty(this.kBG.mRecomAbTag) ? "0" : this.kBG.mRecomAbTag);
            anVar.cp("obj_source", aq.isEmpty(this.kBG.mRecomSource) ? "0" : this.kBG.mRecomSource);
            anVar.cp("obj_type", this.mFromPage);
            anVar.Z("is_vertical", 1);
            if (this.kBG.baijiahaoData != null) {
                anVar.cp("obj_param4", this.kBG.baijiahaoData.oriUgcNid);
                anVar.cp("obj_param6", this.kBG.baijiahaoData.oriUgcVid);
                if (this.kBG.baijiahaoData.oriUgcType == 4) {
                    anVar.Z("obj_param5", 2);
                } else if (this.kBG.baijiahaoData.oriUgcType == 2) {
                    anVar.Z("obj_param5", 3);
                }
            } else {
                anVar.Z("obj_param5", 1);
            }
            TiebaStatic.log(anVar);
        }
    }

    private void Kf(String str) {
        if (this.jpa != null && str != null && !str.equals(this.mVideoUrl)) {
            if (cvs()) {
                ((QuickVideoView) this.jpa).setRecoveryState(0);
            }
            this.jpa.setVideoPath(str, this.kBG.thread_id);
            this.mVideoUrl = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay() {
        if (TbadkCoreApplication.mSquareVideoCanPlayNotWifi || com.baidu.tieba.video.g.cMD().cME() || cQv()) {
            cvE();
            if (this.kBC != null) {
                this.kBC.setVisibility(8);
            }
            if (Build.VERSION.SDK_INT < 17 && this.kBo.getVisibility() == 0) {
                this.kBo.clearAnimation();
                this.kBo.startAnimation(this.eiU);
            }
            if (this.jpa != null) {
                this.jpa.start();
                bsg();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsg() {
        if (this.kBG != null) {
            y yVar = new y();
            yVar.mLocate = "nani_midpage";
            yVar.OC = this.kBG.thread_id;
            yVar.fGQ = this.kBG.forum_id + "";
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.mSource = this.kBG.mRecomSource;
            yVar.jsi = this.kBG.mRecomAbTag;
            yVar.jsj = this.kBG.mRecomWeight;
            yVar.jsk = "";
            yVar.cKC = "";
            yVar.jsl = this.kBG.mMd5;
            if (this.mRect != null) {
                yVar.jsm = "1";
            } else {
                yVar.jsm = "2";
            }
            if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                yVar.jsn = "1";
                yVar.mLocate = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                yVar.jsk = "index";
            }
            com.baidu.tieba.play.l.a(this.kBG.mMd5, "", "1", yVar);
        }
    }

    private void cvE() {
        if (com.baidu.adp.lib.util.j.isMobileNet()) {
            com.baidu.tieba.video.g.cMD().fx(getContext());
        }
    }

    private void pausePlay() {
        if (this.jpa != null) {
            this.jpa.pause();
        }
    }

    private void stopPlay() {
        if (this.jpa != null) {
            if (cvs()) {
                ((QuickVideoView) this.jpa).setRecoveryState(5);
            }
            this.jpa.stopPlayback();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQr() {
        PbActivityConfig createNormalCfg = new PbActivityConfig(getActivity()).createNormalCfg(this.kBG.thread_id, this.kBG.post_id, "");
        createNormalCfg.setForumId(String.valueOf(this.kBG.forum_id));
        createNormalCfg.setForumName(this.kBG.forum_name);
        createNormalCfg.setVideo_source("nani_midpage");
        createNormalCfg.setJumpToCommentArea(true);
        createNormalCfg.setBjhData(this.kBG.baijiahaoData);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQs() {
        if (this.cGR == null) {
            this.kBN = new com.baidu.tieba.view.a(getActivity());
            this.cGR = new e(getActivity(), this.kBN.aCm());
            this.cGR.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.14
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (!TbSingleton.getInstance().isNotchScreen(VideoPlayFragment.this.getActivity()) && !TbSingleton.getInstance().isCutoutScreen(VideoPlayFragment.this.getActivity())) {
                        VideoPlayFragment.this.jpa.getView().setSystemUiVisibility(4);
                    }
                }
            });
        }
        if (this.kBN != null) {
            ArrayList arrayList = new ArrayList();
            a.C0616a c0616a = new a.C0616a(this.kBN);
            c0616a.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.15
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    if (!bc.checkUpIsLogin(VideoPlayFragment.this.getContext())) {
                        VideoPlayFragment.this.cGR.dismiss();
                        return;
                    }
                    VideoPlayFragment.this.cGR.dismiss();
                    if (VideoPlayFragment.this.kBG != null) {
                        boolean z = VideoPlayFragment.this.kBG.post_id != null && VideoPlayFragment.this.kBG.post_id.equals(VideoPlayFragment.this.kBG.mark_id);
                        MarkData markData = new MarkData();
                        Date date = new Date();
                        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
                        markData.setThreadId(VideoPlayFragment.this.kBG.thread_id);
                        markData.setPostId(VideoPlayFragment.this.kBG.post_id);
                        markData.setTime(date.getTime());
                        markData.setHostMode(false);
                        markData.setId(VideoPlayFragment.this.kBG.thread_id);
                        markData.setForumId(VideoPlayFragment.this.kBG.forum_id);
                        if (VideoPlayFragment.this.iCr != null) {
                            VideoPlayFragment.this.iCr.a(markData);
                            if (!z) {
                                VideoPlayFragment.this.iCr.awf();
                            } else {
                                VideoPlayFragment.this.iCr.awe();
                            }
                        }
                    }
                }
            });
            boolean z = false;
            if (this.kBG != null && this.kBG.post_id != null && this.kBG.post_id.equals(this.kBG.mark_id)) {
                z = true;
            }
            if (z) {
                c0616a.setText(getResources().getString(R.string.remove_mark));
            } else {
                c0616a.setText(getResources().getString(R.string.mark));
            }
            if (this.kBG != null && !this.kBG.isBjhVideo) {
                arrayList.add(c0616a);
            }
            a.C0616a c0616a2 = new a.C0616a(getActivity().getString(R.string.delete), this.kBN);
            c0616a2.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.16
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    VideoPlayFragment.this.cGR.dismiss();
                    if (bc.checkUpIsLogin(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.kBG != null) {
                        String str = VideoPlayFragment.this.kBG.thread_id;
                        String str2 = VideoPlayFragment.this.kBG.forum_id;
                        String string = VideoPlayFragment.this.getResources().getString(R.string.web_view_report_title);
                        String str3 = "http://tieba.baidu.com/mo/q/postreport?fid=" + str2 + "&tid=" + str + "&pid=" + VideoPlayFragment.this.kBG.post_id;
                        if (VideoPlayFragment.this.kBG.isBjhVideo) {
                            str3 = String.format(TbConfig.URL_BJH_REPORT, str, VideoPlayFragment.this.kBG.post_id) + "&channelid=33840";
                            string = "";
                        }
                        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(VideoPlayFragment.this.getPageContext().getPageActivity(), string, str3, true);
                        if (VideoPlayFragment.this.kBG.isBjhVideo) {
                            tbWebViewActivityConfig.setFixTitle(true);
                        }
                        VideoPlayFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
                    }
                }
            });
            c0616a2.setText(getResources().getString(R.string.report_text));
            arrayList.add(c0616a2);
            if (this.eGA) {
                a.C0616a c0616a3 = new a.C0616a(getActivity().getString(R.string.delete), this.kBN);
                c0616a3.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.17
                    @Override // com.baidu.tieba.view.a.c
                    public void onClick() {
                        VideoPlayFragment.this.cGR.dismiss();
                        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(VideoPlayFragment.this.getActivity());
                        aVar.jF(R.string.del_thread_confirm);
                        aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.17.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar.dismiss();
                                if (VideoPlayFragment.this.kBG != null) {
                                    VideoPlayFragment.this.fEP.a(VideoPlayFragment.this.kBG.forum_id, VideoPlayFragment.this.kBG.forum_name, VideoPlayFragment.this.kBG.thread_id, VideoPlayFragment.this.kBG.post_id, 0, 0, VideoPlayFragment.this.eGA, null);
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                                }
                            }
                        });
                        aVar.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.17.2
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar.dismiss();
                            }
                        });
                        aVar.fu(true);
                        aVar.b(VideoPlayFragment.this.getPageContext());
                        aVar.aBW();
                    }
                });
                c0616a3.setText(getResources().getString(R.string.delete));
                arrayList.add(c0616a3);
            }
            this.kBN.aA(arrayList);
        }
        this.cGR.show();
    }

    private void cQt() {
        if (this.kBG != null) {
            this.kBo.startLoad(this.kBG.thumbnail_url, 10, false);
            Matcher matcher = Pattern.compile("^我发表了?一(篇|个)视频贴(，|,).+$").matcher(this.kBG.title);
            if (StringUtils.isNull(this.kBG.title) || matcher.matches()) {
                this.kBx.setVisibility(8);
            } else {
                this.kBx.setVisibility(0);
                this.kBx.setTextSize(l.getDimens(getContext(), R.dimen.tbfontsize40));
                this.kBx.setTextColor(R.color.cp_cont_a);
                this.kBx.setLineSpacingExtra(l.getDimens(getContext(), R.dimen.tbds14));
                this.kBx.setExpandable(true);
                this.kBx.setOnStatusChangedListener(new ExpandableTextView.a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.18
                    @Override // com.baidu.tieba.view.expandable.ExpandableTextView.a
                    public void lZ(boolean z) {
                        VideoPlayFragment.this.kBG.isTitleExpanded = z;
                    }
                });
                this.kBx.setData(this.kBG.title, this.kBG.isTitleExpanded);
            }
            this.kBz.setText(aq.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.kBG.comment_num, 0L)));
            this.kBA.setText(aq.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.kBG.agree_num, 0L)));
            this.kBB.setText(aq.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.kBG.share_num, 0L)));
            if (this.kBG.author_info != null) {
                if (!TextUtils.isEmpty(this.kBG.author_info.bjhAvatar)) {
                    this.kBq.startLoad(this.kBG.author_info.bjhAvatar, 12, false);
                } else if (!StringUtils.isNull(this.kBG.author_info.portrait) && this.kBG.author_info.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.kBq.startLoad(this.kBG.author_info.portrait, 10, false);
                } else {
                    this.kBq.startLoad(this.kBG.author_info.portrait, 12, false);
                }
                if (StringUtils.isNull(this.kBG.author_info.cMz())) {
                    this.kBJ.setVisibility(8);
                } else {
                    this.kBJ.setVisibility(0);
                    this.kBJ.setText("@" + this.kBG.author_info.cMz());
                }
            }
            if ("1".equals(this.kBG.is_private) && this.kBH.getVisibility() != 0) {
                this.kBF.setVisibility(0);
            } else {
                this.kBF.setVisibility(8);
            }
            if ("1".equals(this.kBG.is_agreed)) {
                am.setImageResource(this.kBI, R.drawable.icon_card_like_white_full_s);
            } else {
                am.setImageResource(this.kBI, R.drawable.btn_video_agree);
            }
            if (this.kBG.act_info != null && !StringUtils.isNull(this.kBG.act_info.activity_name) && this.kBH.getVisibility() != 0) {
                this.kBE.setVisibility(0);
                this.kBy.setText(this.kBG.act_info.activity_name);
            } else {
                this.kBE.setVisibility(8);
            }
            cQu();
            if (this.kBG.isBjhVideo) {
                this.kBp.setVisibility(8);
            } else {
                this.kBp.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQu() {
        if (this.eGA || (this.kBG.author_info != null && !"0".equals(this.kBG.author_info.is_follow))) {
            this.kBu.setVisibility(4);
            this.kBu.setClickable(false);
            return;
        }
        this.kBu.setVisibility(0);
        this.kBu.setClickable(true);
    }

    private void bqD() {
        if (getActivity() != null) {
            if (this.kBU == null || !this.kBU.isShowing()) {
                this.kBU = new com.baidu.tbadk.core.dialog.a(getActivity());
                View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.video_no_wifi_dialog, (ViewGroup) null);
                ((TextView) inflate.findViewById(R.id.tv_title)).setText(R.string.confirm_title);
                ((TextView) inflate.findViewById(R.id.tv_msg)).setText(R.string.enter_video_center_page_no_wifi_tip);
                ((TextView) inflate.findViewById(R.id.tv_open_free_data)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.19
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        com.baidu.tbadk.browser.a.startWebActivity(true, (Context) VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.getResources().getString(R.string.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
                    }
                });
                SvgManager.aDW().a((ImageView) inflate.findViewById(R.id.open_free_data_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
                this.kBU.aK(inflate);
                this.kBU.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.20
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        TbadkCoreApplication.mSquareVideoCanPlayNotWifi = true;
                        VideoPlayFragment.this.startPlay();
                    }
                });
                this.kBU.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.21
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                    }
                });
                this.kBU.jI(1);
                this.kBU.jG(R.color.cp_cont_b);
                this.kBU.fu(true);
                this.kBU.b(getPageContext());
                this.kBU.aBW();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cQv() {
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable() || com.baidu.adp.lib.util.j.isWifiNet()) {
            return true;
        }
        if (!this.mIsVisible || com.baidu.tieba.video.g.cMD().cME()) {
            return false;
        }
        if (this.kBC != null) {
            this.kBC.setVisibility(0);
        }
        pausePlay();
        bqD();
        return false;
    }

    private void ahr() {
        if ((TbadkCoreApplication.mSquareVideoCanPlayNotWifi || cQv() || com.baidu.tieba.video.g.cMD().cME()) && this.jpa != null && this.kBC != null) {
            if (this.jpa.getParent() == null) {
                cQz();
                cQA();
            }
            this.jpa.b(null);
            this.kBC.setVisibility(8);
            cvE();
            if (this.jqm != null) {
                this.jqm.onStart();
            }
        }
    }

    protected Animation getScaleAnimation() {
        if (this.kBO == null) {
            this.kBO = AnimationUtils.loadAnimation(getContext(), R.anim.scale_zoom_in_and_out_anim);
        }
        return this.kBO;
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0387a
    public void aSy() {
        if (this.jpa.isPlaying()) {
            this.jpa.pause();
            this.kBC.setVisibility(0);
        } else if (TbadkCoreApplication.mSquareVideoCanPlayNotWifi || cQv() || com.baidu.tieba.video.g.cMD().cME()) {
            this.jpa.start();
            this.kBC.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0387a
    public void u(float f, float f2) {
        if (bc.checkUpIsLogin(getActivity()) && !this.kBP) {
            cQw();
            if (this.kBG != null && "0".equals(this.kBG.is_agreed)) {
                DD(this.kBn);
            }
        }
    }

    private void cQw() {
        if (this.mRootView != null) {
            this.kBP = true;
            final ImageView imageView = new ImageView(this.mRootView.getContext());
            imageView.setImageResource(R.drawable.icon_video_like);
            if (this.kBR == null) {
                this.kBR = new RelativeLayout.LayoutParams(-2, -2);
                this.kBR.addRule(13);
            }
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(imageView, this.kBR);
            }
            if (this.kBQ == null) {
                this.kBQ = new AnimatorSet();
                this.kBQ.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.22
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        VideoPlayFragment.this.kBP = false;
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
            this.kBQ.setTarget(imageView);
            this.kBQ.playSequentially(ofPropertyValuesHolder, ofPropertyValuesHolder2);
            this.kBQ.start();
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0387a
    public void aSz() {
        if (this.kBG != null && this.kBG.author_info != null) {
            long j = com.baidu.adp.lib.f.b.toLong(this.kBG.author_info.user_id, 0L);
            long j2 = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
            boolean z = j == j2;
            if (j == 0 && j2 == 0) {
                z = false;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(getActivity()).createNormalConfig(j, z, false)));
        }
    }

    public List<String> getMediaIDs() {
        if (cvs()) {
            return ((QuickVideoView) this.jpa).getMediaIDs();
        }
        return null;
    }

    public String cQx() {
        if (cvs()) {
            return ((QuickVideoView) this.jpa).getMediaId();
        }
        return null;
    }

    public boolean cQy() {
        if (this.kBT == null || this.kBT.aLC() == null || !this.kBT.aLC().isVisible()) {
            return false;
        }
        this.kBT.aLC().hide();
        this.kBK.setVisibility(0);
        if ((this.kBT.aLC().lX(28) instanceof c) && ((c) this.kBT.aLC().lX(28)).getInputView() != null && ((c) this.kBT.aLC().lX(28)).getInputView().getText() != null) {
            this.kBL.setText(StringUtils.isNull(((c) this.kBT.aLC().lX(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
        }
        return true;
    }

    public void c(int i, int i2, Intent intent) {
        if (this.kBT != null) {
            this.kBT.onActivityResult(i, i2, intent);
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
        if (this.kBT != null && this.kBT.aLC() != null) {
            this.kBT.aLC().onChangeSkinType(i);
        }
        SvgManager.aDW().a(this.Ug, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
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

    public void cQz() {
        if (this.jpa != null && this.jpa.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            ((ViewGroup) this.mRootView).addView(this.jpa.getView(), 0);
            this.jpa.getView().setLayoutParams(layoutParams);
            this.jpa.setPageTypeForPerfStat("v_mid_page");
            if (cvs()) {
                ((QuickVideoView) this.jpa).setPlayerReuseEnable(true);
                ((QuickVideoView) this.jpa).setNeedRecovery(true);
            }
            if (this.kBG != null) {
                y yVar = new y();
                yVar.mUid = TbadkCoreApplication.getCurrentAccount();
                yVar.OC = this.kBG.thread_id;
                yVar.fGQ = this.kBG.forum_id;
                yVar.jsl = this.kBG.mMd5;
                yVar.cKC = "";
                yVar.mSource = this.kBG.mRecomSource;
                yVar.mAbTag = this.kBG.mRecomAbTag;
                yVar.jsj = this.kBG.mRecomWeight;
                if (this.mRect != null) {
                    yVar.jsm = "1";
                } else {
                    yVar.jsm = "2";
                }
                if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                    yVar.jsn = "1";
                    yVar.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                    yVar.jsk = this.mFromPage;
                    yVar.cKC = this.cKC;
                    yVar.jsi = this.kBG.mRecomWeight;
                } else {
                    yVar.mLocate = "14";
                }
                this.egK.setVideoStatsData(yVar);
            }
            this.jpa.setContinuePlayEnable(true);
            this.jpa.setBusiness(this.egK);
        }
    }

    private void cQA() {
        if (Build.VERSION.SDK_INT >= 17) {
            this.jpa.setOnPreparedListener(this.kBX);
        }
        this.jpa.setOnCompletionListener(this.kBW);
        this.jpa.setOnOutInfoListener(this.kBV);
    }
}
