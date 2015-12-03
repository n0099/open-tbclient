package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
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
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.location.BDLocationStatusCodes;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LiveRoomEntranceActivityConfig;
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.q;
import com.baidu.tbadk.coreExtra.view.LiveBroadcastCard;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.editortools.sendtool.SendView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.n;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.tbadkCore.FrsPraiseView;
import com.baidu.tieba.tbadkCore.b.a;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tbclient.GodInfo;
/* loaded from: classes.dex */
public class da {
    public static int cFJ = 2;
    public static int cFK = 3;
    public static int cFL = 0;
    public static int cFM = 3;
    public static int cFN = 4;
    public static int cFO = 5;
    public static int cFP = 6;
    private com.baidu.tbadk.editortools.k KS;
    private NoNetworkView aQl;
    private BdTypeListView aRs;
    private q.a afB;
    private View axh;
    private View.OnClickListener bcT;
    private View.OnClickListener cAv;
    PbActivity.b cCd;
    private PbActivity cCy;
    private ImageView cEA;
    private TextView cEB;
    private TextView cEF;
    private View cEJ;
    private View cEL;
    private RelativeLayout cEM;
    private br cEN;
    private PbListView cES;
    private View cEU;
    public int cEj;
    private View cEl;
    public final com.baidu.tieba.pb.pb.main.b.c cEm;
    private List<com.baidu.tieba.pb.pb.main.b.a> cEn;
    private View cEo;
    private LinearLayout cEq;
    private ColumnLayout cEr;
    private TextView cEs;
    private TextView cEt;
    private HeadImageView cEu;
    private ImageView cEv;
    private ImageView cEw;
    private ImageView cEx;
    private UserIconBox cEy;
    private UserIconBox cEz;
    private View cFE;
    private LiveBroadcastCard cFF;
    private View cFG;
    private TextView cFH;
    private Runnable cFQ;
    private Runnable cFR;
    private View cFt;
    private TextView cFu;
    private TextView cFv;
    private TextView cFw;
    private boolean cFy;
    private PbActivity.a cGc;
    private RelativeLayout cuP;
    private com.baidu.tieba.pb.b.c czP;
    private int cEk = 0;
    private View cEp = null;
    private TextView cEC = null;
    private TextView cED = null;
    private TextView cEE = null;
    public FrsPraiseView cEG = null;
    private View cEH = null;
    private View cEI = null;
    private View cEK = null;
    private com.baidu.tbadk.core.dialog.a cEO = null;
    private com.baidu.tbadk.core.dialog.c bcJ = null;
    private View cEP = null;
    private EditText cEQ = null;
    private com.baidu.tieba.pb.view.g cER = null;
    private com.baidu.tieba.pb.view.b cET = null;
    private c.b bRd = null;
    private TbRichTextView.d aDR = null;
    private NoNetworkView.a aXw = null;
    private Dialog cEV = null;
    private View cEW = null;
    private com.baidu.tbadk.core.dialog.a cEX = null;
    private Dialog cEY = null;
    private View cEZ = null;
    private int cFa = 0;
    private RadioGroup Nk = null;
    private RadioButton cFb = null;
    private RadioButton cFc = null;
    private RadioButton cFd = null;
    private Button cFe = null;
    private Button cFf = null;
    private TextView cFg = null;
    private Dialog cFh = null;
    private View cFi = null;
    private LinearLayout cFj = null;
    private CompoundButton.OnCheckedChangeListener cFk = null;
    private TextView cFl = null;
    private TextView cFm = null;
    private String cFn = null;
    private com.baidu.tbadk.core.dialog.c cFo = null;
    private boolean cFp = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView cFq = null;
    private boolean cFr = false;
    private Button cFs = null;
    private boolean cFx = true;
    private LinearLayout cFz = null;
    private TextView cFA = null;
    private TextView cFB = null;
    private View aFP = null;
    private com.baidu.tbadk.core.view.b cFC = null;
    private boolean czN = false;
    private boolean cFD = false;
    private boolean mIsFromCDN = true;
    private int cFI = 0;
    private boolean cFS = true;
    private a.InterfaceC0084a cFT = new db(this);
    private boolean cFU = false;
    private boolean cFV = false;
    private boolean cFW = false;
    private boolean cFX = false;
    private boolean cFY = false;
    private LinearLayout cFZ = null;
    private CustomMessageListener cGa = new dk(this, CmdConfigCustom.PB_SHOW_MULTIIAMGETOOL);
    private final View.OnClickListener cGb = new dw(this);
    private View.OnLongClickListener onLongClickListener = null;
    private boolean cGd = true;
    private boolean cGe = false;
    private boolean WM = false;
    String userId = null;
    private final List<TbImageView> cGf = new ArrayList();
    private boolean cAl = true;
    private boolean cGg = false;

    public NoNetworkView all() {
        return this.aQl;
    }

    public void alm() {
        if (this.KS != null) {
            this.KS.hide();
        }
    }

    public void aln() {
        reset();
        this.cFx = true;
        if (this.KS != null) {
            this.KS.hide();
        }
        if (this.cFt != null) {
            if (this.cFr) {
                fl(false);
            } else {
                fm(false);
            }
        }
    }

    private void reset() {
        if (this.cCy != null && this.cCy.ajY() != null && this.KS != null) {
            com.baidu.tbadk.editortools.d.b.BV().setStatus(0);
            com.baidu.tbadk.editortools.d.e ajY = this.cCy.ajY();
            ajY.Cu();
            if (ajY.getWriteImagesInfo() != null) {
                ajY.getWriteImagesInfo().setMaxImagesAllowed(10);
            }
            ajY.er(10);
            ajY.ep(SendView.ALL);
            ajY.eq(SendView.ALL);
            ajY.fn(this.cCy.getActivity().getString(n.i.pb_reply_hint));
            com.baidu.tbadk.editortools.r eg = this.KS.eg(23);
            com.baidu.tbadk.editortools.r eg2 = this.KS.eg(2);
            com.baidu.tbadk.editortools.r eg3 = this.KS.eg(5);
            if (eg2 != null) {
                eg2.oD();
            }
            if (eg3 != null) {
                eg3.oD();
            }
            if (eg != null) {
                eg.hide();
            }
            this.KS.invalidate();
        }
    }

    public boolean alo() {
        return this.cFx;
    }

    public void fl(boolean z) {
        if (this.cFt != null && this.cFu != null && this.cFv != null) {
            this.cFu.setText(n.i.draft_to_send);
            this.cFv.setVisibility(8);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.cFt.startAnimation(alphaAnimation);
            }
            this.cFt.setVisibility(0);
        }
    }

    public void fm(boolean z) {
        if (this.cFt != null && this.cFu != null && this.cFv != null) {
            this.cFu.setText(n.i.reply_floor_host);
            this.cFv.setVisibility(0);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.cFt.startAnimation(alphaAnimation);
            }
            this.cFt.setVisibility(0);
        }
    }

    public com.baidu.tieba.tbadkCore.data.o alp() {
        int i;
        View childAt;
        int i2 = 0;
        if (this.aRs == null) {
            return null;
        }
        int firstVisiblePosition = this.aRs.getFirstVisiblePosition();
        int lastVisiblePosition = this.aRs.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.aRs.getChildCount();
            int i3 = 0;
            for (int i4 = firstVisiblePosition; i4 <= lastVisiblePosition; i4++) {
                if (i4 - firstVisiblePosition < childCount && (childAt = this.aRs.getChildAt(i4 - firstVisiblePosition)) != null) {
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
        int headerViewsCount = i - this.aRs.getHeaderViewsCount();
        if (headerViewsCount < 0) {
            headerViewsCount = 0;
        }
        if (this.cEN.jR(headerViewsCount) != null && this.cEN.jR(headerViewsCount) != com.baidu.tieba.tbadkCore.data.o.dzy) {
            i2 = headerViewsCount + 1;
        }
        return (com.baidu.tieba.tbadkCore.data.o) this.cEN.aB(i2);
    }

    public da(PbActivity pbActivity, View.OnClickListener onClickListener, com.baidu.tieba.pb.b.c cVar) {
        this.cCy = null;
        this.cuP = null;
        this.cEl = null;
        this.aRs = null;
        this.cEo = null;
        this.cEq = null;
        this.cEr = null;
        this.cEs = null;
        this.cEt = null;
        this.cEu = null;
        this.cEv = null;
        this.cEw = null;
        this.cEx = null;
        this.cEy = null;
        this.cEz = null;
        this.cEA = null;
        this.cEB = null;
        this.cEF = null;
        this.cEJ = null;
        this.cEL = null;
        this.cEN = null;
        this.cES = null;
        this.axh = null;
        this.bcT = null;
        this.cAv = null;
        this.cFt = null;
        this.cFu = null;
        this.cFw = null;
        this.cFG = null;
        this.cFH = null;
        this.cCy = pbActivity;
        this.bcT = onClickListener;
        this.czP = cVar;
        this.cuP = (RelativeLayout) LayoutInflater.from(this.cCy.getPageContext().getPageActivity()).inflate(n.g.new_pb_activity, (ViewGroup) null);
        this.cCy.addContentView(this.cuP, new FrameLayout.LayoutParams(-1, -1));
        this.cEl = this.cCy.findViewById(n.f.statebar_view);
        this.cEM = (RelativeLayout) this.cCy.findViewById(n.f.title_wrapper);
        this.aQl = (NoNetworkView) this.cCy.findViewById(n.f.view_no_network);
        this.aRs = (BdTypeListView) this.cCy.findViewById(n.f.new_pb_list);
        View view = new View(this.cCy.getPageContext().getPageActivity());
        view.setLayoutParams(new AbsListView.LayoutParams(-1, this.cCy.getResources().getDimensionPixelSize(n.d.pb_editor_height)));
        this.aRs.addFooterView(view);
        this.cEm = new com.baidu.tieba.pb.pb.main.b.c(pbActivity);
        this.cEm.ama().setOnTouchListener(new com.baidu.tieba.pb.b.a(new dy(this)));
        this.cFt = this.cCy.findViewById(n.f.pb_editor_tool_comment);
        this.cFu = (TextView) this.cCy.findViewById(n.f.pb_editor_tool_comment_reply_text);
        this.cFw = (TextView) this.cCy.findViewById(n.f.pb_editor_tool_comment_praise_icon);
        this.cFv = (TextView) this.cCy.findViewById(n.f.pb_editor_tool_comment_reply_count_text);
        this.cFu.setOnClickListener(new dz(this));
        this.cFw.setOnClickListener(this.bcT);
        this.cFw.setOnTouchListener(this.cCy);
        this.cEo = LayoutInflater.from(this.cCy.getPageContext().getPageActivity()).inflate(n.g.new_pb_header_item, (ViewGroup) null);
        this.cEq = (LinearLayout) LayoutInflater.from(this.cCy.getPageContext().getPageActivity()).inflate(n.g.new_pb_header_user_item, (ViewGroup) null);
        this.cEr = (ColumnLayout) this.cEq.findViewById(n.f.pb_head_owner_root);
        this.cEr.setOnLongClickListener(this.onLongClickListener);
        this.cEr.setOnTouchListener(this.czP);
        this.cEr.setVisibility(8);
        this.cEo.setOnTouchListener(this.czP);
        this.cEs = (TextView) this.cEo.findViewById(n.f.pb_head_post_title);
        this.cEs.setTextSize(TbConfig.getContentSizeOfPostTitle());
        this.cEs.setVisibility(8);
        this.cFG = this.cEo.findViewById(n.f.pb_head_activity_join_number_container);
        this.cFG.setVisibility(8);
        this.cFH = (TextView) this.cEo.findViewById(n.f.pb_head_activity_join_number);
        this.cEt = (TextView) this.cEr.findViewById(n.f.pb_head_owner_info_user_name);
        this.cEu = (HeadImageView) this.cEr.findViewById(n.f.pb_head_owner_photo);
        if (!this.cAl) {
            this.cEu.setVisibility(8);
        }
        this.cEv = (ImageView) this.cEr.findViewById(n.f.pb_head_owner_info_user_rank);
        this.cEw = (ImageView) this.cEr.findViewById(n.f.pb_head_owner_info_user_gender);
        this.cEx = (ImageView) this.cEr.findViewById(n.f.pb_head_owner_info_user_bawu);
        this.cEy = (UserIconBox) this.cEr.findViewById(n.f.pb_head_owner_info_user_icon);
        this.cEz = (UserIconBox) this.cEr.findViewById(n.f.pb_head_owner_info_tshow_icon);
        this.cEA = (ImageView) this.cEr.findViewById(n.f.pb_head_owner_info_floor_owner);
        this.cEB = (TextView) this.cEr.findViewById(n.f.pb_head_owner_info_time);
        this.cEF = (TextView) this.cEo.findViewById(n.f.pb_head_reverse_hint);
        this.cEF.setOnClickListener(this.bcT);
        this.cEF.setVisibility(8);
        this.cEJ = this.cEo.findViewById(n.f.new_pb_header_item_line_below_livepost);
        this.cEL = this.cEo.findViewById(n.f.new_pb_header_item_line_above_showpassed);
        this.cEo.setOnLongClickListener(new ea(this));
        alt();
        this.cEN = new br(this.cCy, this.aRs);
        this.cEN.C(this.bcT);
        this.cEN.a(this.czP);
        this.cEN.setOnImageClickListener(this.aDR);
        this.cAv = new eb(this);
        this.cEN.B(this.cAv);
        this.aRs.addHeaderView(this.cEq);
        this.aRs.addHeaderView(this.cEo);
        this.cES = new PbListView(this.cCy.getPageContext().getPageActivity());
        this.axh = this.cES.getView().findViewById(n.f.pb_more_view);
        if (this.axh != null) {
            this.axh.setOnClickListener(this.bcT);
            com.baidu.tbadk.core.util.as.i(this.axh, n.e.pb_foot_more_trans_selector);
        }
        this.cES.we();
        this.cES.cT(n.e.pb_foot_more_trans_selector);
        this.cES.cU(n.e.pb_foot_more_trans_selector);
        this.cEU = this.cCy.findViewById(n.f.viewstub_progress);
        this.cCy.registerListener(this.cGa);
    }

    public void fn(boolean z) {
        this.cEm.fn(z);
        if (z && this.cFD) {
            this.cES.setText(this.cCy.getResources().getString(n.i.click_load_more));
            this.aRs.setNextPage(this.cES);
        }
    }

    public void setEditorTools(com.baidu.tbadk.editortools.k kVar) {
        this.KS = kVar;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.cuP.addView(this.KS, layoutParams);
        this.KS.onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        this.KS.hide();
    }

    public void alq() {
        if (this.cCy != null && this.KS != null) {
            this.KS.oD();
        }
    }

    public void kJ(String str) {
        if (this.cFv != null) {
            if (TextUtils.isEmpty(str)) {
                str = "0";
            }
            this.cFv.setText(this.cCy.getPageContext().getResources().getString(n.i.pb_reply_count_text, str));
        }
    }

    public void E(String str, boolean z) {
        this.cFy = z;
        fo(TbadkCoreApplication.m411getInst().getSkinType() == 1);
    }

    private void fo(boolean z) {
        if (this.cFw != null) {
            if (this.cFy) {
                com.baidu.tbadk.core.util.as.i((View) this.cFw, n.e.pb_praise_already_click_selector);
            } else {
                com.baidu.tbadk.core.util.as.i((View) this.cFw, n.e.pb_praise_normal_click_selector);
            }
        }
    }

    public TextView alr() {
        return this.cFw;
    }

    public void fp(boolean z) {
        if (this.aRs != null) {
            if (!z) {
                this.aRs.setEnabled(z);
                return;
            }
            if (this.cFR == null) {
                this.cFR = new ec(this, z);
            }
            com.baidu.adp.lib.h.h.hj().postDelayed(this.cFR, 10L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fq(boolean z) {
        if (z) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cEl.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.cEl.setLayoutParams(layoutParams);
            this.cEl.setVisibility(0);
            return;
        }
        this.cEl.setVisibility(8);
    }

    public void aj(View view) {
        boolean z;
        View view2;
        if (this.cEM != null && view != null) {
            if (this.cFx) {
                z = this.cFt.getVisibility() == 0;
            } else {
                z = this.KS != null && this.KS.getVisibility() == 0;
            }
            boolean z2 = this.cEM.getVisibility() == 0;
            if (z2) {
                TiebaStatic.log("c10084");
                this.cFV = true;
                View findViewById = this.cCy.findViewById(n.f.bg_above_list);
                findViewById.setLayoutParams(new RelativeLayout.LayoutParams(-1, this.cEM.getHeight()));
                com.baidu.tieba.tbadkCore.a.a(this.cCy, this.cEM, n.a.top_fold_up, new ed(this, findViewById));
            } else {
                this.cFV = false;
                com.baidu.tieba.tbadkCore.a.a(this.cCy, this.cEM, n.a.top_fold_down, new dc(this));
            }
            if (this.cFx) {
                view2 = this.cFt;
            } else {
                view2 = this.KS;
            }
            if (z) {
                if (z2) {
                    if (this.KS != null) {
                        this.KS.zY();
                    }
                    com.baidu.tieba.tbadkCore.a.a(this.cCy, view2, n.a.bottom_fold_down, new dd(this));
                }
            } else if (!z2) {
                com.baidu.tieba.tbadkCore.a.a(this.cCy, view2, n.a.bottom_fold_up, new de(this));
            }
        }
    }

    public br als() {
        return this.cEN;
    }

    public void a(PbActivity.b bVar) {
        this.cCd = bVar;
    }

    private void a(com.baidu.tbadk.core.data.ac acVar) {
        if (acVar == null || acVar.tp() == 0) {
            if (this.cFs != null) {
                this.cFs.setVisibility(8);
            }
            if (this.cEI != null) {
                this.cEI.setVisibility(8);
                return;
            }
            return;
        }
        if (this.cFs == null) {
            this.cCy.getLayoutMode().k(((ViewStub) this.cEo.findViewById(n.f.live_talk_layout)).inflate());
            this.cFs = (Button) this.cEo.findViewById(n.f.pb_head_function_manage_go_to_live_post);
            this.cEI = this.cEo.findViewById(n.f.new_pb_header_item_line_above_livepost);
        }
        int tq = acVar.tq();
        String string = this.cCy.getPageContext().getString(n.i.go_to_live_post_prefix);
        if (tq == 0) {
            string = String.valueOf(string) + this.cCy.getPageContext().getString(n.i.go_to_interview_post);
        } else if (tq == 1) {
            string = String.valueOf(string) + this.cCy.getPageContext().getString(n.i.go_to_discuss_post);
        }
        this.cFs.setText(string);
        this.cFs.setVisibility(0);
        this.cFs.setOnClickListener(this.bcT);
        alG();
    }

    private void alt() {
        this.cFz = (LinearLayout) this.cEo.findViewById(n.f.btn_show_passed_pb);
        this.cFB = (TextView) this.cEo.findViewById(n.f.show_pre_page_view);
        this.cFA = (TextView) this.cEo.findViewById(n.f.go_back_top_view);
        this.aFP = this.cEo.findViewById(n.f.show_passed_divider);
        this.cFB.setOnClickListener(this.cGb);
        this.cFA.setOnClickListener(this.bcT);
        alG();
    }

    public void ak(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, boolean z) {
        SparseArray sparseArray2;
        if (this.cEW == null) {
            this.cEW = LayoutInflater.from(this.cCy.getPageContext().getPageActivity()).inflate(n.g.forum_manage_dialog, (ViewGroup) null);
        }
        this.cCy.getLayoutMode().k(this.cEW);
        if (this.cEV == null) {
            this.cEV = new Dialog(this.cCy.getPageContext().getPageActivity(), n.j.common_alert_dialog);
            this.cEV.setCanceledOnTouchOutside(true);
            this.cEV.setCancelable(true);
            this.cEV.setContentView(this.cEW);
            WindowManager.LayoutParams attributes = this.cEV.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.k.K(this.cCy.getPageContext().getPageActivity()) * 0.9d);
            this.cEV.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.cEV.findViewById(n.f.del_post_btn);
        TextView textView2 = (TextView) this.cEV.findViewById(n.f.forbid_user_btn);
        TextView textView3 = (TextView) this.cEV.findViewById(n.f.disable_reply_btn);
        int intValue = sparseArray.get(n.f.tag_check_mute_from) instanceof Integer ? ((Integer) sparseArray.get(n.f.tag_check_mute_from)).intValue() : -1;
        if ("".equals(sparseArray.get(n.f.tag_del_post_id)) || intValue == 2) {
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
            if ((sparseArray.get(n.f.tag_del_post_type) instanceof Integer ? ((Integer) sparseArray.get(n.f.tag_del_post_type)).intValue() : -1) != 0) {
                textView.setText(n.i.delete);
            } else {
                textView.setText(n.i.delete_post);
            }
            sparseArray2.put(n.f.tag_del_post_id, sparseArray.get(n.f.tag_del_post_id));
            sparseArray2.put(n.f.tag_del_post_type, sparseArray.get(n.f.tag_del_post_type));
            sparseArray2.put(n.f.tag_del_post_is_self, sparseArray.get(n.f.tag_del_post_is_self));
            sparseArray2.put(n.f.tag_manage_user_identity, sparseArray.get(n.f.tag_manage_user_identity));
            textView.setOnClickListener(new df(this));
        }
        if ("".equals(sparseArray.get(n.f.tag_forbid_user_name))) {
            textView2.setVisibility(8);
        } else {
            SparseArray sparseArray5 = (SparseArray) textView2.getTag();
            if (sparseArray5 == null) {
                sparseArray5 = new SparseArray();
                textView2.setTag(sparseArray5);
            }
            textView2.setVisibility(0);
            sparseArray5.put(n.f.tag_forbid_user_name, sparseArray.get(n.f.tag_forbid_user_name));
            sparseArray5.put(n.f.tag_manage_user_identity, sparseArray.get(n.f.tag_manage_user_identity));
            sparseArray5.put(n.f.tag_forbid_user_post_id, sparseArray.get(n.f.tag_forbid_user_post_id));
            textView2.setOnClickListener(new dg(this));
        }
        if (!((sparseArray.get(n.f.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(n.f.tag_user_mute_visible)).booleanValue())) {
            textView3.setVisibility(8);
        } else {
            SparseArray sparseArray6 = (SparseArray) textView3.getTag();
            if (sparseArray6 == null) {
                sparseArray6 = new SparseArray();
                textView3.setTag(sparseArray6);
            }
            textView3.setVisibility(0);
            if (z) {
                textView3.setText(n.i.un_mute);
            } else {
                textView3.setText(n.i.mute);
            }
            sparseArray6.put(n.f.tag_is_mem, sparseArray.get(n.f.tag_is_mem));
            sparseArray6.put(n.f.tag_user_mute_mute_userid, sparseArray.get(n.f.tag_user_mute_mute_userid));
            sparseArray6.put(n.f.tag_user_mute_mute_username, sparseArray.get(n.f.tag_user_mute_mute_username));
            sparseArray6.put(n.f.tag_user_mute_post_id, sparseArray.get(n.f.tag_user_mute_post_id));
            sparseArray6.put(n.f.tag_user_mute_thread_id, sparseArray.get(n.f.tag_user_mute_thread_id));
            textView3.setOnClickListener(new dh(this, z));
        }
        com.baidu.adp.lib.h.j.a(this.cEV, this.cCy.getPageContext());
    }

    public void a(PbActivity.a aVar) {
        this.cGc = aVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(n.f.tag_del_post_id, str);
        sparseArray.put(n.f.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(n.f.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(n.f.tag_del_post_is_self, Boolean.valueOf(z));
        sparseArray.put(cFL, Integer.valueOf(cFM));
        int i3 = n.i.del_post_confirm;
        if (i == 0) {
            i3 = n.i.del_thread_confirm;
        }
        this.cEX = new com.baidu.tbadk.core.dialog.a(this.cCy.getActivity());
        this.cEX.bN(i3);
        this.cEX.x(sparseArray);
        this.cEX.a(n.i.dialog_ok, this.cCy);
        this.cEX.b(n.i.dialog_cancel, new di(this));
        this.cEX.al(true);
        this.cEX.b(this.cCy.getPageContext());
        this.cEX.tv();
    }

    public void X(ArrayList<com.baidu.tbadk.core.data.m> arrayList) {
        if (this.cFi == null) {
            this.cFi = LayoutInflater.from(this.cCy.getPageContext().getPageActivity()).inflate(n.g.commit_good, (ViewGroup) null);
        }
        this.cCy.getLayoutMode().k(this.cFi);
        if (this.cFh == null) {
            this.cFh = new Dialog(this.cCy.getPageContext().getPageActivity(), n.j.common_alert_dialog);
            this.cFh.setCanceledOnTouchOutside(true);
            this.cFh.setCancelable(true);
            this.cFq = (ScrollView) this.cFi.findViewById(n.f.good_scroll);
            this.cFh.setContentView(this.cFi);
            WindowManager.LayoutParams attributes = this.cFh.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.k.d(this.cCy.getPageContext().getPageActivity(), n.d.ds540);
            this.cFh.getWindow().setAttributes(attributes);
            this.cFk = new dj(this);
            this.cFj = (LinearLayout) this.cFi.findViewById(n.f.good_class_group);
            this.cFm = (TextView) this.cFi.findViewById(n.f.dialog_button_cancel);
            this.cFm.setOnClickListener(new dl(this));
            this.cFl = (TextView) this.cFi.findViewById(n.f.dialog_button_ok);
            this.cFl.setOnClickListener(this.bcT);
        }
        this.cFj.removeAllViews();
        this.cEn = new ArrayList();
        com.baidu.tieba.pb.pb.main.b.a ba = ba("0", this.cCy.getPageContext().getString(n.i.def_good_class));
        this.cEn.add(ba);
        ba.setChecked(true);
        this.cFj.addView(ba);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.tieba.pb.pb.main.b.a ba2 = ba(String.valueOf(arrayList.get(i2).rY()), arrayList.get(i2).rX());
                this.cEn.add(ba2);
                View view = new View(this.cCy.getPageContext().getPageActivity());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.d(this.cCy.getPageContext().getPageActivity(), n.d.ds1));
                com.baidu.tbadk.core.util.as.j(view, n.c.cp_bg_line_a);
                view.setLayoutParams(layoutParams);
                this.cFj.addView(view);
                this.cFj.addView(ba2);
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.cFq.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.k.dip2px(this.cCy.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.k.dip2px(this.cCy.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.k.dip2px(this.cCy.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.cFq.setLayoutParams(layoutParams2);
            this.cFq.removeAllViews();
            this.cFq.addView(this.cFj);
        }
        com.baidu.adp.lib.h.j.a(this.cFh, this.cCy.getPageContext());
    }

    private com.baidu.tieba.pb.pb.main.b.a ba(String str, String str2) {
        Activity pageActivity = this.cCy.getPageContext().getPageActivity();
        com.baidu.tieba.pb.pb.main.b.a aVar = new com.baidu.tieba.pb.pb.main.b.a(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.k.d(pageActivity, n.d.ds100));
        aVar.setOnCheckedChangeListener(this.cFk);
        aVar.setTag(str);
        aVar.setText(str2);
        aVar.setLayoutParams(layoutParams);
        return aVar;
    }

    public void alu() {
        this.cCy.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.cCy.hideProgressBar();
        if (z && z2) {
            this.cCy.showToast(this.cCy.getPageContext().getString(n.i.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.ax.isEmpty(str)) {
                str = TbadkCoreApplication.m411getInst().getResources().getString(n.i.neterror);
            }
            this.cCy.showToast(str);
        }
    }

    public void YT() {
        this.cEU.setVisibility(0);
    }

    public void YS() {
        this.cEU.setVisibility(8);
    }

    public View alv() {
        if (this.cFi != null) {
            return this.cFi.findViewById(n.f.dialog_button_ok);
        }
        return null;
    }

    public String alw() {
        return this.cFn;
    }

    public View getView() {
        return this.cuP;
    }

    public void alx() {
        com.baidu.adp.lib.util.k.c(this.cCy.getPageContext().getPageActivity(), this.cCy.getCurrentFocus());
    }

    public void aly() {
        this.cCy.showProgressBar();
    }

    public void fr(boolean z) {
        this.cCy.hideProgressBar();
        alO();
    }

    public void alz() {
        this.cES.startLoadData();
    }

    public void alA() {
    }

    public void alB() {
        this.cCy.hideProgressBar();
        this.cES.wf();
        alU();
        this.aRs.completePullRefresh();
        alG();
    }

    public void alC() {
        this.aRs.completePullRefresh();
        this.cFz.setVisibility(8);
        alG();
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.cEN.setOnLongClickListener(onLongClickListener);
    }

    public void a(c.b bVar, boolean z, boolean z2) {
        if (this.cFo != null) {
            this.cFo.dismiss();
            this.cFo = null;
        }
        this.cFo = new com.baidu.tbadk.core.dialog.c(this.cCy.getPageContext().getPageActivity());
        this.cFo.bQ(n.i.operation);
        if (z2) {
            this.cFo.a(new String[]{this.cCy.getPageContext().getString(n.i.copy)}, bVar);
        } else if (!z) {
            this.cFo.a(new String[]{this.cCy.getPageContext().getString(n.i.copy), this.cCy.getPageContext().getString(n.i.mark)}, bVar);
        } else {
            this.cFo.a(new String[]{this.cCy.getPageContext().getString(n.i.copy), this.cCy.getPageContext().getString(n.i.remove_mark)}, bVar);
        }
        this.cFo.d(this.cCy.getPageContext());
        this.cFo.tz();
    }

    public int alD() {
        int firstVisiblePosition = this.aRs.getFirstVisiblePosition();
        com.baidu.adp.widget.ListView.e eVar = (com.baidu.adp.widget.ListView.e) this.aRs.getAdapter();
        if (eVar != null) {
            if (eVar.getItem(firstVisiblePosition) instanceof com.baidu.tieba.pb.a.b) {
                firstVisiblePosition++;
            }
            int headersCount = (this.aRs.getAdapter() == null || !(this.aRs.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) ? 0 : ((com.baidu.adp.widget.ListView.e) this.aRs.getAdapter()).getHeadersCount();
            return firstVisiblePosition > headersCount ? firstVisiblePosition - headersCount : 0;
        }
        return firstVisiblePosition;
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.cEQ.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void i(com.baidu.tieba.pb.a.c cVar) {
        this.cEN.a(cVar);
        this.cEN.notifyDataSetChanged();
        if (cVar == null) {
            kJ("");
        } else {
            kJ(com.baidu.tbadk.core.util.ax.w(cVar.ajz().getReply_num()));
        }
        alG();
    }

    public void j(com.baidu.tieba.pb.a.c cVar) {
        PraiseData praise;
        if (this.cEG == null) {
            this.cCy.getLayoutMode().k(((ViewStub) this.cEo.findViewById(n.f.praise_layout)).inflate());
            this.cEG = (FrsPraiseView) this.cEo.findViewById(n.f.pb_head_praise_view);
            this.cEG.setIsFromPb(true);
            this.cEK = this.cEo.findViewById(n.f.new_pb_header_item_line_above_praise);
            this.cEG.cX(TbadkCoreApplication.m411getInst().getSkinType());
        }
        if (this.cEG != null) {
            boolean alG = alG();
            if (cVar != null && cVar.ajA() != null && cVar.ajA().size() > 0) {
                com.baidu.tieba.tbadkCore.data.o oVar = cVar.ajA().get(0);
                if ((!this.czN || oVar.aDd() != 1) && (praise = cVar.ajz().getPraise()) != null && praise.getUser() != null && praise.getUser().size() > 0) {
                    this.cEG.setVisibility(0);
                    this.cEG.setIsFromPb(true);
                    this.cEG.a(praise, cVar.ajz().getId(), praise.getPostId(), true);
                    this.cEK.setVisibility(0);
                    if (this.cEG.getVisibility() == 0) {
                        this.cEL.setVisibility(0);
                        return;
                    }
                    return;
                }
            }
            this.cEG.setVisibility(8);
            this.cEK.setVisibility(8);
            if (cVar != null && cVar.getPage() != null && cVar.getPage().sg() == 0 && this.czN) {
                this.cEK.setVisibility(8);
                if (alG) {
                    this.cEJ.setVisibility(0);
                    return;
                } else {
                    this.cEJ.setVisibility(8);
                    return;
                }
            }
            this.cEK.setVisibility(0);
            this.cEJ.setVisibility(8);
        }
    }

    private com.baidu.tieba.tbadkCore.data.o a(com.baidu.tieba.pb.a.c cVar, boolean z, int i) {
        if (z) {
            if (cVar == null || cVar.ajA() == null || cVar.ajA().size() <= 0) {
                return null;
            }
            com.baidu.tieba.tbadkCore.data.o oVar = cVar.ajA().get(0);
            if (oVar.aDd() != 1) {
                return k(cVar);
            }
            return oVar;
        }
        return k(cVar);
    }

    private com.baidu.tieba.tbadkCore.data.o k(com.baidu.tieba.pb.a.c cVar) {
        MetaData metaData;
        if (cVar == null || cVar.ajz() == null || cVar.ajz().getAuthor() == null) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.o oVar = new com.baidu.tieba.tbadkCore.data.o();
        MetaData author = cVar.ajz().getAuthor();
        String userId = author.getUserId();
        HashMap<String, MetaData> userMap = cVar.ajz().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = author;
        }
        oVar.mw(1);
        oVar.setId(cVar.ajz().sT());
        oVar.setTitle(cVar.ajz().getTitle());
        oVar.setTime(cVar.ajz().getCreateTime());
        oVar.setAuthor(metaData);
        return oVar;
    }

    private void b(com.baidu.tieba.pb.a.c cVar, boolean z, int i) {
        com.baidu.tieba.tbadkCore.data.o a;
        this.cEr.setVisibility(8);
        if (cVar != null && cVar.ajz() != null && (a = a(cVar, z, i)) != null) {
            String str = null;
            if (cVar != null && cVar.ajz() != null && cVar.ajz().getAuthor() != null) {
                str = cVar.ajz().getAuthor().getUserId();
            }
            this.cFU = !cVar.ajz().tc() && a(a, cVar.ajz().getId(), str);
            if (z) {
                this.cEF.setVisibility(8);
            } else {
                this.cEF.setVisibility(0);
            }
            this.cEr.setVisibility(0);
            SparseArray sparseArray = (SparseArray) this.cEr.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.cEr.setTag(sparseArray);
            }
            sparseArray.put(n.f.tag_clip_board, a);
            sparseArray.put(n.f.tag_is_subpb, false);
            this.cEB.setText(com.baidu.tbadk.core.util.ax.s(a.getTime()));
            cVar.ajz().tb();
            this.cEs.setVisibility(0);
            this.cEs.setText(cVar.ajz().getSpan_str());
            j(cVar);
            ArrayList<com.baidu.tbadk.core.data.a> sQ = cVar.ajz().sQ();
            if (sQ != null && sQ.size() > 0) {
                this.cFH.setText(String.valueOf(sQ.get(0).rA()));
                this.cFG.setVisibility(0);
            } else {
                this.cFG.setVisibility(8);
            }
            com.baidu.tbadk.core.util.as.i(this.cFG, n.e.activity_join_num_bg);
            com.baidu.tbadk.core.util.as.b(this.cFH, n.c.cp_link_tip_d, 1);
            boolean appResponseToIntentClass = TbadkCoreApplication.m411getInst().appResponseToIntentClass(LiveRoomEntranceActivityConfig.class);
            if (cVar != null && cVar.ajz() != null && cVar.ajz().getAnchorInfoData() != null) {
                if (cVar.ajz().getAnchorInfoData().getGroup_id() != 0 && appResponseToIntentClass) {
                    if (this.cFE == null) {
                        BdLog.e("pb time   liveCardLayout new");
                        this.cFE = ((ViewStub) this.cEo.findViewById(n.f.live_card_layout)).inflate();
                        this.cCy.getLayoutMode().k(this.cFE);
                        this.cFF = (LiveBroadcastCard) this.cEo.findViewById(n.f.item_card);
                    }
                    this.cFE.setVisibility(0);
                    LiveCardData liveCardData = new LiveCardData();
                    liveCardData.setPublisherId(cVar.ajz().getAnchorInfoData().getAuthorId());
                    liveCardData.setPublisherName(cVar.ajz().getAnchorInfoData().getAuthorName());
                    liveCardData.setPublisherPortrait(cVar.ajz().getAnchorInfoData().getPublisherPortrait());
                    liveCardData.setGroupId(cVar.ajz().getAnchorInfoData().getGroup_id());
                    liveCardData.setIntro(cVar.ajz().getAnchorInfoData().getIntro());
                    liveCardData.setLikers(cVar.ajz().getAnchorInfoData().getLikers());
                    liveCardData.setListeners(cVar.ajz().getAnchorInfoData().getListeners());
                    liveCardData.setName(cVar.ajz().getAnchorInfoData().getName());
                    liveCardData.setPortrait(cVar.ajz().getAnchorInfoData().getPortrait());
                    liveCardData.setStatus(cVar.ajz().getAnchorInfoData().getStatus());
                    liveCardData.setStartTime(cVar.ajz().getAnchorInfoData().getStartTime());
                    liveCardData.setIsVip(cVar.ajz().getAnchorInfoData().getIsVip());
                    this.cFF.setData(liveCardData);
                    this.cFF.setStatisticsKey("notice_pb_live");
                } else if (this.cFE != null) {
                    this.cFE.setVisibility(8);
                }
            }
            if (cVar != null && cVar.ajz() != null && cVar.ajz().getAuthor() != null) {
                String userId = cVar.ajz().getAuthor().getUserId();
                if (userId != null && !userId.equals("0") && userId.equals(a.getAuthor().getUserId())) {
                    this.cEA.setVisibility(0);
                } else {
                    this.cEA.setVisibility(8);
                }
            }
            if (a.getAuthor() != null) {
                int level_id = a.getAuthor().getLevel_id();
                int is_bawu = a.getAuthor().getIs_bawu();
                String bawu_type = a.getAuthor().getBawu_type();
                int i2 = 3;
                if (level_id != 0) {
                    this.cEv.setVisibility(0);
                    com.baidu.tbadk.core.util.as.c(this.cEv, com.baidu.tbadk.core.util.c.cp(level_id));
                    this.cEv.setOnClickListener(null);
                } else {
                    this.cEv.setVisibility(8);
                }
                if (is_bawu != 0) {
                    if (bawu_type.equals("manager")) {
                        com.baidu.tbadk.core.util.as.c(this.cEx, n.e.pb_manager);
                        this.cEv.setVisibility(8);
                        this.cEx.setVisibility(0);
                    } else if (bawu_type.equals("assist")) {
                        com.baidu.tbadk.core.util.as.c(this.cEx, n.e.pb_assist);
                        this.cEv.setVisibility(8);
                        this.cEx.setVisibility(0);
                    }
                }
                if (a.getAuthor().getGender() == 2) {
                    com.baidu.tbadk.core.util.as.c(this.cEw, n.e.icon_pb_pop_girl);
                    this.cEw.setVisibility(0);
                } else if (a.getAuthor().getGender() == 1) {
                    com.baidu.tbadk.core.util.as.c(this.cEw, n.e.icon_pb_pop_boy);
                    this.cEw.setVisibility(0);
                } else {
                    this.cEw.setVisibility(8);
                }
                if (!StringUtils.isNull(a.getAuthor().getName_show()) && com.baidu.adp.lib.util.j.aV(a.getAuthor().getName_show()) > 14) {
                    i2 = 0;
                }
                ArrayList<IconData> iconInfo = a.getAuthor().getIconInfo();
                ArrayList<IconData> tShowInfoNew = a.getAuthor().getTShowInfoNew();
                if (this.cEy != null) {
                    this.cEy.setTag(n.f.tag_user_id, a.getAuthor().getUserId());
                    this.cEy.setOnClickListener(this.cCy.cBM.bdv);
                    this.cEy.a(iconInfo, i2, this.cCy.getResources().getDimensionPixelSize(n.d.pb_icon_width), this.cCy.getResources().getDimensionPixelSize(n.d.pb_icon_height), this.cCy.getResources().getDimensionPixelSize(n.d.pb_icon_margin));
                }
                if (this.cEz != null) {
                    this.cEz.setOnClickListener(this.cCy.cBM.cGo);
                    this.cEz.a(tShowInfoNew, 3, this.cCy.getResources().getDimensionPixelSize(n.d.small_icon_width), this.cCy.getResources().getDimensionPixelSize(n.d.small_icon_height), this.cCy.getResources().getDimensionPixelSize(n.d.big_icon_margin), true);
                }
                this.cEt.setText(a.getAuthor().getName_show());
                this.cEt.setTag(n.f.tag_user_id, a.getAuthor().getUserId());
                this.cEt.setTag(n.f.tag_user_name, a.getAuthor().getName_show());
                if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                    com.baidu.tbadk.core.util.as.b(this.cEt, n.c.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.as.b(this.cEt, n.c.cp_cont_f, 1);
                }
                if (!this.cAl) {
                    this.cEu.setVisibility(8);
                }
                this.cEu.setUserId(a.getAuthor().getUserId());
                this.cEu.setUserName(a.getAuthor().getUserName());
                this.cEu.setImageDrawable(null);
                this.cEu.setTag(a.getAuthor().getUserId());
                if (this.cFU) {
                    dm dmVar = new dm(this, a);
                    this.cEt.setOnClickListener(dmVar);
                    this.cEu.setOnClickListener(dmVar);
                } else {
                    this.cEt.setOnClickListener(this.cCy.cBM.cGn);
                    this.cEu.setOnClickListener(this.cCy.cBM.cGn);
                }
                this.cEu.d(a.getAuthor().getPortrait(), 28, false);
            }
        }
    }

    public boolean alE() {
        return this.cGe;
    }

    private boolean alF() {
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.userId);
    }

    public void a(com.baidu.tieba.pb.a.c cVar, int i, int i2, boolean z, int i3, boolean z2) {
        Parcelable alf;
        Parcelable alf2;
        String sb;
        if (cVar != null) {
            if (cVar.ajz() != null) {
                this.cFI = cVar.ajz().sG();
                this.WM = cVar.ajz().sE();
                if (cVar.ajz().getAnchorLevel() != 0) {
                    this.cGe = true;
                }
            }
            if (cVar.getUserData() != null) {
                this.userId = cVar.getUserData().getUserId();
            }
            this.cFD = false;
            this.czN = z;
            alB();
            b(cVar, z, i);
            this.cEN.eU(this.czN);
            this.cEN.a(cVar);
            this.cEN.notifyDataSetChanged();
            if (cVar.ajy() != null) {
                this.mForumName = cVar.ajy().getName();
                this.mForumId = cVar.getForumId();
            }
            this.cEm.kM(this.mForumName);
            if (cVar.ajz() != null) {
                kJ(com.baidu.tbadk.core.util.ax.w(cVar.ajz().getReply_num()));
                if (cVar.ajz().getPraise() != null) {
                    if (cVar.ajz().getPraise().getNum() < 1) {
                        sb = this.cCy.getResources().getString(n.i.frs_item_praise_text);
                    } else {
                        sb = new StringBuilder(String.valueOf(cVar.ajz().getPraise().getNum())).toString();
                    }
                    if (this.cEj != -1) {
                        cVar.ajz().getPraise().setIsLike(this.cEj);
                    }
                    E(sb, cVar.ajz().getPraise().getIsLike() == 1);
                }
            }
            if (cVar.getPage().sf() == 0 && !z) {
                this.aRs.setNextPage(null);
            } else if (this.cCy.isLogin()) {
                this.aRs.setNextPage(this.cES);
                alU();
            } else if (cVar.getPage().sf() == 1) {
                this.cFD = true;
                if (this.cET == null) {
                    this.cET = new com.baidu.tieba.pb.view.b(this.cCy.getPageContext());
                }
                this.aRs.setNextPage(this.cET);
            }
            if (cVar.getPage().sg() == 0 && z) {
                this.aRs.setPullRefresh(null);
                this.cEk = 0;
                this.cFz.setVisibility(8);
            } else {
                if (this.cER == null) {
                    this.cER = new com.baidu.tieba.pb.view.g(this.cCy.getPageContext());
                    this.cER.nv();
                    this.cER.a(this.afB);
                }
                this.aRs.setPullRefresh(this.cER);
                this.cEk = 1;
                if (this.cER != null) {
                    this.cER.cV(TbadkCoreApplication.m411getInst().getSkinType());
                }
                this.cFz.setVisibility(0);
                alU();
            }
            alG();
            ArrayList<com.baidu.tieba.tbadkCore.data.o> ajA = cVar.ajA();
            if (cVar.getPage().sf() == 0 || ajA == null || ajA.size() < cVar.getPage().se()) {
                this.cES.setText(this.cCy.getResources().getString(n.i.list_no_more));
                l(cVar);
            } else if (z2) {
                if (this.cGd) {
                    wf();
                    if (cVar.getPage().sf() != 0) {
                        this.cES.setText(this.cCy.getResources().getString(n.i.pb_load_more));
                    }
                } else {
                    this.cES.showLoading();
                }
            } else {
                this.cES.showLoading();
            }
            if (z) {
                this.cFA.setVisibility(0);
                this.aFP.setVisibility(0);
                this.cFB.setText(this.cCy.getResources().getString(n.i.btn_show_passed_pb));
            } else {
                this.cFA.setVisibility(8);
                this.aFP.setVisibility(8);
                this.cFB.setText(this.cCy.getResources().getString(n.i.btn_show_passed_pb_aftre));
            }
            if (cVar.ajz() != null && cVar.ajz().getAuthor() != null && cVar.ajz().getAuthor().getType() == 0) {
                this.cEm.amb();
            }
            switch (i) {
                case 2:
                    this.aRs.setSelection(i2);
                    if (this.cEp != null) {
                        CompatibleUtile.scrollListViewBy(this.aRs, -this.cEp.getHeight(), 0);
                        break;
                    }
                    break;
                case 3:
                    if (i3 == 1 && (alf2 = ct.ale().alf()) != null) {
                        this.aRs.onRestoreInstanceState(alf2);
                        this.cFY = true;
                        break;
                    } else {
                        this.aRs.setSelection(0);
                        break;
                    }
                    break;
                case 4:
                    this.cGd = false;
                    this.aRs.setSelection(0);
                    break;
                case 5:
                    this.aRs.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1 && (alf = ct.ale().alf()) != null) {
                        this.aRs.onRestoreInstanceState(alf);
                        this.cFY = true;
                        break;
                    } else {
                        this.aRs.setSelection(0);
                        break;
                    }
                    break;
            }
            if (this.cFI == cFK && alF()) {
                alX();
            }
        }
    }

    public void fs(boolean z) {
        this.cFp = z;
        this.cEm.fs(z);
    }

    public void wf() {
        if (this.cES != null) {
            this.cES.wf();
        }
        alU();
    }

    public void NC() {
        this.aRs.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean alG() {
        boolean z;
        boolean z2 = true;
        if (this.cEp != null && this.cEp.getVisibility() == 0) {
            if (this.cEH != null) {
                this.cEH.setVisibility(0);
                z = true;
            } else {
                z = true;
            }
        } else {
            if (this.cEH != null) {
                this.cEH.setVisibility(8);
            }
            z = false;
        }
        if (this.cFs != null && this.cFs.getVisibility() == 0) {
            if (this.cEI != null) {
                this.cEI.setVisibility(0);
            }
        } else {
            if (this.cEI != null) {
                this.cEI.setVisibility(8);
            }
            z2 = z;
        }
        if ((this.cEK == null || this.cEK.getVisibility() == 8) && z2 && this.czN) {
            this.cEJ.setVisibility(0);
        } else {
            this.cEJ.setVisibility(8);
        }
        return z2;
    }

    public boolean a(com.baidu.tieba.pb.a.c cVar, boolean z, boolean z2) {
        if (cVar == null) {
            return false;
        }
        if (this.cEs != null) {
            if (cVar.ajz().sS() == 0) {
                this.cEs.setVisibility(0);
                cVar.ajz().tb();
                this.cEs.setText(cVar.ajz().getSpan_str());
            } else {
                this.cEs.setVisibility(8);
            }
        }
        if (z) {
            if (this.cFE != null) {
                this.cFE.findViewById(n.f.pb_head_live_blank).setVisibility(8);
            }
        } else if (this.cFE != null) {
            this.cFE.findViewById(n.f.pb_head_live_blank).setVisibility(0);
        }
        this.czN = z;
        com.baidu.tbadk.core.data.z ajz = cVar.ajz();
        if (ajz != null) {
            a(ajz.sK());
        }
        if (cVar.ajD() == 1) {
            alH();
            Button button = (Button) this.cEo.findViewById(n.f.pb_head_function_manage_commit_top);
            Button button2 = (Button) this.cEo.findViewById(n.f.pb_head_function_manage_cancel_top);
            Button button3 = (Button) this.cEo.findViewById(n.f.pb_head_function_manage_commit_good);
            Button button4 = (Button) this.cEo.findViewById(n.f.pb_head_function_manage_cancel_good);
            button.setOnClickListener(this.bcT);
            button2.setOnClickListener(this.bcT);
            button3.setOnClickListener(this.bcT);
            button4.setOnClickListener(this.bcT);
            if (cVar.ajz().getIs_good() == 1) {
                button3.setVisibility(8);
                button4.setVisibility(0);
            } else {
                button3.setVisibility(0);
                button4.setVisibility(8);
            }
            if (cVar.ajz().getIs_top() == 1) {
                button.setVisibility(8);
                button2.setVisibility(0);
            } else {
                button.setVisibility(0);
                button2.setVisibility(8);
            }
            return true;
        }
        return false;
    }

    private void alH() {
        if (this.cEp == null) {
            this.cEp = ((ViewStub) this.cEo.findViewById(n.f.pb_header_function_manage)).inflate();
            this.cCy.getLayoutMode().k(this.cEp);
            this.cEH = this.cEo.findViewById(n.f.new_pb_header_item_line_above_manage);
            return;
        }
        this.cEp.setVisibility(0);
    }

    public void a(com.baidu.tieba.pb.a.c cVar, boolean z, boolean z2, int i) {
        boolean z3;
        boolean z4;
        boolean z5;
        String userId;
        if (cVar != null) {
            a(cVar, z, z2);
            com.baidu.tieba.tbadkCore.data.o a = a(cVar, z, i);
            if (a != null) {
                if (cVar.ajD() != 0 && a.getAuthor() != null) {
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
                    String userId3 = cVar.ajz().getAuthor().getUserId();
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
                        sparseArray.put(n.f.tag_forbid_user_name, a.getAuthor().getUserName());
                        sparseArray.put(n.f.tag_forbid_user_post_id, a.getId());
                    }
                    sparseArray.put(n.f.tag_del_post_id, a.getId());
                    sparseArray.put(n.f.tag_del_post_type, 0);
                    sparseArray.put(n.f.tag_del_post_is_self, Boolean.valueOf(z3));
                    sparseArray.put(n.f.tag_manage_user_identity, Integer.valueOf(cVar.ajD()));
                    sparseArray.put(n.f.tag_should_manage_visible, true);
                    a(n.i.manage, sparseArray);
                } else if (z4) {
                    SparseArray<Object> sparseArray2 = new SparseArray<>();
                    sparseArray2.put(n.f.tag_del_post_id, a.getId());
                    sparseArray2.put(n.f.tag_del_post_type, 0);
                    sparseArray2.put(n.f.tag_del_post_is_self, Boolean.valueOf(z3));
                    sparseArray2.put(n.f.tag_manage_user_identity, Integer.valueOf(cVar.ajD()));
                    sparseArray2.put(n.f.tag_should_manage_visible, false);
                    a(n.i.delete, sparseArray2);
                }
            }
            alG();
        }
    }

    private void a(int i, SparseArray<Object> sparseArray) {
        alH();
        Button button = (Button) this.cEo.findViewById(n.f.pb_head_function_manage_delormanage);
        button.setOnClickListener(this.bcT);
        button.setVisibility(0);
        button.setText(i);
        button.setTag(sparseArray);
    }

    public View getNextView() {
        return this.axh;
    }

    public void kK(String str) {
        if (this.cES != null && !StringUtils.isNull(str)) {
            this.cES.setText(str);
        }
    }

    public BdListView getListView() {
        return this.aRs;
    }

    public int alI() {
        return n.f.richText;
    }

    public int NJ() {
        return n.f.user_icon_box;
    }

    public Button alJ() {
        return (Button) this.cEo.findViewById(n.f.pb_head_function_manage_commit_good);
    }

    public Button alK() {
        return (Button) this.cEo.findViewById(n.f.pb_head_function_manage_cancel_good);
    }

    public Button alL() {
        return (Button) this.cEo.findViewById(n.f.pb_head_function_manage_commit_top);
    }

    public Button alM() {
        return (Button) this.cEo.findViewById(n.f.pb_head_function_manage_cancel_top);
    }

    public void d(BdListView.e eVar) {
        this.aRs.setOnSrollToBottomListener(eVar);
    }

    public void a(BdListView.h hVar) {
        this.aRs.setOnSrollToTopListener(hVar);
    }

    public void a(q.a aVar) {
        this.afB = aVar;
        if (this.cER != null) {
            this.cER.a(aVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.q qVar, a.b bVar) {
        if (qVar != null) {
            int sd = qVar.sd();
            int sb = qVar.sb();
            if (this.cEO != null) {
                this.cEO.tv();
            } else {
                this.cEO = new com.baidu.tbadk.core.dialog.a(this.cCy.getPageContext().getPageActivity());
                this.cEP = LayoutInflater.from(this.cCy.getPageContext().getPageActivity()).inflate(n.g.dialog_direct_pager, (ViewGroup) null);
                this.cEO.m(this.cEP);
                this.cEO.a(n.i.dialog_ok, bVar);
                this.cEO.b(n.i.dialog_cancel, new dn(this));
                this.cEO.a(new Cdo(this));
                this.cEO.b(this.cCy.getPageContext()).tv();
            }
            this.cEQ = (EditText) this.cEP.findViewById(n.f.input_page_number);
            this.cEQ.setText("");
            TextView textView = (TextView) this.cEP.findViewById(n.f.current_page_number);
            if (sd <= 0) {
                sd = 1;
            }
            if (sb <= 0) {
                sb = 1;
            }
            textView.setText(MessageFormat.format(this.cCy.getApplicationContext().getResources().getString(n.i.current_page), Integer.valueOf(sd), Integer.valueOf(sb)));
            this.cCy.ShowSoftKeyPadDelay(this.cEQ, 150);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.aRs.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.cCy.showToast(str);
    }

    public boolean ft(boolean z) {
        if (this.KS == null || !this.KS.Bx()) {
            return false;
        }
        this.KS.zY();
        return true;
    }

    public void alN() {
        if (this.cGf != null) {
            while (this.cGf.size() > 0) {
                TbImageView remove = this.cGf.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        alN();
    }

    public void onDestroy() {
        this.cCy.hideProgressBar();
        if (this.aQl != null && this.aXw != null) {
            this.aQl.b(this.aXw);
        }
        alO();
        this.cES.wf();
        if (this.cFQ != null) {
            com.baidu.adp.lib.h.h.hj().removeCallbacks(this.cFQ);
        }
        if (this.cFR != null) {
            com.baidu.adp.lib.h.h.hj().removeCallbacks(this.cFR);
        }
    }

    public void alO() {
        this.cEm.qE();
        com.baidu.adp.lib.util.k.c(this.cCy.getPageContext().getPageActivity(), this.cEQ);
        if (this.cFo != null) {
            this.cFo.dismiss();
        }
        alP();
    }

    public void eT(boolean z) {
        this.cEN.eT(z);
    }

    public void eV(boolean z) {
        this.cAl = z;
        this.cEN.eV(z);
    }

    public void fu(boolean z) {
        this.cFr = z;
    }

    public void alP() {
        if (this.cEX != null) {
            this.cEX.dismiss();
        }
        if (this.cEY != null) {
            com.baidu.adp.lib.h.j.b(this.cEY, this.cCy.getPageContext());
        }
        if (this.cFh != null) {
            com.baidu.adp.lib.h.j.b(this.cFh, this.cCy.getPageContext());
        }
        if (this.cEV != null) {
            com.baidu.adp.lib.h.j.b(this.cEV, this.cCy.getPageContext());
        }
    }

    public void onChangeSkinType(int i) {
        this.cCy.getLayoutMode().af(i == 1);
        this.cCy.getLayoutMode().k(this.cuP);
        this.cCy.getLayoutMode().k(this.cEq);
        this.cCy.getLayoutMode().k(this.cEo);
        this.cCy.getLayoutMode().k(this.axh);
        this.cEm.mNavigationBar.onChangeSkinType(this.cCy.getPageContext(), i);
        com.baidu.tbadk.core.util.as.a(this.cEm.cGw, n.e.btn_more_selector_s, n.e.btn_more_selector);
        com.baidu.tbadk.core.util.as.a(this.cEm.cGx, n.e.icon_floor_addition_selector, n.e.icon_floor_addition_selector);
        if (this.cEP != null) {
            this.cCy.getLayoutMode().k(this.cEP);
        }
        fs(this.cFp);
        this.cEN.notifyDataSetChanged();
        if (this.cER != null) {
            this.cER.cV(i);
        }
        if (this.cES != null) {
            this.cES.cV(i);
            com.baidu.tbadk.core.util.as.i(this.axh, n.e.pb_foot_more_trans_selector);
            this.cES.cT(n.e.pb_foot_more_trans_selector);
        }
        if (this.KS != null) {
            this.KS.onChangeSkinType(i);
        }
        if (this.cEG != null) {
            this.cEG.cX(i);
        }
        if (this.cET != null) {
            this.cET.cV(i);
        }
        if (this.cEn != null && this.cEn.size() > 0) {
            for (com.baidu.tieba.pb.pb.main.b.a aVar : this.cEn) {
                aVar.alZ();
            }
        }
        fo(i == 1);
    }

    public void setOnImageClickListener(TbRichTextView.d dVar) {
        this.aDR = dVar;
        this.cEN.setOnImageClickListener(this.aDR);
    }

    public void f(NoNetworkView.a aVar) {
        this.aXw = aVar;
        if (this.aQl != null) {
            this.aQl.a(this.aXw);
        }
    }

    public void fv(boolean z) {
        this.cEN.setIsFromCDN(z);
        this.mIsFromCDN = z;
    }

    public Button alQ() {
        return this.cFs;
    }

    public void l(com.baidu.tieba.pb.a.c cVar) {
        if (cVar != null) {
            ArrayList<com.baidu.tieba.tbadkCore.data.o> ajA = cVar.ajA();
            if (ajA.size() == 1) {
                com.baidu.tieba.tbadkCore.data.o oVar = ajA.get(0);
                if (oVar.aDj() < oVar.aDc().size()) {
                    this.aRs.setNextPage(null);
                    return;
                } else {
                    this.aRs.setNextPage(this.cES);
                    return;
                }
            }
            this.aRs.setNextPage(this.cES);
        }
    }

    public void alR() {
        if (com.baidu.tbadk.performanceLog.y.ES().ET()) {
            int lastVisiblePosition = this.aRs.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.aRs.getChildAt(i);
                if (childAt != null) {
                    TbRichTextView tbRichTextView = (TbRichTextView) childAt.findViewById(n.f.richText);
                    if (tbRichTextView != null) {
                        for (int i2 = 0; i2 < tbRichTextView.getChildCount(); i2++) {
                            View childAt2 = tbRichTextView.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.performanceLog.s perfLog = tbImageView.getPerfLog();
                                perfLog.eL(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
                                perfLog.ayl = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr = new int[2];
                                    tbRichTextView.getLocationOnScreen(iArr);
                                    if (iArr[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                    }
                                }
                                tbImageView.vY();
                            }
                        }
                    }
                    HeadImageView headImageView = (HeadImageView) childAt.findViewById(n.f.photo);
                    if (headImageView != null) {
                        com.baidu.tbadk.performanceLog.s perfLog2 = headImageView.getPerfLog();
                        perfLog2.eL(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
                        perfLog2.ayl = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr2 = new int[2];
                            headImageView.getLocationOnScreen(iArr2);
                            if (iArr2[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                            }
                        }
                        headImageView.vY();
                    }
                }
            }
        }
    }

    public void fw(boolean z) {
        if (this.cFt != null && this.cFt != null) {
            if (this.cFr) {
                fl(z);
            } else {
                fm(z);
            }
        }
    }

    public void alS() {
        if (this.cFt != null) {
            this.cFt.setVisibility(8);
        }
    }

    public TextView alT() {
        return this.cFA;
    }

    public void acC() {
        if (this.cFC == null) {
            this.cFC = new com.baidu.tbadk.core.view.b(this.cCy.getPageContext());
        }
        this.cFC.ay(true);
    }

    public void alU() {
        if (this.cFC != null) {
            this.cFC.ay(false);
        }
    }

    private boolean a(com.baidu.tieba.tbadkCore.data.o oVar, String str, String str2) {
        ColumnLayout.a aVar;
        if (oVar == null || oVar.getAuthor() == null || oVar.getAuthor().getGodInfo() == null) {
            return false;
        }
        GodInfo godInfo = oVar.getAuthor().getGodInfo();
        this.cEr.setPadding(TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.d.ds18), TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.d.ds16), TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.d.ds20), 0);
        this.cEo.setPadding(0, TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.d.ds34), 0, 0);
        int dimensionPixelSize = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.d.ds120);
        if (this.cEu.getLayoutParams() == null) {
            aVar = new ColumnLayout.a(dimensionPixelSize, dimensionPixelSize);
        } else {
            aVar = (ColumnLayout.a) this.cEu.getLayoutParams();
            aVar.width = dimensionPixelSize;
            aVar.height = dimensionPixelSize;
        }
        this.cEu.setLayoutParams(aVar);
        if (this.cEC == null) {
            this.cEC = new TextView(this.cCy.getActivity());
            this.cEC.setClickable(false);
            this.cEC.setIncludeFontPadding(false);
            this.cEC.setGravity(16);
            this.cEC.setTextSize(0, this.cCy.getResources().getDimensionPixelSize(n.d.fontsize20));
            ColumnLayout.a aVar2 = new ColumnLayout.a(-2, -2, 3, 2);
            aVar2.topMargin = this.cCy.getResources().getDimensionPixelSize(n.d.ds10);
            this.cEC.setSingleLine(true);
            this.cEC.setEllipsize(TextUtils.TruncateAt.END);
            this.cEr.addView(this.cEC, -1, aVar2);
            com.baidu.tbadk.core.util.as.i((View) this.cEC, n.e.icon_shen);
            com.baidu.tbadk.core.util.as.b(this.cEC, n.c.cp_cont_h, 1);
        }
        if (StringUtils.isNull(godInfo.intro, true)) {
            this.cEC.setText(n.i.god_intro_default);
        } else {
            this.cEC.setText(godInfo.intro);
        }
        if (this.cED == null) {
            this.cED = new TextView(this.cCy.getActivity());
            this.cED.setClickable(false);
            this.cED.setTextSize(0, this.cCy.getResources().getDimensionPixelSize(n.d.fontsize24));
            ColumnLayout.a aVar3 = new ColumnLayout.a(-2, -2, 3, 2);
            aVar3.topMargin = this.cCy.getResources().getDimensionPixelSize(n.d.ds8);
            this.cED.setSingleLine(true);
            this.cEr.addView(this.cED, -1, aVar3);
        }
        kb(oVar.getAuthor().getGiftNum());
        this.cEB.setVisibility(8);
        long userIdLong = oVar.getAuthor().getUserIdLong();
        String userName = oVar.getAuthor().getUserName();
        String id = oVar.getId();
        if (this.cEE == null) {
            this.cEE = new TextView(this.cCy.getActivity());
            this.cEE.setTextSize(0, this.cCy.getResources().getDimensionPixelSize(n.d.fontsize28));
            int dimensionPixelSize2 = this.cCy.getResources().getDimensionPixelSize(n.d.ds10);
            int dimensionPixelSize3 = this.cCy.getResources().getDimensionPixelSize(n.d.ds12);
            this.cEE.setPadding(dimensionPixelSize3, dimensionPixelSize2, dimensionPixelSize3, dimensionPixelSize2);
            this.cEE.setCompoundDrawablePadding(this.cCy.getResources().getDimensionPixelSize(n.d.ds8));
            this.cEE.setGravity(17);
            com.baidu.tbadk.core.util.as.b(this.cEE, n.c.cp_cont_i, 1);
            this.cEE.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.as.getDrawable(n.e.icon_btn_gift), (Drawable) null, (Drawable) null, (Drawable) null);
            com.baidu.tbadk.core.util.as.i((View) this.cEE, n.e.btn_all_red);
            this.cEE.setText(n.i.send_gift);
            this.cEE.setOnClickListener(new dq(this, userIdLong, userName, str, id));
            this.cEr.addView(this.cEE, -1, new ColumnLayout.a(-2, -2, 16, 3));
        }
        if (this.cFZ == null) {
            dr drVar = new dr(this, userIdLong);
            this.cFZ = (LinearLayout) LayoutInflater.from(this.cCy.getActivity()).inflate(n.g.god_floating_view, (ViewGroup) null);
            this.cFZ.setOnClickListener(drVar);
            this.cFZ.setTag(n.f.tag_user_id, String.valueOf(userIdLong));
            this.cFZ.setTag(n.f.tag_user_name, userName);
            HeadImageView headImageView = (HeadImageView) this.cFZ.findViewById(n.f.god_floating_owner_photo);
            headImageView.setOnClickListener(drVar);
            if (!this.cAl) {
                headImageView.setVisibility(8);
            }
            headImageView.setUserId(oVar.getAuthor().getUserId());
            headImageView.setUserName(oVar.getAuthor().getUserName());
            headImageView.setImageDrawable(null);
            headImageView.setTag(oVar.getAuthor().getUserId());
            headImageView.d(oVar.getAuthor().getPortrait(), 28, false);
            View findViewById = this.cFZ.findViewById(n.f.god_floating_owner_info_floor_owner);
            if (str2 != null && !str2.equals("0") && str2.equals(oVar.getAuthor().getUserId())) {
                findViewById.setVisibility(0);
            } else {
                findViewById.setVisibility(8);
            }
            ImageView imageView = (ImageView) this.cFZ.findViewById(n.f.god_floating_owner_info_user_rank);
            int level_id = oVar.getAuthor().getLevel_id();
            int is_bawu = oVar.getAuthor().getIs_bawu();
            String bawu_type = oVar.getAuthor().getBawu_type();
            int i = 3;
            if (level_id != 0) {
                imageView.setVisibility(0);
                com.baidu.tbadk.core.util.as.c(imageView, com.baidu.tbadk.core.util.c.cp(level_id));
                imageView.setOnClickListener(null);
            } else {
                imageView.setVisibility(8);
            }
            ImageView imageView2 = (ImageView) this.cFZ.findViewById(n.f.god_floating_owner_info_user_bawu);
            if (is_bawu != 0) {
                if (bawu_type.equals("manager")) {
                    com.baidu.tbadk.core.util.as.c(imageView2, n.e.pb_manager);
                    imageView.setVisibility(8);
                    imageView2.setVisibility(0);
                } else if (bawu_type.equals("assist")) {
                    com.baidu.tbadk.core.util.as.c(imageView2, n.e.pb_assist);
                    imageView.setVisibility(8);
                    imageView2.setVisibility(0);
                }
            }
            ImageView imageView3 = (ImageView) this.cFZ.findViewById(n.f.god_floating_owner_info_user_gender);
            if (oVar.getAuthor().getGender() == 2) {
                com.baidu.tbadk.core.util.as.c(imageView3, n.e.icon_pb_pop_girl);
                imageView3.setVisibility(0);
            } else if (oVar.getAuthor().getGender() == 1) {
                com.baidu.tbadk.core.util.as.c(imageView3, n.e.icon_pb_pop_boy);
                imageView3.setVisibility(0);
            } else {
                imageView3.setVisibility(8);
            }
            if (!StringUtils.isNull(oVar.getAuthor().getName_show()) && com.baidu.adp.lib.util.j.aV(oVar.getAuthor().getName_show()) > 14) {
                i = 0;
            }
            ArrayList<IconData> iconInfo = oVar.getAuthor().getIconInfo();
            ArrayList<IconData> tShowInfoNew = oVar.getAuthor().getTShowInfoNew();
            UserIconBox userIconBox = (UserIconBox) this.cFZ.findViewById(n.f.god_floating_owner_info_user_icon);
            UserIconBox userIconBox2 = (UserIconBox) this.cFZ.findViewById(n.f.god_floating_owner_info_tshow_icon);
            if (userIconBox != null) {
                userIconBox.setTag(n.f.tag_user_id, oVar.getAuthor().getUserId());
                userIconBox.setOnClickListener(this.cCy.cBM.bdv);
                userIconBox.a(iconInfo, i, this.cCy.getResources().getDimensionPixelSize(n.d.pb_icon_width), this.cCy.getResources().getDimensionPixelSize(n.d.pb_icon_height), this.cCy.getResources().getDimensionPixelSize(n.d.pb_icon_margin));
            }
            if (userIconBox2 != null) {
                userIconBox2.setOnClickListener(this.cCy.cBM.cGo);
                userIconBox2.a(tShowInfoNew, 3, this.cCy.getResources().getDimensionPixelSize(n.d.small_icon_width), this.cCy.getResources().getDimensionPixelSize(n.d.small_icon_height), this.cCy.getResources().getDimensionPixelSize(n.d.big_icon_margin), true);
            }
            TextView textView = (TextView) this.cFZ.findViewById(n.f.god_floating_owner_info_user_name);
            if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                com.baidu.tbadk.core.util.as.b(textView, n.c.cp_cont_h, 1);
            } else {
                com.baidu.tbadk.core.util.as.b(textView, n.c.cp_cont_f, 1);
            }
            textView.setText(oVar.getAuthor().getName_show());
            ((TextView) this.cFZ.findViewById(n.f.god_floating_gift)).setOnClickListener(new ds(this, userIdLong, userName, str, id));
            TextView textView2 = (TextView) this.cFZ.findViewById(n.f.god_floating_intro);
            if (StringUtils.isNull(godInfo.intro, true)) {
                textView2.setText(n.i.god_intro_default);
            } else {
                textView2.setText(godInfo.intro);
            }
            com.baidu.tbadk.core.util.as.i((View) textView2, n.e.icon_shen);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(3, n.f.title_wrapper);
            this.cuP.addView(this.cFZ, layoutParams);
            this.cCy.getLayoutMode().k(this.cFZ);
        }
        return true;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.cFU && !this.cFV && i > this.cEk) {
            this.cFX = true;
            alW();
            return;
        }
        this.cFX = false;
        alV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alV() {
        if (this.cFZ != null && this.cFZ.getVisibility() != 8) {
            this.cFZ.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alW() {
        if (!this.cFW && this.cFZ != null && this.cFZ.getVisibility() != 0) {
            this.cFW = true;
            if (this.cFY) {
                this.cFZ.setVisibility(0);
                this.cFY = false;
                this.cFW = false;
                return;
            }
            com.baidu.tieba.tbadkCore.a.a(this.cCy, this.cFZ, n.a.fade_in_10to100, new dt(this));
        }
    }

    public void alX() {
        if (!this.cGg) {
            TiebaStatic.log("c10490");
            this.cGg = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cCy.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(cFL, Integer.valueOf(cFN));
            aVar.bM(n.i.grade_thread_tips);
            View inflate = LayoutInflater.from(this.cCy.getPageContext().getPageActivity()).inflate(n.g.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(n.f.function_description_view)).setText(n.i.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(n.f.title_view)).setText(n.i.grade_thread_tips);
            aVar.m(inflate);
            aVar.x(sparseArray);
            aVar.a(n.i.grade_button_tips, this.cCy);
            aVar.b(n.i.look_again, new du(this));
            aVar.b(this.cCy.getPageContext()).tv();
        }
    }

    public void alY() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cCy.getPageContext().getPageActivity());
        aVar.cC(this.cCy.getResources().getString(n.i.upgrade_to_new_photo_live_tips));
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(cFL, Integer.valueOf(cFP));
        aVar.x(sparseArray);
        aVar.a(n.i.upgrade_to_new, this.cCy);
        aVar.b(n.i.cancel, new dv(this));
        aVar.b(this.cCy.getPageContext()).tv();
    }

    public int sG() {
        return this.cFI;
    }

    public void kL(String str) {
        if (str.contains("_")) {
            str = str.replace("_", "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cCy.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.cCy.getPageContext().getPageActivity()).inflate(n.g.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(n.f.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(n.f.function_description_view)).setVisibility(8);
        aVar.m(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(cFL, Integer.valueOf(cFO));
        aVar.x(sparseArray);
        aVar.a(n.i.view, this.cCy);
        aVar.b(n.i.cancel, new dx(this));
        aVar.b(this.cCy.getPageContext()).tv();
    }

    public void a(int i, com.baidu.tieba.pb.a.c cVar, boolean z, int i2) {
        com.baidu.tieba.tbadkCore.data.o a;
        if (i > 0 && (a = a(cVar, z, i2)) != null && a.getAuthor() != null) {
            MetaData author = a.getAuthor();
            author.setGiftNum(author.getGiftNum() + i);
            if (this.cFU) {
                kb(a.getAuthor().getGiftNum());
            }
        }
    }

    private void kb(int i) {
        if (this.cED != null) {
            String v = com.baidu.tbadk.core.util.ax.v(i);
            String format = String.format(this.cCy.getResources().getString(n.i.gift_received_count), v);
            int indexOf = format.indexOf(v);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(format);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(com.baidu.tbadk.core.util.as.getColor(n.c.cp_cont_d)), 0, format.length(), 17);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(com.baidu.tbadk.core.util.as.getColor(n.c.cp_cont_h)), indexOf, v.length() + indexOf, 17);
            this.cED.setText(spannableStringBuilder);
        }
    }
}
