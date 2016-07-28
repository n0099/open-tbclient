package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Parcelable;
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
import com.baidu.tieba.card.at;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.f;
import com.baidu.tieba.pb.view.PbInterviewStatusView;
import com.baidu.tieba.tbadkCore.FrsPraiseView;
import com.baidu.tieba.tbadkCore.b.a;
import com.baidu.tieba.u;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class ew {
    private com.baidu.tbadk.editortools.l Cw;
    private ViewStub aSW;
    private TbImageView aSX;
    private boolean abg;
    private t.b ado;
    private TextView anB;
    private View axQ;
    private View bGN;
    private View.OnClickListener bGw;
    private NoNetworkView bmB;
    private BdTypeListView bqG;
    private RelativeLayout dLY;
    private com.baidu.tieba.pb.a.d dYQ;
    private View.OnClickListener dZu;
    private PbActivity eat;
    PbActivity.c ebF;
    public int efP;
    public final com.baidu.tieba.pb.pb.main.b.e efS;
    public com.baidu.tieba.pb.pb.main.b.c efT;
    private ViewStub efU;
    private ViewStub efV;
    private List<com.baidu.tieba.pb.pb.main.b.a> efW;
    private View efX;
    private LinearLayout efZ;
    private TextView egA;
    private TextView egB;
    private View egD;
    private View egE;
    private ObservedChangeLinearLayout egH;
    private ch egI;
    private PbListView egN;
    private View egP;
    private com.baidu.tieba.pb.data.b ega;
    private g egb;
    private dd egc;
    private ColumnLayout egd;
    private ThreadSkinView ege;
    private TextView egf;
    private TextView egg;
    private FrameLayout egh;
    private HeadImageView egi;
    private ImageView egj;
    private ImageView egk;
    private ImageView egl;
    private UserIconBox egm;
    private UserIconBox egn;
    private ImageView ego;
    private TextView egp;
    private TextView egq;
    private TextView egr;
    private TextView egv;
    private UserLikeButton egy;
    private LinearLayout egz;
    private View ehC;
    private TextView ehD;
    private ViewStub ehE;
    private PbInterviewStatusView ehF;
    private Runnable ehO;
    private Runnable ehP;
    private View eho;
    private TextView ehp;
    private TextView ehq;
    private ViewGroup ehr;
    private TextView ehs;
    private boolean ehu;
    private HeadImageView ehv;
    private ImageView ehw;
    private View eia;
    private TextView eib;
    private ClickableHeaderImageView eic;
    private TbImageView eid;
    private FrameLayout eie;
    private TextView eif;
    private LinearLayout eig;
    private boolean eih;
    private f eii;
    private Runnable eik;
    private PbActivity.a ein;
    private boolean eip;
    private boolean eiq;
    public static int ehH = 2;
    public static int ehI = 3;
    public static int ehJ = 0;
    public static int ehK = 3;
    public static int ehL = 4;
    public static int ehM = 5;
    public static int ehN = 6;
    private static HashMap<Point, Integer> Rs = new HashMap<>();
    private static SparseArray<at.a> ehQ = new SparseArray<>(3);
    private int efQ = 0;
    private int efR = 0;
    private final Handler mHandler = new Handler();
    private View efY = null;
    private TextView egs = null;
    private TextView egt = null;
    private TextView egu = null;
    public FrsPraiseView egw = null;
    private ClickableHeaderImageView eeG = null;
    private ClickableHeaderImageView egx = null;
    private View egC = null;
    private View egF = null;
    private boolean egG = false;
    private com.baidu.tbadk.core.dialog.a egJ = null;
    private com.baidu.tbadk.core.dialog.c bGq = null;
    private View egK = null;
    private EditText egL = null;
    private com.baidu.tieba.pb.view.w egM = null;
    private com.baidu.tieba.pb.view.d egO = null;
    private c.b cSA = null;
    private TbRichTextView.d aGw = null;
    private NoNetworkView.a bCV = null;
    private Dialog egQ = null;
    private View egR = null;
    private com.baidu.tbadk.core.dialog.a egS = null;
    private Dialog egT = null;
    private View egU = null;
    private int egV = 0;
    private RadioGroup Fh = null;
    private RadioButton egW = null;
    private RadioButton egX = null;
    private RadioButton egY = null;
    private Button egZ = null;
    private Button eha = null;
    private TextView ehb = null;
    private Dialog ehc = null;
    private View ehd = null;
    private LinearLayout ehe = null;
    private CompoundButton.OnCheckedChangeListener ehf = null;
    private TextView ehg = null;
    private TextView ehh = null;
    private String ehi = null;
    private com.baidu.tbadk.core.dialog.c ehj = null;
    private boolean ehk = false;
    private boolean ehl = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView ehm = null;
    private boolean dlB = false;
    private Button ehn = null;
    private boolean eht = true;
    private LinearLayout ehx = null;
    private TextView ehy = null;
    private TextView ehz = null;
    private View aIR = null;
    private com.baidu.tbadk.core.view.b ehA = null;
    private boolean dZq = false;
    private boolean ehB = false;
    private boolean mIsFromCDN = true;
    private int ehG = 0;
    private boolean ehR = true;
    private a.InterfaceC0074a ehS = new ex(this);
    private boolean ehT = false;
    private boolean ehU = false;
    private boolean ehV = false;
    private LinearLayout ehW = null;
    private TextView ehX = null;
    private int ehY = 0;
    private boolean ehZ = false;
    private Handler eij = new Handler();
    private CustomMessageListener eil = new fi(this, CmdConfigCustom.PB_SHOW_MULTIIAMGETOOL);
    private final View.OnClickListener eim = new fs(this);
    private View.OnLongClickListener onLongClickListener = null;
    private boolean eio = true;
    private boolean eir = false;
    private boolean RD = false;
    String userId = null;
    private final List<TbImageView> eis = new ArrayList();
    private boolean dZp = true;
    private boolean eit = false;
    private Runnable ctk = new fz(this);

    static {
        Rs.put(new Point(1, 1), Integer.valueOf(u.j.lottery_status_ing));
        Rs.put(new Point(1, 2), Integer.valueOf(u.j.lottery_status_over));
        Rs.put(new Point(1, 3), Integer.valueOf(u.j.lottery_status_off));
        Rs.put(new Point(1, 4), Integer.valueOf(u.j.lottery_status_not_start));
        Rs.put(new Point(2, 1), Integer.valueOf(u.j.share_picture_status_ing));
        Rs.put(new Point(2, 2), Integer.valueOf(u.j.share_picture_status_over));
        Rs.put(new Point(2, 3), Integer.valueOf(u.j.share_picture_status_off));
        Rs.put(new Point(2, 4), Integer.valueOf(u.j.share_picture_status_not_start));
        ehQ.put(1, new at.a(u.j.interview_live_status_not_start, u.d.cp_other_b, u.f.pic_dot_title_red));
        ehQ.put(2, new at.a(u.j.interview_live_status_ing, u.d.cp_other_c, u.f.pic_dot_title_green));
        ehQ.put(3, new at.a(u.j.interview_live_status_over, u.d.cp_other_d, u.f.pic_dot_title_blue));
    }

    public f aKd() {
        return this.eii;
    }

    public NoNetworkView aKe() {
        return this.bmB;
    }

    public boolean isFullScreen() {
        return this.ehU;
    }

    public void aKf() {
        if (this.Cw != null) {
            this.Cw.hide();
        }
    }

    public void aKg() {
        reset();
        this.eht = true;
        if (this.Cw != null) {
            this.Cw.hide();
        }
        if (this.eho != null) {
            if (this.dlB && !aLj()) {
                gg(false);
            } else {
                gh(false);
            }
        }
        aIR();
    }

    private void reset() {
        if (this.eat != null && this.eat.aHJ() != null && this.Cw != null) {
            com.baidu.tbadk.editortools.d.b.BM().setStatus(0);
            com.baidu.tbadk.editortools.d.e aHJ = this.eat.aHJ();
            aHJ.Ck();
            if (aHJ.getWriteImagesInfo() != null) {
                aHJ.getWriteImagesInfo().setMaxImagesAllowed(10);
            }
            aHJ.eu(10);
            aHJ.es(SendView.ALL);
            aHJ.et(SendView.ALL);
            aHJ.fy(this.eat.getActivity().getString(u.j.pb_reply_hint));
            com.baidu.tbadk.editortools.s ej = this.Cw.ej(23);
            com.baidu.tbadk.editortools.s ej2 = this.Cw.ej(2);
            com.baidu.tbadk.editortools.s ej3 = this.Cw.ej(5);
            if (ej2 != null) {
                ej2.kB();
            }
            if (ej3 != null) {
                ej3.kB();
            }
            if (ej != null) {
                ej.hide();
            }
            this.Cw.invalidate();
        }
    }

    public boolean aKh() {
        return this.eht;
    }

    public void gg(boolean z) {
        if (this.eho != null && this.ehp != null && this.ehq != null) {
            this.ehp.setText(u.j.draft_to_send);
            this.ehq.setVisibility(8);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.eho.startAnimation(alphaAnimation);
            }
            this.eho.setVisibility(0);
        }
    }

    public void gh(boolean z) {
        if (this.eho != null && this.ehp != null && this.ehq != null) {
            this.ehp.setText(u.j.reply_floor_host);
            this.ehq.setVisibility(0);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.eho.startAnimation(alphaAnimation);
            }
            this.eho.setVisibility(0);
        }
    }

    public com.baidu.tieba.tbadkCore.data.s aKi() {
        int i;
        View childAt;
        int i2 = 0;
        if (this.bqG == null) {
            return null;
        }
        int firstVisiblePosition = this.bqG.getFirstVisiblePosition();
        int lastVisiblePosition = this.bqG.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.bqG.getChildCount();
            int i3 = 0;
            for (int i4 = firstVisiblePosition; i4 <= lastVisiblePosition; i4++) {
                if (i4 - firstVisiblePosition < childCount && (childAt = this.bqG.getChildAt(i4 - firstVisiblePosition)) != null) {
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
        int headerViewsCount = i - this.bqG.getHeaderViewsCount();
        if (headerViewsCount < 0) {
            headerViewsCount = 0;
        }
        if (this.egI.nB(headerViewsCount) != null && this.egI.nB(headerViewsCount) != com.baidu.tieba.tbadkCore.data.s.fkG) {
            i2 = headerViewsCount + 1;
        }
        return (com.baidu.tieba.tbadkCore.data.s) this.egI.aw(i2);
    }

    public ew(PbActivity pbActivity, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.d dVar) {
        this.eat = null;
        this.dLY = null;
        this.bGN = null;
        this.bqG = null;
        this.efX = null;
        this.efZ = null;
        this.egd = null;
        this.egf = null;
        this.egg = null;
        this.egh = null;
        this.egi = null;
        this.egj = null;
        this.egk = null;
        this.egl = null;
        this.egm = null;
        this.egn = null;
        this.ego = null;
        this.egp = null;
        this.egq = null;
        this.egr = null;
        this.egv = null;
        this.egy = null;
        this.egD = null;
        this.egE = null;
        this.egI = null;
        this.egN = null;
        this.axQ = null;
        this.bGw = null;
        this.dZu = null;
        this.eho = null;
        this.ehp = null;
        this.ehr = null;
        this.ehs = null;
        this.ehv = null;
        this.ehw = null;
        this.ehC = null;
        this.ehD = null;
        this.ehE = null;
        this.eat = pbActivity;
        this.bGw = onClickListener;
        this.dYQ = dVar;
        this.dLY = (RelativeLayout) LayoutInflater.from(this.eat.getPageContext().getPageActivity()).inflate(u.h.new_pb_activity, (ViewGroup) null);
        this.eat.addContentView(this.dLY, new FrameLayout.LayoutParams(-1, -1));
        this.bGN = this.eat.findViewById(u.g.statebar_view);
        this.egH = (ObservedChangeLinearLayout) this.eat.findViewById(u.g.title_wrapper);
        this.bmB = (NoNetworkView) this.eat.findViewById(u.g.view_no_network);
        this.bqG = (BdTypeListView) this.eat.findViewById(u.g.new_pb_list);
        this.anB = new TextView(this.eat.getActivity());
        this.anB.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.c(this.eat.getActivity(), u.e.ds98)));
        this.bqG.f(this.anB, 0);
        View view = new View(this.eat.getPageContext().getPageActivity());
        view.setLayoutParams(new AbsListView.LayoutParams(-1, this.eat.getResources().getDimensionPixelSize(u.e.ds100)));
        view.setVisibility(4);
        this.bqG.addFooterView(view);
        this.bqG.setOnTouchListener(this.eat.aGS);
        this.efS = new com.baidu.tieba.pb.pb.main.b.e(pbActivity);
        if (this.eat.aIg()) {
            this.efU = (ViewStub) this.eat.findViewById(u.g.manga_view_stub);
            this.efU.setVisibility(0);
            this.efT = new com.baidu.tieba.pb.pb.main.b.c(pbActivity);
            this.efT.show();
            this.efS.mNavigationBar.setVisibility(8);
        }
        this.efS.aLn().setOnTouchListener(new com.baidu.tieba.pb.a.a(new ga(this)));
        this.eho = this.eat.findViewById(u.g.pb_editor_tool_comment);
        this.ehp = (TextView) this.eat.findViewById(u.g.pb_editor_tool_comment_reply_text);
        this.ehr = (ViewGroup) this.eat.findViewById(u.g.pb_editor_tool_comment_reply_layout);
        this.ehs = (TextView) this.eat.findViewById(u.g.pb_editor_tool_comment_praise_icon);
        this.ehv = (HeadImageView) this.eat.findViewById(u.g.pb_editor_tool_comment_avatar);
        aKq();
        this.ehw = (ImageView) this.eat.findViewById(u.g.pb_editor_tool_comment_share_icon);
        this.ehw.setOnClickListener(this.bGw);
        boolean al = com.baidu.tieba.graffiti.d.al(this.ehs);
        if (al) {
            ib(al);
            this.ehs.setVisibility(0);
        }
        this.ehq = (TextView) this.eat.findViewById(u.g.pb_editor_tool_comment_reply_count_text);
        this.egc = new dd(this.eat, this.dLY);
        this.egc.init();
        this.egc.a(this.egc.aIS(), this.bGw);
        this.ehr.setOnClickListener(new gb(this));
        this.ehs.setOnClickListener(this.bGw);
        this.ehs.setOnTouchListener(this.eat);
        this.efX = LayoutInflater.from(this.eat.getPageContext().getPageActivity()).inflate(u.h.new_pb_header_item, (ViewGroup) null);
        this.efZ = (LinearLayout) LayoutInflater.from(this.eat.getPageContext().getPageActivity()).inflate(u.h.new_pb_header_user_item, (ViewGroup) null);
        this.ega = new com.baidu.tieba.pb.data.b(0);
        this.ega.dXE = this.eat;
        this.ega.aGK();
        this.egb = new g(this.eat, this.efZ);
        this.egb.init();
        this.egb.a(this.egb.aHI(), this.bGw);
        this.egd = (ColumnLayout) this.efZ.findViewById(u.g.pb_head_owner_root);
        this.ege = (ThreadSkinView) this.efZ.findViewById(u.g.pb_thread_skin);
        this.egd.setOnLongClickListener(this.onLongClickListener);
        this.egd.setOnTouchListener(this.dYQ);
        this.egd.setVisibility(8);
        this.efX.setOnTouchListener(this.dYQ);
        this.egf = (TextView) this.efX.findViewById(u.g.pb_head_post_title);
        this.egf.setTextSize(TbConfig.getContentSizeOfPostTitle());
        this.egf.setVisibility(8);
        this.ehC = this.efX.findViewById(u.g.pb_head_activity_join_number_container);
        this.ehC.setVisibility(8);
        this.ehD = (TextView) this.efX.findViewById(u.g.pb_head_activity_join_number);
        this.egg = (TextView) this.egd.findViewById(u.g.pb_head_owner_info_user_name);
        this.egh = (FrameLayout) this.egd.findViewById(u.g.pb_head_headImage_container);
        this.egi = (HeadImageView) this.egd.findViewById(u.g.pb_head_owner_photo);
        this.aSW = (ViewStub) this.egd.findViewById(u.g.viewstub_headimage_mask);
        if (!this.dZp) {
            this.egi.setVisibility(8);
        }
        this.egj = (ImageView) this.egd.findViewById(u.g.pb_head_owner_info_user_rank);
        this.egk = (ImageView) this.egd.findViewById(u.g.pb_head_owner_info_user_gender);
        this.egl = (ImageView) this.egd.findViewById(u.g.pb_head_owner_info_user_bawu);
        this.egm = (UserIconBox) this.egd.findViewById(u.g.pb_head_owner_info_user_icon);
        this.egn = (UserIconBox) this.egd.findViewById(u.g.pb_head_owner_info_tshow_icon);
        this.ego = (ImageView) this.egd.findViewById(u.g.pb_head_owner_info_floor_owner);
        this.egq = (TextView) this.egd.findViewById(u.g.pb_head_owner_info_floor);
        this.egp = (TextView) this.egd.findViewById(u.g.pb_head_owner_info_time);
        this.egr = (TextView) this.efX.findViewById(u.g.pb_head_read_button);
        this.egr.setOnClickListener(this.bGw);
        this.egv = (TextView) this.efX.findViewById(u.g.pb_head_reverse_hint);
        this.egv.setOnClickListener(this.bGw);
        this.egv.setVisibility(8);
        this.egy = (UserLikeButton) this.egd.findViewById(u.g.pb_like_button);
        this.egD = this.efX.findViewById(u.g.new_pb_header_item_line_above_livepost);
        this.egE = this.efX.findViewById(u.g.new_pb_header_item_line_below_livepost);
        this.efX.setOnLongClickListener(new gc(this));
        aKt();
        this.ehE = (ViewStub) this.dLY.findViewById(u.g.interview_status_stub);
        this.egI = new ch(this.eat, this.bqG);
        this.egI.J(this.bGw);
        this.egI.a(this.dYQ);
        this.egI.setOnImageClickListener(this.aGw);
        this.dZu = new gd(this);
        this.egI.I(this.dZu);
        this.bqG.addHeaderView(this.efZ);
        this.bqG.addHeaderView(this.efX);
        this.egN = new PbListView(this.eat.getPageContext().getPageActivity());
        this.axQ = this.egN.getView().findViewById(u.g.pb_more_view);
        if (this.axQ != null) {
            this.axQ.setOnClickListener(this.bGw);
            com.baidu.tbadk.core.util.av.k(this.axQ, u.f.pb_foot_more_trans_selector);
        }
        this.egN.va();
        this.egN.cR(u.f.pb_foot_more_trans_selector);
        this.egN.cS(u.f.pb_foot_more_trans_selector);
        this.egP = this.eat.findViewById(u.g.viewstub_progress);
        this.eat.registerListener(this.eil);
        this.egy.i(this.eat.getUniqueId());
    }

    public void aKj() {
        if (this.bqG != null) {
            this.bqG.removeHeaderView(this.efZ);
            this.bqG.removeHeaderView(this.efX);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKk() {
        if (this.eat.aIg()) {
            this.efV = (ViewStub) this.eat.findViewById(u.g.manga_mention_controller_view_stub);
            this.efV.setVisibility(0);
            if (this.egz == null) {
                this.egz = (LinearLayout) this.eat.findViewById(u.g.manga_controller_layout);
                com.baidu.tbadk.j.a.a(this.eat.getPageContext(), this.egz);
            }
            if (this.egA == null) {
                this.egA = (TextView) this.egz.findViewById(u.g.manga_prev_btn);
            }
            if (this.egB == null) {
                this.egB = (TextView) this.egz.findViewById(u.g.manga_next_btn);
            }
            this.egA.setOnClickListener(this.bGw);
            this.egB.setOnClickListener(this.bGw);
        }
    }

    private void aKl() {
        if (this.eat.aIg()) {
            if (this.eat.aIj() == -1) {
                com.baidu.tbadk.core.util.av.c(this.egA, u.d.cp_cont_e, 1);
            }
            if (this.eat.aIk() == -1) {
                com.baidu.tbadk.core.util.av.c(this.egB, u.d.cp_cont_e, 1);
            }
        }
    }

    public void aKm() {
        if (this.egz == null) {
            aKk();
        }
        this.efV.setVisibility(8);
        if (this.eij != null && this.eik != null) {
            this.eij.removeCallbacks(this.eik);
        }
    }

    private void a(DealInfoData dealInfoData, boolean z) {
        if (this.ehT) {
            View findViewWithTag = this.efZ.findViewWithTag("pb_god_bottom_line_view_tag");
            if (findViewWithTag != null) {
                this.efZ.removeView(findViewWithTag);
            }
            this.egt.setPadding(this.egt.getPaddingLeft(), this.egt.getCompoundPaddingTop(), this.egt.getPaddingRight(), this.eat.getResources().getDimensionPixelSize(u.e.ds10));
            this.egd.setPadding(TbadkCoreApplication.m10getInst().getResources().getDimensionPixelSize(u.e.ds30), TbadkCoreApplication.m10getInst().getResources().getDimensionPixelSize(u.e.ds20), TbadkCoreApplication.m10getInst().getResources().getDimensionPixelSize(u.e.ds32), 0);
        } else {
            this.egq.setVisibility(8);
            this.egd.setPadding(this.eat.getResources().getDimensionPixelSize(u.e.ds30), this.eat.getResources().getDimensionPixelSize(u.e.ds18), this.eat.getResources().getDimensionPixelSize(u.e.ds30), this.eat.getResources().getDimensionPixelSize(u.e.ds10));
            ((FloatingLayout) this.efZ.findViewById(u.g.pb_head_owner_info_root)).setPadding(0, TbadkCoreApplication.m10getInst().getResources().getDimensionPixelSize(u.e.ds16), 0, 0);
        }
        this.bqG.setOverScrollMode(2);
        this.eho.setPadding(this.eho.getPaddingLeft(), 0, 0, 0);
        com.baidu.tbadk.core.util.av.k(this.eho, u.f.pb_ecomm_comment_bg);
        this.ehr.setBackgroundResource(0);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.ehr.getLayoutParams();
        marginLayoutParams.rightMargin = this.eat.getResources().getDimensionPixelSize(u.e.ds234);
        this.ehr.setLayoutParams(marginLayoutParams);
        TextView textView = (TextView) this.eat.findViewById(u.g.pb_editor_tool_comment_ecomm_buy_layout);
        textView.setVisibility(0);
        View findViewById = this.dLY.findViewById(u.g.pb_editor_tool_comment_layout);
        boolean appResponseToIntentClass = TbadkCoreApplication.m10getInst().appResponseToIntentClass(EcommPersonManagerActivityConfig.class);
        if (z || !appResponseToIntentClass) {
            textView.setVisibility(8);
        } else if (dealInfoData.status != 1) {
            textView.setText(u.j.pb_ecomm_status_off_shelf_text);
            com.baidu.tbadk.core.util.av.l(textView, u.d.cp_other_e_alpha30);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
        } else if (dealInfoData.stock == 0) {
            textView.setText(u.j.pb_ecomm_buy_button_none_text);
            com.baidu.tbadk.core.util.av.l(textView, u.d.cp_other_e_alpha30);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
        } else {
            textView.setText(u.j.pb_ecomm_buy_button_text);
            com.baidu.tbadk.core.util.av.l(textView, u.d.cp_other_e);
            if (this.bGw != null) {
                textView.setOnClickListener(this.bGw);
            }
        }
    }

    public void aKn() {
        if (this.eij != null) {
            if (this.eik != null) {
                this.eij.removeCallbacks(this.eik);
            }
            this.eik = new ey(this);
            this.eij.postDelayed(this.eik, 2000L);
        }
    }

    public void hU(boolean z) {
        this.efS.hU(z);
        if (z && this.ehB) {
            this.egN.setText(this.eat.getResources().getString(u.j.click_load_more));
            this.bqG.setNextPage(this.egN);
            this.efR = 2;
        }
    }

    public void aKo() {
        TbadkCoreApplication.m10getInst().setReadThreadPlayerScreenMaxHeight(this.dLY.getHeight());
    }

    public void setEditorTools(com.baidu.tbadk.editortools.l lVar) {
        this.Cw = lVar;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.dLY.addView(this.Cw, layoutParams);
        this.Cw.onChangeSkinType(TbadkCoreApplication.m10getInst().getSkinType());
        this.Cw.hide();
    }

    public void aKp() {
        if (this.eat != null && this.Cw != null) {
            this.Cw.kB();
        }
    }

    public void oo(String str) {
        if (this.ehq != null) {
            if (TextUtils.isEmpty(str)) {
                str = "0";
            }
            this.ehq.setText(this.eat.getPageContext().getResources().getString(u.j.pb_reply_count_text, str));
        }
    }

    private void aKq() {
        if (this.ehv != null) {
            this.ehv.setIsRound(true);
            this.ehv.setDrawBorder(false);
            this.ehv.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
            if (!StringUtils.isNull(currentPortrait)) {
                String dh = com.baidu.tbadk.core.util.q.dh(currentPortrait);
                this.ehv.setUrl(dh);
                this.ehv.c(dh, 12, false);
            }
        }
    }

    public void I(String str, boolean z) {
        this.ehu = z;
        hV(TbadkCoreApplication.m10getInst().getSkinType() == 1);
    }

    private void hV(boolean z) {
        if (this.ehs != null) {
            if (this.ehu) {
                com.baidu.tbadk.core.util.av.k(this.ehs, u.f.pb_praise_already_click_selector);
                this.ehs.setContentDescription(this.eat.getResources().getString(u.j.cancel_praise));
                return;
            }
            com.baidu.tbadk.core.util.av.k(this.ehs, u.f.pb_praise_normal_click_selector);
            this.ehs.setContentDescription(this.eat.getResources().getString(u.j.frs_item_praise_text));
        }
    }

    public TextView aKr() {
        return this.ehs;
    }

    public void hW(boolean z) {
        if (this.bqG != null) {
            if (!z) {
                this.bqG.setEnabled(z);
                return;
            }
            if (this.ehP == null) {
                this.ehP = new ez(this, z);
            }
            com.baidu.adp.lib.h.h.dL().postDelayed(this.ehP, 10L);
        }
    }

    public void hX(boolean z) {
        if (this.bqG != null && this.anB != null && this.bGN != null) {
            if (z) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.bGN.setVisibility(0);
                    this.bqG.removeHeaderView(this.anB);
                    this.bqG.f(this.anB, 0);
                } else {
                    this.bGN.setVisibility(8);
                    this.bqG.removeHeaderView(this.anB);
                }
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.anB.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = UtilHelper.getLightStatusBarHeight();
                    this.anB.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.anB.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + ig(true);
                this.anB.setLayoutParams(layoutParams2);
            }
            this.bqG.removeHeaderView(this.anB);
            this.bqG.f(this.anB, 0);
            aLi();
        }
    }

    public void aY(View view) {
        boolean z;
        View view2;
        if (this.egH != null && view != null) {
            if (this.eht) {
                z = this.eho.getVisibility() == 0;
            } else {
                z = this.Cw != null && this.Cw.getVisibility() == 0;
            }
            boolean z2 = this.egH.getVisibility() == 0;
            if (z2) {
                TiebaStatic.log("c10084");
                this.ehU = true;
                View findViewById = this.eat.findViewById(u.g.bg_above_list);
                if (findViewById != null && findViewById.getLayoutParams() != null) {
                    findViewById.getLayoutParams().height = this.egH.getHeight();
                    findViewById.setLayoutParams(findViewById.getLayoutParams());
                }
                com.baidu.tieba.tbadkCore.a.a(this.eat, this.egH, u.a.top_fold_up, new fa(this, findViewById));
            } else {
                this.ehU = false;
                com.baidu.tieba.tbadkCore.a.a(this.eat, this.egH, u.a.top_fold_down, new fb(this));
            }
            if (this.eht) {
                view2 = this.eho;
            } else {
                view2 = this.Cw;
            }
            if (z) {
                if (z2) {
                    if (this.Cw != null) {
                        this.Cw.zD();
                    }
                    com.baidu.tieba.tbadkCore.a.a(this.eat, view2, u.a.bottom_fold_down, new fc(this));
                }
            } else if (!z2) {
                com.baidu.tieba.tbadkCore.a.a(this.eat, view2, u.a.bottom_fold_up, new fd(this));
            }
            aIR();
        }
    }

    public ch aKs() {
        return this.egI;
    }

    public void a(PbActivity.c cVar) {
        this.ebF = cVar;
    }

    private void a(com.baidu.tbadk.core.data.bi biVar) {
        if (biVar == null || biVar.rF() == 0) {
            if (this.ehn != null) {
                this.ehn.setVisibility(8);
            }
            if (this.egD != null) {
                this.egD.setVisibility(8);
                return;
            }
            return;
        }
        if (this.ehn == null) {
            this.eat.getLayoutMode().w(((ViewStub) this.efX.findViewById(u.g.live_talk_layout)).inflate());
            this.ehn = (Button) this.efX.findViewById(u.g.pb_head_function_manage_go_to_live_post);
            this.egD = this.efX.findViewById(u.g.new_pb_header_item_line_above_livepost);
        }
        int rG = biVar.rG();
        String string = this.eat.getPageContext().getString(u.j.go_to_live_post_prefix);
        if (rG == 0) {
            string = String.valueOf(string) + this.eat.getPageContext().getString(u.j.go_to_interview_post);
        } else if (rG == 1) {
            string = String.valueOf(string) + this.eat.getPageContext().getString(u.j.go_to_discuss_post);
        }
        this.ehn.setText(string);
        this.ehn.setVisibility(0);
        this.ehn.setOnClickListener(this.bGw);
        this.eiq = true;
        aKG();
        aKJ();
    }

    private void aKt() {
        this.ehx = (LinearLayout) this.efX.findViewById(u.g.btn_show_passed_pb);
        this.ehz = (TextView) this.efX.findViewById(u.g.show_pre_page_view);
        this.ehy = (TextView) this.efX.findViewById(u.g.go_back_top_view);
        this.aIR = this.efX.findViewById(u.g.show_passed_divider);
        this.ehz.setOnClickListener(this.eim);
        this.ehy.setOnClickListener(this.bGw);
        aKJ();
    }

    public TextView aKu() {
        return this.egr;
    }

    public void hY(boolean z) {
        if (this.egr != null) {
            if (z && TbadkCoreApplication.m10getInst().isTTSCanUse() && !this.eih) {
                this.egr.setVisibility(0);
                if (this.ehx != null && this.ehx.getVisibility() == 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ehx.getLayoutParams();
                    layoutParams.topMargin = com.baidu.adp.lib.util.k.c(this.eat.getApplicationContext(), u.e.ds10);
                    this.ehx.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            this.egr.setVisibility(8);
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
        if (this.egR == null) {
            this.egR = LayoutInflater.from(this.eat.getPageContext().getPageActivity()).inflate(u.h.forum_manage_dialog, (ViewGroup) null);
        }
        this.eat.getLayoutMode().w(this.egR);
        if (this.egQ == null) {
            this.egQ = new Dialog(this.eat.getPageContext().getPageActivity(), u.k.common_alert_dialog);
            this.egQ.setCanceledOnTouchOutside(true);
            this.egQ.setCancelable(true);
            this.egQ.setContentView(this.egR);
            WindowManager.LayoutParams attributes = this.egQ.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.k.A(this.eat.getPageContext().getPageActivity()) * 0.9d);
            this.egQ.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.egQ.findViewById(u.g.del_post_btn);
        TextView textView2 = (TextView) this.egQ.findViewById(u.g.forbid_user_btn);
        TextView textView3 = (TextView) this.egQ.findViewById(u.g.disable_reply_btn);
        int intValue = sparseArray.get(u.g.tag_check_mute_from) instanceof Integer ? ((Integer) sparseArray.get(u.g.tag_check_mute_from)).intValue() : -1;
        if ("".equals(sparseArray.get(u.g.tag_del_post_id)) || intValue == 2) {
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
            if ((sparseArray.get(u.g.tag_del_post_type) instanceof Integer ? ((Integer) sparseArray.get(u.g.tag_del_post_type)).intValue() : -1) != 0) {
                textView.setText(u.j.delete);
            } else {
                textView.setText(u.j.delete_post);
            }
            sparseArray2.put(u.g.tag_del_post_id, sparseArray.get(u.g.tag_del_post_id));
            sparseArray2.put(u.g.tag_del_post_type, sparseArray.get(u.g.tag_del_post_type));
            sparseArray2.put(u.g.tag_del_post_is_self, sparseArray.get(u.g.tag_del_post_is_self));
            sparseArray2.put(u.g.tag_manage_user_identity, sparseArray.get(u.g.tag_manage_user_identity));
            textView.setOnClickListener(new fe(this));
        }
        if ("".equals(sparseArray.get(u.g.tag_forbid_user_name)) || aLf()) {
            textView2.setVisibility(8);
        } else {
            SparseArray sparseArray5 = (SparseArray) textView2.getTag();
            if (sparseArray5 == null) {
                sparseArray5 = new SparseArray();
                textView2.setTag(sparseArray5);
            }
            textView2.setVisibility(0);
            sparseArray5.put(u.g.tag_forbid_user_name, sparseArray.get(u.g.tag_forbid_user_name));
            sparseArray5.put(u.g.tag_manage_user_identity, sparseArray.get(u.g.tag_manage_user_identity));
            sparseArray5.put(u.g.tag_forbid_user_post_id, sparseArray.get(u.g.tag_forbid_user_post_id));
            textView2.setOnClickListener(new ff(this));
        }
        if (!((sparseArray.get(u.g.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(u.g.tag_user_mute_visible)).booleanValue())) {
            textView3.setVisibility(8);
        } else {
            SparseArray sparseArray6 = (SparseArray) textView3.getTag();
            if (sparseArray6 == null) {
                sparseArray6 = new SparseArray();
                textView3.setTag(sparseArray6);
            }
            textView3.setVisibility(0);
            if (z) {
                textView3.setText(u.j.un_mute);
            } else {
                textView3.setText(u.j.mute);
            }
            sparseArray6.put(u.g.tag_is_mem, sparseArray.get(u.g.tag_is_mem));
            sparseArray6.put(u.g.tag_user_mute_mute_userid, sparseArray.get(u.g.tag_user_mute_mute_userid));
            sparseArray6.put(u.g.tag_user_mute_mute_username, sparseArray.get(u.g.tag_user_mute_mute_username));
            sparseArray6.put(u.g.tag_user_mute_post_id, sparseArray.get(u.g.tag_user_mute_post_id));
            sparseArray6.put(u.g.tag_user_mute_thread_id, sparseArray.get(u.g.tag_user_mute_thread_id));
            sparseArray6.put(u.g.tag_user_mute_msg, sparseArray.get(u.g.tag_user_mute_msg));
            textView3.setOnClickListener(new fg(this, z));
        }
        com.baidu.adp.lib.h.j.a(this.egQ, this.eat.getPageContext());
    }

    public void a(PbActivity.a aVar) {
        this.ein = aVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(u.g.tag_del_post_id, str);
        sparseArray.put(u.g.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(u.g.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(u.g.tag_del_post_is_self, Boolean.valueOf(z));
        sparseArray.put(ehJ, Integer.valueOf(ehK));
        int i3 = u.j.del_post_confirm;
        if (i == 0) {
            i3 = u.j.del_thread_confirm;
        }
        this.egS = new com.baidu.tbadk.core.dialog.a(this.eat.getActivity());
        this.egS.bM(i3);
        this.egS.A(sparseArray);
        this.egS.a(u.j.dialog_ok, this.eat);
        this.egS.b(u.j.dialog_cancel, new fh(this));
        this.egS.ap(true);
        this.egS.b(this.eat.getPageContext());
        this.egS.rS();
    }

    public void an(ArrayList<com.baidu.tbadk.core.data.y> arrayList) {
        if (this.ehd == null) {
            this.ehd = LayoutInflater.from(this.eat.getPageContext().getPageActivity()).inflate(u.h.commit_good, (ViewGroup) null);
        }
        this.eat.getLayoutMode().w(this.ehd);
        if (this.ehc == null) {
            this.ehc = new Dialog(this.eat.getPageContext().getPageActivity(), u.k.common_alert_dialog);
            this.ehc.setCanceledOnTouchOutside(true);
            this.ehc.setCancelable(true);
            this.ehm = (ScrollView) this.ehd.findViewById(u.g.good_scroll);
            this.ehc.setContentView(this.ehd);
            WindowManager.LayoutParams attributes = this.ehc.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.k.c(this.eat.getPageContext().getPageActivity(), u.e.ds540);
            this.ehc.getWindow().setAttributes(attributes);
            this.ehf = new fj(this);
            this.ehe = (LinearLayout) this.ehd.findViewById(u.g.good_class_group);
            this.ehh = (TextView) this.ehd.findViewById(u.g.dialog_button_cancel);
            this.ehh.setOnClickListener(new fk(this));
            this.ehg = (TextView) this.ehd.findViewById(u.g.dialog_button_ok);
            this.ehg.setOnClickListener(this.bGw);
        }
        this.ehe.removeAllViews();
        this.efW = new ArrayList();
        com.baidu.tieba.pb.pb.main.b.a bD = bD("0", this.eat.getPageContext().getString(u.j.def_good_class));
        this.efW.add(bD);
        bD.setChecked(true);
        this.ehe.addView(bD);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.tieba.pb.pb.main.b.a bD2 = bD(String.valueOf(arrayList.get(i2).oL()), arrayList.get(i2).oK());
                this.efW.add(bD2);
                View view = new View(this.eat.getPageContext().getPageActivity());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.c(this.eat.getPageContext().getPageActivity(), u.e.ds1));
                com.baidu.tbadk.core.util.av.l(view, u.d.cp_bg_line_a);
                view.setLayoutParams(layoutParams);
                this.ehe.addView(view);
                this.ehe.addView(bD2);
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.ehm.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.k.dip2px(this.eat.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.k.dip2px(this.eat.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.k.dip2px(this.eat.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.ehm.setLayoutParams(layoutParams2);
            this.ehm.removeAllViews();
            this.ehm.addView(this.ehe);
        }
        com.baidu.adp.lib.h.j.a(this.ehc, this.eat.getPageContext());
    }

    private com.baidu.tieba.pb.pb.main.b.a bD(String str, String str2) {
        Activity pageActivity = this.eat.getPageContext().getPageActivity();
        com.baidu.tieba.pb.pb.main.b.a aVar = new com.baidu.tieba.pb.pb.main.b.a(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.k.c(pageActivity, u.e.ds100));
        aVar.setOnCheckedChangeListener(this.ehf);
        aVar.setTag(str);
        aVar.setText(str2);
        aVar.setLayoutParams(layoutParams);
        return aVar;
    }

    public void aKv() {
        this.eat.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.eat.hideProgressBar();
        if (z && z2) {
            this.eat.showToast(this.eat.getPageContext().getString(u.j.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.ba.isEmpty(str)) {
                str = TbadkCoreApplication.m10getInst().getResources().getString(u.j.neterror);
            }
            this.eat.showToast(str);
        }
    }

    public void app() {
        this.egP.setVisibility(0);
    }

    public void apo() {
        this.egP.setVisibility(8);
    }

    public View aKw() {
        if (this.ehd != null) {
            return this.ehd.findViewById(u.g.dialog_button_ok);
        }
        return null;
    }

    public String aKx() {
        return this.ehi;
    }

    public View getView() {
        return this.dLY;
    }

    public void aKy() {
        com.baidu.adp.lib.util.k.b(this.eat.getPageContext().getPageActivity(), this.eat.getCurrentFocus());
    }

    public void avQ() {
        this.eat.showProgressBar();
    }

    public void hZ(boolean z) {
        this.eat.hideProgressBar();
        avR();
    }

    public void aKz() {
        this.egN.vh();
    }

    public void aKA() {
    }

    public void aKB() {
        this.eat.hideProgressBar();
        this.egN.vi();
        aFN();
        this.bqG.l(2000L);
        aKJ();
    }

    public void aKC() {
        this.bqG.l(2000L);
        this.ehx.setVisibility(8);
        aKJ();
    }

    public void ia(boolean z) {
        this.egc.g(this.egc.aIS(), z);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.ehr.getLayoutParams();
        marginLayoutParams.rightMargin = z ? this.eat.getResources().getDimensionPixelSize(u.e.ds84) : 0;
        this.ehr.setLayoutParams(marginLayoutParams);
    }

    private void ib(boolean z) {
        int i;
        int i2;
        int dimensionPixelSize = TbadkCoreApplication.m10getInst().getResources().getDimensionPixelSize(u.e.ds16);
        int dimensionPixelSize2 = TbadkCoreApplication.m10getInst().getResources().getDimensionPixelSize(u.e.ds16);
        int dimensionPixelSize3 = TbadkCoreApplication.m10getInst().getResources().getDimensionPixelSize(u.e.ds84);
        int dimensionPixelSize4 = TbadkCoreApplication.m10getInst().getResources().getDimensionPixelSize(u.e.ds14);
        if (z) {
            i = TbadkCoreApplication.m10getInst().getResources().getDimensionPixelSize(u.e.ds16);
            i2 = 0;
        } else {
            i = dimensionPixelSize;
            i2 = dimensionPixelSize3;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ehr.getLayoutParams();
        layoutParams.setMargins(i, dimensionPixelSize2, i2, dimensionPixelSize4);
        this.ehr.setLayoutParams(layoutParams);
    }

    public void c(com.baidu.tbadk.core.data.aa aaVar) {
        this.egc.c(aaVar);
    }

    public boolean aIP() {
        return this.egc.aIP();
    }

    public void aIQ() {
        this.egc.aIQ();
    }

    public void aIR() {
        this.egc.aIR();
    }

    public ImageView aKD() {
        return this.ehw;
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.egI.setOnLongClickListener(onLongClickListener);
    }

    public void a(c.b bVar, boolean z, boolean z2) {
        if (this.ehj != null) {
            this.ehj.dismiss();
            this.ehj = null;
        }
        this.ehj = new com.baidu.tbadk.core.dialog.c(this.eat.getPageContext().getPageActivity());
        this.ehj.bP(u.j.operation);
        if (z2) {
            this.ehj.a(new String[]{this.eat.getPageContext().getString(u.j.copy)}, bVar);
        } else if (!z) {
            this.ehj.a(new String[]{this.eat.getPageContext().getString(u.j.copy), this.eat.getPageContext().getString(u.j.mark)}, bVar);
        } else {
            this.ehj.a(new String[]{this.eat.getPageContext().getString(u.j.copy), this.eat.getPageContext().getString(u.j.remove_mark)}, bVar);
        }
        this.ehj.d(this.eat.getPageContext());
        this.ehj.rV();
    }

    public int aKE() {
        return nO(this.bqG.getFirstVisiblePosition());
    }

    private int nO(int i) {
        com.baidu.adp.widget.ListView.e eVar = (com.baidu.adp.widget.ListView.e) this.bqG.getAdapter();
        if (eVar != null) {
            if (i < eVar.getCount() && i >= 0 && (eVar.getItem(i) instanceof com.baidu.tieba.pb.data.f)) {
                i++;
            }
            int headerViewsCount = (eVar.getHeaderViewsCount() + eVar.jv()) - 1;
            if (i > headerViewsCount) {
                i = headerViewsCount;
            }
            int headersCount = (this.bqG.getAdapter() == null || !(this.bqG.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) ? 0 : ((com.baidu.adp.widget.ListView.e) this.bqG.getAdapter()).getHeadersCount();
            return i > headersCount ? i - headersCount : 0;
        }
        return i;
    }

    public int aKF() {
        return nO(this.bqG.getLastVisiblePosition());
    }

    public void setSelection(int i) {
        this.bqG.setSelection(i);
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.egL.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void j(com.baidu.tieba.pb.data.h hVar) {
        this.egI.b(hVar);
        this.egI.notifyDataSetChanged();
        if (hVar == null) {
            oo("");
        } else {
            oo(com.baidu.tbadk.core.util.ba.y(hVar.aGY().qr()));
        }
        aKJ();
    }

    public void k(com.baidu.tieba.pb.data.h hVar) {
        PraiseData qp;
        if (this.egw == null) {
            this.eat.getLayoutMode().w(((ViewStub) this.efX.findViewById(u.g.praise_layout)).inflate());
            this.egw = (FrsPraiseView) this.efX.findViewById(u.g.pb_head_praise_view);
            this.egw.setIsFromPb(true);
            this.egF = this.efX.findViewById(u.g.new_pb_header_item_line_above_praise);
            this.egw.cX(TbadkCoreApplication.m10getInst().getSkinType());
        }
        if (this.egw != null) {
            boolean aKJ = aKJ();
            if (hVar != null && hVar.aGZ() != null && hVar.aGZ().size() > 0) {
                com.baidu.tieba.tbadkCore.data.s sVar = hVar.aGZ().get(0);
                if ((!this.dZq || sVar.bfB() != 1) && (qp = hVar.aGY().qp()) != null && qp.getUser() != null && qp.getUser().size() > 0) {
                    this.egw.setVisibility(0);
                    this.egw.setIsFromPb(true);
                    this.egw.a(qp, hVar.aGY().getId(), qp.getPostId(), true);
                    this.egw.getVisibility();
                    com.baidu.tieba.graffiti.d.al(this.egw);
                    return;
                }
            }
            this.egw.setVisibility(8);
            if (hVar != null && hVar.getPage() != null && hVar.getPage().po() == 0 && this.dZq) {
                if (aKJ) {
                    this.egE.setVisibility(0);
                } else {
                    this.egE.setVisibility(8);
                }
            } else {
                this.egE.setVisibility(8);
            }
            com.baidu.tieba.graffiti.d.al(this.egE);
        }
    }

    private com.baidu.tieba.tbadkCore.data.s a(com.baidu.tieba.pb.data.h hVar, boolean z, int i) {
        if (z) {
            if (hVar == null || hVar.aGZ() == null || hVar.aGZ().size() <= 0) {
                return null;
            }
            com.baidu.tieba.tbadkCore.data.s sVar = hVar.aGZ().get(0);
            if (sVar.bfB() != 1) {
                sVar = a(hVar);
            }
            if (sVar.getAuthor() != null && sVar.getAuthor().getUserTbVipInfoData() != null && sVar.getAuthor().getUserTbVipInfoData().getvipIntro() != null) {
                sVar.getAuthor().getGodUserData().setIntro(sVar.getAuthor().getUserTbVipInfoData().getvipIntro());
                return sVar;
            }
            return sVar;
        }
        return a(hVar);
    }

    private com.baidu.tieba.tbadkCore.data.s a(com.baidu.tieba.pb.data.h hVar) {
        MetaData metaData;
        if (hVar == null || hVar.aGY() == null || hVar.aGY().getAuthor() == null) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.s sVar = new com.baidu.tieba.tbadkCore.data.s();
        MetaData author = hVar.aGY().getAuthor();
        String userId = author.getUserId();
        HashMap<String, MetaData> userMap = hVar.aGY().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = author;
        }
        sVar.qY(1);
        sVar.setId(hVar.aGY().qL());
        sVar.setTitle(hVar.aGY().getTitle());
        sVar.setTime(hVar.aGY().getCreateTime());
        sVar.setAuthor(metaData);
        return sVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v251, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void b(com.baidu.tieba.pb.data.h hVar, boolean z, int i) {
        if (hVar != null && hVar.aGY() != null) {
            if (hVar.aGZ() != null && hVar.aGZ().size() > 0 && hVar.aGZ().get(0) != null) {
                String str = null;
                if (this.eat.aIq()) {
                    str = "FRS";
                }
                if (hVar.aGZ().get(0).bfB() == 1 && hVar.aGZ().get(0).qP() != null) {
                    this.ege.a(this.eat.getPageContext(), hVar.aGZ().get(0).qP(), com.baidu.tieba.tbadkCore.d.a.b("PB", "c0132", hVar.aGX().getId(), hVar.aGX().getName(), hVar.aGY().getId(), str));
                    this.egd.setPadding(this.egd.getPaddingLeft(), (int) this.eat.getResources().getDimension(u.e.ds20), this.egd.getPaddingRight(), this.egd.getPaddingBottom());
                } else {
                    this.ege.a(null, null, null);
                }
            }
            aLg();
            this.egd.setVisibility(8);
            com.baidu.tieba.tbadkCore.data.s a = a(hVar, z, i);
            if (a != null) {
                String str2 = null;
                boolean z2 = false;
                if (hVar != null && hVar.aGY() != null && hVar.aGY().getAuthor() != null) {
                    str2 = hVar.aGY().getAuthor().getUserId();
                    if (hVar.getPage() != null) {
                        this.ehY = hVar.getPage().pk();
                        z2 = hVar.getPage().pn() == 1;
                    }
                }
                boolean rg = hVar.aGY().rg();
                if (a.getAuthor() != null && a.getAuthor().getUserTbVipInfoData() != null) {
                    this.abg = !StringUtils.isNull(a.getAuthor().getUserTbVipInfoData().getvipV_url());
                }
                this.ehT = !rg && b(a, hVar.aGY().getId(), str2, z2, z);
                if (z) {
                    this.egv.setVisibility(8);
                } else if (!this.eih) {
                    this.egv.setVisibility(0);
                }
                this.egd.setVisibility(0);
                if (this.ega != null && this.ega.dXI != null && this.ega.dXJ != null && hVar.aGY() != null && hVar.aGY().RO != null) {
                    this.egG = true;
                    DealInfoData rs = hVar.aGY().rs();
                    String userId = hVar.aGY().getAuthor().getUserId();
                    boolean z3 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
                    com.baidu.tieba.pb.data.b bVar = new com.baidu.tieba.pb.data.b(1);
                    bVar.dXI = this.ega.dXI;
                    bVar.dXJ = this.ega.dXJ;
                    bVar.dXF = rs;
                    bVar.aGK();
                    a(a, hVar.aGY().getId(), str2, z2, z);
                    a(rs, z3);
                    if (this.efZ != null) {
                        this.bqG.removeHeaderView(this.efZ);
                    }
                    if (this.efX != null) {
                        this.bqG.removeHeaderView(this.efX);
                    }
                    com.baidu.tieba.pb.data.b bVar2 = new com.baidu.tieba.pb.data.b(2);
                    bVar2.dXI = this.ega.dXI;
                    bVar2.dXJ = this.ega.dXJ;
                    bVar2.aJF = this.efZ;
                    bVar2.bqG = this.bqG;
                    bVar2.aGK();
                    this.bqG.addHeaderView(this.efX);
                    aKW();
                    if (this.eat.aHM() != null) {
                        this.eat.aHM().ii(true);
                    }
                }
                SparseArray sparseArray = (SparseArray) this.egd.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    this.egd.setTag(sparseArray);
                }
                sparseArray.put(u.g.tag_clip_board, a);
                sparseArray.put(u.g.tag_is_subpb, false);
                this.egp.setText(com.baidu.tbadk.core.util.ba.t(a.getTime()));
                this.egq.setText(String.format(this.eat.getPageContext().getString(u.j.is_floor), Integer.valueOf(a.bfB())));
                hVar.aGY().re();
                if (!this.eih) {
                    this.egf.setVisibility(0);
                }
                if (!hVar.aGY().rh() && this.egf.getText() != null && this.egf.getText().length() > 0) {
                    this.egf.setVisibility(0);
                } else {
                    this.egf.setVisibility(8);
                }
                k(hVar);
                ArrayList<com.baidu.tbadk.core.data.a> qG = hVar.aGY().qG();
                if (qG != null && qG.size() > 0 && !this.eih) {
                    this.ehD.setText(String.valueOf(qG.get(0).oe()));
                    this.ehC.setVisibility(0);
                    this.eip = true;
                } else {
                    this.ehC.setVisibility(8);
                }
                com.baidu.tbadk.core.util.av.k(this.ehC, u.f.activity_join_num_bg);
                com.baidu.tbadk.core.util.av.c(this.ehD, u.d.cp_link_tip_d, 1);
                if (hVar != null && hVar.aGY() != null && hVar.aGY().getAuthor() != null) {
                    String userId2 = hVar.aGY().getAuthor().getUserId();
                    if (userId2 != null && !userId2.equals("0") && userId2.equals(a.getAuthor().getUserId())) {
                        this.ego.setVisibility(0);
                        this.ego.setAlpha(SocialAPIErrorCodes.ERROR_INVALID_BDUSS);
                    } else {
                        this.ego.setVisibility(8);
                    }
                }
                if (a.getAuthor() != null) {
                    int level_id = a.getAuthor().getLevel_id();
                    int is_bawu = a.getAuthor().getIs_bawu();
                    String bawu_type = a.getAuthor().getBawu_type();
                    int i2 = 3;
                    if (level_id != 0) {
                        this.egj.setVisibility(0);
                        com.baidu.tbadk.core.util.av.c(this.egj, BitmapHelper.getGradeResourceIdNew(level_id));
                        this.egj.setAlpha(SocialAPIErrorCodes.ERROR_INVALID_BDUSS);
                        this.egj.setContentDescription(String.format(TbadkCoreApplication.m10getInst().getString(u.j.degree_in_forum), Integer.valueOf(level_id)));
                        this.egj.setOnClickListener(null);
                    } else {
                        this.egj.setVisibility(8);
                    }
                    if (is_bawu != 0) {
                        this.egl.setAlpha(SocialAPIErrorCodes.ERROR_INVALID_BDUSS);
                        if (bawu_type.equals("manager")) {
                            com.baidu.tbadk.core.util.av.c(this.egl, u.f.pb_manager);
                            this.egj.setVisibility(8);
                            this.egl.setVisibility(0);
                        } else if (bawu_type.equals("assist")) {
                            com.baidu.tbadk.core.util.av.c(this.egl, u.f.pb_assist);
                            this.egj.setVisibility(8);
                            this.egl.setVisibility(0);
                        }
                    }
                    this.egk.setAlpha(SocialAPIErrorCodes.ERROR_INVALID_BDUSS);
                    if (a.getAuthor().getGender() == 2) {
                        com.baidu.tbadk.core.util.av.c(this.egk, u.f.icon_pb_pop_girl);
                        this.egk.setVisibility(0);
                    } else if (a.getAuthor().getGender() == 1) {
                        com.baidu.tbadk.core.util.av.c(this.egk, u.f.icon_pb_pop_boy);
                        this.egk.setVisibility(0);
                    } else {
                        this.egk.setVisibility(8);
                    }
                    String string = a.getAuthor().getName_show() == null ? StringUtils.string(a.getAuthor().getUserName()) : StringUtils.string(a.getAuthor().getName_show());
                    if (!StringUtils.isNull(string)) {
                        int aQ = com.baidu.adp.lib.util.j.aQ(a.getAuthor().getName_show());
                        if (aQ > 14) {
                            i2 = 0;
                        } else if (aQ >= 12) {
                            i2 = 1;
                        } else if (aQ >= 10) {
                            i2 = 2;
                            if (is_bawu == 0) {
                                i2 = 1;
                            }
                        }
                    }
                    ArrayList<IconData> iconInfo = a.getAuthor().getIconInfo();
                    ArrayList<IconData> tShowInfoNew = a.getAuthor().getTShowInfoNew();
                    if (this.egm != null) {
                        this.egm.setTag(u.g.tag_user_id, a.getAuthor().getUserId());
                        this.egm.setOnClickListener(this.eat.ebc.bJt);
                        this.egm.vy();
                        this.egm.a(iconInfo, i2, this.eat.getResources().getDimensionPixelSize(u.e.ds30), this.eat.getResources().getDimensionPixelSize(u.e.ds30), this.eat.getResources().getDimensionPixelSize(u.e.ds10));
                    }
                    if (this.egn != null) {
                        if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                            this.egn.setTag(tShowInfoNew.get(0).getUrl());
                        }
                        this.egn.setOnClickListener(this.eat.ebc.eiK);
                        this.egn.a(tShowInfoNew, 3, this.eat.getResources().getDimensionPixelSize(u.e.ds32), this.eat.getResources().getDimensionPixelSize(u.e.ds32), this.eat.getResources().getDimensionPixelSize(u.e.ds8), true);
                    }
                    if (com.baidu.adp.lib.util.j.aQ(string) > 14) {
                        this.egg.setText(com.baidu.tbadk.core.util.ba.d(a.getAuthor().getName_show(), 14, "..."));
                    } else {
                        this.egg.setText(a.getAuthor().getName_show());
                    }
                    this.egg.setTag(u.g.tag_user_id, a.getAuthor().getUserId());
                    this.egg.setTag(u.g.tag_user_name, a.getAuthor().getName_show());
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                        com.baidu.tbadk.core.util.av.c(this.egg, u.d.cp_cont_h, 1);
                    } else {
                        com.baidu.tbadk.core.util.av.c(this.egg, u.d.cp_cont_f, 1);
                    }
                    this.egi.setUserId(a.getAuthor().getUserId());
                    this.egi.setUserName(a.getAuthor().getUserName());
                    this.egi.setImageDrawable(null);
                    this.egi.setRadius(com.baidu.adp.lib.util.k.c(this.eat.getActivity(), u.e.ds35));
                    this.egi.setTag(a.getAuthor().getUserId());
                    if (!PbNormalLikeButtonSwitchStatic.Fr() || this.ehl || this.ehT || (a.getAuthor().hadConcerned() && a.getAuthor().getGodUserData() != null && a.getAuthor().getGodUserData().getIsFromNetWork())) {
                        this.egy.setVisibility(8);
                    } else {
                        this.egy.setVisibility(0);
                        this.egy.setMode(2);
                        this.egy.setData(a.getAuthor());
                    }
                    if (this.abg) {
                        if (!this.dZp) {
                            this.egi.setVisibility(8);
                        } else {
                            this.egi.setVisibility(0);
                            UserTbVipInfoData userTbVipInfoData = a.getAuthor().getUserTbVipInfoData();
                            if (userTbVipInfoData != null && userTbVipInfoData.getvipV_url() != null && this.aSW != null) {
                                if (this.aSX == null) {
                                    this.aSW.inflate();
                                    this.aSX = (TbImageView) this.egd.findViewById(u.g.user_head_mask);
                                }
                                this.aSX.c(userTbVipInfoData.getvipV_url(), 10, false);
                            }
                            this.egp.setVisibility(8);
                        }
                        this.egq.setVisibility(8);
                        this.egg.setOnClickListener(this.eat.ebc.eiJ);
                        this.egi.setOnClickListener(this.eat.ebc.eiJ);
                        this.egk.setVisibility(0);
                    } else if (this.ehT) {
                        fl flVar = new fl(this, a);
                        this.egg.setOnClickListener(flVar);
                        this.egi.setOnClickListener(flVar);
                        this.egi.setVisibility(8);
                        this.egp.setVisibility(8);
                        this.egq.setVisibility(8);
                        this.egk.setVisibility(8);
                    } else {
                        if (!this.dZp) {
                            this.egi.setVisibility(8);
                        } else {
                            this.egi.setVisibility(0);
                        }
                        this.egg.setOnClickListener(this.eat.ebc.eiJ);
                        this.egi.setOnClickListener(this.eat.ebc.eiJ);
                        this.egk.setVisibility(0);
                    }
                    this.egi.c(a.getAuthor().getPortrait(), 28, false);
                }
                aKG();
                if (hVar != null) {
                    this.egb.s(hVar.aGY());
                }
            }
        }
    }

    private void aKG() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.egr.getLayoutParams();
        int i = layoutParams.topMargin;
        int i2 = layoutParams.bottomMargin;
        if (this.eip) {
            i = com.baidu.adp.lib.util.k.c(TbadkCoreApplication.m10getInst(), u.e.ds20);
        }
        if (this.eiq) {
            i2 = com.baidu.adp.lib.util.k.c(TbadkCoreApplication.m10getInst(), u.e.ds24);
        }
        layoutParams.setMargins(layoutParams.leftMargin, i, layoutParams.rightMargin, i2);
        this.egr.setLayoutParams(layoutParams);
    }

    public boolean aKH() {
        return this.eir;
    }

    private boolean aKI() {
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.userId);
    }

    private boolean g(com.baidu.tbadk.core.data.be beVar) {
        if (beVar == null || beVar.getAuthor() == null || beVar.getAuthor().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), beVar.getAuthor().getUserId());
    }

    public void a(com.baidu.tieba.pb.data.g gVar) {
        if (gVar != null) {
            this.efS.aLr();
            if (!StringUtils.isNull(gVar.forumName)) {
                this.efS.lZ(gVar.forumName);
            }
            String string = this.eat.getResources().getString(u.j.thread_delete_by);
            String str = "";
            switch (com.baidu.adp.lib.h.b.g(gVar.source, 0)) {
                case 100:
                    str = this.eat.getResources().getString(u.j.self);
                    break;
                case 300:
                    str = this.eat.getResources().getString(u.j.bawu);
                    break;
                case 400:
                    str = this.eat.getResources().getString(u.j.system);
                    break;
            }
            this.eat.showNetRefreshView(this.dLY, String.format(string, str), null, this.eat.getResources().getString(u.j.appeal_restore), true, new fm(this, gVar.dXU));
        }
    }

    public void a(com.baidu.tieba.pb.data.h hVar, int i, int i2, boolean z, int i3, boolean z2) {
        Parcelable aKa;
        Parcelable aKa2;
        String sb;
        if (hVar != null) {
            if (hVar.aGY() != null) {
                this.ehG = hVar.aGY().qn();
                this.RD = hVar.aGY().qk();
                if (hVar.aGY().getAnchorLevel() != 0) {
                    this.eir = true;
                }
                this.ehl = g(hVar.aGY());
            }
            if (hVar.getUserData() != null) {
                this.userId = hVar.getUserData().getUserId();
            }
            n(hVar);
            this.ehB = false;
            this.dZq = z;
            aKB();
            b(hVar, z, i);
            if (this.eat.aIg()) {
                if (this.egM == null) {
                    this.egM = new com.baidu.tieba.pb.view.w(this.eat.getPageContext());
                    this.egM.jp();
                    this.egM.a(this.ado);
                }
                this.bqG.setPullRefresh(this.egM);
                this.bqG.removeHeaderView(this.anB);
                this.bqG.f(this.anB, 0);
                if (this.egM != null) {
                    this.egM.cT(TbadkCoreApplication.m10getInst().getSkinType());
                }
            } else if (hVar.getPage().po() == 0 && z) {
                this.bqG.setPullRefresh(null);
                this.efQ = 0;
                this.ehx.setVisibility(8);
            } else {
                if (this.egM == null) {
                    this.egM = new com.baidu.tieba.pb.view.w(this.eat.getPageContext());
                    this.egM.jp();
                    this.egM.a(this.ado);
                }
                this.bqG.setPullRefresh(this.egM);
                this.bqG.removeHeaderView(this.anB);
                this.bqG.f(this.anB, 0);
                this.efQ = 1;
                if (this.egM != null) {
                    this.egM.cT(TbadkCoreApplication.m10getInst().getSkinType());
                }
                this.ehx.setVisibility(0);
                aFN();
            }
            aKJ();
            boolean z3 = this.ehx.getVisibility() == 0;
            this.egI.ht(this.dZq);
            this.egI.hu(z3);
            this.egI.b(hVar);
            this.egI.notifyDataSetChanged();
            if (hVar.aGX() != null) {
                this.mForumName = hVar.aGX().getName();
                this.mForumId = hVar.getForumId();
            }
            this.efS.lZ(this.mForumName);
            if (hVar.aGY() != null) {
                oo(com.baidu.tbadk.core.util.ba.y(hVar.aGY().qr()));
                if (hVar.aGY().qp() != null) {
                    if (hVar.aGY().qp().getNum() < 1) {
                        sb = this.eat.getResources().getString(u.j.frs_item_praise_text);
                    } else {
                        sb = new StringBuilder(String.valueOf(hVar.aGY().qp().getNum())).toString();
                    }
                    if (this.efP != -1) {
                        hVar.aGY().qp().setIsLike(this.efP);
                    }
                    I(sb, hVar.aGY().qp().getIsLike() == 1);
                }
            }
            if (hVar.getPage().pn() == 0 && !z) {
                this.bqG.setNextPage(null);
                this.efR = 1;
            } else if (this.eat.isLogin()) {
                this.bqG.setNextPage(this.egN);
                this.efR = 2;
                aFN();
            } else if (hVar.getPage().pn() == 1) {
                this.ehB = true;
                if (this.egO == null) {
                    this.egO = new com.baidu.tieba.pb.view.d(this.eat.getPageContext());
                }
                this.bqG.setNextPage(this.egO);
                this.efR = 3;
            }
            ArrayList<com.baidu.tieba.tbadkCore.data.s> aGZ = hVar.aGZ();
            if (hVar.getPage().pn() == 0 || aGZ == null || aGZ.size() < hVar.getPage().pm()) {
                this.egN.setText(this.eat.getResources().getString(u.j.list_no_more));
                if (this.eat.aIg() && this.bqG != null && this.bqG.getData() != null && this.bqG.getData().size() == 1 && (this.bqG.getData().get(0) instanceof com.baidu.tieba.pb.data.l)) {
                    this.egN.setText("");
                }
                m(hVar);
            } else if (z2) {
                if (this.eio) {
                    vi();
                    if (hVar.getPage().pn() != 0) {
                        this.egN.setText(this.eat.getResources().getString(u.j.pb_load_more));
                    }
                } else {
                    this.egN.vj();
                }
            } else {
                this.egN.vj();
            }
            if (z) {
                this.ehy.setVisibility(0);
                this.aIR.setVisibility(0);
                this.ehz.setText(this.eat.getResources().getString(u.j.btn_show_passed_pb));
            } else {
                this.ehy.setVisibility(8);
                this.aIR.setVisibility(8);
                this.ehz.setText(this.eat.getResources().getString(u.j.btn_show_passed_pb_aftre));
            }
            if (hVar.aGY() != null && hVar.aGY().getAuthor() != null && hVar.aGY().getAuthor().getType() == 0) {
                this.efS.aLo();
            }
            switch (i) {
                case 2:
                    this.bqG.setSelection(i2 > 1 ? i2 - 2 : 0);
                    if (this.efY != null) {
                        CompatibleUtile.scrollListViewBy(this.bqG, -this.efY.getHeight(), 0);
                        break;
                    }
                    break;
                case 3:
                    if (i3 == 1 && (aKa2 = ep.aJZ().aKa()) != null) {
                        this.bqG.onRestoreInstanceState(aKa2);
                        break;
                    } else {
                        this.bqG.setSelection(0);
                        break;
                    }
                    break;
                case 4:
                    this.eio = false;
                    this.bqG.setSelection(0);
                    break;
                case 5:
                    this.bqG.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1 && (aKa = ep.aJZ().aKa()) != null) {
                        this.bqG.onRestoreInstanceState(aKa);
                        break;
                    } else {
                        this.bqG.setSelection(0);
                        break;
                    }
            }
            if (this.ehG == ehI && aKI()) {
                aLa();
            }
        }
    }

    public void ic(boolean z) {
        this.ehk = z;
        this.efS.ic(z);
    }

    public void vi() {
        if (this.egN != null) {
            this.egN.vi();
        }
        aFN();
    }

    public void Mb() {
        this.bqG.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aKJ() {
        boolean z;
        boolean z2 = true;
        if (this.efY != null && this.efY.getVisibility() == 0) {
            if (this.egC != null) {
                this.egC.setVisibility(0);
                z = true;
            } else {
                z = true;
            }
        } else {
            if (this.egC != null) {
                this.egC.setVisibility(8);
            }
            z = false;
        }
        if (this.ehn != null && this.ehn.getVisibility() == 0) {
            if (this.egD != null) {
                this.egD.setVisibility(0);
            }
        } else {
            if (this.egD != null) {
                this.egD.setVisibility(8);
            }
            z2 = z;
        }
        if ((this.egF == null || this.egF.getVisibility() == 8) && z2 && this.dZq) {
            this.egE.setVisibility(0);
        } else {
            this.egE.setVisibility(8);
        }
        com.baidu.tieba.graffiti.d.al(this.egE);
        return z2;
    }

    private boolean l(com.baidu.tieba.pb.data.h hVar) {
        if (hVar == null || hVar.aGY() == null) {
            return false;
        }
        if (hVar.aGY().qv() == 1 || hVar.aGY().getThreadType() == 33) {
            return true;
        }
        return !(hVar.aGY().qw() == null || hVar.aGY().qw().rF() == 0) || hVar.aGY().qt() == 1 || hVar.aGY().qu() == 1 || hVar.aGY().ra() || hVar.aGY().rn() || hVar.aGY().rg() || hVar.aGY().qH() != null || hVar.aGY().ro() || !com.baidu.tbadk.core.util.ba.isEmpty(hVar.aGY().qq());
    }

    public boolean a(com.baidu.tieba.pb.data.h hVar, boolean z, boolean z2) {
        if (hVar == null) {
            return false;
        }
        if (this.egf != null) {
            if (hVar.aGY().qK() == 0 && !hVar.aGY().rh() && !this.eih) {
                this.egf.setVisibility(0);
                hVar.aGY().re();
                if (l(hVar)) {
                    ArrayList arrayList = new ArrayList();
                    if (hVar.aGY().qv() == 1 || hVar.aGY().getThreadType() == 33 || (hVar.aGY().qw() != null && hVar.aGY().qw().rF() != 0)) {
                        if (hVar.aGY().qh() != null && hVar.aGY().rn()) {
                            if (hVar.aGY().qX() == 2) {
                                arrayList.add(new at.a(u.j.interview_live));
                            }
                        } else {
                            arrayList.add(new at.a(u.j.kn_zhibo));
                        }
                    }
                    if (hVar.aGY().qt() == 1) {
                        arrayList.add(new at.a(u.j.commit_top));
                    }
                    if (hVar.aGY().qu() == 1) {
                        arrayList.add(new at.a(u.j.good));
                    }
                    if (hVar.aGY().rn()) {
                        arrayList.add(ehQ.get(hVar.aGY().qX()));
                    }
                    if (hVar.aGY().ra()) {
                        Integer num = Rs.get(new Point(hVar.aGY().qZ(), hVar.aGY().qY()));
                        if (num != null) {
                            arrayList.add(new at.a(num.intValue(), u.d.cp_other_b, u.f.pic_dot_title_red));
                        } else {
                            arrayList.add(new at.a(u.j.card_promotion_text));
                        }
                    }
                    if (hVar.aGY().rg()) {
                        arrayList.add(new at.a(u.j.vote));
                    }
                    if (hVar.aGY().ro()) {
                        arrayList.add(new at.a(u.j.evaluation));
                    }
                    if (hVar.aGY().qH() != null) {
                        arrayList.add(new at.a(u.j.card_promotion_text, u.d.cp_other_b, u.f.pic_dot_title_red));
                    }
                    if (!com.baidu.tbadk.core.util.ba.isEmpty(hVar.aGY().qq())) {
                        arrayList.add(new at.a(hVar.aGY().qq()));
                    }
                    this.egf.setText(com.baidu.tieba.card.at.a(this.eat.getPageContext().getPageActivity(), hVar.aGY().getTitle(), arrayList));
                } else {
                    this.egf.setText(hVar.aGY().qV());
                }
            } else {
                this.egf.setVisibility(8);
                this.eip = true;
                aKG();
            }
        }
        this.dZq = z;
        com.baidu.tbadk.core.data.be aGY = hVar.aGY();
        if (aGY != null) {
            a(aGY.qw());
        }
        if (hVar.aHf() != 1 || t(aGY) || aGY == null || aGY.ro()) {
            return false;
        }
        aKK();
        Button button = (Button) this.efX.findViewById(u.g.pb_head_function_manage_commit_top);
        Button button2 = (Button) this.efX.findViewById(u.g.pb_head_function_manage_cancel_top);
        Button button3 = (Button) this.efX.findViewById(u.g.pb_head_function_manage_commit_good);
        Button button4 = (Button) this.efX.findViewById(u.g.pb_head_function_manage_cancel_good);
        button.setOnClickListener(this.bGw);
        button2.setOnClickListener(this.bGw);
        button3.setOnClickListener(this.bGw);
        button4.setOnClickListener(this.bGw);
        if (hVar.aGY().qu() == 1) {
            button3.setVisibility(8);
            button4.setVisibility(0);
        } else {
            button3.setVisibility(0);
            button4.setVisibility(8);
        }
        if (hVar.aGY().qt() == 1) {
            button.setVisibility(8);
            button2.setVisibility(0);
        } else {
            button.setVisibility(0);
            button2.setVisibility(8);
        }
        if (hVar.aGY().rn() && hVar.aGY().qX() == 2) {
            button.setEnabled(false);
            com.baidu.tbadk.core.util.av.j((View) button, u.d.cp_cont_d);
        }
        return true;
    }

    private boolean t(com.baidu.tbadk.core.data.be beVar) {
        if (beVar == null) {
            return false;
        }
        return beVar.isDeal && beVar.RO != null;
    }

    private void aKK() {
        if (this.efY == null) {
            this.efY = ((ViewStub) this.efX.findViewById(u.g.pb_header_function_manage)).inflate();
            this.eat.getLayoutMode().w(this.efY);
            this.egC = this.efX.findViewById(u.g.new_pb_header_item_line_above_manage);
            return;
        }
        this.efY.setVisibility(0);
    }

    public void a(com.baidu.tieba.pb.data.h hVar, boolean z, boolean z2, int i) {
        boolean z3;
        boolean z4;
        boolean z5;
        String userId;
        if (hVar != null) {
            a(hVar, z, z2);
            com.baidu.tieba.tbadkCore.data.s a = a(hVar, z, i);
            if (a != null) {
                if (hVar.aHf() != 0 && a.getAuthor() != null && !t(hVar.aGY())) {
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
                    String userId3 = hVar.aGY().getAuthor().getUserId();
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
                        sparseArray.put(u.g.tag_forbid_user_name, a.getAuthor().getUserName());
                        sparseArray.put(u.g.tag_forbid_user_post_id, a.getId());
                    }
                    sparseArray.put(u.g.tag_del_post_id, a.getId());
                    sparseArray.put(u.g.tag_del_post_type, 0);
                    sparseArray.put(u.g.tag_del_post_is_self, Boolean.valueOf(z3));
                    sparseArray.put(u.g.tag_manage_user_identity, Integer.valueOf(hVar.aHf()));
                    sparseArray.put(u.g.tag_should_manage_visible, true);
                    a(u.j.manage, sparseArray, hVar);
                } else if (z4) {
                    SparseArray<Object> sparseArray2 = new SparseArray<>();
                    sparseArray2.put(u.g.tag_del_post_id, a.getId());
                    sparseArray2.put(u.g.tag_del_post_type, 0);
                    sparseArray2.put(u.g.tag_del_post_is_self, Boolean.valueOf(z3));
                    sparseArray2.put(u.g.tag_manage_user_identity, Integer.valueOf(hVar.aHf()));
                    sparseArray2.put(u.g.tag_should_manage_visible, false);
                    a(u.j.delete, sparseArray2, hVar);
                }
            }
            aKJ();
        }
    }

    private void a(int i, SparseArray<Object> sparseArray, com.baidu.tieba.pb.data.h hVar) {
        if (hVar != null && hVar.aGY() != null && !hVar.aGY().ro()) {
            aKK();
            Button button = (Button) this.efX.findViewById(u.g.pb_head_function_manage_delormanage);
            button.setOnClickListener(this.bGw);
            button.setVisibility(0);
            button.setText(i);
            button.setTag(sparseArray);
        }
    }

    public View getNextView() {
        return this.axQ;
    }

    public void op(String str) {
        if (this.egN != null && !StringUtils.isNull(str)) {
            this.egN.setText(str);
        }
    }

    public BdListView LN() {
        return this.bqG;
    }

    public int aKL() {
        return u.g.richText;
    }

    public int WJ() {
        return u.g.user_icon_box;
    }

    public Button aKM() {
        return (Button) this.efX.findViewById(u.g.pb_head_function_manage_commit_good);
    }

    public Button aKN() {
        return (Button) this.efX.findViewById(u.g.pb_head_function_manage_cancel_good);
    }

    public Button aKO() {
        return (Button) this.efX.findViewById(u.g.pb_head_function_manage_commit_top);
    }

    public Button aKP() {
        return (Button) this.efX.findViewById(u.g.pb_head_function_manage_cancel_top);
    }

    public TextView aHI() {
        return this.egb.aHI();
    }

    public void c(BdListView.e eVar) {
        this.bqG.setOnSrollToBottomListener(eVar);
    }

    public void a(t.b bVar) {
        this.ado = bVar;
        if (this.egM != null) {
            this.egM.a(bVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.aj ajVar, a.b bVar) {
        if (ajVar != null) {
            int pl = ajVar.pl();
            int pi = ajVar.pi();
            if (this.egJ != null) {
                this.egJ.rS();
            } else {
                this.egJ = new com.baidu.tbadk.core.dialog.a(this.eat.getPageContext().getPageActivity());
                this.egK = LayoutInflater.from(this.eat.getPageContext().getPageActivity()).inflate(u.h.dialog_direct_pager, (ViewGroup) null);
                this.egJ.y(this.egK);
                this.egJ.a(u.j.dialog_ok, bVar);
                this.egJ.b(u.j.dialog_cancel, new fn(this));
                this.egJ.a(new fo(this));
                this.egJ.b(this.eat.getPageContext()).rS();
            }
            this.egL = (EditText) this.egK.findViewById(u.g.input_page_number);
            this.egL.setText("");
            TextView textView = (TextView) this.egK.findViewById(u.g.current_page_number);
            if (pl <= 0) {
                pl = 1;
            }
            if (pi <= 0) {
                pi = 1;
            }
            textView.setText(MessageFormat.format(this.eat.getApplicationContext().getResources().getString(u.j.current_page), Integer.valueOf(pl), Integer.valueOf(pi)));
            this.eat.ShowSoftKeyPadDelay(this.egL, 150);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.bqG.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.eat.showToast(str);
    }

    public boolean id(boolean z) {
        if (this.Cw == null || !this.Cw.Bo()) {
            return false;
        }
        this.Cw.zD();
        return true;
    }

    public void aKQ() {
        if (this.eis != null) {
            while (this.eis.size() > 0) {
                TbImageView remove = this.eis.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        aKQ();
        if (this.egI.aIC() != null) {
            this.egI.aIC().pause();
        }
    }

    public void onResume() {
        if (this.egI.aIC() != null) {
            this.egI.aIC().resume();
        }
    }

    public void onDestroy() {
        this.eat.hideProgressBar();
        if (this.bmB != null && this.bCV != null) {
            this.bmB.b(this.bCV);
        }
        avR();
        this.egN.vi();
        if (this.ehO != null) {
            com.baidu.adp.lib.h.h.dL().removeCallbacks(this.ehO);
        }
        if (this.ehP != null) {
            com.baidu.adp.lib.h.h.dL().removeCallbacks(this.ehP);
        }
        aKX();
        if (this.eig != null) {
            this.eig.removeAllViews();
        }
        if (this.egd != null && this.eeG != null) {
            this.egd.removeView(this.egh);
            this.eeG = null;
        }
        if (this.ehF != null) {
            this.ehF.clearStatus();
        }
        this.eij = null;
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.egI.aIC() != null) {
            this.egI.aIC().release();
        }
        if (this.bGN != null) {
            this.bGN.setBackgroundDrawable(null);
        }
    }

    public void avR() {
        this.efS.nf();
        com.baidu.adp.lib.util.k.b(this.eat.getPageContext().getPageActivity(), this.egL);
        if (this.ehj != null) {
            this.ehj.dismiss();
        }
        aKR();
    }

    public void hr(boolean z) {
        this.egI.hr(z);
    }

    public void hs(boolean z) {
        this.dZp = z;
        this.egI.hs(z);
    }

    public void ge(boolean z) {
        this.dlB = z;
    }

    public void aKR() {
        if (this.egS != null) {
            this.egS.dismiss();
        }
        if (this.egT != null) {
            com.baidu.adp.lib.h.j.b(this.egT, this.eat.getPageContext());
        }
        if (this.ehc != null) {
            com.baidu.adp.lib.h.j.b(this.ehc, this.eat.getPageContext());
        }
        if (this.egQ != null) {
            com.baidu.adp.lib.h.j.b(this.egQ, this.eat.getPageContext());
        }
    }

    public void onChangeSkinType(int i) {
        this.eat.getLayoutMode().af(i == 1);
        this.eat.getLayoutMode().w(this.dLY);
        this.eat.getLayoutMode().w(this.efZ);
        this.eat.getLayoutMode().w(this.efX);
        if (this.ega != null) {
            com.baidu.tieba.pb.data.b bVar = new com.baidu.tieba.pb.data.b(3);
            bVar.dXI = this.ega.dXI;
            bVar.dXJ = this.ega.dXJ;
            bVar.afy = i;
            bVar.dXE = this.eat;
            bVar.aGK();
        }
        this.eat.getLayoutMode().w(this.axQ);
        this.efS.mNavigationBar.onChangeSkinType(this.eat.getPageContext(), i);
        com.baidu.tbadk.core.util.av.b(this.efS.eiX, u.f.btn_more_selector_s, u.f.btn_more_selector);
        com.baidu.tbadk.core.util.av.b(this.efS.eiY, u.f.icon_floor_addition_selector_s, u.f.icon_floor_addition_selector);
        if (this.egK != null) {
            this.eat.getLayoutMode().w(this.egK);
        }
        ic(this.ehk);
        this.egI.notifyDataSetChanged();
        if (this.egM != null) {
            this.egM.cT(i);
        }
        if (this.egN != null) {
            this.egN.cT(i);
            com.baidu.tbadk.core.util.av.k(this.axQ, u.f.pb_foot_more_trans_selector);
            this.egN.cR(u.f.pb_foot_more_trans_selector);
        }
        if (this.Cw != null) {
            this.Cw.onChangeSkinType(i);
        }
        if (this.egw != null) {
            this.egw.cX(i);
        }
        if (this.egO != null) {
            this.egO.cT(i);
        }
        if (this.efW != null && this.efW.size() > 0) {
            for (com.baidu.tieba.pb.pb.main.b.a aVar : this.efW) {
                aVar.aLm();
            }
        }
        if (this.eig != null) {
            com.baidu.tbadk.core.util.av.l(this.eig, u.d.cp_bg_line_d);
            com.baidu.tbadk.core.util.av.l(this.eia, u.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.av.c(this.eif, u.d.cp_cont_c, 1);
        }
        hV(i == 1);
        this.egc.changeSkinType(i);
        aKl();
        UtilHelper.setStatusBarBackground(this.bGN, i);
        if (this.egy != null) {
            this.egy.aJ(true);
        }
        if (this.egz != null) {
            com.baidu.tbadk.j.a.a(this.eat.getPageContext(), this.egz);
        }
        com.baidu.tbadk.core.util.av.b(this.efS.eiV, u.d.cp_cont_b, u.d.s_navbar_title_color);
    }

    public void setOnImageClickListener(TbRichTextView.d dVar) {
        this.aGw = dVar;
        this.egI.setOnImageClickListener(this.aGw);
    }

    public void g(NoNetworkView.a aVar) {
        this.bCV = aVar;
        if (this.bmB != null) {
            this.bmB.a(this.bCV);
        }
    }

    public void ie(boolean z) {
        this.egI.setIsFromCDN(z);
        this.mIsFromCDN = z;
    }

    public Button aKS() {
        return this.ehn;
    }

    public void m(com.baidu.tieba.pb.data.h hVar) {
        if (hVar != null) {
            ArrayList<com.baidu.tieba.tbadkCore.data.s> aGZ = hVar.aGZ();
            if (aGZ.size() == 1) {
                com.baidu.tieba.tbadkCore.data.s sVar = aGZ.get(0);
                if (sVar.bfH() < sVar.bfA().size()) {
                    if (this.efR != 1) {
                        this.bqG.setNextPage(null);
                        this.efR = 1;
                    }
                } else if (this.efR != 2) {
                    this.bqG.setNextPage(this.egN);
                    this.efR = 2;
                }
            } else if (this.efR != 2) {
                this.bqG.setNextPage(this.egN);
                this.efR = 2;
            }
        }
    }

    public void aKT() {
        if (com.baidu.tbadk.performanceLog.aa.EV().EW()) {
            int lastVisiblePosition = this.bqG.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.bqG.getChildAt(i);
                if (childAt != null) {
                    TbRichTextView tbRichTextView = (TbRichTextView) childAt.findViewById(u.g.richText);
                    if (tbRichTextView != null) {
                        for (int i2 = 0; i2 < tbRichTextView.getChildCount(); i2++) {
                            View childAt2 = tbRichTextView.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.performanceLog.u perfLog = tbImageView.getPerfLog();
                                perfLog.eQ(1001);
                                perfLog.azb = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr = new int[2];
                                    tbRichTextView.getLocationOnScreen(iArr);
                                    if (iArr[1] > com.baidu.adp.lib.util.k.B(TbadkCoreApplication.m10getInst().getContext())) {
                                    }
                                }
                                tbImageView.uS();
                            }
                        }
                    }
                    HeadImageView headImageView = (HeadImageView) childAt.findViewById(u.g.photo);
                    if (headImageView != null) {
                        com.baidu.tbadk.performanceLog.u perfLog2 = headImageView.getPerfLog();
                        perfLog2.eQ(1001);
                        perfLog2.azb = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr2 = new int[2];
                            headImageView.getLocationOnScreen(iArr2);
                            if (iArr2[1] > com.baidu.adp.lib.util.k.B(TbadkCoreApplication.m10getInst().getContext())) {
                            }
                        }
                        headImageView.uS();
                    }
                }
            }
        }
    }

    public void gf(boolean z) {
        if (this.eho != null && this.eho != null) {
            if (this.dlB && !aLj()) {
                gg(z);
            } else {
                gh(z);
            }
        }
    }

    public void aKU() {
        if (this.eho != null) {
            this.eho.setVisibility(8);
        }
    }

    public TextView aKV() {
        return this.ehy;
    }

    public void atw() {
        if (this.ehA == null) {
            this.ehA = new com.baidu.tbadk.core.view.b(this.eat.getPageContext());
        }
        this.ehA.aE(true);
    }

    public void aFN() {
        if (this.ehA != null) {
            this.ehA.aE(false);
        }
    }

    private void a(com.baidu.tieba.tbadkCore.data.s sVar, String str, String str2, boolean z, boolean z2) {
        this.egp.setVisibility(8);
        this.egi.setIsRound(true);
        if (this.efS != null) {
            this.efS.mNavigationBar.setBackgroundResource(0);
            ((ViewGroup.MarginLayoutParams) this.efS.eiV.getLayoutParams()).leftMargin = this.eat.getResources().getDimensionPixelOffset(u.e.ds6);
            this.bqG.removeHeaderView(this.anB);
        }
    }

    private boolean b(com.baidu.tieba.tbadkCore.data.s sVar, String str, String str2, boolean z, boolean z2) {
        FrameLayout.LayoutParams layoutParams;
        if (sVar == null || sVar.getAuthor() == null || sVar.getAuthor().getGodUserData() == null) {
            return false;
        }
        GodUserData godUserData = sVar.getAuthor().getGodUserData();
        if (2 != godUserData.getType()) {
            return false;
        }
        MetaData author = sVar.getAuthor();
        long userIdLong = sVar.getAuthor().getUserIdLong();
        String userName = sVar.getAuthor().getUserName();
        int fansNum = sVar.getAuthor().getFansNum();
        sVar.getId();
        String portrait = sVar.getAuthor().getPortrait();
        fq fqVar = new fq(this, str, new com.baidu.tbadk.coreExtra.d.a(null), author);
        this.egd.setPadding(TbadkCoreApplication.m10getInst().getResources().getDimensionPixelSize(u.e.ds32), TbadkCoreApplication.m10getInst().getResources().getDimensionPixelSize(u.e.ds20), TbadkCoreApplication.m10getInst().getResources().getDimensionPixelSize(u.e.ds32), 0);
        if (sVar.getType() == null || sVar.getType().getId() != com.baidu.tieba.tbadkCore.data.s.QC.getId()) {
            this.efX.setPadding(0, TbadkCoreApplication.m10getInst().getResources().getDimensionPixelSize(u.e.ds34), 0, 0);
        }
        int dimensionPixelSize = TbadkCoreApplication.m10getInst().getResources().getDimensionPixelSize(u.e.ds76);
        if (this.egi.getLayoutParams() == null) {
            layoutParams = new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
        } else {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.egi.getLayoutParams();
            layoutParams2.width = dimensionPixelSize;
            layoutParams2.height = dimensionPixelSize;
            layoutParams = layoutParams2;
        }
        this.egi.setLayoutParams(layoutParams);
        this.egi.setVisibility(8);
        View findViewWithTag = this.egd.findViewWithTag("pb_god_head_image_view_tag");
        if (!(findViewWithTag instanceof ClickableHeaderImageView)) {
            this.eeG = new ClickableHeaderImageView(this.eat.getApplicationContext());
            this.eeG.setGodIconMargin(0);
            this.eeG.setTag("pb_god_head_image_view_tag");
            this.eeG.setUserId(String.valueOf(userIdLong));
            this.eeG.setUserName(userName);
            this.egh.addView(this.eeG, 0, layoutParams);
        } else {
            this.eeG = (ClickableHeaderImageView) findViewWithTag;
        }
        if (this.abg) {
            this.eeG.setIsBigV(true);
        }
        fr frVar = new fr(this, sVar);
        this.egd.setTag(u.g.tag_user_id, String.valueOf(userIdLong));
        this.egd.setTag(u.g.tag_user_name, userName);
        this.efZ.setTag(u.g.tag_user_id, String.valueOf(userIdLong));
        this.efZ.setTag(u.g.tag_user_name, userName);
        if (this.dZp) {
            this.eeG.setVisibility(0);
            this.eeG.setOnClickListener(frVar);
            this.eeG.c(portrait, 28, false);
        } else {
            this.eeG.setVisibility(8);
        }
        if (this.egs == null) {
            this.egs = new TextView(this.eat.getActivity());
            this.egs.setClickable(false);
            this.egs.setIncludeFontPadding(false);
            this.egs.setGravity(16);
            this.egs.setTextSize(0, this.eat.getResources().getDimensionPixelSize(u.e.fontsize24));
            ColumnLayout.a aVar = new ColumnLayout.a(-2, -2, 3, 2);
            aVar.topMargin = this.eat.getResources().getDimensionPixelSize(u.e.ds8);
            aVar.bottomMargin = this.eat.getResources().getDimensionPixelSize(u.e.ds10);
            this.egs.setSingleLine(true);
            com.baidu.tbadk.core.util.av.c(this.egs, u.d.cp_cont_d, 1);
            this.egd.addView(this.egs, -1, aVar);
        }
        String format = String.format(this.eat.getResources().getString(u.j.fans_default_name_god_user), com.baidu.tbadk.core.util.ba.w(fansNum));
        this.egs.setText(format);
        this.egs.setTag(u.g.tag_user_id, String.valueOf(userIdLong));
        this.egs.setTag(u.g.tag_user_name, userName);
        this.egs.setOnClickListener(frVar);
        if (this.egt == null) {
            this.egt = new TextView(this.eat.getActivity());
            this.egt.setClickable(true);
            this.egt.setTextSize(0, this.eat.getResources().getDimensionPixelSize(u.e.fontsize24));
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
            this.egt.setSingleLine(true);
            this.egt.setPadding(this.eat.getResources().getDimensionPixelSize(u.e.ds32), 0, this.eat.getResources().getDimensionPixelSize(u.e.ds128), 0);
            this.egt.setEllipsize(TextUtils.TruncateAt.END);
            this.egt.setTag(u.g.tag_user_id, String.valueOf(userIdLong));
            this.egt.setTag(u.g.tag_user_name, userName);
            com.baidu.tbadk.core.util.av.c(this.egt, u.d.cp_cont_d, 1);
            this.egt.setOnTouchListener(this.dYQ);
            this.efZ.addView(this.egt, layoutParams3);
        }
        String string = this.eat.getResources().getString(u.j.tieba_certification);
        this.egt.setText(StringUtils.isNull(godUserData.getIntro()) ? String.format(string, this.eat.getResources().getString(u.j.god_intro_default)) : String.format(string, godUserData.getIntro()));
        this.egp.setVisibility(8);
        if (this.egu == null) {
            this.egu = new TextView(this.eat.getActivity());
            this.egu.setTextSize(0, this.eat.getResources().getDimensionPixelSize(u.e.fontsize24));
            this.egu.setGravity(17);
            this.egu.setOnClickListener(fqVar);
            ColumnLayout.a aVar2 = new ColumnLayout.a(this.eat.getResources().getDimensionPixelSize(u.e.ds110), this.eat.getResources().getDimensionPixelSize(u.e.ds50), 80, 3);
            aVar2.bottomMargin = this.eat.getResources().getDimensionPixelSize(u.e.ds22);
            this.egd.addView(this.egu, -1, aVar2);
        }
        b(this.egu, godUserData.getFollowed() == 1);
        if (this.ehl || (godUserData.getFollowed() == 1 && godUserData.getIsFromNetWork())) {
            this.egu.setVisibility(8);
        } else {
            this.egu.setVisibility(0);
        }
        if (this.efZ.findViewWithTag("pb_god_bottom_line_view_tag") == null) {
            View view = new View(this.eat.getApplicationContext());
            view.setTag("pb_god_bottom_line_view_tag");
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, this.eat.getResources().getDimensionPixelSize(u.e.ds1));
            layoutParams4.topMargin = this.eat.getResources().getDimensionPixelSize(u.e.ds18);
            layoutParams4.bottomMargin = this.eat.getResources().getDimensionPixelSize(u.e.ds1);
            com.baidu.tbadk.core.util.av.l(view, u.d.cp_bg_line_a);
            this.efZ.addView(view, layoutParams4);
        }
        if (this.ehX == null) {
            this.ehX = new TextView(this.eat.getApplicationContext());
            this.ehX.setId(u.g.pb_god_user_tip_content);
            this.ehX.setEllipsize(TextUtils.TruncateAt.END);
            this.ehX.setGravity(17);
            this.ehX.setSingleLine(true);
            this.ehX.setHeight(this.eat.getResources().getDimensionPixelSize(u.e.ds56));
            this.ehX.setTextSize(0, this.eat.getResources().getDimensionPixelSize(u.e.fontsize24));
            this.ehX.setVisibility(8);
            if (aLd() != null) {
                aLd().addView(this.ehX);
            }
            this.eat.getLayoutMode().w(this.ehX);
        }
        com.baidu.tbadk.core.util.av.k(this.ehX, u.d.common_color_10260);
        com.baidu.tbadk.core.util.av.j((View) this.ehX, u.d.cp_cont_g);
        this.ehX.setOnClickListener(new ft(this));
        this.ehX.setText(String.format(this.eat.getResources().getString(u.j.god_user_floor_owner_tip), com.baidu.tbadk.core.util.ba.w(this.ehY)));
        nP(this.ehY);
        if (this.ehW == null) {
            this.ehW = (LinearLayout) LayoutInflater.from(this.eat.getActivity()).inflate(u.h.god_floating_view, (ViewGroup) null);
            this.ehW.setOnClickListener(frVar);
            this.ehW.setTag(u.g.tag_user_id, String.valueOf(userIdLong));
            this.ehW.setTag(u.g.tag_user_name, userName);
            ClickableHeaderImageView clickableHeaderImageView = (ClickableHeaderImageView) this.ehW.findViewById(u.g.god_floating_owner_photo);
            if (this.abg) {
                ViewStub viewStub = (ViewStub) this.ehW.findViewById(u.g.viewstub_headimage_mask);
                if (viewStub != null && 0 == 0) {
                    viewStub.inflate();
                    TbImageView tbImageView = (TbImageView) this.ehW.findViewById(u.g.user_head_mask);
                    if (tbImageView != null && author != null && author.getUserTbVipInfoData() != null && !StringUtils.isNull(author.getUserTbVipInfoData().getvipV_url())) {
                        tbImageView.c(author.getUserTbVipInfoData().getvipV_url(), 10, false);
                        clickableHeaderImageView.setIsBigV(true);
                    }
                }
            } else {
                clickableHeaderImageView.setGodIconMargin(0);
            }
            clickableHeaderImageView.setOnClickListener(frVar);
            if (!this.dZp) {
                clickableHeaderImageView.setVisibility(8);
            }
            clickableHeaderImageView.setTag(sVar.getAuthor().getUserId());
            clickableHeaderImageView.c(sVar.getAuthor().getPortrait(), 28, false);
            View findViewById = this.ehW.findViewById(u.g.god_floating_owner_info_floor_owner);
            if (str2 != null && !str2.equals("0") && str2.equals(sVar.getAuthor().getUserId())) {
                findViewById.setVisibility(0);
            } else {
                findViewById.setVisibility(8);
            }
            ImageView imageView = (ImageView) this.ehW.findViewById(u.g.god_floating_owner_info_user_rank);
            int level_id = sVar.getAuthor().getLevel_id();
            int is_bawu = sVar.getAuthor().getIs_bawu();
            String bawu_type = sVar.getAuthor().getBawu_type();
            int i = 3;
            if (level_id != 0) {
                imageView.setVisibility(0);
                com.baidu.tbadk.core.util.av.c(imageView, BitmapHelper.getGradeResourceIdNew(level_id));
                imageView.setContentDescription(String.format(TbadkCoreApplication.m10getInst().getString(u.j.degree_in_forum), Integer.valueOf(level_id)));
                imageView.setOnClickListener(null);
            } else {
                imageView.setVisibility(8);
            }
            ImageView imageView2 = (ImageView) this.ehW.findViewById(u.g.god_floating_owner_info_user_bawu);
            if (is_bawu != 0) {
                if (bawu_type.equals("manager")) {
                    com.baidu.tbadk.core.util.av.c(imageView2, u.f.pb_manager);
                    imageView.setVisibility(8);
                    imageView2.setVisibility(0);
                } else if (bawu_type.equals("assist")) {
                    com.baidu.tbadk.core.util.av.c(imageView2, u.f.pb_assist);
                    imageView.setVisibility(8);
                    imageView2.setVisibility(0);
                }
            }
            if (!StringUtils.isNull(sVar.getAuthor().getName_show()) && com.baidu.adp.lib.util.j.aQ(sVar.getAuthor().getName_show()) > 14) {
                i = 0;
            }
            ArrayList<IconData> iconInfo = sVar.getAuthor().getIconInfo();
            ArrayList<IconData> tShowInfoNew = sVar.getAuthor().getTShowInfoNew();
            UserIconBox userIconBox = (UserIconBox) this.ehW.findViewById(u.g.god_floating_owner_info_user_icon);
            UserIconBox userIconBox2 = (UserIconBox) this.ehW.findViewById(u.g.god_floating_owner_info_tshow_icon);
            if (userIconBox != null) {
                userIconBox.setTag(u.g.tag_user_id, sVar.getAuthor().getUserId());
                userIconBox.setOnClickListener(this.eat.ebc.bJt);
                userIconBox.a(iconInfo, i, this.eat.getResources().getDimensionPixelSize(u.e.ds30), this.eat.getResources().getDimensionPixelSize(u.e.ds30), this.eat.getResources().getDimensionPixelSize(u.e.ds10));
            }
            if (userIconBox2 != null) {
                userIconBox2.setOnClickListener(this.eat.ebc.eiK);
                userIconBox2.a(tShowInfoNew, 3, this.eat.getResources().getDimensionPixelSize(u.e.ds32), this.eat.getResources().getDimensionPixelSize(u.e.ds32), this.eat.getResources().getDimensionPixelSize(u.e.ds8), true);
            }
            TextView textView = (TextView) this.ehW.findViewById(u.g.god_floating_owner_info_user_name);
            if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                com.baidu.tbadk.core.util.av.c(textView, u.d.cp_cont_h, 1);
            } else {
                com.baidu.tbadk.core.util.av.c(textView, u.d.cp_cont_f, 1);
            }
            textView.setText(sVar.getAuthor().getName_show());
            if (aLd() != null) {
                aLd().addView(this.ehW);
            }
            this.eat.getLayoutMode().w(this.ehW);
        }
        TextView textView2 = (TextView) this.ehW.findViewById(u.g.god_floating_gift);
        textView2.setOnClickListener(fqVar);
        b(textView2, godUserData.getFollowed() == 1);
        ImageView imageView3 = (ImageView) this.ehW.findViewById(u.g.god_floating_arrow);
        com.baidu.tbadk.core.util.av.c(imageView3, u.f.icon_arrow_tab);
        if (this.ehl || (godUserData.getFollowed() == 1 && godUserData.getIsFromNetWork())) {
            textView2.setVisibility(8);
            imageView3.setVisibility(0);
        } else {
            textView2.setVisibility(0);
            imageView3.setVisibility(8);
        }
        TextView textView3 = (TextView) this.ehW.findViewById(u.g.god_floating_intro);
        if (textView3 != null) {
            textView3.setText(format);
        }
        this.eig = this.egN.ve();
        if (this.eig != null && !this.ehl && !z && z2 && (godUserData.getFollowed() != 1 || !godUserData.getIsFromNetWork())) {
            this.egN.vf();
            this.egN.vb();
            this.eia = this.eig.findViewWithTag("pb_god_bottom_extra_line_view_tag");
            if (this.eia == null) {
                this.eia = new View(this.eat.getApplicationContext());
                this.eia.setTag("pb_god_bottom_extra_line_view_tag");
                this.eig.addView(this.eia, new LinearLayout.LayoutParams(-1, this.eat.getResources().getDimensionPixelSize(u.e.ds20)));
                this.eie = new FrameLayout(this.eat.getApplicationContext());
                this.eie.setTag("pb_god_bottom_extra_god_avatar_frame_tag");
                this.eic = new ClickableHeaderImageView(this.eat.getApplicationContext());
                this.eic.setTag("pb_god_bottom_extra_god_avatar_tag");
                this.eic.c(portrait, 28, false);
                this.eic.setUserId(String.valueOf(userIdLong));
                this.eic.setUserName(userName);
                this.eic.setOnClickListener(frVar);
                this.eie.addView(this.eic, new FrameLayout.LayoutParams(this.eat.getResources().getDimensionPixelSize(u.e.ds130), this.eat.getResources().getDimensionPixelSize(u.e.ds130)));
                if (this.abg) {
                    this.eid = new TbImageView(this.eat.getApplicationContext());
                    this.eid.setTag("pb_god_bottom_extra_god_avatar_mask_tag");
                    this.eid.c(author.getUserTbVipInfoData().getvipV_url(), 10, false);
                    FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(this.eat.getResources().getDimensionPixelSize(u.e.ds45), this.eat.getResources().getDimensionPixelSize(u.e.ds45));
                    layoutParams5.gravity = 85;
                    this.eie.addView(this.eid, layoutParams5);
                } else {
                    this.eic.setGodIconMargin(0);
                }
                LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(this.eat.getResources().getDimensionPixelSize(u.e.ds130), this.eat.getResources().getDimensionPixelSize(u.e.ds130));
                layoutParams6.gravity = 17;
                layoutParams6.topMargin = this.eat.getResources().getDimensionPixelSize(u.e.ds40);
                this.eig.addView(this.eie, layoutParams6);
                this.eif = new TextView(this.eat.getApplicationContext());
                this.eif.setTag("pb_god_bottom_extra_text_view_tag");
                this.eif.setSingleLine(true);
                this.eif.setTextSize(0, this.eat.getResources().getDimensionPixelSize(u.e.fontsize24));
                LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams7.topMargin = this.eat.getResources().getDimensionPixelSize(u.e.ds36);
                layoutParams7.gravity = 1;
                this.eif.setText(this.eat.getResources().getString(u.j.god_user_attention_tip));
                this.eig.addView(this.eif, layoutParams7);
                this.eib = new TextView(this.eat.getApplicationContext());
                this.eib.setTag("pb_god_bottom_extra_attention_btn_tag");
                this.eib.setSingleLine(true);
                this.eib.setGravity(17);
                this.eib.setTextSize(0, this.eat.getResources().getDimensionPixelSize(u.e.fontsize24));
                this.eib.setOnClickListener(fqVar);
                LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(this.eat.getResources().getDimensionPixelSize(u.e.ds212), this.eat.getResources().getDimensionPixelSize(u.e.ds54));
                layoutParams8.topMargin = this.eat.getResources().getDimensionPixelSize(u.e.ds30);
                layoutParams8.bottomMargin = this.eat.getResources().getDimensionPixelSize(u.e.ds40);
                layoutParams8.gravity = 1;
                this.eig.addView(this.eib, layoutParams8);
            } else {
                this.eib = (TextView) this.eig.findViewWithTag("pb_god_bottom_extra_attention_btn_tag");
                this.eic = (ClickableHeaderImageView) this.eig.findViewWithTag("pb_god_bottom_extra_god_avatar_tag");
                this.eif = (TextView) this.eig.findViewWithTag("pb_god_bottom_extra_text_view_tag");
                this.eia = this.eig.findViewWithTag("pb_god_bottom_extra_line_view_tag");
            }
            com.baidu.tbadk.core.util.av.l(this.eig, u.d.cp_bg_line_d);
            com.baidu.tbadk.core.util.av.l(this.eia, u.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.av.c(this.eif, u.d.cp_cont_c, 1);
            this.eig.setOnTouchListener(new fu(this));
            boolean z3 = godUserData.getFollowed() == 1;
            b(this.eib, z3);
            if (!z3) {
                this.eib.setPadding(this.eat.getResources().getDimensionPixelSize(u.e.ds68), 0, this.eat.getResources().getDimensionPixelSize(u.e.ds52), 0);
            }
        } else {
            this.egN.vg();
            this.egN.va();
        }
        return true;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.ehT && !this.ehU && i > this.efQ) {
            this.ehV = true;
        } else {
            this.ehV = false;
            aKY();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL));
        aKW();
    }

    public void aKW() {
        float f = 1.0f;
        if (this.ega != null && this.ega.dXI != null && this.egG) {
            int dimension = (int) this.eat.getResources().getDimension(u.e.ds98);
            int dimension2 = ((int) this.eat.getResources().getDimension(u.e.ds450)) - (-this.ega.dXI.getTop());
            if (this.bqG.getChildAt(0) == this.ega.dXI && dimension2 >= dimension) {
                if (dimension2 < dimension || dimension2 > dimension * 2) {
                    f = dimension2 > dimension * 2 ? 0.0f : 0.0f;
                } else {
                    f = 1.0f - (((dimension2 - dimension) * 1.0f) / dimension);
                }
            }
            this.efS.V(f);
        }
    }

    private void nP(int i) {
        boolean z;
        if (this.ehX != null && this.ehX.getVisibility() != 0 && i >= 2 && !this.ehl) {
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                z = com.baidu.tbadk.core.sharedPref.b.sN().getBoolean("pb_god_floor_owner_tip_has_shown_" + TbadkCoreApplication.getCurrentAccount(), false);
            } else {
                z = com.baidu.tbadk.core.sharedPref.b.sN().getBoolean("pb_god_floor_owner_not_login_tip_has_shown_" + TbadkCoreApplication.getCurrentAccount(), false);
            }
            if (!z) {
                this.ehZ = true;
                this.ehX.setVisibility(0);
            }
            com.baidu.adp.lib.h.h.dL().postDelayed(this.ctk, 3000L);
        }
    }

    public void aKX() {
        com.baidu.adp.lib.h.h.dL().removeCallbacks(this.ctk);
        if (this.ehX != null && 8 != this.ehX.getVisibility()) {
            com.baidu.tieba.tbadkCore.a.a(this.eat, this.ehX, u.a.fade_out, new fv(this));
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                com.baidu.tbadk.core.sharedPref.b.sN().putBoolean("pb_god_floor_owner_tip_has_shown_" + TbadkCoreApplication.getCurrentAccount(), true);
            } else {
                com.baidu.tbadk.core.sharedPref.b.sN().putBoolean("pb_god_floor_owner_not_login_tip_has_shown_" + TbadkCoreApplication.getCurrentAccount(), true);
            }
        }
    }

    public void aKY() {
        if (this.ehW != null) {
            this.ehW.clearAnimation();
            if (this.ehW.getVisibility() != 8) {
                this.ehW.setVisibility(8);
            }
        }
    }

    public void aKZ() {
        if (this.ehT && this.ehV && this.ehW != null && this.ehW.getVisibility() != 0 && !this.ehZ) {
            this.ehW.clearAnimation();
            this.ehW.setVisibility(0);
        }
    }

    public void aLa() {
        if (!this.eit) {
            TiebaStatic.log("c10490");
            this.eit = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eat.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(ehJ, Integer.valueOf(ehL));
            aVar.bL(u.j.grade_thread_tips);
            View inflate = LayoutInflater.from(this.eat.getPageContext().getPageActivity()).inflate(u.h.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(u.g.function_description_view)).setText(u.j.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(u.g.title_view)).setText(u.j.grade_thread_tips);
            aVar.y(inflate);
            aVar.A(sparseArray);
            aVar.a(u.j.grade_button_tips, this.eat);
            aVar.b(u.j.look_again, new fw(this));
            aVar.b(this.eat.getPageContext()).rS();
        }
    }

    public void aLb() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eat.getPageContext().getPageActivity());
        aVar.cz(this.eat.getResources().getString(u.j.upgrade_to_new_photo_live_tips));
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(ehJ, Integer.valueOf(ehN));
        aVar.A(sparseArray);
        aVar.a(u.j.upgrade_to_new, this.eat);
        aVar.b(u.j.cancel, new fx(this));
        aVar.b(this.eat.getPageContext()).rS();
    }

    public int qn() {
        return this.ehG;
    }

    public void oq(String str) {
        if (str.contains("_")) {
            str = str.replace("_", "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eat.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.eat.getPageContext().getPageActivity()).inflate(u.h.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(u.g.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(u.g.function_description_view)).setVisibility(8);
        aVar.y(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(ehJ, Integer.valueOf(ehM));
        aVar.A(sparseArray);
        aVar.a(u.j.view, this.eat);
        aVar.b(u.j.cancel, new fy(this));
        aVar.b(this.eat.getPageContext()).rS();
    }

    public void a(int i, com.baidu.tieba.pb.data.h hVar, boolean z, int i2) {
        com.baidu.tieba.tbadkCore.data.s a;
        if (i > 0 && (a = a(hVar, z, i2)) != null && a.getAuthor() != null) {
            MetaData author = a.getAuthor();
            author.setGiftNum(author.getGiftNum() + i);
        }
    }

    public void c(com.baidu.tieba.pb.data.h hVar, boolean z, int i) {
        b(hVar, z, i);
    }

    private void b(TextView textView, boolean z) {
        if (z) {
            textView.setClickable(false);
            com.baidu.tbadk.core.util.av.c(textView, u.d.cp_cont_d, 1);
            textView.setText(TbadkCoreApplication.m10getInst().getString(u.j.relate_forum_is_followed));
            textView.setBackgroundDrawable(null);
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setPadding(0, 0, 0, 0);
            return;
        }
        com.baidu.tbadk.core.util.av.c(textView, u.d.btn_forum_focus_color, 1);
        textView.setText(TbadkCoreApplication.m10getInst().getString(u.j.forum_list_attention_tv));
        com.baidu.tbadk.core.util.av.k(textView, u.f.btn_focus_border_bg);
        textView.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.av.getDrawable(u.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        textView.setClickable(true);
        textView.setPadding(TbadkCoreApplication.m10getInst().getResources().getDimensionPixelSize(u.e.ds18), 0, TbadkCoreApplication.m10getInst().getResources().getDimensionPixelSize(u.e.ds10), 0);
    }

    public PbInterviewStatusView aLc() {
        return this.ehF;
    }

    private void n(com.baidu.tieba.pb.data.h hVar) {
        if (hVar != null && hVar.aGY() != null && hVar.aGY().rn() && this.ehF == null) {
            this.ehF = (PbInterviewStatusView) this.ehE.inflate();
            this.ehF.setOnClickListener(this.bGw);
            this.ehF.setCallback(this.eat.aIp());
            this.ehF.a(this.eat, hVar);
        }
    }

    public LinearLayout aLd() {
        return this.egH;
    }

    public View aLe() {
        return this.bGN;
    }

    public boolean aLf() {
        return this.eih;
    }

    public void aIO() {
        this.egc.aIO();
    }

    public void hx(boolean z) {
        this.egb.hx(z);
    }

    private void aLg() {
        if (this.eih) {
            if (this.eii == null) {
                f.a aVar = f.eav.get();
                if (aVar != null) {
                    this.eii = aVar.a(this.eat);
                    ListAdapter adapter = this.bqG.getAdapter();
                    if (adapter != null) {
                        if (adapter.getView(0, null, null) == this.anB) {
                            this.bqG.f(this.eii.aHG(), 1);
                        } else {
                            this.bqG.f(this.eii.aHG(), 0);
                        }
                    }
                } else {
                    this.efZ.setVisibility(0);
                    return;
                }
            }
            this.efZ.setVisibility(8);
            this.bqG.removeHeaderView(this.efZ);
            return;
        }
        this.efZ.setVisibility(0);
    }

    /* renamed from: if  reason: not valid java name */
    public void m19if(boolean z) {
        this.eih = z;
    }

    public View aIS() {
        return this.egc.aIS();
    }

    public void aLh() {
        this.eat.showNetRefreshView(getView(), "");
        View Dg = this.eat.getRefreshView().Dg();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) Dg.getLayoutParams();
        layoutParams.addRule(3, aLd().getId());
        Dg.setLayoutParams(layoutParams);
        this.eat.hideLoadingView(getView());
        if (this.eii != null) {
            this.bqG.removeHeaderView(this.eii.aHG());
            this.eii = null;
        }
    }

    public void or(String str) {
        if (this.efT != null) {
            this.efT.setTitle(str);
        }
    }

    public void Bx() {
        this.egc.Bx();
    }

    public void aHE() {
        if (this.egf != null) {
            this.egf.setTextSize(TbConfig.getContentSizeOfPostTitle());
        }
        if (this.egI != null && this.egI.aIz() != null) {
            this.egI.aIz().aHE();
        }
        if (this.egI != null) {
            if (this.egI.aIA() != null) {
                this.egI.aIA().updateFontSize();
            }
            if (this.egI.aIB() != null) {
                this.egI.aIB().updateFontSize();
            }
        }
    }

    private int ig(boolean z) {
        if (this.ehF == null || this.ehF.getVisibility() != 0 || !z) {
            return 0;
        }
        return 0 + com.baidu.adp.lib.util.k.c(this.eat.getPageContext().getPageActivity(), u.e.ds72);
    }

    private void aLi() {
        if (this.ehF != null && this.ehF.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ehF.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.ehF.setLayoutParams(layoutParams);
        }
    }

    public boolean aLj() {
        return this.egG;
    }

    public boolean aHP() {
        return this.ehT;
    }

    public TextView aLk() {
        return this.egt;
    }
}
