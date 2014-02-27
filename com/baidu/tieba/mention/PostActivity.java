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
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.aq;
import com.baidu.tieba.model.bn;
import com.baidu.tieba.util.bq;
import com.baidu.tieba.util.bs;
import com.baidu.tieba.view.CustomTextView;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class PostActivity extends com.baidu.tieba.f {
    private LinearLayout a = null;
    private LinearLayout b = null;
    private TextView c = null;
    private Button d = null;
    private ImageView e = null;
    private ProgressBar f = null;
    private RelativeLayout g = null;
    private String h = null;
    private String i = null;
    private String j = null;
    private ac k = null;
    private bn l = null;
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
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.post_activity);
        this.g = (RelativeLayout) findViewById(R.id.container);
        this.b = (LinearLayout) findViewById(R.id.title);
        this.c = (TextView) findViewById(R.id.title_text);
        this.a = (LinearLayout) findViewById(R.id.post);
        this.e = (ImageView) findViewById(R.id.back);
        this.e.setOnClickListener(new w(this));
        this.d = (Button) findViewById(R.id.reply);
        this.d.setOnClickListener(new x(this));
        this.f = (ProgressBar) findViewById(R.id.progress);
        this.f.setVisibility(8);
        this.n = (ImageView) findViewById(R.id.photo);
        this.n.setOnClickListener(new y(this));
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
        this.o.setTextSize(com.baidu.tieba.data.i.E());
        this.s.setTextSize(com.baidu.tieba.data.i.B());
        this.u = TiebaApplication.g().aa();
        this.v = TiebaApplication.g().Z();
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
        this.l = new bn();
        a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, android.app.Activity
    public void onResume() {
        if (this.u != TiebaApplication.g().aa()) {
            this.u = TiebaApplication.g().aa();
            this.o.setTextSize(com.baidu.tieba.data.i.E());
            this.s.setTextSize(com.baidu.tieba.data.i.B());
            b();
        }
        if (this.v != TiebaApplication.g().Z()) {
            this.v = TiebaApplication.g().Z();
            b();
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        try {
            if (this.k != null) {
                this.k.cancel();
                this.k = null;
            }
            if (this.m != null) {
                this.m.c();
            }
            if (this.l != null) {
                if (this.l.a() != null) {
                    this.l.a(null);
                }
                this.l = null;
            }
            this.f.setVisibility(8);
            System.gc();
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b(getClass().getName(), "onDestroy", e.getMessage());
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("tid", this.h);
        bundle.putString("pid", this.i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        bq.a(this.c, i);
        bq.a(this.e, i);
        bq.f((TextView) this.d, i);
        bq.a(this.g, i);
        bq.d(this.b, i);
        bq.b(this.o, i);
        if (i == 1) {
            this.s.setTextColor(getResources().getColor(R.color.skin_1_second_common_color));
            bq.e((View) this.p, (int) R.drawable.floor_bg_1);
            return;
        }
        this.s.setTextColor(-12040120);
        bq.e((View) this.p, (int) R.drawable.floor_bg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        try {
            StringBuffer stringBuffer = new StringBuffer(30);
            stringBuffer.append(com.baidu.tieba.data.i.a);
            stringBuffer.append("c/f/pb/page");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new BasicNameValuePair("kz", this.h));
            arrayList.add(new BasicNameValuePair("pid", this.i));
            arrayList.add(new BasicNameValuePair("mark", String.valueOf(1)));
            arrayList.add(new BasicNameValuePair("rn", String.valueOf(1)));
            if (this.j != null) {
                arrayList.add(new BasicNameValuePair("st_type", this.j));
            }
            this.k = new ac(this, stringBuffer.toString(), arrayList);
            this.k.setPriority(3);
            this.k.execute(stringBuffer.toString(), arrayList);
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b("PbActivity", "startPbAsyncTask", "error" + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        ArrayList<aq> e;
        ArrayList<com.baidu.tieba.data.k> i;
        int i2;
        int i3;
        try {
            if (this.l != null && this.l.a() != null && (e = this.l.a().e()) != null && e.size() > 0) {
                aq aqVar = e.get(0);
                this.c.setText(String.format(getString(R.string.post_x_floor), Integer.valueOf(aqVar.e())));
                this.n.setVisibility(0);
                String portrait = aqVar.g().getPortrait();
                if (portrait != null && portrait.length() > 0) {
                    com.baidu.tieba.util.i iVar = this.m;
                    com.baidu.adp.widget.ImageView.b b = com.baidu.tbadk.imageManager.e.a().b(portrait);
                    if (b != null) {
                        b.a(this.n);
                        if (aqVar.g() == null && aqVar.g().getName_show() != null) {
                            this.o.setText(aqVar.g().getName_show());
                        } else {
                            this.o.setText((CharSequence) null);
                        }
                        if (aqVar.g() == null && aqVar.g().getLevel_id() != 0) {
                            this.q.setText(String.valueOf(String.valueOf(aqVar.g().getLevel_id())) + getString(R.string.grade));
                        } else {
                            this.q.setText((CharSequence) null);
                        }
                        this.r.setText(bs.a(aqVar.f()));
                        this.p.setVisibility(0);
                        this.p.setText(String.valueOf(String.valueOf(aqVar.e())) + getString(R.string.floor));
                        i = aqVar.i();
                        if (i == null && i.size() > 0) {
                            com.baidu.tieba.data.k kVar = i.get(0);
                            if (kVar == null || kVar.a() != 0) {
                                i2 = 0;
                            } else {
                                this.s.setVisibility(0);
                                this.s.setText(kVar.d());
                                i2 = 1;
                            }
                            int i4 = -1;
                            this.t.setVisibility(8);
                            int i5 = i2;
                            while (i5 < i.size()) {
                                this.t.setVisibility(0);
                                com.baidu.tieba.data.k kVar2 = i.get(i5);
                                if (kVar2.a() == 3) {
                                    if (this.v) {
                                        int i6 = i4 + 1;
                                        ImageView imageView = new ImageView(this);
                                        int a = BdUtilHelper.a((Context) this, 105.0f);
                                        int a2 = BdUtilHelper.a((Context) this, 105.0f);
                                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, a);
                                        layoutParams.topMargin = BdUtilHelper.a((Context) this, 15.0f);
                                        com.baidu.tieba.util.i iVar2 = this.m;
                                        com.baidu.adp.widget.ImageView.b c = com.baidu.tbadk.imageManager.e.a().c(kVar2.e());
                                        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                                        imageView.setMaxWidth(a2);
                                        if (c != null) {
                                            imageView.setTag(null);
                                            c.a(imageView);
                                        } else {
                                            imageView.setTag(kVar2.e());
                                            imageView.setImageBitmap(com.baidu.tieba.util.n.a((int) R.drawable.image_default));
                                        }
                                        imageView.setClickable(true);
                                        imageView.setFocusable(false);
                                        imageView.setOnClickListener(new ab(this, i, i6));
                                        this.t.addView(imageView, layoutParams);
                                        i3 = i6;
                                        i5++;
                                        i4 = i3;
                                    }
                                } else {
                                    CustomTextView customTextView = new CustomTextView(this);
                                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                                    int a3 = BdUtilHelper.a((Context) this, 15.0f);
                                    layoutParams2.rightMargin = 0;
                                    layoutParams2.leftMargin = 0;
                                    layoutParams2.topMargin = a3;
                                    customTextView.setTextSize(com.baidu.tieba.data.i.B());
                                    customTextView.setTextColor(-11974584);
                                    customTextView.setText(kVar2.d());
                                    customTextView.setLineSpacing(0.0f, 1.2f);
                                    customTextView.setMovementMethod(LinkMovementMethod.getInstance());
                                    customTextView.setFocusable(false);
                                    this.t.addView(customTextView, layoutParams2);
                                }
                                i3 = i4;
                                i5++;
                                i4 = i3;
                            }
                        } else {
                            this.s.setVisibility(0);
                            this.s.setText((CharSequence) null);
                        }
                        c();
                    }
                    this.n.setTag(portrait);
                }
                this.n.setImageResource(R.drawable.photo);
                if (aqVar.g() == null) {
                }
                this.o.setText((CharSequence) null);
                if (aqVar.g() == null) {
                }
                this.q.setText((CharSequence) null);
                this.r.setText(bs.a(aqVar.f()));
                this.p.setVisibility(0);
                this.p.setText(String.valueOf(String.valueOf(aqVar.e())) + getString(R.string.floor));
                i = aqVar.i();
                if (i == null) {
                }
                this.s.setVisibility(0);
                this.s.setText((CharSequence) null);
                c();
            }
        } catch (Exception e2) {
            com.baidu.adp.lib.util.e.b("PbActivity", "refreshActivity", "error = " + e2.getMessage());
        }
    }

    private void c() {
        try {
            aq aqVar = this.l.a().e().get(0);
            if (aqVar != null) {
                ArrayList<com.baidu.tieba.data.k> i = aqVar.i();
                String portrait = aqVar.g().getPortrait();
                if (this.l.b() && portrait != null && portrait.length() > 0) {
                    this.m.d(portrait, new z(this));
                }
                int size = i.size();
                if (this.v) {
                    for (int i2 = 0; i2 < size; i2++) {
                        if (i.get(i2).a() == 3) {
                            this.m.b(i.get(i2).e(), new aa(this));
                        }
                    }
                }
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b("PbActivity", "mGetImageRunnble.run", "error = " + e.getMessage());
        }
    }
}
