package com.baidu.tieba.pb.main;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
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
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.editortool.PbEditor;
import com.baidu.tieba.frs.view.FrsPraiseView;
import com.baidu.tieba.view.PbListView;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public final class bm {
    public static int a = 80;
    private TextView A;
    private TextView B;
    private View C;
    private View D;
    private View E;
    private View F;
    private View G;
    private RelativeLayout H;
    private ba I;
    private com.baidu.tbadk.core.view.i J;
    private bi K;
    private com.baidu.tieba.view.y Q;
    private PbListView R;
    private View S;
    private View.OnClickListener W;
    private View aG;
    private com.baidu.tbadk.editortool.x aJ;
    private View aK;
    private View aL;
    private LinearLayout aM;
    private TextView aN;
    private LinearLayout aO;
    private ImageView aP;
    private TextView aQ;
    private LinearLayout aS;
    private View aT;
    private PbListView aU;
    private ay aX;
    private View.OnClickListener af;
    NavigationBar b;
    private com.baidu.tbadk.editortool.ab ba;
    TextView e;
    ImageView f;
    ImageView g;
    ImageView h;
    public FrsPraiseView i;
    public PbEditor j;
    public View k;
    az l;
    private PbActivity m;
    private FrameLayout n;
    private BdListView o;
    private NoNetworkView p;
    private View q;
    private View r;
    private ColumnLayout s;
    private TextView t;
    private TextView u;
    private HeadImageView v;
    private TextView w;
    private UserIconBox x;
    private UserIconBox y;
    private ImageView z;
    View c = null;
    ImageView d = null;
    private Dialog L = null;
    private Dialog M = null;
    private com.baidu.tieba.pb.sub.m N = null;
    private View O = null;
    private EditText P = null;
    private FrameLayout T = null;
    private View U = null;
    private DialogInterface.OnClickListener V = null;
    private View.OnClickListener X = null;
    private View.OnClickListener Y = null;
    private View.OnClickListener Z = null;
    private AbsListView.OnScrollListener aa = null;
    private com.baidu.tbadk.widget.richText.r ab = null;
    private com.baidu.tbadk.widget.richText.q ac = null;
    private com.baidu.tbadk.core.view.m ad = null;
    private Dialog ae = null;
    private Dialog ag = null;
    private View ah = null;
    private Button ai = null;
    private Button aj = null;
    private TextView ak = null;
    private Dialog al = null;
    private View am = null;
    private int an = 0;
    private RadioGroup ao = null;
    private RadioButton ap = null;
    private RadioButton aq = null;
    private RadioButton ar = null;
    private Button as = null;
    private Button at = null;
    private TextView au = null;
    private Dialog av = null;
    private View aw = null;
    private RadioGroup ax = null;
    private CompoundButton.OnCheckedChangeListener ay = null;
    private Button az = null;
    private Button aA = null;
    private String aB = null;
    private ct aC = null;
    private Dialog aD = null;
    private boolean aE = false;
    private ScrollView aH = null;
    private Button aI = null;
    private boolean aR = true;
    private boolean aV = false;
    private final View.OnClickListener aW = new bn(this);
    private View.OnLongClickListener aY = null;
    private boolean aZ = false;
    private final List<bd> bb = new ArrayList();
    private boolean bc = true;
    private final com.baidu.tbadk.imageManager.d bd = new by(this);
    private final com.baidu.tbadk.imageManager.d be = new ck(this);
    private final com.baidu.tbadk.imageManager.d bf = new cn(this);
    private final com.baidu.tbadk.imageManager.d bg = new co(this);
    private com.baidu.tieba.c.a aF = new com.baidu.tieba.c.a(new cp(this));

    public final NoNetworkView a() {
        return this.p;
    }

    public final void b() {
        this.aR = true;
        if (this.j != null) {
            this.j.setVisibility(8);
        }
        if (this.aL != null) {
            this.aL.setVisibility(0);
            this.aK.setVisibility(0);
        }
    }

    public bm(PbActivity pbActivity, View.OnClickListener onClickListener) {
        this.m = null;
        this.n = null;
        this.b = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.o = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = null;
        this.B = null;
        this.i = null;
        this.C = null;
        this.D = null;
        this.E = null;
        this.F = null;
        this.G = null;
        this.I = null;
        this.J = null;
        this.K = null;
        this.Q = null;
        this.R = null;
        this.S = null;
        this.W = null;
        this.af = null;
        this.aG = null;
        this.aK = null;
        this.aL = null;
        this.aM = null;
        this.aN = null;
        this.aO = null;
        this.aP = null;
        this.aQ = null;
        this.aS = null;
        this.aT = null;
        this.aU = null;
        this.ba = new com.baidu.tbadk.editortool.ab(this.m);
        this.m = pbActivity;
        this.W = onClickListener;
        LayoutInflater from = LayoutInflater.from(this.m);
        this.n = (FrameLayout) from.inflate(com.baidu.tieba.a.i.new_pb_activity, (ViewGroup) null);
        this.m.addContentView(this.n, new FrameLayout.LayoutParams(-1, -1));
        this.H = (RelativeLayout) this.m.findViewById(com.baidu.tieba.a.h.title_wrapper);
        this.p = (NoNetworkView) this.m.findViewById(com.baidu.tieba.a.h.view_no_network);
        this.o = (BdListView) this.m.findViewById(com.baidu.tieba.a.h.new_pb_list);
        this.aG = new View(this.m);
        this.aG.setBackgroundResource(com.baidu.tieba.a.e.cp_bg_line_d);
        this.aG.setLayoutParams(new AbsListView.LayoutParams(-1, this.m.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.navi_height)));
        this.o.addHeaderView(this.aG);
        View view = new View(this.m);
        view.setLayoutParams(new AbsListView.LayoutParams(-1, this.m.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.pb_editor_height)));
        this.o.addFooterView(view);
        this.b = (NavigationBar) this.m.findViewById(com.baidu.tieba.a.h.view_navigation_bar);
        this.b.setOnClickListener(new cq(this));
        this.k = this.b.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.W);
        this.e = (TextView) this.b.a(NavigationBar.ControlAlign.HORIZONTAL_CENTER, com.baidu.tieba.a.i.pb_title_textview, (View.OnClickListener) null);
        this.h = (ImageView) this.b.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.a.i.widget_nb_add_floor, this.W);
        this.f = (ImageView) this.b.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.a.i.nb_item_floor_host, this.W);
        this.g = (ImageView) this.b.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.a.i.nb_item_floor_more, this.W);
        this.K = new bi(this.m, this.W);
        this.J = new com.baidu.tbadk.core.view.i(this.m, this.K.a(), this.b, this.m.getResources().getDrawable(com.baidu.tieba.a.g.bg_pull_down_right_n), new cr(this));
        this.j = (PbEditor) this.m.findViewById(com.baidu.tieba.a.h.pb_editor_view);
        this.j.setFrom(1);
        this.j.a(false);
        this.j.setVisibility(8);
        this.aL = this.m.findViewById(com.baidu.tieba.a.h.pb_editor_tool_comment);
        this.aM = (LinearLayout) this.m.findViewById(com.baidu.tieba.a.h.pb_editor_tool_comment_reply);
        this.aO = (LinearLayout) this.m.findViewById(com.baidu.tieba.a.h.pb_editor_tool_comment_praise);
        this.aK = this.m.findViewById(com.baidu.tieba.a.h.pb_editor_tool_comment_line);
        this.aN = (TextView) this.m.findViewById(com.baidu.tieba.a.h.pb_editor_tool_comment_reply_text);
        this.aP = (ImageView) this.m.findViewById(com.baidu.tieba.a.h.pb_editor_tool_comment_praise_icon);
        this.aQ = (TextView) this.m.findViewById(com.baidu.tieba.a.h.pb_editor_tool_comment_praise_text);
        this.aM.setOnClickListener(new cs(this));
        this.aO.setOnClickListener(this.W);
        this.aO.setOnTouchListener(this.m);
        I();
        this.q = from.inflate(com.baidu.tieba.a.i.new_pb_header_item, (ViewGroup) null);
        this.s = (ColumnLayout) this.q.findViewById(com.baidu.tieba.a.h.pb_head_owner_root);
        this.s.setOnLongClickListener(this.aY);
        this.s.setOnTouchListener(this.aF);
        this.s.setVisibility(8);
        this.q.setOnTouchListener(this.aF);
        this.t = (TextView) this.q.findViewById(com.baidu.tieba.a.h.pb_head_post_title);
        this.t.setTextSize(com.baidu.tbadk.core.data.n.q());
        this.t.setVisibility(8);
        this.u = (TextView) this.s.findViewById(com.baidu.tieba.a.h.pb_head_owner_info_user_name);
        this.v = (HeadImageView) this.s.findViewById(com.baidu.tieba.a.h.pb_head_owner_photo);
        if (!this.bc) {
            this.v.setVisibility(8);
        }
        this.w = (TextView) this.s.findViewById(com.baidu.tieba.a.h.pb_head_owner_info_user_rank);
        this.x = (UserIconBox) this.s.findViewById(com.baidu.tieba.a.h.pb_head_owner_info_user_icon);
        this.y = (UserIconBox) this.s.findViewById(com.baidu.tieba.a.h.pb_head_owner_info_tshow_icon);
        this.z = (ImageView) this.s.findViewById(com.baidu.tieba.a.h.pb_head_owner_info_floor_owner);
        this.A = (TextView) this.s.findViewById(com.baidu.tieba.a.h.pb_head_owner_info_time);
        this.B = (TextView) this.q.findViewById(com.baidu.tieba.a.h.pb_head_reverse_hint);
        this.B.setOnClickListener(this.W);
        this.B.setVisibility(8);
        this.i = (FrsPraiseView) this.q.findViewById(com.baidu.tieba.a.h.pb_head_praise_view);
        this.i.setIsFromPb(true);
        this.r = this.q.findViewById(com.baidu.tieba.a.h.pb_head_function_manage_root);
        this.C = this.q.findViewById(com.baidu.tieba.a.h.new_pb_header_item_line_above_manage);
        this.D = this.q.findViewById(com.baidu.tieba.a.h.new_pb_header_item_line_above_livepost);
        this.E = this.q.findViewById(com.baidu.tieba.a.h.new_pb_header_item_line_below_livepost);
        this.F = this.q.findViewById(com.baidu.tieba.a.h.new_pb_header_item_line_above_praise);
        this.G = this.q.findViewById(com.baidu.tieba.a.h.new_pb_header_item_line_above_showpassed);
        this.q.setOnLongClickListener(new bo(this));
        this.aS = (LinearLayout) this.q.findViewById(com.baidu.tieba.a.h.btn_show_passed_pb);
        PbActivity pbActivity2 = this.m;
        PbListView.IconType iconType = PbListView.IconType.ICON_UP_WARD;
        this.aU = new PbListView(pbActivity2, (byte) 0);
        this.aT = this.aU.a();
        this.aU.a(this.m.getResources().getString(com.baidu.tieba.a.k.btn_show_passed_pb));
        this.aT.setOnClickListener(this.aW);
        this.aS.addView(this.aT);
        this.aS.requestLayout();
        this.aS.invalidate();
        int l = TbadkApplication.j().l();
        this.aT.setBackgroundResource(l == 1 ? com.baidu.tieba.a.e.cp_bg_line_e_1 : com.baidu.tieba.a.e.cp_bg_line_e);
        this.aU.a(l == 1 ? com.baidu.tieba.a.e.cp_bg_line_e_1 : com.baidu.tieba.a.e.cp_bg_line_e);
        this.aU.b(com.baidu.tieba.a.e.cp_bg_line_e);
        ai();
        this.I = new ba(this.m);
        this.I.e(this.W);
        this.I.a(this.aF);
        this.I.a(this.ab);
        this.af = new bp(this);
        this.I.a(this.af);
        this.o.setAdapter((ListAdapter) this.I);
        this.o.addHeaderView(this.q);
        this.Q = new com.baidu.tieba.view.y(this.m);
        this.Q.a();
        this.R = new PbListView(this.m);
        this.S = this.R.b().findViewById(com.baidu.tieba.a.h.pb_more_view);
        if (this.S != null) {
            this.S.setOnClickListener(this.W);
        }
        int l2 = TbadkApplication.j().l();
        this.S.setBackgroundResource(l2 == 1 ? com.baidu.tieba.a.g.pb_foot_more_trans_selector_1 : com.baidu.tieba.a.g.pb_foot_more_trans_selector);
        this.R.c();
        this.R.a(l2 == 1 ? com.baidu.tieba.a.g.pb_foot_more_trans_selector_1 : com.baidu.tieba.a.g.pb_foot_more_trans_selector);
        this.R.b(com.baidu.tieba.a.g.pb_foot_more_trans_selector);
        this.e.setOnClickListener(this.W);
    }

    private void c(String str) {
        if (this.aN != null && !"0".equals(str)) {
            this.aN.setText(str);
        } else {
            this.aN.setText(this.m.getString(com.baidu.tieba.a.k.reply));
        }
    }

    public final void a(String str, boolean z) {
        if (this.aQ != null) {
            this.aQ.setText(str);
            int l = TbadkApplication.j().l();
            if (z) {
                if (l == 1) {
                    this.aP.setImageResource(com.baidu.tieba.a.g.icon_hand_click_1);
                } else {
                    this.aP.setImageResource(com.baidu.tieba.a.g.icon_hand_click);
                }
            } else if (l == 1) {
                this.aP.setImageResource(com.baidu.tieba.a.g.icon_hand_normal_1);
            } else {
                this.aP.setImageResource(com.baidu.tieba.a.g.icon_hand_normal);
            }
        }
    }

    public final View c() {
        return this.aO;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(bm bmVar, boolean z) {
        if (bmVar.o != null) {
            if (z) {
                bmVar.o.postDelayed(new bq(bmVar, z), 10L);
            } else {
                bmVar.o.setEnabled(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(bm bmVar, View view) {
        boolean z = false;
        com.baidu.adp.lib.util.f.e("PbView", "showHideToolbar", "toggle");
        if (bmVar.H == null || bmVar.j == null || view == null) {
            return;
        }
        boolean z2 = bmVar.aR ? bmVar.aL.getVisibility() == 0 : bmVar.j.getVisibility() == 0;
        if (bmVar.H.getVisibility() == 0 || z2) {
            z = true;
        }
        if (!z) {
            Animation loadAnimation = AnimationUtils.loadAnimation(view.getContext(), com.baidu.tieba.a.b.top_fold_down);
            loadAnimation.setAnimationListener(new bt(bmVar));
            bmVar.H.startAnimation(loadAnimation);
            Animation loadAnimation2 = AnimationUtils.loadAnimation(view.getContext(), com.baidu.tieba.a.b.bottom_fold_up);
            loadAnimation2.setAnimationListener(new bu(bmVar));
            if (bmVar.aR) {
                bmVar.aL.startAnimation(loadAnimation2);
                return;
            } else {
                bmVar.j.startAnimation(loadAnimation2);
                return;
            }
        }
        Animation loadAnimation3 = AnimationUtils.loadAnimation(view.getContext(), com.baidu.tieba.a.b.top_fold_up);
        loadAnimation3.setAnimationListener(new br(bmVar));
        bmVar.H.startAnimation(loadAnimation3);
        bmVar.j.f();
        Animation loadAnimation4 = AnimationUtils.loadAnimation(view.getContext(), com.baidu.tieba.a.b.bottom_fold_down);
        loadAnimation4.setAnimationListener(new bs(bmVar));
        if (bmVar.aR) {
            bmVar.aL.startAnimation(loadAnimation4);
        } else {
            bmVar.j.startAnimation(loadAnimation4);
        }
    }

    public final VoiceData.VoiceModel d() {
        return this.j.getAudioData();
    }

    public final void e() {
        this.j.q();
    }

    public final void f() {
        if (this.N != null) {
            this.N.j();
        }
    }

    public final bi g() {
        return this.K;
    }

    public final void h() {
        if (this.N != null) {
            this.N.k();
        }
    }

    public final VoiceData.VoiceModel i() {
        if (this.N != null) {
            return this.N.m();
        }
        return null;
    }

    public final void j() {
        if (this.N != null) {
            this.N.n();
        }
    }

    public final TextView k() {
        if (this.N == null || !(this.N instanceof com.baidu.tieba.pb.sub.j)) {
            return null;
        }
        return ((com.baidu.tieba.pb.sub.j) this.N).c();
    }

    public final ba l() {
        return this.I;
    }

    public final void a(az azVar) {
        this.l = azVar;
    }

    public final void m() {
        if (this.m.getCurrentFocus() != null) {
            com.baidu.adp.lib.util.i.a(this.m, this.m.getCurrentFocus());
        }
    }

    public final void a(View view) {
        if (this.ae == null) {
            this.ae = new Dialog(this.m, com.baidu.tieba.a.l.common_alert_dialog);
            this.ae.setCanceledOnTouchOutside(true);
            this.ae.setCancelable(true);
            this.ae.setContentView(this.m.getLayoutInflater().inflate(com.baidu.tieba.a.i.forum_manage_dialog, (ViewGroup) null));
            WindowManager.LayoutParams attributes = this.ae.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.i.b(this.m) * 0.9d);
            this.ae.getWindow().setAttributes(attributes);
        }
        Button button = (Button) this.ae.findViewById(com.baidu.tieba.a.h.del_post_btn);
        Button button2 = (Button) this.ae.findViewById(com.baidu.tieba.a.h.forbid_user_btn);
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            if ("".equals(sparseArray.get(com.baidu.tieba.a.h.tag_del_post_id))) {
                button.setVisibility(8);
            } else {
                SparseArray sparseArray2 = (SparseArray) button.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    button.setTag(sparseArray2);
                }
                button.setVisibility(0);
                sparseArray2.put(com.baidu.tieba.a.h.tag_del_post_id, sparseArray.get(com.baidu.tieba.a.h.tag_del_post_id));
                sparseArray2.put(com.baidu.tieba.a.h.tag_del_post_type, sparseArray.get(com.baidu.tieba.a.h.tag_del_post_type));
                sparseArray2.put(com.baidu.tieba.a.h.tag_del_post_is_self, sparseArray.get(com.baidu.tieba.a.h.tag_del_post_is_self));
                sparseArray2.put(com.baidu.tieba.a.h.tag_manage_user_identity, sparseArray.get(com.baidu.tieba.a.h.tag_manage_user_identity));
                button.setOnClickListener(new bv(this));
            }
            if ("".equals(sparseArray.get(com.baidu.tieba.a.h.tag_forbid_user_name))) {
                button2.setVisibility(8);
            } else {
                SparseArray sparseArray3 = (SparseArray) button2.getTag();
                if (sparseArray3 == null) {
                    sparseArray3 = new SparseArray();
                    button2.setTag(sparseArray3);
                }
                button2.setVisibility(0);
                sparseArray3.put(com.baidu.tieba.a.h.tag_forbid_user_name, sparseArray.get(com.baidu.tieba.a.h.tag_forbid_user_name));
                sparseArray3.put(com.baidu.tieba.a.h.tag_manage_user_identity, sparseArray.get(com.baidu.tieba.a.h.tag_manage_user_identity));
                button2.setOnClickListener(new bw(this));
            }
            this.ae.show();
        }
    }

    public final void a(ay ayVar) {
        this.aX = ayVar;
    }

    public final void a(int i, String str, int i2, boolean z) {
        if (this.ag == null) {
            this.ag = new Dialog(this.m, com.baidu.tieba.a.l.common_alert_dialog);
            this.ag.setCanceledOnTouchOutside(true);
            this.ag.setCancelable(true);
            this.ah = this.m.getLayoutInflater().inflate(com.baidu.tieba.a.i.del_post, (ViewGroup) null);
            this.ag.setContentView(this.ah);
            WindowManager.LayoutParams attributes = this.ag.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.i.b(this.m) * 0.9d);
            this.ag.getWindow().setAttributes(attributes);
            this.ai = (Button) this.ah.findViewById(com.baidu.tieba.a.h.dialog_button_ok);
            this.ai.setOnClickListener(this.W);
            this.aj = (Button) this.ah.findViewById(com.baidu.tieba.a.h.dialog_button_cancel);
            this.aj.setOnClickListener(new bx(this));
            this.ak = (TextView) this.ah.findViewById(com.baidu.tieba.a.h.confirm_text);
        }
        SparseArray sparseArray = (SparseArray) this.ai.getTag();
        if (sparseArray == null) {
            sparseArray = new SparseArray();
            this.ai.setTag(sparseArray);
        }
        sparseArray.put(com.baidu.tieba.a.h.tag_del_post_id, str);
        sparseArray.put(com.baidu.tieba.a.h.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(com.baidu.tieba.a.h.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(com.baidu.tieba.a.h.tag_del_post_is_self, Boolean.valueOf(z));
        if (i == 0) {
            this.ak.setText(com.baidu.tieba.a.k.del_thread_confirm);
        } else {
            this.ak.setText(com.baidu.tieba.a.k.del_post_confirm);
        }
        this.ag.show();
    }

    public final void a(ArrayList<com.baidu.tbadk.core.data.g> arrayList) {
        if (this.av == null) {
            this.av = new Dialog(this.m, com.baidu.tieba.a.l.common_alert_dialog);
            this.av.setCanceledOnTouchOutside(true);
            this.av.setCancelable(true);
            this.aw = this.m.getLayoutInflater().inflate(com.baidu.tieba.a.i.commit_good, (ViewGroup) null);
            this.aH = (ScrollView) this.aw.findViewById(com.baidu.tieba.a.h.good_scroll);
            this.av.setContentView(this.aw);
            WindowManager.LayoutParams attributes = this.av.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.i.b(this.m) * 0.9d);
            this.av.getWindow().setAttributes(attributes);
            this.ay = new bz(this);
            this.ax = (RadioGroup) this.aw.findViewById(com.baidu.tieba.a.h.good_class_group);
            this.aA = (Button) this.aw.findViewById(com.baidu.tieba.a.h.dialog_button_cancel);
            this.aA.setOnClickListener(new ca(this));
            this.az = (Button) this.aw.findViewById(com.baidu.tieba.a.h.dialog_button_ok);
            this.az.setOnClickListener(this.W);
        }
        this.ax.removeAllViews();
        LayoutInflater layoutInflater = this.m.getLayoutInflater();
        RadioButton radioButton = (RadioButton) layoutInflater.inflate(com.baidu.tieba.a.i.good_class_radio_button, (ViewGroup) null);
        radioButton.setTag("0");
        radioButton.setText(this.m.getString(com.baidu.tieba.a.k.def_good_class));
        radioButton.setOnCheckedChangeListener(this.ay);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, -2);
        layoutParams.setMargins(com.baidu.adp.lib.util.i.a((Context) this.m, 10.0f), com.baidu.adp.lib.util.i.a((Context) this.m, 5.0f), com.baidu.adp.lib.util.i.a((Context) this.m, 10.0f), com.baidu.adp.lib.util.i.a((Context) this.m, 5.0f));
        this.ax.addView(radioButton, layoutParams);
        this.ax.requestLayout();
        this.ax.check(radioButton.getId());
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                RadioButton radioButton2 = (RadioButton) layoutInflater.inflate(com.baidu.tieba.a.i.good_class_radio_button, (ViewGroup) null);
                radioButton2.setTag(String.valueOf(arrayList.get(i2).b()));
                radioButton2.setText(arrayList.get(i2).a());
                radioButton2.setOnCheckedChangeListener(this.ay);
                this.ax.addView(radioButton2, layoutParams);
                this.ax.requestLayout();
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.aH.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.i.a((Context) this.m, 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.i.a((Context) this.m, 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.i.a((Context) this.m, 220.0f);
                    break;
            }
            this.aH.setLayoutParams(layoutParams2);
            this.aH.removeAllViews();
            this.aH.addView(this.ax);
        }
        this.av.show();
    }

    public final void n() {
        this.m.showProgressBar();
    }

    public final void a(boolean z, String str, boolean z2) {
        this.m.hideProgressBar();
        if (z && z2) {
            this.m.showToast(this.m.getString(com.baidu.tieba.a.k.success));
        } else if (str != null && z2) {
            this.m.showToast(str);
        }
    }

    public final void o() {
        this.n.removeView(this.T);
    }

    public final View p() {
        if (this.ah != null) {
            return this.ah.findViewById(com.baidu.tieba.a.h.dialog_button_ok);
        }
        return null;
    }

    public final View q() {
        if (this.aw != null) {
            return this.aw.findViewById(com.baidu.tieba.a.h.dialog_button_ok);
        }
        return null;
    }

    public final String r() {
        return this.aB;
    }

    public final View s() {
        if (this.N != null) {
            return this.N.v();
        }
        return null;
    }

    public final void t() {
        this.m.showProgressBar();
        com.baidu.adp.lib.util.i.a(this.m, this.j.getEditText());
    }

    public final void u() {
        if (this.N != null) {
            this.N.y();
        } else {
            this.m.showProgressBar();
        }
    }

    public final void a(boolean z) {
        if (this.N != null) {
            this.N.z();
        } else {
            this.m.hideProgressBar();
        }
        ab();
        if (z) {
            this.j.getEditText().setText("");
            this.j.b();
            this.j.k();
            if (this.N != null) {
                this.N.s();
            }
        }
    }

    public final void v() {
        this.R.d();
    }

    public final void w() {
        this.m.hideProgressBar();
        this.R.e();
        this.aU.e();
        this.o.b();
        ai();
    }

    public final void x() {
        this.o.b();
        this.aS.setVisibility(8);
        ai();
    }

    public final void b(boolean z) {
        if (!z) {
            this.j.d();
        } else if (this.N != null) {
            this.N.b((String) null);
        }
    }

    public final void y() {
        if (!this.j.h()) {
            b(false);
        }
    }

    public final void z() {
        if (D() && this.N != null) {
            this.N.i();
        }
    }

    public final void A() {
        if (this.N == null) {
            PbActivity pbActivity = this.m;
            boolean z = this.aZ;
            this.N = new com.baidu.tieba.pb.sub.m(pbActivity, this.W, this.af, this.X, this.Y, this.Z);
            this.N.a(this.aJ);
            this.N.a(this.I.a());
            this.N.a(this.aa);
            this.N.c(this.I.c());
            this.N.b(this.I.d());
            this.U = this.N.l();
            this.N.a(this.ab);
            this.N.a(this.ac);
            this.N.a(this.I.b());
        }
        this.U.setVisibility(0);
        this.N.x();
        this.n.addView(this.U);
        aj();
    }

    public final void a(com.baidu.tbadk.editortool.x xVar) {
        if (xVar != null) {
            this.j.setOnActionListener(new cb(this, xVar));
            this.aJ = xVar;
            if (this.N != null) {
                this.N.a(xVar);
            }
        }
    }

    public final void a(ct ctVar) {
        this.aC = ctVar;
    }

    public final void a(boolean z, com.baidu.tieba.data.am amVar, String str, String str2, View view, int i) {
        Bitmap bitmap;
        int i2;
        Bitmap bitmap2;
        if (amVar != null && view != null) {
            TiebaStatic.a(this.m, "pb_tosubpb", "pbclick", 1, new Object[0]);
            if (this.N == null) {
                PbActivity pbActivity = this.m;
                boolean z2 = this.aZ;
                this.N = new com.baidu.tieba.pb.sub.m(pbActivity, this.W, this.af, this.X, this.Y, this.Z);
                this.N.a(this.aJ);
                this.N.a(this.I.a());
                this.N.a(this.aa);
                this.N.c(this.I.c());
                this.N.b(this.I.d());
                this.U = this.N.l();
                this.N.a(this.ab);
                this.N.a(this.ac);
                this.N.a(this.I.b());
            }
            this.N.b(this.I.e());
            this.N.a(amVar, i);
            if (str2 != null && !str2.equals("")) {
                this.N.c(str2);
            } else {
                this.N.c(1);
            }
            int i3 = 0;
            if (this.H.getVisibility() == 0) {
                i3 = this.H.getHeight();
            }
            int top = view.getTop();
            int bottom = view.getBottom();
            if (!z) {
                this.N.o();
            }
            int height = ((view.getHeight() + this.m.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.subpb_listitem_packup_min_height)) - this.m.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.pb_list_item_border_bottom_margin_top)) - this.n.getHeight();
            if (height > 0) {
                top += height;
            }
            AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator(1.5f);
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, top, 0.0f);
            translateAnimation.setDuration(300L);
            this.U.setAnimation(translateAnimation);
            this.n.invalidate();
            this.n.buildDrawingCache();
            Bitmap drawingCache = this.n.getDrawingCache();
            Bitmap bitmap3 = null;
            if (drawingCache == null) {
                bitmap = null;
                i2 = top;
                bitmap2 = null;
            } else {
                if (bottom > 0 && bottom < drawingCache.getHeight()) {
                    try {
                        bitmap3 = Bitmap.createBitmap(drawingCache, 0, bottom, drawingCache.getWidth(), drawingCache.getHeight() - bottom);
                    } catch (OutOfMemoryError e) {
                        bitmap3 = null;
                    }
                }
                if (top < i3) {
                    top = i3;
                }
                if (top <= 0 || top >= drawingCache.getHeight()) {
                    bitmap = null;
                    i2 = top;
                    bitmap2 = bitmap3;
                } else {
                    try {
                        bitmap = Bitmap.createBitmap(drawingCache, 0, 0, drawingCache.getWidth(), top);
                        i2 = top;
                        bitmap2 = bitmap3;
                    } catch (OutOfMemoryError e2) {
                        bitmap = null;
                        i2 = top;
                        bitmap2 = bitmap3;
                    }
                }
            }
            this.U.setVisibility(0);
            if (this.U.getParent() == this.n) {
                this.n.removeView(this.U);
            }
            this.n.addView(this.U);
            if (bitmap != null) {
                ImageView imageView = new ImageView(this.m);
                imageView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 48));
                imageView.setImageBitmap(bitmap);
                this.n.addView(imageView);
                TranslateAnimation translateAnimation2 = new TranslateAnimation(0.0f, 0.0f, 0.0f, -i2);
                translateAnimation2.setDuration(300L);
                imageView.setAnimation(translateAnimation2);
                translateAnimation2.setAnimationListener(new cc(this, imageView));
                translateAnimation2.setInterpolator(accelerateInterpolator);
                translateAnimation2.start();
            }
            ImageView imageView2 = new ImageView(this.m);
            imageView2.setImageBitmap(bitmap2);
            imageView2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 80));
            this.n.addView(imageView2);
            TranslateAnimation translateAnimation3 = new TranslateAnimation(0.0f, 0.0f, 0.0f, bitmap2 == null ? 0 : bitmap2.getHeight());
            translateAnimation3.setDuration(300L);
            imageView2.setAnimation(translateAnimation3);
            translateAnimation3.setAnimationListener(new ce(this, imageView2));
            translateAnimation.setAnimationListener(new cg(this, amVar, z, str, str2));
            translateAnimation.setInterpolator(accelerateInterpolator);
            translateAnimation3.setInterpolator(accelerateInterpolator);
            translateAnimation3.start();
            translateAnimation.start();
        }
    }

    public final void a(View.OnLongClickListener onLongClickListener) {
        this.aY = onLongClickListener;
        this.I.a(onLongClickListener);
        if (this.N != null) {
            this.N.a(onLongClickListener);
        }
    }

    public final void B() {
        if (D()) {
            this.N.p();
        }
    }

    public final void C() {
        if (D() && (this.N instanceof com.baidu.tieba.pb.sub.j)) {
            ((com.baidu.tieba.pb.sub.j) this.N).d();
        }
    }

    public final boolean D() {
        return (this.U == null || this.U.getVisibility() == 8) ? false : true;
    }

    public final void E() {
        if (this.U != null) {
            this.U.setVisibility(8);
            this.n.removeView(this.U);
            this.N.q();
        }
        ab();
        if (this.b != null) {
            this.b.setVisibility(0);
        }
        if (this.o != null) {
            this.o.setVisibility(0);
        }
        if (this.j != null) {
            int visibility = this.H != null ? this.H.getVisibility() : 0;
            if (visibility != 0) {
                this.aR = this.aL.getVisibility() == 0;
                this.j.setVisibility(visibility);
                this.aL.setVisibility(visibility);
                this.aK.setVisibility(visibility);
            } else if (!this.aR) {
                this.j.setVisibility(visibility);
            } else {
                this.aL.setVisibility(visibility);
                this.aK.setVisibility(visibility);
            }
        }
    }

    public final void F() {
        if (this.N != null) {
            this.N.A();
            if (this.N instanceof com.baidu.tieba.pb.sub.j) {
                ((com.baidu.tieba.pb.sub.j) this.N).e();
            }
        }
    }

    public final void a(com.baidu.tieba.data.am amVar, int i) {
        if (this.N != null) {
            this.N.A();
            this.N.b(this.I.e());
            this.N.a(amVar, i);
        }
    }

    public final void G() {
        if (this.N == null) {
            this.N = new com.baidu.tieba.pb.sub.j(this.m, this.aZ, this.W, this.af, this.X, this.Y, this.Z);
            this.N.a(this.aJ);
            this.N.a(this.I.a());
            this.N.a(this.aa);
            this.N.c(this.I.c());
            this.N.b(this.I.d());
            this.U = this.N.l();
            this.N.a(this.ab);
            this.N.a(this.ac);
            this.N.a(this.I.b());
        }
        this.U.setVisibility(0);
        this.N.x();
        this.n.addView(this.U);
        aj();
    }

    public final void a(com.baidu.tieba.data.am amVar, int i, String str, boolean z, boolean z2) {
        if (this.N != null && (this.N instanceof com.baidu.tieba.pb.sub.j)) {
            com.baidu.tieba.pb.sub.j jVar = (com.baidu.tieba.pb.sub.j) this.N;
            this.N.A();
            this.N.b(this.I.e());
            this.N.a(amVar, i);
            if (z2) {
                jVar.a(str);
            }
            if (!z) {
                jVar.f();
            } else {
                jVar.g();
            }
        }
    }

    public final void b(ArrayList<String> arrayList) {
        this.j.a(arrayList);
    }

    public final void c(ArrayList<String> arrayList) {
        if (this.N != null) {
            this.N.a(arrayList);
        }
    }

    public final void H() {
        this.aZ = true;
        this.j.o();
    }

    public final void I() {
        this.aZ = false;
        this.j.p();
    }

    public final void a(DialogInterface.OnClickListener onClickListener, boolean z, boolean z2) {
        if (this.aD != null) {
            this.aD.dismiss();
            this.aD = null;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this.m);
        builder.setTitle(com.baidu.tieba.a.k.operation);
        if (z2) {
            builder.setItems(new String[]{this.m.getString(com.baidu.tieba.a.k.copy)}, onClickListener);
        } else if (!z) {
            builder.setItems(new String[]{this.m.getString(com.baidu.tieba.a.k.copy), this.m.getString(com.baidu.tieba.a.k.mark)}, onClickListener);
        } else {
            builder.setItems(new String[]{this.m.getString(com.baidu.tieba.a.k.copy), this.m.getString(com.baidu.tieba.a.k.remove_mark)}, onClickListener);
        }
        this.aD = builder.create();
        this.aD.setCanceledOnTouchOutside(true);
        this.aD.show();
    }

    public final void c(boolean z) {
        this.j.setAudioFocusable(z);
    }

    public final void d(boolean z) {
        if (this.N != null) {
            this.N.a(z);
        }
    }

    public final void a(Bitmap bitmap) {
        this.j.a(bitmap);
        this.j.a();
    }

    public final void J() {
        this.j.a((Bitmap) null);
    }

    public final int K() {
        int firstVisiblePosition = this.o.getFirstVisiblePosition();
        int i = (this.o.getChildAt(0) == null || this.o.getChildAt(0).getBottom() >= this.o.getHeight()) ? firstVisiblePosition : firstVisiblePosition + 1;
        int c = (this.o.getAdapter() == null || !(this.o.getAdapter() instanceof com.baidu.adp.widget.ListView.g)) ? 0 : ((com.baidu.adp.widget.ListView.g) this.o.getAdapter()).c();
        if (i > c) {
            return i - c;
        }
        return 0;
    }

    public final int L() {
        try {
            return Integer.parseInt(this.P.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public final String M() {
        return this.j.getContent();
    }

    public final void a(String str) {
        this.j.setContent(str);
    }

    public final String N() {
        if (this.N == null) {
            return null;
        }
        return this.N.w();
    }

    public final String O() {
        if (this.N != null) {
            return this.N.r();
        }
        return null;
    }

    public final void a(com.baidu.tieba.data.ae aeVar) {
        this.I.a(aeVar);
        this.I.notifyDataSetChanged();
        c(new StringBuilder(String.valueOf(aeVar.d().o())).toString());
        ai();
    }

    public final void b(com.baidu.tieba.data.ae aeVar) {
        PraiseData k;
        boolean ai = ai();
        if (aeVar != null && aeVar.e() != null && aeVar.e().size() > 0) {
            com.baidu.tieba.data.ai aiVar = aeVar.e().get(0);
            if ((!this.aV || aiVar.e() != 1) && (k = aeVar.d().k()) != null && k.getUser() != null && k.getUser().size() > 0) {
                this.i.setVisibility(0);
                this.i.setImageLoad(this.ba);
                this.i.setIsFromPb(true);
                this.i.a(k, aeVar.d().l(), k.getPostId(), true);
                this.F.setVisibility(0);
                if (this.i != null && this.i.getVisibility() == 0) {
                    this.G.setVisibility(0);
                    return;
                }
                return;
            }
        }
        this.i.setVisibility(8);
        this.F.setVisibility(8);
        if (aeVar.f().g() == 0 && this.aV) {
            this.F.setVisibility(8);
            if (ai) {
                this.E.setVisibility(0);
                return;
            } else {
                this.E.setVisibility(8);
                return;
            }
        }
        this.F.setVisibility(0);
        this.E.setVisibility(8);
    }

    private com.baidu.tieba.data.ai a(com.baidu.tieba.data.ae aeVar, boolean z) {
        if (z) {
            if (aeVar == null || aeVar.e() == null || aeVar.e().size() <= 0) {
                return null;
            }
            com.baidu.tieba.data.ai aiVar = aeVar.e().get(0);
            if (aiVar.e() == 1) {
                return aiVar;
            }
        }
        return d(aeVar);
    }

    private static com.baidu.tieba.data.ai d(com.baidu.tieba.data.ae aeVar) {
        if (aeVar == null || aeVar.d() == null || aeVar.d().t() == null) {
            return null;
        }
        com.baidu.tieba.data.ai aiVar = new com.baidu.tieba.data.ai();
        MetaData t = aeVar.d().t();
        UserData userData = new UserData();
        aiVar.b(1);
        aiVar.a(aeVar.d().C());
        aiVar.b(aeVar.d().n());
        aiVar.a(aeVar.d().i());
        userData.setName_show(t.getName_show());
        userData.setPortrait(t.getPortrait());
        userData.setUserId(t.getUserId());
        userData.setUserName(t.getUserName());
        userData.setIconInfo(t.getIconInfo());
        userData.setTShowInfo(t.getTShowInfo());
        userData.setLevel_id(t.getLevel_id());
        userData.setIsLike(t.getIsLike());
        userData.setIsBawu(t.getIs_bawu());
        userData.setBawuType(t.getBawu_type());
        aiVar.a(userData);
        return aiVar;
    }

    public final void a(com.baidu.tieba.data.ae aeVar, int i, int i2, boolean z, int i3) {
        bj bjVar;
        bj bjVar2;
        String sb;
        this.aV = z;
        w();
        this.s.setVisibility(8);
        com.baidu.tieba.data.ai a2 = a(aeVar, z);
        if (a2 != null) {
            if (z) {
                this.B.setVisibility(8);
            } else {
                this.B.setVisibility(0);
            }
            this.s.setVisibility(0);
            SparseArray sparseArray = (SparseArray) this.s.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.s.setTag(sparseArray);
            }
            sparseArray.put(com.baidu.tieba.a.h.tag_clip_board, a2);
            sparseArray.put(com.baidu.tieba.a.h.tag_is_subpb, false);
            this.A.setText(com.baidu.tbadk.core.util.bc.a(a2.f()));
            aeVar.d().E();
            this.t.setVisibility(0);
            this.t.setText(aeVar.d().D());
            b(aeVar);
            String userId = aeVar.d().t().getUserId();
            if (userId == null || userId.equals("0") || !userId.equals(a2.g().getUserId())) {
                this.z.setVisibility(8);
            } else {
                this.z.setVisibility(0);
                if (TbadkApplication.j().l() == 1) {
                    this.z.setImageResource(com.baidu.tieba.a.g.icon_floorhost_1);
                } else {
                    this.z.setImageResource(com.baidu.tieba.a.g.icon_floorhost);
                }
            }
            if (a2.g() != null) {
                int level_id = a2.g().getLevel_id();
                int isLike = a2.g().getIsLike();
                int is_bawu = a2.g().getIs_bawu();
                String bawu_type = a2.g().getBawu_type();
                int i4 = 3;
                if (level_id == 0 || isLike == 0) {
                    this.w.setVisibility(8);
                } else {
                    this.w.setVisibility(0);
                    this.w.setText(String.valueOf(level_id));
                    this.w.setBackgroundResource(com.baidu.tbadk.core.util.g.b(level_id));
                    i4 = 2;
                    this.w.setOnClickListener(null);
                }
                if (is_bawu != 0) {
                    if (bawu_type.equals("manager")) {
                        this.w.setText((CharSequence) null);
                        this.w.setBackgroundResource(TbadkApplication.j().l() == 1 ? com.baidu.tieba.a.g.pb_manager_1 : com.baidu.tieba.a.g.pb_manager);
                        this.w.setOnClickListener(this.Y);
                    } else if (bawu_type.equals("assist")) {
                        this.w.setText((CharSequence) null);
                        this.w.setBackgroundResource(TbadkApplication.j().l() == 1 ? com.baidu.tieba.a.g.pb_assist_1 : com.baidu.tieba.a.g.pb_assist);
                        this.w.setOnClickListener(this.Y);
                    }
                }
                LinkedList<IconData> iconInfo = a2.g().getIconInfo();
                LinkedList<IconData> tShowInfo = a2.g().getTShowInfo();
                if (this.x != null) {
                    this.x.setOnClickListener(this.Y);
                    this.x.a(iconInfo, i4, this.m.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.pb_icon_width), this.m.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.pb_icon_height), this.m.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.pb_icon_margin));
                }
                if (this.y != null) {
                    this.y.setOnClickListener(this.Y);
                    this.y.a(tShowInfo, 3, this.m.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.big_icon_width), this.m.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.big_icon_height), this.m.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.big_icon_margin), true);
                }
                this.u.setText(a2.g().getName_show());
                this.u.setTag(a2.g().getUserId());
                int l = TbadkApplication.j().l();
                if (tShowInfo == null || tShowInfo.size() <= 0) {
                    if (l == 1) {
                        this.u.setTextColor(this.m.getResources().getColor(com.baidu.tieba.a.e.cp_cont_f_1));
                    } else {
                        this.u.setTextColor(this.m.getResources().getColor(com.baidu.tieba.a.e.cp_cont_f));
                    }
                } else if (l == 1) {
                    this.u.setTextColor(this.m.getResources().getColor(com.baidu.tieba.a.e.cp_cont_h_1));
                } else {
                    this.u.setTextColor(this.m.getResources().getColor(com.baidu.tieba.a.e.cp_cont_h));
                }
                if (!this.bc) {
                    this.v.setVisibility(8);
                }
                this.v.setUserId(a2.g().getUserId());
                this.v.setImageBitmap(null);
                this.v.setTag(a2.g().getUserId());
                this.u.setOnClickListener(this.X);
                this.v.setOnClickListener(this.X);
                String portrait = a2.g().getPortrait();
                com.baidu.tbadk.editortool.ab abVar = this.ba;
                com.baidu.adp.widget.ImageView.b b = com.baidu.tbadk.imageManager.e.a().b(portrait);
                if (b != null) {
                    b.a(this.v);
                } else {
                    this.ba.c(portrait, new ci(this));
                }
            }
        }
        this.I.a(this.aV);
        this.I.a(aeVar);
        this.I.notifyDataSetChanged();
        String name = aeVar.c().getName();
        this.e.setVisibility(0);
        this.e.setText(String.valueOf(name) + this.m.getString(com.baidu.tieba.a.k.bar));
        if (this.j != null && aeVar.d() != null) {
            c(new StringBuilder(String.valueOf(aeVar.d().o())).toString());
            if (aeVar.d().k() != null) {
                if (aeVar.d().k().getNum() < 1) {
                    sb = this.m.getResources().getString(com.baidu.tieba.a.k.frs_item_praise_text);
                } else {
                    sb = new StringBuilder(String.valueOf(aeVar.d().k().getNum())).toString();
                }
                a(sb, aeVar.d().k().getIsLike() == 1);
            }
        }
        if (aeVar.f().f() == 0 && !z) {
            this.o.setNextPage(null);
        } else {
            this.o.setNextPage(this.R);
            this.aU.e();
        }
        if (aeVar.f().g() == 0 && z) {
            this.o.setPullRefresh(null);
            this.aS.setVisibility(8);
        } else {
            this.o.setPullRefresh(this.Q);
            if (this.Q != null) {
                this.Q.a(TbadkApplication.j().l());
            }
            this.aS.setVisibility(0);
            this.aU.e();
        }
        ai();
        if (z) {
            if (aeVar.f().f() == 0) {
                this.R.a(this.m.getResources().getString(com.baidu.tieba.a.k.no_more_to_load));
                c(aeVar);
            } else {
                this.R.a(this.m.getResources().getString(com.baidu.tieba.a.k.pb_load_more));
            }
            this.aU.a(this.m.getResources().getString(com.baidu.tieba.a.k.btn_show_passed_pb));
        } else {
            this.aU.a(this.m.getResources().getString(com.baidu.tieba.a.k.btn_show_passed_pb_aftre));
        }
        if (aeVar.d() != null && aeVar.d().t() != null && aeVar.d().t().getType() == 0) {
            this.f.setVisibility(4);
            this.f.setEnabled(false);
        }
        switch (i) {
            case 2:
                this.o.setSelection(i2);
                CompatibleUtile.scrollListViewBy(this.o, -this.r.getHeight(), 0);
                return;
            case 3:
                if (i3 == 1) {
                    bjVar2 = bk.a;
                    Parcelable c = bjVar2.c();
                    if (c != null) {
                        this.o.onRestoreInstanceState(c);
                        return;
                    }
                }
                this.o.setSelection(0);
                return;
            case 4:
                if (z) {
                    this.o.setSelection(0);
                    return;
                } else if (aeVar.e() != null) {
                    if (aeVar.f() != null && aeVar.f().g() != 0) {
                        this.o.setSelection(aeVar.e().size() + 1);
                        return;
                    } else {
                        this.o.setSelection(aeVar.e().size());
                        return;
                    }
                } else {
                    return;
                }
            case 5:
                this.o.setSelection(0);
                return;
            case 6:
                if (i3 == 1) {
                    bjVar = bk.a;
                    Parcelable c2 = bjVar.c();
                    if (c2 != null) {
                        this.o.onRestoreInstanceState(c2);
                        return;
                    }
                }
                if (z) {
                    this.o.setSelection(0);
                    return;
                } else if (aeVar.e() != null) {
                    if (aeVar.f() != null && aeVar.f().g() != 0) {
                        this.o.setSelection(aeVar.e().size() + 1);
                        return;
                    } else {
                        this.o.setSelection(aeVar.e().size());
                        return;
                    }
                } else {
                    return;
                }
            default:
                return;
        }
    }

    public final void e(boolean z) {
        this.aE = z;
        if (TbadkApplication.j().l() == 1) {
            if (z) {
                this.f.setImageResource(com.baidu.tieba.a.g.icon_floor_host_s_1);
            } else {
                this.f.setImageResource(com.baidu.tieba.a.g.icon_floor_host_n_1);
            }
        } else if (z) {
            this.f.setImageResource(com.baidu.tieba.a.g.icon_floor_host_s);
        } else {
            this.f.setImageResource(com.baidu.tieba.a.g.icon_floor_host_n);
        }
    }

    public final void P() {
        if (this.R != null) {
            this.R.e();
        }
        if (this.aU != null) {
            this.aU.e();
        }
    }

    public final void a(boolean z, boolean z2) {
        if (!this.m.isProgressBarShown() && this.J != null) {
            if (com.baidu.tbadk.coreExtra.share.g.a(this.m)) {
                this.K.e().setVisibility(0);
                this.K.f().setVisibility(0);
            } else {
                this.K.e().setVisibility(8);
                this.K.f().setVisibility(8);
            }
            if (TbadkApplication.j().l() == 1) {
                if (z) {
                    this.K.h().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.a.g.icon_recommend_see_n_1, 0, 0, 0);
                } else {
                    this.K.h().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.a.g.icon_recommend_see_s_1, 0, 0, 0);
                }
                if (z2) {
                    this.K.d().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.a.g.icon_recommend_collect_s_1, 0, 0, 0);
                } else {
                    this.K.d().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.a.g.icon_recommend_collect_n_1, 0, 0, 0);
                }
            } else {
                if (z) {
                    this.K.h().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.a.g.icon_recommend_see_n, 0, 0, 0);
                } else {
                    this.K.h().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.a.g.icon_recommend_see_s, 0, 0, 0);
                }
                if (z2) {
                    this.K.d().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.a.g.icon_recommend_collect_s, 0, 0, 0);
                } else {
                    this.K.d().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.a.g.icon_recommend_collect_n, 0, 0, 0);
                }
            }
            this.J.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ai() {
        boolean z;
        boolean z2 = true;
        View findViewById = this.q.findViewById(com.baidu.tieba.a.h.pb_head_function_manage_root);
        if (findViewById != null && findViewById.getVisibility() == 0) {
            this.C.setVisibility(0);
            z = true;
        } else {
            this.C.setVisibility(8);
            z = false;
        }
        View findViewById2 = this.q.findViewById(com.baidu.tieba.a.h.pb_head_function_manage_go_to_live_post);
        if (findViewById2 != null && findViewById2.getVisibility() == 0) {
            this.D.setVisibility(0);
        } else {
            this.D.setVisibility(8);
            z2 = z;
        }
        if (z2 && this.aV) {
            this.E.setVisibility(0);
        } else {
            this.E.setVisibility(8);
        }
        return z2;
    }

    public final boolean a(com.baidu.tieba.data.ae aeVar, boolean z, boolean z2) {
        boolean z3;
        com.baidu.tbadk.core.data.q s;
        if (this.t != null) {
            if (aeVar.d().B() == 0) {
                this.t.setVisibility(0);
                aeVar.d().E();
                this.t.setText(aeVar.d().D());
            } else {
                this.t.setVisibility(8);
            }
        }
        this.aV = z;
        this.aI = (Button) this.q.findViewById(com.baidu.tieba.a.h.pb_head_function_manage_go_to_live_post);
        com.baidu.tbadk.core.data.o d = aeVar.d();
        if (d != null && (s = d.s()) != null && s.a() != 0) {
            int b = s.b();
            String string = this.m.getString(com.baidu.tieba.a.k.go_to_live_post_prefix);
            if (b == 0) {
                string = String.valueOf(string) + this.m.getString(com.baidu.tieba.a.k.go_to_interview_post);
            } else if (b == 1) {
                string = String.valueOf(string) + this.m.getString(com.baidu.tieba.a.k.go_to_discuss_post);
            }
            this.aI.setText(string);
            this.aI.setVisibility(0);
            this.aI.setOnClickListener(this.W);
            ai();
        }
        RelativeLayout relativeLayout = (RelativeLayout) this.q.findViewById(com.baidu.tieba.a.h.pb_head_function_manage_root);
        Button button = (Button) this.q.findViewById(com.baidu.tieba.a.h.pb_head_function_manage_commit_top);
        Button button2 = (Button) this.q.findViewById(com.baidu.tieba.a.h.pb_head_function_manage_cancel_top);
        Button button3 = (Button) this.q.findViewById(com.baidu.tieba.a.h.pb_head_function_manage_commit_good);
        Button button4 = (Button) this.q.findViewById(com.baidu.tieba.a.h.pb_head_function_manage_cancel_good);
        button.setOnClickListener(this.W);
        button2.setOnClickListener(this.W);
        button3.setOnClickListener(this.W);
        button4.setOnClickListener(this.W);
        if (!z2) {
            relativeLayout.setVisibility(8);
            button.setVisibility(8);
            button2.setVisibility(8);
            button3.setVisibility(8);
            button4.setVisibility(8);
        }
        if (aeVar.l() == 1) {
            if (relativeLayout != null) {
                relativeLayout.setVisibility(0);
                z3 = true;
            } else {
                z3 = false;
            }
            if (aeVar.d().r() == 1) {
                button3.setVisibility(8);
                button4.setVisibility(0);
            } else {
                button3.setVisibility(0);
                button4.setVisibility(8);
            }
            if (aeVar.d().q() == 1) {
                button.setVisibility(8);
                button2.setVisibility(0);
                return z3;
            }
            button.setVisibility(0);
            button2.setVisibility(8);
            return z3;
        }
        return false;
    }

    @SuppressLint({"CutPasteId"})
    public final void a(com.baidu.tieba.data.ae aeVar, boolean z, boolean z2, int i) {
        boolean z3;
        boolean z4;
        boolean z5;
        String userId;
        if (aeVar != null) {
            boolean a2 = a(aeVar, z, false);
            RelativeLayout relativeLayout = (RelativeLayout) this.q.findViewById(com.baidu.tieba.a.h.pb_head_function_manage_root);
            Button button = (Button) this.q.findViewById(com.baidu.tieba.a.h.pb_head_function_manage_delormanage);
            button.setOnClickListener(this.W);
            com.baidu.tieba.data.ai a3 = a(aeVar, z);
            if (a3 != null) {
                if (aeVar.l() != 0 && a3.g() != null) {
                    String userId2 = a3.g().getUserId();
                    boolean z6 = userId2 == null || !userId2.equals(TbadkApplication.E());
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
                    String userId3 = aeVar.d().t().getUserId();
                    if (userId3 != null && userId3.equals(TbadkApplication.E())) {
                        z3 = false;
                        z4 = true;
                        z5 = false;
                    } else if (a3.g() == null || (userId = a3.g().getUserId()) == null || !userId.equals(TbadkApplication.E())) {
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
                    relativeLayout.setVisibility(0);
                    button.setVisibility(0);
                    button.setText(com.baidu.tieba.a.k.manage);
                    SparseArray sparseArray = new SparseArray();
                    if (a3.g() != null) {
                        sparseArray.put(com.baidu.tieba.a.h.tag_forbid_user_name, a3.g().getUserName());
                    }
                    sparseArray.put(com.baidu.tieba.a.h.tag_del_post_id, a3.d());
                    sparseArray.put(com.baidu.tieba.a.h.tag_del_post_type, 0);
                    sparseArray.put(com.baidu.tieba.a.h.tag_del_post_is_self, Boolean.valueOf(z3));
                    sparseArray.put(com.baidu.tieba.a.h.tag_manage_user_identity, Integer.valueOf(aeVar.l()));
                    sparseArray.put(com.baidu.tieba.a.h.tag_should_manage_visible, true);
                    button.setTag(sparseArray);
                } else if (z4) {
                    relativeLayout.setVisibility(0);
                    button.setVisibility(0);
                    button.setText(com.baidu.tieba.a.k.delete);
                    SparseArray sparseArray2 = new SparseArray();
                    sparseArray2.put(com.baidu.tieba.a.h.tag_del_post_id, a3.d());
                    sparseArray2.put(com.baidu.tieba.a.h.tag_del_post_type, 0);
                    sparseArray2.put(com.baidu.tieba.a.h.tag_del_post_is_self, Boolean.valueOf(z3));
                    sparseArray2.put(com.baidu.tieba.a.h.tag_manage_user_identity, Integer.valueOf(aeVar.l()));
                    sparseArray2.put(com.baidu.tieba.a.h.tag_should_manage_visible, false);
                    button.setTag(sparseArray2);
                } else {
                    if (a2) {
                        relativeLayout.setVisibility(0);
                    } else {
                        relativeLayout.setVisibility(8);
                    }
                    button.setVisibility(8);
                }
            }
            ai();
        }
    }

    public final View Q() {
        return this.S;
    }

    public final BdListView R() {
        return this.o;
    }

    public static int S() {
        return com.baidu.tieba.a.h.richText;
    }

    public static int T() {
        return com.baidu.tieba.a.h.user_icon_box;
    }

    public final Button U() {
        return (Button) this.q.findViewById(com.baidu.tieba.a.h.pb_head_function_manage_commit_good);
    }

    public final Button V() {
        return (Button) this.q.findViewById(com.baidu.tieba.a.h.pb_head_function_manage_cancel_good);
    }

    public final Button W() {
        return (Button) this.q.findViewById(com.baidu.tieba.a.h.pb_head_function_manage_commit_top);
    }

    public final Button X() {
        return (Button) this.q.findViewById(com.baidu.tieba.a.h.pb_head_function_manage_cancel_top);
    }

    public final View Y() {
        if (this.N == null) {
            return null;
        }
        return this.N.t();
    }

    public final void a(com.baidu.adp.widget.ListView.t tVar) {
        this.o.setOnSrollToBottomListener(tVar);
    }

    public final void a(com.baidu.adp.widget.ListView.v vVar) {
        this.o.setOnSrollToTopListener(vVar);
    }

    public final void a(DialogInterface.OnClickListener onClickListener) {
        this.V = onClickListener;
    }

    public final void a(com.baidu.adp.widget.ListView.d dVar) {
        this.Q.a(dVar);
    }

    public final void a(com.baidu.tbadk.core.data.l lVar) {
        if (lVar != null) {
            int d = lVar.d();
            int a2 = lVar.a();
            if (this.L == null) {
                this.L = new Dialog(this.m, com.baidu.tieba.a.l.common_alert_dialog);
                this.L.setCanceledOnTouchOutside(true);
                this.L.setCancelable(true);
                this.O = this.m.getLayoutInflater().inflate(com.baidu.tieba.a.i.dialog_direct_pager, (ViewGroup) null);
                this.L.setContentView(this.O);
                WindowManager.LayoutParams attributes = this.L.getWindow().getAttributes();
                attributes.gravity = 49;
                attributes.y = com.baidu.adp.lib.util.i.a((Context) this.m, 54.0f);
                attributes.width = (int) (com.baidu.adp.lib.util.i.b(this.m) * 0.9d);
                this.L.getWindow().setAttributes(attributes);
                this.L.setOnKeyListener(new cj(this));
            }
            this.L.show();
            ((Button) this.O.findViewById(com.baidu.tieba.a.h.dialog_button_ok)).setOnClickListener(this.W);
            ((Button) this.O.findViewById(com.baidu.tieba.a.h.dialog_button_cancel)).setOnClickListener(this.W);
            this.P = (EditText) this.O.findViewById(com.baidu.tieba.a.h.input_page_number);
            this.P.setText("");
            this.P.setOnFocusChangeListener(new cm(this));
            TextView textView = (TextView) this.O.findViewById(com.baidu.tieba.a.h.current_page_number);
            if (d <= 0) {
                d = 1;
            }
            textView.setText(MessageFormat.format(this.m.getApplicationContext().getResources().getString(com.baidu.tieba.a.k.current_page), Integer.valueOf(d), Integer.valueOf(a2 <= 0 ? 1 : a2)));
            this.m.ShowSoftKeyPadDelay(this.P, 150);
        }
    }

    public final void a(AbsListView.OnScrollListener onScrollListener) {
        this.o.setOnScrollListener(onScrollListener);
    }

    public final void b(AbsListView.OnScrollListener onScrollListener) {
        this.aa = onScrollListener;
    }

    public final void a(View.OnClickListener onClickListener) {
        this.X = onClickListener;
        this.I.b(onClickListener);
    }

    public final void b(View.OnClickListener onClickListener) {
        this.Y = onClickListener;
        this.I.c(onClickListener);
    }

    public final void c(View.OnClickListener onClickListener) {
        this.Z = onClickListener;
        this.I.d(onClickListener);
    }

    public final void b(String str) {
        this.m.showToast(str);
    }

    public final boolean f(boolean z) {
        if (this.N == null || !this.N.a()) {
            if (!z) {
                if (D()) {
                    E();
                    return true;
                } else if (this.j.h()) {
                    this.j.g();
                    return true;
                }
            } else if (D()) {
                E();
                return true;
            }
            return false;
        }
        return true;
    }

    public final void a(bd bdVar) {
        if (bdVar != null) {
            this.bb.remove(bdVar);
        }
    }

    public final void Z() {
        if (this.bb != null) {
            while (this.bb.size() > 0) {
                bd remove = this.bb.remove(0);
                if (remove != null) {
                    remove.a(false);
                }
            }
        }
    }

    public final void aa() {
        this.m.hideProgressBar();
        if (this.p != null && this.ad != null) {
            this.p.b(this.ad);
        }
        ab();
        this.R.e();
        try {
            this.I.a().c();
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "stopLoadImage", "error = " + e.getMessage());
        }
    }

    public final void ab() {
        if (this.J != null) {
            this.J.dismiss();
        }
        com.baidu.adp.lib.util.i.a(this.m, this.P);
        this.j.e();
        if (this.L != null) {
            this.L.dismiss();
        }
        if (this.aD != null) {
            this.aD.dismiss();
        }
        if (this.N != null) {
            this.N.o();
        }
        ac();
    }

    public final void g(boolean z) {
        this.I.b(z);
        if (this.N != null) {
            this.N.c(z);
        }
    }

    public final void h(boolean z) {
        this.bc = z;
        this.I.c(z);
        if (this.N != null) {
            this.N.b(z);
        }
    }

    public final void ac() {
        if (this.ag != null) {
            this.ag.dismiss();
        }
        if (this.al != null) {
            this.al.dismiss();
        }
        if (this.av != null) {
            this.av.dismiss();
        }
        if (this.ae != null) {
            this.ae.dismiss();
        }
    }

    public final void ad() {
        if (this.N != null) {
            this.N.u();
        }
    }

    public final com.baidu.adp.widget.ImageView.b a(View view, String str) {
        bd bdVar;
        com.baidu.adp.widget.ImageView.b a2 = this.I.a().a(str, this.bg, true, true);
        if (a2 == null && view != null && (view instanceof bd) && (bdVar = (bd) view) != null) {
            if (UtilHelper.a()) {
                bdVar.e();
                if (this.bb != null) {
                    this.bb.add(bdVar);
                }
            } else {
                com.baidu.adp.lib.util.i.a((Context) this.m, com.baidu.tieba.a.k.neterror);
            }
        }
        return a2;
    }

    public final void ae() {
        this.m.n();
        com.baidu.tbadk.core.util.ac.a(this.o, this.I.a(), this.bf, this.bd, null, this.be, this.I.c() ? 0 : 1, 0);
    }

    public final void a(int i) {
        this.m.getLayoutMode().a(i == 1);
        this.m.getLayoutMode().a(this.n);
        this.m.getLayoutMode().a(this.q);
        this.m.getLayoutMode().a(this.S);
        this.J.a(this.m, i, this.m.getResources().getDrawable(com.baidu.tieba.a.g.bg_pull_down_right_n), this.m.getResources().getDrawable(com.baidu.tieba.a.g.bg_pull_down_right_n_1));
        this.b.b(i);
        this.m.getLayoutMode().a(i == 1);
        this.m.getLayoutMode().a(this.n);
        e(this.aE);
        this.I.notifyDataSetChanged();
        this.j.c(i);
        if (this.N != null) {
            this.N.a(i);
            this.m.getLayoutMode().a(this.R.b());
        }
        if (this.Q != null) {
            this.Q.a(i);
        }
        if (this.R != null) {
            this.R.c(i);
            this.S.setBackgroundResource(i == 1 ? com.baidu.tieba.a.g.pb_foot_more_trans_selector_1 : com.baidu.tieba.a.g.pb_foot_more_trans_selector);
            this.R.a(i == 1 ? com.baidu.tieba.a.g.pb_foot_more_trans_selector_1 : com.baidu.tieba.a.g.pb_foot_more_trans_selector);
        }
        if (this.aU != null) {
            this.aU.c(i);
            this.aU.a(i == 1 ? com.baidu.tieba.a.e.cp_bg_line_e_1 : com.baidu.tieba.a.e.cp_bg_line_e);
            this.aT.setBackgroundResource(i == 1 ? com.baidu.tieba.a.e.cp_bg_line_e_1 : com.baidu.tieba.a.e.cp_bg_line_e);
        }
        this.j.c(i);
        if (this.aG != null) {
            if (i == 1) {
                this.aG.setBackgroundResource(com.baidu.tieba.a.e.cp_bg_line_d_1);
            } else {
                this.aG.setBackgroundResource(com.baidu.tieba.a.e.cp_bg_line_d);
            }
        }
        if (this.i != null) {
            this.i.a(i);
        }
    }

    public final void a(com.baidu.tbadk.widget.richText.r rVar) {
        this.ab = rVar;
        this.I.a(this.ab);
        if (this.N != null) {
            this.N.a(this.ab);
        }
    }

    public final void a(com.baidu.tbadk.widget.richText.q qVar) {
        this.ac = qVar;
        this.I.a(this.ac);
        if (this.N != null) {
            this.N.a(this.ac);
        }
    }

    public final void a(com.baidu.tbadk.core.view.m mVar) {
        this.ad = mVar;
        if (this.p != null) {
            this.p.a(this.ad);
        }
    }

    public final void i(boolean z) {
        this.I.a().a(z);
    }

    public final View af() {
        if (this.N == null) {
            return null;
        }
        return this.N.B();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aj() {
        if (this.b != null) {
            this.b.setVisibility(8);
        }
        if (this.o != null) {
            this.o.setVisibility(8);
        }
        if (this.j != null) {
            this.aR = this.aL.getVisibility() == 0;
            this.j.setVisibility(8);
            this.aL.setVisibility(8);
            this.aK.setVisibility(8);
        }
    }

    public final Button ag() {
        return this.aI;
    }

    public final void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.j.c.a(writeImagesInfo, z);
    }

    public final void ah() {
        this.j.c.p();
    }

    public final void b(boolean z, boolean z2) {
        if (z) {
            this.h.setVisibility(0);
            this.h.setSelected(z2);
            return;
        }
        this.h.setVisibility(8);
    }

    public final void c(com.baidu.tieba.data.ae aeVar) {
        ArrayList<com.baidu.tieba.data.ai> e = aeVar.e();
        if (e.size() == 1) {
            com.baidu.tieba.data.ai aiVar = e.get(0);
            if (aiVar.n() < aiVar.c().size()) {
                this.o.setNextPage(null);
                return;
            } else {
                this.o.setNextPage(this.R);
                return;
            }
        }
        this.o.setNextPage(this.R);
    }
}
