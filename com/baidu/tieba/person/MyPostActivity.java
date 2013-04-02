package com.baidu.tieba.person;

import android.app.Activity;
import android.app.ActivityGroup;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
public class MyPostActivity extends ActivityGroup {
    private RelativeLayout a = null;
    private RelativeLayout b = null;
    private Button c = null;
    private Button d = null;
    private TextView e = null;
    private RadioGroup f = null;
    private FrameLayout g;

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.my_post_activity);
        a();
        b();
    }

    void a() {
        this.a = (RelativeLayout) findViewById(R.id.my_post_activity_layout);
        this.b = (RelativeLayout) findViewById(R.id.title);
        this.e = (TextView) findViewById(R.id.title_text);
        this.g = (FrameLayout) findViewById(R.id.content);
        this.c = (Button) findViewById(R.id.back);
        this.c.setOnClickListener(new af(this));
        this.d = (Button) findViewById(R.id.refresh);
        this.d.setOnClickListener(new ag(this));
        this.f = (RadioGroup) findViewById(R.id.posttype_tabs);
        this.f.setOnCheckedChangeListener(new ah(this));
        this.f.check(R.id.all_tab);
        this.f.setVisibility(8);
    }

    void b() {
        if (TiebaApplication.b().ah() != 0) {
            a(1);
        }
    }

    public void a(int i) {
        com.baidu.tieba.c.ae.a(this.a, i);
        com.baidu.tieba.c.ae.c(this.b, i);
        com.baidu.tieba.c.ae.c(this.e, i);
        com.baidu.tieba.c.ae.c((TextView) this.c, i);
        com.baidu.tieba.c.ae.e((TextView) this.c, i);
        com.baidu.tieba.c.ae.e((View) this.d, i);
    }

    public void a(String str, Class cls) {
        Intent intent = new Intent(this, cls);
        this.g.removeAllViews();
        this.g.addView(getLocalActivityManager().startActivity(str, intent).getDecorView());
    }

    public void c() {
        String currentId = getLocalActivityManager().getCurrentId();
        Activity currentActivity = getLocalActivityManager().getCurrentActivity();
        if (currentId.equals("all")) {
            ((AllPostActivity) currentActivity).c(0);
        } else if (!currentId.equals("my_thread")) {
            currentId.equals("my_reply");
        }
    }
}
