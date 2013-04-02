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
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.a.ak;
import com.baidu.tieba.a.an;
import com.baidu.tieba.c.ae;
import com.baidu.tieba.c.af;
import com.baidu.tieba.c.ag;
import com.baidu.tieba.c.ai;
import com.baidu.tieba.view.CustomTextView;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class PostActivity extends com.baidu.tieba.e {
    private LinearLayout c = null;
    private LinearLayout d = null;
    private TextView e = null;
    private Button f = null;
    private Button g = null;
    private ProgressBar h = null;
    private RelativeLayout i = null;
    private String j = null;
    private String k = null;
    private String l = null;
    private x m = null;
    private com.baidu.tieba.b.r n = null;
    private com.baidu.tieba.c.a o;
    private ImageView p;
    private TextView q;
    private TextView r;
    private TextView s;
    private TextView t;
    private TextView u;
    private LinearLayout v;
    private int w;
    private boolean x;

    public static void a(Context context, String str, String str2, String str3) {
        Intent intent = new Intent(context, PostActivity.class);
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0) {
            intent.putExtra("tid", str);
            intent.putExtra("pid", str2);
            intent.putExtra("st_type", str3);
            context.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.post_activity);
        i();
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
        this.o = new com.baidu.tieba.c.a(this);
        this.n = new com.baidu.tieba.b.r();
        k();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onResume() {
        if (this.w != TiebaApplication.b().af()) {
            this.w = TiebaApplication.b().af();
            this.q.setTextSize(com.baidu.tieba.a.i.l());
            this.u.setTextSize(com.baidu.tieba.a.i.k());
            l();
        }
        if (this.x != TiebaApplication.b().ae()) {
            this.x = TiebaApplication.b().ae();
            l();
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        try {
            j();
            if (this.n != null) {
                if (this.n.a() != null) {
                    this.n.a((ak) null);
                }
                this.n = null;
            }
            this.h.setVisibility(8);
            System.gc();
        } catch (Exception e) {
            ag.b(getClass().getName(), "onDestroy", e.getMessage());
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("tid", this.j);
        bundle.putString("pid", this.k);
    }

    private void i() {
        this.i = (RelativeLayout) findViewById(R.id.container);
        this.d = (LinearLayout) findViewById(R.id.title);
        this.e = (TextView) findViewById(R.id.title_text);
        this.c = (LinearLayout) findViewById(R.id.post);
        this.g = (Button) findViewById(R.id.back);
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
        this.q.setTextSize(com.baidu.tieba.a.i.l());
        this.u.setTextSize(com.baidu.tieba.a.i.k());
        this.w = TiebaApplication.b().af();
        this.x = TiebaApplication.b().ae();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e
    public void b(int i) {
        super.b(i);
        ae.c((TextView) this.g, i);
        ae.a(this.e, i);
        ae.e((TextView) this.g, i);
        ae.a(this.i, i);
        ae.c(this.d, i);
        ae.b(this.q, i);
        if (i == 1) {
            this.u.setTextColor(getResources().getColor(R.color.skin_1_second_common_color));
            ae.h(this.r, R.drawable.floor_bg_1);
            this.f.setBackgroundResource(R.drawable.title_reply_1);
            return;
        }
        this.u.setTextColor(-12040120);
        ae.h(this.r, R.drawable.floor_bg);
        this.f.setBackgroundResource(R.drawable.title_reply);
    }

    private void j() {
        if (this.m != null) {
            this.m.a();
            this.m = null;
        }
        if (this.o != null) {
            this.o.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        try {
            StringBuffer stringBuffer = new StringBuffer(30);
            stringBuffer.append("http://c.tieba.baidu.com/");
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
            this.m.execute(stringBuffer.toString(), arrayList);
        } catch (Exception e) {
            ag.b("PbActivity", "startPbAsyncTask", "error" + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        ArrayList d;
        int i;
        int i2;
        try {
            if (this.n != null && this.n.a() != null && (d = this.n.a().d()) != null && d.size() > 0) {
                an anVar = (an) d.get(0);
                this.e.setText(String.format(getString(R.string.post_x_floor), Integer.valueOf(anVar.c())));
                this.p.setVisibility(0);
                String d2 = anVar.e().d();
                if (d2 != null && d2.length() > 0) {
                    Bitmap b = this.o.b(d2);
                    if (b != null) {
                        this.p.setImageBitmap(b);
                    } else {
                        this.p.setTag(d2);
                        this.p.setImageResource(R.drawable.photo);
                    }
                } else {
                    this.p.setImageResource(R.drawable.photo);
                }
                if (anVar.e() != null && anVar.e().c() != null) {
                    this.q.setText(anVar.e().c());
                } else {
                    this.q.setText((CharSequence) null);
                }
                if (anVar.e() != null && anVar.e().k() != 0) {
                    this.s.setText(String.valueOf(String.valueOf(anVar.e().k())) + getString(R.string.grade));
                } else {
                    this.s.setText((CharSequence) null);
                }
                this.t.setText(af.a(anVar.d()));
                this.r.setVisibility(0);
                this.r.setText(String.valueOf(String.valueOf(anVar.c())) + getString(R.string.floor));
                ArrayList f = anVar.f();
                if (f != null && f.size() > 0) {
                    com.baidu.tieba.a.k kVar = (com.baidu.tieba.a.k) f.get(0);
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
                    while (i4 < f.size()) {
                        this.v.setVisibility(0);
                        com.baidu.tieba.a.k kVar2 = (com.baidu.tieba.a.k) f.get(i4);
                        if (kVar2.a() == 3) {
                            if (this.x) {
                                int i5 = i3 + 1;
                                ImageView imageView = new ImageView(this);
                                int a = ai.a(this, 105.0f);
                                int a2 = ai.a(this, 105.0f);
                                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, a);
                                layoutParams.topMargin = ai.a(this, 15.0f);
                                Bitmap c = this.o.c(kVar2.f());
                                imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                                imageView.setMaxWidth(a2);
                                if (c != null) {
                                    imageView.setTag(null);
                                    imageView.setImageBitmap(c);
                                } else {
                                    imageView.setTag(kVar2.f());
                                    imageView.setImageBitmap(com.baidu.tieba.c.e.a((int) R.drawable.image_default));
                                }
                                imageView.setClickable(true);
                                imageView.setFocusable(false);
                                imageView.setOnClickListener(new w(this, f, i5));
                                this.v.addView(imageView, layoutParams);
                                i2 = i5;
                                i4++;
                                i3 = i2;
                            }
                        } else {
                            CustomTextView customTextView = new CustomTextView(this);
                            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                            int a3 = ai.a(this, 15.0f);
                            layoutParams2.rightMargin = 0;
                            layoutParams2.leftMargin = 0;
                            layoutParams2.topMargin = a3;
                            customTextView.setTextSize(com.baidu.tieba.a.i.k());
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
                m();
            }
        } catch (Exception e) {
            ag.b("PbActivity", "refreshActivity", "error = " + e.getMessage());
        }
    }

    private void m() {
        try {
            an anVar = (an) this.n.a().d().get(0);
            if (anVar != null) {
                ArrayList f = anVar.f();
                String d = anVar.e().d();
                if (this.n.b() && d != null && d.length() > 0) {
                    this.o.d(d, new u(this));
                }
                int size = f.size();
                if (this.x) {
                    for (int i = 0; i < size; i++) {
                        if (((com.baidu.tieba.a.k) f.get(i)).a() == 3) {
                            this.o.a(((com.baidu.tieba.a.k) f.get(i)).f(), new v(this));
                        }
                    }
                }
            }
        } catch (Exception e) {
            ag.b("PbActivity", "mGetImageRunnble.run", "error = " + e.getMessage());
        }
    }
}
