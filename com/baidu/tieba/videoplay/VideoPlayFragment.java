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
    public com.baidu.tieba.play.a.a jsB;
    private QuickVideoView.c jtN;
    private j.b jtw;
    private TbImageView kEQ;
    public ImageView kER;
    public HeadImageView kES;
    public LinearLayout kET;
    public LinearLayout kEU;
    public LinearLayout kEV;
    public ImageView kEW;
    public ImageView kEX;
    public ImageView kEY;
    public ExpandableTextView kEZ;
    public TextView kFa;
    public TextView kFb;
    public TextView kFc;
    public TextView kFd;
    public ImageView kFe;
    private LinearLayout kFf;
    public LinearLayout kFg;
    public LinearLayout kFh;
    public VideoItemData kFi;
    private TextView kFj;
    public ImageView kFk;
    public TextView kFl;
    private View kFm;
    private TextView kFn;
    private int kFo;
    private com.baidu.tieba.view.a kFp;
    protected Animation kFq;
    private boolean kFr;
    private AnimatorSet kFs;
    private RelativeLayout.LayoutParams kFt;
    private com.baidu.tieba.videoplay.editor.a kFv;
    com.baidu.tbadk.core.dialog.a kFw;
    private String mFrom;
    private String mFromPage;
    private boolean mHasInit;
    private boolean mIsVisible;
    private int mOriginHeight;
    private int mOriginWidth;
    private Rect mRect;
    public View mRootView;
    private String mVideoUrl;
    private int kEO = 0;
    private int kEP = 1;
    private ForumManageModel fHZ = null;
    private com.baidu.tbadk.baseEditMark.a iFV = null;
    private com.baidu.tbadk.coreExtra.model.a cVY = null;
    private BdUniqueId Mm = BdUniqueId.gen();
    private boolean kFu = false;
    private int playTime = 1;
    private CustomMessageListener cWc = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (VideoPlayFragment.this.kFi != null && VideoPlayFragment.this.kFi.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.kFi.author_info.user_id) && data != null && VideoPlayFragment.this.kFi.author_info.user_id.equals(data.toUid)) {
                    boolean z = true;
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    z = (message == null || message.getTag() == null || !message.getTag().equals(VideoPlayFragment.this.Mm)) ? false : false;
                    if (data.djO == null) {
                        if (!data.isSucc) {
                            if (z && !"0".equals(VideoPlayFragment.this.kFi.author_info.is_follow)) {
                                l.showToast(VideoPlayFragment.this.getActivity(), (int) R.string.attention_fail);
                                VideoPlayFragment.this.kFi.author_info.is_follow = "0";
                                VideoPlayFragment.this.cRx();
                            }
                        } else if (updateAttentionMessage.isAttention()) {
                            if (VideoPlayFragment.this.mIsVisible) {
                                if (z) {
                                    l.showToast(VideoPlayFragment.this.getActivity(), (int) R.string.attention_success);
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_AGREE_LOVE, VideoPlayFragment.this.kFi));
                                    return;
                                }
                                VideoPlayFragment.this.kFi.author_info.is_follow = "1";
                                VideoPlayFragment.this.cRx();
                            }
                        } else {
                            VideoPlayFragment.this.kFi.author_info.is_follow = "0";
                            VideoPlayFragment.this.cRx();
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
                VideoPlayFragment.this.cRy();
            }
        }
    };
    private g.e kFx = new g.e() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.24
        @Override // com.baidu.tieba.play.g.e
        public boolean onInfo(g gVar, int i, int i2) {
            if (VideoPlayFragment.this.mIsVisible) {
                if ((i == 3 || i == 904) && VideoPlayFragment.this.kEQ.getVisibility() == 0) {
                    VideoPlayFragment.this.kEQ.clearAnimation();
                    VideoPlayFragment.this.kEQ.startAnimation(VideoPlayFragment.this.ejI);
                    return true;
                }
                return true;
            }
            return true;
        }
    };
    private g.a kFy = new g.a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.25
        @Override // com.baidu.tieba.play.g.a
        public void onCompletion(g gVar) {
            if (VideoPlayFragment.this.jsB != null) {
                VideoPlayFragment.this.jsB.seekTo(0);
                VideoPlayFragment.this.jsB.start();
                VideoPlayFragment.this.bti();
                VideoPlayFragment.y(VideoPlayFragment.this);
                if (VideoPlayFragment.this.playTime == 3 && !VideoPlayFragment.this.kFi.isBjhVideo) {
                    VideoPlayFragment.this.cRr();
                }
            }
        }
    };
    private g.f kFz = new g.f() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.26
        @Override // com.baidu.tieba.play.g.f
        public void onPrepared(g gVar) {
            if (VideoPlayFragment.this.jsB != null) {
                VideoPlayFragment.this.jsB.setVolume(1.0f, 1.0f);
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
        this.kFi = (VideoItemData) arguments.get(VideoPlayActivityConfig.VIDEO_DATA);
        this.mRect = (Rect) arguments.getParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT);
        this.kFo = arguments.getInt(VideoPlayActivityConfig.VIDEO_INDEX);
        this.mFrom = arguments.getString(VideoPlayActivityConfig.PAGE_FROM);
        this.mFromPage = arguments.getString("from");
        this.cKN = arguments.getString("obj_id");
        if (this.kFi != null && this.kFi.author_info != null && String.valueOf(TbadkCoreApplication.getCurrentAccountId()).equals(this.kFi.author_info.user_id)) {
            this.eHK = true;
        }
        this.egU = new n(getActivity());
        this.egU.a(this.kFi);
        this.egU.a(new j.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.23
            @Override // com.baidu.tieba.play.j.b
            public void bx(int i, int i2) {
                if (VideoPlayFragment.this.jtw != null) {
                    VideoPlayFragment.this.jtw.bx(i, i2);
                }
            }
        });
        this.mRootView = layoutInflater.inflate(R.layout.video_play_view, (ViewGroup) null);
        this.isNewPlayer = b.rs("cyber_player_test");
        this.jsB = com.baidu.tieba.play.a.b.F(getContext(), this.isNewPlayer ? 1 : 0);
        cRC();
        this.kEQ = (TbImageView) this.mRootView.findViewById(R.id.video_cover);
        this.kEQ.setPlaceHolder(3);
        this.kEQ.setDefaultErrorResource(R.drawable.icon_play_bg);
        if (com.baidu.tbadk.core.util.g.aDB()) {
            this.fRj = this.mRootView.findViewById(R.id.top_container);
            int statusBarHeight = UtilHelper.getStatusBarHeight();
            if (this.fRj.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.fRj.getLayoutParams()).topMargin = statusBarHeight;
            }
        }
        this.Uw = (ImageView) this.mRootView.findViewById(R.id.back_btn);
        this.kER = (ImageView) this.mRootView.findViewById(R.id.more_btn);
        this.kES = (HeadImageView) this.mRootView.findViewById(R.id.author_portrait);
        this.kES.setDefaultResource(17170445);
        this.kES.setPlaceHolder(2);
        this.kES.setIsRound(true);
        this.kEW = (ImageView) this.mRootView.findViewById(R.id.love_btn);
        this.kFk = (ImageView) this.mRootView.findViewById(R.id.agree_img);
        this.kEZ = (ExpandableTextView) this.mRootView.findViewById(R.id.video_title);
        this.kFa = (TextView) this.mRootView.findViewById(R.id.video_activity);
        this.kEU = (LinearLayout) this.mRootView.findViewById(R.id.comment_container);
        this.kFb = (TextView) this.mRootView.findViewById(R.id.comment_num);
        this.kET = (LinearLayout) this.mRootView.findViewById(R.id.agree_container);
        this.kFc = (TextView) this.mRootView.findViewById(R.id.agree_num);
        this.kFd = (TextView) this.mRootView.findViewById(R.id.share_num);
        this.kEX = (ImageView) this.mRootView.findViewById(R.id.share_img);
        this.kEY = (ImageView) this.mRootView.findViewById(R.id.share_img_changed);
        cRs();
        this.kFe = (ImageView) this.mRootView.findViewById(R.id.play_btn);
        this.kFf = (LinearLayout) this.mRootView.findViewById(R.id.video_act_private_container);
        this.kFg = (LinearLayout) this.mRootView.findViewById(R.id.video_activity_container);
        this.kFh = (LinearLayout) this.mRootView.findViewById(R.id.video_private);
        this.kEV = (LinearLayout) this.mRootView.findViewById(R.id.share_container);
        this.kEV.setVisibility(8);
        this.kFl = (TextView) this.mRootView.findViewById(R.id.video_author_name);
        this.kFm = this.mRootView.findViewById(R.id.quick_reply_comment_layout);
        this.kFm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.27
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.kFi.isBjhVideo) {
                    VideoPlayFragment.this.cRu();
                } else if (VideoPlayFragment.this.a(VideoPlayFragment.this.getPageContext(), 11001)) {
                    VideoPlayFragment.this.kFm.setVisibility(4);
                    if (VideoPlayFragment.this.kFv != null && VideoPlayFragment.this.kFv.aLV() != null) {
                        VideoPlayFragment.this.kFv.aLV().display();
                    }
                    if (VideoPlayFragment.this.kFi != null) {
                        an anVar = new an("c13025");
                        anVar.cp("tid", VideoPlayFragment.this.kFi.thread_id);
                        anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                        anVar.cp("fid", VideoPlayFragment.this.kFi.forum_id);
                        TiebaStatic.log(anVar);
                    }
                }
            }
        });
        this.kFn = (TextView) this.mRootView.findViewById(R.id.quick_reply_comment_text);
        this.kFj = (TextView) this.mRootView.findViewById(R.id.download_nani_guide_txt);
        this.kFj.setVisibility(8);
        String string = com.baidu.tbadk.core.sharedPref.b.aDr().getString("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(string)) {
            this.kFj.setText(string);
        }
        final String string2 = com.baidu.tbadk.core.sharedPref.b.aDr().getString("nani_key_download_link_url", null);
        this.kFj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.28
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(string2)) {
                    ba.aEt().a((TbPageContext) i.ab(VideoPlayFragment.this.getPageContext().getPageActivity()), new String[]{string2}, true);
                }
            }
        });
        cRw();
        this.kES.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.29
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.kFi != null && VideoPlayFragment.this.kFi.author_info != null && !StringUtils.isNull(VideoPlayFragment.this.kFi.author_info.user_id) && VideoPlayFragment.this.kFi != null && VideoPlayFragment.this.kFi.author_info != null) {
                    long j = com.baidu.adp.lib.f.b.toLong(VideoPlayFragment.this.kFi.author_info.user_id, 0L);
                    long j2 = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                    boolean z = j == j2;
                    if (j == 0 && j2 == 0) {
                        z = false;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(VideoPlayFragment.this.getActivity()).createNormalConfig(j, z, false)));
                    an anVar = new an("c12798");
                    anVar.cp("tid", VideoPlayFragment.this.kFi.thread_id);
                    anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(anVar);
                }
            }
        });
        this.kFg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.30
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.kFi != null && VideoPlayFragment.this.kFi.act_info != null) {
                    com.baidu.tbadk.browser.a.startInternalWebActivity(VideoPlayFragment.this.getActivity(), VideoPlayFragment.this.kFi.act_info.link_url);
                    an anVar = new an("c12799");
                    anVar.cp("tid", VideoPlayFragment.this.kFi.thread_id);
                    anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(anVar);
                }
            }
        });
        this.kEZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.31
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.cRu();
            }
        });
        this.Uw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.32
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPlayFragment.this.kFi != null && !StringUtils.isNull(VideoPlayFragment.this.kFi.thread_id)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_INDEX, VideoPlayFragment.this.kFi.thread_id));
                }
                VideoPlayFragment.this.getActivity().finish();
            }
        });
        this.kER.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.cRv();
            }
        });
        this.kEU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.cRu();
                an anVar = new an("c12796");
                anVar.cp("tid", VideoPlayFragment.this.kFi.thread_id);
                anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(anVar);
            }
        });
        this.kET.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.DJ(VideoPlayFragment.this.kEO);
            }
        });
        this.kEV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayFragment.this.aFL();
                an anVar = new an("c12797");
                anVar.cp("tid", VideoPlayFragment.this.kFi.thread_id);
                anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(anVar);
            }
        });
        this.kEW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bc.checkUpIsLogin(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.kFi != null && VideoPlayFragment.this.kFi.author_info != null) {
                    VideoPlayFragment.this.cVY.a(true, VideoPlayFragment.this.kFi.author_info.portrait, VideoPlayFragment.this.kFi.author_info.user_id, false, "6", VideoPlayFragment.this.Mm, VideoPlayFragment.this.kFi.forum_id, "0");
                    VideoPlayFragment.this.kFi.author_info.is_follow = "1";
                    VideoPlayFragment.this.cRx();
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
                if (VideoPlayFragment.this.kEQ != null) {
                    VideoPlayFragment.this.kEQ.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        if (this.mRect != null) {
            this.mOriginWidth = this.mRect.right - this.mRect.left;
            this.mOriginHeight = this.mRect.bottom - this.mRect.top;
            this.kEQ.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.8
                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    int i2;
                    float f;
                    float f2 = 1.0f;
                    int width = VideoPlayFragment.this.kEQ.getWidth();
                    int height = VideoPlayFragment.this.kEQ.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.kFi.video_height, 0) > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.kFi.video_width, 0) > 0) {
                        float f3 = width / height;
                        float f4 = com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.kFi.video_width, 0.0f) / com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.kFi.video_height, 0.0f);
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
                            VideoPlayFragment.this.kEQ.setLayoutParams(layoutParams);
                            if (VideoPlayFragment.this.mOriginHeight > 0 || VideoPlayFragment.this.mOriginWidth <= 0) {
                                f = 1.0f;
                            } else {
                                f2 = i2 / VideoPlayFragment.this.mOriginWidth;
                                f = i / VideoPlayFragment.this.mOriginHeight;
                            }
                            VideoPlayFragment.this.kEQ.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                            VideoPlayFragment.this.kEQ.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.8.1
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
                    VideoPlayFragment.this.kEQ.setLayoutParams(layoutParams2);
                    if (VideoPlayFragment.this.mOriginHeight > 0) {
                    }
                    f = 1.0f;
                    VideoPlayFragment.this.kEQ.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f).scaleX(f2).translationX((width / 2.0f) - (VideoPlayFragment.this.mRect.left + ((VideoPlayFragment.this.mRect.right - VideoPlayFragment.this.mRect.left) / 2))).translationY((height / 2.0f) - (VideoPlayFragment.this.mRect.top + ((VideoPlayFragment.this.mRect.bottom - VideoPlayFragment.this.mRect.top) / 2))).start();
                    VideoPlayFragment.this.kEQ.postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.8.1
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
            this.kEQ.post(new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.9
                @Override // java.lang.Runnable
                public void run() {
                    int width = VideoPlayFragment.this.kEQ.getWidth();
                    int height = VideoPlayFragment.this.kEQ.getHeight();
                    if (height > 0 && width > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.kFi.video_height, 0) > 0 && com.baidu.adp.lib.f.b.toInt(VideoPlayFragment.this.kFi.video_width, 0) > 0) {
                        float f = width / height;
                        float f2 = com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.kFi.video_width, 0.0f) / com.baidu.adp.lib.f.b.toFloat(VideoPlayFragment.this.kFi.video_height, 0.0f);
                        if (f2 > 0.0f && Math.abs(f2 - f) > 0.05d) {
                            if (f2 > f) {
                                height = (int) (width / f2);
                            } else {
                                width = (int) (height * f2);
                            }
                        }
                        ViewGroup.LayoutParams layoutParams = VideoPlayFragment.this.kEQ.getLayoutParams();
                        layoutParams.height = height;
                        layoutParams.width = width;
                        VideoPlayFragment.this.kEQ.setLayoutParams(layoutParams);
                    }
                }
            });
        }
        ceg();
        if (this.mIsVisible) {
            cRt();
        }
        if (this.kFi != null && !StringUtils.isNull(this.kFi.video_url)) {
            Kp(this.kFi.video_url);
        }
        return this.mRootView;
    }

    public boolean cwz() {
        return !this.isNewPlayer && (this.jsB instanceof QuickVideoView);
    }

    public void a(j.b bVar) {
        this.jtw = bVar;
    }

    public void setVideoStatusListener(QuickVideoView.c cVar) {
        this.jtN = cVar;
    }

    private void ceg() {
        this.kFv = (com.baidu.tieba.videoplay.editor.a) new com.baidu.tieba.videoplay.editor.b().dR(getActivity());
        if (this.kFv != null && this.kFi != null) {
            this.kFv.a(getPageContext());
            this.kFv.aw(this.kFi.thread_id, this.kFi.forum_id, this.kFi.forum_name);
            this.kFv.a(new a.InterfaceC0620a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.10
                @Override // com.baidu.tieba.videoplay.editor.a.InterfaceC0620a
                public void tv(boolean z) {
                    VideoPlayFragment.this.kFm.setVisibility(0);
                    if (z) {
                        VideoPlayFragment.this.kFn.setText(R.string.reply_something);
                    } else {
                        VideoPlayFragment.this.kFn.setText(StringUtils.isNull(((c) VideoPlayFragment.this.kFv.aLV().lX(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
                    }
                    if (VideoPlayFragment.this.kFi != null && z) {
                        long j = com.baidu.adp.lib.f.b.toLong(VideoPlayFragment.this.kFi.comment_num, 0L) + 1;
                        VideoPlayFragment.this.kFi.comment_num = String.valueOf(j);
                        VideoPlayFragment.this.kFb.setText(aq.numFormatOverWan(j));
                    }
                }
            });
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            ((RelativeLayout) this.mRootView).addView(this.kFv.aLV(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFL() {
        if (this.kFi != null) {
            if (this.kFi.isBjhVideo && !TbadkCoreApplication.isLogin()) {
                bc.skipToLoginActivity(getContext());
                return;
            }
            String str = this.kFi.forum_id;
            String str2 = this.kFi.forum_name;
            String str3 = this.kFi.title;
            String str4 = this.kFi.thread_id;
            String str5 = "http://tieba.baidu.com/p/" + str4 + "?share=9105&fr=share";
            String str6 = this.kFi.thumbnail_url;
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
            if (this.kFi.isBjhVideo) {
                shareItem.dmf = false;
                shareItem.canShareBySmartApp = false;
            }
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.showPicUrl = this.kFi.thumbnail_url;
            originalThreadInfo.showType = 3;
            originalThreadInfo.showText = this.kFi.title;
            originalThreadInfo.threadId = this.kFi.thread_id;
            originalThreadInfo.oriUgcInfo = this.kFi.baijiahaoData;
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
                        if (VideoPlayFragment.this.kFi != null) {
                            if (z2) {
                                VideoPlayFragment.this.kFi.mark_id = VideoPlayFragment.this.kFi.post_id;
                            } else {
                                VideoPlayFragment.this.kFi.mark_id = null;
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
            this.kFu = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        cRw();
        cRD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cRr() {
        if (this.kEY != null && this.kEX != null) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(300L);
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation2.setDuration(300L);
            this.kEX.clearAnimation();
            this.kEY.clearAnimation();
            this.kEX.setVisibility(8);
            this.kEY.setVisibility(0);
            this.kEY.startAnimation(scaleAnimation2);
            this.kEX.startAnimation(scaleAnimation);
        }
    }

    private void cRs() {
        if (this.kEY != null && this.kEX != null) {
            this.kEX.clearAnimation();
            this.kEY.clearAnimation();
            this.kEX.setVisibility(0);
            this.kEY.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DJ(int i) {
        int i2;
        if (bc.checkUpIsLogin(getActivity()) && this.kFi != null) {
            if (i == this.kEO) {
                if ("1".equals(this.kFi.is_agreed)) {
                    i2 = 1;
                    this.kFi.agree_num = String.valueOf(com.baidu.adp.lib.f.b.toInt(this.kFi.agree_num, 0) - 1);
                    this.kFi.is_agreed = "0";
                } else {
                    this.kFi.agree_num = String.valueOf(com.baidu.adp.lib.f.b.toInt(this.kFi.agree_num, 0) + 1);
                    this.kFi.is_agreed = "1";
                    i2 = 0;
                }
            } else {
                this.kFi.agree_num = String.valueOf(com.baidu.adp.lib.f.b.toInt(this.kFi.agree_num, 0) + 1);
                this.kFi.is_agreed = "1";
                i2 = 0;
            }
            an anVar = new an("c12795");
            anVar.cp("tid", this.kFi.thread_id);
            anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
            if (i == this.kEO) {
                anVar.Z("obj_type", i2);
            } else {
                anVar.Z("obj_type", 2);
            }
            TiebaStatic.log(anVar);
            cRw();
            if (this.kFk != null && i2 == 0) {
                this.kFk.startAnimation(getScaleAnimation());
            }
            HttpMessage httpMessage = new HttpMessage(1001601);
            httpMessage.addParam("thread_id", this.kFi.thread_id);
            httpMessage.addParam("op_type", i2);
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            httpMessage.addHeader("needSig", "1");
            sendMessage(httpMessage);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_AGREE_LOVE, this.kFi));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (!TbSingleton.getInstance().isNotchScreen(getActivity()) && !TbSingleton.getInstance().isCutoutScreen(getActivity())) {
            this.mRootView.setSystemUiVisibility(4);
        }
        if (this.kFi != null && !StringUtils.isNull(this.kFi.video_url)) {
            this.mHasInit = true;
            if (this.mIsVisible) {
                bti();
                ahK();
                if (this.kFi != null && this.mRect != null) {
                    an anVar = new an("c12794");
                    anVar.cp("tid", this.kFi.thread_id);
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
        if (this.kFv != null && this.kFv.aLV() != null) {
            this.kFv.aLV().hide();
            this.kFm.setVisibility(0);
            this.kFn.setText(StringUtils.isNull(((c) this.kFv.aLV().lX(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
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
        if (this.kFv != null) {
            this.kFv.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.mIsVisible = z;
        if (this.mHasInit) {
            if (this.mIsVisible && (!this.kFu || Build.VERSION.SDK_INT < 24 || !getBaseFragmentActivity().isInMultiWindowMode())) {
                if (this.kFi != null && this.mRect == null) {
                    an anVar = new an("c12794");
                    anVar.cp("tid", this.kFi.thread_id);
                    anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                    anVar.Z("obj_type", 1);
                    TiebaStatic.log(anVar);
                }
                startPlay();
                cRt();
                this.kFu = false;
                return;
            }
            cRs();
            this.playTime = 1;
            pausePlay();
        }
    }

    private void cRt() {
        if (this.kFi != null) {
            an anVar = new an("c12590");
            anVar.cp("tid", this.kFi.thread_id);
            anVar.cp("fid", this.kFi.forum_id);
            anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
            anVar.Z("obj_locate", this.kFo);
            anVar.Z(TiebaInitialize.Params.OBJ_PARAM2, 1);
            anVar.cp("obj_param1", aq.isEmpty(this.kFi.mRecomWeight) ? "0" : this.kFi.mRecomWeight);
            anVar.cp("extra", aq.isEmpty(this.kFi.mRecomExtra) ? "0" : this.kFi.mRecomExtra);
            anVar.cp("obj_id", this.cKN);
            anVar.cp(TiebaInitialize.Params.AB_TAG, aq.isEmpty(this.kFi.mRecomAbTag) ? "0" : this.kFi.mRecomAbTag);
            anVar.cp("obj_source", aq.isEmpty(this.kFi.mRecomSource) ? "0" : this.kFi.mRecomSource);
            anVar.cp("obj_type", this.mFromPage);
            anVar.Z("is_vertical", 1);
            if (this.kFi.baijiahaoData != null) {
                anVar.cp("obj_param4", this.kFi.baijiahaoData.oriUgcNid);
                anVar.cp("obj_param6", this.kFi.baijiahaoData.oriUgcVid);
                if (this.kFi.baijiahaoData.oriUgcType == 4) {
                    anVar.Z("obj_param5", 2);
                } else if (this.kFi.baijiahaoData.oriUgcType == 2) {
                    anVar.Z("obj_param5", 3);
                }
            } else {
                anVar.Z("obj_param5", 1);
            }
            TiebaStatic.log(anVar);
        }
    }

    private void Kp(String str) {
        if (this.jsB != null && str != null && !str.equals(this.mVideoUrl)) {
            if (cwz()) {
                ((QuickVideoView) this.jsB).setRecoveryState(0);
            }
            this.jsB.setVideoPath(str, this.kFi.thread_id);
            this.mVideoUrl = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay() {
        if (TbadkCoreApplication.mSquareVideoCanPlayNotWifi || com.baidu.tieba.video.g.cNI().cNJ() || cRy()) {
            cwL();
            if (this.kFe != null) {
                this.kFe.setVisibility(8);
            }
            if (Build.VERSION.SDK_INT < 17 && this.kEQ.getVisibility() == 0) {
                this.kEQ.clearAnimation();
                this.kEQ.startAnimation(this.ejI);
            }
            if (this.jsB != null) {
                this.jsB.start();
                bti();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bti() {
        if (this.kFi != null) {
            y yVar = new y();
            yVar.mLocate = "nani_midpage";
            yVar.OG = this.kFi.thread_id;
            yVar.fKa = this.kFi.forum_id + "";
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.mSource = this.kFi.mRecomSource;
            yVar.jvJ = this.kFi.mRecomAbTag;
            yVar.jvK = this.kFi.mRecomWeight;
            yVar.jvL = "";
            yVar.cKN = "";
            yVar.jvN = this.kFi.mMd5;
            if (this.mRect != null) {
                yVar.jvO = "1";
            } else {
                yVar.jvO = "2";
            }
            if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                yVar.jvP = "1";
                yVar.mLocate = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                yVar.jvL = "index";
            }
            com.baidu.tieba.play.l.a(this.kFi.mMd5, "", "1", yVar);
        }
    }

    private void cwL() {
        if (com.baidu.adp.lib.util.j.isMobileNet()) {
            com.baidu.tieba.video.g.cNI().fy(getContext());
        }
    }

    private void pausePlay() {
        if (this.jsB != null) {
            this.jsB.pause();
        }
    }

    private void stopPlay() {
        if (this.jsB != null) {
            if (cwz()) {
                ((QuickVideoView) this.jsB).setRecoveryState(5);
            }
            this.jsB.stopPlayback();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cRu() {
        PbActivityConfig createNormalCfg = new PbActivityConfig(getActivity()).createNormalCfg(this.kFi.thread_id, this.kFi.post_id, "");
        createNormalCfg.setForumId(String.valueOf(this.kFi.forum_id));
        createNormalCfg.setForumName(this.kFi.forum_name);
        createNormalCfg.setVideo_source("nani_midpage");
        createNormalCfg.setJumpToCommentArea(true);
        createNormalCfg.setBjhData(this.kFi.baijiahaoData);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cRv() {
        if (this.cHd == null) {
            this.kFp = new com.baidu.tieba.view.a(getActivity());
            this.cHd = new e(getActivity(), this.kFp.aCF());
            this.cHd.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.14
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (!TbSingleton.getInstance().isNotchScreen(VideoPlayFragment.this.getActivity()) && !TbSingleton.getInstance().isCutoutScreen(VideoPlayFragment.this.getActivity())) {
                        VideoPlayFragment.this.jsB.getView().setSystemUiVisibility(4);
                    }
                }
            });
        }
        if (this.kFp != null) {
            ArrayList arrayList = new ArrayList();
            a.C0621a c0621a = new a.C0621a(this.kFp);
            c0621a.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.15
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    if (!bc.checkUpIsLogin(VideoPlayFragment.this.getContext())) {
                        VideoPlayFragment.this.cHd.dismiss();
                        return;
                    }
                    VideoPlayFragment.this.cHd.dismiss();
                    if (VideoPlayFragment.this.kFi != null) {
                        boolean z = VideoPlayFragment.this.kFi.post_id != null && VideoPlayFragment.this.kFi.post_id.equals(VideoPlayFragment.this.kFi.mark_id);
                        MarkData markData = new MarkData();
                        Date date = new Date();
                        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
                        markData.setThreadId(VideoPlayFragment.this.kFi.thread_id);
                        markData.setPostId(VideoPlayFragment.this.kFi.post_id);
                        markData.setTime(date.getTime());
                        markData.setHostMode(false);
                        markData.setId(VideoPlayFragment.this.kFi.thread_id);
                        markData.setForumId(VideoPlayFragment.this.kFi.forum_id);
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
            if (this.kFi != null && this.kFi.post_id != null && this.kFi.post_id.equals(this.kFi.mark_id)) {
                z = true;
            }
            if (z) {
                c0621a.setText(getResources().getString(R.string.remove_mark));
            } else {
                c0621a.setText(getResources().getString(R.string.mark));
            }
            if (this.kFi != null && !this.kFi.isBjhVideo) {
                arrayList.add(c0621a);
            }
            a.C0621a c0621a2 = new a.C0621a(getActivity().getString(R.string.delete), this.kFp);
            c0621a2.a(new a.c() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.16
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    VideoPlayFragment.this.cHd.dismiss();
                    if (bc.checkUpIsLogin(VideoPlayFragment.this.getActivity()) && VideoPlayFragment.this.kFi != null) {
                        String str = VideoPlayFragment.this.kFi.thread_id;
                        String str2 = VideoPlayFragment.this.kFi.forum_id;
                        String string = VideoPlayFragment.this.getResources().getString(R.string.web_view_report_title);
                        String str3 = "http://tieba.baidu.com/mo/q/postreport?fid=" + str2 + "&tid=" + str + "&pid=" + VideoPlayFragment.this.kFi.post_id;
                        if (VideoPlayFragment.this.kFi.isBjhVideo) {
                            str3 = String.format(TbConfig.URL_BJH_REPORT, str, VideoPlayFragment.this.kFi.post_id) + "&channelid=33840";
                            string = "";
                        }
                        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(VideoPlayFragment.this.getPageContext().getPageActivity(), string, str3, true);
                        if (VideoPlayFragment.this.kFi.isBjhVideo) {
                            tbWebViewActivityConfig.setFixTitle(true);
                        }
                        VideoPlayFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
                    }
                }
            });
            c0621a2.setText(getResources().getString(R.string.report_text));
            arrayList.add(c0621a2);
            if (this.eHK) {
                a.C0621a c0621a3 = new a.C0621a(getActivity().getString(R.string.delete), this.kFp);
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
                                if (VideoPlayFragment.this.kFi != null) {
                                    VideoPlayFragment.this.fHZ.a(VideoPlayFragment.this.kFi.forum_id, VideoPlayFragment.this.kFi.forum_name, VideoPlayFragment.this.kFi.thread_id, VideoPlayFragment.this.kFi.post_id, 0, 0, VideoPlayFragment.this.eHK, null);
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
            this.kFp.az(arrayList);
        }
        this.cHd.show();
    }

    private void cRw() {
        if (this.kFi != null) {
            this.kEQ.startLoad(this.kFi.thumbnail_url, 10, false);
            Matcher matcher = Pattern.compile("^我发表了?一(篇|个)视频贴(，|,).+$").matcher(this.kFi.title);
            if (StringUtils.isNull(this.kFi.title) || matcher.matches()) {
                this.kEZ.setVisibility(8);
            } else {
                this.kEZ.setVisibility(0);
                this.kEZ.setTextSize(l.getDimens(getContext(), R.dimen.tbfontsize40));
                this.kEZ.setTextColor(R.color.cp_cont_a);
                this.kEZ.setLineSpacingExtra(l.getDimens(getContext(), R.dimen.tbds14));
                this.kEZ.setExpandable(true);
                this.kEZ.setOnStatusChangedListener(new ExpandableTextView.a() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.18
                    @Override // com.baidu.tieba.view.expandable.ExpandableTextView.a
                    public void mk(boolean z) {
                        VideoPlayFragment.this.kFi.isTitleExpanded = z;
                    }
                });
                this.kEZ.setData(this.kFi.title, this.kFi.isTitleExpanded);
            }
            this.kFb.setText(aq.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.kFi.comment_num, 0L)));
            this.kFc.setText(aq.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.kFi.agree_num, 0L)));
            this.kFd.setText(aq.numFormatOverWan(com.baidu.adp.lib.f.b.toLong(this.kFi.share_num, 0L)));
            if (this.kFi.author_info != null) {
                if (!TextUtils.isEmpty(this.kFi.author_info.bjhAvatar)) {
                    this.kES.startLoad(this.kFi.author_info.bjhAvatar, 12, false);
                } else if (!StringUtils.isNull(this.kFi.author_info.portrait) && this.kFi.author_info.portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.kES.startLoad(this.kFi.author_info.portrait, 10, false);
                } else {
                    this.kES.startLoad(this.kFi.author_info.portrait, 12, false);
                }
                if (StringUtils.isNull(this.kFi.author_info.cNE())) {
                    this.kFl.setVisibility(8);
                } else {
                    this.kFl.setVisibility(0);
                    this.kFl.setText("@" + this.kFi.author_info.cNE());
                }
            }
            if ("1".equals(this.kFi.is_private) && this.kFj.getVisibility() != 0) {
                this.kFh.setVisibility(0);
            } else {
                this.kFh.setVisibility(8);
            }
            if ("1".equals(this.kFi.is_agreed)) {
                am.setImageResource(this.kFk, R.drawable.icon_card_like_white_full_s);
            } else {
                am.setImageResource(this.kFk, R.drawable.btn_video_agree);
            }
            if (this.kFi.act_info != null && !StringUtils.isNull(this.kFi.act_info.activity_name) && this.kFj.getVisibility() != 0) {
                this.kFg.setVisibility(0);
                this.kFa.setText(this.kFi.act_info.activity_name);
            } else {
                this.kFg.setVisibility(8);
            }
            cRx();
            if (this.kFi.isBjhVideo) {
                this.kER.setVisibility(8);
            } else {
                this.kER.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cRx() {
        if (this.eHK || (this.kFi.author_info != null && !"0".equals(this.kFi.author_info.is_follow))) {
            this.kEW.setVisibility(4);
            this.kEW.setClickable(false);
            return;
        }
        this.kEW.setVisibility(0);
        this.kEW.setClickable(true);
    }

    private void brF() {
        if (getActivity() != null) {
            if (this.kFw == null || !this.kFw.isShowing()) {
                this.kFw = new com.baidu.tbadk.core.dialog.a(getActivity());
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
                this.kFw.aO(inflate);
                this.kFw.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.20
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        TbadkCoreApplication.mSquareVideoCanPlayNotWifi = true;
                        VideoPlayFragment.this.startPlay();
                    }
                });
                this.kFw.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.21
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                    }
                });
                this.kFw.jI(1);
                this.kFw.jG(R.color.cp_cont_b);
                this.kFw.fz(true);
                this.kFw.b(getPageContext());
                this.kFw.aCp();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cRy() {
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable() || com.baidu.adp.lib.util.j.isWifiNet()) {
            return true;
        }
        if (!this.mIsVisible || com.baidu.tieba.video.g.cNI().cNJ()) {
            return false;
        }
        if (this.kFe != null) {
            this.kFe.setVisibility(0);
        }
        pausePlay();
        brF();
        return false;
    }

    private void ahK() {
        if ((TbadkCoreApplication.mSquareVideoCanPlayNotWifi || cRy() || com.baidu.tieba.video.g.cNI().cNJ()) && this.jsB != null && this.kFe != null) {
            if (this.jsB.getParent() == null) {
                cRC();
                cRD();
            }
            this.jsB.b(null);
            this.kFe.setVisibility(8);
            cwL();
            if (this.jtN != null) {
                this.jtN.onStart();
            }
        }
    }

    protected Animation getScaleAnimation() {
        if (this.kFq == null) {
            this.kFq = AnimationUtils.loadAnimation(getContext(), R.anim.scale_zoom_in_and_out_anim);
        }
        return this.kFq;
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0389a
    public void aSS() {
        if (this.jsB.isPlaying()) {
            this.jsB.pause();
            this.kFe.setVisibility(0);
        } else if (TbadkCoreApplication.mSquareVideoCanPlayNotWifi || cRy() || com.baidu.tieba.video.g.cNI().cNJ()) {
            this.jsB.start();
            this.kFe.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0389a
    public void u(float f, float f2) {
        if (bc.checkUpIsLogin(getActivity()) && !this.kFr) {
            cRz();
            if (this.kFi != null && "0".equals(this.kFi.is_agreed)) {
                DJ(this.kEP);
            }
        }
    }

    private void cRz() {
        if (this.mRootView != null) {
            this.kFr = true;
            final ImageView imageView = new ImageView(this.mRootView.getContext());
            imageView.setImageResource(R.drawable.icon_video_like);
            if (this.kFt == null) {
                this.kFt = new RelativeLayout.LayoutParams(-2, -2);
                this.kFt.addRule(13);
            }
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(imageView, this.kFt);
            }
            if (this.kFs == null) {
                this.kFs = new AnimatorSet();
                this.kFs.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.videoplay.VideoPlayFragment.22
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        VideoPlayFragment.this.kFr = false;
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
            this.kFs.setTarget(imageView);
            this.kFs.playSequentially(ofPropertyValuesHolder, ofPropertyValuesHolder2);
            this.kFs.start();
        }
    }

    @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0389a
    public void aST() {
        if (this.kFi != null && this.kFi.author_info != null) {
            long j = com.baidu.adp.lib.f.b.toLong(this.kFi.author_info.user_id, 0L);
            long j2 = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
            boolean z = j == j2;
            if (j == 0 && j2 == 0) {
                z = false;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(getActivity()).createNormalConfig(j, z, false)));
        }
    }

    public List<String> getMediaIDs() {
        if (cwz()) {
            return ((QuickVideoView) this.jsB).getMediaIDs();
        }
        return null;
    }

    public String cRA() {
        if (cwz()) {
            return ((QuickVideoView) this.jsB).getMediaId();
        }
        return null;
    }

    public boolean cRB() {
        if (this.kFv == null || this.kFv.aLV() == null || !this.kFv.aLV().isVisible()) {
            return false;
        }
        this.kFv.aLV().hide();
        this.kFm.setVisibility(0);
        if ((this.kFv.aLV().lX(28) instanceof c) && ((c) this.kFv.aLV().lX(28)).getInputView() != null && ((c) this.kFv.aLV().lX(28)).getInputView().getText() != null) {
            this.kFn.setText(StringUtils.isNull(((c) this.kFv.aLV().lX(28)).getInputView().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
        }
        return true;
    }

    public void c(int i, int i2, Intent intent) {
        if (this.kFv != null) {
            this.kFv.onActivityResult(i, i2, intent);
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
        if (this.kFv != null && this.kFv.aLV() != null) {
            this.kFv.aLV().onChangeSkinType(i);
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

    public void cRC() {
        if (this.jsB != null && this.jsB.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            ((ViewGroup) this.mRootView).addView(this.jsB.getView(), 0);
            this.jsB.getView().setLayoutParams(layoutParams);
            this.jsB.setPageTypeForPerfStat("v_mid_page");
            if (cwz()) {
                ((QuickVideoView) this.jsB).setPlayerReuseEnable(true);
                ((QuickVideoView) this.jsB).setNeedRecovery(true);
            }
            if (this.kFi != null) {
                y yVar = new y();
                yVar.mUid = TbadkCoreApplication.getCurrentAccount();
                yVar.OG = this.kFi.thread_id;
                yVar.fKa = this.kFi.forum_id;
                yVar.jvN = this.kFi.mMd5;
                yVar.cKN = "";
                yVar.mSource = this.kFi.mRecomSource;
                yVar.mAbTag = this.kFi.mRecomAbTag;
                yVar.jvM = 1;
                if (this.kFi.baijiahaoData != null) {
                    if (this.kFi.baijiahaoData.oriUgcType == 2) {
                        yVar.jvM = 3;
                    } else if (this.kFi.baijiahaoData.oriUgcType == 4) {
                        yVar.jvM = 2;
                    }
                }
                yVar.jvK = this.kFi.mRecomWeight;
                if (this.mRect != null) {
                    yVar.jvO = "1";
                } else {
                    yVar.jvO = "2";
                }
                if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
                    yVar.jvP = "1";
                    yVar.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                    yVar.jvL = this.mFromPage;
                    yVar.cKN = this.cKN;
                    yVar.jvJ = this.kFi.mRecomWeight;
                } else {
                    yVar.mLocate = "14";
                }
                this.egU.setVideoStatsData(yVar);
            }
            this.jsB.setContinuePlayEnable(true);
            this.jsB.setBusiness(this.egU);
        }
    }

    private void cRD() {
        if (Build.VERSION.SDK_INT >= 17) {
            this.jsB.setOnPreparedListener(this.kFz);
        }
        this.jsB.setOnCompletionListener(this.kFy);
        this.jsB.setOnOutInfoListener(this.kFx);
    }
}
