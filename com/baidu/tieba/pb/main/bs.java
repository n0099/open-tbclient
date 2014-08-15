package com.baidu.tieba.pb.main;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
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
public class bs {
    public static int a = 80;
    private View A;
    private View B;
    private View C;
    private View D;
    private View E;
    private RelativeLayout F;
    private bf G;
    private bo I;
    private com.baidu.tieba.view.y O;
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
    private bd aZ;
    private View.OnClickListener ad;
    NavigationBar b;
    TextView c;
    ImageView d;
    ImageView e;
    ImageView f;
    public FrsPraiseView g;
    public PbEditor h;
    public View i;
    be j;
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
    private com.baidu.tbadk.core.view.m H = null;
    private Dialog J = null;
    private Dialog K = null;
    private com.baidu.tieba.pb.sub.l L = null;
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
    private com.baidu.tbadk.core.view.q ab = null;
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
    private cu aA = null;
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
    private com.baidu.tieba.bubble.t aX = new bt(this);
    private final View.OnClickListener aY = new cc(this);
    private View.OnLongClickListener ba = null;
    private boolean bb = false;
    private final List<TbImageView> bc = new ArrayList();
    private boolean bd = true;
    private com.baidu.tieba.c.a aD = new com.baidu.tieba.c.a(new cn(this));

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

    public com.baidu.tieba.data.an c() {
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
        return (com.baidu.tieba.data.an) this.G.getItem(i7);
    }

    public bs(PbActivity pbActivity, View.OnClickListener onClickListener) {
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
        this.l = (FrameLayout) from.inflate(com.baidu.tieba.v.new_pb_activity, (ViewGroup) null);
        this.k.addContentView(this.l, new FrameLayout.LayoutParams(-1, -1));
        this.F = (RelativeLayout) this.k.findViewById(com.baidu.tieba.u.title_wrapper);
        this.n = (NoNetworkView) this.k.findViewById(com.baidu.tieba.u.view_no_network);
        this.m = (BdListView) this.k.findViewById(com.baidu.tieba.u.new_pb_list);
        this.aE = new View(this.k);
        this.aE.setBackgroundResource(com.baidu.tieba.r.cp_bg_line_d);
        this.aE.setLayoutParams(new AbsListView.LayoutParams(-1, this.k.getResources().getDimensionPixelSize(com.baidu.tieba.s.navi_height)));
        this.m.addHeaderView(this.aE);
        View view = new View(this.k);
        view.setLayoutParams(new AbsListView.LayoutParams(-1, this.k.getResources().getDimensionPixelSize(com.baidu.tieba.s.pb_editor_height)));
        this.m.addFooterView(view);
        this.b = (NavigationBar) this.k.findViewById(com.baidu.tieba.u.view_navigation_bar);
        this.b.setOnClickListener(new co(this));
        this.i = this.b.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.U);
        this.c = (TextView) this.b.a(NavigationBar.ControlAlign.HORIZONTAL_CENTER, com.baidu.tieba.v.pb_title_textview, (View.OnClickListener) null);
        this.f = (ImageView) this.b.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.v.widget_nb_add_floor, this.U);
        this.d = (ImageView) this.b.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.v.nb_item_floor_host, this.U);
        this.e = (ImageView) this.b.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.v.nb_item_floor_more, this.U);
        this.I = new bo(this.k, this.U);
        this.h = (PbEditor) this.k.findViewById(com.baidu.tieba.u.pb_editor_view);
        this.h.setFrom(1);
        this.h.a(false);
        this.h.setVisibility(8);
        this.aJ = this.k.findViewById(com.baidu.tieba.u.pb_editor_tool_comment);
        this.aK = (LinearLayout) this.k.findViewById(com.baidu.tieba.u.pb_editor_tool_comment_reply);
        this.aM = (LinearLayout) this.k.findViewById(com.baidu.tieba.u.pb_editor_tool_comment_praise);
        this.aI = this.k.findViewById(com.baidu.tieba.u.pb_editor_tool_comment_line);
        this.aL = (TextView) this.k.findViewById(com.baidu.tieba.u.pb_editor_tool_comment_reply_text);
        this.aN = (ImageView) this.k.findViewById(com.baidu.tieba.u.pb_editor_tool_comment_praise_icon);
        this.aO = (TextView) this.k.findViewById(com.baidu.tieba.u.pb_editor_tool_comment_praise_text);
        this.aK.setOnClickListener(new cp(this));
        this.aM.setOnClickListener(this.U);
        this.aM.setOnTouchListener(this.k);
        J();
        this.o = from.inflate(com.baidu.tieba.v.new_pb_header_item, (ViewGroup) null);
        this.q = (ColumnLayout) this.o.findViewById(com.baidu.tieba.u.pb_head_owner_root);
        this.q.setOnLongClickListener(this.ba);
        this.q.setOnTouchListener(this.aD);
        this.q.setVisibility(8);
        this.o.setOnTouchListener(this.aD);
        this.r = (TextView) this.o.findViewById(com.baidu.tieba.u.pb_head_post_title);
        this.r.setTextSize(TbConfig.getContentSizeOfPostTitle());
        this.r.setVisibility(8);
        this.s = (TextView) this.q.findViewById(com.baidu.tieba.u.pb_head_owner_info_user_name);
        this.t = (HeadImageView) this.q.findViewById(com.baidu.tieba.u.pb_head_owner_photo);
        if (!this.bd) {
            this.t.setVisibility(8);
        }
        this.u = (TextView) this.q.findViewById(com.baidu.tieba.u.pb_head_owner_info_user_rank);
        this.v = (UserIconBox) this.q.findViewById(com.baidu.tieba.u.pb_head_owner_info_user_icon);
        this.w = (UserIconBox) this.q.findViewById(com.baidu.tieba.u.pb_head_owner_info_tshow_icon);
        this.x = (ImageView) this.q.findViewById(com.baidu.tieba.u.pb_head_owner_info_floor_owner);
        this.y = (TextView) this.q.findViewById(com.baidu.tieba.u.pb_head_owner_info_time);
        this.z = (TextView) this.o.findViewById(com.baidu.tieba.u.pb_head_reverse_hint);
        this.z.setOnClickListener(this.U);
        this.z.setVisibility(8);
        this.g = (FrsPraiseView) this.o.findViewById(com.baidu.tieba.u.pb_head_praise_view);
        this.g.setIsFromPb(true);
        this.p = this.o.findViewById(com.baidu.tieba.u.pb_head_function_manage_root);
        this.A = this.o.findViewById(com.baidu.tieba.u.new_pb_header_item_line_above_manage);
        this.B = this.o.findViewById(com.baidu.tieba.u.new_pb_header_item_line_above_livepost);
        this.C = this.o.findViewById(com.baidu.tieba.u.new_pb_header_item_line_below_livepost);
        this.D = this.o.findViewById(com.baidu.tieba.u.new_pb_header_item_line_above_praise);
        this.E = this.o.findViewById(com.baidu.tieba.u.new_pb_header_item_line_above_showpassed);
        this.aU = this.o.findViewById(com.baidu.tieba.u.live_card_layout);
        this.aV = (LiveBroadcastCard) this.o.findViewById(com.baidu.tieba.u.item_card);
        this.o.setOnLongClickListener(new cq(this));
        aj();
        this.G = new bf(this.k);
        this.G.e(this.U);
        this.G.a(this.aD);
        this.G.a(this.Z);
        this.ad = new cr(this);
        this.G.a(this.ad);
        this.m.setAdapter((ListAdapter) this.G);
        this.m.addHeaderView(this.o);
        this.O = new com.baidu.tieba.view.y(this.k);
        this.O.a();
        this.P = new PbListView(this.k);
        this.Q = this.P.b().findViewById(com.baidu.tieba.u.pb_more_view);
        if (this.Q != null) {
            this.Q.setOnClickListener(this.U);
        }
        int skinType = TbadkApplication.m252getInst().getSkinType();
        this.Q.setBackgroundResource(skinType == 1 ? com.baidu.tieba.t.pb_foot_more_trans_selector_1 : com.baidu.tieba.t.pb_foot_more_trans_selector);
        this.P.c();
        this.P.a(skinType == 1 ? com.baidu.tieba.t.pb_foot_more_trans_selector_1 : com.baidu.tieba.t.pb_foot_more_trans_selector);
        this.P.c(com.baidu.tieba.t.pb_foot_more_trans_selector);
        this.c.setOnClickListener(this.U);
    }

    public void a(String str) {
        if (this.aL != null) {
            if (!TextUtils.isEmpty(str) && !"0".equals(str)) {
                this.aL.setText(str);
            } else {
                this.aL.setText(this.k.getString(com.baidu.tieba.x.reply));
            }
        }
    }

    public void a(String str, boolean z) {
        if (this.aO != null) {
            this.aO.setText(str);
            int skinType = TbadkApplication.m252getInst().getSkinType();
            if (z) {
                if (skinType == 1) {
                    this.aN.setImageResource(com.baidu.tieba.t.icon_hand_click_1);
                } else {
                    this.aN.setImageResource(com.baidu.tieba.t.icon_hand_click);
                }
            } else if (skinType == 1) {
                this.aN.setImageResource(com.baidu.tieba.t.icon_hand_normal_1);
            } else {
                this.aN.setImageResource(com.baidu.tieba.t.icon_hand_normal);
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
                this.m.postDelayed(new cs(this, z), 10L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view) {
        boolean z;
        if (this.F != null && this.h != null && view != null) {
            if (this.aP) {
                z = this.aJ.getVisibility() == 0;
            } else {
                z = this.h.getVisibility() == 0;
            }
            boolean z2 = this.F.getVisibility() == 0;
            if (z2) {
                Animation loadAnimation = AnimationUtils.loadAnimation(view.getContext(), com.baidu.tieba.o.top_fold_up);
                loadAnimation.setAnimationListener(new ct(this));
                this.F.startAnimation(loadAnimation);
            } else {
                Animation loadAnimation2 = AnimationUtils.loadAnimation(view.getContext(), com.baidu.tieba.o.top_fold_down);
                loadAnimation2.setAnimationListener(new bu(this));
                this.F.startAnimation(loadAnimation2);
            }
            if (z) {
                if (z2) {
                    this.h.f();
                    Animation loadAnimation3 = AnimationUtils.loadAnimation(view.getContext(), com.baidu.tieba.o.bottom_fold_down);
                    loadAnimation3.setAnimationListener(new bv(this));
                    if (this.aP) {
                        this.aJ.startAnimation(loadAnimation3);
                    } else {
                        this.h.startAnimation(loadAnimation3);
                    }
                }
            } else if (!z2) {
                Animation loadAnimation4 = AnimationUtils.loadAnimation(view.getContext(), com.baidu.tieba.o.bottom_fold_up);
                loadAnimation4.setAnimationListener(new bw(this));
                if (this.aP) {
                    this.aJ.startAnimation(loadAnimation4);
                } else {
                    this.h.startAnimation(loadAnimation4);
                }
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

    public bo h() {
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
        if (this.L == null || !(this.L instanceof com.baidu.tieba.pb.sub.i)) {
            return null;
        }
        return ((com.baidu.tieba.pb.sub.i) this.L).c();
    }

    public bf m() {
        return this.G;
    }

    public void a(be beVar) {
        this.j = beVar;
    }

    public void n() {
        if (this.k.getCurrentFocus() != null) {
            com.baidu.adp.lib.util.j.a(this.k, this.k.getCurrentFocus());
        }
    }

    private void a(com.baidu.tbadk.core.data.p pVar) {
        if (pVar != null && pVar.a() != 0) {
            int b = pVar.b();
            String string = this.k.getString(com.baidu.tieba.x.go_to_live_post_prefix);
            if (b == 0) {
                string = String.valueOf(string) + this.k.getString(com.baidu.tieba.x.go_to_interview_post);
            } else if (b == 1) {
                string = String.valueOf(string) + this.k.getString(com.baidu.tieba.x.go_to_discuss_post);
            }
            this.aG.setText(string);
            this.aG.setVisibility(0);
            this.aG.setOnClickListener(this.U);
            ak();
        }
    }

    private void aj() {
        this.aQ = (LinearLayout) this.o.findViewById(com.baidu.tieba.u.btn_show_passed_pb);
        this.aS = new PbListView(this.k, PbListView.IconType.ICON_UP_WARD);
        this.aR = this.aS.a();
        this.aS.a(this.k.getResources().getString(com.baidu.tieba.x.btn_show_passed_pb));
        this.aR.setOnClickListener(this.aY);
        this.aQ.addView(this.aR);
        this.aQ.requestLayout();
        this.aQ.invalidate();
        int skinType = TbadkApplication.m252getInst().getSkinType();
        this.aR.setBackgroundResource(skinType == 1 ? com.baidu.tieba.r.cp_bg_line_e_1 : com.baidu.tieba.r.cp_bg_line_e);
        this.aS.a(skinType == 1 ? com.baidu.tieba.r.cp_bg_line_e_1 : com.baidu.tieba.r.cp_bg_line_e);
        this.aS.c(com.baidu.tieba.r.cp_bg_line_e);
        ak();
    }

    public void a(View view) {
        if (this.ac == null) {
            this.ac = new Dialog(this.k, com.baidu.tieba.y.common_alert_dialog);
            this.ac.setCanceledOnTouchOutside(true);
            this.ac.setCancelable(true);
            this.ac.setContentView(this.k.getLayoutInflater().inflate(com.baidu.tieba.v.forum_manage_dialog, (ViewGroup) null));
            WindowManager.LayoutParams attributes = this.ac.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.j.b(this.k) * 0.9d);
            this.ac.getWindow().setAttributes(attributes);
        }
        Button button = (Button) this.ac.findViewById(com.baidu.tieba.u.del_post_btn);
        Button button2 = (Button) this.ac.findViewById(com.baidu.tieba.u.forbid_user_btn);
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            if ("".equals(sparseArray.get(com.baidu.tieba.u.tag_del_post_id))) {
                button.setVisibility(8);
            } else {
                SparseArray sparseArray2 = (SparseArray) button.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    button.setTag(sparseArray2);
                }
                button.setVisibility(0);
                sparseArray2.put(com.baidu.tieba.u.tag_del_post_id, sparseArray.get(com.baidu.tieba.u.tag_del_post_id));
                sparseArray2.put(com.baidu.tieba.u.tag_del_post_type, sparseArray.get(com.baidu.tieba.u.tag_del_post_type));
                sparseArray2.put(com.baidu.tieba.u.tag_del_post_is_self, sparseArray.get(com.baidu.tieba.u.tag_del_post_is_self));
                sparseArray2.put(com.baidu.tieba.u.tag_manage_user_identity, sparseArray.get(com.baidu.tieba.u.tag_manage_user_identity));
                button.setOnClickListener(new bx(this));
            }
            if ("".equals(sparseArray.get(com.baidu.tieba.u.tag_forbid_user_name))) {
                button2.setVisibility(8);
            } else {
                SparseArray sparseArray3 = (SparseArray) button2.getTag();
                if (sparseArray3 == null) {
                    sparseArray3 = new SparseArray();
                    button2.setTag(sparseArray3);
                }
                button2.setVisibility(0);
                sparseArray3.put(com.baidu.tieba.u.tag_forbid_user_name, sparseArray.get(com.baidu.tieba.u.tag_forbid_user_name));
                sparseArray3.put(com.baidu.tieba.u.tag_manage_user_identity, sparseArray.get(com.baidu.tieba.u.tag_manage_user_identity));
                button2.setOnClickListener(new by(this));
            }
            com.baidu.adp.lib.e.d.a(this.ac, this.k);
        }
    }

    public void a(bd bdVar) {
        this.aZ = bdVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        if (this.ae == null) {
            this.ae = new Dialog(this.k, com.baidu.tieba.y.common_alert_dialog);
            this.ae.setCanceledOnTouchOutside(true);
            this.ae.setCancelable(true);
            this.af = this.k.getLayoutInflater().inflate(com.baidu.tieba.v.del_post, (ViewGroup) null);
            this.ae.setContentView(this.af);
            WindowManager.LayoutParams attributes = this.ae.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.j.b(this.k) * 0.9d);
            this.ae.getWindow().setAttributes(attributes);
            this.ag = (Button) this.af.findViewById(com.baidu.tieba.u.dialog_button_ok);
            this.ag.setOnClickListener(this.U);
            this.ah = (Button) this.af.findViewById(com.baidu.tieba.u.dialog_button_cancel);
            this.ah.setOnClickListener(new bz(this));
            this.ai = (TextView) this.af.findViewById(com.baidu.tieba.u.confirm_text);
        }
        SparseArray sparseArray = (SparseArray) this.ag.getTag();
        if (sparseArray == null) {
            sparseArray = new SparseArray();
            this.ag.setTag(sparseArray);
        }
        sparseArray.put(com.baidu.tieba.u.tag_del_post_id, str);
        sparseArray.put(com.baidu.tieba.u.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(com.baidu.tieba.u.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(com.baidu.tieba.u.tag_del_post_is_self, Boolean.valueOf(z));
        if (i == 0) {
            this.ai.setText(com.baidu.tieba.x.del_thread_confirm);
        } else {
            this.ai.setText(com.baidu.tieba.x.del_post_confirm);
        }
        com.baidu.adp.lib.e.d.a(this.ae, this.k);
    }

    public void a(ArrayList<com.baidu.tbadk.core.data.h> arrayList) {
        if (this.at == null) {
            this.at = new Dialog(this.k, com.baidu.tieba.y.common_alert_dialog);
            this.at.setCanceledOnTouchOutside(true);
            this.at.setCancelable(true);
            this.au = this.k.getLayoutInflater().inflate(com.baidu.tieba.v.commit_good, (ViewGroup) null);
            this.aF = (ScrollView) this.au.findViewById(com.baidu.tieba.u.good_scroll);
            this.at.setContentView(this.au);
            WindowManager.LayoutParams attributes = this.at.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.j.b(this.k) * 0.9d);
            this.at.getWindow().setAttributes(attributes);
            this.aw = new ca(this);
            this.av = (RadioGroup) this.au.findViewById(com.baidu.tieba.u.good_class_group);
            this.ay = (Button) this.au.findViewById(com.baidu.tieba.u.dialog_button_cancel);
            this.ay.setOnClickListener(new cb(this));
            this.ax = (Button) this.au.findViewById(com.baidu.tieba.u.dialog_button_ok);
            this.ax.setOnClickListener(this.U);
        }
        this.av.removeAllViews();
        LayoutInflater layoutInflater = this.k.getLayoutInflater();
        RadioButton radioButton = (RadioButton) layoutInflater.inflate(com.baidu.tieba.v.good_class_radio_button, (ViewGroup) null);
        radioButton.setTag("0");
        radioButton.setText(this.k.getString(com.baidu.tieba.x.def_good_class));
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
                RadioButton radioButton2 = (RadioButton) layoutInflater.inflate(com.baidu.tieba.v.good_class_radio_button, (ViewGroup) null);
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
        com.baidu.adp.lib.e.d.a(this.at, this.k);
    }

    public void o() {
        this.k.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.k.hideProgressBar();
        if (z && z2) {
            this.k.showToast(this.k.getString(com.baidu.tieba.x.success));
        } else if (str != null && z2) {
            this.k.showToast(str);
        }
    }

    public void p() {
        this.l.removeView(this.R);
    }

    public View q() {
        if (this.af != null) {
            return this.af.findViewById(com.baidu.tieba.u.dialog_button_ok);
        }
        return null;
    }

    public View r() {
        if (this.au != null) {
            return this.au.findViewById(com.baidu.tieba.u.dialog_button_ok);
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
        if (!TextUtils.isEmpty(str)) {
            this.c.setVisibility(0);
            this.c.setText(String.valueOf(str) + this.k.getString(com.baidu.tieba.x.bar));
        }
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
            this.L = new com.baidu.tieba.pb.sub.l(this.k, this.bb, this.U, this.ad, this.V, this.W, this.X);
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
            this.h.setOnActionListener(new cd(this, wVar));
            this.aH = wVar;
            if (this.L != null) {
                this.L.a(wVar);
            }
        }
    }

    public void a(cu cuVar) {
        this.aA = cuVar;
    }

    public void a(boolean z, com.baidu.tieba.data.au auVar, boolean z2, String str, String str2, View view, int i) {
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap bitmap3;
        if (auVar != null && view != null) {
            TiebaStatic.eventStat(this.k, "pb_tosubpb", "pbclick", 1, new Object[0]);
            if (this.L == null) {
                this.L = new com.baidu.tieba.pb.sub.l(this.k, this.bb, this.U, this.ad, this.V, this.W, this.X);
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
            this.L.a(auVar, i);
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
            int height = ((view.getHeight() + this.k.getResources().getDimensionPixelSize(com.baidu.tieba.s.subpb_listitem_packup_min_height)) - this.k.getResources().getDimensionPixelSize(com.baidu.tieba.s.pb_list_item_border_bottom_margin_top)) - this.l.getHeight();
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
                translateAnimation2.setAnimationListener(new ce(this, imageView));
                translateAnimation2.setInterpolator(accelerateInterpolator);
                translateAnimation2.start();
            }
            translateAnimation.setAnimationListener(new cg(this, auVar, z, str, str2));
            translateAnimation.setInterpolator(accelerateInterpolator);
            if (bitmap3 != null) {
                ImageView imageView2 = new ImageView(this.k);
                imageView2.setImageBitmap(bitmap3);
                imageView2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 80));
                this.l.addView(imageView2);
                TranslateAnimation translateAnimation3 = new TranslateAnimation(0.0f, 0.0f, 0.0f, bitmap3 == null ? 0 : bitmap3.getHeight());
                translateAnimation3.setDuration(300L);
                imageView2.setAnimation(translateAnimation3);
                translateAnimation3.setAnimationListener(new ci(this, imageView2));
                translateAnimation3.setInterpolator(accelerateInterpolator);
                translateAnimation3.start();
            }
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
        if (E() && (this.L instanceof com.baidu.tieba.pb.sub.i)) {
            ((com.baidu.tieba.pb.sub.i) this.L).d();
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
            if (this.L instanceof com.baidu.tieba.pb.sub.i) {
                ((com.baidu.tieba.pb.sub.i) this.L).e();
            }
        }
    }

    public void a(com.baidu.tieba.data.au auVar, int i) {
        if (this.L != null) {
            this.L.B();
            this.L.b(this.G.d());
            this.L.a(auVar, i);
        }
    }

    public void H() {
        if (this.L == null) {
            this.L = new com.baidu.tieba.pb.sub.i(this.k, this.bb, this.U, this.ad, this.V, this.W, this.X);
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

    public void a(com.baidu.tieba.data.au auVar, int i, String str, boolean z, boolean z2) {
        if (this.L != null && (this.L instanceof com.baidu.tieba.pb.sub.i)) {
            com.baidu.tieba.pb.sub.i iVar = (com.baidu.tieba.pb.sub.i) this.L;
            this.L.B();
            this.L.b(this.G.d());
            this.L.a(auVar, i);
            if (z2) {
                iVar.a(str);
            }
            if (!z) {
                iVar.f();
            } else {
                iVar.g();
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
            com.baidu.adp.lib.e.d.b(this.aB, this.k);
            this.aB = null;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this.k);
        builder.setTitle(com.baidu.tieba.x.operation);
        if (z2) {
            builder.setItems(new String[]{this.k.getString(com.baidu.tieba.x.copy)}, onClickListener);
        } else if (!z) {
            builder.setItems(new String[]{this.k.getString(com.baidu.tieba.x.copy), this.k.getString(com.baidu.tieba.x.mark)}, onClickListener);
        } else {
            builder.setItems(new String[]{this.k.getString(com.baidu.tieba.x.copy), this.k.getString(com.baidu.tieba.x.remove_mark)}, onClickListener);
        }
        this.aB = builder.create();
        this.aB.setCanceledOnTouchOutside(true);
        com.baidu.adp.lib.e.d.a(this.aB, this.k);
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
            if (gVar.getItem(firstVisiblePosition) instanceof com.baidu.tieba.data.ai) {
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

    public void a(com.baidu.tieba.data.aj ajVar) {
        this.G.a(ajVar);
        this.G.notifyDataSetChanged();
        if (ajVar == null) {
            a("");
        } else {
            a(new StringBuilder(String.valueOf(ajVar.d().k())).toString());
        }
        ak();
    }

    public void b(com.baidu.tieba.data.aj ajVar) {
        PraiseData g;
        if (this.g != null) {
            boolean ak = ak();
            if (ajVar != null && ajVar.e() != null && ajVar.e().size() > 0) {
                com.baidu.tieba.data.an anVar = ajVar.e().get(0);
                if ((!this.aT || anVar.e() != 1) && (g = ajVar.d().g()) != null && g.getUser() != null && g.getUser().size() > 0) {
                    this.g.setVisibility(0);
                    this.g.setIsFromPb(true);
                    this.g.a(g, ajVar.d().h(), g.getPostId(), true);
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
            if (ajVar != null && ajVar.f() != null && ajVar.f().g() == 0 && this.aT) {
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

    private com.baidu.tieba.data.an a(com.baidu.tieba.data.aj ajVar, boolean z, int i) {
        if (z) {
            if (ajVar == null || ajVar.e() == null || ajVar.e().size() <= 0) {
                return null;
            }
            com.baidu.tieba.data.an anVar = ajVar.e().get(0);
            if (anVar.e() != 1) {
                return d(ajVar);
            }
            return anVar;
        }
        return d(ajVar);
    }

    private com.baidu.tieba.data.an d(com.baidu.tieba.data.aj ajVar) {
        MetaData metaData;
        if (ajVar == null || ajVar.d() == null || ajVar.d().q() == null) {
            return null;
        }
        com.baidu.tieba.data.an anVar = new com.baidu.tieba.data.an();
        MetaData q = ajVar.d().q();
        String userId = q.getUserId();
        HashMap<String, MetaData> d = ajVar.d().d();
        if (d == null || (metaData = d.get(userId)) == null || metaData.getUserId() == null) {
            metaData = q;
        }
        anVar.b(1);
        anVar.a(ajVar.d().A());
        anVar.b(ajVar.d().j());
        anVar.a(ajVar.d().e());
        anVar.a(metaData);
        return anVar;
    }

    private void b(com.baidu.tieba.data.aj ajVar, boolean z, int i) {
        this.q.setVisibility(8);
        com.baidu.tieba.data.an a2 = a(ajVar, z, i);
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
            sparseArray.put(com.baidu.tieba.u.tag_clip_board, a2);
            sparseArray.put(com.baidu.tieba.u.tag_is_subpb, false);
            this.y.setText(com.baidu.tbadk.core.util.ba.a(a2.o_()));
            ajVar.d().D();
            this.r.setVisibility(0);
            this.r.setText(ajVar.d().B());
            b(ajVar);
            if (ajVar.d().E().getGroup_id() != 0) {
                this.aU.setVisibility(0);
                LiveCardData liveCardData = new LiveCardData();
                liveCardData.setPublisherId(ajVar.d().E().getAuthorId());
                liveCardData.setPublisherName(ajVar.d().E().getAuthorName());
                liveCardData.setPublisherPortrait(ajVar.d().E().getPublisherPortrait());
                liveCardData.setGroupId(ajVar.d().E().getGroup_id());
                liveCardData.setIntro(ajVar.d().E().getIntro());
                liveCardData.setLikers(ajVar.d().E().getLikers());
                liveCardData.setListeners(ajVar.d().E().getListeners());
                liveCardData.setName(ajVar.d().E().getName());
                liveCardData.setPortrait(ajVar.d().E().getPortrait());
                liveCardData.setStatus(ajVar.d().E().getStatus());
                liveCardData.setStartTime(ajVar.d().E().getStartTime());
                this.aV.setData(liveCardData);
                this.aV.setStatisticsKey("notice_pb_live");
            } else {
                this.aU.setVisibility(8);
            }
            String userId = ajVar.d().q().getUserId();
            if (userId != null && !userId.equals("0") && userId.equals(a2.g().getUserId())) {
                this.x.setVisibility(0);
            } else {
                this.x.setVisibility(8);
            }
            if (a2.g() != null) {
                int level_id = a2.g().getLevel_id();
                int is_bawu = a2.g().getIs_bawu();
                String bawu_type = a2.g().getBawu_type();
                int i2 = 3;
                if (level_id != 0) {
                    this.u.setVisibility(0);
                    this.u.setText(String.valueOf(level_id));
                    this.u.setBackgroundResource(com.baidu.tbadk.core.util.d.b(level_id));
                    i2 = 2;
                    this.u.setOnClickListener(null);
                } else {
                    this.u.setVisibility(8);
                }
                if (is_bawu != 0) {
                    if (bawu_type.equals("manager")) {
                        this.u.setText((CharSequence) null);
                        this.u.setBackgroundResource(TbadkApplication.m252getInst().getSkinType() == 1 ? com.baidu.tieba.t.pb_manager_1 : com.baidu.tieba.t.pb_manager);
                        this.u.setOnClickListener(this.W);
                    } else if (bawu_type.equals("assist")) {
                        this.u.setText((CharSequence) null);
                        this.u.setBackgroundResource(TbadkApplication.m252getInst().getSkinType() == 1 ? com.baidu.tieba.t.pb_assist_1 : com.baidu.tieba.t.pb_assist);
                        this.u.setOnClickListener(this.W);
                    }
                }
                LinkedList<IconData> iconInfo = a2.g().getIconInfo();
                LinkedList<IconData> tShowInfo = a2.g().getTShowInfo();
                if (this.v != null) {
                    this.v.setOnClickListener(this.W);
                    this.v.a(iconInfo, i2, this.k.getResources().getDimensionPixelSize(com.baidu.tieba.s.pb_icon_width), this.k.getResources().getDimensionPixelSize(com.baidu.tieba.s.pb_icon_height), this.k.getResources().getDimensionPixelSize(com.baidu.tieba.s.pb_icon_margin));
                }
                if (this.w != null) {
                    this.w.setOnClickListener(this.X);
                    this.w.a(tShowInfo, 3, this.k.getResources().getDimensionPixelSize(com.baidu.tieba.s.big_icon_width), this.k.getResources().getDimensionPixelSize(com.baidu.tieba.s.big_icon_height), this.k.getResources().getDimensionPixelSize(com.baidu.tieba.s.big_icon_margin), true);
                }
                this.s.setText(a2.g().getName_show());
                this.s.setTag(a2.g().getUserId());
                int skinType = TbadkApplication.m252getInst().getSkinType();
                if (tShowInfo != null && tShowInfo.size() > 0) {
                    if (skinType == 1) {
                        this.s.setTextColor(this.k.getResources().getColor(com.baidu.tieba.r.cp_cont_h_1));
                    } else {
                        this.s.setTextColor(this.k.getResources().getColor(com.baidu.tieba.r.cp_cont_h));
                    }
                } else if (skinType == 1) {
                    this.s.setTextColor(this.k.getResources().getColor(com.baidu.tieba.r.cp_cont_f_1));
                } else {
                    this.s.setTextColor(this.k.getResources().getColor(com.baidu.tieba.r.cp_cont_f));
                }
                if (!this.bd) {
                    this.t.setVisibility(8);
                }
                this.t.setUserId(a2.g().getUserId());
                this.t.setImageDrawable(null);
                this.t.setTag(a2.g().getUserId());
                this.s.setOnClickListener(this.V);
                this.t.setOnClickListener(this.V);
                this.t.a(a2.g().getPortrait(), 12, false);
            }
        }
    }

    public void a(com.baidu.tieba.data.aj ajVar, int i, int i2, boolean z, int i3) {
        Parcelable c;
        Parcelable c2;
        String sb;
        this.aT = z;
        x();
        b(ajVar, z, i);
        this.G.a(this.aT);
        this.G.a(ajVar);
        this.G.notifyDataSetChanged();
        b(ajVar.c().getName());
        if (this.h != null && ajVar.d() != null) {
            a(new StringBuilder(String.valueOf(ajVar.d().k())).toString());
            if (ajVar.d().g() != null) {
                if (ajVar.d().g().getNum() < 1) {
                    sb = this.k.getResources().getString(com.baidu.tieba.x.frs_item_praise_text);
                } else {
                    sb = new StringBuilder(String.valueOf(ajVar.d().g().getNum())).toString();
                }
                a(sb, ajVar.d().g().getIsLike() == 1);
            }
        }
        if (ajVar.f().f() == 0 && !z) {
            this.m.setNextPage(null);
        } else {
            this.m.setNextPage(this.P);
            this.aS.e();
        }
        if (ajVar.f().g() == 0 && z) {
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
            if (ajVar.f().f() == 0) {
                this.P.a(this.k.getResources().getString(com.baidu.tieba.x.no_more_to_load));
                c(ajVar);
            } else {
                this.P.a(this.k.getResources().getString(com.baidu.tieba.x.pb_load_more));
            }
            this.aS.a(this.k.getResources().getString(com.baidu.tieba.x.btn_show_passed_pb));
        } else {
            this.aS.a(this.k.getResources().getString(com.baidu.tieba.x.btn_show_passed_pb_aftre));
        }
        if (ajVar.d() != null && ajVar.d().q() != null && ajVar.d().q().getType() == 0) {
            this.d.setVisibility(4);
            this.d.setEnabled(false);
        }
        switch (i) {
            case 2:
                this.m.setSelection(i2);
                CompatibleUtile.scrollListViewBy(this.m, -this.p.getHeight(), 0);
                return;
            case 3:
                if (i3 == 1 && (c2 = bp.a().c()) != null) {
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
                } else if (ajVar.e() != null) {
                    if (ajVar.f() != null && ajVar.f().g() != 0) {
                        this.m.setSelection(ajVar.e().size() + 1);
                        return;
                    } else {
                        this.m.setSelection(ajVar.e().size());
                        return;
                    }
                } else {
                    return;
                }
            case 5:
                this.m.setSelection(0);
                return;
            case 6:
                if (i3 == 1 && (c = bp.a().c()) != null) {
                    this.m.onRestoreInstanceState(c);
                    return;
                } else if (z) {
                    this.m.setSelection(0);
                    return;
                } else if (ajVar.e() != null) {
                    if (ajVar.f() != null && ajVar.f().g() != 0) {
                        this.m.setSelection(ajVar.e().size() + 1);
                        return;
                    } else {
                        this.m.setSelection(ajVar.e().size());
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
                this.d.setImageResource(com.baidu.tieba.t.icon_floor_host_s_1);
            } else {
                this.d.setImageResource(com.baidu.tieba.t.icon_floor_host_n_1);
            }
        } else if (z) {
            this.d.setImageResource(com.baidu.tieba.t.icon_floor_host_s);
        } else {
            this.d.setImageResource(com.baidu.tieba.t.icon_floor_host_n);
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
        Drawable drawable;
        if (!this.k.isProgressBarShown()) {
            if (this.H == null) {
                int skinType = TbadkApplication.m252getInst().getSkinType();
                PbActivity pbActivity = this.k;
                View a2 = this.I.a();
                NavigationBar navigationBar = this.b;
                if (skinType == 1) {
                    drawable = this.k.getResources().getDrawable(com.baidu.tieba.t.bg_pull_down_right_n_1);
                } else {
                    drawable = this.k.getResources().getDrawable(com.baidu.tieba.t.bg_pull_down_right_n);
                }
                this.H = new com.baidu.tbadk.core.view.m(pbActivity, a2, navigationBar, drawable, new ck(this));
                this.H.a(this.k, skinType, this.k.getResources().getDrawable(com.baidu.tieba.t.bg_pull_down_right_n), this.k.getResources().getDrawable(com.baidu.tieba.t.bg_pull_down_right_n_1));
            }
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
                this.I.f().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.t.icon_recommend_see_s_1, 0, 0, 0);
            } else {
                this.I.f().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.t.icon_recommend_see_n_1, 0, 0, 0);
            }
            if (z2) {
                this.I.b().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.t.icon_recommend_collect_s_1, 0, 0, 0);
                return;
            } else {
                this.I.b().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.t.icon_recommend_collect_n_1, 0, 0, 0);
                return;
            }
        }
        if (!z) {
            this.I.f().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.t.icon_recommend_see_s, 0, 0, 0);
        } else {
            this.I.f().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.t.icon_recommend_see_n, 0, 0, 0);
        }
        if (z2) {
            this.I.b().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.t.icon_recommend_collect_s, 0, 0, 0);
        } else {
            this.I.b().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.t.icon_recommend_collect_n, 0, 0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ak() {
        boolean z;
        boolean z2 = true;
        View findViewById = this.o.findViewById(com.baidu.tieba.u.pb_head_function_manage_root);
        if (findViewById != null && findViewById.getVisibility() == 0) {
            this.A.setVisibility(0);
            z = true;
        } else {
            this.A.setVisibility(8);
            z = false;
        }
        View findViewById2 = this.o.findViewById(com.baidu.tieba.u.pb_head_function_manage_go_to_live_post);
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

    public boolean a(com.baidu.tieba.data.aj ajVar, boolean z, boolean z2) {
        boolean z3;
        if (ajVar == null) {
            return false;
        }
        if (this.r != null) {
            if (ajVar.d().z() == 0) {
                this.r.setVisibility(0);
                ajVar.d().D();
                this.r.setText(ajVar.d().B());
            } else {
                this.r.setVisibility(8);
            }
        }
        this.aT = z;
        this.aG = (Button) this.o.findViewById(com.baidu.tieba.u.pb_head_function_manage_go_to_live_post);
        com.baidu.tbadk.core.data.n d = ajVar.d();
        if (d != null) {
            a(d.p());
        }
        RelativeLayout relativeLayout = (RelativeLayout) this.o.findViewById(com.baidu.tieba.u.pb_head_function_manage_root);
        Button button = (Button) this.o.findViewById(com.baidu.tieba.u.pb_head_function_manage_commit_top);
        Button button2 = (Button) this.o.findViewById(com.baidu.tieba.u.pb_head_function_manage_cancel_top);
        Button button3 = (Button) this.o.findViewById(com.baidu.tieba.u.pb_head_function_manage_commit_good);
        Button button4 = (Button) this.o.findViewById(com.baidu.tieba.u.pb_head_function_manage_cancel_good);
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
        if (ajVar.l() == 1) {
            if (relativeLayout != null) {
                relativeLayout.setVisibility(0);
                z3 = true;
            } else {
                z3 = false;
            }
            if (ajVar.d().n() == 1) {
                button3.setVisibility(8);
                button4.setVisibility(0);
            } else {
                button3.setVisibility(0);
                button4.setVisibility(8);
            }
            if (ajVar.d().m() == 1) {
                button.setVisibility(8);
                button2.setVisibility(0);
            } else {
                button.setVisibility(0);
                button2.setVisibility(8);
            }
        } else {
            z3 = false;
        }
        return z3;
    }

    @SuppressLint({"CutPasteId"})
    public void a(com.baidu.tieba.data.aj ajVar, boolean z, boolean z2, int i) {
        boolean z3;
        boolean z4;
        boolean z5;
        String userId;
        if (ajVar != null) {
            boolean a2 = a(ajVar, z, z2);
            RelativeLayout relativeLayout = (RelativeLayout) this.o.findViewById(com.baidu.tieba.u.pb_head_function_manage_root);
            Button button = (Button) this.o.findViewById(com.baidu.tieba.u.pb_head_function_manage_delormanage);
            button.setOnClickListener(this.U);
            com.baidu.tieba.data.an a3 = a(ajVar, z, i);
            if (a3 != null) {
                if (ajVar.l() != 0 && a3.g() != null) {
                    String userId2 = a3.g().getUserId();
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
                    String userId3 = ajVar.d().q().getUserId();
                    if (userId3 != null && userId3.equals(TbadkApplication.getCurrentAccount())) {
                        z3 = false;
                        z4 = true;
                        z5 = false;
                    } else if (a3.g() == null || (userId = a3.g().getUserId()) == null || !userId.equals(TbadkApplication.getCurrentAccount())) {
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
                    button.setText(com.baidu.tieba.x.manage);
                    SparseArray sparseArray = new SparseArray();
                    if (a3.g() != null) {
                        sparseArray.put(com.baidu.tieba.u.tag_forbid_user_name, a3.g().getUserName());
                    }
                    sparseArray.put(com.baidu.tieba.u.tag_del_post_id, a3.d());
                    sparseArray.put(com.baidu.tieba.u.tag_del_post_type, 0);
                    sparseArray.put(com.baidu.tieba.u.tag_del_post_is_self, Boolean.valueOf(z3));
                    sparseArray.put(com.baidu.tieba.u.tag_manage_user_identity, Integer.valueOf(ajVar.l()));
                    sparseArray.put(com.baidu.tieba.u.tag_should_manage_visible, true);
                    button.setTag(sparseArray);
                } else if (z4) {
                    relativeLayout.setVisibility(0);
                    button.setVisibility(0);
                    button.setText(com.baidu.tieba.x.delete);
                    SparseArray sparseArray2 = new SparseArray();
                    sparseArray2.put(com.baidu.tieba.u.tag_del_post_id, a3.d());
                    sparseArray2.put(com.baidu.tieba.u.tag_del_post_type, 0);
                    sparseArray2.put(com.baidu.tieba.u.tag_del_post_is_self, Boolean.valueOf(z3));
                    sparseArray2.put(com.baidu.tieba.u.tag_manage_user_identity, Integer.valueOf(ajVar.l()));
                    sparseArray2.put(com.baidu.tieba.u.tag_should_manage_visible, false);
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

    public View R() {
        return this.Q;
    }

    public BdListView S() {
        return this.m;
    }

    public int T() {
        return com.baidu.tieba.u.richText;
    }

    public int U() {
        return com.baidu.tieba.u.user_icon_box;
    }

    public Button V() {
        return (Button) this.o.findViewById(com.baidu.tieba.u.pb_head_function_manage_commit_good);
    }

    public Button W() {
        return (Button) this.o.findViewById(com.baidu.tieba.u.pb_head_function_manage_cancel_good);
    }

    public Button X() {
        return (Button) this.o.findViewById(com.baidu.tieba.u.pb_head_function_manage_commit_top);
    }

    public Button Y() {
        return (Button) this.o.findViewById(com.baidu.tieba.u.pb_head_function_manage_cancel_top);
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

    public void a(com.baidu.tbadk.core.data.l lVar) {
        if (lVar != null) {
            int d = lVar.d();
            int a2 = lVar.a();
            if (this.J == null) {
                this.J = new Dialog(this.k, com.baidu.tieba.y.common_alert_dialog);
                this.J.setCanceledOnTouchOutside(true);
                this.J.setCancelable(true);
                this.M = this.k.getLayoutInflater().inflate(com.baidu.tieba.v.dialog_direct_pager, (ViewGroup) null);
                this.J.setContentView(this.M);
                WindowManager.LayoutParams attributes = this.J.getWindow().getAttributes();
                attributes.gravity = 49;
                attributes.y = com.baidu.adp.lib.util.j.a((Context) this.k, 54.0f);
                attributes.width = (int) (com.baidu.adp.lib.util.j.b(this.k) * 0.9d);
                this.J.getWindow().setAttributes(attributes);
                this.J.setOnKeyListener(new cl(this));
            }
            com.baidu.adp.lib.e.d.a(this.J, this.k);
            ((Button) this.M.findViewById(com.baidu.tieba.u.dialog_button_ok)).setOnClickListener(this.U);
            ((Button) this.M.findViewById(com.baidu.tieba.u.dialog_button_cancel)).setOnClickListener(this.U);
            this.N = (EditText) this.M.findViewById(com.baidu.tieba.u.input_page_number);
            this.N.setText("");
            this.N.setOnFocusChangeListener(new cm(this));
            TextView textView = (TextView) this.M.findViewById(com.baidu.tieba.u.current_page_number);
            if (d <= 0) {
                d = 1;
            }
            textView.setText(MessageFormat.format(this.k.getApplicationContext().getResources().getString(com.baidu.tieba.x.current_page), Integer.valueOf(d), Integer.valueOf(a2 <= 0 ? 1 : a2)));
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
            com.baidu.adp.lib.e.d.a(this.H, this.k);
        }
        com.baidu.adp.lib.util.j.a(this.k, this.N);
        this.h.e();
        if (this.J != null) {
            com.baidu.adp.lib.e.d.b(this.J, this.k);
        }
        if (this.aB != null) {
            com.baidu.adp.lib.e.d.b(this.aB, this.k);
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
            com.baidu.adp.lib.e.d.b(this.ae, this.k);
        }
        if (this.aj != null) {
            com.baidu.adp.lib.e.d.b(this.aj, this.k);
        }
        if (this.at != null) {
            com.baidu.adp.lib.e.d.b(this.at, this.k);
        }
        if (this.ac != null) {
            com.baidu.adp.lib.e.d.b(this.ac, this.k);
        }
    }

    public void a(int i) {
        this.k.getLayoutMode().a(i == 1);
        this.k.getLayoutMode().a((View) this.l);
        this.k.getLayoutMode().a(this.o);
        this.k.getLayoutMode().a(this.Q);
        this.b.c(i);
        e(this.aC);
        this.G.notifyDataSetChanged();
        if (this.L != null) {
            this.L.a(i);
            this.k.getLayoutMode().a(this.P.b());
        }
        if (this.O != null) {
            this.O.a(i);
        }
        if (this.P != null) {
            this.P.d(i);
            this.Q.setBackgroundResource(i == 1 ? com.baidu.tieba.t.pb_foot_more_trans_selector_1 : com.baidu.tieba.t.pb_foot_more_trans_selector);
            this.P.a(i == 1 ? com.baidu.tieba.t.pb_foot_more_trans_selector_1 : com.baidu.tieba.t.pb_foot_more_trans_selector);
        }
        if (this.aS != null) {
            this.aS.d(i);
            this.aS.a(i == 1 ? com.baidu.tieba.r.cp_bg_line_e_1 : com.baidu.tieba.r.cp_bg_line_e);
            this.aR.setBackgroundResource(i == 1 ? com.baidu.tieba.r.cp_bg_line_e_1 : com.baidu.tieba.r.cp_bg_line_e);
        }
        this.h.c(i);
        if (this.aE != null) {
            if (i == 1) {
                this.aE.setBackgroundResource(com.baidu.tieba.r.cp_bg_line_d_1);
            } else {
                this.aE.setBackgroundResource(com.baidu.tieba.r.cp_bg_line_d);
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

    public void a(com.baidu.tbadk.core.view.q qVar) {
        this.ab = qVar;
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

    public void c(com.baidu.tieba.data.aj ajVar) {
        if (ajVar != null) {
            ArrayList<com.baidu.tieba.data.an> e = ajVar.e();
            if (e.size() == 1) {
                com.baidu.tieba.data.an anVar = e.get(0);
                if (anVar.n() < anVar.c().size()) {
                    this.m.setNextPage(null);
                    return;
                } else {
                    this.m.setNextPage(this.P);
                    return;
                }
            }
            this.m.setNextPage(this.P);
        }
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
