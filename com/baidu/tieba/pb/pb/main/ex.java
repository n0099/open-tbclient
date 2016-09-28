package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Parcelable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.adp.widget.FloatingLayout;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EcommPersonManagerActivityConfig;
import com.baidu.tbadk.core.data.DealInfoData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.UserLikeButton;
import com.baidu.tbadk.core.view.y;
import com.baidu.tbadk.data.GodUserData;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.editortools.sendtool.SendView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.f;
import com.baidu.tieba.pb.view.PbInterviewStatusView;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.FrsPraiseView;
import com.baidu.tieba.tbadkCore.b.a;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class ex {
    public static int evW = 2;
    public static int evX = 3;
    public static int evY = 0;
    public static int evZ = 3;
    public static int ewa = 4;
    public static int ewb = 5;
    public static int ewc = 6;
    private com.baidu.tbadk.editortools.l EJ;
    private View aAA;
    private ViewStub aYH;
    private TbImageView aYI;
    private boolean aeb;
    private y.b agD;
    private TextView aqq;
    private BdTypeListView bCe;
    private View bJw;
    private View.OnClickListener bRx;
    private NoNetworkView bmi;
    private RelativeLayout dZP;
    private com.baidu.tieba.pb.a.d emU;
    private View.OnClickListener env;
    private PbActivity eow;
    PbActivity.c epM;
    private ImageView euA;
    private UserIconBox euB;
    private UserIconBox euC;
    private ImageView euD;
    private TextView euE;
    private TextView euF;
    private TextView euG;
    private TextView euK;
    private UserLikeButton euN;
    private LinearLayout euO;
    private TextView euP;
    private TextView euQ;
    private View euS;
    private View euT;
    private ObservedChangeLinearLayout euW;
    private cj euX;
    public int eud;
    public final com.baidu.tieba.pb.pb.main.b.e eug;
    public com.baidu.tieba.pb.pb.main.b.c euh;
    private ViewStub eui;
    private ViewStub euj;
    private List<com.baidu.tieba.pb.pb.main.b.a> euk;
    private View eul;
    private LinearLayout eun;
    private com.baidu.tieba.pb.data.b euo;
    private g eup;
    private dd euq;
    private ColumnLayout eur;
    private ThreadSkinView eus;
    private TextView eut;
    private TextView euu;
    private FrameLayout euv;
    private HeadPendantView euw;
    private HeadImageView eux;
    private ImageView euy;
    private ImageView euz;
    private View evD;
    private TextView evE;
    private TextView evF;
    private ViewGroup evG;
    private TextView evH;
    private boolean evJ;
    private HeadImageView evK;
    private ImageView evL;
    private View evR;
    private TextView evS;
    private ViewStub evT;
    private PbInterviewStatusView evU;
    private PbListView evc;
    private View eve;
    private PbActivity.a ewA;
    private boolean ewC;
    private boolean ewD;
    private Runnable ewd;
    private Runnable ewe;
    private View ewn;
    private TextView ewo;
    private ClickableHeaderImageView ewp;
    private TbImageView ewq;
    private FrameLayout ewr;
    private TextView ews;
    private LinearLayout ewt;
    private boolean ewu;
    private f ewv;
    private Runnable ewx;
    private int eue = 0;
    private int euf = 0;
    private final Handler mHandler = new Handler();
    private View eum = null;
    private TextView euH = null;
    private TextView euI = null;
    private TextView euJ = null;
    public FrsPraiseView euL = null;
    private ClickableHeaderImageView esT = null;
    private ClickableHeaderImageView euM = null;
    private View euR = null;
    private View euU = null;
    private boolean euV = false;
    private com.baidu.tbadk.core.dialog.a euY = null;
    private com.baidu.tbadk.core.dialog.c bRr = null;
    private View euZ = null;
    private EditText eva = null;
    private com.baidu.tieba.pb.view.w evb = null;
    private com.baidu.tieba.pb.view.d evd = null;
    private c.b dfH = null;
    private TbRichTextView.e aJh = null;
    private NoNetworkView.a aRn = null;
    private Dialog evf = null;
    private View evg = null;
    private com.baidu.tbadk.core.dialog.a evh = null;
    private Dialog evi = null;
    private View evj = null;
    private int evk = 0;
    private RadioGroup Hu = null;
    private RadioButton evl = null;
    private RadioButton evm = null;
    private RadioButton evn = null;
    private Button evo = null;
    private Button evp = null;
    private TextView evq = null;
    private Dialog evr = null;
    private View evs = null;
    private LinearLayout evt = null;
    private CompoundButton.OnCheckedChangeListener evu = null;
    private TextView evv = null;
    private TextView evw = null;
    private String evx = null;
    private com.baidu.tbadk.core.dialog.c evy = null;
    private boolean evz = false;
    private boolean evA = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView evB = null;
    private boolean dyE = false;
    private Button evC = null;
    private boolean evI = true;
    private LinearLayout evM = null;
    private TextView evN = null;
    private TextView evO = null;
    private View aNs = null;
    private com.baidu.tbadk.core.view.a evP = null;
    private boolean enr = false;
    private boolean evQ = false;
    private boolean mIsFromCDN = true;
    private int evV = 0;
    private a.InterfaceC0077a ewf = new ey(this);
    private boolean ewg = false;
    private boolean ewh = false;
    private boolean ewi = false;
    private LinearLayout ewj = null;
    private TextView ewk = null;
    private int ewl = 0;
    private boolean ewm = false;
    private Handler eww = new Handler();
    private CustomMessageListener ewy = new fj(this, CmdConfigCustom.PB_SHOW_MULTIIAMGETOOL);
    private final View.OnClickListener ewz = new ft(this);
    private View.OnLongClickListener onLongClickListener = null;
    private boolean ewB = true;
    private boolean ewE = false;
    private boolean Uw = false;
    String userId = null;
    private final List<TbImageView> ewF = new ArrayList();
    private boolean enq = true;
    private boolean ewG = false;
    private Runnable cFO = new ga(this);

    public f aPD() {
        return this.ewv;
    }

    public NoNetworkView aPE() {
        return this.bmi;
    }

    public boolean isFullScreen() {
        return this.ewh;
    }

    public void aPF() {
        if (this.EJ != null) {
            this.EJ.hide();
        }
    }

    public void aPG() {
        reset();
        this.evI = true;
        if (this.EJ != null) {
            this.EJ.hide();
        }
        if (this.evD != null) {
            if (this.dyE && !aQJ()) {
                gF(false);
            } else {
                gG(false);
            }
        }
        aOq();
    }

    private void reset() {
        if (this.eow != null && this.eow.aNg() != null && this.EJ != null) {
            com.baidu.tbadk.editortools.e.b.Dh().setStatus(0);
            com.baidu.tbadk.editortools.e.e aNg = this.eow.aNg();
            aNg.DF();
            if (aNg.getWriteImagesInfo() != null) {
                aNg.getWriteImagesInfo().setMaxImagesAllowed(10);
            }
            aNg.eH(10);
            aNg.eF(SendView.ALL);
            aNg.eG(SendView.ALL);
            aNg.fE(this.eow.getActivity().getString(r.j.pb_reply_hint));
            com.baidu.tbadk.editortools.s ew = this.EJ.ew(23);
            com.baidu.tbadk.editortools.s ew2 = this.EJ.ew(2);
            com.baidu.tbadk.editortools.s ew3 = this.EJ.ew(5);
            if (ew2 != null) {
                ew2.lw();
            }
            if (ew3 != null) {
                ew3.lw();
            }
            if (ew != null) {
                ew.hide();
            }
            this.EJ.invalidate();
        }
    }

    public boolean aPH() {
        return this.evI;
    }

    public void gF(boolean z) {
        if (this.evD != null && this.evE != null && this.evF != null) {
            this.evE.setText(r.j.draft_to_send);
            this.evF.setVisibility(8);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.evD.startAnimation(alphaAnimation);
            }
            this.evD.setVisibility(0);
        }
    }

    public void gG(boolean z) {
        if (this.evD != null && this.evE != null && this.evF != null) {
            this.evE.setText(r.j.reply_floor_host);
            this.evF.setVisibility(0);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.evD.startAnimation(alphaAnimation);
            }
            this.evD.setVisibility(0);
        }
    }

    public com.baidu.tieba.tbadkCore.data.q aPI() {
        int i;
        View childAt;
        int i2 = 0;
        if (this.bCe == null) {
            return null;
        }
        int firstVisiblePosition = this.bCe.getFirstVisiblePosition();
        int lastVisiblePosition = this.bCe.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.bCe.getChildCount();
            int i3 = 0;
            for (int i4 = firstVisiblePosition; i4 <= lastVisiblePosition; i4++) {
                if (i4 - firstVisiblePosition < childCount && (childAt = this.bCe.getChildAt(i4 - firstVisiblePosition)) != null) {
                    childAt.getGlobalVisibleRect(rect);
                    iArr[i4 - firstVisiblePosition] = rect.height();
                }
                i3 += iArr[i4 - firstVisiblePosition];
            }
            int i5 = i3 / 2;
            int i6 = 0;
            for (int i7 = 0; i7 < iArr.length; i7++) {
                i6 += iArr[i7];
                if (i6 > i5) {
                    i = i7 + firstVisiblePosition;
                    break;
                }
            }
        }
        i = firstVisiblePosition;
        int headerViewsCount = i - this.bCe.getHeaderViewsCount();
        if (headerViewsCount < 0) {
            headerViewsCount = 0;
        }
        if (this.euX.oo(headerViewsCount) != null && this.euX.oo(headerViewsCount) != com.baidu.tieba.tbadkCore.data.q.fvf) {
            i2 = headerViewsCount + 1;
        }
        return (com.baidu.tieba.tbadkCore.data.q) this.euX.aJ(i2);
    }

    public ex(PbActivity pbActivity, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.d dVar) {
        this.eow = null;
        this.dZP = null;
        this.bJw = null;
        this.bCe = null;
        this.eul = null;
        this.eun = null;
        this.eur = null;
        this.eut = null;
        this.euu = null;
        this.euv = null;
        this.euw = null;
        this.eux = null;
        this.euy = null;
        this.euz = null;
        this.euA = null;
        this.euB = null;
        this.euC = null;
        this.euD = null;
        this.euE = null;
        this.euF = null;
        this.euG = null;
        this.euK = null;
        this.euN = null;
        this.euS = null;
        this.euT = null;
        this.euX = null;
        this.evc = null;
        this.aAA = null;
        this.bRx = null;
        this.env = null;
        this.evD = null;
        this.evE = null;
        this.evG = null;
        this.evH = null;
        this.evK = null;
        this.evL = null;
        this.evR = null;
        this.evS = null;
        this.evT = null;
        this.eow = pbActivity;
        this.bRx = onClickListener;
        this.emU = dVar;
        this.dZP = (RelativeLayout) LayoutInflater.from(this.eow.getPageContext().getPageActivity()).inflate(r.h.new_pb_activity, (ViewGroup) null);
        this.eow.addContentView(this.dZP, new FrameLayout.LayoutParams(-1, -1));
        this.bJw = this.eow.findViewById(r.g.statebar_view);
        this.euW = (ObservedChangeLinearLayout) this.eow.findViewById(r.g.title_wrapper);
        this.bmi = (NoNetworkView) this.eow.findViewById(r.g.view_no_network);
        this.bCe = (BdTypeListView) this.eow.findViewById(r.g.new_pb_list);
        this.aqq = new TextView(this.eow.getActivity());
        this.aqq.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.e(this.eow.getActivity(), r.e.ds98)));
        this.bCe.f(this.aqq, 0);
        View view = new View(this.eow.getPageContext().getPageActivity());
        view.setLayoutParams(new AbsListView.LayoutParams(-1, this.eow.getResources().getDimensionPixelSize(r.e.ds100)));
        view.setVisibility(4);
        this.bCe.addFooterView(view);
        this.bCe.setOnTouchListener(this.eow.aJD);
        this.eug = new com.baidu.tieba.pb.pb.main.b.e(pbActivity);
        if (this.eow.aNE()) {
            this.eui = (ViewStub) this.eow.findViewById(r.g.manga_view_stub);
            this.eui.setVisibility(0);
            this.euh = new com.baidu.tieba.pb.pb.main.b.c(pbActivity);
            this.euh.show();
            this.eug.mNavigationBar.setVisibility(8);
        }
        this.eug.aQN().setOnTouchListener(new com.baidu.tieba.pb.a.a(new gb(this)));
        this.evD = this.eow.findViewById(r.g.pb_editor_tool_comment);
        this.evE = (TextView) this.eow.findViewById(r.g.pb_editor_tool_comment_reply_text);
        this.evG = (ViewGroup) this.eow.findViewById(r.g.pb_editor_tool_comment_reply_layout);
        this.evH = (TextView) this.eow.findViewById(r.g.pb_editor_tool_comment_praise_icon);
        this.evK = (HeadImageView) this.eow.findViewById(r.g.pb_editor_tool_comment_avatar);
        aPQ();
        this.evL = (ImageView) this.eow.findViewById(r.g.pb_editor_tool_comment_share_icon);
        this.evL.setOnClickListener(this.bRx);
        boolean ak = com.baidu.tieba.graffiti.d.ak(this.evH);
        if (ak) {
            iz(ak);
            this.evH.setVisibility(0);
        }
        this.evF = (TextView) this.eow.findViewById(r.g.pb_editor_tool_comment_reply_count_text);
        this.euq = new dd(this.eow, this.dZP);
        this.euq.init();
        this.euq.a(this.euq.aOr(), this.bRx);
        this.evG.setOnClickListener(new gc(this));
        this.evH.setOnClickListener(this.bRx);
        this.evH.setOnTouchListener(this.eow);
        this.eul = LayoutInflater.from(this.eow.getPageContext().getPageActivity()).inflate(r.h.new_pb_header_item, (ViewGroup) null);
        this.eun = (LinearLayout) LayoutInflater.from(this.eow.getPageContext().getPageActivity()).inflate(r.h.new_pb_header_user_item, (ViewGroup) null);
        this.euo = new com.baidu.tieba.pb.data.b(0);
        this.euo.elH = this.eow;
        this.euo.aMe();
        this.euo = new com.baidu.tieba.pb.data.b(0);
        this.euo.elH = this.eow;
        this.euo.aMe();
        this.eup = new g(this.eow, this.eun);
        this.eup.init();
        this.eup.a(this.eup.aNf(), this.bRx);
        this.eur = (ColumnLayout) this.eun.findViewById(r.g.pb_head_owner_root);
        this.eus = (ThreadSkinView) this.eun.findViewById(r.g.pb_thread_skin);
        this.eur.setOnLongClickListener(this.onLongClickListener);
        this.eur.setOnTouchListener(this.emU);
        this.eur.setVisibility(8);
        this.eul.setOnTouchListener(this.emU);
        this.eut = (TextView) this.eul.findViewById(r.g.pb_head_post_title);
        this.eut.setTextSize(TbConfig.getContentSizeOfPostTitle());
        this.eut.setVisibility(8);
        this.evR = this.eul.findViewById(r.g.pb_head_activity_join_number_container);
        this.evR.setVisibility(8);
        this.evS = (TextView) this.eul.findViewById(r.g.pb_head_activity_join_number);
        this.euu = (TextView) this.eur.findViewById(r.g.pb_head_owner_info_user_name);
        this.euv = (FrameLayout) this.eur.findViewById(r.g.pb_head_headImage_container);
        this.eux = (HeadImageView) this.eur.findViewById(r.g.pb_head_owner_photo);
        this.euw = (HeadPendantView) this.eur.findViewById(r.g.pb_pendant_head_owner_photo);
        this.aYH = (ViewStub) this.eur.findViewById(r.g.viewstub_headimage_mask);
        if (!this.enq) {
            this.eux.setVisibility(8);
        }
        this.euw.wk();
        if (this.euw.getHeadView() != null) {
            this.euw.getHeadView().setIsRound(true);
            this.euw.getHeadView().setDrawBorder(false);
        }
        if (this.euw.getPendantView() != null) {
            this.euw.getPendantView().setIsRound(true);
            this.euw.getPendantView().setDrawBorder(false);
        }
        this.euy = (ImageView) this.eur.findViewById(r.g.pb_head_owner_info_user_rank);
        this.euz = (ImageView) this.eur.findViewById(r.g.pb_head_owner_info_user_gender);
        this.euA = (ImageView) this.eur.findViewById(r.g.pb_head_owner_info_user_bawu);
        this.euB = (UserIconBox) this.eur.findViewById(r.g.pb_head_owner_info_user_icon);
        this.euC = (UserIconBox) this.eur.findViewById(r.g.pb_head_owner_info_tshow_icon);
        this.euD = (ImageView) this.eur.findViewById(r.g.pb_head_owner_info_floor_owner);
        this.euF = (TextView) this.eur.findViewById(r.g.pb_head_owner_info_floor);
        this.euE = (TextView) this.eur.findViewById(r.g.pb_head_owner_info_time);
        this.euG = (TextView) this.eul.findViewById(r.g.pb_head_read_button);
        this.euG.setOnClickListener(this.bRx);
        this.euK = (TextView) this.eul.findViewById(r.g.pb_head_reverse_hint);
        this.euK.setOnClickListener(this.bRx);
        this.euK.setVisibility(8);
        this.euN = (UserLikeButton) this.eur.findViewById(r.g.pb_like_button);
        this.euS = this.eul.findViewById(r.g.new_pb_header_item_line_above_livepost);
        this.euT = this.eul.findViewById(r.g.new_pb_header_item_line_below_livepost);
        this.eul.setOnLongClickListener(new gd(this));
        aPT();
        this.evT = (ViewStub) this.dZP.findViewById(r.g.interview_status_stub);
        this.euX = new cj(this.eow, this.bCe);
        this.euX.G(this.bRx);
        this.euX.a(this.emU);
        this.euX.setOnImageClickListener(this.aJh);
        this.env = new ge(this);
        this.euX.F(this.env);
        this.bCe.addHeaderView(this.eun);
        this.bCe.addHeaderView(this.eul);
        this.evc = new PbListView(this.eow.getPageContext().getPageActivity());
        this.aAA = this.evc.getView().findViewById(r.g.pb_more_view);
        if (this.aAA != null) {
            this.aAA.setOnClickListener(this.bRx);
            com.baidu.tbadk.core.util.av.k(this.aAA, r.f.pb_foot_more_trans_selector);
        }
        this.evc.wu();
        this.evc.df(r.f.pb_foot_more_trans_selector);
        this.evc.dg(r.f.pb_foot_more_trans_selector);
        this.eve = this.eow.findViewById(r.g.viewstub_progress);
        this.eow.registerListener(this.ewy);
        this.euN.i(this.eow.getUniqueId());
    }

    public void aPJ() {
        if (this.bCe != null) {
            this.bCe.removeHeaderView(this.eun);
            this.bCe.removeHeaderView(this.eul);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPK() {
        if (this.eow.aNE()) {
            this.euj = (ViewStub) this.eow.findViewById(r.g.manga_mention_controller_view_stub);
            this.euj.setVisibility(0);
            if (this.euO == null) {
                this.euO = (LinearLayout) this.eow.findViewById(r.g.manga_controller_layout);
                com.baidu.tbadk.i.a.a(this.eow.getPageContext(), this.euO);
            }
            if (this.euP == null) {
                this.euP = (TextView) this.euO.findViewById(r.g.manga_prev_btn);
            }
            if (this.euQ == null) {
                this.euQ = (TextView) this.euO.findViewById(r.g.manga_next_btn);
            }
            this.euP.setOnClickListener(this.bRx);
            this.euQ.setOnClickListener(this.bRx);
        }
    }

    private void aPL() {
        if (this.eow.aNE()) {
            if (this.eow.aNH() == -1) {
                com.baidu.tbadk.core.util.av.c(this.euP, r.d.cp_cont_e, 1);
            }
            if (this.eow.aNI() == -1) {
                com.baidu.tbadk.core.util.av.c(this.euQ, r.d.cp_cont_e, 1);
            }
        }
    }

    public void aPM() {
        if (this.euO == null) {
            aPK();
        }
        this.euj.setVisibility(8);
        if (this.eww != null && this.ewx != null) {
            this.eww.removeCallbacks(this.ewx);
        }
    }

    private void a(DealInfoData dealInfoData, boolean z) {
        if (this.ewg) {
            View findViewWithTag = this.eun.findViewWithTag("pb_god_bottom_line_view_tag");
            if (findViewWithTag != null) {
                this.eun.removeView(findViewWithTag);
            }
            this.euI.setPadding(this.euI.getPaddingLeft(), this.euI.getCompoundPaddingTop(), this.euI.getPaddingRight(), this.eow.getResources().getDimensionPixelSize(r.e.ds10));
            this.eur.setPadding(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds30), TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds20), TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds32), 0);
        } else {
            this.euF.setVisibility(8);
            this.eur.setPadding(this.eow.getResources().getDimensionPixelSize(r.e.ds30), this.eow.getResources().getDimensionPixelSize(r.e.ds18), this.eow.getResources().getDimensionPixelSize(r.e.ds30), this.eow.getResources().getDimensionPixelSize(r.e.ds10));
            ((FloatingLayout) this.eun.findViewById(r.g.pb_head_owner_info_root)).setPadding(0, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds16), 0, 0);
        }
        this.bCe.setOverScrollMode(2);
        this.evD.setPadding(this.evD.getPaddingLeft(), 0, 0, 0);
        com.baidu.tbadk.core.util.av.k(this.evD, r.f.pb_ecomm_comment_bg);
        this.evG.setBackgroundResource(0);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.evG.getLayoutParams();
        marginLayoutParams.rightMargin = this.eow.getResources().getDimensionPixelSize(r.e.ds234);
        this.evG.setLayoutParams(marginLayoutParams);
        TextView textView = (TextView) this.eow.findViewById(r.g.pb_editor_tool_comment_ecomm_buy_layout);
        textView.setVisibility(0);
        View findViewById = this.dZP.findViewById(r.g.pb_editor_tool_comment_layout);
        boolean appResponseToIntentClass = TbadkCoreApplication.m9getInst().appResponseToIntentClass(EcommPersonManagerActivityConfig.class);
        if (z || !appResponseToIntentClass) {
            textView.setVisibility(8);
        } else if (dealInfoData.status != 1) {
            textView.setText(r.j.pb_ecomm_status_off_shelf_text);
            com.baidu.tbadk.core.util.av.l(textView, r.d.cp_other_e_alpha30);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
        } else if (dealInfoData.stock == 0) {
            textView.setText(r.j.pb_ecomm_buy_button_none_text);
            com.baidu.tbadk.core.util.av.l(textView, r.d.cp_other_e_alpha30);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
        } else {
            textView.setText(r.j.pb_ecomm_buy_button_text);
            com.baidu.tbadk.core.util.av.l(textView, r.d.cp_other_e);
            if (this.bRx != null) {
                textView.setOnClickListener(this.bRx);
            }
        }
    }

    public void aPN() {
        if (this.eww != null) {
            if (this.ewx != null) {
                this.eww.removeCallbacks(this.ewx);
            }
            this.ewx = new ez(this);
            this.eww.postDelayed(this.ewx, 2000L);
        }
    }

    public void is(boolean z) {
        this.eug.is(z);
        if (z && this.evQ) {
            this.evc.setText(this.eow.getResources().getString(r.j.click_load_more));
            this.bCe.setNextPage(this.evc);
            this.euf = 2;
        }
    }

    public void aPO() {
        TbadkCoreApplication.m9getInst().setReadThreadPlayerScreenMaxHeight(this.dZP.getHeight());
    }

    public void setEditorTools(com.baidu.tbadk.editortools.l lVar) {
        this.EJ = lVar;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.dZP.addView(this.EJ, layoutParams);
        this.EJ.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        this.EJ.hide();
    }

    public void aPP() {
        if (this.eow != null && this.EJ != null) {
            this.EJ.lw();
        }
    }

    public void pm(String str) {
        if (this.evF != null) {
            if (TextUtils.isEmpty(str)) {
                str = "0";
            }
            this.evF.setText(this.eow.getPageContext().getResources().getString(r.j.pb_reply_count_text, str));
        }
    }

    private void aPQ() {
        if (this.evK != null) {
            this.evK.setIsRound(true);
            this.evK.setDrawBorder(false);
            this.evK.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
            if (!StringUtils.isNull(currentPortrait)) {
                String dm = com.baidu.tbadk.core.util.q.dm(currentPortrait);
                this.evK.setUrl(dm);
                this.evK.c(dm, 12, false);
            }
        }
    }

    public void N(String str, boolean z) {
        this.evJ = z;
        it(TbadkCoreApplication.m9getInst().getSkinType() == 1);
    }

    private void it(boolean z) {
        if (this.evH != null) {
            if (this.evJ) {
                com.baidu.tbadk.core.util.av.k(this.evH, r.f.pb_praise_already_click_selector);
                this.evH.setContentDescription(this.eow.getResources().getString(r.j.cancel_praise));
                return;
            }
            com.baidu.tbadk.core.util.av.k(this.evH, r.f.pb_praise_normal_click_selector);
            this.evH.setContentDescription(this.eow.getResources().getString(r.j.frs_item_praise_text));
        }
    }

    public TextView aPR() {
        return this.evH;
    }

    public void iu(boolean z) {
        if (this.bCe != null) {
            if (!z) {
                this.bCe.setEnabled(z);
                return;
            }
            if (this.ewe == null) {
                this.ewe = new fa(this, z);
            }
            com.baidu.adp.lib.h.h.eG().postDelayed(this.ewe, 10L);
        }
    }

    public void iv(boolean z) {
        if (this.bCe != null && this.aqq != null && this.bJw != null) {
            if (z) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.bJw.setVisibility(0);
                    this.bCe.removeHeaderView(this.aqq);
                    this.bCe.f(this.aqq, 0);
                } else {
                    this.bJw.setVisibility(8);
                    this.bCe.removeHeaderView(this.aqq);
                }
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.aqq.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = UtilHelper.getLightStatusBarHeight();
                    this.aqq.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.aqq.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + iE(true);
                this.aqq.setLayoutParams(layoutParams2);
            }
            this.bCe.removeHeaderView(this.aqq);
            this.bCe.f(this.aqq, 0);
            aQI();
        }
    }

    public void aX(View view) {
        boolean z;
        View view2;
        if (this.euW != null && view != null) {
            if (this.evI) {
                z = this.evD.getVisibility() == 0;
            } else {
                z = this.EJ != null && this.EJ.getVisibility() == 0;
            }
            boolean z2 = this.euW.getVisibility() == 0;
            if (z2) {
                TiebaStatic.log("c10084");
                this.ewh = true;
                View findViewById = this.eow.findViewById(r.g.bg_above_list);
                if (findViewById != null && findViewById.getLayoutParams() != null) {
                    findViewById.getLayoutParams().height = this.euW.getHeight();
                    findViewById.setLayoutParams(findViewById.getLayoutParams());
                }
                com.baidu.tieba.tbadkCore.a.a(this.eow, this.euW, r.a.top_fold_up, new fb(this, findViewById));
            } else {
                this.ewh = false;
                com.baidu.tieba.tbadkCore.a.a(this.eow, this.euW, r.a.top_fold_down, new fc(this));
            }
            if (this.evI) {
                view2 = this.evD;
            } else {
                view2 = this.EJ;
            }
            if (z) {
                if (z2) {
                    if (this.EJ != null) {
                        this.EJ.AV();
                    }
                    com.baidu.tieba.tbadkCore.a.a(this.eow, view2, r.a.bottom_fold_down, new fd(this));
                }
            } else if (!z2) {
                com.baidu.tieba.tbadkCore.a.a(this.eow, view2, r.a.bottom_fold_up, new fe(this));
            }
            aOq();
        }
    }

    public cj aPS() {
        return this.euX;
    }

    public void a(PbActivity.c cVar) {
        this.epM = cVar;
    }

    private void a(com.baidu.tbadk.core.data.bo boVar) {
        if (boVar == null || boVar.sZ() == 0) {
            if (this.evC != null) {
                this.evC.setVisibility(8);
            }
            if (this.euS != null) {
                this.euS.setVisibility(8);
                return;
            }
            return;
        }
        if (this.evC == null) {
            this.eow.getLayoutMode().x(((ViewStub) this.eul.findViewById(r.g.live_talk_layout)).inflate());
            this.evC = (Button) this.eul.findViewById(r.g.pb_head_function_manage_go_to_live_post);
            this.euS = this.eul.findViewById(r.g.new_pb_header_item_line_above_livepost);
        }
        int ta = boVar.ta();
        String string = this.eow.getPageContext().getString(r.j.go_to_live_post_prefix);
        if (ta == 0) {
            string = String.valueOf(string) + this.eow.getPageContext().getString(r.j.go_to_interview_post);
        } else if (ta == 1) {
            string = String.valueOf(string) + this.eow.getPageContext().getString(r.j.go_to_discuss_post);
        }
        this.evC.setText(string);
        this.evC.setVisibility(0);
        this.evC.setOnClickListener(this.bRx);
        this.ewD = true;
        aQg();
        aQj();
    }

    private void aPT() {
        this.evM = (LinearLayout) this.eul.findViewById(r.g.btn_show_passed_pb);
        this.evO = (TextView) this.eul.findViewById(r.g.show_pre_page_view);
        this.evN = (TextView) this.eul.findViewById(r.g.go_back_top_view);
        this.aNs = this.eul.findViewById(r.g.show_passed_divider);
        this.evO.setOnClickListener(this.ewz);
        this.evN.setOnClickListener(this.bRx);
        aQj();
    }

    public TextView aPU() {
        return this.euG;
    }

    public void iw(boolean z) {
        if (this.euG != null) {
            if (z && TbadkCoreApplication.m9getInst().isTTSCanUse() && !this.ewu) {
                this.euG.setVisibility(0);
                if (this.evM != null && this.evM.getVisibility() == 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.evM.getLayoutParams();
                    layoutParams.topMargin = com.baidu.adp.lib.util.k.e(this.eow.getApplicationContext(), r.e.ds10);
                    this.evM.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            this.euG.setVisibility(8);
        }
    }

    public void aY(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, boolean z) {
        SparseArray sparseArray2;
        if (this.evg == null) {
            this.evg = LayoutInflater.from(this.eow.getPageContext().getPageActivity()).inflate(r.h.forum_manage_dialog, (ViewGroup) null);
        }
        this.eow.getLayoutMode().x(this.evg);
        if (this.evf == null) {
            this.evf = new Dialog(this.eow.getPageContext().getPageActivity(), r.k.common_alert_dialog);
            this.evf.setCanceledOnTouchOutside(true);
            this.evf.setCancelable(true);
            this.evf.setContentView(this.evg);
            WindowManager.LayoutParams attributes = this.evf.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.k.K(this.eow.getPageContext().getPageActivity()) * 0.9d);
            this.evf.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.evf.findViewById(r.g.del_post_btn);
        TextView textView2 = (TextView) this.evf.findViewById(r.g.forbid_user_btn);
        TextView textView3 = (TextView) this.evf.findViewById(r.g.disable_reply_btn);
        int intValue = sparseArray.get(r.g.tag_check_mute_from) instanceof Integer ? ((Integer) sparseArray.get(r.g.tag_check_mute_from)).intValue() : -1;
        if ("".equals(sparseArray.get(r.g.tag_del_post_id)) || intValue == 2) {
            textView.setVisibility(8);
        } else {
            SparseArray sparseArray3 = (SparseArray) textView.getTag();
            if (sparseArray3 == null) {
                SparseArray sparseArray4 = new SparseArray();
                textView.setTag(sparseArray4);
                sparseArray2 = sparseArray4;
            } else {
                sparseArray2 = sparseArray3;
            }
            textView.setVisibility(0);
            if ((sparseArray.get(r.g.tag_del_post_type) instanceof Integer ? ((Integer) sparseArray.get(r.g.tag_del_post_type)).intValue() : -1) != 0) {
                textView.setText(r.j.delete);
            } else {
                textView.setText(r.j.delete_post);
            }
            sparseArray2.put(r.g.tag_del_post_id, sparseArray.get(r.g.tag_del_post_id));
            sparseArray2.put(r.g.tag_del_post_type, sparseArray.get(r.g.tag_del_post_type));
            sparseArray2.put(r.g.tag_del_post_is_self, sparseArray.get(r.g.tag_del_post_is_self));
            sparseArray2.put(r.g.tag_manage_user_identity, sparseArray.get(r.g.tag_manage_user_identity));
            textView.setOnClickListener(new ff(this));
        }
        if ("".equals(sparseArray.get(r.g.tag_forbid_user_name)) || aQF()) {
            textView2.setVisibility(8);
        } else {
            SparseArray sparseArray5 = (SparseArray) textView2.getTag();
            if (sparseArray5 == null) {
                sparseArray5 = new SparseArray();
                textView2.setTag(sparseArray5);
            }
            textView2.setVisibility(0);
            sparseArray5.put(r.g.tag_forbid_user_name, sparseArray.get(r.g.tag_forbid_user_name));
            sparseArray5.put(r.g.tag_manage_user_identity, sparseArray.get(r.g.tag_manage_user_identity));
            sparseArray5.put(r.g.tag_forbid_user_post_id, sparseArray.get(r.g.tag_forbid_user_post_id));
            textView2.setOnClickListener(new fg(this));
        }
        if (!((sparseArray.get(r.g.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(r.g.tag_user_mute_visible)).booleanValue())) {
            textView3.setVisibility(8);
        } else {
            SparseArray sparseArray6 = (SparseArray) textView3.getTag();
            if (sparseArray6 == null) {
                sparseArray6 = new SparseArray();
                textView3.setTag(sparseArray6);
            }
            textView3.setVisibility(0);
            if (z) {
                textView3.setText(r.j.un_mute);
            } else {
                textView3.setText(r.j.mute);
            }
            sparseArray6.put(r.g.tag_is_mem, sparseArray.get(r.g.tag_is_mem));
            sparseArray6.put(r.g.tag_user_mute_mute_userid, sparseArray.get(r.g.tag_user_mute_mute_userid));
            sparseArray6.put(r.g.tag_user_mute_mute_username, sparseArray.get(r.g.tag_user_mute_mute_username));
            sparseArray6.put(r.g.tag_user_mute_post_id, sparseArray.get(r.g.tag_user_mute_post_id));
            sparseArray6.put(r.g.tag_user_mute_thread_id, sparseArray.get(r.g.tag_user_mute_thread_id));
            sparseArray6.put(r.g.tag_user_mute_msg, sparseArray.get(r.g.tag_user_mute_msg));
            textView3.setOnClickListener(new fh(this, z));
        }
        com.baidu.adp.lib.h.j.a(this.evf, this.eow.getPageContext());
    }

    public void a(PbActivity.a aVar) {
        this.ewA = aVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(r.g.tag_del_post_id, str);
        sparseArray.put(r.g.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(r.g.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(r.g.tag_del_post_is_self, Boolean.valueOf(z));
        sparseArray.put(evY, Integer.valueOf(evZ));
        int i3 = r.j.del_post_confirm;
        if (i == 0) {
            i3 = r.j.del_thread_confirm;
        }
        this.evh = new com.baidu.tbadk.core.dialog.a(this.eow.getActivity());
        this.evh.bZ(i3);
        this.evh.A(sparseArray);
        this.evh.a(r.j.dialog_ok, this.eow);
        this.evh.b(r.j.dialog_cancel, new fi(this));
        this.evh.aq(true);
        this.evh.b(this.eow.getPageContext());
        this.evh.tm();
    }

    public void am(ArrayList<com.baidu.tbadk.core.data.ab> arrayList) {
        if (this.evs == null) {
            this.evs = LayoutInflater.from(this.eow.getPageContext().getPageActivity()).inflate(r.h.commit_good, (ViewGroup) null);
        }
        this.eow.getLayoutMode().x(this.evs);
        if (this.evr == null) {
            this.evr = new Dialog(this.eow.getPageContext().getPageActivity(), r.k.common_alert_dialog);
            this.evr.setCanceledOnTouchOutside(true);
            this.evr.setCancelable(true);
            this.evB = (ScrollView) this.evs.findViewById(r.g.good_scroll);
            this.evr.setContentView(this.evs);
            WindowManager.LayoutParams attributes = this.evr.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.k.e(this.eow.getPageContext().getPageActivity(), r.e.ds540);
            this.evr.getWindow().setAttributes(attributes);
            this.evu = new fk(this);
            this.evt = (LinearLayout) this.evs.findViewById(r.g.good_class_group);
            this.evw = (TextView) this.evs.findViewById(r.g.dialog_button_cancel);
            this.evw.setOnClickListener(new fl(this));
            this.evv = (TextView) this.evs.findViewById(r.g.dialog_button_ok);
            this.evv.setOnClickListener(this.bRx);
        }
        this.evt.removeAllViews();
        this.euk = new ArrayList();
        com.baidu.tieba.pb.pb.main.b.a bG = bG("0", this.eow.getPageContext().getString(r.j.def_good_class));
        this.euk.add(bG);
        bG.setChecked(true);
        this.evt.addView(bG);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.tieba.pb.pb.main.b.a bG2 = bG(String.valueOf(arrayList.get(i2).pZ()), arrayList.get(i2).pY());
                this.euk.add(bG2);
                View view = new View(this.eow.getPageContext().getPageActivity());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.e(this.eow.getPageContext().getPageActivity(), r.e.ds1));
                com.baidu.tbadk.core.util.av.l(view, r.d.cp_bg_line_a);
                view.setLayoutParams(layoutParams);
                this.evt.addView(view);
                this.evt.addView(bG2);
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.evB.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.k.dip2px(this.eow.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.k.dip2px(this.eow.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.k.dip2px(this.eow.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.evB.setLayoutParams(layoutParams2);
            this.evB.removeAllViews();
            this.evB.addView(this.evt);
        }
        com.baidu.adp.lib.h.j.a(this.evr, this.eow.getPageContext());
    }

    private com.baidu.tieba.pb.pb.main.b.a bG(String str, String str2) {
        Activity pageActivity = this.eow.getPageContext().getPageActivity();
        com.baidu.tieba.pb.pb.main.b.a aVar = new com.baidu.tieba.pb.pb.main.b.a(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.k.e(pageActivity, r.e.ds100));
        aVar.setOnCheckedChangeListener(this.evu);
        aVar.setTag(str);
        aVar.setText(str2);
        aVar.setLayoutParams(layoutParams);
        return aVar;
    }

    public void aPV() {
        this.eow.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.eow.hideProgressBar();
        if (z && z2) {
            this.eow.showToast(this.eow.getPageContext().getString(r.j.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.az.isEmpty(str)) {
                str = TbadkCoreApplication.m9getInst().getResources().getString(r.j.neterror);
            }
            this.eow.showToast(str);
        }
    }

    public void auC() {
        this.eve.setVisibility(0);
    }

    public void auB() {
        this.eve.setVisibility(8);
    }

    public View aPW() {
        if (this.evs != null) {
            return this.evs.findViewById(r.g.dialog_button_ok);
        }
        return null;
    }

    public String aPX() {
        return this.evx;
    }

    public View getView() {
        return this.dZP;
    }

    public void aPY() {
        com.baidu.adp.lib.util.k.b(this.eow.getPageContext().getPageActivity(), this.eow.getCurrentFocus());
    }

    public void ix(boolean z) {
        this.eow.hideProgressBar();
        aBc();
    }

    public void aPZ() {
        this.evc.wB();
    }

    public void aQa() {
    }

    public void aQb() {
        this.eow.hideProgressBar();
        this.evc.wC();
        aLg();
        this.bCe.l(2000L);
        aQj();
    }

    public void aQc() {
        this.bCe.l(2000L);
        this.evM.setVisibility(8);
        aQj();
    }

    public void iy(boolean z) {
        this.euq.f(this.euq.aOr(), z);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.evG.getLayoutParams();
        marginLayoutParams.rightMargin = z ? this.eow.getResources().getDimensionPixelSize(r.e.ds84) : 0;
        this.evG.setLayoutParams(marginLayoutParams);
    }

    private void iz(boolean z) {
        int i;
        int i2;
        int dimensionPixelSize = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds16);
        int dimensionPixelSize2 = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds16);
        int dimensionPixelSize3 = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds84);
        int dimensionPixelSize4 = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds14);
        if (z) {
            i = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds16);
            i2 = 0;
        } else {
            i = dimensionPixelSize;
            i2 = dimensionPixelSize3;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.evG.getLayoutParams();
        layoutParams.setMargins(i, dimensionPixelSize2, i2, dimensionPixelSize4);
        this.evG.setLayoutParams(layoutParams);
    }

    public void c(com.baidu.tbadk.core.data.ad adVar) {
        this.euq.c(adVar);
    }

    public boolean aOo() {
        return this.euq.aOo();
    }

    public void aOp() {
        this.euq.aOp();
    }

    public void aOq() {
        this.euq.aOq();
    }

    public ImageView aQd() {
        return this.evL;
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.euX.setOnLongClickListener(onLongClickListener);
    }

    public void a(c.b bVar, boolean z, boolean z2) {
        if (this.evy != null) {
            this.evy.dismiss();
            this.evy = null;
        }
        this.evy = new com.baidu.tbadk.core.dialog.c(this.eow.getPageContext().getPageActivity());
        this.evy.cc(r.j.operation);
        if (z2) {
            this.evy.a(new String[]{this.eow.getPageContext().getString(r.j.copy)}, bVar);
        } else if (!z) {
            this.evy.a(new String[]{this.eow.getPageContext().getString(r.j.copy), this.eow.getPageContext().getString(r.j.mark)}, bVar);
        } else {
            this.evy.a(new String[]{this.eow.getPageContext().getString(r.j.copy), this.eow.getPageContext().getString(r.j.remove_mark)}, bVar);
        }
        this.evy.d(this.eow.getPageContext());
        this.evy.tp();
    }

    public int aQe() {
        return oC(this.bCe.getFirstVisiblePosition());
    }

    private int oC(int i) {
        com.baidu.adp.widget.ListView.e eVar = (com.baidu.adp.widget.ListView.e) this.bCe.getAdapter();
        if (eVar != null) {
            if (i < eVar.getCount() && i >= 0 && (eVar.getItem(i) instanceof com.baidu.tieba.pb.data.f)) {
                i++;
            }
            int headerViewsCount = (eVar.getHeaderViewsCount() + eVar.kq()) - 1;
            if (i > headerViewsCount) {
                i = headerViewsCount;
            }
            int headersCount = (this.bCe.getAdapter() == null || !(this.bCe.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) ? 0 : ((com.baidu.adp.widget.ListView.e) this.bCe.getAdapter()).getHeadersCount();
            return i > headersCount ? i - headersCount : 0;
        }
        return i;
    }

    public int aQf() {
        return oC(this.bCe.getLastVisiblePosition());
    }

    public void setSelection(int i) {
        this.bCe.setSelection(i);
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.eva.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void j(com.baidu.tieba.pb.data.h hVar) {
        this.euX.b(hVar);
        this.euX.notifyDataSetChanged();
        if (hVar == null) {
            pm("");
        } else {
            pm(com.baidu.tbadk.core.util.az.z(hVar.aMs().rH()));
        }
        aQj();
    }

    public void k(com.baidu.tieba.pb.data.h hVar) {
        PraiseData rF;
        if (this.euL == null) {
            this.eow.getLayoutMode().x(((ViewStub) this.eul.findViewById(r.g.praise_layout)).inflate());
            this.euL = (FrsPraiseView) this.eul.findViewById(r.g.pb_head_praise_view);
            this.euL.setIsFromPb(true);
            this.euU = this.eul.findViewById(r.g.new_pb_header_item_line_above_praise);
            this.euL.dl(TbadkCoreApplication.m9getInst().getSkinType());
        }
        if (this.euL != null) {
            boolean aQj = aQj();
            if (hVar != null && hVar.aMt() != null && hVar.aMt().size() > 0) {
                com.baidu.tieba.tbadkCore.data.q qVar = hVar.aMt().get(0);
                if ((!this.enr || qVar.bjO() != 1) && (rF = hVar.aMs().rF()) != null && rF.getUser() != null && rF.getUser().size() > 0) {
                    this.euL.setVisibility(0);
                    this.euL.setIsFromPb(true);
                    this.euL.a(rF, hVar.aMs().getId(), rF.getPostId(), true);
                    this.euL.getVisibility();
                    com.baidu.tieba.graffiti.d.ak(this.euL);
                    return;
                }
            }
            this.euL.setVisibility(8);
            if (hVar != null && hVar.getPage() != null && hVar.getPage().qC() == 0 && this.enr) {
                if (aQj) {
                    this.euT.setVisibility(0);
                } else {
                    this.euT.setVisibility(8);
                }
            } else {
                this.euT.setVisibility(8);
            }
            com.baidu.tieba.graffiti.d.ak(this.euT);
        }
    }

    private com.baidu.tieba.tbadkCore.data.q a(com.baidu.tieba.pb.data.h hVar, boolean z, int i) {
        if (z) {
            if (hVar == null || hVar.aMt() == null || hVar.aMt().size() <= 0) {
                return null;
            }
            com.baidu.tieba.tbadkCore.data.q qVar = hVar.aMt().get(0);
            if (qVar.bjO() != 1) {
                qVar = a(hVar);
            }
            if (qVar.getAuthor() != null && qVar.getAuthor().getUserTbVipInfoData() != null && qVar.getAuthor().getUserTbVipInfoData().getvipIntro() != null) {
                qVar.getAuthor().getGodUserData().setIntro(qVar.getAuthor().getUserTbVipInfoData().getvipIntro());
                return qVar;
            }
            return qVar;
        }
        return a(hVar);
    }

    private com.baidu.tieba.tbadkCore.data.q a(com.baidu.tieba.pb.data.h hVar) {
        MetaData metaData;
        if (hVar == null || hVar.aMs() == null || hVar.aMs().getAuthor() == null) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.q qVar = new com.baidu.tieba.tbadkCore.data.q();
        MetaData author = hVar.aMs().getAuthor();
        String userId = author.getUserId();
        HashMap<String, MetaData> userMap = hVar.aMs().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = author;
        }
        qVar.rM(1);
        qVar.setId(hVar.aMs().sc());
        qVar.setTitle(hVar.aMs().getTitle());
        qVar.setTime(hVar.aMs().getCreateTime());
        qVar.setAuthor(metaData);
        return qVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v283, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void b(com.baidu.tieba.pb.data.h hVar, boolean z, int i) {
        if (hVar != null && hVar.aMs() != null) {
            if (hVar.aMt() != null && hVar.aMt().size() > 0 && hVar.aMt().get(0) != null) {
                String str = null;
                if (this.eow.aNO()) {
                    str = "FRS";
                }
                if (hVar.aMt().get(0).bjO() == 1 && hVar.aMt().get(0).sg() != null) {
                    this.eus.a(this.eow.getPageContext(), hVar.aMt().get(0).sg(), com.baidu.tieba.tbadkCore.d.a.b("PB", "c0132", hVar.aMr().getId(), hVar.aMr().getName(), hVar.aMs().getId(), str));
                    this.eur.setPadding(this.eur.getPaddingLeft(), (int) this.eow.getResources().getDimension(r.e.ds20), this.eur.getPaddingRight(), this.eur.getPaddingBottom());
                } else {
                    this.eus.a(null, null, null);
                }
            }
            aQG();
            this.eur.setVisibility(8);
            com.baidu.tieba.tbadkCore.data.q a = a(hVar, z, i);
            if (a != null) {
                String str2 = null;
                boolean z2 = false;
                if (hVar != null && hVar.aMs() != null && hVar.aMs().getAuthor() != null) {
                    str2 = hVar.aMs().getAuthor().getUserId();
                    if (hVar.getPage() != null) {
                        this.ewl = hVar.getPage().qy();
                        z2 = hVar.getPage().qB() == 1;
                    }
                }
                boolean sy = hVar.aMs().sy();
                if (a.getAuthor() != null && a.getAuthor().getUserTbVipInfoData() != null) {
                    this.aeb = !StringUtils.isNull(a.getAuthor().getUserTbVipInfoData().getvipV_url());
                }
                this.ewg = !sy && b(a, hVar.aMs().getId(), str2, z2, z);
                if (z) {
                    this.euK.setVisibility(8);
                } else if (!this.ewu) {
                    this.euK.setVisibility(0);
                }
                this.eur.setVisibility(0);
                if (this.euo != null && this.euo.elL != null && this.euo.elM != null && hVar.aMs() != null && hVar.aMs().UH != null) {
                    this.euV = true;
                    DealInfoData sK = hVar.aMs().sK();
                    String userId = hVar.aMs().getAuthor().getUserId();
                    boolean z3 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
                    com.baidu.tieba.pb.data.b bVar = new com.baidu.tieba.pb.data.b(1);
                    bVar.elL = this.euo.elL;
                    bVar.elM = this.euo.elM;
                    bVar.elI = sK;
                    bVar.aMe();
                    a(a, hVar.aMs().getId(), str2, z2, z);
                    a(sK, z3);
                    if (this.eun != null) {
                        this.bCe.removeHeaderView(this.eun);
                    }
                    if (this.eul != null) {
                        this.bCe.removeHeaderView(this.eul);
                    }
                    com.baidu.tieba.pb.data.b bVar2 = new com.baidu.tieba.pb.data.b(2);
                    bVar2.elL = this.euo.elL;
                    bVar2.elM = this.euo.elM;
                    bVar2.aPr = this.eun;
                    bVar2.bCe = this.bCe;
                    bVar2.aMe();
                    this.bCe.addHeaderView(this.eul);
                    aQw();
                    if (this.eow.aNj() != null) {
                        this.eow.aNj().iG(true);
                    }
                }
                SparseArray sparseArray = (SparseArray) this.eur.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    this.eur.setTag(sparseArray);
                }
                sparseArray.put(r.g.tag_clip_board, a);
                sparseArray.put(r.g.tag_is_subpb, false);
                this.euE.setText(com.baidu.tbadk.core.util.az.t(a.getTime()));
                this.euF.setText(String.format(this.eow.getPageContext().getString(r.j.is_floor), Integer.valueOf(a.bjO())));
                hVar.aMs().sv();
                if (!this.ewu) {
                    this.eut.setVisibility(0);
                }
                if (!hVar.aMs().sz() && this.eut.getText() != null && this.eut.getText().length() > 0) {
                    this.eut.setVisibility(0);
                } else {
                    this.eut.setVisibility(8);
                }
                k(hVar);
                ArrayList<com.baidu.tbadk.core.data.a> rX = hVar.aMs().rX();
                if (rX != null && rX.size() > 0 && !this.ewu) {
                    this.evS.setText(String.valueOf(rX.get(0).pb()));
                    this.evR.setVisibility(0);
                    this.ewC = true;
                } else {
                    this.evR.setVisibility(8);
                }
                com.baidu.tbadk.core.util.av.k(this.evR, r.f.activity_join_num_bg);
                com.baidu.tbadk.core.util.av.c(this.evS, r.d.cp_link_tip_d, 1);
                if (hVar != null && hVar.aMs() != null && hVar.aMs().getAuthor() != null) {
                    String userId2 = hVar.aMs().getAuthor().getUserId();
                    if (userId2 != null && !userId2.equals("0") && userId2.equals(a.getAuthor().getUserId())) {
                        this.euD.setVisibility(0);
                        this.euD.setAlpha(SocialAPIErrorCodes.ERROR_INVALID_BDUSS);
                    } else {
                        this.euD.setVisibility(8);
                    }
                }
                if (a.getAuthor() != null) {
                    int level_id = a.getAuthor().getLevel_id();
                    int is_bawu = a.getAuthor().getIs_bawu();
                    String bawu_type = a.getAuthor().getBawu_type();
                    int i2 = 3;
                    if (level_id != 0) {
                        this.euy.setVisibility(0);
                        com.baidu.tbadk.core.util.av.c(this.euy, BitmapHelper.getGradeResourceIdNew(level_id));
                        this.euy.setAlpha(SocialAPIErrorCodes.ERROR_INVALID_BDUSS);
                        this.euy.setContentDescription(String.format(TbadkCoreApplication.m9getInst().getString(r.j.degree_in_forum), Integer.valueOf(level_id)));
                        this.euy.setOnClickListener(null);
                    } else {
                        this.euy.setVisibility(8);
                    }
                    if (is_bawu != 0) {
                        this.euA.setAlpha(SocialAPIErrorCodes.ERROR_INVALID_BDUSS);
                        if (bawu_type.equals("manager")) {
                            com.baidu.tbadk.core.util.av.c(this.euA, r.f.pb_manager);
                            this.euy.setVisibility(8);
                            this.euA.setVisibility(0);
                        } else if (bawu_type.equals("assist")) {
                            com.baidu.tbadk.core.util.av.c(this.euA, r.f.pb_assist);
                            this.euy.setVisibility(8);
                            this.euA.setVisibility(0);
                        }
                    }
                    this.euz.setAlpha(SocialAPIErrorCodes.ERROR_INVALID_BDUSS);
                    if (a.getAuthor().getGender() == 2) {
                        com.baidu.tbadk.core.util.av.c(this.euz, r.f.icon_pb_pop_girl);
                        this.euz.setVisibility(0);
                    } else if (a.getAuthor().getGender() == 1) {
                        com.baidu.tbadk.core.util.av.c(this.euz, r.f.icon_pb_pop_boy);
                        this.euz.setVisibility(0);
                    } else {
                        this.euz.setVisibility(8);
                    }
                    String string = a.getAuthor().getName_show() == null ? StringUtils.string(a.getAuthor().getUserName()) : StringUtils.string(a.getAuthor().getName_show());
                    if (!StringUtils.isNull(string)) {
                        int aR = com.baidu.adp.lib.util.j.aR(a.getAuthor().getName_show());
                        if (aR > 14) {
                            i2 = 0;
                        } else if (aR >= 12) {
                            i2 = 1;
                        } else if (aR >= 10) {
                            i2 = 2;
                            if (is_bawu == 0) {
                                i2 = 1;
                            }
                        }
                    }
                    ArrayList<IconData> iconInfo = a.getAuthor().getIconInfo();
                    ArrayList<IconData> tShowInfoNew = a.getAuthor().getTShowInfoNew();
                    if (this.euB != null) {
                        this.euB.setTag(r.g.tag_user_id, a.getAuthor().getUserId());
                        this.euB.setOnClickListener(this.eow.epf.bUn);
                        this.euB.wL();
                        this.euB.a(iconInfo, i2, this.eow.getResources().getDimensionPixelSize(r.e.ds30), this.eow.getResources().getDimensionPixelSize(r.e.ds30), this.eow.getResources().getDimensionPixelSize(r.e.ds10));
                    }
                    if (this.euC != null) {
                        if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                            this.euC.setTag(tShowInfoNew.get(0).getUrl());
                        }
                        this.euC.setOnClickListener(this.eow.epf.ewX);
                        this.euC.a(tShowInfoNew, 3, this.eow.getResources().getDimensionPixelSize(r.e.ds32), this.eow.getResources().getDimensionPixelSize(r.e.ds32), this.eow.getResources().getDimensionPixelSize(r.e.ds8), true);
                    }
                    if (com.baidu.adp.lib.util.j.aR(string) > 14) {
                        this.euu.setText(com.baidu.tbadk.core.util.az.d(a.getAuthor().getName_show(), 14, "..."));
                    } else {
                        this.euu.setText(a.getAuthor().getName_show());
                    }
                    this.euu.setTag(r.g.tag_user_id, a.getAuthor().getUserId());
                    this.euu.setTag(r.g.tag_user_name, a.getAuthor().getName_show());
                    if (!com.baidu.tbadk.core.util.y.t(tShowInfoNew)) {
                        com.baidu.tbadk.core.util.av.c(this.euu, r.d.cp_cont_h, 1);
                    } else {
                        com.baidu.tbadk.core.util.av.c(this.euu, r.d.cp_cont_f, 1);
                    }
                    this.eux.setUserId(a.getAuthor().getUserId());
                    this.eux.setUserName(a.getAuthor().getUserName());
                    this.eux.setImageDrawable(null);
                    this.eux.setRadius(com.baidu.adp.lib.util.k.e(this.eow.getActivity(), r.e.ds35));
                    this.eux.setTag(a.getAuthor().getUserId());
                    if (!PbNormalLikeButtonSwitchStatic.GK() || this.evA || this.ewg || (a.getAuthor().hadConcerned() && a.getAuthor().getGodUserData() != null && a.getAuthor().getGodUserData().getIsFromNetWork())) {
                        this.euN.setVisibility(8);
                    } else {
                        this.euN.setVisibility(0);
                        this.euN.setMode(2);
                        this.euN.setData(a.getAuthor());
                        this.euN.setForumId(hVar.getForumId());
                    }
                    String portrait = a.getAuthor().getPortrait();
                    if (a.getAuthor() != null && a.getAuthor().getPendantData() != null && !StringUtils.isNull(a.getAuthor().getPendantData().pO())) {
                        if (!this.enq) {
                            this.eux.setVisibility(8);
                            this.euw.setVisibility(8);
                        } else {
                            this.eux.setVisibility(8);
                            this.euw.setVisibility(0);
                        }
                        if (this.esT != null) {
                            this.esT.setVisibility(8);
                        }
                        this.euu.setOnClickListener(this.eow.epf.ewW);
                        this.euz.setVisibility(0);
                        this.euu.setOnClickListener(this.eow.epf.ewW);
                        this.euz.setVisibility(0);
                        this.euw.getHeadView().c(portrait, 28, false);
                        this.euw.getHeadView().setUserId(a.getAuthor().getUserId());
                        this.euw.getHeadView().setUserName(a.getAuthor().getUserName());
                        this.euw.getHeadView().setOnClickListener(this.eow.epf.ewW);
                        this.euw.dX(a.getAuthor().getPendantData().pO());
                    } else if (this.aeb) {
                        if (!this.enq) {
                            this.eux.setVisibility(8);
                        } else {
                            this.eux.setVisibility(0);
                            UserTbVipInfoData userTbVipInfoData = a.getAuthor().getUserTbVipInfoData();
                            if (userTbVipInfoData != null && userTbVipInfoData.getvipV_url() != null && this.aYH != null) {
                                if (this.aYI == null) {
                                    this.aYH.inflate();
                                    this.aYI = (TbImageView) this.eur.findViewById(r.g.user_head_mask);
                                }
                                this.aYI.c(userTbVipInfoData.getvipV_url(), 10, false);
                            }
                            this.euE.setVisibility(8);
                        }
                        this.euF.setVisibility(8);
                        this.euu.setOnClickListener(this.eow.epf.ewW);
                        this.eux.setOnClickListener(this.eow.epf.ewW);
                        this.euz.setVisibility(0);
                        this.euz.setVisibility(8);
                        this.euw.setVisibility(8);
                    } else {
                        if (this.ewg) {
                            fm fmVar = new fm(this, a);
                            this.euu.setOnClickListener(fmVar);
                            this.eux.setOnClickListener(fmVar);
                            this.eux.setVisibility(8);
                            this.euE.setVisibility(8);
                            this.euF.setVisibility(8);
                            this.euz.setVisibility(8);
                            this.euw.setVisibility(8);
                        } else {
                            if (!this.enq) {
                                this.eux.setVisibility(8);
                            } else {
                                this.eux.setVisibility(0);
                            }
                            this.euu.setOnClickListener(this.eow.epf.ewW);
                            this.eux.setOnClickListener(this.eow.epf.ewW);
                            this.euz.setVisibility(0);
                        }
                        this.euw.setVisibility(8);
                    }
                    this.eux.c(portrait, 28, false);
                }
                aQg();
                this.eup.s(hVar.aMs());
            }
        }
    }

    private void aQg() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.euG.getLayoutParams();
        int i = layoutParams.topMargin;
        int i2 = layoutParams.bottomMargin;
        if (this.ewC) {
            i = com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst(), r.e.ds20);
        }
        if (this.ewD) {
            i2 = com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst(), r.e.ds24);
        }
        layoutParams.setMargins(layoutParams.leftMargin, i, layoutParams.rightMargin, i2);
        this.euG.setLayoutParams(layoutParams);
    }

    public boolean aQh() {
        return this.ewE;
    }

    private boolean aQi() {
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.userId);
    }

    private boolean h(com.baidu.tbadk.core.data.bi biVar) {
        if (biVar == null || biVar.getAuthor() == null || biVar.getAuthor().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), biVar.getAuthor().getUserId());
    }

    public void a(com.baidu.tieba.pb.data.g gVar) {
        if (gVar != null) {
            this.eug.aQR();
            if (!StringUtils.isNull(gVar.forumName)) {
                this.eug.mV(gVar.forumName);
            }
            String string = this.eow.getResources().getString(r.j.thread_delete_by);
            String str = "";
            switch (com.baidu.adp.lib.h.b.g(gVar.source, 0)) {
                case 100:
                    str = this.eow.getResources().getString(r.j.self);
                    break;
                case 300:
                    str = this.eow.getResources().getString(r.j.bawu);
                    break;
                case 400:
                    str = this.eow.getResources().getString(r.j.system);
                    break;
            }
            this.eow.showNetRefreshView(this.dZP, String.format(string, str), null, this.eow.getResources().getString(r.j.appeal_restore), true, new fn(this, gVar.elW));
        }
    }

    public void a(com.baidu.tieba.pb.data.h hVar, int i, int i2, boolean z, int i3, boolean z2) {
        Parcelable aPA;
        Parcelable aPA2;
        String sb;
        if (hVar != null) {
            if (hVar.aMs() != null) {
                this.evV = hVar.aMs().rD();
                this.Uw = hVar.aMs().rA();
                if (hVar.aMs().getAnchorLevel() != 0) {
                    this.ewE = true;
                }
                this.evA = h(hVar.aMs());
            }
            if (hVar.getUserData() != null) {
                this.userId = hVar.getUserData().getUserId();
            }
            m(hVar);
            this.evQ = false;
            this.enr = z;
            aQb();
            b(hVar, z, i);
            if (this.eow.aNE()) {
                if (this.evb == null) {
                    this.evb = new com.baidu.tieba.pb.view.w(this.eow.getPageContext());
                    this.evb.kk();
                    this.evb.a(this.agD);
                }
                this.bCe.setPullRefresh(this.evb);
                this.bCe.removeHeaderView(this.aqq);
                this.bCe.f(this.aqq, 0);
                if (this.evb != null) {
                    this.evb.dh(TbadkCoreApplication.m9getInst().getSkinType());
                }
            } else if (hVar.getPage().qC() == 0 && z) {
                this.bCe.setPullRefresh(null);
                this.eue = 0;
                this.evM.setVisibility(8);
            } else {
                if (this.evb == null) {
                    this.evb = new com.baidu.tieba.pb.view.w(this.eow.getPageContext());
                    this.evb.kk();
                    this.evb.a(this.agD);
                }
                this.bCe.setPullRefresh(this.evb);
                this.bCe.removeHeaderView(this.aqq);
                this.bCe.f(this.aqq, 0);
                this.eue = 1;
                if (this.evb != null) {
                    this.evb.dh(TbadkCoreApplication.m9getInst().getSkinType());
                }
                this.evM.setVisibility(0);
                aLg();
            }
            aQj();
            boolean z3 = this.evM.getVisibility() == 0;
            this.euX.hS(this.enr);
            this.euX.hT(z3);
            this.euX.b(hVar);
            this.euX.notifyDataSetChanged();
            if (hVar.aMr() != null) {
                this.mForumName = hVar.aMr().getName();
                this.mForumId = hVar.getForumId();
            }
            this.eug.mV(this.mForumName);
            if (hVar.aMs() != null) {
                pm(com.baidu.tbadk.core.util.az.z(hVar.aMs().rH()));
                if (hVar.aMs().rF() != null) {
                    if (hVar.aMs().rF().getNum() < 1) {
                        sb = this.eow.getResources().getString(r.j.frs_item_praise_text);
                    } else {
                        sb = new StringBuilder(String.valueOf(hVar.aMs().rF().getNum())).toString();
                    }
                    if (this.eud != -1) {
                        hVar.aMs().rF().setIsLike(this.eud);
                    }
                    N(sb, hVar.aMs().rF().getIsLike() == 1);
                }
            }
            if (hVar.getPage().qB() == 0 && !z) {
                this.bCe.setNextPage(null);
                this.euf = 1;
            } else if (this.eow.isLogin()) {
                this.bCe.setNextPage(this.evc);
                this.euf = 2;
                aLg();
            } else if (hVar.getPage().qB() == 1) {
                this.evQ = true;
                if (this.evd == null) {
                    this.evd = new com.baidu.tieba.pb.view.d(this.eow.getPageContext());
                }
                this.bCe.setNextPage(this.evd);
                this.euf = 3;
            }
            ArrayList<com.baidu.tieba.tbadkCore.data.q> aMt = hVar.aMt();
            if (hVar.getPage().qB() == 0 || aMt == null || aMt.size() < hVar.getPage().qA()) {
                this.evc.setText(this.eow.getResources().getString(r.j.list_no_more));
                if (this.eow.aNE() && this.bCe != null && this.bCe.getData() != null && this.bCe.getData().size() == 1 && (this.bCe.getData().get(0) instanceof com.baidu.tieba.pb.data.m)) {
                    this.evc.setText("");
                }
                l(hVar);
            } else if (z2) {
                if (this.ewB) {
                    wC();
                    if (hVar.getPage().qB() != 0) {
                        this.evc.setText(this.eow.getResources().getString(r.j.pb_load_more));
                    }
                } else {
                    this.evc.wD();
                }
            } else {
                this.evc.wD();
            }
            if (z) {
                this.evN.setVisibility(0);
                this.aNs.setVisibility(0);
                this.evO.setText(this.eow.getResources().getString(r.j.btn_show_passed_pb));
            } else {
                this.evN.setVisibility(8);
                this.aNs.setVisibility(8);
                this.evO.setText(this.eow.getResources().getString(r.j.btn_show_passed_pb_aftre));
            }
            if (hVar.aMs() != null && hVar.aMs().getAuthor() != null && hVar.aMs().getAuthor().getType() == 0) {
                this.eug.aQO();
            }
            switch (i) {
                case 2:
                    this.bCe.setSelection(i2 > 1 ? i2 - 2 : 0);
                    if (this.eum != null) {
                        CompatibleUtile.scrollListViewBy(this.bCe, -this.eum.getHeight(), 0);
                        break;
                    }
                    break;
                case 3:
                    if (i3 == 1 && (aPA2 = ep.aPz().aPA()) != null) {
                        this.bCe.onRestoreInstanceState(aPA2);
                        break;
                    } else {
                        this.bCe.setSelection(0);
                        break;
                    }
                    break;
                case 4:
                    this.ewB = false;
                    this.bCe.setSelection(0);
                    break;
                case 5:
                    this.bCe.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1 && (aPA = ep.aPz().aPA()) != null) {
                        this.bCe.onRestoreInstanceState(aPA);
                        break;
                    } else {
                        this.bCe.setSelection(0);
                        break;
                    }
            }
            if (this.evV == evX && aQi()) {
                aQA();
            }
        }
    }

    public void iA(boolean z) {
        this.evz = z;
        this.eug.iA(z);
    }

    public void wC() {
        if (this.evc != null) {
            this.evc.wC();
        }
        aLg();
    }

    public void JK() {
        this.bCe.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aQj() {
        boolean z;
        boolean z2 = true;
        if (this.eum != null && this.eum.getVisibility() == 0) {
            if (this.euR != null) {
                this.euR.setVisibility(0);
                z = true;
            } else {
                z = true;
            }
        } else {
            if (this.euR != null) {
                this.euR.setVisibility(8);
            }
            z = false;
        }
        if (this.evC != null && this.evC.getVisibility() == 0) {
            if (this.euS != null) {
                this.euS.setVisibility(0);
            }
        } else {
            if (this.euS != null) {
                this.euS.setVisibility(8);
            }
            z2 = z;
        }
        if ((this.euU == null || this.euU.getVisibility() == 8) && z2 && this.enr) {
            this.euT.setVisibility(0);
        } else {
            this.euT.setVisibility(8);
        }
        com.baidu.tieba.graffiti.d.ak(this.euT);
        return z2;
    }

    public boolean a(com.baidu.tieba.pb.data.h hVar, boolean z, boolean z2) {
        if (hVar == null) {
            return false;
        }
        if (this.eut != null) {
            if (hVar.aMs().sb() == 0 && !hVar.aMs().sz() && !this.ewu) {
                this.eut.setVisibility(0);
                hVar.aMs().sv();
                if (hVar.aMs() != null) {
                    hVar.aMs().e(true, n(hVar));
                }
                SpannableStringBuilder sm = hVar.aMs().sm();
                this.eut.setOnTouchListener(new com.baidu.tieba.view.y(sm));
                this.eut.setText(sm);
            } else {
                this.eut.setVisibility(8);
                this.ewC = true;
                aQg();
            }
        }
        this.enr = z;
        com.baidu.tbadk.core.data.bi aMs = hVar.aMs();
        if (aMs != null) {
            a(aMs.rN());
        }
        if (hVar.aMz() != 1 || t(aMs) || aMs == null || aMs.sF()) {
            return false;
        }
        aQk();
        Button button = (Button) this.eul.findViewById(r.g.pb_head_function_manage_commit_top);
        Button button2 = (Button) this.eul.findViewById(r.g.pb_head_function_manage_cancel_top);
        Button button3 = (Button) this.eul.findViewById(r.g.pb_head_function_manage_commit_good);
        Button button4 = (Button) this.eul.findViewById(r.g.pb_head_function_manage_cancel_good);
        button.setOnClickListener(this.bRx);
        button2.setOnClickListener(this.bRx);
        button3.setOnClickListener(this.bRx);
        button4.setOnClickListener(this.bRx);
        if (hVar.aMs().rK() == 1) {
            button3.setVisibility(8);
            button4.setVisibility(0);
        } else {
            button3.setVisibility(0);
            button4.setVisibility(8);
        }
        if (hVar.aMs().rJ() == 1) {
            button.setVisibility(8);
            button2.setVisibility(0);
        } else {
            button.setVisibility(0);
            button2.setVisibility(8);
        }
        if (hVar.aMs().sE() && hVar.aMs().so() == 2) {
            button.setEnabled(false);
            com.baidu.tbadk.core.util.av.j((View) button, r.d.cp_cont_d);
        }
        return true;
    }

    private boolean t(com.baidu.tbadk.core.data.bi biVar) {
        if (biVar == null) {
            return false;
        }
        return biVar.isDeal && biVar.UH != null;
    }

    private void aQk() {
        if (this.eum == null) {
            this.eum = ((ViewStub) this.eul.findViewById(r.g.pb_header_function_manage)).inflate();
            this.eow.getLayoutMode().x(this.eum);
            this.euR = this.eul.findViewById(r.g.new_pb_header_item_line_above_manage);
            return;
        }
        this.eum.setVisibility(0);
    }

    public void a(com.baidu.tieba.pb.data.h hVar, boolean z, boolean z2, int i) {
        boolean z3;
        boolean z4;
        boolean z5;
        String userId;
        if (hVar != null) {
            a(hVar, z, z2);
            com.baidu.tieba.tbadkCore.data.q a = a(hVar, z, i);
            if (a != null) {
                if (hVar.aMz() != 0 && a.getAuthor() != null && !t(hVar.aMs())) {
                    String userId2 = a.getAuthor().getUserId();
                    boolean z6 = userId2 == null || !userId2.equals(TbadkCoreApplication.getCurrentAccount());
                    if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                        z3 = false;
                        z4 = true;
                        z5 = false;
                    } else {
                        z4 = true;
                        z5 = z6;
                        z3 = false;
                    }
                } else {
                    String userId3 = hVar.aMs().getAuthor().getUserId();
                    if (userId3 != null && userId3.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z3 = false;
                        z4 = true;
                        z5 = false;
                    } else if (a.getAuthor() == null || (userId = a.getAuthor().getUserId()) == null || !userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z3 = false;
                        z4 = false;
                        z5 = false;
                    } else {
                        z3 = true;
                        z4 = true;
                        z5 = false;
                    }
                }
                if (z4 && z5) {
                    SparseArray<Object> sparseArray = new SparseArray<>();
                    if (a.getAuthor() != null) {
                        sparseArray.put(r.g.tag_forbid_user_name, a.getAuthor().getUserName());
                        sparseArray.put(r.g.tag_forbid_user_post_id, a.getId());
                    }
                    sparseArray.put(r.g.tag_del_post_id, a.getId());
                    sparseArray.put(r.g.tag_del_post_type, 0);
                    sparseArray.put(r.g.tag_del_post_is_self, Boolean.valueOf(z3));
                    sparseArray.put(r.g.tag_manage_user_identity, Integer.valueOf(hVar.aMz()));
                    sparseArray.put(r.g.tag_should_manage_visible, true);
                    a(r.j.manage, sparseArray, hVar);
                } else if (z4) {
                    SparseArray<Object> sparseArray2 = new SparseArray<>();
                    sparseArray2.put(r.g.tag_del_post_id, a.getId());
                    sparseArray2.put(r.g.tag_del_post_type, 0);
                    sparseArray2.put(r.g.tag_del_post_is_self, Boolean.valueOf(z3));
                    sparseArray2.put(r.g.tag_manage_user_identity, Integer.valueOf(hVar.aMz()));
                    sparseArray2.put(r.g.tag_should_manage_visible, false);
                    a(r.j.delete, sparseArray2, hVar);
                }
            }
            aQj();
        }
    }

    private void a(int i, SparseArray<Object> sparseArray, com.baidu.tieba.pb.data.h hVar) {
        if (hVar != null && hVar.aMs() != null && !hVar.aMs().sF()) {
            aQk();
            Button button = (Button) this.eul.findViewById(r.g.pb_head_function_manage_delormanage);
            button.setOnClickListener(this.bRx);
            button.setVisibility(0);
            button.setText(i);
            button.setTag(sparseArray);
        }
    }

    public View getNextView() {
        return this.aAA;
    }

    public void pn(String str) {
        if (this.evc != null && !StringUtils.isNull(str)) {
            this.evc.setText(str);
        }
    }

    public BdListView OU() {
        return this.bCe;
    }

    public int aQl() {
        return r.g.richText;
    }

    public int abS() {
        return r.g.user_icon_box;
    }

    public Button aQm() {
        return (Button) this.eul.findViewById(r.g.pb_head_function_manage_commit_good);
    }

    public Button aQn() {
        return (Button) this.eul.findViewById(r.g.pb_head_function_manage_cancel_good);
    }

    public Button aQo() {
        return (Button) this.eul.findViewById(r.g.pb_head_function_manage_commit_top);
    }

    public Button aQp() {
        return (Button) this.eul.findViewById(r.g.pb_head_function_manage_cancel_top);
    }

    public TextView aNf() {
        return this.eup.aNf();
    }

    public void c(BdListView.e eVar) {
        this.bCe.setOnSrollToBottomListener(eVar);
    }

    public void a(y.b bVar) {
        this.agD = bVar;
        if (this.evb != null) {
            this.evb.a(bVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.am amVar, a.b bVar) {
        if (amVar != null) {
            int qz = amVar.qz();
            int qw = amVar.qw();
            if (this.euY != null) {
                this.euY.tm();
            } else {
                this.euY = new com.baidu.tbadk.core.dialog.a(this.eow.getPageContext().getPageActivity());
                this.euZ = LayoutInflater.from(this.eow.getPageContext().getPageActivity()).inflate(r.h.dialog_direct_pager, (ViewGroup) null);
                this.euY.z(this.euZ);
                this.euY.a(r.j.dialog_ok, bVar);
                this.euY.b(r.j.dialog_cancel, new fo(this));
                this.euY.a(new fp(this));
                this.euY.b(this.eow.getPageContext()).tm();
            }
            this.eva = (EditText) this.euZ.findViewById(r.g.input_page_number);
            this.eva.setText("");
            TextView textView = (TextView) this.euZ.findViewById(r.g.current_page_number);
            if (qz <= 0) {
                qz = 1;
            }
            if (qw <= 0) {
                qw = 1;
            }
            textView.setText(MessageFormat.format(this.eow.getApplicationContext().getResources().getString(r.j.current_page), Integer.valueOf(qz), Integer.valueOf(qw)));
            this.eow.ShowSoftKeyPadDelay(this.eva, 150);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.bCe.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.eow.showToast(str);
    }

    public boolean iB(boolean z) {
        if (this.EJ == null || !this.EJ.CJ()) {
            return false;
        }
        this.EJ.AV();
        return true;
    }

    public void aQq() {
        if (this.ewF != null) {
            while (this.ewF.size() > 0) {
                TbImageView remove = this.ewF.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        aQq();
        this.euX.op(1);
    }

    public void onResume() {
        this.euX.op(2);
    }

    public void onDestroy() {
        this.eow.hideProgressBar();
        if (this.bmi != null && this.aRn != null) {
            this.bmi.b(this.aRn);
        }
        aBc();
        this.evc.wC();
        if (this.ewd != null) {
            com.baidu.adp.lib.h.h.eG().removeCallbacks(this.ewd);
        }
        if (this.ewe != null) {
            com.baidu.adp.lib.h.h.eG().removeCallbacks(this.ewe);
        }
        aQx();
        if (this.ewt != null) {
            this.ewt.removeAllViews();
        }
        if (this.eur != null && this.esT != null) {
            this.eur.removeView(this.euv);
            this.esT = null;
        }
        if (this.evU != null) {
            this.evU.clearStatus();
        }
        this.eww = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.euX.op(3);
        if (this.bJw != null) {
            this.bJw.setBackgroundDrawable(null);
        }
    }

    public void aBc() {
        this.eug.ob();
        com.baidu.adp.lib.util.k.b(this.eow.getPageContext().getPageActivity(), this.eva);
        if (this.evy != null) {
            this.evy.dismiss();
        }
        aQr();
    }

    public void hQ(boolean z) {
        this.euX.hQ(z);
    }

    public void hR(boolean z) {
        this.enq = z;
        this.euX.hR(z);
    }

    public void gD(boolean z) {
        this.dyE = z;
    }

    public void aQr() {
        if (this.evh != null) {
            this.evh.dismiss();
        }
        if (this.evi != null) {
            com.baidu.adp.lib.h.j.b(this.evi, this.eow.getPageContext());
        }
        if (this.evr != null) {
            com.baidu.adp.lib.h.j.b(this.evr, this.eow.getPageContext());
        }
        if (this.evf != null) {
            com.baidu.adp.lib.h.j.b(this.evf, this.eow.getPageContext());
        }
    }

    public void onChangeSkinType(int i) {
        this.eow.getLayoutMode().ah(i == 1);
        this.eow.getLayoutMode().x(this.dZP);
        this.eow.getLayoutMode().x(this.eun);
        this.eow.getLayoutMode().x(this.eul);
        if (this.euo != null) {
            com.baidu.tieba.pb.data.b bVar = new com.baidu.tieba.pb.data.b(3);
            bVar.elL = this.euo.elL;
            bVar.elM = this.euo.elM;
            bVar.ahV = i;
            bVar.elH = this.eow;
            bVar.aMe();
        }
        this.eow.getLayoutMode().x(this.aAA);
        this.eug.mNavigationBar.onChangeSkinType(this.eow.getPageContext(), i);
        com.baidu.tbadk.core.util.av.b(this.eug.exk, r.f.btn_more_selector_s, r.f.btn_more_selector);
        com.baidu.tbadk.core.util.av.b(this.eug.exl, r.f.icon_floor_addition_selector_s, r.f.icon_floor_addition_selector);
        if (this.euZ != null) {
            this.eow.getLayoutMode().x(this.euZ);
        }
        iA(this.evz);
        this.euX.notifyDataSetChanged();
        if (this.evb != null) {
            this.evb.dh(i);
        }
        if (this.evc != null) {
            this.evc.dh(i);
            com.baidu.tbadk.core.util.av.k(this.aAA, r.f.pb_foot_more_trans_selector);
            this.evc.df(r.f.pb_foot_more_trans_selector);
        }
        if (this.EJ != null) {
            this.EJ.onChangeSkinType(i);
        }
        if (this.euL != null) {
            this.euL.dl(i);
        }
        if (this.evd != null) {
            this.evd.dh(i);
        }
        if (this.euk != null && this.euk.size() > 0) {
            for (com.baidu.tieba.pb.pb.main.b.a aVar : this.euk) {
                aVar.aQM();
            }
        }
        if (this.ewt != null) {
            com.baidu.tbadk.core.util.av.l(this.ewt, r.d.cp_bg_line_d);
            com.baidu.tbadk.core.util.av.l(this.ewn, r.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.av.c(this.ews, r.d.cp_cont_c, 1);
        }
        it(i == 1);
        this.euq.changeSkinType(i);
        aPL();
        UtilHelper.setStatusBarBackground(this.bJw, i);
        if (this.euN != null) {
            this.euN.aK(true);
        }
        if (this.euO != null) {
            com.baidu.tbadk.i.a.a(this.eow.getPageContext(), this.euO);
        }
        com.baidu.tbadk.core.util.av.b(this.eug.exi, r.d.cp_cont_b, r.d.s_navbar_title_color);
    }

    public void setOnImageClickListener(TbRichTextView.e eVar) {
        this.aJh = eVar;
        this.euX.setOnImageClickListener(this.aJh);
    }

    public void g(NoNetworkView.a aVar) {
        this.aRn = aVar;
        if (this.bmi != null) {
            this.bmi.a(this.aRn);
        }
    }

    public void iC(boolean z) {
        this.euX.setIsFromCDN(z);
        this.mIsFromCDN = z;
    }

    public Button aQs() {
        return this.evC;
    }

    public void l(com.baidu.tieba.pb.data.h hVar) {
        if (hVar != null) {
            ArrayList<com.baidu.tieba.tbadkCore.data.q> aMt = hVar.aMt();
            if (aMt.size() == 1) {
                com.baidu.tieba.tbadkCore.data.q qVar = aMt.get(0);
                if (qVar.bjU() < qVar.bjN().size()) {
                    if (this.euf != 1) {
                        this.bCe.setNextPage(null);
                        this.euf = 1;
                    }
                } else if (this.euf != 2) {
                    this.bCe.setNextPage(this.evc);
                    this.euf = 2;
                }
            } else if (this.euf != 2) {
                this.bCe.setNextPage(this.evc);
                this.euf = 2;
            }
        }
    }

    public void aQt() {
        if (com.baidu.tbadk.performanceLog.aa.Go().Gp()) {
            int lastVisiblePosition = this.bCe.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.bCe.getChildAt(i);
                if (childAt != null) {
                    TbRichTextView tbRichTextView = (TbRichTextView) childAt.findViewById(r.g.richText);
                    if (tbRichTextView != null) {
                        for (int i2 = 0; i2 < tbRichTextView.getChildCount(); i2++) {
                            View childAt2 = tbRichTextView.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.performanceLog.u perfLog = tbImageView.getPerfLog();
                                perfLog.fd(1001);
                                perfLog.aBL = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr = new int[2];
                                    tbRichTextView.getLocationOnScreen(iArr);
                                    if (iArr[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m9getInst().getContext())) {
                                    }
                                }
                                tbImageView.wi();
                            }
                        }
                    }
                    HeadImageView headImageView = (HeadImageView) childAt.findViewById(r.g.photo);
                    if (headImageView != null) {
                        com.baidu.tbadk.performanceLog.u perfLog2 = headImageView.getPerfLog();
                        perfLog2.fd(1001);
                        perfLog2.aBL = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr2 = new int[2];
                            headImageView.getLocationOnScreen(iArr2);
                            if (iArr2[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m9getInst().getContext())) {
                            }
                        }
                        headImageView.wi();
                    }
                }
            }
        }
    }

    public void gE(boolean z) {
        if (this.evD != null) {
            if (this.dyE && !aQJ()) {
                gF(z);
            } else {
                gG(z);
            }
        }
    }

    public void aQu() {
        if (this.evD != null) {
            this.evD.setVisibility(8);
        }
    }

    public TextView aQv() {
        return this.evN;
    }

    public void ayI() {
        if (this.evP == null) {
            this.evP = new com.baidu.tbadk.core.view.a(this.eow.getPageContext());
        }
        this.evP.aF(true);
    }

    public void aLg() {
        if (this.evP != null) {
            this.evP.aF(false);
        }
    }

    private void a(com.baidu.tieba.tbadkCore.data.q qVar, String str, String str2, boolean z, boolean z2) {
        this.euE.setVisibility(8);
        this.eux.setIsRound(true);
        if (this.eug != null) {
            this.eug.mNavigationBar.setBackgroundResource(0);
            ((ViewGroup.MarginLayoutParams) this.eug.exi.getLayoutParams()).leftMargin = this.eow.getResources().getDimensionPixelOffset(r.e.ds6);
            this.bCe.removeHeaderView(this.aqq);
        }
    }

    private boolean b(com.baidu.tieba.tbadkCore.data.q qVar, String str, String str2, boolean z, boolean z2) {
        FrameLayout.LayoutParams layoutParams;
        if (qVar == null || qVar.getAuthor() == null || qVar.getAuthor().getGodUserData() == null) {
            return false;
        }
        GodUserData godUserData = qVar.getAuthor().getGodUserData();
        if (2 != godUserData.getType()) {
            return false;
        }
        MetaData author = qVar.getAuthor();
        long userIdLong = qVar.getAuthor().getUserIdLong();
        String userName = qVar.getAuthor().getUserName();
        int fansNum = qVar.getAuthor().getFansNum();
        qVar.getId();
        String portrait = qVar.getAuthor().getPortrait();
        fr frVar = new fr(this, str, new com.baidu.tbadk.coreExtra.d.a(null), author);
        this.eur.setPadding(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds32), TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds0), TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds32), 0);
        if (qVar.getType() == null || qVar.getType().getId() != com.baidu.tieba.tbadkCore.data.q.Tt.getId()) {
            this.eul.setPadding(0, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds34), 0, 0);
        }
        int dimensionPixelSize = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds76);
        if (this.eux.getLayoutParams() == null) {
            layoutParams = new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
        } else {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.eux.getLayoutParams();
            layoutParams2.width = dimensionPixelSize;
            layoutParams2.height = dimensionPixelSize;
            layoutParams = layoutParams2;
        }
        this.eux.setLayoutParams(layoutParams);
        this.eux.setVisibility(8);
        View findViewWithTag = this.eur.findViewWithTag("pb_god_head_image_view_tag");
        if (!(findViewWithTag instanceof ClickableHeaderImageView)) {
            this.esT = new ClickableHeaderImageView(this.eow.getApplicationContext());
            this.esT.setGodIconMargin(0);
            this.esT.setTag("pb_god_head_image_view_tag");
            this.esT.setUserId(String.valueOf(userIdLong));
            this.esT.setUserName(userName);
            layoutParams.leftMargin = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds0);
            this.euv.addView(this.esT, 0, layoutParams);
        } else {
            this.esT = (ClickableHeaderImageView) findViewWithTag;
        }
        if (this.aeb) {
            this.esT.setIsBigV(true);
        }
        fs fsVar = new fs(this, qVar);
        this.eur.setTag(r.g.tag_user_id, String.valueOf(userIdLong));
        this.eur.setTag(r.g.tag_user_name, userName);
        this.eun.setTag(r.g.tag_user_id, String.valueOf(userIdLong));
        this.eun.setTag(r.g.tag_user_name, userName);
        if (this.enq) {
            this.esT.setVisibility(0);
            this.esT.setOnClickListener(fsVar);
            this.esT.c(portrait, 28, false);
        } else {
            this.esT.setVisibility(8);
        }
        if (this.euH == null) {
            this.euH = new TextView(this.eow.getActivity());
            this.euH.setClickable(false);
            this.euH.setIncludeFontPadding(false);
            this.euH.setGravity(16);
            this.euH.setTextSize(0, this.eow.getResources().getDimensionPixelSize(r.e.fontsize24));
            ColumnLayout.a aVar = new ColumnLayout.a(-2, -2, 3, 2);
            aVar.topMargin = this.eow.getResources().getDimensionPixelSize(r.e.ds8);
            aVar.bottomMargin = this.eow.getResources().getDimensionPixelSize(r.e.ds10);
            this.euH.setSingleLine(true);
            com.baidu.tbadk.core.util.av.c(this.euH, r.d.cp_cont_d, 1);
            this.eur.addView(this.euH, -1, aVar);
        }
        String format = String.format(this.eow.getResources().getString(r.j.fans_default_name_god_user), com.baidu.tbadk.core.util.az.w(fansNum));
        this.euH.setText(format);
        this.euH.setTag(r.g.tag_user_id, String.valueOf(userIdLong));
        this.euH.setTag(r.g.tag_user_name, userName);
        this.euH.setOnClickListener(fsVar);
        if (this.euI == null) {
            this.euI = new TextView(this.eow.getActivity());
            this.euI.setClickable(true);
            this.euI.setTextSize(0, this.eow.getResources().getDimensionPixelSize(r.e.fontsize24));
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
            this.euI.setSingleLine(true);
            this.euI.setPadding(this.eow.getResources().getDimensionPixelSize(r.e.ds32), 0, this.eow.getResources().getDimensionPixelSize(r.e.ds128), 0);
            this.euI.setEllipsize(TextUtils.TruncateAt.END);
            this.euI.setTag(r.g.tag_user_id, String.valueOf(userIdLong));
            this.euI.setTag(r.g.tag_user_name, userName);
            com.baidu.tbadk.core.util.av.c(this.euI, r.d.cp_cont_d, 1);
            this.euI.setOnTouchListener(this.emU);
            this.eun.addView(this.euI, layoutParams3);
        }
        String string = this.eow.getResources().getString(r.j.tieba_certification);
        this.euI.setText(StringUtils.isNull(godUserData.getIntro()) ? String.format(string, this.eow.getResources().getString(r.j.god_intro_default)) : String.format(string, godUserData.getIntro()));
        this.euE.setVisibility(8);
        if (this.euJ == null) {
            this.euJ = new TextView(this.eow.getActivity());
            this.euJ.setTextSize(0, this.eow.getResources().getDimensionPixelSize(r.e.fontsize24));
            this.euJ.setGravity(17);
            this.euJ.setOnClickListener(frVar);
            ColumnLayout.a aVar2 = new ColumnLayout.a(this.eow.getResources().getDimensionPixelSize(r.e.ds110), this.eow.getResources().getDimensionPixelSize(r.e.ds50), 80, 3);
            aVar2.bottomMargin = this.eow.getResources().getDimensionPixelSize(r.e.ds22);
            this.eur.addView(this.euJ, -1, aVar2);
        }
        a(this.euJ, godUserData.getFollowed() == 1);
        if (this.evA || (godUserData.getFollowed() == 1 && godUserData.getIsFromNetWork())) {
            this.euJ.setVisibility(8);
        } else {
            this.euJ.setVisibility(0);
        }
        if (this.eun.findViewWithTag("pb_god_bottom_line_view_tag") == null) {
            View view = new View(this.eow.getApplicationContext());
            view.setTag("pb_god_bottom_line_view_tag");
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, this.eow.getResources().getDimensionPixelSize(r.e.ds1));
            layoutParams4.topMargin = this.eow.getResources().getDimensionPixelSize(r.e.ds18);
            layoutParams4.bottomMargin = this.eow.getResources().getDimensionPixelSize(r.e.ds1);
            com.baidu.tbadk.core.util.av.l(view, r.d.cp_bg_line_a);
            this.eun.addView(view, layoutParams4);
        }
        if (this.ewk == null) {
            this.ewk = new TextView(this.eow.getApplicationContext());
            this.ewk.setId(r.g.pb_god_user_tip_content);
            this.ewk.setEllipsize(TextUtils.TruncateAt.END);
            this.ewk.setGravity(17);
            this.ewk.setSingleLine(true);
            this.ewk.setHeight(this.eow.getResources().getDimensionPixelSize(r.e.ds56));
            this.ewk.setTextSize(0, this.eow.getResources().getDimensionPixelSize(r.e.fontsize24));
            this.ewk.setVisibility(8);
            if (aQD() != null) {
                aQD().addView(this.ewk);
            }
            this.eow.getLayoutMode().x(this.ewk);
        }
        com.baidu.tbadk.core.util.av.k(this.ewk, r.d.common_color_10260);
        com.baidu.tbadk.core.util.av.j((View) this.ewk, r.d.cp_cont_g);
        this.ewk.setOnClickListener(new fu(this));
        this.ewk.setText(String.format(this.eow.getResources().getString(r.j.god_user_floor_owner_tip), com.baidu.tbadk.core.util.az.w(this.ewl)));
        oD(this.ewl);
        if (this.ewj == null) {
            this.ewj = (LinearLayout) LayoutInflater.from(this.eow.getActivity()).inflate(r.h.god_floating_view, (ViewGroup) null);
            this.ewj.setOnClickListener(fsVar);
            this.ewj.setTag(r.g.tag_user_id, String.valueOf(userIdLong));
            this.ewj.setTag(r.g.tag_user_name, userName);
            ClickableHeaderImageView clickableHeaderImageView = (ClickableHeaderImageView) this.ewj.findViewById(r.g.god_floating_owner_photo);
            if (this.aeb) {
                ViewStub viewStub = (ViewStub) this.ewj.findViewById(r.g.viewstub_headimage_mask);
                if (viewStub != null && 0 == 0) {
                    viewStub.inflate();
                    TbImageView tbImageView = (TbImageView) this.ewj.findViewById(r.g.user_head_mask);
                    if (tbImageView != null && author != null && author.getUserTbVipInfoData() != null && !StringUtils.isNull(author.getUserTbVipInfoData().getvipV_url())) {
                        tbImageView.c(author.getUserTbVipInfoData().getvipV_url(), 10, false);
                        clickableHeaderImageView.setIsBigV(true);
                    }
                }
            } else {
                clickableHeaderImageView.setGodIconMargin(0);
            }
            clickableHeaderImageView.setOnClickListener(fsVar);
            if (!this.enq) {
                clickableHeaderImageView.setVisibility(8);
            }
            clickableHeaderImageView.setTag(qVar.getAuthor().getUserId());
            clickableHeaderImageView.c(qVar.getAuthor().getPortrait(), 28, false);
            View findViewById = this.ewj.findViewById(r.g.god_floating_owner_info_floor_owner);
            if (str2 != null && !str2.equals("0") && str2.equals(qVar.getAuthor().getUserId())) {
                findViewById.setVisibility(0);
            } else {
                findViewById.setVisibility(8);
            }
            ImageView imageView = (ImageView) this.ewj.findViewById(r.g.god_floating_owner_info_user_rank);
            int level_id = qVar.getAuthor().getLevel_id();
            int is_bawu = qVar.getAuthor().getIs_bawu();
            String bawu_type = qVar.getAuthor().getBawu_type();
            int i = 3;
            if (level_id != 0) {
                imageView.setVisibility(0);
                com.baidu.tbadk.core.util.av.c(imageView, BitmapHelper.getGradeResourceIdNew(level_id));
                imageView.setContentDescription(String.format(TbadkCoreApplication.m9getInst().getString(r.j.degree_in_forum), Integer.valueOf(level_id)));
                imageView.setOnClickListener(null);
            } else {
                imageView.setVisibility(8);
            }
            ImageView imageView2 = (ImageView) this.ewj.findViewById(r.g.god_floating_owner_info_user_bawu);
            if (is_bawu != 0) {
                if (bawu_type.equals("manager")) {
                    com.baidu.tbadk.core.util.av.c(imageView2, r.f.pb_manager);
                    imageView.setVisibility(8);
                    imageView2.setVisibility(0);
                } else if (bawu_type.equals("assist")) {
                    com.baidu.tbadk.core.util.av.c(imageView2, r.f.pb_assist);
                    imageView.setVisibility(8);
                    imageView2.setVisibility(0);
                }
            }
            if (!StringUtils.isNull(qVar.getAuthor().getName_show()) && com.baidu.adp.lib.util.j.aR(qVar.getAuthor().getName_show()) > 14) {
                i = 0;
            }
            ArrayList<IconData> iconInfo = qVar.getAuthor().getIconInfo();
            ArrayList<IconData> tShowInfoNew = qVar.getAuthor().getTShowInfoNew();
            UserIconBox userIconBox = (UserIconBox) this.ewj.findViewById(r.g.god_floating_owner_info_user_icon);
            UserIconBox userIconBox2 = (UserIconBox) this.ewj.findViewById(r.g.god_floating_owner_info_tshow_icon);
            if (userIconBox != null) {
                userIconBox.setTag(r.g.tag_user_id, qVar.getAuthor().getUserId());
                userIconBox.setOnClickListener(this.eow.epf.bUn);
                userIconBox.a(iconInfo, i, this.eow.getResources().getDimensionPixelSize(r.e.ds30), this.eow.getResources().getDimensionPixelSize(r.e.ds30), this.eow.getResources().getDimensionPixelSize(r.e.ds10));
            }
            if (userIconBox2 != null) {
                userIconBox2.setOnClickListener(this.eow.epf.ewX);
                userIconBox2.a(tShowInfoNew, 3, this.eow.getResources().getDimensionPixelSize(r.e.ds32), this.eow.getResources().getDimensionPixelSize(r.e.ds32), this.eow.getResources().getDimensionPixelSize(r.e.ds8), true);
            }
            TextView textView = (TextView) this.ewj.findViewById(r.g.god_floating_owner_info_user_name);
            if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                com.baidu.tbadk.core.util.av.c(textView, r.d.cp_cont_h, 1);
            } else {
                com.baidu.tbadk.core.util.av.c(textView, r.d.cp_cont_f, 1);
            }
            textView.setText(qVar.getAuthor().getName_show());
            if (aQD() != null) {
                aQD().addView(this.ewj);
            }
            this.eow.getLayoutMode().x(this.ewj);
        }
        TextView textView2 = (TextView) this.ewj.findViewById(r.g.god_floating_gift);
        textView2.setOnClickListener(frVar);
        a(textView2, godUserData.getFollowed() == 1);
        ImageView imageView3 = (ImageView) this.ewj.findViewById(r.g.god_floating_arrow);
        com.baidu.tbadk.core.util.av.c(imageView3, r.f.icon_arrow_tab);
        if (this.evA || (godUserData.getFollowed() == 1 && godUserData.getIsFromNetWork())) {
            textView2.setVisibility(8);
            imageView3.setVisibility(0);
        } else {
            textView2.setVisibility(0);
            imageView3.setVisibility(8);
        }
        TextView textView3 = (TextView) this.ewj.findViewById(r.g.god_floating_intro);
        if (textView3 != null) {
            textView3.setText(format);
        }
        this.ewt = this.evc.wy();
        if (this.ewt != null && !this.evA && !z && z2 && (godUserData.getFollowed() != 1 || !godUserData.getIsFromNetWork())) {
            this.evc.wz();
            this.evc.wv();
            this.ewn = this.ewt.findViewWithTag("pb_god_bottom_extra_line_view_tag");
            if (this.ewn == null) {
                this.ewn = new View(this.eow.getApplicationContext());
                this.ewn.setTag("pb_god_bottom_extra_line_view_tag");
                this.ewt.addView(this.ewn, new LinearLayout.LayoutParams(-1, this.eow.getResources().getDimensionPixelSize(r.e.ds20)));
                this.ewr = new FrameLayout(this.eow.getApplicationContext());
                this.ewr.setTag("pb_god_bottom_extra_god_avatar_frame_tag");
                this.ewp = new ClickableHeaderImageView(this.eow.getApplicationContext());
                this.ewp.setTag("pb_god_bottom_extra_god_avatar_tag");
                this.ewp.c(portrait, 28, false);
                this.ewp.setUserId(String.valueOf(userIdLong));
                this.ewp.setUserName(userName);
                this.ewp.setOnClickListener(fsVar);
                this.ewr.addView(this.ewp, new FrameLayout.LayoutParams(this.eow.getResources().getDimensionPixelSize(r.e.ds130), this.eow.getResources().getDimensionPixelSize(r.e.ds130)));
                if (this.aeb) {
                    this.ewq = new TbImageView(this.eow.getApplicationContext());
                    this.ewq.setTag("pb_god_bottom_extra_god_avatar_mask_tag");
                    this.ewq.c(author.getUserTbVipInfoData().getvipV_url(), 10, false);
                    FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(this.eow.getResources().getDimensionPixelSize(r.e.ds45), this.eow.getResources().getDimensionPixelSize(r.e.ds45));
                    layoutParams5.gravity = 85;
                    this.ewr.addView(this.ewq, layoutParams5);
                } else {
                    this.ewp.setGodIconMargin(0);
                }
                LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(this.eow.getResources().getDimensionPixelSize(r.e.ds130), this.eow.getResources().getDimensionPixelSize(r.e.ds130));
                layoutParams6.gravity = 17;
                layoutParams6.topMargin = this.eow.getResources().getDimensionPixelSize(r.e.ds40);
                this.ewt.addView(this.ewr, layoutParams6);
                this.ews = new TextView(this.eow.getApplicationContext());
                this.ews.setTag("pb_god_bottom_extra_text_view_tag");
                this.ews.setSingleLine(true);
                this.ews.setTextSize(0, this.eow.getResources().getDimensionPixelSize(r.e.fontsize24));
                LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams7.topMargin = this.eow.getResources().getDimensionPixelSize(r.e.ds36);
                layoutParams7.gravity = 1;
                this.ews.setText(this.eow.getResources().getString(r.j.god_user_attention_tip));
                this.ewt.addView(this.ews, layoutParams7);
                this.ewo = new TextView(this.eow.getApplicationContext());
                this.ewo.setTag("pb_god_bottom_extra_attention_btn_tag");
                this.ewo.setSingleLine(true);
                this.ewo.setGravity(17);
                this.ewo.setTextSize(0, this.eow.getResources().getDimensionPixelSize(r.e.fontsize24));
                this.ewo.setOnClickListener(frVar);
                LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(this.eow.getResources().getDimensionPixelSize(r.e.ds212), this.eow.getResources().getDimensionPixelSize(r.e.ds54));
                layoutParams8.topMargin = this.eow.getResources().getDimensionPixelSize(r.e.ds30);
                layoutParams8.bottomMargin = this.eow.getResources().getDimensionPixelSize(r.e.ds40);
                layoutParams8.gravity = 1;
                this.ewt.addView(this.ewo, layoutParams8);
            } else {
                this.ewo = (TextView) this.ewt.findViewWithTag("pb_god_bottom_extra_attention_btn_tag");
                this.ewp = (ClickableHeaderImageView) this.ewt.findViewWithTag("pb_god_bottom_extra_god_avatar_tag");
                this.ews = (TextView) this.ewt.findViewWithTag("pb_god_bottom_extra_text_view_tag");
                this.ewn = this.ewt.findViewWithTag("pb_god_bottom_extra_line_view_tag");
            }
            com.baidu.tbadk.core.util.av.l(this.ewt, r.d.cp_bg_line_d);
            com.baidu.tbadk.core.util.av.l(this.ewn, r.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.av.c(this.ews, r.d.cp_cont_c, 1);
            this.ewt.setOnTouchListener(new fv(this));
            boolean z3 = godUserData.getFollowed() == 1;
            a(this.ewo, z3);
            if (!z3) {
                this.ewo.setPadding(this.eow.getResources().getDimensionPixelSize(r.e.ds68), 0, this.eow.getResources().getDimensionPixelSize(r.e.ds52), 0);
            }
        } else {
            this.evc.wA();
            this.evc.wu();
        }
        return true;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.ewg && !this.ewh && i > this.eue) {
            this.ewi = true;
        } else {
            this.ewi = false;
            aQy();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL));
        aQw();
    }

    public void aQw() {
        float f = 1.0f;
        if (this.euo != null && this.euo.elL != null && this.euV) {
            int dimension = (int) this.eow.getResources().getDimension(r.e.ds98);
            int dimension2 = ((int) this.eow.getResources().getDimension(r.e.ds450)) - (-this.euo.elL.getTop());
            if (this.bCe.getChildAt(0) == this.euo.elL && dimension2 >= dimension) {
                if (dimension2 < dimension || dimension2 > dimension * 2) {
                    f = dimension2 > dimension * 2 ? 0.0f : 0.0f;
                } else {
                    f = 1.0f - (((dimension2 - dimension) * 1.0f) / dimension);
                }
            }
            this.eug.ap(f);
        }
    }

    private void oD(int i) {
        boolean z;
        if (this.ewk != null && this.ewk.getVisibility() != 0 && i >= 2 && !this.evA) {
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                z = com.baidu.tbadk.core.sharedPref.b.uh().getBoolean("pb_god_floor_owner_tip_has_shown_" + TbadkCoreApplication.getCurrentAccount(), false);
            } else {
                z = com.baidu.tbadk.core.sharedPref.b.uh().getBoolean("pb_god_floor_owner_not_login_tip_has_shown_" + TbadkCoreApplication.getCurrentAccount(), false);
            }
            if (!z) {
                this.ewm = true;
                this.ewk.setVisibility(0);
            }
            com.baidu.adp.lib.h.h.eG().postDelayed(this.cFO, 3000L);
        }
    }

    public void aQx() {
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.cFO);
        if (this.ewk != null && 8 != this.ewk.getVisibility()) {
            com.baidu.tieba.tbadkCore.a.a(this.eow, this.ewk, r.a.fade_out, new fw(this));
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                com.baidu.tbadk.core.sharedPref.b.uh().putBoolean("pb_god_floor_owner_tip_has_shown_" + TbadkCoreApplication.getCurrentAccount(), true);
            } else {
                com.baidu.tbadk.core.sharedPref.b.uh().putBoolean("pb_god_floor_owner_not_login_tip_has_shown_" + TbadkCoreApplication.getCurrentAccount(), true);
            }
        }
    }

    public void aQy() {
        if (this.ewj != null) {
            this.ewj.clearAnimation();
            if (this.ewj.getVisibility() != 8) {
                this.ewj.setVisibility(8);
            }
        }
    }

    public void aQz() {
        if (this.ewg && this.ewi && this.ewj != null && this.ewj.getVisibility() != 0 && !this.ewm) {
            this.ewj.clearAnimation();
            this.ewj.setVisibility(0);
        }
    }

    public void aQA() {
        if (!this.ewG) {
            TiebaStatic.log("c10490");
            this.ewG = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eow.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(evY, Integer.valueOf(ewa));
            aVar.bY(r.j.grade_thread_tips);
            View inflate = LayoutInflater.from(this.eow.getPageContext().getPageActivity()).inflate(r.h.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(r.g.function_description_view)).setText(r.j.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(r.g.title_view)).setText(r.j.grade_thread_tips);
            aVar.z(inflate);
            aVar.A(sparseArray);
            aVar.a(r.j.grade_button_tips, this.eow);
            aVar.b(r.j.look_again, new fx(this));
            aVar.b(this.eow.getPageContext()).tm();
        }
    }

    public void aQB() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eow.getPageContext().getPageActivity());
        aVar.cD(this.eow.getResources().getString(r.j.upgrade_to_new_photo_live_tips));
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(evY, Integer.valueOf(ewc));
        aVar.A(sparseArray);
        aVar.a(r.j.upgrade_to_new, this.eow);
        aVar.b(r.j.cancel, new fy(this));
        aVar.b(this.eow.getPageContext()).tm();
    }

    public int rD() {
        return this.evV;
    }

    public void po(String str) {
        if (str.contains("_")) {
            str = str.replace("_", "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eow.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.eow.getPageContext().getPageActivity()).inflate(r.h.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(r.g.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(r.g.function_description_view)).setVisibility(8);
        aVar.z(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(evY, Integer.valueOf(ewb));
        aVar.A(sparseArray);
        aVar.a(r.j.view, this.eow);
        aVar.b(r.j.cancel, new fz(this));
        aVar.b(this.eow.getPageContext()).tm();
    }

    public void a(int i, com.baidu.tieba.pb.data.h hVar, boolean z, int i2) {
        com.baidu.tieba.tbadkCore.data.q a;
        if (i > 0 && (a = a(hVar, z, i2)) != null && a.getAuthor() != null) {
            MetaData author = a.getAuthor();
            author.setGiftNum(author.getGiftNum() + i);
        }
    }

    public void c(com.baidu.tieba.pb.data.h hVar, boolean z, int i) {
        b(hVar, z, i);
    }

    private void a(TextView textView, boolean z) {
        if (z) {
            textView.setClickable(false);
            com.baidu.tbadk.core.util.av.c(textView, r.d.cp_cont_d, 1);
            textView.setText(TbadkCoreApplication.m9getInst().getString(r.j.relate_forum_is_followed));
            textView.setBackgroundDrawable(null);
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setPadding(0, 0, 0, 0);
            return;
        }
        com.baidu.tbadk.core.util.av.c(textView, r.d.btn_forum_focus_color, 1);
        textView.setText(TbadkCoreApplication.m9getInst().getString(r.j.forum_list_attention_tv));
        com.baidu.tbadk.core.util.av.k(textView, r.f.btn_transparent_focus_border_bg);
        textView.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.av.getDrawable(r.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        textView.setClickable(true);
        textView.setPadding(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds18), 0, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds10), 0);
    }

    public PbInterviewStatusView aQC() {
        return this.evU;
    }

    private void m(com.baidu.tieba.pb.data.h hVar) {
        if (hVar != null && hVar.aMs() != null && hVar.aMs().sE() && this.evU == null) {
            this.evU = (PbInterviewStatusView) this.evT.inflate();
            this.evU.setOnClickListener(this.bRx);
            this.evU.setCallback(this.eow.aNN());
            this.evU.a(this.eow, hVar);
        }
    }

    public LinearLayout aQD() {
        return this.euW;
    }

    public View aQE() {
        return this.bJw;
    }

    public boolean aQF() {
        return this.ewu;
    }

    public void aOn() {
        this.euq.aOn();
    }

    public void hW(boolean z) {
        this.eup.hW(z);
    }

    private void aQG() {
        if (this.ewu) {
            if (this.ewv == null) {
                f.a aVar = f.eoy.get();
                if (aVar != null) {
                    this.ewv = aVar.a(this.eow);
                    ListAdapter adapter = this.bCe.getAdapter();
                    if (adapter != null) {
                        if (adapter.getView(0, null, null) == this.aqq) {
                            this.bCe.f(this.ewv.aNd(), 1);
                        } else {
                            this.bCe.f(this.ewv.aNd(), 0);
                        }
                    }
                } else {
                    this.eun.setVisibility(0);
                    return;
                }
            }
            this.eun.setVisibility(8);
            this.bCe.removeHeaderView(this.eun);
            return;
        }
        this.eun.setVisibility(0);
    }

    public void iD(boolean z) {
        this.ewu = z;
    }

    public View aOr() {
        return this.euq.aOr();
    }

    public void aQH() {
        this.eow.showNetRefreshView(getView(), "");
        View EA = this.eow.getRefreshView().EA();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) EA.getLayoutParams();
        layoutParams.addRule(3, aQD().getId());
        EA.setLayoutParams(layoutParams);
        this.eow.hideLoadingView(getView());
        if (this.ewv != null) {
            this.bCe.removeHeaderView(this.ewv.aNd());
            this.ewv = null;
        }
    }

    public void pp(String str) {
        if (this.euh != null) {
            this.euh.setTitle(str);
        }
    }

    public void CS() {
        this.euq.CS();
    }

    public void aNb() {
        if (this.eut != null) {
            this.eut.setTextSize(TbConfig.getContentSizeOfPostTitle());
        }
        if (this.euX != null && this.euX.aNY() != null) {
            this.euX.aNY().aNb();
        }
        if (this.euX != null) {
            if (this.euX.aNZ() != null) {
                this.euX.aNZ().aCl();
            }
            if (this.euX.aOa() != null) {
                this.euX.aOa().aCl();
            }
            if (this.euX.aOb() != null) {
                this.euX.aOb().aCl();
            }
        }
    }

    private int iE(boolean z) {
        if (this.evU == null || this.evU.getVisibility() != 0 || !z) {
            return 0;
        }
        return 0 + com.baidu.adp.lib.util.k.e(this.eow.getPageContext().getPageActivity(), r.e.ds72);
    }

    private void aQI() {
        if (this.evU != null && this.evU.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.evU.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.evU.setLayoutParams(layoutParams);
        }
    }

    public boolean aQJ() {
        return this.euV;
    }

    public boolean aNm() {
        return this.ewg;
    }

    public TextView aQK() {
        return this.euI;
    }

    private boolean n(com.baidu.tieba.pb.data.h hVar) {
        if (hVar == null || hVar.aMs() == null) {
            return false;
        }
        if (hVar.aMs().rL() == 1 || hVar.aMs().getThreadType() == 33) {
            return true;
        }
        return !(hVar.aMs().rN() == null || hVar.aMs().rN().sZ() == 0) || hVar.aMs().rJ() == 1 || hVar.aMs().rK() == 1 || hVar.aMs().sr() || hVar.aMs().sE() || hVar.aMs().sy() || hVar.aMs().rY() != null || hVar.aMs().sF() || hVar.aMs().sF() || !com.baidu.tbadk.core.util.az.isEmpty(hVar.aMs().rG());
    }
}
