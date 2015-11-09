package com.baidu.tieba.setting.more;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ c cNP;
    private final /* synthetic */ r cNQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, r rVar) {
        this.cNP = cVar;
        this.cNQ = rVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SettingTextTestNewView settingTextTestNewView;
        TbSettingTextTipView tbSettingTextTipView;
        TextView textView;
        long j;
        int i;
        settingTextTestNewView = this.cNP.cNL;
        if (view == settingTextTestNewView) {
            this.cNQ.kN(1);
            return;
        }
        tbSettingTextTipView = this.cNP.cNM;
        if (view == tbSettingTextTipView) {
            this.cNQ.kN(2);
            return;
        }
        textView = this.cNP.cNK;
        if (view == textView) {
            long currentTimeMillis = System.currentTimeMillis();
            j = this.cNP.lastClickTime;
            if (currentTimeMillis - j >= 2000) {
                this.cNP.cNH = 0;
            } else {
                c cVar = this.cNP;
                i = cVar.cNH;
                int i2 = i + 1;
                cVar.cNH = i2;
                if (i2 >= 14) {
                    this.cNQ.kN(4);
                    this.cNP.cNH = 0;
                }
            }
            this.cNP.lastClickTime = System.currentTimeMillis();
        }
    }
}
