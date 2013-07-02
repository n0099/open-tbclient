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
import com.baidu.tieba.data.aj;
import com.baidu.tieba.data.an;
import com.baidu.tieba.model.bg;
import com.baidu.tieba.util.ab;
import com.baidu.tieba.view.CustomTextView;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class PostActivity extends com.baidu.tieba.g {
    private LinearLayout a = null;
    private LinearLayout b = null;
    private TextView c = null;
    private Button d = null;
    private ImageView e = null;
    private ProgressBar f = null;
    private RelativeLayout g = null;
    private String j = null;
    private String k = null;
    private String l = null;
    private x m = null;
    private bg n = null;
    private com.baidu.tieba.util.a o;
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
    @Override // com.baidu.tieba.g, com.baidu.adp.a.a, android.app.Activity
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
        this.o = new com.baidu.tieba.util.a(this);
        this.n = new bg();
        d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onResume() {
        if (this.w != TiebaApplication.f().aq()) {
            this.w = TiebaApplication.f().aq();
            this.q.setTextSize(com.baidu.tieba.data.g.q());
            this.u.setTextSize(com.baidu.tieba.data.g.n());
            m();
        }
        if (this.x != TiebaApplication.f().ap()) {
            this.x = TiebaApplication.f().ap();
            m();
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        try {
            c();
            if (this.n != null) {
                if (this.n.a() != null) {
                    this.n.a((aj) null);
                }
                this.n = null;
            }
            this.f.setVisibility(8);
            System.gc();
        } catch (Exception e) {
            com.baidu.tieba.util.z.b(getClass().getName(), "onDestroy", e.getMessage());
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("tid", this.j);
        bundle.putString("pid", this.k);
    }

    private void b() {
        this.g = (RelativeLayout) findViewById(R.id.container);
        this.b = (LinearLayout) findViewById(R.id.title);
        this.c = (TextView) findViewById(R.id.title_text);
        this.a = (LinearLayout) findViewById(R.id.post);
        this.e = (ImageView) findViewById(R.id.back);
        this.e.setOnClickListener(new r(this));
        this.d = (Button) findViewById(R.id.reply);
        this.d.setOnClickListener(new s(this));
        this.f = (ProgressBar) findViewById(R.id.progress);
        this.f.setVisibility(8);
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
        this.q.setTextSize(com.baidu.tieba.data.g.q());
        this.u.setTextSize(com.baidu.tieba.data.g.n());
        this.w = TiebaApplication.f().aq();
        this.x = TiebaApplication.f().ap();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g
    public void a(int i) {
        super.a(i);
        com.baidu.tieba.util.x.a(this.c, i);
        com.baidu.tieba.util.x.a(this.e, i);
        com.baidu.tieba.util.x.g((TextView) this.d, i);
        com.baidu.tieba.util.x.a(this.g, i);
        com.baidu.tieba.util.x.d(this.b, i);
        com.baidu.tieba.util.x.b(this.q, i);
        if (i == 1) {
            this.u.setTextColor(getResources().getColor(R.color.skin_1_second_common_color));
            com.baidu.tieba.util.x.h((View) this.r, (int) R.drawable.floor_bg_1);
            return;
        }
        this.u.setTextColor(-12040120);
        com.baidu.tieba.util.x.h((View) this.r, (int) R.drawable.floor_bg);
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
            stringBuffer.append(com.baidu.tieba.data.g.a);
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
            com.baidu.tieba.util.z.b("PbActivity", "startPbAsyncTask", "error" + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        ArrayList d;
        int i;
        int i2;
        try {
            if (this.n != null && this.n.a() != null && (d = this.n.a().d()) != null && d.size() > 0) {
                an anVar = (an) d.get(0);
                this.c.setText(String.format(getString(R.string.post_x_floor), Integer.valueOf(anVar.f())));
                this.p.setVisibility(0);
                String portrait = anVar.h().getPortrait();
                if (portrait != null && portrait.length() > 0) {
                    com.baidu.adp.widget.a.b b = this.o.b(portrait);
                    if (b != null) {
                        b.b(this.p);
                    } else {
                        this.p.setTag(portrait);
                        this.p.setImageResource(R.drawable.photo);
                    }
                } else {
                    this.p.setImageResource(R.drawable.photo);
                }
                if (anVar.h() != null && anVar.h().getName_show() != null) {
                    this.q.setText(anVar.h().getName_show());
                } else {
                    this.q.setText((CharSequence) null);
                }
                if (anVar.h() != null && anVar.h().getLevel_id() != 0) {
                    this.s.setText(String.valueOf(String.valueOf(anVar.h().getLevel_id())) + getString(R.string.grade));
                } else {
                    this.s.setText((CharSequence) null);
                }
                this.t.setText(com.baidu.tieba.util.y.a(anVar.g()));
                this.r.setVisibility(0);
                this.r.setText(String.valueOf(String.valueOf(anVar.f())) + getString(R.string.floor));
                ArrayList j = anVar.j();
                if (j != null && j.size() > 0) {
                    com.baidu.tieba.data.i iVar = (com.baidu.tieba.data.i) j.get(0);
                    if (iVar == null || iVar.a() != 0) {
                        i = 0;
                    } else {
                        this.u.setVisibility(0);
                        this.u.setText(iVar.e());
                        i = 1;
                    }
                    int i3 = -1;
                    this.v.setVisibility(8);
                    int i4 = i;
                    while (i4 < j.size()) {
                        this.v.setVisibility(0);
                        com.baidu.tieba.data.i iVar2 = (com.baidu.tieba.data.i) j.get(i4);
                        if (iVar2.a() == 3) {
                            if (this.x) {
                                int i5 = i3 + 1;
                                ImageView imageView = new ImageView(this);
                                int a = ab.a(this, 105.0f);
                                int a2 = ab.a(this, 105.0f);
                                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, a);
                                layoutParams.topMargin = ab.a(this, 15.0f);
                                com.baidu.adp.widget.a.b c = this.o.c(iVar2.f());
                                imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                                imageView.setMaxWidth(a2);
                                if (c != null) {
                                    imageView.setTag(null);
                                    c.b(imageView);
                                } else {
                                    imageView.setTag(iVar2.f());
                                    imageView.setImageBitmap(com.baidu.tieba.util.d.a((int) R.drawable.image_default));
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
                            int a3 = ab.a(this, 15.0f);
                            layoutParams2.rightMargin = 0;
                            layoutParams2.leftMargin = 0;
                            layoutParams2.topMargin = a3;
                            customTextView.setTextSize(com.baidu.tieba.data.g.n());
                            customTextView.setTextColor(-11974584);
                            customTextView.setText(iVar2.e());
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
        } catch (Exception e) {
            com.baidu.tieba.util.z.b("PbActivity", "refreshActivity", "error = " + e.getMessage());
        }
    }

    private void n() {
        try {
            an anVar = (an) this.n.a().d().get(0);
            if (anVar != null) {
                ArrayList j = anVar.j();
                String portrait = anVar.h().getPortrait();
                if (this.n.b() && portrait != null && portrait.length() > 0) {
                    this.o.d(portrait, new u(this));
                }
                int size = j.size();
                if (this.x) {
                    for (int i = 0; i < size; i++) {
                        if (((com.baidu.tieba.data.i) j.get(i)).a() == 3) {
                            this.o.a(((com.baidu.tieba.data.i) j.get(i)).f(), new v(this));
                        }
                    }
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.util.z.b("PbActivity", "mGetImageRunnble.run", "error = " + e.getMessage());
        }
    }
}
