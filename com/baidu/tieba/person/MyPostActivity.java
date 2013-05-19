package com.baidu.tieba.person;

import android.app.Activity;
import android.app.ActivityGroup;
import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class MyPostActivity extends ActivityGroup {
    private FrameLayout h;
    private RelativeLayout b = null;
    private RelativeLayout c = null;
    private ImageView d = null;
    private ImageView e = null;
    private TextView f = null;
    private RadioGroup g = null;
    protected int a = -1;

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (a()) {
            CompatibleUtile.getInstance().openGpu(this);
        }
        setContentView(R.layout.my_post_activity);
        b();
    }

    public boolean a() {
        return false;
    }

    void b() {
        this.b = (RelativeLayout) findViewById(R.id.my_post_activity_layout);
        this.c = (RelativeLayout) findViewById(R.id.title);
        this.f = (TextView) findViewById(R.id.title_text);
        this.h = (FrameLayout) findViewById(R.id.content);
        this.d = (ImageView) findViewById(R.id.back);
        this.d.setOnClickListener(new aa(this));
        this.e = (ImageView) findViewById(R.id.refresh);
        this.e.setOnClickListener(new ab(this));
        this.g = (RadioGroup) findViewById(R.id.posttype_tabs);
        this.g.setOnCheckedChangeListener(new ac(this));
        this.g.check(R.id.all_tab);
        this.g.setVisibility(8);
    }

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (TiebaApplication.d().ai() != this.a) {
            this.a = TiebaApplication.d().ai();
            a(this.a);
        }
    }

    public void a(int i) {
        com.baidu.tieba.d.ac.a(this.b, i);
        com.baidu.tieba.d.ac.d(this.c, i);
        com.baidu.tieba.d.ac.f(this.f, i);
        com.baidu.tieba.d.ac.a(this.d, i);
        com.baidu.tieba.d.ac.b(this.e, i);
    }

    public void a(String str, Class cls) {
        Intent intent = new Intent(this, cls);
        this.h.removeAllViews();
        this.h.addView(getLocalActivityManager().startActivity(str, intent).getDecorView());
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
