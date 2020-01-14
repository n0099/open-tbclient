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
/* loaded from: classes9.dex */
public class VideoPlayFragment extends BaseFragment implements a.InterfaceC0389a {
    public ImageView Uw;
    private e cHd;
    private String cKN;
    private boolean eHK;
    private n egU;
    private AlphaAnimation ejI;
    private View fRj;
    private boolean isNewPlayer;
    public com.baidu.tieba.play.a.a jsG;
    private j.b jtB;
    private QuickVideoView.c jtS;
    private TbImageView kEV;
    public ImageView kEW;
    public HeadImageView kEX;
    public LinearLayout kEY;
    public LinearLayout kEZ;
    private com.baidu.tieba.videoplay.editor.a kFA;
    com.baidu.tbadk.core.dialog.a kFB;
    public LinearLayout kFa;
    public ImageView kFb;
    public ImageView kFc;
    public ImageView kFd;
    public ExpandableTextView kFe;
    public TextView kFf;
    public TextView kFg;
    public TextView kFh;
    public TextView kFi;
    public ImageView kFj;
    private LinearLayout kFk;
    public LinearLayout kFl;
    public LinearLayout kFm;
    public VideoItemData kFn;
    private TextView kFo;
    public ImageView kFp;
    public TextView kFq;
    private View kFr;
    private TextView kFs;
    private int kFt;
    private com.baidu.tieba.view.a kFu;
    protected Animation kFv;
    private boolean kFw;
    private AnimatorSet kFx;
    private RelativeLayout.LayoutParams kFy;
    private String mFrom;
    private String mFromPage;
    private boolean mHasInit;
    private boolean mIsVisible;
    private int mOriginHeight;
    private int mOriginWidth;
    private Rect mRect;
    public View mRootView;
    private String mVideoUrl;
    private int kET = 0;
    private int kEU = 1;
    private ForumManageModel fHZ = null;
    private com.baidu.tbadk.baseEditMark.a iFV = null;
    private com.baidu.tbadk.coreExtra.model.a cVY = null;
    private BdUniqueId Mm = BdUniqueId.gen();
    private boolean kFz = false;
    private int playTime = 1;
    private CustomMessageListener cWc = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (VideoPlayFragment.this.kFn != null && VideoPlayFragment.this.kFn.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.kFn.author_info.user_id) && data != null && VideoPlayFragment.this.kFn.author_info.user_id.equals(data.toUid)) {
                    boolean z = true;
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    z = (message == null || message.getTag() == null || !message.getTag().equals(VideoPlayFragment.this.Mm)) ? false : false;
                    if (data.djO == null) {
                        if (!data.isSucc) {
                            if (z && !"0".equals(VideoPlayFragment.this.kFn.author_info.is_follow)) {
                                l.showToast(VideoPlayFragment.this.getActivity(), (int) R.string.attention_fail);
                                VideoPlayFragment.this.kFn.author_info.is_follow = "0";
                                VideoPlayFragment.this.cRz();
                            }
                        } else if (updateAttentionMessage.isAttention()) {
                            if (VideoPlayFragment.this.mIsVisible) {
                                if (z) {
                                    l.showToast(VideoPlayFragment.this.getActivity(), (int) R.string.attention_success);
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_AGREE_LOVE, VideoPlayFragment.this.kFn));
                                    return;
                                }
                                VideoPlayFragment.this.kFn.author_info.is_follow = "1";
                                VideoPlayFragment.this.cRz();
                            }
                        } else {
                            VideoPlayFragment.this.kFn.author_info.is_follow = "0";
                            VideoPlayFragment.this.cRz();
                        }
                    }
                }
            }
        }
    };
    private final CustomMessageListener cHu = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof NetWorkChangedMessage) && customResponsedMessage.getCmd() == 2000994 && !customResponsedMessage.hasError()) {
                VideoPlayFragment.this.cRA();
            }
        }
    };
    private g.e kFC = new g.e() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.24
        @Override // com.baidu.tieba.play.g.e
        public boolean onInfo(g gVar, int i, int i2) {
            if (VideoPlayFragment.this.mIsVisible) {
                if ((i == 3 || i == 904) && VideoPlayFragment.this.kEV.getVisibility() == 0) {
                    VideoPlayFragment.this.kEV.clearAnimation();
                    VideoPlayFragment.this.kEV.startAnimation(VideoPlayFragment.this.ejI);
                    return true;
                }
                return true;
            }
            return true;
        }
    };
    private g.a kFD = new g.a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.25
        @Override // com.baidu.tieba.play.g.a
        public void onCompletion(g gVar) {
            if (VideoPlayFragment.this.jsG != null) {
                VideoPlayFragment.this.jsG.seekTo(0);
                VideoPlayFragment.this.jsG.start();
                VideoPlayFragment.this.bti();
                VideoPlayFragment.y(VideoPlayFragment.this);
                if (VideoPlayFragment.this.playTime == 3 && !VideoPlayFragment.this.kFn.isBjhVideo) {
                    VideoPlayFragment.this.cRt();
                }
            }
        }
    };
    private g.f kFE = new g.f() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.26
        @Override // com.baidu.tieba.play.g.f
        public void onPrepared(g gVar) {
            if (VideoPlayFragment.this.jsG != null) {
                VideoPlayFragment.this.jsG.setVolume(1.0f, 1.0f);
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
        this.kFn = (VideoItemData) arguments.get(VideoPlayActivityConfig.VIDEO_DATA);
        this.mRect = (Rect) arguments.getParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT);
        this.kFt = arguments.getInt(VideoPlayActivityConfig.VIDEO_INDEX);
        this.mFrom = arguments.getString(VideoPlayActivityConfig.PAGE_FROM);
        this.mFromPage = arguments.getString("from");
        this.cKN = arguments.getString("obj_id");
        if (this.kFn != null && this.kFn.author_info != null && String.valueOf(TbadkCoreApplication.getCurrentAccountId()).equals(this.kFn.author_info.user_id)) {
            this.eHK = true;
        }
        this.egU = new n(getActivity());
        this.egU.a(this.kFn);
        this.egU.a(new j.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.23
            @Override // com.baidu.tieba.play.j.b
            public void bx(int i, int i2) {
                if (VideoPlayFragment.this.jtB != null) {
                    VideoPlayFragment.this.jtB.bx(i, i2);
                }
            }
        });
        this.mRootView = layoutInflater.inflate(R.layout.video_play_view, (ViewGroup) null);
        this.isNewPlayer = b.rs("cyber_player_test");
        this.jsG = com.baidu.tieba.play.a.b.F(getContext(), this.isNewPlayer ? 1 : 0);
        cRE();
        this.kEV = (TbImageView) this.mRootView.findViewById(R.id.video_cover);
        this.kEV.setPlaceHolder(3);
        this.kEV.setDefaultErrorResource(R.drawable.icon_play_bg);
        if (com.baidu.tbadk.core.util.g.aDB()) {
            this.fRj = this.mRootView.findViewById(R.id.top_container);
            int statusBarHeight = UtilHelper.getStatusBarHeight();
            if (this.fRj.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.fRj.getLayoutParams()).topMargin = statusBarHeight;
            }
        }
        this.Uw = (ImageView) this.mRootView.findViewById(R.id.back_btn);
        this.kEW = (ImageView) this.mRootView.findViewById(R.id.more_btn);
        this.kEX = (HeadImageView) this.mRootView.findViewById(R.id.author_portrait);
        this.kEX.setDefaultResource(17170445);
        this.kEX.setPlaceHolder(2);
        this.kEX.setIsRound(true);
        this.kFb = (ImageView) this.mRootView.findViewById(R.id.love_btn);
        this.kFp = (ImageView) this.mRootView.findViewById(R.id.agree_img);
        this.kFe = (ExpandableTextView) this.mRootView.findViewById(R.id.video_title);
        this.kFf = (TextView) this.mRootView.findViewById(R.id.video_activity);
        this.kEZ = (LinearLayout) this.mRootView.findViewById(R.id.comment_container);
        this.kFg = (TextView) this.mRootView.findViewById(R.id.comment_num);
        this.kEY = (LinearLayout) this.mRootView.findViewById(R.id.agree_container);
        this.kFh = (TextView) this.mRootView.findViewById(R.id.agree_num);
        this.kFi = (TextView) this.mRootView.findViewById(R.id.share_num);
        this.kFc = (ImageView) this.mRootView.findViewById(R.id.share_img);
        this.kFd = (ImageView) this.mRootView.findViewById(R.id.share_img_changed);
        cRu();
        this.kFj = (ImageView) this.mRootView.findViewById(R.id.play_btn);
        this.kFk = (LinearLayout) this.mRootView.findViewById(R.id.video_act_private_container);
        this.kFl = (LinearLayout) this.mRootView.findViewById(R.id.video_activity_container);
        this.kFm = (LinearLayout) this.mRootView.findViewById(R.id.video_private);
        this.kFa = (LinearLayout) this.mRootView.findViewById(R.id.share_container);
        this.kFa.setVisibility(8);
        this.kFq = (TextView) this.mRootView.findViewById(R.id.video_author_name);
        this.kFr = this.mRootView.findViewById(R.id.quick_reply_comment_layout);
        this.kFr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.27
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.kFn.isBjhVideo) {
                    VideoPlayFragment.this.cRw();
                } else if (VideoPlayFragment.this.a(VideoPlayFragment.this.getPageContext(), 11001)) {
                    VideoPlayFragment.this.kFr.setVisibility(4);
                    if (VideoPlayFragment.this.kFA != null && VideoPlayFragment.this.kFA.aLV() != null) {
                        VideoPlayFragment.this.kFA.aLV().display();
                    }
                    if (VideoPlayFragment.this.kFn != null) {
                        an anVar = new an("c13025");
                        anVar.cp("tid", VideoPlayFragment.this.kFn.thread_id);
                        anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                        anVar.cp("fid", VideoPlayFragment.this.kFn.forum_id);
                        TiebaStatic.log(anVar);
                    }
                }
            }
        });
        this.kFs = (TextView) this.mRootView.findViewById(R.id.quick_reply_comment_text);
        this.kFo = (TextView) this.mRootView.findViewById(R.id.download_nani_guide_txt);
        this.kFo.setVisibility(8);
        String string = com.baidu.tbadk.core.sharedPref.b.aDr().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.kFo.setText(string);
        }
        final String string2 = com.baidu.tbadk.core.sharedPref.b.aDr().getString("nani_key_download_link_url", null);
        this.kFo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.28
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(string2)) {
                    ba.aEt().a((TbPageContext) i.ab(VideoPlayFragment.this.getPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        cRy();
        this.kEX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.29
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.kFn != null && VideoPlayFragment.this.kFn.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.kFn.author_info.user_id) && VideoPlayFragment.this.kFn != null && VideoPlayFragment.this.kFn.author_info != null) {
                    long j = com.baidu.adp.lib.f.b.toLong(VideoPlayFragment.this.kFn.author_info.user_id, 0L);
                    long j2 = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                    boolean z = j == j2;
                    if (j == 0 && j2 == 0) {
                        z = false;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(VideoPlayFragment.this.getActivity()).createNormalConfig(j, z, false)));
                    an anVar = new an("c12798");
                    anVar.cp("tid", VideoPlayFragment.this.kFn.thread_id);
                    anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(anVar);
                }
            }
        });
        this.kFl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.30
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.kFn != null && VideoPlayFragment.this.kFn.act_info != null) {
                    com.baidu.tbadk.browser.a.startInternalWebActivity(VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.kFn.act_info.link_url);
                    an anVar = new an("c12799");
                    anVar.cp("tid", VideoPlayFragment.this.kFn.thread_id);
                    anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(anVar);
                }
            }
        });
        this.kFe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.31
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.cRw();
            }
        });
        this.Uw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.32
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.kFn != null && !StringUtils.isNull(VideoPlayFragment.this.kFn.thread_id)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_INDEX, VideoPlayFragment.this.kFn.thread_id));
                }
                VideoPlayFragment.this.getActivity().finish();
            }
        });
        this.kEW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.cRx();
            }
        });
        this.kEZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.cRw();
                an anVar = new an("c12796");
                anVar.cp("tid", VideoPlayFragment.this.kFn.thread_id);
                anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(anVar);
            }
        });
        this.kEY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.DJ(VideoPlayFragment.this.kET);
            }
        });
        this.kFa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.aFL();
                an anVar = new an("c12797");
                anVar.cp("tid", VideoPlayFragment.this.kFn.thread_id);
                anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(anVar);
            }
        });
        this.kFb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bc.checkUpIsLogin(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.kFn != null && VideoPlayFragment.this.kFn.author_info != null) {
                    VideoPlayFragment.this.cVY.a(true, VideoPlayFragment.this.kFn.author_info.portrait, VideoPlayFragment.this.kFn.author_info.user_id, false, "6", VideoPlayFragment.this.Mm, VideoPlayFragment.this.kFn.forum_id, "0");
                    VideoPlayFragment.this.kFn.author_info.is_follow = "1";
                    VideoPlayFragment.this.cRz();
                }
            }
        });
        this.ejI = new AlphaAnimation(1.0f, 0.0f);
        this.ejI.setDuration(100L);
        this.ejI.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.7
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (VideoPlayFragment.this.kEV != null) {
                    VideoPlayFragment.this.kEV.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        if (this.mRect != null) {
            this.mOriginWidth = this.mRect.right - this.mRect.left;
            this.mOriginHeight = this.mRect.bottom - this.mRect.top;
            this.kEV.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.8
                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    int i2;
                    float f;
                    float f2 = 1.0f;
                    int width = VideoPlayFragment.this.kEV.getWidth();
                    int height = VideoPlayFragment.this.kEV.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.kFn.video_height, 0) > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.kFn.video_width, 0) > 0) {
                        float f3 = width / height;
                        float f4 = com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.kFn.video_width, 0.0f) / com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.kFn.video_height, 0.0f);
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
                            VideoPlayFragment.this.kEV.setLayoutParams(layoutParams);
                            if (VideoPlayFragment.this.mOriginHeight > 0 || VideoPlayFragment.this.mOriginWidth <= 0) {
                                f = 1.0f;
                            } else {
                                f2 = i2 / VideoPlayFragment.this.mOriginWidth;
                                f = i / VideoPlayFragment.this.mOriginHeight;
                            }
                            VideoPlayFragment.this.kEV.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                            VideoPlayFragment.this.kEV.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.8.1
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
                    VideoPlayFragment.this.kEV.setLayoutParams(layoutParams2);
                    if (VideoPlayFragment.this.mOriginHeight > 0) {
                    }
                    f = 1.0f;
                    VideoPlayFragment.this.kEV.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                    VideoPlayFragment.this.kEV.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.8.1
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
            this.kEV.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9
                @Override // java.lang.Runnable
                public void run() {
                    int width = VideoPlayFragment.this.kEV.getWidth();
                    int height = VideoPlayFragment.this.kEV.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.kFn.video_height, 0) > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.kFn.video_width, 0) > 0) {
                        float f = width / height;
                        float f2 = com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.kFn.video_width, 0.0f) / com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.kFn.video_height, 0.0f);
                        if (f2 > 0.0f && Math.abs(f2 - f) > 0.05d) {
                            if (f2 > f) {
                                height = (int) (width / f2);
                            } else {
                                width = (int) (height * f2);
                            }
                        }
                        ViewGroup.LayoutParams layoutParams = VideoPlayFragment.this.kEV.getLayoutParams();
                        layoutParams.height = height;
                        layoutParams.width = width;
                        VideoPlayFragment.this.kEV.setLayoutParams(layoutParams);
                    }
                }
            });
        }
        ceg();
        if (this.mIsVisible) {
            cRv();
        }
        if (this.kFn != null && !StringUtils.isNull(this.kFn.video_url)) {
            Kp(this.kFn.video_url);
        }
        return this.mRootView;
    }

    public boolean cwB() {
        return !this.isNewPlayer && (this.jsG instanceof QuickVideoView);
    }

    public void a(j.b bVar) {
        this.jtB = bVar;
    }

    public void setVideoStatusListener(QuickVideoView.c cVar) {
        this.jtS = cVar;
    }

    private void ceg() {
        this.kFA = (com.baidu.tieba.videoplay.editor.a) new com.baidu.tieba.videoplay.editor.b().dR(getActivity());
        if (this.kFA != null && this.kFn != null) {
            this.kFA.a(getPageContext());
            this.kFA.aw(this.kFn.thread_id, this.kFn.forum_id, this.kFn.forum_name);
            this.kFA.a(new a.InterfaceC0620a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.10
                @Override // com.baidu.tieba.videoplay.editor.a.InterfaceC0620a
                public void tv(boolean z) {
                    VideoPlayFragment.this.kFr.setVisibility(0);
                    if (z) {
                        VideoPlayFragment.this.kFs.setText(R.string.reply_something);
                    } else {
                        VideoPlayFragment.this.kFs.setText(StringUtils.isNull(((c) VideoPlayFragment.this.kFA.aLV().lX(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
                    }
                    if (VideoPlayFragment.this.kFn != null && z) {
                        long j = com.baidu.adp.lib.f.b.toLong(VideoPlayFragment.this.kFn.comment_num, 0L) + 1;
                        VideoPlayFragment.this.kFn.comment_num = String.valueOf(j);
                        VideoPlayFragment.this.kFg.setText(aq.numFormatOverWan(j));
                    }
                }
            });
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            ((RelativeLayout) this.mRootView).addView(this.kFA.aLV(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFL() {
        if (this.kFn != null) {
            if (this.kFn.isBjhVideo && !TbadkCoreApplication.isLogin()) {
                bc.skipToLoginActivity(getContext());
                return;
            }
            String str = this.kFn.forum_id;
            String str2 = this.kFn.forum_name;
            String str3 = this.kFn.title;
            String str4 = this.kFn.thread_id;
            String str5 = "http://tieba.baidu.com/p/" + str4 + "?share=9105&fr=share";
            String str6 = this.kFn.thumbnail_url;
            String format = MessageFormat.format(getResources().getString(R.string.share_content_tpl), str3, "");
            Uri parse = str6 == null ? null : Uri.parse(str6);
            ShareItem shareItem = new ShareItem();
            shareItem.title = str3;
            shareItem.content = format;
            shareItem.dlS = "";
            shareItem.linkUrl = str5;
            shareItem.cQy = 2;
            shareItem.extData = str4;
            shareItem.dlV = 3;
            shareItem.fid = str;
            shareItem.fName = str2;
            shareItem.tid = str4;
            shareItem.dlJ = true;
            shareItem.dlU = 0;
            shareItem.dlZ = 2;
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            if (this.kFn.isBjhVideo) {
                shareItem.dmf = false;
                shareItem.canShareBySmartApp = false;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = this.kFn.thumbnail_url;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = this.kFn.title;
            originalThreadInfo.threadId = this.kFn.thread_id;
            originalThreadInfo.oriUgcInfo = this.kFn.baijiahaoData;
            shareItem.dmc = OriginalThreadInfo.ShareInfo.generateShareInfo(originalThreadInfo);
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.dlV);
            bundle.putInt("obj_type", shareItem.dlZ);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.cQy);
            shareItem.Y(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getActivity(), shareItem, true, true);
            shareDialogConfig.setIsAlaLive(false);
            shareDialogConfig.setFrom(ShareDialogConfig.From.VideoMiddlePageVertical);
            com.baidu.tieba.c.e.buG().b(shareDialogConfig);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.eHK) {
            this.fHZ = new ForumManageModel(getPageContext());
            this.fHZ.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.11
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (obj != null) {
                        switch (VideoPlayFragment.this.fHZ.getLoadDataMode()) {
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
        this.iFV = com.baidu.tbadk.baseEditMark.a.a(getBaseFragmentActivity());
        if (this.iFV != null) {
            this.iFV.a(new a.InterfaceC0364a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.13
                @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0364a
                public void c(boolean z, boolean z2, String str) {
                    if (z) {
                        if (VideoPlayFragment.this.iFV != null) {
                            VideoPlayFragment.this.iFV.ff(z2);
                        }
                        if (VideoPlayFragment.this.kFn != null) {
                            if (z2) {
                                VideoPlayFragment.this.kFn.mark_id = VideoPlayFragment.this.kFn.post_id;
                            } else {
                                VideoPlayFragment.this.kFn.mark_id = null;
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
        this.cVY = new com.baidu.tbadk.coreExtra.model.a(null);
        registerListener(this.cWc);
        registerListener(this.cHu);
        if (Build.VERSION.SDK_INT >= 24 && getBaseFragmentActivity().isInMultiWindowMode()) {
            this.kFz = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        cRy();
        cRF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cRt() {
        if (this.kFd != null && this.kFc != null) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(300L);
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation2.setDuration(300L);
            this.kFc.clearAnimation();
            this.kFd.clearAnimation();
            this.kFc.setVisibility(8);
            this.kFd.setVisibility(0);
            this.kFd.startAnimation(scaleAnimation2);
            this.kFc.startAnimation(scaleAnimation);
        }
    }

    private void cRu() {
        if (this.kFd != null && this.kFc != null) {
            this.kFc.clearAnimation();
            this.kFd.clearAnimation();
            this.kFc.setVisibility(0);
            this.kFd.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DJ(int i) {
        int i2;
        if (bc.checkUpIsLogin(getActivity()) && this.kFn != null) {
            if (i == this.kET) {
                if ("1".equals(this.kFn.is_agreed)) {
                    i2 = 1;
                    this.kFn.agree_num = String.valueOf(com.baidu.adp.lib.f.b.toInt(this.kFn.agree_num, 0) - 1);
                    this.kFn.is_agreed = "0";
                } else {
                    this.kFn.agree_num = String.valueOf(com.baidu.adp.lib.f.b.toInt(this.kFn.agree_num, 0) + 1);
                    this.kFn.is_agreed = "1";
                    i2 = 0;
                }
            } else {
                this.kFn.agree_num = String.valueOf(com.baidu.adp.lib.f.b.toInt(this.kFn.agree_num, 0) + 1);
                this.kFn.is_agreed = "1";
                i2 = 0;
            }
            an anVar = new an("c12795");
            anVar.cp("tid", this.kFn.thread_id);
            anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
            if (i == this.kET) {
                anVar.Z("obj_type", i2);
            } else {
                anVar.Z("obj_type", 2);
            }
            TiebaStatic.log(anVar);
            cRy();
            if (this.kFp != null && i2 == 0) {
                this.kFp.startAnimation(getScaleAnimation());
            }
            HttpMessage httpMessage = new HttpMessage(1001601);
            httpMessage.addParam("thread_id", this.kFn.thread_id);
            httpMessage.addParam("op_type", i2);
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            httpMessage.addHeader("needSig", "1");
            sendMessage(httpMessage);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_AGREE_LOVE, this.kFn));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (!TbSingleton.getInstance().isNotchScreen(getActivity()) && !TbSingleton.getInstance().isCutoutScreen(getActivity())) {
            this.mRootView.setSystemUiVisibility(4);
        }
        if (this.kFn != null && !StringUtils.isNull(this.kFn.video_url)) {
            this.mHasInit = true;
            if (this.mIsVisible) {
                bti();
                ahK();
                if (this.kFn != null && this.mRect != null) {
                    an anVar = new an("c12794");
                    anVar.cp("tid", this.kFn.thread_id);
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
        if (this.kFA != null && this.kFA.aLV() != null) {
            this.kFA.aLV().hide();
            this.kFr.setVisibility(0);
            this.kFs.setText(StringUtils.isNull(((c) this.kFA.aLV().lX(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
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
        if (this.kFA != null) {
            this.kFA.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.mIsVisible = z;
        if (this.mHasInit) {
            if (this.mIsVisible && (!this.kFz || Build.VERSION.SDK_INT < 24 || !getBaseFragmentActivity().isInMultiWindowMode())) {
                if (this.kFn != null && this.mRect == null) {
                    an anVar = new an("c12794");
                    anVar.cp("tid", this.kFn.thread_id);
                    anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                    anVar.Z("obj_type", 1);
                    TiebaStatic.log(anVar);
                }
                startPlay();
                cRv();
                this.kFz = false;
                return;
            }
            cRu();
            this.playTime = 1;
            pausePlay();
        }
    }

    private void cRv() {
        if (this.kFn != null) {
            an anVar = new an("c12590");
            anVar.cp("tid", this.kFn.thread_id);
            anVar.cp("fid", this.kFn.forum_id);
            anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
            anVar.Z("obj_locate", this.kFt);
            anVar.Z(TiebaInitialize.Params.OBJ_PARAM2, 1);
            anVar.cp("obj_param1", aq.isEmpty(this.kFn.mRecomWeight) ? "0" : this.kFn.mRecomWeight);
            anVar.cp("extra", aq.isEmpty(this.kFn.mRecomExtra) ? "0" : this.kFn.mRecomExtra);
            anVar.cp("obj_id", this.cKN);
            anVar.cp(TiebaInitialize.Params.AB_TAG, aq.isEmpty(this.kFn.mRecomAbTag) ? "0" : this.kFn.mRecomAbTag);
            anVar.cp("obj_source", aq.isEmpty(this.kFn.mRecomSource) ? "0" : this.kFn.mRecomSource);
            anVar.cp("obj_type", this.mFromPage);
            anVar.Z("is_vertical", 1);
            if (this.kFn.baijiahaoData != null) {
                anVar.cp("obj_param4", this.kFn.baijiahaoData.oriUgcNid);
                anVar.cp("obj_param6", this.kFn.baijiahaoData.oriUgcVid);
                if (this.kFn.baijiahaoData.oriUgcType == 4) {
                    anVar.Z("obj_param5", 2);
                } else if (this.kFn.baijiahaoData.oriUgcType == 2) {
                    anVar.Z("obj_param5", 3);
                }
            } else {
                anVar.Z("obj_param5", 1);
            }
            TiebaStatic.log(anVar);
        }
    }

    private void Kp(String str) {
        if (this.jsG != null && str != null && !str.equals(this.mVideoUrl)) {
            if (cwB()) {
                ((QuickVideoView) this.jsG).setRecoveryState(0);
            }
            this.jsG.setVideoPath(str, this.kFn.thread_id);
            this.mVideoUrl = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay() {
        if (TbadkCoreApplication.mSquareVideoCanPlayNotWifi || com.baidu.tieba.video.g.cNK().cNL() || cRA()) {
            cwN();
            if (this.kFj != null) {
                this.kFj.setVisibility(8);
            }
            if (Build.VERSION.SDK_INT < 17 && this.kEV.getVisibility() == 0) {
                this.kEV.clearAnimation();
                this.kEV.startAnimation(this.ejI);
            }
            if (this.jsG != null) {
                this.jsG.start();
                bti();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bti() {
        if (this.kFn != null) {
            y yVar = new y();
            yVar.mLocate = "nani_midpage";
            yVar.OG = this.kFn.thread_id;
            yVar.fKa = this.kFn.forum_id + "";
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.mSource = this.kFn.mRecomSource;
            yVar.jvO = this.kFn.mRecomAbTag;
            yVar.jvP = this.kFn.mRecomWeight;
            yVar.jvQ = "";
            yVar.cKN = "";
            yVar.jvS = this.kFn.mMd5;
            if (this.mRect != null) {
                yVar.jvT = "1";
            } else {
                yVar.jvT = "2";
            }
            if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                yVar.jvU = "1";
                yVar.mLocate = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                yVar.jvQ = "index";
            }
            com.baidu.tieba.play.l.a(this.kFn.mMd5, "", "1", yVar);
        }
    }

    private void cwN() {
        if (com.baidu.adp.lib.util.j.isMobileNet()) {
            com.baidu.tieba.video.g.cNK().fy(getContext());
        }
    }

    private void pausePlay() {
        if (this.jsG != null) {
            this.jsG.pause();
        }
    }

    private void stopPlay() {
        if (this.jsG != null) {
            if (cwB()) {
                ((QuickVideoView) this.jsG).setRecoveryState(5);
            }
            this.jsG.stopPlayback();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cRw() {
        PbActivityConfig createNormalCfg = new PbActivityConfig(getActivity()).createNormalCfg(this.kFn.thread_id, this.kFn.post_id, "");
        createNormalCfg.setForumId(String.valueOf(this.kFn.forum_id));
        createNormalCfg.setForumName(this.kFn.forum_name);
        createNormalCfg.setVideo_source("nani_midpage");
        createNormalCfg.setJumpToCommentArea(true);
        createNormalCfg.setBjhData(this.kFn.baijiahaoData);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cRx() {
        if (this.cHd == null) {
            this.kFu = new com.baidu.tieba.view.a(getActivity());
            this.cHd = new e(getActivity(), this.kFu.aCF());
            this.cHd.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.14
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (!TbSingleton.getInstance().isNotchScreen(VideoPlayFragment.this.getActivity()) && !TbSingleton.getInstance().isCutoutScreen(VideoPlayFragment.this.getActivity())) {
                        VideoPlayFragment.this.jsG.getView().setSystemUiVisibility(4);
                    }
                }
            });
        }
        if (this.kFu != null) {
            ArrayList arrayList = new ArrayList();
            a.C0621a c0621a = new a.C0621a(this.kFu);
            c0621a.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.15
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    if (!bc.checkUpIsLogin(VideoPlayFragment.this.getContext())) {
                        VideoPlayFragment.this.cHd.dismiss();
                        return;
                    }
                    VideoPlayFragment.this.cHd.dismiss();
                    if (VideoPlayFragment.this.kFn != null) {
                        boolean z = VideoPlayFragment.this.kFn.post_id != null && VideoPlayFragment.this.kFn.post_id.equals(VideoPlayFragment.this.kFn.mark_id);
                        MarkData markData = new MarkData();
                        Date date = new Date();
                        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
                        markData.setThreadId(VideoPlayFragment.this.kFn.thread_id);
                        markData.setPostId(VideoPlayFragment.this.kFn.post_id);
                        markData.setTime(date.getTime());
                        markData.setHostMode(false);
                        markData.setId(VideoPlayFragment.this.kFn.thread_id);
                        markData.setForumId(VideoPlayFragment.this.kFn.forum_id);
                        if (VideoPlayFragment.this.iFV != null) {
                            VideoPlayFragment.this.iFV.a(markData);
                            if (!z) {
                                VideoPlayFragment.this.iFV.awy();
                            } else {
                                VideoPlayFragment.this.iFV.awx();
                            }
                        }
                    }
                }
            });
            boolean z = false;
            if (this.kFn != null && this.kFn.post_id != null && this.kFn.post_id.equals(this.kFn.mark_id)) {
                z = true;
            }
            if (z) {
                c0621a.setText(getResources().getString(R.string.remove_mark));
            } else {
                c0621a.setText(getResources().getString(R.string.mark));
            }
            if (this.kFn != null && !this.kFn.isBjhVideo) {
                arrayList.add(c0621a);
            }
            a.C0621a c0621a2 = new a.C0621a(getActivity().getString(R.string.delete), this.kFu);
            c0621a2.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.16
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    VideoPlayFragment.this.cHd.dismiss();
                    if (bc.checkUpIsLogin(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.kFn != null) {
                        String str = VideoPlayFragment.this.kFn.thread_id;
                        String str2 = VideoPlayFragment.this.kFn.forum_id;
                        String string = VideoPlayFragment.this.getResources().getString(R.string.web_view_report_title);
                        String str3 = "http://tieba.baidu.com/mo/q/postreport?fid=" + str2 + "&tid=" + str + "&pid=" + VideoPlayFragment.this.kFn.post_id;
                        if (VideoPlayFragment.this.kFn.isBjhVideo) {
                            str3 = String.format(TbConfig.URL_BJH_REPORT, str, VideoPlayFragment.this.kFn.post_id) + "&channelid=33840";
                            string = "";
                        }
                        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(VideoPlayFragment.this.getPageContext().getPageActivity(), string, str3, true);
                        if (VideoPlayFragment.this.kFn.isBjhVideo) {
                            tbWebViewActivityConfig.setFixTitle(true);
                        }
                        VideoPlayFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
                    }
                }
            });
            c0621a2.setText(getResources().getString(R.string.report_text));
            arrayList.add(c0621a2);
            if (this.eHK) {
                a.C0621a c0621a3 = new a.C0621a(getActivity().getString(R.string.delete), this.kFu);
                c0621a3.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.17
                    @Override // com.baidu.tieba.view.a.c
                    public void onClick() {
                        VideoPlayFragment.this.cHd.dismiss();
                        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(VideoPlayFragment.this.getActivity());
                        aVar.jF(R.string.del_thread_confirm);
                        aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.17.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar.dismiss();
                                if (VideoPlayFragment.this.kFn != null) {
                                    VideoPlayFragment.this.fHZ.a(VideoPlayFragment.this.kFn.forum_id, VideoPlayFragment.this.kFn.forum_name, VideoPlayFragment.this.kFn.thread_id, VideoPlayFragment.this.kFn.post_id, 0, 0, VideoPlayFragment.this.eHK, null);
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
                        aVar.fz(true);
                        aVar.b(VideoPlayFragment.this.getPageContext());
                        aVar.aCp();
                    }
                });
                c0621a3.setText(getResources().getString(R.string.delete));
                arrayList.add(c0621a3);
            }
            this.kFu.az(arrayList);
        }
        this.cHd.show();
    }

    private void cRy() {
        if (this.kFn != null) {
            this.kEV.startLoad(this.kFn.thumbnail_url, 10, false);
            Matcher matcher = Pattern.compile("^我发表了?一(篇|个)视频贴(，|,).+$").matcher(this.kFn.title);
            if (StringUtils.isNull(this.kFn.title) || matcher.matches()) {
                this.kFe.setVisibility(8);
            } else {
                this.kFe.setVisibility(0);
                this.kFe.setTextSize(l.getDimens(getContext(), R.dimen.tbfontsize40));
                this.kFe.setTextColor(R.color.cp_cont_a);
                this.kFe.setLineSpacingExtra(l.getDimens(getContext(), R.dimen.tbds14));
                this.kFe.setExpandable(true);
                this.kFe.setOnStatusChangedListener(new ExpandableTextView.a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.18
                    @Override // com.baidu.tieba.view.expandable.ExpandableTextView.a
                    public void mk(boolean z) {
                        VideoPlayFragment.this.kFn.isTitleExpanded = z;
                    }
                });
                this.kFe.setData(this.kFn.title, this.kFn.isTitleExpanded);
            }
            this.kFg.setText(aq.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.kFn.comment_num, 0L)));
            this.kFh.setText(aq.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.kFn.agree_num, 0L)));
            this.kFi.setText(aq.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.kFn.share_num, 0L)));
            if (this.kFn.author_info != null) {
                if (!TextUtils.isEmpty(this.kFn.author_info.bjhAvatar)) {
                    this.kEX.startLoad(this.kFn.author_info.bjhAvatar, 12, false);
                } else if (!StringUtils.isNull(this.kFn.author_info.portrait) && this.kFn.author_info.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.kEX.startLoad(this.kFn.author_info.portrait, 10, false);
                } else {
                    this.kEX.startLoad(this.kFn.author_info.portrait, 12, false);
                }
                if (StringUtils.isNull(this.kFn.author_info.cNG())) {
                    this.kFq.setVisibility(8);
                } else {
                    this.kFq.setVisibility(0);
                    this.kFq.setText("@" + this.kFn.author_info.cNG());
                }
            }
            if ("1".equals(this.kFn.is_private) && this.kFo.getVisibility() != 0) {
                this.kFm.setVisibility(0);
            } else {
                this.kFm.setVisibility(8);
            }
            if ("1".equals(this.kFn.is_agreed)) {
                am.setImageResource(this.kFp, R.drawable.icon_card_like_white_full_s);
            } else {
                am.setImageResource(this.kFp, R.drawable.btn_video_agree);
            }
            if (this.kFn.act_info != null && !StringUtils.isNull(this.kFn.act_info.activity_name) && this.kFo.getVisibility() != 0) {
                this.kFl.setVisibility(0);
                this.kFf.setText(this.kFn.act_info.activity_name);
            } else {
                this.kFl.setVisibility(8);
            }
            cRz();
            if (this.kFn.isBjhVideo) {
                this.kEW.setVisibility(8);
            } else {
                this.kEW.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cRz() {
        if (this.eHK || (this.kFn.author_info != null && !"0".equals(this.kFn.author_info.is_follow))) {
            this.kFb.setVisibility(4);
            this.kFb.setClickable(false);
            return;
        }
        this.kFb.setVisibility(0);
        this.kFb.setClickable(true);
    }

    private void brF() {
        if (getActivity() != null) {
            if (this.kFB == null || !this.kFB.isShowing()) {
                this.kFB = new com.baidu.tbadk.core.dialog.a(getActivity());
                View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.video_no_wifi_dialog, (ViewGroup) null);
                ((TextView) inflate.findViewById(R.id.tv_title)).setText(R.string.confirm_title);
                ((TextView) inflate.findViewById(R.id.tv_msg)).setText(R.string.enter_video_center_page_no_wifi_tip);
                ((TextView) inflate.findViewById(R.id.tv_open_free_data)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.19
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        com.baidu.tbadk.browser.a.startWebActivity(true, (Context) VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.getResources().getString(R.string.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
                    }
                });
                SvgManager.aEp().a((ImageView) inflate.findViewById(R.id.open_free_data_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
                this.kFB.aO(inflate);
                this.kFB.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.20
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        TbadkCoreApplication.mSquareVideoCanPlayNotWifi = true;
                        VideoPlayFragment.this.startPlay();
                    }
                });
                this.kFB.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.21
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                    }
                });
                this.kFB.jI(1);
                this.kFB.jG(R.color.cp_cont_b);
                this.kFB.fz(true);
                this.kFB.b(getPageContext());
                this.kFB.aCp();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cRA() {
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable() || com.baidu.adp.lib.util.j.isWifiNet()) {
            return true;
        }
        if (!this.mIsVisible || com.baidu.tieba.video.g.cNK().cNL()) {
            return false;
        }
        if (this.kFj != null) {
            this.kFj.setVisibility(0);
        }
        pausePlay();
        brF();
        return false;
    }

    private void ahK() {
        if ((TbadkCoreApplication.mSquareVideoCanPlayNotWifi || cRA() || com.baidu.tieba.video.g.cNK().cNL()) && this.jsG != null && this.kFj != null) {
            if (this.jsG.getParent() == null) {
                cRE();
                cRF();
            }
            this.jsG.b(null);
            this.kFj.setVisibility(8);
            cwN();
            if (this.jtS != null) {
                this.jtS.onStart();
            }
        }
    }

    protected Animation getScaleAnimation() {
        if (this.kFv == null) {
            this.kFv = AnimationUtils.loadAnimation(getContext(), R.anim.scale_zoom_in_and_out_anim);
        }
        return this.kFv;
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0389a
    public void aSS() {
        if (this.jsG.isPlaying()) {
            this.jsG.pause();
            this.kFj.setVisibility(0);
        } else if (TbadkCoreApplication.mSquareVideoCanPlayNotWifi || cRA() || com.baidu.tieba.video.g.cNK().cNL()) {
            this.jsG.start();
            this.kFj.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0389a
    public void u(float f, float f2) {
        if (bc.checkUpIsLogin(getActivity()) && !this.kFw) {
            cRB();
            if (this.kFn != null && "0".equals(this.kFn.is_agreed)) {
                DJ(this.kEU);
            }
        }
    }

    private void cRB() {
        if (this.mRootView != null) {
            this.kFw = true;
            final ImageView imageView = new ImageView(this.mRootView.getContext());
            imageView.setImageResource(R.drawable.icon_video_like);
            if (this.kFy == null) {
                this.kFy = new RelativeLayout.LayoutParams(-2, -2);
                this.kFy.addRule(13);
            }
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(imageView, this.kFy);
            }
            if (this.kFx == null) {
                this.kFx = new AnimatorSet();
                this.kFx.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.22
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        VideoPlayFragment.this.kFw = false;
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
            this.kFx.setTarget(imageView);
            this.kFx.playSequentially(ofPropertyValuesHolder, ofPropertyValuesHolder2);
            this.kFx.start();
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0389a
    public void aST() {
        if (this.kFn != null && this.kFn.author_info != null) {
            long j = com.baidu.adp.lib.f.b.toLong(this.kFn.author_info.user_id, 0L);
            long j2 = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
            boolean z = j == j2;
            if (j == 0 && j2 == 0) {
                z = false;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(getActivity()).createNormalConfig(j, z, false)));
        }
    }

    public List<String> getMediaIDs() {
        if (cwB()) {
            return ((QuickVideoView) this.jsG).getMediaIDs();
        }
        return null;
    }

    public String cRC() {
        if (cwB()) {
            return ((QuickVideoView) this.jsG).getMediaId();
        }
        return null;
    }

    public boolean cRD() {
        if (this.kFA == null || this.kFA.aLV() == null || !this.kFA.aLV().isVisible()) {
            return false;
        }
        this.kFA.aLV().hide();
        this.kFr.setVisibility(0);
        if ((this.kFA.aLV().lX(28) instanceof c) && ((c) this.kFA.aLV().lX(28)).getInputView() != null && ((c) this.kFA.aLV().lX(28)).getInputView().getText() != null) {
            this.kFs.setText(StringUtils.isNull(((c) this.kFA.aLV().lX(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
        }
        return true;
    }

    public void c(int i, int i2, Intent intent) {
        if (this.kFA != null) {
            this.kFA.onActivityResult(i, i2, intent);
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
        if (this.kFA != null && this.kFA.aLV() != null) {
            this.kFA.aLV().onChangeSkinType(i);
        }
        SvgManager.aEp().a(this.Uw, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
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

    public void cRE() {
        if (this.jsG != null && this.jsG.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            ((ViewGroup) this.mRootView).addView(this.jsG.getView(), 0);
            this.jsG.getView().setLayoutParams(layoutParams);
            this.jsG.setPageTypeForPerfStat("v_mid_page");
            if (cwB()) {
                ((QuickVideoView) this.jsG).setPlayerReuseEnable(true);
                ((QuickVideoView) this.jsG).setNeedRecovery(true);
            }
            if (this.kFn != null) {
                y yVar = new y();
                yVar.mUid = TbadkCoreApplication.getCurrentAccount();
                yVar.OG = this.kFn.thread_id;
                yVar.fKa = this.kFn.forum_id;
                yVar.jvS = this.kFn.mMd5;
                yVar.cKN = "";
                yVar.mSource = this.kFn.mRecomSource;
                yVar.mAbTag = this.kFn.mRecomAbTag;
                yVar.jvR = 1;
                if (this.kFn.baijiahaoData != null) {
                    if (this.kFn.baijiahaoData.oriUgcType == 2) {
                        yVar.jvR = 3;
                    } else if (this.kFn.baijiahaoData.oriUgcType == 4) {
                        yVar.jvR = 2;
                    }
                }
                yVar.jvP = this.kFn.mRecomWeight;
                if (this.mRect != null) {
                    yVar.jvT = "1";
                } else {
                    yVar.jvT = "2";
                }
                if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                    yVar.jvU = "1";
                    yVar.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                    yVar.jvQ = this.mFromPage;
                    yVar.cKN = this.cKN;
                    yVar.jvO = this.kFn.mRecomWeight;
                } else {
                    yVar.mLocate = "14";
                }
                this.egU.setVideoStatsData(yVar);
            }
            this.jsG.setContinuePlayEnable(true);
            this.jsG.setBusiness(this.egU);
        }
    }

    private void cRF() {
        if (Build.VERSION.SDK_INT >= 17) {
            this.jsG.setOnPreparedListener(this.kFE);
        }
        this.jsG.setOnCompletionListener(this.kFD);
        this.jsG.setOnOutInfoListener(this.kFC);
    }
}
