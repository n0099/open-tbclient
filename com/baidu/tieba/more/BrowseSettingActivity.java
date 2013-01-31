package com.baidu.tieba.more;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
public class BrowseSettingActivity extends com.baidu.tieba.e {
    private AlertDialog g;
    private RadioGroup c = null;
    private RadioGroup d = null;
    private LinearLayout e = null;
    private TextView f = null;
    private RelativeLayout h = null;
    private RelativeLayout i = null;
    private TextView j = null;
    private TextView k = null;
    private RadioButton l = null;
    private RadioButton m = null;
    private RadioButton n = null;
    private TextView o = null;
    private RadioButton p = null;
    private RadioButton q = null;
    private RadioButton r = null;
    private TextView s = null;
    private Button t = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.browse_setting_activity);
        i();
        k();
        j();
        l();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e
    public void b(int i) {
        int color;
        super.b(i);
        com.baidu.tieba.c.ad.a(this.h, i);
        com.baidu.tieba.c.ad.c(this.i, i);
        com.baidu.tieba.c.ad.e((TextView) this.t, i);
        com.baidu.tieba.c.ad.c(this.j, i);
        if (i == 1) {
            color = com.baidu.tieba.c.ad.a(i);
            com.baidu.tieba.c.ad.i(this.l, R.drawable.more_up_1);
            com.baidu.tieba.c.ad.i(this.m, R.drawable.more_middle_1);
            com.baidu.tieba.c.ad.i(this.n, R.drawable.more_down_1);
            com.baidu.tieba.c.ad.i(this.p, R.drawable.more_up_1);
            com.baidu.tieba.c.ad.i(this.q, R.drawable.more_middle_1);
            com.baidu.tieba.c.ad.i(this.r, R.drawable.more_down_1);
            this.e.setBackgroundResource(R.drawable.more_all_1);
        } else {
            color = getResources().getColor(R.color.more_color);
            com.baidu.tieba.c.ad.i(this.l, R.drawable.more_up);
            com.baidu.tieba.c.ad.i(this.m, R.drawable.more_middle);
            com.baidu.tieba.c.ad.i(this.n, R.drawable.more_down);
            com.baidu.tieba.c.ad.i(this.p, R.drawable.more_up);
            com.baidu.tieba.c.ad.i(this.q, R.drawable.more_middle);
            com.baidu.tieba.c.ad.i(this.r, R.drawable.more_down);
            this.e.setBackgroundResource(R.drawable.more_all);
        }
        this.l.setTextColor(color);
        this.m.setTextColor(color);
        this.n.setTextColor(color);
        this.p.setTextColor(color);
        this.q.setTextColor(color);
        this.r.setTextColor(color);
        this.k.setTextColor(color);
        this.o.setTextColor(color);
        this.s.setTextColor(color);
        this.f.setTextColor(color);
    }

    void i() {
        this.h = (RelativeLayout) findViewById(R.id.parent);
        this.i = (RelativeLayout) findViewById(R.id.title);
        this.j = (TextView) findViewById(R.id.title_text);
        this.k = (TextView) findViewById(R.id.quality_text);
        this.l = (RadioButton) findViewById(R.id.image_quality_high);
        this.m = (RadioButton) findViewById(R.id.image_quality_low);
        this.n = (RadioButton) findViewById(R.id.image_quality_close);
        this.o = (TextView) findViewById(R.id.font_size_text);
        this.p = (RadioButton) findViewById(R.id.font_size_big);
        this.q = (RadioButton) findViewById(R.id.font_size_mid);
        this.r = (RadioButton) findViewById(R.id.font_size_small);
        this.s = (TextView) findViewById(R.id.show_photo_text);
        this.c = (RadioGroup) findViewById(R.id.image_quality_radio);
        this.c.setOnCheckedChangeListener(new t(this));
        SpannableString spannableString = new SpannableString(getString(R.string.view_image_quality_high_menu));
        spannableString.setSpan(new AbsoluteSizeSpan(com.baidu.tieba.c.ah.a(this, 12.0f)), 1, spannableString.length(), 18);
        SpannableString spannableString2 = new SpannableString(getString(R.string.view_image_quality_low_menu));
        spannableString2.setSpan(new AbsoluteSizeSpan(com.baidu.tieba.c.ah.a(this, 12.0f)), 1, spannableString2.length(), 18);
        SpannableString spannableString3 = new SpannableString(getString(R.string.view_image_quality_close_menu));
        spannableString3.setSpan(new AbsoluteSizeSpan(com.baidu.tieba.c.ah.a(this, 12.0f)), 2, spannableString3.length(), 18);
        ((RadioButton) findViewById(R.id.image_quality_high)).setText(spannableString);
        ((RadioButton) findViewById(R.id.image_quality_low)).setText(spannableString2);
        ((RadioButton) findViewById(R.id.image_quality_close)).setText(spannableString3);
        this.d = (RadioGroup) findViewById(R.id.font_size_radio);
        this.d.setOnCheckedChangeListener(new u(this));
        v vVar = new v(this);
        this.e = (LinearLayout) findViewById(R.id.show_photo);
        this.e.setOnClickListener(vVar);
        this.f = (TextView) findViewById(R.id.photo_switch);
        this.t = (Button) findViewById(R.id.back);
        this.t.setOnClickListener(new x(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onPause() {
        if (this.g != null) {
            this.g.dismiss();
        }
        super.onPause();
    }

    public static void a(Context context) {
        context.startActivity(new Intent(context, BrowseSettingActivity.class));
    }

    private void j() {
        if (!TiebaApplication.b().ac()) {
            this.c.check(R.id.image_quality_close);
        } else if (TiebaApplication.b().ab() == 1) {
            this.c.check(R.id.image_quality_high);
        } else {
            this.c.check(R.id.image_quality_low);
        }
    }

    private void k() {
        if (TiebaApplication.b().ad() == 1) {
            this.d.check(R.id.font_size_big);
        } else if (TiebaApplication.b().ad() == 2) {
            this.d.check(R.id.font_size_mid);
        } else {
            this.d.check(R.id.font_size_small);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (TiebaApplication.b().s()) {
            this.f.setText(getString(R.string.view_images_open));
        } else {
            this.f.setText(getString(R.string.view_images_close));
        }
    }
}
