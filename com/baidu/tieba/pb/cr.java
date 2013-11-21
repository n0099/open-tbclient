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
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.KeyboardEventLayout;
import com.baidu.tieba.view.NavigationBar;
import com.baidu.tieba.view.NoNetworkView;
import com.baidu.tieba.view.PbListView;
import com.baidu.tieba.voice.VoiceManager;
import com.slidingmenu.lib.R;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class cr {
    private View.OnClickListener H;

    /* renamed from: a  reason: collision with root package name */
    NavigationBar f2106a;
    private View aj;
    private View ak;
    private View al;
    private PbEditor an;
    private com.baidu.tieba.editortool.h ao;
    private bv au;
    ImageView b;
    TextView c;
    ImageView d;
    ImageView e;
    bw f;
    private NewPbActivity g;
    private KeyboardEventLayout h;
    private BdListView i;
    private NoNetworkView j;
    private View k;
    private View l;
    private bx m;
    private com.baidu.tieba.view.bj u;
    private PbListView v;
    private View w;
    private View.OnClickListener z;
    private Dialog n = null;
    private Dialog o = null;
    private Dialog p = null;
    private ed q = null;
    private View r = null;
    private EditText s = null;
    private View t = null;
    private View x = null;
    private DialogInterface.OnClickListener y = null;
    private View.OnClickListener A = null;
    private View.OnClickListener B = null;
    private AbsListView.OnScrollListener C = null;
    private com.baidu.tbadk.widget.richText.n D = null;
    private com.baidu.tieba.view.az E = null;
    private Handler F = null;
    private Dialog G = null;
    private Dialog I = null;
    private View J = null;
    private Button K = null;
    private Button L = null;
    private TextView M = null;
    private Dialog N = null;
    private View O = null;
    private int P = 0;
    private RadioGroup Q = null;
    private RadioButton R = null;
    private RadioButton S = null;
    private RadioButton T = null;
    private Button U = null;
    private Button V = null;
    private TextView W = null;
    private Dialog X = null;
    private View Y = null;
    private RadioGroup Z = null;
    private CompoundButton.OnCheckedChangeListener aa = null;
    private Button ab = null;
    private Button ac = null;
    private String ad = null;
    private boolean ae = false;
    private dx af = null;
    private Dialog ag = null;
    private boolean ah = false;
    private Button am = null;
    private LinearLayout ap = null;
    private PbListView aq = null;
    private boolean ar = false;
    private int as = 0;
    private View.OnClickListener at = new dw(this);
    private boolean av = false;
    private List<com.baidu.tieba.view.ba> aw = new ArrayList();
    private com.baidu.tbadk.imageManager.c ax = new dk(this);
    private com.baidu.tbadk.imageManager.c ay = new dl(this);
    private com.baidu.tbadk.imageManager.c az = new dm(this);
    private com.baidu.tieba.view.ao aA = new dn(this);
    private com.baidu.tieba.c.a ai = new com.baidu.tieba.c.a(new cs(this));

    public NoNetworkView a() {
        return this.j;
    }

    public cr(NewPbActivity newPbActivity, View.OnClickListener onClickListener) {
        this.g = null;
        this.h = null;
        this.f2106a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.i = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.z = null;
        this.H = null;
        this.aj = null;
        this.ak = null;
        this.al = null;
        this.g = newPbActivity;
        this.z = onClickListener;
        LayoutInflater from = LayoutInflater.from(this.g);
        this.h = (KeyboardEventLayout) from.inflate(R.layout.new_pb_activity, (ViewGroup) null);
        this.g.addContentView(this.h, new FrameLayout.LayoutParams(-2, -2));
        this.j = (NoNetworkView) this.g.findViewById(R.id.view_no_network);
        this.i = (BdListView) this.g.findViewById(R.id.new_pb_list);
        this.f2106a = (NavigationBar) this.g.findViewById(R.id.view_navigation_bar);
        this.f2106a.setOnClickListener(new dd(this));
        this.b = this.f2106a.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.z);
        this.c = this.f2106a.a("");
        this.d = (ImageView) this.f2106a.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nb_item_floor_host, this.z);
        this.e = this.f2106a.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, NavigationBar.ControlType.MORE_BUTTON, this.z);
        this.an = (PbEditor) this.g.findViewById(R.id.pb_editor_view);
        this.an.setImageFocusable(false);
        C();
        this.l = from.inflate(R.layout.new_pb_header_item, (ViewGroup) null);
        this.k = (LinearLayout) this.l.findViewById(R.id.pb_header_container);
        this.aj = this.k.findViewById(R.id.pb_header_divider);
        if (this.l != null) {
            this.l.setOnTouchListener(this.ai);
            this.l.setOnLongClickListener(new Cdo(this));
        }
        ah();
        this.m = new bx(this.g);
        this.m.c(this.z);
        this.m.a(this.ai);
        this.m.a(this.D);
        this.H = new dp(this);
        this.m.d(this.H);
        this.i.setAdapter((ListAdapter) this.m);
        this.i.addHeaderView(this.l);
        this.u = new com.baidu.tieba.view.bj(this.g);
        this.u.a();
        this.v = new PbListView(this.g);
        this.w = this.v.b().findViewById(R.id.pb_more_view);
        if (this.w != null) {
            this.w.setOnClickListener(this.z);
        }
        this.c.setOnClickListener(this.z);
        this.h.setOnKeyStateChangedListener(this.aA);
        this.ak = this.l.findViewById(R.id.border_top);
        this.al = this.l.findViewById(R.id.border_bottom);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(boolean z) {
        if (this.i != null) {
            if (!z) {
                this.i.setEnabled(z);
            } else {
                this.i.postDelayed(new dq(this, z), 10L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view) {
        int i;
        int i2;
        Bitmap bitmap;
        Bitmap bitmap2 = null;
        if (this.f2106a != null && this.an != null && view != null) {
            boolean z = this.f2106a.getVisibility() != 0;
            boolean z2 = this.an.getVisibility() != 0;
            if (z || z2) {
                this.f2106a.postDelayed(new dr(this), 50L);
                return;
            }
            AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator(1.5f);
            int measuredHeight = this.f2106a.getMeasuredHeight();
            if (this.i != null) {
                i = this.i.getBottom() + measuredHeight;
                i2 = measuredHeight;
            } else {
                i = 0;
                i2 = 0;
            }
            this.h.invalidate();
            this.h.buildDrawingCache();
            Bitmap drawingCache = this.h.getDrawingCache();
            if (drawingCache != null) {
                Bitmap createBitmap = (i <= 0 || i >= drawingCache.getHeight()) ? null : Bitmap.createBitmap(drawingCache, 0, i, drawingCache.getWidth(), drawingCache.getHeight() - i);
                if (i2 < measuredHeight) {
                    i2 = measuredHeight;
                }
                if (i2 <= 0 || i2 >= drawingCache.getHeight()) {
                    bitmap = null;
                    bitmap2 = createBitmap;
                } else {
                    bitmap = Bitmap.createBitmap(drawingCache, 0, 0, drawingCache.getWidth(), i2);
                    bitmap2 = createBitmap;
                }
            } else {
                bitmap = null;
            }
            if (bitmap != null) {
                ImageView imageView = new ImageView(this.g);
                imageView.setImageBitmap(bitmap);
                this.h.addView(imageView);
                TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, -i2);
                translateAnimation.setDuration(300L);
                imageView.setAnimation(translateAnimation);
                translateAnimation.setAnimationListener(new ds(this, imageView));
                translateAnimation.setInterpolator(accelerateInterpolator);
                translateAnimation.start();
            }
            if (bitmap2 != null) {
                ImageView imageView2 = new ImageView(this.g);
                imageView2.setImageBitmap(bitmap2);
                this.h.addView(imageView2);
                TranslateAnimation translateAnimation2 = new TranslateAnimation(0.0f, 0.0f, i, this.h.getHeight());
                translateAnimation2.setDuration(300L);
                imageView2.setAnimation(translateAnimation2);
                translateAnimation2.setAnimationListener(new du(this, imageView2));
            }
            this.f2106a.setVisibility(8);
            this.an.g();
            this.an.setVisibility(8);
        }
    }

    public VoiceManager.VoiceModel b() {
        return this.an.getAudioData();
    }

    public void c() {
        this.an.s();
    }

    public void d() {
        if (this.q != null) {
            this.q.l();
        }
    }

    public void e() {
        if (this.q != null) {
            this.q.m();
        }
    }

    public VoiceManager.VoiceModel f() {
        if (this.q != null) {
            return this.q.o();
        }
        return null;
    }

    public void g() {
        if (this.q != null) {
            this.q.p();
        }
    }

    public TextView h() {
        if (this.q == null || !(this.q instanceof ea)) {
            return null;
        }
        return ((ea) this.q).c();
    }

    public void a(bw bwVar) {
        this.f = bwVar;
    }

    public void i() {
        if (this.ae && this.g.getCurrentFocus() != null) {
            this.ae = false;
            UtilHelper.a(this.g, this.g.getCurrentFocus());
        }
    }

    private void a(com.baidu.tieba.data.bc bcVar) {
        if (bcVar != null && bcVar.a() != 0) {
            int b = bcVar.b();
            String string = this.g.getString(R.string.go_to_live_post_prefix);
            if (b == 0) {
                string = string + this.g.getString(R.string.go_to_interview_post);
            } else if (b == 1) {
                string = string + this.g.getString(R.string.go_to_discuss_post);
            }
            this.am.setText(string);
            this.am.setVisibility(0);
            this.am.setOnClickListener(this.z);
            ai();
        }
    }

    private void ah() {
        this.ap = (LinearLayout) this.l.findViewById(R.id.btn_show_passed_pb);
        this.aq = new PbListView(this.g, PbListView.IconType.ICON_UP_WARD);
        View a2 = this.aq.a();
        this.aq.a(this.g.getResources().getString(R.string.btn_show_passed_pb));
        this.aq.b(this.g.getResources().getDimensionPixelSize(R.dimen.pb_header_long_button_height));
        a2.setOnClickListener(this.at);
        this.ap.addView(a2);
        this.ap.requestLayout();
        this.ap.invalidate();
        this.aq.a(TiebaApplication.g().ap() == 1 ? R.drawable.button_load_next_1 : R.drawable.button_load_next);
        ai();
    }

    public void a(View view) {
        if (this.G == null) {
            this.G = new Dialog(this.g, R.style.common_alert_dialog);
            this.G.setCanceledOnTouchOutside(true);
            this.G.setCancelable(true);
            this.G.setContentView(this.g.getLayoutInflater().inflate(R.layout.forum_manage_dialog, (ViewGroup) null));
            WindowManager.LayoutParams attributes = this.G.getWindow().getAttributes();
            attributes.width = (int) (UtilHelper.a((Context) this.g) * 0.9d);
            this.G.getWindow().setAttributes(attributes);
        }
        Button button = (Button) this.G.findViewById(R.id.del_post_btn);
        Button button2 = (Button) this.G.findViewById(R.id.forbid_user_btn);
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
                button.setOnClickListener(new ct(this));
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
                button2.setOnClickListener(new cu(this));
            }
            this.G.show();
        }
    }

    public void a(bv bvVar) {
        this.au = bvVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        if (this.I == null) {
            this.I = new Dialog(this.g, R.style.common_alert_dialog);
            this.I.setCanceledOnTouchOutside(true);
            this.I.setCancelable(true);
            this.J = this.g.getLayoutInflater().inflate(R.layout.del_post, (ViewGroup) null);
            this.I.setContentView(this.J);
            WindowManager.LayoutParams attributes = this.I.getWindow().getAttributes();
            attributes.width = (int) (UtilHelper.a((Context) this.g) * 0.9d);
            this.I.getWindow().setAttributes(attributes);
            this.K = (Button) this.J.findViewById(R.id.dialog_button_ok);
            this.K.setOnClickListener(this.z);
            this.L = (Button) this.J.findViewById(R.id.dialog_button_cancel);
            this.L.setOnClickListener(new cv(this));
            this.M = (TextView) this.J.findViewById(R.id.confirm_text);
        }
        SparseArray sparseArray = (SparseArray) this.K.getTag();
        if (sparseArray == null) {
            sparseArray = new SparseArray();
            this.K.setTag(sparseArray);
        }
        sparseArray.put(R.id.tag_del_post_id, str);
        sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z));
        if (i == 0) {
            this.M.setText(R.string.del_thread_confirm);
        } else {
            this.M.setText(R.string.del_post_confirm);
        }
        this.I.show();
    }

    public void a(ArrayList<com.baidu.tieba.data.z> arrayList) {
        if (this.X == null) {
            this.X = new Dialog(this.g, R.style.common_alert_dialog);
            this.X.setCanceledOnTouchOutside(true);
            this.X.setCancelable(true);
            this.Y = this.g.getLayoutInflater().inflate(R.layout.commit_good, (ViewGroup) null);
            this.X.setContentView(this.Y);
            WindowManager.LayoutParams attributes = this.X.getWindow().getAttributes();
            attributes.width = (int) (UtilHelper.a((Context) this.g) * 0.9d);
            this.X.getWindow().setAttributes(attributes);
            this.aa = new cw(this);
            this.Z = (RadioGroup) this.Y.findViewById(R.id.good_class_group);
            this.ac = (Button) this.Y.findViewById(R.id.dialog_button_cancel);
            this.ac.setOnClickListener(new cx(this));
            this.ab = (Button) this.Y.findViewById(R.id.dialog_button_ok);
            this.ab.setOnClickListener(this.z);
        }
        this.Z.removeAllViews();
        LayoutInflater layoutInflater = this.g.getLayoutInflater();
        RadioButton radioButton = (RadioButton) layoutInflater.inflate(R.layout.good_class_radio_button, (ViewGroup) null);
        radioButton.setTag(SocialConstants.FALSE);
        radioButton.setText(this.g.getString(R.string.def_good_class));
        radioButton.setOnCheckedChangeListener(this.aa);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, -2);
        layoutParams.setMargins(UtilHelper.a((Context) this.g, 10.0f), UtilHelper.a((Context) this.g, 5.0f), UtilHelper.a((Context) this.g, 10.0f), UtilHelper.a((Context) this.g, 5.0f));
        this.Z.addView(radioButton, layoutParams);
        this.Z.requestLayout();
        this.Z.check(radioButton.getId());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < arrayList.size()) {
                RadioButton radioButton2 = (RadioButton) layoutInflater.inflate(R.layout.good_class_radio_button, (ViewGroup) null);
                radioButton2.setTag(String.valueOf(arrayList.get(i2).b()));
                radioButton2.setText(arrayList.get(i2).a());
                radioButton2.setOnCheckedChangeListener(this.aa);
                this.Z.addView(radioButton2, layoutParams);
                this.Z.requestLayout();
                i = i2 + 1;
            } else {
                this.X.show();
                return;
            }
        }
    }

    public void j() {
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

    public View k() {
        if (this.J != null) {
            return this.J.findViewById(R.id.dialog_button_ok);
        }
        return null;
    }

    public View l() {
        if (this.Y != null) {
            return this.Y.findViewById(R.id.dialog_button_ok);
        }
        return null;
    }

    public String m() {
        return this.ad;
    }

    public View n() {
        if (this.q != null) {
            return this.q.y();
        }
        return null;
    }

    public void o() {
        this.g.showProgressBar();
        UtilHelper.a(this.g, this.an.getEditText());
    }

    public void p() {
        if (this.q != null) {
            this.q.B();
        } else {
            this.g.showProgressBar();
        }
    }

    public void a(boolean z) {
        if (this.q != null) {
            this.q.C();
        } else {
            this.g.hideProgressBar();
        }
        Z();
        if (z) {
            this.an.getEditText().setText("");
            this.an.b();
            this.an.m();
            if (this.q != null) {
                this.q.v();
            }
        }
    }

    public void q() {
        this.v.c();
    }

    public void r() {
        this.g.hideProgressBar();
        this.v.d();
        this.aq.d();
        this.i.a();
        ai();
    }

    public void s() {
        this.i.a();
        this.ap.setVisibility(8);
        ai();
    }

    public void a(String str) {
        this.c.setText(str + this.g.getString(R.string.bar));
    }

    public void b(boolean z) {
        if (!z) {
            this.an.e();
        } else if (this.q != null) {
            this.q.c((String) null);
        }
    }

    public void t() {
        if (x() && this.q != null) {
            this.q.j();
        }
    }

    public void u() {
        if (this.q == null) {
            this.q = new ed(this.g, this.av, this.z, this.H, this.A, this.B);
            this.q.a(this.ao);
            this.q.a(this.m.a());
            this.q.a(this.C);
            this.q.c(this.m.c());
            this.q.b(this.m.d());
            this.x = this.q.n();
            this.q.a(this.D);
            this.q.a(this.m.b());
        }
        this.x.setVisibility(0);
        this.q.A();
        this.h.addView(this.x);
        al();
    }

    public void a(com.baidu.tieba.editortool.h hVar) {
        if (hVar != null) {
            this.an.setOnActionListener(new cy(this, hVar));
            this.ao = hVar;
            if (this.q != null) {
                this.q.a(hVar);
            }
        }
    }

    public void a(dx dxVar) {
        this.af = dxVar;
    }

    public void a(boolean z, com.baidu.tieba.data.av avVar, boolean z2, String str, String str2, View view, int i) {
        int i2;
        int i3;
        if (avVar != null && view != null) {
            if (TiebaApplication.g().s()) {
                StatService.onEvent(this.g, "pb_tosubpb", "pbclick", 1);
            }
            if (this.q == null) {
                this.q = new ed(this.g, this.av, this.z, this.H, this.A, this.B);
                this.q.a(this.ao);
                this.q.a(this.m.a());
                this.q.a(this.C);
                this.q.c(this.m.c());
                this.q.b(this.m.d());
                this.x = this.q.n();
                this.q.a(this.D);
                this.q.a(this.m.b());
            }
            this.q.c(this.m.e());
            this.q.a(avVar, i);
            if (str2 != null && !str2.equals("")) {
                this.q.d(str2);
            } else {
                this.q.d(1);
            }
            int height = this.f2106a.getHeight();
            if (view == null) {
                i2 = 0;
                i3 = 0;
            } else {
                int top = view.getTop() + height;
                i2 = view.getBottom() + height;
                i3 = top;
            }
            if (!z) {
                this.q.q();
            }
            int height2 = (view.getHeight() + this.i.getDividerHeight()) - (this.h.getHeight() - UtilHelper.a((Context) this.g, 43.0f));
            if (view.findViewById(R.id.sub_pb_more) == null) {
            }
            if (height2 > 0) {
                i3 += height2;
            }
            AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator(1.5f);
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, i3, 0.0f);
            translateAnimation.setDuration(300L);
            this.x.setAnimation(translateAnimation);
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
                if (i3 < height) {
                    i3 = height;
                }
                if (i3 > 0 && i3 < drawingCache.getHeight()) {
                    try {
                        bitmap2 = Bitmap.createBitmap(drawingCache, 0, 0, drawingCache.getWidth(), i3);
                    } catch (OutOfMemoryError e2) {
                        bitmap2 = null;
                    }
                }
            }
            this.x.setVisibility(0);
            if (this.x.getParent() == this.h) {
                this.h.removeView(this.x);
            }
            this.h.addView(this.x);
            if (bitmap2 != null) {
                ImageView imageView = new ImageView(this.g);
                imageView.setImageBitmap(bitmap2);
                this.h.addView(imageView);
                TranslateAnimation translateAnimation2 = new TranslateAnimation(0.0f, 0.0f, 0.0f, -i3);
                translateAnimation2.setDuration(300L);
                imageView.setAnimation(translateAnimation2);
                translateAnimation2.setAnimationListener(new cz(this, imageView));
                translateAnimation2.setInterpolator(accelerateInterpolator);
                translateAnimation2.start();
            }
            ImageView imageView2 = new ImageView(this.g);
            imageView2.setImageBitmap(bitmap);
            this.h.addView(imageView2);
            TranslateAnimation translateAnimation3 = new TranslateAnimation(0.0f, 0.0f, i2, this.h.getHeight());
            translateAnimation3.setDuration(300L);
            imageView2.setAnimation(translateAnimation3);
            translateAnimation3.setAnimationListener(new db(this, imageView2));
            translateAnimation.setAnimationListener(new de(this, avVar, z, str, str2));
            translateAnimation.setInterpolator(accelerateInterpolator);
            translateAnimation3.setInterpolator(accelerateInterpolator);
            translateAnimation3.start();
            translateAnimation.start();
        }
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.m.a(onLongClickListener);
        if (this.q != null) {
            this.q.a(onLongClickListener);
        }
    }

    public void v() {
        if (x()) {
            this.q.r();
        }
    }

    public void w() {
        if (x() && (this.q instanceof ea)) {
            ((ea) this.q).d();
        }
    }

    public boolean x() {
        return (this.x == null || this.x.getVisibility() == 8) ? false : true;
    }

    public void y() {
        if (this.x != null) {
            this.x.setVisibility(8);
            this.h.removeView(this.x);
            this.q.s();
        }
        Z();
        am();
    }

    public void z() {
        if (this.q != null) {
            this.q.D();
            if (this.q instanceof ea) {
                ((ea) this.q).e();
            }
        }
    }

    public void a(com.baidu.tieba.data.av avVar, int i) {
        if (this.q != null) {
            this.q.D();
            this.q.c(this.m.e());
            this.q.a(avVar, i);
        }
    }

    public void A() {
        if (this.q == null) {
            this.q = new ea(this.g, this.av, this.z, this.H, this.A, this.B);
            this.q.a(this.ao);
            this.q.a(this.m.a());
            this.q.a(this.C);
            this.q.c(this.m.c());
            this.q.b(this.m.d());
            this.x = this.q.n();
            this.q.a(this.D);
            this.q.a(this.m.b());
        }
        this.x.setVisibility(0);
        this.q.A();
        this.h.addView(this.x);
        al();
    }

    public void a(com.baidu.tieba.data.av avVar, int i, String str, boolean z, boolean z2) {
        if (this.q != null && (this.q instanceof ea)) {
            ea eaVar = (ea) this.q;
            this.q.D();
            this.q.c(this.m.e());
            this.q.a(avVar, i);
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
        com.baidu.tieba.util.bg.c("testing........" + str);
        this.an.a(str);
    }

    public void c(String str) {
        if (this.q != null) {
            this.q.b(str);
        }
    }

    public void B() {
        this.av = true;
        this.an.q();
    }

    public void C() {
        this.av = false;
        this.an.r();
    }

    public void a(DialogInterface.OnClickListener onClickListener, boolean z, boolean z2) {
        if (this.ag != null) {
            this.ag.dismiss();
            this.ag = null;
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
        this.ag = builder.create();
        this.ag.setCanceledOnTouchOutside(true);
        this.ag.show();
    }

    public void D() {
        if (this.p == null) {
            ak();
        }
        this.p.show();
    }

    public void c(boolean z) {
        this.an.setAudioFocusable(z);
    }

    public void d(boolean z) {
        if (this.q != null) {
            this.q.a(z);
        }
    }

    public void e(boolean z) {
        this.an.setImageFocusable(z);
    }

    public boolean E() {
        return this.an.t();
    }

    public Bitmap F() {
        return this.an.getImage();
    }

    public void a(Bitmap bitmap) {
        this.an.a(bitmap);
        this.an.a();
    }

    public void G() {
        this.an.u();
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

    public void a(int i) {
        this.i.setSelection(i);
    }

    public int I() {
        try {
            return Integer.parseInt(this.s.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public String J() {
        return this.an.getContent();
    }

    public void d(String str) {
        this.an.setContent(str);
    }

    public String K() {
        if (this.q == null) {
            return null;
        }
        return this.q.z();
    }

    public String L() {
        if (this.q != null) {
            return this.q.t();
        }
        return null;
    }

    public void a(com.baidu.tieba.data.an anVar) {
        this.m.a(anVar);
        this.m.notifyDataSetChanged();
        ai();
        if (this.q != null) {
            this.q.d(anVar.i());
        }
    }

    public void a(com.baidu.tieba.data.an anVar, int i, int i2, boolean z) {
        this.ak.setVisibility(0);
        this.al.setVisibility(0);
        this.ar = z;
        r();
        this.m.a(anVar);
        this.m.notifyDataSetChanged();
        a(anVar.c().getName());
        if (anVar.f().f() == 0 && !z) {
            this.i.setNextPage(null);
        } else {
            this.i.setNextPage(this.v);
            this.aq.d();
        }
        if (anVar.f().g() == 0 && z) {
            this.i.setPullRefresh(null);
            this.ap.setVisibility(8);
        } else {
            this.i.setPullRefresh(this.u);
            if (this.u != null) {
                this.u.a(TiebaApplication.g().ap());
            }
            this.ap.setVisibility(0);
            this.aq.d();
        }
        ai();
        if (TiebaApplication.g().ap() == 1) {
        }
        if (z) {
            if (anVar.f().f() == 0) {
                this.v.a(this.g.getResources().getString(R.string.no_more_to_load));
            } else {
                this.v.a(this.g.getResources().getString(R.string.pb_load_more));
            }
            this.aq.a(this.g.getResources().getString(R.string.btn_show_passed_pb));
        } else {
            this.aq.a(this.g.getResources().getString(R.string.btn_show_passed_pb_aftre));
        }
        if (anVar.d() != null && anVar.d().j() != null && anVar.d().j().getType() == 0) {
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
                } else if (anVar.e() != null) {
                    if (anVar.f() != null && anVar.f().g() != 0) {
                        this.i.setSelection(anVar.e().size() + 1);
                        return;
                    } else {
                        this.i.setSelection(anVar.e().size());
                        return;
                    }
                } else {
                    return;
                }
            default:
                return;
        }
    }

    public void f(boolean z) {
        this.ah = z;
        if (TiebaApplication.g().ap() == 1) {
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
        if (this.v != null) {
            this.v.d();
        }
        if (this.aq != null) {
            this.aq.d();
        }
    }

    public void a(boolean z, boolean z2) {
        if (!this.g.isProgressBarShown()) {
            if (this.n == null) {
                aj();
            }
            this.n.show();
            this.n.setContentView(this.t);
            TextView textView = (TextView) this.t.findViewById(R.id.reverse_txt);
            TextView textView2 = (TextView) this.t.findViewById(R.id.skip_txt);
            TextView textView3 = (TextView) this.t.findViewById(R.id.share_txt);
            TextView textView4 = (TextView) this.t.findViewById(R.id.mark_txt);
            textView.setOnClickListener(this.z);
            textView2.setOnClickListener(this.z);
            textView3.setOnClickListener(this.z);
            textView4.setOnClickListener(this.z);
            int ap = TiebaApplication.g().ap();
            this.g.getLayoutMode().a(ap == 1);
            this.g.getLayoutMode().a(this.t);
            if (ap == 1) {
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
            int height = this.f2106a.getHeight();
            WindowManager.LayoutParams attributes = this.n.getWindow().getAttributes();
            attributes.gravity = 53;
            attributes.x = 0;
            attributes.y = height;
            attributes.alpha = 1.0f;
            attributes.width = -1;
            attributes.height = -2;
            this.n.getWindow().setAttributes(attributes);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ai() {
        View findViewById = this.g.findViewById(R.id.manage_bottom_bar);
        View findViewById2 = this.g.findViewById(R.id.go_to_live_post);
        View findViewById3 = this.g.findViewById(R.id.btn_show_passed_pb);
        if ((findViewById != null && findViewById.getVisibility() == 0) || ((findViewById2 != null && findViewById2.getVisibility() == 0) || (findViewById3 != null && findViewById3.getVisibility() == 0))) {
            this.aj.setVisibility(0);
        } else {
            this.aj.setVisibility(8);
        }
    }

    public void a(com.baidu.tieba.data.an anVar, boolean z) {
        if (anVar != null) {
            TextView textView = (TextView) this.k.findViewById(R.id.pb_header_title);
            textView.setTextSize(com.baidu.tieba.data.h.p());
            TextView textView2 = (TextView) this.k.findViewById(R.id.pb_list_header_time);
            TextView textView3 = (TextView) this.k.findViewById(R.id.pb_list_header_reply);
            TextView textView4 = (TextView) this.k.findViewById(R.id.pb_list_header_bar);
            textView4.setOnClickListener(this.z);
            if (anVar.c() != null && anVar.c().getName() != null) {
                String name = anVar.c().getName();
                if (name.length() > 6) {
                    name = name.substring(0, 5) + this.g.getResources().getString(R.string.three_point);
                }
                textView4.setText(name + this.g.getResources().getString(R.string.bar));
            }
            anVar.d().t();
            textView.setText(anVar.d().r());
            if (anVar.d().d() != 0) {
                textView3.setText(String.valueOf(anVar.d().d()));
            } else {
                textView3.setVisibility(8);
            }
            this.k.setVisibility(0);
            ArrayList<com.baidu.tieba.data.ar> e = anVar.e();
            long j = -1;
            if (e.size() > 0) {
                com.baidu.tieba.data.ar arVar = e.get(0);
                if (arVar.e() == 1) {
                    j = arVar.f();
                }
                com.baidu.tieba.data.ar arVar2 = e.get(e.size() - 1);
                if (arVar2.e() == 1) {
                    j = arVar2.f();
                }
            }
            if (j > 0) {
                textView2.setVisibility(0);
                textView2.setText(com.baidu.tieba.util.be.b(j));
            }
            this.am = (Button) this.k.findViewById(R.id.go_to_live_post);
            com.baidu.tieba.data.az d = anVar.d();
            if (d != null) {
                a(d.i());
            }
            Button button = (Button) this.k.findViewById(R.id.pb_list_header_manage_btn);
            LinearLayout linearLayout = (LinearLayout) this.k.findViewById(R.id.manage_bottom_bar);
            if (!z) {
                linearLayout.setVisibility(8);
            }
            if (anVar.l() == 1) {
                button.setVisibility(0);
            } else {
                button.setVisibility(8);
            }
            button.setOnClickListener(new dg(this));
            Button button2 = (Button) this.k.findViewById(R.id.commit_top);
            button2.setOnClickListener(this.z);
            Button button3 = (Button) this.k.findViewById(R.id.cancel_top);
            button3.setOnClickListener(this.z);
            Button button4 = (Button) this.k.findViewById(R.id.commit_good);
            button4.setOnClickListener(this.z);
            Button button5 = (Button) this.k.findViewById(R.id.cancel_good);
            button5.setOnClickListener(this.z);
            if (anVar.d().g() == 1) {
                button4.setVisibility(8);
                button5.setVisibility(0);
            } else {
                button4.setVisibility(0);
                button5.setVisibility(8);
            }
            if (anVar.d().f() == 1) {
                button2.setVisibility(8);
                button3.setVisibility(0);
            } else {
                button2.setVisibility(0);
                button3.setVisibility(8);
            }
            ai();
        }
    }

    private void c(int i) {
        this.g.getLayoutMode().a(i == 1);
        this.g.getLayoutMode().a(this.h);
        TextView textView = (TextView) this.k.findViewById(R.id.pb_list_header_time);
        TextView textView2 = (TextView) this.k.findViewById(R.id.pb_list_header_reply);
        TextView textView3 = (TextView) this.k.findViewById(R.id.pb_list_header_bar);
        com.baidu.tieba.util.bd.a(this.b, i);
        f(this.ah);
        this.m.notifyDataSetChanged();
        if (i == 1) {
            textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_little_time_1, 0, 0, 0);
            textView2.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_little_comment_n_1, 0, 0, 0);
        } else {
            textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_little_time, 0, 0, 0);
            textView2.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_little_comment_n, 0, 0, 0);
        }
        this.an.d(i);
    }

    private void d(int i) {
        try {
            Button button = (Button) this.k.findViewById(R.id.pb_list_header_manage_btn);
            if (i == 1) {
                button.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_manage_n_1, 0, 0, 0);
            } else {
                button.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_manage_n, 0, 0, 0);
            }
        } catch (Exception e) {
            com.baidu.tieba.util.bg.b(getClass().getName(), "setBawuSkin", e.getMessage());
        }
    }

    public View N() {
        return this.w;
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
        if (this.q == null) {
            return null;
        }
        return this.q.w();
    }

    public void a(com.baidu.adp.widget.ListView.r rVar) {
        this.i.setOnSrollToBottomListener(rVar);
    }

    public void a(com.baidu.adp.widget.ListView.s sVar) {
        this.i.setOnSrollToTopListener(sVar);
    }

    public void a(DialogInterface.OnClickListener onClickListener) {
        this.y = onClickListener;
    }

    public void a(com.baidu.adp.widget.ListView.b bVar) {
        this.u.a(bVar);
    }

    private void aj() {
        this.n = new com.baidu.tieba.view.aw(this.g);
        this.t = this.g.getLayoutInflater().inflate(R.layout.new_pb_more, (ViewGroup) null);
        this.t.setOnTouchListener(new dh(this));
        this.n.setCanceledOnTouchOutside(true);
    }

    private void ak() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.g);
        builder.setTitle(this.g.getResources().getString(R.string.operation));
        builder.setItems(new String[]{this.g.getResources().getString(R.string.take_photo), this.g.getResources().getString(R.string.album)}, this.y);
        this.p = builder.create();
        this.p.setCanceledOnTouchOutside(true);
    }

    public void a(com.baidu.tieba.data.am amVar) {
        if (amVar != null) {
            int d = amVar.d();
            int a2 = amVar.a();
            if (this.o == null) {
                this.o = new Dialog(this.g, R.style.common_alert_dialog);
                this.o.setCanceledOnTouchOutside(true);
                this.o.setCancelable(true);
                this.r = this.g.getLayoutInflater().inflate(R.layout.dialog_direct_pager, (ViewGroup) null);
                this.o.setContentView(this.r);
                WindowManager.LayoutParams attributes = this.o.getWindow().getAttributes();
                attributes.gravity = 49;
                attributes.y = UtilHelper.a((Context) this.g, 54.0f);
                attributes.width = (int) (UtilHelper.a((Context) this.g) * 0.9d);
                this.o.getWindow().setAttributes(attributes);
                this.o.setOnKeyListener(new di(this));
            }
            this.o.show();
            ((Button) this.r.findViewById(R.id.dialog_button_ok)).setOnClickListener(this.z);
            ((Button) this.r.findViewById(R.id.dialog_button_cancel)).setOnClickListener(this.z);
            this.s = (EditText) this.r.findViewById(R.id.input_page_number);
            this.s.setText("");
            this.s.setOnFocusChangeListener(new dj(this));
            TextView textView = (TextView) this.r.findViewById(R.id.current_page_number);
            if (d <= 0) {
                d = 1;
            }
            textView.setText(MessageFormat.format(this.g.getApplicationContext().getResources().getString(R.string.current_page), Integer.valueOf(d), Integer.valueOf(a2 <= 0 ? 1 : a2)));
            this.g.ShowSoftKeyPadDelay(this.s, 150);
        }
    }

    public void a(AbsListView.OnScrollListener onScrollListener) {
        this.i.setOnScrollListener(onScrollListener);
    }

    public void b(AbsListView.OnScrollListener onScrollListener) {
        this.C = onScrollListener;
    }

    public void a(View.OnClickListener onClickListener) {
        this.A = onClickListener;
        this.m.a(onClickListener);
    }

    public void b(View.OnClickListener onClickListener) {
        this.B = onClickListener;
        this.m.b(onClickListener);
    }

    public void e(String str) {
        this.g.showToast(str);
    }

    public boolean g(boolean z) {
        if (this.q == null || !this.q.a()) {
            if (!z) {
                if (x()) {
                    y();
                    return true;
                } else if (this.an.i()) {
                    this.an.h();
                    return true;
                }
            } else if (x()) {
                y();
                return true;
            }
            return false;
        }
        return true;
    }

    public void a(com.baidu.tieba.view.ba baVar) {
        if (baVar != null) {
            if (!UtilHelper.b()) {
                UtilHelper.a((Context) this.g, (int) R.string.neterror);
                return;
            }
            baVar.e();
            if (this.aw != null) {
                this.aw.add(baVar);
            }
        }
    }

    public void b(com.baidu.tieba.view.ba baVar) {
        if (baVar != null) {
            this.aw.remove(baVar);
        }
    }

    public void W() {
        if (this.aw != null) {
            while (this.aw.size() > 0) {
                com.baidu.tieba.view.ba remove = this.aw.remove(0);
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
        if (this.j != null && this.E != null) {
            this.j.b(this.E);
        }
        Z();
        this.v.d();
        ad();
    }

    public void Z() {
        UtilHelper.a(this.g, this.s);
        this.an.f();
        if (this.n != null) {
            this.n.dismiss();
        }
        if (this.o != null) {
            this.o.dismiss();
        }
        if (this.ag != null) {
            this.ag.dismiss();
        }
        if (this.q != null) {
            this.q.q();
        }
        aa();
    }

    public void h(boolean z) {
        this.m.a(z);
        if (this.q != null) {
            this.q.c(z);
        }
    }

    public void i(boolean z) {
        this.m.b(z);
        if (this.q != null) {
            this.q.b(z);
        }
    }

    public void aa() {
        if (this.I != null) {
            this.I.dismiss();
        }
        if (this.N != null) {
            this.N.dismiss();
        }
        if (this.X != null) {
            this.X.dismiss();
        }
        if (this.G != null) {
            this.G.dismiss();
        }
    }

    public void ab() {
        if (this.q != null) {
            this.q.x();
        }
    }

    public com.baidu.adp.widget.ImageView.e a(View view, String str) {
        com.baidu.adp.widget.ImageView.e a2 = this.m.a().a(str, this.az, true);
        if (a2 == null && view != null && (view instanceof com.baidu.tieba.view.ba)) {
            a((com.baidu.tieba.view.ba) view);
        }
        return a2;
    }

    public void ac() {
        this.g.j();
        com.baidu.tieba.util.ak.a(this.i, this.m.a(), this.ay, this.ax, this.m.c() ? 0 : 1, 0);
    }

    public void ad() {
        try {
            this.m.a().b();
        } catch (Exception e) {
            com.baidu.tieba.util.bg.b(getClass().getName(), "stopLoadImage", "error = " + e.getMessage());
        }
    }

    public void b(int i) {
        this.g.getLayoutMode().a(i == 1);
        this.g.getLayoutMode().a(this.h);
        this.g.getLayoutMode().a(this.t);
        this.g.getLayoutMode().a(this.l);
        this.g.getLayoutMode().a(this.v.b());
        this.g.getLayoutMode().a(this.w);
        this.f2106a.c(i);
        d(i);
        c(i);
        if (this.q != null) {
            this.q.b(i);
        }
        if (this.u != null) {
            this.u.a(i);
        }
        if (this.v != null) {
            this.v.d(i);
        }
        if (this.aq != null) {
            this.aq.d(i);
            this.aq.a(i == 1 ? R.drawable.button_load_next_1 : R.drawable.button_load_next);
        }
    }

    public boolean ae() {
        return this.ae;
    }

    public void a(com.baidu.tbadk.widget.richText.n nVar) {
        this.D = nVar;
        this.m.a(this.D);
        if (this.q != null) {
            this.q.a(this.D);
        }
    }

    public void a(com.baidu.tieba.view.az azVar) {
        this.E = azVar;
        if (this.j != null) {
            this.j.a(this.E);
        }
    }

    public void j(boolean z) {
        this.m.a().d(z);
    }

    public View af() {
        if (this.q == null) {
            return null;
        }
        return this.q.E();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void al() {
        if (this.f2106a != null) {
            this.f2106a.setVisibility(8);
        }
        if (this.i != null) {
            this.i.setVisibility(8);
        }
        if (this.an != null) {
            this.an.setVisibility(8);
        }
    }

    private void am() {
        if (this.f2106a != null) {
            this.f2106a.setVisibility(0);
        }
        if (this.i != null) {
            this.i.setVisibility(0);
        }
        if (this.an != null) {
            this.an.setVisibility(0);
        }
    }

    public Button ag() {
        return this.am;
    }
}
