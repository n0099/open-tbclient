package com.baidu.tieba.pb;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.text.method.LinkMovementMethod;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/* loaded from: classes.dex */
public class SubPbActivity extends com.baidu.tieba.e {
    private List K;
    private EditText t;
    private ListView u;
    private View w;
    private Button x;
    private Button y;
    private DialogInterface.OnClickListener z;
    private com.baidu.tieba.b.t g = null;
    private dh h = null;
    private String i = null;
    private String j = null;
    private String k = null;
    private String l = null;
    private String m = null;
    private com.baidu.tieba.a.af n = null;
    private boolean o = false;
    private boolean p = true;
    private boolean q = false;
    private boolean r = false;
    private ProgressBar s = null;
    private AdapterView.OnItemLongClickListener v = null;
    private com.baidu.tieba.a.an A = null;
    private int B = -1;
    private String C = null;
    private String D = null;
    private com.baidu.tieba.a.b E = null;
    private DialogInterface.OnCancelListener F = null;
    private df G = null;
    private dg H = null;
    private int I = 1;
    private int J = 1;
    private String L = null;
    private boolean M = false;
    private int N = 0;
    private Dialog O = null;
    private View P = null;
    private Button Q = null;
    private Button R = null;
    private Dialog S = null;
    private View T = null;
    private int U = 0;
    RadioGroup c = null;
    RadioButton d = null;
    RadioButton e = null;
    RadioButton f = null;
    private Button V = null;
    private Button W = null;
    private TextView X = null;
    private RelativeLayout Y = null;
    private RelativeLayout Z = null;
    private Button aa = null;
    private Button ab = null;
    private TextView ac = null;
    private GridView ad = null;
    private LinearLayout ae = null;
    private dd af = null;
    private de ag = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.sub_pb_activity);
        this.E = (com.baidu.tieba.a.b) getIntent().getSerializableExtra("anti");
        this.L = TiebaApplication.w();
        i();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        try {
            if (this.G != null) {
                this.G.a();
                this.G = null;
            }
            if (this.H != null) {
                this.H.a();
                this.H = null;
            }
            if (this.h != null) {
                this.h.e();
            }
            if (this.af != null) {
                this.af.a();
                this.af = null;
            }
            if (this.ag != null) {
                this.ag.a();
                this.ag = null;
            }
            r();
        } catch (Exception e) {
            com.baidu.tieba.c.af.e(getClass().getName(), "onDestroy", e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onResume() {
        super.onResume();
        String w = TiebaApplication.w();
        if (this.L == null && w != null && w.length() > 0) {
            this.L = w;
            if (this.E != null) {
                this.E.a(1);
            }
        }
    }

    public static void a(Context context, String str, String str2, boolean z) {
        Intent intent = new Intent(context, SubPbActivity.class);
        intent.putExtra("themeId", str);
        intent.putExtra("postId", str2);
        intent.putExtra("isFromMention", z);
        context.startActivity(intent);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 1200005) {
                o();
            } else if (i == 1100010) {
                k();
            } else if (i == 1100005) {
                q();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e
    public void b(int i) {
        super.b(i);
        try {
            com.baidu.tieba.c.ad.a(this.Y, i);
            com.baidu.tieba.c.ad.c(this.Z, i);
            com.baidu.tieba.c.ad.c(this.ac, i);
            com.baidu.tieba.c.ad.e((TextView) this.aa, i);
            com.baidu.tieba.c.ad.d((TextView) this.ab, i);
            com.baidu.tieba.c.ad.b(this.u, i);
            this.h.notifyDataSetChanged();
            TextView textView = (TextView) this.w.findViewById(R.id.text);
            TextView textView2 = (TextView) this.w.findViewById(R.id.user_name);
            TextView textView3 = (TextView) this.w.findViewById(R.id.rank);
            TextView textView4 = (TextView) this.w.findViewById(R.id.time);
            TextView textView5 = (TextView) this.w.findViewById(R.id.floor);
            View findViewById = this.w.findViewById(R.id.manage_divider);
            if (i == 1) {
                this.w.setBackgroundResource(R.drawable.sub_pb_post_bg_1);
                textView3.setTextColor(com.baidu.tieba.c.ad.b(i));
                findViewById.setBackgroundColor(getResources().getColor(R.color.skin_1_divider_color));
                textView5.setTextColor(com.baidu.tieba.c.ad.b(i));
                textView5.setBackgroundResource(R.drawable.floor_bg_1);
                textView.setTextColor(com.baidu.tieba.c.ad.a(i));
                textView4.setTextColor(com.baidu.tieba.c.ad.b(i));
                if (textView2.getTag() == null) {
                    textView4.setTextColor(com.baidu.tieba.c.ad.a(i));
                }
                this.ad.setBackgroundColor(getResources().getColor(R.color.skin_1_face_bg_color));
                com.baidu.tieba.c.ad.i(this.ae, R.drawable.sub_pb_reply_bg_1);
                return;
            }
            this.w.setBackgroundResource(R.drawable.sub_pb_post_bg);
            textView3.setTextColor(-9276814);
            findViewById.setBackgroundColor(-6710887);
            textView5.setTextColor(-9276814);
            textView5.setBackgroundResource(R.drawable.floor_bg);
            textView.setTextColor(-11974584);
            textView4.setTextColor(-9276814);
            if (textView2.getTag() == null) {
                textView4.setTextColor(-16777216);
            }
            this.ad.setBackgroundColor(-1644826);
            com.baidu.tieba.c.ad.i(this.ae, R.drawable.sub_pb_reply_bg);
        } catch (Exception e) {
            com.baidu.tieba.c.af.b(getClass().getName(), "onChangeSkinType", e.getMessage());
        }
    }

    private void i() {
        this.Y = (RelativeLayout) findViewById(R.id.parent);
        this.Z = (RelativeLayout) findViewById(R.id.title);
        this.ac = (TextView) findViewById(R.id.text_title);
        this.ae = (LinearLayout) findViewById(R.id.layout_reply);
        this.v = new ce(this);
        this.z = new cp(this);
        this.aa = (Button) findViewById(R.id.button_back);
        this.aa.setOnClickListener(new cw(this));
        this.x = (Button) findViewById(R.id.reply_button);
        this.x.setEnabled(false);
        this.x.setOnClickListener(new cx(this));
        this.ab = (Button) findViewById(R.id.button_mark);
        this.ab.setOnClickListener(new cy(this));
        this.t = (EditText) findViewById(R.id.reply_content);
        this.s = (ProgressBar) findViewById(R.id.progress);
        this.s.setVisibility(0);
        l();
        this.M = getIntent().getBooleanExtra("manage_mode", false);
        this.N = getIntent().getIntExtra("user_identity", 0);
        this.n = (com.baidu.tieba.a.af) getIntent().getSerializableExtra("mark");
        this.o = getIntent().getBooleanExtra("isMarked", false);
        this.r = getIntent().getBooleanExtra("isFromMention", false);
        this.m = getIntent().getStringExtra("st_type");
        if (this.n != null) {
            this.i = this.n.d();
            this.j = this.n.j();
            this.k = this.n.k();
            this.l = this.n.l();
            this.D = this.n.m();
            this.p = this.n.h().booleanValue();
            this.q = this.n.i();
        } else {
            this.i = getIntent().getStringExtra("themeId");
            this.j = getIntent().getStringExtra("postId");
            this.ab.setEnabled(false);
        }
        Handler handler = new Handler();
        this.ad = (GridView) findViewById(R.id.face_view);
        this.y = (Button) findViewById(R.id.button_face);
        com.baidu.tieba.write.m mVar = new com.baidu.tieba.write.m(this);
        this.ad.setAdapter((ListAdapter) mVar);
        this.ad.setOnItemClickListener(new cz(this, mVar));
        this.y.setOnClickListener(new db(this, handler, new da(this)));
        this.t.setOnTouchListener(new dc(this));
        this.F = new cf(this);
        this.w = getLayoutInflater().inflate(R.layout.sub_pb_header, (ViewGroup) null);
        this.w.setOnLongClickListener(new cg(this));
        this.w.setVisibility(8);
        this.u = (ListView) findViewById(R.id.pb_list);
        this.u.addHeaderView(this.w, null, false);
        this.u.setOnItemClickListener(new ch(this));
        this.u.setOnItemLongClickListener(this.v);
        this.u.setOnScrollListener(new ci(this));
        cj cjVar = new cj(this);
        this.K = new ArrayList();
        this.h = new dh(this, this.g);
        this.h.a(this.M);
        this.h.a(this.N);
        this.h.a(new ck(this, handler, cjVar));
        this.u.setAdapter((ListAdapter) this.h);
        j();
        c(3);
    }

    private void j() {
        Button button = (Button) findViewById(R.id.button_mark);
        ImageView imageView = (ImageView) this.w.findViewById(R.id.mark);
        if (this.o) {
            imageView.setVisibility(0);
            button.setText(R.string.remove_mark);
            return;
        }
        imageView.setVisibility(8);
        button.setText(R.string.add_mark);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        String w = TiebaApplication.w();
        if (w == null || w.length() <= 0) {
            LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 1100010);
            return;
        }
        this.n.e(TiebaApplication.w());
        ImageView imageView = (ImageView) this.w.findViewById(R.id.mark);
        Button button = (Button) findViewById(R.id.button_mark);
        if (this.o) {
            if (com.baidu.tieba.c.k.m(this.n.d())) {
                b(getString(R.string.success));
                this.o = false;
                imageView.setVisibility(8);
                button.setText(R.string.add_mark);
                return;
            }
            b(getString(R.string.fail));
        } else if (com.baidu.tieba.c.k.a(this.n)) {
            b(getString(R.string.success));
            this.o = true;
            imageView.setVisibility(0);
            button.setText(R.string.remove_mark);
        } else {
            b(getString(R.string.fail));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i) {
        int size;
        if ((i != 2 && i != 1) || this.K == null || this.K.size() < 200) {
            if (this.H != null) {
                this.H.a();
                this.H = null;
            }
            if ((i == 2 || i == 1) && this.g != null) {
                List b = this.g.a().b();
                if (b != null && b.size() > 0 && (size = b.size()) > 190) {
                    for (int i2 = 1; i2 <= size - 190 && size - i2 >= 0; i2++) {
                        b.remove(size - i2);
                    }
                    if (i == 2) {
                        this.h.c(2);
                    }
                    if (i == 1) {
                        this.h.b(2);
                    }
                    this.h.notifyDataSetChanged();
                }
            } else {
                this.h.c(0);
                this.h.b(0);
                this.s.setVisibility(0);
            }
            this.H = new dg(this, i);
            this.H.execute(new String[0]);
            if ((i == 2 || i == 1) && this.H != null) {
                this.h.b(true);
                this.h.notifyDataSetChanged();
            }
        }
    }

    private void a(ImageView imageView) {
        com.baidu.tieba.c.a aVar = new com.baidu.tieba.c.a(this);
        String d = this.g.a().a().d().d();
        if (com.baidu.tieba.c.ae.e(d)) {
            imageView.setImageResource(R.drawable.photo);
            return;
        }
        Bitmap b = aVar.b(d);
        if (b != null) {
            imageView.setImageBitmap(b);
        } else {
            aVar.c(d, new cl(this, imageView));
        }
    }

    private void l() {
        this.t.addTextChangedListener(new cm(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m() {
        ImageSpan[] imageSpanArr = (ImageSpan[]) this.t.getText().getSpans(0, this.t.getText().length(), ImageSpan.class);
        int length = imageSpanArr.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (imageSpanArr[i2] != null && imageSpanArr[i2].getSource() != null) {
                i += imageSpanArr[i2].getSource().length();
            }
        }
        return (this.t.getText().toString().length() - i) + length > 140;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        String a;
        if (this.g != null && this.g.a().a() != null) {
            TextView textView = (TextView) this.w.findViewById(R.id.text);
            TextView textView2 = (TextView) this.w.findViewById(R.id.user_name);
            ImageView imageView = (ImageView) this.w.findViewById(R.id.photo);
            LinearLayout linearLayout = (LinearLayout) this.w.findViewById(R.id.seg);
            TextView textView3 = (TextView) this.w.findViewById(R.id.text_reply_num);
            TextView textView4 = (TextView) this.w.findViewById(R.id.del_post);
            TextView textView5 = (TextView) this.w.findViewById(R.id.forbid_user);
            View findViewById = this.w.findViewById(R.id.manage_divider);
            com.baidu.tieba.a.an a2 = this.g.a().a();
            this.ac.setText(getString(R.string.format_floor, new Object[]{Integer.valueOf(a2.b())}));
            ((TextView) this.w.findViewById(R.id.rank)).setText(getString(R.string.format_grade, new Object[]{Integer.valueOf(a2.d().k())}));
            ((TextView) this.w.findViewById(R.id.floor)).setText(getString(R.string.format_floor, new Object[]{Integer.valueOf(a2.b())}));
            ((TextView) this.w.findViewById(R.id.time)).setText(com.baidu.tieba.c.ae.a(a2.c()));
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            int d = this.g.a().d();
            if (d > 0) {
                textView3.setText(String.valueOf(d));
            } else {
                textView3.setVisibility(4);
            }
            textView2.setTextSize(com.baidu.tieba.a.i.l());
            textView2.setText(this.g.a().a().d().c());
            ArrayList e = a2.e();
            com.baidu.tieba.c.g gVar = new com.baidu.tieba.c.g(this);
            gVar.a(-11974584);
            gVar.a(true);
            gVar.a(textView, linearLayout, e, false);
            cn cnVar = new cn(this);
            imageView.setOnClickListener(cnVar);
            textView2.setOnClickListener(cnVar);
            String a3 = this.g.a().a().d().a();
            if (a3 == null || a3.length() <= 0 || a3.equals("0")) {
                textView2.setTextColor(-16777216);
                textView2.setTag(null);
            } else {
                textView2.setTextColor(-9989158);
                textView2.setTag(a3);
            }
            this.C = a2.a();
            this.s.setVisibility(8);
            this.w.setVisibility(0);
            textView5.setVisibility(4);
            textView4.setVisibility(4);
            if (this.M && this.N != 0) {
                textView5.setVisibility(0);
                textView4.setVisibility(0);
                String a4 = a2.d().a();
                if (a4 != null && a4.equals(TiebaApplication.w())) {
                    textView5.setVisibility(4);
                }
                if (a4 == null || a4.equals("0") || a4.length() == 0) {
                    textView5.setVisibility(4);
                }
            } else {
                com.baidu.tieba.a.av h = this.g.a().h();
                if (h != null && (a = h.h().a()) != null && a.equals(TiebaApplication.w()) && a2.b() != 1) {
                    textView4.setVisibility(0);
                }
            }
            findViewById.setVisibility(4);
            if (textView5.getVisibility() == 0 && textView4.getVisibility() == 0) {
                findViewById.setVisibility(0);
            }
            textView4.setOnClickListener(new co(this, a2));
            textView5.setOnClickListener(new cq(this, a2));
            if (TiebaApplication.b().s()) {
                imageView.setVisibility(0);
                a(imageView);
                return;
            }
            imageView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        this.t.setText((CharSequence) null);
        if (this.ad.getVisibility() == 0) {
            this.ad.setVisibility(8);
        }
        com.baidu.tieba.c.ah.a(this, this.t);
        this.y.setBackgroundResource(R.drawable.sub_pb_face);
        this.h.c(2);
        this.h.notifyDataSetChanged();
        if (this.g != null && this.g.a() != null && this.g.a().e() == this.g.a().c()) {
            c(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        String j;
        this.n = new com.baidu.tieba.a.af();
        Date date = new Date();
        this.n.e(TiebaApplication.w());
        this.n.a(date.getTime());
        this.n.a((Boolean) true);
        this.n.b(1);
        this.n.a(Boolean.valueOf(this.p));
        this.n.a(this.q);
        if (this.K != null) {
            com.baidu.tieba.a.an a = this.g.a().a();
            com.baidu.tieba.a.av h = this.g.a().h();
            com.baidu.tieba.a.q f = this.g.a().f();
            this.k = f.b();
            this.l = f.c();
            this.D = h.a();
            this.j = a.a();
            this.J = this.g.a().e();
            this.n.b(h.a());
            this.n.c(h.c());
            this.n.a(h.h().c());
            this.n.a(h.d());
            this.n.f(f.b());
            this.n.g(f.c());
            this.n.h(h.a());
            this.n.c(a.b());
            this.n.d(a.a());
        }
        boolean z = false;
        com.baidu.tieba.a.af l = com.baidu.tieba.c.k.l(this.i);
        if (l != null && (j = l.j()) != null && j.equals(this.j)) {
            z = true;
        }
        if (this.o != z) {
            this.o = z;
            j();
        }
        ((Button) findViewById(R.id.button_mark)).setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        String w = TiebaApplication.w();
        if (w == null || w.length() <= 0) {
            if (this.E != null) {
                this.E.a(1);
            }
            LoginActivity.a((Activity) this, getString(R.string.login_to_post), true, 1100005);
        } else if (this.E != null && this.E.a() == 0) {
            com.baidu.tieba.c.ah.a((Context) this, this.E.e());
        } else {
            String editable = this.t.getText().toString();
            if (editable != null && editable.length() > 0 && this.g != null && this.g.a() != null) {
                if (m()) {
                    editable = editable.substring(0, 140);
                }
                a(getString(R.string.sending), this.F);
                com.baidu.tieba.b.w wVar = new com.baidu.tieba.b.w();
                wVar.e(this.k);
                wVar.f(this.l);
                wVar.b(editable);
                wVar.g(null);
                wVar.d(this.C);
                wVar.c(this.D);
                wVar.b(0);
                wVar.a(2);
                this.G = new df(this, wVar);
                this.G.execute(new Integer[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e
    public void a() {
        r();
        super.a();
    }

    private void r() {
        if (this.O != null && this.O.isShowing()) {
            this.O.dismiss();
        }
        if (this.S != null && this.S.isShowing()) {
            this.S.dismiss();
        }
    }

    public void a(int i, String str) {
        if (this.O == null) {
            this.O = new Dialog(this, R.style.common_alert_dialog);
            this.O.setCanceledOnTouchOutside(true);
            this.O.setCancelable(true);
            this.P = getLayoutInflater().inflate(R.layout.del_post, (ViewGroup) null);
            this.O.setContentView(this.P);
            WindowManager.LayoutParams attributes = this.O.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.tieba.c.ah.a((Context) this) * 0.9d);
            this.O.getWindow().setAttributes(attributes);
            this.Q = (Button) this.P.findViewById(R.id.dialog_button_ok);
            this.R = (Button) this.P.findViewById(R.id.dialog_button_cancel);
            this.R.setOnClickListener(new cr(this));
        }
        if (this.g != null) {
            this.Q.setOnClickListener(new cs(this, i, str));
            this.O.show();
        }
    }

    public void c(String str) {
        if (this.S == null) {
            this.S = new Dialog(this, R.style.common_alert_dialog);
            this.S.setCanceledOnTouchOutside(true);
            this.S.setCancelable(true);
            this.T = getLayoutInflater().inflate(R.layout.forbid_user, (ViewGroup) null);
            this.S.setContentView(this.T);
            WindowManager.LayoutParams attributes = this.S.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.tieba.c.ah.a((Context) this) * 0.9d);
            this.S.getWindow().setAttributes(attributes);
            this.c = (RadioGroup) this.T.findViewById(R.id.radio_group);
            this.d = (RadioButton) this.T.findViewById(R.id.radio_button_1day);
            this.e = (RadioButton) this.T.findViewById(R.id.radio_button_3day);
            this.f = (RadioButton) this.T.findViewById(R.id.radio_button_10day);
            ct ctVar = new ct(this);
            this.d.setOnCheckedChangeListener(ctVar);
            this.e.setOnCheckedChangeListener(ctVar);
            this.f.setOnCheckedChangeListener(ctVar);
            this.V = (Button) this.T.findViewById(R.id.dialog_button_ok);
            this.W = (Button) this.T.findViewById(R.id.dialog_button_cancel);
            this.W.setOnClickListener(new cu(this));
            this.X = (TextView) this.T.findViewById(R.id.user_name);
        }
        if (this.g != null) {
            this.X.setText(str);
            this.c.check(R.id.radio_button_1day);
            if (this.N == 2) {
                this.e.setVisibility(8);
                this.f.setVisibility(8);
            }
            this.V.setOnClickListener(new cv(this, str));
            this.S.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, String str) {
        String w = TiebaApplication.w();
        if (w == null || w.length() <= 0) {
            LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 1100019);
        } else if (!this.g.b()) {
            this.g.a(true);
            if (this.af != null) {
                this.af.a();
                this.af = null;
            }
            com.baidu.tieba.a.q f = this.g.a().f();
            com.baidu.tieba.a.av h = this.g.a().h();
            if (f != null) {
                this.af = new dd(this, f.b(), f.c(), h.a(), str, i);
                this.af.execute("http://c.tieba.baidu.com/c/c/bawu/delpost");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        String w = TiebaApplication.w();
        if (w == null || w.length() <= 0) {
            LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 1100020);
        } else if (!this.g.c()) {
            this.g.b(true);
            if (this.ag != null) {
                this.ag.a();
                this.ag = null;
            }
            com.baidu.tieba.a.q f = this.g.a().f();
            this.ag = new de(this, f.b(), f.c(), this.g.a().h().a(), str, String.valueOf(this.U));
            this.ag.execute("http://c.tieba.baidu.com/c/c/bawu/commitprison");
        }
    }
}
