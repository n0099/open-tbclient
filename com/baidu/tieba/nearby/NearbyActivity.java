package com.baidu.tieba.nearby;

import android.app.ActivityGroup;
import android.content.Intent;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class NearbyActivity extends ActivityGroup {
    private TextView a;
    private RadioButton b;
    private RadioButton c;
    private CompoundButton.OnCheckedChangeListener d = null;
    private FrameLayout e;

    void a() {
        this.a = (TextView) findViewById(R.id.location_text);
        this.e = (FrameLayout) findViewById(R.id.content);
        this.b = (RadioButton) findViewById(R.id.radar_mode);
        this.c = (RadioButton) findViewById(R.id.list_mode);
        this.d = new o(this);
        this.b.setOnCheckedChangeListener(this.d);
        this.c.setOnCheckedChangeListener(this.d);
        this.b.setChecked(true);
    }

    public void a(String str) {
        if (str.equals("")) {
            this.a.setText(getResources().getText(R.string.your_location));
        } else {
            this.a.setText(str);
        }
    }

    public void a(String str, Class cls) {
        Intent intent = new Intent(this, cls);
        this.e.removeAllViews();
        this.e.addView(getLocalActivityManager().startActivity(str, intent).getDecorView());
    }

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.nearby_activity);
        a();
    }
}
