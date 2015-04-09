package com.baidu.tieba.setting.more;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ d cal;
    private final /* synthetic */ q cam;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, q qVar) {
        this.cal = dVar;
        this.cam = qVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SettingTextTestNewView settingTextTestNewView;
        TbSettingTextTipView tbSettingTextTipView;
        SettingTextFunctionIntroView settingTextFunctionIntroView;
        TextView textView;
        long j;
        int i;
        settingTextTestNewView = this.cal.cah;
        if (view == settingTextTestNewView) {
            this.cam.hW(1);
            return;
        }
        tbSettingTextTipView = this.cal.cai;
        if (view == tbSettingTextTipView) {
            this.cam.hW(2);
            return;
        }
        settingTextFunctionIntroView = this.cal.caj;
        if (view == settingTextFunctionIntroView) {
            this.cam.hW(3);
            return;
        }
        textView = this.cal.cae;
        if (view == textView) {
            long currentTimeMillis = System.currentTimeMillis();
            j = this.cal.cac;
            if (currentTimeMillis - j >= 2000) {
                this.cal.cab = 0;
            } else {
                d dVar = this.cal;
                i = dVar.cab;
                int i2 = i + 1;
                dVar.cab = i2;
                if (i2 >= 14) {
                    this.cam.hW(4);
                    this.cal.cab = 0;
                }
            }
            this.cal.cac = System.currentTimeMillis();
        }
    }
}
