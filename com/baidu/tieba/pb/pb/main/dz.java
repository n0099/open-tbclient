package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
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
import com.baidu.tbadk.core.view.GodHeadImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.r;
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
public class dz {
    public static int cRN = 2;
    public static int cRO = 3;
    public static int cRP = 0;
    public static int cRQ = 3;
    public static int cRR = 4;
    public static int cRS = 5;
    public static int cRT = 6;
    private com.baidu.tbadk.editortools.k Lx;
    private NoNetworkView aWk;
    private BdTypeListView aXu;
    private r.a ahc;
    private View azC;
    private View.OnClickListener bjG;
    private RelativeLayout cFw;
    private com.baidu.tieba.pb.b.c cKb;
    private View.OnClickListener cLt;
    private PbActivity cNL;
    PbActivity.c cNh;
    private UserIconBox cQA;
    private ImageView cQB;
    private TextView cQC;
    private LinearLayout cQD;
    private TextView cQE;
    private TextView cQF;
    private TextView cQJ;
    private View cQN;
    private View cQP;
    private RelativeLayout cQQ;
    private cb cQR;
    private PbListView cQW;
    private View cQY;
    public int cQk;
    private View cQm;
    public final com.baidu.tieba.pb.pb.main.b.c cQn;
    private List<com.baidu.tieba.pb.pb.main.b.a> cQo;
    private View cQp;
    private LinearLayout cQr;
    private ColumnLayout cQs;
    private TextView cQt;
    private TextView cQu;
    private HeadImageView cQv;
    private ImageView cQw;
    private ImageView cQx;
    private ImageView cQy;
    private UserIconBox cQz;
    private TextView cRA;
    private boolean cRC;
    private View cRI;
    private TextView cRJ;
    private LinearLayout cRK;
    private TextView cRL;
    private Runnable cRU;
    private Runnable cRV;
    private View cRx;
    private TextView cRy;
    private TextView cRz;
    private View cSh;
    private TextView cSi;
    private GodHeadImageView cSj;
    private TextView cSk;
    private LinearLayout cSl;
    private PbActivity.a cSo;
    private boolean cSq;
    private boolean cSr;
    private int cQl = 0;
    private View cQq = null;
    private TextView cQG = null;
    private TextView cQH = null;
    private TextView cQI = null;
    public FrsPraiseView cQK = null;
    private GodHeadImageView cPJ = null;
    private View cQL = null;
    private View cQM = null;
    private View cQO = null;
    private com.baidu.tbadk.core.dialog.a cQS = null;
    private com.baidu.tbadk.core.dialog.c bjw = null;
    private View cQT = null;
    private EditText cQU = null;
    private com.baidu.tieba.pb.view.m cQV = null;
    private com.baidu.tieba.pb.view.b cQX = null;
    private c.b bYO = null;
    private TbRichTextView.d aGi = null;
    private NoNetworkView.a bdG = null;
    private Dialog cQZ = null;
    private View cRa = null;
    private com.baidu.tbadk.core.dialog.a cRb = null;
    private Dialog cRc = null;
    private View cRd = null;
    private int cRe = 0;
    private RadioGroup Od = null;
    private RadioButton cRf = null;
    private RadioButton cRg = null;
    private RadioButton cRh = null;
    private Button cRi = null;
    private Button cRj = null;
    private TextView cRk = null;
    private Dialog cRl = null;
    private View cRm = null;
    private LinearLayout cRn = null;
    private CompoundButton.OnCheckedChangeListener cRo = null;
    private TextView cRp = null;
    private TextView cRq = null;
    private String cRr = null;
    private com.baidu.tbadk.core.dialog.c cRs = null;
    private boolean cRt = false;
    private boolean cRu = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView cRv = null;
    private boolean crE = false;
    private Button cRw = null;
    private boolean cRB = true;
    private LinearLayout cRD = null;
    private TextView cRE = null;
    private TextView cRF = null;
    private View aIr = null;
    private com.baidu.tbadk.core.view.b cRG = null;
    private boolean cKa = false;
    private boolean cRH = false;
    private boolean mIsFromCDN = true;
    private int cRM = 0;
    private boolean cRW = true;
    private a.InterfaceC0084a cRX = new ea(this);
    private boolean cRY = false;
    private boolean cRZ = false;
    private boolean cSa = false;
    private boolean cSb = false;
    private boolean cSc = false;
    private LinearLayout cSd = null;
    private TextView cSe = null;
    private int cSf = 0;
    private boolean cSg = false;
    private CustomMessageListener cSm = new ej(this, CmdConfigCustom.PB_SHOW_MULTIIAMGETOOL);
    private final View.OnClickListener cSn = new ev(this);
    private View.OnLongClickListener onLongClickListener = null;
    private boolean cSp = true;
    private boolean cSs = false;
    private boolean Xv = false;
    String userId = null;
    private final List<TbImageView> cSt = new ArrayList();
    private boolean cJY = true;
    private boolean cSu = false;
    private Runnable cSv = new fa(this);

    public NoNetworkView aqR() {
        return this.aWk;
    }

    public void aqS() {
        if (this.Lx != null) {
            this.Lx.hide();
        }
    }

    public void aqT() {
        reset();
        this.cRB = true;
        if (this.Lx != null) {
            this.Lx.hide();
        }
        if (this.cRx != null) {
            if (this.crE) {
                er(false);
            } else {
                es(false);
            }
        }
    }

    private void reset() {
        if (this.cNL != null && this.cNL.aph() != null && this.Lx != null) {
            com.baidu.tbadk.editortools.d.b.Da().setStatus(0);
            com.baidu.tbadk.editortools.d.e aph = this.cNL.aph();
            aph.Dz();
            if (aph.getWriteImagesInfo() != null) {
                aph.getWriteImagesInfo().setMaxImagesAllowed(10);
            }
            aph.eF(10);
            aph.eD(SendView.ALL);
            aph.eE(SendView.ALL);
            aph.fp(this.cNL.getActivity().getString(t.j.pb_reply_hint));
            com.baidu.tbadk.editortools.r ev = this.Lx.ev(23);
            com.baidu.tbadk.editortools.r ev2 = this.Lx.ev(2);
            com.baidu.tbadk.editortools.r ev3 = this.Lx.ev(5);
            if (ev2 != null) {
                ev2.ow();
            }
            if (ev3 != null) {
                ev3.ow();
            }
            if (ev != null) {
                ev.hide();
            }
            this.Lx.invalidate();
        }
    }

    public boolean aqU() {
        return this.cRB;
    }

    public void er(boolean z) {
        if (this.cRx != null && this.cRy != null && this.cRz != null) {
            this.cRy.setText(t.j.draft_to_send);
            this.cRz.setVisibility(8);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.cRx.startAnimation(alphaAnimation);
            }
            this.cRx.setVisibility(0);
        }
    }

    public void es(boolean z) {
        if (this.cRx != null && this.cRy != null && this.cRz != null) {
            this.cRy.setText(t.j.reply_floor_host);
            this.cRz.setVisibility(0);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.cRx.startAnimation(alphaAnimation);
            }
            this.cRx.setVisibility(0);
        }
    }

    public com.baidu.tieba.tbadkCore.data.r aqV() {
        int i;
        View childAt;
        int i2 = 0;
        if (this.aXu == null) {
            return null;
        }
        int firstVisiblePosition = this.aXu.getFirstVisiblePosition();
        int lastVisiblePosition = this.aXu.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.aXu.getChildCount();
            int i3 = 0;
            for (int i4 = firstVisiblePosition; i4 <= lastVisiblePosition; i4++) {
                if (i4 - firstVisiblePosition < childCount && (childAt = this.aXu.getChildAt(i4 - firstVisiblePosition)) != null) {
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
        int headerViewsCount = i - this.aXu.getHeaderViewsCount();
        if (headerViewsCount < 0) {
            headerViewsCount = 0;
        }
        if (this.cQR.kO(headerViewsCount) != null && this.cQR.kO(headerViewsCount) != com.baidu.tieba.tbadkCore.data.r.dWX) {
            i2 = headerViewsCount + 1;
        }
        return (com.baidu.tieba.tbadkCore.data.r) this.cQR.aG(i2);
    }

    public dz(PbActivity pbActivity, View.OnClickListener onClickListener, com.baidu.tieba.pb.b.c cVar) {
        this.cNL = null;
        this.cFw = null;
        this.cQm = null;
        this.aXu = null;
        this.cQp = null;
        this.cQr = null;
        this.cQs = null;
        this.cQt = null;
        this.cQu = null;
        this.cQv = null;
        this.cQw = null;
        this.cQx = null;
        this.cQy = null;
        this.cQz = null;
        this.cQA = null;
        this.cQB = null;
        this.cQC = null;
        this.cQD = null;
        this.cQE = null;
        this.cQF = null;
        this.cQJ = null;
        this.cQN = null;
        this.cQP = null;
        this.cQR = null;
        this.cQW = null;
        this.azC = null;
        this.bjG = null;
        this.cLt = null;
        this.cRx = null;
        this.cRy = null;
        this.cRA = null;
        this.cRI = null;
        this.cRJ = null;
        this.cNL = pbActivity;
        this.bjG = onClickListener;
        this.cKb = cVar;
        this.cFw = (RelativeLayout) LayoutInflater.from(this.cNL.getPageContext().getPageActivity()).inflate(t.h.new_pb_activity, (ViewGroup) null);
        this.cNL.addContentView(this.cFw, new FrameLayout.LayoutParams(-1, -1));
        this.cQm = this.cNL.findViewById(t.g.statebar_view);
        this.cQQ = (RelativeLayout) this.cNL.findViewById(t.g.title_wrapper);
        this.aWk = (NoNetworkView) this.cNL.findViewById(t.g.view_no_network);
        this.aXu = (BdTypeListView) this.cNL.findViewById(t.g.new_pb_list);
        View view = new View(this.cNL.getPageContext().getPageActivity());
        view.setLayoutParams(new AbsListView.LayoutParams(-1, this.cNL.getResources().getDimensionPixelSize(t.e.pb_editor_height)));
        this.aXu.addFooterView(view);
        this.aXu.setOnTouchListener(this.cNL.bjS);
        this.cQn = new com.baidu.tieba.pb.pb.main.b.c(pbActivity);
        this.cQn.arM().setOnTouchListener(new com.baidu.tieba.pb.b.a(new fb(this)));
        this.cRx = this.cNL.findViewById(t.g.pb_editor_tool_comment);
        this.cRy = (TextView) this.cNL.findViewById(t.g.pb_editor_tool_comment_reply_text);
        this.cRA = (TextView) this.cNL.findViewById(t.g.pb_editor_tool_comment_praise_icon);
        this.cRz = (TextView) this.cNL.findViewById(t.g.pb_editor_tool_comment_reply_count_text);
        this.cRy.setOnClickListener(new fc(this));
        this.cRA.setOnClickListener(this.bjG);
        this.cRA.setOnTouchListener(this.cNL);
        this.cQp = LayoutInflater.from(this.cNL.getPageContext().getPageActivity()).inflate(t.h.new_pb_header_item, (ViewGroup) null);
        this.cQr = (LinearLayout) LayoutInflater.from(this.cNL.getPageContext().getPageActivity()).inflate(t.h.new_pb_header_user_item, (ViewGroup) null);
        this.cQs = (ColumnLayout) this.cQr.findViewById(t.g.pb_head_owner_root);
        this.cQs.setOnLongClickListener(this.onLongClickListener);
        this.cQs.setOnTouchListener(this.cKb);
        this.cQs.setVisibility(8);
        this.cQp.setOnTouchListener(this.cKb);
        this.cQt = (TextView) this.cQp.findViewById(t.g.pb_head_post_title);
        this.cQt.setTextSize(TbConfig.getContentSizeOfPostTitle());
        this.cQt.setVisibility(8);
        this.cRI = this.cQp.findViewById(t.g.pb_head_activity_join_number_container);
        this.cRI.setVisibility(8);
        this.cRJ = (TextView) this.cQp.findViewById(t.g.pb_head_activity_join_number);
        this.cQu = (TextView) this.cQs.findViewById(t.g.pb_head_owner_info_user_name);
        this.cQv = (HeadImageView) this.cQs.findViewById(t.g.pb_head_owner_photo);
        if (!this.cJY) {
            this.cQv.setVisibility(8);
        }
        this.cQw = (ImageView) this.cQs.findViewById(t.g.pb_head_owner_info_user_rank);
        this.cQx = (ImageView) this.cQs.findViewById(t.g.pb_head_owner_info_user_gender);
        this.cQy = (ImageView) this.cQs.findViewById(t.g.pb_head_owner_info_user_bawu);
        this.cQz = (UserIconBox) this.cQs.findViewById(t.g.pb_head_owner_info_user_icon);
        this.cQA = (UserIconBox) this.cQs.findViewById(t.g.pb_head_owner_info_tshow_icon);
        this.cQB = (ImageView) this.cQs.findViewById(t.g.pb_head_owner_info_floor_owner);
        this.cQC = (TextView) this.cQs.findViewById(t.g.pb_head_owner_info_time);
        this.cQD = (LinearLayout) this.cQp.findViewById(t.g.read_thread_view);
        this.cQE = (TextView) this.cQp.findViewById(t.g.pb_head_read_button);
        this.cQF = (TextView) this.cQp.findViewById(t.g.pb_head_read_tip);
        this.cQD.setOnClickListener(this.bjG);
        this.cQJ = (TextView) this.cQp.findViewById(t.g.pb_head_reverse_hint);
        this.cQJ.setOnClickListener(this.bjG);
        this.cQJ.setVisibility(8);
        aqW();
        this.cQN = this.cQp.findViewById(t.g.new_pb_header_item_line_below_livepost);
        this.cQP = this.cQp.findViewById(t.g.new_pb_header_item_line_above_showpassed);
        this.cQp.setOnLongClickListener(new fd(this));
        arc();
        this.cRK = (LinearLayout) this.cFw.findViewById(t.g.interview_live_status_container);
        this.cRL = (TextView) this.cFw.findViewById(t.g.interview_live_status_btn);
        this.cRK.setOnClickListener(this.bjG);
        this.cQR = new cb(this.cNL, this.aXu);
        this.cQR.I(this.bjG);
        this.cQR.a(this.cKb);
        this.cQR.setOnImageClickListener(this.aGi);
        this.cLt = new fe(this);
        this.cQR.H(this.cLt);
        this.aXu.addHeaderView(this.cQr);
        this.aXu.addHeaderView(this.cQp);
        this.cQW = new PbListView(this.cNL.getPageContext().getPageActivity());
        this.azC = this.cQW.getView().findViewById(t.g.pb_more_view);
        if (this.azC != null) {
            this.azC.setOnClickListener(this.bjG);
            com.baidu.tbadk.core.util.ar.k(this.azC, t.f.pb_foot_more_trans_selector);
        }
        this.cQW.wW();
        this.cQW.de(t.f.pb_foot_more_trans_selector);
        this.cQW.df(t.f.pb_foot_more_trans_selector);
        this.cQY = this.cNL.findViewById(t.g.viewstub_progress);
        this.cNL.registerListener(this.cSm);
    }

    public void fC(boolean z) {
        this.cQn.fC(z);
        if (z && this.cRH) {
            this.cQW.setText(this.cNL.getResources().getString(t.j.click_load_more));
            this.aXu.setNextPage(this.cQW);
        }
    }

    private void aqW() {
        if (com.baidu.tbadk.core.sharedPref.b.uO().getBoolean("should_show_pb_read_text", true)) {
            this.cQF.setVisibility(0);
        }
    }

    public void aqX() {
        this.cQF.setVisibility(8);
        com.baidu.tbadk.core.sharedPref.b.uO().putBoolean("should_show_pb_read_text", false);
    }

    public void aqY() {
        TbadkCoreApplication.m411getInst().setReadThreadPlayerScreenMaxHeight(this.cFw.getHeight());
    }

    public void setEditorTools(com.baidu.tbadk.editortools.k kVar) {
        this.Lx = kVar;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.cFw.addView(this.Lx, layoutParams);
        this.Lx.onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        this.Lx.hide();
    }

    public void aqZ() {
        if (this.cNL != null && this.Lx != null) {
            this.Lx.ow();
        }
    }

    public void kN(String str) {
        if (this.cRz != null) {
            if (TextUtils.isEmpty(str)) {
                str = "0";
            }
            this.cRz.setText(this.cNL.getPageContext().getResources().getString(t.j.pb_reply_count_text, str));
        }
    }

    public void D(String str, boolean z) {
        this.cRC = z;
        fD(TbadkCoreApplication.m411getInst().getSkinType() == 1);
    }

    private void fD(boolean z) {
        if (this.cRA != null) {
            if (this.cRC) {
                com.baidu.tbadk.core.util.ar.k(this.cRA, t.f.pb_praise_already_click_selector);
            } else {
                com.baidu.tbadk.core.util.ar.k(this.cRA, t.f.pb_praise_normal_click_selector);
            }
        }
    }

    public TextView ara() {
        return this.cRA;
    }

    public void fE(boolean z) {
        if (this.aXu != null) {
            if (!z) {
                this.aXu.setEnabled(z);
                return;
            }
            if (this.cRV == null) {
                this.cRV = new ff(this, z);
            }
            com.baidu.adp.lib.h.h.hr().postDelayed(this.cRV, 10L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fF(boolean z) {
        if (z) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cQm.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.cQm.setLayoutParams(layoutParams);
            this.cQm.setVisibility(0);
            return;
        }
        this.cQm.setVisibility(8);
    }

    public void aE(View view) {
        boolean z;
        View view2;
        if (this.cQQ != null && view != null) {
            if (this.cRB) {
                z = this.cRx.getVisibility() == 0;
            } else {
                z = this.Lx != null && this.Lx.getVisibility() == 0;
            }
            boolean z2 = this.cQQ.getVisibility() == 0;
            if (z2) {
                TiebaStatic.log("c10084");
                this.cRZ = true;
                View findViewById = this.cNL.findViewById(t.g.bg_above_list);
                findViewById.setLayoutParams(new RelativeLayout.LayoutParams(-1, this.cQQ.getHeight()));
                com.baidu.tieba.tbadkCore.a.a(this.cNL, this.cQQ, t.a.top_fold_up, new eb(this, findViewById));
            } else {
                this.cRZ = false;
                com.baidu.tieba.tbadkCore.a.a(this.cNL, this.cQQ, t.a.top_fold_down, new ec(this));
            }
            if (this.cRB) {
                view2 = this.cRx;
            } else {
                view2 = this.Lx;
            }
            if (z) {
                if (z2) {
                    if (this.Lx != null) {
                        this.Lx.Ba();
                    }
                    com.baidu.tieba.tbadkCore.a.a(this.cNL, view2, t.a.bottom_fold_down, new ed(this));
                }
            } else if (!z2) {
                com.baidu.tieba.tbadkCore.a.a(this.cNL, view2, t.a.bottom_fold_up, new ee(this));
            }
        }
    }

    public cb arb() {
        return this.cQR;
    }

    public void a(PbActivity.c cVar) {
        this.cNh = cVar;
    }

    private void a(com.baidu.tbadk.core.data.ak akVar) {
        if (akVar == null || akVar.tX() == 0) {
            if (this.cRw != null) {
                this.cRw.setVisibility(8);
            }
            if (this.cQM != null) {
                this.cQM.setVisibility(8);
                return;
            }
            return;
        }
        if (this.cRw == null) {
            this.cNL.getLayoutMode().x(((ViewStub) this.cQp.findViewById(t.g.live_talk_layout)).inflate());
            this.cRw = (Button) this.cQp.findViewById(t.g.pb_head_function_manage_go_to_live_post);
            this.cQM = this.cQp.findViewById(t.g.new_pb_header_item_line_above_livepost);
        }
        int tY = akVar.tY();
        String string = this.cNL.getPageContext().getString(t.j.go_to_live_post_prefix);
        if (tY == 0) {
            string = String.valueOf(string) + this.cNL.getPageContext().getString(t.j.go_to_interview_post);
        } else if (tY == 1) {
            string = String.valueOf(string) + this.cNL.getPageContext().getString(t.j.go_to_discuss_post);
        }
        this.cRw.setText(string);
        this.cRw.setVisibility(0);
        this.cRw.setOnClickListener(this.bjG);
        this.cSr = true;
        aro();
        arr();
    }

    private void arc() {
        this.cRD = (LinearLayout) this.cQp.findViewById(t.g.btn_show_passed_pb);
        this.cRF = (TextView) this.cQp.findViewById(t.g.show_pre_page_view);
        this.cRE = (TextView) this.cQp.findViewById(t.g.go_back_top_view);
        this.aIr = this.cQp.findViewById(t.g.show_passed_divider);
        this.cRF.setOnClickListener(this.cSn);
        this.cRE.setOnClickListener(this.bjG);
        arr();
    }

    public LinearLayout ard() {
        return this.cQD;
    }

    public void fG(boolean z) {
        if (this.cQD != null) {
            if (z && TbadkCoreApplication.m411getInst().isTTSCanUse()) {
                this.cQD.setVisibility(0);
            } else {
                this.cQD.setVisibility(8);
            }
        }
    }

    public void aF(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, boolean z) {
        SparseArray sparseArray2;
        if (this.cRa == null) {
            this.cRa = LayoutInflater.from(this.cNL.getPageContext().getPageActivity()).inflate(t.h.forum_manage_dialog, (ViewGroup) null);
        }
        this.cNL.getLayoutMode().x(this.cRa);
        if (this.cQZ == null) {
            this.cQZ = new Dialog(this.cNL.getPageContext().getPageActivity(), t.k.common_alert_dialog);
            this.cQZ.setCanceledOnTouchOutside(true);
            this.cQZ.setCancelable(true);
            this.cQZ.setContentView(this.cRa);
            WindowManager.LayoutParams attributes = this.cQZ.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.k.K(this.cNL.getPageContext().getPageActivity()) * 0.9d);
            this.cQZ.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.cQZ.findViewById(t.g.del_post_btn);
        TextView textView2 = (TextView) this.cQZ.findViewById(t.g.forbid_user_btn);
        TextView textView3 = (TextView) this.cQZ.findViewById(t.g.disable_reply_btn);
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
            textView.setOnClickListener(new ef(this));
        }
        if ("".equals(sparseArray.get(t.g.tag_forbid_user_name))) {
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
            textView2.setOnClickListener(new eg(this));
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
            textView3.setOnClickListener(new eh(this, z));
        }
        com.baidu.adp.lib.h.j.a(this.cQZ, this.cNL.getPageContext());
    }

    public void a(PbActivity.a aVar) {
        this.cSo = aVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(t.g.tag_del_post_id, str);
        sparseArray.put(t.g.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(t.g.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(t.g.tag_del_post_is_self, Boolean.valueOf(z));
        sparseArray.put(cRP, Integer.valueOf(cRQ));
        int i3 = t.j.del_post_confirm;
        if (i == 0) {
            i3 = t.j.del_thread_confirm;
        }
        this.cRb = new com.baidu.tbadk.core.dialog.a(this.cNL.getActivity());
        this.cRb.bY(i3);
        this.cRb.x(sparseArray);
        this.cRb.a(t.j.dialog_ok, this.cNL);
        this.cRb.b(t.j.dialog_cancel, new ei(this));
        this.cRb.aj(true);
        this.cRb.b(this.cNL.getPageContext());
        this.cRb.uj();
    }

    public void X(ArrayList<com.baidu.tbadk.core.data.p> arrayList) {
        if (this.cRm == null) {
            this.cRm = LayoutInflater.from(this.cNL.getPageContext().getPageActivity()).inflate(t.h.commit_good, (ViewGroup) null);
        }
        this.cNL.getLayoutMode().x(this.cRm);
        if (this.cRl == null) {
            this.cRl = new Dialog(this.cNL.getPageContext().getPageActivity(), t.k.common_alert_dialog);
            this.cRl.setCanceledOnTouchOutside(true);
            this.cRl.setCancelable(true);
            this.cRv = (ScrollView) this.cRm.findViewById(t.g.good_scroll);
            this.cRl.setContentView(this.cRm);
            WindowManager.LayoutParams attributes = this.cRl.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.k.c(this.cNL.getPageContext().getPageActivity(), t.e.ds540);
            this.cRl.getWindow().setAttributes(attributes);
            this.cRo = new ek(this);
            this.cRn = (LinearLayout) this.cRm.findViewById(t.g.good_class_group);
            this.cRq = (TextView) this.cRm.findViewById(t.g.dialog_button_cancel);
            this.cRq.setOnClickListener(new el(this));
            this.cRp = (TextView) this.cRm.findViewById(t.g.dialog_button_ok);
            this.cRp.setOnClickListener(this.bjG);
        }
        this.cRn.removeAllViews();
        this.cQo = new ArrayList();
        com.baidu.tieba.pb.pb.main.b.a bc = bc("0", this.cNL.getPageContext().getString(t.j.def_good_class));
        this.cQo.add(bc);
        bc.setChecked(true);
        this.cRn.addView(bc);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.tieba.pb.pb.main.b.a bc2 = bc(String.valueOf(arrayList.get(i2).sl()), arrayList.get(i2).sk());
                this.cQo.add(bc2);
                View view = new View(this.cNL.getPageContext().getPageActivity());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.c(this.cNL.getPageContext().getPageActivity(), t.e.ds1));
                com.baidu.tbadk.core.util.ar.l(view, t.d.cp_bg_line_a);
                view.setLayoutParams(layoutParams);
                this.cRn.addView(view);
                this.cRn.addView(bc2);
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.cRv.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.k.dip2px(this.cNL.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.k.dip2px(this.cNL.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.k.dip2px(this.cNL.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.cRv.setLayoutParams(layoutParams2);
            this.cRv.removeAllViews();
            this.cRv.addView(this.cRn);
        }
        com.baidu.adp.lib.h.j.a(this.cRl, this.cNL.getPageContext());
    }

    private com.baidu.tieba.pb.pb.main.b.a bc(String str, String str2) {
        Activity pageActivity = this.cNL.getPageContext().getPageActivity();
        com.baidu.tieba.pb.pb.main.b.a aVar = new com.baidu.tieba.pb.pb.main.b.a(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.k.c(pageActivity, t.e.ds100));
        aVar.setOnCheckedChangeListener(this.cRo);
        aVar.setTag(str);
        aVar.setText(str2);
        aVar.setLayoutParams(layoutParams);
        return aVar;
    }

    public void are() {
        this.cNL.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.cNL.hideProgressBar();
        if (z && z2) {
            this.cNL.showToast(this.cNL.getPageContext().getString(t.j.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.aw.isEmpty(str)) {
                str = TbadkCoreApplication.m411getInst().getResources().getString(t.j.neterror);
            }
            this.cNL.showToast(str);
        }
    }

    public void acM() {
        this.cQY.setVisibility(0);
    }

    public void acL() {
        this.cQY.setVisibility(8);
    }

    public View arf() {
        if (this.cRm != null) {
            return this.cRm.findViewById(t.g.dialog_button_ok);
        }
        return null;
    }

    public String arg() {
        return this.cRr;
    }

    public View getView() {
        return this.cFw;
    }

    public void arh() {
        com.baidu.adp.lib.util.k.c(this.cNL.getPageContext().getPageActivity(), this.cNL.getCurrentFocus());
    }

    public void ajo() {
        this.cNL.showProgressBar();
    }

    public void fH(boolean z) {
        this.cNL.hideProgressBar();
        ajp();
    }

    public void ari() {
        this.cQW.xb();
    }

    public void arj() {
    }

    public void ark() {
        this.cNL.hideProgressBar();
        this.cQW.xc();
        arE();
        this.aXu.nr();
        arr();
    }

    public void arl() {
        this.aXu.nr();
        this.cRD.setVisibility(8);
        arr();
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.cQR.setOnLongClickListener(onLongClickListener);
    }

    public void a(c.b bVar, boolean z, boolean z2) {
        if (this.cRs != null) {
            this.cRs.dismiss();
            this.cRs = null;
        }
        this.cRs = new com.baidu.tbadk.core.dialog.c(this.cNL.getPageContext().getPageActivity());
        this.cRs.cb(t.j.operation);
        if (z2) {
            this.cRs.a(new String[]{this.cNL.getPageContext().getString(t.j.copy)}, bVar);
        } else if (!z) {
            this.cRs.a(new String[]{this.cNL.getPageContext().getString(t.j.copy), this.cNL.getPageContext().getString(t.j.mark)}, bVar);
        } else {
            this.cRs.a(new String[]{this.cNL.getPageContext().getString(t.j.copy), this.cNL.getPageContext().getString(t.j.remove_mark)}, bVar);
        }
        this.cRs.d(this.cNL.getPageContext());
        this.cRs.un();
    }

    public int arm() {
        return lb(this.aXu.getFirstVisiblePosition());
    }

    private int lb(int i) {
        com.baidu.adp.widget.ListView.e eVar = (com.baidu.adp.widget.ListView.e) this.aXu.getAdapter();
        if (eVar != null) {
            if (i < eVar.getCount() && i >= 0 && (eVar.getItem(i) instanceof com.baidu.tieba.pb.a.b)) {
                i++;
            }
            int headerViewsCount = (eVar.getHeaderViewsCount() + eVar.nn()) - 1;
            if (i > headerViewsCount) {
                i = headerViewsCount;
            }
            int headersCount = (this.aXu.getAdapter() == null || !(this.aXu.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) ? 0 : ((com.baidu.adp.widget.ListView.e) this.aXu.getAdapter()).getHeadersCount();
            return i > headersCount ? i - headersCount : 0;
        }
        return i;
    }

    public int arn() {
        return lb(this.aXu.getLastVisiblePosition());
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.cQU.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void j(com.baidu.tieba.pb.a.c cVar) {
        this.cQR.a(cVar);
        this.cQR.notifyDataSetChanged();
        if (cVar == null) {
            kN("");
        } else {
            kN(com.baidu.tbadk.core.util.aw.y(cVar.aoF().getReply_num()));
        }
        arr();
    }

    public void k(com.baidu.tieba.pb.a.c cVar) {
        PraiseData praise;
        if (this.cQK == null) {
            this.cNL.getLayoutMode().x(((ViewStub) this.cQp.findViewById(t.g.praise_layout)).inflate());
            this.cQK = (FrsPraiseView) this.cQp.findViewById(t.g.pb_head_praise_view);
            this.cQK.setIsFromPb(true);
            this.cQO = this.cQp.findViewById(t.g.new_pb_header_item_line_above_praise);
            this.cQK.dk(TbadkCoreApplication.m411getInst().getSkinType());
        }
        if (this.cQK != null) {
            boolean arr = arr();
            if (cVar != null && cVar.aoG() != null && cVar.aoG().size() > 0) {
                com.baidu.tieba.tbadkCore.data.r rVar = cVar.aoG().get(0);
                if ((!this.cKa || rVar.aMw() != 1) && (praise = cVar.aoF().getPraise()) != null && praise.getUser() != null && praise.getUser().size() > 0) {
                    this.cQK.setVisibility(0);
                    this.cQK.setIsFromPb(true);
                    this.cQK.a(praise, cVar.aoF().getId(), praise.getPostId(), true);
                    this.cQO.setVisibility(0);
                    if (this.cQK.getVisibility() == 0) {
                        this.cQP.setVisibility(0);
                        return;
                    }
                    return;
                }
            }
            this.cQK.setVisibility(8);
            this.cQO.setVisibility(8);
            if (cVar != null && cVar.getPage() != null && cVar.getPage().sw() == 0 && this.cKa) {
                this.cQO.setVisibility(8);
                if (arr) {
                    this.cQN.setVisibility(0);
                    return;
                } else {
                    this.cQN.setVisibility(8);
                    return;
                }
            }
            this.cQO.setVisibility(0);
            this.cQN.setVisibility(8);
        }
    }

    private com.baidu.tieba.tbadkCore.data.r a(com.baidu.tieba.pb.a.c cVar, boolean z, int i) {
        if (z) {
            if (cVar == null || cVar.aoG() == null || cVar.aoG().size() <= 0) {
                return null;
            }
            com.baidu.tieba.tbadkCore.data.r rVar = cVar.aoG().get(0);
            if (rVar.aMw() != 1) {
                return b(cVar);
            }
            return rVar;
        }
        return b(cVar);
    }

    private com.baidu.tieba.tbadkCore.data.r b(com.baidu.tieba.pb.a.c cVar) {
        MetaData metaData;
        if (cVar == null || cVar.aoF() == null || cVar.aoF().getAuthor() == null) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.r rVar = new com.baidu.tieba.tbadkCore.data.r();
        MetaData author = cVar.aoF().getAuthor();
        String userId = author.getUserId();
        HashMap<String, MetaData> userMap = cVar.aoF().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = author;
        }
        rVar.oj(1);
        rVar.setId(cVar.aoF().ty());
        rVar.setTitle(cVar.aoF().getTitle());
        rVar.setTime(cVar.aoF().getCreateTime());
        rVar.setAuthor(metaData);
        return rVar;
    }

    private void b(com.baidu.tieba.pb.a.c cVar, boolean z, int i) {
        com.baidu.tieba.tbadkCore.data.r a;
        this.cQs.setVisibility(8);
        if (cVar != null && cVar.aoF() != null && (a = a(cVar, z, i)) != null) {
            String str = null;
            boolean z2 = false;
            if (cVar != null && cVar.aoF() != null && cVar.aoF().getAuthor() != null) {
                str = cVar.aoF().getAuthor().getUserId();
                if (cVar.getPage() != null) {
                    this.cSf = cVar.getPage().ss();
                    z2 = cVar.getPage().sv() == 1;
                }
            }
            this.cRY = !cVar.aoF().tI() && a(a, cVar.aoF().getId(), str, z2, z);
            if (z) {
                this.cQJ.setVisibility(8);
            } else {
                this.cQJ.setVisibility(0);
            }
            this.cQs.setVisibility(0);
            SparseArray sparseArray = (SparseArray) this.cQs.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.cQs.setTag(sparseArray);
            }
            sparseArray.put(t.g.tag_clip_board, a);
            sparseArray.put(t.g.tag_is_subpb, false);
            this.cQC.setText(com.baidu.tbadk.core.util.aw.t(a.getTime()));
            cVar.aoF().tH();
            this.cQt.setText(cVar.aoF().getSpan_str());
            k(cVar);
            ArrayList<com.baidu.tbadk.core.data.a> tt = cVar.aoF().tt();
            if (tt != null && tt.size() > 0) {
                this.cRJ.setText(String.valueOf(tt.get(0).rG()));
                this.cRI.setVisibility(0);
                this.cSq = true;
            } else {
                this.cRI.setVisibility(8);
            }
            com.baidu.tbadk.core.util.ar.k(this.cRI, t.f.activity_join_num_bg);
            com.baidu.tbadk.core.util.ar.b(this.cRJ, t.d.cp_link_tip_d, 1);
            if (cVar != null && cVar.aoF() != null && cVar.aoF().getAuthor() != null) {
                String userId = cVar.aoF().getAuthor().getUserId();
                if (userId != null && !userId.equals("0") && userId.equals(a.getAuthor().getUserId())) {
                    this.cQB.setVisibility(0);
                } else {
                    this.cQB.setVisibility(8);
                }
            }
            if (a.getAuthor() != null) {
                int level_id = a.getAuthor().getLevel_id();
                int is_bawu = a.getAuthor().getIs_bawu();
                String bawu_type = a.getAuthor().getBawu_type();
                int i2 = 3;
                if (level_id != 0) {
                    this.cQw.setVisibility(0);
                    com.baidu.tbadk.core.util.ar.c(this.cQw, BitmapHelper.getGradeResourceIdNew(level_id));
                    this.cQw.setOnClickListener(null);
                } else {
                    this.cQw.setVisibility(8);
                }
                if (is_bawu != 0) {
                    if (bawu_type.equals("manager")) {
                        com.baidu.tbadk.core.util.ar.c(this.cQy, t.f.pb_manager);
                        this.cQw.setVisibility(8);
                        this.cQy.setVisibility(0);
                    } else if (bawu_type.equals("assist")) {
                        com.baidu.tbadk.core.util.ar.c(this.cQy, t.f.pb_assist);
                        this.cQw.setVisibility(8);
                        this.cQy.setVisibility(0);
                    }
                }
                if (a.getAuthor().getGender() == 2) {
                    com.baidu.tbadk.core.util.ar.c(this.cQx, t.f.icon_pb_pop_girl);
                    this.cQx.setVisibility(0);
                } else if (a.getAuthor().getGender() == 1) {
                    com.baidu.tbadk.core.util.ar.c(this.cQx, t.f.icon_pb_pop_boy);
                    this.cQx.setVisibility(0);
                } else {
                    this.cQx.setVisibility(8);
                }
                if (!StringUtils.isNull(a.getAuthor().getName_show()) && com.baidu.adp.lib.util.j.aU(a.getAuthor().getName_show()) > 14) {
                    i2 = 0;
                }
                ArrayList<IconData> iconInfo = a.getAuthor().getIconInfo();
                ArrayList<IconData> tShowInfoNew = a.getAuthor().getTShowInfoNew();
                if (this.cQz != null) {
                    this.cQz.setTag(t.g.tag_user_id, a.getAuthor().getUserId());
                    this.cQz.setOnClickListener(this.cNL.cML.bkj);
                    this.cQz.a(iconInfo, i2, this.cNL.getResources().getDimensionPixelSize(t.e.pb_icon_width), this.cNL.getResources().getDimensionPixelSize(t.e.pb_icon_height), this.cNL.getResources().getDimensionPixelSize(t.e.pb_icon_margin));
                }
                if (this.cQA != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        this.cQA.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    this.cQA.setOnClickListener(this.cNL.cML.cSF);
                    this.cQA.a(tShowInfoNew, 3, this.cNL.getResources().getDimensionPixelSize(t.e.small_icon_width), this.cNL.getResources().getDimensionPixelSize(t.e.small_icon_height), this.cNL.getResources().getDimensionPixelSize(t.e.big_icon_margin), true);
                }
                this.cQu.setText(a.getAuthor().getName_show());
                this.cQu.setTag(t.g.tag_user_id, a.getAuthor().getUserId());
                this.cQu.setTag(t.g.tag_user_name, a.getAuthor().getName_show());
                if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                    com.baidu.tbadk.core.util.ar.b(this.cQu, t.d.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.ar.b(this.cQu, t.d.cp_cont_f, 1);
                }
                this.cQv.setUserId(a.getAuthor().getUserId());
                this.cQv.setUserName(a.getAuthor().getUserName());
                this.cQv.setImageDrawable(null);
                this.cQv.setTag(a.getAuthor().getUserId());
                if (this.cRY) {
                    em emVar = new em(this, a);
                    this.cQu.setOnClickListener(emVar);
                    this.cQv.setOnClickListener(emVar);
                    this.cQv.setVisibility(8);
                } else {
                    if (!this.cJY) {
                        this.cQv.setVisibility(8);
                    } else {
                        this.cQv.setVisibility(0);
                    }
                    this.cQu.setOnClickListener(this.cNL.cML.cSE);
                    this.cQv.setOnClickListener(this.cNL.cML.cSE);
                }
                this.cQv.d(a.getAuthor().getPortrait(), 28, false);
            }
            aro();
        }
    }

    private void aro() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cQD.getLayoutParams();
        layoutParams.setMargins(layoutParams.leftMargin, this.cSq ? com.baidu.adp.lib.util.k.c(TbadkCoreApplication.m411getInst(), t.e.ds20) : 0, layoutParams.rightMargin, this.cSr ? com.baidu.adp.lib.util.k.c(TbadkCoreApplication.m411getInst(), t.e.ds20) : 0);
        this.cQD.setLayoutParams(layoutParams);
    }

    public boolean arp() {
        return this.cSs;
    }

    private boolean arq() {
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.userId);
    }

    private boolean f(com.baidu.tbadk.core.data.ah ahVar) {
        if (ahVar == null || ahVar.getAuthor() == null || ahVar.getAuthor().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), ahVar.getAuthor().getUserId());
    }

    public void a(com.baidu.tieba.pb.a.c cVar, int i, int i2, boolean z, int i3, boolean z2) {
        Parcelable aqL;
        Parcelable aqL2;
        String sb;
        if (cVar != null) {
            if (cVar.aoF() != null) {
                this.cRM = cVar.aoF().tj();
                this.Xv = cVar.aoF().tg();
                if (cVar.aoF().getAnchorLevel() != 0) {
                    this.cSs = true;
                }
                this.cRu = f(cVar.aoF());
            }
            if (cVar.getUserData() != null) {
                this.userId = cVar.getUserData().getUserId();
            }
            m(cVar);
            this.cRH = false;
            this.cKa = z;
            ark();
            b(cVar, z, i);
            this.cQR.fi(this.cKa);
            this.cQR.a(cVar);
            this.cQR.notifyDataSetChanged();
            if (cVar.aoE() != null) {
                this.mForumName = cVar.aoE().getName();
                this.mForumId = cVar.getForumId();
            }
            this.cQn.kQ(this.mForumName);
            if (cVar.aoF() != null) {
                kN(com.baidu.tbadk.core.util.aw.y(cVar.aoF().getReply_num()));
                if (cVar.aoF().getPraise() != null) {
                    if (cVar.aoF().getPraise().getNum() < 1) {
                        sb = this.cNL.getResources().getString(t.j.frs_item_praise_text);
                    } else {
                        sb = new StringBuilder(String.valueOf(cVar.aoF().getPraise().getNum())).toString();
                    }
                    if (this.cQk != -1) {
                        cVar.aoF().getPraise().setIsLike(this.cQk);
                    }
                    D(sb, cVar.aoF().getPraise().getIsLike() == 1);
                }
            }
            if (cVar.getPage().sv() == 0 && !z) {
                this.aXu.setNextPage(null);
            } else if (this.cNL.isLogin()) {
                this.aXu.setNextPage(this.cQW);
                arE();
            } else if (cVar.getPage().sv() == 1) {
                this.cRH = true;
                if (this.cQX == null) {
                    this.cQX = new com.baidu.tieba.pb.view.b(this.cNL.getPageContext());
                }
                this.aXu.setNextPage(this.cQX);
            }
            if (cVar.getPage().sw() == 0 && z) {
                this.aXu.setPullRefresh(null);
                this.cQl = 0;
                this.cRD.setVisibility(8);
            } else {
                if (this.cQV == null) {
                    this.cQV = new com.baidu.tieba.pb.view.m(this.cNL.getPageContext());
                    this.cQV.ni();
                    this.cQV.a(this.ahc);
                }
                this.aXu.setPullRefresh(this.cQV);
                this.cQl = 1;
                if (this.cQV != null) {
                    this.cQV.dg(TbadkCoreApplication.m411getInst().getSkinType());
                }
                this.cRD.setVisibility(0);
                arE();
            }
            arr();
            ArrayList<com.baidu.tieba.tbadkCore.data.r> aoG = cVar.aoG();
            if (cVar.getPage().sv() == 0 || aoG == null || aoG.size() < cVar.getPage().su()) {
                this.cQW.setText(this.cNL.getResources().getString(t.j.list_no_more));
                l(cVar);
            } else if (z2) {
                if (this.cSp) {
                    xc();
                    if (cVar.getPage().sv() != 0) {
                        this.cQW.setText(this.cNL.getResources().getString(t.j.pb_load_more));
                    }
                } else {
                    this.cQW.showLoading();
                }
            } else {
                this.cQW.showLoading();
            }
            if (z) {
                this.cRE.setVisibility(0);
                this.aIr.setVisibility(0);
                this.cRF.setText(this.cNL.getResources().getString(t.j.btn_show_passed_pb));
            } else {
                this.cRE.setVisibility(8);
                this.aIr.setVisibility(8);
                this.cRF.setText(this.cNL.getResources().getString(t.j.btn_show_passed_pb_aftre));
            }
            if (cVar.aoF() != null && cVar.aoF().getAuthor() != null && cVar.aoF().getAuthor().getType() == 0) {
                this.cQn.arN();
            }
            switch (i) {
                case 2:
                    this.aXu.setSelection(i2);
                    if (this.cQq != null) {
                        CompatibleUtile.scrollListViewBy(this.aXu, -this.cQq.getHeight(), 0);
                        break;
                    }
                    break;
                case 3:
                    if (i3 == 1 && (aqL2 = ds.aqK().aqL()) != null) {
                        this.aXu.onRestoreInstanceState(aqL2);
                        this.cSc = true;
                        break;
                    } else {
                        this.aXu.setSelection(0);
                        break;
                    }
                    break;
                case 4:
                    this.cSp = false;
                    this.aXu.setSelection(0);
                    break;
                case 5:
                    this.aXu.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1 && (aqL = ds.aqK().aqL()) != null) {
                        this.aXu.onRestoreInstanceState(aqL);
                        this.cSc = true;
                        break;
                    } else {
                        this.aXu.setSelection(0);
                        break;
                    }
                    break;
            }
            if (this.cRM == cRO && arq()) {
                arI();
            }
        }
    }

    public void fI(boolean z) {
        this.cRt = z;
        this.cQn.fI(z);
    }

    public void xc() {
        if (this.cQW != null) {
            this.cQW.xc();
        }
        arE();
    }

    public void KZ() {
        this.aXu.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean arr() {
        boolean z;
        boolean z2 = true;
        if (this.cQq != null && this.cQq.getVisibility() == 0) {
            if (this.cQL != null) {
                this.cQL.setVisibility(0);
                z = true;
            } else {
                z = true;
            }
        } else {
            if (this.cQL != null) {
                this.cQL.setVisibility(8);
            }
            z = false;
        }
        if (this.cRw != null && this.cRw.getVisibility() == 0) {
            if (this.cQM != null) {
                this.cQM.setVisibility(0);
            }
        } else {
            if (this.cQM != null) {
                this.cQM.setVisibility(8);
            }
            z2 = z;
        }
        if ((this.cQO == null || this.cQO.getVisibility() == 8) && z2 && this.cKa) {
            this.cQN.setVisibility(0);
        } else {
            this.cQN.setVisibility(8);
        }
        return z2;
    }

    public boolean a(com.baidu.tieba.pb.a.c cVar, boolean z, boolean z2) {
        if (cVar == null) {
            return false;
        }
        if (this.cQt != null) {
            if (cVar.aoF().tx() == 0 && !cVar.aoF().tJ()) {
                this.cQt.setVisibility(0);
                cVar.aoF().tH();
                this.cQt.setText(cVar.aoF().getSpan_str());
            } else {
                this.cQt.setVisibility(8);
                this.cSq = true;
                aro();
            }
        }
        this.cKa = z;
        com.baidu.tbadk.core.data.ah aoF = cVar.aoF();
        if (aoF != null) {
            a(aoF.tm());
        }
        if (cVar.aoJ() == 1) {
            ars();
            Button button = (Button) this.cQp.findViewById(t.g.pb_head_function_manage_commit_top);
            Button button2 = (Button) this.cQp.findViewById(t.g.pb_head_function_manage_cancel_top);
            Button button3 = (Button) this.cQp.findViewById(t.g.pb_head_function_manage_commit_good);
            Button button4 = (Button) this.cQp.findViewById(t.g.pb_head_function_manage_cancel_good);
            button.setOnClickListener(this.bjG);
            button2.setOnClickListener(this.bjG);
            button3.setOnClickListener(this.bjG);
            button4.setOnClickListener(this.bjG);
            if (cVar.aoF().getIs_good() == 1) {
                button3.setVisibility(8);
                button4.setVisibility(0);
            } else {
                button3.setVisibility(0);
                button4.setVisibility(8);
            }
            if (cVar.aoF().getIs_top() == 1) {
                button.setVisibility(8);
                button2.setVisibility(0);
            } else {
                button.setVisibility(0);
                button2.setVisibility(8);
            }
            if (cVar.aoF().tP() && cVar.aoF().tC() == 2) {
                button.setEnabled(false);
                com.baidu.tbadk.core.util.ar.j((View) button, t.d.cp_cont_d);
            }
            return true;
        }
        return false;
    }

    private void ars() {
        if (this.cQq == null) {
            this.cQq = ((ViewStub) this.cQp.findViewById(t.g.pb_header_function_manage)).inflate();
            this.cNL.getLayoutMode().x(this.cQq);
            this.cQL = this.cQp.findViewById(t.g.new_pb_header_item_line_above_manage);
            return;
        }
        this.cQq.setVisibility(0);
    }

    public void a(com.baidu.tieba.pb.a.c cVar, boolean z, boolean z2, int i) {
        boolean z3;
        boolean z4;
        boolean z5;
        String userId;
        if (cVar != null) {
            a(cVar, z, z2);
            com.baidu.tieba.tbadkCore.data.r a = a(cVar, z, i);
            if (a != null) {
                if (cVar.aoJ() != 0 && a.getAuthor() != null) {
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
                    String userId3 = cVar.aoF().getAuthor().getUserId();
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
                    sparseArray.put(t.g.tag_manage_user_identity, Integer.valueOf(cVar.aoJ()));
                    sparseArray.put(t.g.tag_should_manage_visible, true);
                    a(t.j.manage, sparseArray);
                } else if (z4) {
                    SparseArray<Object> sparseArray2 = new SparseArray<>();
                    sparseArray2.put(t.g.tag_del_post_id, a.getId());
                    sparseArray2.put(t.g.tag_del_post_type, 0);
                    sparseArray2.put(t.g.tag_del_post_is_self, Boolean.valueOf(z3));
                    sparseArray2.put(t.g.tag_manage_user_identity, Integer.valueOf(cVar.aoJ()));
                    sparseArray2.put(t.g.tag_should_manage_visible, false);
                    a(t.j.delete, sparseArray2);
                }
            }
            arr();
        }
    }

    private void a(int i, SparseArray<Object> sparseArray) {
        ars();
        Button button = (Button) this.cQp.findViewById(t.g.pb_head_function_manage_delormanage);
        button.setOnClickListener(this.bjG);
        button.setVisibility(0);
        button.setText(i);
        button.setTag(sparseArray);
    }

    public View getNextView() {
        return this.azC;
    }

    public void kO(String str) {
        if (this.cQW != null && !StringUtils.isNull(str)) {
            this.cQW.setText(str);
        }
    }

    public BdListView KM() {
        return this.aXu;
    }

    public int art() {
        return t.g.richText;
    }

    public int Qc() {
        return t.g.user_icon_box;
    }

    public Button aru() {
        return (Button) this.cQp.findViewById(t.g.pb_head_function_manage_commit_good);
    }

    public Button arv() {
        return (Button) this.cQp.findViewById(t.g.pb_head_function_manage_cancel_good);
    }

    public Button arw() {
        return (Button) this.cQp.findViewById(t.g.pb_head_function_manage_commit_top);
    }

    public Button arx() {
        return (Button) this.cQp.findViewById(t.g.pb_head_function_manage_cancel_top);
    }

    public void c(BdListView.e eVar) {
        this.aXu.setOnSrollToBottomListener(eVar);
    }

    public void a(BdListView.h hVar) {
        this.aXu.setOnSrollToTopListener(hVar);
    }

    public void a(r.a aVar) {
        this.ahc = aVar;
        if (this.cQV != null) {
            this.cQV.a(aVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.u uVar, a.b bVar) {
        if (uVar != null) {
            int st = uVar.st();
            int sq = uVar.sq();
            if (this.cQS != null) {
                this.cQS.uj();
            } else {
                this.cQS = new com.baidu.tbadk.core.dialog.a(this.cNL.getPageContext().getPageActivity());
                this.cQT = LayoutInflater.from(this.cNL.getPageContext().getPageActivity()).inflate(t.h.dialog_direct_pager, (ViewGroup) null);
                this.cQS.z(this.cQT);
                this.cQS.a(t.j.dialog_ok, bVar);
                this.cQS.b(t.j.dialog_cancel, new en(this));
                this.cQS.a(new eo(this));
                this.cQS.b(this.cNL.getPageContext()).uj();
            }
            this.cQU = (EditText) this.cQT.findViewById(t.g.input_page_number);
            this.cQU.setText("");
            TextView textView = (TextView) this.cQT.findViewById(t.g.current_page_number);
            if (st <= 0) {
                st = 1;
            }
            if (sq <= 0) {
                sq = 1;
            }
            textView.setText(MessageFormat.format(this.cNL.getApplicationContext().getResources().getString(t.j.current_page), Integer.valueOf(st), Integer.valueOf(sq)));
            this.cNL.ShowSoftKeyPadDelay(this.cQU, 150);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.aXu.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.cNL.showToast(str);
    }

    public boolean fJ(boolean z) {
        if (this.Lx == null || !this.Lx.CC()) {
            return false;
        }
        this.Lx.Ba();
        return true;
    }

    public void ary() {
        if (this.cSt != null) {
            while (this.cSt.size() > 0) {
                TbImageView remove = this.cSt.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        ary();
    }

    public void onDestroy() {
        this.cNL.hideProgressBar();
        if (this.aWk != null && this.bdG != null) {
            this.aWk.b(this.bdG);
        }
        ajp();
        this.cQW.xc();
        if (this.cRU != null) {
            com.baidu.adp.lib.h.h.hr().removeCallbacks(this.cRU);
        }
        if (this.cRV != null) {
            com.baidu.adp.lib.h.h.hr().removeCallbacks(this.cRV);
        }
        arF();
        if (this.cSl != null) {
            this.cSl.removeAllViews();
        }
        if (this.cPJ != null) {
            this.cPJ.removeAllViews();
            this.cPJ = null;
        }
    }

    public void ajp() {
        this.cQn.qI();
        com.baidu.adp.lib.util.k.c(this.cNL.getPageContext().getPageActivity(), this.cQU);
        if (this.cRs != null) {
            this.cRs.dismiss();
        }
        arz();
    }

    public void fg(boolean z) {
        this.cQR.fg(z);
    }

    public void fh(boolean z) {
        this.cJY = z;
        this.cQR.fh(z);
    }

    public void ep(boolean z) {
        this.crE = z;
    }

    public void arz() {
        if (this.cRb != null) {
            this.cRb.dismiss();
        }
        if (this.cRc != null) {
            com.baidu.adp.lib.h.j.b(this.cRc, this.cNL.getPageContext());
        }
        if (this.cRl != null) {
            com.baidu.adp.lib.h.j.b(this.cRl, this.cNL.getPageContext());
        }
        if (this.cQZ != null) {
            com.baidu.adp.lib.h.j.b(this.cQZ, this.cNL.getPageContext());
        }
    }

    public void onChangeSkinType(int i) {
        this.cNL.getLayoutMode().ac(i == 1);
        this.cNL.getLayoutMode().x(this.cFw);
        this.cNL.getLayoutMode().x(this.cQr);
        this.cNL.getLayoutMode().x(this.cQp);
        this.cNL.getLayoutMode().x(this.azC);
        com.baidu.tbadk.core.util.ar.b(this.cQF, t.d.cp_cont_g, 1);
        this.cQn.mNavigationBar.onChangeSkinType(this.cNL.getPageContext(), i);
        com.baidu.tbadk.core.util.ar.a(this.cQn.cSN, t.f.btn_more_selector_s, t.f.btn_more_selector);
        com.baidu.tbadk.core.util.ar.a(this.cQn.cSO, t.f.icon_floor_addition_selector, t.f.icon_floor_addition_selector);
        if (this.cQT != null) {
            this.cNL.getLayoutMode().x(this.cQT);
        }
        fI(this.cRt);
        this.cQR.notifyDataSetChanged();
        if (this.cQV != null) {
            this.cQV.dg(i);
        }
        if (this.cQW != null) {
            this.cQW.dg(i);
            com.baidu.tbadk.core.util.ar.k(this.azC, t.f.pb_foot_more_trans_selector);
            this.cQW.de(t.f.pb_foot_more_trans_selector);
        }
        if (this.Lx != null) {
            this.Lx.onChangeSkinType(i);
        }
        if (this.cQK != null) {
            this.cQK.dk(i);
        }
        if (this.cQX != null) {
            this.cQX.dg(i);
        }
        if (this.cQo != null && this.cQo.size() > 0) {
            for (com.baidu.tieba.pb.pb.main.b.a aVar : this.cQo) {
                aVar.arL();
            }
        }
        if (this.cSl != null) {
            com.baidu.tbadk.core.util.ar.l(this.cSl, t.d.cp_bg_line_d);
            com.baidu.tbadk.core.util.ar.l(this.cSh, t.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.ar.b(this.cSk, t.d.cp_cont_c, 1);
        }
        fD(i == 1);
    }

    public void setOnImageClickListener(TbRichTextView.d dVar) {
        this.aGi = dVar;
        this.cQR.setOnImageClickListener(this.aGi);
    }

    public void f(NoNetworkView.a aVar) {
        this.bdG = aVar;
        if (this.aWk != null) {
            this.aWk.a(this.bdG);
        }
    }

    public void fK(boolean z) {
        this.cQR.setIsFromCDN(z);
        this.mIsFromCDN = z;
    }

    public Button arA() {
        return this.cRw;
    }

    public void l(com.baidu.tieba.pb.a.c cVar) {
        if (cVar != null) {
            ArrayList<com.baidu.tieba.tbadkCore.data.r> aoG = cVar.aoG();
            if (aoG.size() == 1) {
                com.baidu.tieba.tbadkCore.data.r rVar = aoG.get(0);
                if (rVar.aMB() < rVar.aMv().size()) {
                    this.aXu.setNextPage(null);
                    return;
                } else {
                    this.aXu.setNextPage(this.cQW);
                    return;
                }
            }
            this.aXu.setNextPage(this.cQW);
        }
    }

    public void arB() {
        if (com.baidu.tbadk.performanceLog.aa.FY().FZ()) {
            int lastVisiblePosition = this.aXu.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.aXu.getChildAt(i);
                if (childAt != null) {
                    TbRichTextView tbRichTextView = (TbRichTextView) childAt.findViewById(t.g.richText);
                    if (tbRichTextView != null) {
                        for (int i2 = 0; i2 < tbRichTextView.getChildCount(); i2++) {
                            View childAt2 = tbRichTextView.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.performanceLog.u perfLog = tbImageView.getPerfLog();
                                perfLog.eZ(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
                                perfLog.aAD = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr = new int[2];
                                    tbRichTextView.getLocationOnScreen(iArr);
                                    if (iArr[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                    }
                                }
                                tbImageView.wQ();
                            }
                        }
                    }
                    HeadImageView headImageView = (HeadImageView) childAt.findViewById(t.g.photo);
                    if (headImageView != null) {
                        com.baidu.tbadk.performanceLog.u perfLog2 = headImageView.getPerfLog();
                        perfLog2.eZ(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
                        perfLog2.aAD = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr2 = new int[2];
                            headImageView.getLocationOnScreen(iArr2);
                            if (iArr2[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                            }
                        }
                        headImageView.wQ();
                    }
                }
            }
        }
    }

    public void eq(boolean z) {
        if (this.cRx != null && this.cRx != null) {
            if (this.crE) {
                er(z);
            } else {
                es(z);
            }
        }
    }

    public void arC() {
        if (this.cRx != null) {
            this.cRx.setVisibility(8);
        }
    }

    public TextView arD() {
        return this.cRE;
    }

    public void agV() {
        if (this.cRG == null) {
            this.cRG = new com.baidu.tbadk.core.view.b(this.cNL.getPageContext());
        }
        this.cRG.aw(true);
    }

    public void arE() {
        if (this.cRG != null) {
            this.cRG.aw(false);
        }
    }

    private boolean a(com.baidu.tieba.tbadkCore.data.r rVar, String str, String str2, boolean z, boolean z2) {
        ColumnLayout.a aVar;
        if (rVar == null || rVar.getAuthor() == null || rVar.getAuthor().getGodUserData() == null) {
            return false;
        }
        GodUserData godUserData = rVar.getAuthor().getGodUserData();
        if (2 != godUserData.getType()) {
            return false;
        }
        MetaData author = rVar.getAuthor();
        long userIdLong = rVar.getAuthor().getUserIdLong();
        String userName = rVar.getAuthor().getUserName();
        int fansNum = rVar.getAuthor().getFansNum();
        rVar.getId();
        String portrait = rVar.getAuthor().getPortrait();
        eq eqVar = new eq(this, str, new com.baidu.tbadk.coreExtra.d.a(null), author);
        this.cQs.setPadding(TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds32), TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds20), TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds32), 0);
        if (rVar.getType() == null || rVar.getType().getId() != com.baidu.tieba.tbadkCore.data.r.WH.getId()) {
            this.cQp.setPadding(0, TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds34), 0, 0);
        }
        int dimensionPixelSize = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds76);
        if (this.cQv.getLayoutParams() == null) {
            aVar = new ColumnLayout.a(dimensionPixelSize, dimensionPixelSize);
        } else {
            ColumnLayout.a aVar2 = (ColumnLayout.a) this.cQv.getLayoutParams();
            aVar2.width = dimensionPixelSize;
            aVar2.height = dimensionPixelSize;
            aVar = aVar2;
        }
        this.cQv.setLayoutParams(aVar);
        this.cQv.setVisibility(8);
        View findViewWithTag = this.cQs.findViewWithTag("pb_god_head_image_view_tag");
        if (!(findViewWithTag instanceof GodHeadImageView)) {
            this.cPJ = new GodHeadImageView(this.cNL.getApplicationContext());
            this.cPJ.setTag("pb_god_head_image_view_tag");
            this.cPJ.setShapeType(2);
            this.cPJ.setShowType(1);
            this.cPJ.setTag(t.g.tag_user_id, String.valueOf(userIdLong));
            this.cPJ.setTag(t.g.tag_user_name, userName);
            this.cQs.addView(this.cPJ, 0, aVar);
        } else {
            this.cPJ = (GodHeadImageView) findViewWithTag;
        }
        er erVar = new er(this, rVar);
        this.cQs.setTag(t.g.tag_user_id, String.valueOf(userIdLong));
        this.cQs.setTag(t.g.tag_user_name, userName);
        this.cQs.setOnClickListener(erVar);
        this.cQr.setTag(t.g.tag_user_id, String.valueOf(userIdLong));
        this.cQr.setTag(t.g.tag_user_name, userName);
        this.cQr.setOnClickListener(erVar);
        if (this.cJY) {
            this.cPJ.setVisibility(0);
            this.cPJ.setOnClickListener(erVar);
            this.cPJ.d(portrait, 28, false);
        } else {
            this.cPJ.setVisibility(8);
        }
        if (this.cQG == null) {
            this.cQG = new TextView(this.cNL.getActivity());
            this.cQG.setClickable(false);
            this.cQG.setIncludeFontPadding(false);
            this.cQG.setGravity(16);
            this.cQG.setTextSize(0, this.cNL.getResources().getDimensionPixelSize(t.e.fontsize24));
            ColumnLayout.a aVar3 = new ColumnLayout.a(-2, -2, 3, 2);
            aVar3.topMargin = this.cNL.getResources().getDimensionPixelSize(t.e.ds8);
            aVar3.bottomMargin = this.cNL.getResources().getDimensionPixelSize(t.e.ds10);
            this.cQG.setSingleLine(true);
            com.baidu.tbadk.core.util.ar.b(this.cQG, t.d.cp_cont_d, 1);
            this.cQs.addView(this.cQG, -1, aVar3);
        }
        String format = String.format(this.cNL.getResources().getString(t.j.fans_default_name_god_user), com.baidu.tbadk.core.util.aw.x(fansNum));
        this.cQG.setText(format);
        this.cQG.setTag(t.g.tag_user_id, String.valueOf(userIdLong));
        this.cQG.setTag(t.g.tag_user_name, userName);
        this.cQG.setOnClickListener(erVar);
        if (this.cQH == null) {
            this.cQH = new TextView(this.cNL.getActivity());
            this.cQH.setClickable(false);
            this.cQH.setTextSize(0, this.cNL.getResources().getDimensionPixelSize(t.e.fontsize24));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            this.cQH.setSingleLine(true);
            this.cQH.setPadding(this.cNL.getResources().getDimensionPixelSize(t.e.ds32), 0, this.cNL.getResources().getDimensionPixelSize(t.e.ds128), 0);
            this.cQH.setEllipsize(TextUtils.TruncateAt.END);
            this.cQH.setTag(t.g.tag_user_id, String.valueOf(userIdLong));
            this.cQH.setTag(t.g.tag_user_name, userName);
            com.baidu.tbadk.core.util.ar.b(this.cQH, t.d.cp_cont_d, 1);
            this.cQr.addView(this.cQH, layoutParams);
        }
        String string = this.cNL.getResources().getString(t.j.tieba_certification);
        String format2 = StringUtils.isNull(godUserData.getIntro()) ? String.format(string, this.cNL.getResources().getString(t.j.god_intro_default)) : String.format(string, godUserData.getIntro());
        this.cQH.setOnClickListener(erVar);
        this.cQH.setText(format2);
        this.cQC.setVisibility(8);
        if (this.cQI == null) {
            this.cQI = new TextView(this.cNL.getActivity());
            this.cQI.setTextSize(0, this.cNL.getResources().getDimensionPixelSize(t.e.fontsize24));
            this.cQI.setGravity(17);
            this.cQI.setOnClickListener(eqVar);
            ColumnLayout.a aVar4 = new ColumnLayout.a(this.cNL.getResources().getDimensionPixelSize(t.e.ds110), this.cNL.getResources().getDimensionPixelSize(t.e.ds50), 80, 3);
            aVar4.bottomMargin = this.cNL.getResources().getDimensionPixelSize(t.e.ds22);
            this.cQs.addView(this.cQI, -1, aVar4);
        }
        a(this.cQI, godUserData.getFollowed() == 1);
        if (this.cRu || (godUserData.getFollowed() == 1 && godUserData.getIsFromNetWork())) {
            this.cQI.setVisibility(8);
        } else {
            this.cQI.setVisibility(0);
        }
        if (this.cQr.findViewWithTag("pb_god_bottom_line_view_tag") == null) {
            View view = new View(this.cNL.getApplicationContext());
            view.setTag("pb_god_bottom_line_view_tag");
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, this.cNL.getResources().getDimensionPixelSize(t.e.ds1));
            layoutParams2.topMargin = this.cNL.getResources().getDimensionPixelSize(t.e.ds18);
            layoutParams2.bottomMargin = this.cNL.getResources().getDimensionPixelSize(t.e.ds1);
            com.baidu.tbadk.core.util.ar.l(view, t.d.cp_bg_line_a);
            this.cQr.addView(view, layoutParams2);
        }
        if (this.cSe == null) {
            this.cSe = new TextView(this.cNL.getApplicationContext());
            this.cSe.setId(t.g.pb_god_user_tip_content);
            this.cSe.setEllipsize(TextUtils.TruncateAt.END);
            this.cSe.setGravity(17);
            this.cSe.setSingleLine(true);
            this.cSe.setHeight(this.cNL.getResources().getDimensionPixelSize(t.e.ds56));
            this.cSe.setTextSize(0, this.cNL.getResources().getDimensionPixelSize(t.e.fontsize24));
            this.cSe.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams3.addRule(3, t.g.title_wrapper);
            this.cFw.addView(this.cSe, layoutParams3);
            this.cNL.getLayoutMode().x(this.cSe);
        }
        com.baidu.tbadk.core.util.ar.k(this.cSe, t.d.cp_link_tip_a_alpha80);
        com.baidu.tbadk.core.util.ar.j((View) this.cSe, t.d.cp_cont_g);
        this.cSe.setOnClickListener(new es(this));
        this.cSe.setText(String.format(this.cNL.getResources().getString(t.j.god_user_floor_owner_tip), com.baidu.tbadk.core.util.aw.x(this.cSf)));
        lc(this.cSf);
        if (this.cSd == null) {
            this.cSd = (LinearLayout) LayoutInflater.from(this.cNL.getActivity()).inflate(t.h.god_floating_view, (ViewGroup) null);
            this.cSd.setOnClickListener(erVar);
            this.cSd.setTag(t.g.tag_user_id, String.valueOf(userIdLong));
            this.cSd.setTag(t.g.tag_user_name, userName);
            GodHeadImageView godHeadImageView = (GodHeadImageView) this.cSd.findViewById(t.g.god_floating_owner_photo);
            godHeadImageView.setOnClickListener(erVar);
            if (!this.cJY) {
                godHeadImageView.setVisibility(8);
            }
            godHeadImageView.setTag(rVar.getAuthor().getUserId());
            godHeadImageView.d(rVar.getAuthor().getPortrait(), 28, false);
            View findViewById = this.cSd.findViewById(t.g.god_floating_owner_info_floor_owner);
            if (str2 != null && !str2.equals("0") && str2.equals(rVar.getAuthor().getUserId())) {
                findViewById.setVisibility(0);
            } else {
                findViewById.setVisibility(8);
            }
            ImageView imageView = (ImageView) this.cSd.findViewById(t.g.god_floating_owner_info_user_rank);
            int level_id = rVar.getAuthor().getLevel_id();
            int is_bawu = rVar.getAuthor().getIs_bawu();
            String bawu_type = rVar.getAuthor().getBawu_type();
            int i = 3;
            if (level_id != 0) {
                imageView.setVisibility(0);
                com.baidu.tbadk.core.util.ar.c(imageView, BitmapHelper.getGradeResourceIdNew(level_id));
                imageView.setOnClickListener(null);
            } else {
                imageView.setVisibility(8);
            }
            ImageView imageView2 = (ImageView) this.cSd.findViewById(t.g.god_floating_owner_info_user_bawu);
            if (is_bawu != 0) {
                if (bawu_type.equals("manager")) {
                    com.baidu.tbadk.core.util.ar.c(imageView2, t.f.pb_manager);
                    imageView.setVisibility(8);
                    imageView2.setVisibility(0);
                } else if (bawu_type.equals("assist")) {
                    com.baidu.tbadk.core.util.ar.c(imageView2, t.f.pb_assist);
                    imageView.setVisibility(8);
                    imageView2.setVisibility(0);
                }
            }
            ImageView imageView3 = (ImageView) this.cSd.findViewById(t.g.god_floating_owner_info_user_gender);
            if (rVar.getAuthor().getGender() == 2) {
                com.baidu.tbadk.core.util.ar.c(imageView3, t.f.icon_pb_pop_girl);
                imageView3.setVisibility(0);
            } else if (rVar.getAuthor().getGender() == 1) {
                com.baidu.tbadk.core.util.ar.c(imageView3, t.f.icon_pb_pop_boy);
                imageView3.setVisibility(0);
            } else {
                imageView3.setVisibility(8);
            }
            if (!StringUtils.isNull(rVar.getAuthor().getName_show()) && com.baidu.adp.lib.util.j.aU(rVar.getAuthor().getName_show()) > 14) {
                i = 0;
            }
            ArrayList<IconData> iconInfo = rVar.getAuthor().getIconInfo();
            ArrayList<IconData> tShowInfoNew = rVar.getAuthor().getTShowInfoNew();
            UserIconBox userIconBox = (UserIconBox) this.cSd.findViewById(t.g.god_floating_owner_info_user_icon);
            UserIconBox userIconBox2 = (UserIconBox) this.cSd.findViewById(t.g.god_floating_owner_info_tshow_icon);
            if (userIconBox != null) {
                userIconBox.setTag(t.g.tag_user_id, rVar.getAuthor().getUserId());
                userIconBox.setOnClickListener(this.cNL.cML.bkj);
                userIconBox.a(iconInfo, i, this.cNL.getResources().getDimensionPixelSize(t.e.pb_icon_width), this.cNL.getResources().getDimensionPixelSize(t.e.pb_icon_height), this.cNL.getResources().getDimensionPixelSize(t.e.pb_icon_margin));
            }
            if (userIconBox2 != null) {
                userIconBox2.setOnClickListener(this.cNL.cML.cSF);
                userIconBox2.a(tShowInfoNew, 3, this.cNL.getResources().getDimensionPixelSize(t.e.small_icon_width), this.cNL.getResources().getDimensionPixelSize(t.e.small_icon_height), this.cNL.getResources().getDimensionPixelSize(t.e.big_icon_margin), true);
            }
            TextView textView = (TextView) this.cSd.findViewById(t.g.god_floating_owner_info_user_name);
            if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                com.baidu.tbadk.core.util.ar.b(textView, t.d.cp_cont_h, 1);
            } else {
                com.baidu.tbadk.core.util.ar.b(textView, t.d.cp_cont_f, 1);
            }
            textView.setText(rVar.getAuthor().getName_show());
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams4.addRule(3, t.g.title_wrapper);
            this.cFw.addView(this.cSd, layoutParams4);
            this.cNL.getLayoutMode().x(this.cSd);
        }
        TextView textView2 = (TextView) this.cSd.findViewById(t.g.god_floating_gift);
        textView2.setOnClickListener(eqVar);
        a(textView2, godUserData.getFollowed() == 1);
        ImageView imageView4 = (ImageView) this.cSd.findViewById(t.g.god_floating_arrow);
        com.baidu.tbadk.core.util.ar.c(imageView4, t.f.icon_arrow_tab);
        if (this.cRu || (godUserData.getFollowed() == 1 && godUserData.getIsFromNetWork())) {
            textView2.setVisibility(8);
            imageView4.setVisibility(0);
        } else {
            textView2.setVisibility(0);
            imageView4.setVisibility(8);
        }
        TextView textView3 = (TextView) this.cSd.findViewById(t.g.god_floating_intro);
        if (textView3 != null) {
            textView3.setText(format);
        }
        this.cSl = this.cQW.wY();
        if (this.cSl != null && !this.cRu && !z && z2 && (godUserData.getFollowed() != 1 || !godUserData.getIsFromNetWork())) {
            this.cQW.wZ();
            this.cQW.wX();
            this.cSh = this.cSl.findViewWithTag("pb_god_bottom_extra_line_view_tag");
            if (this.cSh == null) {
                this.cSh = new View(this.cNL.getApplicationContext());
                this.cSh.setTag("pb_god_bottom_extra_line_view_tag");
                this.cSl.addView(this.cSh, new LinearLayout.LayoutParams(-1, this.cNL.getResources().getDimensionPixelSize(t.e.ds20)));
                this.cSj = new GodHeadImageView(this.cNL.getApplicationContext());
                this.cSj.setTag("pb_god_bottom_extra_god_avatar_tag");
                this.cSj.setShowType(0);
                this.cSj.setShapeType(1);
                this.cSj.d(portrait, 28, false);
                this.cSj.setTag(t.g.tag_user_id, String.valueOf(userIdLong));
                this.cSj.setTag(t.g.tag_user_name, userName);
                this.cSj.setOnClickListener(erVar);
                LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(this.cNL.getResources().getDimensionPixelSize(t.e.ds130), this.cNL.getResources().getDimensionPixelSize(t.e.ds130));
                layoutParams5.topMargin = this.cNL.getResources().getDimensionPixelSize(t.e.ds40);
                layoutParams5.gravity = 1;
                this.cSl.addView(this.cSj, layoutParams5);
                this.cSk = new TextView(this.cNL.getApplicationContext());
                this.cSk.setTag("pb_god_bottom_extra_text_view_tag");
                this.cSk.setSingleLine(true);
                this.cSk.setTextSize(0, this.cNL.getResources().getDimensionPixelSize(t.e.fontsize24));
                LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams6.topMargin = this.cNL.getResources().getDimensionPixelSize(t.e.ds36);
                layoutParams6.gravity = 1;
                this.cSk.setText(this.cNL.getResources().getString(t.j.god_user_attention_tip));
                this.cSl.addView(this.cSk, layoutParams6);
                this.cSi = new TextView(this.cNL.getApplicationContext());
                this.cSi.setTag("pb_god_bottom_extra_attention_btn_tag");
                this.cSi.setSingleLine(true);
                this.cSi.setGravity(17);
                this.cSi.setTextSize(0, this.cNL.getResources().getDimensionPixelSize(t.e.fontsize24));
                this.cSi.setOnClickListener(eqVar);
                LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(this.cNL.getResources().getDimensionPixelSize(t.e.ds212), this.cNL.getResources().getDimensionPixelSize(t.e.ds54));
                layoutParams7.topMargin = this.cNL.getResources().getDimensionPixelSize(t.e.ds30);
                layoutParams7.bottomMargin = this.cNL.getResources().getDimensionPixelSize(t.e.ds40);
                layoutParams7.gravity = 1;
                this.cSl.addView(this.cSi, layoutParams7);
            } else {
                this.cSi = (TextView) this.cSl.findViewWithTag("pb_god_bottom_extra_attention_btn_tag");
                this.cSj = (GodHeadImageView) this.cSl.findViewWithTag("pb_god_bottom_extra_god_avatar_tag");
                this.cSk = (TextView) this.cSl.findViewWithTag("pb_god_bottom_extra_text_view_tag");
                this.cSh = this.cSl.findViewWithTag("pb_god_bottom_extra_line_view_tag");
            }
            com.baidu.tbadk.core.util.ar.l(this.cSl, t.d.cp_bg_line_d);
            com.baidu.tbadk.core.util.ar.l(this.cSh, t.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.ar.b(this.cSk, t.d.cp_cont_c, 1);
            this.cSl.setOnTouchListener(new et(this));
            boolean z3 = godUserData.getFollowed() == 1;
            a(this.cSi, z3);
            if (!z3) {
                this.cSi.setPadding(this.cNL.getResources().getDimensionPixelSize(t.e.ds68), 0, this.cNL.getResources().getDimensionPixelSize(t.e.ds52), 0);
            }
        } else {
            this.cQW.xa();
            this.cQW.wW();
        }
        return true;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.cRY && !this.cRZ && i > this.cQl) {
            this.cSb = true;
        } else {
            this.cSb = false;
            arG();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL));
    }

    private void lc(int i) {
        boolean z;
        if (this.cSe != null && this.cSe.getVisibility() != 0 && i >= 2 && !this.cRu) {
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                z = com.baidu.tbadk.core.sharedPref.b.uO().getBoolean("pb_god_floor_owner_tip_has_shown_" + TbadkCoreApplication.getCurrentAccount(), false);
            } else {
                z = com.baidu.tbadk.core.sharedPref.b.uO().getBoolean("pb_god_floor_owner_not_login_tip_has_shown_" + TbadkCoreApplication.getCurrentAccount(), false);
            }
            if (!z) {
                this.cSg = true;
                this.cSe.setVisibility(0);
            }
            com.baidu.adp.lib.h.h.hr().postDelayed(this.cSv, 3000L);
        }
    }

    public void arF() {
        com.baidu.adp.lib.h.h.hr().removeCallbacks(this.cSv);
        if (this.cSe != null && 8 != this.cSe.getVisibility()) {
            com.baidu.tieba.tbadkCore.a.a(this.cNL, this.cSe, t.a.fade_out, new eu(this));
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                com.baidu.tbadk.core.sharedPref.b.uO().putBoolean("pb_god_floor_owner_tip_has_shown_" + TbadkCoreApplication.getCurrentAccount(), true);
            } else {
                com.baidu.tbadk.core.sharedPref.b.uO().putBoolean("pb_god_floor_owner_not_login_tip_has_shown_" + TbadkCoreApplication.getCurrentAccount(), true);
            }
        }
    }

    public void arG() {
        if (this.cSd != null && this.cSd.getVisibility() != 8) {
            this.cSd.setVisibility(8);
        }
    }

    public void arH() {
        if (this.cRY && this.cSb && !this.cSa && this.cSd != null && this.cSd.getVisibility() != 0 && !this.cSg) {
            this.cSa = true;
            if (this.cSc) {
                this.cSd.setVisibility(0);
                this.cSc = false;
                this.cSa = false;
                return;
            }
            com.baidu.tieba.tbadkCore.a.a(this.cNL, this.cSd, t.a.fade_in_10to100, new ew(this));
        }
    }

    public void arI() {
        if (!this.cSu) {
            TiebaStatic.log("c10490");
            this.cSu = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cNL.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(cRP, Integer.valueOf(cRR));
            aVar.bX(t.j.grade_thread_tips);
            View inflate = LayoutInflater.from(this.cNL.getPageContext().getPageActivity()).inflate(t.h.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(t.g.function_description_view)).setText(t.j.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(t.g.title_view)).setText(t.j.grade_thread_tips);
            aVar.z(inflate);
            aVar.x(sparseArray);
            aVar.a(t.j.grade_button_tips, this.cNL);
            aVar.b(t.j.look_again, new ex(this));
            aVar.b(this.cNL.getPageContext()).uj();
        }
    }

    public void arJ() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cNL.getPageContext().getPageActivity());
        aVar.cE(this.cNL.getResources().getString(t.j.upgrade_to_new_photo_live_tips));
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(cRP, Integer.valueOf(cRT));
        aVar.x(sparseArray);
        aVar.a(t.j.upgrade_to_new, this.cNL);
        aVar.b(t.j.cancel, new ey(this));
        aVar.b(this.cNL.getPageContext()).uj();
    }

    public int tj() {
        return this.cRM;
    }

    public void kP(String str) {
        if (str.contains("_")) {
            str = str.replace("_", "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cNL.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.cNL.getPageContext().getPageActivity()).inflate(t.h.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(t.g.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(t.g.function_description_view)).setVisibility(8);
        aVar.z(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(cRP, Integer.valueOf(cRS));
        aVar.x(sparseArray);
        aVar.a(t.j.view, this.cNL);
        aVar.b(t.j.cancel, new ez(this));
        aVar.b(this.cNL.getPageContext()).uj();
    }

    public void a(int i, com.baidu.tieba.pb.a.c cVar, boolean z, int i2) {
        com.baidu.tieba.tbadkCore.data.r a;
        if (i > 0 && (a = a(cVar, z, i2)) != null && a.getAuthor() != null) {
            MetaData author = a.getAuthor();
            author.setGiftNum(author.getGiftNum() + i);
        }
    }

    public void c(com.baidu.tieba.pb.a.c cVar, boolean z, int i) {
        b(cVar, z, i);
    }

    private void a(TextView textView, boolean z) {
        if (z) {
            textView.setClickable(false);
            com.baidu.tbadk.core.util.ar.b(textView, t.d.cp_cont_d, 1);
            textView.setText(TbadkCoreApplication.m411getInst().getString(t.j.relate_forum_is_followed));
            textView.setBackgroundDrawable(null);
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setPadding(0, 0, 0, 0);
            return;
        }
        com.baidu.tbadk.core.util.ar.b(textView, t.d.btn_forum_focus_color, 1);
        textView.setText(TbadkCoreApplication.m411getInst().getString(t.j.forum_list_attention_tv));
        com.baidu.tbadk.core.util.ar.k(textView, t.f.btn_focus_border_bg);
        textView.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.ar.getDrawable(t.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        textView.setClickable(true);
        textView.setPadding(TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds18), 0, TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds10), 0);
    }

    public LinearLayout arK() {
        return this.cRK;
    }

    private void m(com.baidu.tieba.pb.a.c cVar) {
        if (cVar != null && cVar.aoF() != null && cVar.aoF().tP()) {
            int tC = cVar.aoF().tC();
            this.cRK.setVisibility(0);
            switch (tC) {
                case 1:
                    this.cRL.setText(this.cNL.getPageContext().getPageActivity().getString(t.j.interview_live_before_start));
                    return;
                case 2:
                    this.cRL.setText(this.cNL.getPageContext().getPageActivity().getString(t.j.interview_live_start));
                    return;
                case 3:
                    this.cRL.setText(this.cNL.getPageContext().getPageActivity().getString(t.j.interview_live_finished));
                    return;
                default:
                    this.cRK.setVisibility(8);
                    return;
            }
        }
    }
}
