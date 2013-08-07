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

    /* renamed from: a  reason: collision with root package name */
    protected int f1553a = -1;
    private String i = null;

    public static void a(Activity activity, String str) {
        Intent intent = new Intent(activity, MyPostActivity.class);
        intent.putExtra("user", str);
        activity.startActivity(intent);
    }

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (a()) {
            CompatibleUtile.getInstance().openGpu(this);
        }
        setContentView(R.layout.my_post_activity);
        this.i = getIntent().getStringExtra("user");
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
        this.d.setOnClickListener(new ab(this));
        this.e = (ImageView) findViewById(R.id.refresh);
        this.e.setOnClickListener(new ac(this));
        this.g = (RadioGroup) findViewById(R.id.posttype_tabs);
        this.g.setOnCheckedChangeListener(new ad(this));
        this.g.check(R.id.all_tab);
        this.g.setVisibility(8);
    }

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (TiebaApplication.f().au() != this.f1553a) {
            this.f1553a = TiebaApplication.f().au();
            a(this.f1553a);
        }
    }

    public void a(int i) {
        com.baidu.tieba.util.ah.a(this.b, i);
        com.baidu.tieba.util.ah.d(this.c, i);
        com.baidu.tieba.util.ah.f(this.f, i);
        com.baidu.tieba.util.ah.a(this.d, i);
        com.baidu.tieba.util.ah.b(this.e, i);
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
            ((AllPostActivity) currentActivity).b(0);
        } else if (!currentId.equals("my_thread")) {
            currentId.equals("my_reply");
        }
    }
}
