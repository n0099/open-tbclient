package com.baidu.tieba.pb;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Handler;
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
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.NavigationBar;
import com.baidu.tieba.view.NoNetworkView;
import com.baidu.tieba.view.PbListView;
import com.baidu.tieba.voice.VoiceManager;
import com.slidingmenu.lib.R;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class cs {
    private View.OnClickListener A;
    private View.OnClickListener K;
    NavigationBar a;
    private View am;
    private View an;
    private View ao;
    private PbEditor aq;
    private com.baidu.tieba.editortool.t ar;
    private bx ax;
    ImageView b;
    TextView c;
    ImageView d;
    ImageView e;
    by f;
    private NewPbActivity g;
    private FrameLayout h;
    private BdListView i;
    private NoNetworkView j;
    private View k;
    private View l;
    private RelativeLayout m;
    private bz n;
    private com.baidu.tieba.view.bx v;
    private PbListView w;
    private View x;
    private Dialog o = null;
    private Dialog p = null;
    private Dialog q = null;
    private ed r = null;
    private View s = null;
    private EditText t = null;
    private View u = null;
    private View y = null;
    private DialogInterface.OnClickListener z = null;
    private View.OnClickListener B = null;
    private View.OnClickListener C = null;
    private View.OnClickListener D = null;
    private AbsListView.OnScrollListener E = null;
    private com.baidu.tbadk.widget.richText.r F = null;
    private com.baidu.tbadk.widget.richText.q G = null;
    private com.baidu.tieba.view.bf H = null;
    private Handler I = null;
    private Dialog J = null;
    private Dialog L = null;
    private View M = null;
    private Button N = null;
    private Button O = null;
    private TextView P = null;
    private Dialog Q = null;
    private View R = null;
    private int S = 0;
    private RadioGroup T = null;
    private RadioButton U = null;
    private RadioButton V = null;
    private RadioButton W = null;
    private Button X = null;
    private Button Y = null;
    private TextView Z = null;
    private Dialog aa = null;
    private View ab = null;
    private RadioGroup ac = null;
    private CompoundButton.OnCheckedChangeListener ad = null;
    private Button ae = null;
    private Button af = null;
    private String ag = null;
    private boolean ah = false;
    private dx ai = null;
    private Dialog aj = null;
    private boolean ak = false;
    private Button ap = null;
    private LinearLayout as = null;
    private PbListView at = null;
    private boolean au = false;
    private int av = 0;
    private View.OnClickListener aw = new cu(this);
    private boolean ay = false;
    private List<com.baidu.tieba.view.bg> az = new ArrayList();
    private com.baidu.tbadk.imageManager.c aA = new dm(this);
    private com.baidu.tbadk.imageManager.c aB = new dn(this);
    private com.baidu.tbadk.imageManager.c aC = new Cdo(this);
    private com.baidu.tieba.view.av aD = new dp(this);
    private com.baidu.tieba.d.a al = new com.baidu.tieba.d.a(new ct(this));

    public NoNetworkView a() {
        return this.j;
    }

    public cs(NewPbActivity newPbActivity, View.OnClickListener onClickListener) {
        this.g = null;
        this.h = null;
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.i = null;
        this.k = null;
        this.l = null;
        this.n = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.A = null;
        this.K = null;
        this.am = null;
        this.an = null;
        this.ao = null;
        this.g = newPbActivity;
        this.A = onClickListener;
        LayoutInflater from = LayoutInflater.from(this.g);
        this.h = (FrameLayout) from.inflate(R.layout.new_pb_activity, (ViewGroup) null);
        this.g.addContentView(this.h, new FrameLayout.LayoutParams(-1, -1));
        this.m = (RelativeLayout) this.g.findViewById(R.id.title_wrapper);
        this.j = (NoNetworkView) this.g.findViewById(R.id.view_no_network);
        this.i = (BdListView) this.g.findViewById(R.id.new_pb_list);
        View view = new View(this.g);
        view.setLayoutParams(new AbsListView.LayoutParams(-1, this.g.getResources().getDimensionPixelSize(R.dimen.navi_height)));
        this.i.addHeaderView(view);
        View view2 = new View(this.g);
        view2.setLayoutParams(new AbsListView.LayoutParams(-1, this.g.getResources().getDimensionPixelSize(R.dimen.pb_editor_height)));
        this.i.addFooterView(view2);
        this.a = (NavigationBar) this.g.findViewById(R.id.view_navigation_bar);
        this.a.setOnClickListener(new dd(this));
        this.b = this.a.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.A);
        this.c = this.a.a("");
        this.d = (ImageView) this.a.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nb_item_floor_host, this.A);
        this.e = this.a.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, NavigationBar.ControlType.MORE_BUTTON, this.A);
        this.aq = (PbEditor) this.g.findViewById(R.id.pb_editor_view);
        this.aq.setFrom(1);
        this.aq.a(false);
        D();
        this.l = from.inflate(R.layout.new_pb_header_item, (ViewGroup) null);
        this.k = (LinearLayout) this.l.findViewById(R.id.pb_header_container);
        this.am = this.k.findViewById(R.id.pb_header_divider);
        if (this.l != null) {
            this.l.setOnTouchListener(this.al);
            this.l.setOnLongClickListener(new dq(this));
        }
        ah();
        this.n = new bz(this.g);
        this.n.d(this.A);
        this.n.a(this.al);
        this.n.a(this.F);
        this.K = new dr(this);
        this.n.e(this.K);
        this.i.setAdapter((ListAdapter) this.n);
        this.i.addHeaderView(this.l);
        this.v = new com.baidu.tieba.view.bx(this.g);
        this.v.a();
        this.w = new PbListView(this.g);
        this.x = this.w.b().findViewById(R.id.pb_more_view);
        if (this.x != null) {
            this.x.setOnClickListener(this.A);
        }
        this.c.setOnClickListener(this.A);
        this.an = this.l.findViewById(R.id.border_top);
        this.ao = this.l.findViewById(R.id.border_bottom);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(boolean z) {
        if (this.i != null) {
            if (!z) {
                this.i.setEnabled(z);
            } else {
                this.i.postDelayed(new ds(this, z), 10L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view) {
        com.baidu.adp.lib.h.e.e("PbView", "showHideToolbar", "toggle");
        if (this.m != null && this.aq != null && view != null) {
            if (this.m.getVisibility() == 0 || this.aq.getVisibility() == 0) {
                Animation loadAnimation = AnimationUtils.loadAnimation(view.getContext(), R.anim.top_fold_up);
                loadAnimation.setAnimationListener(new dt(this));
                this.m.startAnimation(loadAnimation);
                this.aq.f();
                Animation loadAnimation2 = AnimationUtils.loadAnimation(view.getContext(), R.anim.bottom_fold_down);
                loadAnimation2.setAnimationListener(new du(this));
                this.aq.startAnimation(loadAnimation2);
                return;
            }
            Animation loadAnimation3 = AnimationUtils.loadAnimation(view.getContext(), R.anim.top_fold_down);
            loadAnimation3.setAnimationListener(new dv(this));
            this.m.startAnimation(loadAnimation3);
            Animation loadAnimation4 = AnimationUtils.loadAnimation(view.getContext(), R.anim.bottom_fold_up);
            loadAnimation4.setAnimationListener(new dw(this));
            this.aq.startAnimation(loadAnimation4);
        }
    }

    public VoiceManager.VoiceModel b() {
        return this.aq.getAudioData();
    }

    public void c() {
        this.aq.r();
    }

    public void d() {
        if (this.r != null) {
            this.r.l();
        }
    }

    public void e() {
        if (this.r != null) {
            this.r.m();
        }
    }

    public VoiceManager.VoiceModel f() {
        if (this.r != null) {
            return this.r.o();
        }
        return null;
    }

    public void g() {
        if (this.r != null) {
            this.r.p();
        }
    }

    public TextView h() {
        if (this.r == null || !(this.r instanceof ea)) {
            return null;
        }
        return ((ea) this.r).c();
    }

    public bz i() {
        return this.n;
    }

    public void a(by byVar) {
        this.f = byVar;
    }

    public void j() {
        if (this.ah && this.g.getCurrentFocus() != null) {
            this.ah = false;
            com.baidu.adp.lib.h.g.a(this.g, this.g.getCurrentFocus());
        }
    }

    private void a(com.baidu.tieba.data.be beVar) {
        if (beVar != null && beVar.a() != 0) {
            int b = beVar.b();
            String string = this.g.getString(R.string.go_to_live_post_prefix);
            if (b == 0) {
                string = string + this.g.getString(R.string.go_to_interview_post);
            } else if (b == 1) {
                string = string + this.g.getString(R.string.go_to_discuss_post);
            }
            this.ap.setText(string);
            this.ap.setVisibility(0);
            this.ap.setOnClickListener(this.A);
            ai();
        }
    }

    private void ah() {
        this.as = (LinearLayout) this.l.findViewById(R.id.btn_show_passed_pb);
        this.at = new PbListView(this.g, PbListView.IconType.ICON_UP_WARD);
        View a = this.at.a();
        this.at.a(this.g.getResources().getString(R.string.btn_show_passed_pb));
        this.at.b(this.g.getResources().getDimensionPixelSize(R.dimen.pb_header_long_button_height));
        a.setOnClickListener(this.aw);
        this.as.addView(a);
        this.as.requestLayout();
        this.as.invalidate();
        this.at.a(TiebaApplication.g().an() == 1 ? R.drawable.button_load_next_1 : R.drawable.button_load_next);
        ai();
    }

    public void a(View view) {
        if (this.J == null) {
            this.J = new Dialog(this.g, R.style.common_alert_dialog);
            this.J.setCanceledOnTouchOutside(true);
            this.J.setCancelable(true);
            this.J.setContentView(this.g.getLayoutInflater().inflate(R.layout.forum_manage_dialog, (ViewGroup) null));
            WindowManager.LayoutParams attributes = this.J.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.h.g.b(this.g) * 0.9d);
            this.J.getWindow().setAttributes(attributes);
        }
        Button button = (Button) this.J.findViewById(R.id.del_post_btn);
        Button button2 = (Button) this.J.findViewById(R.id.forbid_user_btn);
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            if ("".equals(sparseArray.get(R.id.tag_del_post_id))) {
                button.setVisibility(8);
            } else {
                SparseArray sparseArray2 = (SparseArray) button.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    button.setTag(sparseArray2);
                }
                button.setVisibility(0);
                sparseArray2.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                sparseArray2.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                sparseArray2.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
                sparseArray2.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                button.setOnClickListener(new cv(this));
            }
            if ("".equals(sparseArray.get(R.id.tag_forbid_user_name))) {
                button2.setVisibility(8);
            } else {
                SparseArray sparseArray3 = (SparseArray) button2.getTag();
                if (sparseArray3 == null) {
                    sparseArray3 = new SparseArray();
                    button2.setTag(sparseArray3);
                }
                button2.setVisibility(0);
                sparseArray3.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
                sparseArray3.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                button2.setOnClickListener(new cw(this));
            }
            this.J.show();
        }
    }

    public void a(bx bxVar) {
        this.ax = bxVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        if (this.L == null) {
            this.L = new Dialog(this.g, R.style.common_alert_dialog);
            this.L.setCanceledOnTouchOutside(true);
            this.L.setCancelable(true);
            this.M = this.g.getLayoutInflater().inflate(R.layout.del_post, (ViewGroup) null);
            this.L.setContentView(this.M);
            WindowManager.LayoutParams attributes = this.L.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.h.g.b(this.g) * 0.9d);
            this.L.getWindow().setAttributes(attributes);
            this.N = (Button) this.M.findViewById(R.id.dialog_button_ok);
            this.N.setOnClickListener(this.A);
            this.O = (Button) this.M.findViewById(R.id.dialog_button_cancel);
            this.O.setOnClickListener(new cx(this));
            this.P = (TextView) this.M.findViewById(R.id.confirm_text);
        }
        SparseArray sparseArray = (SparseArray) this.N.getTag();
        if (sparseArray == null) {
            sparseArray = new SparseArray();
            this.N.setTag(sparseArray);
        }
        sparseArray.put(R.id.tag_del_post_id, str);
        sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z));
        if (i == 0) {
            this.P.setText(R.string.del_thread_confirm);
        } else {
            this.P.setText(R.string.del_post_confirm);
        }
        this.L.show();
    }

    public void a(ArrayList<com.baidu.tieba.data.aa> arrayList) {
        if (this.aa == null) {
            this.aa = new Dialog(this.g, R.style.common_alert_dialog);
            this.aa.setCanceledOnTouchOutside(true);
            this.aa.setCancelable(true);
            this.ab = this.g.getLayoutInflater().inflate(R.layout.commit_good, (ViewGroup) null);
            this.aa.setContentView(this.ab);
            WindowManager.LayoutParams attributes = this.aa.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.h.g.b(this.g) * 0.9d);
            this.aa.getWindow().setAttributes(attributes);
            this.ad = new cy(this);
            this.ac = (RadioGroup) this.ab.findViewById(R.id.good_class_group);
            this.af = (Button) this.ab.findViewById(R.id.dialog_button_cancel);
            this.af.setOnClickListener(new cz(this));
            this.ae = (Button) this.ab.findViewById(R.id.dialog_button_ok);
            this.ae.setOnClickListener(this.A);
        }
        this.ac.removeAllViews();
        LayoutInflater layoutInflater = this.g.getLayoutInflater();
        RadioButton radioButton = (RadioButton) layoutInflater.inflate(R.layout.good_class_radio_button, (ViewGroup) null);
        radioButton.setTag(SocialConstants.FALSE);
        radioButton.setText(this.g.getString(R.string.def_good_class));
        radioButton.setOnCheckedChangeListener(this.ad);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, -2);
        layoutParams.setMargins(com.baidu.adp.lib.h.g.a((Context) this.g, 10.0f), com.baidu.adp.lib.h.g.a((Context) this.g, 5.0f), com.baidu.adp.lib.h.g.a((Context) this.g, 10.0f), com.baidu.adp.lib.h.g.a((Context) this.g, 5.0f));
        this.ac.addView(radioButton, layoutParams);
        this.ac.requestLayout();
        this.ac.check(radioButton.getId());
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                RadioButton radioButton2 = (RadioButton) layoutInflater.inflate(R.layout.good_class_radio_button, (ViewGroup) null);
                radioButton2.setTag(String.valueOf(arrayList.get(i2).b()));
                radioButton2.setText(arrayList.get(i2).a());
                radioButton2.setOnCheckedChangeListener(this.ad);
                this.ac.addView(radioButton2, layoutParams);
                this.ac.requestLayout();
                i = i2 + 1;
            }
        }
        this.aa.show();
    }

    public void k() {
        this.g.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.g.hideProgressBar();
        if (z && z2) {
            this.g.showToast(this.g.getString(R.string.success));
        } else if (str != null && z2) {
            this.g.showToast(str);
        }
    }

    public View l() {
        if (this.M != null) {
            return this.M.findViewById(R.id.dialog_button_ok);
        }
        return null;
    }

    public View m() {
        if (this.ab != null) {
            return this.ab.findViewById(R.id.dialog_button_ok);
        }
        return null;
    }

    public String n() {
        return this.ag;
    }

    public View o() {
        if (this.r != null) {
            return this.r.y();
        }
        return null;
    }

    public void p() {
        this.g.showProgressBar();
        com.baidu.adp.lib.h.g.a(this.g, this.aq.getEditText());
    }

    public void q() {
        if (this.r != null) {
            this.r.B();
        } else {
            this.g.showProgressBar();
        }
    }

    public void a(boolean z) {
        if (this.r != null) {
            this.r.C();
        } else {
            this.g.hideProgressBar();
        }
        Z();
        if (z) {
            this.aq.getEditText().setText("");
            this.aq.b();
            this.aq.l();
            if (this.r != null) {
                this.r.v();
            }
        }
    }

    public void r() {
        this.w.c();
    }

    public void s() {
        this.g.hideProgressBar();
        this.w.d();
        this.at.d();
        this.i.a();
        ai();
    }

    public void t() {
        this.i.a();
        this.as.setVisibility(8);
        ai();
    }

    public void a(String str) {
        this.c.setText(str + this.g.getString(R.string.bar));
    }

    public void b(boolean z) {
        if (!z) {
            this.aq.d();
        } else if (this.r != null) {
            this.r.c((String) null);
        }
    }

    public void u() {
        if (y() && this.r != null) {
            this.r.j();
        }
    }

    public void v() {
        if (this.r == null) {
            this.r = new ed(this.g, this.ay, this.A, this.K, this.B, this.C, this.D);
            this.r.a(this.ar);
            this.r.a(this.n.a());
            this.r.a(this.E);
            this.r.c(this.n.c());
            this.r.b(this.n.d());
            this.y = this.r.n();
            this.r.a(this.F);
            this.r.a(this.G);
            this.r.a(this.n.b());
        }
        this.y.setVisibility(0);
        this.r.A();
        this.h.addView(this.y);
        al();
    }

    public void a(com.baidu.tieba.editortool.t tVar) {
        if (tVar != null) {
            this.aq.setOnActionListener(new da(this, tVar));
            this.ar = tVar;
            if (this.r != null) {
                this.r.a(tVar);
            }
        }
    }

    public void a(dx dxVar) {
        this.ai = dxVar;
    }

    public void a(boolean z, com.baidu.tieba.data.ax axVar, boolean z2, String str, String str2, View view, int i) {
        int i2;
        int i3;
        if (axVar != null && view != null) {
            if (TiebaApplication.g().s()) {
                StatService.onEvent(this.g, "pb_tosubpb", "pbclick", 1);
            }
            if (this.r == null) {
                this.r = new ed(this.g, this.ay, this.A, this.K, this.B, this.C, this.D);
                this.r.a(this.ar);
                this.r.a(this.n.a());
                this.r.a(this.E);
                this.r.c(this.n.c());
                this.r.b(this.n.d());
                this.y = this.r.n();
                this.r.a(this.F);
                this.r.a(this.G);
                this.r.a(this.n.b());
            }
            this.r.c(this.n.e());
            this.r.a(axVar, i);
            if (str2 != null && !str2.equals("")) {
                this.r.d(str2);
            } else {
                this.r.d(1);
            }
            if (view != null) {
                int top = view.getTop() + 0;
                i2 = view.getBottom() + 0;
                i3 = top;
            } else {
                i2 = 0;
                i3 = 0;
            }
            if (!z) {
                this.r.q();
            }
            AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator(1.5f);
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, i3, 0.0f);
            translateAnimation.setDuration(300L);
            this.y.setAnimation(translateAnimation);
            this.h.invalidate();
            this.h.buildDrawingCache();
            Bitmap drawingCache = this.h.getDrawingCache();
            Bitmap bitmap = null;
            Bitmap bitmap2 = null;
            if (drawingCache != null) {
                if (i2 > 0 && i2 < drawingCache.getHeight()) {
                    try {
                        bitmap = Bitmap.createBitmap(drawingCache, 0, i2, drawingCache.getWidth(), drawingCache.getHeight() - i2);
                    } catch (OutOfMemoryError e) {
                        bitmap = null;
                    }
                }
                if (i3 < 0) {
                    i3 = 0;
                }
                if (i3 > 0 && i3 < drawingCache.getHeight()) {
                    try {
                        bitmap2 = Bitmap.createBitmap(drawingCache, 0, 0, drawingCache.getWidth(), i3);
                    } catch (OutOfMemoryError e2) {
                        bitmap2 = null;
                    }
                }
            }
            this.y.setVisibility(0);
            if (this.y.getParent() == this.h) {
                this.h.removeView(this.y);
            }
            this.h.addView(this.y);
            if (bitmap2 != null) {
                ImageView imageView = new ImageView(this.g);
                imageView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 48));
                imageView.setImageBitmap(bitmap2);
                this.h.addView(imageView);
                TranslateAnimation translateAnimation2 = new TranslateAnimation(0.0f, 0.0f, 0.0f, -i3);
                translateAnimation2.setDuration(300L);
                imageView.setAnimation(translateAnimation2);
                translateAnimation2.setAnimationListener(new db(this, imageView));
                translateAnimation2.setInterpolator(accelerateInterpolator);
                translateAnimation2.start();
            }
            ImageView imageView2 = new ImageView(this.g);
            imageView2.setImageBitmap(bitmap);
            imageView2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 80));
            this.h.addView(imageView2);
            TranslateAnimation translateAnimation3 = new TranslateAnimation(0.0f, 0.0f, i2, this.h.getHeight());
            translateAnimation3.setDuration(300L);
            imageView2.setAnimation(translateAnimation3);
            translateAnimation3.setAnimationListener(new de(this, imageView2));
            translateAnimation.setAnimationListener(new dg(this, axVar, z, str, str2));
            translateAnimation.setInterpolator(accelerateInterpolator);
            translateAnimation3.setInterpolator(accelerateInterpolator);
            translateAnimation3.start();
            translateAnimation.start();
        }
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.n.a(onLongClickListener);
        if (this.r != null) {
            this.r.a(onLongClickListener);
        }
    }

    public void w() {
        if (y()) {
            this.r.r();
        }
    }

    public void x() {
        if (y() && (this.r instanceof ea)) {
            ((ea) this.r).d();
        }
    }

    public boolean y() {
        return (this.y == null || this.y.getVisibility() == 8) ? false : true;
    }

    public void z() {
        if (this.y != null) {
            this.y.setVisibility(8);
            this.h.removeView(this.y);
            this.r.s();
        }
        Z();
        am();
    }

    public void A() {
        if (this.r != null) {
            this.r.D();
            if (this.r instanceof ea) {
                ((ea) this.r).e();
            }
        }
    }

    public void a(com.baidu.tieba.data.ax axVar, int i) {
        if (this.r != null) {
            this.r.D();
            this.r.c(this.n.e());
            this.r.a(axVar, i);
        }
    }

    public void B() {
        if (this.r == null) {
            this.r = new ea(this.g, this.ay, this.A, this.K, this.B, this.C, this.D);
            this.r.a(this.ar);
            this.r.a(this.n.a());
            this.r.a(this.E);
            this.r.c(this.n.c());
            this.r.b(this.n.d());
            this.y = this.r.n();
            this.r.a(this.F);
            this.r.a(this.G);
            this.r.a(this.n.b());
        }
        this.y.setVisibility(0);
        this.r.A();
        this.h.addView(this.y);
        al();
    }

    public void a(com.baidu.tieba.data.ax axVar, int i, String str, boolean z, boolean z2) {
        if (this.r != null && (this.r instanceof ea)) {
            ea eaVar = (ea) this.r;
            this.r.D();
            this.r.c(this.n.e());
            this.r.a(axVar, i);
            if (z2) {
                eaVar.a(str);
            }
            if (!z) {
                eaVar.f();
            } else {
                eaVar.g();
            }
        }
    }

    public void b(String str) {
        this.aq.a(str);
    }

    public void c(String str) {
        if (this.r != null) {
            this.r.b(str);
        }
    }

    public void C() {
        this.ay = true;
        this.aq.p();
    }

    public void D() {
        this.ay = false;
        this.aq.q();
    }

    public void a(DialogInterface.OnClickListener onClickListener, boolean z, boolean z2) {
        if (this.aj != null) {
            this.aj.dismiss();
            this.aj = null;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this.g);
        builder.setTitle(R.string.operation);
        if (z2) {
            builder.setItems(new String[]{this.g.getString(R.string.copy)}, onClickListener);
        } else if (z) {
            builder.setItems(new String[]{this.g.getString(R.string.copy), this.g.getString(R.string.remove_mark)}, onClickListener);
        } else {
            builder.setItems(new String[]{this.g.getString(R.string.copy), this.g.getString(R.string.mark)}, onClickListener);
        }
        this.aj = builder.create();
        this.aj.setCanceledOnTouchOutside(true);
        this.aj.show();
    }

    public void E() {
        if (this.q == null) {
            ak();
        }
        this.q.show();
    }

    public void c(boolean z) {
        this.aq.setAudioFocusable(z);
    }

    public void d(boolean z) {
        if (this.r != null) {
            this.r.a(z);
        }
    }

    public boolean F() {
        return this.aq.s();
    }

    public void a(Bitmap bitmap) {
        this.aq.a(bitmap);
        this.aq.a();
    }

    public void G() {
        this.aq.a((Bitmap) null);
    }

    public int H() {
        int firstVisiblePosition = this.i.getFirstVisiblePosition();
        int i = (this.i.getChildAt(0) == null || this.i.getChildAt(0).getBottom() >= this.i.getHeight()) ? firstVisiblePosition : firstVisiblePosition + 1;
        int c = (this.i.getAdapter() == null || !(this.i.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) ? 0 : ((com.baidu.adp.widget.ListView.e) this.i.getAdapter()).c();
        if (i > c) {
            return i - c;
        }
        return 0;
    }

    public int I() {
        try {
            return Integer.parseInt(this.t.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public String J() {
        return this.aq.getContent();
    }

    public void d(String str) {
        this.aq.setContent(str);
    }

    public String K() {
        if (this.r == null) {
            return null;
        }
        return this.r.z();
    }

    public String L() {
        if (this.r != null) {
            return this.r.t();
        }
        return null;
    }

    public void a(com.baidu.tieba.data.ao aoVar) {
        this.n.a(aoVar);
        this.n.notifyDataSetChanged();
        ai();
        if (this.r != null) {
            this.r.d(aoVar.i());
        }
    }

    public void a(com.baidu.tieba.data.ao aoVar, int i, int i2, boolean z) {
        this.an.setVisibility(0);
        this.ao.setVisibility(0);
        this.au = z;
        s();
        this.n.a(aoVar);
        this.n.notifyDataSetChanged();
        a(aoVar.c().getName());
        if (aoVar.f().f() == 0 && !z) {
            this.i.setNextPage(null);
        } else {
            this.i.setNextPage(this.w);
            this.at.d();
        }
        if (aoVar.f().g() == 0 && z) {
            this.i.setPullRefresh(null);
            this.as.setVisibility(8);
        } else {
            this.i.setPullRefresh(this.v);
            if (this.v != null) {
                this.v.a(TiebaApplication.g().an());
            }
            this.as.setVisibility(0);
            this.at.d();
        }
        ai();
        if (TiebaApplication.g().an() == 1) {
        }
        if (z) {
            if (aoVar.f().f() == 0) {
                this.w.a(this.g.getResources().getString(R.string.no_more_to_load));
            } else {
                this.w.a(this.g.getResources().getString(R.string.pb_load_more));
            }
            this.at.a(this.g.getResources().getString(R.string.btn_show_passed_pb));
        } else {
            this.at.a(this.g.getResources().getString(R.string.btn_show_passed_pb_aftre));
        }
        if (aoVar.d() != null && aoVar.d().j() != null && aoVar.d().j().getType() == 0) {
            this.d.setVisibility(4);
            this.d.setEnabled(false);
        }
        switch (i) {
            case 2:
                this.i.setSelection(i2);
                CompatibleUtile.scrollListViewBy(this.i, -this.k.getHeight(), 0);
                return;
            case 3:
            case 5:
                this.i.setSelection(0);
                return;
            case 4:
            case 6:
                if (z) {
                    this.i.setSelection(0);
                    return;
                } else if (aoVar.e() != null) {
                    if (aoVar.f() != null && aoVar.f().g() != 0) {
                        this.i.setSelection(aoVar.e().size() + 1);
                        return;
                    } else {
                        this.i.setSelection(aoVar.e().size());
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
        this.ak = z;
        if (TiebaApplication.g().an() == 1) {
            if (z) {
                this.d.setImageResource(R.drawable.icon_floor_host_s_1);
            } else {
                this.d.setImageResource(R.drawable.icon_floor_host_n_1);
            }
        } else if (z) {
            this.d.setImageResource(R.drawable.icon_floor_host_s);
        } else {
            this.d.setImageResource(R.drawable.icon_floor_host_n);
        }
    }

    public void M() {
        if (this.w != null) {
            this.w.d();
        }
        if (this.at != null) {
            this.at.d();
        }
    }

    public void a(boolean z, boolean z2) {
        if (!this.g.isProgressBarShown()) {
            if (this.o == null) {
                aj();
            }
            this.o.show();
            this.o.setContentView(this.u);
            TextView textView = (TextView) this.u.findViewById(R.id.reverse_txt);
            TextView textView2 = (TextView) this.u.findViewById(R.id.skip_txt);
            TextView textView3 = (TextView) this.u.findViewById(R.id.share_txt);
            TextView textView4 = (TextView) this.u.findViewById(R.id.mark_txt);
            textView.setOnClickListener(this.A);
            textView2.setOnClickListener(this.A);
            textView3.setOnClickListener(this.A);
            textView4.setOnClickListener(this.A);
            int an = TiebaApplication.g().an();
            this.g.getLayoutMode().a(an == 1);
            this.g.getLayoutMode().a(this.u);
            if (an == 1) {
                textView4.setTextColor(this.g.getResources().getColor(R.color.pb_more_txt_color_1));
                textView4.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_recommend_collect_n_1, 0, 0);
                textView3.setTextColor(this.g.getResources().getColor(R.color.pb_more_txt_color_1));
                textView3.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_recommend_share_n_1, 0, 0);
                textView2.setTextColor(this.g.getResources().getColor(R.color.pb_more_txt_color_1));
                textView2.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_recommend_jump_n_1, 0, 0);
                textView.setTextColor(this.g.getResources().getColor(R.color.pb_more_txt_color_1));
                textView.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_recommend_see_n_1, 0, 0);
                if (!z) {
                    textView.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_recommend_see_s_1, 0, 0);
                }
                if (z2) {
                    textView4.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_recommend_collect_s_1, 0, 0);
                }
            } else {
                textView4.setTextColor(this.g.getResources().getColor(R.color.pb_more_txt_color));
                textView4.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_recommend_collect_n, 0, 0);
                textView3.setTextColor(this.g.getResources().getColor(R.color.pb_more_txt_color));
                textView3.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_recommend_share_n, 0, 0);
                textView2.setTextColor(this.g.getResources().getColor(R.color.pb_more_txt_color));
                textView2.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_recommend_jump_n, 0, 0);
                textView.setTextColor(this.g.getResources().getColor(R.color.pb_more_txt_color));
                textView.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_recommend_see_n, 0, 0);
                if (!z) {
                    textView.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_recommend_see_s, 0, 0);
                }
                if (z2) {
                    textView4.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icon_recommend_collect_s, 0, 0);
                }
            }
            int height = this.a.getHeight();
            WindowManager.LayoutParams attributes = this.o.getWindow().getAttributes();
            attributes.gravity = 53;
            attributes.x = 0;
            attributes.y = height;
            attributes.alpha = 1.0f;
            attributes.width = -1;
            attributes.height = -2;
            this.o.getWindow().setAttributes(attributes);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ai() {
        View findViewById = this.g.findViewById(R.id.manage_bottom_bar);
        View findViewById2 = this.g.findViewById(R.id.go_to_live_post);
        View findViewById3 = this.g.findViewById(R.id.btn_show_passed_pb);
        if ((findViewById != null && findViewById.getVisibility() == 0) || ((findViewById2 != null && findViewById2.getVisibility() == 0) || (findViewById3 != null && findViewById3.getVisibility() == 0))) {
            this.am.setVisibility(0);
        } else {
            this.am.setVisibility(8);
        }
    }

    public void a(com.baidu.tieba.data.ao aoVar, boolean z) {
        if (aoVar != null) {
            TextView textView = (TextView) this.k.findViewById(R.id.pb_header_title);
            textView.setTextSize(com.baidu.tieba.data.h.s());
            TextView textView2 = (TextView) this.k.findViewById(R.id.pb_list_header_time);
            TextView textView3 = (TextView) this.k.findViewById(R.id.pb_list_header_reply);
            TextView textView4 = (TextView) this.k.findViewById(R.id.pb_list_header_bar);
            textView4.setOnClickListener(this.A);
            if (aoVar.c() != null && aoVar.c().getName() != null) {
                String name = aoVar.c().getName();
                if (name.length() > 6) {
                    name = name.substring(0, 5) + this.g.getResources().getString(R.string.three_point);
                }
                textView4.setText(name + this.g.getResources().getString(R.string.bar));
            }
            aoVar.d().t();
            textView.setText(aoVar.d().r());
            if (aoVar.d().d() != 0) {
                textView3.setText(String.valueOf(aoVar.d().d()));
            } else {
                textView3.setVisibility(8);
            }
            this.k.setVisibility(0);
            ArrayList<com.baidu.tieba.data.as> e = aoVar.e();
            long j = -1;
            if (e.size() > 0) {
                com.baidu.tieba.data.as asVar = e.get(0);
                if (asVar.e() == 1) {
                    j = asVar.f();
                }
                com.baidu.tieba.data.as asVar2 = e.get(e.size() - 1);
                if (asVar2.e() == 1) {
                    j = asVar2.f();
                }
            }
            if (j > 0) {
                textView2.setVisibility(0);
                textView2.setText(com.baidu.tieba.util.bm.b(j));
            }
            this.ap = (Button) this.k.findViewById(R.id.go_to_live_post);
            com.baidu.tieba.data.bb d = aoVar.d();
            if (d != null) {
                a(d.i());
            }
            Button button = (Button) this.k.findViewById(R.id.pb_list_header_manage_btn);
            LinearLayout linearLayout = (LinearLayout) this.k.findViewById(R.id.manage_bottom_bar);
            if (!z) {
                linearLayout.setVisibility(8);
            }
            if (aoVar.l() == 1) {
                button.setVisibility(0);
            } else {
                button.setVisibility(8);
            }
            button.setOnClickListener(new di(this));
            Button button2 = (Button) this.k.findViewById(R.id.commit_top);
            button2.setOnClickListener(this.A);
            Button button3 = (Button) this.k.findViewById(R.id.cancel_top);
            button3.setOnClickListener(this.A);
            Button button4 = (Button) this.k.findViewById(R.id.commit_good);
            button4.setOnClickListener(this.A);
            Button button5 = (Button) this.k.findViewById(R.id.cancel_good);
            button5.setOnClickListener(this.A);
            if (aoVar.d().g() == 1) {
                button4.setVisibility(8);
                button5.setVisibility(0);
            } else {
                button4.setVisibility(0);
                button5.setVisibility(8);
            }
            if (aoVar.d().f() == 1) {
                button2.setVisibility(8);
                button3.setVisibility(0);
            } else {
                button2.setVisibility(0);
                button3.setVisibility(8);
            }
            ai();
        }
    }

    private void b(int i) {
        this.g.getLayoutMode().a(i == 1);
        this.g.getLayoutMode().a(this.h);
        TextView textView = (TextView) this.k.findViewById(R.id.pb_list_header_time);
        TextView textView2 = (TextView) this.k.findViewById(R.id.pb_list_header_reply);
        TextView textView3 = (TextView) this.k.findViewById(R.id.pb_list_header_bar);
        com.baidu.tieba.util.bl.a(this.b, i);
        e(this.ak);
        this.n.notifyDataSetChanged();
        if (i == 1) {
            textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_little_time_1, 0, 0, 0);
            textView2.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_little_comment_n_1, 0, 0, 0);
        } else {
            textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_little_time, 0, 0, 0);
            textView2.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_little_comment_n, 0, 0, 0);
        }
        this.aq.d(i);
    }

    private void c(int i) {
        try {
            Button button = (Button) this.k.findViewById(R.id.pb_list_header_manage_btn);
            if (i == 1) {
                button.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_manage_n_1, 0, 0, 0);
            } else {
                button.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_manage_n, 0, 0, 0);
            }
        } catch (Exception e) {
            com.baidu.tieba.util.bo.b(getClass().getName(), "setBawuSkin", e.getMessage());
        }
    }

    public View N() {
        return this.x;
    }

    public BdListView O() {
        return this.i;
    }

    public int P() {
        return R.id.richText;
    }

    public int Q() {
        return R.id.user_icon_box;
    }

    public Button R() {
        return (Button) this.k.findViewById(R.id.commit_good);
    }

    public Button S() {
        return (Button) this.k.findViewById(R.id.cancel_good);
    }

    public Button T() {
        return (Button) this.k.findViewById(R.id.commit_top);
    }

    public Button U() {
        return (Button) this.k.findViewById(R.id.cancel_top);
    }

    public View V() {
        if (this.r == null) {
            return null;
        }
        return this.r.w();
    }

    public void a(com.baidu.adp.widget.ListView.r rVar) {
        this.i.setOnSrollToBottomListener(rVar);
    }

    public void a(com.baidu.adp.widget.ListView.t tVar) {
        this.i.setOnSrollToTopListener(tVar);
    }

    public void a(DialogInterface.OnClickListener onClickListener) {
        this.z = onClickListener;
    }

    public void a(com.baidu.adp.widget.ListView.b bVar) {
        this.v.a(bVar);
    }

    private void aj() {
        this.o = new com.baidu.tieba.view.bd(this.g);
        this.u = this.g.getLayoutInflater().inflate(R.layout.new_pb_more, (ViewGroup) null);
        this.u.setOnTouchListener(new dj(this));
        this.o.setCanceledOnTouchOutside(true);
    }

    private void ak() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.g);
        builder.setTitle(this.g.getResources().getString(R.string.operation));
        builder.setItems(new String[]{this.g.getResources().getString(R.string.take_photo), this.g.getResources().getString(R.string.album)}, this.z);
        this.q = builder.create();
        this.q.setCanceledOnTouchOutside(true);
    }

    public void a(com.baidu.tieba.data.an anVar) {
        if (anVar != null) {
            int d = anVar.d();
            int a = anVar.a();
            if (this.p == null) {
                this.p = new Dialog(this.g, R.style.common_alert_dialog);
                this.p.setCanceledOnTouchOutside(true);
                this.p.setCancelable(true);
                this.s = this.g.getLayoutInflater().inflate(R.layout.dialog_direct_pager, (ViewGroup) null);
                this.p.setContentView(this.s);
                WindowManager.LayoutParams attributes = this.p.getWindow().getAttributes();
                attributes.gravity = 49;
                attributes.y = com.baidu.adp.lib.h.g.a((Context) this.g, 54.0f);
                attributes.width = (int) (com.baidu.adp.lib.h.g.b(this.g) * 0.9d);
                this.p.getWindow().setAttributes(attributes);
                this.p.setOnKeyListener(new dk(this));
            }
            this.p.show();
            ((Button) this.s.findViewById(R.id.dialog_button_ok)).setOnClickListener(this.A);
            ((Button) this.s.findViewById(R.id.dialog_button_cancel)).setOnClickListener(this.A);
            this.t = (EditText) this.s.findViewById(R.id.input_page_number);
            this.t.setText("");
            this.t.setOnFocusChangeListener(new dl(this));
            TextView textView = (TextView) this.s.findViewById(R.id.current_page_number);
            if (d <= 0) {
                d = 1;
            }
            textView.setText(MessageFormat.format(this.g.getApplicationContext().getResources().getString(R.string.current_page), Integer.valueOf(d), Integer.valueOf(a <= 0 ? 1 : a)));
            this.g.ShowSoftKeyPadDelay(this.t, 150);
        }
    }

    public void a(AbsListView.OnScrollListener onScrollListener) {
        this.i.setOnScrollListener(onScrollListener);
    }

    public void b(AbsListView.OnScrollListener onScrollListener) {
        this.E = onScrollListener;
    }

    public void a(View.OnClickListener onClickListener) {
        this.B = onClickListener;
        this.n.a(onClickListener);
    }

    public void b(View.OnClickListener onClickListener) {
        this.C = onClickListener;
        this.n.b(onClickListener);
    }

    public void c(View.OnClickListener onClickListener) {
        this.D = onClickListener;
        this.n.c(onClickListener);
    }

    public void e(String str) {
        this.g.showToast(str);
    }

    public boolean f(boolean z) {
        if (this.r == null || !this.r.a()) {
            if (!z) {
                if (y()) {
                    z();
                    return true;
                } else if (this.aq.h()) {
                    this.aq.g();
                    return true;
                }
            } else if (y()) {
                z();
                return true;
            }
            return false;
        }
        return true;
    }

    public void a(com.baidu.tieba.view.bg bgVar) {
        if (bgVar != null) {
            if (!UtilHelper.b()) {
                com.baidu.adp.lib.h.g.a((Context) this.g, (int) R.string.neterror);
                return;
            }
            bgVar.f();
            if (this.az != null) {
                this.az.add(bgVar);
            }
        }
    }

    public void b(com.baidu.tieba.view.bg bgVar) {
        if (bgVar != null) {
            this.az.remove(bgVar);
        }
    }

    public void W() {
        if (this.az != null) {
            while (this.az.size() > 0) {
                com.baidu.tieba.view.bg remove = this.az.remove(0);
                if (remove != null) {
                    remove.a(false);
                }
            }
        }
    }

    public void X() {
        W();
    }

    public void Y() {
        this.g.hideProgressBar();
        if (this.j != null && this.H != null) {
            this.j.b(this.H);
        }
        Z();
        this.w.d();
        ad();
    }

    public void Z() {
        com.baidu.adp.lib.h.g.a(this.g, this.t);
        this.aq.e();
        if (this.o != null) {
            this.o.dismiss();
        }
        if (this.p != null) {
            this.p.dismiss();
        }
        if (this.aj != null) {
            this.aj.dismiss();
        }
        if (this.r != null) {
            this.r.q();
        }
        aa();
    }

    public void g(boolean z) {
        this.n.a(z);
        if (this.r != null) {
            this.r.c(z);
        }
    }

    public void h(boolean z) {
        this.n.b(z);
        if (this.r != null) {
            this.r.b(z);
        }
    }

    public void aa() {
        if (this.L != null) {
            this.L.dismiss();
        }
        if (this.Q != null) {
            this.Q.dismiss();
        }
        if (this.aa != null) {
            this.aa.dismiss();
        }
        if (this.J != null) {
            this.J.dismiss();
        }
    }

    public void ab() {
        if (this.r != null) {
            this.r.x();
        }
    }

    public com.baidu.adp.widget.ImageView.d a(View view, String str) {
        com.baidu.adp.widget.ImageView.d a = this.n.a().a(str, this.aC, true);
        if (a == null && view != null && (view instanceof com.baidu.tieba.view.bg)) {
            a((com.baidu.tieba.view.bg) view);
        }
        return a;
    }

    public void ac() {
        this.g.k();
        com.baidu.tieba.util.ak.a(this.i, this.n.a(), this.aB, this.aA, null, this.n.c() ? 0 : 1, 0);
    }

    public void ad() {
        try {
            this.n.a().d();
        } catch (Exception e) {
            com.baidu.tieba.util.bo.b(getClass().getName(), "stopLoadImage", "error = " + e.getMessage());
        }
    }

    public void a(int i) {
        this.g.getLayoutMode().a(i == 1);
        this.g.getLayoutMode().a(this.h);
        this.g.getLayoutMode().a(this.u);
        this.g.getLayoutMode().a(this.l);
        this.g.getLayoutMode().a(this.w.b());
        this.g.getLayoutMode().a(this.x);
        this.a.c(i);
        c(i);
        b(i);
        if (this.r != null) {
            this.r.b(i);
        }
        if (this.v != null) {
            this.v.a(i);
        }
        if (this.w != null) {
            this.w.d(i);
        }
        if (this.at != null) {
            this.at.d(i);
            this.at.a(i == 1 ? R.drawable.button_load_next_1 : R.drawable.button_load_next);
        }
        this.aq.d(i);
    }

    public boolean ae() {
        return this.ah;
    }

    public void a(com.baidu.tbadk.widget.richText.r rVar) {
        this.F = rVar;
        this.n.a(this.F);
        if (this.r != null) {
            this.r.a(this.F);
        }
    }

    public void a(com.baidu.tbadk.widget.richText.q qVar) {
        this.G = qVar;
        this.n.a(this.G);
        if (this.r != null) {
            this.r.a(this.G);
        }
    }

    public void a(com.baidu.tieba.view.bf bfVar) {
        this.H = bfVar;
        if (this.j != null) {
            this.j.a(this.H);
        }
    }

    public void i(boolean z) {
        this.n.a().d(z);
    }

    public View af() {
        if (this.r == null) {
            return null;
        }
        return this.r.E();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void al() {
        if (this.a != null) {
            this.a.setVisibility(8);
        }
        if (this.i != null) {
            this.i.setVisibility(8);
        }
        if (this.aq != null) {
            this.aq.setVisibility(8);
        }
    }

    private void am() {
        if (this.a != null) {
            this.a.setVisibility(0);
        }
        if (this.i != null) {
            this.i.setVisibility(0);
        }
        if (this.aq != null) {
            this.aq.setVisibility(0);
        }
    }

    public Button ag() {
        return this.ap;
    }
}
