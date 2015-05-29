package com.baidu.tieba.setting.more;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ d ceH;
    private final /* synthetic */ q ceI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, q qVar) {
        this.ceH = dVar;
        this.ceI = qVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SettingTextTestNewView settingTextTestNewView;
        TbSettingTextTipView tbSettingTextTipView;
        TextView textView;
        long j;
        int i;
        settingTextTestNewView = this.ceH.ceD;
        if (view == settingTextTestNewView) {
            this.ceI.iu(1);
            return;
        }
        tbSettingTextTipView = this.ceH.ceE;
        if (view == tbSettingTextTipView) {
            this.ceI.iu(2);
            return;
        }
        textView = this.ceH.ceC;
        if (view == textView) {
            long currentTimeMillis = System.currentTimeMillis();
            j = this.ceH.cez;
            if (currentTimeMillis - j >= 2000) {
                this.ceH.cey = 0;
            } else {
                d dVar = this.ceH;
                i = dVar.cey;
                int i2 = i + 1;
                dVar.cey = i2;
                if (i2 >= 14) {
                    this.ceI.iu(4);
                    this.ceH.cey = 0;
                }
            }
            this.ceH.cez = System.currentTimeMillis();
        }
    }
}
