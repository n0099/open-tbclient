package com.baidu.tieba.mention;

import android.content.Context;
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
import com.baidu.tieba.data.as;
import com.baidu.tieba.model.bv;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.bd;
import com.baidu.tieba.util.be;
import com.baidu.tieba.util.bg;
import com.baidu.tieba.view.CustomTextView;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class PostActivity extends com.baidu.tieba.j {

    /* renamed from: a  reason: collision with root package name */
    private LinearLayout f1847a = null;
    private LinearLayout b = null;
    private TextView c = null;
    private Button d = null;
    private ImageView e = null;
    private ProgressBar f = null;
    private RelativeLayout g = null;
    private String h = null;
    private String i = null;
    private String j = null;
    private aa k = null;
    private bv l = null;
    private com.baidu.tieba.util.i m;
    private ImageView n;
    private TextView o;
    private TextView p;
    private TextView q;
    private TextView r;
    private TextView s;
    private LinearLayout t;
    private int u;
    private boolean v;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.post_activity);
        a();
        if (bundle != null) {
            this.h = bundle.getString("tid");
            this.i = bundle.getString("pid");
            this.j = bundle.getString("st_type");
        } else {
            Intent intent = getIntent();
            this.h = intent.getStringExtra("tid");
            this.i = intent.getStringExtra("pid");
            this.j = intent.getStringExtra("st_type");
        }
        this.m = new com.baidu.tieba.util.i(this);
        this.l = new bv();
        c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onResume() {
        if (this.u != TiebaApplication.g().al()) {
            this.u = TiebaApplication.g().al();
            this.o.setTextSize(com.baidu.tieba.data.h.r());
            this.s.setTextSize(com.baidu.tieba.data.h.o());
            d();
        }
        if (this.v != TiebaApplication.g().ak()) {
            this.v = TiebaApplication.g().ak();
            d();
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        try {
            b();
            if (this.l != null) {
                if (this.l.a() != null) {
                    this.l.a(null);
                }
                this.l = null;
            }
            this.f.setVisibility(8);
            System.gc();
        } catch (Exception e) {
            bg.b(getClass().getName(), "onDestroy", e.getMessage());
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("tid", this.h);
        bundle.putString("pid", this.i);
    }

    private void a() {
        this.g = (RelativeLayout) findViewById(R.id.container);
        this.b = (LinearLayout) findViewById(R.id.title);
        this.c = (TextView) findViewById(R.id.title_text);
        this.f1847a = (LinearLayout) findViewById(R.id.post);
        this.e = (ImageView) findViewById(R.id.back);
        this.e.setOnClickListener(new u(this));
        this.d = (Button) findViewById(R.id.reply);
        this.d.setOnClickListener(new v(this));
        this.f = (ProgressBar) findViewById(R.id.progress);
        this.f.setVisibility(8);
        this.n = (ImageView) findViewById(R.id.photo);
        this.n.setOnClickListener(new w(this));
        this.o = (TextView) findViewById(R.id.user_name);
        this.o.getPaint().setFakeBoldText(true);
        this.p = (TextView) findViewById(R.id.floor);
        this.p.setVisibility(8);
        this.q = (TextView) findViewById(R.id.rank);
        this.r = (TextView) findViewById(R.id.time);
        this.s = (TextView) findViewById(R.id.text);
        this.s.setMovementMethod(LinkMovementMethod.getInstance());
        this.s.setFocusable(false);
        this.s.setLineSpacing(0.0f, 1.2f);
        this.t = (LinearLayout) findViewById(R.id.seg);
        this.o.setTextSize(com.baidu.tieba.data.h.r());
        this.s.setTextSize(com.baidu.tieba.data.h.o());
        this.u = TiebaApplication.g().al();
        this.v = TiebaApplication.g().ak();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        bd.a(this.c, i);
        bd.a(this.e, i);
        bd.f((TextView) this.d, i);
        bd.a(this.g, i);
        bd.d(this.b, i);
        bd.b(this.o, i);
        if (i == 1) {
            this.s.setTextColor(getResources().getColor(R.color.skin_1_second_common_color));
            bd.e((View) this.p, (int) R.drawable.floor_bg_1);
            return;
        }
        this.s.setTextColor(-12040120);
        bd.e((View) this.p, (int) R.drawable.floor_bg);
    }

    private void b() {
        if (this.k != null) {
            this.k.cancel();
            this.k = null;
        }
        if (this.m != null) {
            this.m.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        try {
            StringBuffer stringBuffer = new StringBuffer(30);
            stringBuffer.append(com.baidu.tieba.data.h.f1196a);
            stringBuffer.append("c/f/pb/page");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new BasicNameValuePair("kz", this.h));
            arrayList.add(new BasicNameValuePair("pid", this.i));
            arrayList.add(new BasicNameValuePair("mark", String.valueOf(1)));
            arrayList.add(new BasicNameValuePair("rn", String.valueOf(1)));
            if (this.j != null) {
                arrayList.add(new BasicNameValuePair("st_type", this.j));
            }
            this.k = new aa(this, stringBuffer.toString(), arrayList);
            this.k.setPriority(3);
            this.k.execute(stringBuffer.toString(), arrayList);
        } catch (Exception e) {
            bg.b("PbActivity", "startPbAsyncTask", "error" + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        ArrayList<as> e;
        int i;
        int i2;
        try {
            if (this.l != null && this.l.a() != null && (e = this.l.a().e()) != null && e.size() > 0) {
                as asVar = e.get(0);
                this.c.setText(String.format(getString(R.string.post_x_floor), Integer.valueOf(asVar.e())));
                this.n.setVisibility(0);
                String portrait = asVar.g().getPortrait();
                if (portrait != null && portrait.length() > 0) {
                    com.baidu.adp.widget.ImageView.e c = this.m.c(portrait);
                    if (c != null) {
                        c.a(this.n);
                    } else {
                        this.n.setTag(portrait);
                        this.n.setImageResource(R.drawable.photo);
                    }
                } else {
                    this.n.setImageResource(R.drawable.photo);
                }
                if (asVar.g() != null && asVar.g().getName_show() != null) {
                    this.o.setText(asVar.g().getName_show());
                } else {
                    this.o.setText((CharSequence) null);
                }
                if (asVar.g() != null && asVar.g().getLevel_id() != 0) {
                    this.q.setText(String.valueOf(asVar.g().getLevel_id()) + getString(R.string.grade));
                } else {
                    this.q.setText((CharSequence) null);
                }
                this.r.setText(be.b(asVar.f()));
                this.p.setVisibility(0);
                this.p.setText(String.valueOf(asVar.e()) + getString(R.string.floor));
                ArrayList<com.baidu.tieba.data.j> i3 = asVar.i();
                if (i3 != null && i3.size() > 0) {
                    com.baidu.tieba.data.j jVar = i3.get(0);
                    if (jVar == null || jVar.a() != 0) {
                        i = 0;
                    } else {
                        this.s.setVisibility(0);
                        this.s.setText(jVar.c());
                        i = 1;
                    }
                    int i4 = -1;
                    this.t.setVisibility(8);
                    int i5 = i;
                    while (i5 < i3.size()) {
                        this.t.setVisibility(0);
                        com.baidu.tieba.data.j jVar2 = i3.get(i5);
                        if (jVar2.a() == 3) {
                            if (this.v) {
                                int i6 = i4 + 1;
                                ImageView imageView = new ImageView(this);
                                int a2 = UtilHelper.a((Context) this, 105.0f);
                                int a3 = UtilHelper.a((Context) this, 105.0f);
                                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, a2);
                                layoutParams.topMargin = UtilHelper.a((Context) this, 15.0f);
                                com.baidu.adp.widget.ImageView.e d = this.m.d(jVar2.d());
                                imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                                imageView.setMaxWidth(a3);
                                if (d != null) {
                                    imageView.setTag(null);
                                    d.a(imageView);
                                } else {
                                    imageView.setTag(jVar2.d());
                                    imageView.setImageBitmap(com.baidu.tieba.util.m.a((int) R.drawable.image_default));
                                }
                                imageView.setClickable(true);
                                imageView.setFocusable(false);
                                imageView.setOnClickListener(new z(this, i3, i6));
                                this.t.addView(imageView, layoutParams);
                                i2 = i6;
                                i5++;
                                i4 = i2;
                            }
                        } else {
                            CustomTextView customTextView = new CustomTextView(this);
                            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                            int a4 = UtilHelper.a((Context) this, 15.0f);
                            layoutParams2.rightMargin = 0;
                            layoutParams2.leftMargin = 0;
                            layoutParams2.topMargin = a4;
                            customTextView.setTextSize(com.baidu.tieba.data.h.o());
                            customTextView.setTextColor(-11974584);
                            customTextView.setText(jVar2.c());
                            customTextView.setLineSpacing(0.0f, 1.2f);
                            customTextView.setMovementMethod(LinkMovementMethod.getInstance());
                            customTextView.setFocusable(false);
                            this.t.addView(customTextView, layoutParams2);
                        }
                        i2 = i4;
                        i5++;
                        i4 = i2;
                    }
                } else {
                    this.s.setVisibility(0);
                    this.s.setText((CharSequence) null);
                }
                e();
            }
        } catch (Exception e2) {
            bg.b("PbActivity", "refreshActivity", "error = " + e2.getMessage());
        }
    }

    private void e() {
        try {
            as asVar = this.l.a().e().get(0);
            if (asVar != null) {
                ArrayList<com.baidu.tieba.data.j> i = asVar.i();
                String portrait = asVar.g().getPortrait();
                if (this.l.b() && portrait != null && portrait.length() > 0) {
                    this.m.d(portrait, new x(this));
                }
                int size = i.size();
                if (this.v) {
                    for (int i2 = 0; i2 < size; i2++) {
                        if (i.get(i2).a() == 3) {
                            this.m.a(i.get(i2).d(), new y(this));
                        }
                    }
                }
            }
        } catch (Exception e) {
            bg.b("PbActivity", "mGetImageRunnble.run", "error = " + e.getMessage());
        }
    }
}
