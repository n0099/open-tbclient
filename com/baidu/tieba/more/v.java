package com.baidu.tieba.more;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.util.TypedValue;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public final class v extends com.baidu.adp.a.e {
    Handler a;
    private BrowseSettingActivity c;
    private RelativeLayout d;
    private NavigationBar e;
    private SettingTextSwitchView f;
    private SettingTextSwitchView g;
    private SettingTextTipView h;
    private SettingTextTipView i;
    private SettingTextTipView j;
    private SettingTextTipView k;
    private AlertDialog l;
    private AlertDialog m;
    private AlertDialog n;
    private AlertDialog o;
    private AlertDialog p;
    private com.baidu.adp.widget.BdSwitchView.c q;
    private final DialogInterface.OnClickListener r;
    private final DialogInterface.OnClickListener s;
    private final DialogInterface.OnClickListener t;
    private final DialogInterface.OnClickListener u;

    public v(BrowseSettingActivity browseSettingActivity) {
        super(browseSettingActivity);
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
        this.p = null;
        this.q = new w(this);
        this.r = new x(this);
        this.s = new y(this);
        this.t = new z(this);
        this.u = new aa(this);
        this.a = new Handler();
        this.c = browseSettingActivity;
        this.c.setContentView(R.layout.browse_setting_activity);
        this.e = (NavigationBar) this.c.findViewById(R.id.view_navigation_bar);
        this.e.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.e.a(this.c.getString(R.string.browse_setting));
        this.f = (SettingTextSwitchView) this.c.findViewById(R.id.eyeshield_mode);
        this.g = (SettingTextSwitchView) this.c.findViewById(R.id.img_thrift_setting);
        this.h = (SettingTextTipView) this.c.findViewById(R.id.img_browser);
        this.i = (SettingTextTipView) this.c.findViewById(R.id.img_upload);
        this.j = (SettingTextTipView) this.c.findViewById(R.id.show_image);
        this.k = (SettingTextTipView) this.c.findViewById(R.id.font_size);
        this.d = (RelativeLayout) this.c.findViewById(R.id.parent);
        if (TiebaApplication.g().ae() == 1) {
            this.f.b();
        } else {
            this.f.a();
        }
        p();
        q();
        o();
        n();
        a(false);
        this.h.setOnClickListener(this.c);
        this.i.setOnClickListener(this.c);
        this.f.setSwitchStateChangeListener(this.c);
        this.j.setOnClickListener(this.c);
        this.k.setOnClickListener(this.c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(int i) {
        this.e.b(i);
        this.f.a(i);
        this.g.a(i);
        this.h.a(i);
        this.i.a(i);
        this.j.a(i);
        this.k.a(i);
        this.c.getLayoutMode().a(i == 1);
        this.c.getLayoutMode().a(this.d);
    }

    public final SettingTextTipView a() {
        return this.i;
    }

    public final SettingTextTipView d() {
        return this.h;
    }

    public final SettingTextTipView e() {
        return this.j;
    }

    public final SettingTextTipView f() {
        return this.k;
    }

    public final void g() {
        if (this.l == null) {
            SpannableString spannableString = new SpannableString(this.c.getString(R.string.image_quality_auto_menu));
            spannableString.setSpan(new AbsoluteSizeSpan(BdUtilHelper.a(this.b, 12.0f)), 5, spannableString.length(), 18);
            SpannableString spannableString2 = new SpannableString(this.c.getString(R.string.image_quality_high_menu));
            spannableString2.setSpan(new AbsoluteSizeSpan(BdUtilHelper.a((Context) this.c, 12.0f)), 1, spannableString2.length(), 18);
            SpannableString spannableString3 = new SpannableString(this.c.getString(R.string.image_quality_mid_menu));
            SpannableString spannableString4 = new SpannableString(this.c.getString(R.string.image_quality_low_menu));
            spannableString4.setSpan(new AbsoluteSizeSpan(BdUtilHelper.a((Context) this.c, 12.0f)), 1, spannableString4.length(), 18);
            this.l = new AlertDialog.Builder(this.c).setTitle(R.string.upload_image_quality).setItems(new CharSequence[]{spannableString, spannableString2, spannableString3, spannableString4}, this.s).create();
        }
        this.l.setCanceledOnTouchOutside(true);
        this.l.show();
    }

    public final void h() {
        if (this.m == null) {
            SpannableString spannableString = new SpannableString(this.c.getString(R.string.view_image_quality_auto_menu));
            spannableString.setSpan(new AbsoluteSizeSpan(BdUtilHelper.a(this.b, 12.0f)), 5, spannableString.length(), 18);
            SpannableString spannableString2 = new SpannableString(this.b.getString(R.string.view_image_quality_high_menu));
            spannableString2.setSpan(new AbsoluteSizeSpan(BdUtilHelper.a(this.b, 12.0f)), 1, spannableString2.length(), 18);
            SpannableString spannableString3 = new SpannableString(this.b.getString(R.string.view_image_quality_low_menu));
            spannableString3.setSpan(new AbsoluteSizeSpan(BdUtilHelper.a(this.b, 12.0f)), 1, spannableString3.length(), 18);
            SpannableString spannableString4 = new SpannableString(this.b.getString(R.string.view_image_quality_close_menu));
            spannableString4.setSpan(new AbsoluteSizeSpan(BdUtilHelper.a(this.b, 12.0f)), 2, spannableString4.length(), 18);
            this.m = new AlertDialog.Builder(this.c).setTitle(R.string.browser_image_quality).setItems(new CharSequence[]{spannableString, spannableString2, spannableString3, spannableString4}, this.r).create();
        }
        this.m.setCanceledOnTouchOutside(true);
        this.m.show();
    }

    public final void i() {
        if (this.n == null) {
            int applyDimension = (int) TypedValue.applyDimension(2, 14.0f, this.b.getResources().getDisplayMetrics());
            SpannableString spannableString = new SpannableString(this.c.getString(R.string.is_flowmode_close));
            spannableString.setSpan(new AbsoluteSizeSpan(applyDimension), 3, spannableString.length(), 33);
            SpannableString spannableString2 = new SpannableString(this.c.getString(R.string.is_flowmode_2g3gopen));
            spannableString2.setSpan(new AbsoluteSizeSpan(applyDimension), 12, spannableString2.length(), 33);
            SpannableString spannableString3 = new SpannableString(this.c.getString(R.string.is_flowmode_alwaysopen));
            spannableString3.setSpan(new AbsoluteSizeSpan(applyDimension), 4, spannableString3.length(), 33);
        }
        this.n.setCanceledOnTouchOutside(true);
        this.n.show();
    }

    public final void j() {
        if (this.o == null) {
            SpannableString spannableString = new SpannableString(this.c.getString(R.string.is_wifiopen_dialog));
            spannableString.setSpan(new AbsoluteSizeSpan(BdUtilHelper.a(this.b, 12.0f)), 5, spannableString.length(), 18);
            this.o = new AlertDialog.Builder(this.c).setTitle(R.string.show_photo).setItems(new CharSequence[]{spannableString, new SpannableString(this.c.getString(R.string.is_alwaysopen)), new SpannableString(this.c.getString(R.string.is_close))}, this.t).create();
        }
        this.o.setCanceledOnTouchOutside(true);
        this.o.show();
    }

    public final void k() {
        if (this.p == null) {
            this.p = new AlertDialog.Builder(this.c).setTitle(R.string.font_size).setItems(new CharSequence[]{new SpannableString(this.c.getString(R.string.font_size_big)), new SpannableString(this.c.getString(R.string.font_size_mid)), new SpannableString(this.c.getString(R.string.font_size_small))}, this.u).create();
        }
        this.p.setCanceledOnTouchOutside(true);
        this.p.show();
    }

    public final void b(int i) {
        if (i == 1) {
            if (TiebaApplication.g().ae() != 1) {
                TiebaApplication.g().e(i);
                a(i);
                new com.baidu.tieba.account.ax("eyeshield").start();
            } else {
                return;
            }
        } else if (i == 0) {
            if (TiebaApplication.g().ae() != 0) {
                TiebaApplication.g().e(i);
                a(i);
            } else {
                return;
            }
        }
        com.baidu.tieba.util.n.a();
    }

    public final void l() {
        p();
        q();
        n();
    }

    private void a(boolean z) {
        this.g.setSwitchStateChangeListener(null);
        if (com.baidu.tieba.h.a.a().h()) {
            this.g.b(z);
        } else {
            this.g.a(z);
        }
        this.g.setSwitchStateChangeListener(this.q);
    }

    public final void m() {
        a(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        if (!com.baidu.tieba.h.a.a().f()) {
            this.h.setTip(this.b.getString(R.string.view_close));
        } else if (com.baidu.tieba.h.a.a().g() == 1) {
            this.h.setTip(this.b.getString(R.string.view_high));
        } else if (com.baidu.tieba.h.a.a().g() == 2) {
            this.h.setTip(this.b.getString(R.string.view_low));
        } else {
            this.h.setTip(this.b.getString(R.string.view_auto));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        switch (com.baidu.tieba.h.a.a().e()) {
            case 0:
                this.i.setTip(this.b.getString(R.string.view_auto));
                return;
            case 1:
                this.i.setTip(this.b.getString(R.string.view_high));
                return;
            case 2:
                this.i.setTip(this.b.getString(R.string.view_mid));
                return;
            case 3:
                this.i.setTip(this.b.getString(R.string.view_low));
                return;
            default:
                return;
        }
    }

    public final void n() {
        switch (com.baidu.tieba.h.a.a().c()) {
            case 0:
                this.j.setTip(this.b.getString(R.string.is_wifiopen));
                return;
            case 1:
                this.j.setTip(this.b.getString(R.string.is_alwaysopen));
                return;
            case 2:
                this.j.setTip(this.b.getString(R.string.is_close));
                return;
            default:
                return;
        }
    }

    public final void o() {
        if (TiebaApplication.g().aa() == 1) {
            this.k.setTip(this.b.getString(R.string.font_size_big));
        } else if (TiebaApplication.g().aa() == 2) {
            this.k.setTip(this.b.getString(R.string.font_size_mid));
        } else {
            this.k.setTip(this.b.getString(R.string.font_size_small));
        }
    }
}
