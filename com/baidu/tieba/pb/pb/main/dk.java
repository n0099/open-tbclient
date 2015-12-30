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
import com.baidu.tbadk.core.view.r;
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
public class dk {
    public static int cJI = 2;
    public static int cJJ = 3;
    public static int cJK = 0;
    public static int cJL = 3;
    public static int cJM = 4;
    public static int cJN = 5;
    public static int cJO = 6;
    private com.baidu.tbadk.editortools.k Li;
    private NoNetworkView aUd;
    private BdTypeListView aVi;
    private r.a ago;
    private View ayL;
    private View.OnClickListener bgT;
    private com.baidu.tieba.pb.b.c cDu;
    private View.OnClickListener cEa;
    PbActivity.b cFJ;
    private PbActivity cGj;
    private TextView cIA;
    private TextView cIE;
    private View cII;
    private View cIK;
    private RelativeLayout cIL;
    private bu cIM;
    private PbListView cIR;
    private View cIT;
    public int cIi;
    private View cIk;
    public final com.baidu.tieba.pb.pb.main.b.c cIl;
    private List<com.baidu.tieba.pb.pb.main.b.a> cIm;
    private View cIn;
    private LinearLayout cIp;
    private ColumnLayout cIq;
    private TextView cIr;
    private TextView cIs;
    private HeadImageView cIt;
    private ImageView cIu;
    private ImageView cIv;
    private ImageView cIw;
    private UserIconBox cIx;
    private UserIconBox cIy;
    private ImageView cIz;
    private View cJD;
    private LiveBroadcastCard cJE;
    private View cJF;
    private TextView cJG;
    private Runnable cJP;
    private Runnable cJQ;
    private View cJs;
    private TextView cJt;
    private TextView cJu;
    private TextView cJv;
    private boolean cJx;
    private PbActivity.a cKb;
    private RelativeLayout cyP;
    private int cIj = 0;
    private View cIo = null;
    private TextView cIB = null;
    private TextView cIC = null;
    private TextView cID = null;
    public FrsPraiseView cIF = null;
    private View cIG = null;
    private View cIH = null;
    private View cIJ = null;
    private com.baidu.tbadk.core.dialog.a cIN = null;
    private com.baidu.tbadk.core.dialog.c bgJ = null;
    private View cIO = null;
    private EditText cIP = null;
    private com.baidu.tieba.pb.view.j cIQ = null;
    private com.baidu.tieba.pb.view.b cIS = null;
    private c.b bUJ = null;
    private TbRichTextView.d aFq = null;
    private NoNetworkView.a bbw = null;
    private Dialog cIU = null;
    private View cIV = null;
    private com.baidu.tbadk.core.dialog.a cIW = null;
    private Dialog cIX = null;
    private View cIY = null;
    private int cIZ = 0;
    private RadioGroup NA = null;
    private RadioButton cJa = null;
    private RadioButton cJb = null;
    private RadioButton cJc = null;
    private Button cJd = null;
    private Button cJe = null;
    private TextView cJf = null;
    private Dialog cJg = null;
    private View cJh = null;
    private LinearLayout cJi = null;
    private CompoundButton.OnCheckedChangeListener cJj = null;
    private TextView cJk = null;
    private TextView cJl = null;
    private String cJm = null;
    private com.baidu.tbadk.core.dialog.c cJn = null;
    private boolean cJo = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView cJp = null;
    private boolean cJq = false;
    private Button cJr = null;
    private boolean cJw = true;
    private LinearLayout cJy = null;
    private TextView cJz = null;
    private TextView cJA = null;
    private View aHp = null;
    private com.baidu.tbadk.core.view.b cJB = null;
    private boolean cDs = false;
    private boolean cJC = false;
    private boolean mIsFromCDN = true;
    private int cJH = 0;
    private boolean cJR = true;
    private a.InterfaceC0080a cJS = new dl(this);
    private boolean cJT = false;
    private boolean cJU = false;
    private boolean cJV = false;
    private boolean cJW = false;
    private boolean cJX = false;
    private LinearLayout cJY = null;
    private CustomMessageListener cJZ = new du(this, CmdConfigCustom.PB_SHOW_MULTIIAMGETOOL);
    private final View.OnClickListener cKa = new eg(this);
    private View.OnLongClickListener onLongClickListener = null;
    private boolean cKc = true;
    private boolean cKd = false;
    private boolean Xo = false;
    String userId = null;
    private final List<TbImageView> cKe = new ArrayList();
    private boolean cDQ = true;
    private boolean cKf = false;

    public NoNetworkView amx() {
        return this.aUd;
    }

    public void amy() {
        if (this.Li != null) {
            this.Li.hide();
        }
    }

    public void amz() {
        reset();
        this.cJw = true;
        if (this.Li != null) {
            this.Li.hide();
        }
        if (this.cJs != null) {
            if (this.cJq) {
                fk(false);
            } else {
                fl(false);
            }
        }
    }

    private void reset() {
        if (this.cGj != null && this.cGj.alf() != null && this.Li != null) {
            com.baidu.tbadk.editortools.d.b.BK().setStatus(0);
            com.baidu.tbadk.editortools.d.e alf = this.cGj.alf();
            alf.Cj();
            if (alf.getWriteImagesInfo() != null) {
                alf.getWriteImagesInfo().setMaxImagesAllowed(10);
            }
            alf.el(10);
            alf.ej(SendView.ALL);
            alf.ek(SendView.ALL);
            alf.fr(this.cGj.getActivity().getString(n.j.pb_reply_hint));
            com.baidu.tbadk.editortools.r ea = this.Li.ea(23);
            com.baidu.tbadk.editortools.r ea2 = this.Li.ea(2);
            com.baidu.tbadk.editortools.r ea3 = this.Li.ea(5);
            if (ea2 != null) {
                ea2.ob();
            }
            if (ea3 != null) {
                ea3.ob();
            }
            if (ea != null) {
                ea.hide();
            }
            this.Li.invalidate();
        }
    }

    public boolean amA() {
        return this.cJw;
    }

    public void fk(boolean z) {
        if (this.cJs != null && this.cJt != null && this.cJu != null) {
            this.cJt.setText(n.j.draft_to_send);
            this.cJu.setVisibility(8);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.cJs.startAnimation(alphaAnimation);
            }
            this.cJs.setVisibility(0);
        }
    }

    public void fl(boolean z) {
        if (this.cJs != null && this.cJt != null && this.cJu != null) {
            this.cJt.setText(n.j.reply_floor_host);
            this.cJu.setVisibility(0);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.cJs.startAnimation(alphaAnimation);
            }
            this.cJs.setVisibility(0);
        }
    }

    public com.baidu.tieba.tbadkCore.data.r amB() {
        int i;
        View childAt;
        int i2 = 0;
        if (this.aVi == null) {
            return null;
        }
        int firstVisiblePosition = this.aVi.getFirstVisiblePosition();
        int lastVisiblePosition = this.aVi.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.aVi.getChildCount();
            int i3 = 0;
            for (int i4 = firstVisiblePosition; i4 <= lastVisiblePosition; i4++) {
                if (i4 - firstVisiblePosition < childCount && (childAt = this.aVi.getChildAt(i4 - firstVisiblePosition)) != null) {
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
        int headerViewsCount = i - this.aVi.getHeaderViewsCount();
        if (headerViewsCount < 0) {
            headerViewsCount = 0;
        }
        if (this.cIM.ko(headerViewsCount) != null && this.cIM.ko(headerViewsCount) != com.baidu.tieba.tbadkCore.data.r.dHb) {
            i2 = headerViewsCount + 1;
        }
        return (com.baidu.tieba.tbadkCore.data.r) this.cIM.au(i2);
    }

    public dk(PbActivity pbActivity, View.OnClickListener onClickListener, com.baidu.tieba.pb.b.c cVar) {
        this.cGj = null;
        this.cyP = null;
        this.cIk = null;
        this.aVi = null;
        this.cIn = null;
        this.cIp = null;
        this.cIq = null;
        this.cIr = null;
        this.cIs = null;
        this.cIt = null;
        this.cIu = null;
        this.cIv = null;
        this.cIw = null;
        this.cIx = null;
        this.cIy = null;
        this.cIz = null;
        this.cIA = null;
        this.cIE = null;
        this.cII = null;
        this.cIK = null;
        this.cIM = null;
        this.cIR = null;
        this.ayL = null;
        this.bgT = null;
        this.cEa = null;
        this.cJs = null;
        this.cJt = null;
        this.cJv = null;
        this.cJF = null;
        this.cJG = null;
        this.cGj = pbActivity;
        this.bgT = onClickListener;
        this.cDu = cVar;
        this.cyP = (RelativeLayout) LayoutInflater.from(this.cGj.getPageContext().getPageActivity()).inflate(n.h.new_pb_activity, (ViewGroup) null);
        this.cGj.addContentView(this.cyP, new FrameLayout.LayoutParams(-1, -1));
        this.cIk = this.cGj.findViewById(n.g.statebar_view);
        this.cIL = (RelativeLayout) this.cGj.findViewById(n.g.title_wrapper);
        this.aUd = (NoNetworkView) this.cGj.findViewById(n.g.view_no_network);
        this.aVi = (BdTypeListView) this.cGj.findViewById(n.g.new_pb_list);
        View view = new View(this.cGj.getPageContext().getPageActivity());
        view.setLayoutParams(new AbsListView.LayoutParams(-1, this.cGj.getResources().getDimensionPixelSize(n.e.pb_editor_height)));
        this.aVi.addFooterView(view);
        this.cIl = new com.baidu.tieba.pb.pb.main.b.c(pbActivity);
        this.cIl.anm().setOnTouchListener(new com.baidu.tieba.pb.b.a(new ei(this)));
        this.cJs = this.cGj.findViewById(n.g.pb_editor_tool_comment);
        this.cJt = (TextView) this.cGj.findViewById(n.g.pb_editor_tool_comment_reply_text);
        this.cJv = (TextView) this.cGj.findViewById(n.g.pb_editor_tool_comment_praise_icon);
        this.cJu = (TextView) this.cGj.findViewById(n.g.pb_editor_tool_comment_reply_count_text);
        this.cJt.setOnClickListener(new ej(this));
        this.cJv.setOnClickListener(this.bgT);
        this.cJv.setOnTouchListener(this.cGj);
        this.cIn = LayoutInflater.from(this.cGj.getPageContext().getPageActivity()).inflate(n.h.new_pb_header_item, (ViewGroup) null);
        this.cIp = (LinearLayout) LayoutInflater.from(this.cGj.getPageContext().getPageActivity()).inflate(n.h.new_pb_header_user_item, (ViewGroup) null);
        this.cIq = (ColumnLayout) this.cIp.findViewById(n.g.pb_head_owner_root);
        this.cIq.setOnLongClickListener(this.onLongClickListener);
        this.cIq.setOnTouchListener(this.cDu);
        this.cIq.setVisibility(8);
        this.cIn.setOnTouchListener(this.cDu);
        this.cIr = (TextView) this.cIn.findViewById(n.g.pb_head_post_title);
        this.cIr.setTextSize(TbConfig.getContentSizeOfPostTitle());
        this.cIr.setVisibility(8);
        this.cJF = this.cIn.findViewById(n.g.pb_head_activity_join_number_container);
        this.cJF.setVisibility(8);
        this.cJG = (TextView) this.cIn.findViewById(n.g.pb_head_activity_join_number);
        this.cIs = (TextView) this.cIq.findViewById(n.g.pb_head_owner_info_user_name);
        this.cIt = (HeadImageView) this.cIq.findViewById(n.g.pb_head_owner_photo);
        if (!this.cDQ) {
            this.cIt.setVisibility(8);
        }
        this.cIu = (ImageView) this.cIq.findViewById(n.g.pb_head_owner_info_user_rank);
        this.cIv = (ImageView) this.cIq.findViewById(n.g.pb_head_owner_info_user_gender);
        this.cIw = (ImageView) this.cIq.findViewById(n.g.pb_head_owner_info_user_bawu);
        this.cIx = (UserIconBox) this.cIq.findViewById(n.g.pb_head_owner_info_user_icon);
        this.cIy = (UserIconBox) this.cIq.findViewById(n.g.pb_head_owner_info_tshow_icon);
        this.cIz = (ImageView) this.cIq.findViewById(n.g.pb_head_owner_info_floor_owner);
        this.cIA = (TextView) this.cIq.findViewById(n.g.pb_head_owner_info_time);
        this.cIE = (TextView) this.cIn.findViewById(n.g.pb_head_reverse_hint);
        this.cIE.setOnClickListener(this.bgT);
        this.cIE.setVisibility(8);
        this.cII = this.cIn.findViewById(n.g.new_pb_header_item_line_below_livepost);
        this.cIK = this.cIn.findViewById(n.g.new_pb_header_item_line_above_showpassed);
        this.cIn.setOnLongClickListener(new ek(this));
        amF();
        this.cIM = new bu(this.cGj, this.aVi);
        this.cIM.C(this.bgT);
        this.cIM.a(this.cDu);
        this.cIM.setOnImageClickListener(this.aFq);
        this.cEa = new el(this);
        this.cIM.B(this.cEa);
        this.aVi.addHeaderView(this.cIp);
        this.aVi.addHeaderView(this.cIn);
        this.cIR = new PbListView(this.cGj.getPageContext().getPageActivity());
        this.ayL = this.cIR.getView().findViewById(n.g.pb_more_view);
        if (this.ayL != null) {
            this.ayL.setOnClickListener(this.bgT);
            com.baidu.tbadk.core.util.as.i(this.ayL, n.f.pb_foot_more_trans_selector);
        }
        this.cIR.vO();
        this.cIR.cN(n.f.pb_foot_more_trans_selector);
        this.cIR.cO(n.f.pb_foot_more_trans_selector);
        this.cIT = this.cGj.findViewById(n.g.viewstub_progress);
        this.cGj.registerListener(this.cJZ);
    }

    public void fm(boolean z) {
        this.cIl.fm(z);
        if (z && this.cJC) {
            this.cIR.setText(this.cGj.getResources().getString(n.j.click_load_more));
            this.aVi.setNextPage(this.cIR);
        }
    }

    public void setEditorTools(com.baidu.tbadk.editortools.k kVar) {
        this.Li = kVar;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.cyP.addView(this.Li, layoutParams);
        this.Li.onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        this.Li.hide();
    }

    public void amC() {
        if (this.cGj != null && this.Li != null) {
            this.Li.ob();
        }
    }

    public void kG(String str) {
        if (this.cJu != null) {
            if (TextUtils.isEmpty(str)) {
                str = "0";
            }
            this.cJu.setText(this.cGj.getPageContext().getResources().getString(n.j.pb_reply_count_text, str));
        }
    }

    public void D(String str, boolean z) {
        this.cJx = z;
        fn(TbadkCoreApplication.m411getInst().getSkinType() == 1);
    }

    private void fn(boolean z) {
        if (this.cJv != null) {
            if (this.cJx) {
                com.baidu.tbadk.core.util.as.i((View) this.cJv, n.f.pb_praise_already_click_selector);
            } else {
                com.baidu.tbadk.core.util.as.i((View) this.cJv, n.f.pb_praise_normal_click_selector);
            }
        }
    }

    public TextView amD() {
        return this.cJv;
    }

    public void fo(boolean z) {
        if (this.aVi != null) {
            if (!z) {
                this.aVi.setEnabled(z);
                return;
            }
            if (this.cJQ == null) {
                this.cJQ = new em(this, z);
            }
            com.baidu.adp.lib.h.h.hj().postDelayed(this.cJQ, 10L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fp(boolean z) {
        if (z) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cIk.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.cIk.setLayoutParams(layoutParams);
            this.cIk.setVisibility(0);
            return;
        }
        this.cIk.setVisibility(8);
    }

    public void ao(View view) {
        boolean z;
        View view2;
        if (this.cIL != null && view != null) {
            if (this.cJw) {
                z = this.cJs.getVisibility() == 0;
            } else {
                z = this.Li != null && this.Li.getVisibility() == 0;
            }
            boolean z2 = this.cIL.getVisibility() == 0;
            if (z2) {
                TiebaStatic.log("c10084");
                this.cJU = true;
                View findViewById = this.cGj.findViewById(n.g.bg_above_list);
                findViewById.setLayoutParams(new RelativeLayout.LayoutParams(-1, this.cIL.getHeight()));
                com.baidu.tieba.tbadkCore.a.a(this.cGj, this.cIL, n.a.top_fold_up, new en(this, findViewById));
            } else {
                this.cJU = false;
                com.baidu.tieba.tbadkCore.a.a(this.cGj, this.cIL, n.a.top_fold_down, new dm(this));
            }
            if (this.cJw) {
                view2 = this.cJs;
            } else {
                view2 = this.Li;
            }
            if (z) {
                if (z2) {
                    if (this.Li != null) {
                        this.Li.zK();
                    }
                    com.baidu.tieba.tbadkCore.a.a(this.cGj, view2, n.a.bottom_fold_down, new dn(this));
                }
            } else if (!z2) {
                com.baidu.tieba.tbadkCore.a.a(this.cGj, view2, n.a.bottom_fold_up, new Cdo(this));
            }
        }
    }

    public bu amE() {
        return this.cIM;
    }

    public void a(PbActivity.b bVar) {
        this.cFJ = bVar;
    }

    private void a(com.baidu.tbadk.core.data.ac acVar) {
        if (acVar == null || acVar.sZ() == 0) {
            if (this.cJr != null) {
                this.cJr.setVisibility(8);
            }
            if (this.cIH != null) {
                this.cIH.setVisibility(8);
                return;
            }
            return;
        }
        if (this.cJr == null) {
            this.cGj.getLayoutMode().k(((ViewStub) this.cIn.findViewById(n.g.live_talk_layout)).inflate());
            this.cJr = (Button) this.cIn.findViewById(n.g.pb_head_function_manage_go_to_live_post);
            this.cIH = this.cIn.findViewById(n.g.new_pb_header_item_line_above_livepost);
        }
        int ta = acVar.ta();
        String string = this.cGj.getPageContext().getString(n.j.go_to_live_post_prefix);
        if (ta == 0) {
            string = String.valueOf(string) + this.cGj.getPageContext().getString(n.j.go_to_interview_post);
        } else if (ta == 1) {
            string = String.valueOf(string) + this.cGj.getPageContext().getString(n.j.go_to_discuss_post);
        }
        this.cJr.setText(string);
        this.cJr.setVisibility(0);
        this.cJr.setOnClickListener(this.bgT);
        amS();
    }

    private void amF() {
        this.cJy = (LinearLayout) this.cIn.findViewById(n.g.btn_show_passed_pb);
        this.cJA = (TextView) this.cIn.findViewById(n.g.show_pre_page_view);
        this.cJz = (TextView) this.cIn.findViewById(n.g.go_back_top_view);
        this.aHp = this.cIn.findViewById(n.g.show_passed_divider);
        this.cJA.setOnClickListener(this.cKa);
        this.cJz.setOnClickListener(this.bgT);
        amS();
    }

    public void ap(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, boolean z) {
        SparseArray sparseArray2;
        if (this.cIV == null) {
            this.cIV = LayoutInflater.from(this.cGj.getPageContext().getPageActivity()).inflate(n.h.forum_manage_dialog, (ViewGroup) null);
        }
        this.cGj.getLayoutMode().k(this.cIV);
        if (this.cIU == null) {
            this.cIU = new Dialog(this.cGj.getPageContext().getPageActivity(), n.k.common_alert_dialog);
            this.cIU.setCanceledOnTouchOutside(true);
            this.cIU.setCancelable(true);
            this.cIU.setContentView(this.cIV);
            WindowManager.LayoutParams attributes = this.cIU.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.k.K(this.cGj.getPageContext().getPageActivity()) * 0.9d);
            this.cIU.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.cIU.findViewById(n.g.del_post_btn);
        TextView textView2 = (TextView) this.cIU.findViewById(n.g.forbid_user_btn);
        TextView textView3 = (TextView) this.cIU.findViewById(n.g.disable_reply_btn);
        int intValue = sparseArray.get(n.g.tag_check_mute_from) instanceof Integer ? ((Integer) sparseArray.get(n.g.tag_check_mute_from)).intValue() : -1;
        if ("".equals(sparseArray.get(n.g.tag_del_post_id)) || intValue == 2) {
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
            if ((sparseArray.get(n.g.tag_del_post_type) instanceof Integer ? ((Integer) sparseArray.get(n.g.tag_del_post_type)).intValue() : -1) != 0) {
                textView.setText(n.j.delete);
            } else {
                textView.setText(n.j.delete_post);
            }
            sparseArray2.put(n.g.tag_del_post_id, sparseArray.get(n.g.tag_del_post_id));
            sparseArray2.put(n.g.tag_del_post_type, sparseArray.get(n.g.tag_del_post_type));
            sparseArray2.put(n.g.tag_del_post_is_self, sparseArray.get(n.g.tag_del_post_is_self));
            sparseArray2.put(n.g.tag_manage_user_identity, sparseArray.get(n.g.tag_manage_user_identity));
            textView.setOnClickListener(new dp(this));
        }
        if ("".equals(sparseArray.get(n.g.tag_forbid_user_name))) {
            textView2.setVisibility(8);
        } else {
            SparseArray sparseArray5 = (SparseArray) textView2.getTag();
            if (sparseArray5 == null) {
                sparseArray5 = new SparseArray();
                textView2.setTag(sparseArray5);
            }
            textView2.setVisibility(0);
            sparseArray5.put(n.g.tag_forbid_user_name, sparseArray.get(n.g.tag_forbid_user_name));
            sparseArray5.put(n.g.tag_manage_user_identity, sparseArray.get(n.g.tag_manage_user_identity));
            sparseArray5.put(n.g.tag_forbid_user_post_id, sparseArray.get(n.g.tag_forbid_user_post_id));
            textView2.setOnClickListener(new dq(this));
        }
        if (!((sparseArray.get(n.g.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(n.g.tag_user_mute_visible)).booleanValue())) {
            textView3.setVisibility(8);
        } else {
            SparseArray sparseArray6 = (SparseArray) textView3.getTag();
            if (sparseArray6 == null) {
                sparseArray6 = new SparseArray();
                textView3.setTag(sparseArray6);
            }
            textView3.setVisibility(0);
            if (z) {
                textView3.setText(n.j.un_mute);
            } else {
                textView3.setText(n.j.mute);
            }
            sparseArray6.put(n.g.tag_is_mem, sparseArray.get(n.g.tag_is_mem));
            sparseArray6.put(n.g.tag_user_mute_mute_userid, sparseArray.get(n.g.tag_user_mute_mute_userid));
            sparseArray6.put(n.g.tag_user_mute_mute_username, sparseArray.get(n.g.tag_user_mute_mute_username));
            sparseArray6.put(n.g.tag_user_mute_post_id, sparseArray.get(n.g.tag_user_mute_post_id));
            sparseArray6.put(n.g.tag_user_mute_thread_id, sparseArray.get(n.g.tag_user_mute_thread_id));
            textView3.setOnClickListener(new dr(this, z));
        }
        com.baidu.adp.lib.h.j.a(this.cIU, this.cGj.getPageContext());
    }

    public void a(PbActivity.a aVar) {
        this.cKb = aVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(n.g.tag_del_post_id, str);
        sparseArray.put(n.g.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(n.g.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(n.g.tag_del_post_is_self, Boolean.valueOf(z));
        sparseArray.put(cJK, Integer.valueOf(cJL));
        int i3 = n.j.del_post_confirm;
        if (i == 0) {
            i3 = n.j.del_thread_confirm;
        }
        this.cIW = new com.baidu.tbadk.core.dialog.a(this.cGj.getActivity());
        this.cIW.bG(i3);
        this.cIW.x(sparseArray);
        this.cIW.a(n.j.dialog_ok, this.cGj);
        this.cIW.b(n.j.dialog_cancel, new ds(this));
        this.cIW.ai(true);
        this.cIW.b(this.cGj.getPageContext());
        this.cIW.tf();
    }

    public void W(ArrayList<com.baidu.tbadk.core.data.m> arrayList) {
        if (this.cJh == null) {
            this.cJh = LayoutInflater.from(this.cGj.getPageContext().getPageActivity()).inflate(n.h.commit_good, (ViewGroup) null);
        }
        this.cGj.getLayoutMode().k(this.cJh);
        if (this.cJg == null) {
            this.cJg = new Dialog(this.cGj.getPageContext().getPageActivity(), n.k.common_alert_dialog);
            this.cJg.setCanceledOnTouchOutside(true);
            this.cJg.setCancelable(true);
            this.cJp = (ScrollView) this.cJh.findViewById(n.g.good_scroll);
            this.cJg.setContentView(this.cJh);
            WindowManager.LayoutParams attributes = this.cJg.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.k.d(this.cGj.getPageContext().getPageActivity(), n.e.ds540);
            this.cJg.getWindow().setAttributes(attributes);
            this.cJj = new dt(this);
            this.cJi = (LinearLayout) this.cJh.findViewById(n.g.good_class_group);
            this.cJl = (TextView) this.cJh.findViewById(n.g.dialog_button_cancel);
            this.cJl.setOnClickListener(new dv(this));
            this.cJk = (TextView) this.cJh.findViewById(n.g.dialog_button_ok);
            this.cJk.setOnClickListener(this.bgT);
        }
        this.cJi.removeAllViews();
        this.cIm = new ArrayList();
        com.baidu.tieba.pb.pb.main.b.a aV = aV("0", this.cGj.getPageContext().getString(n.j.def_good_class));
        this.cIm.add(aV);
        aV.setChecked(true);
        this.cJi.addView(aV);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.tieba.pb.pb.main.b.a aV2 = aV(String.valueOf(arrayList.get(i2).rH()), arrayList.get(i2).rG());
                this.cIm.add(aV2);
                View view = new View(this.cGj.getPageContext().getPageActivity());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.d(this.cGj.getPageContext().getPageActivity(), n.e.ds1));
                com.baidu.tbadk.core.util.as.j(view, n.d.cp_bg_line_a);
                view.setLayoutParams(layoutParams);
                this.cJi.addView(view);
                this.cJi.addView(aV2);
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.cJp.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.k.dip2px(this.cGj.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.k.dip2px(this.cGj.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.k.dip2px(this.cGj.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.cJp.setLayoutParams(layoutParams2);
            this.cJp.removeAllViews();
            this.cJp.addView(this.cJi);
        }
        com.baidu.adp.lib.h.j.a(this.cJg, this.cGj.getPageContext());
    }

    private com.baidu.tieba.pb.pb.main.b.a aV(String str, String str2) {
        Activity pageActivity = this.cGj.getPageContext().getPageActivity();
        com.baidu.tieba.pb.pb.main.b.a aVar = new com.baidu.tieba.pb.pb.main.b.a(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.k.d(pageActivity, n.e.ds100));
        aVar.setOnCheckedChangeListener(this.cJj);
        aVar.setTag(str);
        aVar.setText(str2);
        aVar.setLayoutParams(layoutParams);
        return aVar;
    }

    public void amG() {
        this.cGj.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.cGj.hideProgressBar();
        if (z && z2) {
            this.cGj.showToast(this.cGj.getPageContext().getString(n.j.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.ax.isEmpty(str)) {
                str = TbadkCoreApplication.m411getInst().getResources().getString(n.j.neterror);
            }
            this.cGj.showToast(str);
        }
    }

    public void ZY() {
        this.cIT.setVisibility(0);
    }

    public void ZX() {
        this.cIT.setVisibility(8);
    }

    public View amH() {
        if (this.cJh != null) {
            return this.cJh.findViewById(n.g.dialog_button_ok);
        }
        return null;
    }

    public String amI() {
        return this.cJm;
    }

    public View getView() {
        return this.cyP;
    }

    public void amJ() {
        com.baidu.adp.lib.util.k.c(this.cGj.getPageContext().getPageActivity(), this.cGj.getCurrentFocus());
    }

    public void amK() {
        this.cGj.showProgressBar();
    }

    public void fq(boolean z) {
        this.cGj.hideProgressBar();
        ana();
    }

    public void amL() {
        this.cIR.startLoadData();
    }

    public void amM() {
    }

    public void amN() {
        this.cGj.hideProgressBar();
        this.cIR.vP();
        ang();
        this.aVi.completePullRefresh();
        amS();
    }

    public void amO() {
        this.aVi.completePullRefresh();
        this.cJy.setVisibility(8);
        amS();
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.cIM.setOnLongClickListener(onLongClickListener);
    }

    public void a(c.b bVar, boolean z, boolean z2) {
        if (this.cJn != null) {
            this.cJn.dismiss();
            this.cJn = null;
        }
        this.cJn = new com.baidu.tbadk.core.dialog.c(this.cGj.getPageContext().getPageActivity());
        this.cJn.bJ(n.j.operation);
        if (z2) {
            this.cJn.a(new String[]{this.cGj.getPageContext().getString(n.j.copy)}, bVar);
        } else if (!z) {
            this.cJn.a(new String[]{this.cGj.getPageContext().getString(n.j.copy), this.cGj.getPageContext().getString(n.j.mark)}, bVar);
        } else {
            this.cJn.a(new String[]{this.cGj.getPageContext().getString(n.j.copy), this.cGj.getPageContext().getString(n.j.remove_mark)}, bVar);
        }
        this.cJn.d(this.cGj.getPageContext());
        this.cJn.tj();
    }

    public int amP() {
        int firstVisiblePosition = this.aVi.getFirstVisiblePosition();
        com.baidu.adp.widget.ListView.e eVar = (com.baidu.adp.widget.ListView.e) this.aVi.getAdapter();
        if (eVar != null) {
            if (eVar.getItem(firstVisiblePosition) instanceof com.baidu.tieba.pb.a.b) {
                firstVisiblePosition++;
            }
            int headersCount = (this.aVi.getAdapter() == null || !(this.aVi.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) ? 0 : ((com.baidu.adp.widget.ListView.e) this.aVi.getAdapter()).getHeadersCount();
            return firstVisiblePosition > headersCount ? firstVisiblePosition - headersCount : 0;
        }
        return firstVisiblePosition;
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.cIP.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void i(com.baidu.tieba.pb.a.c cVar) {
        this.cIM.a(cVar);
        this.cIM.notifyDataSetChanged();
        if (cVar == null) {
            kG("");
        } else {
            kG(com.baidu.tbadk.core.util.ax.x(cVar.akH().getReply_num()));
        }
        amS();
    }

    public void j(com.baidu.tieba.pb.a.c cVar) {
        PraiseData praise;
        if (this.cIF == null) {
            this.cGj.getLayoutMode().k(((ViewStub) this.cIn.findViewById(n.g.praise_layout)).inflate());
            this.cIF = (FrsPraiseView) this.cIn.findViewById(n.g.pb_head_praise_view);
            this.cIF.setIsFromPb(true);
            this.cIJ = this.cIn.findViewById(n.g.new_pb_header_item_line_above_praise);
            this.cIF.cR(TbadkCoreApplication.m411getInst().getSkinType());
        }
        if (this.cIF != null) {
            boolean amS = amS();
            if (cVar != null && cVar.akI() != null && cVar.akI().size() > 0) {
                com.baidu.tieba.tbadkCore.data.r rVar = cVar.akI().get(0);
                if ((!this.cDs || rVar.aFq() != 1) && (praise = cVar.akH().getPraise()) != null && praise.getUser() != null && praise.getUser().size() > 0) {
                    this.cIF.setVisibility(0);
                    this.cIF.setIsFromPb(true);
                    this.cIF.a(praise, cVar.akH().getId(), praise.getPostId(), true);
                    this.cIJ.setVisibility(0);
                    if (this.cIF.getVisibility() == 0) {
                        this.cIK.setVisibility(0);
                        return;
                    }
                    return;
                }
            }
            this.cIF.setVisibility(8);
            this.cIJ.setVisibility(8);
            if (cVar != null && cVar.getPage() != null && cVar.getPage().rP() == 0 && this.cDs) {
                this.cIJ.setVisibility(8);
                if (amS) {
                    this.cII.setVisibility(0);
                    return;
                } else {
                    this.cII.setVisibility(8);
                    return;
                }
            }
            this.cIJ.setVisibility(0);
            this.cII.setVisibility(8);
        }
    }

    private com.baidu.tieba.tbadkCore.data.r a(com.baidu.tieba.pb.a.c cVar, boolean z, int i) {
        if (z) {
            if (cVar == null || cVar.akI() == null || cVar.akI().size() <= 0) {
                return null;
            }
            com.baidu.tieba.tbadkCore.data.r rVar = cVar.akI().get(0);
            if (rVar.aFq() != 1) {
                return k(cVar);
            }
            return rVar;
        }
        return k(cVar);
    }

    private com.baidu.tieba.tbadkCore.data.r k(com.baidu.tieba.pb.a.c cVar) {
        MetaData metaData;
        if (cVar == null || cVar.akH() == null || cVar.akH().getAuthor() == null) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.r rVar = new com.baidu.tieba.tbadkCore.data.r();
        MetaData author = cVar.akH().getAuthor();
        String userId = author.getUserId();
        HashMap<String, MetaData> userMap = cVar.akH().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = author;
        }
        rVar.mY(1);
        rVar.setId(cVar.akH().sD());
        rVar.setTitle(cVar.akH().getTitle());
        rVar.setTime(cVar.akH().getCreateTime());
        rVar.setAuthor(metaData);
        return rVar;
    }

    private void b(com.baidu.tieba.pb.a.c cVar, boolean z, int i) {
        com.baidu.tieba.tbadkCore.data.r a;
        this.cIq.setVisibility(8);
        if (cVar != null && cVar.akH() != null && (a = a(cVar, z, i)) != null) {
            String str = null;
            if (cVar != null && cVar.akH() != null && cVar.akH().getAuthor() != null) {
                str = cVar.akH().getAuthor().getUserId();
            }
            this.cJT = !cVar.akH().sM() && a(a, cVar.akH().getId(), str);
            if (z) {
                this.cIE.setVisibility(8);
            } else {
                this.cIE.setVisibility(0);
            }
            this.cIq.setVisibility(0);
            SparseArray sparseArray = (SparseArray) this.cIq.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.cIq.setTag(sparseArray);
            }
            sparseArray.put(n.g.tag_clip_board, a);
            sparseArray.put(n.g.tag_is_subpb, false);
            this.cIA.setText(com.baidu.tbadk.core.util.ax.s(a.getTime()));
            cVar.akH().sL();
            this.cIr.setVisibility(0);
            this.cIr.setText(cVar.akH().getSpan_str());
            j(cVar);
            ArrayList<com.baidu.tbadk.core.data.a> sA = cVar.akH().sA();
            if (sA != null && sA.size() > 0) {
                this.cJG.setText(String.valueOf(sA.get(0).rj()));
                this.cJF.setVisibility(0);
            } else {
                this.cJF.setVisibility(8);
            }
            com.baidu.tbadk.core.util.as.i(this.cJF, n.f.activity_join_num_bg);
            com.baidu.tbadk.core.util.as.b(this.cJG, n.d.cp_link_tip_d, 1);
            boolean appResponseToIntentClass = TbadkCoreApplication.m411getInst().appResponseToIntentClass(LiveRoomEntranceActivityConfig.class);
            if (cVar != null && cVar.akH() != null && cVar.akH().getAnchorInfoData() != null) {
                if (cVar.akH().getAnchorInfoData().getGroup_id() != 0 && appResponseToIntentClass) {
                    if (this.cJD == null) {
                        BdLog.e("pb time   liveCardLayout new");
                        this.cJD = ((ViewStub) this.cIn.findViewById(n.g.live_card_layout)).inflate();
                        this.cGj.getLayoutMode().k(this.cJD);
                        this.cJE = (LiveBroadcastCard) this.cIn.findViewById(n.g.item_card);
                    }
                    this.cJD.setVisibility(0);
                    LiveCardData liveCardData = new LiveCardData();
                    liveCardData.setPublisherId(cVar.akH().getAnchorInfoData().getAuthorId());
                    liveCardData.setPublisherName(cVar.akH().getAnchorInfoData().getAuthorName());
                    liveCardData.setPublisherPortrait(cVar.akH().getAnchorInfoData().getPublisherPortrait());
                    liveCardData.setGroupId(cVar.akH().getAnchorInfoData().getGroup_id());
                    liveCardData.setIntro(cVar.akH().getAnchorInfoData().getIntro());
                    liveCardData.setLikers(cVar.akH().getAnchorInfoData().getLikers());
                    liveCardData.setListeners(cVar.akH().getAnchorInfoData().getListeners());
                    liveCardData.setName(cVar.akH().getAnchorInfoData().getName());
                    liveCardData.setPortrait(cVar.akH().getAnchorInfoData().getPortrait());
                    liveCardData.setStatus(cVar.akH().getAnchorInfoData().getStatus());
                    liveCardData.setStartTime(cVar.akH().getAnchorInfoData().getStartTime());
                    liveCardData.setIsVip(cVar.akH().getAnchorInfoData().getIsVip());
                    this.cJE.setData(liveCardData);
                    this.cJE.setStatisticsKey("notice_pb_live");
                } else if (this.cJD != null) {
                    this.cJD.setVisibility(8);
                }
            }
            if (cVar != null && cVar.akH() != null && cVar.akH().getAuthor() != null) {
                String userId = cVar.akH().getAuthor().getUserId();
                if (userId != null && !userId.equals("0") && userId.equals(a.getAuthor().getUserId())) {
                    this.cIz.setVisibility(0);
                } else {
                    this.cIz.setVisibility(8);
                }
            }
            if (a.getAuthor() != null) {
                int level_id = a.getAuthor().getLevel_id();
                int is_bawu = a.getAuthor().getIs_bawu();
                String bawu_type = a.getAuthor().getBawu_type();
                int i2 = 3;
                if (level_id != 0) {
                    this.cIu.setVisibility(0);
                    com.baidu.tbadk.core.util.as.c(this.cIu, com.baidu.tbadk.core.util.c.ci(level_id));
                    this.cIu.setOnClickListener(null);
                } else {
                    this.cIu.setVisibility(8);
                }
                if (is_bawu != 0) {
                    if (bawu_type.equals("manager")) {
                        com.baidu.tbadk.core.util.as.c(this.cIw, n.f.pb_manager);
                        this.cIu.setVisibility(8);
                        this.cIw.setVisibility(0);
                    } else if (bawu_type.equals("assist")) {
                        com.baidu.tbadk.core.util.as.c(this.cIw, n.f.pb_assist);
                        this.cIu.setVisibility(8);
                        this.cIw.setVisibility(0);
                    }
                }
                if (a.getAuthor().getGender() == 2) {
                    com.baidu.tbadk.core.util.as.c(this.cIv, n.f.icon_pb_pop_girl);
                    this.cIv.setVisibility(0);
                } else if (a.getAuthor().getGender() == 1) {
                    com.baidu.tbadk.core.util.as.c(this.cIv, n.f.icon_pb_pop_boy);
                    this.cIv.setVisibility(0);
                } else {
                    this.cIv.setVisibility(8);
                }
                if (!StringUtils.isNull(a.getAuthor().getName_show()) && com.baidu.adp.lib.util.j.aV(a.getAuthor().getName_show()) > 14) {
                    i2 = 0;
                }
                ArrayList<IconData> iconInfo = a.getAuthor().getIconInfo();
                ArrayList<IconData> tShowInfoNew = a.getAuthor().getTShowInfoNew();
                if (this.cIx != null) {
                    this.cIx.setTag(n.g.tag_user_id, a.getAuthor().getUserId());
                    this.cIx.setOnClickListener(this.cGj.cFr.bhv);
                    this.cIx.a(iconInfo, i2, this.cGj.getResources().getDimensionPixelSize(n.e.pb_icon_width), this.cGj.getResources().getDimensionPixelSize(n.e.pb_icon_height), this.cGj.getResources().getDimensionPixelSize(n.e.pb_icon_margin));
                }
                if (this.cIy != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        this.cIy.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    this.cIy.setOnClickListener(this.cGj.cFr.cKn);
                    this.cIy.a(tShowInfoNew, 3, this.cGj.getResources().getDimensionPixelSize(n.e.small_icon_width), this.cGj.getResources().getDimensionPixelSize(n.e.small_icon_height), this.cGj.getResources().getDimensionPixelSize(n.e.big_icon_margin), true);
                }
                this.cIs.setText(a.getAuthor().getName_show());
                this.cIs.setTag(n.g.tag_user_id, a.getAuthor().getUserId());
                this.cIs.setTag(n.g.tag_user_name, a.getAuthor().getName_show());
                if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                    com.baidu.tbadk.core.util.as.b(this.cIs, n.d.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.as.b(this.cIs, n.d.cp_cont_f, 1);
                }
                if (!this.cDQ) {
                    this.cIt.setVisibility(8);
                }
                this.cIt.setUserId(a.getAuthor().getUserId());
                this.cIt.setUserName(a.getAuthor().getUserName());
                this.cIt.setImageDrawable(null);
                this.cIt.setTag(a.getAuthor().getUserId());
                if (this.cJT) {
                    dw dwVar = new dw(this, a);
                    this.cIs.setOnClickListener(dwVar);
                    this.cIt.setOnClickListener(dwVar);
                } else {
                    this.cIs.setOnClickListener(this.cGj.cFr.cKm);
                    this.cIt.setOnClickListener(this.cGj.cFr.cKm);
                }
                this.cIt.d(a.getAuthor().getPortrait(), 28, false);
            }
        }
    }

    public boolean amQ() {
        return this.cKd;
    }

    private boolean amR() {
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.userId);
    }

    public void a(com.baidu.tieba.pb.a.c cVar, int i, int i2, boolean z, int i3, boolean z2) {
        Parcelable amr;
        Parcelable amr2;
        String sb;
        if (cVar != null) {
            if (cVar.akH() != null) {
                this.cJH = cVar.akH().sq();
                this.Xo = cVar.akH().sn();
                if (cVar.akH().getAnchorLevel() != 0) {
                    this.cKd = true;
                }
            }
            if (cVar.getUserData() != null) {
                this.userId = cVar.getUserData().getUserId();
            }
            this.cJC = false;
            this.cDs = z;
            amN();
            b(cVar, z, i);
            this.cIM.eT(this.cDs);
            this.cIM.a(cVar);
            this.cIM.notifyDataSetChanged();
            if (cVar.akG() != null) {
                this.mForumName = cVar.akG().getName();
                this.mForumId = cVar.getForumId();
            }
            this.cIl.kJ(this.mForumName);
            if (cVar.akH() != null) {
                kG(com.baidu.tbadk.core.util.ax.x(cVar.akH().getReply_num()));
                if (cVar.akH().getPraise() != null) {
                    if (cVar.akH().getPraise().getNum() < 1) {
                        sb = this.cGj.getResources().getString(n.j.frs_item_praise_text);
                    } else {
                        sb = new StringBuilder(String.valueOf(cVar.akH().getPraise().getNum())).toString();
                    }
                    if (this.cIi != -1) {
                        cVar.akH().getPraise().setIsLike(this.cIi);
                    }
                    D(sb, cVar.akH().getPraise().getIsLike() == 1);
                }
            }
            if (cVar.getPage().rO() == 0 && !z) {
                this.aVi.setNextPage(null);
            } else if (this.cGj.isLogin()) {
                this.aVi.setNextPage(this.cIR);
                ang();
            } else if (cVar.getPage().rO() == 1) {
                this.cJC = true;
                if (this.cIS == null) {
                    this.cIS = new com.baidu.tieba.pb.view.b(this.cGj.getPageContext());
                }
                this.aVi.setNextPage(this.cIS);
            }
            if (cVar.getPage().rP() == 0 && z) {
                this.aVi.setPullRefresh(null);
                this.cIj = 0;
                this.cJy.setVisibility(8);
            } else {
                if (this.cIQ == null) {
                    this.cIQ = new com.baidu.tieba.pb.view.j(this.cGj.getPageContext());
                    this.cIQ.mT();
                    this.cIQ.a(this.ago);
                }
                this.aVi.setPullRefresh(this.cIQ);
                this.cIj = 1;
                if (this.cIQ != null) {
                    this.cIQ.cP(TbadkCoreApplication.m411getInst().getSkinType());
                }
                this.cJy.setVisibility(0);
                ang();
            }
            amS();
            ArrayList<com.baidu.tieba.tbadkCore.data.r> akI = cVar.akI();
            if (cVar.getPage().rO() == 0 || akI == null || akI.size() < cVar.getPage().rN()) {
                this.cIR.setText(this.cGj.getResources().getString(n.j.list_no_more));
                l(cVar);
            } else if (z2) {
                if (this.cKc) {
                    vP();
                    if (cVar.getPage().rO() != 0) {
                        this.cIR.setText(this.cGj.getResources().getString(n.j.pb_load_more));
                    }
                } else {
                    this.cIR.showLoading();
                }
            } else {
                this.cIR.showLoading();
            }
            if (z) {
                this.cJz.setVisibility(0);
                this.aHp.setVisibility(0);
                this.cJA.setText(this.cGj.getResources().getString(n.j.btn_show_passed_pb));
            } else {
                this.cJz.setVisibility(8);
                this.aHp.setVisibility(8);
                this.cJA.setText(this.cGj.getResources().getString(n.j.btn_show_passed_pb_aftre));
            }
            if (cVar.akH() != null && cVar.akH().getAuthor() != null && cVar.akH().getAuthor().getType() == 0) {
                this.cIl.ann();
            }
            switch (i) {
                case 2:
                    this.aVi.setSelection(i2);
                    if (this.cIo != null) {
                        CompatibleUtile.scrollListViewBy(this.aVi, -this.cIo.getHeight(), 0);
                        break;
                    }
                    break;
                case 3:
                    if (i3 == 1 && (amr2 = dd.amq().amr()) != null) {
                        this.aVi.onRestoreInstanceState(amr2);
                        this.cJX = true;
                        break;
                    } else {
                        this.aVi.setSelection(0);
                        break;
                    }
                    break;
                case 4:
                    this.cKc = false;
                    this.aVi.setSelection(0);
                    break;
                case 5:
                    this.aVi.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1 && (amr = dd.amq().amr()) != null) {
                        this.aVi.onRestoreInstanceState(amr);
                        this.cJX = true;
                        break;
                    } else {
                        this.aVi.setSelection(0);
                        break;
                    }
                    break;
            }
            if (this.cJH == cJJ && amR()) {
                anj();
            }
        }
    }

    public void fr(boolean z) {
        this.cJo = z;
        this.cIl.fr(z);
    }

    public void vP() {
        if (this.cIR != null) {
            this.cIR.vP();
        }
        ang();
    }

    public void NV() {
        this.aVi.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean amS() {
        boolean z;
        boolean z2 = true;
        if (this.cIo != null && this.cIo.getVisibility() == 0) {
            if (this.cIG != null) {
                this.cIG.setVisibility(0);
                z = true;
            } else {
                z = true;
            }
        } else {
            if (this.cIG != null) {
                this.cIG.setVisibility(8);
            }
            z = false;
        }
        if (this.cJr != null && this.cJr.getVisibility() == 0) {
            if (this.cIH != null) {
                this.cIH.setVisibility(0);
            }
        } else {
            if (this.cIH != null) {
                this.cIH.setVisibility(8);
            }
            z2 = z;
        }
        if ((this.cIJ == null || this.cIJ.getVisibility() == 8) && z2 && this.cDs) {
            this.cII.setVisibility(0);
        } else {
            this.cII.setVisibility(8);
        }
        return z2;
    }

    public boolean a(com.baidu.tieba.pb.a.c cVar, boolean z, boolean z2) {
        if (cVar == null) {
            return false;
        }
        if (this.cIr != null) {
            if (cVar.akH().sC() == 0) {
                this.cIr.setVisibility(0);
                cVar.akH().sL();
                this.cIr.setText(cVar.akH().getSpan_str());
            } else {
                this.cIr.setVisibility(8);
            }
        }
        if (z) {
            if (this.cJD != null) {
                this.cJD.findViewById(n.g.pb_head_live_blank).setVisibility(8);
            }
        } else if (this.cJD != null) {
            this.cJD.findViewById(n.g.pb_head_live_blank).setVisibility(0);
        }
        this.cDs = z;
        com.baidu.tbadk.core.data.z akH = cVar.akH();
        if (akH != null) {
            a(akH.su());
        }
        if (cVar.akL() == 1) {
            amT();
            Button button = (Button) this.cIn.findViewById(n.g.pb_head_function_manage_commit_top);
            Button button2 = (Button) this.cIn.findViewById(n.g.pb_head_function_manage_cancel_top);
            Button button3 = (Button) this.cIn.findViewById(n.g.pb_head_function_manage_commit_good);
            Button button4 = (Button) this.cIn.findViewById(n.g.pb_head_function_manage_cancel_good);
            button.setOnClickListener(this.bgT);
            button2.setOnClickListener(this.bgT);
            button3.setOnClickListener(this.bgT);
            button4.setOnClickListener(this.bgT);
            if (cVar.akH().getIs_good() == 1) {
                button3.setVisibility(8);
                button4.setVisibility(0);
            } else {
                button3.setVisibility(0);
                button4.setVisibility(8);
            }
            if (cVar.akH().getIs_top() == 1) {
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

    private void amT() {
        if (this.cIo == null) {
            this.cIo = ((ViewStub) this.cIn.findViewById(n.g.pb_header_function_manage)).inflate();
            this.cGj.getLayoutMode().k(this.cIo);
            this.cIG = this.cIn.findViewById(n.g.new_pb_header_item_line_above_manage);
            return;
        }
        this.cIo.setVisibility(0);
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
                if (cVar.akL() != 0 && a.getAuthor() != null) {
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
                    String userId3 = cVar.akH().getAuthor().getUserId();
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
                        sparseArray.put(n.g.tag_forbid_user_name, a.getAuthor().getUserName());
                        sparseArray.put(n.g.tag_forbid_user_post_id, a.getId());
                    }
                    sparseArray.put(n.g.tag_del_post_id, a.getId());
                    sparseArray.put(n.g.tag_del_post_type, 0);
                    sparseArray.put(n.g.tag_del_post_is_self, Boolean.valueOf(z3));
                    sparseArray.put(n.g.tag_manage_user_identity, Integer.valueOf(cVar.akL()));
                    sparseArray.put(n.g.tag_should_manage_visible, true);
                    a(n.j.manage, sparseArray);
                } else if (z4) {
                    SparseArray<Object> sparseArray2 = new SparseArray<>();
                    sparseArray2.put(n.g.tag_del_post_id, a.getId());
                    sparseArray2.put(n.g.tag_del_post_type, 0);
                    sparseArray2.put(n.g.tag_del_post_is_self, Boolean.valueOf(z3));
                    sparseArray2.put(n.g.tag_manage_user_identity, Integer.valueOf(cVar.akL()));
                    sparseArray2.put(n.g.tag_should_manage_visible, false);
                    a(n.j.delete, sparseArray2);
                }
            }
            amS();
        }
    }

    private void a(int i, SparseArray<Object> sparseArray) {
        amT();
        Button button = (Button) this.cIn.findViewById(n.g.pb_head_function_manage_delormanage);
        button.setOnClickListener(this.bgT);
        button.setVisibility(0);
        button.setText(i);
        button.setTag(sparseArray);
    }

    public View getNextView() {
        return this.ayL;
    }

    public void kH(String str) {
        if (this.cIR != null && !StringUtils.isNull(str)) {
            this.cIR.setText(str);
        }
    }

    public BdListView getListView() {
        return this.aVi;
    }

    public int amU() {
        return n.g.richText;
    }

    public int Oc() {
        return n.g.user_icon_box;
    }

    public Button amV() {
        return (Button) this.cIn.findViewById(n.g.pb_head_function_manage_commit_good);
    }

    public Button amW() {
        return (Button) this.cIn.findViewById(n.g.pb_head_function_manage_cancel_good);
    }

    public Button amX() {
        return (Button) this.cIn.findViewById(n.g.pb_head_function_manage_commit_top);
    }

    public Button amY() {
        return (Button) this.cIn.findViewById(n.g.pb_head_function_manage_cancel_top);
    }

    public void c(BdListView.e eVar) {
        this.aVi.setOnSrollToBottomListener(eVar);
    }

    public void a(BdListView.h hVar) {
        this.aVi.setOnSrollToTopListener(hVar);
    }

    public void a(r.a aVar) {
        this.ago = aVar;
        if (this.cIQ != null) {
            this.cIQ.a(aVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.q qVar, a.b bVar) {
        if (qVar != null) {
            int rM = qVar.rM();
            int rK = qVar.rK();
            if (this.cIN != null) {
                this.cIN.tf();
            } else {
                this.cIN = new com.baidu.tbadk.core.dialog.a(this.cGj.getPageContext().getPageActivity());
                this.cIO = LayoutInflater.from(this.cGj.getPageContext().getPageActivity()).inflate(n.h.dialog_direct_pager, (ViewGroup) null);
                this.cIN.m(this.cIO);
                this.cIN.a(n.j.dialog_ok, bVar);
                this.cIN.b(n.j.dialog_cancel, new dx(this));
                this.cIN.a(new dy(this));
                this.cIN.b(this.cGj.getPageContext()).tf();
            }
            this.cIP = (EditText) this.cIO.findViewById(n.g.input_page_number);
            this.cIP.setText("");
            TextView textView = (TextView) this.cIO.findViewById(n.g.current_page_number);
            if (rM <= 0) {
                rM = 1;
            }
            if (rK <= 0) {
                rK = 1;
            }
            textView.setText(MessageFormat.format(this.cGj.getApplicationContext().getResources().getString(n.j.current_page), Integer.valueOf(rM), Integer.valueOf(rK)));
            this.cGj.ShowSoftKeyPadDelay(this.cIP, 150);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.aVi.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.cGj.showToast(str);
    }

    public boolean fs(boolean z) {
        if (this.Li == null || !this.Li.Bm()) {
            return false;
        }
        this.Li.zK();
        return true;
    }

    public void amZ() {
        if (this.cKe != null) {
            while (this.cKe.size() > 0) {
                TbImageView remove = this.cKe.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        amZ();
    }

    public void onDestroy() {
        this.cGj.hideProgressBar();
        if (this.aUd != null && this.bbw != null) {
            this.aUd.b(this.bbw);
        }
        ana();
        this.cIR.vP();
        if (this.cJP != null) {
            com.baidu.adp.lib.h.h.hj().removeCallbacks(this.cJP);
        }
        if (this.cJQ != null) {
            com.baidu.adp.lib.h.h.hj().removeCallbacks(this.cJQ);
        }
    }

    public void ana() {
        this.cIl.qn();
        com.baidu.adp.lib.util.k.c(this.cGj.getPageContext().getPageActivity(), this.cIP);
        if (this.cJn != null) {
            this.cJn.dismiss();
        }
        anb();
    }

    public void eS(boolean z) {
        this.cIM.eS(z);
    }

    public void eU(boolean z) {
        this.cDQ = z;
        this.cIM.eU(z);
    }

    public void ft(boolean z) {
        this.cJq = z;
    }

    public void anb() {
        if (this.cIW != null) {
            this.cIW.dismiss();
        }
        if (this.cIX != null) {
            com.baidu.adp.lib.h.j.b(this.cIX, this.cGj.getPageContext());
        }
        if (this.cJg != null) {
            com.baidu.adp.lib.h.j.b(this.cJg, this.cGj.getPageContext());
        }
        if (this.cIU != null) {
            com.baidu.adp.lib.h.j.b(this.cIU, this.cGj.getPageContext());
        }
    }

    public void onChangeSkinType(int i) {
        this.cGj.getLayoutMode().ac(i == 1);
        this.cGj.getLayoutMode().k(this.cyP);
        this.cGj.getLayoutMode().k(this.cIp);
        this.cGj.getLayoutMode().k(this.cIn);
        this.cGj.getLayoutMode().k(this.ayL);
        this.cIl.mNavigationBar.onChangeSkinType(this.cGj.getPageContext(), i);
        com.baidu.tbadk.core.util.as.a(this.cIl.cKv, n.f.btn_more_selector_s, n.f.btn_more_selector);
        com.baidu.tbadk.core.util.as.a(this.cIl.cKw, n.f.icon_floor_addition_selector, n.f.icon_floor_addition_selector);
        if (this.cIO != null) {
            this.cGj.getLayoutMode().k(this.cIO);
        }
        fr(this.cJo);
        this.cIM.notifyDataSetChanged();
        if (this.cIQ != null) {
            this.cIQ.cP(i);
        }
        if (this.cIR != null) {
            this.cIR.cP(i);
            com.baidu.tbadk.core.util.as.i(this.ayL, n.f.pb_foot_more_trans_selector);
            this.cIR.cN(n.f.pb_foot_more_trans_selector);
        }
        if (this.Li != null) {
            this.Li.onChangeSkinType(i);
        }
        if (this.cIF != null) {
            this.cIF.cR(i);
        }
        if (this.cIS != null) {
            this.cIS.cP(i);
        }
        if (this.cIm != null && this.cIm.size() > 0) {
            for (com.baidu.tieba.pb.pb.main.b.a aVar : this.cIm) {
                aVar.anl();
            }
        }
        fn(i == 1);
    }

    public void setOnImageClickListener(TbRichTextView.d dVar) {
        this.aFq = dVar;
        this.cIM.setOnImageClickListener(this.aFq);
    }

    public void f(NoNetworkView.a aVar) {
        this.bbw = aVar;
        if (this.aUd != null) {
            this.aUd.a(this.bbw);
        }
    }

    public void fu(boolean z) {
        this.cIM.setIsFromCDN(z);
        this.mIsFromCDN = z;
    }

    public Button anc() {
        return this.cJr;
    }

    public void l(com.baidu.tieba.pb.a.c cVar) {
        if (cVar != null) {
            ArrayList<com.baidu.tieba.tbadkCore.data.r> akI = cVar.akI();
            if (akI.size() == 1) {
                com.baidu.tieba.tbadkCore.data.r rVar = akI.get(0);
                if (rVar.aFw() < rVar.aFp().size()) {
                    this.aVi.setNextPage(null);
                    return;
                } else {
                    this.aVi.setNextPage(this.cIR);
                    return;
                }
            }
            this.aVi.setNextPage(this.cIR);
        }
    }

    public void and() {
        if (com.baidu.tbadk.performanceLog.y.EH().EI()) {
            int lastVisiblePosition = this.aVi.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.aVi.getChildAt(i);
                if (childAt != null) {
                    TbRichTextView tbRichTextView = (TbRichTextView) childAt.findViewById(n.g.richText);
                    if (tbRichTextView != null) {
                        for (int i2 = 0; i2 < tbRichTextView.getChildCount(); i2++) {
                            View childAt2 = tbRichTextView.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.performanceLog.s perfLog = tbImageView.getPerfLog();
                                perfLog.eF(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
                                perfLog.azO = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr = new int[2];
                                    tbRichTextView.getLocationOnScreen(iArr);
                                    if (iArr[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                    }
                                }
                                tbImageView.vI();
                            }
                        }
                    }
                    HeadImageView headImageView = (HeadImageView) childAt.findViewById(n.g.photo);
                    if (headImageView != null) {
                        com.baidu.tbadk.performanceLog.s perfLog2 = headImageView.getPerfLog();
                        perfLog2.eF(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
                        perfLog2.azO = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr2 = new int[2];
                            headImageView.getLocationOnScreen(iArr2);
                            if (iArr2[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                            }
                        }
                        headImageView.vI();
                    }
                }
            }
        }
    }

    public void fv(boolean z) {
        if (this.cJs != null && this.cJs != null) {
            if (this.cJq) {
                fk(z);
            } else {
                fl(z);
            }
        }
    }

    public void ane() {
        if (this.cJs != null) {
            this.cJs.setVisibility(8);
        }
    }

    public TextView anf() {
        return this.cJz;
    }

    public void adL() {
        if (this.cJB == null) {
            this.cJB = new com.baidu.tbadk.core.view.b(this.cGj.getPageContext());
        }
        this.cJB.av(true);
    }

    public void ang() {
        if (this.cJB != null) {
            this.cJB.av(false);
        }
    }

    private boolean a(com.baidu.tieba.tbadkCore.data.r rVar, String str, String str2) {
        ColumnLayout.a aVar;
        if (rVar == null || rVar.getAuthor() == null || rVar.getAuthor().getGodInfo() == null) {
            return false;
        }
        GodInfo godInfo = rVar.getAuthor().getGodInfo();
        this.cIq.setPadding(TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.e.ds18), TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.e.ds16), TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.e.ds20), 0);
        this.cIn.setPadding(0, TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.e.ds34), 0, 0);
        int dimensionPixelSize = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.e.ds120);
        if (this.cIt.getLayoutParams() == null) {
            aVar = new ColumnLayout.a(dimensionPixelSize, dimensionPixelSize);
        } else {
            aVar = (ColumnLayout.a) this.cIt.getLayoutParams();
            aVar.width = dimensionPixelSize;
            aVar.height = dimensionPixelSize;
        }
        this.cIt.setLayoutParams(aVar);
        if (this.cIB == null) {
            this.cIB = new TextView(this.cGj.getActivity());
            this.cIB.setClickable(false);
            this.cIB.setIncludeFontPadding(false);
            this.cIB.setGravity(16);
            this.cIB.setTextSize(0, this.cGj.getResources().getDimensionPixelSize(n.e.fontsize20));
            ColumnLayout.a aVar2 = new ColumnLayout.a(-2, -2, 3, 2);
            aVar2.topMargin = this.cGj.getResources().getDimensionPixelSize(n.e.ds10);
            this.cIB.setSingleLine(true);
            this.cIB.setEllipsize(TextUtils.TruncateAt.END);
            this.cIq.addView(this.cIB, -1, aVar2);
            com.baidu.tbadk.core.util.as.i((View) this.cIB, n.f.icon_shen);
            com.baidu.tbadk.core.util.as.b(this.cIB, n.d.cp_cont_h, 1);
        }
        if (StringUtils.isNull(godInfo.intro, true)) {
            this.cIB.setText(n.j.god_intro_default);
        } else {
            this.cIB.setText(godInfo.intro);
        }
        if (this.cIC == null) {
            this.cIC = new TextView(this.cGj.getActivity());
            this.cIC.setClickable(false);
            this.cIC.setTextSize(0, this.cGj.getResources().getDimensionPixelSize(n.e.fontsize24));
            ColumnLayout.a aVar3 = new ColumnLayout.a(-2, -2, 3, 2);
            aVar3.topMargin = this.cGj.getResources().getDimensionPixelSize(n.e.ds8);
            this.cIC.setSingleLine(true);
            this.cIq.addView(this.cIC, -1, aVar3);
        }
        ky(rVar.getAuthor().getGiftNum());
        this.cIA.setVisibility(8);
        long userIdLong = rVar.getAuthor().getUserIdLong();
        String userName = rVar.getAuthor().getUserName();
        String id = rVar.getId();
        if (this.cID == null) {
            this.cID = new TextView(this.cGj.getActivity());
            this.cID.setTextSize(0, this.cGj.getResources().getDimensionPixelSize(n.e.fontsize28));
            int dimensionPixelSize2 = this.cGj.getResources().getDimensionPixelSize(n.e.ds10);
            int dimensionPixelSize3 = this.cGj.getResources().getDimensionPixelSize(n.e.ds12);
            this.cID.setPadding(dimensionPixelSize3, dimensionPixelSize2, dimensionPixelSize3, dimensionPixelSize2);
            this.cID.setCompoundDrawablePadding(this.cGj.getResources().getDimensionPixelSize(n.e.ds8));
            this.cID.setGravity(17);
            com.baidu.tbadk.core.util.as.b(this.cID, n.d.cp_cont_i, 1);
            this.cID.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.as.getDrawable(n.f.icon_btn_gift), (Drawable) null, (Drawable) null, (Drawable) null);
            com.baidu.tbadk.core.util.as.i((View) this.cID, n.f.btn_all_red);
            this.cID.setText(n.j.send_gift);
            this.cID.setOnClickListener(new ea(this, userIdLong, userName, str, id));
            this.cIq.addView(this.cID, -1, new ColumnLayout.a(-2, -2, 16, 3));
        }
        if (this.cJY == null) {
            eb ebVar = new eb(this, userIdLong);
            this.cJY = (LinearLayout) LayoutInflater.from(this.cGj.getActivity()).inflate(n.h.god_floating_view, (ViewGroup) null);
            this.cJY.setOnClickListener(ebVar);
            this.cJY.setTag(n.g.tag_user_id, String.valueOf(userIdLong));
            this.cJY.setTag(n.g.tag_user_name, userName);
            HeadImageView headImageView = (HeadImageView) this.cJY.findViewById(n.g.god_floating_owner_photo);
            headImageView.setOnClickListener(ebVar);
            if (!this.cDQ) {
                headImageView.setVisibility(8);
            }
            headImageView.setUserId(rVar.getAuthor().getUserId());
            headImageView.setUserName(rVar.getAuthor().getUserName());
            headImageView.setImageDrawable(null);
            headImageView.setTag(rVar.getAuthor().getUserId());
            headImageView.d(rVar.getAuthor().getPortrait(), 28, false);
            View findViewById = this.cJY.findViewById(n.g.god_floating_owner_info_floor_owner);
            if (str2 != null && !str2.equals("0") && str2.equals(rVar.getAuthor().getUserId())) {
                findViewById.setVisibility(0);
            } else {
                findViewById.setVisibility(8);
            }
            ImageView imageView = (ImageView) this.cJY.findViewById(n.g.god_floating_owner_info_user_rank);
            int level_id = rVar.getAuthor().getLevel_id();
            int is_bawu = rVar.getAuthor().getIs_bawu();
            String bawu_type = rVar.getAuthor().getBawu_type();
            int i = 3;
            if (level_id != 0) {
                imageView.setVisibility(0);
                com.baidu.tbadk.core.util.as.c(imageView, com.baidu.tbadk.core.util.c.ci(level_id));
                imageView.setOnClickListener(null);
            } else {
                imageView.setVisibility(8);
            }
            ImageView imageView2 = (ImageView) this.cJY.findViewById(n.g.god_floating_owner_info_user_bawu);
            if (is_bawu != 0) {
                if (bawu_type.equals("manager")) {
                    com.baidu.tbadk.core.util.as.c(imageView2, n.f.pb_manager);
                    imageView.setVisibility(8);
                    imageView2.setVisibility(0);
                } else if (bawu_type.equals("assist")) {
                    com.baidu.tbadk.core.util.as.c(imageView2, n.f.pb_assist);
                    imageView.setVisibility(8);
                    imageView2.setVisibility(0);
                }
            }
            ImageView imageView3 = (ImageView) this.cJY.findViewById(n.g.god_floating_owner_info_user_gender);
            if (rVar.getAuthor().getGender() == 2) {
                com.baidu.tbadk.core.util.as.c(imageView3, n.f.icon_pb_pop_girl);
                imageView3.setVisibility(0);
            } else if (rVar.getAuthor().getGender() == 1) {
                com.baidu.tbadk.core.util.as.c(imageView3, n.f.icon_pb_pop_boy);
                imageView3.setVisibility(0);
            } else {
                imageView3.setVisibility(8);
            }
            if (!StringUtils.isNull(rVar.getAuthor().getName_show()) && com.baidu.adp.lib.util.j.aV(rVar.getAuthor().getName_show()) > 14) {
                i = 0;
            }
            ArrayList<IconData> iconInfo = rVar.getAuthor().getIconInfo();
            ArrayList<IconData> tShowInfoNew = rVar.getAuthor().getTShowInfoNew();
            UserIconBox userIconBox = (UserIconBox) this.cJY.findViewById(n.g.god_floating_owner_info_user_icon);
            UserIconBox userIconBox2 = (UserIconBox) this.cJY.findViewById(n.g.god_floating_owner_info_tshow_icon);
            if (userIconBox != null) {
                userIconBox.setTag(n.g.tag_user_id, rVar.getAuthor().getUserId());
                userIconBox.setOnClickListener(this.cGj.cFr.bhv);
                userIconBox.a(iconInfo, i, this.cGj.getResources().getDimensionPixelSize(n.e.pb_icon_width), this.cGj.getResources().getDimensionPixelSize(n.e.pb_icon_height), this.cGj.getResources().getDimensionPixelSize(n.e.pb_icon_margin));
            }
            if (userIconBox2 != null) {
                userIconBox2.setOnClickListener(this.cGj.cFr.cKn);
                userIconBox2.a(tShowInfoNew, 3, this.cGj.getResources().getDimensionPixelSize(n.e.small_icon_width), this.cGj.getResources().getDimensionPixelSize(n.e.small_icon_height), this.cGj.getResources().getDimensionPixelSize(n.e.big_icon_margin), true);
            }
            TextView textView = (TextView) this.cJY.findViewById(n.g.god_floating_owner_info_user_name);
            if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                com.baidu.tbadk.core.util.as.b(textView, n.d.cp_cont_h, 1);
            } else {
                com.baidu.tbadk.core.util.as.b(textView, n.d.cp_cont_f, 1);
            }
            textView.setText(rVar.getAuthor().getName_show());
            ((TextView) this.cJY.findViewById(n.g.god_floating_gift)).setOnClickListener(new ec(this, userIdLong, userName, str, id));
            TextView textView2 = (TextView) this.cJY.findViewById(n.g.god_floating_intro);
            if (StringUtils.isNull(godInfo.intro, true)) {
                textView2.setText(n.j.god_intro_default);
            } else {
                textView2.setText(godInfo.intro);
            }
            com.baidu.tbadk.core.util.as.i((View) textView2, n.f.icon_shen);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(3, n.g.title_wrapper);
            this.cyP.addView(this.cJY, layoutParams);
            this.cGj.getLayoutMode().k(this.cJY);
        }
        return true;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.cJT && !this.cJU && i > this.cIj) {
            this.cJW = true;
            ani();
            return;
        }
        this.cJW = false;
        anh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anh() {
        if (this.cJY != null && this.cJY.getVisibility() != 8) {
            this.cJY.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ani() {
        if (!this.cJV && this.cJY != null && this.cJY.getVisibility() != 0) {
            this.cJV = true;
            if (this.cJX) {
                this.cJY.setVisibility(0);
                this.cJX = false;
                this.cJV = false;
                return;
            }
            com.baidu.tieba.tbadkCore.a.a(this.cGj, this.cJY, n.a.fade_in_10to100, new ed(this));
        }
    }

    public void anj() {
        if (!this.cKf) {
            TiebaStatic.log("c10490");
            this.cKf = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cGj.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(cJK, Integer.valueOf(cJM));
            aVar.bF(n.j.grade_thread_tips);
            View inflate = LayoutInflater.from(this.cGj.getPageContext().getPageActivity()).inflate(n.h.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(n.g.function_description_view)).setText(n.j.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(n.g.title_view)).setText(n.j.grade_thread_tips);
            aVar.m(inflate);
            aVar.x(sparseArray);
            aVar.a(n.j.grade_button_tips, this.cGj);
            aVar.b(n.j.look_again, new ee(this));
            aVar.b(this.cGj.getPageContext()).tf();
        }
    }

    public void ank() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cGj.getPageContext().getPageActivity());
        aVar.cF(this.cGj.getResources().getString(n.j.upgrade_to_new_photo_live_tips));
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(cJK, Integer.valueOf(cJO));
        aVar.x(sparseArray);
        aVar.a(n.j.upgrade_to_new, this.cGj);
        aVar.b(n.j.cancel, new ef(this));
        aVar.b(this.cGj.getPageContext()).tf();
    }

    public int sq() {
        return this.cJH;
    }

    public void kI(String str) {
        if (str.contains("_")) {
            str = str.replace("_", "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cGj.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.cGj.getPageContext().getPageActivity()).inflate(n.h.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(n.g.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(n.g.function_description_view)).setVisibility(8);
        aVar.m(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(cJK, Integer.valueOf(cJN));
        aVar.x(sparseArray);
        aVar.a(n.j.view, this.cGj);
        aVar.b(n.j.cancel, new eh(this));
        aVar.b(this.cGj.getPageContext()).tf();
    }

    public void a(int i, com.baidu.tieba.pb.a.c cVar, boolean z, int i2) {
        com.baidu.tieba.tbadkCore.data.r a;
        if (i > 0 && (a = a(cVar, z, i2)) != null && a.getAuthor() != null) {
            MetaData author = a.getAuthor();
            author.setGiftNum(author.getGiftNum() + i);
            if (this.cJT) {
                ky(a.getAuthor().getGiftNum());
            }
        }
    }

    private void ky(int i) {
        if (this.cIC != null) {
            String w = com.baidu.tbadk.core.util.ax.w(i);
            String format = String.format(this.cGj.getResources().getString(n.j.gift_received_count), w);
            int indexOf = format.indexOf(w);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(format);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(com.baidu.tbadk.core.util.as.getColor(n.d.cp_cont_d)), 0, format.length(), 17);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(com.baidu.tbadk.core.util.as.getColor(n.d.cp_cont_h)), indexOf, w.length() + indexOf, 17);
            this.cIC.setText(spannableStringBuilder);
        }
    }
}
