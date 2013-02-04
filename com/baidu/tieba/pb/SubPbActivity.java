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
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/* loaded from: classes.dex */
public class SubPbActivity extends com.baidu.tieba.e {
    private List J;
    private EditText s;
    private ListView t;
    private View v;
    private Button w;
    private Button x;
    private DialogInterface.OnClickListener y;
    private com.baidu.tieba.b.r f = null;
    private df g = null;
    private String h = null;
    private String i = null;
    private String j = null;
    private String k = null;
    private String l = null;
    private com.baidu.tieba.a.ae m = null;
    private boolean n = false;
    private boolean o = true;
    private boolean p = false;
    private boolean q = false;
    private ProgressBar r = null;
    private AdapterView.OnItemLongClickListener u = null;
    private com.baidu.tieba.a.am z = null;
    private int A = -1;
    private String B = null;
    private String C = null;
    private com.baidu.tieba.a.b D = null;
    private DialogInterface.OnCancelListener E = null;
    private dd F = null;
    private de G = null;
    private int H = 1;
    private int I = 1;
    private String K = null;
    private boolean L = false;
    private int M = 0;
    private Dialog N = null;
    private View O = null;
    private Button P = null;
    private Button Q = null;
    private Dialog R = null;
    private View S = null;
    private int T = 0;
    RadioGroup b = null;
    RadioButton c = null;
    RadioButton d = null;
    RadioButton e = null;
    private Button U = null;
    private Button V = null;
    private TextView W = null;
    private db X = null;
    private dc Y = null;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        int size;
        if ((i == 2 || i == 1) && this.J != null && this.J.size() >= 200) {
            return;
        }
        if (this.G != null) {
            this.G.a();
            this.G = null;
        }
        if ((i == 2 || i == 1) && this.f != null) {
            List b = this.f.a().b();
            if (b != null && b.size() > 0 && (size = b.size()) > 190) {
                for (int i2 = 1; i2 <= size - 190 && size - i2 >= 0; i2++) {
                    b.remove(size - i2);
                }
                if (i == 2) {
                    this.g.c(2);
                }
                if (i == 1) {
                    this.g.b(2);
                }
                this.g.notifyDataSetChanged();
            }
        } else {
            this.g.c(0);
            this.g.b(0);
            this.r.setVisibility(0);
        }
        this.G = new de(this, i);
        this.G.execute(new String[0]);
        if ((i == 2 || i == 1) && this.G != null) {
            this.g.b(true);
            this.g.notifyDataSetChanged();
        }
    }

    private void a(ImageView imageView) {
        com.baidu.tieba.c.a aVar = new com.baidu.tieba.c.a(this);
        String d = this.f.a().a().d().d();
        if (com.baidu.tieba.c.ad.e(d)) {
            imageView.setImageResource(R.drawable.photo);
            return;
        }
        Bitmap b = aVar.b(d);
        if (b != null) {
            imageView.setImageBitmap(b);
        } else {
            aVar.c(d, new cj(this, imageView));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, String str) {
        String u = TiebaApplication.u();
        if (u == null || u.length() <= 0) {
            LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 1100019);
        } else if (this.f.b()) {
        } else {
            this.f.a(true);
            if (this.X != null) {
                this.X.a();
                this.X = null;
            }
            com.baidu.tieba.a.p f = this.f.a().f();
            com.baidu.tieba.a.as h = this.f.a().h();
            if (f != null) {
                this.X = new db(this, f.b(), f.c(), h.a(), str, i);
                this.X.execute("http://c.tieba.baidu.com/c/c/bawu/delpost");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        String u = TiebaApplication.u();
        if (u == null || u.length() <= 0) {
            LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 1100020);
        } else if (this.f.c()) {
        } else {
            this.f.b(true);
            if (this.Y != null) {
                this.Y.a();
                this.Y = null;
            }
            com.baidu.tieba.a.p f = this.f.a().f();
            this.Y = new dc(this, f.b(), f.c(), this.f.a().h().a(), str, String.valueOf(this.T));
            this.Y.execute("http://c.tieba.baidu.com/c/c/bawu/commitprison");
        }
    }

    private void g() {
        this.u = new cc(this);
        this.y = new cn(this);
        ((Button) findViewById(R.id.button_back)).setOnClickListener(new cu(this));
        this.w = (Button) findViewById(R.id.reply_button);
        this.w.setEnabled(false);
        this.w.setOnClickListener(new cv(this));
        Button button = (Button) findViewById(R.id.button_mark);
        button.setOnClickListener(new cw(this));
        this.s = (EditText) findViewById(R.id.reply_content);
        this.r = (ProgressBar) findViewById(R.id.progress);
        this.r.setVisibility(0);
        j();
        this.L = getIntent().getBooleanExtra("manage_mode", false);
        this.M = getIntent().getIntExtra("user_identity", 0);
        this.m = (com.baidu.tieba.a.ae) getIntent().getSerializableExtra("mark");
        this.n = getIntent().getBooleanExtra("isMarked", false);
        this.q = getIntent().getBooleanExtra("isFromMention", false);
        this.l = getIntent().getStringExtra("st_type");
        if (this.m != null) {
            this.h = this.m.d();
            this.i = this.m.j();
            this.j = this.m.k();
            this.k = this.m.l();
            this.C = this.m.m();
            this.o = this.m.h().booleanValue();
            this.p = this.m.i();
        } else {
            this.h = getIntent().getStringExtra("themeId");
            this.i = getIntent().getStringExtra("postId");
            button.setEnabled(false);
        }
        Handler handler = new Handler();
        GridView gridView = (GridView) findViewById(R.id.face_view);
        this.x = (Button) findViewById(R.id.button_face);
        com.baidu.tieba.write.m mVar = new com.baidu.tieba.write.m(this);
        gridView.setAdapter((ListAdapter) mVar);
        gridView.setOnItemClickListener(new cx(this, mVar));
        this.x.setOnClickListener(new cz(this, gridView, handler, new cy(this, gridView)));
        this.s.setOnTouchListener(new da(this, gridView));
        this.E = new cd(this);
        this.v = getLayoutInflater().inflate(R.layout.sub_pb_header, (ViewGroup) null);
        this.v.setOnLongClickListener(new ce(this));
        this.v.setVisibility(8);
        this.t = (ListView) findViewById(R.id.pb_list);
        this.t.addHeaderView(this.v, null, false);
        this.t.setOnItemClickListener(new cf(this));
        this.t.setOnItemLongClickListener(this.u);
        this.t.setOnScrollListener(new cg(this, gridView));
        ch chVar = new ch(this);
        this.J = new ArrayList();
        this.g = new df(this, this.f);
        this.g.a(this.L);
        this.g.a(this.M);
        this.g.a(new ci(this, gridView, handler, chVar));
        this.t.setAdapter((ListAdapter) this.g);
        h();
        a(3);
    }

    private void h() {
        Button button = (Button) findViewById(R.id.button_mark);
        ImageView imageView = (ImageView) this.v.findViewById(R.id.mark);
        if (this.n) {
            imageView.setVisibility(0);
            button.setText(R.string.remove_mark);
            return;
        }
        imageView.setVisibility(8);
        button.setText(R.string.add_mark);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        String u = TiebaApplication.u();
        if (u == null || u.length() <= 0) {
            LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 1100010);
            return;
        }
        this.m.e(TiebaApplication.u());
        ImageView imageView = (ImageView) this.v.findViewById(R.id.mark);
        Button button = (Button) findViewById(R.id.button_mark);
        if (this.n) {
            if (!com.baidu.tieba.c.k.l(this.m.d())) {
                b(getString(R.string.fail));
                return;
            }
            b(getString(R.string.success));
            this.n = false;
            imageView.setVisibility(8);
            button.setText(R.string.add_mark);
        } else if (!com.baidu.tieba.c.k.a(this.m)) {
            b(getString(R.string.fail));
        } else {
            b(getString(R.string.success));
            this.n = true;
            imageView.setVisibility(0);
            button.setText(R.string.remove_mark);
        }
    }

    private void j() {
        this.s.addTextChangedListener(new ck(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean k() {
        ImageSpan[] imageSpanArr = (ImageSpan[]) this.s.getText().getSpans(0, this.s.getText().length(), ImageSpan.class);
        int length = imageSpanArr.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (imageSpanArr[i2] != null && imageSpanArr[i2].getSource() != null) {
                i += imageSpanArr[i2].getSource().length();
            }
        }
        return (this.s.getText().toString().length() - i) + length > 140;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        String a;
        if (this.f == null || this.f.a().a() == null) {
            return;
        }
        TextView textView = (TextView) this.v.findViewById(R.id.text);
        TextView textView2 = (TextView) this.v.findViewById(R.id.user_name);
        ImageView imageView = (ImageView) this.v.findViewById(R.id.photo);
        LinearLayout linearLayout = (LinearLayout) this.v.findViewById(R.id.seg);
        TextView textView3 = (TextView) this.v.findViewById(R.id.text_reply_num);
        TextView textView4 = (TextView) this.v.findViewById(R.id.del_post);
        TextView textView5 = (TextView) this.v.findViewById(R.id.forbid_user);
        View findViewById = this.v.findViewById(R.id.manage_divider);
        com.baidu.tieba.a.am a2 = this.f.a().a();
        ((TextView) findViewById(R.id.text_title)).setText(getString(R.string.format_floor, new Object[]{Integer.valueOf(a2.b())}));
        ((TextView) this.v.findViewById(R.id.rank)).setText(getString(R.string.format_grade, new Object[]{Integer.valueOf(a2.d().k())}));
        ((TextView) this.v.findViewById(R.id.floor)).setText(getString(R.string.format_floor, new Object[]{Integer.valueOf(a2.b())}));
        ((TextView) this.v.findViewById(R.id.time)).setText(com.baidu.tieba.c.ad.a(a2.c()));
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        int d = this.f.a().d();
        if (d > 0) {
            textView3.setText(String.valueOf(d));
        } else {
            textView3.setVisibility(4);
        }
        textView2.setTextSize(com.baidu.tieba.a.h.l());
        textView2.setText(this.f.a().a().d().c());
        ArrayList e = a2.e();
        com.baidu.tieba.c.g gVar = new com.baidu.tieba.c.g(this);
        gVar.a(true);
        gVar.a(textView, linearLayout, e, false);
        cl clVar = new cl(this);
        imageView.setOnClickListener(clVar);
        textView2.setOnClickListener(clVar);
        String a3 = this.f.a().a().d().a();
        if (a3 == null || a3.length() <= 0 || a3.equals("0")) {
            textView2.setTextColor(-16777216);
        } else {
            textView2.setTextColor(-9989158);
        }
        this.B = a2.a();
        this.r.setVisibility(8);
        this.v.setVisibility(0);
        textView5.setVisibility(4);
        textView4.setVisibility(4);
        if (!this.L || this.M == 0) {
            com.baidu.tieba.a.as h = this.f.a().h();
            if (h != null && (a = h.h().a()) != null && a.equals(TiebaApplication.u()) && a2.b() != 1) {
                textView4.setVisibility(0);
            }
        } else {
            textView5.setVisibility(0);
            textView4.setVisibility(0);
            String a4 = a2.d().a();
            if (a4 != null && a4.equals(TiebaApplication.u())) {
                textView5.setVisibility(4);
            }
            if (a4 == null || a4.equals("0") || a4.length() == 0) {
                textView5.setVisibility(4);
            }
        }
        findViewById.setVisibility(4);
        if (textView5.getVisibility() == 0 && textView4.getVisibility() == 0) {
            findViewById.setVisibility(0);
        }
        textView4.setOnClickListener(new cm(this, a2));
        textView5.setOnClickListener(new co(this, a2));
        if (!TiebaApplication.a().q()) {
            imageView.setVisibility(8);
            return;
        }
        imageView.setVisibility(0);
        a(imageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        b(TiebaApplication.a().getString(R.string.send_success));
        this.s.setText((CharSequence) null);
        GridView gridView = (GridView) findViewById(R.id.face_view);
        if (gridView.getVisibility() == 0) {
            gridView.setVisibility(8);
        }
        com.baidu.tieba.c.ag.a(this, this.s);
        this.x.setBackgroundResource(R.drawable.sub_pb_face);
        this.g.c(2);
        this.g.notifyDataSetChanged();
        if (this.f == null || this.f.a() == null || this.f.a().e() != this.f.a().c()) {
            return;
        }
        a(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        String j;
        this.m = new com.baidu.tieba.a.ae();
        Date date = new Date();
        this.m.e(TiebaApplication.u());
        this.m.a(date.getTime());
        this.m.a((Boolean) true);
        this.m.b(1);
        this.m.a(Boolean.valueOf(this.o));
        this.m.a(this.p);
        if (this.J != null) {
            com.baidu.tieba.a.am a = this.f.a().a();
            com.baidu.tieba.a.as h = this.f.a().h();
            com.baidu.tieba.a.p f = this.f.a().f();
            this.j = f.b();
            this.k = f.c();
            this.C = h.a();
            this.i = a.a();
            this.I = this.f.a().e();
            this.m.b(h.a());
            this.m.c(h.c());
            this.m.a(h.h().c());
            this.m.a(h.d());
            this.m.f(f.b());
            this.m.g(f.c());
            this.m.h(h.a());
            this.m.c(a.b());
            this.m.d(a.a());
        }
        boolean z = false;
        com.baidu.tieba.a.ae k = com.baidu.tieba.c.k.k(this.h);
        if (k != null && (j = k.j()) != null && j.equals(this.i)) {
            z = true;
        }
        if (this.n != z) {
            this.n = z;
            h();
        }
        ((Button) findViewById(R.id.button_mark)).setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        String u = TiebaApplication.u();
        if (u == null || u.length() <= 0) {
            if (this.D != null) {
                this.D.a(1);
            }
            LoginActivity.a((Activity) this, getString(R.string.login_to_post), true, 1100005);
        } else if (this.D != null && this.D.a() == 0) {
            com.baidu.tieba.c.ag.a((Context) this, this.D.e());
        } else {
            String editable = this.s.getText().toString();
            if (editable == null || editable.length() <= 0 || this.f == null || this.f.a() == null) {
                return;
            }
            if (k()) {
                editable = editable.substring(0, 140);
            }
            a(getString(R.string.sending), this.E);
            com.baidu.tieba.b.u uVar = new com.baidu.tieba.b.u();
            uVar.e(this.j);
            uVar.f(this.k);
            uVar.b(editable);
            uVar.g(null);
            uVar.d(this.B);
            uVar.c(this.C);
            uVar.b(0);
            uVar.a(2);
            this.F = new dd(this, uVar);
            this.F.execute(new Integer[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        q();
        finish();
    }

    private void q() {
        if (this.N != null && this.N.isShowing()) {
            this.N.dismiss();
        }
        if (this.R == null || !this.R.isShowing()) {
            return;
        }
        this.R.dismiss();
    }

    public void a(int i, String str) {
        if (this.N == null) {
            this.N = new Dialog(this, R.style.common_alert_dialog);
            this.N.setCanceledOnTouchOutside(true);
            this.N.setCancelable(true);
            this.O = getLayoutInflater().inflate(R.layout.del_post, (ViewGroup) null);
            this.N.setContentView(this.O);
            WindowManager.LayoutParams attributes = this.N.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.tieba.c.ag.a((Context) this) * 0.9d);
            this.N.getWindow().setAttributes(attributes);
            this.P = (Button) this.O.findViewById(R.id.dialog_button_ok);
            this.Q = (Button) this.O.findViewById(R.id.dialog_button_cancel);
            this.Q.setOnClickListener(new cp(this));
        }
        if (this.f != null) {
            this.P.setOnClickListener(new cq(this, i, str));
            this.N.show();
        }
    }

    public void c(String str) {
        if (this.R == null) {
            this.R = new Dialog(this, R.style.common_alert_dialog);
            this.R.setCanceledOnTouchOutside(true);
            this.R.setCancelable(true);
            this.S = getLayoutInflater().inflate(R.layout.forbid_user, (ViewGroup) null);
            this.R.setContentView(this.S);
            WindowManager.LayoutParams attributes = this.R.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.tieba.c.ag.a((Context) this) * 0.9d);
            this.R.getWindow().setAttributes(attributes);
            this.b = (RadioGroup) this.S.findViewById(R.id.radio_group);
            this.c = (RadioButton) this.S.findViewById(R.id.radio_button_1day);
            this.d = (RadioButton) this.S.findViewById(R.id.radio_button_3day);
            this.e = (RadioButton) this.S.findViewById(R.id.radio_button_10day);
            cr crVar = new cr(this);
            this.c.setOnCheckedChangeListener(crVar);
            this.d.setOnCheckedChangeListener(crVar);
            this.e.setOnCheckedChangeListener(crVar);
            this.U = (Button) this.S.findViewById(R.id.dialog_button_ok);
            this.V = (Button) this.S.findViewById(R.id.dialog_button_cancel);
            this.V.setOnClickListener(new cs(this));
            this.W = (TextView) this.S.findViewById(R.id.user_name);
        }
        if (this.f != null) {
            this.W.setText(str);
            this.b.check(R.id.radio_button_1day);
            if (this.M == 2) {
                this.d.setVisibility(8);
                this.e.setVisibility(8);
            }
            this.U.setOnClickListener(new ct(this, str));
            this.R.show();
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 1200005) {
                m();
            } else if (i == 1100010) {
                i();
            } else if (i == 1100005) {
                o();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.sub_pb_activity);
        this.D = (com.baidu.tieba.a.b) getIntent().getSerializableExtra("anti");
        this.K = TiebaApplication.u();
        g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        try {
            if (this.F != null) {
                this.F.a();
                this.F = null;
            }
            if (this.G != null) {
                this.G.a();
                this.G = null;
            }
            if (this.g != null) {
                this.g.e();
            }
            if (this.X != null) {
                this.X.a();
                this.X = null;
            }
            if (this.Y != null) {
                this.Y.a();
                this.Y = null;
            }
            q();
        } catch (Exception e) {
            com.baidu.tieba.c.ae.c(getClass().getName(), "onDestroy", e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onResume() {
        super.onResume();
        String u = TiebaApplication.u();
        if (this.K != null || u == null || u.length() <= 0) {
            return;
        }
        this.K = u;
        if (this.D != null) {
            this.D.a(1);
        }
    }
}
