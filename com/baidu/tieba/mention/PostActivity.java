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
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.bk;
import com.baidu.tbadk.core.util.bm;
import com.baidu.tieba.ai;
import com.baidu.tieba.data.am;
import com.baidu.tieba.model.al;
import com.baidu.tieba.view.CustomTextView;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class PostActivity extends BaseActivity {
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
    private z k = null;
    private al l = null;
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
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.w.post_activity);
        a();
        if (bundle != null) {
            this.h = bundle.getString("tid");
            this.i = bundle.getString("pid");
            this.j = bundle.getString(com.baidu.tbadk.core.frameworkData.a.ST_TYPE);
        } else {
            Intent intent = getIntent();
            this.h = intent.getStringExtra("tid");
            this.i = intent.getStringExtra("pid");
            this.j = intent.getStringExtra(com.baidu.tbadk.core.frameworkData.a.ST_TYPE);
        }
        this.m = new com.baidu.tbadk.editortool.aa(this);
        this.l = new al();
        c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        if (this.u != TbadkApplication.m252getInst().getFontSize()) {
            this.u = TbadkApplication.m252getInst().getFontSize();
            this.o.setTextSize(TbConfig.getNameSize());
            this.s.setTextSize(TbConfig.getContentSize());
            d();
        }
        if (this.v != ai.c().x()) {
            this.v = ai.c().x();
            d();
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
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
            BdLog.e(e.getMessage());
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("tid", this.h);
        bundle.putString("pid", this.i);
    }

    private void a() {
        this.g = (RelativeLayout) findViewById(com.baidu.tieba.v.container);
        this.b = (LinearLayout) findViewById(com.baidu.tieba.v.title);
        this.c = (TextView) findViewById(com.baidu.tieba.v.title_text);
        this.a = (LinearLayout) findViewById(com.baidu.tieba.v.post);
        this.e = (ImageView) findViewById(com.baidu.tieba.v.back);
        this.e.setOnClickListener(new t(this));
        this.d = (Button) findViewById(com.baidu.tieba.v.reply);
        this.d.setOnClickListener(new u(this));
        this.f = (ProgressBar) findViewById(com.baidu.tieba.v.progress);
        this.f.setVisibility(8);
        this.n = (ImageView) findViewById(com.baidu.tieba.v.photo);
        this.n.setOnClickListener(new v(this));
        this.o = (TextView) findViewById(com.baidu.tieba.v.user_name);
        this.o.getPaint().setFakeBoldText(true);
        this.p = (TextView) findViewById(com.baidu.tieba.v.floor);
        this.p.setVisibility(8);
        this.q = (TextView) findViewById(com.baidu.tieba.v.rank);
        this.r = (TextView) findViewById(com.baidu.tieba.v.time);
        this.s = (TextView) findViewById(com.baidu.tieba.v.text);
        this.s.setMovementMethod(LinkMovementMethod.getInstance());
        this.s.setFocusable(false);
        this.s.setLineSpacing(0.0f, 1.2f);
        this.t = (LinearLayout) findViewById(com.baidu.tieba.v.seg);
        this.o.setTextSize(TbConfig.getNameSize());
        this.s.setTextSize(TbConfig.getContentSize());
        this.u = TbadkApplication.m252getInst().getFontSize();
        this.v = ai.c().x();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        bk.a(this.c, i);
        bk.a(this.e, i);
        bk.e((TextView) this.d, i);
        bk.a(this.g, i);
        bk.d(this.b, i);
        bk.b(this.o, i);
        if (i == 1) {
            this.s.setTextColor(getResources().getColor(com.baidu.tieba.s.skin_1_second_common_color));
            bk.e((View) this.p, com.baidu.tieba.u.floor_bg_1);
            return;
        }
        this.s.setTextColor(-12040120);
        bk.e((View) this.p, com.baidu.tieba.u.floor_bg);
    }

    private void b() {
        if (this.k != null) {
            this.k.cancel();
            this.k = null;
        }
        if (this.m != null) {
            this.m.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        try {
            StringBuffer stringBuffer = new StringBuffer(30);
            stringBuffer.append(TbConfig.SERVER_ADDRESS);
            stringBuffer.append("c/f/pb/page");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new BasicNameValuePair("kz", this.h));
            arrayList.add(new BasicNameValuePair("pid", this.i));
            arrayList.add(new BasicNameValuePair("mark", String.valueOf(1)));
            arrayList.add(new BasicNameValuePair("rn", String.valueOf(1)));
            if (this.j != null) {
                arrayList.add(new BasicNameValuePair(com.baidu.tbadk.core.frameworkData.a.ST_TYPE, this.j));
            }
            this.k = new z(this, stringBuffer.toString(), arrayList);
            this.k.setPriority(3);
            this.k.execute(stringBuffer.toString(), arrayList);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        ArrayList<am> d;
        int i;
        int i2;
        try {
            if (this.l != null && this.l.a() != null && (d = this.l.a().d()) != null && d.size() > 0) {
                am amVar = d.get(0);
                this.c.setText(String.format(getString(com.baidu.tieba.y.post_x_floor), Integer.valueOf(amVar.m())));
                this.n.setVisibility(0);
                String portrait = amVar.o().getPortrait();
                if (portrait != null && portrait.length() > 0) {
                    com.baidu.adp.widget.a.a c = this.m.c(portrait);
                    if (c != null) {
                        c.a(this.n);
                    } else {
                        this.n.setTag(portrait);
                        this.n.setImageResource(com.baidu.tieba.u.photo);
                    }
                } else {
                    this.n.setImageResource(com.baidu.tieba.u.photo);
                }
                if (amVar.o() != null && amVar.o().getName_show() != null) {
                    this.o.setText(amVar.o().getName_show());
                } else {
                    this.o.setText((CharSequence) null);
                }
                if (amVar.o() != null && amVar.o().getLevel_id() != 0) {
                    this.q.setText(String.valueOf(String.valueOf(amVar.o().getLevel_id())) + getString(com.baidu.tieba.y.grade));
                } else {
                    this.q.setText((CharSequence) null);
                }
                this.r.setText(bm.a(amVar.n()));
                this.p.setVisibility(0);
                this.p.setText(String.valueOf(String.valueOf(amVar.m())) + getString(com.baidu.tieba.y.floor));
                ArrayList<com.baidu.tieba.data.g> s = amVar.s();
                if (s != null && s.size() > 0) {
                    com.baidu.tieba.data.g gVar = s.get(0);
                    if (gVar == null || gVar.a() != 0) {
                        i = 0;
                    } else {
                        this.s.setVisibility(0);
                        this.s.setText(gVar.d());
                        i = 1;
                    }
                    int i3 = -1;
                    this.t.setVisibility(8);
                    int i4 = i;
                    while (i4 < s.size()) {
                        this.t.setVisibility(0);
                        com.baidu.tieba.data.g gVar2 = s.get(i4);
                        if (gVar2.a() == 3) {
                            if (this.v) {
                                int i5 = i3 + 1;
                                ImageView imageView = new ImageView(this);
                                int a = com.baidu.adp.lib.util.j.a((Context) this, 105.0f);
                                int a2 = com.baidu.adp.lib.util.j.a((Context) this, 105.0f);
                                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, a);
                                layoutParams.topMargin = com.baidu.adp.lib.util.j.a((Context) this, 15.0f);
                                com.baidu.adp.widget.a.a d2 = this.m.d(gVar2.e());
                                imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                                imageView.setMaxWidth(a2);
                                if (d2 != null) {
                                    imageView.setTag(null);
                                    d2.a(imageView);
                                } else {
                                    imageView.setTag(gVar2.e());
                                    imageView.setImageBitmap(com.baidu.tbadk.core.util.h.a(com.baidu.tieba.u.image_default));
                                }
                                imageView.setClickable(true);
                                imageView.setFocusable(false);
                                imageView.setOnClickListener(new y(this, s, i5));
                                this.t.addView(imageView, layoutParams);
                                i2 = i5;
                                i4++;
                                i3 = i2;
                            }
                        } else {
                            CustomTextView customTextView = new CustomTextView(this);
                            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                            int a3 = com.baidu.adp.lib.util.j.a((Context) this, 15.0f);
                            layoutParams2.rightMargin = 0;
                            layoutParams2.leftMargin = 0;
                            layoutParams2.topMargin = a3;
                            customTextView.setTextSize(TbConfig.getContentSize());
                            customTextView.setTextColor(-11974584);
                            customTextView.setText(gVar2.d());
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
                e();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void e() {
        try {
            am amVar = this.l.a().d().get(0);
            if (amVar != null) {
                ArrayList<com.baidu.tieba.data.g> s = amVar.s();
                String portrait = amVar.o().getPortrait();
                if (this.l.b() && portrait != null && portrait.length() > 0) {
                    this.m.d(portrait, new w(this));
                }
                int size = s.size();
                if (this.v) {
                    for (int i = 0; i < size; i++) {
                        if (s.get(i).a() == 3) {
                            this.m.b(s.get(i).e(), new x(this));
                        }
                    }
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
