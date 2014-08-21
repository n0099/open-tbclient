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
    private TextView A;
    private View B;
    private View C;
    private View D;
    private View E;
    private View F;
    private RelativeLayout G;
    private bf H;
    private bo J;
    private com.baidu.tieba.view.y P;
    private PbListView Q;
    private View R;
    private View.OnClickListener V;
    private View aF;
    private com.baidu.tbadk.editortool.w aI;
    private View aJ;
    private View aK;
    private LinearLayout aL;
    private TextView aM;
    private LinearLayout aN;
    private ImageView aO;
    private TextView aP;
    private View aV;
    private LiveBroadcastCard aW;
    private View.OnClickListener ae;
    NavigationBar b;
    private bd ba;
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
    private ImageView v;
    private UserIconBox w;
    private UserIconBox x;
    private ImageView y;
    private TextView z;
    private com.baidu.tbadk.core.view.n I = null;
    private Dialog K = null;
    private Dialog L = null;
    private com.baidu.tieba.pb.sub.l M = null;
    private View N = null;
    private EditText O = null;
    private FrameLayout S = null;
    private View T = null;
    private DialogInterface.OnClickListener U = null;
    private View.OnClickListener W = null;
    private View.OnClickListener X = null;
    private View.OnClickListener Y = null;
    private AbsListView.OnScrollListener Z = null;
    private com.baidu.tbadk.widget.richText.s aa = null;
    private com.baidu.tbadk.widget.richText.r ab = null;
    private com.baidu.tbadk.core.view.r ac = null;
    private Dialog ad = null;
    private Dialog af = null;
    private View ag = null;
    private Button ah = null;
    private Button ai = null;
    private TextView aj = null;
    private Dialog ak = null;
    private View al = null;
    private int am = 0;
    private RadioGroup an = null;
    private RadioButton ao = null;
    private RadioButton ap = null;
    private RadioButton aq = null;
    private Button ar = null;
    private Button as = null;
    private TextView at = null;
    private Dialog au = null;
    private View av = null;
    private RadioGroup aw = null;
    private CompoundButton.OnCheckedChangeListener ax = null;
    private Button ay = null;
    private Button az = null;
    private String aA = null;
    private cu aB = null;
    private Dialog aC = null;
    private boolean aD = false;
    private ScrollView aG = null;
    private Button aH = null;
    private boolean aQ = true;
    private LinearLayout aR = null;
    private View aS = null;
    private PbListView aT = null;
    private boolean aU = false;
    private boolean aX = true;
    private com.baidu.tieba.bubble.t aY = new bt(this);
    private final View.OnClickListener aZ = new cc(this);
    private View.OnLongClickListener bb = null;
    private boolean bc = false;
    private final List<TbImageView> bd = new ArrayList();
    private boolean be = true;
    private com.baidu.tieba.c.a aE = new com.baidu.tieba.c.a(new cn(this));

    public NoNetworkView a() {
        return this.n;
    }

    public void b() {
        this.aQ = true;
        if (this.h != null) {
            this.h.setVisibility(8);
        }
        if (this.aK != null) {
            this.aK.setVisibility(0);
            this.aJ.setVisibility(0);
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
        if (this.H.getItemViewType(i7) != 0) {
            i7++;
        }
        return (com.baidu.tieba.data.an) this.H.getItem(i7);
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
        this.A = null;
        this.g = null;
        this.B = null;
        this.C = null;
        this.D = null;
        this.E = null;
        this.F = null;
        this.H = null;
        this.J = null;
        this.P = null;
        this.Q = null;
        this.R = null;
        this.V = null;
        this.ae = null;
        this.aF = null;
        this.aJ = null;
        this.aK = null;
        this.aL = null;
        this.aM = null;
        this.aN = null;
        this.aO = null;
        this.aP = null;
        this.k = pbActivity;
        this.V = onClickListener;
        this.l = (FrameLayout) com.baidu.adp.lib.e.b.a().a(this.k, com.baidu.tieba.v.new_pb_activity, null);
        this.k.addContentView(this.l, new FrameLayout.LayoutParams(-1, -1));
        this.G = (RelativeLayout) this.k.findViewById(com.baidu.tieba.u.title_wrapper);
        this.n = (NoNetworkView) this.k.findViewById(com.baidu.tieba.u.view_no_network);
        this.m = (BdListView) this.k.findViewById(com.baidu.tieba.u.new_pb_list);
        this.aF = new View(this.k);
        this.aF.setBackgroundResource(com.baidu.tieba.r.cp_bg_line_d);
        this.aF.setLayoutParams(new AbsListView.LayoutParams(-1, this.k.getResources().getDimensionPixelSize(com.baidu.tieba.s.navi_height)));
        this.m.addHeaderView(this.aF);
        View view = new View(this.k);
        view.setLayoutParams(new AbsListView.LayoutParams(-1, this.k.getResources().getDimensionPixelSize(com.baidu.tieba.s.pb_editor_height)));
        this.m.addFooterView(view);
        this.b = (NavigationBar) this.k.findViewById(com.baidu.tieba.u.view_navigation_bar);
        this.b.setOnClickListener(new co(this));
        this.i = this.b.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.V);
        this.c = (TextView) this.b.a(NavigationBar.ControlAlign.HORIZONTAL_CENTER, com.baidu.tieba.v.pb_title_textview, (View.OnClickListener) null);
        this.f = (ImageView) this.b.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.v.widget_nb_add_floor, this.V);
        this.d = (ImageView) this.b.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.v.nb_item_floor_host, this.V);
        this.e = (ImageView) this.b.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.v.nb_item_floor_more, this.V);
        this.J = new bo(this.k, this.V);
        this.h = (PbEditor) this.k.findViewById(com.baidu.tieba.u.pb_editor_view);
        this.h.setFrom(1);
        this.h.a(false);
        this.h.setVisibility(8);
        this.aK = this.k.findViewById(com.baidu.tieba.u.pb_editor_tool_comment);
        this.aL = (LinearLayout) this.k.findViewById(com.baidu.tieba.u.pb_editor_tool_comment_reply);
        this.aN = (LinearLayout) this.k.findViewById(com.baidu.tieba.u.pb_editor_tool_comment_praise);
        this.aJ = this.k.findViewById(com.baidu.tieba.u.pb_editor_tool_comment_line);
        this.aM = (TextView) this.k.findViewById(com.baidu.tieba.u.pb_editor_tool_comment_reply_text);
        this.aO = (ImageView) this.k.findViewById(com.baidu.tieba.u.pb_editor_tool_comment_praise_icon);
        this.aP = (TextView) this.k.findViewById(com.baidu.tieba.u.pb_editor_tool_comment_praise_text);
        this.aL.setOnClickListener(new cp(this));
        this.aN.setOnClickListener(this.V);
        this.aN.setOnTouchListener(this.k);
        J();
        this.o = com.baidu.adp.lib.e.b.a().a(this.k, com.baidu.tieba.v.new_pb_header_item, null);
        this.q = (ColumnLayout) this.o.findViewById(com.baidu.tieba.u.pb_head_owner_root);
        this.q.setOnLongClickListener(this.bb);
        this.q.setOnTouchListener(this.aE);
        this.q.setVisibility(8);
        this.o.setOnTouchListener(this.aE);
        this.r = (TextView) this.o.findViewById(com.baidu.tieba.u.pb_head_post_title);
        this.r.setTextSize(TbConfig.getContentSizeOfPostTitle());
        this.r.setVisibility(8);
        this.s = (TextView) this.q.findViewById(com.baidu.tieba.u.pb_head_owner_info_user_name);
        this.t = (HeadImageView) this.q.findViewById(com.baidu.tieba.u.pb_head_owner_photo);
        if (!this.be) {
            this.t.setVisibility(8);
        }
        this.u = (TextView) this.q.findViewById(com.baidu.tieba.u.pb_head_owner_info_user_rank);
        this.v = (ImageView) this.q.findViewById(com.baidu.tieba.u.pb_head_owner_info_user_gender);
        this.w = (UserIconBox) this.q.findViewById(com.baidu.tieba.u.pb_head_owner_info_user_icon);
        this.x = (UserIconBox) this.q.findViewById(com.baidu.tieba.u.pb_head_owner_info_tshow_icon);
        this.y = (ImageView) this.q.findViewById(com.baidu.tieba.u.pb_head_owner_info_floor_owner);
        this.z = (TextView) this.q.findViewById(com.baidu.tieba.u.pb_head_owner_info_time);
        this.A = (TextView) this.o.findViewById(com.baidu.tieba.u.pb_head_reverse_hint);
        this.A.setOnClickListener(this.V);
        this.A.setVisibility(8);
        this.g = (FrsPraiseView) this.o.findViewById(com.baidu.tieba.u.pb_head_praise_view);
        this.g.setIsFromPb(true);
        this.p = this.o.findViewById(com.baidu.tieba.u.pb_head_function_manage_root);
        this.B = this.o.findViewById(com.baidu.tieba.u.new_pb_header_item_line_above_manage);
        this.C = this.o.findViewById(com.baidu.tieba.u.new_pb_header_item_line_above_livepost);
        this.D = this.o.findViewById(com.baidu.tieba.u.new_pb_header_item_line_below_livepost);
        this.E = this.o.findViewById(com.baidu.tieba.u.new_pb_header_item_line_above_praise);
        this.F = this.o.findViewById(com.baidu.tieba.u.new_pb_header_item_line_above_showpassed);
        this.aV = this.o.findViewById(com.baidu.tieba.u.live_card_layout);
        this.aW = (LiveBroadcastCard) this.o.findViewById(com.baidu.tieba.u.item_card);
        this.o.setOnLongClickListener(new cq(this));
        aj();
        this.H = new bf(this.k);
        this.H.e(this.V);
        this.H.a(this.aE);
        this.H.a(this.aa);
        this.ae = new cr(this);
        this.H.a(this.ae);
        this.m.setAdapter((ListAdapter) this.H);
        this.m.addHeaderView(this.o);
        this.P = new com.baidu.tieba.view.y(this.k);
        this.P.a();
        this.Q = new PbListView(this.k);
        this.R = this.Q.b().findViewById(com.baidu.tieba.u.pb_more_view);
        int skinType = TbadkApplication.m252getInst().getSkinType();
        if (this.R != null) {
            this.R.setOnClickListener(this.V);
            this.R.setBackgroundResource(skinType == 1 ? com.baidu.tieba.t.pb_foot_more_trans_selector_1 : com.baidu.tieba.t.pb_foot_more_trans_selector);
        }
        this.Q.c();
        this.Q.a(skinType == 1 ? com.baidu.tieba.t.pb_foot_more_trans_selector_1 : com.baidu.tieba.t.pb_foot_more_trans_selector);
        this.Q.c(com.baidu.tieba.t.pb_foot_more_trans_selector);
        this.c.setOnClickListener(this.V);
    }

    public void a(String str) {
        if (this.aM != null) {
            if (!TextUtils.isEmpty(str) && !"0".equals(str)) {
                this.aM.setText(str);
            } else {
                this.aM.setText(this.k.getString(com.baidu.tieba.x.reply));
            }
        }
    }

    public void a(String str, boolean z) {
        if (this.aP != null) {
            this.aP.setText(str);
            int skinType = TbadkApplication.m252getInst().getSkinType();
            if (z) {
                if (skinType == 1) {
                    this.aO.setImageResource(com.baidu.tieba.t.icon_hand_click_1);
                } else {
                    this.aO.setImageResource(com.baidu.tieba.t.icon_hand_click);
                }
            } else if (skinType == 1) {
                this.aO.setImageResource(com.baidu.tieba.t.icon_hand_normal_1);
            } else {
                this.aO.setImageResource(com.baidu.tieba.t.icon_hand_normal);
            }
        }
    }

    public View d() {
        return this.aN;
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
        if (this.G != null && this.h != null && view != null) {
            if (this.aQ) {
                z = this.aK.getVisibility() == 0;
            } else {
                z = this.h.getVisibility() == 0;
            }
            boolean z2 = this.G.getVisibility() == 0;
            if (z2) {
                Animation loadAnimation = AnimationUtils.loadAnimation(view.getContext(), com.baidu.tieba.o.top_fold_up);
                loadAnimation.setAnimationListener(new ct(this));
                this.G.startAnimation(loadAnimation);
            } else {
                Animation loadAnimation2 = AnimationUtils.loadAnimation(view.getContext(), com.baidu.tieba.o.top_fold_down);
                loadAnimation2.setAnimationListener(new bu(this));
                this.G.startAnimation(loadAnimation2);
            }
            if (z) {
                if (z2) {
                    this.h.f();
                    Animation loadAnimation3 = AnimationUtils.loadAnimation(view.getContext(), com.baidu.tieba.o.bottom_fold_down);
                    loadAnimation3.setAnimationListener(new bv(this));
                    if (this.aQ) {
                        this.aK.startAnimation(loadAnimation3);
                    } else {
                        this.h.startAnimation(loadAnimation3);
                    }
                }
            } else if (!z2) {
                Animation loadAnimation4 = AnimationUtils.loadAnimation(view.getContext(), com.baidu.tieba.o.bottom_fold_up);
                loadAnimation4.setAnimationListener(new bw(this));
                if (this.aQ) {
                    this.aK.startAnimation(loadAnimation4);
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
        if (this.M != null) {
            this.M.l();
        }
    }

    public bo h() {
        return this.J;
    }

    public void i() {
        if (this.M != null) {
            this.M.m();
        }
    }

    public VoiceData.VoiceModel j() {
        if (this.M != null) {
            return this.M.o();
        }
        return null;
    }

    public void k() {
        if (this.M != null) {
            this.M.p();
        }
    }

    public TextView l() {
        if (this.M == null || !(this.M instanceof com.baidu.tieba.pb.sub.i)) {
            return null;
        }
        return ((com.baidu.tieba.pb.sub.i) this.M).c();
    }

    public bf m() {
        return this.H;
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
            this.aH.setText(string);
            this.aH.setVisibility(0);
            this.aH.setOnClickListener(this.V);
            ak();
        }
    }

    private void aj() {
        this.aR = (LinearLayout) this.o.findViewById(com.baidu.tieba.u.btn_show_passed_pb);
        this.aT = new PbListView(this.k, PbListView.IconType.ICON_UP_WARD);
        this.aS = this.aT.a();
        this.aT.a(this.k.getResources().getString(com.baidu.tieba.x.btn_show_passed_pb));
        this.aS.setOnClickListener(this.aZ);
        this.aR.addView(this.aS);
        this.aR.requestLayout();
        this.aR.invalidate();
        int skinType = TbadkApplication.m252getInst().getSkinType();
        this.aS.setBackgroundResource(skinType == 1 ? com.baidu.tieba.r.cp_bg_line_e_1 : com.baidu.tieba.r.cp_bg_line_e);
        this.aT.a(skinType == 1 ? com.baidu.tieba.r.cp_bg_line_e_1 : com.baidu.tieba.r.cp_bg_line_e);
        this.aT.c(com.baidu.tieba.r.cp_bg_line_e);
        ak();
    }

    public void a(View view) {
        if (this.ad == null) {
            this.ad = new Dialog(this.k, com.baidu.tieba.y.common_alert_dialog);
            this.ad.setCanceledOnTouchOutside(true);
            this.ad.setCancelable(true);
            this.ad.setContentView(com.baidu.adp.lib.e.b.a().a(this.k, com.baidu.tieba.v.forum_manage_dialog, null));
            WindowManager.LayoutParams attributes = this.ad.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.j.b(this.k) * 0.9d);
            this.ad.getWindow().setAttributes(attributes);
        }
        Button button = (Button) this.ad.findViewById(com.baidu.tieba.u.del_post_btn);
        Button button2 = (Button) this.ad.findViewById(com.baidu.tieba.u.forbid_user_btn);
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
            com.baidu.adp.lib.e.e.a(this.ad, this.k);
        }
    }

    public void a(bd bdVar) {
        this.ba = bdVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        if (this.af == null) {
            this.af = new Dialog(this.k, com.baidu.tieba.y.common_alert_dialog);
            this.af.setCanceledOnTouchOutside(true);
            this.af.setCancelable(true);
            this.ag = com.baidu.adp.lib.e.b.a().a(this.k, com.baidu.tieba.v.del_post, null);
            this.af.setContentView(this.ag);
            WindowManager.LayoutParams attributes = this.af.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.j.b(this.k) * 0.9d);
            this.af.getWindow().setAttributes(attributes);
            this.ah = (Button) this.ag.findViewById(com.baidu.tieba.u.dialog_button_ok);
            this.ah.setOnClickListener(this.V);
            this.ai = (Button) this.ag.findViewById(com.baidu.tieba.u.dialog_button_cancel);
            this.ai.setOnClickListener(new bz(this));
            this.aj = (TextView) this.ag.findViewById(com.baidu.tieba.u.confirm_text);
        }
        SparseArray sparseArray = (SparseArray) this.ah.getTag();
        if (sparseArray == null) {
            sparseArray = new SparseArray();
            this.ah.setTag(sparseArray);
        }
        sparseArray.put(com.baidu.tieba.u.tag_del_post_id, str);
        sparseArray.put(com.baidu.tieba.u.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(com.baidu.tieba.u.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(com.baidu.tieba.u.tag_del_post_is_self, Boolean.valueOf(z));
        if (i == 0) {
            this.aj.setText(com.baidu.tieba.x.del_thread_confirm);
        } else {
            this.aj.setText(com.baidu.tieba.x.del_post_confirm);
        }
        com.baidu.adp.lib.e.e.a(this.af, this.k);
    }

    public void a(ArrayList<com.baidu.tbadk.core.data.h> arrayList) {
        if (this.au == null) {
            this.au = new Dialog(this.k, com.baidu.tieba.y.common_alert_dialog);
            this.au.setCanceledOnTouchOutside(true);
            this.au.setCancelable(true);
            this.av = com.baidu.adp.lib.e.b.a().a(this.k, com.baidu.tieba.v.commit_good, null);
            this.aG = (ScrollView) this.av.findViewById(com.baidu.tieba.u.good_scroll);
            this.au.setContentView(this.av);
            WindowManager.LayoutParams attributes = this.au.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.j.b(this.k) * 0.9d);
            this.au.getWindow().setAttributes(attributes);
            this.ax = new ca(this);
            this.aw = (RadioGroup) this.av.findViewById(com.baidu.tieba.u.good_class_group);
            this.az = (Button) this.av.findViewById(com.baidu.tieba.u.dialog_button_cancel);
            this.az.setOnClickListener(new cb(this));
            this.ay = (Button) this.av.findViewById(com.baidu.tieba.u.dialog_button_ok);
            this.ay.setOnClickListener(this.V);
        }
        this.aw.removeAllViews();
        RadioButton radioButton = (RadioButton) com.baidu.adp.lib.e.b.a().a(this.k, com.baidu.tieba.v.good_class_radio_button, null);
        radioButton.setTag("0");
        radioButton.setText(this.k.getString(com.baidu.tieba.x.def_good_class));
        radioButton.setOnCheckedChangeListener(this.ax);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, -2);
        layoutParams.setMargins(com.baidu.adp.lib.util.j.a((Context) this.k, 10.0f), com.baidu.adp.lib.util.j.a((Context) this.k, 5.0f), com.baidu.adp.lib.util.j.a((Context) this.k, 10.0f), com.baidu.adp.lib.util.j.a((Context) this.k, 5.0f));
        this.aw.addView(radioButton, layoutParams);
        this.aw.requestLayout();
        this.aw.check(radioButton.getId());
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                RadioButton radioButton2 = (RadioButton) com.baidu.adp.lib.e.b.a().a(this.k, com.baidu.tieba.v.good_class_radio_button, null);
                radioButton2.setTag(String.valueOf(arrayList.get(i2).b()));
                radioButton2.setText(arrayList.get(i2).a());
                radioButton2.setOnCheckedChangeListener(this.ax);
                this.aw.addView(radioButton2, layoutParams);
                this.aw.requestLayout();
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.aG.getLayoutParams();
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
            this.aG.setLayoutParams(layoutParams2);
            this.aG.removeAllViews();
            this.aG.addView(this.aw);
        }
        com.baidu.adp.lib.e.e.a(this.au, this.k);
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
        this.l.removeView(this.S);
    }

    public View q() {
        if (this.ag != null) {
            return this.ag.findViewById(com.baidu.tieba.u.dialog_button_ok);
        }
        return null;
    }

    public View r() {
        if (this.av != null) {
            return this.av.findViewById(com.baidu.tieba.u.dialog_button_ok);
        }
        return null;
    }

    public String s() {
        return this.aA;
    }

    public View t() {
        if (this.M != null) {
            return this.M.w();
        }
        return null;
    }

    public void u() {
        this.k.showProgressBar();
        com.baidu.adp.lib.util.j.a(this.k, this.h.getEditText());
    }

    public void v() {
        if (this.M != null) {
            this.M.z();
        } else {
            this.k.showProgressBar();
        }
    }

    public void a(boolean z) {
        if (this.M != null) {
            this.M.A();
        } else {
            this.k.hideProgressBar();
        }
        ad();
        if (z) {
            this.h.getEditText().setText("");
            this.h.b();
            this.h.m();
            if (this.M != null) {
                this.M.u();
            }
        }
    }

    public void w() {
        this.Q.d();
    }

    public void x() {
        this.k.hideProgressBar();
        this.Q.e();
        this.aT.e();
        this.m.d();
        ak();
    }

    public void y() {
        this.m.d();
        this.aR.setVisibility(8);
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
        } else if (this.M != null) {
            this.M.b((String) null);
        }
    }

    public void z() {
        if (!this.h.h()) {
            b(false);
        }
    }

    public void A() {
        if (E() && this.M != null) {
            this.M.j();
        }
    }

    public void B() {
        if (this.M == null) {
            this.M = new com.baidu.tieba.pb.sub.l(this.k, this.bc, this.V, this.ae, this.W, this.X, this.Y);
            this.M.a(this.aI);
            this.M.a(this.Z);
            this.M.c(this.H.b());
            this.M.b(this.H.c());
            this.T = this.M.n();
            this.M.a(this.aa);
            this.M.a(this.ab);
            this.M.a(this.H.a());
        }
        this.T.setVisibility(0);
        this.M.d(this.aX);
        this.M.y();
        this.l.addView(this.T);
        al();
    }

    public void a(com.baidu.tbadk.editortool.w wVar) {
        if (wVar != null) {
            this.h.setOnActionListener(new cd(this, wVar));
            this.aI = wVar;
            if (this.M != null) {
                this.M.a(wVar);
            }
        }
    }

    public void a(cu cuVar) {
        this.aB = cuVar;
    }

    public void a(boolean z, com.baidu.tieba.data.au auVar, boolean z2, String str, String str2, View view, int i) {
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap bitmap3;
        if (auVar != null && view != null) {
            TiebaStatic.eventStat(this.k, "pb_tosubpb", "pbclick", 1, new Object[0]);
            if (this.M == null) {
                this.M = new com.baidu.tieba.pb.sub.l(this.k, this.bc, this.V, this.ae, this.W, this.X, this.Y);
                this.M.a(this.aI);
                this.M.a(this.Z);
                this.M.c(this.H.b());
                this.M.b(this.H.c());
                this.T = this.M.n();
                this.M.a(this.aa);
                this.M.a(this.ab);
                this.M.a(this.H.a());
            }
            this.M.b(this.H.d());
            this.M.a(auVar, i);
            this.M.d(this.aX);
            if (str2 != null && !str2.equals("")) {
                this.M.c(str2);
            } else {
                this.M.c(1);
            }
            int i2 = 0;
            if (this.G.getVisibility() == 0) {
                i2 = this.G.getHeight();
            }
            int top = view.getTop();
            int bottom = view.getBottom();
            if (!z) {
                this.M.q();
            }
            int height = ((view.getHeight() + this.k.getResources().getDimensionPixelSize(com.baidu.tieba.s.subpb_listitem_packup_min_height)) - this.k.getResources().getDimensionPixelSize(com.baidu.tieba.s.pb_list_item_border_bottom_margin_top)) - this.l.getHeight();
            if (height > 0) {
                top += height;
            }
            AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator(1.5f);
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, top, 0.0f);
            translateAnimation.setDuration(300L);
            this.T.setAnimation(translateAnimation);
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
            this.T.setVisibility(0);
            if (this.T.getParent() == this.l) {
                this.l.removeView(this.T);
            }
            this.l.addView(this.T);
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
        this.bb = onLongClickListener;
        this.H.a(onLongClickListener);
        if (this.M != null) {
            this.M.a(onLongClickListener);
        }
    }

    public void C() {
        if (E()) {
            this.M.r();
        }
    }

    public void D() {
        if (E() && (this.M instanceof com.baidu.tieba.pb.sub.i)) {
            ((com.baidu.tieba.pb.sub.i) this.M).d();
        }
    }

    public boolean E() {
        return (this.T == null || this.T.getVisibility() == 8) ? false : true;
    }

    public void F() {
        if (this.T != null) {
            this.T.setVisibility(8);
            this.l.removeView(this.T);
            this.M.s();
        }
        ad();
        am();
    }

    public void G() {
        if (this.M != null) {
            this.M.B();
            if (this.M instanceof com.baidu.tieba.pb.sub.i) {
                ((com.baidu.tieba.pb.sub.i) this.M).e();
            }
        }
    }

    public void a(com.baidu.tieba.data.au auVar, int i) {
        if (this.M != null) {
            this.M.B();
            this.M.b(this.H.d());
            this.M.a(auVar, i);
        }
    }

    public void H() {
        if (this.M == null) {
            this.M = new com.baidu.tieba.pb.sub.i(this.k, this.bc, this.V, this.ae, this.W, this.X, this.Y);
            this.M.a(this.aI);
            this.M.a(this.Z);
            this.M.c(this.H.b());
            this.M.b(this.H.c());
            this.T = this.M.n();
            this.M.a(this.aa);
            this.M.a(this.ab);
            this.M.a(this.H.a());
        }
        this.T.setVisibility(0);
        this.M.y();
        this.l.addView(this.T);
        al();
    }

    public void a(com.baidu.tieba.data.au auVar, int i, String str, boolean z, boolean z2) {
        if (this.M != null && (this.M instanceof com.baidu.tieba.pb.sub.i)) {
            com.baidu.tieba.pb.sub.i iVar = (com.baidu.tieba.pb.sub.i) this.M;
            this.M.B();
            this.M.b(this.H.d());
            this.M.a(auVar, i);
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
        if (this.M != null) {
            this.M.a(arrayList);
        }
    }

    public void I() {
        this.bc = true;
        this.h.q();
    }

    public void J() {
        this.bc = false;
        this.h.r();
    }

    public void a(DialogInterface.OnClickListener onClickListener, boolean z, boolean z2) {
        if (this.aC != null) {
            com.baidu.adp.lib.e.e.b(this.aC, this.k);
            this.aC = null;
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
        this.aC = builder.create();
        this.aC.setCanceledOnTouchOutside(true);
        com.baidu.adp.lib.e.e.a(this.aC, this.k);
    }

    public void c(boolean z) {
        this.h.setAudioFocusable(z);
    }

    public void d(boolean z) {
        if (this.M != null) {
            this.M.a(z);
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
            return Integer.parseInt(this.O.getText().toString(), 10);
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
        if (this.M == null) {
            return null;
        }
        return this.M.x();
    }

    public String P() {
        if (this.M != null) {
            return this.M.t();
        }
        return null;
    }

    public void a(com.baidu.tieba.data.aj ajVar) {
        this.H.a(ajVar);
        this.H.notifyDataSetChanged();
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
                if ((!this.aU || anVar.e() != 1) && (g = ajVar.d().g()) != null && g.getUser() != null && g.getUser().size() > 0) {
                    this.g.setVisibility(0);
                    this.g.setIsFromPb(true);
                    this.g.a(g, ajVar.d().h(), g.getPostId(), true);
                    this.E.setVisibility(0);
                    if (this.g.getVisibility() == 0) {
                        this.F.setVisibility(0);
                        return;
                    }
                    return;
                }
            }
            this.g.setVisibility(8);
            this.E.setVisibility(8);
            if (ajVar != null && ajVar.f() != null && ajVar.f().g() == 0 && this.aU) {
                this.E.setVisibility(8);
                if (ak) {
                    this.D.setVisibility(0);
                    return;
                } else {
                    this.D.setVisibility(8);
                    return;
                }
            }
            this.E.setVisibility(0);
            this.D.setVisibility(8);
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
                this.A.setVisibility(8);
            } else {
                this.A.setVisibility(0);
            }
            this.q.setVisibility(0);
            SparseArray sparseArray = (SparseArray) this.q.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.q.setTag(sparseArray);
            }
            sparseArray.put(com.baidu.tieba.u.tag_clip_board, a2);
            sparseArray.put(com.baidu.tieba.u.tag_is_subpb, false);
            this.z.setText(com.baidu.tbadk.core.util.ba.a(a2.o_()));
            ajVar.d().D();
            this.r.setVisibility(0);
            this.r.setText(ajVar.d().B());
            b(ajVar);
            if (ajVar.d().E().getGroup_id() != 0) {
                this.aV.setVisibility(0);
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
                this.aW.setData(liveCardData);
                this.aW.setStatisticsKey("notice_pb_live");
            } else {
                this.aV.setVisibility(8);
            }
            String userId = ajVar.d().q().getUserId();
            if (userId != null && !userId.equals("0") && userId.equals(a2.g().getUserId())) {
                this.y.setVisibility(0);
            } else {
                this.y.setVisibility(8);
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
                        this.u.setOnClickListener(this.X);
                    } else if (bawu_type.equals("assist")) {
                        this.u.setText((CharSequence) null);
                        this.u.setBackgroundResource(TbadkApplication.m252getInst().getSkinType() == 1 ? com.baidu.tieba.t.pb_assist_1 : com.baidu.tieba.t.pb_assist);
                        this.u.setOnClickListener(this.X);
                    }
                }
                if (a2.g().getGender() == 2) {
                    this.v.setImageResource(TbadkApplication.m252getInst().getSkinType() == 1 ? com.baidu.tieba.t.icon_pop_girl_square_1 : com.baidu.tieba.t.icon_pop_girl_square);
                    this.v.setVisibility(0);
                } else {
                    this.v.setVisibility(8);
                }
                LinkedList<IconData> iconInfo = a2.g().getIconInfo();
                LinkedList<IconData> tShowInfo = a2.g().getTShowInfo();
                if (this.w != null) {
                    this.w.setOnClickListener(this.X);
                    this.w.a(iconInfo, i2, this.k.getResources().getDimensionPixelSize(com.baidu.tieba.s.pb_icon_width), this.k.getResources().getDimensionPixelSize(com.baidu.tieba.s.pb_icon_height), this.k.getResources().getDimensionPixelSize(com.baidu.tieba.s.pb_icon_margin));
                }
                if (this.x != null) {
                    this.x.setOnClickListener(this.Y);
                    this.x.a(tShowInfo, 3, this.k.getResources().getDimensionPixelSize(com.baidu.tieba.s.big_icon_width), this.k.getResources().getDimensionPixelSize(com.baidu.tieba.s.big_icon_height), this.k.getResources().getDimensionPixelSize(com.baidu.tieba.s.big_icon_margin), true);
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
                if (!this.be) {
                    this.t.setVisibility(8);
                }
                this.t.setUserId(a2.g().getUserId());
                this.t.setImageDrawable(null);
                this.t.setTag(a2.g().getUserId());
                this.s.setOnClickListener(this.W);
                this.t.setOnClickListener(this.W);
                this.t.a(a2.g().getPortrait(), 12, false);
            }
        }
    }

    public void a(com.baidu.tieba.data.aj ajVar, int i, int i2, boolean z, int i3) {
        Parcelable c;
        Parcelable c2;
        String sb;
        this.aU = z;
        x();
        b(ajVar, z, i);
        this.H.a(this.aU);
        this.H.a(ajVar);
        this.H.notifyDataSetChanged();
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
            this.m.setNextPage(this.Q);
            this.aT.e();
        }
        if (ajVar.f().g() == 0 && z) {
            this.m.setPullRefresh(null);
            this.aR.setVisibility(8);
        } else {
            this.m.setPullRefresh(this.P);
            if (this.P != null) {
                this.P.a(TbadkApplication.m252getInst().getSkinType());
            }
            this.aR.setVisibility(0);
            this.aT.e();
        }
        ak();
        if (z) {
            if (ajVar.f().f() == 0) {
                this.Q.a(this.k.getResources().getString(com.baidu.tieba.x.no_more_to_load));
                c(ajVar);
            } else {
                this.Q.a(this.k.getResources().getString(com.baidu.tieba.x.pb_load_more));
            }
            this.aT.a(this.k.getResources().getString(com.baidu.tieba.x.btn_show_passed_pb));
        } else {
            this.aT.a(this.k.getResources().getString(com.baidu.tieba.x.btn_show_passed_pb_aftre));
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
        this.aD = z;
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
        if (this.Q != null) {
            this.Q.e();
        }
        if (this.aT != null) {
            this.aT.e();
        }
    }

    public void a(boolean z, boolean z2) {
        Drawable drawable;
        if (!this.k.isProgressBarShown()) {
            if (this.I == null) {
                int skinType = TbadkApplication.m252getInst().getSkinType();
                PbActivity pbActivity = this.k;
                View a2 = this.J.a();
                NavigationBar navigationBar = this.b;
                if (skinType == 1) {
                    drawable = this.k.getResources().getDrawable(com.baidu.tieba.t.bg_pull_down_right_n_1);
                } else {
                    drawable = this.k.getResources().getDrawable(com.baidu.tieba.t.bg_pull_down_right_n);
                }
                this.I = new com.baidu.tbadk.core.view.n(pbActivity, a2, navigationBar, drawable, new ck(this));
                this.I.a(this.k, skinType, this.k.getResources().getDrawable(com.baidu.tieba.t.bg_pull_down_right_n), this.k.getResources().getDrawable(com.baidu.tieba.t.bg_pull_down_right_n_1));
            }
            if (com.baidu.tbadk.coreExtra.share.i.a(this.k)) {
                this.J.c().setVisibility(0);
                this.J.d().setVisibility(0);
            } else {
                this.J.c().setVisibility(8);
                this.J.d().setVisibility(8);
            }
            b(z, z2);
            this.I.b();
        }
    }

    private void b(boolean z, boolean z2) {
        if (TbadkApplication.m252getInst().getSkinType() == 1) {
            if (!z) {
                this.J.f().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.t.icon_recommend_see_s_1, 0, 0, 0);
            } else {
                this.J.f().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.t.icon_recommend_see_n_1, 0, 0, 0);
            }
            if (z2) {
                this.J.b().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.t.icon_recommend_collect_s_1, 0, 0, 0);
                return;
            } else {
                this.J.b().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.t.icon_recommend_collect_n_1, 0, 0, 0);
                return;
            }
        }
        if (!z) {
            this.J.f().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.t.icon_recommend_see_s, 0, 0, 0);
        } else {
            this.J.f().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.t.icon_recommend_see_n, 0, 0, 0);
        }
        if (z2) {
            this.J.b().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.t.icon_recommend_collect_s, 0, 0, 0);
        } else {
            this.J.b().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.t.icon_recommend_collect_n, 0, 0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ak() {
        boolean z;
        boolean z2 = true;
        View findViewById = this.o.findViewById(com.baidu.tieba.u.pb_head_function_manage_root);
        if (findViewById != null && findViewById.getVisibility() == 0) {
            this.B.setVisibility(0);
            z = true;
        } else {
            this.B.setVisibility(8);
            z = false;
        }
        View findViewById2 = this.o.findViewById(com.baidu.tieba.u.pb_head_function_manage_go_to_live_post);
        if (findViewById2 != null && findViewById2.getVisibility() == 0) {
            this.C.setVisibility(0);
        } else {
            this.C.setVisibility(8);
            z2 = z;
        }
        if (z2 && this.aU) {
            this.D.setVisibility(0);
        } else {
            this.D.setVisibility(8);
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
        this.aU = z;
        this.aH = (Button) this.o.findViewById(com.baidu.tieba.u.pb_head_function_manage_go_to_live_post);
        com.baidu.tbadk.core.data.n d = ajVar.d();
        if (d != null) {
            a(d.p());
        }
        RelativeLayout relativeLayout = (RelativeLayout) this.o.findViewById(com.baidu.tieba.u.pb_head_function_manage_root);
        Button button = (Button) this.o.findViewById(com.baidu.tieba.u.pb_head_function_manage_commit_top);
        Button button2 = (Button) this.o.findViewById(com.baidu.tieba.u.pb_head_function_manage_cancel_top);
        Button button3 = (Button) this.o.findViewById(com.baidu.tieba.u.pb_head_function_manage_commit_good);
        Button button4 = (Button) this.o.findViewById(com.baidu.tieba.u.pb_head_function_manage_cancel_good);
        button.setOnClickListener(this.V);
        button2.setOnClickListener(this.V);
        button3.setOnClickListener(this.V);
        button4.setOnClickListener(this.V);
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
            button.setOnClickListener(this.V);
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
        return this.R;
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
        if (this.M == null) {
            return null;
        }
        return this.M.v();
    }

    public void a(com.baidu.adp.widget.ListView.x xVar) {
        this.m.setOnSrollToBottomListener(xVar);
    }

    public void a(com.baidu.adp.widget.ListView.z zVar) {
        this.m.setOnSrollToTopListener(zVar);
    }

    public void a(DialogInterface.OnClickListener onClickListener) {
        this.U = onClickListener;
    }

    public void a(com.baidu.adp.widget.ListView.d dVar) {
        this.P.a(dVar);
    }

    public void a(com.baidu.tbadk.core.data.l lVar) {
        if (lVar != null) {
            int d = lVar.d();
            int a2 = lVar.a();
            if (this.K == null) {
                this.K = new Dialog(this.k, com.baidu.tieba.y.common_alert_dialog);
                this.K.setCanceledOnTouchOutside(true);
                this.K.setCancelable(true);
                this.N = com.baidu.adp.lib.e.b.a().a(this.k, com.baidu.tieba.v.dialog_direct_pager, null);
                this.K.setContentView(this.N);
                WindowManager.LayoutParams attributes = this.K.getWindow().getAttributes();
                attributes.gravity = 49;
                attributes.y = com.baidu.adp.lib.util.j.a((Context) this.k, 54.0f);
                attributes.width = (int) (com.baidu.adp.lib.util.j.b(this.k) * 0.9d);
                this.K.getWindow().setAttributes(attributes);
                this.K.setOnKeyListener(new cl(this));
            }
            com.baidu.adp.lib.e.e.a(this.K, this.k);
            ((Button) this.N.findViewById(com.baidu.tieba.u.dialog_button_ok)).setOnClickListener(this.V);
            ((Button) this.N.findViewById(com.baidu.tieba.u.dialog_button_cancel)).setOnClickListener(this.V);
            this.O = (EditText) this.N.findViewById(com.baidu.tieba.u.input_page_number);
            this.O.setText("");
            this.O.setOnFocusChangeListener(new cm(this));
            TextView textView = (TextView) this.N.findViewById(com.baidu.tieba.u.current_page_number);
            if (d <= 0) {
                d = 1;
            }
            textView.setText(MessageFormat.format(this.k.getApplicationContext().getResources().getString(com.baidu.tieba.x.current_page), Integer.valueOf(d), Integer.valueOf(a2 <= 0 ? 1 : a2)));
            this.k.ShowSoftKeyPadDelay(this.O, 150);
        }
    }

    public void a(AbsListView.OnScrollListener onScrollListener) {
        this.m.setOnScrollListener(onScrollListener);
    }

    public void b(AbsListView.OnScrollListener onScrollListener) {
        this.Z = onScrollListener;
    }

    public void a(View.OnClickListener onClickListener) {
        this.W = onClickListener;
        this.H.b(onClickListener);
    }

    public void b(View.OnClickListener onClickListener) {
        this.X = onClickListener;
        this.H.c(onClickListener);
    }

    public void c(View.OnClickListener onClickListener) {
        this.Y = onClickListener;
        this.H.d(onClickListener);
    }

    public void d(String str) {
        this.k.showToast(str);
    }

    public boolean f(boolean z) {
        if (this.M == null || !this.M.a()) {
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
        if (this.bd != null) {
            while (this.bd.size() > 0) {
                TbImageView remove = this.bd.remove(0);
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
        if (this.n != null && this.ac != null) {
            this.n.b(this.ac);
        }
        ad();
        this.Q.e();
    }

    public void ad() {
        if (this.I != null) {
            com.baidu.adp.lib.e.e.a(this.I, this.k);
        }
        com.baidu.adp.lib.util.j.a(this.k, this.O);
        this.h.e();
        if (this.K != null) {
            com.baidu.adp.lib.e.e.b(this.K, this.k);
        }
        if (this.aC != null) {
            com.baidu.adp.lib.e.e.b(this.aC, this.k);
        }
        if (this.M != null) {
            this.M.q();
        }
        ae();
    }

    public void g(boolean z) {
        this.H.b(z);
        if (this.M != null) {
            this.M.c(z);
        }
    }

    public void h(boolean z) {
        this.be = z;
        this.H.c(z);
        if (this.M != null) {
            this.M.b(z);
        }
    }

    public void ae() {
        if (this.af != null) {
            com.baidu.adp.lib.e.e.b(this.af, this.k);
        }
        if (this.ak != null) {
            com.baidu.adp.lib.e.e.b(this.ak, this.k);
        }
        if (this.au != null) {
            com.baidu.adp.lib.e.e.b(this.au, this.k);
        }
        if (this.ad != null) {
            com.baidu.adp.lib.e.e.b(this.ad, this.k);
        }
    }

    public void a(int i) {
        this.k.getLayoutMode().a(i == 1);
        this.k.getLayoutMode().a((View) this.l);
        this.k.getLayoutMode().a(this.o);
        this.k.getLayoutMode().a(this.R);
        this.b.c(i);
        e(this.aD);
        this.H.notifyDataSetChanged();
        if (this.M != null) {
            this.M.a(i);
            this.k.getLayoutMode().a(this.Q.b());
        }
        if (this.P != null) {
            this.P.a(i);
        }
        if (this.Q != null) {
            this.Q.d(i);
            this.R.setBackgroundResource(i == 1 ? com.baidu.tieba.t.pb_foot_more_trans_selector_1 : com.baidu.tieba.t.pb_foot_more_trans_selector);
            this.Q.a(i == 1 ? com.baidu.tieba.t.pb_foot_more_trans_selector_1 : com.baidu.tieba.t.pb_foot_more_trans_selector);
        }
        if (this.aT != null) {
            this.aT.d(i);
            this.aT.a(i == 1 ? com.baidu.tieba.r.cp_bg_line_e_1 : com.baidu.tieba.r.cp_bg_line_e);
            this.aS.setBackgroundResource(i == 1 ? com.baidu.tieba.r.cp_bg_line_e_1 : com.baidu.tieba.r.cp_bg_line_e);
        }
        this.h.c(i);
        if (this.aF != null) {
            if (i == 1) {
                this.aF.setBackgroundResource(com.baidu.tieba.r.cp_bg_line_d_1);
            } else {
                this.aF.setBackgroundResource(com.baidu.tieba.r.cp_bg_line_d);
            }
        }
        if (this.g != null) {
            this.g.a(i);
        }
    }

    public void a(com.baidu.tbadk.widget.richText.s sVar) {
        this.aa = sVar;
        this.H.a(this.aa);
        if (this.M != null) {
            this.M.a(this.aa);
        }
    }

    public void a(com.baidu.tbadk.widget.richText.r rVar) {
        this.ab = rVar;
        this.H.a(this.ab);
        if (this.M != null) {
            this.M.a(this.ab);
        }
    }

    public void a(com.baidu.tbadk.core.view.r rVar) {
        this.ac = rVar;
        if (this.n != null) {
            this.n.a(this.ac);
        }
    }

    public void i(boolean z) {
        this.H.d(z);
        this.aX = z;
    }

    public View af() {
        if (this.M == null) {
            return null;
        }
        return this.M.C();
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
            this.aQ = this.aK.getVisibility() == 0;
            this.h.setVisibility(8);
            this.aK.setVisibility(8);
            this.aJ.setVisibility(8);
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
            int visibility = this.G != null ? this.G.getVisibility() : 0;
            if (visibility == 0) {
                if (this.aQ) {
                    this.aK.setVisibility(visibility);
                    this.aJ.setVisibility(visibility);
                    return;
                }
                this.h.setVisibility(visibility);
                return;
            }
            this.aQ = this.aK.getVisibility() == 0;
            this.h.setVisibility(visibility);
            this.aK.setVisibility(visibility);
            this.aJ.setVisibility(visibility);
        }
    }

    public Button ag() {
        return this.aH;
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
                    this.m.setNextPage(this.Q);
                    return;
                }
            }
            this.m.setNextPage(this.Q);
        }
    }

    public boolean ah() {
        return this.h.l();
    }

    public boolean ai() {
        if (this.M == null) {
            return false;
        }
        return this.M.D();
    }
}
