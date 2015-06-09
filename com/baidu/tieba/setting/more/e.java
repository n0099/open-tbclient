package com.baidu.tieba.setting.more;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ d ceI;
    private final /* synthetic */ q ceJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, q qVar) {
        this.ceI = dVar;
        this.ceJ = qVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SettingTextTestNewView settingTextTestNewView;
        TbSettingTextTipView tbSettingTextTipView;
        TextView textView;
        long j;
        int i;
        settingTextTestNewView = this.ceI.ceE;
        if (view == settingTextTestNewView) {
            this.ceJ.iu(1);
            return;
        }
        tbSettingTextTipView = this.ceI.ceF;
        if (view == tbSettingTextTipView) {
            this.ceJ.iu(2);
            return;
        }
        textView = this.ceI.ceD;
        if (view == textView) {
            long currentTimeMillis = System.currentTimeMillis();
            j = this.ceI.ceA;
            if (currentTimeMillis - j >= 2000) {
                this.ceI.cez = 0;
            } else {
                d dVar = this.ceI;
                i = dVar.cez;
                int i2 = i + 1;
                dVar.cez = i2;
                if (i2 >= 14) {
                    this.ceJ.iu(4);
                    this.ceI.cez = 0;
                }
            }
            this.ceI.ceA = System.currentTimeMillis();
        }
    }
}
