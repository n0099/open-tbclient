package com.baidu.tieba.more;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class BrowseSettingActivity extends com.baidu.tieba.e {
    private RadioGroup c = null;
    private RadioGroup d = null;
    private LinearLayout e = null;
    private BdSwitchView f = null;
    private RelativeLayout g = null;
    private RelativeLayout h = null;
    private TextView i = null;
    private TextView j = null;
    private RadioButton k = null;
    private RadioButton l = null;
    private RadioButton m = null;
    private TextView n = null;
    private RadioButton o = null;
    private RadioButton p = null;
    private RadioButton q = null;
    private TextView r = null;
    private ImageView s = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.browse_setting_activity);
        b();
        d();
        c();
        m();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e
    public void b(int i) {
        int color;
        super.b(i);
        com.baidu.tieba.d.ac.b(this.g, i);
        com.baidu.tieba.d.ac.d(this.h, i);
        com.baidu.tieba.d.ac.a(this.s, i);
        com.baidu.tieba.d.ac.f(this.i, i);
        if (i == 1) {
            color = com.baidu.tieba.d.ac.a(i);
            com.baidu.tieba.d.ac.h((View) this.k, (int) R.drawable.more_up_1);
            com.baidu.tieba.d.ac.h((View) this.l, (int) R.drawable.more_middle_1);
            com.baidu.tieba.d.ac.h((View) this.m, (int) R.drawable.more_down_1);
            com.baidu.tieba.d.ac.h((View) this.o, (int) R.drawable.more_up_1);
            com.baidu.tieba.d.ac.h((View) this.p, (int) R.drawable.more_middle_1);
            com.baidu.tieba.d.ac.h((View) this.q, (int) R.drawable.more_down_1);
            this.e.setBackgroundResource(R.drawable.more_all_1);
            this.f.setSwitchStyle(com.baidu.adp.widget.BdSwitchView.e.NIGHT);
        } else {
            color = getResources().getColor(R.color.more_color);
            com.baidu.tieba.d.ac.h((View) this.k, (int) R.drawable.more_up);
            com.baidu.tieba.d.ac.h((View) this.l, (int) R.drawable.more_middle);
            com.baidu.tieba.d.ac.h((View) this.m, (int) R.drawable.more_down);
            com.baidu.tieba.d.ac.h((View) this.o, (int) R.drawable.more_up);
            com.baidu.tieba.d.ac.h((View) this.p, (int) R.drawable.more_middle);
            com.baidu.tieba.d.ac.h((View) this.q, (int) R.drawable.more_down);
            this.e.setBackgroundResource(R.drawable.more_all);
            this.f.setSwitchStyle(com.baidu.adp.widget.BdSwitchView.e.DAY);
        }
        this.k.setTextColor(color);
        this.l.setTextColor(color);
        this.m.setTextColor(color);
        this.o.setTextColor(color);
        this.p.setTextColor(color);
        this.q.setTextColor(color);
        this.j.setTextColor(color);
        this.n.setTextColor(color);
        this.r.setTextColor(color);
    }

    void b() {
        this.g = (RelativeLayout) findViewById(R.id.parent);
        this.h = (RelativeLayout) findViewById(R.id.title);
        this.i = (TextView) findViewById(R.id.title_text);
        this.j = (TextView) findViewById(R.id.quality_text);
        this.k = (RadioButton) findViewById(R.id.image_quality_high);
        this.l = (RadioButton) findViewById(R.id.image_quality_low);
        this.m = (RadioButton) findViewById(R.id.image_quality_close);
        this.n = (TextView) findViewById(R.id.font_size_text);
        this.o = (RadioButton) findViewById(R.id.font_size_big);
        this.p = (RadioButton) findViewById(R.id.font_size_mid);
        this.q = (RadioButton) findViewById(R.id.font_size_small);
        this.r = (TextView) findViewById(R.id.show_photo_text);
        this.c = (RadioGroup) findViewById(R.id.image_quality_radio);
        this.c.setOnCheckedChangeListener(new t(this));
        SpannableString spannableString = new SpannableString(getString(R.string.view_image_quality_high_menu));
        spannableString.setSpan(new AbsoluteSizeSpan(com.baidu.tieba.d.ag.a(this, 12.0f)), 1, spannableString.length(), 18);
        SpannableString spannableString2 = new SpannableString(getString(R.string.view_image_quality_low_menu));
        spannableString2.setSpan(new AbsoluteSizeSpan(com.baidu.tieba.d.ag.a(this, 12.0f)), 1, spannableString2.length(), 18);
        SpannableString spannableString3 = new SpannableString(getString(R.string.view_image_quality_close_menu));
        spannableString3.setSpan(new AbsoluteSizeSpan(com.baidu.tieba.d.ag.a(this, 12.0f)), 2, spannableString3.length(), 18);
        ((RadioButton) findViewById(R.id.image_quality_high)).setText(spannableString);
        ((RadioButton) findViewById(R.id.image_quality_low)).setText(spannableString2);
        ((RadioButton) findViewById(R.id.image_quality_close)).setText(spannableString3);
        this.d = (RadioGroup) findViewById(R.id.font_size_radio);
        this.d.setOnCheckedChangeListener(new u(this));
        this.e = (LinearLayout) findViewById(R.id.show_photo);
        this.e.setClickable(false);
        this.f = (BdSwitchView) findViewById(R.id.show_photo_switch);
        this.f.setOnSwitchStateChangeListener(new v(this));
        this.s = (ImageView) findViewById(R.id.back);
        this.s.setOnClickListener(new w(this));
    }

    public static void a(Context context) {
        context.startActivity(new Intent(context, BrowseSettingActivity.class));
    }

    private void c() {
        if (!TiebaApplication.e().ao()) {
            this.c.check(R.id.image_quality_close);
        } else if (TiebaApplication.e().an() == 1) {
            this.c.check(R.id.image_quality_high);
        } else {
            this.c.check(R.id.image_quality_low);
        }
    }

    private void d() {
        if (TiebaApplication.e().ap() == 1) {
            this.d.check(R.id.font_size_big);
        } else if (TiebaApplication.e().ap() == 2) {
            this.d.check(R.id.font_size_mid);
        } else {
            this.d.check(R.id.font_size_small);
        }
    }

    private void m() {
        if (TiebaApplication.e().y()) {
            this.f.a();
        } else {
            this.f.b();
        }
    }
}
