package com.baidu.tieba.pb.main;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Rect;
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
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.coreExtra.view.LiveBroadcastCard;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.editortool.PbEditor;
import com.baidu.tieba.frs.view.FrsPraiseView;
import com.baidu.tieba.view.PbListView;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class bt {
    public static int a = 80;
    private View A;
    private View B;
    private View C;
    private View D;
    private View E;
    private RelativeLayout F;
    private bc G;
    private com.baidu.tbadk.core.view.i H;
    private bp I;
    private com.baidu.tieba.view.aa O;
    private PbListView P;
    private View Q;
    private View.OnClickListener U;
    private View aE;
    private com.baidu.tbadk.editortool.w aH;
    private View aI;
    private View aJ;
    private LinearLayout aK;
    private TextView aL;
    private LinearLayout aM;
    private ImageView aN;
    private TextView aO;
    private View aU;
    private LiveBroadcastCard aV;
    private ba aZ;
    private View.OnClickListener ad;
    NavigationBar b;
    TextView c;
    ImageView d;
    ImageView e;
    ImageView f;
    public FrsPraiseView g;
    public PbEditor h;
    public View i;
    bb j;
    private PbActivity k;
    private FrameLayout l;
    private BdListView m;
    private NoNetworkView n;
    private View o;
    private View p;
    private ColumnLayout q;
    private TextView r;
    private TextView s;
    private HeadImageView t;
    private TextView u;
    private UserIconBox v;
    private UserIconBox w;
    private ImageView x;
    private TextView y;
    private TextView z;
    private Dialog J = null;
    private Dialog K = null;
    private com.baidu.tieba.pb.sub.m L = null;
    private View M = null;
    private EditText N = null;
    private FrameLayout R = null;
    private View S = null;
    private DialogInterface.OnClickListener T = null;
    private View.OnClickListener V = null;
    private View.OnClickListener W = null;
    private View.OnClickListener X = null;
    private AbsListView.OnScrollListener Y = null;
    private com.baidu.tbadk.widget.richText.s Z = null;
    private com.baidu.tbadk.widget.richText.r aa = null;
    private com.baidu.tbadk.core.view.m ab = null;
    private Dialog ac = null;
    private Dialog ae = null;
    private View af = null;
    private Button ag = null;
    private Button ah = null;
    private TextView ai = null;
    private Dialog aj = null;
    private View ak = null;
    private int al = 0;
    private RadioGroup am = null;
    private RadioButton an = null;
    private RadioButton ao = null;
    private RadioButton ap = null;
    private Button aq = null;
    private Button ar = null;
    private TextView as = null;
    private Dialog at = null;
    private View au = null;
    private RadioGroup av = null;
    private CompoundButton.OnCheckedChangeListener aw = null;
    private Button ax = null;
    private Button ay = null;
    private String az = null;
    private cv aA = null;
    private Dialog aB = null;
    private boolean aC = false;
    private ScrollView aF = null;
    private Button aG = null;
    private boolean aP = true;
    private LinearLayout aQ = null;
    private View aR = null;
    private PbListView aS = null;
    private boolean aT = false;
    private boolean aW = true;
    private com.baidu.tieba.bubble.t aX = new bu(this);
    private final View.OnClickListener aY = new cd(this);
    private View.OnLongClickListener ba = null;
    private boolean bb = false;
    private final List<TbImageView> bc = new ArrayList();
    private boolean bd = true;
    private com.baidu.tieba.c.a aD = new com.baidu.tieba.c.a(new co(this));

    public NoNetworkView a() {
        return this.n;
    }

    public void b() {
        this.aP = true;
        if (this.h != null) {
            this.h.setVisibility(8);
        }
        if (this.aJ != null) {
            this.aJ.setVisibility(0);
            this.aI.setVisibility(0);
        }
    }

    public com.baidu.tieba.data.am c() {
        int i;
        View childAt;
        if (this.m == null) {
            return null;
        }
        int firstVisiblePosition = this.m.getFirstVisiblePosition();
        int lastVisiblePosition = this.m.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.m.getChildCount();
            int i2 = 0;
            for (int i3 = firstVisiblePosition; i3 <= lastVisiblePosition; i3++) {
                if (i3 - firstVisiblePosition < childCount && (childAt = this.m.getChildAt(i3 - firstVisiblePosition)) != null) {
                    childAt.getGlobalVisibleRect(rect);
                    iArr[i3 - firstVisiblePosition] = rect.height();
                }
                i2 += iArr[i3 - firstVisiblePosition];
            }
            int i4 = i2 / 2;
            int i5 = 0;
            for (int i6 = 0; i6 < iArr.length; i6++) {
                i5 += iArr[i6];
                if (i5 > i4) {
                    i = i6 + firstVisiblePosition;
                    break;
                }
            }
        }
        i = firstVisiblePosition;
        int headerViewsCount = i - this.m.getHeaderViewsCount();
        int i7 = headerViewsCount >= 0 ? headerViewsCount : 0;
        if (this.G.getItemViewType(i7) != 0) {
            i7++;
        }
        return (com.baidu.tieba.data.am) this.G.getItem(i7);
    }

    public bt(PbActivity pbActivity, View.OnClickListener onClickListener) {
        this.k = null;
        this.l = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.m = null;
        this.o = null;
        this.p = null;
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
        this.g = null;
        this.A = null;
        this.B = null;
        this.C = null;
        this.D = null;
        this.E = null;
        this.G = null;
        this.H = null;
        this.I = null;
        this.O = null;
        this.P = null;
        this.Q = null;
        this.U = null;
        this.ad = null;
        this.aE = null;
        this.aI = null;
        this.aJ = null;
        this.aK = null;
        this.aL = null;
        this.aM = null;
        this.aN = null;
        this.aO = null;
        this.k = pbActivity;
        this.U = onClickListener;
        LayoutInflater from = LayoutInflater.from(this.k);
        this.l = (FrameLayout) from.inflate(com.baidu.tieba.w.new_pb_activity, (ViewGroup) null);
        this.k.addContentView(this.l, new FrameLayout.LayoutParams(-1, -1));
        this.F = (RelativeLayout) this.k.findViewById(com.baidu.tieba.v.title_wrapper);
        this.n = (NoNetworkView) this.k.findViewById(com.baidu.tieba.v.view_no_network);
        this.m = (BdListView) this.k.findViewById(com.baidu.tieba.v.new_pb_list);
        this.aE = new View(this.k);
        this.aE.setBackgroundResource(com.baidu.tieba.s.cp_bg_line_d);
        this.aE.setLayoutParams(new AbsListView.LayoutParams(-1, this.k.getResources().getDimensionPixelSize(com.baidu.tieba.t.navi_height)));
        this.m.addHeaderView(this.aE);
        View view = new View(this.k);
        view.setLayoutParams(new AbsListView.LayoutParams(-1, this.k.getResources().getDimensionPixelSize(com.baidu.tieba.t.pb_editor_height)));
        this.m.addFooterView(view);
        this.b = (NavigationBar) this.k.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.b.setOnClickListener(new cp(this));
        this.i = this.b.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.U);
        this.c = (TextView) this.b.a(NavigationBar.ControlAlign.HORIZONTAL_CENTER, com.baidu.tieba.w.pb_title_textview, (View.OnClickListener) null);
        this.f = (ImageView) this.b.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.widget_nb_add_floor, this.U);
        this.d = (ImageView) this.b.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.nb_item_floor_host, this.U);
        this.e = (ImageView) this.b.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.nb_item_floor_more, this.U);
        this.I = new bp(this.k, this.U);
        this.H = new com.baidu.tbadk.core.view.i(this.k, this.I.a(), this.b, this.k.getResources().getDrawable(com.baidu.tieba.u.bg_pull_down_right_n), new cq(this));
        this.h = (PbEditor) this.k.findViewById(com.baidu.tieba.v.pb_editor_view);
        this.h.setFrom(1);
        this.h.a(false);
        this.h.setVisibility(8);
        this.aJ = this.k.findViewById(com.baidu.tieba.v.pb_editor_tool_comment);
        this.aK = (LinearLayout) this.k.findViewById(com.baidu.tieba.v.pb_editor_tool_comment_reply);
        this.aM = (LinearLayout) this.k.findViewById(com.baidu.tieba.v.pb_editor_tool_comment_praise);
        this.aI = this.k.findViewById(com.baidu.tieba.v.pb_editor_tool_comment_line);
        this.aL = (TextView) this.k.findViewById(com.baidu.tieba.v.pb_editor_tool_comment_reply_text);
        this.aN = (ImageView) this.k.findViewById(com.baidu.tieba.v.pb_editor_tool_comment_praise_icon);
        this.aO = (TextView) this.k.findViewById(com.baidu.tieba.v.pb_editor_tool_comment_praise_text);
        this.aK.setOnClickListener(new cr(this));
        this.aM.setOnClickListener(this.U);
        this.aM.setOnTouchListener(this.k);
        J();
        this.o = from.inflate(com.baidu.tieba.w.new_pb_header_item, (ViewGroup) null);
        this.q = (ColumnLayout) this.o.findViewById(com.baidu.tieba.v.pb_head_owner_root);
        this.q.setOnLongClickListener(this.ba);
        this.q.setOnTouchListener(this.aD);
        this.q.setVisibility(8);
        this.o.setOnTouchListener(this.aD);
        this.r = (TextView) this.o.findViewById(com.baidu.tieba.v.pb_head_post_title);
        this.r.setTextSize(TbConfig.getContentSizeOfPostTitle());
        this.r.setVisibility(8);
        this.s = (TextView) this.q.findViewById(com.baidu.tieba.v.pb_head_owner_info_user_name);
        this.t = (HeadImageView) this.q.findViewById(com.baidu.tieba.v.pb_head_owner_photo);
        if (!this.bd) {
            this.t.setVisibility(8);
        }
        this.u = (TextView) this.q.findViewById(com.baidu.tieba.v.pb_head_owner_info_user_rank);
        this.v = (UserIconBox) this.q.findViewById(com.baidu.tieba.v.pb_head_owner_info_user_icon);
        this.w = (UserIconBox) this.q.findViewById(com.baidu.tieba.v.pb_head_owner_info_tshow_icon);
        this.x = (ImageView) this.q.findViewById(com.baidu.tieba.v.pb_head_owner_info_floor_owner);
        this.y = (TextView) this.q.findViewById(com.baidu.tieba.v.pb_head_owner_info_time);
        this.z = (TextView) this.o.findViewById(com.baidu.tieba.v.pb_head_reverse_hint);
        this.z.setOnClickListener(this.U);
        this.z.setVisibility(8);
        this.g = (FrsPraiseView) this.o.findViewById(com.baidu.tieba.v.pb_head_praise_view);
        this.g.setIsFromPb(true);
        this.p = this.o.findViewById(com.baidu.tieba.v.pb_head_function_manage_root);
        this.A = this.o.findViewById(com.baidu.tieba.v.new_pb_header_item_line_above_manage);
        this.B = this.o.findViewById(com.baidu.tieba.v.new_pb_header_item_line_above_livepost);
        this.C = this.o.findViewById(com.baidu.tieba.v.new_pb_header_item_line_below_livepost);
        this.D = this.o.findViewById(com.baidu.tieba.v.new_pb_header_item_line_above_praise);
        this.E = this.o.findViewById(com.baidu.tieba.v.new_pb_header_item_line_above_showpassed);
        this.aU = this.o.findViewById(com.baidu.tieba.v.live_card_layout);
        this.aV = (LiveBroadcastCard) this.o.findViewById(com.baidu.tieba.v.item_card);
        this.o.setOnLongClickListener(new cs(this));
        aj();
        this.G = new bc(this.k);
        this.G.e(this.U);
        this.G.a(this.aD);
        this.G.a(this.Z);
        this.ad = new ct(this);
        this.G.a(this.ad);
        this.m.setAdapter((ListAdapter) this.G);
        this.m.addHeaderView(this.o);
        this.O = new com.baidu.tieba.view.aa(this.k);
        this.O.a();
        this.P = new PbListView(this.k);
        this.Q = this.P.b().findViewById(com.baidu.tieba.v.pb_more_view);
        if (this.Q != null) {
            this.Q.setOnClickListener(this.U);
        }
        int skinType = TbadkApplication.m252getInst().getSkinType();
        this.Q.setBackgroundResource(skinType == 1 ? com.baidu.tieba.u.pb_foot_more_trans_selector_1 : com.baidu.tieba.u.pb_foot_more_trans_selector);
        this.P.c();
        this.P.a(skinType == 1 ? com.baidu.tieba.u.pb_foot_more_trans_selector_1 : com.baidu.tieba.u.pb_foot_more_trans_selector);
        this.P.c(com.baidu.tieba.u.pb_foot_more_trans_selector);
        this.c.setOnClickListener(this.U);
    }

    public void a(String str) {
        if (this.aL != null) {
            if (!"0".equals(str)) {
                this.aL.setText(str);
            } else {
                this.aL.setText(this.k.getString(com.baidu.tieba.y.reply));
            }
        }
    }

    public void a(String str, boolean z) {
        if (this.aO != null) {
            this.aO.setText(str);
            int skinType = TbadkApplication.m252getInst().getSkinType();
            if (z) {
                if (skinType == 1) {
                    this.aN.setImageResource(com.baidu.tieba.u.icon_hand_click_1);
                } else {
                    this.aN.setImageResource(com.baidu.tieba.u.icon_hand_click);
                }
            } else if (skinType == 1) {
                this.aN.setImageResource(com.baidu.tieba.u.icon_hand_normal_1);
            } else {
                this.aN.setImageResource(com.baidu.tieba.u.icon_hand_normal);
            }
        }
    }

    public View d() {
        return this.aM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(boolean z) {
        if (this.m != null) {
            if (!z) {
                this.m.setEnabled(z);
            } else {
                this.m.postDelayed(new cu(this, z), 10L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view) {
        boolean z;
        boolean z2 = false;
        if (this.F != null && this.h != null && view != null) {
            if (this.aP) {
                z = this.aJ.getVisibility() == 0;
            } else {
                z = this.h.getVisibility() == 0;
            }
            if (this.F.getVisibility() == 0 || z) {
                z2 = true;
            }
            if (z2) {
                Animation loadAnimation = AnimationUtils.loadAnimation(view.getContext(), com.baidu.tieba.p.top_fold_up);
                loadAnimation.setAnimationListener(new bv(this));
                this.F.startAnimation(loadAnimation);
                this.h.f();
                Animation loadAnimation2 = AnimationUtils.loadAnimation(view.getContext(), com.baidu.tieba.p.bottom_fold_down);
                loadAnimation2.setAnimationListener(new bw(this));
                if (this.aP) {
                    this.aJ.startAnimation(loadAnimation2);
                    return;
                } else {
                    this.h.startAnimation(loadAnimation2);
                    return;
                }
            }
            Animation loadAnimation3 = AnimationUtils.loadAnimation(view.getContext(), com.baidu.tieba.p.top_fold_down);
            loadAnimation3.setAnimationListener(new bx(this));
            this.F.startAnimation(loadAnimation3);
            Animation loadAnimation4 = AnimationUtils.loadAnimation(view.getContext(), com.baidu.tieba.p.bottom_fold_up);
            loadAnimation4.setAnimationListener(new by(this));
            if (this.aP) {
                this.aJ.startAnimation(loadAnimation4);
            } else {
                this.h.startAnimation(loadAnimation4);
            }
        }
    }

    public VoiceData.VoiceModel e() {
        return this.h.getAudioData();
    }

    public void f() {
        this.h.s();
    }

    public void g() {
        if (this.L != null) {
            this.L.l();
        }
    }

    public bp h() {
        return this.I;
    }

    public void i() {
        if (this.L != null) {
            this.L.m();
        }
    }

    public VoiceData.VoiceModel j() {
        if (this.L != null) {
            return this.L.o();
        }
        return null;
    }

    public void k() {
        if (this.L != null) {
            this.L.p();
        }
    }

    public TextView l() {
        if (this.L == null || !(this.L instanceof com.baidu.tieba.pb.sub.j)) {
            return null;
        }
        return ((com.baidu.tieba.pb.sub.j) this.L).c();
    }

    public bc m() {
        return this.G;
    }

    public void a(bb bbVar) {
        this.j = bbVar;
    }

    public void n() {
        if (this.k.getCurrentFocus() != null) {
            com.baidu.adp.lib.util.j.a(this.k, this.k.getCurrentFocus());
        }
    }

    private void a(com.baidu.tbadk.core.data.o oVar) {
        if (oVar != null && oVar.a() != 0) {
            int b = oVar.b();
            String string = this.k.getString(com.baidu.tieba.y.go_to_live_post_prefix);
            if (b == 0) {
                string = String.valueOf(string) + this.k.getString(com.baidu.tieba.y.go_to_interview_post);
            } else if (b == 1) {
                string = String.valueOf(string) + this.k.getString(com.baidu.tieba.y.go_to_discuss_post);
            }
            this.aG.setText(string);
            this.aG.setVisibility(0);
            this.aG.setOnClickListener(this.U);
            ak();
        }
    }

    private void aj() {
        this.aQ = (LinearLayout) this.o.findViewById(com.baidu.tieba.v.btn_show_passed_pb);
        this.aS = new PbListView(this.k, PbListView.IconType.ICON_UP_WARD);
        this.aR = this.aS.a();
        this.aS.a(this.k.getResources().getString(com.baidu.tieba.y.btn_show_passed_pb));
        this.aR.setOnClickListener(this.aY);
        this.aQ.addView(this.aR);
        this.aQ.requestLayout();
        this.aQ.invalidate();
        int skinType = TbadkApplication.m252getInst().getSkinType();
        this.aR.setBackgroundResource(skinType == 1 ? com.baidu.tieba.s.cp_bg_line_e_1 : com.baidu.tieba.s.cp_bg_line_e);
        this.aS.a(skinType == 1 ? com.baidu.tieba.s.cp_bg_line_e_1 : com.baidu.tieba.s.cp_bg_line_e);
        this.aS.c(com.baidu.tieba.s.cp_bg_line_e);
        ak();
    }

    public void a(View view) {
        if (this.ac == null) {
            this.ac = new Dialog(this.k, com.baidu.tieba.z.common_alert_dialog);
            this.ac.setCanceledOnTouchOutside(true);
            this.ac.setCancelable(true);
            this.ac.setContentView(this.k.getLayoutInflater().inflate(com.baidu.tieba.w.forum_manage_dialog, (ViewGroup) null));
            WindowManager.LayoutParams attributes = this.ac.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.j.b(this.k) * 0.9d);
            this.ac.getWindow().setAttributes(attributes);
        }
        Button button = (Button) this.ac.findViewById(com.baidu.tieba.v.del_post_btn);
        Button button2 = (Button) this.ac.findViewById(com.baidu.tieba.v.forbid_user_btn);
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            if ("".equals(sparseArray.get(com.baidu.tieba.v.tag_del_post_id))) {
                button.setVisibility(8);
            } else {
                SparseArray sparseArray2 = (SparseArray) button.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    button.setTag(sparseArray2);
                }
                button.setVisibility(0);
                sparseArray2.put(com.baidu.tieba.v.tag_del_post_id, sparseArray.get(com.baidu.tieba.v.tag_del_post_id));
                sparseArray2.put(com.baidu.tieba.v.tag_del_post_type, sparseArray.get(com.baidu.tieba.v.tag_del_post_type));
                sparseArray2.put(com.baidu.tieba.v.tag_del_post_is_self, sparseArray.get(com.baidu.tieba.v.tag_del_post_is_self));
                sparseArray2.put(com.baidu.tieba.v.tag_manage_user_identity, sparseArray.get(com.baidu.tieba.v.tag_manage_user_identity));
                button.setOnClickListener(new bz(this));
            }
            if ("".equals(sparseArray.get(com.baidu.tieba.v.tag_forbid_user_name))) {
                button2.setVisibility(8);
            } else {
                SparseArray sparseArray3 = (SparseArray) button2.getTag();
                if (sparseArray3 == null) {
                    sparseArray3 = new SparseArray();
                    button2.setTag(sparseArray3);
                }
                button2.setVisibility(0);
                sparseArray3.put(com.baidu.tieba.v.tag_forbid_user_name, sparseArray.get(com.baidu.tieba.v.tag_forbid_user_name));
                sparseArray3.put(com.baidu.tieba.v.tag_manage_user_identity, sparseArray.get(com.baidu.tieba.v.tag_manage_user_identity));
                button2.setOnClickListener(new ca(this));
            }
            this.ac.show();
        }
    }

    public void a(ba baVar) {
        this.aZ = baVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        if (this.ae == null) {
            this.ae = new Dialog(this.k, com.baidu.tieba.z.common_alert_dialog);
            this.ae.setCanceledOnTouchOutside(true);
            this.ae.setCancelable(true);
            this.af = this.k.getLayoutInflater().inflate(com.baidu.tieba.w.del_post, (ViewGroup) null);
            this.ae.setContentView(this.af);
            WindowManager.LayoutParams attributes = this.ae.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.j.b(this.k) * 0.9d);
            this.ae.getWindow().setAttributes(attributes);
            this.ag = (Button) this.af.findViewById(com.baidu.tieba.v.dialog_button_ok);
            this.ag.setOnClickListener(this.U);
            this.ah = (Button) this.af.findViewById(com.baidu.tieba.v.dialog_button_cancel);
            this.ah.setOnClickListener(new cb(this));
            this.ai = (TextView) this.af.findViewById(com.baidu.tieba.v.confirm_text);
        }
        SparseArray sparseArray = (SparseArray) this.ag.getTag();
        if (sparseArray == null) {
            sparseArray = new SparseArray();
            this.ag.setTag(sparseArray);
        }
        sparseArray.put(com.baidu.tieba.v.tag_del_post_id, str);
        sparseArray.put(com.baidu.tieba.v.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(com.baidu.tieba.v.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(com.baidu.tieba.v.tag_del_post_is_self, Boolean.valueOf(z));
        if (i == 0) {
            this.ai.setText(com.baidu.tieba.y.del_thread_confirm);
        } else {
            this.ai.setText(com.baidu.tieba.y.del_post_confirm);
        }
        this.ae.show();
    }

    public void a(ArrayList<com.baidu.tbadk.core.data.g> arrayList) {
        if (this.at == null) {
            this.at = new Dialog(this.k, com.baidu.tieba.z.common_alert_dialog);
            this.at.setCanceledOnTouchOutside(true);
            this.at.setCancelable(true);
            this.au = this.k.getLayoutInflater().inflate(com.baidu.tieba.w.commit_good, (ViewGroup) null);
            this.aF = (ScrollView) this.au.findViewById(com.baidu.tieba.v.good_scroll);
            this.at.setContentView(this.au);
            WindowManager.LayoutParams attributes = this.at.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.j.b(this.k) * 0.9d);
            this.at.getWindow().setAttributes(attributes);
            this.aw = new cc(this);
            this.av = (RadioGroup) this.au.findViewById(com.baidu.tieba.v.good_class_group);
            this.ay = (Button) this.au.findViewById(com.baidu.tieba.v.dialog_button_cancel);
            this.ay.setOnClickListener(new ce(this));
            this.ax = (Button) this.au.findViewById(com.baidu.tieba.v.dialog_button_ok);
            this.ax.setOnClickListener(this.U);
        }
        this.av.removeAllViews();
        LayoutInflater layoutInflater = this.k.getLayoutInflater();
        RadioButton radioButton = (RadioButton) layoutInflater.inflate(com.baidu.tieba.w.good_class_radio_button, (ViewGroup) null);
        radioButton.setTag("0");
        radioButton.setText(this.k.getString(com.baidu.tieba.y.def_good_class));
        radioButton.setOnCheckedChangeListener(this.aw);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, -2);
        layoutParams.setMargins(com.baidu.adp.lib.util.j.a((Context) this.k, 10.0f), com.baidu.adp.lib.util.j.a((Context) this.k, 5.0f), com.baidu.adp.lib.util.j.a((Context) this.k, 10.0f), com.baidu.adp.lib.util.j.a((Context) this.k, 5.0f));
        this.av.addView(radioButton, layoutParams);
        this.av.requestLayout();
        this.av.check(radioButton.getId());
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                RadioButton radioButton2 = (RadioButton) layoutInflater.inflate(com.baidu.tieba.w.good_class_radio_button, (ViewGroup) null);
                radioButton2.setTag(String.valueOf(arrayList.get(i2).b()));
                radioButton2.setText(arrayList.get(i2).a());
                radioButton2.setOnCheckedChangeListener(this.aw);
                this.av.addView(radioButton2, layoutParams);
                this.av.requestLayout();
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.aF.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.j.a((Context) this.k, 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.j.a((Context) this.k, 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.j.a((Context) this.k, 220.0f);
                    break;
            }
            this.aF.setLayoutParams(layoutParams2);
            this.aF.removeAllViews();
            this.aF.addView(this.av);
        }
        this.at.show();
    }

    public void o() {
        this.k.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.k.hideProgressBar();
        if (z && z2) {
            this.k.showToast(this.k.getString(com.baidu.tieba.y.success));
        } else if (str != null && z2) {
            this.k.showToast(str);
        }
    }

    public void p() {
        this.l.removeView(this.R);
    }

    public View q() {
        if (this.af != null) {
            return this.af.findViewById(com.baidu.tieba.v.dialog_button_ok);
        }
        return null;
    }

    public View r() {
        if (this.au != null) {
            return this.au.findViewById(com.baidu.tieba.v.dialog_button_ok);
        }
        return null;
    }

    public String s() {
        return this.az;
    }

    public View t() {
        if (this.L != null) {
            return this.L.w();
        }
        return null;
    }

    public void u() {
        this.k.showProgressBar();
        com.baidu.adp.lib.util.j.a(this.k, this.h.getEditText());
    }

    public void v() {
        if (this.L != null) {
            this.L.z();
        } else {
            this.k.showProgressBar();
        }
    }

    public void a(boolean z) {
        if (this.L != null) {
            this.L.A();
        } else {
            this.k.hideProgressBar();
        }
        ad();
        if (z) {
            this.h.getEditText().setText("");
            this.h.b();
            this.h.m();
            if (this.L != null) {
                this.L.u();
            }
        }
    }

    public void w() {
        this.P.d();
    }

    public void x() {
        this.k.hideProgressBar();
        this.P.e();
        this.aS.e();
        this.m.d();
        ak();
    }

    public void y() {
        this.m.d();
        this.aQ.setVisibility(8);
        ak();
    }

    public void b(String str) {
        this.c.setVisibility(0);
        this.c.setText(String.valueOf(str) + this.k.getString(com.baidu.tieba.y.bar));
    }

    public void b(boolean z) {
        if (!z) {
            this.h.d();
        } else if (this.L != null) {
            this.L.b((String) null);
        }
    }

    public void z() {
        if (!this.h.h()) {
            b(false);
        }
    }

    public void A() {
        if (E() && this.L != null) {
            this.L.j();
        }
    }

    public void B() {
        if (this.L == null) {
            this.L = new com.baidu.tieba.pb.sub.m(this.k, this.bb, this.U, this.ad, this.V, this.W, this.X);
            this.L.a(this.aH);
            this.L.a(this.Y);
            this.L.c(this.G.b());
            this.L.b(this.G.c());
            this.S = this.L.n();
            this.L.a(this.Z);
            this.L.a(this.aa);
            this.L.a(this.G.a());
        }
        this.S.setVisibility(0);
        this.L.d(this.aW);
        this.L.y();
        this.l.addView(this.S);
        al();
    }

    public void a(com.baidu.tbadk.editortool.w wVar) {
        if (wVar != null) {
            this.h.setOnActionListener(new cf(this, wVar));
            this.aH = wVar;
            if (this.L != null) {
                this.L.a(wVar);
            }
        }
    }

    public void a(cv cvVar) {
        this.aA = cvVar;
    }

    public void a(boolean z, com.baidu.tieba.data.at atVar, boolean z2, String str, String str2, View view, int i) {
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap bitmap3;
        if (atVar != null && view != null) {
            TiebaStatic.eventStat(this.k, "pb_tosubpb", "pbclick", 1, new Object[0]);
            if (this.L == null) {
                this.L = new com.baidu.tieba.pb.sub.m(this.k, this.bb, this.U, this.ad, this.V, this.W, this.X);
                this.L.a(this.aH);
                this.L.a(this.Y);
                this.L.c(this.G.b());
                this.L.b(this.G.c());
                this.S = this.L.n();
                this.L.a(this.Z);
                this.L.a(this.aa);
                this.L.a(this.G.a());
            }
            this.L.b(this.G.d());
            this.L.a(atVar, i);
            this.L.d(this.aW);
            if (str2 != null && !str2.equals("")) {
                this.L.c(str2);
            } else {
                this.L.c(1);
            }
            int i2 = 0;
            if (this.F.getVisibility() == 0) {
                i2 = this.F.getHeight();
            }
            int top = view.getTop();
            int bottom = view.getBottom();
            if (!z) {
                this.L.q();
            }
            int height = ((view.getHeight() + this.k.getResources().getDimensionPixelSize(com.baidu.tieba.t.subpb_listitem_packup_min_height)) - this.k.getResources().getDimensionPixelSize(com.baidu.tieba.t.pb_list_item_border_bottom_margin_top)) - this.l.getHeight();
            if (height > 0) {
                top += height;
            }
            AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator(1.5f);
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, top, 0.0f);
            translateAnimation.setDuration(300L);
            this.S.setAnimation(translateAnimation);
            try {
                this.l.invalidate();
                this.l.buildDrawingCache();
                bitmap = this.l.getDrawingCache();
            } catch (Throwable th) {
                BdLog.detailException(th);
                bitmap = null;
            }
            Bitmap bitmap4 = null;
            if (bitmap == null) {
                bitmap2 = null;
                bitmap3 = null;
            } else {
                if (bottom > 0 && bottom < bitmap.getHeight()) {
                    try {
                        bitmap4 = Bitmap.createBitmap(bitmap, 0, bottom, bitmap.getWidth(), bitmap.getHeight() - bottom);
                    } catch (Throwable th2) {
                        bitmap4 = null;
                    }
                }
                if (top < i2) {
                    top = i2;
                }
                if (top <= 0 || top >= bitmap.getHeight()) {
                    bitmap2 = null;
                    bitmap3 = bitmap4;
                } else {
                    try {
                        bitmap2 = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), top);
                        bitmap3 = bitmap4;
                    } catch (Throwable th3) {
                        bitmap2 = null;
                        bitmap3 = bitmap4;
                    }
                }
            }
            this.S.setVisibility(0);
            if (this.S.getParent() == this.l) {
                this.l.removeView(this.S);
            }
            this.l.addView(this.S);
            if (bitmap2 != null) {
                ImageView imageView = new ImageView(this.k);
                imageView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 48));
                imageView.setImageBitmap(bitmap2);
                this.l.addView(imageView);
                TranslateAnimation translateAnimation2 = new TranslateAnimation(0.0f, 0.0f, 0.0f, -top);
                translateAnimation2.setDuration(300L);
                imageView.setAnimation(translateAnimation2);
                translateAnimation2.setAnimationListener(new cg(this, imageView));
                translateAnimation2.setInterpolator(accelerateInterpolator);
                translateAnimation2.start();
            }
            ImageView imageView2 = new ImageView(this.k);
            imageView2.setImageBitmap(bitmap3);
            imageView2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 80));
            this.l.addView(imageView2);
            TranslateAnimation translateAnimation3 = new TranslateAnimation(0.0f, 0.0f, 0.0f, bitmap3 == null ? 0 : bitmap3.getHeight());
            translateAnimation3.setDuration(300L);
            imageView2.setAnimation(translateAnimation3);
            translateAnimation3.setAnimationListener(new ci(this, imageView2));
            translateAnimation.setAnimationListener(new ck(this, atVar, z, str, str2));
            translateAnimation.setInterpolator(accelerateInterpolator);
            translateAnimation3.setInterpolator(accelerateInterpolator);
            translateAnimation3.start();
            translateAnimation.start();
        }
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.ba = onLongClickListener;
        this.G.a(onLongClickListener);
        if (this.L != null) {
            this.L.a(onLongClickListener);
        }
    }

    public void C() {
        if (E()) {
            this.L.r();
        }
    }

    public void D() {
        if (E() && (this.L instanceof com.baidu.tieba.pb.sub.j)) {
            ((com.baidu.tieba.pb.sub.j) this.L).d();
        }
    }

    public boolean E() {
        return (this.S == null || this.S.getVisibility() == 8) ? false : true;
    }

    public void F() {
        if (this.S != null) {
            this.S.setVisibility(8);
            this.l.removeView(this.S);
            this.L.s();
        }
        ad();
        am();
    }

    public void G() {
        if (this.L != null) {
            this.L.B();
            if (this.L instanceof com.baidu.tieba.pb.sub.j) {
                ((com.baidu.tieba.pb.sub.j) this.L).e();
            }
        }
    }

    public void a(com.baidu.tieba.data.at atVar, int i) {
        if (this.L != null) {
            this.L.B();
            this.L.b(this.G.d());
            this.L.a(atVar, i);
        }
    }

    public void H() {
        if (this.L == null) {
            this.L = new com.baidu.tieba.pb.sub.j(this.k, this.bb, this.U, this.ad, this.V, this.W, this.X);
            this.L.a(this.aH);
            this.L.a(this.Y);
            this.L.c(this.G.b());
            this.L.b(this.G.c());
            this.S = this.L.n();
            this.L.a(this.Z);
            this.L.a(this.aa);
            this.L.a(this.G.a());
        }
        this.S.setVisibility(0);
        this.L.y();
        this.l.addView(this.S);
        al();
    }

    public void a(com.baidu.tieba.data.at atVar, int i, String str, boolean z, boolean z2) {
        if (this.L != null && (this.L instanceof com.baidu.tieba.pb.sub.j)) {
            com.baidu.tieba.pb.sub.j jVar = (com.baidu.tieba.pb.sub.j) this.L;
            this.L.B();
            this.L.b(this.G.d());
            this.L.a(atVar, i);
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

    public void b(ArrayList<String> arrayList) {
        this.h.a(arrayList);
    }

    public void c(ArrayList<String> arrayList) {
        if (this.L != null) {
            this.L.a(arrayList);
        }
    }

    public void I() {
        this.bb = true;
        this.h.q();
    }

    public void J() {
        this.bb = false;
        this.h.r();
    }

    public void a(DialogInterface.OnClickListener onClickListener, boolean z, boolean z2) {
        if (this.aB != null) {
            this.aB.dismiss();
            this.aB = null;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this.k);
        builder.setTitle(com.baidu.tieba.y.operation);
        if (z2) {
            builder.setItems(new String[]{this.k.getString(com.baidu.tieba.y.copy)}, onClickListener);
        } else if (!z) {
            builder.setItems(new String[]{this.k.getString(com.baidu.tieba.y.copy), this.k.getString(com.baidu.tieba.y.mark)}, onClickListener);
        } else {
            builder.setItems(new String[]{this.k.getString(com.baidu.tieba.y.copy), this.k.getString(com.baidu.tieba.y.remove_mark)}, onClickListener);
        }
        this.aB = builder.create();
        this.aB.setCanceledOnTouchOutside(true);
        this.aB.show();
    }

    public void c(boolean z) {
        this.h.setAudioFocusable(z);
    }

    public void d(boolean z) {
        if (this.L != null) {
            this.L.a(z);
        }
    }

    public void a(Bitmap bitmap) {
        this.h.a(bitmap);
        this.h.a();
    }

    public void K() {
        this.h.a((Bitmap) null);
    }

    public int L() {
        int firstVisiblePosition = this.m.getFirstVisiblePosition();
        com.baidu.adp.widget.ListView.g gVar = (com.baidu.adp.widget.ListView.g) this.m.getAdapter();
        if (gVar != null) {
            if (gVar.getItem(firstVisiblePosition) instanceof com.baidu.tieba.data.ah) {
                firstVisiblePosition++;
            }
            int c = (this.m.getAdapter() == null || !(this.m.getAdapter() instanceof com.baidu.adp.widget.ListView.g)) ? 0 : ((com.baidu.adp.widget.ListView.g) this.m.getAdapter()).c();
            return firstVisiblePosition > c ? firstVisiblePosition - c : 0;
        }
        return firstVisiblePosition;
    }

    public int M() {
        try {
            return Integer.parseInt(this.N.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public String N() {
        return this.h.getContent();
    }

    public void c(String str) {
        this.h.setContent(str);
    }

    public String O() {
        if (this.L == null) {
            return null;
        }
        return this.L.x();
    }

    public String P() {
        if (this.L != null) {
            return this.L.t();
        }
        return null;
    }

    public void a(com.baidu.tieba.data.ai aiVar) {
        this.G.a(aiVar);
        this.G.notifyDataSetChanged();
        a(new StringBuilder(String.valueOf(aiVar.c().s())).toString());
        ak();
    }

    public void b(com.baidu.tieba.data.ai aiVar) {
        PraiseData o;
        if (this.g != null) {
            boolean ak = ak();
            if (aiVar != null && aiVar.d() != null && aiVar.d().size() > 0) {
                com.baidu.tieba.data.am amVar = aiVar.d().get(0);
                if ((!this.aT || amVar.m() != 1) && (o = aiVar.c().o()) != null && o.getUser() != null && o.getUser().size() > 0) {
                    this.g.setVisibility(0);
                    this.g.setIsFromPb(true);
                    this.g.a(o, aiVar.c().p(), o.getPostId(), true);
                    this.D.setVisibility(0);
                    if (this.g.getVisibility() == 0) {
                        this.E.setVisibility(0);
                        return;
                    }
                    return;
                }
            }
            this.g.setVisibility(8);
            this.D.setVisibility(8);
            if (aiVar != null && aiVar.e() != null && aiVar.e().f() == 0 && this.aT) {
                this.D.setVisibility(8);
                if (ak) {
                    this.C.setVisibility(0);
                    return;
                } else {
                    this.C.setVisibility(8);
                    return;
                }
            }
            this.D.setVisibility(0);
            this.C.setVisibility(8);
        }
    }

    private com.baidu.tieba.data.am a(com.baidu.tieba.data.ai aiVar, boolean z, int i) {
        if (z) {
            if (aiVar == null || aiVar.d() == null || aiVar.d().size() <= 0) {
                return null;
            }
            com.baidu.tieba.data.am amVar = aiVar.d().get(0);
            if (amVar.m() != 1) {
                return d(aiVar);
            }
            return amVar;
        }
        return d(aiVar);
    }

    private com.baidu.tieba.data.am d(com.baidu.tieba.data.ai aiVar) {
        MetaData metaData;
        if (aiVar == null || aiVar.c() == null || aiVar.c().y() == null) {
            return null;
        }
        com.baidu.tieba.data.am amVar = new com.baidu.tieba.data.am();
        MetaData y = aiVar.c().y();
        String userId = y.getUserId();
        HashMap<String, MetaData> l = aiVar.c().l();
        if (l == null || (metaData = l.get(userId)) == null || metaData.getUserId() == null) {
            metaData = y;
        }
        amVar.c(1);
        amVar.a(aiVar.c().I());
        amVar.b(aiVar.c().r());
        amVar.a(aiVar.c().m());
        amVar.a(metaData);
        return amVar;
    }

    private void b(com.baidu.tieba.data.ai aiVar, boolean z, int i) {
        this.q.setVisibility(8);
        com.baidu.tieba.data.am a2 = a(aiVar, z, i);
        if (a2 != null) {
            if (z) {
                this.z.setVisibility(8);
            } else {
                this.z.setVisibility(0);
            }
            this.q.setVisibility(0);
            SparseArray sparseArray = (SparseArray) this.q.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.q.setTag(sparseArray);
            }
            sparseArray.put(com.baidu.tieba.v.tag_clip_board, a2);
            sparseArray.put(com.baidu.tieba.v.tag_is_subpb, false);
            this.y.setText(com.baidu.tbadk.core.util.bm.a(a2.n()));
            aiVar.c().L();
            this.r.setVisibility(0);
            this.r.setText(aiVar.c().J());
            b(aiVar);
            if (aiVar.c().M().getGroup_id() != 0) {
                this.aU.setVisibility(0);
                LiveCardData liveCardData = new LiveCardData();
                liveCardData.setPublisherId(aiVar.c().M().getAuthorId());
                liveCardData.setPublisherName(aiVar.c().M().getAuthorName());
                liveCardData.setPublisherPortrait(aiVar.c().M().getPublisherPortrait());
                liveCardData.setGroupId(aiVar.c().M().getGroup_id());
                liveCardData.setIntro(aiVar.c().M().getIntro());
                liveCardData.setLikers(aiVar.c().M().getLikers());
                liveCardData.setListeners(aiVar.c().M().getListeners());
                liveCardData.setName(aiVar.c().M().getName());
                liveCardData.setPortrait(aiVar.c().M().getPortrait());
                liveCardData.setStatus(aiVar.c().M().getStatus());
                liveCardData.setStartTime(aiVar.c().M().getStartTime());
                this.aV.setData(liveCardData);
                this.aV.setStatisticsKey("notice_pb_live");
            } else {
                this.aU.setVisibility(8);
            }
            String userId = aiVar.c().y().getUserId();
            if (userId != null && !userId.equals("0") && userId.equals(a2.o().getUserId())) {
                this.x.setVisibility(0);
                if (TbadkApplication.m252getInst().getSkinType() == 1) {
                    this.x.setImageResource(com.baidu.tieba.u.icon_floorhost_1);
                } else {
                    this.x.setImageResource(com.baidu.tieba.u.icon_floorhost);
                }
            } else {
                this.x.setVisibility(8);
            }
            if (a2.o() != null) {
                int level_id = a2.o().getLevel_id();
                int is_bawu = a2.o().getIs_bawu();
                String bawu_type = a2.o().getBawu_type();
                int i2 = 3;
                if (level_id != 0) {
                    this.u.setVisibility(0);
                    this.u.setText(String.valueOf(level_id));
                    this.u.setBackgroundResource(com.baidu.tbadk.core.util.h.b(level_id));
                    i2 = 2;
                    this.u.setOnClickListener(null);
                } else {
                    this.u.setVisibility(8);
                }
                if (is_bawu != 0) {
                    if (bawu_type.equals("manager")) {
                        this.u.setText((CharSequence) null);
                        this.u.setBackgroundResource(TbadkApplication.m252getInst().getSkinType() == 1 ? com.baidu.tieba.u.pb_manager_1 : com.baidu.tieba.u.pb_manager);
                        this.u.setOnClickListener(this.W);
                    } else if (bawu_type.equals("assist")) {
                        this.u.setText((CharSequence) null);
                        this.u.setBackgroundResource(TbadkApplication.m252getInst().getSkinType() == 1 ? com.baidu.tieba.u.pb_assist_1 : com.baidu.tieba.u.pb_assist);
                        this.u.setOnClickListener(this.W);
                    }
                }
                LinkedList<IconData> iconInfo = a2.o().getIconInfo();
                LinkedList<IconData> tShowInfo = a2.o().getTShowInfo();
                if (this.v != null) {
                    this.v.setOnClickListener(this.W);
                    this.v.a(iconInfo, i2, this.k.getResources().getDimensionPixelSize(com.baidu.tieba.t.pb_icon_width), this.k.getResources().getDimensionPixelSize(com.baidu.tieba.t.pb_icon_height), this.k.getResources().getDimensionPixelSize(com.baidu.tieba.t.pb_icon_margin));
                }
                if (this.w != null) {
                    this.w.setOnClickListener(this.X);
                    this.w.a(tShowInfo, 3, this.k.getResources().getDimensionPixelSize(com.baidu.tieba.t.big_icon_width), this.k.getResources().getDimensionPixelSize(com.baidu.tieba.t.big_icon_height), this.k.getResources().getDimensionPixelSize(com.baidu.tieba.t.big_icon_margin), true);
                }
                this.s.setText(a2.o().getName_show());
                this.s.setTag(a2.o().getUserId());
                int skinType = TbadkApplication.m252getInst().getSkinType();
                if (tShowInfo != null && tShowInfo.size() > 0) {
                    if (skinType == 1) {
                        this.s.setTextColor(this.k.getResources().getColor(com.baidu.tieba.s.cp_cont_h_1));
                    } else {
                        this.s.setTextColor(this.k.getResources().getColor(com.baidu.tieba.s.cp_cont_h));
                    }
                } else if (skinType == 1) {
                    this.s.setTextColor(this.k.getResources().getColor(com.baidu.tieba.s.cp_cont_f_1));
                } else {
                    this.s.setTextColor(this.k.getResources().getColor(com.baidu.tieba.s.cp_cont_f));
                }
                if (!this.bd) {
                    this.t.setVisibility(8);
                }
                this.t.setUserId(a2.o().getUserId());
                this.t.setImageBitmap(null);
                this.t.setTag(a2.o().getUserId());
                this.s.setOnClickListener(this.V);
                this.t.setOnClickListener(this.V);
                this.t.a(a2.o().getPortrait(), 12, false);
            }
        }
    }

    public void a(com.baidu.tieba.data.ai aiVar, int i, int i2, boolean z, int i3) {
        Parcelable c;
        Parcelable c2;
        String sb;
        this.aT = z;
        x();
        b(aiVar, z, i);
        this.G.a(this.aT);
        this.G.a(aiVar);
        this.G.notifyDataSetChanged();
        b(aiVar.b().getName());
        if (this.h != null && aiVar.c() != null) {
            a(new StringBuilder(String.valueOf(aiVar.c().s())).toString());
            if (aiVar.c().o() != null) {
                if (aiVar.c().o().getNum() < 1) {
                    sb = this.k.getResources().getString(com.baidu.tieba.y.frs_item_praise_text);
                } else {
                    sb = new StringBuilder(String.valueOf(aiVar.c().o().getNum())).toString();
                }
                a(sb, aiVar.c().o().getIsLike() == 1);
            }
        }
        if (aiVar.e().e() == 0 && !z) {
            this.m.setNextPage(null);
        } else {
            this.m.setNextPage(this.P);
            this.aS.e();
        }
        if (aiVar.e().f() == 0 && z) {
            this.m.setPullRefresh(null);
            this.aQ.setVisibility(8);
        } else {
            this.m.setPullRefresh(this.O);
            if (this.O != null) {
                this.O.a(TbadkApplication.m252getInst().getSkinType());
            }
            this.aQ.setVisibility(0);
            this.aS.e();
        }
        ak();
        if (z) {
            if (aiVar.e().e() == 0) {
                this.P.a(this.k.getResources().getString(com.baidu.tieba.y.no_more_to_load));
                c(aiVar);
            } else {
                this.P.a(this.k.getResources().getString(com.baidu.tieba.y.pb_load_more));
            }
            this.aS.a(this.k.getResources().getString(com.baidu.tieba.y.btn_show_passed_pb));
        } else {
            this.aS.a(this.k.getResources().getString(com.baidu.tieba.y.btn_show_passed_pb_aftre));
        }
        if (aiVar.c() != null && aiVar.c().y() != null && aiVar.c().y().getType() == 0) {
            this.d.setVisibility(4);
            this.d.setEnabled(false);
        }
        switch (i) {
            case 2:
                this.m.setSelection(i2);
                CompatibleUtile.scrollListViewBy(this.m, -this.p.getHeight(), 0);
                return;
            case 3:
                if (i3 == 1 && (c2 = bq.a().c()) != null) {
                    this.m.onRestoreInstanceState(c2);
                    return;
                } else {
                    this.m.setSelection(0);
                    return;
                }
            case 4:
                if (z) {
                    this.m.setSelection(0);
                    return;
                } else if (aiVar.d() != null) {
                    if (aiVar.e() != null && aiVar.e().f() != 0) {
                        this.m.setSelection(aiVar.d().size() + 1);
                        return;
                    } else {
                        this.m.setSelection(aiVar.d().size());
                        return;
                    }
                } else {
                    return;
                }
            case 5:
                this.m.setSelection(0);
                return;
            case 6:
                if (i3 == 1 && (c = bq.a().c()) != null) {
                    this.m.onRestoreInstanceState(c);
                    return;
                } else if (z) {
                    this.m.setSelection(0);
                    return;
                } else if (aiVar.d() != null) {
                    if (aiVar.e() != null && aiVar.e().f() != 0) {
                        this.m.setSelection(aiVar.d().size() + 1);
                        return;
                    } else {
                        this.m.setSelection(aiVar.d().size());
                        return;
                    }
                } else {
                    return;
                }
            default:
                return;
        }
    }

    public void e(boolean z) {
        this.aC = z;
        if (TbadkApplication.m252getInst().getSkinType() == 1) {
            if (z) {
                this.d.setImageResource(com.baidu.tieba.u.icon_floor_host_s_1);
            } else {
                this.d.setImageResource(com.baidu.tieba.u.icon_floor_host_n_1);
            }
        } else if (z) {
            this.d.setImageResource(com.baidu.tieba.u.icon_floor_host_s);
        } else {
            this.d.setImageResource(com.baidu.tieba.u.icon_floor_host_n);
        }
    }

    public void Q() {
        if (this.P != null) {
            this.P.e();
        }
        if (this.aS != null) {
            this.aS.e();
        }
    }

    public void a(boolean z, boolean z2) {
        if (!this.k.isProgressBarShown() && this.H != null) {
            if (com.baidu.tbadk.coreExtra.share.i.a(this.k)) {
                this.I.c().setVisibility(0);
                this.I.d().setVisibility(0);
            } else {
                this.I.c().setVisibility(8);
                this.I.d().setVisibility(8);
            }
            b(z, z2);
            this.H.b();
        }
    }

    private void b(boolean z, boolean z2) {
        if (TbadkApplication.m252getInst().getSkinType() == 1) {
            if (!z) {
                this.I.f().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.u.icon_recommend_see_s_1, 0, 0, 0);
            } else {
                this.I.f().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.u.icon_recommend_see_n_1, 0, 0, 0);
            }
            if (z2) {
                this.I.b().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.u.icon_recommend_collect_s_1, 0, 0, 0);
                return;
            } else {
                this.I.b().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.u.icon_recommend_collect_n_1, 0, 0, 0);
                return;
            }
        }
        if (!z) {
            this.I.f().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.u.icon_recommend_see_s, 0, 0, 0);
        } else {
            this.I.f().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.u.icon_recommend_see_n, 0, 0, 0);
        }
        if (z2) {
            this.I.b().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.u.icon_recommend_collect_s, 0, 0, 0);
        } else {
            this.I.b().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.u.icon_recommend_collect_n, 0, 0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ak() {
        boolean z;
        boolean z2 = true;
        View findViewById = this.o.findViewById(com.baidu.tieba.v.pb_head_function_manage_root);
        if (findViewById != null && findViewById.getVisibility() == 0) {
            this.A.setVisibility(0);
            z = true;
        } else {
            this.A.setVisibility(8);
            z = false;
        }
        View findViewById2 = this.o.findViewById(com.baidu.tieba.v.pb_head_function_manage_go_to_live_post);
        if (findViewById2 != null && findViewById2.getVisibility() == 0) {
            this.B.setVisibility(0);
        } else {
            this.B.setVisibility(8);
            z2 = z;
        }
        if (z2 && this.aT) {
            this.C.setVisibility(0);
        } else {
            this.C.setVisibility(8);
        }
        return z2;
    }

    public boolean a(com.baidu.tieba.data.ai aiVar, boolean z, boolean z2) {
        boolean z3;
        if (this.r != null) {
            if (aiVar.c().H() == 0) {
                this.r.setVisibility(0);
                aiVar.c().L();
                this.r.setText(aiVar.c().J());
            } else {
                this.r.setVisibility(8);
            }
        }
        this.aT = z;
        this.aG = (Button) this.o.findViewById(com.baidu.tieba.v.pb_head_function_manage_go_to_live_post);
        com.baidu.tbadk.core.data.m c = aiVar.c();
        if (c != null) {
            a(c.x());
        }
        RelativeLayout relativeLayout = (RelativeLayout) this.o.findViewById(com.baidu.tieba.v.pb_head_function_manage_root);
        Button button = (Button) this.o.findViewById(com.baidu.tieba.v.pb_head_function_manage_commit_top);
        Button button2 = (Button) this.o.findViewById(com.baidu.tieba.v.pb_head_function_manage_cancel_top);
        Button button3 = (Button) this.o.findViewById(com.baidu.tieba.v.pb_head_function_manage_commit_good);
        Button button4 = (Button) this.o.findViewById(com.baidu.tieba.v.pb_head_function_manage_cancel_good);
        button.setOnClickListener(this.U);
        button2.setOnClickListener(this.U);
        button3.setOnClickListener(this.U);
        button4.setOnClickListener(this.U);
        if (!z2) {
            relativeLayout.setVisibility(8);
            button.setVisibility(8);
            button2.setVisibility(8);
            button3.setVisibility(8);
            button4.setVisibility(8);
        }
        if (aiVar.k() == 1) {
            if (relativeLayout != null) {
                relativeLayout.setVisibility(0);
                z3 = true;
            } else {
                z3 = false;
            }
            if (aiVar.c().v() == 1) {
                button3.setVisibility(8);
                button4.setVisibility(0);
            } else {
                button3.setVisibility(0);
                button4.setVisibility(8);
            }
            if (aiVar.c().u() == 1) {
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
    public void a(com.baidu.tieba.data.ai aiVar, boolean z, boolean z2, int i) {
        boolean z3;
        boolean z4;
        boolean z5;
        String userId;
        if (aiVar != null) {
            boolean a2 = a(aiVar, z, z2);
            RelativeLayout relativeLayout = (RelativeLayout) this.o.findViewById(com.baidu.tieba.v.pb_head_function_manage_root);
            Button button = (Button) this.o.findViewById(com.baidu.tieba.v.pb_head_function_manage_delormanage);
            button.setOnClickListener(this.U);
            com.baidu.tieba.data.am a3 = a(aiVar, z, i);
            if (a3 != null) {
                if (aiVar.k() != 0 && a3.o() != null) {
                    String userId2 = a3.o().getUserId();
                    boolean z6 = userId2 == null || !userId2.equals(TbadkApplication.getCurrentAccount());
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
                    String userId3 = aiVar.c().y().getUserId();
                    if (userId3 != null && userId3.equals(TbadkApplication.getCurrentAccount())) {
                        z3 = false;
                        z4 = true;
                        z5 = false;
                    } else if (a3.o() == null || (userId = a3.o().getUserId()) == null || !userId.equals(TbadkApplication.getCurrentAccount())) {
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
                    button.setText(com.baidu.tieba.y.manage);
                    SparseArray sparseArray = new SparseArray();
                    if (a3.o() != null) {
                        sparseArray.put(com.baidu.tieba.v.tag_forbid_user_name, a3.o().getUserName());
                    }
                    sparseArray.put(com.baidu.tieba.v.tag_del_post_id, a3.l());
                    sparseArray.put(com.baidu.tieba.v.tag_del_post_type, 0);
                    sparseArray.put(com.baidu.tieba.v.tag_del_post_is_self, Boolean.valueOf(z3));
                    sparseArray.put(com.baidu.tieba.v.tag_manage_user_identity, Integer.valueOf(aiVar.k()));
                    sparseArray.put(com.baidu.tieba.v.tag_should_manage_visible, true);
                    button.setTag(sparseArray);
                } else if (z4) {
                    relativeLayout.setVisibility(0);
                    button.setVisibility(0);
                    button.setText(com.baidu.tieba.y.delete);
                    SparseArray sparseArray2 = new SparseArray();
                    sparseArray2.put(com.baidu.tieba.v.tag_del_post_id, a3.l());
                    sparseArray2.put(com.baidu.tieba.v.tag_del_post_type, 0);
                    sparseArray2.put(com.baidu.tieba.v.tag_del_post_is_self, Boolean.valueOf(z3));
                    sparseArray2.put(com.baidu.tieba.v.tag_manage_user_identity, Integer.valueOf(aiVar.k()));
                    sparseArray2.put(com.baidu.tieba.v.tag_should_manage_visible, false);
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
            ak();
        }
    }

    private void b(int i) {
        this.k.getLayoutMode().a(i == 1);
        this.k.getLayoutMode().a((View) this.l);
        e(this.aC);
        this.G.notifyDataSetChanged();
        this.h.c(i);
    }

    public View R() {
        return this.Q;
    }

    public BdListView S() {
        return this.m;
    }

    public int T() {
        return com.baidu.tieba.v.richText;
    }

    public int U() {
        return com.baidu.tieba.v.user_icon_box;
    }

    public Button V() {
        return (Button) this.o.findViewById(com.baidu.tieba.v.pb_head_function_manage_commit_good);
    }

    public Button W() {
        return (Button) this.o.findViewById(com.baidu.tieba.v.pb_head_function_manage_cancel_good);
    }

    public Button X() {
        return (Button) this.o.findViewById(com.baidu.tieba.v.pb_head_function_manage_commit_top);
    }

    public Button Y() {
        return (Button) this.o.findViewById(com.baidu.tieba.v.pb_head_function_manage_cancel_top);
    }

    public View Z() {
        if (this.L == null) {
            return null;
        }
        return this.L.v();
    }

    public void a(com.baidu.adp.widget.ListView.x xVar) {
        this.m.setOnSrollToBottomListener(xVar);
    }

    public void a(com.baidu.adp.widget.ListView.z zVar) {
        this.m.setOnSrollToTopListener(zVar);
    }

    public void a(DialogInterface.OnClickListener onClickListener) {
        this.T = onClickListener;
    }

    public void a(com.baidu.adp.widget.ListView.d dVar) {
        this.O.a(dVar);
    }

    public void a(com.baidu.tbadk.core.data.k kVar) {
        if (kVar != null) {
            int c = kVar.c();
            int a2 = kVar.a();
            if (this.J == null) {
                this.J = new Dialog(this.k, com.baidu.tieba.z.common_alert_dialog);
                this.J.setCanceledOnTouchOutside(true);
                this.J.setCancelable(true);
                this.M = this.k.getLayoutInflater().inflate(com.baidu.tieba.w.dialog_direct_pager, (ViewGroup) null);
                this.J.setContentView(this.M);
                WindowManager.LayoutParams attributes = this.J.getWindow().getAttributes();
                attributes.gravity = 49;
                attributes.y = com.baidu.adp.lib.util.j.a((Context) this.k, 54.0f);
                attributes.width = (int) (com.baidu.adp.lib.util.j.b(this.k) * 0.9d);
                this.J.getWindow().setAttributes(attributes);
                this.J.setOnKeyListener(new cm(this));
            }
            this.J.show();
            ((Button) this.M.findViewById(com.baidu.tieba.v.dialog_button_ok)).setOnClickListener(this.U);
            ((Button) this.M.findViewById(com.baidu.tieba.v.dialog_button_cancel)).setOnClickListener(this.U);
            this.N = (EditText) this.M.findViewById(com.baidu.tieba.v.input_page_number);
            this.N.setText("");
            this.N.setOnFocusChangeListener(new cn(this));
            TextView textView = (TextView) this.M.findViewById(com.baidu.tieba.v.current_page_number);
            if (c <= 0) {
                c = 1;
            }
            textView.setText(MessageFormat.format(this.k.getApplicationContext().getResources().getString(com.baidu.tieba.y.current_page), Integer.valueOf(c), Integer.valueOf(a2 <= 0 ? 1 : a2)));
            this.k.ShowSoftKeyPadDelay(this.N, 150);
        }
    }

    public void a(AbsListView.OnScrollListener onScrollListener) {
        this.m.setOnScrollListener(onScrollListener);
    }

    public void b(AbsListView.OnScrollListener onScrollListener) {
        this.Y = onScrollListener;
    }

    public void a(View.OnClickListener onClickListener) {
        this.V = onClickListener;
        this.G.b(onClickListener);
    }

    public void b(View.OnClickListener onClickListener) {
        this.W = onClickListener;
        this.G.c(onClickListener);
    }

    public void c(View.OnClickListener onClickListener) {
        this.X = onClickListener;
        this.G.d(onClickListener);
    }

    public void d(String str) {
        this.k.showToast(str);
    }

    public boolean f(boolean z) {
        if (this.L == null || !this.L.a()) {
            if (!z) {
                if (E()) {
                    F();
                    return true;
                } else if (this.h.h()) {
                    this.h.g();
                    return true;
                }
            } else if (E()) {
                F();
                return true;
            }
            return false;
        }
        return true;
    }

    public void aa() {
        if (this.bc != null) {
            while (this.bc.size() > 0) {
                TbImageView remove = this.bc.remove(0);
                if (remove != null) {
                    remove.e();
                }
            }
        }
    }

    public void ab() {
        aa();
    }

    public void ac() {
        this.k.hideProgressBar();
        if (this.n != null && this.ab != null) {
            this.n.b(this.ab);
        }
        ad();
        this.P.e();
    }

    public void ad() {
        if (this.H != null) {
            this.H.dismiss();
        }
        com.baidu.adp.lib.util.j.a(this.k, this.N);
        this.h.e();
        if (this.J != null) {
            this.J.dismiss();
        }
        if (this.aB != null) {
            this.aB.dismiss();
        }
        if (this.L != null) {
            this.L.q();
        }
        ae();
    }

    public void g(boolean z) {
        this.G.b(z);
        if (this.L != null) {
            this.L.c(z);
        }
    }

    public void h(boolean z) {
        this.bd = z;
        this.G.c(z);
        if (this.L != null) {
            this.L.b(z);
        }
    }

    public void ae() {
        if (this.ae != null) {
            this.ae.dismiss();
        }
        if (this.aj != null) {
            this.aj.dismiss();
        }
        if (this.at != null) {
            this.at.dismiss();
        }
        if (this.ac != null) {
            this.ac.dismiss();
        }
    }

    public void a(int i) {
        this.k.getLayoutMode().a(i == 1);
        this.k.getLayoutMode().a((View) this.l);
        this.k.getLayoutMode().a(this.o);
        this.k.getLayoutMode().a(this.Q);
        this.H.a(this.k, i, this.k.getResources().getDrawable(com.baidu.tieba.u.bg_pull_down_right_n), this.k.getResources().getDrawable(com.baidu.tieba.u.bg_pull_down_right_n_1));
        this.b.c(i);
        b(i);
        if (this.L != null) {
            this.L.a(i);
            this.k.getLayoutMode().a(this.P.b());
        }
        if (this.O != null) {
            this.O.a(i);
        }
        if (this.P != null) {
            this.P.d(i);
            this.Q.setBackgroundResource(i == 1 ? com.baidu.tieba.u.pb_foot_more_trans_selector_1 : com.baidu.tieba.u.pb_foot_more_trans_selector);
            this.P.a(i == 1 ? com.baidu.tieba.u.pb_foot_more_trans_selector_1 : com.baidu.tieba.u.pb_foot_more_trans_selector);
        }
        if (this.aS != null) {
            this.aS.d(i);
            this.aS.a(i == 1 ? com.baidu.tieba.s.cp_bg_line_e_1 : com.baidu.tieba.s.cp_bg_line_e);
            this.aR.setBackgroundResource(i == 1 ? com.baidu.tieba.s.cp_bg_line_e_1 : com.baidu.tieba.s.cp_bg_line_e);
        }
        this.h.c(i);
        if (this.aE != null) {
            if (i == 1) {
                this.aE.setBackgroundResource(com.baidu.tieba.s.cp_bg_line_d_1);
            } else {
                this.aE.setBackgroundResource(com.baidu.tieba.s.cp_bg_line_d);
            }
        }
        if (this.g != null) {
            this.g.a(i);
        }
    }

    public void a(com.baidu.tbadk.widget.richText.s sVar) {
        this.Z = sVar;
        this.G.a(this.Z);
        if (this.L != null) {
            this.L.a(this.Z);
        }
    }

    public void a(com.baidu.tbadk.widget.richText.r rVar) {
        this.aa = rVar;
        this.G.a(this.aa);
        if (this.L != null) {
            this.L.a(this.aa);
        }
    }

    public void a(com.baidu.tbadk.core.view.m mVar) {
        this.ab = mVar;
        if (this.n != null) {
            this.n.a(this.ab);
        }
    }

    public void i(boolean z) {
        this.G.d(z);
        this.aW = z;
    }

    public View af() {
        if (this.L == null) {
            return null;
        }
        return this.L.C();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void al() {
        if (this.b != null) {
            this.b.setVisibility(8);
        }
        if (this.m != null) {
            this.m.setVisibility(8);
        }
        if (this.h != null) {
            this.aP = this.aJ.getVisibility() == 0;
            this.h.setVisibility(8);
            this.aJ.setVisibility(8);
            this.aI.setVisibility(8);
        }
    }

    private void am() {
        if (this.b != null) {
            this.b.setVisibility(0);
        }
        if (this.m != null) {
            this.m.setVisibility(0);
        }
        if (this.h != null) {
            int visibility = this.F != null ? this.F.getVisibility() : 0;
            if (visibility == 0) {
                if (this.aP) {
                    this.aJ.setVisibility(visibility);
                    this.aI.setVisibility(visibility);
                    return;
                }
                this.h.setVisibility(visibility);
                return;
            }
            this.aP = this.aJ.getVisibility() == 0;
            this.h.setVisibility(visibility);
            this.aJ.setVisibility(visibility);
            this.aI.setVisibility(visibility);
        }
    }

    public Button ag() {
        return this.aG;
    }

    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.h.c.a(writeImagesInfo, z);
    }

    public void a(WriteImagesInfo writeImagesInfo) {
        this.h.c.setBaobaoUris(writeImagesInfo);
        if (writeImagesInfo != null && writeImagesInfo.size() > 0) {
            this.h.a();
        } else {
            this.h.b();
        }
    }

    public void j(boolean z) {
        if (z) {
            this.f.setVisibility(0);
        } else {
            this.f.setVisibility(8);
        }
    }

    public void c(com.baidu.tieba.data.ai aiVar) {
        ArrayList<com.baidu.tieba.data.am> d = aiVar.d();
        if (d.size() == 1) {
            com.baidu.tieba.data.am amVar = d.get(0);
            if (amVar.v() < amVar.k().size()) {
                this.m.setNextPage(null);
                return;
            } else {
                this.m.setNextPage(this.P);
                return;
            }
        }
        this.m.setNextPage(this.P);
    }

    public boolean ah() {
        return this.h.l();
    }

    public boolean ai() {
        if (this.L == null) {
            return false;
        }
        return this.L.D();
    }
}
