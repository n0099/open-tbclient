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
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
public class BrowseSettingActivity extends com.baidu.tieba.e {
    private AlertDialog f;
    private RadioGroup b = null;
    private RadioGroup c = null;
    private LinearLayout d = null;
    private TextView e = null;
    private Button g = null;

    public static void a(Context context) {
        context.startActivity(new Intent(context, BrowseSettingActivity.class));
    }

    private void h() {
        if (!TiebaApplication.a().Z()) {
            this.b.check(R.id.image_quality_close);
        } else if (TiebaApplication.a().Y() == 1) {
            this.b.check(R.id.image_quality_high);
        } else {
            this.b.check(R.id.image_quality_low);
        }
    }

    private void i() {
        if (TiebaApplication.a().aa() == 1) {
            this.c.check(R.id.font_size_big);
        } else if (TiebaApplication.a().aa() == 2) {
            this.c.check(R.id.font_size_mid);
        } else {
            this.c.check(R.id.font_size_small);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (TiebaApplication.a().q()) {
            this.e.setText(getString(R.string.view_images_open));
        } else {
            this.e.setText(getString(R.string.view_images_close));
        }
    }

    void g() {
        this.b = (RadioGroup) findViewById(R.id.image_quality_radio);
        this.b.setOnCheckedChangeListener(new s(this));
        SpannableString spannableString = new SpannableString(getString(R.string.view_image_quality_high_menu));
        spannableString.setSpan(new AbsoluteSizeSpan(com.baidu.tieba.c.ag.a((Context) this, 12.0f)), 1, spannableString.length(), 18);
        SpannableString spannableString2 = new SpannableString(getString(R.string.view_image_quality_low_menu));
        spannableString2.setSpan(new AbsoluteSizeSpan(com.baidu.tieba.c.ag.a((Context) this, 12.0f)), 1, spannableString2.length(), 18);
        SpannableString spannableString3 = new SpannableString(getString(R.string.view_image_quality_close_menu));
        spannableString3.setSpan(new AbsoluteSizeSpan(com.baidu.tieba.c.ag.a((Context) this, 12.0f)), 2, spannableString3.length(), 18);
        ((RadioButton) findViewById(R.id.image_quality_high)).setText(spannableString);
        ((RadioButton) findViewById(R.id.image_quality_low)).setText(spannableString2);
        ((RadioButton) findViewById(R.id.image_quality_close)).setText(spannableString3);
        this.c = (RadioGroup) findViewById(R.id.font_size_radio);
        this.c.setOnCheckedChangeListener(new t(this));
        u uVar = new u(this);
        this.d = (LinearLayout) findViewById(R.id.show_photo);
        this.d.setOnClickListener(uVar);
        this.e = (TextView) findViewById(R.id.photo_switch);
        this.g = (Button) findViewById(R.id.back);
        this.g.setOnClickListener(new w(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.browse_setting_activity);
        g();
        i();
        h();
        j();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onPause() {
        if (this.f != null) {
            this.f.dismiss();
        }
        super.onPause();
    }
}
