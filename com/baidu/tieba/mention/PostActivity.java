package com.baidu.tieba.mention;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.a.am;
import com.baidu.tieba.a.ar;
import com.baidu.tieba.c.bg;
import com.baidu.tieba.d.ac;
import com.baidu.tieba.d.ad;
import com.baidu.tieba.d.ae;
import com.baidu.tieba.d.ag;
import com.baidu.tieba.view.CustomTextView;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class PostActivity extends com.baidu.tieba.e {
    private LinearLayout c = null;
    private LinearLayout d = null;
    private TextView e = null;
    private Button f = null;
    private ImageView g = null;
    private ProgressBar h = null;
    private RelativeLayout i = null;
    private String j = null;
    private String k = null;
    private String l = null;
    private x m = null;
    private bg n = null;
    private com.baidu.tieba.d.a o;
    private ImageView p;
    private TextView q;
    private TextView r;
    private TextView s;
    private TextView t;
    private TextView u;
    private LinearLayout v;
    private int w;
    private boolean x;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.post_activity);
        b();
        if (bundle != null) {
            this.j = bundle.getString("tid");
            this.k = bundle.getString("pid");
            this.l = bundle.getString("st_type");
        } else {
            Intent intent = getIntent();
            this.j = intent.getStringExtra("tid");
            this.k = intent.getStringExtra("pid");
            this.l = intent.getStringExtra("st_type");
        }
        this.o = new com.baidu.tieba.d.a(this);
        this.n = new bg();
        d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onResume() {
        if (this.w != TiebaApplication.d().ao()) {
            this.w = TiebaApplication.d().ao();
            this.q.setTextSize(com.baidu.tieba.a.i.q());
            this.u.setTextSize(com.baidu.tieba.a.i.n());
            m();
        }
        if (this.x != TiebaApplication.d().an()) {
            this.x = TiebaApplication.d().an();
            m();
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        try {
            c();
            if (this.n != null) {
                if (this.n.a() != null) {
                    this.n.a((am) null);
                }
                this.n = null;
            }
            this.h.setVisibility(8);
            System.gc();
        } catch (Exception e) {
            ae.b(getClass().getName(), "onDestroy", e.getMessage());
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("tid", this.j);
        bundle.putString("pid", this.k);
    }

    private void b() {
        this.i = (RelativeLayout) findViewById(R.id.container);
        this.d = (LinearLayout) findViewById(R.id.title);
        this.e = (TextView) findViewById(R.id.title_text);
        this.c = (LinearLayout) findViewById(R.id.post);
        this.g = (ImageView) findViewById(R.id.back);
        this.g.setOnClickListener(new r(this));
        this.f = (Button) findViewById(R.id.reply);
        this.f.setOnClickListener(new s(this));
        this.h = (ProgressBar) findViewById(R.id.progress);
        this.h.setVisibility(8);
        this.p = (ImageView) findViewById(R.id.photo);
        this.p.setOnClickListener(new t(this));
        this.q = (TextView) findViewById(R.id.user_name);
        this.q.getPaint().setFakeBoldText(true);
        this.r = (TextView) findViewById(R.id.floor);
        this.r.setVisibility(8);
        this.s = (TextView) findViewById(R.id.rank);
        this.t = (TextView) findViewById(R.id.time);
        this.u = (TextView) findViewById(R.id.text);
        this.u.setMovementMethod(LinkMovementMethod.getInstance());
        this.u.setFocusable(false);
        this.u.setLineSpacing(0.0f, 1.2f);
        this.v = (LinearLayout) findViewById(R.id.seg);
        this.q.setTextSize(com.baidu.tieba.a.i.q());
        this.u.setTextSize(com.baidu.tieba.a.i.n());
        this.w = TiebaApplication.d().ao();
        this.x = TiebaApplication.d().an();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e
    public void b(int i) {
        super.b(i);
        ac.a(this.e, i);
        ac.a(this.g, i);
        ac.g((TextView) this.f, i);
        ac.a(this.i, i);
        ac.d(this.d, i);
        ac.b(this.q, i);
        if (i == 1) {
            this.u.setTextColor(getResources().getColor(R.color.skin_1_second_common_color));
            ac.h((View) this.r, (int) R.drawable.floor_bg_1);
            return;
        }
        this.u.setTextColor(-12040120);
        ac.h((View) this.r, (int) R.drawable.floor_bg);
    }

    private void c() {
        if (this.m != null) {
            this.m.cancel();
            this.m = null;
        }
        if (this.o != null) {
            this.o.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        try {
            StringBuffer stringBuffer = new StringBuffer(30);
            stringBuffer.append(com.baidu.tieba.a.i.e);
            stringBuffer.append("c/f/pb/page");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new BasicNameValuePair("kz", this.j));
            arrayList.add(new BasicNameValuePair("pid", this.k));
            arrayList.add(new BasicNameValuePair("mark", String.valueOf(1)));
            arrayList.add(new BasicNameValuePair("rn", String.valueOf(1)));
            if (this.l != null) {
                arrayList.add(new BasicNameValuePair("st_type", this.l));
            }
            this.m = new x(this, stringBuffer.toString(), arrayList);
            this.m.setPriority(3);
            this.m.execute(stringBuffer.toString(), arrayList);
        } catch (Exception e) {
            ae.b("PbActivity", "startPbAsyncTask", "error" + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        ArrayList d;
        int i;
        int i2;
        try {
            if (this.n != null && this.n.a() != null && (d = this.n.a().d()) != null && d.size() > 0) {
                ar arVar = (ar) d.get(0);
                this.e.setText(String.format(getString(R.string.post_x_floor), Integer.valueOf(arVar.f())));
                this.p.setVisibility(0);
                String e = arVar.h().e();
                if (e != null && e.length() > 0) {
                    com.baidu.adp.widget.a.b b = this.o.b(e);
                    if (b != null) {
                        b.b(this.p);
                    } else {
                        this.p.setTag(e);
                        this.p.setImageResource(R.drawable.photo);
                    }
                } else {
                    this.p.setImageResource(R.drawable.photo);
                }
                if (arVar.h() != null && arVar.h().d() != null) {
                    this.q.setText(arVar.h().d());
                } else {
                    this.q.setText((CharSequence) null);
                }
                if (arVar.h() != null && arVar.h().m() != 0) {
                    this.s.setText(String.valueOf(String.valueOf(arVar.h().m())) + getString(R.string.grade));
                } else {
                    this.s.setText((CharSequence) null);
                }
                this.t.setText(ad.a(arVar.g()));
                this.r.setVisibility(0);
                this.r.setText(String.valueOf(String.valueOf(arVar.f())) + getString(R.string.floor));
                ArrayList j = arVar.j();
                if (j != null && j.size() > 0) {
                    com.baidu.tieba.a.k kVar = (com.baidu.tieba.a.k) j.get(0);
                    if (kVar == null || kVar.a() != 0) {
                        i = 0;
                    } else {
                        this.u.setVisibility(0);
                        this.u.setText(kVar.e());
                        i = 1;
                    }
                    int i3 = -1;
                    this.v.setVisibility(8);
                    int i4 = i;
                    while (i4 < j.size()) {
                        this.v.setVisibility(0);
                        com.baidu.tieba.a.k kVar2 = (com.baidu.tieba.a.k) j.get(i4);
                        if (kVar2.a() == 3) {
                            if (this.x) {
                                int i5 = i3 + 1;
                                ImageView imageView = new ImageView(this);
                                int a = ag.a(this, 105.0f);
                                int a2 = ag.a(this, 105.0f);
                                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, a);
                                layoutParams.topMargin = ag.a(this, 15.0f);
                                com.baidu.adp.widget.a.b c = this.o.c(kVar2.f());
                                imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                                imageView.setMaxWidth(a2);
                                if (c != null) {
                                    imageView.setTag(null);
                                    c.b(imageView);
                                } else {
                                    imageView.setTag(kVar2.f());
                                    imageView.setImageBitmap(com.baidu.tieba.d.d.a((int) R.drawable.image_default));
                                }
                                imageView.setClickable(true);
                                imageView.setFocusable(false);
                                imageView.setOnClickListener(new w(this, j, i5));
                                this.v.addView(imageView, layoutParams);
                                i2 = i5;
                                i4++;
                                i3 = i2;
                            }
                        } else {
                            CustomTextView customTextView = new CustomTextView(this);
                            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                            int a3 = ag.a(this, 15.0f);
                            layoutParams2.rightMargin = 0;
                            layoutParams2.leftMargin = 0;
                            layoutParams2.topMargin = a3;
                            customTextView.setTextSize(com.baidu.tieba.a.i.n());
                            customTextView.setTextColor(-11974584);
                            customTextView.setText(kVar2.e());
                            customTextView.setLineSpacing(0.0f, 1.2f);
                            customTextView.setMovementMethod(LinkMovementMethod.getInstance());
                            customTextView.setFocusable(false);
                            this.v.addView(customTextView, layoutParams2);
                        }
                        i2 = i3;
                        i4++;
                        i3 = i2;
                    }
                } else {
                    this.u.setVisibility(0);
                    this.u.setText((CharSequence) null);
                }
                n();
            }
        } catch (Exception e2) {
            ae.b("PbActivity", "refreshActivity", "error = " + e2.getMessage());
        }
    }

    private void n() {
        try {
            ar arVar = (ar) this.n.a().d().get(0);
            if (arVar != null) {
                ArrayList j = arVar.j();
                String e = arVar.h().e();
                if (this.n.b() && e != null && e.length() > 0) {
                    this.o.d(e, new u(this));
                }
                int size = j.size();
                if (this.x) {
                    for (int i = 0; i < size; i++) {
                        if (((com.baidu.tieba.a.k) j.get(i)).a() == 3) {
                            this.o.a(((com.baidu.tieba.a.k) j.get(i)).f(), new v(this));
                        }
                    }
                }
            }
        } catch (Exception e2) {
            ae.b("PbActivity", "mGetImageRunnble.run", "error = " + e2.getMessage());
        }
    }
}
