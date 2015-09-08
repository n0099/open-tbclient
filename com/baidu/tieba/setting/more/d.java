package com.baidu.tieba.setting.more;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ c cET;
    private final /* synthetic */ r cEU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, r rVar) {
        this.cET = cVar;
        this.cEU = rVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SettingTextTestNewView settingTextTestNewView;
        TbSettingTextTipView tbSettingTextTipView;
        TextView textView;
        long j;
        int i;
        settingTextTestNewView = this.cET.cEP;
        if (view == settingTextTestNewView) {
            this.cEU.jY(1);
            return;
        }
        tbSettingTextTipView = this.cET.cEQ;
        if (view == tbSettingTextTipView) {
            this.cEU.jY(2);
            return;
        }
        textView = this.cET.cEO;
        if (view == textView) {
            long currentTimeMillis = System.currentTimeMillis();
            j = this.cET.lastClickTime;
            if (currentTimeMillis - j >= 2000) {
                this.cET.cEL = 0;
            } else {
                c cVar = this.cET;
                i = cVar.cEL;
                int i2 = i + 1;
                cVar.cEL = i2;
                if (i2 >= 14) {
                    this.cEU.jY(4);
                    this.cET.cEL = 0;
                }
            }
            this.cET.lastClickTime = System.currentTimeMillis();
        }
    }
}
