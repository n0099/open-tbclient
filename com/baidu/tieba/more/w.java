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
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class w extends com.baidu.adp.a.e {

    /* renamed from: a  reason: collision with root package name */
    private BrowseSettingActivity f2023a;
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

    public w(BrowseSettingActivity browseSettingActivity) {
        super(browseSettingActivity);
        this.f2023a = null;
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
        this.p = new x(this);
        this.q = new y(this);
        this.r = new z(this);
        this.s = new aa(this);
        this.t = new ab(this);
        this.f2023a = browseSettingActivity;
        s();
        n();
        t();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i) {
        com.baidu.tieba.util.bb.b(this.c, i);
        this.d.b(i);
        this.e.a(i);
        this.f.a(i);
        this.g.a(i);
        this.h.a(i);
        this.i.a(i);
        this.j.a(i);
        if (i == 1) {
            com.baidu.tieba.util.bb.e(this.f, (int) R.drawable.more_up_1);
            com.baidu.tieba.util.bb.e(this.g, (int) R.drawable.more_down_1);
            com.baidu.tieba.util.bb.e(this.e, (int) R.drawable.more_all_1);
            com.baidu.tieba.util.bb.e(this.h, (int) R.drawable.more_all_1);
            com.baidu.tieba.util.bb.e(this.i, (int) R.drawable.more_all_1);
            com.baidu.tieba.util.bb.e(this.j, (int) R.drawable.more_all_1);
            return;
        }
        com.baidu.tieba.util.bb.e(this.f, (int) R.drawable.more_up);
        com.baidu.tieba.util.bb.e(this.g, (int) R.drawable.more_down);
        com.baidu.tieba.util.bb.e(this.e, (int) R.drawable.more_all);
        com.baidu.tieba.util.bb.e(this.h, (int) R.drawable.more_all);
        com.baidu.tieba.util.bb.e(this.i, (int) R.drawable.more_all);
        com.baidu.tieba.util.bb.e(this.j, (int) R.drawable.more_all);
    }

    public SettingTextTipView a() {
        return this.g;
    }

    public SettingTextTipView e() {
        return this.f;
    }

    public SettingTextTipView f() {
        return this.h;
    }

    public SettingTextTipView g() {
        return this.i;
    }

    public SettingTextTipView h() {
        return this.j;
    }

    public void i() {
        v();
        this.k.setCanceledOnTouchOutside(true);
        this.k.show();
    }

    public void j() {
        u();
        this.l.setCanceledOnTouchOutside(true);
        this.l.show();
    }

    public void k() {
        w();
        this.m.setCanceledOnTouchOutside(true);
        this.m.show();
    }

    public void l() {
        x();
        this.n.setCanceledOnTouchOutside(true);
        this.n.show();
    }

    public void m() {
        y();
        this.o.setCanceledOnTouchOutside(true);
        this.o.show();
    }

    private void s() {
        this.f2023a.setContentView(R.layout.browse_setting_activity);
        this.d = (NavigationBar) this.f2023a.findViewById(R.id.view_navigation_bar);
        this.d.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.d.a(this.f2023a.getString(R.string.browse_setting));
        this.e = (SettingTextSwitchView) this.f2023a.findViewById(R.id.eyeshield_mode);
        this.f = (SettingTextTipView) this.f2023a.findViewById(R.id.img_browser);
        this.g = (SettingTextTipView) this.f2023a.findViewById(R.id.img_upload);
        this.h = (SettingTextTipView) this.f2023a.findViewById(R.id.abstract_mode);
        this.i = (SettingTextTipView) this.f2023a.findViewById(R.id.show_image);
        this.j = (SettingTextTipView) this.f2023a.findViewById(R.id.font_size);
        this.c = (RelativeLayout) this.f2023a.findViewById(R.id.parent);
    }

    private void t() {
        this.f.setOnClickListener(this.f2023a);
        this.g.setOnClickListener(this.f2023a);
        this.e.setSwitchStateChangeListener(this.f2023a);
        this.h.setOnClickListener(this.f2023a);
        this.i.setOnClickListener(this.f2023a);
        this.j.setOnClickListener(this.f2023a);
    }

    private void u() {
        if (this.l == null) {
            SpannableString spannableString = new SpannableString(this.f2023a.getString(R.string.view_image_quality_auto_menu));
            spannableString.setSpan(new AbsoluteSizeSpan(UtilHelper.a(this.b, 12.0f)), 4, spannableString.length(), 18);
            SpannableString spannableString2 = new SpannableString(this.b.getString(R.string.view_image_quality_high_menu));
            spannableString2.setSpan(new AbsoluteSizeSpan(UtilHelper.a(this.b, 12.0f)), 1, spannableString2.length(), 18);
            SpannableString spannableString3 = new SpannableString(this.b.getString(R.string.view_image_quality_low_menu));
            spannableString3.setSpan(new AbsoluteSizeSpan(UtilHelper.a(this.b, 12.0f)), 1, spannableString3.length(), 18);
            SpannableString spannableString4 = new SpannableString(this.b.getString(R.string.view_image_quality_close_menu));
            spannableString4.setSpan(new AbsoluteSizeSpan(UtilHelper.a(this.b, 12.0f)), 2, spannableString4.length(), 18);
            this.l = new AlertDialog.Builder(this.f2023a).setTitle(R.string.browser_image_quality).setItems(new CharSequence[]{spannableString, spannableString2, spannableString3, spannableString4}, this.p).create();
        }
    }

    private void v() {
        if (this.k == null) {
            SpannableString spannableString = new SpannableString(this.f2023a.getString(R.string.image_quality_auto_menu));
            spannableString.setSpan(new AbsoluteSizeSpan(UtilHelper.a(this.b, 12.0f)), 4, spannableString.length(), 18);
            SpannableString spannableString2 = new SpannableString(this.f2023a.getString(R.string.image_quality_high_menu));
            spannableString2.setSpan(new AbsoluteSizeSpan(UtilHelper.a((Context) this.f2023a, 12.0f)), 1, spannableString2.length(), 18);
            SpannableString spannableString3 = new SpannableString(this.f2023a.getString(R.string.image_quality_mid_menu));
            SpannableString spannableString4 = new SpannableString(this.f2023a.getString(R.string.image_quality_low_menu));
            spannableString4.setSpan(new AbsoluteSizeSpan(UtilHelper.a((Context) this.f2023a, 12.0f)), 1, spannableString4.length(), 18);
            this.k = new AlertDialog.Builder(this.f2023a).setTitle(R.string.upload_image_quality).setItems(new CharSequence[]{spannableString, spannableString2, spannableString3, spannableString4}, this.q).create();
        }
    }

    private void w() {
        if (this.m == null) {
            int applyDimension = (int) TypedValue.applyDimension(2, 14.0f, this.b.getResources().getDisplayMetrics());
            SpannableString spannableString = new SpannableString(this.f2023a.getString(R.string.is_flowmode_close));
            spannableString.setSpan(new AbsoluteSizeSpan(applyDimension), 3, spannableString.length(), 33);
            SpannableString spannableString2 = new SpannableString(this.f2023a.getString(R.string.is_flowmode_2g3gopen));
            spannableString2.setSpan(new AbsoluteSizeSpan(applyDimension), 12, spannableString2.length(), 33);
            SpannableString spannableString3 = new SpannableString(this.f2023a.getString(R.string.is_flowmode_alwaysopen));
            spannableString3.setSpan(new AbsoluteSizeSpan(applyDimension), 4, spannableString3.length(), 33);
            this.m = new AlertDialog.Builder(this.f2023a).setTitle(R.string.flow_mode_title).setItems(new CharSequence[]{spannableString, spannableString2, spannableString3}, this.r).create();
        }
    }

    private void x() {
        if (this.n == null) {
            this.n = new AlertDialog.Builder(this.f2023a).setTitle(R.string.show_photo).setItems(new CharSequence[]{new SpannableString(this.f2023a.getString(R.string.is_alwaysopen)), new SpannableString(this.f2023a.getString(R.string.is_wifiopen)), new SpannableString(this.f2023a.getString(R.string.is_close))}, this.s).create();
        }
    }

    private void y() {
        if (this.o == null) {
            this.o = new AlertDialog.Builder(this.f2023a).setTitle(R.string.font_size).setItems(new CharSequence[]{new SpannableString(this.f2023a.getString(R.string.font_size_big)), new SpannableString(this.f2023a.getString(R.string.font_size_mid)), new SpannableString(this.f2023a.getString(R.string.font_size_small))}, this.t).create();
        }
    }

    public void b(int i) {
        if (i == 1) {
            if (TiebaApplication.g().as() != 1) {
                TiebaApplication.g().i(i);
                a(i);
                new com.baidu.tieba.account.ah("eyeshield").start();
            } else {
                return;
            }
        } else if (i == 0) {
            if (TiebaApplication.g().as() != 0) {
                TiebaApplication.g().i(i);
                a(i);
            } else {
                return;
            }
        }
        com.baidu.tieba.util.e.a();
    }

    public void n() {
        o();
        z();
        A();
        p();
        r();
        q();
    }

    public void o() {
        if (TiebaApplication.g().as() == 1) {
            this.e.b();
        } else {
            this.e.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        if (!TiebaApplication.g().an()) {
            this.f.setTip(this.b.getString(R.string.view_close));
        } else if (TiebaApplication.g().am() == 1) {
            this.f.setTip(this.b.getString(R.string.view_high));
        } else if (TiebaApplication.g().am() == 2) {
            this.f.setTip(this.b.getString(R.string.view_low));
        } else {
            this.f.setTip(this.b.getString(R.string.view_auto));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        switch (TiebaApplication.g().al()) {
            case 0:
                this.g.setTip(this.b.getString(R.string.view_auto));
                return;
            case 1:
                this.g.setTip(this.b.getString(R.string.view_high));
                return;
            case 2:
                this.g.setTip(this.b.getString(R.string.view_mid));
                return;
            case 3:
                this.g.setTip(this.b.getString(R.string.view_low));
                return;
            default:
                return;
        }
    }

    public void p() {
        switch (TiebaApplication.g().aq()) {
            case 0:
                this.h.setTip(this.b.getString(R.string.is_2g3gopen));
                return;
            case 1:
                this.h.setTip(this.b.getString(R.string.is_close));
                return;
            case 2:
                this.h.setTip(this.b.getString(R.string.is_alwaysopen));
                return;
            default:
                return;
        }
    }

    public void q() {
        switch (TiebaApplication.g().A()) {
            case 0:
                this.i.setTip(this.b.getString(R.string.is_wifiopen));
                return;
            case 1:
                this.i.setTip(this.b.getString(R.string.is_alwaysopen));
                return;
            case 2:
                this.i.setTip(this.b.getString(R.string.is_close));
                return;
            default:
                return;
        }
    }

    public void r() {
        if (TiebaApplication.g().ao() == 1) {
            this.j.setTip(this.b.getString(R.string.font_size_big));
        } else if (TiebaApplication.g().ao() == 2) {
            this.j.setTip(this.b.getString(R.string.font_size_mid));
        } else {
            this.j.setTip(this.b.getString(R.string.font_size_small));
        }
    }
}
