package com.baidu.tieba.nearby;

import android.app.ActivityGroup;
import android.content.Intent;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.c.ad;
/* loaded from: classes.dex */
public class NearbyActivity extends ActivityGroup {
    private TextView b;
    private RelativeLayout c;
    private LinearLayout d;
    private RadioButton e;
    private RadioButton f;
    private FrameLayout h;
    private CompoundButton.OnCheckedChangeListener g = null;
    protected int a = -1;

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.nearby_activity);
        a();
    }

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (TiebaApplication.b().af() != this.a) {
            this.a = TiebaApplication.b().af();
            a(this.a);
        }
    }

    protected void a(int i) {
        ad.a(this.c, i);
        if (i == 1) {
            this.d.setBackgroundColor(-13290187);
            this.b.setTextColor(ad.a(i));
            this.e.setButtonDrawable(R.drawable.nearby_radar_btn_bg_1);
            this.f.setButtonDrawable(R.drawable.nearby_list_btn_bg_1);
            return;
        }
        this.d.setBackgroundColor(-1);
        this.b.setTextColor(-14277082);
        this.e.setButtonDrawable(R.drawable.nearby_radar_btn_bg);
        this.f.setButtonDrawable(R.drawable.nearby_list_btn_bg);
    }

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onStop() {
        super.onStop();
        this.a = -1;
        this.e.setButtonDrawable(0);
        this.f.setButtonDrawable(0);
    }

    void a() {
        this.c = (RelativeLayout) findViewById(R.id.parent);
        this.d = (LinearLayout) findViewById(R.id.top_bar);
        this.b = (TextView) findViewById(R.id.location_text);
        this.h = (FrameLayout) findViewById(R.id.content);
        this.e = (RadioButton) findViewById(R.id.radar_mode);
        this.f = (RadioButton) findViewById(R.id.list_mode);
        this.g = new o(this);
        this.e.setOnCheckedChangeListener(this.g);
        this.f.setOnCheckedChangeListener(this.g);
        this.e.setChecked(true);
    }

    public void a(String str, Class cls) {
        Intent intent = new Intent(this, cls);
        this.h.removeAllViews();
        this.h.addView(getLocalActivityManager().startActivity(str, intent).getDecorView());
    }

    public void a(String str) {
        if (str.equals("")) {
            this.b.setText(getResources().getText(R.string.your_location));
        } else {
            this.b.setText(str);
        }
    }
}
