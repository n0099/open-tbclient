package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Point;
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
import com.baidu.tbadk.core.view.t;
import com.baidu.tbadk.data.GodUserData;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.editortools.sendtool.SendView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.ap;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.f;
import com.baidu.tieba.pb.view.PbInterviewStatusView;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.FrsPraiseView;
import com.baidu.tieba.tbadkCore.b.a;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class ex {
    private com.baidu.tbadk.editortools.l EJ;
    private View aAX;
    private ViewStub aYe;
    private TbImageView aYf;
    private boolean adQ;
    private t.b agd;
    private TextView aqI;
    private BdTypeListView bBT;
    private View bJv;
    private View.OnClickListener bRE;
    private NoNetworkView blV;
    private RelativeLayout dXV;
    private com.baidu.tieba.pb.a.d ekU;
    private View.OnClickListener ely;
    private PbActivity emy;
    PbActivity.c enN;
    public int erU;
    public final com.baidu.tieba.pb.pb.main.b.e erX;
    public com.baidu.tieba.pb.pb.main.b.c erY;
    private ViewStub erZ;
    private TextView esB;
    private UserLikeButton esE;
    private LinearLayout esF;
    private TextView esG;
    private TextView esH;
    private View esJ;
    private View esK;
    private ObservedChangeLinearLayout esN;
    private cj esO;
    private PbListView esT;
    private View esV;
    private ViewStub esa;
    private List<com.baidu.tieba.pb.pb.main.b.a> esb;
    private View esc;
    private LinearLayout ese;
    private com.baidu.tieba.pb.data.b esf;
    private g esg;
    private dd esh;
    private ColumnLayout esi;
    private ThreadSkinView esj;
    private TextView esk;
    private TextView esl;
    private FrameLayout esm;
    private HeadPendantView esn;
    private HeadImageView eso;
    private ImageView esp;
    private ImageView esq;
    private ImageView esr;
    private UserIconBox ess;
    private UserIconBox est;
    private ImageView esu;
    private TextView esv;
    private TextView esw;
    private TextView esx;
    private boolean etB;
    private HeadImageView etC;
    private ImageView etD;
    private View etJ;
    private TextView etK;
    private ViewStub etL;
    private PbInterviewStatusView etM;
    private Runnable etV;
    private Runnable etW;
    private View etv;
    private TextView etw;
    private TextView etx;
    private ViewGroup ety;
    private TextView etz;
    private View euh;
    private TextView eui;
    private ClickableHeaderImageView euj;
    private TbImageView euk;
    private FrameLayout eul;
    private TextView eum;
    private LinearLayout eun;
    private boolean euo;
    private f eup;
    private Runnable eur;
    private PbActivity.a euu;
    private boolean euw;
    private boolean eux;
    public static int etO = 2;
    public static int etP = 3;
    public static int etQ = 0;
    public static int etR = 3;
    public static int etS = 4;
    public static int etT = 5;
    public static int etU = 6;
    private static HashMap<Point, Integer> Ub = new HashMap<>();
    private static SparseArray<ap.a> etX = new SparseArray<>(3);
    private int erV = 0;
    private int erW = 0;
    private final Handler mHandler = new Handler();
    private View esd = null;
    private TextView esy = null;
    private TextView esz = null;
    private TextView esA = null;
    public FrsPraiseView esC = null;
    private ClickableHeaderImageView eqL = null;
    private ClickableHeaderImageView esD = null;
    private View esI = null;
    private View esL = null;
    private boolean esM = false;
    private com.baidu.tbadk.core.dialog.a esP = null;
    private com.baidu.tbadk.core.dialog.c bRy = null;
    private View esQ = null;
    private EditText esR = null;
    private com.baidu.tieba.pb.view.w esS = null;
    private com.baidu.tieba.pb.view.d esU = null;
    private c.b dej = null;
    private TbRichTextView.d aJI = null;
    private NoNetworkView.a bOz = null;
    private Dialog esW = null;
    private View esX = null;
    private com.baidu.tbadk.core.dialog.a esY = null;
    private Dialog esZ = null;
    private View eta = null;
    private int etb = 0;
    private RadioGroup Hu = null;
    private RadioButton etd = null;
    private RadioButton ete = null;
    private RadioButton etf = null;
    private Button etg = null;
    private Button eth = null;
    private TextView eti = null;
    private Dialog etj = null;
    private View etk = null;
    private LinearLayout etl = null;
    private CompoundButton.OnCheckedChangeListener etm = null;
    private TextView etn = null;
    private TextView eto = null;
    private String etp = null;
    private com.baidu.tbadk.core.dialog.c etq = null;
    private boolean etr = false;
    private boolean ets = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView ett = null;
    private boolean dxj = false;
    private Button etu = null;
    private boolean etA = true;
    private LinearLayout etE = null;
    private TextView etF = null;
    private TextView etG = null;
    private View aMi = null;
    private com.baidu.tbadk.core.view.a etH = null;
    private boolean elu = false;
    private boolean etI = false;
    private boolean mIsFromCDN = true;
    private int etN = 0;
    private boolean etY = true;
    private a.InterfaceC0074a etZ = new ey(this);
    private boolean eua = false;
    private boolean eub = false;
    private boolean euc = false;
    private LinearLayout eud = null;
    private TextView eue = null;
    private int euf = 0;
    private boolean eug = false;
    private Handler euq = new Handler();
    private CustomMessageListener eus = new fj(this, CmdConfigCustom.PB_SHOW_MULTIIAMGETOOL);
    private final View.OnClickListener eut = new ft(this);
    private View.OnLongClickListener onLongClickListener = null;
    private boolean euv = true;
    private boolean euy = false;
    private boolean Um = false;
    String userId = null;
    private final List<TbImageView> euz = new ArrayList();
    private boolean elt = true;
    private boolean euA = false;
    private Runnable cEQ = new ga(this);

    static {
        Ub.put(new Point(1, 1), Integer.valueOf(t.j.lottery_status_ing));
        Ub.put(new Point(1, 2), Integer.valueOf(t.j.lottery_status_over));
        Ub.put(new Point(1, 3), Integer.valueOf(t.j.lottery_status_off));
        Ub.put(new Point(1, 4), Integer.valueOf(t.j.lottery_status_not_start));
        Ub.put(new Point(2, 1), Integer.valueOf(t.j.share_picture_status_ing));
        Ub.put(new Point(2, 2), Integer.valueOf(t.j.share_picture_status_over));
        Ub.put(new Point(2, 3), Integer.valueOf(t.j.share_picture_status_off));
        Ub.put(new Point(2, 4), Integer.valueOf(t.j.share_picture_status_not_start));
        etX.put(1, new ap.a(t.j.interview_live_status_not_start, t.d.cp_other_b, t.f.pic_dot_title_red));
        etX.put(2, new ap.a(t.j.interview_live_status_ing, t.d.cp_other_c, t.f.pic_dot_title_green));
        etX.put(3, new ap.a(t.j.interview_live_status_over, t.d.cp_other_d, t.f.pic_dot_title_blue));
    }

    public f aOU() {
        return this.eup;
    }

    public NoNetworkView aOV() {
        return this.blV;
    }

    public boolean isFullScreen() {
        return this.eub;
    }

    public void aOW() {
        if (this.EJ != null) {
            this.EJ.hide();
        }
    }

    public void aOX() {
        reset();
        this.etA = true;
        if (this.EJ != null) {
            this.EJ.hide();
        }
        if (this.etv != null) {
            if (this.dxj && !aQa()) {
                gC(false);
            } else {
                gD(false);
            }
        }
        aNI();
    }

    private void reset() {
        if (this.emy != null && this.emy.aMB() != null && this.EJ != null) {
            com.baidu.tbadk.editortools.d.b.Dh().setStatus(0);
            com.baidu.tbadk.editortools.d.e aMB = this.emy.aMB();
            aMB.DF();
            if (aMB.getWriteImagesInfo() != null) {
                aMB.getWriteImagesInfo().setMaxImagesAllowed(10);
            }
            aMB.eI(10);
            aMB.eG(SendView.ALL);
            aMB.eH(SendView.ALL);
            aMB.fB(this.emy.getActivity().getString(t.j.pb_reply_hint));
            com.baidu.tbadk.editortools.s ex = this.EJ.ex(23);
            com.baidu.tbadk.editortools.s ex2 = this.EJ.ex(2);
            com.baidu.tbadk.editortools.s ex3 = this.EJ.ex(5);
            if (ex2 != null) {
                ex2.lw();
            }
            if (ex3 != null) {
                ex3.lw();
            }
            if (ex != null) {
                ex.hide();
            }
            this.EJ.invalidate();
        }
    }

    public boolean aOY() {
        return this.etA;
    }

    public void gC(boolean z) {
        if (this.etv != null && this.etw != null && this.etx != null) {
            this.etw.setText(t.j.draft_to_send);
            this.etx.setVisibility(8);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.etv.startAnimation(alphaAnimation);
            }
            this.etv.setVisibility(0);
        }
    }

    public void gD(boolean z) {
        if (this.etv != null && this.etw != null && this.etx != null) {
            this.etw.setText(t.j.reply_floor_host);
            this.etx.setVisibility(0);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.etv.startAnimation(alphaAnimation);
            }
            this.etv.setVisibility(0);
        }
    }

    public com.baidu.tieba.tbadkCore.data.q aOZ() {
        int i;
        View childAt;
        int i2 = 0;
        if (this.bBT == null) {
            return null;
        }
        int firstVisiblePosition = this.bBT.getFirstVisiblePosition();
        int lastVisiblePosition = this.bBT.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.bBT.getChildCount();
            int i3 = 0;
            for (int i4 = firstVisiblePosition; i4 <= lastVisiblePosition; i4++) {
                if (i4 - firstVisiblePosition < childCount && (childAt = this.bBT.getChildAt(i4 - firstVisiblePosition)) != null) {
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
        int headerViewsCount = i - this.bBT.getHeaderViewsCount();
        if (headerViewsCount < 0) {
            headerViewsCount = 0;
        }
        if (this.esO.oe(headerViewsCount) != null && this.esO.oe(headerViewsCount) != com.baidu.tieba.tbadkCore.data.q.fsz) {
            i2 = headerViewsCount + 1;
        }
        return (com.baidu.tieba.tbadkCore.data.q) this.esO.aJ(i2);
    }

    public ex(PbActivity pbActivity, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.d dVar) {
        this.emy = null;
        this.dXV = null;
        this.bJv = null;
        this.bBT = null;
        this.esc = null;
        this.ese = null;
        this.esi = null;
        this.esk = null;
        this.esl = null;
        this.esm = null;
        this.esn = null;
        this.eso = null;
        this.esp = null;
        this.esq = null;
        this.esr = null;
        this.ess = null;
        this.est = null;
        this.esu = null;
        this.esv = null;
        this.esw = null;
        this.esx = null;
        this.esB = null;
        this.esE = null;
        this.esJ = null;
        this.esK = null;
        this.esO = null;
        this.esT = null;
        this.aAX = null;
        this.bRE = null;
        this.ely = null;
        this.etv = null;
        this.etw = null;
        this.ety = null;
        this.etz = null;
        this.etC = null;
        this.etD = null;
        this.etJ = null;
        this.etK = null;
        this.etL = null;
        this.emy = pbActivity;
        this.bRE = onClickListener;
        this.ekU = dVar;
        this.dXV = (RelativeLayout) LayoutInflater.from(this.emy.getPageContext().getPageActivity()).inflate(t.h.new_pb_activity, (ViewGroup) null);
        this.emy.addContentView(this.dXV, new FrameLayout.LayoutParams(-1, -1));
        this.bJv = this.emy.findViewById(t.g.statebar_view);
        this.esN = (ObservedChangeLinearLayout) this.emy.findViewById(t.g.title_wrapper);
        this.blV = (NoNetworkView) this.emy.findViewById(t.g.view_no_network);
        this.bBT = (BdTypeListView) this.emy.findViewById(t.g.new_pb_list);
        this.aqI = new TextView(this.emy.getActivity());
        this.aqI.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.e(this.emy.getActivity(), t.e.ds98)));
        this.bBT.f(this.aqI, 0);
        View view = new View(this.emy.getPageContext().getPageActivity());
        view.setLayoutParams(new AbsListView.LayoutParams(-1, this.emy.getResources().getDimensionPixelSize(t.e.ds100)));
        view.setVisibility(4);
        this.bBT.addFooterView(view);
        this.bBT.setOnTouchListener(this.emy.aKe);
        this.erX = new com.baidu.tieba.pb.pb.main.b.e(pbActivity);
        if (this.emy.aMY()) {
            this.erZ = (ViewStub) this.emy.findViewById(t.g.manga_view_stub);
            this.erZ.setVisibility(0);
            this.erY = new com.baidu.tieba.pb.pb.main.b.c(pbActivity);
            this.erY.show();
            this.erX.mNavigationBar.setVisibility(8);
        }
        this.erX.aQe().setOnTouchListener(new com.baidu.tieba.pb.a.a(new gb(this)));
        this.etv = this.emy.findViewById(t.g.pb_editor_tool_comment);
        this.etw = (TextView) this.emy.findViewById(t.g.pb_editor_tool_comment_reply_text);
        this.ety = (ViewGroup) this.emy.findViewById(t.g.pb_editor_tool_comment_reply_layout);
        this.etz = (TextView) this.emy.findViewById(t.g.pb_editor_tool_comment_praise_icon);
        this.etC = (HeadImageView) this.emy.findViewById(t.g.pb_editor_tool_comment_avatar);
        aPh();
        this.etD = (ImageView) this.emy.findViewById(t.g.pb_editor_tool_comment_share_icon);
        this.etD.setOnClickListener(this.bRE);
        boolean al = com.baidu.tieba.graffiti.d.al(this.etz);
        if (al) {
            iw(al);
            this.etz.setVisibility(0);
        }
        this.etx = (TextView) this.emy.findViewById(t.g.pb_editor_tool_comment_reply_count_text);
        this.esh = new dd(this.emy, this.dXV);
        this.esh.init();
        this.esh.a(this.esh.aNJ(), this.bRE);
        this.ety.setOnClickListener(new gc(this));
        this.etz.setOnClickListener(this.bRE);
        this.etz.setOnTouchListener(this.emy);
        this.esc = LayoutInflater.from(this.emy.getPageContext().getPageActivity()).inflate(t.h.new_pb_header_item, (ViewGroup) null);
        this.ese = (LinearLayout) LayoutInflater.from(this.emy.getPageContext().getPageActivity()).inflate(t.h.new_pb_header_user_item, (ViewGroup) null);
        this.esf = new com.baidu.tieba.pb.data.b(0);
        this.esf.ejJ = this.emy;
        this.esf.aLC();
        this.esf = new com.baidu.tieba.pb.data.b(0);
        this.esf.ejJ = this.emy;
        this.esf.aLC();
        this.esg = new g(this.emy, this.ese);
        this.esg.init();
        this.esg.a(this.esg.aMA(), this.bRE);
        this.esi = (ColumnLayout) this.ese.findViewById(t.g.pb_head_owner_root);
        this.esj = (ThreadSkinView) this.ese.findViewById(t.g.pb_thread_skin);
        this.esi.setOnLongClickListener(this.onLongClickListener);
        this.esi.setOnTouchListener(this.ekU);
        this.esi.setVisibility(8);
        this.esc.setOnTouchListener(this.ekU);
        this.esk = (TextView) this.esc.findViewById(t.g.pb_head_post_title);
        this.esk.setTextSize(TbConfig.getContentSizeOfPostTitle());
        this.esk.setVisibility(8);
        this.etJ = this.esc.findViewById(t.g.pb_head_activity_join_number_container);
        this.etJ.setVisibility(8);
        this.etK = (TextView) this.esc.findViewById(t.g.pb_head_activity_join_number);
        this.esl = (TextView) this.esi.findViewById(t.g.pb_head_owner_info_user_name);
        this.esm = (FrameLayout) this.esi.findViewById(t.g.pb_head_headImage_container);
        this.eso = (HeadImageView) this.esi.findViewById(t.g.pb_head_owner_photo);
        this.esn = (HeadPendantView) this.esi.findViewById(t.g.pb_pendant_head_owner_photo);
        this.aYe = (ViewStub) this.esi.findViewById(t.g.viewstub_headimage_mask);
        if (!this.elt) {
            this.eso.setVisibility(8);
        }
        this.esn.vW();
        if (this.esn.getHeadView() != null) {
            this.esn.getHeadView().setIsRound(true);
            this.esn.getHeadView().setDrawBorder(false);
        }
        if (this.esn.getPendantView() != null) {
            this.esn.getPendantView().setIsRound(true);
            this.esn.getPendantView().setDrawBorder(false);
        }
        this.esp = (ImageView) this.esi.findViewById(t.g.pb_head_owner_info_user_rank);
        this.esq = (ImageView) this.esi.findViewById(t.g.pb_head_owner_info_user_gender);
        this.esr = (ImageView) this.esi.findViewById(t.g.pb_head_owner_info_user_bawu);
        this.ess = (UserIconBox) this.esi.findViewById(t.g.pb_head_owner_info_user_icon);
        this.est = (UserIconBox) this.esi.findViewById(t.g.pb_head_owner_info_tshow_icon);
        this.esu = (ImageView) this.esi.findViewById(t.g.pb_head_owner_info_floor_owner);
        this.esw = (TextView) this.esi.findViewById(t.g.pb_head_owner_info_floor);
        this.esv = (TextView) this.esi.findViewById(t.g.pb_head_owner_info_time);
        this.esx = (TextView) this.esc.findViewById(t.g.pb_head_read_button);
        this.esx.setOnClickListener(this.bRE);
        this.esB = (TextView) this.esc.findViewById(t.g.pb_head_reverse_hint);
        this.esB.setOnClickListener(this.bRE);
        this.esB.setVisibility(8);
        this.esE = (UserLikeButton) this.esi.findViewById(t.g.pb_like_button);
        this.esJ = this.esc.findViewById(t.g.new_pb_header_item_line_above_livepost);
        this.esK = this.esc.findViewById(t.g.new_pb_header_item_line_below_livepost);
        this.esc.setOnLongClickListener(new gd(this));
        aPk();
        this.etL = (ViewStub) this.dXV.findViewById(t.g.interview_status_stub);
        this.esO = new cj(this.emy, this.bBT);
        this.esO.H(this.bRE);
        this.esO.a(this.ekU);
        this.esO.setOnImageClickListener(this.aJI);
        this.ely = new ge(this);
        this.esO.G(this.ely);
        this.bBT.addHeaderView(this.ese);
        this.bBT.addHeaderView(this.esc);
        this.esT = new PbListView(this.emy.getPageContext().getPageActivity());
        this.aAX = this.esT.getView().findViewById(t.g.pb_more_view);
        if (this.aAX != null) {
            this.aAX.setOnClickListener(this.bRE);
            com.baidu.tbadk.core.util.av.k(this.aAX, t.f.pb_foot_more_trans_selector);
        }
        this.esT.we();
        this.esT.df(t.f.pb_foot_more_trans_selector);
        this.esT.dg(t.f.pb_foot_more_trans_selector);
        this.esV = this.emy.findViewById(t.g.viewstub_progress);
        this.emy.registerListener(this.eus);
        this.esE.i(this.emy.getUniqueId());
    }

    public void aPa() {
        if (this.bBT != null) {
            this.bBT.removeHeaderView(this.ese);
            this.bBT.removeHeaderView(this.esc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPb() {
        if (this.emy.aMY()) {
            this.esa = (ViewStub) this.emy.findViewById(t.g.manga_mention_controller_view_stub);
            this.esa.setVisibility(0);
            if (this.esF == null) {
                this.esF = (LinearLayout) this.emy.findViewById(t.g.manga_controller_layout);
                com.baidu.tbadk.j.a.a(this.emy.getPageContext(), this.esF);
            }
            if (this.esG == null) {
                this.esG = (TextView) this.esF.findViewById(t.g.manga_prev_btn);
            }
            if (this.esH == null) {
                this.esH = (TextView) this.esF.findViewById(t.g.manga_next_btn);
            }
            this.esG.setOnClickListener(this.bRE);
            this.esH.setOnClickListener(this.bRE);
        }
    }

    private void aPc() {
        if (this.emy.aMY()) {
            if (this.emy.aNb() == -1) {
                com.baidu.tbadk.core.util.av.c(this.esG, t.d.cp_cont_e, 1);
            }
            if (this.emy.aNc() == -1) {
                com.baidu.tbadk.core.util.av.c(this.esH, t.d.cp_cont_e, 1);
            }
        }
    }

    public void aPd() {
        if (this.esF == null) {
            aPb();
        }
        this.esa.setVisibility(8);
        if (this.euq != null && this.eur != null) {
            this.euq.removeCallbacks(this.eur);
        }
    }

    private void a(DealInfoData dealInfoData, boolean z) {
        if (this.eua) {
            View findViewWithTag = this.ese.findViewWithTag("pb_god_bottom_line_view_tag");
            if (findViewWithTag != null) {
                this.ese.removeView(findViewWithTag);
            }
            this.esz.setPadding(this.esz.getPaddingLeft(), this.esz.getCompoundPaddingTop(), this.esz.getPaddingRight(), this.emy.getResources().getDimensionPixelSize(t.e.ds10));
            this.esi.setPadding(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(t.e.ds30), TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(t.e.ds20), TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(t.e.ds32), 0);
        } else {
            this.esw.setVisibility(8);
            this.esi.setPadding(this.emy.getResources().getDimensionPixelSize(t.e.ds30), this.emy.getResources().getDimensionPixelSize(t.e.ds18), this.emy.getResources().getDimensionPixelSize(t.e.ds30), this.emy.getResources().getDimensionPixelSize(t.e.ds10));
            ((FloatingLayout) this.ese.findViewById(t.g.pb_head_owner_info_root)).setPadding(0, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(t.e.ds16), 0, 0);
        }
        this.bBT.setOverScrollMode(2);
        this.etv.setPadding(this.etv.getPaddingLeft(), 0, 0, 0);
        com.baidu.tbadk.core.util.av.k(this.etv, t.f.pb_ecomm_comment_bg);
        this.ety.setBackgroundResource(0);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.ety.getLayoutParams();
        marginLayoutParams.rightMargin = this.emy.getResources().getDimensionPixelSize(t.e.ds234);
        this.ety.setLayoutParams(marginLayoutParams);
        TextView textView = (TextView) this.emy.findViewById(t.g.pb_editor_tool_comment_ecomm_buy_layout);
        textView.setVisibility(0);
        View findViewById = this.dXV.findViewById(t.g.pb_editor_tool_comment_layout);
        boolean appResponseToIntentClass = TbadkCoreApplication.m9getInst().appResponseToIntentClass(EcommPersonManagerActivityConfig.class);
        if (z || !appResponseToIntentClass) {
            textView.setVisibility(8);
        } else if (dealInfoData.status != 1) {
            textView.setText(t.j.pb_ecomm_status_off_shelf_text);
            com.baidu.tbadk.core.util.av.l(textView, t.d.cp_other_e_alpha30);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
        } else if (dealInfoData.stock == 0) {
            textView.setText(t.j.pb_ecomm_buy_button_none_text);
            com.baidu.tbadk.core.util.av.l(textView, t.d.cp_other_e_alpha30);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
        } else {
            textView.setText(t.j.pb_ecomm_buy_button_text);
            com.baidu.tbadk.core.util.av.l(textView, t.d.cp_other_e);
            if (this.bRE != null) {
                textView.setOnClickListener(this.bRE);
            }
        }
    }

    public void aPe() {
        if (this.euq != null) {
            if (this.eur != null) {
                this.euq.removeCallbacks(this.eur);
            }
            this.eur = new ez(this);
            this.euq.postDelayed(this.eur, 2000L);
        }
    }

    public void ip(boolean z) {
        this.erX.ip(z);
        if (z && this.etI) {
            this.esT.setText(this.emy.getResources().getString(t.j.click_load_more));
            this.bBT.setNextPage(this.esT);
            this.erW = 2;
        }
    }

    public void aPf() {
        TbadkCoreApplication.m9getInst().setReadThreadPlayerScreenMaxHeight(this.dXV.getHeight());
    }

    public void setEditorTools(com.baidu.tbadk.editortools.l lVar) {
        this.EJ = lVar;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.dXV.addView(this.EJ, layoutParams);
        this.EJ.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        this.EJ.hide();
    }

    public void aPg() {
        if (this.emy != null && this.EJ != null) {
            this.EJ.lw();
        }
    }

    public void oX(String str) {
        if (this.etx != null) {
            if (TextUtils.isEmpty(str)) {
                str = "0";
            }
            this.etx.setText(this.emy.getPageContext().getResources().getString(t.j.pb_reply_count_text, str));
        }
    }

    private void aPh() {
        if (this.etC != null) {
            this.etC.setIsRound(true);
            this.etC.setDrawBorder(false);
            this.etC.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
            if (!StringUtils.isNull(currentPortrait)) {
                String dk = com.baidu.tbadk.core.util.q.dk(currentPortrait);
                this.etC.setUrl(dk);
                this.etC.c(dk, 12, false);
            }
        }
    }

    public void M(String str, boolean z) {
        this.etB = z;
        iq(TbadkCoreApplication.m9getInst().getSkinType() == 1);
    }

    private void iq(boolean z) {
        if (this.etz != null) {
            if (this.etB) {
                com.baidu.tbadk.core.util.av.k(this.etz, t.f.pb_praise_already_click_selector);
                this.etz.setContentDescription(this.emy.getResources().getString(t.j.cancel_praise));
                return;
            }
            com.baidu.tbadk.core.util.av.k(this.etz, t.f.pb_praise_normal_click_selector);
            this.etz.setContentDescription(this.emy.getResources().getString(t.j.frs_item_praise_text));
        }
    }

    public TextView aPi() {
        return this.etz;
    }

    public void ir(boolean z) {
        if (this.bBT != null) {
            if (!z) {
                this.bBT.setEnabled(z);
                return;
            }
            if (this.etW == null) {
                this.etW = new fa(this, z);
            }
            com.baidu.adp.lib.h.h.eG().postDelayed(this.etW, 10L);
        }
    }

    public void is(boolean z) {
        if (this.bBT != null && this.aqI != null && this.bJv != null) {
            if (z) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.bJv.setVisibility(0);
                    this.bBT.removeHeaderView(this.aqI);
                    this.bBT.f(this.aqI, 0);
                } else {
                    this.bJv.setVisibility(8);
                    this.bBT.removeHeaderView(this.aqI);
                }
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.aqI.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = UtilHelper.getLightStatusBarHeight();
                    this.aqI.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.aqI.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + iB(true);
                this.aqI.setLayoutParams(layoutParams2);
            }
            this.bBT.removeHeaderView(this.aqI);
            this.bBT.f(this.aqI, 0);
            aPZ();
        }
    }

    public void aY(View view) {
        boolean z;
        View view2;
        if (this.esN != null && view != null) {
            if (this.etA) {
                z = this.etv.getVisibility() == 0;
            } else {
                z = this.EJ != null && this.EJ.getVisibility() == 0;
            }
            boolean z2 = this.esN.getVisibility() == 0;
            if (z2) {
                TiebaStatic.log("c10084");
                this.eub = true;
                View findViewById = this.emy.findViewById(t.g.bg_above_list);
                if (findViewById != null && findViewById.getLayoutParams() != null) {
                    findViewById.getLayoutParams().height = this.esN.getHeight();
                    findViewById.setLayoutParams(findViewById.getLayoutParams());
                }
                com.baidu.tieba.tbadkCore.a.a(this.emy, this.esN, t.a.top_fold_up, new fb(this, findViewById));
            } else {
                this.eub = false;
                com.baidu.tieba.tbadkCore.a.a(this.emy, this.esN, t.a.top_fold_down, new fc(this));
            }
            if (this.etA) {
                view2 = this.etv;
            } else {
                view2 = this.EJ;
            }
            if (z) {
                if (z2) {
                    if (this.EJ != null) {
                        this.EJ.AS();
                    }
                    com.baidu.tieba.tbadkCore.a.a(this.emy, view2, t.a.bottom_fold_down, new fd(this));
                }
            } else if (!z2) {
                com.baidu.tieba.tbadkCore.a.a(this.emy, view2, t.a.bottom_fold_up, new fe(this));
            }
            aNI();
        }
    }

    public cj aPj() {
        return this.esO;
    }

    public void a(PbActivity.c cVar) {
        this.enN = cVar;
    }

    private void a(com.baidu.tbadk.core.data.bm bmVar) {
        if (bmVar == null || bmVar.sK() == 0) {
            if (this.etu != null) {
                this.etu.setVisibility(8);
            }
            if (this.esJ != null) {
                this.esJ.setVisibility(8);
                return;
            }
            return;
        }
        if (this.etu == null) {
            this.emy.getLayoutMode().x(((ViewStub) this.esc.findViewById(t.g.live_talk_layout)).inflate());
            this.etu = (Button) this.esc.findViewById(t.g.pb_head_function_manage_go_to_live_post);
            this.esJ = this.esc.findViewById(t.g.new_pb_header_item_line_above_livepost);
        }
        int sL = bmVar.sL();
        String string = this.emy.getPageContext().getString(t.j.go_to_live_post_prefix);
        if (sL == 0) {
            string = String.valueOf(string) + this.emy.getPageContext().getString(t.j.go_to_interview_post);
        } else if (sL == 1) {
            string = String.valueOf(string) + this.emy.getPageContext().getString(t.j.go_to_discuss_post);
        }
        this.etu.setText(string);
        this.etu.setVisibility(0);
        this.etu.setOnClickListener(this.bRE);
        this.eux = true;
        aPx();
        aPA();
    }

    private void aPk() {
        this.etE = (LinearLayout) this.esc.findViewById(t.g.btn_show_passed_pb);
        this.etG = (TextView) this.esc.findViewById(t.g.show_pre_page_view);
        this.etF = (TextView) this.esc.findViewById(t.g.go_back_top_view);
        this.aMi = this.esc.findViewById(t.g.show_passed_divider);
        this.etG.setOnClickListener(this.eut);
        this.etF.setOnClickListener(this.bRE);
        aPA();
    }

    public TextView aPl() {
        return this.esx;
    }

    public void it(boolean z) {
        if (this.esx != null) {
            if (z && TbadkCoreApplication.m9getInst().isTTSCanUse() && !this.euo) {
                this.esx.setVisibility(0);
                if (this.etE != null && this.etE.getVisibility() == 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.etE.getLayoutParams();
                    layoutParams.topMargin = com.baidu.adp.lib.util.k.e(this.emy.getApplicationContext(), t.e.ds10);
                    this.etE.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            this.esx.setVisibility(8);
        }
    }

    public void aZ(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, boolean z) {
        SparseArray sparseArray2;
        if (this.esX == null) {
            this.esX = LayoutInflater.from(this.emy.getPageContext().getPageActivity()).inflate(t.h.forum_manage_dialog, (ViewGroup) null);
        }
        this.emy.getLayoutMode().x(this.esX);
        if (this.esW == null) {
            this.esW = new Dialog(this.emy.getPageContext().getPageActivity(), t.k.common_alert_dialog);
            this.esW.setCanceledOnTouchOutside(true);
            this.esW.setCancelable(true);
            this.esW.setContentView(this.esX);
            WindowManager.LayoutParams attributes = this.esW.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.k.K(this.emy.getPageContext().getPageActivity()) * 0.9d);
            this.esW.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.esW.findViewById(t.g.del_post_btn);
        TextView textView2 = (TextView) this.esW.findViewById(t.g.forbid_user_btn);
        TextView textView3 = (TextView) this.esW.findViewById(t.g.disable_reply_btn);
        int intValue = sparseArray.get(t.g.tag_check_mute_from) instanceof Integer ? ((Integer) sparseArray.get(t.g.tag_check_mute_from)).intValue() : -1;
        if ("".equals(sparseArray.get(t.g.tag_del_post_id)) || intValue == 2) {
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
            if ((sparseArray.get(t.g.tag_del_post_type) instanceof Integer ? ((Integer) sparseArray.get(t.g.tag_del_post_type)).intValue() : -1) != 0) {
                textView.setText(t.j.delete);
            } else {
                textView.setText(t.j.delete_post);
            }
            sparseArray2.put(t.g.tag_del_post_id, sparseArray.get(t.g.tag_del_post_id));
            sparseArray2.put(t.g.tag_del_post_type, sparseArray.get(t.g.tag_del_post_type));
            sparseArray2.put(t.g.tag_del_post_is_self, sparseArray.get(t.g.tag_del_post_is_self));
            sparseArray2.put(t.g.tag_manage_user_identity, sparseArray.get(t.g.tag_manage_user_identity));
            textView.setOnClickListener(new ff(this));
        }
        if ("".equals(sparseArray.get(t.g.tag_forbid_user_name)) || aPW()) {
            textView2.setVisibility(8);
        } else {
            SparseArray sparseArray5 = (SparseArray) textView2.getTag();
            if (sparseArray5 == null) {
                sparseArray5 = new SparseArray();
                textView2.setTag(sparseArray5);
            }
            textView2.setVisibility(0);
            sparseArray5.put(t.g.tag_forbid_user_name, sparseArray.get(t.g.tag_forbid_user_name));
            sparseArray5.put(t.g.tag_manage_user_identity, sparseArray.get(t.g.tag_manage_user_identity));
            sparseArray5.put(t.g.tag_forbid_user_post_id, sparseArray.get(t.g.tag_forbid_user_post_id));
            textView2.setOnClickListener(new fg(this));
        }
        if (!((sparseArray.get(t.g.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(t.g.tag_user_mute_visible)).booleanValue())) {
            textView3.setVisibility(8);
        } else {
            SparseArray sparseArray6 = (SparseArray) textView3.getTag();
            if (sparseArray6 == null) {
                sparseArray6 = new SparseArray();
                textView3.setTag(sparseArray6);
            }
            textView3.setVisibility(0);
            if (z) {
                textView3.setText(t.j.un_mute);
            } else {
                textView3.setText(t.j.mute);
            }
            sparseArray6.put(t.g.tag_is_mem, sparseArray.get(t.g.tag_is_mem));
            sparseArray6.put(t.g.tag_user_mute_mute_userid, sparseArray.get(t.g.tag_user_mute_mute_userid));
            sparseArray6.put(t.g.tag_user_mute_mute_username, sparseArray.get(t.g.tag_user_mute_mute_username));
            sparseArray6.put(t.g.tag_user_mute_post_id, sparseArray.get(t.g.tag_user_mute_post_id));
            sparseArray6.put(t.g.tag_user_mute_thread_id, sparseArray.get(t.g.tag_user_mute_thread_id));
            sparseArray6.put(t.g.tag_user_mute_msg, sparseArray.get(t.g.tag_user_mute_msg));
            textView3.setOnClickListener(new fh(this, z));
        }
        com.baidu.adp.lib.h.j.a(this.esW, this.emy.getPageContext());
    }

    public void a(PbActivity.a aVar) {
        this.euu = aVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(t.g.tag_del_post_id, str);
        sparseArray.put(t.g.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(t.g.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(t.g.tag_del_post_is_self, Boolean.valueOf(z));
        sparseArray.put(etQ, Integer.valueOf(etR));
        int i3 = t.j.del_post_confirm;
        if (i == 0) {
            i3 = t.j.del_thread_confirm;
        }
        this.esY = new com.baidu.tbadk.core.dialog.a(this.emy.getActivity());
        this.esY.bZ(i3);
        this.esY.A(sparseArray);
        this.esY.a(t.j.dialog_ok, this.emy);
        this.esY.b(t.j.dialog_cancel, new fi(this));
        this.esY.aq(true);
        this.esY.b(this.emy.getPageContext());
        this.esY.sX();
    }

    public void am(ArrayList<com.baidu.tbadk.core.data.z> arrayList) {
        if (this.etk == null) {
            this.etk = LayoutInflater.from(this.emy.getPageContext().getPageActivity()).inflate(t.h.commit_good, (ViewGroup) null);
        }
        this.emy.getLayoutMode().x(this.etk);
        if (this.etj == null) {
            this.etj = new Dialog(this.emy.getPageContext().getPageActivity(), t.k.common_alert_dialog);
            this.etj.setCanceledOnTouchOutside(true);
            this.etj.setCancelable(true);
            this.ett = (ScrollView) this.etk.findViewById(t.g.good_scroll);
            this.etj.setContentView(this.etk);
            WindowManager.LayoutParams attributes = this.etj.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.k.e(this.emy.getPageContext().getPageActivity(), t.e.ds540);
            this.etj.getWindow().setAttributes(attributes);
            this.etm = new fk(this);
            this.etl = (LinearLayout) this.etk.findViewById(t.g.good_class_group);
            this.eto = (TextView) this.etk.findViewById(t.g.dialog_button_cancel);
            this.eto.setOnClickListener(new fl(this));
            this.etn = (TextView) this.etk.findViewById(t.g.dialog_button_ok);
            this.etn.setOnClickListener(this.bRE);
        }
        this.etl.removeAllViews();
        this.esb = new ArrayList();
        com.baidu.tieba.pb.pb.main.b.a bE = bE("0", this.emy.getPageContext().getString(t.j.def_good_class));
        this.esb.add(bE);
        bE.setChecked(true);
        this.etl.addView(bE);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.tieba.pb.pb.main.b.a bE2 = bE(String.valueOf(arrayList.get(i2).pO()), arrayList.get(i2).pN());
                this.esb.add(bE2);
                View view = new View(this.emy.getPageContext().getPageActivity());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.e(this.emy.getPageContext().getPageActivity(), t.e.ds1));
                com.baidu.tbadk.core.util.av.l(view, t.d.cp_bg_line_a);
                view.setLayoutParams(layoutParams);
                this.etl.addView(view);
                this.etl.addView(bE2);
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.ett.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.k.dip2px(this.emy.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.k.dip2px(this.emy.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.k.dip2px(this.emy.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.ett.setLayoutParams(layoutParams2);
            this.ett.removeAllViews();
            this.ett.addView(this.etl);
        }
        com.baidu.adp.lib.h.j.a(this.etj, this.emy.getPageContext());
    }

    private com.baidu.tieba.pb.pb.main.b.a bE(String str, String str2) {
        Activity pageActivity = this.emy.getPageContext().getPageActivity();
        com.baidu.tieba.pb.pb.main.b.a aVar = new com.baidu.tieba.pb.pb.main.b.a(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.k.e(pageActivity, t.e.ds100));
        aVar.setOnCheckedChangeListener(this.etm);
        aVar.setTag(str);
        aVar.setText(str2);
        aVar.setLayoutParams(layoutParams);
        return aVar;
    }

    public void aPm() {
        this.emy.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.emy.hideProgressBar();
        if (z && z2) {
            this.emy.showToast(this.emy.getPageContext().getString(t.j.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.ba.isEmpty(str)) {
                str = TbadkCoreApplication.m9getInst().getResources().getString(t.j.neterror);
            }
            this.emy.showToast(str);
        }
    }

    public void aud() {
        this.esV.setVisibility(0);
    }

    public void auc() {
        this.esV.setVisibility(8);
    }

    public View aPn() {
        if (this.etk != null) {
            return this.etk.findViewById(t.g.dialog_button_ok);
        }
        return null;
    }

    public String aPo() {
        return this.etp;
    }

    public View getView() {
        return this.dXV;
    }

    public void aPp() {
        com.baidu.adp.lib.util.k.b(this.emy.getPageContext().getPageActivity(), this.emy.getCurrentFocus());
    }

    public void aAD() {
        this.emy.showProgressBar();
    }

    public void iu(boolean z) {
        this.emy.hideProgressBar();
        aAE();
    }

    public void aPq() {
        this.esT.wl();
    }

    public void aPr() {
    }

    public void aPs() {
        this.emy.hideProgressBar();
        this.esT.wm();
        aKF();
        this.bBT.l(2000L);
        aPA();
    }

    public void aPt() {
        this.bBT.l(2000L);
        this.etE.setVisibility(8);
        aPA();
    }

    public void iv(boolean z) {
        this.esh.f(this.esh.aNJ(), z);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.ety.getLayoutParams();
        marginLayoutParams.rightMargin = z ? this.emy.getResources().getDimensionPixelSize(t.e.ds84) : 0;
        this.ety.setLayoutParams(marginLayoutParams);
    }

    private void iw(boolean z) {
        int i;
        int i2;
        int dimensionPixelSize = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(t.e.ds16);
        int dimensionPixelSize2 = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(t.e.ds16);
        int dimensionPixelSize3 = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(t.e.ds84);
        int dimensionPixelSize4 = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(t.e.ds14);
        if (z) {
            i = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(t.e.ds16);
            i2 = 0;
        } else {
            i = dimensionPixelSize;
            i2 = dimensionPixelSize3;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ety.getLayoutParams();
        layoutParams.setMargins(i, dimensionPixelSize2, i2, dimensionPixelSize4);
        this.ety.setLayoutParams(layoutParams);
    }

    public void c(com.baidu.tbadk.core.data.ab abVar) {
        this.esh.c(abVar);
    }

    public boolean aNG() {
        return this.esh.aNG();
    }

    public void aNH() {
        this.esh.aNH();
    }

    public void aNI() {
        this.esh.aNI();
    }

    public ImageView aPu() {
        return this.etD;
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.esO.setOnLongClickListener(onLongClickListener);
    }

    public void a(c.b bVar, boolean z, boolean z2) {
        if (this.etq != null) {
            this.etq.dismiss();
            this.etq = null;
        }
        this.etq = new com.baidu.tbadk.core.dialog.c(this.emy.getPageContext().getPageActivity());
        this.etq.cc(t.j.operation);
        if (z2) {
            this.etq.a(new String[]{this.emy.getPageContext().getString(t.j.copy)}, bVar);
        } else if (!z) {
            this.etq.a(new String[]{this.emy.getPageContext().getString(t.j.copy), this.emy.getPageContext().getString(t.j.mark)}, bVar);
        } else {
            this.etq.a(new String[]{this.emy.getPageContext().getString(t.j.copy), this.emy.getPageContext().getString(t.j.remove_mark)}, bVar);
        }
        this.etq.d(this.emy.getPageContext());
        this.etq.ta();
    }

    public int aPv() {
        return os(this.bBT.getFirstVisiblePosition());
    }

    private int os(int i) {
        com.baidu.adp.widget.ListView.e eVar = (com.baidu.adp.widget.ListView.e) this.bBT.getAdapter();
        if (eVar != null) {
            if (i < eVar.getCount() && i >= 0 && (eVar.getItem(i) instanceof com.baidu.tieba.pb.data.f)) {
                i++;
            }
            int headerViewsCount = (eVar.getHeaderViewsCount() + eVar.kq()) - 1;
            if (i > headerViewsCount) {
                i = headerViewsCount;
            }
            int headersCount = (this.bBT.getAdapter() == null || !(this.bBT.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) ? 0 : ((com.baidu.adp.widget.ListView.e) this.bBT.getAdapter()).getHeadersCount();
            return i > headersCount ? i - headersCount : 0;
        }
        return i;
    }

    public int aPw() {
        return os(this.bBT.getLastVisiblePosition());
    }

    public void setSelection(int i) {
        this.bBT.setSelection(i);
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.esR.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void j(com.baidu.tieba.pb.data.h hVar) {
        this.esO.b(hVar);
        this.esO.notifyDataSetChanged();
        if (hVar == null) {
            oX("");
        } else {
            oX(com.baidu.tbadk.core.util.ba.y(hVar.aLQ().rv()));
        }
        aPA();
    }

    public void k(com.baidu.tieba.pb.data.h hVar) {
        PraiseData rt;
        if (this.esC == null) {
            this.emy.getLayoutMode().x(((ViewStub) this.esc.findViewById(t.g.praise_layout)).inflate());
            this.esC = (FrsPraiseView) this.esc.findViewById(t.g.pb_head_praise_view);
            this.esC.setIsFromPb(true);
            this.esL = this.esc.findViewById(t.g.new_pb_header_item_line_above_praise);
            this.esC.dl(TbadkCoreApplication.m9getInst().getSkinType());
        }
        if (this.esC != null) {
            boolean aPA = aPA();
            if (hVar != null && hVar.aLR() != null && hVar.aLR().size() > 0) {
                com.baidu.tieba.tbadkCore.data.q qVar = hVar.aLR().get(0);
                if ((!this.elu || qVar.bjc() != 1) && (rt = hVar.aLQ().rt()) != null && rt.getUser() != null && rt.getUser().size() > 0) {
                    this.esC.setVisibility(0);
                    this.esC.setIsFromPb(true);
                    this.esC.a(rt, hVar.aLQ().getId(), rt.getPostId(), true);
                    this.esC.getVisibility();
                    com.baidu.tieba.graffiti.d.al(this.esC);
                    return;
                }
            }
            this.esC.setVisibility(8);
            if (hVar != null && hVar.getPage() != null && hVar.getPage().qr() == 0 && this.elu) {
                if (aPA) {
                    this.esK.setVisibility(0);
                } else {
                    this.esK.setVisibility(8);
                }
            } else {
                this.esK.setVisibility(8);
            }
            com.baidu.tieba.graffiti.d.al(this.esK);
        }
    }

    private com.baidu.tieba.tbadkCore.data.q a(com.baidu.tieba.pb.data.h hVar, boolean z, int i) {
        if (z) {
            if (hVar == null || hVar.aLR() == null || hVar.aLR().size() <= 0) {
                return null;
            }
            com.baidu.tieba.tbadkCore.data.q qVar = hVar.aLR().get(0);
            if (qVar.bjc() != 1) {
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
        if (hVar == null || hVar.aLQ() == null || hVar.aLQ().getAuthor() == null) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.q qVar = new com.baidu.tieba.tbadkCore.data.q();
        MetaData author = hVar.aLQ().getAuthor();
        String userId = author.getUserId();
        HashMap<String, MetaData> userMap = hVar.aLQ().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = author;
        }
        qVar.ry(1);
        qVar.setId(hVar.aLQ().rQ());
        qVar.setTitle(hVar.aLQ().getTitle());
        qVar.setTime(hVar.aLQ().getCreateTime());
        qVar.setAuthor(metaData);
        return qVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v282, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void b(com.baidu.tieba.pb.data.h hVar, boolean z, int i) {
        if (hVar != null && hVar.aLQ() != null) {
            if (hVar.aLR() != null && hVar.aLR().size() > 0 && hVar.aLR().get(0) != null) {
                String str = null;
                if (this.emy.aNi()) {
                    str = "FRS";
                }
                if (hVar.aLR().get(0).bjc() == 1 && hVar.aLR().get(0).rU() != null) {
                    this.esj.a(this.emy.getPageContext(), hVar.aLR().get(0).rU(), com.baidu.tieba.tbadkCore.d.a.b("PB", "c0132", hVar.aLP().getId(), hVar.aLP().getName(), hVar.aLQ().getId(), str));
                    this.esi.setPadding(this.esi.getPaddingLeft(), (int) this.emy.getResources().getDimension(t.e.ds20), this.esi.getPaddingRight(), this.esi.getPaddingBottom());
                } else {
                    this.esj.a(null, null, null);
                }
            }
            aPX();
            this.esi.setVisibility(8);
            com.baidu.tieba.tbadkCore.data.q a = a(hVar, z, i);
            if (a != null) {
                String str2 = null;
                boolean z2 = false;
                if (hVar != null && hVar.aLQ() != null && hVar.aLQ().getAuthor() != null) {
                    str2 = hVar.aLQ().getAuthor().getUserId();
                    if (hVar.getPage() != null) {
                        this.euf = hVar.getPage().qn();
                        z2 = hVar.getPage().qq() == 1;
                    }
                }
                boolean sm = hVar.aLQ().sm();
                if (a.getAuthor() != null && a.getAuthor().getUserTbVipInfoData() != null) {
                    this.adQ = !StringUtils.isNull(a.getAuthor().getUserTbVipInfoData().getvipV_url());
                }
                this.eua = !sm && b(a, hVar.aLQ().getId(), str2, z2, z);
                if (z) {
                    this.esB.setVisibility(8);
                } else if (!this.euo) {
                    this.esB.setVisibility(0);
                }
                this.esi.setVisibility(0);
                if (this.esf != null && this.esf.ejN != null && this.esf.ejO != null && hVar.aLQ() != null && hVar.aLQ().Uw != null) {
                    this.esM = true;
                    DealInfoData sx = hVar.aLQ().sx();
                    String userId = hVar.aLQ().getAuthor().getUserId();
                    boolean z3 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
                    com.baidu.tieba.pb.data.b bVar = new com.baidu.tieba.pb.data.b(1);
                    bVar.ejN = this.esf.ejN;
                    bVar.ejO = this.esf.ejO;
                    bVar.ejK = sx;
                    bVar.aLC();
                    a(a, hVar.aLQ().getId(), str2, z2, z);
                    a(sx, z3);
                    if (this.ese != null) {
                        this.bBT.removeHeaderView(this.ese);
                    }
                    if (this.esc != null) {
                        this.bBT.removeHeaderView(this.esc);
                    }
                    com.baidu.tieba.pb.data.b bVar2 = new com.baidu.tieba.pb.data.b(2);
                    bVar2.ejN = this.esf.ejN;
                    bVar2.ejO = this.esf.ejO;
                    bVar2.aOh = this.ese;
                    bVar2.bBT = this.bBT;
                    bVar2.aLC();
                    this.bBT.addHeaderView(this.esc);
                    aPN();
                    if (this.emy.aME() != null) {
                        this.emy.aME().iD(true);
                    }
                }
                SparseArray sparseArray = (SparseArray) this.esi.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    this.esi.setTag(sparseArray);
                }
                sparseArray.put(t.g.tag_clip_board, a);
                sparseArray.put(t.g.tag_is_subpb, false);
                this.esv.setText(com.baidu.tbadk.core.util.ba.t(a.getTime()));
                this.esw.setText(String.format(this.emy.getPageContext().getString(t.j.is_floor), Integer.valueOf(a.bjc())));
                hVar.aLQ().sj();
                if (!this.euo) {
                    this.esk.setVisibility(0);
                }
                if (!hVar.aLQ().sn() && this.esk.getText() != null && this.esk.getText().length() > 0) {
                    this.esk.setVisibility(0);
                } else {
                    this.esk.setVisibility(8);
                }
                k(hVar);
                ArrayList<com.baidu.tbadk.core.data.a> rL = hVar.aLQ().rL();
                if (rL != null && rL.size() > 0 && !this.euo) {
                    this.etK.setText(String.valueOf(rL.get(0).pa()));
                    this.etJ.setVisibility(0);
                    this.euw = true;
                } else {
                    this.etJ.setVisibility(8);
                }
                com.baidu.tbadk.core.util.av.k(this.etJ, t.f.activity_join_num_bg);
                com.baidu.tbadk.core.util.av.c(this.etK, t.d.cp_link_tip_d, 1);
                if (hVar != null && hVar.aLQ() != null && hVar.aLQ().getAuthor() != null) {
                    String userId2 = hVar.aLQ().getAuthor().getUserId();
                    if (userId2 != null && !userId2.equals("0") && userId2.equals(a.getAuthor().getUserId())) {
                        this.esu.setVisibility(0);
                        this.esu.setAlpha(SocialAPIErrorCodes.ERROR_INVALID_BDUSS);
                    } else {
                        this.esu.setVisibility(8);
                    }
                }
                if (a.getAuthor() != null) {
                    int level_id = a.getAuthor().getLevel_id();
                    int is_bawu = a.getAuthor().getIs_bawu();
                    String bawu_type = a.getAuthor().getBawu_type();
                    int i2 = 3;
                    if (level_id != 0) {
                        this.esp.setVisibility(0);
                        com.baidu.tbadk.core.util.av.c(this.esp, BitmapHelper.getGradeResourceIdNew(level_id));
                        this.esp.setAlpha(SocialAPIErrorCodes.ERROR_INVALID_BDUSS);
                        this.esp.setContentDescription(String.format(TbadkCoreApplication.m9getInst().getString(t.j.degree_in_forum), Integer.valueOf(level_id)));
                        this.esp.setOnClickListener(null);
                    } else {
                        this.esp.setVisibility(8);
                    }
                    if (is_bawu != 0) {
                        this.esr.setAlpha(SocialAPIErrorCodes.ERROR_INVALID_BDUSS);
                        if (bawu_type.equals("manager")) {
                            com.baidu.tbadk.core.util.av.c(this.esr, t.f.pb_manager);
                            this.esp.setVisibility(8);
                            this.esr.setVisibility(0);
                        } else if (bawu_type.equals("assist")) {
                            com.baidu.tbadk.core.util.av.c(this.esr, t.f.pb_assist);
                            this.esp.setVisibility(8);
                            this.esr.setVisibility(0);
                        }
                    }
                    this.esq.setAlpha(SocialAPIErrorCodes.ERROR_INVALID_BDUSS);
                    if (a.getAuthor().getGender() == 2) {
                        com.baidu.tbadk.core.util.av.c(this.esq, t.f.icon_pb_pop_girl);
                        this.esq.setVisibility(0);
                    } else if (a.getAuthor().getGender() == 1) {
                        com.baidu.tbadk.core.util.av.c(this.esq, t.f.icon_pb_pop_boy);
                        this.esq.setVisibility(0);
                    } else {
                        this.esq.setVisibility(8);
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
                    if (this.ess != null) {
                        this.ess.setTag(t.g.tag_user_id, a.getAuthor().getUserId());
                        this.ess.setOnClickListener(this.emy.eni.bUu);
                        this.ess.wC();
                        this.ess.a(iconInfo, i2, this.emy.getResources().getDimensionPixelSize(t.e.ds30), this.emy.getResources().getDimensionPixelSize(t.e.ds30), this.emy.getResources().getDimensionPixelSize(t.e.ds10));
                    }
                    if (this.est != null) {
                        if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                            this.est.setTag(tShowInfoNew.get(0).getUrl());
                        }
                        this.est.setOnClickListener(this.emy.eni.euR);
                        this.est.a(tShowInfoNew, 3, this.emy.getResources().getDimensionPixelSize(t.e.ds32), this.emy.getResources().getDimensionPixelSize(t.e.ds32), this.emy.getResources().getDimensionPixelSize(t.e.ds8), true);
                    }
                    if (com.baidu.adp.lib.util.j.aR(string) > 14) {
                        this.esl.setText(com.baidu.tbadk.core.util.ba.d(a.getAuthor().getName_show(), 14, "..."));
                    } else {
                        this.esl.setText(a.getAuthor().getName_show());
                    }
                    this.esl.setTag(t.g.tag_user_id, a.getAuthor().getUserId());
                    this.esl.setTag(t.g.tag_user_name, a.getAuthor().getName_show());
                    if (!com.baidu.tbadk.core.util.y.t(tShowInfoNew)) {
                        com.baidu.tbadk.core.util.av.c(this.esl, t.d.cp_cont_h, 1);
                    } else {
                        com.baidu.tbadk.core.util.av.c(this.esl, t.d.cp_cont_f, 1);
                    }
                    this.eso.setUserId(a.getAuthor().getUserId());
                    this.eso.setUserName(a.getAuthor().getUserName());
                    this.eso.setImageDrawable(null);
                    this.eso.setRadius(com.baidu.adp.lib.util.k.e(this.emy.getActivity(), t.e.ds35));
                    this.eso.setTag(a.getAuthor().getUserId());
                    if (!PbNormalLikeButtonSwitchStatic.GL() || this.ets || this.eua || (a.getAuthor().hadConcerned() && a.getAuthor().getGodUserData() != null && a.getAuthor().getGodUserData().getIsFromNetWork())) {
                        this.esE.setVisibility(8);
                    } else {
                        this.esE.setVisibility(0);
                        this.esE.setMode(2);
                        this.esE.setData(a.getAuthor());
                    }
                    String portrait = a.getAuthor().getPortrait();
                    if (a.getAuthor() != null && a.getAuthor().getPendantData() != null && !StringUtils.isNull(a.getAuthor().getPendantData().rc())) {
                        if (!this.elt) {
                            this.eso.setVisibility(8);
                            this.esn.setVisibility(8);
                        } else {
                            this.eso.setVisibility(8);
                            this.esn.setVisibility(0);
                        }
                        if (this.eqL != null) {
                            this.eqL.setVisibility(8);
                        }
                        this.esl.setOnClickListener(this.emy.eni.euQ);
                        this.esq.setVisibility(0);
                        this.esl.setOnClickListener(this.emy.eni.euQ);
                        this.esq.setVisibility(0);
                        this.esn.getHeadView().c(portrait, 28, false);
                        this.esn.getHeadView().setUserId(a.getAuthor().getUserId());
                        this.esn.getHeadView().setUserName(a.getAuthor().getUserName());
                        this.esn.getHeadView().setOnClickListener(this.emy.eni.euQ);
                        this.esn.dU(a.getAuthor().getPendantData().rc());
                    } else if (this.adQ) {
                        if (!this.elt) {
                            this.eso.setVisibility(8);
                        } else {
                            this.eso.setVisibility(0);
                            UserTbVipInfoData userTbVipInfoData = a.getAuthor().getUserTbVipInfoData();
                            if (userTbVipInfoData != null && userTbVipInfoData.getvipV_url() != null && this.aYe != null) {
                                if (this.aYf == null) {
                                    this.aYe.inflate();
                                    this.aYf = (TbImageView) this.esi.findViewById(t.g.user_head_mask);
                                }
                                this.aYf.c(userTbVipInfoData.getvipV_url(), 10, false);
                            }
                            this.esv.setVisibility(8);
                        }
                        this.esw.setVisibility(8);
                        this.esl.setOnClickListener(this.emy.eni.euQ);
                        this.eso.setOnClickListener(this.emy.eni.euQ);
                        this.esq.setVisibility(0);
                        this.esq.setVisibility(8);
                        this.esn.setVisibility(8);
                    } else {
                        if (this.eua) {
                            fm fmVar = new fm(this, a);
                            this.esl.setOnClickListener(fmVar);
                            this.eso.setOnClickListener(fmVar);
                            this.eso.setVisibility(8);
                            this.esv.setVisibility(8);
                            this.esw.setVisibility(8);
                            this.esq.setVisibility(8);
                            this.esn.setVisibility(8);
                        } else {
                            if (!this.elt) {
                                this.eso.setVisibility(8);
                            } else {
                                this.eso.setVisibility(0);
                            }
                            this.esl.setOnClickListener(this.emy.eni.euQ);
                            this.eso.setOnClickListener(this.emy.eni.euQ);
                            this.esq.setVisibility(0);
                        }
                        this.esn.setVisibility(8);
                    }
                    this.eso.c(portrait, 28, false);
                }
                aPx();
                if (hVar != null) {
                    this.esg.s(hVar.aLQ());
                }
            }
        }
    }

    private void aPx() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.esx.getLayoutParams();
        int i = layoutParams.topMargin;
        int i2 = layoutParams.bottomMargin;
        if (this.euw) {
            i = com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst(), t.e.ds20);
        }
        if (this.eux) {
            i2 = com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst(), t.e.ds24);
        }
        layoutParams.setMargins(layoutParams.leftMargin, i, layoutParams.rightMargin, i2);
        this.esx.setLayoutParams(layoutParams);
    }

    public boolean aPy() {
        return this.euy;
    }

    private boolean aPz() {
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.userId);
    }

    private boolean g(com.baidu.tbadk.core.data.bg bgVar) {
        if (bgVar == null || bgVar.getAuthor() == null || bgVar.getAuthor().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bgVar.getAuthor().getUserId());
    }

    public void a(com.baidu.tieba.pb.data.g gVar) {
        if (gVar != null) {
            this.erX.aQi();
            if (!StringUtils.isNull(gVar.forumName)) {
                this.erX.mI(gVar.forumName);
            }
            String string = this.emy.getResources().getString(t.j.thread_delete_by);
            String str = "";
            switch (com.baidu.adp.lib.h.b.g(gVar.source, 0)) {
                case 100:
                    str = this.emy.getResources().getString(t.j.self);
                    break;
                case 300:
                    str = this.emy.getResources().getString(t.j.bawu);
                    break;
                case 400:
                    str = this.emy.getResources().getString(t.j.system);
                    break;
            }
            this.emy.showNetRefreshView(this.dXV, String.format(string, str), null, this.emy.getResources().getString(t.j.appeal_restore), true, new fn(this, gVar.ejY));
        }
    }

    public void a(com.baidu.tieba.pb.data.h hVar, int i, int i2, boolean z, int i3, boolean z2) {
        Parcelable aOR;
        Parcelable aOR2;
        String sb;
        if (hVar != null) {
            if (hVar.aLQ() != null) {
                this.etN = hVar.aLQ().rr();
                this.Um = hVar.aLQ().ro();
                if (hVar.aLQ().getAnchorLevel() != 0) {
                    this.euy = true;
                }
                this.ets = g(hVar.aLQ());
            }
            if (hVar.getUserData() != null) {
                this.userId = hVar.getUserData().getUserId();
            }
            n(hVar);
            this.etI = false;
            this.elu = z;
            aPs();
            b(hVar, z, i);
            if (this.emy.aMY()) {
                if (this.esS == null) {
                    this.esS = new com.baidu.tieba.pb.view.w(this.emy.getPageContext());
                    this.esS.kk();
                    this.esS.a(this.agd);
                }
                this.bBT.setPullRefresh(this.esS);
                this.bBT.removeHeaderView(this.aqI);
                this.bBT.f(this.aqI, 0);
                if (this.esS != null) {
                    this.esS.dh(TbadkCoreApplication.m9getInst().getSkinType());
                }
            } else if (hVar.getPage().qr() == 0 && z) {
                this.bBT.setPullRefresh(null);
                this.erV = 0;
                this.etE.setVisibility(8);
            } else {
                if (this.esS == null) {
                    this.esS = new com.baidu.tieba.pb.view.w(this.emy.getPageContext());
                    this.esS.kk();
                    this.esS.a(this.agd);
                }
                this.bBT.setPullRefresh(this.esS);
                this.bBT.removeHeaderView(this.aqI);
                this.bBT.f(this.aqI, 0);
                this.erV = 1;
                if (this.esS != null) {
                    this.esS.dh(TbadkCoreApplication.m9getInst().getSkinType());
                }
                this.etE.setVisibility(0);
                aKF();
            }
            aPA();
            boolean z3 = this.etE.getVisibility() == 0;
            this.esO.hP(this.elu);
            this.esO.hQ(z3);
            this.esO.b(hVar);
            this.esO.notifyDataSetChanged();
            if (hVar.aLP() != null) {
                this.mForumName = hVar.aLP().getName();
                this.mForumId = hVar.getForumId();
            }
            this.erX.mI(this.mForumName);
            if (hVar.aLQ() != null) {
                oX(com.baidu.tbadk.core.util.ba.y(hVar.aLQ().rv()));
                if (hVar.aLQ().rt() != null) {
                    if (hVar.aLQ().rt().getNum() < 1) {
                        sb = this.emy.getResources().getString(t.j.frs_item_praise_text);
                    } else {
                        sb = new StringBuilder(String.valueOf(hVar.aLQ().rt().getNum())).toString();
                    }
                    if (this.erU != -1) {
                        hVar.aLQ().rt().setIsLike(this.erU);
                    }
                    M(sb, hVar.aLQ().rt().getIsLike() == 1);
                }
            }
            if (hVar.getPage().qq() == 0 && !z) {
                this.bBT.setNextPage(null);
                this.erW = 1;
            } else if (this.emy.isLogin()) {
                this.bBT.setNextPage(this.esT);
                this.erW = 2;
                aKF();
            } else if (hVar.getPage().qq() == 1) {
                this.etI = true;
                if (this.esU == null) {
                    this.esU = new com.baidu.tieba.pb.view.d(this.emy.getPageContext());
                }
                this.bBT.setNextPage(this.esU);
                this.erW = 3;
            }
            ArrayList<com.baidu.tieba.tbadkCore.data.q> aLR = hVar.aLR();
            if (hVar.getPage().qq() == 0 || aLR == null || aLR.size() < hVar.getPage().qp()) {
                this.esT.setText(this.emy.getResources().getString(t.j.list_no_more));
                if (this.emy.aMY() && this.bBT != null && this.bBT.getData() != null && this.bBT.getData().size() == 1 && (this.bBT.getData().get(0) instanceof com.baidu.tieba.pb.data.l)) {
                    this.esT.setText("");
                }
                m(hVar);
            } else if (z2) {
                if (this.euv) {
                    wm();
                    if (hVar.getPage().qq() != 0) {
                        this.esT.setText(this.emy.getResources().getString(t.j.pb_load_more));
                    }
                } else {
                    this.esT.wn();
                }
            } else {
                this.esT.wn();
            }
            if (z) {
                this.etF.setVisibility(0);
                this.aMi.setVisibility(0);
                this.etG.setText(this.emy.getResources().getString(t.j.btn_show_passed_pb));
            } else {
                this.etF.setVisibility(8);
                this.aMi.setVisibility(8);
                this.etG.setText(this.emy.getResources().getString(t.j.btn_show_passed_pb_aftre));
            }
            if (hVar.aLQ() != null && hVar.aLQ().getAuthor() != null && hVar.aLQ().getAuthor().getType() == 0) {
                this.erX.aQf();
            }
            switch (i) {
                case 2:
                    this.bBT.setSelection(i2 > 1 ? i2 - 2 : 0);
                    if (this.esd != null) {
                        CompatibleUtile.scrollListViewBy(this.bBT, -this.esd.getHeight(), 0);
                        break;
                    }
                    break;
                case 3:
                    if (i3 == 1 && (aOR2 = ep.aOQ().aOR()) != null) {
                        this.bBT.onRestoreInstanceState(aOR2);
                        break;
                    } else {
                        this.bBT.setSelection(0);
                        break;
                    }
                    break;
                case 4:
                    this.euv = false;
                    this.bBT.setSelection(0);
                    break;
                case 5:
                    this.bBT.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1 && (aOR = ep.aOQ().aOR()) != null) {
                        this.bBT.onRestoreInstanceState(aOR);
                        break;
                    } else {
                        this.bBT.setSelection(0);
                        break;
                    }
            }
            if (this.etN == etP && aPz()) {
                aPR();
            }
        }
    }

    public void ix(boolean z) {
        this.etr = z;
        this.erX.ix(z);
    }

    public void wm() {
        if (this.esT != null) {
            this.esT.wm();
        }
        aKF();
    }

    public void OG() {
        this.bBT.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aPA() {
        boolean z;
        boolean z2 = true;
        if (this.esd != null && this.esd.getVisibility() == 0) {
            if (this.esI != null) {
                this.esI.setVisibility(0);
                z = true;
            } else {
                z = true;
            }
        } else {
            if (this.esI != null) {
                this.esI.setVisibility(8);
            }
            z = false;
        }
        if (this.etu != null && this.etu.getVisibility() == 0) {
            if (this.esJ != null) {
                this.esJ.setVisibility(0);
            }
        } else {
            if (this.esJ != null) {
                this.esJ.setVisibility(8);
            }
            z2 = z;
        }
        if ((this.esL == null || this.esL.getVisibility() == 8) && z2 && this.elu) {
            this.esK.setVisibility(0);
        } else {
            this.esK.setVisibility(8);
        }
        com.baidu.tieba.graffiti.d.al(this.esK);
        return z2;
    }

    private boolean l(com.baidu.tieba.pb.data.h hVar) {
        if (hVar == null || hVar.aLQ() == null) {
            return false;
        }
        if (hVar.aLQ().rz() == 1 || hVar.aLQ().getThreadType() == 33) {
            return true;
        }
        return !(hVar.aLQ().rB() == null || hVar.aLQ().rB().sK() == 0) || hVar.aLQ().rx() == 1 || hVar.aLQ().ry() == 1 || hVar.aLQ().sf() || hVar.aLQ().ss() || hVar.aLQ().sm() || hVar.aLQ().rM() != null || hVar.aLQ().st() || hVar.aLQ().st() || !com.baidu.tbadk.core.util.ba.isEmpty(hVar.aLQ().ru());
    }

    public boolean a(com.baidu.tieba.pb.data.h hVar, boolean z, boolean z2) {
        if (hVar == null) {
            return false;
        }
        if (this.esk != null) {
            if (hVar.aLQ().rP() == 0 && !hVar.aLQ().sn() && !this.euo) {
                this.esk.setVisibility(0);
                hVar.aLQ().sj();
                if (l(hVar)) {
                    hVar.aLQ().e(true, true);
                } else {
                    hVar.aLQ().e(true, false);
                }
                SpannableStringBuilder sa = hVar.aLQ().sa();
                this.esk.setOnTouchListener(new com.baidu.tieba.view.y(sa));
                this.esk.setText(sa);
            } else {
                this.esk.setVisibility(8);
                this.euw = true;
                aPx();
            }
        }
        this.elu = z;
        com.baidu.tbadk.core.data.bg aLQ = hVar.aLQ();
        if (aLQ != null) {
            a(aLQ.rB());
        }
        if (hVar.aLX() != 1 || t(aLQ) || aLQ == null || aLQ.st()) {
            return false;
        }
        aPB();
        Button button = (Button) this.esc.findViewById(t.g.pb_head_function_manage_commit_top);
        Button button2 = (Button) this.esc.findViewById(t.g.pb_head_function_manage_cancel_top);
        Button button3 = (Button) this.esc.findViewById(t.g.pb_head_function_manage_commit_good);
        Button button4 = (Button) this.esc.findViewById(t.g.pb_head_function_manage_cancel_good);
        button.setOnClickListener(this.bRE);
        button2.setOnClickListener(this.bRE);
        button3.setOnClickListener(this.bRE);
        button4.setOnClickListener(this.bRE);
        if (hVar.aLQ().ry() == 1) {
            button3.setVisibility(8);
            button4.setVisibility(0);
        } else {
            button3.setVisibility(0);
            button4.setVisibility(8);
        }
        if (hVar.aLQ().rx() == 1) {
            button.setVisibility(8);
            button2.setVisibility(0);
        } else {
            button.setVisibility(0);
            button2.setVisibility(8);
        }
        if (hVar.aLQ().ss() && hVar.aLQ().sc() == 2) {
            button.setEnabled(false);
            com.baidu.tbadk.core.util.av.j((View) button, t.d.cp_cont_d);
        }
        return true;
    }

    private boolean t(com.baidu.tbadk.core.data.bg bgVar) {
        if (bgVar == null) {
            return false;
        }
        return bgVar.isDeal && bgVar.Uw != null;
    }

    private void aPB() {
        if (this.esd == null) {
            this.esd = ((ViewStub) this.esc.findViewById(t.g.pb_header_function_manage)).inflate();
            this.emy.getLayoutMode().x(this.esd);
            this.esI = this.esc.findViewById(t.g.new_pb_header_item_line_above_manage);
            return;
        }
        this.esd.setVisibility(0);
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
                if (hVar.aLX() != 0 && a.getAuthor() != null && !t(hVar.aLQ())) {
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
                    String userId3 = hVar.aLQ().getAuthor().getUserId();
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
                        sparseArray.put(t.g.tag_forbid_user_name, a.getAuthor().getUserName());
                        sparseArray.put(t.g.tag_forbid_user_post_id, a.getId());
                    }
                    sparseArray.put(t.g.tag_del_post_id, a.getId());
                    sparseArray.put(t.g.tag_del_post_type, 0);
                    sparseArray.put(t.g.tag_del_post_is_self, Boolean.valueOf(z3));
                    sparseArray.put(t.g.tag_manage_user_identity, Integer.valueOf(hVar.aLX()));
                    sparseArray.put(t.g.tag_should_manage_visible, true);
                    a(t.j.manage, sparseArray, hVar);
                } else if (z4) {
                    SparseArray<Object> sparseArray2 = new SparseArray<>();
                    sparseArray2.put(t.g.tag_del_post_id, a.getId());
                    sparseArray2.put(t.g.tag_del_post_type, 0);
                    sparseArray2.put(t.g.tag_del_post_is_self, Boolean.valueOf(z3));
                    sparseArray2.put(t.g.tag_manage_user_identity, Integer.valueOf(hVar.aLX()));
                    sparseArray2.put(t.g.tag_should_manage_visible, false);
                    a(t.j.delete, sparseArray2, hVar);
                }
            }
            aPA();
        }
    }

    private void a(int i, SparseArray<Object> sparseArray, com.baidu.tieba.pb.data.h hVar) {
        if (hVar != null && hVar.aLQ() != null && !hVar.aLQ().st()) {
            aPB();
            Button button = (Button) this.esc.findViewById(t.g.pb_head_function_manage_delormanage);
            button.setOnClickListener(this.bRE);
            button.setVisibility(0);
            button.setText(i);
            button.setTag(sparseArray);
        }
    }

    public View getNextView() {
        return this.aAX;
    }

    public void oY(String str) {
        if (this.esT != null && !StringUtils.isNull(str)) {
            this.esT.setText(str);
        }
    }

    public BdListView Os() {
        return this.bBT;
    }

    public int aPC() {
        return t.g.richText;
    }

    public int abF() {
        return t.g.user_icon_box;
    }

    public Button aPD() {
        return (Button) this.esc.findViewById(t.g.pb_head_function_manage_commit_good);
    }

    public Button aPE() {
        return (Button) this.esc.findViewById(t.g.pb_head_function_manage_cancel_good);
    }

    public Button aPF() {
        return (Button) this.esc.findViewById(t.g.pb_head_function_manage_commit_top);
    }

    public Button aPG() {
        return (Button) this.esc.findViewById(t.g.pb_head_function_manage_cancel_top);
    }

    public TextView aMA() {
        return this.esg.aMA();
    }

    public void c(BdListView.e eVar) {
        this.bBT.setOnSrollToBottomListener(eVar);
    }

    public void a(t.b bVar) {
        this.agd = bVar;
        if (this.esS != null) {
            this.esS.a(bVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.ak akVar, a.b bVar) {
        if (akVar != null) {
            int qo = akVar.qo();
            int ql = akVar.ql();
            if (this.esP != null) {
                this.esP.sX();
            } else {
                this.esP = new com.baidu.tbadk.core.dialog.a(this.emy.getPageContext().getPageActivity());
                this.esQ = LayoutInflater.from(this.emy.getPageContext().getPageActivity()).inflate(t.h.dialog_direct_pager, (ViewGroup) null);
                this.esP.z(this.esQ);
                this.esP.a(t.j.dialog_ok, bVar);
                this.esP.b(t.j.dialog_cancel, new fo(this));
                this.esP.a(new fp(this));
                this.esP.b(this.emy.getPageContext()).sX();
            }
            this.esR = (EditText) this.esQ.findViewById(t.g.input_page_number);
            this.esR.setText("");
            TextView textView = (TextView) this.esQ.findViewById(t.g.current_page_number);
            if (qo <= 0) {
                qo = 1;
            }
            if (ql <= 0) {
                ql = 1;
            }
            textView.setText(MessageFormat.format(this.emy.getApplicationContext().getResources().getString(t.j.current_page), Integer.valueOf(qo), Integer.valueOf(ql)));
            this.emy.ShowSoftKeyPadDelay(this.esR, 150);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.bBT.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.emy.showToast(str);
    }

    public boolean iy(boolean z) {
        if (this.EJ == null || !this.EJ.CJ()) {
            return false;
        }
        this.EJ.AS();
        return true;
    }

    public void aPH() {
        if (this.euz != null) {
            while (this.euz.size() > 0) {
                TbImageView remove = this.euz.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        aPH();
        this.esO.of(1);
    }

    public void onResume() {
        this.esO.of(2);
    }

    public void onDestroy() {
        this.emy.hideProgressBar();
        if (this.blV != null && this.bOz != null) {
            this.blV.b(this.bOz);
        }
        aAE();
        this.esT.wm();
        if (this.etV != null) {
            com.baidu.adp.lib.h.h.eG().removeCallbacks(this.etV);
        }
        if (this.etW != null) {
            com.baidu.adp.lib.h.h.eG().removeCallbacks(this.etW);
        }
        aPO();
        if (this.eun != null) {
            this.eun.removeAllViews();
        }
        if (this.esi != null && this.eqL != null) {
            this.esi.removeView(this.esm);
            this.eqL = null;
        }
        if (this.etM != null) {
            this.etM.clearStatus();
        }
        this.euq = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.esO.of(3);
        if (this.bJv != null) {
            this.bJv.setBackgroundDrawable(null);
        }
    }

    public void aAE() {
        this.erX.oa();
        com.baidu.adp.lib.util.k.b(this.emy.getPageContext().getPageActivity(), this.esR);
        if (this.etq != null) {
            this.etq.dismiss();
        }
        aPI();
    }

    public void hN(boolean z) {
        this.esO.hN(z);
    }

    public void hO(boolean z) {
        this.elt = z;
        this.esO.hO(z);
    }

    public void gA(boolean z) {
        this.dxj = z;
    }

    public void aPI() {
        if (this.esY != null) {
            this.esY.dismiss();
        }
        if (this.esZ != null) {
            com.baidu.adp.lib.h.j.b(this.esZ, this.emy.getPageContext());
        }
        if (this.etj != null) {
            com.baidu.adp.lib.h.j.b(this.etj, this.emy.getPageContext());
        }
        if (this.esW != null) {
            com.baidu.adp.lib.h.j.b(this.esW, this.emy.getPageContext());
        }
    }

    public void onChangeSkinType(int i) {
        this.emy.getLayoutMode().ah(i == 1);
        this.emy.getLayoutMode().x(this.dXV);
        this.emy.getLayoutMode().x(this.ese);
        this.emy.getLayoutMode().x(this.esc);
        if (this.esf != null) {
            com.baidu.tieba.pb.data.b bVar = new com.baidu.tieba.pb.data.b(3);
            bVar.ejN = this.esf.ejN;
            bVar.ejO = this.esf.ejO;
            bVar.ait = i;
            bVar.ejJ = this.emy;
            bVar.aLC();
        }
        this.emy.getLayoutMode().x(this.aAX);
        this.erX.mNavigationBar.onChangeSkinType(this.emy.getPageContext(), i);
        com.baidu.tbadk.core.util.av.b(this.erX.eve, t.f.btn_more_selector_s, t.f.btn_more_selector);
        com.baidu.tbadk.core.util.av.b(this.erX.evf, t.f.icon_floor_addition_selector_s, t.f.icon_floor_addition_selector);
        if (this.esQ != null) {
            this.emy.getLayoutMode().x(this.esQ);
        }
        ix(this.etr);
        this.esO.notifyDataSetChanged();
        if (this.esS != null) {
            this.esS.dh(i);
        }
        if (this.esT != null) {
            this.esT.dh(i);
            com.baidu.tbadk.core.util.av.k(this.aAX, t.f.pb_foot_more_trans_selector);
            this.esT.df(t.f.pb_foot_more_trans_selector);
        }
        if (this.EJ != null) {
            this.EJ.onChangeSkinType(i);
        }
        if (this.esC != null) {
            this.esC.dl(i);
        }
        if (this.esU != null) {
            this.esU.dh(i);
        }
        if (this.esb != null && this.esb.size() > 0) {
            for (com.baidu.tieba.pb.pb.main.b.a aVar : this.esb) {
                aVar.aQd();
            }
        }
        if (this.eun != null) {
            com.baidu.tbadk.core.util.av.l(this.eun, t.d.cp_bg_line_d);
            com.baidu.tbadk.core.util.av.l(this.euh, t.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.av.c(this.eum, t.d.cp_cont_c, 1);
        }
        iq(i == 1);
        this.esh.changeSkinType(i);
        aPc();
        UtilHelper.setStatusBarBackground(this.bJv, i);
        if (this.esE != null) {
            this.esE.aK(true);
        }
        if (this.esF != null) {
            com.baidu.tbadk.j.a.a(this.emy.getPageContext(), this.esF);
        }
        com.baidu.tbadk.core.util.av.b(this.erX.evc, t.d.cp_cont_b, t.d.s_navbar_title_color);
    }

    public void setOnImageClickListener(TbRichTextView.d dVar) {
        this.aJI = dVar;
        this.esO.setOnImageClickListener(this.aJI);
    }

    public void g(NoNetworkView.a aVar) {
        this.bOz = aVar;
        if (this.blV != null) {
            this.blV.a(this.bOz);
        }
    }

    public void iz(boolean z) {
        this.esO.setIsFromCDN(z);
        this.mIsFromCDN = z;
    }

    public Button aPJ() {
        return this.etu;
    }

    public void m(com.baidu.tieba.pb.data.h hVar) {
        if (hVar != null) {
            ArrayList<com.baidu.tieba.tbadkCore.data.q> aLR = hVar.aLR();
            if (aLR.size() == 1) {
                com.baidu.tieba.tbadkCore.data.q qVar = aLR.get(0);
                if (qVar.bji() < qVar.bjb().size()) {
                    if (this.erW != 1) {
                        this.bBT.setNextPage(null);
                        this.erW = 1;
                    }
                } else if (this.erW != 2) {
                    this.bBT.setNextPage(this.esT);
                    this.erW = 2;
                }
            } else if (this.erW != 2) {
                this.bBT.setNextPage(this.esT);
                this.erW = 2;
            }
        }
    }

    public void aPK() {
        if (com.baidu.tbadk.performanceLog.aa.Gp().Gq()) {
            int lastVisiblePosition = this.bBT.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.bBT.getChildAt(i);
                if (childAt != null) {
                    TbRichTextView tbRichTextView = (TbRichTextView) childAt.findViewById(t.g.richText);
                    if (tbRichTextView != null) {
                        for (int i2 = 0; i2 < tbRichTextView.getChildCount(); i2++) {
                            View childAt2 = tbRichTextView.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.performanceLog.u perfLog = tbImageView.getPerfLog();
                                perfLog.fe(1001);
                                perfLog.aCi = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr = new int[2];
                                    tbRichTextView.getLocationOnScreen(iArr);
                                    if (iArr[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m9getInst().getContext())) {
                                    }
                                }
                                tbImageView.vU();
                            }
                        }
                    }
                    HeadImageView headImageView = (HeadImageView) childAt.findViewById(t.g.photo);
                    if (headImageView != null) {
                        com.baidu.tbadk.performanceLog.u perfLog2 = headImageView.getPerfLog();
                        perfLog2.fe(1001);
                        perfLog2.aCi = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr2 = new int[2];
                            headImageView.getLocationOnScreen(iArr2);
                            if (iArr2[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m9getInst().getContext())) {
                            }
                        }
                        headImageView.vU();
                    }
                }
            }
        }
    }

    public void gB(boolean z) {
        if (this.etv != null && this.etv != null) {
            if (this.dxj && !aQa()) {
                gC(z);
            } else {
                gD(z);
            }
        }
    }

    public void aPL() {
        if (this.etv != null) {
            this.etv.setVisibility(8);
        }
    }

    public TextView aPM() {
        return this.etF;
    }

    public void ayk() {
        if (this.etH == null) {
            this.etH = new com.baidu.tbadk.core.view.a(this.emy.getPageContext());
        }
        this.etH.aF(true);
    }

    public void aKF() {
        if (this.etH != null) {
            this.etH.aF(false);
        }
    }

    private void a(com.baidu.tieba.tbadkCore.data.q qVar, String str, String str2, boolean z, boolean z2) {
        this.esv.setVisibility(8);
        this.eso.setIsRound(true);
        if (this.erX != null) {
            this.erX.mNavigationBar.setBackgroundResource(0);
            ((ViewGroup.MarginLayoutParams) this.erX.evc.getLayoutParams()).leftMargin = this.emy.getResources().getDimensionPixelOffset(t.e.ds6);
            this.bBT.removeHeaderView(this.aqI);
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
        this.esi.setPadding(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(t.e.ds32), TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(t.e.ds0), TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(t.e.ds32), 0);
        if (qVar.getType() == null || qVar.getType().getId() != com.baidu.tieba.tbadkCore.data.q.Tl.getId()) {
            this.esc.setPadding(0, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(t.e.ds34), 0, 0);
        }
        int dimensionPixelSize = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(t.e.ds76);
        if (this.eso.getLayoutParams() == null) {
            layoutParams = new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
        } else {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.eso.getLayoutParams();
            layoutParams2.width = dimensionPixelSize;
            layoutParams2.height = dimensionPixelSize;
            layoutParams = layoutParams2;
        }
        this.eso.setLayoutParams(layoutParams);
        this.eso.setVisibility(8);
        View findViewWithTag = this.esi.findViewWithTag("pb_god_head_image_view_tag");
        if (!(findViewWithTag instanceof ClickableHeaderImageView)) {
            this.eqL = new ClickableHeaderImageView(this.emy.getApplicationContext());
            this.eqL.setGodIconMargin(0);
            this.eqL.setTag("pb_god_head_image_view_tag");
            this.eqL.setUserId(String.valueOf(userIdLong));
            this.eqL.setUserName(userName);
            layoutParams.leftMargin = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(t.e.ds0);
            this.esm.addView(this.eqL, 0, layoutParams);
        } else {
            this.eqL = (ClickableHeaderImageView) findViewWithTag;
        }
        if (this.adQ) {
            this.eqL.setIsBigV(true);
        }
        fs fsVar = new fs(this, qVar);
        this.esi.setTag(t.g.tag_user_id, String.valueOf(userIdLong));
        this.esi.setTag(t.g.tag_user_name, userName);
        this.ese.setTag(t.g.tag_user_id, String.valueOf(userIdLong));
        this.ese.setTag(t.g.tag_user_name, userName);
        if (this.elt) {
            this.eqL.setVisibility(0);
            this.eqL.setOnClickListener(fsVar);
            this.eqL.c(portrait, 28, false);
        } else {
            this.eqL.setVisibility(8);
        }
        if (this.esy == null) {
            this.esy = new TextView(this.emy.getActivity());
            this.esy.setClickable(false);
            this.esy.setIncludeFontPadding(false);
            this.esy.setGravity(16);
            this.esy.setTextSize(0, this.emy.getResources().getDimensionPixelSize(t.e.fontsize24));
            ColumnLayout.a aVar = new ColumnLayout.a(-2, -2, 3, 2);
            aVar.topMargin = this.emy.getResources().getDimensionPixelSize(t.e.ds8);
            aVar.bottomMargin = this.emy.getResources().getDimensionPixelSize(t.e.ds10);
            this.esy.setSingleLine(true);
            com.baidu.tbadk.core.util.av.c(this.esy, t.d.cp_cont_d, 1);
            this.esi.addView(this.esy, -1, aVar);
        }
        String format = String.format(this.emy.getResources().getString(t.j.fans_default_name_god_user), com.baidu.tbadk.core.util.ba.w(fansNum));
        this.esy.setText(format);
        this.esy.setTag(t.g.tag_user_id, String.valueOf(userIdLong));
        this.esy.setTag(t.g.tag_user_name, userName);
        this.esy.setOnClickListener(fsVar);
        if (this.esz == null) {
            this.esz = new TextView(this.emy.getActivity());
            this.esz.setClickable(true);
            this.esz.setTextSize(0, this.emy.getResources().getDimensionPixelSize(t.e.fontsize24));
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
            this.esz.setSingleLine(true);
            this.esz.setPadding(this.emy.getResources().getDimensionPixelSize(t.e.ds32), 0, this.emy.getResources().getDimensionPixelSize(t.e.ds128), 0);
            this.esz.setEllipsize(TextUtils.TruncateAt.END);
            this.esz.setTag(t.g.tag_user_id, String.valueOf(userIdLong));
            this.esz.setTag(t.g.tag_user_name, userName);
            com.baidu.tbadk.core.util.av.c(this.esz, t.d.cp_cont_d, 1);
            this.esz.setOnTouchListener(this.ekU);
            this.ese.addView(this.esz, layoutParams3);
        }
        String string = this.emy.getResources().getString(t.j.tieba_certification);
        this.esz.setText(StringUtils.isNull(godUserData.getIntro()) ? String.format(string, this.emy.getResources().getString(t.j.god_intro_default)) : String.format(string, godUserData.getIntro()));
        this.esv.setVisibility(8);
        if (this.esA == null) {
            this.esA = new TextView(this.emy.getActivity());
            this.esA.setTextSize(0, this.emy.getResources().getDimensionPixelSize(t.e.fontsize24));
            this.esA.setGravity(17);
            this.esA.setOnClickListener(frVar);
            ColumnLayout.a aVar2 = new ColumnLayout.a(this.emy.getResources().getDimensionPixelSize(t.e.ds110), this.emy.getResources().getDimensionPixelSize(t.e.ds50), 80, 3);
            aVar2.bottomMargin = this.emy.getResources().getDimensionPixelSize(t.e.ds22);
            this.esi.addView(this.esA, -1, aVar2);
        }
        a(this.esA, godUserData.getFollowed() == 1);
        if (this.ets || (godUserData.getFollowed() == 1 && godUserData.getIsFromNetWork())) {
            this.esA.setVisibility(8);
        } else {
            this.esA.setVisibility(0);
        }
        if (this.ese.findViewWithTag("pb_god_bottom_line_view_tag") == null) {
            View view = new View(this.emy.getApplicationContext());
            view.setTag("pb_god_bottom_line_view_tag");
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, this.emy.getResources().getDimensionPixelSize(t.e.ds1));
            layoutParams4.topMargin = this.emy.getResources().getDimensionPixelSize(t.e.ds18);
            layoutParams4.bottomMargin = this.emy.getResources().getDimensionPixelSize(t.e.ds1);
            com.baidu.tbadk.core.util.av.l(view, t.d.cp_bg_line_a);
            this.ese.addView(view, layoutParams4);
        }
        if (this.eue == null) {
            this.eue = new TextView(this.emy.getApplicationContext());
            this.eue.setId(t.g.pb_god_user_tip_content);
            this.eue.setEllipsize(TextUtils.TruncateAt.END);
            this.eue.setGravity(17);
            this.eue.setSingleLine(true);
            this.eue.setHeight(this.emy.getResources().getDimensionPixelSize(t.e.ds56));
            this.eue.setTextSize(0, this.emy.getResources().getDimensionPixelSize(t.e.fontsize24));
            this.eue.setVisibility(8);
            if (aPU() != null) {
                aPU().addView(this.eue);
            }
            this.emy.getLayoutMode().x(this.eue);
        }
        com.baidu.tbadk.core.util.av.k(this.eue, t.d.common_color_10260);
        com.baidu.tbadk.core.util.av.j((View) this.eue, t.d.cp_cont_g);
        this.eue.setOnClickListener(new fu(this));
        this.eue.setText(String.format(this.emy.getResources().getString(t.j.god_user_floor_owner_tip), com.baidu.tbadk.core.util.ba.w(this.euf)));
        ot(this.euf);
        if (this.eud == null) {
            this.eud = (LinearLayout) LayoutInflater.from(this.emy.getActivity()).inflate(t.h.god_floating_view, (ViewGroup) null);
            this.eud.setOnClickListener(fsVar);
            this.eud.setTag(t.g.tag_user_id, String.valueOf(userIdLong));
            this.eud.setTag(t.g.tag_user_name, userName);
            ClickableHeaderImageView clickableHeaderImageView = (ClickableHeaderImageView) this.eud.findViewById(t.g.god_floating_owner_photo);
            if (this.adQ) {
                ViewStub viewStub = (ViewStub) this.eud.findViewById(t.g.viewstub_headimage_mask);
                if (viewStub != null && 0 == 0) {
                    viewStub.inflate();
                    TbImageView tbImageView = (TbImageView) this.eud.findViewById(t.g.user_head_mask);
                    if (tbImageView != null && author != null && author.getUserTbVipInfoData() != null && !StringUtils.isNull(author.getUserTbVipInfoData().getvipV_url())) {
                        tbImageView.c(author.getUserTbVipInfoData().getvipV_url(), 10, false);
                        clickableHeaderImageView.setIsBigV(true);
                    }
                }
            } else {
                clickableHeaderImageView.setGodIconMargin(0);
            }
            clickableHeaderImageView.setOnClickListener(fsVar);
            if (!this.elt) {
                clickableHeaderImageView.setVisibility(8);
            }
            clickableHeaderImageView.setTag(qVar.getAuthor().getUserId());
            clickableHeaderImageView.c(qVar.getAuthor().getPortrait(), 28, false);
            View findViewById = this.eud.findViewById(t.g.god_floating_owner_info_floor_owner);
            if (str2 != null && !str2.equals("0") && str2.equals(qVar.getAuthor().getUserId())) {
                findViewById.setVisibility(0);
            } else {
                findViewById.setVisibility(8);
            }
            ImageView imageView = (ImageView) this.eud.findViewById(t.g.god_floating_owner_info_user_rank);
            int level_id = qVar.getAuthor().getLevel_id();
            int is_bawu = qVar.getAuthor().getIs_bawu();
            String bawu_type = qVar.getAuthor().getBawu_type();
            int i = 3;
            if (level_id != 0) {
                imageView.setVisibility(0);
                com.baidu.tbadk.core.util.av.c(imageView, BitmapHelper.getGradeResourceIdNew(level_id));
                imageView.setContentDescription(String.format(TbadkCoreApplication.m9getInst().getString(t.j.degree_in_forum), Integer.valueOf(level_id)));
                imageView.setOnClickListener(null);
            } else {
                imageView.setVisibility(8);
            }
            ImageView imageView2 = (ImageView) this.eud.findViewById(t.g.god_floating_owner_info_user_bawu);
            if (is_bawu != 0) {
                if (bawu_type.equals("manager")) {
                    com.baidu.tbadk.core.util.av.c(imageView2, t.f.pb_manager);
                    imageView.setVisibility(8);
                    imageView2.setVisibility(0);
                } else if (bawu_type.equals("assist")) {
                    com.baidu.tbadk.core.util.av.c(imageView2, t.f.pb_assist);
                    imageView.setVisibility(8);
                    imageView2.setVisibility(0);
                }
            }
            if (!StringUtils.isNull(qVar.getAuthor().getName_show()) && com.baidu.adp.lib.util.j.aR(qVar.getAuthor().getName_show()) > 14) {
                i = 0;
            }
            ArrayList<IconData> iconInfo = qVar.getAuthor().getIconInfo();
            ArrayList<IconData> tShowInfoNew = qVar.getAuthor().getTShowInfoNew();
            UserIconBox userIconBox = (UserIconBox) this.eud.findViewById(t.g.god_floating_owner_info_user_icon);
            UserIconBox userIconBox2 = (UserIconBox) this.eud.findViewById(t.g.god_floating_owner_info_tshow_icon);
            if (userIconBox != null) {
                userIconBox.setTag(t.g.tag_user_id, qVar.getAuthor().getUserId());
                userIconBox.setOnClickListener(this.emy.eni.bUu);
                userIconBox.a(iconInfo, i, this.emy.getResources().getDimensionPixelSize(t.e.ds30), this.emy.getResources().getDimensionPixelSize(t.e.ds30), this.emy.getResources().getDimensionPixelSize(t.e.ds10));
            }
            if (userIconBox2 != null) {
                userIconBox2.setOnClickListener(this.emy.eni.euR);
                userIconBox2.a(tShowInfoNew, 3, this.emy.getResources().getDimensionPixelSize(t.e.ds32), this.emy.getResources().getDimensionPixelSize(t.e.ds32), this.emy.getResources().getDimensionPixelSize(t.e.ds8), true);
            }
            TextView textView = (TextView) this.eud.findViewById(t.g.god_floating_owner_info_user_name);
            if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                com.baidu.tbadk.core.util.av.c(textView, t.d.cp_cont_h, 1);
            } else {
                com.baidu.tbadk.core.util.av.c(textView, t.d.cp_cont_f, 1);
            }
            textView.setText(qVar.getAuthor().getName_show());
            if (aPU() != null) {
                aPU().addView(this.eud);
            }
            this.emy.getLayoutMode().x(this.eud);
        }
        TextView textView2 = (TextView) this.eud.findViewById(t.g.god_floating_gift);
        textView2.setOnClickListener(frVar);
        a(textView2, godUserData.getFollowed() == 1);
        ImageView imageView3 = (ImageView) this.eud.findViewById(t.g.god_floating_arrow);
        com.baidu.tbadk.core.util.av.c(imageView3, t.f.icon_arrow_tab);
        if (this.ets || (godUserData.getFollowed() == 1 && godUserData.getIsFromNetWork())) {
            textView2.setVisibility(8);
            imageView3.setVisibility(0);
        } else {
            textView2.setVisibility(0);
            imageView3.setVisibility(8);
        }
        TextView textView3 = (TextView) this.eud.findViewById(t.g.god_floating_intro);
        if (textView3 != null) {
            textView3.setText(format);
        }
        this.eun = this.esT.wi();
        if (this.eun != null && !this.ets && !z && z2 && (godUserData.getFollowed() != 1 || !godUserData.getIsFromNetWork())) {
            this.esT.wj();
            this.esT.wf();
            this.euh = this.eun.findViewWithTag("pb_god_bottom_extra_line_view_tag");
            if (this.euh == null) {
                this.euh = new View(this.emy.getApplicationContext());
                this.euh.setTag("pb_god_bottom_extra_line_view_tag");
                this.eun.addView(this.euh, new LinearLayout.LayoutParams(-1, this.emy.getResources().getDimensionPixelSize(t.e.ds20)));
                this.eul = new FrameLayout(this.emy.getApplicationContext());
                this.eul.setTag("pb_god_bottom_extra_god_avatar_frame_tag");
                this.euj = new ClickableHeaderImageView(this.emy.getApplicationContext());
                this.euj.setTag("pb_god_bottom_extra_god_avatar_tag");
                this.euj.c(portrait, 28, false);
                this.euj.setUserId(String.valueOf(userIdLong));
                this.euj.setUserName(userName);
                this.euj.setOnClickListener(fsVar);
                this.eul.addView(this.euj, new FrameLayout.LayoutParams(this.emy.getResources().getDimensionPixelSize(t.e.ds130), this.emy.getResources().getDimensionPixelSize(t.e.ds130)));
                if (this.adQ) {
                    this.euk = new TbImageView(this.emy.getApplicationContext());
                    this.euk.setTag("pb_god_bottom_extra_god_avatar_mask_tag");
                    this.euk.c(author.getUserTbVipInfoData().getvipV_url(), 10, false);
                    FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(this.emy.getResources().getDimensionPixelSize(t.e.ds45), this.emy.getResources().getDimensionPixelSize(t.e.ds45));
                    layoutParams5.gravity = 85;
                    this.eul.addView(this.euk, layoutParams5);
                } else {
                    this.euj.setGodIconMargin(0);
                }
                LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(this.emy.getResources().getDimensionPixelSize(t.e.ds130), this.emy.getResources().getDimensionPixelSize(t.e.ds130));
                layoutParams6.gravity = 17;
                layoutParams6.topMargin = this.emy.getResources().getDimensionPixelSize(t.e.ds40);
                this.eun.addView(this.eul, layoutParams6);
                this.eum = new TextView(this.emy.getApplicationContext());
                this.eum.setTag("pb_god_bottom_extra_text_view_tag");
                this.eum.setSingleLine(true);
                this.eum.setTextSize(0, this.emy.getResources().getDimensionPixelSize(t.e.fontsize24));
                LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams7.topMargin = this.emy.getResources().getDimensionPixelSize(t.e.ds36);
                layoutParams7.gravity = 1;
                this.eum.setText(this.emy.getResources().getString(t.j.god_user_attention_tip));
                this.eun.addView(this.eum, layoutParams7);
                this.eui = new TextView(this.emy.getApplicationContext());
                this.eui.setTag("pb_god_bottom_extra_attention_btn_tag");
                this.eui.setSingleLine(true);
                this.eui.setGravity(17);
                this.eui.setTextSize(0, this.emy.getResources().getDimensionPixelSize(t.e.fontsize24));
                this.eui.setOnClickListener(frVar);
                LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(this.emy.getResources().getDimensionPixelSize(t.e.ds212), this.emy.getResources().getDimensionPixelSize(t.e.ds54));
                layoutParams8.topMargin = this.emy.getResources().getDimensionPixelSize(t.e.ds30);
                layoutParams8.bottomMargin = this.emy.getResources().getDimensionPixelSize(t.e.ds40);
                layoutParams8.gravity = 1;
                this.eun.addView(this.eui, layoutParams8);
            } else {
                this.eui = (TextView) this.eun.findViewWithTag("pb_god_bottom_extra_attention_btn_tag");
                this.euj = (ClickableHeaderImageView) this.eun.findViewWithTag("pb_god_bottom_extra_god_avatar_tag");
                this.eum = (TextView) this.eun.findViewWithTag("pb_god_bottom_extra_text_view_tag");
                this.euh = this.eun.findViewWithTag("pb_god_bottom_extra_line_view_tag");
            }
            com.baidu.tbadk.core.util.av.l(this.eun, t.d.cp_bg_line_d);
            com.baidu.tbadk.core.util.av.l(this.euh, t.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.av.c(this.eum, t.d.cp_cont_c, 1);
            this.eun.setOnTouchListener(new fv(this));
            boolean z3 = godUserData.getFollowed() == 1;
            a(this.eui, z3);
            if (!z3) {
                this.eui.setPadding(this.emy.getResources().getDimensionPixelSize(t.e.ds68), 0, this.emy.getResources().getDimensionPixelSize(t.e.ds52), 0);
            }
        } else {
            this.esT.wk();
            this.esT.we();
        }
        return true;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.eua && !this.eub && i > this.erV) {
            this.euc = true;
        } else {
            this.euc = false;
            aPP();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL));
        aPN();
    }

    public void aPN() {
        float f = 1.0f;
        if (this.esf != null && this.esf.ejN != null && this.esM) {
            int dimension = (int) this.emy.getResources().getDimension(t.e.ds98);
            int dimension2 = ((int) this.emy.getResources().getDimension(t.e.ds450)) - (-this.esf.ejN.getTop());
            if (this.bBT.getChildAt(0) == this.esf.ejN && dimension2 >= dimension) {
                if (dimension2 < dimension || dimension2 > dimension * 2) {
                    f = dimension2 > dimension * 2 ? 0.0f : 0.0f;
                } else {
                    f = 1.0f - (((dimension2 - dimension) * 1.0f) / dimension);
                }
            }
            this.erX.ap(f);
        }
    }

    private void ot(int i) {
        boolean z;
        if (this.eue != null && this.eue.getVisibility() != 0 && i >= 2 && !this.ets) {
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                z = com.baidu.tbadk.core.sharedPref.b.tS().getBoolean("pb_god_floor_owner_tip_has_shown_" + TbadkCoreApplication.getCurrentAccount(), false);
            } else {
                z = com.baidu.tbadk.core.sharedPref.b.tS().getBoolean("pb_god_floor_owner_not_login_tip_has_shown_" + TbadkCoreApplication.getCurrentAccount(), false);
            }
            if (!z) {
                this.eug = true;
                this.eue.setVisibility(0);
            }
            com.baidu.adp.lib.h.h.eG().postDelayed(this.cEQ, 3000L);
        }
    }

    public void aPO() {
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.cEQ);
        if (this.eue != null && 8 != this.eue.getVisibility()) {
            com.baidu.tieba.tbadkCore.a.a(this.emy, this.eue, t.a.fade_out, new fw(this));
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                com.baidu.tbadk.core.sharedPref.b.tS().putBoolean("pb_god_floor_owner_tip_has_shown_" + TbadkCoreApplication.getCurrentAccount(), true);
            } else {
                com.baidu.tbadk.core.sharedPref.b.tS().putBoolean("pb_god_floor_owner_not_login_tip_has_shown_" + TbadkCoreApplication.getCurrentAccount(), true);
            }
        }
    }

    public void aPP() {
        if (this.eud != null) {
            this.eud.clearAnimation();
            if (this.eud.getVisibility() != 8) {
                this.eud.setVisibility(8);
            }
        }
    }

    public void aPQ() {
        if (this.eua && this.euc && this.eud != null && this.eud.getVisibility() != 0 && !this.eug) {
            this.eud.clearAnimation();
            this.eud.setVisibility(0);
        }
    }

    public void aPR() {
        if (!this.euA) {
            TiebaStatic.log("c10490");
            this.euA = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.emy.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(etQ, Integer.valueOf(etS));
            aVar.bY(t.j.grade_thread_tips);
            View inflate = LayoutInflater.from(this.emy.getPageContext().getPageActivity()).inflate(t.h.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(t.g.function_description_view)).setText(t.j.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(t.g.title_view)).setText(t.j.grade_thread_tips);
            aVar.z(inflate);
            aVar.A(sparseArray);
            aVar.a(t.j.grade_button_tips, this.emy);
            aVar.b(t.j.look_again, new fx(this));
            aVar.b(this.emy.getPageContext()).sX();
        }
    }

    public void aPS() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.emy.getPageContext().getPageActivity());
        aVar.cB(this.emy.getResources().getString(t.j.upgrade_to_new_photo_live_tips));
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(etQ, Integer.valueOf(etU));
        aVar.A(sparseArray);
        aVar.a(t.j.upgrade_to_new, this.emy);
        aVar.b(t.j.cancel, new fy(this));
        aVar.b(this.emy.getPageContext()).sX();
    }

    public int rr() {
        return this.etN;
    }

    public void oZ(String str) {
        if (str.contains("_")) {
            str = str.replace("_", "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.emy.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.emy.getPageContext().getPageActivity()).inflate(t.h.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(t.g.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(t.g.function_description_view)).setVisibility(8);
        aVar.z(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(etQ, Integer.valueOf(etT));
        aVar.A(sparseArray);
        aVar.a(t.j.view, this.emy);
        aVar.b(t.j.cancel, new fz(this));
        aVar.b(this.emy.getPageContext()).sX();
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
            com.baidu.tbadk.core.util.av.c(textView, t.d.cp_cont_d, 1);
            textView.setText(TbadkCoreApplication.m9getInst().getString(t.j.relate_forum_is_followed));
            textView.setBackgroundDrawable(null);
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setPadding(0, 0, 0, 0);
            return;
        }
        com.baidu.tbadk.core.util.av.c(textView, t.d.btn_forum_focus_color, 1);
        textView.setText(TbadkCoreApplication.m9getInst().getString(t.j.forum_list_attention_tv));
        com.baidu.tbadk.core.util.av.k(textView, t.f.btn_transparent_focus_border_bg);
        textView.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.av.getDrawable(t.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        textView.setClickable(true);
        textView.setPadding(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(t.e.ds18), 0, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(t.e.ds10), 0);
    }

    public PbInterviewStatusView aPT() {
        return this.etM;
    }

    private void n(com.baidu.tieba.pb.data.h hVar) {
        if (hVar != null && hVar.aLQ() != null && hVar.aLQ().ss() && this.etM == null) {
            this.etM = (PbInterviewStatusView) this.etL.inflate();
            this.etM.setOnClickListener(this.bRE);
            this.etM.setCallback(this.emy.aNh());
            this.etM.a(this.emy, hVar);
        }
    }

    public LinearLayout aPU() {
        return this.esN;
    }

    public View aPV() {
        return this.bJv;
    }

    public boolean aPW() {
        return this.euo;
    }

    public void aNF() {
        this.esh.aNF();
    }

    public void hT(boolean z) {
        this.esg.hT(z);
    }

    private void aPX() {
        if (this.euo) {
            if (this.eup == null) {
                f.a aVar = f.emA.get();
                if (aVar != null) {
                    this.eup = aVar.a(this.emy);
                    ListAdapter adapter = this.bBT.getAdapter();
                    if (adapter != null) {
                        if (adapter.getView(0, null, null) == this.aqI) {
                            this.bBT.f(this.eup.aMy(), 1);
                        } else {
                            this.bBT.f(this.eup.aMy(), 0);
                        }
                    }
                } else {
                    this.ese.setVisibility(0);
                    return;
                }
            }
            this.ese.setVisibility(8);
            this.bBT.removeHeaderView(this.ese);
            return;
        }
        this.ese.setVisibility(0);
    }

    public void iA(boolean z) {
        this.euo = z;
    }

    public View aNJ() {
        return this.esh.aNJ();
    }

    public void aPY() {
        this.emy.showNetRefreshView(getView(), "");
        View EA = this.emy.getRefreshView().EA();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) EA.getLayoutParams();
        layoutParams.addRule(3, aPU().getId());
        EA.setLayoutParams(layoutParams);
        this.emy.hideLoadingView(getView());
        if (this.eup != null) {
            this.bBT.removeHeaderView(this.eup.aMy());
            this.eup = null;
        }
    }

    public void pa(String str) {
        if (this.erY != null) {
            this.erY.setTitle(str);
        }
    }

    public void CS() {
        this.esh.CS();
    }

    public void aMw() {
        if (this.esk != null) {
            this.esk.setTextSize(TbConfig.getContentSizeOfPostTitle());
        }
        if (this.esO != null && this.esO.aNr() != null) {
            this.esO.aNr().aMw();
        }
        if (this.esO != null) {
            if (this.esO.aNs() != null) {
                this.esO.aNs().bbo();
            }
            if (this.esO.aNt() != null) {
                this.esO.aNt().bbo();
            }
        }
    }

    private int iB(boolean z) {
        if (this.etM == null || this.etM.getVisibility() != 0 || !z) {
            return 0;
        }
        return 0 + com.baidu.adp.lib.util.k.e(this.emy.getPageContext().getPageActivity(), t.e.ds72);
    }

    private void aPZ() {
        if (this.etM != null && this.etM.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.etM.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.etM.setLayoutParams(layoutParams);
        }
    }

    public boolean aQa() {
        return this.esM;
    }

    public boolean aMH() {
        return this.eua;
    }

    public TextView aQb() {
        return this.esz;
    }
}
