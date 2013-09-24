package com.baidu.tieba.more;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.util.TypedValue;
import android.widget.RelativeLayout;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.as;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class u extends com.baidu.adp.a.d {
    private BrowseSettingActivity b;
    private RelativeLayout c;
    private NavigationBar d;
    private SettingTextSwitchView e;
    private SettingTextTipView f;
    private SettingTextTipView g;
    private SettingTextTipView h;
    private SettingTextTipView i;
    private SettingTextTipView j;
    private AlertDialog k;
    private AlertDialog l;
    private AlertDialog m;
    private AlertDialog n;
    private AlertDialog o;
    private final DialogInterface.OnClickListener p;
    private final DialogInterface.OnClickListener q;
    private final DialogInterface.OnClickListener r;
    private final DialogInterface.OnClickListener s;
    private final DialogInterface.OnClickListener t;

    public u(BrowseSettingActivity browseSettingActivity) {
        super(browseSettingActivity);
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = new v(this);
        this.q = new w(this);
        this.r = new x(this);
        this.s = new y(this);
        this.t = new z(this);
        this.b = browseSettingActivity;
        q();
        l();
        r();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i) {
        as.b(this.c, i);
        this.d.b(i);
        this.e.a(i);
        this.f.a(i);
        this.g.a(i);
        this.h.a(i);
        this.i.a(i);
        this.j.a(i);
        if (i == 1) {
            as.e(this.f, (int) R.drawable.more_up_1);
            as.e(this.g, (int) R.drawable.more_down_1);
            as.e(this.e, (int) R.drawable.more_all_1);
            as.e(this.h, (int) R.drawable.more_all_1);
            as.e(this.i, (int) R.drawable.more_all_1);
            as.e(this.j, (int) R.drawable.more_all_1);
            return;
        }
        as.e(this.f, (int) R.drawable.more_up);
        as.e(this.g, (int) R.drawable.more_down);
        as.e(this.e, (int) R.drawable.more_all);
        as.e(this.h, (int) R.drawable.more_all);
        as.e(this.i, (int) R.drawable.more_all);
        as.e(this.j, (int) R.drawable.more_all);
    }

    public SettingTextTipView b() {
        return this.g;
    }

    public SettingTextTipView c() {
        return this.f;
    }

    public SettingTextTipView d() {
        return this.h;
    }

    public SettingTextTipView e() {
        return this.i;
    }

    public SettingTextTipView f() {
        return this.j;
    }

    public void g() {
        t();
        this.k.setCanceledOnTouchOutside(true);
        this.k.show();
    }

    public void h() {
        s();
        this.l.setCanceledOnTouchOutside(true);
        this.l.show();
    }

    public void i() {
        u();
        this.m.setCanceledOnTouchOutside(true);
        this.m.show();
    }

    public void j() {
        v();
        this.n.setCanceledOnTouchOutside(true);
        this.n.show();
    }

    public void k() {
        w();
        this.o.setCanceledOnTouchOutside(true);
        this.o.show();
    }

    private void q() {
        this.b.setContentView(R.layout.browse_setting_activity);
        this.d = (NavigationBar) this.b.findViewById(R.id.view_navigation_bar);
        this.d.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.d.a(this.b.getString(R.string.browse_setting));
        this.e = (SettingTextSwitchView) this.b.findViewById(R.id.eyeshield_mode);
        this.f = (SettingTextTipView) this.b.findViewById(R.id.img_browser);
        this.g = (SettingTextTipView) this.b.findViewById(R.id.img_upload);
        this.h = (SettingTextTipView) this.b.findViewById(R.id.abstract_mode);
        this.i = (SettingTextTipView) this.b.findViewById(R.id.show_image);
        this.j = (SettingTextTipView) this.b.findViewById(R.id.font_size);
        this.c = (RelativeLayout) this.b.findViewById(R.id.parent);
    }

    private void r() {
        this.f.setOnClickListener(this.b);
        this.g.setOnClickListener(this.b);
        this.e.setSwitchStateChangeListener(this.b);
        this.h.setOnClickListener(this.b);
        this.i.setOnClickListener(this.b);
        this.j.setOnClickListener(this.b);
    }

    private void s() {
        if (this.l == null) {
            SpannableString spannableString = new SpannableString(this.b.getString(R.string.view_image_quality_auto_menu));
            spannableString.setSpan(new AbsoluteSizeSpan(UtilHelper.a(this.f351a, 12.0f)), 4, spannableString.length(), 18);
            SpannableString spannableString2 = new SpannableString(this.f351a.getString(R.string.view_image_quality_high_menu));
            spannableString2.setSpan(new AbsoluteSizeSpan(UtilHelper.a(this.f351a, 12.0f)), 1, spannableString2.length(), 18);
            SpannableString spannableString3 = new SpannableString(this.f351a.getString(R.string.view_image_quality_low_menu));
            spannableString3.setSpan(new AbsoluteSizeSpan(UtilHelper.a(this.f351a, 12.0f)), 1, spannableString3.length(), 18);
            SpannableString spannableString4 = new SpannableString(this.f351a.getString(R.string.view_image_quality_close_menu));
            spannableString4.setSpan(new AbsoluteSizeSpan(UtilHelper.a(this.f351a, 12.0f)), 2, spannableString4.length(), 18);
            this.l = new AlertDialog.Builder(this.b).setTitle(R.string.browser_image_quality).setItems(new CharSequence[]{spannableString, spannableString2, spannableString3, spannableString4}, this.p).create();
        }
    }

    private void t() {
        if (this.k == null) {
            SpannableString spannableString = new SpannableString(this.b.getString(R.string.image_quality_auto_menu));
            spannableString.setSpan(new AbsoluteSizeSpan(UtilHelper.a(this.f351a, 12.0f)), 4, spannableString.length(), 18);
            SpannableString spannableString2 = new SpannableString(this.b.getString(R.string.image_quality_high_menu));
            spannableString2.setSpan(new AbsoluteSizeSpan(UtilHelper.a((Context) this.b, 12.0f)), 1, spannableString2.length(), 18);
            SpannableString spannableString3 = new SpannableString(this.b.getString(R.string.image_quality_mid_menu));
            SpannableString spannableString4 = new SpannableString(this.b.getString(R.string.image_quality_low_menu));
            spannableString4.setSpan(new AbsoluteSizeSpan(UtilHelper.a((Context) this.b, 12.0f)), 1, spannableString4.length(), 18);
            this.k = new AlertDialog.Builder(this.b).setTitle(R.string.upload_image_quality).setItems(new CharSequence[]{spannableString, spannableString2, spannableString3, spannableString4}, this.q).create();
        }
    }

    private void u() {
        if (this.m == null) {
            int applyDimension = (int) TypedValue.applyDimension(2, 14.0f, this.f351a.getResources().getDisplayMetrics());
            SpannableString spannableString = new SpannableString(this.b.getString(R.string.is_flowmode_close));
            spannableString.setSpan(new AbsoluteSizeSpan(applyDimension), 3, spannableString.length(), 33);
            SpannableString spannableString2 = new SpannableString(this.b.getString(R.string.is_flowmode_2g3gopen));
            spannableString2.setSpan(new AbsoluteSizeSpan(applyDimension), 12, spannableString2.length(), 33);
            SpannableString spannableString3 = new SpannableString(this.b.getString(R.string.is_flowmode_alwaysopen));
            spannableString3.setSpan(new AbsoluteSizeSpan(applyDimension), 4, spannableString3.length(), 33);
            this.m = new AlertDialog.Builder(this.b).setTitle(R.string.flow_mode_title).setItems(new CharSequence[]{spannableString, spannableString2, spannableString3}, this.r).create();
        }
    }

    private void v() {
        if (this.n == null) {
            this.n = new AlertDialog.Builder(this.b).setTitle(R.string.show_photo).setItems(new CharSequence[]{new SpannableString(this.b.getString(R.string.is_alwaysopen)), new SpannableString(this.b.getString(R.string.is_wifiopen)), new SpannableString(this.b.getString(R.string.is_close))}, this.s).create();
        }
    }

    private void w() {
        if (this.o == null) {
            this.o = new AlertDialog.Builder(this.b).setTitle(R.string.font_size).setItems(new CharSequence[]{new SpannableString(this.b.getString(R.string.font_size_big)), new SpannableString(this.b.getString(R.string.font_size_mid)), new SpannableString(this.b.getString(R.string.font_size_small))}, this.t).create();
        }
    }

    public void b(int i) {
        if (i == 1) {
            if (TiebaApplication.g().ap() != 1) {
                TiebaApplication.g().i(i);
                a(i);
                new com.baidu.tieba.account.ag("eyeshield").start();
            } else {
                return;
            }
        } else if (i == 0) {
            if (TiebaApplication.g().ap() != 0) {
                TiebaApplication.g().i(i);
                a(i);
            } else {
                return;
            }
        }
        com.baidu.tieba.util.e.a();
    }

    public void l() {
        m();
        x();
        y();
        n();
        p();
        o();
    }

    public void m() {
        if (TiebaApplication.g().ap() == 1) {
            this.e.b();
        } else {
            this.e.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        if (!TiebaApplication.g().al()) {
            this.f.setTip(this.f351a.getString(R.string.view_close));
        } else if (TiebaApplication.g().ak() == 1) {
            this.f.setTip(this.f351a.getString(R.string.view_high));
        } else if (TiebaApplication.g().ak() == 2) {
            this.f.setTip(this.f351a.getString(R.string.view_low));
        } else {
            this.f.setTip(this.f351a.getString(R.string.view_auto));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        switch (TiebaApplication.g().aj()) {
            case 0:
                this.g.setTip(this.f351a.getString(R.string.view_auto));
                return;
            case 1:
                this.g.setTip(this.f351a.getString(R.string.view_high));
                return;
            case 2:
                this.g.setTip(this.f351a.getString(R.string.view_mid));
                return;
            case 3:
                this.g.setTip(this.f351a.getString(R.string.view_low));
                return;
            default:
                return;
        }
    }

    public void n() {
        switch (TiebaApplication.g().an()) {
            case 0:
                this.h.setTip(this.f351a.getString(R.string.is_2g3gopen));
                return;
            case 1:
                this.h.setTip(this.f351a.getString(R.string.is_close));
                return;
            case 2:
                this.h.setTip(this.f351a.getString(R.string.is_alwaysopen));
                return;
            default:
                return;
        }
    }

    public void o() {
        switch (TiebaApplication.g().A()) {
            case 0:
                this.i.setTip(this.f351a.getString(R.string.is_wifiopen));
                return;
            case 1:
                this.i.setTip(this.f351a.getString(R.string.is_alwaysopen));
                return;
            case 2:
                this.i.setTip(this.f351a.getString(R.string.is_close));
                return;
            default:
                return;
        }
    }

    public void p() {
        if (TiebaApplication.g().am() == 1) {
            this.j.setTip(this.f351a.getString(R.string.font_size_big));
        } else if (TiebaApplication.g().am() == 2) {
            this.j.setTip(this.f351a.getString(R.string.font_size_mid));
        } else {
            this.j.setTip(this.f351a.getString(R.string.font_size_small));
        }
    }
}
