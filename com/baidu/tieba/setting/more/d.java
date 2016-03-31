package com.baidu.tieba.setting.more;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ c ebQ;
    private final /* synthetic */ s ebR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, s sVar) {
        this.ebQ = cVar;
        this.ebR = sVar;
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
        settingTextTestNewView = this.ebQ.ebK;
        if (view == settingTextTestNewView) {
            this.ebR.oN(1);
            return;
        }
        tbSettingTextTipView = this.ebQ.ebN;
        if (view == tbSettingTextTipView) {
            this.ebR.oN(2);
            return;
        }
        textView = this.ebQ.ebI;
        if (view == textView) {
            long currentTimeMillis = System.currentTimeMillis();
            j2 = this.ebQ.lastClickTime;
            if (currentTimeMillis - j2 >= 2000) {
                this.ebQ.ebD = 0;
            } else {
                c cVar = this.ebQ;
                i2 = cVar.ebD;
                int i3 = i2 + 1;
                cVar.ebD = i3;
                if (i3 >= 14) {
                    this.ebR.oN(4);
                    this.ebQ.ebD = 0;
                }
            }
            this.ebQ.lastClickTime = System.currentTimeMillis();
            return;
        }
        imageView = this.ebQ.ebM;
        if (view == imageView) {
            long currentTimeMillis2 = System.currentTimeMillis();
            j = this.ebQ.ebF;
            if (currentTimeMillis2 - j >= 2000) {
                this.ebQ.ebE = 0;
            } else {
                c cVar2 = this.ebQ;
                i = cVar2.ebE;
                int i4 = i + 1;
                cVar2.ebE = i4;
                if (i4 >= 4) {
                    this.ebQ.ebE = 0;
                    boolean z = com.baidu.tbadk.core.sharedPref.b.vk().getBoolean("debug_plugin_switcher", false);
                    com.baidu.tbadk.core.sharedPref.b.vk().putBoolean("debug_plugin_switcher", z ? false : true);
                    if (!z) {
                        this.ebR.oN(5);
                        this.ebQ.oO(0);
                    } else {
                        this.ebQ.oO(8);
                    }
                }
            }
            this.ebQ.ebF = System.currentTimeMillis();
            return;
        }
        settingTextTestNewView2 = this.ebQ.ebL;
        if (view == settingTextTestNewView2) {
            this.ebR.oN(6);
        }
    }
}
