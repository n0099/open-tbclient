package com.baidu.tieba.pb;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Handler;
import android.text.InputFilter;
import android.text.TextWatcher;
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
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.location.LocationClientOption;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.ClickableLayout;
import com.baidu.tieba.view.ClickableLayout4Frame;
import com.baidu.tieba.view.KeyboardEventLayout;
import com.baidu.tieba.view.NoNetworkView;
import com.baidu.zeus.WebChromeClient;
import com.slidingmenu.lib.R;
import java.text.MessageFormat;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class bo {
    private com.baidu.tieba.view.ba E;
    private com.baidu.tieba.view.az F;
    private View G;
    private GridView I;
    private com.baidu.tieba.write.m J;
    private View.OnClickListener L;
    private Handler Q;
    private View.OnClickListener S;

    /* renamed from: a  reason: collision with root package name */
    public EditText f1518a;
    private com.baidu.tieba.g b;
    private KeyboardEventLayout c;
    private ClickableLayout d;
    private ClickableLayout4Frame e;
    private BdListView f;
    private NoNetworkView g;
    private ImageView h;
    private ImageView i;
    private ImageView j;
    private Button k;
    private Button l;
    private ImageButton m;
    private Button n;
    private Button o;
    private ImageButton p;
    private TextView q;
    private View r;
    private LinearLayout s;
    private LinearLayout t;
    private LinearLayout u;
    private bk v;
    private ProgressBar w;
    private Dialog x = null;
    private Dialog y = null;
    private Dialog z = null;
    private cv A = null;
    private View B = null;
    private EditText C = null;
    private View D = null;
    private View H = null;
    private DialogInterface.OnClickListener K = null;
    private View.OnClickListener M = null;
    private AbsListView.OnScrollListener N = null;
    private com.baidu.tbadk.widget.richText.m O = null;
    private com.baidu.tieba.view.ax P = null;
    private Dialog R = null;
    private Dialog T = null;
    private View U = null;
    private Button V = null;
    private Button W = null;
    private TextView X = null;
    private Dialog Y = null;
    private View Z = null;
    private int aa = 0;
    private RadioGroup ab = null;
    private RadioButton ac = null;
    private RadioButton ad = null;
    private RadioButton ae = null;
    private Button af = null;
    private Button ag = null;
    private TextView ah = null;
    private Dialog ai = null;
    private View aj = null;
    private RadioGroup ak = null;
    private CompoundButton.OnCheckedChangeListener al = null;
    private Button am = null;
    private Button an = null;
    private String ao = null;
    private boolean ap = false;
    private cu aq = null;
    private Dialog ar = null;
    private boolean as = false;
    private Runnable at = new bp(this);
    private View.OnTouchListener au = new cc(this);
    private com.baidu.tbadk.a.d av = new cj(this);
    private com.baidu.tbadk.a.d aw = new ck(this);
    private com.baidu.tieba.view.an ax = new cl(this);
    private TextWatcher ay = new cq(this);

    public NoNetworkView a() {
        return this.g;
    }

    public bo(NewPbActivity newPbActivity, View.OnClickListener onClickListener) {
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.f1518a = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.E = null;
        this.F = null;
        this.G = null;
        this.I = null;
        this.J = null;
        this.L = null;
        this.Q = null;
        this.S = null;
        this.b = newPbActivity;
        this.L = onClickListener;
        this.Q = new Handler();
        LayoutInflater from = LayoutInflater.from(this.b);
        this.c = (KeyboardEventLayout) from.inflate(R.layout.new_pb_activity, (ViewGroup) null);
        this.b.addContentView(this.c, new FrameLayout.LayoutParams(-2, -2));
        this.t = (LinearLayout) from.inflate(R.layout.reply_post, (ViewGroup) null);
        this.u = (LinearLayout) this.t.findViewById(R.id.extern);
        this.d = (ClickableLayout) this.b.findViewById(R.id.pb_title);
        this.d.setOnkeyUpListener(new cr(this));
        this.e = (ClickableLayout4Frame) this.b.findViewById(R.id.pb_center);
        this.e.setOnkeyUpListener(new cs(this));
        this.g = (NoNetworkView) this.b.findViewById(R.id.view_no_network);
        this.f = (BdListView) this.b.findViewById(R.id.new_pb_list);
        this.h = (ImageView) this.b.findViewById(R.id.pb_title_back);
        this.q = (TextView) this.b.findViewById(R.id.pb_title_forum);
        this.j = (ImageView) this.b.findViewById(R.id.pb_title_more);
        this.i = (ImageView) this.b.findViewById(R.id.pb_title_host);
        this.j.setScaleType(ImageView.ScaleType.CENTER);
        this.i.setScaleType(ImageView.ScaleType.CENTER);
        this.w = (ProgressBar) this.b.findViewById(R.id.progress);
        this.s = (LinearLayout) this.b.findViewById(R.id.pb_reply);
        this.s.addView(this.t);
        this.k = (Button) this.t.findViewById(R.id.pb_reply_post);
        this.l = (Button) this.t.findViewById(R.id.pb_button_face);
        this.m = (ImageButton) this.t.findViewById(R.id.pb_button_camera);
        this.f1518a = (EditText) this.t.findViewById(R.id.reply_content);
        this.n = (Button) this.u.findViewById(R.id.pb_button_face1);
        this.p = (ImageButton) this.u.findViewById(R.id.pb_button_camera1);
        this.o = (Button) this.u.findViewById(R.id.pb_button_at1);
        this.r = from.inflate(R.layout.new_pb_header_item, (ViewGroup) null);
        this.v = new bk(this.b);
        this.v.b(this.L);
        this.v.a(this.O);
        this.S = new ct(this);
        this.v.c(this.S);
        this.f.setAdapter((ListAdapter) this.v);
        this.f.addHeaderView(this.r);
        this.E = new com.baidu.tieba.view.ba(this.b);
        this.E.a();
        this.F = new com.baidu.tieba.view.az(this.b);
        this.G = this.F.b().findViewById(R.id.pb_more_view);
        if (this.G != null) {
            this.G.setOnClickListener(this.L);
        }
        this.I = (GridView) this.b.findViewById(R.id.face_view);
        this.J = new com.baidu.tieba.write.m(this.b);
        this.I.setAdapter((ListAdapter) this.J);
        this.I.setOnItemClickListener(new bq(this));
        this.h.setOnClickListener(this.L);
        this.q.setOnClickListener(this.L);
        this.j.setOnClickListener(this.L);
        this.i.setOnClickListener(this.L);
        this.k.setOnClickListener(this.L);
        this.m.setOnClickListener(this.L);
        this.l.setOnClickListener(this.L);
        this.p.setOnClickListener(this.L);
        this.n.setOnClickListener(this.L);
        this.o.setOnClickListener(this.L);
        this.f1518a.addTextChangedListener(this.ay);
        this.f1518a.setOnTouchListener(this.au);
        this.c.setOnKeyStateChangedListener(this.ax);
        this.f1518a.setFilters(new InputFilter[]{new InputFilter.LengthFilter(LocationClientOption.MIN_SCAN_SPAN)});
    }

    public void b() {
        if (this.ap && this.b.getCurrentFocus() != null) {
            this.ap = false;
            UtilHelper.a(this.b, this.b.getCurrentFocus());
        }
    }

    public void a(View view) {
        if (this.R == null) {
            this.R = new Dialog(this.b, R.style.common_alert_dialog);
            this.R.setCanceledOnTouchOutside(true);
            this.R.setCancelable(true);
            this.R.setContentView(this.b.getLayoutInflater().inflate(R.layout.forum_manage_dialog, (ViewGroup) null));
            WindowManager.LayoutParams attributes = this.R.getWindow().getAttributes();
            attributes.width = (int) (UtilHelper.a((Context) this.b) * 0.9d);
            this.R.getWindow().setAttributes(attributes);
        }
        Button button = (Button) this.R.findViewById(R.id.del_post_btn);
        Button button2 = (Button) this.R.findViewById(R.id.forbid_user_btn);
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
                button.setOnClickListener(new br(this));
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
                button2.setOnClickListener(new bs(this));
            }
            this.R.show();
        }
    }

    public void a(int i, String str, int i2, boolean z) {
        if (this.T == null) {
            this.T = new Dialog(this.b, R.style.common_alert_dialog);
            this.T.setCanceledOnTouchOutside(true);
            this.T.setCancelable(true);
            this.U = this.b.getLayoutInflater().inflate(R.layout.del_post, (ViewGroup) null);
            this.T.setContentView(this.U);
            WindowManager.LayoutParams attributes = this.T.getWindow().getAttributes();
            attributes.width = (int) (UtilHelper.a((Context) this.b) * 0.9d);
            this.T.getWindow().setAttributes(attributes);
            this.V = (Button) this.U.findViewById(R.id.dialog_button_ok);
            this.V.setOnClickListener(this.L);
            this.W = (Button) this.U.findViewById(R.id.dialog_button_cancel);
            this.W.setOnClickListener(new bt(this));
            this.X = (TextView) this.U.findViewById(R.id.confirm_text);
        }
        SparseArray sparseArray = (SparseArray) this.V.getTag();
        if (sparseArray == null) {
            sparseArray = new SparseArray();
            this.V.setTag(sparseArray);
        }
        sparseArray.put(R.id.tag_del_post_id, str);
        sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z));
        if (i == 0) {
            this.X.setText(R.string.del_thread_confirm);
        } else {
            this.X.setText(R.string.del_post_confirm);
        }
        this.T.show();
    }

    public void a(String str, int i) {
        if (this.Y == null) {
            this.Y = new Dialog(this.b, R.style.common_alert_dialog);
            this.Y.setCanceledOnTouchOutside(true);
            this.Y.setCancelable(true);
            this.Z = this.b.getLayoutInflater().inflate(R.layout.forbid_user, (ViewGroup) null);
            this.Y.setContentView(this.Z);
            WindowManager.LayoutParams attributes = this.Y.getWindow().getAttributes();
            attributes.width = (int) (UtilHelper.a((Context) this.b) * 0.9d);
            this.Y.getWindow().setAttributes(attributes);
            this.ab = (RadioGroup) this.Z.findViewById(R.id.radio_group);
            this.ac = (RadioButton) this.Z.findViewById(R.id.radio_button_1day);
            this.ad = (RadioButton) this.Z.findViewById(R.id.radio_button_3day);
            this.ae = (RadioButton) this.Z.findViewById(R.id.radio_button_10day);
            bu buVar = new bu(this);
            this.ac.setOnCheckedChangeListener(buVar);
            this.ad.setOnCheckedChangeListener(buVar);
            this.ae.setOnCheckedChangeListener(buVar);
            this.af = (Button) this.Z.findViewById(R.id.dialog_button_ok);
            this.af.setOnClickListener(this.L);
            this.ag = (Button) this.Z.findViewById(R.id.dialog_button_cancel);
            this.ag.setOnClickListener(new bv(this));
            this.ah = (TextView) this.Z.findViewById(R.id.user_name);
        }
        this.ah.setText(str);
        this.ab.check(R.id.radio_button_1day);
        if (i == 2) {
            this.ad.setVisibility(8);
            this.ae.setVisibility(8);
        }
        this.af.setTag(str);
        this.Y.show();
    }

    public void a(ArrayList arrayList) {
        if (this.ai == null) {
            this.ai = new Dialog(this.b, R.style.common_alert_dialog);
            this.ai.setCanceledOnTouchOutside(true);
            this.ai.setCancelable(true);
            this.aj = this.b.getLayoutInflater().inflate(R.layout.commit_good, (ViewGroup) null);
            this.ai.setContentView(this.aj);
            WindowManager.LayoutParams attributes = this.ai.getWindow().getAttributes();
            attributes.width = (int) (UtilHelper.a((Context) this.b) * 0.9d);
            this.ai.getWindow().setAttributes(attributes);
            this.al = new bw(this);
            this.ak = (RadioGroup) this.aj.findViewById(R.id.good_class_group);
            this.an = (Button) this.aj.findViewById(R.id.dialog_button_cancel);
            this.an.setOnClickListener(new bx(this));
            this.am = (Button) this.aj.findViewById(R.id.dialog_button_ok);
            this.am.setOnClickListener(this.L);
        }
        this.ak.removeAllViews();
        LayoutInflater layoutInflater = this.b.getLayoutInflater();
        RadioButton radioButton = (RadioButton) layoutInflater.inflate(R.layout.good_class_radio_button, (ViewGroup) null);
        radioButton.setTag("0");
        radioButton.setText(this.b.getString(R.string.def_good_class));
        radioButton.setOnCheckedChangeListener(this.al);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, -2);
        layoutParams.setMargins(UtilHelper.a((Context) this.b, 10.0f), UtilHelper.a((Context) this.b, 5.0f), UtilHelper.a((Context) this.b, 10.0f), UtilHelper.a((Context) this.b, 5.0f));
        this.ak.addView(radioButton, layoutParams);
        this.ak.requestLayout();
        this.ak.check(radioButton.getId());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < arrayList.size()) {
                RadioButton radioButton2 = (RadioButton) layoutInflater.inflate(R.layout.good_class_radio_button, (ViewGroup) null);
                radioButton2.setTag(String.valueOf(((com.baidu.tieba.data.aa) arrayList.get(i2)).b()));
                radioButton2.setText(((com.baidu.tieba.data.aa) arrayList.get(i2)).a());
                radioButton2.setOnCheckedChangeListener(this.al);
                this.ak.addView(radioButton2, layoutParams);
                this.ak.requestLayout();
                i = i2 + 1;
            } else {
                this.ai.show();
                return;
            }
        }
    }

    public void c() {
        this.w.setVisibility(0);
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.w.setVisibility(8);
        if (z && z2) {
            this.b.a(this.b.getString(R.string.success));
        } else if (str != null && z2) {
            this.b.a(str);
        }
    }

    public View d() {
        if (this.U != null) {
            return this.U.findViewById(R.id.dialog_button_ok);
        }
        return null;
    }

    public View e() {
        if (this.Z != null) {
            return this.Z.findViewById(R.id.dialog_button_ok);
        }
        return null;
    }

    public int f() {
        return this.aa;
    }

    public View g() {
        if (this.aj != null) {
            return this.aj.findViewById(R.id.dialog_button_ok);
        }
        return null;
    }

    public String h() {
        return this.ao;
    }

    public View i() {
        if (this.A == null) {
            return null;
        }
        return this.A.e();
    }

    public View j() {
        if (this.A == null) {
            return null;
        }
        return this.A.g();
    }

    public View k() {
        if (this.A != null) {
            return this.A.n();
        }
        return null;
    }

    public View l() {
        if (this.A == null) {
            return null;
        }
        return this.A.f();
    }

    public void m() {
        if (this.A != null) {
            this.A.b();
        }
    }

    public void n() {
        this.w.setVisibility(0);
        UtilHelper.a(this.b, this.f1518a);
    }

    public void o() {
        this.w.setVisibility(0);
        if (this.A != null) {
            this.A.q();
        }
    }

    public void a(boolean z) {
        this.w.setVisibility(8);
        if (this.A != null) {
            this.A.r();
        }
        P();
        if (z) {
            this.f1518a.setText("");
            this.k.setEnabled(false);
            x();
            if (this.A != null) {
                this.A.k();
            }
        }
    }

    public void p() {
        this.F.c();
    }

    public void q() {
        this.w.setVisibility(8);
        this.F.d();
        this.f.a();
    }

    public void r() {
        this.f.a();
    }

    public void a(String str) {
        this.q.setText(String.valueOf(str) + this.b.getString(R.string.bar));
    }

    public void b(boolean z) {
        if (!z) {
            A();
            W();
            this.f1518a.requestFocus();
            this.b.a(this.f1518a, 200);
        } else if (this.A != null) {
            this.A.b((String) null);
        }
    }

    public void s() {
        if (this.A == null) {
            this.A = new cv(this.b, this.L, this.S, this.M);
            this.A.a(this.v.a());
            this.A.a(this.N);
            this.A.b(this.v.c());
            this.A.a(this.v.d());
            this.H = this.A.d();
            this.A.a(this.O);
            this.A.a(this.v.b());
        }
        this.H.setVisibility(0);
        this.A.p();
        this.c.addView(this.H);
    }

    public void a(cu cuVar) {
        this.aq = cuVar;
    }

    public void a(boolean z, com.baidu.tieba.data.bd bdVar, boolean z2, String str, View view, int i) {
        int i2;
        int i3;
        if (bdVar != null && view != null) {
            if (TiebaApplication.g().u()) {
                StatService.onEvent(this.b, "pb_tosubpb", "pbclick", 1);
            }
            if (this.A == null) {
                this.A = new cv(this.b, this.L, this.S, this.M);
                this.A.a(this.v.a());
                this.A.a(this.N);
                this.A.b(this.v.c());
                this.A.a(this.v.d());
                this.H = this.A.d();
                this.A.a(this.O);
                this.A.a(this.v.b());
            }
            this.A.a(this.v.e());
            this.A.a(bdVar, i);
            this.A.b(1);
            int height = this.d.getHeight();
            if (view == null) {
                i2 = 0;
                i3 = 0;
            } else {
                int top = view.getTop() + height;
                i2 = view.getBottom() + height;
                i3 = top;
            }
            if (!z) {
                this.A.h();
            }
            int height2 = (view.getHeight() + this.f.getDividerHeight()) - (this.c.getHeight() - UtilHelper.a((Context) this.b, 43.0f));
            view.findViewById(R.id.sub_pb_more);
            if (height2 > 0) {
                i3 += height2;
            }
            AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator(1.5f);
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, i3, 0.0f);
            translateAnimation.setDuration(300L);
            this.H.setAnimation(translateAnimation);
            this.c.invalidate();
            this.c.buildDrawingCache();
            Bitmap drawingCache = this.c.getDrawingCache();
            Bitmap bitmap = null;
            Bitmap bitmap2 = null;
            if (drawingCache != null) {
                if (i2 > 0 && i2 < drawingCache.getHeight()) {
                    bitmap = Bitmap.createBitmap(drawingCache, 0, i2, drawingCache.getWidth(), drawingCache.getHeight() - i2);
                }
                if (i3 < height) {
                    i3 = height;
                }
                if (i3 > 0 && i3 < drawingCache.getHeight()) {
                    bitmap2 = Bitmap.createBitmap(drawingCache, 0, 0, drawingCache.getWidth(), i3);
                }
            }
            this.H.setVisibility(0);
            if (this.H.getParent() == this.c) {
                this.c.removeView(this.H);
            }
            this.c.addView(this.H);
            if (bitmap2 != null) {
                ImageView imageView = new ImageView(this.b);
                imageView.setImageBitmap(bitmap2);
                this.c.addView(imageView);
                TranslateAnimation translateAnimation2 = new TranslateAnimation(0.0f, 0.0f, 0.0f, -i3);
                translateAnimation2.setDuration(300L);
                imageView.setAnimation(translateAnimation2);
                translateAnimation2.setAnimationListener(new by(this, imageView));
                translateAnimation2.setInterpolator(accelerateInterpolator);
                translateAnimation2.start();
            }
            ImageView imageView2 = new ImageView(this.b);
            imageView2.setImageBitmap(bitmap);
            this.c.addView(imageView2);
            TranslateAnimation translateAnimation3 = new TranslateAnimation(0.0f, 0.0f, i2, this.c.getHeight());
            translateAnimation3.setDuration(300L);
            imageView2.setAnimation(translateAnimation3);
            translateAnimation3.setAnimationListener(new ca(this, imageView2));
            translateAnimation.setAnimationListener(new cd(this, bdVar, z, str));
            translateAnimation.setInterpolator(accelerateInterpolator);
            translateAnimation3.setInterpolator(accelerateInterpolator);
            translateAnimation3.start();
            translateAnimation.start();
        }
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.v.a(onLongClickListener);
        if (this.A != null) {
            this.A.a(onLongClickListener);
        }
    }

    public void t() {
        if (u()) {
            this.A.i();
        }
    }

    public boolean u() {
        return (this.H == null || this.H.getVisibility() == 8) ? false : true;
    }

    public void v() {
        if (this.H != null) {
            this.H.setVisibility(8);
            this.c.removeView(this.H);
            this.A.j();
        }
        P();
    }

    public void w() {
        if (this.A != null) {
            this.A.s();
        }
    }

    public void a(com.baidu.tieba.data.bd bdVar, int i) {
        if (this.A != null) {
            this.A.s();
            this.A.a(this.v.e());
            this.A.a(bdVar, i);
        }
    }

    public void b(String str) {
        this.f1518a.getText().insert(this.f1518a.getSelectionStart(), "@" + str + " ");
    }

    public void c(String str) {
        if (this.A != null) {
            this.A.a(str);
        }
    }

    public void a(Bitmap bitmap) {
        if (bitmap != null) {
            this.m.setImageBitmap(bitmap);
            this.m.setTag(bitmap);
            this.p.setImageBitmap(bitmap);
            this.p.setTag(bitmap);
            this.k.setEnabled(true);
        }
    }

    public void x() {
        this.m.setImageBitmap(null);
        this.m.setTag(null);
        this.p.setImageBitmap(null);
        this.p.setTag(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V() {
        this.l.setVisibility(0);
        this.m.setVisibility(0);
        this.u.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W() {
        this.l.setVisibility(8);
        this.m.setVisibility(8);
        this.u.setVisibility(0);
    }

    public void y() {
        W();
        this.f1518a.requestFocus();
        if (this.I.getVisibility() == 8) {
            this.l.setBackgroundResource(R.drawable.new_pb_keyboard_btn);
            this.n.setBackgroundResource(R.drawable.new_pb_keyboard_btn);
            UtilHelper.a(this.b, this.f1518a);
            this.Q.postDelayed(this.at, 200L);
            return;
        }
        this.f1518a.setSelection(this.f1518a.getText().length());
        this.l.setBackgroundResource(R.drawable.new_pb_face_btn);
        this.n.setBackgroundResource(R.drawable.new_pb_face_btn);
        this.I.setVisibility(8);
        this.b.a(this.f1518a, 200);
    }

    public void a(DialogInterface.OnClickListener onClickListener, boolean z, boolean z2) {
        if (this.ar != null) {
            this.ar.dismiss();
            this.ar = null;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this.b);
        builder.setTitle(R.string.operation);
        if (z2) {
            builder.setItems(new String[]{this.b.getString(R.string.copy)}, onClickListener);
        } else if (!z) {
            builder.setItems(new String[]{this.b.getString(R.string.copy), this.b.getString(R.string.mark)}, onClickListener);
        } else {
            builder.setItems(new String[]{this.b.getString(R.string.copy), this.b.getString(R.string.remove_mark)}, onClickListener);
        }
        this.ar = builder.create();
        this.ar.setCanceledOnTouchOutside(true);
        this.ar.show();
    }

    public boolean z() {
        return this.I.getVisibility() == 0;
    }

    public void A() {
        V();
        this.l.setBackgroundResource(R.drawable.new_pb_face_btn);
        this.n.setBackgroundResource(R.drawable.new_pb_face_btn);
        this.I.setVisibility(8);
    }

    public void B() {
        if (this.z == null) {
            Y();
        }
        this.z.show();
    }

    public int C() {
        int firstVisiblePosition = this.f.getFirstVisiblePosition();
        int i = (this.f.getChildAt(0) == null || this.f.getChildAt(0).getBottom() >= this.f.getHeight()) ? firstVisiblePosition : firstVisiblePosition + 1;
        int c = (this.f.getAdapter() == null || !(this.f.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) ? 0 : ((com.baidu.adp.widget.ListView.e) this.f.getAdapter()).c();
        if (i > c) {
            return i - c;
        }
        return 0;
    }

    public void a(int i) {
        this.f.setSelection(i);
    }

    public int D() {
        try {
            return Integer.parseInt(this.C.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public String E() {
        return this.f1518a.getText().toString();
    }

    public String F() {
        if (this.A == null) {
            return null;
        }
        return this.A.o();
    }

    public void a(com.baidu.tieba.data.ao aoVar) {
        this.v.a(aoVar);
        this.v.notifyDataSetChanged();
    }

    public void a(com.baidu.tieba.data.ao aoVar, int i, int i2, boolean z) {
        q();
        this.v.a(aoVar);
        this.v.notifyDataSetChanged();
        a(aoVar.b().b());
        if (aoVar.e().f() == 0 && !z) {
            this.f.setNextPage(null);
        } else {
            this.f.setNextPage(this.F);
        }
        if (aoVar.e().g() == 0 && z) {
            this.f.setPullRefresh(null);
        } else {
            this.f.setPullRefresh(this.E);
        }
        if (z) {
            if (aoVar.e().f() == 0) {
                this.F.a(this.b.getResources().getString(R.string.no_more_to_load));
            } else {
                this.F.a(this.b.getResources().getString(R.string.load_more));
            }
        }
        if (aoVar.c() != null && aoVar.c().g() != null && aoVar.c().g().getType() == 0) {
            this.i.setVisibility(4);
            this.i.setEnabled(false);
        }
        switch (i) {
            case 2:
                this.f.setSelection(i2);
                CompatibleUtile.scrollListViewBy(this.f, -this.r.getHeight(), 0);
                return;
            case 3:
            case 5:
                this.f.setSelection(0);
                return;
            case 4:
            case 6:
                if (z) {
                    this.f.setSelection(0);
                    return;
                } else if (aoVar.d() != null) {
                    if (aoVar.e() != null && aoVar.e().g() != 0) {
                        this.f.setSelection(aoVar.d().size() + 1);
                        return;
                    } else {
                        this.f.setSelection(aoVar.d().size());
                        return;
                    }
                } else {
                    return;
                }
            default:
                return;
        }
    }

    public void c(boolean z) {
        this.as = z;
        if (TiebaApplication.g().an() == 1) {
            if (z) {
                this.i.setImageResource(R.drawable.icon_floor_host_s_1);
            } else {
                this.i.setImageResource(R.drawable.icon_floor_host_n_1);
            }
        } else if (z) {
            this.i.setImageResource(R.drawable.icon_floor_host_s);
        } else {
            this.i.setImageResource(R.drawable.icon_floor_host_n);
        }
    }

    public void a(boolean z, boolean z2) {
        if (this.x == null) {
            X();
        }
        this.x.show();
        this.x.setContentView(this.D);
        ((LinearLayout) this.D.findViewById(R.id.reverse_layout)).setOnClickListener(this.L);
        ((LinearLayout) this.D.findViewById(R.id.skip_layout)).setOnClickListener(this.L);
        ((LinearLayout) this.D.findViewById(R.id.share_layout)).setOnClickListener(this.L);
        ((LinearLayout) this.D.findViewById(R.id.mark_layout)).setOnClickListener(this.L);
        ImageView imageView = (ImageView) this.D.findViewById(R.id.reverse_image);
        ImageView imageView2 = (ImageView) this.D.findViewById(R.id.mark_image);
        if (!z) {
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(4);
        }
        if (z2) {
            imageView2.setVisibility(0);
        } else {
            imageView2.setVisibility(4);
        }
        int height = this.d.getHeight();
        WindowManager.LayoutParams attributes = this.x.getWindow().getAttributes();
        attributes.gravity = 53;
        attributes.x = 0;
        attributes.y = height;
        attributes.alpha = 1.0f;
        attributes.width = UtilHelper.a((Context) this.b, 134.0f);
        attributes.height = -2;
        this.x.getWindow().setAttributes(attributes);
    }

    public void a(com.baidu.tieba.data.ao aoVar, boolean z) {
        if (aoVar != null) {
            TextView textView = (TextView) this.r.findViewById(R.id.pb_header_title);
            textView.setTextSize(com.baidu.tieba.data.g.p());
            TextView textView2 = (TextView) this.r.findViewById(R.id.pb_list_header_time);
            TextView textView3 = (TextView) this.r.findViewById(R.id.pb_list_header_reply);
            Button button = (Button) this.r.findViewById(R.id.pb_list_header_bar);
            button.setOnClickListener(this.L);
            if (aoVar.b() != null && aoVar.b().b() != null) {
                String b = aoVar.b().b();
                if (b.length() > 6) {
                    b = String.valueOf(b.substring(0, 5)) + this.b.getResources().getString(R.string.three_point);
                }
                button.setText(String.valueOf(b) + this.b.getResources().getString(R.string.bar));
            }
            aoVar.c().o();
            textView.setText(aoVar.c().n());
            if (aoVar.c().c() != 0) {
                textView3.setText(String.valueOf(aoVar.c().c()));
            } else {
                textView3.setVisibility(8);
            }
            this.r.setVisibility(0);
            ArrayList d = aoVar.d();
            long j = -1;
            if (d.size() > 0) {
                com.baidu.tieba.data.as asVar = (com.baidu.tieba.data.as) d.get(0);
                if (asVar.e() == 1) {
                    j = asVar.f();
                }
                com.baidu.tieba.data.as asVar2 = (com.baidu.tieba.data.as) d.get(d.size() - 1);
                if (asVar2.e() == 1) {
                    j = asVar2.f();
                }
            }
            if (j > 0) {
                textView2.setVisibility(0);
                textView2.setText(com.baidu.tieba.util.ap.a(j));
            }
            Button button2 = (Button) this.r.findViewById(R.id.pb_list_header_manage_btn);
            LinearLayout linearLayout = (LinearLayout) this.r.findViewById(R.id.manage_bottom_bar);
            if (!z) {
                linearLayout.setVisibility(8);
            }
            if (aoVar.j() == 1) {
                button2.setVisibility(0);
            } else {
                button2.setVisibility(8);
            }
            button2.setOnClickListener(new cf(this));
            Button button3 = (Button) this.r.findViewById(R.id.commit_top);
            button3.setOnClickListener(this.L);
            Button button4 = (Button) this.r.findViewById(R.id.cancel_top);
            button4.setOnClickListener(this.L);
            Button button5 = (Button) this.r.findViewById(R.id.commit_good);
            button5.setOnClickListener(this.L);
            Button button6 = (Button) this.r.findViewById(R.id.cancel_good);
            button6.setOnClickListener(this.L);
            if (aoVar.c().f() == 1) {
                button5.setVisibility(8);
                button6.setVisibility(0);
            } else {
                button5.setVisibility(0);
                button6.setVisibility(8);
            }
            if (aoVar.c().e() == 1) {
                button3.setVisibility(8);
                button4.setVisibility(0);
                return;
            }
            button3.setVisibility(0);
            button4.setVisibility(8);
        }
    }

    private void c(int i) {
        TextView textView = (TextView) this.r.findViewById(R.id.pb_list_header_time);
        TextView textView2 = (TextView) this.r.findViewById(R.id.pb_list_header_reply);
        Button button = (Button) this.r.findViewById(R.id.pb_list_header_bar);
        com.baidu.tieba.util.ao.c((TextView) this.r.findViewById(R.id.pb_header_title), i);
        com.baidu.tieba.util.ao.d(textView, i);
        com.baidu.tieba.util.ao.d(textView2, i);
        com.baidu.tieba.util.ao.d(this.d, i);
        com.baidu.tieba.util.ao.a(this.h, i);
        this.E.a(i);
        c(this.as);
        this.v.notifyDataSetChanged();
        if (i == 1) {
            this.l.setBackgroundResource(R.drawable.new_pb_face_btn_1);
            this.m.setBackgroundResource(R.drawable.new_pb_camera_btn_1);
            this.n.setBackgroundResource(R.drawable.new_pb_face_btn_1);
            this.p.setBackgroundResource(R.drawable.new_pb_camera_btn_1);
            this.o.setBackgroundResource(R.drawable.new_pb_at_btn_1);
            this.r.setBackgroundResource(R.drawable.bg_topbar_1);
            com.baidu.tieba.util.ao.g((View) this.k, (int) R.drawable.btn_post_dl_selector_1);
            this.k.setTextColor(this.b.getResources().getColorStateList(R.color.post_image_btn_color_1));
            this.c.setBackgroundResource(R.drawable.common_bg_1);
            this.i.setBackgroundResource(R.drawable.title_icon_bg_1);
            this.j.setBackgroundResource(R.drawable.title_icon_bg_1);
            com.baidu.tieba.util.ao.g((View) button, (int) R.drawable.pb_button_bar_drawable_1);
            button.setTextColor(this.b.getResources().getColorStateList(R.color.text_blue_white_color_1));
            textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_little_time_1, 0, 0, 0);
            textView2.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_little_comment_1, 0, 0, 0);
            com.baidu.tieba.util.ao.g(this.G, (int) R.drawable.bg_list_all_1);
            return;
        }
        this.l.setBackgroundResource(R.drawable.new_pb_face_btn);
        this.m.setBackgroundResource(R.drawable.new_pb_camera_btn);
        this.n.setBackgroundResource(R.drawable.new_pb_face_btn);
        this.p.setBackgroundResource(R.drawable.new_pb_camera_btn);
        this.o.setBackgroundResource(R.drawable.new_pb_at_btn);
        this.r.setBackgroundResource(R.drawable.bg_topbar);
        com.baidu.tieba.util.ao.g((View) this.k, (int) R.drawable.btn_post_dl_selector);
        this.k.setTextColor(this.b.getResources().getColorStateList(R.color.post_image_btn_color));
        this.c.setBackgroundResource(R.drawable.common_bg);
        this.i.setBackgroundResource(R.drawable.title_icon_bg);
        this.j.setBackgroundResource(R.drawable.title_icon_bg);
        com.baidu.tieba.util.ao.g((View) button, (int) R.drawable.pb_button_bar_drawable);
        button.setTextColor(this.b.getResources().getColorStateList(R.color.text_blue_white_color));
        textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_little_time, 0, 0, 0);
        textView2.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_little_comment, 0, 0, 0);
        com.baidu.tieba.util.ao.g(this.G, (int) R.drawable.bg_list_all);
    }

    private void d(int i) {
        try {
            Button button = (Button) this.r.findViewById(R.id.pb_list_header_manage_btn);
            LinearLayout linearLayout = (LinearLayout) this.r.findViewById(R.id.manage_bottom_bar);
            Button button2 = (Button) this.r.findViewById(R.id.commit_top);
            Button button3 = (Button) this.r.findViewById(R.id.cancel_top);
            Button button4 = (Button) this.r.findViewById(R.id.commit_good);
            Button button5 = (Button) this.r.findViewById(R.id.cancel_good);
            View findViewById = this.r.findViewById(R.id.line2);
            if (i == 1) {
                linearLayout.setBackgroundResource(R.drawable.pb_title_bottom_bar_bg_1);
                com.baidu.tieba.util.ao.g((View) button, (int) R.drawable.common_image_btn_selector_1);
                button.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_manage_dl_selector_1, 0, 0, 0);
                button.setTextColor(this.b.getResources().getColorStateList(R.color.common_image_btn_color_1));
                button2.setTextColor(this.b.getResources().getColorStateList(R.color.forum_manage_btn_color_1));
                button3.setTextColor(this.b.getResources().getColorStateList(R.color.forum_manage_btn_color_1));
                button4.setTextColor(this.b.getResources().getColorStateList(R.color.forum_manage_btn_color_1));
                button5.setTextColor(this.b.getResources().getColorStateList(R.color.forum_manage_btn_color_1));
                button2.setBackgroundResource(R.drawable.pb_title_topgood_btn_bg_1);
                button3.setBackgroundResource(R.drawable.pb_title_topgood_btn_bg_1);
                button4.setBackgroundResource(R.drawable.pb_title_topgood_btn_bg_1);
                button5.setBackgroundResource(R.drawable.pb_title_topgood_btn_bg_1);
                findViewById.setBackgroundColor(-14144716);
            } else {
                linearLayout.setBackgroundResource(R.drawable.pb_title_bottom_bar_bg);
                com.baidu.tieba.util.ao.g((View) button, (int) R.drawable.common_image_btn_selector);
                button.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_manage_dl_selector, 0, 0, 0);
                button.setTextColor(this.b.getResources().getColorStateList(R.color.common_image_btn_color));
                button2.setTextColor(this.b.getResources().getColorStateList(R.color.forum_manage_btn_color));
                button3.setTextColor(this.b.getResources().getColorStateList(R.color.forum_manage_btn_color));
                button4.setTextColor(this.b.getResources().getColorStateList(R.color.forum_manage_btn_color));
                button5.setTextColor(this.b.getResources().getColorStateList(R.color.forum_manage_btn_color));
                button2.setBackgroundResource(R.drawable.pb_title_topgood_btn_bg);
                button3.setBackgroundResource(R.drawable.pb_title_topgood_btn_bg);
                button4.setBackgroundResource(R.drawable.pb_title_topgood_btn_bg);
                button5.setBackgroundResource(R.drawable.pb_title_topgood_btn_bg);
                findViewById.setBackgroundColor(-2696478);
            }
        } catch (Exception e) {
            com.baidu.tieba.util.aq.b(getClass().getName(), "setBawuSkin", e.getMessage());
        }
    }

    public View G() {
        return this.G;
    }

    public BdListView H() {
        return this.f;
    }

    public int I() {
        return R.id.richText;
    }

    public Button J() {
        return (Button) this.r.findViewById(R.id.commit_good);
    }

    public Button K() {
        return (Button) this.r.findViewById(R.id.cancel_good);
    }

    public Button L() {
        return (Button) this.r.findViewById(R.id.commit_top);
    }

    public Button M() {
        return (Button) this.r.findViewById(R.id.cancel_top);
    }

    public View N() {
        if (this.A == null) {
            return null;
        }
        return this.A.l();
    }

    public void a(com.baidu.adp.widget.ListView.r rVar) {
        this.f.setOnSrollToBottomListener(rVar);
    }

    public void a(com.baidu.adp.widget.ListView.s sVar) {
        this.f.setOnSrollToTopListener(sVar);
    }

    public void a(DialogInterface.OnClickListener onClickListener) {
        this.K = onClickListener;
    }

    public void a(com.baidu.adp.widget.ListView.b bVar) {
        this.E.a(bVar);
    }

    private void X() {
        this.x = new com.baidu.tieba.view.au(this.b);
        this.D = this.b.getLayoutInflater().inflate(R.layout.new_pb_more, (ViewGroup) null);
        this.D.setOnTouchListener(new cg(this));
        this.x.setCanceledOnTouchOutside(true);
    }

    private void Y() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.b);
        builder.setTitle(this.b.getResources().getString(R.string.operation));
        builder.setItems(new String[]{this.b.getResources().getString(R.string.take_photo), this.b.getResources().getString(R.string.album)}, this.K);
        this.z = builder.create();
        this.z.setCanceledOnTouchOutside(true);
    }

    public void a(com.baidu.tieba.data.an anVar) {
        if (anVar != null) {
            int d = anVar.d();
            int a2 = anVar.a();
            if (this.y == null) {
                this.y = new Dialog(this.b, R.style.common_alert_dialog);
                this.y.setCanceledOnTouchOutside(true);
                this.y.setCancelable(true);
                this.B = this.b.getLayoutInflater().inflate(R.layout.dialog_direct_pager, (ViewGroup) null);
                this.y.setContentView(this.B);
                WindowManager.LayoutParams attributes = this.y.getWindow().getAttributes();
                attributes.gravity = 49;
                attributes.y = UtilHelper.a((Context) this.b, 54.0f);
                attributes.width = (int) (UtilHelper.a((Context) this.b) * 0.9d);
                this.y.getWindow().setAttributes(attributes);
                this.y.setOnKeyListener(new ch(this));
            }
            this.y.show();
            ((Button) this.B.findViewById(R.id.dialog_button_ok)).setOnClickListener(this.L);
            ((Button) this.B.findViewById(R.id.dialog_button_cancel)).setOnClickListener(this.L);
            this.C = (EditText) this.B.findViewById(R.id.input_page_number);
            this.C.setText("");
            this.C.setOnFocusChangeListener(new ci(this));
            TextView textView = (TextView) this.B.findViewById(R.id.current_page_number);
            if (d <= 0) {
                d = 1;
            }
            textView.setText(MessageFormat.format(this.b.getApplicationContext().getResources().getString(R.string.current_page), Integer.valueOf(d), Integer.valueOf(a2 <= 0 ? 1 : a2)));
            this.b.a(this.C, WebChromeClient.STRING_DLG_BTN_SET);
        }
    }

    public void a(AbsListView.OnScrollListener onScrollListener) {
        this.f.setOnScrollListener(onScrollListener);
    }

    public void b(AbsListView.OnScrollListener onScrollListener) {
        this.N = onScrollListener;
    }

    public void a(View.OnClickListener onClickListener) {
        this.M = onClickListener;
        this.v.a(onClickListener);
    }

    public void d(String str) {
        this.b.a(str);
    }

    public boolean d(boolean z) {
        if (this.A == null || !this.A.a()) {
            if (!z) {
                if (u()) {
                    v();
                    return true;
                } else if (this.I.getVisibility() == 0) {
                    this.I.setVisibility(8);
                    V();
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public void O() {
        if (this.w != null) {
            this.w.setVisibility(8);
        }
        if (this.g != null && this.P != null) {
            this.g.b(this.P);
        }
        P();
        this.F.d();
        T();
    }

    public void P() {
        A();
        V();
        UtilHelper.a(this.b, this.C);
        UtilHelper.a(this.b, this.f1518a);
        if (this.x != null) {
            this.x.dismiss();
        }
        if (this.y != null) {
            this.y.dismiss();
        }
        if (this.ar != null) {
            this.ar.dismiss();
        }
        if (this.A != null) {
            this.A.h();
        }
        Q();
    }

    public void e(boolean z) {
        this.v.a(z);
        if (this.A != null) {
            this.A.b(z);
        }
    }

    public void f(boolean z) {
        this.v.b(z);
        if (this.A != null) {
            this.A.a(z);
        }
    }

    public void Q() {
        if (this.T != null) {
            this.T.dismiss();
        }
        if (this.Y != null) {
            this.Y.dismiss();
        }
        if (this.ai != null) {
            this.ai.dismiss();
        }
        if (this.R != null) {
            this.R.dismiss();
        }
    }

    public void R() {
        if (this.A != null) {
            this.A.m();
        }
    }

    public com.baidu.adp.widget.a.b e(String str) {
        return this.v.a().a(str, this.av);
    }

    public void S() {
        int i;
        int i2;
        int i3;
        int i4;
        try {
            int c = ((com.baidu.adp.widget.ListView.e) this.f.getAdapter()).c();
            int firstVisiblePosition = this.f.getFirstVisiblePosition() - c;
            int lastVisiblePosition = this.f.getLastVisiblePosition() - c;
            if (firstVisiblePosition < 0) {
                firstVisiblePosition = 0;
            }
            UtilHelper.NetworkStateInfo i5 = UtilHelper.i(this.b);
            this.v.a().a();
            boolean z = i5 == UtilHelper.NetworkStateInfo.WIFI || i5 == UtilHelper.NetworkStateInfo.ThreeG;
            this.v.a().a(z);
            int i6 = firstVisiblePosition;
            int i7 = 0;
            int i8 = 0;
            while (i6 < this.v.getCount()) {
                if (z || i6 <= lastVisiblePosition) {
                    com.baidu.tieba.data.as asVar = (com.baidu.tieba.data.as) this.v.getItem(i6);
                    if (asVar != null) {
                        ArrayList a2 = asVar.h().a();
                        int size = a2.size();
                        if (!this.v.c() || i8 >= 13) {
                            i3 = i8;
                        } else {
                            int i9 = 0;
                            int i10 = i8;
                            while (true) {
                                if (i9 >= size) {
                                    i3 = i10;
                                    break;
                                }
                                if (((com.baidu.tbadk.widget.richText.c) a2.get(i9)).a() == 8) {
                                    if (i10 >= 13) {
                                        i3 = i10;
                                        break;
                                    } else {
                                        i10++;
                                        this.v.a().a(((com.baidu.tbadk.widget.richText.c) a2.get(i9)).c().d(), this.av);
                                    }
                                }
                                i9++;
                                i10 = i10;
                            }
                        }
                        String portrait = asVar.g().getPortrait();
                        if (!this.v.d() || portrait == null || portrait.length() <= 0 || i7 >= 30) {
                            i4 = i7;
                        } else {
                            i4 = i7 + 1;
                            this.v.a().d(portrait, this.aw);
                        }
                        int i11 = 0;
                        while (true) {
                            i = i4;
                            if (i11 >= asVar.a().size()) {
                                break;
                            }
                            String portrait2 = ((com.baidu.tieba.data.as) asVar.a().get(i11)).g().getPortrait();
                            if (!this.v.d() || portrait2 == null || portrait2.length() <= 0 || i >= 30) {
                                i4 = i;
                            } else {
                                i4 = i + 1;
                                this.v.a().d(portrait2, this.aw);
                            }
                            i11++;
                        }
                        if (z && i3 >= 13 && i >= 30) {
                            return;
                        }
                        i2 = i3;
                    } else {
                        i = i7;
                        i2 = i8;
                    }
                    i6++;
                    i7 = i;
                    i8 = i2;
                } else {
                    return;
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.util.aq.b(getClass().getName(), "startLoadImage", "error = " + e.getMessage());
        }
    }

    public void T() {
        try {
            this.v.a().b();
        } catch (Exception e) {
            com.baidu.tieba.util.aq.b(getClass().getName(), "stopLoadImage", "error = " + e.getMessage());
        }
    }

    public void b(int i) {
        d(i);
        c(i);
        if (this.A != null) {
            this.A.c(i);
        }
        if (i == 1) {
            this.q.setTextColor(-5524539);
            this.q.setShadowLayer(2.0f, 0.0f, 2.0f, -16777216);
            return;
        }
        this.q.setTextColor(-1);
        this.q.setShadowLayer(0.0f, 0.0f, 0.0f, -1);
    }

    public boolean U() {
        return this.ap;
    }

    public void a(com.baidu.tbadk.widget.richText.m mVar) {
        this.O = mVar;
        this.v.a(this.O);
        if (this.A != null) {
            this.A.a(this.O);
        }
    }

    public void a(com.baidu.tieba.view.ax axVar) {
        this.P = axVar;
        if (this.g != null) {
            this.g.a(this.P);
        }
    }
}
