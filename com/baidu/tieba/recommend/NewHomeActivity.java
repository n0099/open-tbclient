package com.baidu.tieba.recommend;

import android.app.ActivityGroup;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.c.ad;
/* loaded from: classes.dex */
public class NewHomeActivity extends ActivityGroup {
    private Button b;
    private Button c;
    private Button d;
    private View.OnClickListener e;
    private RadioButton f;
    private RadioButton g;
    private FrameLayout i;
    private CompoundButton.OnCheckedChangeListener h = null;
    protected int a = -1;
    private RelativeLayout j = null;
    private RelativeLayout k = null;
    private TextView l = null;

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.new_home_activity);
        a();
    }

    private void a() {
        this.j = (RelativeLayout) findViewById(R.id.parent);
        this.k = (RelativeLayout) findViewById(R.id.title);
        this.l = (TextView) findViewById(R.id.title_text);
        this.d = (Button) findViewById(R.id.login);
        this.c = (Button) findViewById(R.id.search);
        this.b = (Button) findViewById(R.id.refresh);
        this.e = new o(this);
        this.d.setOnClickListener(this.e);
        this.c.setOnClickListener(this.e);
        this.b.setOnClickListener(this.e);
        this.i = (FrameLayout) findViewById(R.id.content);
        this.f = (RadioButton) findViewById(R.id.recommend_tab);
        this.g = (RadioButton) findViewById(R.id.guess_tab);
        this.h = new p(this);
        this.f.setOnCheckedChangeListener(this.h);
        this.g.setOnCheckedChangeListener(this.h);
        if (TiebaApplication.b().ag() >= 3) {
            this.g.setChecked(true);
        } else {
            this.f.setChecked(true);
        }
    }

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onResume() {
        super.onResume();
        String w = TiebaApplication.w();
        if (w != null && w.length() > 0) {
            this.d.setVisibility(4);
            this.d.setClickable(false);
        } else {
            this.d.setVisibility(0);
            this.d.setClickable(true);
        }
        if (TiebaApplication.b().af() != this.a) {
            this.a = TiebaApplication.b().af();
            a(this.a);
        }
    }

    protected void a(int i) {
        ad.a(this.j, i);
        ad.c(this.k, i);
        ad.c(this.l, i);
        ad.e((View) this.b, i);
        ad.g(this.d, i);
        ad.f(this.c, i);
        if (i == 1) {
            ad.i(this.f, R.drawable.home_radio_button_1);
            ad.i(this.g, R.drawable.home_radio_button_1);
            this.f.setTextColor(getResources().getColorStateList(R.color.tab_text_color_bg_1));
            this.g.setTextColor(getResources().getColorStateList(R.color.tab_text_color_bg_1));
            return;
        }
        ad.i(this.f, R.drawable.home_radio_button);
        ad.i(this.g, R.drawable.home_radio_button);
        this.f.setTextColor(getResources().getColorStateList(R.color.tab_text_color_bg));
        this.g.setTextColor(getResources().getColorStateList(R.color.tab_text_color_bg));
    }

    public void a(String str, Class cls) {
        Intent intent = new Intent(this, cls);
        this.i.removeAllViews();
        this.i.addView(getLocalActivityManager().startActivity(str, intent).getDecorView());
    }
}
