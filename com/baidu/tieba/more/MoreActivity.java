package com.baidu.tieba.more;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.write.WriteActivity;
/* loaded from: classes.dex */
public class MoreActivity extends com.baidu.tieba.e {
    private AlertDialog M;
    private AlertDialog N;
    private AlertDialog O;
    private AlertDialog P;
    private ImageView R;
    private AlertDialog l;
    private LinearLayout d = null;
    private RelativeLayout e = null;
    private LinearLayout f = null;
    private TextView g = null;
    private LinearLayout h = null;
    private LinearLayout i = null;
    private LinearLayout j = null;
    private TextView k = null;
    private LinearLayout m = null;
    private LinearLayout n = null;
    private LinearLayout o = null;
    private LinearLayout p = null;
    private LinearLayout q = null;
    private LinearLayout r = null;
    private LinearLayout s = null;
    private LinearLayout t = null;
    private TextView u = null;
    private TextView v = null;
    private TextView w = null;
    private TextView x = null;
    private TextView y = null;
    private TextView z = null;
    private TextView A = null;
    private TextView B = null;
    private TextView C = null;
    private TextView D = null;
    private TextView E = null;
    private TextView F = null;
    private TextView G = null;
    private TextView H = null;
    private TextView I = null;
    private TextView J = null;
    TextView c = null;
    private View.OnClickListener K = null;
    private af L = null;
    private String Q = null;
    private ag S = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.more_activity);
        j();
        k();
        u();
        v();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        w();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onResume() {
        super.onResume();
        String x = TiebaApplication.x();
        com.baidu.tieba.c.ag.a(getClass().getName(), "onResume", "id=" + x);
        if (x != null && !x.equals(this.Q)) {
            this.Q = x;
        }
        o();
        if (TiebaApplication.g()) {
            if (x == null || TiebaApplication.B() == null || TiebaApplication.B().equals("BaiduUser")) {
                this.c.setText(R.string.putin_account);
                this.d.setOnClickListener(new y(this));
            } else {
                this.d.setFocusable(false);
                this.d.setClickable(false);
                this.c.setText(TiebaApplication.B());
            }
            ((ImageView) findViewById(R.id.arrow)).setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.e
    public void b(int i) {
        super.b(i);
        com.baidu.tieba.c.ae.c(this.f, i);
        com.baidu.tieba.c.ae.c(this.g, i);
        com.baidu.tieba.c.ae.a(this.e, i);
        if (i == 1) {
            this.d.setBackgroundResource(R.drawable.more_all_1);
            this.h.setBackgroundResource(R.drawable.more_all_1);
            this.i.setBackgroundResource(R.drawable.more_up_1);
            this.r.setBackgroundResource(R.drawable.more_middle_1);
            this.q.setBackgroundResource(R.drawable.more_middle_1);
            this.n.setBackgroundResource(R.drawable.more_down_1);
            this.t.setBackgroundResource(R.drawable.more_all_1);
            this.s.setBackgroundResource(R.drawable.more_up_1);
            this.j.setBackgroundResource(R.drawable.more_down_1);
            this.p.setBackgroundResource(R.drawable.more_up_1);
            this.m.setBackgroundResource(R.drawable.more_middle_1);
            this.o.setBackgroundResource(R.drawable.more_down_1);
        } else {
            this.d.setBackgroundResource(R.drawable.more_all);
            this.h.setBackgroundResource(R.drawable.more_all);
            this.i.setBackgroundResource(R.drawable.more_up);
            this.r.setBackgroundResource(R.drawable.more_middle);
            this.q.setBackgroundResource(R.drawable.more_middle);
            this.n.setBackgroundResource(R.drawable.more_down);
            this.t.setBackgroundResource(R.drawable.more_all);
            this.s.setBackgroundResource(R.drawable.more_up);
            this.j.setBackgroundResource(R.drawable.more_down);
            this.p.setBackgroundResource(R.drawable.more_up);
            this.m.setBackgroundResource(R.drawable.more_middle);
            this.o.setBackgroundResource(R.drawable.more_down);
        }
        a(this.c);
        a(this.u);
        a(this.F);
        a(this.v);
        a(this.I);
        a(this.w);
        a(this.x);
        a(this.J);
        a(this.y);
        a(this.G);
        a(this.z);
        a(this.A);
        a(this.H);
        a(this.B);
        a(this.k);
        a(this.C);
        a(this.D);
        a(this.E);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e
    public void g() {
        a_(-1);
        this.d.setBackgroundResource(0);
        this.h.setBackgroundResource(0);
        this.i.setBackgroundResource(0);
        this.r.setBackgroundResource(0);
        this.q.setBackgroundResource(0);
        this.n.setBackgroundResource(0);
        this.t.setBackgroundResource(0);
        this.s.setBackgroundResource(0);
        this.j.setBackgroundResource(0);
        this.p.setBackgroundResource(0);
        this.m.setBackgroundResource(0);
        this.o.setBackgroundResource(0);
    }

    public void a(TextView textView) {
        if (textView != null) {
            if (this.b == 1) {
                textView.setTextColor(getResources().getColor(R.color.skin_1_common_color));
            } else {
                textView.setTextColor(getResources().getColor(R.color.more_color));
            }
        }
    }

    private void j() {
        this.Q = TiebaApplication.x();
    }

    private void k() {
        this.K = new z(this);
        this.e = (RelativeLayout) findViewById(R.id.parent);
        this.f = (LinearLayout) findViewById(R.id.title);
        this.g = (TextView) findViewById(R.id.title_text);
        this.d = (LinearLayout) findViewById(R.id.account_manager);
        this.c = (TextView) findViewById(R.id.account_name);
        this.d.setOnClickListener(this.K);
        this.h = (LinearLayout) findViewById(R.id.msg_remind);
        this.h.setOnClickListener(this.K);
        this.u = (TextView) findViewById(R.id.msg_remind_text);
        this.i = (LinearLayout) findViewById(R.id.browse_setting);
        this.i.setOnClickListener(this.K);
        SpannableString spannableString = new SpannableString(getString(R.string.browse_setting_spannable));
        spannableString.setSpan(new AbsoluteSizeSpan(com.baidu.tieba.c.ai.a(this, 12.0f)), 6, spannableString.length(), 18);
        this.v = (TextView) findViewById(R.id.browse_setting_text);
        this.v.setText(spannableString);
        this.j = (LinearLayout) findViewById(R.id.share_location_layout);
        this.j.setOnClickListener(this.K);
        this.B = (TextView) findViewById(R.id.share_location_text);
        this.k = (TextView) findViewById(R.id.share_location_on);
        this.m = (LinearLayout) findViewById(R.id.clear_cash);
        this.m.setOnClickListener(this.K);
        this.D = (TextView) findViewById(R.id.clear_cash_text);
        this.o = (LinearLayout) findViewById(R.id.about_tieba);
        this.o.setOnClickListener(this.K);
        this.E = (TextView) findViewById(R.id.about_tieba_text);
        this.t = (LinearLayout) findViewById(R.id.recommend_app);
        this.t.setOnClickListener(this.K);
        this.z = (TextView) findViewById(R.id.recommend_app_text);
        this.p = (LinearLayout) findViewById(R.id.position_paper);
        this.p.setOnClickListener(this.K);
        this.C = (TextView) findViewById(R.id.position_paper_text);
        this.s = (LinearLayout) findViewById(R.id.promoted_message);
        this.s.setOnClickListener(this.K);
        this.A = (TextView) findViewById(R.id.promoted_message_text);
        this.F = (TextView) findViewById(R.id.frequency_time);
        this.H = (TextView) findViewById(R.id.promoted_message_textview);
        this.n = (LinearLayout) findViewById(R.id.upload_image_quality);
        this.n.setOnClickListener(this.K);
        this.y = (TextView) findViewById(R.id.image_quality_text);
        this.G = (TextView) findViewById(R.id.text_upload_image_quality);
        this.x = (TextView) findViewById(R.id.eyeshield_mode_text);
        this.q = (LinearLayout) findViewById(R.id.eyeshield_mode);
        this.J = (TextView) findViewById(R.id.skin_type_on);
        this.q.setOnClickListener(this.K);
        this.r = (LinearLayout) findViewById(R.id.abstract_selection);
        this.I = (TextView) findViewById(R.id.abstract_state_on);
        this.w = (TextView) findViewById(R.id.abstract_text);
        this.r.setOnClickListener(this.K);
        if (!TiebaApplication.b().n()) {
            this.t.setVisibility(8);
        } else {
            this.t.setVisibility(0);
        }
        o();
        q();
        p();
        r();
        s();
        t();
        this.R = (ImageView) findViewById(R.id.new_version_img);
    }

    public void l() {
        if (this.N == null) {
            this.N = new AlertDialog.Builder(this).setTitle(R.string.eyeshield_mode).setItems(R.array.menu_on_off, new ae(this)).create();
        }
        this.N.setCanceledOnTouchOutside(true);
        this.N.show();
    }

    public void m() {
        Activity parent = getParent();
        if (parent != null && (parent instanceof MainTabActivity)) {
            ((MainTabActivity) parent).a(TiebaApplication.b().ag());
        }
    }

    public void n() {
        String x = TiebaApplication.x();
        if (x == null || x.length() <= 0) {
            LoginActivity.a((Activity) this, getString(R.string.login_feedback), true, 1200007);
            return;
        }
        com.baidu.tieba.a.b bVar = new com.baidu.tieba.a.b();
        bVar.a(1);
        WriteActivity.a(this, com.baidu.tieba.a.i.f(), com.baidu.tieba.a.i.e(), bVar);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 1200007:
                    n();
                    return;
                default:
                    return;
            }
        }
    }

    private void o() {
        if (TiebaApplication.b().L() <= 0) {
            this.F.setText(R.string.close);
        } else if (TiebaApplication.b().L() == 30) {
            this.F.setText(R.string._30_second);
        } else if (TiebaApplication.b().L() == 120) {
            this.F.setText(R.string.tow_minute);
        } else {
            this.F.setText(R.string.five_minute);
        }
    }

    public void p() {
        if (TiebaApplication.b().N()) {
            this.H.setText(R.string.promote_message_on);
        } else {
            this.H.setText(R.string.promote_message_off);
        }
    }

    public void q() {
        switch (TiebaApplication.b().ab()) {
            case 1:
                this.G.setText(getString(R.string.image_quality_high));
                return;
            case 2:
                this.G.setText(getString(R.string.image_quality_mid));
                return;
            case 3:
                this.G.setText(getString(R.string.image_quality_low));
                return;
            default:
                return;
        }
    }

    public void r() {
        if (TiebaApplication.b().af()) {
            this.I.setText(R.string.abstract_on);
        } else {
            this.I.setText(R.string.abstract_off);
        }
    }

    public void s() {
        if (TiebaApplication.b().ag() == 1) {
            this.J.setText(R.string.on);
        } else {
            this.J.setText(R.string.off);
        }
    }

    public void t() {
        if (TiebaApplication.b().l()) {
            this.k.setText(R.string.on);
        } else {
            this.k.setText(R.string.off);
        }
    }

    public void i() {
        if (this.M != null) {
            this.M.dismiss();
        }
        if (this.O != null) {
            this.O.dismiss();
        }
        if (this.N != null) {
            this.N.dismiss();
        }
        if (this.P != null) {
            this.P.dismiss();
        }
        if (this.l != null) {
            this.l.dismiss();
        }
    }

    public void u() {
        if (TiebaApplication.aC()) {
            this.R.setVisibility(0);
        } else {
            this.R.setVisibility(8);
        }
    }

    private void v() {
        this.S = new ag(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.baidu.tieba.broadcast.newversion");
        registerReceiver(this.S, intentFilter);
    }

    private void w() {
        if (this.S != null) {
            unregisterReceiver(this.S);
        }
    }
}
