package com.baidu.tieba.pb;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Handler;
import android.text.TextWatcher;
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
import com.baidu.android.common.util.HanziToPinyin;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.view.ClickableLayout;
import com.baidu.tieba.view.ClickableLayout4Frame;
import com.baidu.tieba.view.KeyboardEventLayout;
import com.baidu.zeus.WebChromeClient;
import com.slidingmenu.lib.R;
import java.text.MessageFormat;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class bl {
    private com.baidu.tieba.view.an E;
    private com.baidu.tieba.view.am F;
    private View G;
    private GridView I;
    private com.baidu.tieba.write.m J;
    private View.OnClickListener L;
    private Handler P;
    private View.OnClickListener R;
    public EditText a;
    private com.baidu.tieba.e b;
    private KeyboardEventLayout c;
    private ClickableLayout d;
    private ClickableLayout4Frame e;
    private BdListView f;
    private ImageView g;
    private ImageView h;
    private ImageView i;
    private Button j;
    private Button k;
    private ImageButton l;
    private Button m;
    private Button n;
    private ImageButton o;
    private TextView p;
    private View q;
    private LinearLayout r;
    private LinearLayout s;
    private LinearLayout t;
    private bh u;
    private ProgressBar v;
    private Dialog w = null;
    private Dialog x = null;
    private Dialog y = null;
    private Dialog z = null;
    private cr A = null;
    private View B = null;
    private EditText C = null;
    private View D = null;
    private View H = null;
    private DialogInterface.OnClickListener K = null;
    private View.OnClickListener M = null;
    private AbsListView.OnScrollListener N = null;
    private com.baidu.tbadk.widget.richText.m O = null;
    private Dialog Q = null;
    private Dialog S = null;
    private View T = null;
    private Button U = null;
    private Button V = null;
    private TextView W = null;
    private Dialog X = null;
    private View Y = null;
    private int Z = 0;
    private RadioGroup aa = null;
    private RadioButton ab = null;
    private RadioButton ac = null;
    private RadioButton ad = null;
    private Button ae = null;
    private Button af = null;
    private TextView ag = null;
    private Dialog ah = null;
    private View ai = null;
    private RadioGroup aj = null;
    private CompoundButton.OnCheckedChangeListener ak = null;
    private Button al = null;
    private Button am = null;
    private String an = null;
    private boolean ao = false;
    private cq ap = null;
    private Dialog aq = null;
    private boolean ar = false;
    private Runnable as = new bm(this);
    private View.OnTouchListener at = new ca(this);
    private com.baidu.tieba.view.ad au = new ch(this);
    private TextWatcher av = new ck(this);

    public bl(NewPbActivity newPbActivity, View.OnClickListener onClickListener) {
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.a = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.E = null;
        this.F = null;
        this.G = null;
        this.I = null;
        this.J = null;
        this.L = null;
        this.P = null;
        this.R = null;
        this.b = newPbActivity;
        this.L = onClickListener;
        this.P = new Handler();
        LayoutInflater from = LayoutInflater.from(this.b);
        this.c = (KeyboardEventLayout) from.inflate(R.layout.new_pb_activity, (ViewGroup) null);
        this.b.addContentView(this.c, new FrameLayout.LayoutParams(-2, -2));
        this.s = (LinearLayout) from.inflate(R.layout.reply_post, (ViewGroup) null);
        this.t = (LinearLayout) this.s.findViewById(R.id.extern);
        this.d = (ClickableLayout) this.b.findViewById(R.id.pb_title);
        this.d.setOnkeyUpListener(new cl(this));
        this.e = (ClickableLayout4Frame) this.b.findViewById(R.id.pb_center);
        this.e.setOnClickListener(new cm(this));
        this.f = (BdListView) this.b.findViewById(R.id.new_pb_list);
        this.g = (ImageView) this.b.findViewById(R.id.pb_title_back);
        this.p = (TextView) this.b.findViewById(R.id.pb_title_forum);
        this.i = (ImageView) this.b.findViewById(R.id.pb_title_more);
        this.h = (ImageView) this.b.findViewById(R.id.pb_title_host);
        this.i.setScaleType(ImageView.ScaleType.CENTER);
        this.h.setScaleType(ImageView.ScaleType.CENTER);
        this.v = (ProgressBar) this.b.findViewById(R.id.progress);
        this.r = (LinearLayout) this.b.findViewById(R.id.pb_reply);
        this.r.addView(this.s);
        this.j = (Button) this.s.findViewById(R.id.pb_reply_post);
        this.k = (Button) this.s.findViewById(R.id.pb_button_face);
        this.l = (ImageButton) this.s.findViewById(R.id.pb_button_camera);
        this.a = (EditText) this.s.findViewById(R.id.reply_content);
        this.m = (Button) this.t.findViewById(R.id.pb_button_face1);
        this.o = (ImageButton) this.t.findViewById(R.id.pb_button_camera1);
        this.n = (Button) this.t.findViewById(R.id.pb_button_at1);
        this.q = from.inflate(R.layout.new_pb_header_item, (ViewGroup) null);
        this.u = new bh(this.b);
        this.u.b(this.L);
        this.u.a(this.O);
        this.R = new cn(this);
        this.u.c(this.R);
        this.f.setAdapter((ListAdapter) this.u);
        this.f.addHeaderView(this.q);
        this.E = new com.baidu.tieba.view.an(this.b);
        this.f.setPullRefresh(this.E);
        this.F = new com.baidu.tieba.view.am(this.b);
        this.G = this.F.b().findViewById(R.id.pb_more_view);
        if (this.G != null) {
            this.G.setOnClickListener(this.L);
        }
        this.I = (GridView) this.b.findViewById(R.id.face_view);
        this.J = new com.baidu.tieba.write.m(this.b);
        this.I.setAdapter((ListAdapter) this.J);
        this.I.setOnItemClickListener(new co(this));
        this.g.setOnClickListener(this.L);
        this.p.setOnClickListener(this.L);
        this.i.setOnClickListener(this.L);
        this.h.setOnClickListener(this.L);
        this.j.setOnClickListener(this.L);
        this.l.setOnClickListener(this.L);
        this.k.setOnClickListener(this.L);
        this.o.setOnClickListener(this.L);
        this.m.setOnClickListener(this.L);
        this.n.setOnClickListener(this.L);
        this.a.addTextChangedListener(this.av);
        this.a.setOnTouchListener(this.at);
        this.c.setOnKeyStateChangedListener(this.au);
    }

    public void a() {
        if (this.ao && this.b.getCurrentFocus() != null) {
            this.ao = false;
            com.baidu.tieba.d.ag.a(this.b, this.b.getCurrentFocus());
        }
    }

    public void a(View view) {
        if (this.Q == null) {
            this.Q = new Dialog(this.b, R.style.common_alert_dialog);
            this.Q.setCanceledOnTouchOutside(true);
            this.Q.setCancelable(true);
            this.Q.setContentView(this.b.getLayoutInflater().inflate(R.layout.forum_manage_dialog, (ViewGroup) null));
            WindowManager.LayoutParams attributes = this.Q.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.tieba.d.ag.a((Context) this.b) * 0.9d);
            this.Q.getWindow().setAttributes(attributes);
        }
        Button button = (Button) this.Q.findViewById(R.id.del_post_btn);
        Button button2 = (Button) this.Q.findViewById(R.id.forbid_user_btn);
        if ("".equals(view.getTag(R.id.tag_del_post_id))) {
            button.setVisibility(8);
        } else {
            button.setVisibility(0);
            button.setTag(R.id.tag_del_post_id, view.getTag(R.id.tag_del_post_id));
            button.setTag(R.id.tag_del_post_type, view.getTag(R.id.tag_del_post_type));
            button.setTag(R.id.tag_manage_user_identity, view.getTag(R.id.tag_manage_user_identity));
            button.setOnClickListener(new cp(this));
        }
        if ("".equals(view.getTag(R.id.tag_forbid_user_name))) {
            button2.setVisibility(8);
        } else {
            button2.setVisibility(0);
            button2.setTag(R.id.tag_forbid_user_name, view.getTag(R.id.tag_forbid_user_name));
            button2.setTag(R.id.tag_manage_user_identity, view.getTag(R.id.tag_manage_user_identity));
            button2.setOnClickListener(new bn(this));
        }
        this.Q.show();
    }

    public void a(int i, String str, int i2) {
        if (this.S == null) {
            this.S = new Dialog(this.b, R.style.common_alert_dialog);
            this.S.setCanceledOnTouchOutside(true);
            this.S.setCancelable(true);
            this.T = this.b.getLayoutInflater().inflate(R.layout.del_post, (ViewGroup) null);
            this.S.setContentView(this.T);
            WindowManager.LayoutParams attributes = this.S.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.tieba.d.ag.a((Context) this.b) * 0.9d);
            this.S.getWindow().setAttributes(attributes);
            this.U = (Button) this.T.findViewById(R.id.dialog_button_ok);
            this.U.setOnClickListener(this.L);
            this.V = (Button) this.T.findViewById(R.id.dialog_button_cancel);
            this.V.setOnClickListener(new bo(this));
            this.W = (TextView) this.T.findViewById(R.id.confirm_text);
        }
        this.U.setTag(R.id.tag_del_post_id, str);
        this.U.setTag(R.id.tag_del_post_type, Integer.valueOf(i));
        this.U.setTag(R.id.tag_manage_user_identity, Integer.valueOf(i2));
        if (i == 0) {
            this.W.setText(R.string.del_thread_confirm);
        } else {
            this.W.setText(R.string.del_post_confirm);
        }
        this.S.show();
    }

    public void a(String str, int i) {
        if (this.X == null) {
            this.X = new Dialog(this.b, R.style.common_alert_dialog);
            this.X.setCanceledOnTouchOutside(true);
            this.X.setCancelable(true);
            this.Y = this.b.getLayoutInflater().inflate(R.layout.forbid_user, (ViewGroup) null);
            this.X.setContentView(this.Y);
            WindowManager.LayoutParams attributes = this.X.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.tieba.d.ag.a((Context) this.b) * 0.9d);
            this.X.getWindow().setAttributes(attributes);
            this.aa = (RadioGroup) this.Y.findViewById(R.id.radio_group);
            this.ab = (RadioButton) this.Y.findViewById(R.id.radio_button_1day);
            this.ac = (RadioButton) this.Y.findViewById(R.id.radio_button_3day);
            this.ad = (RadioButton) this.Y.findViewById(R.id.radio_button_10day);
            bp bpVar = new bp(this);
            this.ab.setOnCheckedChangeListener(bpVar);
            this.ac.setOnCheckedChangeListener(bpVar);
            this.ad.setOnCheckedChangeListener(bpVar);
            this.ae = (Button) this.Y.findViewById(R.id.dialog_button_ok);
            this.ae.setOnClickListener(this.L);
            this.af = (Button) this.Y.findViewById(R.id.dialog_button_cancel);
            this.af.setOnClickListener(new bq(this));
            this.ag = (TextView) this.Y.findViewById(R.id.user_name);
        }
        this.ag.setText(str);
        this.aa.check(R.id.radio_button_1day);
        if (i == 2) {
            this.ac.setVisibility(8);
            this.ad.setVisibility(8);
        }
        this.ae.setTag(R.id.tag_forbid_user_name, str);
        this.X.show();
    }

    public void a(ArrayList arrayList) {
        if (this.ah == null) {
            this.ah = new Dialog(this.b, R.style.common_alert_dialog);
            this.ah.setCanceledOnTouchOutside(true);
            this.ah.setCancelable(true);
            this.ai = this.b.getLayoutInflater().inflate(R.layout.commit_good, (ViewGroup) null);
            this.ah.setContentView(this.ai);
            WindowManager.LayoutParams attributes = this.ah.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.tieba.d.ag.a((Context) this.b) * 0.9d);
            this.ah.getWindow().setAttributes(attributes);
            this.ak = new br(this);
            this.aj = (RadioGroup) this.ai.findViewById(R.id.good_class_group);
            this.am = (Button) this.ai.findViewById(R.id.dialog_button_cancel);
            this.am.setOnClickListener(new bs(this));
            this.al = (Button) this.ai.findViewById(R.id.dialog_button_ok);
            this.al.setOnClickListener(this.L);
        }
        this.aj.removeAllViews();
        LayoutInflater layoutInflater = this.b.getLayoutInflater();
        RadioButton radioButton = (RadioButton) layoutInflater.inflate(R.layout.good_class_radio_button, (ViewGroup) null);
        radioButton.setTag("0");
        radioButton.setText(this.b.getString(R.string.def_good_class));
        radioButton.setOnCheckedChangeListener(this.ak);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, -2);
        layoutParams.setMargins(com.baidu.tieba.d.ag.a(this.b, 10.0f), com.baidu.tieba.d.ag.a(this.b, 5.0f), com.baidu.tieba.d.ag.a(this.b, 10.0f), com.baidu.tieba.d.ag.a(this.b, 5.0f));
        this.aj.addView(radioButton, layoutParams);
        this.aj.requestLayout();
        this.aj.check(radioButton.getId());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < arrayList.size()) {
                RadioButton radioButton2 = (RadioButton) layoutInflater.inflate(R.layout.good_class_radio_button, (ViewGroup) null);
                radioButton2.setTag(String.valueOf(((com.baidu.tieba.a.v) arrayList.get(i2)).b()));
                radioButton2.setText(((com.baidu.tieba.a.v) arrayList.get(i2)).a());
                radioButton2.setOnCheckedChangeListener(this.ak);
                this.aj.addView(radioButton2, layoutParams);
                this.aj.requestLayout();
                i = i2 + 1;
            } else {
                this.ah.show();
                return;
            }
        }
    }

    public void b() {
        this.v.setVisibility(0);
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.v.setVisibility(8);
        if (z && z2) {
            this.b.a(this.b.getString(R.string.success));
        } else if (str != null && z2) {
            this.b.a(str);
        }
    }

    public View c() {
        if (this.T != null) {
            return this.T.findViewById(R.id.dialog_button_ok);
        }
        return null;
    }

    public View d() {
        if (this.Y != null) {
            return this.Y.findViewById(R.id.dialog_button_ok);
        }
        return null;
    }

    public int e() {
        return this.Z;
    }

    public View f() {
        if (this.ai != null) {
            return this.ai.findViewById(R.id.dialog_button_ok);
        }
        return null;
    }

    public String g() {
        return this.an;
    }

    public View h() {
        if (this.A == null) {
            return null;
        }
        return this.A.e();
    }

    public View i() {
        if (this.A == null) {
            return null;
        }
        return this.A.g();
    }

    public View j() {
        if (this.A != null) {
            return this.A.n();
        }
        return null;
    }

    public View k() {
        if (this.A == null) {
            return null;
        }
        return this.A.f();
    }

    public void l() {
        if (this.A != null) {
            this.A.b();
        }
    }

    public void m() {
        this.v.setVisibility(0);
        com.baidu.tieba.d.ag.a(this.b, this.a);
    }

    public void n() {
        this.v.setVisibility(0);
    }

    public void o() {
        this.v.setVisibility(8);
        this.a.setText("");
        this.j.setEnabled(false);
        w();
        N();
        if (this.A != null) {
            this.A.k();
        }
    }

    public void p() {
        this.F.c();
    }

    public void q() {
        this.v.setVisibility(8);
        this.F.d();
        this.f.a();
    }

    public void a(String str) {
        this.p.setText(String.valueOf(str) + this.b.getString(R.string.bar));
        this.p.setTag(R.id.tag_forum_name, str);
    }

    public void a(boolean z) {
        if (!z) {
            y();
            U();
            this.a.setSelection(this.a.getText().length());
            this.a.requestFocus();
            this.b.a(this.a, 200);
        } else if (this.A != null) {
            this.A.b((String) null);
        }
    }

    public void r() {
        if (this.A == null) {
            this.A = new cr(this.b, this.L, this.R, this.M);
            this.A.a(this.M);
            this.A.a(this.u.a());
            this.A.a(this.N);
            this.A.b(this.u.c());
            this.A.a(this.u.d());
            this.H = this.A.d();
            this.A.a(this.O);
            this.A.a(this.u.b());
        }
        this.H.setVisibility(0);
        this.A.p();
        this.c.addView(this.H);
    }

    public void a(cq cqVar) {
        this.ap = cqVar;
    }

    public void a(boolean z, com.baidu.tieba.a.ax axVar, boolean z2, String str, View view, int i) {
        int i2;
        int i3;
        if (axVar != null && view != null) {
            if (TiebaApplication.d().n()) {
                StatService.onEvent(this.b, "pb_tosubpb", "pbclick", 1);
            }
            if (this.A == null) {
                this.A = new cr(this.b, this.L, this.R, this.M);
                this.A.a(this.M);
                this.A.a(this.u.a());
                this.A.a(this.N);
                this.A.b(this.u.c());
                this.A.a(this.u.d());
                this.H = this.A.d();
                this.A.a(this.O);
                this.A.a(this.u.b());
            }
            this.A.a(this.u.e());
            this.A.a(axVar, i);
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
            int height2 = (view.getHeight() + this.f.getDividerHeight()) - (this.c.getHeight() - com.baidu.tieba.d.ag.a(this.b, 43.0f));
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
            this.c.addView(this.H);
            if (bitmap2 != null) {
                ImageView imageView = new ImageView(this.b);
                imageView.setImageBitmap(bitmap2);
                this.c.addView(imageView);
                TranslateAnimation translateAnimation2 = new TranslateAnimation(0.0f, 0.0f, 0.0f, -i3);
                translateAnimation2.setDuration(300L);
                imageView.setAnimation(translateAnimation2);
                translateAnimation2.setAnimationListener(new bt(this, imageView));
                translateAnimation2.setInterpolator(accelerateInterpolator);
                translateAnimation2.start();
            }
            ImageView imageView2 = new ImageView(this.b);
            imageView2.setImageBitmap(bitmap);
            this.c.addView(imageView2);
            TranslateAnimation translateAnimation3 = new TranslateAnimation(0.0f, 0.0f, i2, this.c.getHeight());
            translateAnimation3.setDuration(300L);
            imageView2.setAnimation(translateAnimation3);
            translateAnimation3.setAnimationListener(new bv(this, imageView2));
            translateAnimation.setAnimationListener(new bx(this, axVar, z, str));
            translateAnimation.setInterpolator(accelerateInterpolator);
            translateAnimation3.setInterpolator(accelerateInterpolator);
            translateAnimation3.start();
            translateAnimation.start();
        }
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.u.a(onLongClickListener);
        if (this.A != null) {
            this.A.a(onLongClickListener);
        }
    }

    public void s() {
        if (t()) {
            this.A.i();
        }
    }

    public boolean t() {
        return (this.H == null || this.H.getVisibility() == 8) ? false : true;
    }

    public void u() {
        if (this.H != null) {
            this.H.setVisibility(8);
            this.c.removeView(this.H);
            this.A.j();
        }
        N();
    }

    public void v() {
        if (this.A != null) {
            this.A.q();
        }
    }

    public void a(com.baidu.tieba.a.ax axVar, int i) {
        if (this.A != null) {
            this.A.q();
            this.A.a(this.u.e());
            this.A.a(axVar, i);
        }
    }

    public void b(String str) {
        this.a.getText().insert(this.a.getSelectionStart(), "@" + str + HanziToPinyin.Token.SEPARATOR);
    }

    public void c(String str) {
        if (this.A != null) {
            this.A.a(str);
        }
    }

    public void a(Bitmap bitmap) {
        if (bitmap != null) {
            this.l.setImageBitmap(bitmap);
            this.l.setTag(bitmap);
            this.o.setImageBitmap(bitmap);
            this.o.setTag(bitmap);
            this.j.setEnabled(true);
        }
    }

    public void w() {
        this.l.setImageBitmap(null);
        this.l.setTag(null);
        this.o.setImageBitmap(null);
        this.o.setTag(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T() {
        this.k.setVisibility(0);
        this.l.setVisibility(0);
        this.t.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        this.k.setVisibility(8);
        this.l.setVisibility(8);
        this.t.setVisibility(0);
    }

    public void x() {
        U();
        this.a.setSelection(this.a.getText().length());
        this.a.requestFocus();
        if (this.I.getVisibility() == 8) {
            this.k.setBackgroundResource(R.drawable.new_pb_keyboard_btn);
            this.m.setBackgroundResource(R.drawable.new_pb_keyboard_btn);
            com.baidu.tieba.d.ag.a(this.b, this.a);
            this.P.postDelayed(this.as, 200L);
            return;
        }
        this.k.setBackgroundResource(R.drawable.new_pb_face_btn);
        this.m.setBackgroundResource(R.drawable.new_pb_face_btn);
        this.I.setVisibility(8);
        this.b.a(this.a, 200);
    }

    public void a(DialogInterface.OnClickListener onClickListener) {
        if (this.aq == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.b);
            builder.setTitle(R.string.operation);
            builder.setItems(new String[]{this.b.getString(R.string.copy)}, onClickListener);
            this.aq = builder.create();
            this.aq.setCanceledOnTouchOutside(true);
        }
        this.aq.show();
    }

    public void y() {
        T();
        this.k.setBackgroundResource(R.drawable.new_pb_face_btn);
        this.m.setBackgroundResource(R.drawable.new_pb_face_btn);
        this.I.setVisibility(8);
    }

    public void z() {
        if (this.z == null) {
            W();
        }
        this.z.show();
    }

    public int A() {
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

    public int B() {
        try {
            return Integer.parseInt(this.C.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public String C() {
        return this.a.getText().toString();
    }

    public String D() {
        if (this.A == null) {
            return null;
        }
        return this.A.o();
    }

    public void a(com.baidu.tieba.a.al alVar) {
        this.u.a(alVar);
        this.u.notifyDataSetChanged();
    }

    public void a(com.baidu.tieba.a.al alVar, int i, int i2, boolean z) {
        q();
        this.u.a(alVar);
        this.u.notifyDataSetChanged();
        a(alVar.a().b());
        if (alVar.e().e() == 0 && !z) {
            this.f.setNextPage(null);
        } else {
            this.f.setNextPage(this.F);
        }
        if (alVar.e().f() == 0 && z) {
            this.f.setPullRefresh(null);
        } else {
            this.f.setPullRefresh(this.E);
        }
        if (z) {
            if (alVar.e().e() == 0) {
                this.F.a(this.b.getResources().getString(R.string.no_more_to_load));
            } else {
                this.F.a(this.b.getResources().getString(R.string.load_more));
            }
        }
        if (alVar.b() != null && alVar.b().g() != null && alVar.b().g().b() == 0) {
            this.h.setVisibility(4);
            this.h.setEnabled(false);
        }
        switch (i) {
            case 2:
                this.f.setSelection(i2);
                CompatibleUtile.scrollListViewBy(this.f, -this.q.getHeight(), 0);
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
                } else if (alVar.d() != null) {
                    if (alVar.e() != null && alVar.e().f() != 0) {
                        this.f.setSelection(alVar.d().size() + 1);
                        return;
                    } else {
                        this.f.setSelection(alVar.d().size());
                        return;
                    }
                } else {
                    return;
                }
            default:
                return;
        }
    }

    public void b(boolean z) {
        this.ar = z;
        if (TiebaApplication.d().ai() == 1) {
            if (z) {
                this.h.setImageResource(R.drawable.icon_floor_host_s_1);
            } else {
                this.h.setImageResource(R.drawable.icon_floor_host_n_1);
            }
        } else if (z) {
            this.h.setImageResource(R.drawable.icon_floor_host_s);
        } else {
            this.h.setImageResource(R.drawable.icon_floor_host_n);
        }
    }

    public void a(boolean z, boolean z2) {
        if (this.x == null) {
            V();
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
        attributes.width = com.baidu.tieba.d.ag.a(this.b, 134.0f);
        attributes.height = -2;
        this.x.getWindow().setAttributes(attributes);
    }

    public void a(com.baidu.tieba.a.al alVar, boolean z) {
        if (alVar != null) {
            TextView textView = (TextView) this.q.findViewById(R.id.pb_header_title);
            textView.setTextSize(com.baidu.tieba.a.i.n());
            TextView textView2 = (TextView) this.q.findViewById(R.id.pb_list_header_time);
            TextView textView3 = (TextView) this.q.findViewById(R.id.pb_list_header_reply);
            Button button = (Button) this.q.findViewById(R.id.pb_list_header_bar);
            button.setOnClickListener(this.L);
            if (alVar.a() != null && alVar.a().b() != null) {
                String b = alVar.a().b();
                if (b.length() > 6) {
                    b = String.valueOf(b.substring(0, 5)) + this.b.getResources().getString(R.string.three_point);
                }
                button.setText(String.valueOf(b) + this.b.getResources().getString(R.string.bar));
            }
            alVar.b().o();
            textView.setText(alVar.b().n());
            if (alVar.b().c() != 0) {
                textView3.setText(String.valueOf(alVar.b().c()));
            } else {
                textView3.setVisibility(8);
            }
            this.q.setVisibility(0);
            ArrayList d = alVar.d();
            long j = -1;
            if (d.size() > 0) {
                com.baidu.tieba.a.aq aqVar = (com.baidu.tieba.a.aq) d.get(0);
                if (aqVar.f() == 1) {
                    j = aqVar.g();
                }
                com.baidu.tieba.a.aq aqVar2 = (com.baidu.tieba.a.aq) d.get(d.size() - 1);
                if (aqVar2.f() == 1) {
                    j = aqVar2.g();
                }
            }
            if (j > 0) {
                textView2.setVisibility(0);
                textView2.setText(com.baidu.tieba.d.ad.a(j));
            }
            Button button2 = (Button) this.q.findViewById(R.id.pb_list_header_manage_btn);
            LinearLayout linearLayout = (LinearLayout) this.q.findViewById(R.id.manage_bottom_bar);
            if (!z) {
                linearLayout.setVisibility(8);
            }
            if (alVar.l() == 1) {
                button2.setVisibility(0);
            } else {
                button2.setVisibility(8);
            }
            button2.setOnClickListener(new bz(this));
            Button button3 = (Button) this.q.findViewById(R.id.commit_top);
            button3.setOnClickListener(this.L);
            Button button4 = (Button) this.q.findViewById(R.id.cancel_top);
            button4.setOnClickListener(this.L);
            Button button5 = (Button) this.q.findViewById(R.id.commit_good);
            button5.setOnClickListener(this.L);
            Button button6 = (Button) this.q.findViewById(R.id.cancel_good);
            button6.setOnClickListener(this.L);
            if (alVar.b().f() == 1) {
                button5.setVisibility(8);
                button6.setVisibility(0);
            } else {
                button5.setVisibility(0);
                button6.setVisibility(8);
            }
            if (alVar.b().e() == 1) {
                button3.setVisibility(8);
                button4.setVisibility(0);
                return;
            }
            button3.setVisibility(0);
            button4.setVisibility(8);
        }
    }

    private void c(int i) {
        TextView textView = (TextView) this.q.findViewById(R.id.pb_list_header_time);
        TextView textView2 = (TextView) this.q.findViewById(R.id.pb_list_header_reply);
        Button button = (Button) this.q.findViewById(R.id.pb_list_header_bar);
        com.baidu.tieba.d.ac.c((TextView) this.q.findViewById(R.id.pb_header_title), i);
        com.baidu.tieba.d.ac.d(textView, i);
        com.baidu.tieba.d.ac.d(textView2, i);
        com.baidu.tieba.d.ac.d(this.d, i);
        com.baidu.tieba.d.ac.a(this.g, i);
        this.E.a(i);
        b(this.ar);
        if (i == 1) {
            this.k.setBackgroundResource(R.drawable.new_pb_face_btn_1);
            this.l.setBackgroundResource(R.drawable.new_pb_camera_btn_1);
            this.m.setBackgroundResource(R.drawable.new_pb_face_btn_1);
            this.o.setBackgroundResource(R.drawable.new_pb_camera_btn_1);
            this.n.setBackgroundResource(R.drawable.new_pb_at_btn_1);
            this.q.setBackgroundResource(R.drawable.bg_topbar_1);
            com.baidu.tieba.d.ac.h((View) this.j, (int) R.drawable.btn_post_dl_selector_1);
            this.j.setTextColor(this.b.getResources().getColorStateList(R.color.post_image_btn_color_1));
            this.c.setBackgroundResource(R.drawable.common_bg_1);
            this.h.setBackgroundResource(R.drawable.title_icon_bg_1);
            this.i.setBackgroundResource(R.drawable.title_icon_bg_1);
            com.baidu.tieba.d.ac.h((View) button, (int) R.drawable.pb_button_bar_drawable_1);
            button.setTextColor(this.b.getResources().getColorStateList(R.color.text_blue_white_color_1));
            textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_little_time_1, 0, 0, 0);
            textView2.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_little_comment_1, 0, 0, 0);
            com.baidu.tieba.d.ac.h(this.G, (int) R.drawable.bg_list_all_1);
            return;
        }
        this.k.setBackgroundResource(R.drawable.new_pb_face_btn);
        this.l.setBackgroundResource(R.drawable.new_pb_camera_btn);
        this.m.setBackgroundResource(R.drawable.new_pb_face_btn);
        this.o.setBackgroundResource(R.drawable.new_pb_camera_btn);
        this.n.setBackgroundResource(R.drawable.new_pb_at_btn);
        this.q.setBackgroundResource(R.drawable.bg_topbar);
        com.baidu.tieba.d.ac.h((View) this.j, (int) R.drawable.btn_post_dl_selector);
        this.j.setTextColor(this.b.getResources().getColorStateList(R.color.post_image_btn_color));
        this.c.setBackgroundResource(R.drawable.common_bg);
        this.h.setBackgroundResource(R.drawable.title_icon_bg);
        this.i.setBackgroundResource(R.drawable.title_icon_bg);
        com.baidu.tieba.d.ac.h((View) button, (int) R.drawable.pb_button_bar_drawable);
        button.setTextColor(this.b.getResources().getColorStateList(R.color.text_blue_white_color));
        textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_little_time, 0, 0, 0);
        textView2.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_little_comment, 0, 0, 0);
        com.baidu.tieba.d.ac.h(this.G, (int) R.drawable.bg_list_all);
    }

    private void d(int i) {
        try {
            Button button = (Button) this.q.findViewById(R.id.pb_list_header_manage_btn);
            LinearLayout linearLayout = (LinearLayout) this.q.findViewById(R.id.manage_bottom_bar);
            Button button2 = (Button) this.q.findViewById(R.id.commit_top);
            Button button3 = (Button) this.q.findViewById(R.id.cancel_top);
            Button button4 = (Button) this.q.findViewById(R.id.commit_good);
            Button button5 = (Button) this.q.findViewById(R.id.cancel_good);
            View findViewById = this.q.findViewById(R.id.line2);
            if (i == 1) {
                linearLayout.setBackgroundResource(R.drawable.pb_title_bottom_bar_bg_1);
                com.baidu.tieba.d.ac.h((View) button, (int) R.drawable.common_image_btn_selector_1);
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
                com.baidu.tieba.d.ac.h((View) button, (int) R.drawable.common_image_btn_selector);
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
            com.baidu.tieba.d.ae.b(getClass().getName(), "setBawuSkin", e.getMessage());
        }
    }

    public View E() {
        return this.G;
    }

    public BdListView F() {
        return this.f;
    }

    public int G() {
        return R.id.richText;
    }

    public Button H() {
        return (Button) this.q.findViewById(R.id.commit_good);
    }

    public Button I() {
        return (Button) this.q.findViewById(R.id.cancel_good);
    }

    public Button J() {
        return (Button) this.q.findViewById(R.id.commit_top);
    }

    public Button K() {
        return (Button) this.q.findViewById(R.id.cancel_top);
    }

    public View L() {
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

    public void b(DialogInterface.OnClickListener onClickListener) {
        this.K = onClickListener;
    }

    public void a(com.baidu.adp.widget.ListView.b bVar) {
        this.E.a(bVar);
    }

    private void V() {
        this.x = new com.baidu.tieba.view.al(this.b);
        this.D = this.b.getLayoutInflater().inflate(R.layout.new_pb_more, (ViewGroup) null);
        this.D.setOnTouchListener(new cb(this));
        this.x.setCanceledOnTouchOutside(true);
    }

    private void W() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.b);
        builder.setTitle(this.b.getResources().getString(R.string.operation));
        builder.setItems(new String[]{this.b.getResources().getString(R.string.take_photo), this.b.getResources().getString(R.string.album)}, this.K);
        this.z = builder.create();
        this.z.setCanceledOnTouchOutside(true);
    }

    public void a(com.baidu.tieba.a.ak akVar) {
        if (akVar != null) {
            int c = akVar.c();
            int a = akVar.a();
            if (this.y == null) {
                this.y = new Dialog(this.b, R.style.common_alert_dialog);
                this.y.setCanceledOnTouchOutside(true);
                this.y.setCancelable(true);
                this.B = this.b.getLayoutInflater().inflate(R.layout.dialog_direct_pager, (ViewGroup) null);
                this.y.setContentView(this.B);
                WindowManager.LayoutParams attributes = this.y.getWindow().getAttributes();
                attributes.gravity = 49;
                attributes.y = com.baidu.tieba.d.ag.a(this.b, 54.0f);
                attributes.width = (int) (com.baidu.tieba.d.ag.a((Context) this.b) * 0.9d);
                this.y.getWindow().setAttributes(attributes);
                this.y.setOnKeyListener(new cc(this));
            }
            this.y.show();
            ((Button) this.B.findViewById(R.id.dialog_button_ok)).setOnClickListener(this.L);
            ((Button) this.B.findViewById(R.id.dialog_button_cancel)).setOnClickListener(this.L);
            this.C = (EditText) this.B.findViewById(R.id.input_page_number);
            this.C.setText("");
            this.C.setOnFocusChangeListener(new cd(this));
            TextView textView = (TextView) this.B.findViewById(R.id.current_page_number);
            if (c <= 0) {
                c = 1;
            }
            textView.setText(MessageFormat.format(this.b.getApplicationContext().getResources().getString(R.string.current_page), Integer.valueOf(c), Integer.valueOf(a <= 0 ? 1 : a)));
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
        this.u.a(onClickListener);
    }

    public void d(String str) {
        this.b.a(str);
    }

    public boolean c(boolean z) {
        if (this.A == null || !this.A.a()) {
            if (!z) {
                if (t()) {
                    u();
                    return true;
                } else if (this.I.getVisibility() == 0) {
                    this.I.setVisibility(8);
                    T();
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public void M() {
        if (this.w != null) {
            this.w.dismiss();
        }
        if (this.v != null) {
            this.v.setVisibility(8);
        }
        R();
    }

    public void N() {
        y();
        T();
        com.baidu.tieba.d.ag.a(this.b, this.C);
        com.baidu.tieba.d.ag.a(this.b, this.a);
        if (this.w != null) {
            this.w.dismiss();
        }
        if (this.x != null) {
            this.x.dismiss();
        }
        if (this.y != null) {
            this.y.dismiss();
        }
        if (this.A != null) {
            this.A.h();
        }
        O();
    }

    public void d(boolean z) {
        this.u.a(z);
        if (this.A != null) {
            this.A.b(z);
        }
    }

    public void e(boolean z) {
        this.u.b(z);
        if (this.A != null) {
            this.A.a(z);
        }
    }

    public void O() {
        if (this.S != null) {
            this.S.dismiss();
        }
        if (this.X != null) {
            this.X.dismiss();
        }
        if (this.ah != null) {
            this.ah.dismiss();
        }
        if (this.Q != null) {
            this.Q.dismiss();
        }
    }

    public void P() {
        if (this.A != null) {
            this.A.m();
        }
    }

    public void Q() {
        int i;
        int i2;
        int i3;
        int i4;
        ImageView imageView;
        try {
            int c = ((com.baidu.adp.widget.ListView.e) this.f.getAdapter()).c();
            int firstVisiblePosition = this.f.getFirstVisiblePosition() - c;
            int lastVisiblePosition = this.f.getLastVisiblePosition() - c;
            if (firstVisiblePosition < 0) {
                firstVisiblePosition = 0;
            }
            com.baidu.tieba.d.z c2 = com.baidu.tieba.d.w.c(this.b);
            this.u.a().a();
            boolean z = c2 == com.baidu.tieba.d.z.WIFI || c2 == com.baidu.tieba.d.z.ThreeG;
            this.u.a().a(z);
            int i5 = firstVisiblePosition;
            int i6 = 0;
            int i7 = 0;
            while (i5 < this.u.getCount()) {
                if (z || i5 <= lastVisiblePosition) {
                    com.baidu.tieba.a.aq aqVar = (com.baidu.tieba.a.aq) this.u.getItem(i5);
                    if (aqVar != null) {
                        ArrayList j = aqVar.j();
                        int size = j.size();
                        if (!this.u.c() || i7 >= 13) {
                            i3 = i7;
                        } else {
                            int i8 = 0;
                            int i9 = i7;
                            while (true) {
                                if (i8 >= size) {
                                    i3 = i9;
                                    break;
                                }
                                if (((com.baidu.tieba.a.k) j.get(i8)).a() == 3 || ((com.baidu.tieba.a.k) j.get(i8)).a() == 5) {
                                    if (i9 >= 13) {
                                        i3 = i9;
                                        break;
                                    }
                                    i9++;
                                    if (this.u.a().a(((com.baidu.tieba.a.k) j.get(i8)).f(), new ce(this)) != null && (imageView = (ImageView) this.f.findViewWithTag(((com.baidu.tieba.a.k) j.get(i8)).f())) != null) {
                                        imageView.invalidate();
                                    }
                                }
                                i8++;
                                i9 = i9;
                            }
                        }
                        String e = aqVar.h().e();
                        if (!this.u.d() || e == null || e.length() <= 0 || i6 >= 30) {
                            i4 = i6;
                        } else {
                            i4 = i6 + 1;
                            this.u.a().d(e, new cf(this));
                        }
                        int i10 = 0;
                        while (true) {
                            i = i4;
                            if (i10 >= aqVar.a().size()) {
                                break;
                            }
                            String e2 = ((com.baidu.tieba.a.aq) aqVar.a().get(i10)).h().e();
                            if (!this.u.d() || e2 == null || e2.length() <= 0 || i >= 30) {
                                i4 = i;
                            } else {
                                i4 = i + 1;
                                this.u.a().d(e2, new cg(this));
                            }
                            i10++;
                        }
                        if (z && i3 >= 13 && i >= 30) {
                            return;
                        }
                        i2 = i3;
                    } else {
                        i = i6;
                        i2 = i7;
                    }
                    i5++;
                    i6 = i;
                    i7 = i2;
                } else {
                    return;
                }
            }
        } catch (Exception e3) {
            com.baidu.tieba.d.ae.b(getClass().getName(), "startLoadImage", "error = " + e3.getMessage());
        }
    }

    public void R() {
        try {
            this.u.a().b();
        } catch (Exception e) {
            com.baidu.tieba.d.ae.b(getClass().getName(), "stopLoadImage", "error = " + e.getMessage());
        }
    }

    public void b(int i) {
        d(i);
        c(i);
        if (this.A != null) {
            this.A.c(i);
        }
        if (i == 1) {
            this.p.setTextColor(-5524539);
            this.p.setShadowLayer(2.0f, 0.0f, 2.0f, -16777216);
            return;
        }
        this.p.setTextColor(-1);
        this.p.setShadowLayer(0.0f, 0.0f, 0.0f, -1);
    }

    public boolean S() {
        return this.ao;
    }

    public void a(com.baidu.tbadk.widget.richText.m mVar) {
        this.O = mVar;
        this.u.a(this.O);
        if (this.A != null) {
            this.A.a(this.O);
        }
    }
}
