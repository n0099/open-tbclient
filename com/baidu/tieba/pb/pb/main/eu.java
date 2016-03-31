package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.app.Dialog;
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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.location.BDLocationStatusCodes;
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
import com.baidu.tbadk.core.view.s;
import com.baidu.tbadk.data.GodUserData;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.editortools.sendtool.SendView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.FrsPraiseView;
import com.baidu.tieba.tbadkCore.b.a;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class eu {
    public static int dmo = 2;
    public static int dmp = 3;
    public static int dmq = 0;
    public static int dmr = 3;
    public static int dms = 4;
    public static int dmt = 5;
    public static int dmu = 6;
    private com.baidu.tbadk.editortools.l LE;
    private View aAj;
    private s.a agD;
    private NoNetworkView baT;
    private BdTypeListView bcd;
    private View.OnClickListener boQ;
    private RelativeLayout cYO;
    private com.baidu.tieba.pb.a.c dds;
    private View.OnClickListener deJ;
    private PbActivity dfw;
    PbActivity.c dhf;
    public int dkB;
    private View dkD;
    public final com.baidu.tieba.pb.pb.main.b.e dkF;
    public com.baidu.tieba.pb.pb.main.b.c dkG;
    private List<com.baidu.tieba.pb.pb.main.b.a> dkH;
    private View dkI;
    private LinearLayout dkK;
    private TextView dkL;
    private ColumnLayout dkM;
    private TextView dkN;
    private TextView dkO;
    private HeadImageView dkP;
    private ImageView dkQ;
    private ImageView dkR;
    private ImageView dkS;
    private UserIconBox dkT;
    private UserIconBox dkU;
    private ImageView dkV;
    private TextView dkW;
    private LinearLayout dkX;
    private TextView dkY;
    private TextView dkZ;
    private View dlV;
    private TextView dlW;
    private TextView dlX;
    private ViewGroup dlY;
    private TextView dlZ;
    private TextView dld;
    private LinearLayout dlf;
    private TextView dlg;
    private TextView dlh;
    private View dlj;
    private View dlk;
    private View dlm;
    private RelativeLayout dln;
    private RelativeLayout dlo;
    private cq dlp;
    private PbListView dlu;
    private View dlw;
    private View dmI;
    private TextView dmJ;
    private ClickableHeaderImageView dmK;
    private TextView dmL;
    private LinearLayout dmM;
    private boolean dmN;
    private com.baidu.adp.lib.guide.d dmO;
    private com.baidu.tieba.pb.pb.b.b dmP;
    private Runnable dmR;
    private PbActivity.a dmU;
    private boolean dmW;
    private boolean dmX;
    private View dma;
    private boolean dmc;
    private View dmi;
    private TextView dmj;
    private LinearLayout dmk;
    private TextView dml;
    private Runnable dmv;
    private Runnable dmw;
    private int dkC = 0;
    private int dkE = 0;
    private final Handler mHandler = new Handler();
    private View dkJ = null;
    private TextView dla = null;
    private TextView dlb = null;
    private TextView dlc = null;
    public FrsPraiseView dle = null;
    private ClickableHeaderImageView djZ = null;
    private View dli = null;
    private View dll = null;
    private com.baidu.tbadk.core.dialog.a dlq = null;
    private com.baidu.tbadk.core.dialog.c boG = null;
    private View dlr = null;
    private EditText dls = null;
    private com.baidu.tieba.pb.view.m dlt = null;
    private com.baidu.tieba.pb.view.b dlv = null;
    private c.b cjr = null;
    private TbRichTextView.d aJc = null;
    private NoNetworkView.a bit = null;
    private Dialog dlx = null;
    private View dly = null;
    private com.baidu.tbadk.core.dialog.a dlz = null;
    private Dialog dlA = null;
    private View dlB = null;
    private int dlC = 0;
    private RadioGroup Ok = null;
    private RadioButton dlD = null;
    private RadioButton dlE = null;
    private RadioButton dlF = null;
    private Button dlG = null;
    private Button dlH = null;
    private TextView dlI = null;
    private Dialog dlJ = null;
    private View dlK = null;
    private LinearLayout dlL = null;
    private CompoundButton.OnCheckedChangeListener dlM = null;
    private TextView dlN = null;
    private TextView dlO = null;
    private String dlP = null;
    private com.baidu.tbadk.core.dialog.c dlQ = null;
    private boolean dlR = false;
    private boolean dlS = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView dlT = null;
    private boolean cCe = false;
    private Button dlU = null;
    private boolean dmb = true;
    private LinearLayout dmd = null;
    private TextView dme = null;
    private TextView dmf = null;
    private View aLn = null;
    private com.baidu.tbadk.core.view.b dmg = null;
    private boolean ddr = false;
    private boolean dmh = false;
    private boolean mIsFromCDN = true;
    private com.baidu.tieba.pb.a dmm = null;
    private int dmn = 0;
    private boolean dmx = true;
    private a.InterfaceC0081a dmy = new ev(this);
    private boolean dmz = false;
    private boolean dmA = false;
    private boolean dmB = false;
    private boolean dmC = false;
    private boolean dmD = false;
    private LinearLayout dmE = null;
    private TextView dmF = null;
    private int dmG = 0;
    private boolean dmH = false;
    private Handler dmQ = new Handler();
    private CustomMessageListener dmS = new fg(this, CmdConfigCustom.PB_SHOW_MULTIIAMGETOOL);
    private final View.OnClickListener dmT = new fq(this);
    private View.OnLongClickListener onLongClickListener = null;
    private boolean dmV = true;
    private boolean dmY = false;
    private boolean VM = false;
    String userId = null;
    private final List<TbImageView> dmZ = new ArrayList();
    private boolean ddp = true;
    private boolean dna = false;
    private Runnable dnb = new gb(this);

    public com.baidu.tieba.pb.pb.b.b ayh() {
        return this.dmP;
    }

    public NoNetworkView ayi() {
        return this.baT;
    }

    public void ayj() {
        if (this.LE != null) {
            this.LE.hide();
        }
    }

    public void ayk() {
        reset();
        this.dmb = true;
        if (this.LE != null) {
            this.LE.hide();
        }
        if (this.dlV != null) {
            if (this.cCe) {
                eN(false);
            } else {
                eO(false);
            }
        }
        ayL();
    }

    private void reset() {
        if (this.dfw != null && this.dfw.awd() != null && this.LE != null) {
            com.baidu.tbadk.editortools.d.b.DI().setStatus(0);
            com.baidu.tbadk.editortools.d.e awd = this.dfw.awd();
            awd.Ej();
            if (awd.getWriteImagesInfo() != null) {
                awd.getWriteImagesInfo().setMaxImagesAllowed(10);
            }
            awd.eK(10);
            awd.eI(SendView.ALL);
            awd.eJ(SendView.ALL);
            awd.fx(this.dfw.getActivity().getString(t.j.pb_reply_hint));
            com.baidu.tbadk.editortools.s eA = this.LE.eA(23);
            com.baidu.tbadk.editortools.s eA2 = this.LE.eA(2);
            com.baidu.tbadk.editortools.s eA3 = this.LE.eA(5);
            if (eA2 != null) {
                eA2.op();
            }
            if (eA3 != null) {
                eA3.op();
            }
            if (eA != null) {
                eA.hide();
            }
            this.LE.invalidate();
        }
    }

    public boolean ayl() {
        return this.dmb;
    }

    public void eN(boolean z) {
        if (this.dlV != null && this.dlW != null && this.dlX != null) {
            this.dlW.setText(t.j.draft_to_send);
            this.dlX.setVisibility(8);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.dlV.startAnimation(alphaAnimation);
            }
            this.dlV.setVisibility(0);
        }
    }

    public void eO(boolean z) {
        if (this.dlV != null && this.dlW != null && this.dlX != null) {
            this.dlW.setText(t.j.reply_floor_host);
            this.dlX.setVisibility(0);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.dlV.startAnimation(alphaAnimation);
            }
            this.dlV.setVisibility(0);
        }
    }

    public com.baidu.tieba.tbadkCore.data.s aym() {
        int i;
        View childAt;
        int i2 = 0;
        if (this.bcd == null) {
            return null;
        }
        int firstVisiblePosition = this.bcd.getFirstVisiblePosition();
        int lastVisiblePosition = this.bcd.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.bcd.getChildCount();
            int i3 = 0;
            for (int i4 = firstVisiblePosition; i4 <= lastVisiblePosition; i4++) {
                if (i4 - firstVisiblePosition < childCount && (childAt = this.bcd.getChildAt(i4 - firstVisiblePosition)) != null) {
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
        int headerViewsCount = i - this.bcd.getHeaderViewsCount();
        if (headerViewsCount < 0) {
            headerViewsCount = 0;
        }
        if (this.dlp.lW(headerViewsCount) != null && this.dlp.lW(headerViewsCount) != com.baidu.tieba.tbadkCore.data.s.epG) {
            i2 = headerViewsCount + 1;
        }
        return (com.baidu.tieba.tbadkCore.data.s) this.dlp.aF(i2);
    }

    public eu(PbActivity pbActivity, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.c cVar) {
        this.dfw = null;
        this.cYO = null;
        this.dkD = null;
        this.bcd = null;
        this.dkI = null;
        this.dkK = null;
        this.dkL = null;
        this.dkM = null;
        this.dkN = null;
        this.dkO = null;
        this.dkP = null;
        this.dkQ = null;
        this.dkR = null;
        this.dkS = null;
        this.dkT = null;
        this.dkU = null;
        this.dkV = null;
        this.dkW = null;
        this.dkX = null;
        this.dkY = null;
        this.dkZ = null;
        this.dld = null;
        this.dlj = null;
        this.dlk = null;
        this.dlm = null;
        this.dlp = null;
        this.dlu = null;
        this.aAj = null;
        this.boQ = null;
        this.deJ = null;
        this.dlV = null;
        this.dlW = null;
        this.dlY = null;
        this.dlZ = null;
        this.dma = null;
        this.dmi = null;
        this.dmj = null;
        this.dfw = pbActivity;
        this.boQ = onClickListener;
        this.dds = cVar;
        this.cYO = (RelativeLayout) LayoutInflater.from(this.dfw.getPageContext().getPageActivity()).inflate(t.h.new_pb_activity, (ViewGroup) null);
        this.dfw.addContentView(this.cYO, new FrameLayout.LayoutParams(-1, -1));
        this.dkD = this.dfw.findViewById(t.g.statebar_view);
        this.dln = (RelativeLayout) this.dfw.findViewById(t.g.title_wrapper);
        this.dlo = (RelativeLayout) this.dfw.findViewById(t.g.list_wrapper);
        this.baT = (NoNetworkView) this.dfw.findViewById(t.g.view_no_network);
        this.bcd = (BdTypeListView) this.dfw.findViewById(t.g.new_pb_list);
        View view = new View(this.dfw.getPageContext().getPageActivity());
        view.setLayoutParams(new AbsListView.LayoutParams(-1, this.dfw.getResources().getDimensionPixelSize(t.e.pb_editor_height)));
        this.bcd.addFooterView(view);
        this.bcd.setOnTouchListener(this.dfw.aJt);
        this.dkF = new com.baidu.tieba.pb.pb.main.b.e(pbActivity);
        this.dkG = new com.baidu.tieba.pb.pb.main.b.c(pbActivity);
        if (this.dfw.awE()) {
            this.dkG.show();
            this.dkF.mNavigationBar.setVisibility(8);
        }
        this.dkF.azu().setOnTouchListener(new com.baidu.tieba.pb.a.a(new gc(this)));
        this.dlV = this.dfw.findViewById(t.g.pb_editor_tool_comment);
        ays();
        this.dlW = (TextView) this.dfw.findViewById(t.g.pb_editor_tool_comment_reply_text);
        this.dlY = (ViewGroup) this.dfw.findViewById(t.g.pb_editor_tool_comment_reply_layout);
        this.dlZ = (TextView) this.dfw.findViewById(t.g.pb_editor_tool_comment_praise_icon);
        boolean af = com.baidu.tieba.graffiti.d.af(this.dlZ);
        if (af) {
            gt(af);
            this.dlZ.setVisibility(0);
        }
        this.dlX = (TextView) this.dfw.findViewById(t.g.pb_editor_tool_comment_reply_count_text);
        this.dma = this.dfw.findViewById(t.g.pb_editor_tool_comment_graffiti_icon);
        this.dma.setOnClickListener(this.boQ);
        this.dlW.setOnClickListener(new gd(this));
        this.dlZ.setOnClickListener(this.boQ);
        this.dlZ.setOnTouchListener(this.dfw);
        this.dkI = LayoutInflater.from(this.dfw.getPageContext().getPageActivity()).inflate(t.h.new_pb_header_item, (ViewGroup) null);
        this.dkK = (LinearLayout) LayoutInflater.from(this.dfw.getPageContext().getPageActivity()).inflate(t.h.new_pb_header_user_item, (ViewGroup) null);
        this.dkL = (TextView) this.dkK.findViewById(t.g.icon_push);
        this.dkL.setOnClickListener(this.boQ);
        this.dkL.setVisibility(8);
        this.dkM = (ColumnLayout) this.dkK.findViewById(t.g.pb_head_owner_root);
        this.dkM.setOnLongClickListener(this.onLongClickListener);
        this.dkM.setOnTouchListener(this.dds);
        this.dkM.setVisibility(8);
        this.dkI.setOnTouchListener(this.dds);
        this.dkN = (TextView) this.dkI.findViewById(t.g.pb_head_post_title);
        this.dkN.setTextSize(TbConfig.getContentSizeOfPostTitle());
        this.dkN.setVisibility(8);
        this.dmi = this.dkI.findViewById(t.g.pb_head_activity_join_number_container);
        this.dmi.setVisibility(8);
        this.dmj = (TextView) this.dkI.findViewById(t.g.pb_head_activity_join_number);
        this.dkO = (TextView) this.dkM.findViewById(t.g.pb_head_owner_info_user_name);
        this.dkP = (HeadImageView) this.dkM.findViewById(t.g.pb_head_owner_photo);
        if (!this.ddp) {
            this.dkP.setVisibility(8);
        }
        this.dkQ = (ImageView) this.dkM.findViewById(t.g.pb_head_owner_info_user_rank);
        this.dkR = (ImageView) this.dkM.findViewById(t.g.pb_head_owner_info_user_gender);
        this.dkS = (ImageView) this.dkM.findViewById(t.g.pb_head_owner_info_user_bawu);
        this.dkT = (UserIconBox) this.dkM.findViewById(t.g.pb_head_owner_info_user_icon);
        this.dkU = (UserIconBox) this.dkM.findViewById(t.g.pb_head_owner_info_tshow_icon);
        this.dkV = (ImageView) this.dkM.findViewById(t.g.pb_head_owner_info_floor_owner);
        this.dkW = (TextView) this.dkM.findViewById(t.g.pb_head_owner_info_time);
        this.dkX = (LinearLayout) this.dkI.findViewById(t.g.read_thread_view);
        this.dkY = (TextView) this.dkI.findViewById(t.g.pb_head_read_button);
        this.dkZ = (TextView) this.dkI.findViewById(t.g.pb_head_read_tip);
        this.dkX.setOnClickListener(this.boQ);
        this.dld = (TextView) this.dkI.findViewById(t.g.pb_head_reverse_hint);
        this.dld.setOnClickListener(this.boQ);
        this.dld.setVisibility(8);
        ayt();
        this.dlj = this.dkI.findViewById(t.g.new_pb_header_item_line_above_livepost);
        this.dlk = this.dkI.findViewById(t.g.new_pb_header_item_line_below_livepost);
        this.dlm = this.dkI.findViewById(t.g.new_pb_header_item_line_above_showpassed);
        this.dkI.setOnLongClickListener(new ge(this));
        ayz();
        this.dmk = (LinearLayout) this.cYO.findViewById(t.g.interview_live_status_container);
        this.dml = (TextView) this.cYO.findViewById(t.g.interview_live_status_btn);
        this.dmk.setOnClickListener(this.boQ);
        this.dlp = new cq(this.dfw, this.bcd);
        this.dlp.M(this.boQ);
        this.dlp.a(this.dds);
        this.dlp.setOnImageClickListener(this.aJc);
        this.deJ = new gf(this);
        this.dlp.L(this.deJ);
        this.bcd.addHeaderView(this.dkK);
        this.bcd.addHeaderView(this.dkI);
        this.dlu = new PbListView(this.dfw.getPageContext().getPageActivity());
        this.aAj = this.dlu.getView().findViewById(t.g.pb_more_view);
        if (this.aAj != null) {
            this.aAj.setOnClickListener(this.boQ);
            com.baidu.tbadk.core.util.at.k(this.aAj, t.f.pb_foot_more_trans_selector);
        }
        this.dlu.xp();
        this.dlu.dh(t.f.pb_foot_more_trans_selector);
        this.dlu.di(t.f.pb_foot_more_trans_selector);
        this.dlw = this.dfw.findViewById(t.g.viewstub_progress);
        this.dfw.registerListener(this.dmS);
        ayo();
    }

    public void ayn() {
        if (this.bcd != null) {
            this.bcd.removeHeaderView(this.dkK);
            this.bcd.removeHeaderView(this.dkI);
        }
    }

    private void ayo() {
        this.dlf = (LinearLayout) this.dfw.findViewById(t.g.manga_controller_layout);
        this.dlg = (TextView) this.dfw.findViewById(t.g.manga_prev_btn);
        this.dlh = (TextView) this.dfw.findViewById(t.g.manga_next_btn);
        if (this.dfw.awE()) {
            this.dlg.setOnClickListener(this.boQ);
            this.dlh.setOnClickListener(this.boQ);
            ayr();
        }
    }

    private void ayp() {
        if (this.dfw.awE()) {
            if (this.dfw.awH() == -1) {
                com.baidu.tbadk.core.util.at.b(this.dlg, t.d.cp_cont_e, 1);
            }
            if (this.dfw.awI() == -1) {
                com.baidu.tbadk.core.util.at.b(this.dlh, t.d.cp_cont_e, 1);
            }
        }
    }

    public void ayq() {
        this.dlf.setVisibility(8);
        if (this.dmR != null) {
            this.dmQ.removeCallbacks(this.dmR);
        }
    }

    public void ayr() {
        if (this.dmR != null) {
            this.dmQ.removeCallbacks(this.dmR);
        }
        this.dmR = new ew(this);
        this.dmQ.postDelayed(this.dmR, 2000L);
    }

    private void ays() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GRAFFITI_QUICK_VOTE_VIEW, this.dfw.getActivity()), com.baidu.tieba.pb.a.class);
        if (runTask != null && runTask.getData() != null) {
            this.dmm = (com.baidu.tieba.pb.a) runTask.getData();
            ViewGroup viewGroup = (ViewGroup) this.dfw.findViewById(t.g.pb_comment_container);
            if (this.dmm != null && viewGroup != null) {
                viewGroup.addView(this.dmm, 0, new LinearLayout.LayoutParams(-1, -2));
            }
        }
    }

    public void gm(boolean z) {
        this.dkF.gm(z);
        if (z && this.dmh) {
            this.dlu.setText(this.dfw.getResources().getString(t.j.click_load_more));
            this.bcd.setNextPage(this.dlu);
            this.dkE = 2;
        }
    }

    private void ayt() {
        if (com.baidu.tbadk.core.sharedPref.b.vk().getBoolean("should_show_pb_read_text", true)) {
            this.dkZ.setVisibility(0);
        }
    }

    public void ayu() {
        this.dkZ.setVisibility(8);
        com.baidu.tbadk.core.sharedPref.b.vk().putBoolean("should_show_pb_read_text", false);
    }

    public void ayv() {
        TbadkCoreApplication.m411getInst().setReadThreadPlayerScreenMaxHeight(this.cYO.getHeight());
    }

    public void setEditorTools(com.baidu.tbadk.editortools.l lVar) {
        this.LE = lVar;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.cYO.addView(this.LE, layoutParams);
        this.LE.onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        this.LE.hide();
    }

    public void ayw() {
        if (this.dfw != null && this.LE != null) {
            this.LE.op();
        }
    }

    public void ma(String str) {
        if (this.dlX != null) {
            if (TextUtils.isEmpty(str)) {
                str = "0";
            }
            this.dlX.setText(this.dfw.getPageContext().getResources().getString(t.j.pb_reply_count_text, str));
        }
    }

    public void E(String str, boolean z) {
        this.dmc = z;
        gn(TbadkCoreApplication.m411getInst().getSkinType() == 1);
    }

    private void gn(boolean z) {
        if (this.dlZ != null) {
            if (this.dmc) {
                com.baidu.tbadk.core.util.at.k(this.dlZ, t.f.pb_praise_already_click_selector);
                this.dlZ.setContentDescription(this.dfw.getResources().getString(t.j.cancel_praise));
                return;
            }
            com.baidu.tbadk.core.util.at.k(this.dlZ, t.f.pb_praise_normal_click_selector);
            this.dlZ.setContentDescription(this.dfw.getResources().getString(t.j.frs_item_praise_text));
        }
    }

    public TextView ayx() {
        return this.dlZ;
    }

    public void go(boolean z) {
        if (this.bcd != null) {
            if (!z) {
                this.bcd.setEnabled(z);
                return;
            }
            if (this.dmw == null) {
                this.dmw = new ex(this, z);
            }
            com.baidu.adp.lib.h.h.hx().postDelayed(this.dmw, 10L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gp(boolean z) {
        if (z) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dkD.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.dkD.setLayoutParams(layoutParams);
            this.dkD.setVisibility(0);
            return;
        }
        this.dkD.setVisibility(8);
    }

    public void aM(View view) {
        boolean z;
        View view2;
        if (this.dln != null && view != null) {
            if (this.dmb) {
                z = this.dlV.getVisibility() == 0;
            } else {
                z = this.LE != null && this.LE.getVisibility() == 0;
            }
            boolean z2 = this.dln.getVisibility() == 0;
            if (z2) {
                TiebaStatic.log("c10084");
                this.dmA = true;
                View findViewById = this.dfw.findViewById(t.g.bg_above_list);
                findViewById.setLayoutParams(new RelativeLayout.LayoutParams(-1, this.dln.getHeight()));
                com.baidu.tieba.tbadkCore.a.a(this.dfw, this.dln, t.a.top_fold_up, new ey(this, findViewById));
            } else {
                this.dmA = false;
                com.baidu.tieba.tbadkCore.a.a(this.dfw, this.dln, t.a.top_fold_down, new ez(this));
            }
            if (this.dmb) {
                view2 = this.dlV;
            } else {
                view2 = this.LE;
            }
            if (z) {
                if (z2) {
                    if (this.LE != null) {
                        this.LE.BD();
                    }
                    com.baidu.tieba.tbadkCore.a.a(this.dfw, view2, t.a.bottom_fold_down, new fa(this));
                }
            } else if (!z2) {
                com.baidu.tieba.tbadkCore.a.a(this.dfw, view2, t.a.bottom_fold_up, new fb(this));
            }
            ayL();
        }
    }

    public cq ayy() {
        return this.dlp;
    }

    public void a(PbActivity.c cVar) {
        this.dhf = cVar;
    }

    private void a(com.baidu.tbadk.core.data.av avVar) {
        if (avVar == null || avVar.ud() == 0) {
            if (this.dlU != null) {
                this.dlU.setVisibility(8);
            }
            if (this.dlj != null) {
                this.dlj.setVisibility(8);
                return;
            }
            return;
        }
        if (this.dlU == null) {
            this.dfw.getLayoutMode().x(((ViewStub) this.dkI.findViewById(t.g.live_talk_layout)).inflate());
            this.dlU = (Button) this.dkI.findViewById(t.g.pb_head_function_manage_go_to_live_post);
            this.dlj = this.dkI.findViewById(t.g.new_pb_header_item_line_above_livepost);
        }
        int ue = avVar.ue();
        String string = this.dfw.getPageContext().getString(t.j.go_to_live_post_prefix);
        if (ue == 0) {
            string = String.valueOf(string) + this.dfw.getPageContext().getString(t.j.go_to_interview_post);
        } else if (ue == 1) {
            string = String.valueOf(string) + this.dfw.getPageContext().getString(t.j.go_to_discuss_post);
        }
        this.dlU.setText(string);
        this.dlU.setVisibility(0);
        this.dlU.setOnClickListener(this.boQ);
        this.dmX = true;
        ayO();
        ayR();
    }

    private void ayz() {
        this.dmd = (LinearLayout) this.dkI.findViewById(t.g.btn_show_passed_pb);
        this.dmf = (TextView) this.dkI.findViewById(t.g.show_pre_page_view);
        this.dme = (TextView) this.dkI.findViewById(t.g.go_back_top_view);
        this.aLn = this.dkI.findViewById(t.g.show_passed_divider);
        this.dmf.setOnClickListener(this.dmT);
        this.dme.setOnClickListener(this.boQ);
        ayR();
    }

    public LinearLayout ayA() {
        return this.dkX;
    }

    public void gq(boolean z) {
        if (this.dkX != null) {
            if (z && TbadkCoreApplication.m411getInst().isTTSCanUse() && !this.dmN) {
                this.dkX.setVisibility(0);
            } else {
                this.dkX.setVisibility(8);
            }
        }
    }

    public void aN(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, boolean z) {
        SparseArray sparseArray2;
        if (this.dly == null) {
            this.dly = LayoutInflater.from(this.dfw.getPageContext().getPageActivity()).inflate(t.h.forum_manage_dialog, (ViewGroup) null);
        }
        this.dfw.getLayoutMode().x(this.dly);
        if (this.dlx == null) {
            this.dlx = new Dialog(this.dfw.getPageContext().getPageActivity(), t.k.common_alert_dialog);
            this.dlx.setCanceledOnTouchOutside(true);
            this.dlx.setCancelable(true);
            this.dlx.setContentView(this.dly);
            WindowManager.LayoutParams attributes = this.dlx.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.k.B(this.dfw.getPageContext().getPageActivity()) * 0.9d);
            this.dlx.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.dlx.findViewById(t.g.del_post_btn);
        TextView textView2 = (TextView) this.dlx.findViewById(t.g.forbid_user_btn);
        TextView textView3 = (TextView) this.dlx.findViewById(t.g.disable_reply_btn);
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
            textView.setOnClickListener(new fc(this));
        }
        if ("".equals(sparseArray.get(t.g.tag_forbid_user_name)) || awe()) {
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
            textView2.setOnClickListener(new fd(this));
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
            textView3.setOnClickListener(new fe(this, z));
        }
        com.baidu.adp.lib.h.j.a(this.dlx, this.dfw.getPageContext());
    }

    public void a(PbActivity.a aVar) {
        this.dmU = aVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(t.g.tag_del_post_id, str);
        sparseArray.put(t.g.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(t.g.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(t.g.tag_del_post_is_self, Boolean.valueOf(z));
        sparseArray.put(dmq, Integer.valueOf(dmr));
        int i3 = t.j.del_post_confirm;
        if (i == 0) {
            i3 = t.j.del_thread_confirm;
        }
        this.dlz = new com.baidu.tbadk.core.dialog.a(this.dfw.getActivity());
        this.dlz.ca(i3);
        this.dlz.x(sparseArray);
        this.dlz.a(t.j.dialog_ok, this.dfw);
        this.dlz.b(t.j.dialog_cancel, new ff(this));
        this.dlz.am(true);
        this.dlz.b(this.dfw.getPageContext());
        this.dlz.up();
    }

    public void Y(ArrayList<com.baidu.tbadk.core.data.t> arrayList) {
        if (this.dlK == null) {
            this.dlK = LayoutInflater.from(this.dfw.getPageContext().getPageActivity()).inflate(t.h.commit_good, (ViewGroup) null);
        }
        this.dfw.getLayoutMode().x(this.dlK);
        if (this.dlJ == null) {
            this.dlJ = new Dialog(this.dfw.getPageContext().getPageActivity(), t.k.common_alert_dialog);
            this.dlJ.setCanceledOnTouchOutside(true);
            this.dlJ.setCancelable(true);
            this.dlT = (ScrollView) this.dlK.findViewById(t.g.good_scroll);
            this.dlJ.setContentView(this.dlK);
            WindowManager.LayoutParams attributes = this.dlJ.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.k.c(this.dfw.getPageContext().getPageActivity(), t.e.ds540);
            this.dlJ.getWindow().setAttributes(attributes);
            this.dlM = new fh(this);
            this.dlL = (LinearLayout) this.dlK.findViewById(t.g.good_class_group);
            this.dlO = (TextView) this.dlK.findViewById(t.g.dialog_button_cancel);
            this.dlO.setOnClickListener(new fi(this));
            this.dlN = (TextView) this.dlK.findViewById(t.g.dialog_button_ok);
            this.dlN.setOnClickListener(this.boQ);
        }
        this.dlL.removeAllViews();
        this.dkH = new ArrayList();
        com.baidu.tieba.pb.pb.main.b.a bs = bs("0", this.dfw.getPageContext().getString(t.j.def_good_class));
        this.dkH.add(bs);
        bs.setChecked(true);
        this.dlL.addView(bs);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.tieba.pb.pb.main.b.a bs2 = bs(String.valueOf(arrayList.get(i2).rR()), arrayList.get(i2).rQ());
                this.dkH.add(bs2);
                View view = new View(this.dfw.getPageContext().getPageActivity());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.c(this.dfw.getPageContext().getPageActivity(), t.e.ds1));
                com.baidu.tbadk.core.util.at.l(view, t.d.cp_bg_line_a);
                view.setLayoutParams(layoutParams);
                this.dlL.addView(view);
                this.dlL.addView(bs2);
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.dlT.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.k.dip2px(this.dfw.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.k.dip2px(this.dfw.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.k.dip2px(this.dfw.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.dlT.setLayoutParams(layoutParams2);
            this.dlT.removeAllViews();
            this.dlT.addView(this.dlL);
        }
        com.baidu.adp.lib.h.j.a(this.dlJ, this.dfw.getPageContext());
    }

    private com.baidu.tieba.pb.pb.main.b.a bs(String str, String str2) {
        Activity pageActivity = this.dfw.getPageContext().getPageActivity();
        com.baidu.tieba.pb.pb.main.b.a aVar = new com.baidu.tieba.pb.pb.main.b.a(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.k.c(pageActivity, t.e.ds100));
        aVar.setOnCheckedChangeListener(this.dlM);
        aVar.setTag(str);
        aVar.setText(str2);
        aVar.setLayoutParams(layoutParams);
        return aVar;
    }

    public void ayB() {
        this.dfw.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.dfw.hideProgressBar();
        if (z && z2) {
            this.dfw.showToast(this.dfw.getPageContext().getString(t.j.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.ay.isEmpty(str)) {
                str = TbadkCoreApplication.m411getInst().getResources().getString(t.j.neterror);
            }
            this.dfw.showToast(str);
        }
    }

    public void agh() {
        this.dlw.setVisibility(0);
    }

    public void agg() {
        this.dlw.setVisibility(8);
    }

    public View ayC() {
        if (this.dlK != null) {
            return this.dlK.findViewById(t.g.dialog_button_ok);
        }
        return null;
    }

    public String ayD() {
        return this.dlP;
    }

    public View getView() {
        return this.cYO;
    }

    public void ayE() {
        com.baidu.adp.lib.util.k.c(this.dfw.getPageContext().getPageActivity(), this.dfw.getCurrentFocus());
    }

    public void amH() {
        this.dfw.showProgressBar();
    }

    public void gr(boolean z) {
        this.dfw.hideProgressBar();
        amI();
    }

    public void ayF() {
        this.dlu.xu();
    }

    public void ayG() {
    }

    public void ayH() {
        this.dfw.hideProgressBar();
        this.dlu.xv();
        azf();
        this.bcd.nj();
        ayR();
    }

    public void ayI() {
        this.bcd.nj();
        this.dmd.setVisibility(8);
        ayR();
    }

    public void gs(boolean z) {
        this.dma.setVisibility(z ? 0 : 8);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.dlY.getLayoutParams();
        marginLayoutParams.rightMargin = z ? this.dfw.getResources().getDimensionPixelSize(t.e.ds84) : 0;
        this.dlY.setLayoutParams(marginLayoutParams);
    }

    private void gt(boolean z) {
        int i;
        int i2;
        int dimensionPixelSize = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds16);
        int dimensionPixelSize2 = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds16);
        int dimensionPixelSize3 = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds84);
        int dimensionPixelSize4 = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds14);
        if (z) {
            i = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds96);
            i2 = 0;
        } else {
            i = dimensionPixelSize;
            i2 = dimensionPixelSize3;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dlY.getLayoutParams();
        layoutParams.setMargins(i, dimensionPixelSize2, i2, dimensionPixelSize4);
        this.dlY.setLayoutParams(layoutParams);
    }

    public void b(com.baidu.tbadk.core.data.v vVar) {
        if (this.dmm != null) {
            this.dmm.a(vVar);
        }
    }

    public boolean ayJ() {
        return this.dmm != null && this.dmm.getVisibility() == 0;
    }

    public void ayK() {
        if (this.dmm != null && this.dma != null) {
            this.dmm.Us();
            this.dma.setSelected(true);
        }
    }

    public void ayL() {
        if (this.dmm != null && this.dma != null) {
            this.dmm.Zf();
            this.dma.setSelected(false);
        }
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.dlp.setOnLongClickListener(onLongClickListener);
    }

    public void a(c.b bVar, boolean z, boolean z2) {
        if (this.dlQ != null) {
            this.dlQ.dismiss();
            this.dlQ = null;
        }
        this.dlQ = new com.baidu.tbadk.core.dialog.c(this.dfw.getPageContext().getPageActivity());
        this.dlQ.cd(t.j.operation);
        if (z2) {
            this.dlQ.a(new String[]{this.dfw.getPageContext().getString(t.j.copy)}, bVar);
        } else if (!z) {
            this.dlQ.a(new String[]{this.dfw.getPageContext().getString(t.j.copy), this.dfw.getPageContext().getString(t.j.mark)}, bVar);
        } else {
            this.dlQ.a(new String[]{this.dfw.getPageContext().getString(t.j.copy), this.dfw.getPageContext().getString(t.j.remove_mark)}, bVar);
        }
        this.dlQ.d(this.dfw.getPageContext());
        this.dlQ.us();
    }

    public int ayM() {
        return mj(this.bcd.getFirstVisiblePosition());
    }

    private int mj(int i) {
        com.baidu.adp.widget.ListView.e eVar = (com.baidu.adp.widget.ListView.e) this.bcd.getAdapter();
        if (eVar != null) {
            if (i < eVar.getCount() && i >= 0 && (eVar.getItem(i) instanceof com.baidu.tieba.pb.data.c)) {
                i++;
            }
            int headerViewsCount = (eVar.getHeaderViewsCount() + eVar.nf()) - 1;
            if (i > headerViewsCount) {
                i = headerViewsCount;
            }
            int headersCount = (this.bcd.getAdapter() == null || !(this.bcd.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) ? 0 : ((com.baidu.adp.widget.ListView.e) this.bcd.getAdapter()).getHeadersCount();
            return i > headersCount ? i - headersCount : 0;
        }
        return i;
    }

    public int ayN() {
        return mj(this.bcd.getLastVisiblePosition());
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.dls.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void j(com.baidu.tieba.pb.data.e eVar) {
        this.dlp.a(eVar);
        this.dlp.notifyDataSetChanged();
        if (eVar == null) {
            ma("");
        } else {
            ma(com.baidu.tbadk.core.util.ay.A(eVar.avv().getReply_num()));
        }
        ayR();
    }

    public void k(com.baidu.tieba.pb.data.e eVar) {
        PraiseData praise;
        if (this.dle == null) {
            this.dfw.getLayoutMode().x(((ViewStub) this.dkI.findViewById(t.g.praise_layout)).inflate());
            this.dle = (FrsPraiseView) this.dkI.findViewById(t.g.pb_head_praise_view);
            this.dle.setIsFromPb(true);
            this.dll = this.dkI.findViewById(t.g.new_pb_header_item_line_above_praise);
            this.dle.dn(TbadkCoreApplication.m411getInst().getSkinType());
        }
        if (this.dle != null) {
            boolean ayR = ayR();
            if (eVar != null && eVar.avw() != null && eVar.avw().size() > 0) {
                com.baidu.tieba.tbadkCore.data.s sVar = eVar.avw().get(0);
                if ((!this.ddr || sVar.aTs() != 1) && (praise = eVar.avv().getPraise()) != null && praise.getUser() != null && praise.getUser().size() > 0) {
                    this.dle.setVisibility(0);
                    this.dle.setIsFromPb(true);
                    this.dle.a(praise, eVar.avv().getId(), praise.getPostId(), true);
                    this.dll.setVisibility(0);
                    if (this.dle.getVisibility() == 0) {
                        this.dlm.setVisibility(0);
                    }
                    com.baidu.tieba.graffiti.d.af(this.dle);
                    com.baidu.tieba.graffiti.d.af(this.dll);
                    return;
                }
            }
            this.dle.setVisibility(8);
            this.dll.setVisibility(8);
            if (eVar != null && eVar.getPage() != null && eVar.getPage().sr() == 0 && this.ddr) {
                this.dll.setVisibility(8);
                if (ayR) {
                    this.dlk.setVisibility(0);
                } else {
                    this.dlk.setVisibility(8);
                }
            } else {
                this.dll.setVisibility(0);
                this.dlk.setVisibility(8);
            }
            com.baidu.tieba.graffiti.d.af(this.dll);
            com.baidu.tieba.graffiti.d.af(this.dlk);
        }
    }

    private com.baidu.tieba.tbadkCore.data.s a(com.baidu.tieba.pb.data.e eVar, boolean z, int i) {
        if (z) {
            if (eVar == null || eVar.avw() == null || eVar.avw().size() <= 0) {
                return null;
            }
            com.baidu.tieba.tbadkCore.data.s sVar = eVar.avw().get(0);
            if (sVar.aTs() != 1) {
                return b(eVar);
            }
            return sVar;
        }
        return b(eVar);
    }

    private com.baidu.tieba.tbadkCore.data.s b(com.baidu.tieba.pb.data.e eVar) {
        MetaData metaData;
        if (eVar == null || eVar.avv() == null || eVar.avv().getAuthor() == null) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.s sVar = new com.baidu.tieba.tbadkCore.data.s();
        MetaData author = eVar.avv().getAuthor();
        String userId = author.getUserId();
        HashMap<String, MetaData> userMap = eVar.avv().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = author;
        }
        sVar.ps(1);
        sVar.setId(eVar.avv().tB());
        sVar.setTitle(eVar.avv().getTitle());
        sVar.setTime(eVar.avv().getCreateTime());
        sVar.setAuthor(metaData);
        return sVar;
    }

    private void b(com.baidu.tieba.pb.data.e eVar, boolean z, int i) {
        if (eVar != null && eVar.avv() != null) {
            azo();
            this.dkM.setVisibility(8);
            com.baidu.tieba.tbadkCore.data.s a = a(eVar, z, i);
            if (a != null) {
                String str = null;
                boolean z2 = false;
                if (eVar != null && eVar.avv() != null && eVar.avv().getAuthor() != null) {
                    str = eVar.avv().getAuthor().getUserId();
                    if (eVar.getPage() != null) {
                        this.dmG = eVar.getPage().sn();
                        z2 = eVar.getPage().sq() == 1;
                    }
                }
                this.dmz = !eVar.avv().tN() && a(a, eVar.avv().getId(), str, z2, z);
                if (z) {
                    this.dld.setVisibility(8);
                } else if (!this.dmN) {
                    this.dld.setVisibility(0);
                }
                this.dkM.setVisibility(0);
                SparseArray sparseArray = (SparseArray) this.dkM.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    this.dkM.setTag(sparseArray);
                }
                sparseArray.put(t.g.tag_clip_board, a);
                sparseArray.put(t.g.tag_is_subpb, false);
                this.dkW.setText(com.baidu.tbadk.core.util.ay.w(a.getTime()));
                eVar.avv().tM();
                if (!this.dmN) {
                    this.dkN.setVisibility(0);
                    this.dkN.setText(eVar.avv().getSpan_str());
                }
                if (!eVar.avv().tO()) {
                    this.dkN.setVisibility(0);
                }
                this.dkN.setText(eVar.avv().getSpan_str());
                k(eVar);
                ArrayList<com.baidu.tbadk.core.data.a> tw = eVar.avv().tw();
                if (tw != null && tw.size() > 0 && !this.dmN) {
                    this.dmj.setText(String.valueOf(tw.get(0).qX()));
                    this.dmi.setVisibility(0);
                    this.dmW = true;
                } else {
                    this.dmi.setVisibility(8);
                }
                com.baidu.tbadk.core.util.at.k(this.dmi, t.f.activity_join_num_bg);
                com.baidu.tbadk.core.util.at.b(this.dmj, t.d.cp_link_tip_d, 1);
                if (eVar != null && eVar.avv() != null && eVar.avv().getAuthor() != null) {
                    String userId = eVar.avv().getAuthor().getUserId();
                    if (userId != null && !userId.equals("0") && userId.equals(a.getAuthor().getUserId())) {
                        this.dkV.setVisibility(0);
                    } else {
                        this.dkV.setVisibility(8);
                    }
                }
                if (a.getAuthor() != null) {
                    int level_id = a.getAuthor().getLevel_id();
                    int is_bawu = a.getAuthor().getIs_bawu();
                    String bawu_type = a.getAuthor().getBawu_type();
                    int i2 = 3;
                    if (level_id != 0) {
                        this.dkQ.setVisibility(0);
                        com.baidu.tbadk.core.util.at.c(this.dkQ, BitmapHelper.getGradeResourceIdNew(level_id));
                        this.dkQ.setContentDescription(String.format(TbadkCoreApplication.m411getInst().getString(t.j.degree_in_forum), Integer.valueOf(level_id)));
                        this.dkQ.setOnClickListener(null);
                    } else {
                        this.dkQ.setVisibility(8);
                    }
                    if (is_bawu != 0) {
                        if (bawu_type.equals("manager")) {
                            com.baidu.tbadk.core.util.at.c(this.dkS, t.f.pb_manager);
                            this.dkQ.setVisibility(8);
                            this.dkS.setVisibility(0);
                        } else if (bawu_type.equals("assist")) {
                            com.baidu.tbadk.core.util.at.c(this.dkS, t.f.pb_assist);
                            this.dkQ.setVisibility(8);
                            this.dkS.setVisibility(0);
                        }
                    }
                    if (a.getAuthor().getGender() == 2) {
                        com.baidu.tbadk.core.util.at.c(this.dkR, t.f.icon_pb_pop_girl);
                        this.dkR.setVisibility(0);
                    } else if (a.getAuthor().getGender() == 1) {
                        com.baidu.tbadk.core.util.at.c(this.dkR, t.f.icon_pb_pop_boy);
                        this.dkR.setVisibility(0);
                    } else {
                        this.dkR.setVisibility(8);
                    }
                    if (!StringUtils.isNull(a.getAuthor().getName_show()) && com.baidu.adp.lib.util.j.aW(a.getAuthor().getName_show()) > 14) {
                        i2 = 0;
                    }
                    ArrayList<IconData> iconInfo = a.getAuthor().getIconInfo();
                    ArrayList<IconData> tShowInfoNew = a.getAuthor().getTShowInfoNew();
                    if (this.dkT != null) {
                        this.dkT.setTag(t.g.tag_user_id, a.getAuthor().getUserId());
                        this.dkT.setOnClickListener(this.dfw.dgG.bpv);
                        this.dkT.a(iconInfo, i2, this.dfw.getResources().getDimensionPixelSize(t.e.pb_icon_width), this.dfw.getResources().getDimensionPixelSize(t.e.pb_icon_height), this.dfw.getResources().getDimensionPixelSize(t.e.pb_icon_margin));
                    }
                    if (this.dkU != null) {
                        if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                            this.dkU.setTag(tShowInfoNew.get(0).getUrl());
                        }
                        this.dkU.setOnClickListener(this.dfw.dgG.dnx);
                        this.dkU.a(tShowInfoNew, 3, this.dfw.getResources().getDimensionPixelSize(t.e.small_icon_width), this.dfw.getResources().getDimensionPixelSize(t.e.small_icon_height), this.dfw.getResources().getDimensionPixelSize(t.e.big_icon_margin), true);
                    }
                    this.dkO.setText(a.getAuthor().getName_show());
                    this.dkO.setTag(t.g.tag_user_id, a.getAuthor().getUserId());
                    this.dkO.setTag(t.g.tag_user_name, a.getAuthor().getName_show());
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                        com.baidu.tbadk.core.util.at.b(this.dkO, t.d.cp_cont_h, 1);
                    } else {
                        com.baidu.tbadk.core.util.at.b(this.dkO, t.d.cp_cont_f, 1);
                    }
                    this.dkP.setUserId(a.getAuthor().getUserId());
                    this.dkP.setUserName(a.getAuthor().getUserName());
                    this.dkP.setImageDrawable(null);
                    this.dkP.setTag(a.getAuthor().getUserId());
                    if (this.dmz) {
                        fj fjVar = new fj(this, a);
                        this.dkO.setOnClickListener(fjVar);
                        this.dkP.setOnClickListener(fjVar);
                        this.dkP.setVisibility(8);
                    } else {
                        if (!this.ddp) {
                            this.dkP.setVisibility(8);
                        } else {
                            this.dkP.setVisibility(0);
                        }
                        this.dkO.setOnClickListener(this.dfw.dgG.dnw);
                        this.dkP.setOnClickListener(this.dfw.dgG.dnw);
                    }
                    this.dkP.c(a.getAuthor().getPortrait(), 28, false);
                }
                ayO();
                if (eVar.avv().tE() != null) {
                    int status = eVar.avv().tE().getStatus();
                    if (status == 1) {
                        gx(true);
                    } else if (status == 2) {
                        gx(false);
                    }
                }
            }
        }
    }

    private void ayO() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dkX.getLayoutParams();
        layoutParams.setMargins(layoutParams.leftMargin, this.dmW ? com.baidu.adp.lib.util.k.c(TbadkCoreApplication.m411getInst(), t.e.ds20) : 0, layoutParams.rightMargin, this.dmX ? com.baidu.adp.lib.util.k.c(TbadkCoreApplication.m411getInst(), t.e.ds20) : 0);
        this.dkX.setLayoutParams(layoutParams);
    }

    public boolean ayP() {
        return this.dmY;
    }

    private boolean ayQ() {
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.userId);
    }

    private boolean f(com.baidu.tbadk.core.data.as asVar) {
        if (asVar == null || asVar.getAuthor() == null || asVar.getAuthor().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), asVar.getAuthor().getUserId());
    }

    public void a(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null) {
            this.dkF.azy();
            if (!StringUtils.isNull(dVar.forumName)) {
                this.dkF.kt(dVar.forumName);
            }
            String string = this.dfw.getResources().getString(t.j.thread_delete_by);
            String str = "";
            switch (com.baidu.adp.lib.h.b.g(dVar.source, 0)) {
                case 100:
                    str = this.dfw.getResources().getString(t.j.self);
                    break;
                case 300:
                    str = this.dfw.getResources().getString(t.j.bawu);
                    break;
                case 400:
                    str = this.dfw.getResources().getString(t.j.system);
                    break;
            }
            this.dfw.showNetRefreshView(this.cYO, String.format(string, str), null, this.dfw.getResources().getString(t.j.appeal_restore), true, new fk(this, dVar.dcF));
        }
    }

    public void a(com.baidu.tieba.pb.data.e eVar, int i, int i2, boolean z, int i3, boolean z2) {
        Parcelable ayb;
        Parcelable ayb2;
        String sb;
        if (eVar != null) {
            if (eVar.avv() != null) {
                this.dmn = eVar.avv().tl();
                this.VM = eVar.avv().ti();
                if (eVar.avv().getAnchorLevel() != 0) {
                    this.dmY = true;
                }
                this.dlS = f(eVar.avv());
            }
            if (eVar.getUserData() != null) {
                this.userId = eVar.getUserData().getUserId();
            }
            m(eVar);
            this.dmh = false;
            this.ddr = z;
            ayH();
            b(eVar, z, i);
            this.dlp.fS(this.ddr);
            this.dlp.a(eVar);
            this.dlp.notifyDataSetChanged();
            if (eVar.avu() != null) {
                this.mForumName = eVar.avu().getName();
                this.mForumId = eVar.getForumId();
            }
            this.dkF.kt(this.mForumName);
            if (eVar.avv() != null) {
                ma(com.baidu.tbadk.core.util.ay.A(eVar.avv().getReply_num()));
                if (eVar.avv().getPraise() != null) {
                    if (eVar.avv().getPraise().getNum() < 1) {
                        sb = this.dfw.getResources().getString(t.j.frs_item_praise_text);
                    } else {
                        sb = new StringBuilder(String.valueOf(eVar.avv().getPraise().getNum())).toString();
                    }
                    if (this.dkB != -1) {
                        eVar.avv().getPraise().setIsLike(this.dkB);
                    }
                    E(sb, eVar.avv().getPraise().getIsLike() == 1);
                }
            }
            if (eVar.getPage().sq() == 0 && !z) {
                this.bcd.setNextPage(null);
                this.dkE = 1;
            } else if (this.dfw.isLogin()) {
                this.bcd.setNextPage(this.dlu);
                this.dkE = 2;
                azf();
            } else if (eVar.getPage().sq() == 1) {
                this.dmh = true;
                if (this.dlv == null) {
                    this.dlv = new com.baidu.tieba.pb.view.b(this.dfw.getPageContext());
                }
                this.bcd.setNextPage(this.dlv);
                this.dkE = 3;
            }
            if (this.dfw.awE()) {
                if (this.dlt == null) {
                    this.dlt = new com.baidu.tieba.pb.view.m(this.dfw.getPageContext());
                    this.dlt.mZ();
                    this.dlt.a(this.agD);
                }
                this.bcd.setPullRefresh(this.dlt);
                if (this.dlt != null) {
                    this.dlt.dj(TbadkCoreApplication.m411getInst().getSkinType());
                }
            } else if (eVar.getPage().sr() == 0 && z) {
                this.bcd.setPullRefresh(null);
                this.dkC = 0;
                this.dmd.setVisibility(8);
            } else {
                if (this.dlt == null) {
                    this.dlt = new com.baidu.tieba.pb.view.m(this.dfw.getPageContext());
                    this.dlt.mZ();
                    this.dlt.a(this.agD);
                }
                this.bcd.setPullRefresh(this.dlt);
                this.dkC = 1;
                if (this.dlt != null) {
                    this.dlt.dj(TbadkCoreApplication.m411getInst().getSkinType());
                }
                this.dmd.setVisibility(0);
                azf();
            }
            ayR();
            ArrayList<com.baidu.tieba.tbadkCore.data.s> avw = eVar.avw();
            if (eVar.getPage().sq() == 0 || avw == null || avw.size() < eVar.getPage().sp()) {
                this.dlu.setText(this.dfw.getResources().getString(t.j.list_no_more));
                if (this.dfw.awE() && this.bcd != null && this.bcd.getData() != null && this.bcd.getData().size() == 1 && (this.bcd.getData().get(0) instanceof com.baidu.tieba.pb.data.f)) {
                    this.dlu.setText("");
                }
                l(eVar);
            } else if (z2) {
                if (this.dmV) {
                    xv();
                    if (eVar.getPage().sq() != 0) {
                        this.dlu.setText(this.dfw.getResources().getString(t.j.pb_load_more));
                    }
                } else {
                    this.dlu.showLoading();
                }
            } else {
                this.dlu.showLoading();
            }
            if (z) {
                this.dme.setVisibility(0);
                this.aLn.setVisibility(0);
                this.dmf.setText(this.dfw.getResources().getString(t.j.btn_show_passed_pb));
            } else {
                this.dme.setVisibility(8);
                this.aLn.setVisibility(8);
                this.dmf.setText(this.dfw.getResources().getString(t.j.btn_show_passed_pb_aftre));
            }
            if (eVar.avv() != null && eVar.avv().getAuthor() != null && eVar.avv().getAuthor().getType() == 0) {
                this.dkF.azv();
            }
            switch (i) {
                case 2:
                    this.bcd.setSelection(i2);
                    if (this.dkJ != null) {
                        CompatibleUtile.scrollListViewBy(this.bcd, -this.dkJ.getHeight(), 0);
                        break;
                    }
                    break;
                case 3:
                    if (i3 == 1 && (ayb2 = en.aya().ayb()) != null) {
                        this.bcd.onRestoreInstanceState(ayb2);
                        this.dmD = true;
                        break;
                    } else {
                        this.bcd.setSelection(0);
                        break;
                    }
                case 4:
                    this.dmV = false;
                    this.bcd.setSelection(0);
                    break;
                case 5:
                    this.bcd.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1 && (ayb = en.aya().ayb()) != null) {
                        this.bcd.onRestoreInstanceState(ayb);
                        this.dmD = true;
                        break;
                    } else {
                        this.bcd.setSelection(0);
                        break;
                    }
                    break;
            }
            if (this.dmn == dmp && ayQ()) {
                azj();
            }
        }
    }

    public void gu(boolean z) {
        this.dlR = z;
        this.dkF.gu(z);
    }

    public void xv() {
        if (this.dlu != null) {
            this.dlu.xv();
        }
        azf();
    }

    public void Mu() {
        this.bcd.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ayR() {
        boolean z;
        boolean z2 = true;
        if (this.dkJ != null && this.dkJ.getVisibility() == 0) {
            if (this.dli != null) {
                this.dli.setVisibility(0);
                z = true;
            } else {
                z = true;
            }
        } else {
            if (this.dli != null) {
                this.dli.setVisibility(8);
            }
            z = false;
        }
        if (this.dlU != null && this.dlU.getVisibility() == 0) {
            if (this.dlj != null) {
                this.dlj.setVisibility(0);
            }
        } else {
            if (this.dlj != null) {
                this.dlj.setVisibility(8);
            }
            z2 = z;
        }
        if ((this.dll == null || this.dll.getVisibility() == 8) && z2 && this.ddr) {
            this.dlk.setVisibility(0);
        } else {
            this.dlk.setVisibility(8);
        }
        com.baidu.tieba.graffiti.d.af(this.dlk);
        return z2;
    }

    public boolean a(com.baidu.tieba.pb.data.e eVar, boolean z, boolean z2) {
        if (eVar == null) {
            return false;
        }
        if (this.dkN != null) {
            if (eVar.avv().tA() == 0 && !eVar.avv().tO() && !this.dmN) {
                this.dkN.setVisibility(0);
                eVar.avv().tM();
                this.dkN.setText(eVar.avv().getSpan_str());
            } else {
                this.dkN.setVisibility(8);
                this.dmW = true;
                ayO();
            }
        }
        this.ddr = z;
        com.baidu.tbadk.core.data.as avv = eVar.avv();
        if (avv != null) {
            a(avv.tp());
        }
        if (eVar.avB() == 1) {
            ayS();
            Button button = (Button) this.dkI.findViewById(t.g.pb_head_function_manage_commit_top);
            Button button2 = (Button) this.dkI.findViewById(t.g.pb_head_function_manage_cancel_top);
            Button button3 = (Button) this.dkI.findViewById(t.g.pb_head_function_manage_commit_good);
            Button button4 = (Button) this.dkI.findViewById(t.g.pb_head_function_manage_cancel_good);
            button.setOnClickListener(this.boQ);
            button2.setOnClickListener(this.boQ);
            button3.setOnClickListener(this.boQ);
            button4.setOnClickListener(this.boQ);
            if (eVar.avv().getIs_good() == 1) {
                button3.setVisibility(8);
                button4.setVisibility(0);
            } else {
                button3.setVisibility(0);
                button4.setVisibility(8);
            }
            if (eVar.avv().getIs_top() == 1) {
                button.setVisibility(8);
                button2.setVisibility(0);
            } else {
                button.setVisibility(0);
                button2.setVisibility(8);
            }
            if (eVar.avv().tU() && eVar.avv().tG() == 2) {
                button.setEnabled(false);
                com.baidu.tbadk.core.util.at.j((View) button, t.d.cp_cont_d);
            }
            return true;
        }
        return false;
    }

    private void ayS() {
        if (this.dkJ == null) {
            this.dkJ = ((ViewStub) this.dkI.findViewById(t.g.pb_header_function_manage)).inflate();
            this.dfw.getLayoutMode().x(this.dkJ);
            this.dli = this.dkI.findViewById(t.g.new_pb_header_item_line_above_manage);
            return;
        }
        this.dkJ.setVisibility(0);
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
                if (eVar.avB() != 0 && a.getAuthor() != null) {
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
                    String userId3 = eVar.avv().getAuthor().getUserId();
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
                    sparseArray.put(t.g.tag_manage_user_identity, Integer.valueOf(eVar.avB()));
                    sparseArray.put(t.g.tag_should_manage_visible, true);
                    a(t.j.manage, sparseArray);
                } else if (z4) {
                    SparseArray<Object> sparseArray2 = new SparseArray<>();
                    sparseArray2.put(t.g.tag_del_post_id, a.getId());
                    sparseArray2.put(t.g.tag_del_post_type, 0);
                    sparseArray2.put(t.g.tag_del_post_is_self, Boolean.valueOf(z3));
                    sparseArray2.put(t.g.tag_manage_user_identity, Integer.valueOf(eVar.avB()));
                    sparseArray2.put(t.g.tag_should_manage_visible, false);
                    a(t.j.delete, sparseArray2);
                }
            }
            ayR();
        }
    }

    private void a(int i, SparseArray<Object> sparseArray) {
        ayS();
        Button button = (Button) this.dkI.findViewById(t.g.pb_head_function_manage_delormanage);
        button.setOnClickListener(this.boQ);
        button.setVisibility(0);
        button.setText(i);
        button.setTag(sparseArray);
    }

    public View getNextView() {
        return this.aAj;
    }

    public void mb(String str) {
        if (this.dlu != null && !StringUtils.isNull(str)) {
            this.dlu.setText(str);
        }
    }

    public BdListView Mg() {
        return this.bcd;
    }

    public int ayT() {
        return t.g.richText;
    }

    public int RV() {
        return t.g.user_icon_box;
    }

    public Button ayU() {
        return (Button) this.dkI.findViewById(t.g.pb_head_function_manage_commit_good);
    }

    public Button ayV() {
        return (Button) this.dkI.findViewById(t.g.pb_head_function_manage_cancel_good);
    }

    public Button ayW() {
        return (Button) this.dkI.findViewById(t.g.pb_head_function_manage_commit_top);
    }

    public Button ayX() {
        return (Button) this.dkI.findViewById(t.g.pb_head_function_manage_cancel_top);
    }

    public TextView ayY() {
        return this.dkL;
    }

    public void c(BdListView.e eVar) {
        this.bcd.setOnSrollToBottomListener(eVar);
    }

    public void a(BdListView.h hVar) {
        this.bcd.setOnSrollToTopListener(hVar);
    }

    public void a(s.a aVar) {
        this.agD = aVar;
        if (this.dlt != null) {
            this.dlt.a(aVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.ac acVar, a.b bVar) {
        if (acVar != null) {
            int so = acVar.so();
            int sl = acVar.sl();
            if (this.dlq != null) {
                this.dlq.up();
            } else {
                this.dlq = new com.baidu.tbadk.core.dialog.a(this.dfw.getPageContext().getPageActivity());
                this.dlr = LayoutInflater.from(this.dfw.getPageContext().getPageActivity()).inflate(t.h.dialog_direct_pager, (ViewGroup) null);
                this.dlq.z(this.dlr);
                this.dlq.a(t.j.dialog_ok, bVar);
                this.dlq.b(t.j.dialog_cancel, new fl(this));
                this.dlq.a(new fm(this));
                this.dlq.b(this.dfw.getPageContext()).up();
            }
            this.dls = (EditText) this.dlr.findViewById(t.g.input_page_number);
            this.dls.setText("");
            TextView textView = (TextView) this.dlr.findViewById(t.g.current_page_number);
            if (so <= 0) {
                so = 1;
            }
            if (sl <= 0) {
                sl = 1;
            }
            textView.setText(MessageFormat.format(this.dfw.getApplicationContext().getResources().getString(t.j.current_page), Integer.valueOf(so), Integer.valueOf(sl)));
            this.dfw.ShowSoftKeyPadDelay(this.dls, 150);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.bcd.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.dfw.showToast(str);
    }

    public boolean gv(boolean z) {
        if (this.LE == null || !this.LE.Dk()) {
            return false;
        }
        this.LE.BD();
        return true;
    }

    public void ayZ() {
        if (this.dmZ != null) {
            while (this.dmZ.size() > 0) {
                TbImageView remove = this.dmZ.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        ayZ();
    }

    public void onDestroy() {
        this.dfw.hideProgressBar();
        if (this.baT != null && this.bit != null) {
            this.baT.b(this.bit);
        }
        amI();
        this.dlu.xv();
        if (this.dmv != null) {
            com.baidu.adp.lib.h.h.hx().removeCallbacks(this.dmv);
        }
        if (this.dmw != null) {
            com.baidu.adp.lib.h.h.hx().removeCallbacks(this.dmw);
        }
        azg();
        if (this.dmM != null) {
            this.dmM.removeAllViews();
        }
        if (this.dkM != null && this.djZ != null) {
            this.dkM.removeView(this.djZ);
            this.djZ = null;
        }
        this.dmQ = null;
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public void amI() {
        this.dkF.pZ();
        com.baidu.adp.lib.util.k.c(this.dfw.getPageContext().getPageActivity(), this.dls);
        if (this.dlQ != null) {
            this.dlQ.dismiss();
        }
        aza();
    }

    public void fQ(boolean z) {
        this.dlp.fQ(z);
    }

    public void fR(boolean z) {
        this.ddp = z;
        this.dlp.fR(z);
    }

    public void eL(boolean z) {
        this.cCe = z;
    }

    public void aza() {
        if (this.dlz != null) {
            this.dlz.dismiss();
        }
        if (this.dlA != null) {
            com.baidu.adp.lib.h.j.b(this.dlA, this.dfw.getPageContext());
        }
        if (this.dlJ != null) {
            com.baidu.adp.lib.h.j.b(this.dlJ, this.dfw.getPageContext());
        }
        if (this.dlx != null) {
            com.baidu.adp.lib.h.j.b(this.dlx, this.dfw.getPageContext());
        }
    }

    public void onChangeSkinType(int i) {
        this.dfw.getLayoutMode().ab(i == 1);
        this.dfw.getLayoutMode().x(this.cYO);
        this.dfw.getLayoutMode().x(this.dkK);
        this.dfw.getLayoutMode().x(this.dkI);
        this.dfw.getLayoutMode().x(this.aAj);
        com.baidu.tbadk.core.util.at.b(this.dkZ, t.d.cp_cont_g, 1);
        this.dkF.mNavigationBar.onChangeSkinType(this.dfw.getPageContext(), i);
        com.baidu.tbadk.core.util.at.a(this.dkF.dnH, t.f.btn_more_selector_s, t.f.btn_more_selector);
        com.baidu.tbadk.core.util.at.a(this.dkF.dnI, t.f.icon_floor_addition_selector, t.f.icon_floor_addition_selector);
        if (this.dlr != null) {
            this.dfw.getLayoutMode().x(this.dlr);
        }
        gu(this.dlR);
        this.dlp.notifyDataSetChanged();
        if (this.dlt != null) {
            this.dlt.dj(i);
        }
        if (this.dlu != null) {
            this.dlu.dj(i);
            com.baidu.tbadk.core.util.at.k(this.aAj, t.f.pb_foot_more_trans_selector);
            this.dlu.dh(t.f.pb_foot_more_trans_selector);
        }
        if (this.LE != null) {
            this.LE.onChangeSkinType(i);
        }
        if (this.dle != null) {
            this.dle.dn(i);
        }
        if (this.dlv != null) {
            this.dlv.dj(i);
        }
        if (this.dkH != null && this.dkH.size() > 0) {
            for (com.baidu.tieba.pb.pb.main.b.a aVar : this.dkH) {
                aVar.azt();
            }
        }
        if (this.dmM != null) {
            com.baidu.tbadk.core.util.at.l(this.dmM, t.d.cp_bg_line_d);
            com.baidu.tbadk.core.util.at.l(this.dmI, t.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.at.b(this.dmL, t.d.cp_cont_c, 1);
        }
        gn(i == 1);
        if (this.dmm != null) {
            this.dmm.changeSkinType(i);
        }
        ayp();
    }

    public void setOnImageClickListener(TbRichTextView.d dVar) {
        this.aJc = dVar;
        this.dlp.setOnImageClickListener(this.aJc);
    }

    public void f(NoNetworkView.a aVar) {
        this.bit = aVar;
        if (this.baT != null) {
            this.baT.a(this.bit);
        }
    }

    public void gw(boolean z) {
        this.dlp.setIsFromCDN(z);
        this.mIsFromCDN = z;
    }

    public Button azb() {
        return this.dlU;
    }

    public void l(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null) {
            ArrayList<com.baidu.tieba.tbadkCore.data.s> avw = eVar.avw();
            if (avw.size() == 1) {
                com.baidu.tieba.tbadkCore.data.s sVar = avw.get(0);
                if (sVar.aTy() < sVar.aTr().size()) {
                    if (this.dkE != 1) {
                        this.bcd.setNextPage(null);
                        this.dkE = 1;
                    }
                } else if (this.dkE != 2) {
                    this.bcd.setNextPage(this.dlu);
                    this.dkE = 2;
                }
            } else if (this.dkE != 2) {
                this.bcd.setNextPage(this.dlu);
                this.dkE = 2;
            }
        }
    }

    public void azc() {
        if (com.baidu.tbadk.performanceLog.aa.GU().GV()) {
            int lastVisiblePosition = this.bcd.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.bcd.getChildAt(i);
                if (childAt != null) {
                    TbRichTextView tbRichTextView = (TbRichTextView) childAt.findViewById(t.g.richText);
                    if (tbRichTextView != null) {
                        for (int i2 = 0; i2 < tbRichTextView.getChildCount(); i2++) {
                            View childAt2 = tbRichTextView.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.performanceLog.u perfLog = tbImageView.getPerfLog();
                                perfLog.fh(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
                                perfLog.aBs = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr = new int[2];
                                    tbRichTextView.getLocationOnScreen(iArr);
                                    if (iArr[1] > com.baidu.adp.lib.util.k.C(TbadkCoreApplication.m411getInst().getContext())) {
                                    }
                                }
                                tbImageView.xi();
                            }
                        }
                    }
                    HeadImageView headImageView = (HeadImageView) childAt.findViewById(t.g.photo);
                    if (headImageView != null) {
                        com.baidu.tbadk.performanceLog.u perfLog2 = headImageView.getPerfLog();
                        perfLog2.fh(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
                        perfLog2.aBs = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr2 = new int[2];
                            headImageView.getLocationOnScreen(iArr2);
                            if (iArr2[1] > com.baidu.adp.lib.util.k.C(TbadkCoreApplication.m411getInst().getContext())) {
                            }
                        }
                        headImageView.xi();
                    }
                }
            }
        }
    }

    public void eM(boolean z) {
        if (this.dlV != null && this.dlV != null) {
            if (this.cCe) {
                eN(z);
            } else {
                eO(z);
            }
        }
    }

    public void azd() {
        if (this.dlV != null) {
            this.dlV.setVisibility(8);
        }
    }

    public TextView aze() {
        return this.dme;
    }

    public void akp() {
        if (this.dmg == null) {
            this.dmg = new com.baidu.tbadk.core.view.b(this.dfw.getPageContext());
        }
        this.dmg.ay(true);
    }

    public void azf() {
        if (this.dmg != null) {
            this.dmg.ay(false);
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
        fo foVar = new fo(this, str, new com.baidu.tbadk.coreExtra.d.a(null), author);
        this.dkM.setPadding(TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds32), TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds20), TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds32), 0);
        if (sVar.getType() == null || sVar.getType().getId() != com.baidu.tieba.tbadkCore.data.s.UX.getId()) {
            this.dkI.setPadding(0, TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds34), 0, 0);
        }
        int dimensionPixelSize = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds76);
        if (this.dkP.getLayoutParams() == null) {
            aVar = new ColumnLayout.a(dimensionPixelSize, dimensionPixelSize);
        } else {
            ColumnLayout.a aVar2 = (ColumnLayout.a) this.dkP.getLayoutParams();
            aVar2.width = dimensionPixelSize;
            aVar2.height = dimensionPixelSize;
            aVar = aVar2;
        }
        this.dkP.setLayoutParams(aVar);
        this.dkP.setVisibility(8);
        View findViewWithTag = this.dkM.findViewWithTag("pb_god_head_image_view_tag");
        if (!(findViewWithTag instanceof ClickableHeaderImageView)) {
            this.djZ = new ClickableHeaderImageView(this.dfw.getApplicationContext());
            this.djZ.setGodIconMargin(0);
            this.djZ.setTag("pb_god_head_image_view_tag");
            this.djZ.setUserId(String.valueOf(userIdLong));
            this.djZ.setUserName(userName);
            this.dkM.addView(this.djZ, 0, aVar);
        } else {
            this.djZ = (ClickableHeaderImageView) findViewWithTag;
        }
        fp fpVar = new fp(this, sVar);
        this.dkM.setTag(t.g.tag_user_id, String.valueOf(userIdLong));
        this.dkM.setTag(t.g.tag_user_name, userName);
        this.dkM.setOnClickListener(fpVar);
        this.dkK.setTag(t.g.tag_user_id, String.valueOf(userIdLong));
        this.dkK.setTag(t.g.tag_user_name, userName);
        this.dkK.setOnClickListener(fpVar);
        if (this.ddp) {
            this.djZ.setVisibility(0);
            this.djZ.setOnClickListener(fpVar);
            this.djZ.c(portrait, 28, false);
        } else {
            this.djZ.setVisibility(8);
        }
        if (this.dla == null) {
            this.dla = new TextView(this.dfw.getActivity());
            this.dla.setClickable(false);
            this.dla.setIncludeFontPadding(false);
            this.dla.setGravity(16);
            this.dla.setTextSize(0, this.dfw.getResources().getDimensionPixelSize(t.e.fontsize24));
            ColumnLayout.a aVar3 = new ColumnLayout.a(-2, -2, 3, 2);
            aVar3.topMargin = this.dfw.getResources().getDimensionPixelSize(t.e.ds8);
            aVar3.bottomMargin = this.dfw.getResources().getDimensionPixelSize(t.e.ds10);
            this.dla.setSingleLine(true);
            com.baidu.tbadk.core.util.at.b(this.dla, t.d.cp_cont_d, 1);
            this.dkM.addView(this.dla, -1, aVar3);
        }
        String format = String.format(this.dfw.getResources().getString(t.j.fans_default_name_god_user), com.baidu.tbadk.core.util.ay.z(fansNum));
        this.dla.setText(format);
        this.dla.setTag(t.g.tag_user_id, String.valueOf(userIdLong));
        this.dla.setTag(t.g.tag_user_name, userName);
        this.dla.setOnClickListener(fpVar);
        if (this.dlb == null) {
            this.dlb = new TextView(this.dfw.getActivity());
            this.dlb.setClickable(false);
            this.dlb.setTextSize(0, this.dfw.getResources().getDimensionPixelSize(t.e.fontsize24));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            this.dlb.setSingleLine(true);
            this.dlb.setPadding(this.dfw.getResources().getDimensionPixelSize(t.e.ds32), 0, this.dfw.getResources().getDimensionPixelSize(t.e.ds128), 0);
            this.dlb.setEllipsize(TextUtils.TruncateAt.END);
            this.dlb.setTag(t.g.tag_user_id, String.valueOf(userIdLong));
            this.dlb.setTag(t.g.tag_user_name, userName);
            com.baidu.tbadk.core.util.at.b(this.dlb, t.d.cp_cont_d, 1);
            this.dkK.addView(this.dlb, layoutParams);
        }
        String string = this.dfw.getResources().getString(t.j.tieba_certification);
        String format2 = StringUtils.isNull(godUserData.getIntro()) ? String.format(string, this.dfw.getResources().getString(t.j.god_intro_default)) : String.format(string, godUserData.getIntro());
        this.dlb.setOnClickListener(fpVar);
        this.dlb.setText(format2);
        this.dkW.setVisibility(8);
        if (this.dlc == null) {
            this.dlc = new TextView(this.dfw.getActivity());
            this.dlc.setTextSize(0, this.dfw.getResources().getDimensionPixelSize(t.e.fontsize24));
            this.dlc.setGravity(17);
            this.dlc.setOnClickListener(foVar);
            ColumnLayout.a aVar4 = new ColumnLayout.a(this.dfw.getResources().getDimensionPixelSize(t.e.ds110), this.dfw.getResources().getDimensionPixelSize(t.e.ds50), 80, 3);
            aVar4.bottomMargin = this.dfw.getResources().getDimensionPixelSize(t.e.ds22);
            this.dkM.addView(this.dlc, -1, aVar4);
        }
        a(this.dlc, godUserData.getFollowed() == 1);
        if (this.dlS || (godUserData.getFollowed() == 1 && godUserData.getIsFromNetWork())) {
            this.dlc.setVisibility(8);
        } else {
            this.dlc.setVisibility(0);
        }
        if (this.dkK.findViewWithTag("pb_god_bottom_line_view_tag") == null) {
            View view = new View(this.dfw.getApplicationContext());
            view.setTag("pb_god_bottom_line_view_tag");
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, this.dfw.getResources().getDimensionPixelSize(t.e.ds1));
            layoutParams2.topMargin = this.dfw.getResources().getDimensionPixelSize(t.e.ds18);
            layoutParams2.bottomMargin = this.dfw.getResources().getDimensionPixelSize(t.e.ds1);
            com.baidu.tbadk.core.util.at.l(view, t.d.cp_bg_line_a);
            this.dkK.addView(view, layoutParams2);
        }
        if (this.dmF == null) {
            this.dmF = new TextView(this.dfw.getApplicationContext());
            this.dmF.setId(t.g.pb_god_user_tip_content);
            this.dmF.setEllipsize(TextUtils.TruncateAt.END);
            this.dmF.setGravity(17);
            this.dmF.setSingleLine(true);
            this.dmF.setHeight(this.dfw.getResources().getDimensionPixelSize(t.e.ds56));
            this.dmF.setTextSize(0, this.dfw.getResources().getDimensionPixelSize(t.e.fontsize24));
            this.dmF.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams3.addRule(3, t.g.title_wrapper);
            this.cYO.addView(this.dmF, layoutParams3);
            this.dfw.getLayoutMode().x(this.dmF);
        }
        com.baidu.tbadk.core.util.at.k(this.dmF, t.d.cp_link_tip_a_alpha80);
        com.baidu.tbadk.core.util.at.j((View) this.dmF, t.d.cp_cont_g);
        this.dmF.setOnClickListener(new fr(this));
        this.dmF.setText(String.format(this.dfw.getResources().getString(t.j.god_user_floor_owner_tip), com.baidu.tbadk.core.util.ay.z(this.dmG)));
        mk(this.dmG);
        if (this.dmE == null) {
            this.dmE = (LinearLayout) LayoutInflater.from(this.dfw.getActivity()).inflate(t.h.god_floating_view, (ViewGroup) null);
            this.dmE.setOnClickListener(fpVar);
            this.dmE.setTag(t.g.tag_user_id, String.valueOf(userIdLong));
            this.dmE.setTag(t.g.tag_user_name, userName);
            ClickableHeaderImageView clickableHeaderImageView = (ClickableHeaderImageView) this.dmE.findViewById(t.g.god_floating_owner_photo);
            clickableHeaderImageView.setGodIconMargin(0);
            clickableHeaderImageView.setOnClickListener(fpVar);
            if (!this.ddp) {
                clickableHeaderImageView.setVisibility(8);
            }
            clickableHeaderImageView.setTag(sVar.getAuthor().getUserId());
            clickableHeaderImageView.c(sVar.getAuthor().getPortrait(), 28, false);
            View findViewById = this.dmE.findViewById(t.g.god_floating_owner_info_floor_owner);
            if (str2 != null && !str2.equals("0") && str2.equals(sVar.getAuthor().getUserId())) {
                findViewById.setVisibility(0);
            } else {
                findViewById.setVisibility(8);
            }
            ImageView imageView = (ImageView) this.dmE.findViewById(t.g.god_floating_owner_info_user_rank);
            int level_id = sVar.getAuthor().getLevel_id();
            int is_bawu = sVar.getAuthor().getIs_bawu();
            String bawu_type = sVar.getAuthor().getBawu_type();
            int i = 3;
            if (level_id != 0) {
                imageView.setVisibility(0);
                com.baidu.tbadk.core.util.at.c(imageView, BitmapHelper.getGradeResourceIdNew(level_id));
                imageView.setContentDescription(String.format(TbadkCoreApplication.m411getInst().getString(t.j.degree_in_forum), Integer.valueOf(level_id)));
                imageView.setOnClickListener(null);
            } else {
                imageView.setVisibility(8);
            }
            ImageView imageView2 = (ImageView) this.dmE.findViewById(t.g.god_floating_owner_info_user_bawu);
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
            ImageView imageView3 = (ImageView) this.dmE.findViewById(t.g.god_floating_owner_info_user_gender);
            if (sVar.getAuthor().getGender() == 2) {
                com.baidu.tbadk.core.util.at.c(imageView3, t.f.icon_pb_pop_girl);
                imageView3.setVisibility(0);
            } else if (sVar.getAuthor().getGender() == 1) {
                com.baidu.tbadk.core.util.at.c(imageView3, t.f.icon_pb_pop_boy);
                imageView3.setVisibility(0);
            } else {
                imageView3.setVisibility(8);
            }
            if (!StringUtils.isNull(sVar.getAuthor().getName_show()) && com.baidu.adp.lib.util.j.aW(sVar.getAuthor().getName_show()) > 14) {
                i = 0;
            }
            ArrayList<IconData> iconInfo = sVar.getAuthor().getIconInfo();
            ArrayList<IconData> tShowInfoNew = sVar.getAuthor().getTShowInfoNew();
            UserIconBox userIconBox = (UserIconBox) this.dmE.findViewById(t.g.god_floating_owner_info_user_icon);
            UserIconBox userIconBox2 = (UserIconBox) this.dmE.findViewById(t.g.god_floating_owner_info_tshow_icon);
            if (userIconBox != null) {
                userIconBox.setTag(t.g.tag_user_id, sVar.getAuthor().getUserId());
                userIconBox.setOnClickListener(this.dfw.dgG.bpv);
                userIconBox.a(iconInfo, i, this.dfw.getResources().getDimensionPixelSize(t.e.pb_icon_width), this.dfw.getResources().getDimensionPixelSize(t.e.pb_icon_height), this.dfw.getResources().getDimensionPixelSize(t.e.pb_icon_margin));
            }
            if (userIconBox2 != null) {
                userIconBox2.setOnClickListener(this.dfw.dgG.dnx);
                userIconBox2.a(tShowInfoNew, 3, this.dfw.getResources().getDimensionPixelSize(t.e.small_icon_width), this.dfw.getResources().getDimensionPixelSize(t.e.small_icon_height), this.dfw.getResources().getDimensionPixelSize(t.e.big_icon_margin), true);
            }
            TextView textView = (TextView) this.dmE.findViewById(t.g.god_floating_owner_info_user_name);
            if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                com.baidu.tbadk.core.util.at.b(textView, t.d.cp_cont_h, 1);
            } else {
                com.baidu.tbadk.core.util.at.b(textView, t.d.cp_cont_f, 1);
            }
            textView.setText(sVar.getAuthor().getName_show());
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams4.addRule(3, t.g.title_wrapper);
            this.cYO.addView(this.dmE, layoutParams4);
            this.dfw.getLayoutMode().x(this.dmE);
        }
        TextView textView2 = (TextView) this.dmE.findViewById(t.g.god_floating_gift);
        textView2.setOnClickListener(foVar);
        a(textView2, godUserData.getFollowed() == 1);
        ImageView imageView4 = (ImageView) this.dmE.findViewById(t.g.god_floating_arrow);
        com.baidu.tbadk.core.util.at.c(imageView4, t.f.icon_arrow_tab);
        if (this.dlS || (godUserData.getFollowed() == 1 && godUserData.getIsFromNetWork())) {
            textView2.setVisibility(8);
            imageView4.setVisibility(0);
        } else {
            textView2.setVisibility(0);
            imageView4.setVisibility(8);
        }
        TextView textView3 = (TextView) this.dmE.findViewById(t.g.god_floating_intro);
        if (textView3 != null) {
            textView3.setText(format);
        }
        this.dmM = this.dlu.xr();
        if (this.dmM != null && !this.dlS && !z && z2 && (godUserData.getFollowed() != 1 || !godUserData.getIsFromNetWork())) {
            this.dlu.xs();
            this.dlu.xq();
            this.dmI = this.dmM.findViewWithTag("pb_god_bottom_extra_line_view_tag");
            if (this.dmI == null) {
                this.dmI = new View(this.dfw.getApplicationContext());
                this.dmI.setTag("pb_god_bottom_extra_line_view_tag");
                this.dmM.addView(this.dmI, new LinearLayout.LayoutParams(-1, this.dfw.getResources().getDimensionPixelSize(t.e.ds20)));
                this.dmK = new ClickableHeaderImageView(this.dfw.getApplicationContext());
                this.dmK.setGodIconMargin(0);
                this.dmK.setTag("pb_god_bottom_extra_god_avatar_tag");
                this.dmK.c(portrait, 28, false);
                this.dmK.setUserId(String.valueOf(userIdLong));
                this.dmK.setUserName(userName);
                this.dmK.setOnClickListener(fpVar);
                LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(this.dfw.getResources().getDimensionPixelSize(t.e.ds130), this.dfw.getResources().getDimensionPixelSize(t.e.ds130));
                layoutParams5.topMargin = this.dfw.getResources().getDimensionPixelSize(t.e.ds40);
                layoutParams5.gravity = 1;
                this.dmM.addView(this.dmK, layoutParams5);
                this.dmL = new TextView(this.dfw.getApplicationContext());
                this.dmL.setTag("pb_god_bottom_extra_text_view_tag");
                this.dmL.setSingleLine(true);
                this.dmL.setTextSize(0, this.dfw.getResources().getDimensionPixelSize(t.e.fontsize24));
                LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams6.topMargin = this.dfw.getResources().getDimensionPixelSize(t.e.ds36);
                layoutParams6.gravity = 1;
                this.dmL.setText(this.dfw.getResources().getString(t.j.god_user_attention_tip));
                this.dmM.addView(this.dmL, layoutParams6);
                this.dmJ = new TextView(this.dfw.getApplicationContext());
                this.dmJ.setTag("pb_god_bottom_extra_attention_btn_tag");
                this.dmJ.setSingleLine(true);
                this.dmJ.setGravity(17);
                this.dmJ.setTextSize(0, this.dfw.getResources().getDimensionPixelSize(t.e.fontsize24));
                this.dmJ.setOnClickListener(foVar);
                LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(this.dfw.getResources().getDimensionPixelSize(t.e.ds212), this.dfw.getResources().getDimensionPixelSize(t.e.ds54));
                layoutParams7.topMargin = this.dfw.getResources().getDimensionPixelSize(t.e.ds30);
                layoutParams7.bottomMargin = this.dfw.getResources().getDimensionPixelSize(t.e.ds40);
                layoutParams7.gravity = 1;
                this.dmM.addView(this.dmJ, layoutParams7);
            } else {
                this.dmJ = (TextView) this.dmM.findViewWithTag("pb_god_bottom_extra_attention_btn_tag");
                this.dmK = (ClickableHeaderImageView) this.dmM.findViewWithTag("pb_god_bottom_extra_god_avatar_tag");
                this.dmL = (TextView) this.dmM.findViewWithTag("pb_god_bottom_extra_text_view_tag");
                this.dmI = this.dmM.findViewWithTag("pb_god_bottom_extra_line_view_tag");
            }
            com.baidu.tbadk.core.util.at.l(this.dmM, t.d.cp_bg_line_d);
            com.baidu.tbadk.core.util.at.l(this.dmI, t.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.at.b(this.dmL, t.d.cp_cont_c, 1);
            this.dmM.setOnTouchListener(new fs(this));
            boolean z3 = godUserData.getFollowed() == 1;
            a(this.dmJ, z3);
            if (!z3) {
                this.dmJ.setPadding(this.dfw.getResources().getDimensionPixelSize(t.e.ds68), 0, this.dfw.getResources().getDimensionPixelSize(t.e.ds52), 0);
            }
        } else {
            this.dlu.xt();
            this.dlu.xp();
        }
        return true;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.dmz && !this.dmA && i > this.dkC) {
            this.dmC = true;
        } else {
            this.dmC = false;
            azh();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL));
    }

    private void mk(int i) {
        boolean z;
        if (this.dmF != null && this.dmF.getVisibility() != 0 && i >= 2 && !this.dlS) {
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                z = com.baidu.tbadk.core.sharedPref.b.vk().getBoolean("pb_god_floor_owner_tip_has_shown_" + TbadkCoreApplication.getCurrentAccount(), false);
            } else {
                z = com.baidu.tbadk.core.sharedPref.b.vk().getBoolean("pb_god_floor_owner_not_login_tip_has_shown_" + TbadkCoreApplication.getCurrentAccount(), false);
            }
            if (!z) {
                this.dmH = true;
                this.dmF.setVisibility(0);
            }
            com.baidu.adp.lib.h.h.hx().postDelayed(this.dnb, 3000L);
        }
    }

    public void azg() {
        com.baidu.adp.lib.h.h.hx().removeCallbacks(this.dnb);
        if (this.dmF != null && 8 != this.dmF.getVisibility()) {
            com.baidu.tieba.tbadkCore.a.a(this.dfw, this.dmF, t.a.fade_out, new ft(this));
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                com.baidu.tbadk.core.sharedPref.b.vk().putBoolean("pb_god_floor_owner_tip_has_shown_" + TbadkCoreApplication.getCurrentAccount(), true);
            } else {
                com.baidu.tbadk.core.sharedPref.b.vk().putBoolean("pb_god_floor_owner_not_login_tip_has_shown_" + TbadkCoreApplication.getCurrentAccount(), true);
            }
        }
    }

    public void azh() {
        if (this.dmE != null && this.dmE.getVisibility() != 8) {
            this.dmE.setVisibility(8);
        }
    }

    public void azi() {
        if (this.dmz && this.dmC && !this.dmB && this.dmE != null && this.dmE.getVisibility() != 0 && !this.dmH) {
            this.dmB = true;
            if (this.dmD) {
                this.dmE.setVisibility(0);
                this.dmD = false;
                this.dmB = false;
                return;
            }
            com.baidu.tieba.tbadkCore.a.a(this.dfw, this.dmE, t.a.fade_in_10to100, new fu(this));
        }
    }

    public void azj() {
        if (!this.dna) {
            TiebaStatic.log("c10490");
            this.dna = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dfw.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(dmq, Integer.valueOf(dms));
            aVar.bZ(t.j.grade_thread_tips);
            View inflate = LayoutInflater.from(this.dfw.getPageContext().getPageActivity()).inflate(t.h.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(t.g.function_description_view)).setText(t.j.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(t.g.title_view)).setText(t.j.grade_thread_tips);
            aVar.z(inflate);
            aVar.x(sparseArray);
            aVar.a(t.j.grade_button_tips, this.dfw);
            aVar.b(t.j.look_again, new fv(this));
            aVar.b(this.dfw.getPageContext()).up();
        }
    }

    public void azk() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dfw.getPageContext().getPageActivity());
        aVar.cC(this.dfw.getResources().getString(t.j.upgrade_to_new_photo_live_tips));
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(dmq, Integer.valueOf(dmu));
        aVar.x(sparseArray);
        aVar.a(t.j.upgrade_to_new, this.dfw);
        aVar.b(t.j.cancel, new fw(this));
        aVar.b(this.dfw.getPageContext()).up();
    }

    public int tl() {
        return this.dmn;
    }

    public void mc(String str) {
        if (str.contains("_")) {
            str = str.replace("_", "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dfw.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.dfw.getPageContext().getPageActivity()).inflate(t.h.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(t.g.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(t.g.function_description_view)).setVisibility(8);
        aVar.z(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(dmq, Integer.valueOf(dmt));
        aVar.x(sparseArray);
        aVar.a(t.j.view, this.dfw);
        aVar.b(t.j.cancel, new fx(this));
        aVar.b(this.dfw.getPageContext()).up();
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

    private void a(TextView textView, boolean z) {
        if (z) {
            textView.setClickable(false);
            com.baidu.tbadk.core.util.at.b(textView, t.d.cp_cont_d, 1);
            textView.setText(TbadkCoreApplication.m411getInst().getString(t.j.relate_forum_is_followed));
            textView.setBackgroundDrawable(null);
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setPadding(0, 0, 0, 0);
            return;
        }
        com.baidu.tbadk.core.util.at.b(textView, t.d.btn_forum_focus_color, 1);
        textView.setText(TbadkCoreApplication.m411getInst().getString(t.j.forum_list_attention_tv));
        com.baidu.tbadk.core.util.at.k(textView, t.f.btn_focus_border_bg);
        textView.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.at.getDrawable(t.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        textView.setClickable(true);
        textView.setPadding(TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds18), 0, TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds10), 0);
    }

    public LinearLayout azl() {
        return this.dmk;
    }

    private void m(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.avv() != null && eVar.avv().tU()) {
            int tG = eVar.avv().tG();
            this.dmk.setVisibility(0);
            switch (tG) {
                case 1:
                    this.dml.setText(this.dfw.getPageContext().getPageActivity().getString(t.j.interview_live_before_start));
                    return;
                case 2:
                    this.dml.setText(this.dfw.getPageContext().getPageActivity().getString(t.j.interview_live_start));
                    return;
                case 3:
                    this.dml.setText(this.dfw.getPageContext().getPageActivity().getString(t.j.interview_live_finished));
                    return;
                default:
                    this.dmk.setVisibility(8);
                    return;
            }
        }
    }

    public RelativeLayout azm() {
        return this.dln;
    }

    public boolean awe() {
        return this.dmN;
    }

    public void azn() {
        this.mHandler.postDelayed(new fy(this), 50L);
    }

    public void gx(boolean z) {
        if (z) {
            this.dkL.setText(t.j.push);
            com.baidu.tbadk.core.util.at.j((View) this.dkL, t.f.push_text_selector);
            com.baidu.tbadk.core.util.at.k(this.dkL, t.f.push_bg_selector);
            this.dkL.setClickable(true);
        } else {
            this.dkL.setText(t.j.already_push);
            com.baidu.tbadk.core.util.at.k(this.dkL, t.f.label_bg_gray80);
            com.baidu.tbadk.core.util.at.j((View) this.dkL, t.d.cp_cont_d);
            this.dkL.setClickable(false);
        }
        this.dkL.setVisibility(0);
    }

    private void azo() {
        if (this.dmN) {
            if (this.dmP == null) {
                this.dmP = new com.baidu.tieba.pb.pb.b.b(this.dfw);
                this.bcd.f(this.dmP.avZ(), 0);
            }
            this.dkK.setVisibility(8);
            this.bcd.removeHeaderView(this.dkK);
            return;
        }
        this.dkK.setVisibility(0);
    }

    public void gy(boolean z) {
        this.dmN = z;
    }

    public View azp() {
        return this.dma;
    }

    public void azq() {
        this.dfw.showNetRefreshView(getView(), "");
        View Fg = this.dfw.getRefreshView().Fg();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) Fg.getLayoutParams();
        layoutParams.addRule(3, azm().getId());
        Fg.setLayoutParams(layoutParams);
        this.dfw.hideLoadingView(getView());
        if (this.dmP != null) {
            this.bcd.removeHeaderView(this.dmP.avZ());
            this.dmP = null;
        }
    }

    public void md(String str) {
        if (this.dkG != null) {
            this.dkG.setTitle(str);
        }
    }

    public void Dt() {
        if (this.dmO != null) {
            this.dmO.dismiss();
            this.dmO = null;
        }
    }
}
