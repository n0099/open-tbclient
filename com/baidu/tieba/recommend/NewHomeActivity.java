package com.baidu.tieba.recommend;

import android.app.ActivityGroup;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.c.ag;
/* loaded from: classes.dex */
public class NewHomeActivity extends ActivityGroup {
    private Button a;
    private Button b;
    private Button c;
    private View.OnClickListener d;
    private RadioButton e;
    private RadioButton f;
    private CompoundButton.OnCheckedChangeListener g = null;
    private FrameLayout h;

    private void a() {
        this.c = (Button) findViewById(R.id.login);
        this.b = (Button) findViewById(R.id.search);
        this.a = (Button) findViewById(R.id.refresh);
        this.d = new o(this);
        this.c.setOnClickListener(this.d);
        this.b.setOnClickListener(this.d);
        this.a.setOnClickListener(this.d);
        this.h = (FrameLayout) findViewById(R.id.content);
        this.e = (RadioButton) findViewById(R.id.recommend_tab);
        this.f = (RadioButton) findViewById(R.id.guess_tab);
        this.g = new p(this);
        this.e.setOnCheckedChangeListener(this.g);
        this.f.setOnCheckedChangeListener(this.g);
        if (TiebaApplication.a().ad() >= 3) {
            this.f.setChecked(true);
        } else {
            this.e.setChecked(true);
        }
    }

    public void a(String str, Class cls) {
        Intent intent = new Intent(this, cls);
        this.h.removeAllViews();
        this.h.addView(getLocalActivityManager().startActivity(str, intent).getDecorView());
    }

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.new_home_activity);
        a();
    }

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onResume() {
        String u = TiebaApplication.u();
        if (u == null || u.length() <= 0) {
            this.c.setVisibility(0);
            this.c.setClickable(true);
        } else {
            this.c.setVisibility(4);
            this.c.setClickable(false);
        }
        super.onResume();
        ag.e(this);
    }
}
