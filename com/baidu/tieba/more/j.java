package com.baidu.tieba.more;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.util.TypedValue;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
/* loaded from: classes.dex */
public class j extends com.baidu.adp.base.f {
    Handler a;
    private BrowseSettingActivity b;
    private RelativeLayout c;
    private NavigationBar d;
    private SettingTextSwitchView e;
    private SettingTextSwitchView f;
    private TbSettingTextTipView g;
    private TbSettingTextTipView h;
    private TbSettingTextTipView i;
    private TbSettingTextTipView j;
    private AlertDialog k;
    private AlertDialog l;
    private final AlertDialog m;
    private AlertDialog n;
    private AlertDialog o;
    private final com.baidu.adp.widget.BdSwitchView.c p;
    private final DialogInterface.OnClickListener q;
    private final DialogInterface.OnClickListener r;
    private final DialogInterface.OnClickListener s;
    private final DialogInterface.OnClickListener t;

    public j(BrowseSettingActivity browseSettingActivity) {
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
        this.p = new k(this);
        this.q = new l(this);
        this.r = new m(this);
        this.s = new n(this);
        this.t = new o(this);
        this.a = new Handler();
        this.b = browseSettingActivity;
        q();
        k();
        r();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i) {
        this.d.c(i);
        this.e.a(i);
        this.f.a(i);
        this.b.getLayoutMode().a(i == 1);
        this.b.getLayoutMode().a((View) this.c);
    }

    public TbSettingTextTipView a() {
        return this.h;
    }

    public TbSettingTextTipView b() {
        return this.g;
    }

    public TbSettingTextTipView c() {
        return null;
    }

    public TbSettingTextTipView d() {
        return this.i;
    }

    public TbSettingTextTipView e() {
        return this.j;
    }

    public void f() {
        t();
        this.k.setCanceledOnTouchOutside(true);
        this.k.show();
    }

    public void g() {
        s();
        this.l.setCanceledOnTouchOutside(true);
        this.l.show();
    }

    public void h() {
        u();
        this.m.setCanceledOnTouchOutside(true);
        this.m.show();
    }

    public void i() {
        v();
        this.n.setCanceledOnTouchOutside(true);
        this.n.show();
    }

    public void j() {
        w();
        this.o.setCanceledOnTouchOutside(true);
        this.o.show();
    }

    private void q() {
        this.b.setContentView(com.baidu.tieba.w.browse_setting_activity);
        this.d = (NavigationBar) this.b.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.d.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.d.a(this.b.getString(com.baidu.tieba.y.browse_setting));
        this.e = (SettingTextSwitchView) this.b.findViewById(com.baidu.tieba.v.eyeshield_mode);
        this.f = (SettingTextSwitchView) this.b.findViewById(com.baidu.tieba.v.img_thrift_setting);
        this.g = (TbSettingTextTipView) this.b.findViewById(com.baidu.tieba.v.img_browser);
        this.h = (TbSettingTextTipView) this.b.findViewById(com.baidu.tieba.v.img_upload);
        this.i = (TbSettingTextTipView) this.b.findViewById(com.baidu.tieba.v.show_image);
        this.j = (TbSettingTextTipView) this.b.findViewById(com.baidu.tieba.v.font_size);
        this.c = (RelativeLayout) this.b.findViewById(com.baidu.tieba.v.parent);
    }

    private void r() {
        this.g.setOnClickListener(this.b);
        this.h.setOnClickListener(this.b);
        this.e.setSwitchStateChangeListener(this.b);
        this.i.setOnClickListener(this.b);
        this.j.setOnClickListener(this.b);
    }

    private void s() {
        if (this.l == null) {
            SpannableString spannableString = new SpannableString(this.b.getString(com.baidu.tieba.y.view_image_quality_auto_menu));
            spannableString.setSpan(new AbsoluteSizeSpan(com.baidu.adp.lib.util.j.a(this.mContext, 12.0f)), 5, spannableString.length(), 18);
            SpannableString spannableString2 = new SpannableString(this.mContext.getString(com.baidu.tieba.y.view_image_quality_high_menu));
            spannableString2.setSpan(new AbsoluteSizeSpan(com.baidu.adp.lib.util.j.a(this.mContext, 12.0f)), 1, spannableString2.length(), 18);
            SpannableString spannableString3 = new SpannableString(this.mContext.getString(com.baidu.tieba.y.view_image_quality_low_menu));
            spannableString3.setSpan(new AbsoluteSizeSpan(com.baidu.adp.lib.util.j.a(this.mContext, 12.0f)), 1, spannableString3.length(), 18);
            SpannableString spannableString4 = new SpannableString(this.mContext.getString(com.baidu.tieba.y.view_image_quality_close_menu));
            spannableString4.setSpan(new AbsoluteSizeSpan(com.baidu.adp.lib.util.j.a(this.mContext, 12.0f)), 2, spannableString4.length(), 18);
            this.l = new AlertDialog.Builder(this.b).setTitle(com.baidu.tieba.y.browser_image_quality).setItems(new CharSequence[]{spannableString, spannableString2, spannableString3, spannableString4}, this.q).create();
        }
    }

    private void t() {
        if (this.k == null) {
            SpannableString spannableString = new SpannableString(this.b.getString(com.baidu.tieba.y.image_quality_auto_menu));
            spannableString.setSpan(new AbsoluteSizeSpan(com.baidu.adp.lib.util.j.a(this.mContext, 12.0f)), 5, spannableString.length(), 18);
            SpannableString spannableString2 = new SpannableString(this.b.getString(com.baidu.tieba.y.image_quality_high_menu));
            spannableString2.setSpan(new AbsoluteSizeSpan(com.baidu.adp.lib.util.j.a((Context) this.b, 12.0f)), 1, spannableString2.length(), 18);
            SpannableString spannableString3 = new SpannableString(this.b.getString(com.baidu.tieba.y.image_quality_mid_menu));
            SpannableString spannableString4 = new SpannableString(this.b.getString(com.baidu.tieba.y.image_quality_low_menu));
            spannableString4.setSpan(new AbsoluteSizeSpan(com.baidu.adp.lib.util.j.a((Context) this.b, 12.0f)), 1, spannableString4.length(), 18);
            this.k = new AlertDialog.Builder(this.b).setTitle(com.baidu.tieba.y.upload_image_quality).setItems(new CharSequence[]{spannableString, spannableString2, spannableString3, spannableString4}, this.r).create();
        }
    }

    private void u() {
        if (this.m == null) {
            int applyDimension = (int) TypedValue.applyDimension(2, 14.0f, this.mContext.getResources().getDisplayMetrics());
            SpannableString spannableString = new SpannableString(this.b.getString(com.baidu.tieba.y.is_flowmode_close));
            spannableString.setSpan(new AbsoluteSizeSpan(applyDimension), 3, spannableString.length(), 33);
            SpannableString spannableString2 = new SpannableString(this.b.getString(com.baidu.tieba.y.is_flowmode_2g3gopen));
            spannableString2.setSpan(new AbsoluteSizeSpan(applyDimension), 12, spannableString2.length(), 33);
            SpannableString spannableString3 = new SpannableString(this.b.getString(com.baidu.tieba.y.is_flowmode_alwaysopen));
            spannableString3.setSpan(new AbsoluteSizeSpan(applyDimension), 4, spannableString3.length(), 33);
        }
    }

    private void v() {
        if (this.n == null) {
            SpannableString spannableString = new SpannableString(this.b.getString(com.baidu.tieba.y.is_wifiopen_dialog));
            spannableString.setSpan(new AbsoluteSizeSpan(com.baidu.adp.lib.util.j.a(this.mContext, 12.0f)), 5, spannableString.length(), 18);
            this.n = new AlertDialog.Builder(this.b).setTitle(com.baidu.tieba.y.show_photo).setItems(new CharSequence[]{spannableString, new SpannableString(this.b.getString(com.baidu.tieba.y.is_alwaysopen)), new SpannableString(this.b.getString(com.baidu.tieba.y.is_close))}, this.s).create();
        }
    }

    private void w() {
        if (this.o == null) {
            this.o = new AlertDialog.Builder(this.b).setTitle(com.baidu.tieba.y.font_size).setItems(new CharSequence[]{new SpannableString(this.b.getString(com.baidu.tieba.y.font_size_big)), new SpannableString(this.b.getString(com.baidu.tieba.y.font_size_mid)), new SpannableString(this.b.getString(com.baidu.tieba.y.font_size_small))}, this.t).create();
        }
    }

    public void b(int i) {
        if (i == 1) {
            if (TbadkApplication.m252getInst().getSkinType() != 1) {
                com.baidu.tieba.ai.c().c(i);
                a(i);
                TiebaStatic.eventStat(TbadkApplication.m252getInst().getApp(), TbConfig.ST_TYPE_EYESHIELD_MODE, null, 1, new Object[0]);
            } else {
                return;
            }
        } else if (i == 0) {
            if (TbadkApplication.m252getInst().getSkinType() != 0) {
                com.baidu.tieba.ai.c().c(i);
                a(i);
            } else {
                return;
            }
        }
        com.baidu.tbadk.core.util.h.a();
    }

    public void k() {
        m();
        x();
        y();
        p();
        o();
        a(false);
    }

    public void l() {
        x();
        y();
        o();
    }

    public void m() {
        if (TbadkApplication.m252getInst().getSkinType() == 1) {
            this.e.b();
        } else {
            this.e.a();
        }
    }

    public void a(boolean z) {
        this.f.setSwitchStateChangeListener(null);
        if (com.baidu.tbadk.core.h.a().h()) {
            this.f.b(z);
        } else {
            this.f.a(z);
        }
        this.f.setSwitchStateChangeListener(this.p);
    }

    public void n() {
        a(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        if (!com.baidu.tbadk.core.h.a().f()) {
            this.g.setTip(this.mContext.getString(com.baidu.tieba.y.view_close));
        } else if (com.baidu.tbadk.core.h.a().g() == 1) {
            this.g.setTip(this.mContext.getString(com.baidu.tieba.y.view_high));
        } else if (com.baidu.tbadk.core.h.a().g() == 2) {
            this.g.setTip(this.mContext.getString(com.baidu.tieba.y.view_low));
        } else {
            this.g.setTip(this.mContext.getString(com.baidu.tieba.y.view_auto));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        switch (com.baidu.tbadk.core.h.a().e()) {
            case 0:
                this.h.setTip(this.mContext.getString(com.baidu.tieba.y.view_auto));
                return;
            case 1:
                this.h.setTip(this.mContext.getString(com.baidu.tieba.y.view_high));
                return;
            case 2:
                this.h.setTip(this.mContext.getString(com.baidu.tieba.y.view_mid));
                return;
            case 3:
                this.h.setTip(this.mContext.getString(com.baidu.tieba.y.view_low));
                return;
            default:
                return;
        }
    }

    public void o() {
        switch (com.baidu.tbadk.core.h.a().c()) {
            case 0:
                this.i.setTip(this.mContext.getString(com.baidu.tieba.y.is_wifiopen));
                return;
            case 1:
                this.i.setTip(this.mContext.getString(com.baidu.tieba.y.is_alwaysopen));
                return;
            case 2:
                this.i.setTip(this.mContext.getString(com.baidu.tieba.y.is_close));
                return;
            default:
                return;
        }
    }

    public void p() {
        if (TbadkApplication.m252getInst().getFontSize() == 1) {
            this.j.setTip(this.mContext.getString(com.baidu.tieba.y.font_size_big));
        } else if (TbadkApplication.m252getInst().getFontSize() == 2) {
            this.j.setTip(this.mContext.getString(com.baidu.tieba.y.font_size_mid));
        } else {
            this.j.setTip(this.mContext.getString(com.baidu.tieba.y.font_size_small));
        }
    }
}
