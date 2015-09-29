package com.baidu.tieba.setting.more;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ c cLU;
    private final /* synthetic */ r cLV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, r rVar) {
        this.cLU = cVar;
        this.cLV = rVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SettingTextTestNewView settingTextTestNewView;
        TbSettingTextTipView tbSettingTextTipView;
        TextView textView;
        long j;
        int i;
        settingTextTestNewView = this.cLU.cLQ;
        if (view == settingTextTestNewView) {
            this.cLV.kx(1);
            return;
        }
        tbSettingTextTipView = this.cLU.cLR;
        if (view == tbSettingTextTipView) {
            this.cLV.kx(2);
            return;
        }
        textView = this.cLU.cLP;
        if (view == textView) {
            long currentTimeMillis = System.currentTimeMillis();
            j = this.cLU.lastClickTime;
            if (currentTimeMillis - j >= 2000) {
                this.cLU.cLM = 0;
            } else {
                c cVar = this.cLU;
                i = cVar.cLM;
                int i2 = i + 1;
                cVar.cLM = i2;
                if (i2 >= 14) {
                    this.cLV.kx(4);
                    this.cLU.cLM = 0;
                }
            }
            this.cLU.lastClickTime = System.currentTimeMillis();
        }
    }
}
