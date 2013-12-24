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
    private String i = null;
    private int j = 0;

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (a()) {
            CompatibleUtile.getInstance().openGpu(this);
        }
        setContentView(R.layout.my_post_activity);
        this.i = getIntent().getStringExtra("user");
        this.j = getIntent().getIntExtra("user_sex", 0);
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
        if (this.i != null) {
            if (this.j == 2) {
                this.f.setText(R.string.her_posts);
            } else if (this.j == 1) {
                this.f.setText(R.string.his_posts);
            } else {
                this.f.setText(R.string.ta_posts);
            }
        } else {
            this.f.setText(R.string.my_post);
        }
        this.d = (ImageView) findViewById(R.id.back);
        this.d.setOnClickListener(new ac(this));
        this.e = (ImageView) findViewById(R.id.refresh);
        this.e.setOnClickListener(new ad(this));
        this.g = (RadioGroup) findViewById(R.id.posttype_tabs);
        this.g.setOnCheckedChangeListener(new ae(this));
        this.g.check(R.id.all_tab);
        this.g.setVisibility(8);
    }

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (TiebaApplication.h().an() != this.a) {
            this.a = TiebaApplication.h().an();
            a(this.a);
        }
    }

    public void a(int i) {
        com.baidu.tieba.util.bb.a(this.b, i);
        com.baidu.tieba.util.bb.d(this.c, i);
        com.baidu.tieba.util.bb.e(this.f, i);
        com.baidu.tieba.util.bb.a(this.d, i);
        com.baidu.tieba.util.bb.b(this.e, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, Intent intent) {
        this.h.removeAllViews();
        this.h.addView(getLocalActivityManager().startActivity(str, intent).getDecorView());
    }

    public void c() {
        String currentId = getLocalActivityManager().getCurrentId();
        Activity currentActivity = getLocalActivityManager().getCurrentActivity();
        if (currentId.equals("all")) {
            ((AllPostActivity) currentActivity).a(0);
            return;
        }
        if (currentId.equals("my_thread") || currentId.equals("my_reply")) {
        }
    }
}
