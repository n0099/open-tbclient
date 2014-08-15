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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.task.TbHttpMessageTask;
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
    private ak k = null;
    private com.baidu.tieba.model.am l = null;
    private ImageView m;
    private TextView n;
    private TextView o;
    private TextView p;
    private TextView q;
    private TextView r;
    private LinearLayout s;
    private int t;
    private boolean u;

    static {
        a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.v.post_activity);
        b();
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
        this.l = new com.baidu.tieba.model.am();
        d();
    }

    private static void a() {
        com.baidu.tieba.ah.a(303007, ReplyMeSocketResponseMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.REPLYME_HTTP_CMD, com.baidu.tieba.ah.a("c/u/feed/replyme", 303007));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(ReplyMeHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        if (this.t != TbadkApplication.m252getInst().getFontSize()) {
            this.t = TbadkApplication.m252getInst().getFontSize();
            this.n.setTextSize(TbConfig.getNameSize());
            this.r.setTextSize(TbConfig.getContentSize());
            e();
        }
        if (this.u != com.baidu.tieba.ai.c().w()) {
            this.u = com.baidu.tieba.ai.c().w();
            e();
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        try {
            c();
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

    private void b() {
        this.g = (RelativeLayout) findViewById(com.baidu.tieba.u.container);
        this.b = (LinearLayout) findViewById(com.baidu.tieba.u.title);
        this.c = (TextView) findViewById(com.baidu.tieba.u.title_text);
        this.a = (LinearLayout) findViewById(com.baidu.tieba.u.post);
        this.e = (ImageView) findViewById(com.baidu.tieba.u.back);
        this.e.setOnClickListener(new ae(this));
        this.d = (Button) findViewById(com.baidu.tieba.u.reply);
        this.d.setOnClickListener(new af(this));
        this.f = (ProgressBar) findViewById(com.baidu.tieba.u.progress);
        this.f.setVisibility(8);
        this.m = (ImageView) findViewById(com.baidu.tieba.u.photo);
        this.m.setOnClickListener(new ag(this));
        this.n = (TextView) findViewById(com.baidu.tieba.u.user_name);
        this.n.getPaint().setFakeBoldText(true);
        this.o = (TextView) findViewById(com.baidu.tieba.u.floor);
        this.o.setVisibility(8);
        this.p = (TextView) findViewById(com.baidu.tieba.u.rank);
        this.q = (TextView) findViewById(com.baidu.tieba.u.time);
        this.r = (TextView) findViewById(com.baidu.tieba.u.text);
        this.r.setMovementMethod(LinkMovementMethod.getInstance());
        this.r.setFocusable(false);
        this.r.setLineSpacing(0.0f, 1.2f);
        this.s = (LinearLayout) findViewById(com.baidu.tieba.u.seg);
        this.n.setTextSize(TbConfig.getNameSize());
        this.r.setTextSize(TbConfig.getContentSize());
        this.t = TbadkApplication.m252getInst().getFontSize();
        this.u = com.baidu.tieba.ai.c().w();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.ay.a(this.c, i);
        com.baidu.tbadk.core.util.ay.a(this.e, i);
        com.baidu.tbadk.core.util.ay.e((TextView) this.d, i);
        com.baidu.tbadk.core.util.ay.a(this.g, i);
        com.baidu.tbadk.core.util.ay.d(this.b, i);
        com.baidu.tbadk.core.util.ay.b(this.n, i);
        if (i == 1) {
            this.r.setTextColor(getResources().getColor(com.baidu.tieba.r.skin_1_second_common_color));
            com.baidu.tbadk.core.util.ay.e((View) this.o, com.baidu.tieba.t.floor_bg_1);
            return;
        }
        this.r.setTextColor(-12040120);
        com.baidu.tbadk.core.util.ay.e((View) this.o, com.baidu.tieba.t.floor_bg);
    }

    private void c() {
        if (this.k != null) {
            this.k.cancel();
            this.k = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
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
            this.k = new ak(this, stringBuffer.toString(), arrayList);
            this.k.setPriority(3);
            this.k.execute(stringBuffer.toString(), arrayList);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        ArrayList<com.baidu.tieba.data.an> e;
        int i;
        int i2;
        try {
            if (this.l != null && this.l.a() != null && (e = this.l.a().e()) != null && e.size() > 0) {
                com.baidu.tieba.data.an anVar = e.get(0);
                this.c.setText(String.format(getString(com.baidu.tieba.x.post_x_floor), Integer.valueOf(anVar.e())));
                this.m.setVisibility(0);
                String portrait = anVar.g().getPortrait();
                if (portrait != null && portrait.length() > 0) {
                    com.baidu.adp.widget.a.a b = com.baidu.tbadk.imageManager.e.a().b(portrait);
                    if (b != null) {
                        b.a(this.m);
                    } else {
                        this.m.setTag(portrait);
                        this.m.setImageResource(com.baidu.tieba.t.photo);
                    }
                } else {
                    this.m.setImageResource(com.baidu.tieba.t.photo);
                }
                if (anVar.g() != null && anVar.g().getName_show() != null) {
                    this.n.setText(anVar.g().getName_show());
                } else {
                    this.n.setText((CharSequence) null);
                }
                if (anVar.g() != null && anVar.g().getLevel_id() != 0) {
                    this.p.setText(String.valueOf(String.valueOf(anVar.g().getLevel_id())) + getString(com.baidu.tieba.x.grade));
                } else {
                    this.p.setText((CharSequence) null);
                }
                this.q.setText(ba.a(anVar.o_()));
                this.o.setVisibility(0);
                this.o.setText(String.valueOf(String.valueOf(anVar.e())) + getString(com.baidu.tieba.x.floor));
                ArrayList<com.baidu.tieba.data.g> k = anVar.k();
                if (k != null && k.size() > 0) {
                    com.baidu.tieba.data.g gVar = k.get(0);
                    if (gVar == null || gVar.a() != 0) {
                        i = 0;
                    } else {
                        this.r.setVisibility(0);
                        this.r.setText(gVar.d());
                        i = 1;
                    }
                    int i3 = -1;
                    this.s.setVisibility(8);
                    int i4 = i;
                    while (i4 < k.size()) {
                        this.s.setVisibility(0);
                        com.baidu.tieba.data.g gVar2 = k.get(i4);
                        if (gVar2.a() == 3) {
                            if (this.u) {
                                int i5 = i3 + 1;
                                ImageView imageView = new ImageView(this);
                                int a = com.baidu.adp.lib.util.j.a((Context) this, 105.0f);
                                int a2 = com.baidu.adp.lib.util.j.a((Context) this, 105.0f);
                                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, a);
                                layoutParams.topMargin = com.baidu.adp.lib.util.j.a((Context) this, 15.0f);
                                com.baidu.adp.widget.a.a c = com.baidu.tbadk.imageManager.e.a().c(gVar2.e());
                                imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                                imageView.setMaxWidth(a2);
                                if (c != null) {
                                    imageView.setTag(null);
                                    c.a(imageView);
                                } else {
                                    imageView.setTag(gVar2.e());
                                    imageView.setImageBitmap(com.baidu.tbadk.core.util.d.a(com.baidu.tieba.t.image_default));
                                }
                                imageView.setClickable(true);
                                imageView.setFocusable(false);
                                imageView.setOnClickListener(new aj(this, k, i5));
                                this.s.addView(imageView, layoutParams);
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
                            this.s.addView(customTextView, layoutParams2);
                        }
                        i2 = i3;
                        i4++;
                        i3 = i2;
                    }
                } else {
                    this.r.setVisibility(0);
                    this.r.setText((CharSequence) null);
                }
                f();
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    private void f() {
        try {
            com.baidu.tieba.data.an anVar = this.l.a().e().get(0);
            if (anVar != null) {
                ArrayList<com.baidu.tieba.data.g> k = anVar.k();
                String portrait = anVar.g().getPortrait();
                if (this.l.b() && portrait != null && portrait.length() > 0) {
                    com.baidu.adp.lib.resourceLoader.d.a().a(portrait, 12, new ah(this), getUniqueId());
                }
                int size = k.size();
                if (this.u) {
                    for (int i = 0; i < size; i++) {
                        if (k.get(i).a() == 3) {
                            com.baidu.adp.lib.resourceLoader.d.a().a(k.get(i).e(), 12, new ai(this), getUniqueId());
                        }
                    }
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
