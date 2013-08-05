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
import com.baidu.tieba.data.aw;
import com.baidu.tieba.model.bl;
import com.baidu.tieba.util.ah;
import com.baidu.tieba.util.ai;
import com.baidu.tieba.util.aj;
import com.baidu.tieba.util.am;
import com.baidu.tieba.view.CustomTextView;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class PostActivity extends com.baidu.tieba.g {

    /* renamed from: a  reason: collision with root package name */
    private LinearLayout f1289a = null;
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
    private bl n = null;
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
        this.n = new bl();
        d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onResume() {
        if (this.w != TiebaApplication.f().ar()) {
            this.w = TiebaApplication.f().ar();
            this.q.setTextSize(com.baidu.tieba.data.g.q());
            this.u.setTextSize(com.baidu.tieba.data.g.n());
            k();
        }
        if (this.x != TiebaApplication.f().aq()) {
            this.x = TiebaApplication.f().aq();
            k();
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
                    this.n.a(null);
                }
                this.n = null;
            }
            this.f.setVisibility(8);
            System.gc();
        } catch (Exception e) {
            aj.b(getClass().getName(), "onDestroy", e.getMessage());
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
        this.f1289a = (LinearLayout) findViewById(R.id.post);
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
        this.w = TiebaApplication.f().ar();
        this.x = TiebaApplication.f().aq();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g
    public void a(int i) {
        super.a(i);
        ah.a(this.c, i);
        ah.a(this.e, i);
        ah.g((TextView) this.d, i);
        ah.a(this.g, i);
        ah.d(this.b, i);
        ah.b(this.q, i);
        if (i == 1) {
            this.u.setTextColor(getResources().getColor(R.color.skin_1_second_common_color));
            ah.h((View) this.r, (int) R.drawable.floor_bg_1);
            return;
        }
        this.u.setTextColor(-12040120);
        ah.h((View) this.r, (int) R.drawable.floor_bg);
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
            stringBuffer.append(com.baidu.tieba.data.g.f1013a);
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
            aj.b("PbActivity", "startPbAsyncTask", "error" + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        ArrayList c;
        int i;
        int i2;
        try {
            if (this.n != null && this.n.a() != null && (c = this.n.a().c()) != null && c.size() > 0) {
                aw awVar = (aw) c.get(0);
                this.c.setText(String.format(getString(R.string.post_x_floor), Integer.valueOf(awVar.e())));
                this.p.setVisibility(0);
                String portrait = awVar.g().getPortrait();
                if (portrait != null && portrait.length() > 0) {
                    com.baidu.adp.widget.a.b c2 = this.o.c(portrait);
                    if (c2 != null) {
                        c2.b(this.p);
                    } else {
                        this.p.setTag(portrait);
                        this.p.setImageResource(R.drawable.photo);
                    }
                } else {
                    this.p.setImageResource(R.drawable.photo);
                }
                if (awVar.g() != null && awVar.g().getName_show() != null) {
                    this.q.setText(awVar.g().getName_show());
                } else {
                    this.q.setText((CharSequence) null);
                }
                if (awVar.g() != null && awVar.g().getLevel_id() != 0) {
                    this.s.setText(String.valueOf(String.valueOf(awVar.g().getLevel_id())) + getString(R.string.grade));
                } else {
                    this.s.setText((CharSequence) null);
                }
                this.t.setText(ai.a(awVar.f()));
                this.r.setVisibility(0);
                this.r.setText(String.valueOf(String.valueOf(awVar.e())) + getString(R.string.floor));
                ArrayList i3 = awVar.i();
                if (i3 != null && i3.size() > 0) {
                    com.baidu.tieba.data.i iVar = (com.baidu.tieba.data.i) i3.get(0);
                    if (iVar == null || iVar.a() != 0) {
                        i = 0;
                    } else {
                        this.u.setVisibility(0);
                        this.u.setText(iVar.c());
                        i = 1;
                    }
                    int i4 = -1;
                    this.v.setVisibility(8);
                    int i5 = i;
                    while (i5 < i3.size()) {
                        this.v.setVisibility(0);
                        com.baidu.tieba.data.i iVar2 = (com.baidu.tieba.data.i) i3.get(i5);
                        if (iVar2.a() == 3) {
                            if (this.x) {
                                int i6 = i4 + 1;
                                ImageView imageView = new ImageView(this);
                                int a2 = am.a((Context) this, 105.0f);
                                int a3 = am.a((Context) this, 105.0f);
                                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, a2);
                                layoutParams.topMargin = am.a((Context) this, 15.0f);
                                com.baidu.adp.widget.a.b d = this.o.d(iVar2.d());
                                imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                                imageView.setMaxWidth(a3);
                                if (d != null) {
                                    imageView.setTag(null);
                                    d.b(imageView);
                                } else {
                                    imageView.setTag(iVar2.d());
                                    imageView.setImageBitmap(com.baidu.tieba.util.e.a((int) R.drawable.image_default));
                                }
                                imageView.setClickable(true);
                                imageView.setFocusable(false);
                                imageView.setOnClickListener(new w(this, i3, i6));
                                this.v.addView(imageView, layoutParams);
                                i2 = i6;
                                i5++;
                                i4 = i2;
                            }
                        } else {
                            CustomTextView customTextView = new CustomTextView(this);
                            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                            int a4 = am.a((Context) this, 15.0f);
                            layoutParams2.rightMargin = 0;
                            layoutParams2.leftMargin = 0;
                            layoutParams2.topMargin = a4;
                            customTextView.setTextSize(com.baidu.tieba.data.g.n());
                            customTextView.setTextColor(-11974584);
                            customTextView.setText(iVar2.c());
                            customTextView.setLineSpacing(0.0f, 1.2f);
                            customTextView.setMovementMethod(LinkMovementMethod.getInstance());
                            customTextView.setFocusable(false);
                            this.v.addView(customTextView, layoutParams2);
                        }
                        i2 = i4;
                        i5++;
                        i4 = i2;
                    }
                } else {
                    this.u.setVisibility(0);
                    this.u.setText((CharSequence) null);
                }
                l();
            }
        } catch (Exception e) {
            aj.b("PbActivity", "refreshActivity", "error = " + e.getMessage());
        }
    }

    private void l() {
        try {
            aw awVar = (aw) this.n.a().c().get(0);
            if (awVar != null) {
                ArrayList i = awVar.i();
                String portrait = awVar.g().getPortrait();
                if (this.n.b() && portrait != null && portrait.length() > 0) {
                    this.o.d(portrait, new u(this));
                }
                int size = i.size();
                if (this.x) {
                    for (int i2 = 0; i2 < size; i2++) {
                        if (((com.baidu.tieba.data.i) i.get(i2)).a() == 3) {
                            this.o.a(((com.baidu.tieba.data.i) i.get(i2)).d(), new v(this));
                        }
                    }
                }
            }
        } catch (Exception e) {
            aj.b("PbActivity", "mGetImageRunnble.run", "error = " + e.getMessage());
        }
    }
}
