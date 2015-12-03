package com.baidu.tieba.setting.more;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ c dmg;
    private final /* synthetic */ s dmh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, s sVar) {
        this.dmg = cVar;
        this.dmh = sVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SettingTextTestNewView settingTextTestNewView;
        TbSettingTextTipView tbSettingTextTipView;
        TextView textView;
        long j;
        int i;
        settingTextTestNewView = this.dmg.dmc;
        if (view == settingTextTestNewView) {
            this.dmh.lV(1);
            return;
        }
        tbSettingTextTipView = this.dmg.dmd;
        if (view == tbSettingTextTipView) {
            this.dmh.lV(2);
            return;
        }
        textView = this.dmg.dmb;
        if (view == textView) {
            long currentTimeMillis = System.currentTimeMillis();
            j = this.dmg.lastClickTime;
            if (currentTimeMillis - j >= 2000) {
                this.dmg.dlY = 0;
            } else {
                c cVar = this.dmg;
                i = cVar.dlY;
                int i2 = i + 1;
                cVar.dlY = i2;
                if (i2 >= 14) {
                    this.dmh.lV(4);
                    this.dmg.dlY = 0;
                }
            }
            this.dmg.lastClickTime = System.currentTimeMillis();
        }
    }
}
