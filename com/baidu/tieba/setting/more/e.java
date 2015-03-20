package com.baidu.tieba.setting.more;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ d bZW;
    private final /* synthetic */ q bZX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, q qVar) {
        this.bZW = dVar;
        this.bZX = qVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SettingTextTestNewView settingTextTestNewView;
        TbSettingTextTipView tbSettingTextTipView;
        SettingTextFunctionIntroView settingTextFunctionIntroView;
        TextView textView;
        long j;
        int i;
        settingTextTestNewView = this.bZW.bZS;
        if (view == settingTextTestNewView) {
            this.bZX.hT(1);
            return;
        }
        tbSettingTextTipView = this.bZW.bZT;
        if (view == tbSettingTextTipView) {
            this.bZX.hT(2);
            return;
        }
        settingTextFunctionIntroView = this.bZW.bZU;
        if (view == settingTextFunctionIntroView) {
            this.bZX.hT(3);
            return;
        }
        textView = this.bZW.bZP;
        if (view == textView) {
            long currentTimeMillis = System.currentTimeMillis();
            j = this.bZW.bZN;
            if (currentTimeMillis - j >= 2000) {
                this.bZW.bZM = 0;
            } else {
                d dVar = this.bZW;
                i = dVar.bZM;
                int i2 = i + 1;
                dVar.bZM = i2;
                if (i2 >= 14) {
                    this.bZX.hT(4);
                    this.bZW.bZM = 0;
                }
            }
            this.bZW.bZN = System.currentTimeMillis();
        }
    }
}
