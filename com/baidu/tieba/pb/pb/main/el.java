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
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
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
import com.baidu.tbadk.core.view.t;
import com.baidu.tbadk.data.GodUserData;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.editortools.sendtool.SendView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.view.PbInterviewStatusView;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.FrsPraiseView;
import com.baidu.tieba.tbadkCore.b.a;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class el {
    private com.baidu.tbadk.editortools.l BV;
    private NoNetworkView aWZ;
    private t.b acj;
    private TextView amg;
    private View awm;
    private BdTypeListView bej;
    private View.OnClickListener bjV;
    private View bkp;
    private RelativeLayout dbg;
    private com.baidu.tieba.pb.a.d dfM;
    private PbActivity dhY;
    private View.OnClickListener dhc;
    PbActivity.c djq;
    public int dmW;
    public final com.baidu.tieba.pb.pb.main.b.e dmZ;
    private LinearLayout dnB;
    private TextView dnC;
    private TextView dnD;
    private View dnF;
    private View dnG;
    private ObservedChangeLinearLayout dnI;
    private bz dnJ;
    private PbListView dnO;
    private View dnQ;
    public com.baidu.tieba.pb.pb.main.b.c dna;
    private List<com.baidu.tieba.pb.pb.main.b.a> dnb;
    private View dnc;
    private LinearLayout dne;
    private f dnf;
    private cs dng;
    private ColumnLayout dnh;
    private TextView dni;
    private TextView dnj;
    private HeadImageView dnk;
    private ImageView dnl;
    private ImageView dnm;
    private ImageView dnn;
    private UserIconBox dno;
    private UserIconBox dnp;
    private ImageView dnq;
    private TextView dnr;
    private TextView dns;
    private LinearLayout dnt;
    private TextView dnu;
    private TextView dnv;
    private TextView dnz;
    private View doC;
    private TextView doD;
    private ViewStub doE;
    private PbInterviewStatusView doF;
    private Runnable doO;
    private Runnable doP;
    private View doq;
    private TextView dor;
    private TextView dos;
    private ViewGroup dot;
    private TextView dou;
    private boolean dow;
    private View dpa;
    private TextView dpb;
    private ClickableHeaderImageView dpc;
    private TextView dpd;
    private LinearLayout dpe;
    private boolean dpf;
    private com.baidu.tieba.pb.pb.b.l dpg;
    private Runnable dpj;
    private PbActivity.a dpm;
    private boolean dpo;
    private boolean dpp;
    public static int doH = 2;
    public static int doI = 3;
    public static int doJ = 0;
    public static int doK = 3;
    public static int doL = 4;
    public static int doM = 5;
    public static int doN = 6;
    private static HashMap<Point, Integer> QB = new HashMap<>();
    private static SparseArray<Integer> doQ = new SparseArray<>(3);
    private int dmX = 0;
    private int dmY = 0;
    private final Handler mHandler = new Handler();
    private View dnd = null;
    private TextView dnw = null;
    private TextView dnx = null;
    private TextView dny = null;
    public FrsPraiseView dnA = null;
    private ClickableHeaderImageView dmx = null;
    private View dnE = null;
    private View dnH = null;
    private com.baidu.tbadk.core.dialog.a dnK = null;
    private com.baidu.tbadk.core.dialog.c bjP = null;
    private View dnL = null;
    private EditText dnM = null;
    private com.baidu.tieba.pb.view.s dnN = null;
    private com.baidu.tieba.pb.view.b dnP = null;
    private c.b ckp = null;
    private TbRichTextView.d aFe = null;
    private NoNetworkView.a bes = null;
    private Dialog dnR = null;
    private View dnS = null;
    private com.baidu.tbadk.core.dialog.a dnT = null;
    private Dialog dnU = null;
    private View dnV = null;
    private int dnW = 0;
    private RadioGroup EA = null;
    private RadioButton dnX = null;
    private RadioButton dnY = null;
    private RadioButton dnZ = null;
    private Button doa = null;
    private Button dob = null;
    private TextView dod = null;
    private Dialog doe = null;
    private View dof = null;
    private LinearLayout dog = null;
    private CompoundButton.OnCheckedChangeListener doh = null;
    private TextView doi = null;
    private TextView doj = null;
    private String dok = null;
    private com.baidu.tbadk.core.dialog.c dol = null;
    private boolean dom = false;
    private boolean don = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView doo = null;
    private boolean cDe = false;
    private Button dop = null;
    private boolean dov = true;
    private LinearLayout dox = null;
    private TextView doy = null;
    private TextView doz = null;
    private View aHy = null;
    private com.baidu.tbadk.core.view.b doA = null;
    private boolean dfL = false;
    private boolean doB = false;
    private boolean mIsFromCDN = true;
    private int doG = 0;
    private boolean doR = true;
    private a.InterfaceC0073a doS = new em(this);
    private boolean doT = false;
    private boolean doU = false;
    private boolean doV = false;
    private LinearLayout doW = null;
    private TextView doX = null;
    private int doY = 0;
    private boolean doZ = false;
    private Handler dph = new Handler();
    private CustomMessageListener dpk = new ex(this, CmdConfigCustom.PB_SHOW_MULTIIAMGETOOL);
    private final View.OnClickListener dpl = new fh(this);
    private View.OnLongClickListener onLongClickListener = null;
    private boolean dpn = true;
    private boolean dpq = false;
    private boolean QM = false;
    String userId = null;
    private final List<TbImageView> dpr = new ArrayList();
    private boolean dfJ = true;
    private boolean dps = false;
    private Runnable dpt = new fo(this);

    static {
        QB.put(new Point(1, 1), Integer.valueOf(t.j.lottery_status_ing));
        QB.put(new Point(1, 2), Integer.valueOf(t.j.lottery_status_over));
        QB.put(new Point(1, 3), Integer.valueOf(t.j.lottery_status_off));
        QB.put(new Point(1, 4), Integer.valueOf(t.j.lottery_status_not_start));
        QB.put(new Point(2, 1), Integer.valueOf(t.j.share_picture_status_ing));
        QB.put(new Point(2, 2), Integer.valueOf(t.j.share_picture_status_over));
        QB.put(new Point(2, 3), Integer.valueOf(t.j.share_picture_status_off));
        QB.put(new Point(2, 4), Integer.valueOf(t.j.share_picture_status_not_start));
        doQ.put(1, Integer.valueOf(t.j.interview_live_status_not_start));
        doQ.put(2, Integer.valueOf(t.j.interview_live_status_ing));
        doQ.put(3, Integer.valueOf(t.j.interview_live_status_over));
    }

    public com.baidu.tieba.pb.pb.b.l ayE() {
        return this.dpg;
    }

    public NoNetworkView ayF() {
        return this.aWZ;
    }

    public boolean isFullScreen() {
        return this.doU;
    }

    public void ayG() {
        if (this.BV != null) {
            this.BV.hide();
        }
    }

    public void ayH() {
        reset();
        this.dov = true;
        if (this.BV != null) {
            this.BV.hide();
        }
        if (this.doq != null) {
            if (this.cDe) {
                fp(false);
            } else {
                fq(false);
            }
        }
        axv();
    }

    private void reset() {
        if (this.dhY != null && this.dhY.awr() != null && this.BV != null) {
            com.baidu.tbadk.editortools.d.b.BC().setStatus(0);
            com.baidu.tbadk.editortools.d.e awr = this.dhY.awr();
            awr.Cc();
            if (awr.getWriteImagesInfo() != null) {
                awr.getWriteImagesInfo().setMaxImagesAllowed(10);
            }
            awr.eq(10);
            awr.eo(SendView.ALL);
            awr.ep(SendView.ALL);
            awr.fu(this.dhY.getActivity().getString(t.j.pb_reply_hint));
            com.baidu.tbadk.editortools.s eg = this.BV.eg(23);
            com.baidu.tbadk.editortools.s eg2 = this.BV.eg(2);
            com.baidu.tbadk.editortools.s eg3 = this.BV.eg(5);
            if (eg2 != null) {
                eg2.kC();
            }
            if (eg3 != null) {
                eg3.kC();
            }
            if (eg != null) {
                eg.hide();
            }
            this.BV.invalidate();
        }
    }

    public boolean ayI() {
        return this.dov;
    }

    public void fp(boolean z) {
        if (this.doq != null && this.dor != null && this.dos != null) {
            this.dor.setText(t.j.draft_to_send);
            this.dos.setVisibility(8);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.doq.startAnimation(alphaAnimation);
            }
            this.doq.setVisibility(0);
        }
    }

    public void fq(boolean z) {
        if (this.doq != null && this.dor != null && this.dos != null) {
            this.dor.setText(t.j.reply_floor_host);
            this.dos.setVisibility(0);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.doq.startAnimation(alphaAnimation);
            }
            this.doq.setVisibility(0);
        }
    }

    public com.baidu.tieba.tbadkCore.data.s ayJ() {
        int i;
        View childAt;
        int i2 = 0;
        if (this.bej == null) {
            return null;
        }
        int firstVisiblePosition = this.bej.getFirstVisiblePosition();
        int lastVisiblePosition = this.bej.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.bej.getChildCount();
            int i3 = 0;
            for (int i4 = firstVisiblePosition; i4 <= lastVisiblePosition; i4++) {
                if (i4 - firstVisiblePosition < childCount && (childAt = this.bej.getChildAt(i4 - firstVisiblePosition)) != null) {
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
        int headerViewsCount = i - this.bej.getHeaderViewsCount();
        if (headerViewsCount < 0) {
            headerViewsCount = 0;
        }
        if (this.dnJ.lL(headerViewsCount) != null && this.dnJ.lL(headerViewsCount) != com.baidu.tieba.tbadkCore.data.s.esQ) {
            i2 = headerViewsCount + 1;
        }
        return (com.baidu.tieba.tbadkCore.data.s) this.dnJ.at(i2);
    }

    public el(PbActivity pbActivity, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.d dVar) {
        this.dhY = null;
        this.dbg = null;
        this.bkp = null;
        this.bej = null;
        this.dnc = null;
        this.dne = null;
        this.dnh = null;
        this.dni = null;
        this.dnj = null;
        this.dnk = null;
        this.dnl = null;
        this.dnm = null;
        this.dnn = null;
        this.dno = null;
        this.dnp = null;
        this.dnq = null;
        this.dnr = null;
        this.dns = null;
        this.dnt = null;
        this.dnu = null;
        this.dnv = null;
        this.dnz = null;
        this.dnF = null;
        this.dnG = null;
        this.dnJ = null;
        this.dnO = null;
        this.awm = null;
        this.bjV = null;
        this.dhc = null;
        this.doq = null;
        this.dor = null;
        this.dot = null;
        this.dou = null;
        this.doC = null;
        this.doD = null;
        this.doE = null;
        this.dhY = pbActivity;
        this.bjV = onClickListener;
        this.dfM = dVar;
        this.dbg = (RelativeLayout) LayoutInflater.from(this.dhY.getPageContext().getPageActivity()).inflate(t.h.new_pb_activity, (ViewGroup) null);
        this.dhY.addContentView(this.dbg, new FrameLayout.LayoutParams(-1, -1));
        this.bkp = this.dhY.findViewById(t.g.statebar_view);
        this.dnI = (ObservedChangeLinearLayout) this.dhY.findViewById(t.g.title_wrapper);
        this.aWZ = (NoNetworkView) this.dhY.findViewById(t.g.view_no_network);
        this.bej = (BdTypeListView) this.dhY.findViewById(t.g.new_pb_list);
        this.amg = new TextView(this.dhY.getActivity());
        this.amg.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.c(this.dhY.getActivity(), t.e.ds98)));
        this.bej.f(this.amg, 0);
        View view = new View(this.dhY.getPageContext().getPageActivity());
        view.setLayoutParams(new AbsListView.LayoutParams(-1, this.dhY.getResources().getDimensionPixelSize(t.e.pb_editor_height)));
        view.setVisibility(4);
        this.bej.addFooterView(view);
        this.bej.setOnTouchListener(this.dhY.aFz);
        this.dmZ = new com.baidu.tieba.pb.pb.main.b.e(pbActivity);
        this.dna = new com.baidu.tieba.pb.pb.main.b.c(pbActivity);
        if (this.dhY.awM()) {
            this.dna.show();
            this.dmZ.mNavigationBar.setVisibility(8);
        }
        this.dmZ.azL().setOnTouchListener(new com.baidu.tieba.pb.a.a(new fp(this)));
        this.doq = this.dhY.findViewById(t.g.pb_editor_tool_comment);
        this.dor = (TextView) this.dhY.findViewById(t.g.pb_editor_tool_comment_reply_text);
        this.dot = (ViewGroup) this.dhY.findViewById(t.g.pb_editor_tool_comment_reply_layout);
        this.dou = (TextView) this.dhY.findViewById(t.g.pb_editor_tool_comment_praise_icon);
        boolean aj = com.baidu.tieba.graffiti.d.aj(this.dou);
        if (aj) {
            gW(aj);
            this.dou.setVisibility(0);
        }
        this.dos = (TextView) this.dhY.findViewById(t.g.pb_editor_tool_comment_reply_count_text);
        this.dng = new cs(this.dhY, this.dbg);
        this.dng.init();
        this.dng.a(this.dng.axw(), this.bjV);
        this.dor.setOnClickListener(new fq(this));
        this.dou.setOnClickListener(this.bjV);
        this.dou.setOnTouchListener(this.dhY);
        this.dnc = LayoutInflater.from(this.dhY.getPageContext().getPageActivity()).inflate(t.h.new_pb_header_item, (ViewGroup) null);
        this.dne = (LinearLayout) LayoutInflater.from(this.dhY.getPageContext().getPageActivity()).inflate(t.h.new_pb_header_user_item, (ViewGroup) null);
        this.dnf = new f(this.dhY, this.dne);
        this.dnf.init();
        this.dnf.a(this.dnf.awq(), this.bjV);
        this.dnh = (ColumnLayout) this.dne.findViewById(t.g.pb_head_owner_root);
        this.dnh.setOnLongClickListener(this.onLongClickListener);
        this.dnh.setOnTouchListener(this.dfM);
        this.dnh.setVisibility(8);
        this.dnc.setOnTouchListener(this.dfM);
        this.dni = (TextView) this.dnc.findViewById(t.g.pb_head_post_title);
        this.dni.setTextSize(TbConfig.getContentSizeOfPostTitle());
        this.dni.setVisibility(8);
        this.doC = this.dnc.findViewById(t.g.pb_head_activity_join_number_container);
        this.doC.setVisibility(8);
        this.doD = (TextView) this.dnc.findViewById(t.g.pb_head_activity_join_number);
        this.dnj = (TextView) this.dnh.findViewById(t.g.pb_head_owner_info_user_name);
        this.dnk = (HeadImageView) this.dnh.findViewById(t.g.pb_head_owner_photo);
        if (!this.dfJ) {
            this.dnk.setVisibility(8);
        }
        this.dnl = (ImageView) this.dnh.findViewById(t.g.pb_head_owner_info_user_rank);
        this.dnm = (ImageView) this.dnh.findViewById(t.g.pb_head_owner_info_user_gender);
        this.dnn = (ImageView) this.dnh.findViewById(t.g.pb_head_owner_info_user_bawu);
        this.dno = (UserIconBox) this.dnh.findViewById(t.g.pb_head_owner_info_user_icon);
        this.dnp = (UserIconBox) this.dnh.findViewById(t.g.pb_head_owner_info_tshow_icon);
        this.dnq = (ImageView) this.dnh.findViewById(t.g.pb_head_owner_info_floor_owner);
        this.dns = (TextView) this.dnh.findViewById(t.g.pb_head_owner_info_floor);
        this.dnr = (TextView) this.dnh.findViewById(t.g.pb_head_owner_info_time);
        this.dnt = (LinearLayout) this.dnc.findViewById(t.g.read_thread_view);
        this.dnu = (TextView) this.dnc.findViewById(t.g.pb_head_read_button);
        this.dnv = (TextView) this.dnc.findViewById(t.g.pb_head_read_tip);
        this.dnt.setOnClickListener(this.bjV);
        this.dnz = (TextView) this.dnc.findViewById(t.g.pb_head_reverse_hint);
        this.dnz.setOnClickListener(this.bjV);
        this.dnz.setVisibility(8);
        ayP();
        this.dnF = this.dnc.findViewById(t.g.new_pb_header_item_line_above_livepost);
        this.dnG = this.dnc.findViewById(t.g.new_pb_header_item_line_below_livepost);
        this.dnc.setOnLongClickListener(new fr(this));
        ayV();
        this.doE = (ViewStub) this.dbg.findViewById(t.g.interview_status_stub);
        this.dnJ = new bz(this.dhY, this.bej);
        this.dnJ.I(this.bjV);
        this.dnJ.a(this.dfM);
        this.dnJ.setOnImageClickListener(this.aFe);
        this.dhc = new fs(this);
        this.dnJ.H(this.dhc);
        this.bej.addHeaderView(this.dne);
        this.bej.addHeaderView(this.dnc);
        this.dnO = new PbListView(this.dhY.getPageContext().getPageActivity());
        this.awm = this.dnO.getView().findViewById(t.g.pb_more_view);
        if (this.awm != null) {
            this.awm.setOnClickListener(this.bjV);
            com.baidu.tbadk.core.util.at.k(this.awm, t.f.pb_foot_more_trans_selector);
        }
        this.dnO.uZ();
        this.dnO.cQ(t.f.pb_foot_more_trans_selector);
        this.dnO.cR(t.f.pb_foot_more_trans_selector);
        this.dnQ = this.dhY.findViewById(t.g.viewstub_progress);
        this.dhY.registerListener(this.dpk);
        ayL();
    }

    public void ayK() {
        if (this.bej != null) {
            this.bej.removeHeaderView(this.dne);
            this.bej.removeHeaderView(this.dnc);
        }
    }

    private void ayL() {
        this.dnB = (LinearLayout) this.dhY.findViewById(t.g.manga_controller_layout);
        this.dnC = (TextView) this.dhY.findViewById(t.g.manga_prev_btn);
        this.dnD = (TextView) this.dhY.findViewById(t.g.manga_next_btn);
        if (this.dhY.awM()) {
            this.dnC.setOnClickListener(this.bjV);
            this.dnD.setOnClickListener(this.bjV);
            ayO();
        }
    }

    private void ayM() {
        if (this.dhY.awM()) {
            if (this.dhY.awP() == -1) {
                com.baidu.tbadk.core.util.at.c(this.dnC, t.d.cp_cont_e, 1);
            }
            if (this.dhY.awQ() == -1) {
                com.baidu.tbadk.core.util.at.c(this.dnD, t.d.cp_cont_e, 1);
            }
        }
    }

    public void ayN() {
        this.dnB.setVisibility(8);
        if (this.dph != null && this.dpj != null) {
            this.dph.removeCallbacks(this.dpj);
        }
    }

    public void ayO() {
        if (this.dph != null) {
            if (this.dpj != null) {
                this.dph.removeCallbacks(this.dpj);
            }
            this.dpj = new en(this);
            this.dph.postDelayed(this.dpj, 2000L);
        }
    }

    public void gP(boolean z) {
        this.dmZ.gP(z);
        if (z && this.doB) {
            this.dnO.setText(this.dhY.getResources().getString(t.j.click_load_more));
            this.bej.setNextPage(this.dnO);
            this.dmY = 2;
        }
    }

    private void ayP() {
        if (com.baidu.tbadk.core.sharedPref.b.sQ().getBoolean("should_show_pb_read_text", true)) {
            this.dnv.setVisibility(0);
        }
    }

    public void ayQ() {
        this.dnv.setVisibility(8);
        com.baidu.tbadk.core.sharedPref.b.sQ().putBoolean("should_show_pb_read_text", false);
    }

    public void ayR() {
        TbadkCoreApplication.m11getInst().setReadThreadPlayerScreenMaxHeight(this.dbg.getHeight());
    }

    public void setEditorTools(com.baidu.tbadk.editortools.l lVar) {
        this.BV = lVar;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.dbg.addView(this.BV, layoutParams);
        this.BV.onChangeSkinType(TbadkCoreApplication.m11getInst().getSkinType());
        this.BV.hide();
    }

    public void ayS() {
        if (this.dhY != null && this.BV != null) {
            this.BV.kC();
        }
    }

    public void ma(String str) {
        if (this.dos != null) {
            if (TextUtils.isEmpty(str)) {
                str = "0";
            }
            this.dos.setText(this.dhY.getPageContext().getResources().getString(t.j.pb_reply_count_text, str));
        }
    }

    public void G(String str, boolean z) {
        this.dow = z;
        gQ(TbadkCoreApplication.m11getInst().getSkinType() == 1);
    }

    private void gQ(boolean z) {
        if (this.dou != null) {
            if (this.dow) {
                com.baidu.tbadk.core.util.at.k(this.dou, t.f.pb_praise_already_click_selector);
                this.dou.setContentDescription(this.dhY.getResources().getString(t.j.cancel_praise));
                return;
            }
            com.baidu.tbadk.core.util.at.k(this.dou, t.f.pb_praise_normal_click_selector);
            this.dou.setContentDescription(this.dhY.getResources().getString(t.j.frs_item_praise_text));
        }
    }

    public TextView ayT() {
        return this.dou;
    }

    public void gR(boolean z) {
        if (this.bej != null) {
            if (!z) {
                this.bej.setEnabled(z);
                return;
            }
            if (this.doP == null) {
                this.doP = new eo(this, z);
            }
            com.baidu.adp.lib.h.h.dL().postDelayed(this.doP, 10L);
        }
    }

    public void gS(boolean z) {
        if (this.bej != null && this.amg != null && this.bkp != null) {
            if (z) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.bkp.setVisibility(0);
                    this.bej.removeHeaderView(this.amg);
                    this.bej.f(this.amg, 0);
                } else {
                    this.bkp.setVisibility(8);
                    this.bej.removeHeaderView(this.amg);
                }
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.amg.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = UtilHelper.getLightStatusBarHeight();
                    this.amg.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.amg.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + hb(true);
                this.amg.setLayoutParams(layoutParams2);
            }
            this.bej.removeHeaderView(this.amg);
            this.bej.f(this.amg, 0);
            azI();
        }
    }

    public void aQ(View view) {
        boolean z;
        View view2;
        if (this.dnI != null && view != null) {
            if (this.dov) {
                z = this.doq.getVisibility() == 0;
            } else {
                z = this.BV != null && this.BV.getVisibility() == 0;
            }
            boolean z2 = this.dnI.getVisibility() == 0;
            if (z2) {
                TiebaStatic.log("c10084");
                this.doU = true;
                View findViewById = this.dhY.findViewById(t.g.bg_above_list);
                if (findViewById != null && findViewById.getLayoutParams() != null) {
                    findViewById.getLayoutParams().height = this.dnI.getHeight();
                    findViewById.setLayoutParams(findViewById.getLayoutParams());
                }
                com.baidu.tieba.tbadkCore.a.a(this.dhY, this.dnI, t.a.top_fold_up, new ep(this, findViewById));
            } else {
                this.doU = false;
                com.baidu.tieba.tbadkCore.a.a(this.dhY, this.dnI, t.a.top_fold_down, new eq(this));
            }
            if (this.dov) {
                view2 = this.doq;
            } else {
                view2 = this.BV;
            }
            if (z) {
                if (z2) {
                    if (this.BV != null) {
                        this.BV.zx();
                    }
                    com.baidu.tieba.tbadkCore.a.a(this.dhY, view2, t.a.bottom_fold_down, new er(this));
                }
            } else if (!z2) {
                com.baidu.tieba.tbadkCore.a.a(this.dhY, view2, t.a.bottom_fold_up, new es(this));
            }
            axv();
        }
    }

    public bz ayU() {
        return this.dnJ;
    }

    public void a(PbActivity.c cVar) {
        this.djq = cVar;
    }

    private void a(com.baidu.tbadk.core.data.bb bbVar) {
        if (bbVar == null || bbVar.rI() == 0) {
            if (this.dop != null) {
                this.dop.setVisibility(8);
            }
            if (this.dnF != null) {
                this.dnF.setVisibility(8);
                return;
            }
            return;
        }
        if (this.dop == null) {
            this.dhY.getLayoutMode().x(((ViewStub) this.dnc.findViewById(t.g.live_talk_layout)).inflate());
            this.dop = (Button) this.dnc.findViewById(t.g.pb_head_function_manage_go_to_live_post);
            this.dnF = this.dnc.findViewById(t.g.new_pb_header_item_line_above_livepost);
        }
        int rJ = bbVar.rJ();
        String string = this.dhY.getPageContext().getString(t.j.go_to_live_post_prefix);
        if (rJ == 0) {
            string = String.valueOf(string) + this.dhY.getPageContext().getString(t.j.go_to_interview_post);
        } else if (rJ == 1) {
            string = String.valueOf(string) + this.dhY.getPageContext().getString(t.j.go_to_discuss_post);
        }
        this.dop.setText(string);
        this.dop.setVisibility(0);
        this.dop.setOnClickListener(this.bjV);
        this.dpp = true;
        azh();
        azk();
    }

    private void ayV() {
        this.dox = (LinearLayout) this.dnc.findViewById(t.g.btn_show_passed_pb);
        this.doz = (TextView) this.dnc.findViewById(t.g.show_pre_page_view);
        this.doy = (TextView) this.dnc.findViewById(t.g.go_back_top_view);
        this.aHy = this.dnc.findViewById(t.g.show_passed_divider);
        this.doz.setOnClickListener(this.dpl);
        this.doy.setOnClickListener(this.bjV);
        azk();
    }

    public LinearLayout ayW() {
        return this.dnt;
    }

    public void gT(boolean z) {
        if (this.dnt != null) {
            if (z && TbadkCoreApplication.m11getInst().isTTSCanUse() && !this.dpf) {
                this.dnt.setVisibility(0);
                if (this.dox != null && this.dox.getVisibility() == 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dox.getLayoutParams();
                    layoutParams.topMargin = com.baidu.adp.lib.util.k.c(this.dhY.getApplicationContext(), t.e.ds10);
                    this.dox.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            this.dnt.setVisibility(8);
        }
    }

    public void aR(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, boolean z) {
        SparseArray sparseArray2;
        if (this.dnS == null) {
            this.dnS = LayoutInflater.from(this.dhY.getPageContext().getPageActivity()).inflate(t.h.forum_manage_dialog, (ViewGroup) null);
        }
        this.dhY.getLayoutMode().x(this.dnS);
        if (this.dnR == null) {
            this.dnR = new Dialog(this.dhY.getPageContext().getPageActivity(), t.k.common_alert_dialog);
            this.dnR.setCanceledOnTouchOutside(true);
            this.dnR.setCancelable(true);
            this.dnR.setContentView(this.dnS);
            WindowManager.LayoutParams attributes = this.dnR.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.k.B(this.dhY.getPageContext().getPageActivity()) * 0.9d);
            this.dnR.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.dnR.findViewById(t.g.del_post_btn);
        TextView textView2 = (TextView) this.dnR.findViewById(t.g.forbid_user_btn);
        TextView textView3 = (TextView) this.dnR.findViewById(t.g.disable_reply_btn);
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
            textView.setOnClickListener(new et(this));
        }
        if ("".equals(sparseArray.get(t.g.tag_forbid_user_name)) || awi()) {
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
            textView2.setOnClickListener(new eu(this));
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
            textView3.setOnClickListener(new ev(this, z));
        }
        com.baidu.adp.lib.h.j.a(this.dnR, this.dhY.getPageContext());
    }

    public void a(PbActivity.a aVar) {
        this.dpm = aVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(t.g.tag_del_post_id, str);
        sparseArray.put(t.g.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(t.g.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(t.g.tag_del_post_is_self, Boolean.valueOf(z));
        sparseArray.put(doJ, Integer.valueOf(doK));
        int i3 = t.j.del_post_confirm;
        if (i == 0) {
            i3 = t.j.del_thread_confirm;
        }
        this.dnT = new com.baidu.tbadk.core.dialog.a(this.dhY.getActivity());
        this.dnT.bM(i3);
        this.dnT.x(sparseArray);
        this.dnT.a(t.j.dialog_ok, this.dhY);
        this.dnT.b(t.j.dialog_cancel, new ew(this));
        this.dnT.ap(true);
        this.dnT.b(this.dhY.getPageContext());
        this.dnT.rU();
    }

    public void aa(ArrayList<com.baidu.tbadk.core.data.t> arrayList) {
        if (this.dof == null) {
            this.dof = LayoutInflater.from(this.dhY.getPageContext().getPageActivity()).inflate(t.h.commit_good, (ViewGroup) null);
        }
        this.dhY.getLayoutMode().x(this.dof);
        if (this.doe == null) {
            this.doe = new Dialog(this.dhY.getPageContext().getPageActivity(), t.k.common_alert_dialog);
            this.doe.setCanceledOnTouchOutside(true);
            this.doe.setCancelable(true);
            this.doo = (ScrollView) this.dof.findViewById(t.g.good_scroll);
            this.doe.setContentView(this.dof);
            WindowManager.LayoutParams attributes = this.doe.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.k.c(this.dhY.getPageContext().getPageActivity(), t.e.ds540);
            this.doe.getWindow().setAttributes(attributes);
            this.doh = new ey(this);
            this.dog = (LinearLayout) this.dof.findViewById(t.g.good_class_group);
            this.doj = (TextView) this.dof.findViewById(t.g.dialog_button_cancel);
            this.doj.setOnClickListener(new ez(this));
            this.doi = (TextView) this.dof.findViewById(t.g.dialog_button_ok);
            this.doi.setOnClickListener(this.bjV);
        }
        this.dog.removeAllViews();
        this.dnb = new ArrayList();
        com.baidu.tieba.pb.pb.main.b.a bx = bx("0", this.dhY.getPageContext().getString(t.j.def_good_class));
        this.dnb.add(bx);
        bx.setChecked(true);
        this.dog.addView(bx);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.tieba.pb.pb.main.b.a bx2 = bx(String.valueOf(arrayList.get(i2).pk()), arrayList.get(i2).pj());
                this.dnb.add(bx2);
                View view = new View(this.dhY.getPageContext().getPageActivity());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.c(this.dhY.getPageContext().getPageActivity(), t.e.ds1));
                com.baidu.tbadk.core.util.at.l(view, t.d.cp_bg_line_a);
                view.setLayoutParams(layoutParams);
                this.dog.addView(view);
                this.dog.addView(bx2);
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.doo.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.k.dip2px(this.dhY.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.k.dip2px(this.dhY.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.k.dip2px(this.dhY.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.doo.setLayoutParams(layoutParams2);
            this.doo.removeAllViews();
            this.doo.addView(this.dog);
        }
        com.baidu.adp.lib.h.j.a(this.doe, this.dhY.getPageContext());
    }

    private com.baidu.tieba.pb.pb.main.b.a bx(String str, String str2) {
        Activity pageActivity = this.dhY.getPageContext().getPageActivity();
        com.baidu.tieba.pb.pb.main.b.a aVar = new com.baidu.tieba.pb.pb.main.b.a(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.k.c(pageActivity, t.e.ds100));
        aVar.setOnCheckedChangeListener(this.doh);
        aVar.setTag(str);
        aVar.setText(str2);
        aVar.setLayoutParams(layoutParams);
        return aVar;
    }

    public void ayX() {
        this.dhY.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.dhY.hideProgressBar();
        if (z && z2) {
            this.dhY.showToast(this.dhY.getPageContext().getString(t.j.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.ay.isEmpty(str)) {
                str = TbadkCoreApplication.m11getInst().getResources().getString(t.j.neterror);
            }
            this.dhY.showToast(str);
        }
    }

    public void ago() {
        this.dnQ.setVisibility(0);
    }

    public void agn() {
        this.dnQ.setVisibility(8);
    }

    public View ayY() {
        if (this.dof != null) {
            return this.dof.findViewById(t.g.dialog_button_ok);
        }
        return null;
    }

    public String ayZ() {
        return this.dok;
    }

    public View getView() {
        return this.dbg;
    }

    public void aza() {
        com.baidu.adp.lib.util.k.a(this.dhY.getPageContext().getPageActivity(), this.dhY.getCurrentFocus());
    }

    public void amP() {
        this.dhY.showProgressBar();
    }

    public void gU(boolean z) {
        this.dhY.hideProgressBar();
        amQ();
    }

    public void azb() {
        this.dnO.vg();
    }

    public void azc() {
    }

    public void azd() {
        this.dhY.hideProgressBar();
        this.dnO.vh();
        azx();
        this.bej.k(2000L);
        azk();
    }

    public void aze() {
        this.bej.k(2000L);
        this.dox.setVisibility(8);
        azk();
    }

    public void gV(boolean z) {
        this.dng.g(this.dng.axw(), z);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.dot.getLayoutParams();
        marginLayoutParams.rightMargin = z ? this.dhY.getResources().getDimensionPixelSize(t.e.ds84) : 0;
        this.dot.setLayoutParams(marginLayoutParams);
    }

    private void gW(boolean z) {
        int i;
        int i2;
        int dimensionPixelSize = TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds16);
        int dimensionPixelSize2 = TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds16);
        int dimensionPixelSize3 = TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds84);
        int dimensionPixelSize4 = TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds14);
        if (z) {
            i = TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds96);
            i2 = 0;
        } else {
            i = dimensionPixelSize;
            i2 = dimensionPixelSize3;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dot.getLayoutParams();
        layoutParams.setMargins(i, dimensionPixelSize2, i2, dimensionPixelSize4);
        this.dot.setLayoutParams(layoutParams);
    }

    public void b(com.baidu.tbadk.core.data.v vVar) {
        this.dng.b(vVar);
    }

    public boolean axt() {
        return this.dng.axt();
    }

    public void axu() {
        this.dng.axu();
    }

    public void axv() {
        this.dng.axv();
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.dnJ.setOnLongClickListener(onLongClickListener);
    }

    public void a(c.b bVar, boolean z, boolean z2) {
        if (this.dol != null) {
            this.dol.dismiss();
            this.dol = null;
        }
        this.dol = new com.baidu.tbadk.core.dialog.c(this.dhY.getPageContext().getPageActivity());
        this.dol.bP(t.j.operation);
        if (z2) {
            this.dol.a(new String[]{this.dhY.getPageContext().getString(t.j.copy)}, bVar);
        } else if (!z) {
            this.dol.a(new String[]{this.dhY.getPageContext().getString(t.j.copy), this.dhY.getPageContext().getString(t.j.mark)}, bVar);
        } else {
            this.dol.a(new String[]{this.dhY.getPageContext().getString(t.j.copy), this.dhY.getPageContext().getString(t.j.remove_mark)}, bVar);
        }
        this.dol.d(this.dhY.getPageContext());
        this.dol.rX();
    }

    public int azf() {
        return lY(this.bej.getFirstVisiblePosition());
    }

    private int lY(int i) {
        com.baidu.adp.widget.ListView.e eVar = (com.baidu.adp.widget.ListView.e) this.bej.getAdapter();
        if (eVar != null) {
            if (i < eVar.getCount() && i >= 0 && (eVar.getItem(i) instanceof com.baidu.tieba.pb.data.c)) {
                i++;
            }
            int headerViewsCount = (eVar.getHeaderViewsCount() + eVar.jt()) - 1;
            if (i > headerViewsCount) {
                i = headerViewsCount;
            }
            int headersCount = (this.bej.getAdapter() == null || !(this.bej.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) ? 0 : ((com.baidu.adp.widget.ListView.e) this.bej.getAdapter()).getHeadersCount();
            return i > headersCount ? i - headersCount : 0;
        }
        return i;
    }

    public int azg() {
        return lY(this.bej.getLastVisiblePosition());
    }

    public void setSelection(int i) {
        this.bej.setSelection(i);
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.dnM.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void j(com.baidu.tieba.pb.data.e eVar) {
        this.dnJ.b(eVar);
        this.dnJ.notifyDataSetChanged();
        if (eVar == null) {
            ma("");
        } else {
            ma(com.baidu.tbadk.core.util.ay.B(eVar.avB().getReply_num()));
        }
        azk();
    }

    public void k(com.baidu.tieba.pb.data.e eVar) {
        PraiseData praise;
        if (this.dnA == null) {
            this.dhY.getLayoutMode().x(((ViewStub) this.dnc.findViewById(t.g.praise_layout)).inflate());
            this.dnA = (FrsPraiseView) this.dnc.findViewById(t.g.pb_head_praise_view);
            this.dnA.setIsFromPb(true);
            this.dnH = this.dnc.findViewById(t.g.new_pb_header_item_line_above_praise);
            this.dnA.cW(TbadkCoreApplication.m11getInst().getSkinType());
        }
        if (this.dnA != null) {
            boolean azk = azk();
            if (eVar != null && eVar.avC() != null && eVar.avC().size() > 0) {
                com.baidu.tieba.tbadkCore.data.s sVar = eVar.avC().get(0);
                if ((!this.dfL || sVar.aTS() != 1) && (praise = eVar.avB().getPraise()) != null && praise.getUser() != null && praise.getUser().size() > 0) {
                    this.dnA.setVisibility(0);
                    this.dnA.setIsFromPb(true);
                    this.dnA.a(praise, eVar.avB().getId(), praise.getPostId(), true);
                    this.dnA.getVisibility();
                    com.baidu.tieba.graffiti.d.aj(this.dnA);
                    return;
                }
            }
            this.dnA.setVisibility(8);
            if (eVar != null && eVar.getPage() != null && eVar.getPage().pL() == 0 && this.dfL) {
                if (azk) {
                    this.dnG.setVisibility(0);
                } else {
                    this.dnG.setVisibility(8);
                }
            } else {
                this.dnG.setVisibility(8);
            }
            com.baidu.tieba.graffiti.d.aj(this.dnG);
        }
    }

    private com.baidu.tieba.tbadkCore.data.s a(com.baidu.tieba.pb.data.e eVar, boolean z, int i) {
        if (z) {
            if (eVar == null || eVar.avC() == null || eVar.avC().size() <= 0) {
                return null;
            }
            com.baidu.tieba.tbadkCore.data.s sVar = eVar.avC().get(0);
            if (sVar.aTS() != 1) {
                return a(eVar);
            }
            return sVar;
        }
        return a(eVar);
    }

    private com.baidu.tieba.tbadkCore.data.s a(com.baidu.tieba.pb.data.e eVar) {
        MetaData metaData;
        if (eVar == null || eVar.avB() == null || eVar.avB().getAuthor() == null) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.s sVar = new com.baidu.tieba.tbadkCore.data.s();
        MetaData author = eVar.avB().getAuthor();
        String userId = author.getUserId();
        HashMap<String, MetaData> userMap = eVar.avB().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = author;
        }
        sVar.po(1);
        sVar.setId(eVar.avB().qZ());
        sVar.setTitle(eVar.avB().getTitle());
        sVar.setTime(eVar.avB().getCreateTime());
        sVar.setAuthor(metaData);
        return sVar;
    }

    private void b(com.baidu.tieba.pb.data.e eVar, boolean z, int i) {
        if (eVar != null && eVar.avB() != null) {
            azG();
            this.dnh.setVisibility(8);
            com.baidu.tieba.tbadkCore.data.s a = a(eVar, z, i);
            if (a != null) {
                String str = null;
                boolean z2 = false;
                if (eVar != null && eVar.avB() != null && eVar.avB().getAuthor() != null) {
                    str = eVar.avB().getAuthor().getUserId();
                    if (eVar.getPage() != null) {
                        this.doY = eVar.getPage().pH();
                        z2 = eVar.getPage().pK() == 1;
                    }
                }
                this.doT = !eVar.avB().rl() && a(a, eVar.avB().getId(), str, z2, z);
                if (z) {
                    this.dnz.setVisibility(8);
                } else if (!this.dpf) {
                    this.dnz.setVisibility(0);
                }
                this.dnh.setVisibility(0);
                SparseArray sparseArray = (SparseArray) this.dnh.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    this.dnh.setTag(sparseArray);
                }
                sparseArray.put(t.g.tag_clip_board, a);
                sparseArray.put(t.g.tag_is_subpb, false);
                this.dnr.setText(com.baidu.tbadk.core.util.ay.x(a.getTime()));
                this.dns.setText(String.format(this.dhY.getPageContext().getString(t.j.is_floor), Integer.valueOf(a.aTS())));
                eVar.avB().rk();
                if (!this.dpf) {
                    this.dni.setVisibility(0);
                }
                if (!eVar.avB().rm()) {
                    this.dni.setVisibility(0);
                }
                k(eVar);
                ArrayList<com.baidu.tbadk.core.data.a> qU = eVar.avB().qU();
                if (qU != null && qU.size() > 0 && !this.dpf) {
                    this.doD.setText(String.valueOf(qU.get(0).ou()));
                    this.doC.setVisibility(0);
                    this.dpo = true;
                } else {
                    this.doC.setVisibility(8);
                }
                com.baidu.tbadk.core.util.at.k(this.doC, t.f.activity_join_num_bg);
                com.baidu.tbadk.core.util.at.c(this.doD, t.d.cp_link_tip_d, 1);
                if (eVar != null && eVar.avB() != null && eVar.avB().getAuthor() != null) {
                    String userId = eVar.avB().getAuthor().getUserId();
                    if (userId != null && !userId.equals("0") && userId.equals(a.getAuthor().getUserId())) {
                        this.dnq.setVisibility(0);
                        this.dnq.setAlpha(SocialAPIErrorCodes.ERROR_INVALID_BDUSS);
                    } else {
                        this.dnq.setVisibility(8);
                    }
                }
                if (a.getAuthor() != null) {
                    int level_id = a.getAuthor().getLevel_id();
                    int is_bawu = a.getAuthor().getIs_bawu();
                    String bawu_type = a.getAuthor().getBawu_type();
                    int i2 = 3;
                    if (level_id != 0) {
                        this.dnl.setVisibility(0);
                        com.baidu.tbadk.core.util.at.c(this.dnl, BitmapHelper.getGradeResourceIdNew(level_id));
                        this.dnl.setAlpha(SocialAPIErrorCodes.ERROR_INVALID_BDUSS);
                        this.dnl.setContentDescription(String.format(TbadkCoreApplication.m11getInst().getString(t.j.degree_in_forum), Integer.valueOf(level_id)));
                        this.dnl.setOnClickListener(null);
                    } else {
                        this.dnl.setVisibility(8);
                    }
                    if (is_bawu != 0) {
                        this.dnn.setAlpha(SocialAPIErrorCodes.ERROR_INVALID_BDUSS);
                        if (bawu_type.equals("manager")) {
                            com.baidu.tbadk.core.util.at.c(this.dnn, t.f.pb_manager);
                            this.dnl.setVisibility(8);
                            this.dnn.setVisibility(0);
                        } else if (bawu_type.equals("assist")) {
                            com.baidu.tbadk.core.util.at.c(this.dnn, t.f.pb_assist);
                            this.dnl.setVisibility(8);
                            this.dnn.setVisibility(0);
                        }
                    }
                    this.dnm.setAlpha(SocialAPIErrorCodes.ERROR_INVALID_BDUSS);
                    if (a.getAuthor().getGender() == 2) {
                        com.baidu.tbadk.core.util.at.c(this.dnm, t.f.icon_pb_pop_girl);
                        this.dnm.setVisibility(0);
                    } else if (a.getAuthor().getGender() == 1) {
                        com.baidu.tbadk.core.util.at.c(this.dnm, t.f.icon_pb_pop_boy);
                        this.dnm.setVisibility(0);
                    } else {
                        this.dnm.setVisibility(8);
                    }
                    if (!StringUtils.isNull(a.getAuthor().getName_show()) && com.baidu.adp.lib.util.j.aP(a.getAuthor().getName_show()) > 14) {
                        i2 = 0;
                    }
                    ArrayList<IconData> iconInfo = a.getAuthor().getIconInfo();
                    ArrayList<IconData> tShowInfoNew = a.getAuthor().getTShowInfoNew();
                    if (this.dno != null) {
                        this.dno.setTag(t.g.tag_user_id, a.getAuthor().getUserId());
                        this.dno.setOnClickListener(this.dhY.diS.bkL);
                        this.dno.vv();
                        this.dno.a(iconInfo, i2, this.dhY.getResources().getDimensionPixelSize(t.e.pb_icon_width), this.dhY.getResources().getDimensionPixelSize(t.e.pb_icon_height), this.dhY.getResources().getDimensionPixelSize(t.e.pb_icon_margin));
                    }
                    if (this.dnp != null) {
                        if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                            this.dnp.setTag(tShowInfoNew.get(0).getUrl());
                        }
                        this.dnp.setOnClickListener(this.dhY.diS.dpK);
                        this.dnp.a(tShowInfoNew, 3, this.dhY.getResources().getDimensionPixelSize(t.e.small_icon_width), this.dhY.getResources().getDimensionPixelSize(t.e.small_icon_height), this.dhY.getResources().getDimensionPixelSize(t.e.big_icon_margin), true);
                    }
                    this.dnj.setText(a.getAuthor().getName_show());
                    this.dnj.setTag(t.g.tag_user_id, a.getAuthor().getUserId());
                    this.dnj.setTag(t.g.tag_user_name, a.getAuthor().getName_show());
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                        com.baidu.tbadk.core.util.at.c(this.dnj, t.d.cp_cont_h, 1);
                    } else {
                        com.baidu.tbadk.core.util.at.c(this.dnj, t.d.cp_cont_f, 1);
                    }
                    this.dnk.setUserId(a.getAuthor().getUserId());
                    this.dnk.setUserName(a.getAuthor().getUserName());
                    this.dnk.setImageDrawable(null);
                    this.dnk.setRadius(com.baidu.adp.lib.util.k.c(this.dhY.getActivity(), t.e.ds35));
                    this.dnk.setTag(a.getAuthor().getUserId());
                    if (this.doT) {
                        fa faVar = new fa(this, a);
                        this.dnj.setOnClickListener(faVar);
                        this.dnk.setOnClickListener(faVar);
                        this.dnk.setVisibility(8);
                        this.dnr.setVisibility(8);
                        this.dns.setVisibility(8);
                        this.dnm.setVisibility(8);
                    } else {
                        if (!this.dfJ) {
                            this.dnk.setVisibility(8);
                        } else {
                            this.dnk.setVisibility(0);
                        }
                        this.dnj.setOnClickListener(this.dhY.diS.dpJ);
                        this.dnk.setOnClickListener(this.dhY.diS.dpJ);
                        this.dnm.setVisibility(0);
                    }
                    this.dnk.c(a.getAuthor().getPortrait(), 28, false);
                }
                azh();
                if (eVar != null) {
                    this.dnf.m(eVar.avB());
                }
            }
        }
    }

    private void azh() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dnt.getLayoutParams();
        layoutParams.setMargins(layoutParams.leftMargin, this.dpo ? com.baidu.adp.lib.util.k.c(TbadkCoreApplication.m11getInst(), t.e.ds20) : 0, layoutParams.rightMargin, this.dpp ? com.baidu.adp.lib.util.k.c(TbadkCoreApplication.m11getInst(), t.e.ds20) : 0);
        this.dnt.setLayoutParams(layoutParams);
    }

    public boolean azi() {
        return this.dpq;
    }

    private boolean azj() {
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.userId);
    }

    private boolean f(com.baidu.tbadk.core.data.ax axVar) {
        if (axVar == null || axVar.getAuthor() == null || axVar.getAuthor().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), axVar.getAuthor().getUserId());
    }

    public void a(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null) {
            this.dmZ.azP();
            if (!StringUtils.isNull(dVar.forumName)) {
                this.dmZ.kx(dVar.forumName);
            }
            String string = this.dhY.getResources().getString(t.j.thread_delete_by);
            String str = "";
            switch (com.baidu.adp.lib.h.b.g(dVar.source, 0)) {
                case 100:
                    str = this.dhY.getResources().getString(t.j.self);
                    break;
                case 300:
                    str = this.dhY.getResources().getString(t.j.bawu);
                    break;
                case 400:
                    str = this.dhY.getResources().getString(t.j.system);
                    break;
            }
            this.dhY.showNetRefreshView(this.dbg, String.format(string, str), null, this.dhY.getResources().getString(t.j.appeal_restore), true, new fb(this, dVar.deZ));
        }
    }

    public void a(com.baidu.tieba.pb.data.e eVar, int i, int i2, boolean z, int i3, boolean z2) {
        Parcelable ayB;
        Parcelable ayB2;
        String sb;
        if (eVar != null) {
            if (eVar.avB() != null) {
                this.doG = eVar.avB().qK();
                this.QM = eVar.avB().qH();
                if (eVar.avB().getAnchorLevel() != 0) {
                    this.dpq = true;
                }
                this.don = f(eVar.avB());
            }
            if (eVar.getUserData() != null) {
                this.userId = eVar.getUserData().getUserId();
            }
            o(eVar);
            this.doB = false;
            this.dfL = z;
            azd();
            b(eVar, z, i);
            if (this.dhY.awM()) {
                if (this.dnN == null) {
                    this.dnN = new com.baidu.tieba.pb.view.s(this.dhY.getPageContext());
                    this.dnN.jn();
                    this.dnN.a(this.acj);
                }
                this.bej.setPullRefresh(this.dnN);
                this.bej.removeHeaderView(this.amg);
                this.bej.f(this.amg, 0);
                if (this.dnN != null) {
                    this.dnN.cS(TbadkCoreApplication.m11getInst().getSkinType());
                }
            } else if (eVar.getPage().pL() == 0 && z) {
                this.bej.setPullRefresh(null);
                this.dmX = 0;
                this.dox.setVisibility(8);
            } else {
                if (this.dnN == null) {
                    this.dnN = new com.baidu.tieba.pb.view.s(this.dhY.getPageContext());
                    this.dnN.jn();
                    this.dnN.a(this.acj);
                }
                this.bej.setPullRefresh(this.dnN);
                this.bej.removeHeaderView(this.amg);
                this.bej.f(this.amg, 0);
                this.dmX = 1;
                if (this.dnN != null) {
                    this.dnN.cS(TbadkCoreApplication.m11getInst().getSkinType());
                }
                this.dox.setVisibility(0);
                azx();
            }
            azk();
            boolean z3 = this.dox.getVisibility() == 0;
            this.dnJ.gs(this.dfL);
            this.dnJ.gC(z3);
            this.dnJ.b(eVar);
            this.dnJ.notifyDataSetChanged();
            if (eVar.avA() != null) {
                this.mForumName = eVar.avA().getName();
                this.mForumId = eVar.getForumId();
            }
            this.dmZ.kx(this.mForumName);
            if (eVar.avB() != null) {
                ma(com.baidu.tbadk.core.util.ay.B(eVar.avB().getReply_num()));
                if (eVar.avB().getPraise() != null) {
                    if (eVar.avB().getPraise().getNum() < 1) {
                        sb = this.dhY.getResources().getString(t.j.frs_item_praise_text);
                    } else {
                        sb = new StringBuilder(String.valueOf(eVar.avB().getPraise().getNum())).toString();
                    }
                    if (this.dmW != -1) {
                        eVar.avB().getPraise().setIsLike(this.dmW);
                    }
                    G(sb, eVar.avB().getPraise().getIsLike() == 1);
                }
            }
            if (eVar.getPage().pK() == 0 && !z) {
                this.bej.setNextPage(null);
                this.dmY = 1;
            } else if (this.dhY.isLogin()) {
                this.bej.setNextPage(this.dnO);
                this.dmY = 2;
                azx();
            } else if (eVar.getPage().pK() == 1) {
                this.doB = true;
                if (this.dnP == null) {
                    this.dnP = new com.baidu.tieba.pb.view.b(this.dhY.getPageContext());
                }
                this.bej.setNextPage(this.dnP);
                this.dmY = 3;
            }
            ArrayList<com.baidu.tieba.tbadkCore.data.s> avC = eVar.avC();
            if (eVar.getPage().pK() == 0 || avC == null || avC.size() < eVar.getPage().pJ()) {
                this.dnO.setText(this.dhY.getResources().getString(t.j.list_no_more));
                if (this.dhY.awM() && this.bej != null && this.bej.getData() != null && this.bej.getData().size() == 1 && (this.bej.getData().get(0) instanceof com.baidu.tieba.pb.data.g)) {
                    this.dnO.setText("");
                }
                n(eVar);
            } else if (z2) {
                if (this.dpn) {
                    vh();
                    if (eVar.getPage().pK() != 0) {
                        this.dnO.setText(this.dhY.getResources().getString(t.j.pb_load_more));
                    }
                } else {
                    this.dnO.showLoading();
                }
            } else {
                this.dnO.showLoading();
            }
            if (z) {
                this.doy.setVisibility(0);
                this.aHy.setVisibility(0);
                this.doz.setText(this.dhY.getResources().getString(t.j.btn_show_passed_pb));
            } else {
                this.doy.setVisibility(8);
                this.aHy.setVisibility(8);
                this.doz.setText(this.dhY.getResources().getString(t.j.btn_show_passed_pb_aftre));
            }
            if (eVar.avB() != null && eVar.avB().getAuthor() != null && eVar.avB().getAuthor().getType() == 0) {
                this.dmZ.azM();
            }
            switch (i) {
                case 2:
                    this.bej.setSelection(i2 > 1 ? i2 - 2 : 0);
                    if (this.dnd != null) {
                        CompatibleUtile.scrollListViewBy(this.bej, -this.dnd.getHeight(), 0);
                        break;
                    }
                    break;
                case 3:
                    if (i3 == 1 && (ayB2 = ee.ayA().ayB()) != null) {
                        this.bej.onRestoreInstanceState(ayB2);
                        break;
                    } else {
                        this.bej.setSelection(0);
                        break;
                    }
                    break;
                case 4:
                    this.dpn = false;
                    this.bej.setSelection(0);
                    break;
                case 5:
                    this.bej.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1 && (ayB = ee.ayA().ayB()) != null) {
                        this.bej.onRestoreInstanceState(ayB);
                        break;
                    } else {
                        this.bej.setSelection(0);
                        break;
                    }
            }
            if (this.doG == doI && azj()) {
                azB();
            }
        }
    }

    public void gX(boolean z) {
        this.dom = z;
        this.dmZ.gX(z);
    }

    public void vh() {
        if (this.dnO != null) {
            this.dnO.vh();
        }
        azx();
    }

    public void Ld() {
        this.bej.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean azk() {
        boolean z;
        boolean z2 = true;
        if (this.dnd != null && this.dnd.getVisibility() == 0) {
            if (this.dnE != null) {
                this.dnE.setVisibility(0);
                z = true;
            } else {
                z = true;
            }
        } else {
            if (this.dnE != null) {
                this.dnE.setVisibility(8);
            }
            z = false;
        }
        if (this.dop != null && this.dop.getVisibility() == 0) {
            if (this.dnF != null) {
                this.dnF.setVisibility(0);
            }
        } else {
            if (this.dnF != null) {
                this.dnF.setVisibility(8);
            }
            z2 = z;
        }
        if ((this.dnH == null || this.dnH.getVisibility() == 8) && z2 && this.dfL) {
            this.dnG.setVisibility(0);
        } else {
            this.dnG.setVisibility(8);
        }
        com.baidu.tieba.graffiti.d.aj(this.dnG);
        return z2;
    }

    private boolean l(com.baidu.tieba.pb.data.e eVar) {
        if (eVar == null || eVar.avB() == null) {
            return false;
        }
        if (eVar.avB().qM() == 1 || eVar.avB().getThreadType() == 33 || !(eVar.avB().qN() == null || eVar.avB().qN().rI() == 0)) {
            return true;
        }
        return eVar.avB().getIs_top() == 1 || eVar.avB().getIs_good() == 1 || eVar.avB().rh() || eVar.avB().rs() || eVar.avB().rl();
    }

    private boolean m(com.baidu.tieba.pb.data.e eVar) {
        return (eVar == null || eVar.avB() == null || eVar.avB().qV() == null) ? false : true;
    }

    public boolean a(com.baidu.tieba.pb.data.e eVar, boolean z, boolean z2) {
        if (eVar == null) {
            return false;
        }
        if (this.dni != null) {
            if (eVar.avB().qY() == 0 && !eVar.avB().rm() && !this.dpf) {
                this.dni.setVisibility(0);
                eVar.avB().rk();
                if (l(eVar)) {
                    ArrayList arrayList = new ArrayList();
                    if (eVar.avB().qM() == 1 || eVar.avB().getThreadType() == 33 || (eVar.avB().qN() != null && eVar.avB().qN().rI() != 0)) {
                        if (eVar.avB().qF() != null && eVar.avB().rs()) {
                            if (eVar.avB().re() == 2) {
                                arrayList.add(Integer.valueOf(t.j.interview_live));
                            }
                        } else {
                            arrayList.add(Integer.valueOf(t.j.kn_zhibo));
                        }
                    }
                    if (eVar.avB().getIs_top() == 1) {
                        arrayList.add(Integer.valueOf(t.j.commit_top));
                    }
                    if (eVar.avB().getIs_good() == 1) {
                        arrayList.add(Integer.valueOf(t.j.good));
                    }
                    if (eVar.avB().rs()) {
                        Integer num = doQ.get(eVar.avB().re());
                        if (num != null) {
                            arrayList.add(num);
                        }
                    }
                    if (eVar.avB().rh()) {
                        Integer num2 = QB.get(new Point(eVar.avB().rg(), eVar.avB().rf()));
                        if (num2 != null) {
                            arrayList.add(num2);
                        } else {
                            arrayList.add(Integer.valueOf(t.j.card_promotion_text));
                        }
                    }
                    if (eVar.avB().rl()) {
                        arrayList.add(Integer.valueOf(t.j.vote));
                    }
                    this.dni.setText(com.baidu.tieba.card.au.a(this.dhY.getPageContext().getPageActivity(), eVar.avB().getTitle(), arrayList, 3));
                } else if (m(eVar)) {
                    ArrayList arrayList2 = new ArrayList();
                    if (eVar.avB().qV() != null) {
                        arrayList2.add(Integer.valueOf(t.j.card_promotion_text));
                    }
                    this.dni.setText(com.baidu.tieba.card.au.b(this.dhY.getPageContext().getPageActivity(), eVar.avB().getTitle(), arrayList2, 3));
                } else {
                    this.dni.setText(eVar.avB().getSpan_str());
                }
            } else {
                this.dni.setVisibility(8);
                this.dpo = true;
                azh();
            }
        }
        this.dfL = z;
        com.baidu.tbadk.core.data.ax avB = eVar.avB();
        if (avB != null) {
            a(avB.qN());
        }
        if (eVar.avH() == 1) {
            azl();
            Button button = (Button) this.dnc.findViewById(t.g.pb_head_function_manage_commit_top);
            Button button2 = (Button) this.dnc.findViewById(t.g.pb_head_function_manage_cancel_top);
            Button button3 = (Button) this.dnc.findViewById(t.g.pb_head_function_manage_commit_good);
            Button button4 = (Button) this.dnc.findViewById(t.g.pb_head_function_manage_cancel_good);
            button.setOnClickListener(this.bjV);
            button2.setOnClickListener(this.bjV);
            button3.setOnClickListener(this.bjV);
            button4.setOnClickListener(this.bjV);
            if (eVar.avB().getIs_good() == 1) {
                button3.setVisibility(8);
                button4.setVisibility(0);
            } else {
                button3.setVisibility(0);
                button4.setVisibility(8);
            }
            if (eVar.avB().getIs_top() == 1) {
                button.setVisibility(8);
                button2.setVisibility(0);
            } else {
                button.setVisibility(0);
                button2.setVisibility(8);
            }
            if (eVar.avB().rs() && eVar.avB().re() == 2) {
                button.setEnabled(false);
                com.baidu.tbadk.core.util.at.j((View) button, t.d.cp_cont_d);
            }
            return true;
        }
        return false;
    }

    private void azl() {
        if (this.dnd == null) {
            this.dnd = ((ViewStub) this.dnc.findViewById(t.g.pb_header_function_manage)).inflate();
            this.dhY.getLayoutMode().x(this.dnd);
            this.dnE = this.dnc.findViewById(t.g.new_pb_header_item_line_above_manage);
            return;
        }
        this.dnd.setVisibility(0);
    }

    public void a(com.baidu.tieba.pb.data.e eVar, boolean z, boolean z2, int i) {
        boolean z3;
        boolean z4;
        boolean z5;
        String userId;
        if (eVar != null) {
            a(eVar, z, z2);
            com.baidu.tieba.tbadkCore.data.s a = a(eVar, z, i);
            if (a != null) {
                if (eVar.avH() != 0 && a.getAuthor() != null) {
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
                    String userId3 = eVar.avB().getAuthor().getUserId();
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
                    sparseArray.put(t.g.tag_manage_user_identity, Integer.valueOf(eVar.avH()));
                    sparseArray.put(t.g.tag_should_manage_visible, true);
                    a(t.j.manage, sparseArray);
                } else if (z4) {
                    SparseArray<Object> sparseArray2 = new SparseArray<>();
                    sparseArray2.put(t.g.tag_del_post_id, a.getId());
                    sparseArray2.put(t.g.tag_del_post_type, 0);
                    sparseArray2.put(t.g.tag_del_post_is_self, Boolean.valueOf(z3));
                    sparseArray2.put(t.g.tag_manage_user_identity, Integer.valueOf(eVar.avH()));
                    sparseArray2.put(t.g.tag_should_manage_visible, false);
                    a(t.j.delete, sparseArray2);
                }
            }
            azk();
        }
    }

    private void a(int i, SparseArray<Object> sparseArray) {
        azl();
        Button button = (Button) this.dnc.findViewById(t.g.pb_head_function_manage_delormanage);
        button.setOnClickListener(this.bjV);
        button.setVisibility(0);
        button.setText(i);
        button.setTag(sparseArray);
    }

    public View getNextView() {
        return this.awm;
    }

    public void mb(String str) {
        if (this.dnO != null && !StringUtils.isNull(str)) {
            this.dnO.setText(str);
        }
    }

    public BdListView KP() {
        return this.bej;
    }

    public int azm() {
        return t.g.richText;
    }

    public int QW() {
        return t.g.user_icon_box;
    }

    public Button azn() {
        return (Button) this.dnc.findViewById(t.g.pb_head_function_manage_commit_good);
    }

    public Button azo() {
        return (Button) this.dnc.findViewById(t.g.pb_head_function_manage_cancel_good);
    }

    public Button azp() {
        return (Button) this.dnc.findViewById(t.g.pb_head_function_manage_commit_top);
    }

    public Button azq() {
        return (Button) this.dnc.findViewById(t.g.pb_head_function_manage_cancel_top);
    }

    public TextView awq() {
        return this.dnf.awq();
    }

    public void c(BdListView.e eVar) {
        this.bej.setOnSrollToBottomListener(eVar);
    }

    public void a(t.b bVar) {
        this.acj = bVar;
        if (this.dnN != null) {
            this.dnN.a(bVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.ad adVar, a.b bVar) {
        if (adVar != null) {
            int pI = adVar.pI();
            int pF = adVar.pF();
            if (this.dnK != null) {
                this.dnK.rU();
            } else {
                this.dnK = new com.baidu.tbadk.core.dialog.a(this.dhY.getPageContext().getPageActivity());
                this.dnL = LayoutInflater.from(this.dhY.getPageContext().getPageActivity()).inflate(t.h.dialog_direct_pager, (ViewGroup) null);
                this.dnK.z(this.dnL);
                this.dnK.a(t.j.dialog_ok, bVar);
                this.dnK.b(t.j.dialog_cancel, new fc(this));
                this.dnK.a(new fd(this));
                this.dnK.b(this.dhY.getPageContext()).rU();
            }
            this.dnM = (EditText) this.dnL.findViewById(t.g.input_page_number);
            this.dnM.setText("");
            TextView textView = (TextView) this.dnL.findViewById(t.g.current_page_number);
            if (pI <= 0) {
                pI = 1;
            }
            if (pF <= 0) {
                pF = 1;
            }
            textView.setText(MessageFormat.format(this.dhY.getApplicationContext().getResources().getString(t.j.current_page), Integer.valueOf(pI), Integer.valueOf(pF)));
            this.dhY.ShowSoftKeyPadDelay(this.dnM, 150);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.bej.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.dhY.showToast(str);
    }

    public boolean gY(boolean z) {
        if (this.BV == null || !this.BV.Be()) {
            return false;
        }
        this.BV.zx();
        return true;
    }

    public void azr() {
        if (this.dpr != null) {
            while (this.dpr.size() > 0) {
                TbImageView remove = this.dpr.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        azr();
    }

    public void onDestroy() {
        this.dhY.hideProgressBar();
        if (this.aWZ != null && this.bes != null) {
            this.aWZ.b(this.bes);
        }
        amQ();
        this.dnO.vh();
        if (this.doO != null) {
            com.baidu.adp.lib.h.h.dL().removeCallbacks(this.doO);
        }
        if (this.doP != null) {
            com.baidu.adp.lib.h.h.dL().removeCallbacks(this.doP);
        }
        azy();
        if (this.dpe != null) {
            this.dpe.removeAllViews();
        }
        if (this.dnh != null && this.dmx != null) {
            this.dnh.removeView(this.dmx);
            this.dmx = null;
        }
        if (this.doF != null) {
            this.doF.clearStatus();
        }
        this.dph = null;
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.bkp != null) {
            this.bkp.setBackgroundDrawable(null);
        }
    }

    public void amQ() {
        this.dmZ.nv();
        com.baidu.adp.lib.util.k.a(this.dhY.getPageContext().getPageActivity(), this.dnM);
        if (this.dol != null) {
            this.dol.dismiss();
        }
        azs();
    }

    public void gq(boolean z) {
        this.dnJ.gq(z);
    }

    public void gr(boolean z) {
        this.dfJ = z;
        this.dnJ.gr(z);
    }

    public void fn(boolean z) {
        this.cDe = z;
    }

    public void azs() {
        if (this.dnT != null) {
            this.dnT.dismiss();
        }
        if (this.dnU != null) {
            com.baidu.adp.lib.h.j.b(this.dnU, this.dhY.getPageContext());
        }
        if (this.doe != null) {
            com.baidu.adp.lib.h.j.b(this.doe, this.dhY.getPageContext());
        }
        if (this.dnR != null) {
            com.baidu.adp.lib.h.j.b(this.dnR, this.dhY.getPageContext());
        }
    }

    public void onChangeSkinType(int i) {
        this.dhY.getLayoutMode().ae(i == 1);
        this.dhY.getLayoutMode().x(this.dbg);
        this.dhY.getLayoutMode().x(this.dne);
        this.dhY.getLayoutMode().x(this.dnc);
        this.dhY.getLayoutMode().x(this.awm);
        com.baidu.tbadk.core.util.at.c(this.dnv, t.d.cp_cont_g, 1);
        this.dmZ.mNavigationBar.onChangeSkinType(this.dhY.getPageContext(), i);
        com.baidu.tbadk.core.util.at.a(this.dmZ.dpW, t.f.btn_more_selector_s, t.f.btn_more_selector);
        com.baidu.tbadk.core.util.at.a(this.dmZ.dpX, t.f.icon_floor_addition_selector_s, t.f.icon_floor_addition_selector);
        if (this.dnL != null) {
            this.dhY.getLayoutMode().x(this.dnL);
        }
        gX(this.dom);
        this.dnJ.notifyDataSetChanged();
        if (this.dnN != null) {
            this.dnN.cS(i);
        }
        if (this.dnO != null) {
            this.dnO.cS(i);
            com.baidu.tbadk.core.util.at.k(this.awm, t.f.pb_foot_more_trans_selector);
            this.dnO.cQ(t.f.pb_foot_more_trans_selector);
        }
        if (this.BV != null) {
            this.BV.onChangeSkinType(i);
        }
        if (this.dnA != null) {
            this.dnA.cW(i);
        }
        if (this.dnP != null) {
            this.dnP.cS(i);
        }
        if (this.dnb != null && this.dnb.size() > 0) {
            for (com.baidu.tieba.pb.pb.main.b.a aVar : this.dnb) {
                aVar.azK();
            }
        }
        if (this.dpe != null) {
            com.baidu.tbadk.core.util.at.l(this.dpe, t.d.cp_bg_line_d);
            com.baidu.tbadk.core.util.at.l(this.dpa, t.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.at.c(this.dpd, t.d.cp_cont_c, 1);
        }
        gQ(i == 1);
        this.dng.changeSkinType(i);
        ayM();
        UtilHelper.setStatusBarBackground(this.bkp, i);
    }

    public void setOnImageClickListener(TbRichTextView.d dVar) {
        this.aFe = dVar;
        this.dnJ.setOnImageClickListener(this.aFe);
    }

    public void g(NoNetworkView.a aVar) {
        this.bes = aVar;
        if (this.aWZ != null) {
            this.aWZ.a(this.bes);
        }
    }

    public void gZ(boolean z) {
        this.dnJ.setIsFromCDN(z);
        this.mIsFromCDN = z;
    }

    public Button azt() {
        return this.dop;
    }

    public void n(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null) {
            ArrayList<com.baidu.tieba.tbadkCore.data.s> avC = eVar.avC();
            if (avC.size() == 1) {
                com.baidu.tieba.tbadkCore.data.s sVar = avC.get(0);
                if (sVar.aTY() < sVar.aTR().size()) {
                    if (this.dmY != 1) {
                        this.bej.setNextPage(null);
                        this.dmY = 1;
                    }
                } else if (this.dmY != 2) {
                    this.bej.setNextPage(this.dnO);
                    this.dmY = 2;
                }
            } else if (this.dmY != 2) {
                this.bej.setNextPage(this.dnO);
                this.dmY = 2;
            }
        }
    }

    public void azu() {
        if (com.baidu.tbadk.performanceLog.aa.EM().EN()) {
            int lastVisiblePosition = this.bej.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.bej.getChildAt(i);
                if (childAt != null) {
                    TbRichTextView tbRichTextView = (TbRichTextView) childAt.findViewById(t.g.richText);
                    if (tbRichTextView != null) {
                        for (int i2 = 0; i2 < tbRichTextView.getChildCount(); i2++) {
                            View childAt2 = tbRichTextView.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.performanceLog.u perfLog = tbImageView.getPerfLog();
                                perfLog.eM(1001);
                                perfLog.axv = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr = new int[2];
                                    tbRichTextView.getLocationOnScreen(iArr);
                                    if (iArr[1] > com.baidu.adp.lib.util.k.C(TbadkCoreApplication.m11getInst().getContext())) {
                                    }
                                }
                                tbImageView.uR();
                            }
                        }
                    }
                    HeadImageView headImageView = (HeadImageView) childAt.findViewById(t.g.photo);
                    if (headImageView != null) {
                        com.baidu.tbadk.performanceLog.u perfLog2 = headImageView.getPerfLog();
                        perfLog2.eM(1001);
                        perfLog2.axv = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr2 = new int[2];
                            headImageView.getLocationOnScreen(iArr2);
                            if (iArr2[1] > com.baidu.adp.lib.util.k.C(TbadkCoreApplication.m11getInst().getContext())) {
                            }
                        }
                        headImageView.uR();
                    }
                }
            }
        }
    }

    public void fo(boolean z) {
        if (this.doq != null && this.doq != null) {
            if (this.cDe) {
                fp(z);
            } else {
                fq(z);
            }
        }
    }

    public void azv() {
        if (this.doq != null) {
            this.doq.setVisibility(8);
        }
    }

    public TextView azw() {
        return this.doy;
    }

    public void akv() {
        if (this.doA == null) {
            this.doA = new com.baidu.tbadk.core.view.b(this.dhY.getPageContext());
        }
        this.doA.aD(true);
    }

    public void azx() {
        if (this.doA != null) {
            this.doA.aD(false);
        }
    }

    private boolean a(com.baidu.tieba.tbadkCore.data.s sVar, String str, String str2, boolean z, boolean z2) {
        ColumnLayout.a aVar;
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
        ff ffVar = new ff(this, str, new com.baidu.tbadk.coreExtra.d.a(null), author);
        this.dnh.setPadding(TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds32), TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds20), TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds32), 0);
        if (sVar.getType() == null || sVar.getType().getId() != com.baidu.tieba.tbadkCore.data.s.PV.getId()) {
            this.dnc.setPadding(0, TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds34), 0, 0);
        }
        int dimensionPixelSize = TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds76);
        if (this.dnk.getLayoutParams() == null) {
            aVar = new ColumnLayout.a(dimensionPixelSize, dimensionPixelSize);
        } else {
            ColumnLayout.a aVar2 = (ColumnLayout.a) this.dnk.getLayoutParams();
            aVar2.width = dimensionPixelSize;
            aVar2.height = dimensionPixelSize;
            aVar = aVar2;
        }
        this.dnk.setLayoutParams(aVar);
        this.dnk.setVisibility(8);
        View findViewWithTag = this.dnh.findViewWithTag("pb_god_head_image_view_tag");
        if (!(findViewWithTag instanceof ClickableHeaderImageView)) {
            this.dmx = new ClickableHeaderImageView(this.dhY.getApplicationContext());
            this.dmx.setGodIconMargin(0);
            this.dmx.setTag("pb_god_head_image_view_tag");
            this.dmx.setUserId(String.valueOf(userIdLong));
            this.dmx.setUserName(userName);
            this.dnh.addView(this.dmx, 0, aVar);
        } else {
            this.dmx = (ClickableHeaderImageView) findViewWithTag;
        }
        fg fgVar = new fg(this, sVar);
        this.dnh.setTag(t.g.tag_user_id, String.valueOf(userIdLong));
        this.dnh.setTag(t.g.tag_user_name, userName);
        this.dnh.setOnClickListener(fgVar);
        this.dne.setTag(t.g.tag_user_id, String.valueOf(userIdLong));
        this.dne.setTag(t.g.tag_user_name, userName);
        this.dne.setOnClickListener(fgVar);
        if (this.dfJ) {
            this.dmx.setVisibility(0);
            this.dmx.setOnClickListener(fgVar);
            this.dmx.c(portrait, 28, false);
        } else {
            this.dmx.setVisibility(8);
        }
        if (this.dnw == null) {
            this.dnw = new TextView(this.dhY.getActivity());
            this.dnw.setClickable(false);
            this.dnw.setIncludeFontPadding(false);
            this.dnw.setGravity(16);
            this.dnw.setTextSize(0, this.dhY.getResources().getDimensionPixelSize(t.e.fontsize24));
            ColumnLayout.a aVar3 = new ColumnLayout.a(-2, -2, 3, 2);
            aVar3.topMargin = this.dhY.getResources().getDimensionPixelSize(t.e.ds8);
            aVar3.bottomMargin = this.dhY.getResources().getDimensionPixelSize(t.e.ds10);
            this.dnw.setSingleLine(true);
            com.baidu.tbadk.core.util.at.c(this.dnw, t.d.cp_cont_d, 1);
            this.dnh.addView(this.dnw, -1, aVar3);
        }
        String format = String.format(this.dhY.getResources().getString(t.j.fans_default_name_god_user), com.baidu.tbadk.core.util.ay.A(fansNum));
        this.dnw.setText(format);
        this.dnw.setTag(t.g.tag_user_id, String.valueOf(userIdLong));
        this.dnw.setTag(t.g.tag_user_name, userName);
        this.dnw.setOnClickListener(fgVar);
        if (this.dnx == null) {
            this.dnx = new TextView(this.dhY.getActivity());
            this.dnx.setClickable(false);
            this.dnx.setTextSize(0, this.dhY.getResources().getDimensionPixelSize(t.e.fontsize24));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            this.dnx.setSingleLine(true);
            this.dnx.setPadding(this.dhY.getResources().getDimensionPixelSize(t.e.ds32), 0, this.dhY.getResources().getDimensionPixelSize(t.e.ds128), 0);
            this.dnx.setEllipsize(TextUtils.TruncateAt.END);
            this.dnx.setTag(t.g.tag_user_id, String.valueOf(userIdLong));
            this.dnx.setTag(t.g.tag_user_name, userName);
            com.baidu.tbadk.core.util.at.c(this.dnx, t.d.cp_cont_d, 1);
            this.dne.addView(this.dnx, layoutParams);
        }
        String string = this.dhY.getResources().getString(t.j.tieba_certification);
        String format2 = StringUtils.isNull(godUserData.getIntro()) ? String.format(string, this.dhY.getResources().getString(t.j.god_intro_default)) : String.format(string, godUserData.getIntro());
        this.dnx.setOnClickListener(fgVar);
        this.dnx.setText(format2);
        this.dnr.setVisibility(8);
        if (this.dny == null) {
            this.dny = new TextView(this.dhY.getActivity());
            this.dny.setTextSize(0, this.dhY.getResources().getDimensionPixelSize(t.e.fontsize24));
            this.dny.setGravity(17);
            this.dny.setOnClickListener(ffVar);
            ColumnLayout.a aVar4 = new ColumnLayout.a(this.dhY.getResources().getDimensionPixelSize(t.e.ds110), this.dhY.getResources().getDimensionPixelSize(t.e.ds50), 80, 3);
            aVar4.bottomMargin = this.dhY.getResources().getDimensionPixelSize(t.e.ds22);
            this.dnh.addView(this.dny, -1, aVar4);
        }
        b(this.dny, godUserData.getFollowed() == 1);
        if (this.don || (godUserData.getFollowed() == 1 && godUserData.getIsFromNetWork())) {
            this.dny.setVisibility(8);
        } else {
            this.dny.setVisibility(0);
        }
        if (this.dne.findViewWithTag("pb_god_bottom_line_view_tag") == null) {
            View view = new View(this.dhY.getApplicationContext());
            view.setTag("pb_god_bottom_line_view_tag");
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, this.dhY.getResources().getDimensionPixelSize(t.e.ds1));
            layoutParams2.topMargin = this.dhY.getResources().getDimensionPixelSize(t.e.ds18);
            layoutParams2.bottomMargin = this.dhY.getResources().getDimensionPixelSize(t.e.ds1);
            com.baidu.tbadk.core.util.at.l(view, t.d.cp_bg_line_a);
            this.dne.addView(view, layoutParams2);
        }
        if (this.doX == null) {
            this.doX = new TextView(this.dhY.getApplicationContext());
            this.doX.setId(t.g.pb_god_user_tip_content);
            this.doX.setEllipsize(TextUtils.TruncateAt.END);
            this.doX.setGravity(17);
            this.doX.setSingleLine(true);
            this.doX.setHeight(this.dhY.getResources().getDimensionPixelSize(t.e.ds56));
            this.doX.setTextSize(0, this.dhY.getResources().getDimensionPixelSize(t.e.fontsize24));
            this.doX.setVisibility(8);
            if (azE() != null) {
                azE().addView(this.doX);
            }
            this.dhY.getLayoutMode().x(this.doX);
        }
        com.baidu.tbadk.core.util.at.k(this.doX, t.d.cp_link_tip_a_alpha80);
        com.baidu.tbadk.core.util.at.j((View) this.doX, t.d.cp_cont_g);
        this.doX.setOnClickListener(new fi(this));
        this.doX.setText(String.format(this.dhY.getResources().getString(t.j.god_user_floor_owner_tip), com.baidu.tbadk.core.util.ay.A(this.doY)));
        lZ(this.doY);
        if (this.doW == null) {
            this.doW = (LinearLayout) LayoutInflater.from(this.dhY.getActivity()).inflate(t.h.god_floating_view, (ViewGroup) null);
            this.doW.setOnClickListener(fgVar);
            this.doW.setTag(t.g.tag_user_id, String.valueOf(userIdLong));
            this.doW.setTag(t.g.tag_user_name, userName);
            ClickableHeaderImageView clickableHeaderImageView = (ClickableHeaderImageView) this.doW.findViewById(t.g.god_floating_owner_photo);
            clickableHeaderImageView.setGodIconMargin(0);
            clickableHeaderImageView.setOnClickListener(fgVar);
            if (!this.dfJ) {
                clickableHeaderImageView.setVisibility(8);
            }
            clickableHeaderImageView.setTag(sVar.getAuthor().getUserId());
            clickableHeaderImageView.c(sVar.getAuthor().getPortrait(), 28, false);
            View findViewById = this.doW.findViewById(t.g.god_floating_owner_info_floor_owner);
            if (str2 != null && !str2.equals("0") && str2.equals(sVar.getAuthor().getUserId())) {
                findViewById.setVisibility(0);
            } else {
                findViewById.setVisibility(8);
            }
            ImageView imageView = (ImageView) this.doW.findViewById(t.g.god_floating_owner_info_user_rank);
            int level_id = sVar.getAuthor().getLevel_id();
            int is_bawu = sVar.getAuthor().getIs_bawu();
            String bawu_type = sVar.getAuthor().getBawu_type();
            int i = 3;
            if (level_id != 0) {
                imageView.setVisibility(0);
                com.baidu.tbadk.core.util.at.c(imageView, BitmapHelper.getGradeResourceIdNew(level_id));
                imageView.setContentDescription(String.format(TbadkCoreApplication.m11getInst().getString(t.j.degree_in_forum), Integer.valueOf(level_id)));
                imageView.setOnClickListener(null);
            } else {
                imageView.setVisibility(8);
            }
            ImageView imageView2 = (ImageView) this.doW.findViewById(t.g.god_floating_owner_info_user_bawu);
            if (is_bawu != 0) {
                if (bawu_type.equals("manager")) {
                    com.baidu.tbadk.core.util.at.c(imageView2, t.f.pb_manager);
                    imageView.setVisibility(8);
                    imageView2.setVisibility(0);
                } else if (bawu_type.equals("assist")) {
                    com.baidu.tbadk.core.util.at.c(imageView2, t.f.pb_assist);
                    imageView.setVisibility(8);
                    imageView2.setVisibility(0);
                }
            }
            if (!StringUtils.isNull(sVar.getAuthor().getName_show()) && com.baidu.adp.lib.util.j.aP(sVar.getAuthor().getName_show()) > 14) {
                i = 0;
            }
            ArrayList<IconData> iconInfo = sVar.getAuthor().getIconInfo();
            ArrayList<IconData> tShowInfoNew = sVar.getAuthor().getTShowInfoNew();
            UserIconBox userIconBox = (UserIconBox) this.doW.findViewById(t.g.god_floating_owner_info_user_icon);
            UserIconBox userIconBox2 = (UserIconBox) this.doW.findViewById(t.g.god_floating_owner_info_tshow_icon);
            if (userIconBox != null) {
                userIconBox.setTag(t.g.tag_user_id, sVar.getAuthor().getUserId());
                userIconBox.setOnClickListener(this.dhY.diS.bkL);
                userIconBox.a(iconInfo, i, this.dhY.getResources().getDimensionPixelSize(t.e.pb_icon_width), this.dhY.getResources().getDimensionPixelSize(t.e.pb_icon_height), this.dhY.getResources().getDimensionPixelSize(t.e.pb_icon_margin));
            }
            if (userIconBox2 != null) {
                userIconBox2.setOnClickListener(this.dhY.diS.dpK);
                userIconBox2.a(tShowInfoNew, 3, this.dhY.getResources().getDimensionPixelSize(t.e.small_icon_width), this.dhY.getResources().getDimensionPixelSize(t.e.small_icon_height), this.dhY.getResources().getDimensionPixelSize(t.e.big_icon_margin), true);
            }
            TextView textView = (TextView) this.doW.findViewById(t.g.god_floating_owner_info_user_name);
            if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                com.baidu.tbadk.core.util.at.c(textView, t.d.cp_cont_h, 1);
            } else {
                com.baidu.tbadk.core.util.at.c(textView, t.d.cp_cont_f, 1);
            }
            textView.setText(sVar.getAuthor().getName_show());
            if (azE() != null) {
                azE().addView(this.doW);
            }
            this.dhY.getLayoutMode().x(this.doW);
        }
        TextView textView2 = (TextView) this.doW.findViewById(t.g.god_floating_gift);
        textView2.setOnClickListener(ffVar);
        b(textView2, godUserData.getFollowed() == 1);
        ImageView imageView3 = (ImageView) this.doW.findViewById(t.g.god_floating_arrow);
        com.baidu.tbadk.core.util.at.c(imageView3, t.f.icon_arrow_tab);
        if (this.don || (godUserData.getFollowed() == 1 && godUserData.getIsFromNetWork())) {
            textView2.setVisibility(8);
            imageView3.setVisibility(0);
        } else {
            textView2.setVisibility(0);
            imageView3.setVisibility(8);
        }
        TextView textView3 = (TextView) this.doW.findViewById(t.g.god_floating_intro);
        if (textView3 != null) {
            textView3.setText(format);
        }
        this.dpe = this.dnO.vd();
        if (this.dpe != null && !this.don && !z && z2 && (godUserData.getFollowed() != 1 || !godUserData.getIsFromNetWork())) {
            this.dnO.ve();
            this.dnO.va();
            this.dpa = this.dpe.findViewWithTag("pb_god_bottom_extra_line_view_tag");
            if (this.dpa == null) {
                this.dpa = new View(this.dhY.getApplicationContext());
                this.dpa.setTag("pb_god_bottom_extra_line_view_tag");
                this.dpe.addView(this.dpa, new LinearLayout.LayoutParams(-1, this.dhY.getResources().getDimensionPixelSize(t.e.ds20)));
                this.dpc = new ClickableHeaderImageView(this.dhY.getApplicationContext());
                this.dpc.setGodIconMargin(0);
                this.dpc.setTag("pb_god_bottom_extra_god_avatar_tag");
                this.dpc.c(portrait, 28, false);
                this.dpc.setUserId(String.valueOf(userIdLong));
                this.dpc.setUserName(userName);
                this.dpc.setOnClickListener(fgVar);
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(this.dhY.getResources().getDimensionPixelSize(t.e.ds130), this.dhY.getResources().getDimensionPixelSize(t.e.ds130));
                layoutParams3.topMargin = this.dhY.getResources().getDimensionPixelSize(t.e.ds40);
                layoutParams3.gravity = 1;
                this.dpe.addView(this.dpc, layoutParams3);
                this.dpd = new TextView(this.dhY.getApplicationContext());
                this.dpd.setTag("pb_god_bottom_extra_text_view_tag");
                this.dpd.setSingleLine(true);
                this.dpd.setTextSize(0, this.dhY.getResources().getDimensionPixelSize(t.e.fontsize24));
                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams4.topMargin = this.dhY.getResources().getDimensionPixelSize(t.e.ds36);
                layoutParams4.gravity = 1;
                this.dpd.setText(this.dhY.getResources().getString(t.j.god_user_attention_tip));
                this.dpe.addView(this.dpd, layoutParams4);
                this.dpb = new TextView(this.dhY.getApplicationContext());
                this.dpb.setTag("pb_god_bottom_extra_attention_btn_tag");
                this.dpb.setSingleLine(true);
                this.dpb.setGravity(17);
                this.dpb.setTextSize(0, this.dhY.getResources().getDimensionPixelSize(t.e.fontsize24));
                this.dpb.setOnClickListener(ffVar);
                LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(this.dhY.getResources().getDimensionPixelSize(t.e.ds212), this.dhY.getResources().getDimensionPixelSize(t.e.ds54));
                layoutParams5.topMargin = this.dhY.getResources().getDimensionPixelSize(t.e.ds30);
                layoutParams5.bottomMargin = this.dhY.getResources().getDimensionPixelSize(t.e.ds40);
                layoutParams5.gravity = 1;
                this.dpe.addView(this.dpb, layoutParams5);
            } else {
                this.dpb = (TextView) this.dpe.findViewWithTag("pb_god_bottom_extra_attention_btn_tag");
                this.dpc = (ClickableHeaderImageView) this.dpe.findViewWithTag("pb_god_bottom_extra_god_avatar_tag");
                this.dpd = (TextView) this.dpe.findViewWithTag("pb_god_bottom_extra_text_view_tag");
                this.dpa = this.dpe.findViewWithTag("pb_god_bottom_extra_line_view_tag");
            }
            com.baidu.tbadk.core.util.at.l(this.dpe, t.d.cp_bg_line_d);
            com.baidu.tbadk.core.util.at.l(this.dpa, t.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.at.c(this.dpd, t.d.cp_cont_c, 1);
            this.dpe.setOnTouchListener(new fj(this));
            boolean z3 = godUserData.getFollowed() == 1;
            b(this.dpb, z3);
            if (!z3) {
                this.dpb.setPadding(this.dhY.getResources().getDimensionPixelSize(t.e.ds68), 0, this.dhY.getResources().getDimensionPixelSize(t.e.ds52), 0);
            }
        } else {
            this.dnO.vf();
            this.dnO.uZ();
        }
        return true;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.doT && !this.doU && i > this.dmX) {
            this.doV = true;
        } else {
            this.doV = false;
            azz();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL));
    }

    private void lZ(int i) {
        boolean z;
        if (this.doX != null && this.doX.getVisibility() != 0 && i >= 2 && !this.don) {
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                z = com.baidu.tbadk.core.sharedPref.b.sQ().getBoolean("pb_god_floor_owner_tip_has_shown_" + TbadkCoreApplication.getCurrentAccount(), false);
            } else {
                z = com.baidu.tbadk.core.sharedPref.b.sQ().getBoolean("pb_god_floor_owner_not_login_tip_has_shown_" + TbadkCoreApplication.getCurrentAccount(), false);
            }
            if (!z) {
                this.doZ = true;
                this.doX.setVisibility(0);
            }
            com.baidu.adp.lib.h.h.dL().postDelayed(this.dpt, 3000L);
        }
    }

    public void azy() {
        com.baidu.adp.lib.h.h.dL().removeCallbacks(this.dpt);
        if (this.doX != null && 8 != this.doX.getVisibility()) {
            com.baidu.tieba.tbadkCore.a.a(this.dhY, this.doX, t.a.fade_out, new fk(this));
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                com.baidu.tbadk.core.sharedPref.b.sQ().putBoolean("pb_god_floor_owner_tip_has_shown_" + TbadkCoreApplication.getCurrentAccount(), true);
            } else {
                com.baidu.tbadk.core.sharedPref.b.sQ().putBoolean("pb_god_floor_owner_not_login_tip_has_shown_" + TbadkCoreApplication.getCurrentAccount(), true);
            }
        }
    }

    public void azz() {
        if (this.doW != null) {
            this.doW.clearAnimation();
            if (this.doW.getVisibility() != 8) {
                this.doW.setVisibility(8);
            }
        }
    }

    public void azA() {
        if (this.doT && this.doV && this.doW != null && this.doW.getVisibility() != 0 && !this.doZ) {
            this.doW.clearAnimation();
            this.doW.setVisibility(0);
        }
    }

    public void azB() {
        if (!this.dps) {
            TiebaStatic.log("c10490");
            this.dps = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dhY.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(doJ, Integer.valueOf(doL));
            aVar.bL(t.j.grade_thread_tips);
            View inflate = LayoutInflater.from(this.dhY.getPageContext().getPageActivity()).inflate(t.h.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(t.g.function_description_view)).setText(t.j.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(t.g.title_view)).setText(t.j.grade_thread_tips);
            aVar.z(inflate);
            aVar.x(sparseArray);
            aVar.a(t.j.grade_button_tips, this.dhY);
            aVar.b(t.j.look_again, new fl(this));
            aVar.b(this.dhY.getPageContext()).rU();
        }
    }

    public void azC() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dhY.getPageContext().getPageActivity());
        aVar.cA(this.dhY.getResources().getString(t.j.upgrade_to_new_photo_live_tips));
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(doJ, Integer.valueOf(doN));
        aVar.x(sparseArray);
        aVar.a(t.j.upgrade_to_new, this.dhY);
        aVar.b(t.j.cancel, new fm(this));
        aVar.b(this.dhY.getPageContext()).rU();
    }

    public int qK() {
        return this.doG;
    }

    public void mc(String str) {
        if (str.contains("_")) {
            str = str.replace("_", "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dhY.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.dhY.getPageContext().getPageActivity()).inflate(t.h.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(t.g.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(t.g.function_description_view)).setVisibility(8);
        aVar.z(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(doJ, Integer.valueOf(doM));
        aVar.x(sparseArray);
        aVar.a(t.j.view, this.dhY);
        aVar.b(t.j.cancel, new fn(this));
        aVar.b(this.dhY.getPageContext()).rU();
    }

    public void a(int i, com.baidu.tieba.pb.data.e eVar, boolean z, int i2) {
        com.baidu.tieba.tbadkCore.data.s a;
        if (i > 0 && (a = a(eVar, z, i2)) != null && a.getAuthor() != null) {
            MetaData author = a.getAuthor();
            author.setGiftNum(author.getGiftNum() + i);
        }
    }

    public void c(com.baidu.tieba.pb.data.e eVar, boolean z, int i) {
        b(eVar, z, i);
    }

    private void b(TextView textView, boolean z) {
        if (z) {
            textView.setClickable(false);
            com.baidu.tbadk.core.util.at.c(textView, t.d.cp_cont_d, 1);
            textView.setText(TbadkCoreApplication.m11getInst().getString(t.j.relate_forum_is_followed));
            textView.setBackgroundDrawable(null);
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setPadding(0, 0, 0, 0);
            return;
        }
        com.baidu.tbadk.core.util.at.c(textView, t.d.btn_forum_focus_color, 1);
        textView.setText(TbadkCoreApplication.m11getInst().getString(t.j.forum_list_attention_tv));
        com.baidu.tbadk.core.util.at.k(textView, t.f.btn_focus_border_bg);
        textView.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.at.getDrawable(t.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        textView.setClickable(true);
        textView.setPadding(TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds18), 0, TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds10), 0);
    }

    public PbInterviewStatusView azD() {
        return this.doF;
    }

    private void o(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.avB() != null && eVar.avB().rs() && this.doF == null) {
            this.doF = (PbInterviewStatusView) this.doE.inflate();
            this.doF.setOnClickListener(this.bjV);
            this.doF.setCallback(this.dhY.awV());
            this.doF.a(this.dhY, eVar);
        }
    }

    public LinearLayout azE() {
        return this.dnI;
    }

    public View azF() {
        return this.bkp;
    }

    public boolean awi() {
        return this.dpf;
    }

    public void axs() {
        this.dng.axs();
    }

    public void gt(boolean z) {
        this.dnf.gt(z);
    }

    private void azG() {
        if (this.dpf) {
            if (this.dpg == null) {
                this.dpg = new com.baidu.tieba.pb.pb.b.l(this.dhY);
                ListAdapter adapter = this.bej.getAdapter();
                if (adapter != null) {
                    if (adapter.getView(0, null, null) == this.amg) {
                        this.bej.f(this.dpg.awp(), 1);
                    } else {
                        this.bej.f(this.dpg.awp(), 0);
                    }
                }
            }
            this.dne.setVisibility(8);
            this.bej.removeHeaderView(this.dne);
            return;
        }
        this.dne.setVisibility(0);
    }

    public void ha(boolean z) {
        this.dpf = z;
    }

    public View axw() {
        return this.dng.axw();
    }

    public void azH() {
        this.dhY.showNetRefreshView(getView(), "");
        View CY = this.dhY.getRefreshView().CY();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) CY.getLayoutParams();
        layoutParams.addRule(3, azE().getId());
        CY.setLayoutParams(layoutParams);
        this.dhY.hideLoadingView(getView());
        if (this.dpg != null) {
            this.bej.removeHeaderView(this.dpg.awp());
            this.dpg = null;
        }
    }

    public void md(String str) {
        if (this.dna != null) {
            this.dna.setTitle(str);
        }
    }

    public void Bn() {
        this.dng.Bn();
    }

    public void awf() {
        if (this.dni != null) {
            this.dni.setTextSize(TbConfig.getContentSizeOfPostTitle());
        }
        if (this.dnJ != null && this.dnJ.axe() != null) {
            this.dnJ.axe().awf();
        }
        if (this.dnJ != null) {
            if (this.dnJ.axf() != null) {
                this.dnJ.axf().updateFontSize();
            }
            if (this.dnJ.axg() != null) {
                this.dnJ.axg().updateFontSize();
            }
        }
    }

    private int hb(boolean z) {
        if (this.doF == null || this.doF.getVisibility() != 0 || !z) {
            return 0;
        }
        return 0 + com.baidu.adp.lib.util.k.c(this.dhY.getPageContext().getPageActivity(), t.e.ds72);
    }

    private void azI() {
        if (this.doF != null && this.doF.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.doF.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.doF.setLayoutParams(layoutParams);
        }
    }
}
