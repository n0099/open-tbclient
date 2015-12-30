package com.baidu.tieba.setting.more;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ c dts;
    private final /* synthetic */ s dtt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, s sVar) {
        this.dts = cVar;
        this.dtt = sVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SettingTextTestNewView settingTextTestNewView;
        TbSettingTextTipView tbSettingTextTipView;
        TextView textView;
        ImageView imageView;
        SettingTextTestNewView settingTextTestNewView2;
        long j;
        int i;
        long j2;
        int i2;
        settingTextTestNewView = this.dts.dtm;
        if (view == settingTextTestNewView) {
            this.dtt.mw(1);
            return;
        }
        tbSettingTextTipView = this.dts.dtp;
        if (view == tbSettingTextTipView) {
            this.dtt.mw(2);
            return;
        }
        textView = this.dts.dtk;
        if (view == textView) {
            long currentTimeMillis = System.currentTimeMillis();
            j2 = this.dts.lastClickTime;
            if (currentTimeMillis - j2 >= 2000) {
                this.dts.dtf = 0;
            } else {
                c cVar = this.dts;
                i2 = cVar.dtf;
                int i3 = i2 + 1;
                cVar.dtf = i3;
                if (i3 >= 14) {
                    this.dtt.mw(4);
                    this.dts.dtf = 0;
                }
            }
            this.dts.lastClickTime = System.currentTimeMillis();
            return;
        }
        imageView = this.dts.dto;
        if (view == imageView) {
            long currentTimeMillis2 = System.currentTimeMillis();
            j = this.dts.dth;
            if (currentTimeMillis2 - j >= 2000) {
                this.dts.dtg = 0;
            } else {
                c cVar2 = this.dts;
                i = cVar2.dtg;
                int i4 = i + 1;
                cVar2.dtg = i4;
                if (i4 >= 4) {
                    this.dts.dtg = 0;
                    boolean z = com.baidu.tbadk.core.sharedPref.b.tJ().getBoolean("debug_plugin_switcher", false);
                    com.baidu.tbadk.core.sharedPref.b.tJ().putBoolean("debug_plugin_switcher", z ? false : true);
                    if (!z) {
                        this.dtt.mw(5);
                        this.dts.mx(0);
                    } else {
                        this.dts.mx(8);
                    }
                }
            }
            this.dts.dth = System.currentTimeMillis();
            return;
        }
        settingTextTestNewView2 = this.dts.dtn;
        if (view == settingTextTestNewView2) {
            this.dtt.mw(6);
        }
    }
}
