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
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.ao;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class BrowseSettingActivity extends com.baidu.tieba.g {

    /* renamed from: a  reason: collision with root package name */
    private RadioGroup f1427a = null;
    private RadioGroup b = null;
    private LinearLayout c = null;
    private BdSwitchView d = null;
    private RelativeLayout e = null;
    private RelativeLayout f = null;
    private TextView g = null;
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
    @Override // com.baidu.tieba.g, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.browse_setting_activity);
        b();
        d();
        c();
        k();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g
    public void a(int i) {
        int color;
        super.a(i);
        ao.b(this.e, i);
        ao.d(this.f, i);
        ao.a(this.s, i);
        ao.f(this.g, i);
        if (i == 1) {
            color = ao.a(i);
            ao.g((View) this.k, (int) R.drawable.more_up_1);
            ao.g((View) this.l, (int) R.drawable.more_middle_1);
            ao.g((View) this.m, (int) R.drawable.more_down_1);
            ao.g((View) this.o, (int) R.drawable.more_up_1);
            ao.g((View) this.p, (int) R.drawable.more_middle_1);
            ao.g((View) this.q, (int) R.drawable.more_down_1);
            this.c.setBackgroundResource(R.drawable.more_all_1);
            this.d.setSwitchStyle(BdSwitchView.SwitchStyle.NIGHT);
        } else {
            color = getResources().getColor(R.color.more_color);
            ao.g((View) this.k, (int) R.drawable.more_up);
            ao.g((View) this.l, (int) R.drawable.more_middle);
            ao.g((View) this.m, (int) R.drawable.more_down);
            ao.g((View) this.o, (int) R.drawable.more_up);
            ao.g((View) this.p, (int) R.drawable.more_middle);
            ao.g((View) this.q, (int) R.drawable.more_down);
            this.c.setBackgroundResource(R.drawable.more_all);
            this.d.setSwitchStyle(BdSwitchView.SwitchStyle.DAY);
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
        this.e = (RelativeLayout) findViewById(R.id.parent);
        this.f = (RelativeLayout) findViewById(R.id.title);
        this.g = (TextView) findViewById(R.id.title_text);
        this.j = (TextView) findViewById(R.id.quality_text);
        this.k = (RadioButton) findViewById(R.id.image_quality_high);
        this.l = (RadioButton) findViewById(R.id.image_quality_low);
        this.m = (RadioButton) findViewById(R.id.image_quality_close);
        this.n = (TextView) findViewById(R.id.font_size_text);
        this.o = (RadioButton) findViewById(R.id.font_size_big);
        this.p = (RadioButton) findViewById(R.id.font_size_mid);
        this.q = (RadioButton) findViewById(R.id.font_size_small);
        this.r = (TextView) findViewById(R.id.show_photo_text);
        this.f1427a = (RadioGroup) findViewById(R.id.image_quality_radio);
        this.f1427a.setOnCheckedChangeListener(new u(this));
        SpannableString spannableString = new SpannableString(getString(R.string.view_image_quality_high_menu));
        spannableString.setSpan(new AbsoluteSizeSpan(UtilHelper.a((Context) this, 12.0f)), 1, spannableString.length(), 18);
        SpannableString spannableString2 = new SpannableString(getString(R.string.view_image_quality_low_menu));
        spannableString2.setSpan(new AbsoluteSizeSpan(UtilHelper.a((Context) this, 12.0f)), 1, spannableString2.length(), 18);
        SpannableString spannableString3 = new SpannableString(getString(R.string.view_image_quality_close_menu));
        spannableString3.setSpan(new AbsoluteSizeSpan(UtilHelper.a((Context) this, 12.0f)), 2, spannableString3.length(), 18);
        ((RadioButton) findViewById(R.id.image_quality_high)).setText(spannableString);
        ((RadioButton) findViewById(R.id.image_quality_low)).setText(spannableString2);
        ((RadioButton) findViewById(R.id.image_quality_close)).setText(spannableString3);
        this.b = (RadioGroup) findViewById(R.id.font_size_radio);
        this.b.setOnCheckedChangeListener(new v(this));
        this.c = (LinearLayout) findViewById(R.id.show_photo);
        this.c.setClickable(false);
        this.d = (BdSwitchView) findViewById(R.id.show_photo_switch);
        this.d.setOnSwitchStateChangeListener(new w(this));
        this.s = (ImageView) findViewById(R.id.back);
        this.s.setOnClickListener(new x(this));
    }

    public static void a(Context context) {
        context.startActivity(new Intent(context, BrowseSettingActivity.class));
    }

    private void c() {
        if (!TiebaApplication.g().aj()) {
            this.f1427a.check(R.id.image_quality_close);
        } else if (TiebaApplication.g().ai() == 1) {
            this.f1427a.check(R.id.image_quality_high);
        } else {
            this.f1427a.check(R.id.image_quality_low);
        }
    }

    private void d() {
        if (TiebaApplication.g().ak() == 1) {
            this.b.check(R.id.font_size_big);
        } else if (TiebaApplication.g().ak() == 2) {
            this.b.check(R.id.font_size_mid);
        } else {
            this.b.check(R.id.font_size_small);
        }
    }

    private void k() {
        if (TiebaApplication.g().C()) {
            this.d.a();
        } else {
            this.d.b();
        }
    }
}
