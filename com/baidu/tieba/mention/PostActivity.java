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
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.data.ai;
import com.baidu.tieba.model.am;
import com.baidu.tieba.view.CustomTextView;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class PostActivity extends com.baidu.tbadk.a {
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
    private am l = null;
    private com.baidu.tbadk.editortool.aa m;
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
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.a.i.post_activity);
        this.g = (RelativeLayout) findViewById(com.baidu.tieba.a.h.container);
        this.b = (LinearLayout) findViewById(com.baidu.tieba.a.h.title);
        this.c = (TextView) findViewById(com.baidu.tieba.a.h.title_text);
        this.a = (LinearLayout) findViewById(com.baidu.tieba.a.h.post);
        this.e = (ImageView) findViewById(com.baidu.tieba.a.h.back);
        this.e.setOnClickListener(new w(this));
        this.d = (Button) findViewById(com.baidu.tieba.a.h.reply);
        this.d.setOnClickListener(new x(this));
        this.f = (ProgressBar) findViewById(com.baidu.tieba.a.h.progress);
        this.f.setVisibility(8);
        this.n = (ImageView) findViewById(com.baidu.tieba.a.h.photo);
        this.n.setOnClickListener(new y(this));
        this.o = (TextView) findViewById(com.baidu.tieba.a.h.user_name);
        this.o.getPaint().setFakeBoldText(true);
        this.p = (TextView) findViewById(com.baidu.tieba.a.h.floor);
        this.p.setVisibility(8);
        this.q = (TextView) findViewById(com.baidu.tieba.a.h.rank);
        this.r = (TextView) findViewById(com.baidu.tieba.a.h.time);
        this.s = (TextView) findViewById(com.baidu.tieba.a.h.text);
        this.s.setMovementMethod(LinkMovementMethod.getInstance());
        this.s.setFocusable(false);
        this.s.setLineSpacing(0.0f, 1.2f);
        this.t = (LinearLayout) findViewById(com.baidu.tieba.a.h.seg);
        this.o.setTextSize(com.baidu.tbadk.core.data.n.o());
        this.s.setTextSize(com.baidu.tbadk.core.data.n.p());
        this.u = TbadkApplication.j().L();
        this.v = com.baidu.tieba.r.c().u();
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
        this.m = new com.baidu.tbadk.editortool.aa(this);
        this.l = new am();
        a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, android.app.Activity
    public void onResume() {
        if (this.u != TbadkApplication.j().L()) {
            this.u = TbadkApplication.j().L();
            this.o.setTextSize(com.baidu.tbadk.core.data.n.o());
            this.s.setTextSize(com.baidu.tbadk.core.data.n.p());
            b();
        }
        if (this.v != com.baidu.tieba.r.c().u()) {
            this.v = com.baidu.tieba.r.c().u();
            b();
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
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
            com.baidu.adp.lib.util.f.b(getClass().getName(), "onDestroy", e.getMessage());
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("tid", this.h);
        bundle.putString("pid", this.i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ba.a(this.c, i);
        ba.a(this.e, i);
        ba.e((TextView) this.d, i);
        ba.a(this.g, i);
        ba.d(this.b, i);
        ba.b(this.o, i);
        if (i == 1) {
            this.s.setTextColor(getResources().getColor(com.baidu.tieba.a.e.skin_1_second_common_color));
            ba.e((View) this.p, com.baidu.tieba.a.g.floor_bg_1);
            return;
        }
        this.s.setTextColor(-12040120);
        ba.e((View) this.p, com.baidu.tieba.a.g.floor_bg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        try {
            StringBuffer stringBuffer = new StringBuffer(30);
            stringBuffer.append(com.baidu.tbadk.core.data.n.a);
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
            com.baidu.adp.lib.util.f.b("PbActivity", "startPbAsyncTask", "error" + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        ArrayList<ai> e;
        ArrayList<com.baidu.tieba.data.f> j;
        int i;
        int i2;
        try {
            if (this.l != null && this.l.a() != null && (e = this.l.a().e()) != null && e.size() > 0) {
                ai aiVar = e.get(0);
                this.c.setText(String.format(getString(com.baidu.tieba.a.k.post_x_floor), Integer.valueOf(aiVar.e())));
                this.n.setVisibility(0);
                String portrait = aiVar.g().getPortrait();
                if (portrait != null && portrait.length() > 0) {
                    com.baidu.tbadk.editortool.aa aaVar = this.m;
                    com.baidu.adp.widget.ImageView.b b = com.baidu.tbadk.imageManager.e.a().b(portrait);
                    if (b != null) {
                        b.a(this.n);
                        if (aiVar.g() == null && aiVar.g().getName_show() != null) {
                            this.o.setText(aiVar.g().getName_show());
                        } else {
                            this.o.setText((CharSequence) null);
                        }
                        if (aiVar.g() == null && aiVar.g().getLevel_id() != 0) {
                            this.q.setText(String.valueOf(String.valueOf(aiVar.g().getLevel_id())) + getString(com.baidu.tieba.a.k.grade));
                        } else {
                            this.q.setText((CharSequence) null);
                        }
                        this.r.setText(bc.a(aiVar.f()));
                        this.p.setVisibility(0);
                        this.p.setText(String.valueOf(String.valueOf(aiVar.e())) + getString(com.baidu.tieba.a.k.floor));
                        j = aiVar.j();
                        if (j == null && j.size() > 0) {
                            com.baidu.tieba.data.f fVar = j.get(0);
                            if (fVar == null || fVar.a() != 0) {
                                i = 0;
                            } else {
                                this.s.setVisibility(0);
                                this.s.setText(fVar.f());
                                i = 1;
                            }
                            int i3 = -1;
                            this.t.setVisibility(8);
                            int i4 = i;
                            while (i4 < j.size()) {
                                this.t.setVisibility(0);
                                com.baidu.tieba.data.f fVar2 = j.get(i4);
                                if (fVar2.a() == 3) {
                                    if (this.v) {
                                        int i5 = i3 + 1;
                                        ImageView imageView = new ImageView(this);
                                        int a = com.baidu.adp.lib.util.i.a((Context) this, 105.0f);
                                        int a2 = com.baidu.adp.lib.util.i.a((Context) this, 105.0f);
                                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, a);
                                        layoutParams.topMargin = com.baidu.adp.lib.util.i.a((Context) this, 15.0f);
                                        com.baidu.tbadk.editortool.aa aaVar2 = this.m;
                                        com.baidu.adp.widget.ImageView.b c = com.baidu.tbadk.imageManager.e.a().c(fVar2.g());
                                        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                                        imageView.setMaxWidth(a2);
                                        if (c != null) {
                                            imageView.setTag(null);
                                            c.a(imageView);
                                        } else {
                                            imageView.setTag(fVar2.g());
                                            imageView.setImageBitmap(com.baidu.tbadk.core.util.g.a(com.baidu.tieba.a.g.image_default));
                                        }
                                        imageView.setClickable(true);
                                        imageView.setFocusable(false);
                                        imageView.setOnClickListener(new ab(this, j, i5));
                                        this.t.addView(imageView, layoutParams);
                                        i2 = i5;
                                        i4++;
                                        i3 = i2;
                                    }
                                } else {
                                    CustomTextView customTextView = new CustomTextView(this);
                                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                                    int a3 = com.baidu.adp.lib.util.i.a((Context) this, 15.0f);
                                    layoutParams2.rightMargin = 0;
                                    layoutParams2.leftMargin = 0;
                                    layoutParams2.topMargin = a3;
                                    customTextView.setTextSize(com.baidu.tbadk.core.data.n.p());
                                    customTextView.setTextColor(-11974584);
                                    customTextView.setText(fVar2.f());
                                    customTextView.setLineSpacing(0.0f, 1.2f);
                                    customTextView.setMovementMethod(LinkMovementMethod.getInstance());
                                    customTextView.setFocusable(false);
                                    this.t.addView(customTextView, layoutParams2);
                                }
                                i2 = i3;
                                i4++;
                                i3 = i2;
                            }
                        } else {
                            this.s.setVisibility(0);
                            this.s.setText((CharSequence) null);
                        }
                        c();
                    }
                    this.n.setTag(portrait);
                }
                this.n.setImageResource(com.baidu.tieba.a.g.photo);
                if (aiVar.g() == null) {
                }
                this.o.setText((CharSequence) null);
                if (aiVar.g() == null) {
                }
                this.q.setText((CharSequence) null);
                this.r.setText(bc.a(aiVar.f()));
                this.p.setVisibility(0);
                this.p.setText(String.valueOf(String.valueOf(aiVar.e())) + getString(com.baidu.tieba.a.k.floor));
                j = aiVar.j();
                if (j == null) {
                }
                this.s.setVisibility(0);
                this.s.setText((CharSequence) null);
                c();
            }
        } catch (Exception e2) {
            com.baidu.adp.lib.util.f.b("PbActivity", "refreshActivity", "error = " + e2.getMessage());
        }
    }

    private void c() {
        try {
            ai aiVar = this.l.a().e().get(0);
            if (aiVar != null) {
                ArrayList<com.baidu.tieba.data.f> j = aiVar.j();
                String portrait = aiVar.g().getPortrait();
                if (this.l.b() && portrait != null && portrait.length() > 0) {
                    this.m.d(portrait, new z(this));
                }
                int size = j.size();
                if (this.v) {
                    for (int i = 0; i < size; i++) {
                        if (j.get(i).a() == 3) {
                            this.m.b(j.get(i).g(), new aa(this));
                        }
                    }
                }
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("PbActivity", "mGetImageRunnble.run", "error = " + e.getMessage());
        }
    }
}
