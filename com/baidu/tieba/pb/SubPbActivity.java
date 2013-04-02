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
import java.util.List;
/* loaded from: classes.dex */
public class SubPbActivity extends com.baidu.tieba.e {
    private List G;
    private EditText p;
    private ListView q;
    private View s;
    private Button t;
    private Button u;
    private DialogInterface.OnClickListener v;
    private com.baidu.tieba.b.w g = null;
    private Cdo h = null;
    private String i = null;
    private String j = null;
    private String k = null;
    private String l = null;
    private boolean m = false;
    private boolean n = false;
    private ProgressBar o = null;
    private AdapterView.OnItemLongClickListener r = null;
    private com.baidu.tieba.a.an w = null;
    private int x = -1;
    private String y = null;
    private String z = null;
    private com.baidu.tieba.a.b A = null;
    private DialogInterface.OnCancelListener B = null;
    private dm C = null;
    private dn D = null;
    private int E = 1;
    private int F = 1;
    private String H = null;
    private boolean I = false;
    private int J = 0;
    private Dialog K = null;
    private View L = null;
    private Button M = null;
    private Button N = null;
    private Dialog O = null;
    private View P = null;
    private int Q = 0;
    RadioGroup c = null;
    RadioButton d = null;
    RadioButton e = null;
    RadioButton f = null;
    private Button R = null;
    private Button S = null;
    private TextView T = null;
    private RelativeLayout U = null;
    private RelativeLayout V = null;
    private Button W = null;
    private TextView X = null;
    private GridView Y = null;
    private LinearLayout Z = null;
    private dk aa = null;
    private dl ab = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.sub_pb_activity);
        this.A = (com.baidu.tieba.a.b) getIntent().getSerializableExtra("anti");
        this.H = TiebaApplication.y();
        i();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        try {
            if (this.C != null) {
                this.C.a();
                this.C = null;
            }
            if (this.D != null) {
                this.D.a();
                this.D = null;
            }
            if (this.h != null) {
                this.h.e();
            }
            if (this.aa != null) {
                this.aa.a();
                this.aa = null;
            }
            if (this.ab != null) {
                this.ab.a();
                this.ab = null;
            }
            p();
        } catch (Exception e) {
            com.baidu.tieba.c.ag.e(getClass().getName(), "onDestroy", e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onResume() {
        super.onResume();
        String y = TiebaApplication.y();
        if (this.H == null && y != null && y.length() > 0) {
            this.H = y;
            if (this.A != null) {
                this.A.a(1);
            }
        }
    }

    public static void a(Context context, String str, String str2, boolean z) {
        Intent intent = new Intent(context, SubPbActivity.class);
        intent.putExtra("threadId", str);
        intent.putExtra("postId", str2);
        intent.putExtra("isFromMention", z);
        context.startActivity(intent);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 1200005) {
                n();
            } else if (i == 1100005) {
                o();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e
    public void b(int i) {
        super.b(i);
        try {
            com.baidu.tieba.c.ae.a(this.U, i);
            com.baidu.tieba.c.ae.c(this.V, i);
            com.baidu.tieba.c.ae.c(this.X, i);
            com.baidu.tieba.c.ae.e((TextView) this.W, i);
            com.baidu.tieba.c.ae.b(this.q, i);
            this.h.notifyDataSetChanged();
            TextView textView = (TextView) this.s.findViewById(R.id.text);
            TextView textView2 = (TextView) this.s.findViewById(R.id.user_name);
            TextView textView3 = (TextView) this.s.findViewById(R.id.rank);
            TextView textView4 = (TextView) this.s.findViewById(R.id.time);
            TextView textView5 = (TextView) this.s.findViewById(R.id.floor);
            View findViewById = this.s.findViewById(R.id.manage_divider);
            if (i == 1) {
                this.s.setBackgroundResource(R.drawable.sub_pb_post_bg_1);
                textView3.setTextColor(com.baidu.tieba.c.ae.b(i));
                findViewById.setBackgroundColor(getResources().getColor(R.color.skin_1_divider_color));
                textView5.setTextColor(com.baidu.tieba.c.ae.b(i));
                textView5.setBackgroundResource(R.drawable.floor_bg_1);
                textView.setTextColor(com.baidu.tieba.c.ae.a(i));
                textView4.setTextColor(com.baidu.tieba.c.ae.b(i));
                if (textView2.getTag() == null) {
                    textView4.setTextColor(com.baidu.tieba.c.ae.a(i));
                }
                this.Y.setBackgroundColor(getResources().getColor(R.color.skin_1_face_bg_color));
                com.baidu.tieba.c.ae.h(this.Z, R.drawable.sub_pb_reply_bg_1);
                return;
            }
            this.s.setBackgroundResource(R.drawable.sub_pb_post_bg);
            textView3.setTextColor(-9276814);
            findViewById.setBackgroundColor(-6710887);
            textView5.setTextColor(-9276814);
            textView5.setBackgroundResource(R.drawable.floor_bg);
            textView.setTextColor(-11974584);
            textView4.setTextColor(-9276814);
            if (textView2.getTag() == null) {
                textView4.setTextColor(-16777216);
            }
            this.Y.setBackgroundColor(-1644826);
            com.baidu.tieba.c.ae.h(this.Z, R.drawable.sub_pb_reply_bg);
        } catch (Exception e) {
            com.baidu.tieba.c.ag.b(getClass().getName(), "onChangeSkinType", e.getMessage());
        }
    }

    private void i() {
        this.U = (RelativeLayout) findViewById(R.id.parent);
        this.V = (RelativeLayout) findViewById(R.id.title);
        this.X = (TextView) findViewById(R.id.text_title);
        this.Z = (LinearLayout) findViewById(R.id.layout_reply);
        this.r = new cm(this);
        this.v = new cx(this);
        this.W = (Button) findViewById(R.id.button_back);
        this.W.setOnClickListener(new dd(this));
        this.t = (Button) findViewById(R.id.reply_button);
        this.t.setEnabled(false);
        this.t.setOnClickListener(new de(this));
        this.p = (EditText) findViewById(R.id.reply_content);
        this.o = (ProgressBar) findViewById(R.id.progress);
        this.o.setVisibility(0);
        k();
        this.I = getIntent().getBooleanExtra("manage_mode", false);
        this.J = getIntent().getIntExtra("user_identity", 0);
        this.m = getIntent().getBooleanExtra("isMarked", false);
        this.n = getIntent().getBooleanExtra("isFromMention", false);
        this.l = getIntent().getStringExtra("st_type");
        this.i = getIntent().getStringExtra("postId");
        this.z = getIntent().getStringExtra("threadId");
        Handler handler = new Handler();
        this.Y = (GridView) findViewById(R.id.face_view);
        this.u = (Button) findViewById(R.id.button_face);
        com.baidu.tieba.write.m mVar = new com.baidu.tieba.write.m(this);
        this.Y.setAdapter((ListAdapter) mVar);
        this.Y.setOnItemClickListener(new df(this, mVar));
        this.u.setOnClickListener(new dh(this, handler, new dg(this)));
        this.p.setOnTouchListener(new di(this));
        this.B = new dj(this);
        this.s = getLayoutInflater().inflate(R.layout.sub_pb_header, (ViewGroup) null);
        this.s.setOnLongClickListener(new cn(this));
        this.s.setVisibility(8);
        this.q = (ListView) findViewById(R.id.pb_list);
        this.q.addHeaderView(this.s, null, false);
        this.q.setOnItemClickListener(new co(this));
        this.q.setOnItemLongClickListener(this.r);
        this.q.setOnScrollListener(new cp(this));
        cq cqVar = new cq(this);
        this.G = new ArrayList();
        this.h = new Cdo(this, this.g);
        this.h.a(this.I);
        this.h.a(this.J);
        this.h.a(new cr(this, handler, cqVar));
        this.q.setAdapter((ListAdapter) this.h);
        j();
        c(3);
    }

    private void j() {
        Button button = (Button) findViewById(R.id.button_mark);
        ImageView imageView = (ImageView) this.s.findViewById(R.id.mark);
        if (this.m) {
            imageView.setVisibility(0);
            button.setText(R.string.remove_mark);
            return;
        }
        imageView.setVisibility(8);
        button.setText(R.string.add_mark);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i) {
        int size;
        if ((i != 2 && i != 1) || this.G == null || this.G.size() < 200) {
            if (this.D != null) {
                this.D.a();
                this.D = null;
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
                this.o.setVisibility(0);
            }
            this.D = new dn(this, i);
            this.D.execute(new String[0]);
            if ((i == 2 || i == 1) && this.D != null) {
                this.h.b(true);
                this.h.notifyDataSetChanged();
            }
        }
    }

    private void a(ImageView imageView) {
        com.baidu.tieba.c.a aVar = new com.baidu.tieba.c.a(this);
        String d = this.g.a().a().e().d();
        if (com.baidu.tieba.c.af.e(d)) {
            imageView.setImageResource(R.drawable.photo);
            return;
        }
        Bitmap b = aVar.b(d);
        if (b != null) {
            imageView.setImageBitmap(b);
        } else {
            aVar.c(d, new cs(this, imageView));
        }
    }

    private void k() {
        this.p.addTextChangedListener(new ct(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean l() {
        ImageSpan[] imageSpanArr = (ImageSpan[]) this.p.getText().getSpans(0, this.p.getText().length(), ImageSpan.class);
        int length = imageSpanArr.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (imageSpanArr[i2] != null && imageSpanArr[i2].getSource() != null) {
                i += imageSpanArr[i2].getSource().length();
            }
        }
        return (this.p.getText().toString().length() - i) + length > 140;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        String a;
        if (this.g != null && this.g.a().a() != null) {
            TextView textView = (TextView) this.s.findViewById(R.id.text);
            TextView textView2 = (TextView) this.s.findViewById(R.id.user_name);
            ImageView imageView = (ImageView) this.s.findViewById(R.id.photo);
            LinearLayout linearLayout = (LinearLayout) this.s.findViewById(R.id.seg);
            TextView textView3 = (TextView) this.s.findViewById(R.id.text_reply_num);
            TextView textView4 = (TextView) this.s.findViewById(R.id.del_post);
            TextView textView5 = (TextView) this.s.findViewById(R.id.forbid_user);
            View findViewById = this.s.findViewById(R.id.manage_divider);
            com.baidu.tieba.a.an a2 = this.g.a().a();
            this.X.setText(getString(R.string.format_floor, new Object[]{Integer.valueOf(a2.c())}));
            ((TextView) this.s.findViewById(R.id.rank)).setText(getString(R.string.format_grade, new Object[]{Integer.valueOf(a2.e().k())}));
            ((TextView) this.s.findViewById(R.id.floor)).setText(getString(R.string.format_floor, new Object[]{Integer.valueOf(a2.c())}));
            ((TextView) this.s.findViewById(R.id.time)).setText(com.baidu.tieba.c.af.a(a2.d()));
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            int d = this.g.a().d();
            if (d > 0) {
                textView3.setText(String.valueOf(d));
            } else {
                textView3.setVisibility(4);
            }
            textView2.setTextSize(com.baidu.tieba.a.i.l());
            textView2.setText(this.g.a().a().e().c());
            ArrayList f = a2.f();
            com.baidu.tieba.c.g gVar = new com.baidu.tieba.c.g(this);
            gVar.a(-11974584);
            gVar.a(true);
            gVar.a(textView, linearLayout, f, false);
            cu cuVar = new cu(this);
            imageView.setOnClickListener(cuVar);
            textView2.setOnClickListener(cuVar);
            String a3 = this.g.a().a().e().a();
            if (a3 == null || a3.length() <= 0 || a3.equals("0")) {
                textView2.setTextColor(-16777216);
                textView2.setTag(null);
            } else {
                textView2.setTextColor(-9989158);
                textView2.setTag(a3);
            }
            this.y = a2.a();
            this.o.setVisibility(8);
            this.s.setVisibility(0);
            textView5.setVisibility(4);
            textView4.setVisibility(4);
            if (this.I && this.J != 0) {
                textView5.setVisibility(0);
                textView4.setVisibility(0);
                String a4 = a2.e().a();
                if (a4 != null && a4.equals(TiebaApplication.y())) {
                    textView5.setVisibility(4);
                }
                if (a4 == null || a4.equals("0") || a4.length() == 0) {
                    textView5.setVisibility(4);
                }
            } else {
                com.baidu.tieba.a.ax h = this.g.a().h();
                if (h != null && (a = h.h().a()) != null && a.equals(TiebaApplication.y()) && a2.c() != 1) {
                    textView4.setVisibility(0);
                }
            }
            findViewById.setVisibility(4);
            if (textView5.getVisibility() == 0 && textView4.getVisibility() == 0) {
                findViewById.setVisibility(0);
            }
            textView4.setOnClickListener(new cv(this, a2));
            textView5.setOnClickListener(new cw(this, a2));
            if (TiebaApplication.b().t()) {
                imageView.setVisibility(0);
                a(imageView);
                return;
            }
            imageView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        b(TiebaApplication.b().getString(R.string.send_success));
        this.p.setText((CharSequence) null);
        if (this.Y.getVisibility() == 0) {
            this.Y.setVisibility(8);
        }
        com.baidu.tieba.c.ai.a(this, this.p);
        this.u.setBackgroundResource(R.drawable.sub_pb_face);
        this.h.c(2);
        this.h.notifyDataSetChanged();
        if (this.g != null && this.g.a() != null && this.g.a().e() == this.g.a().c()) {
            c(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        String y = TiebaApplication.y();
        if (y == null || y.length() <= 0) {
            if (this.A != null) {
                this.A.a(1);
            }
            LoginActivity.a((Activity) this, getString(R.string.login_to_post), true, 1100005);
        } else if (this.A != null && this.A.a() == 0) {
            com.baidu.tieba.c.ai.a((Context) this, this.A.e());
        } else {
            String editable = this.p.getText().toString();
            if (editable != null && editable.length() > 0 && this.g != null && this.g.a() != null) {
                if (l()) {
                    editable = editable.substring(0, 140);
                }
                a(getString(R.string.sending), this.B);
                com.baidu.tieba.b.z zVar = new com.baidu.tieba.b.z();
                zVar.e(this.j);
                zVar.f(this.k);
                zVar.b(editable);
                zVar.g(null);
                zVar.d(this.y);
                zVar.c(this.z);
                zVar.b(0);
                zVar.a(2);
                this.C = new dm(this, zVar);
                this.C.execute(new Integer[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e
    public void a() {
        p();
        super.a();
    }

    private void p() {
        if (this.K != null && this.K.isShowing()) {
            this.K.dismiss();
        }
        if (this.O != null && this.O.isShowing()) {
            this.O.dismiss();
        }
    }

    public void a(int i, String str) {
        if (this.K == null) {
            this.K = new Dialog(this, R.style.common_alert_dialog);
            this.K.setCanceledOnTouchOutside(true);
            this.K.setCancelable(true);
            this.L = getLayoutInflater().inflate(R.layout.del_post, (ViewGroup) null);
            this.K.setContentView(this.L);
            WindowManager.LayoutParams attributes = this.K.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.tieba.c.ai.a((Context) this) * 0.9d);
            this.K.getWindow().setAttributes(attributes);
            this.M = (Button) this.L.findViewById(R.id.dialog_button_ok);
            this.N = (Button) this.L.findViewById(R.id.dialog_button_cancel);
            this.N.setOnClickListener(new cy(this));
        }
        if (this.g != null) {
            this.M.setOnClickListener(new cz(this, i, str));
            this.K.show();
        }
    }

    public void c(String str) {
        if (this.O == null) {
            this.O = new Dialog(this, R.style.common_alert_dialog);
            this.O.setCanceledOnTouchOutside(true);
            this.O.setCancelable(true);
            this.P = getLayoutInflater().inflate(R.layout.forbid_user, (ViewGroup) null);
            this.O.setContentView(this.P);
            WindowManager.LayoutParams attributes = this.O.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.tieba.c.ai.a((Context) this) * 0.9d);
            this.O.getWindow().setAttributes(attributes);
            this.c = (RadioGroup) this.P.findViewById(R.id.radio_group);
            this.d = (RadioButton) this.P.findViewById(R.id.radio_button_1day);
            this.e = (RadioButton) this.P.findViewById(R.id.radio_button_3day);
            this.f = (RadioButton) this.P.findViewById(R.id.radio_button_10day);
            da daVar = new da(this);
            this.d.setOnCheckedChangeListener(daVar);
            this.e.setOnCheckedChangeListener(daVar);
            this.f.setOnCheckedChangeListener(daVar);
            this.R = (Button) this.P.findViewById(R.id.dialog_button_ok);
            this.S = (Button) this.P.findViewById(R.id.dialog_button_cancel);
            this.S.setOnClickListener(new db(this));
            this.T = (TextView) this.P.findViewById(R.id.user_name);
        }
        if (this.g != null) {
            this.T.setText(str);
            this.c.check(R.id.radio_button_1day);
            if (this.J == 2) {
                this.e.setVisibility(8);
                this.f.setVisibility(8);
            }
            this.R.setOnClickListener(new dc(this, str));
            this.O.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, String str) {
        String y = TiebaApplication.y();
        if (y == null || y.length() <= 0) {
            LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 1100019);
        } else if (!this.g.b()) {
            this.g.a(true);
            if (this.aa != null) {
                this.aa.a();
                this.aa = null;
            }
            com.baidu.tieba.a.q f = this.g.a().f();
            com.baidu.tieba.a.ax h = this.g.a().h();
            if (f != null) {
                this.aa = new dk(this, f.b(), f.c(), h.a(), str, i);
                this.aa.execute("http://c.tieba.baidu.com/c/c/bawu/delpost");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        String y = TiebaApplication.y();
        if (y == null || y.length() <= 0) {
            LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 1100020);
        } else if (!this.g.c()) {
            this.g.b(true);
            if (this.ab != null) {
                this.ab.a();
                this.ab = null;
            }
            com.baidu.tieba.a.q f = this.g.a().f();
            this.ab = new dl(this, f.b(), f.c(), this.g.a().h().a(), str, String.valueOf(this.Q));
            this.ab.execute("http://c.tieba.baidu.com/c/c/bawu/commitprison");
        }
    }
}
