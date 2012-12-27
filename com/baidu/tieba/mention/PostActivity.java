package com.baidu.tieba.mention;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.a.ak;
import com.baidu.tieba.a.am;
import com.baidu.tieba.c.ad;
import com.baidu.tieba.c.ae;
import com.baidu.tieba.c.ag;
import com.baidu.tieba.view.CustomTextView;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class PostActivity extends com.baidu.tieba.e {
    private LinearLayout b = null;
    private TextView c = null;
    private Button d = null;
    private Button e = null;
    private ProgressBar f = null;
    private String g = null;
    private String h = null;
    private String i = null;
    private x j = null;
    private com.baidu.tieba.b.n k = null;
    private com.baidu.tieba.c.a l;
    private ImageView m;
    private TextView n;
    private TextView o;
    private TextView p;
    private TextView q;
    private TextView r;
    private LinearLayout s;
    private int t;
    private boolean u;

    public static void a(Context context, String str, String str2, String str3) {
        Intent intent = new Intent(context, PostActivity.class);
        if (str == null || str.length() <= 0 || str2 == null || str2.length() <= 0) {
            return;
        }
        intent.putExtra("tid", str);
        intent.putExtra("pid", str2);
        intent.putExtra("st_type", str3);
        context.startActivity(intent);
    }

    private void g() {
        this.c = (TextView) findViewById(R.id.titel_text);
        this.b = (LinearLayout) findViewById(R.id.post);
        this.e = (Button) findViewById(R.id.back);
        this.e.setOnClickListener(new r(this));
        this.d = (Button) findViewById(R.id.reply);
        this.d.setOnClickListener(new s(this));
        this.f = (ProgressBar) findViewById(R.id.progress);
        this.f.setVisibility(8);
        this.m = (ImageView) findViewById(R.id.photo);
        this.m.setOnClickListener(new t(this));
        this.n = (TextView) findViewById(R.id.user_name);
        this.n.getPaint().setFakeBoldText(true);
        this.o = (TextView) findViewById(R.id.floor);
        this.o.setVisibility(8);
        this.p = (TextView) findViewById(R.id.rank);
        this.q = (TextView) findViewById(R.id.time);
        this.r = (TextView) findViewById(R.id.text);
        this.r.setMovementMethod(LinkMovementMethod.getInstance());
        this.r.setFocusable(false);
        this.r.setLineSpacing(0.0f, 1.2f);
        this.s = (LinearLayout) findViewById(R.id.seg);
        this.n.setTextSize(com.baidu.tieba.a.h.l());
        this.r.setTextSize(com.baidu.tieba.a.h.k());
        this.t = TiebaApplication.a().aa();
        this.u = TiebaApplication.a().Z();
    }

    private void h() {
        if (this.j != null) {
            this.j.a();
            this.j = null;
        }
        if (this.l != null) {
            this.l.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        try {
            StringBuffer stringBuffer = new StringBuffer(30);
            stringBuffer.append("http://c.tieba.baidu.com/");
            stringBuffer.append("c/f/pb/page");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new BasicNameValuePair("kz", this.g));
            arrayList.add(new BasicNameValuePair("pid", this.h));
            arrayList.add(new BasicNameValuePair("mark", String.valueOf(1)));
            arrayList.add(new BasicNameValuePair("rn", String.valueOf(1)));
            if (this.i != null) {
                arrayList.add(new BasicNameValuePair("st_type", this.i));
            }
            this.j = new x(this, stringBuffer.toString(), arrayList);
            this.j.execute(stringBuffer.toString(), arrayList);
        } catch (Exception e) {
            ae.b("PbActivity", "startPbAsyncTask", "error" + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        ArrayList c;
        int i;
        int i2;
        try {
            if (this.k == null || this.k.a() == null || (c = this.k.a().c()) == null || c.size() <= 0) {
                return;
            }
            am amVar = (am) c.get(0);
            this.c.setText(String.format(getString(R.string.post_x_floor), Integer.valueOf(amVar.b())));
            this.m.setVisibility(0);
            String d = amVar.d().d();
            if (d == null || d.length() <= 0) {
                this.m.setImageResource(R.drawable.photo);
            } else {
                Bitmap b = this.l.b(d);
                if (b != null) {
                    this.m.setImageBitmap(b);
                } else {
                    this.m.setTag(d);
                    this.m.setImageResource(R.drawable.photo);
                }
            }
            if (amVar.d() == null || amVar.d().c() == null) {
                this.n.setText((CharSequence) null);
            } else {
                this.n.setText(amVar.d().c());
            }
            if (amVar.d() == null || amVar.d().k() == 0) {
                this.p.setText((CharSequence) null);
            } else {
                this.p.setText(String.valueOf(String.valueOf(amVar.d().k())) + getString(R.string.grade));
            }
            this.q.setText(ad.a(amVar.c()));
            this.o.setVisibility(0);
            this.o.setText(String.valueOf(String.valueOf(amVar.b())) + getString(R.string.floor));
            ArrayList e = amVar.e();
            if (e == null || e.size() <= 0) {
                this.r.setVisibility(0);
                this.r.setText((CharSequence) null);
            } else {
                com.baidu.tieba.a.j jVar = (com.baidu.tieba.a.j) e.get(0);
                if (jVar == null || jVar.a() != 0) {
                    i = 0;
                } else {
                    this.r.setVisibility(0);
                    this.r.setText(jVar.e());
                    i = 1;
                }
                int i3 = -1;
                this.s.setVisibility(8);
                int i4 = i;
                while (i4 < e.size()) {
                    this.s.setVisibility(0);
                    com.baidu.tieba.a.j jVar2 = (com.baidu.tieba.a.j) e.get(i4);
                    if (jVar2.a() != 3) {
                        CustomTextView customTextView = new CustomTextView(this);
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                        int a = ag.a((Context) this, 15.0f);
                        layoutParams.rightMargin = 0;
                        layoutParams.leftMargin = 0;
                        layoutParams.topMargin = a;
                        customTextView.setTextSize(com.baidu.tieba.a.h.k());
                        customTextView.setTextColor(-11974584);
                        customTextView.setText(jVar2.e());
                        customTextView.setLineSpacing(0.0f, 1.2f);
                        customTextView.setMovementMethod(LinkMovementMethod.getInstance());
                        customTextView.setFocusable(false);
                        this.s.addView(customTextView, layoutParams);
                    } else if (this.u) {
                        int i5 = i3 + 1;
                        ImageView imageView = new ImageView(this);
                        int a2 = ag.a((Context) this, 105.0f);
                        int a3 = ag.a((Context) this, 105.0f);
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, a2);
                        layoutParams2.topMargin = ag.a((Context) this, 15.0f);
                        Bitmap c2 = this.l.c(jVar2.f());
                        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                        imageView.setMaxWidth(a3);
                        if (c2 != null) {
                            imageView.setTag(null);
                            imageView.setImageBitmap(c2);
                        } else {
                            imageView.setTag(jVar2.f());
                            imageView.setImageBitmap(com.baidu.tieba.c.e.a((int) R.drawable.image_default));
                        }
                        imageView.setClickable(true);
                        imageView.setFocusable(false);
                        imageView.setOnClickListener(new w(this, e, i5));
                        this.s.addView(imageView, layoutParams2);
                        i2 = i5;
                        i4++;
                        i3 = i2;
                    }
                    i2 = i3;
                    i4++;
                    i3 = i2;
                }
            }
            k();
        } catch (Exception e2) {
            ae.b("PbActivity", "refreshActivity", "error = " + e2.getMessage());
        }
    }

    private void k() {
        try {
            am amVar = (am) this.k.a().c().get(0);
            if (amVar != null) {
                ArrayList e = amVar.e();
                String d = amVar.d().d();
                if (this.k.b() && d != null && d.length() > 0) {
                    this.l.d(d, new u(this));
                }
                int size = e.size();
                if (this.u) {
                    for (int i = 0; i < size; i++) {
                        if (((com.baidu.tieba.a.j) e.get(i)).a() == 3) {
                            this.l.a(((com.baidu.tieba.a.j) e.get(i)).f(), new v(this));
                        }
                    }
                }
            }
        } catch (Exception e2) {
            ae.b("PbActivity", "mGetImageRunnble.run", "error = " + e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.post_activity);
        g();
        if (bundle != null) {
            this.g = bundle.getString("tid");
            this.h = bundle.getString("pid");
            this.i = bundle.getString("st_type");
        } else {
            Intent intent = getIntent();
            this.g = intent.getStringExtra("tid");
            this.h = intent.getStringExtra("pid");
            this.i = intent.getStringExtra("st_type");
        }
        this.l = new com.baidu.tieba.c.a(this);
        this.k = new com.baidu.tieba.b.n();
        i();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        try {
            h();
            if (this.k != null) {
                if (this.k.a() != null) {
                    this.k.a((ak) null);
                }
                this.k = null;
            }
            this.f.setVisibility(8);
            System.gc();
        } catch (Exception e) {
            ae.b(getClass().getName(), "onDestroy", e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onResume() {
        if (this.t != TiebaApplication.a().aa()) {
            this.t = TiebaApplication.a().aa();
            this.n.setTextSize(com.baidu.tieba.a.h.l());
            this.r.setTextSize(com.baidu.tieba.a.h.k());
            j();
        }
        if (this.u != TiebaApplication.a().Z()) {
            this.u = TiebaApplication.a().Z();
            j();
        }
        super.onResume();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("tid", this.g);
        bundle.putString("pid", this.h);
    }
}
