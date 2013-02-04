package com.baidu.tieba.more;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.write.WriteActivity;
/* loaded from: classes.dex */
public class MoreActivity extends com.baidu.tieba.e {
    private AlertDialog A;
    private AlertDialog B;
    private AlertDialog h;
    private AlertDialog x;
    private AlertDialog y;
    private Dialog z;
    private LinearLayout c = null;
    private LinearLayout d = null;
    private LinearLayout e = null;
    private LinearLayout f = null;
    private TextView g = null;
    private LinearLayout i = null;
    private LinearLayout j = null;
    private LinearLayout k = null;
    private LinearLayout l = null;
    private LinearLayout m = null;
    private LinearLayout n = null;
    private LinearLayout o = null;
    private LinearLayout p = null;
    private TextView q = null;
    private TextView r = null;
    private TextView s = null;
    private TextView t = null;
    private TextView u = null;
    TextView b = null;
    private View.OnClickListener v = null;
    private ag w = null;
    private String C = null;

    private void h() {
        this.C = TiebaApplication.u();
    }

    private void i() {
        this.v = new y(this);
        this.c = (LinearLayout) findViewById(R.id.account_manager);
        this.b = (TextView) findViewById(R.id.account_name);
        this.c.setOnClickListener(this.v);
        this.d = (LinearLayout) findViewById(R.id.msg_remind);
        this.d.setOnClickListener(this.v);
        this.e = (LinearLayout) findViewById(R.id.browse_setting);
        this.e.setOnClickListener(this.v);
        SpannableString spannableString = new SpannableString(getString(R.string.browse_setting_spannable));
        spannableString.setSpan(new AbsoluteSizeSpan(com.baidu.tieba.c.ag.a((Context) this, 12.0f)), 6, spannableString.length(), 18);
        ((TextView) findViewById(R.id.browse_setting_text)).setText(spannableString);
        this.f = (LinearLayout) findViewById(R.id.share_location_layout);
        this.f.setOnClickListener(this.v);
        this.g = (TextView) findViewById(R.id.share_location_on);
        this.i = (LinearLayout) findViewById(R.id.clear_cash);
        this.i.setOnClickListener(this.v);
        this.k = (LinearLayout) findViewById(R.id.about_bieta);
        this.k.setOnClickListener(this.v);
        this.p = (LinearLayout) findViewById(R.id.recommend_app);
        this.p.setOnClickListener(this.v);
        this.l = (LinearLayout) findViewById(R.id.position_paper);
        this.l.setOnClickListener(this.v);
        this.o = (LinearLayout) findViewById(R.id.promoted_message);
        this.o.setOnClickListener(this.v);
        this.q = (TextView) findViewById(R.id.frequency_time);
        this.s = (TextView) findViewById(R.id.promoted_message_textview);
        this.j = (LinearLayout) findViewById(R.id.upload_image_quality);
        this.j.setOnClickListener(this.v);
        this.r = (TextView) findViewById(R.id.text_upload_image_quality);
        this.m = (LinearLayout) findViewById(R.id.eyeshield_mode);
        this.u = (TextView) findViewById(R.id.eyeshield_mode_on);
        this.m.setOnClickListener(this.v);
        this.n = (LinearLayout) findViewById(R.id.abstract_selection);
        this.t = (TextView) findViewById(R.id.abstract_state_on);
        this.n.setOnClickListener(this.v);
        if (TiebaApplication.a().l()) {
            this.p.setVisibility(0);
        } else {
            this.p.setVisibility(8);
        }
        m();
        o();
        n();
        p();
        q();
        r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (this.y == null) {
            this.y = new AlertDialog.Builder(this).setTitle(R.string.eyeshield_mode).setItems(R.array.menu_view_brightness, new ad(this)).create();
        }
        this.y.setCanceledOnTouchOutside(true);
        this.y.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (this.z == null) {
            this.z = new Dialog(this, R.style.common_alert_dialog);
            this.z.setCanceledOnTouchOutside(true);
            this.z.setCancelable(true);
            View inflate = getLayoutInflater().inflate(R.layout.dialog_tip_bright_setting, (ViewGroup) null);
            this.z.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.z.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.tieba.c.ag.a((Context) this) * 0.9d);
            this.z.getWindow().setAttributes(attributes);
            ((Button) inflate.findViewById(R.id.dialog_button_cancel)).setOnClickListener(new ae(this));
            ((Button) inflate.findViewById(R.id.dialog_button_ok)).setOnClickListener(new af(this));
        }
        this.z.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        String u = TiebaApplication.u();
        if (u == null || u.length() <= 0) {
            LoginActivity.a((Activity) this, getString(R.string.login_feedback), true, 1200007);
            return;
        }
        com.baidu.tieba.a.b bVar = new com.baidu.tieba.a.b();
        bVar.a(1);
        WriteActivity.a(this, com.baidu.tieba.a.h.f(), com.baidu.tieba.a.h.e(), bVar);
    }

    private void m() {
        if (TiebaApplication.a().G() <= 0) {
            this.q.setText(R.string.close);
        } else if (TiebaApplication.a().G() == 30) {
            this.q.setText(R.string._30_second);
        } else if (TiebaApplication.a().G() == 120) {
            this.q.setText(R.string.tow_minute);
        } else {
            this.q.setText(R.string.five_minute);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        if (TiebaApplication.a().I()) {
            this.s.setText(R.string.promote_message_on);
        } else {
            this.s.setText(R.string.promote_message_off);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        switch (TiebaApplication.a().X()) {
            case 1:
                this.r.setText(getString(R.string.image_quality_high));
                return;
            case 2:
                this.r.setText(getString(R.string.image_quality_mid));
                return;
            case 3:
                this.r.setText(getString(R.string.image_quality_low));
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        if (TiebaApplication.a().ab()) {
            this.t.setText(R.string.abstract_on);
        } else {
            this.t.setText(R.string.abstract_off);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        if (TiebaApplication.a().ac() == 0.0f) {
            this.u.setText(R.string.view_brightness_normal);
        } else if (TiebaApplication.a().ac() == 0.4f) {
            this.u.setText(R.string.view_brightness_middle);
        } else if (TiebaApplication.a().ac() == 0.05f) {
            this.u.setText(R.string.view_brightness_low);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        if (TiebaApplication.a().j()) {
            this.g.setText(R.string.on);
        } else {
            this.g.setText(R.string.off);
        }
    }

    public void g() {
        if (this.x != null) {
            this.x.dismiss();
        }
        if (this.A != null) {
            this.A.dismiss();
        }
        if (this.y != null) {
            this.y.dismiss();
        }
        if (this.B != null) {
            this.B.dismiss();
        }
        if (this.h != null) {
            this.h.dismiss();
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 1200007:
                    l();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.more_activity);
        h();
        i();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onResume() {
        super.onResume();
        String u = TiebaApplication.u();
        com.baidu.tieba.c.ae.a(getClass().getName(), "onResume", "id=" + u);
        if (u != null && !u.equals(this.C)) {
            this.C = u;
        }
        m();
        if (TiebaApplication.f()) {
            if (u == null || TiebaApplication.x() == null || TiebaApplication.x().equals("BaiduUser")) {
                this.b.setText(R.string.putin_account);
                this.c.setOnClickListener(new x(this));
            } else {
                this.c.setFocusable(false);
                this.c.setClickable(false);
                this.b.setText(TiebaApplication.x());
            }
            ((ImageView) findViewById(R.id.arrow)).setVisibility(8);
        }
    }
}
