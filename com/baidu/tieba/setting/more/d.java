package com.baidu.tieba.setting.more;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ c cMt;
    private final /* synthetic */ r cMu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, r rVar) {
        this.cMt = cVar;
        this.cMu = rVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SettingTextTestNewView settingTextTestNewView;
        TbSettingTextTipView tbSettingTextTipView;
        TextView textView;
        long j;
        int i;
        settingTextTestNewView = this.cMt.cMp;
        if (view == settingTextTestNewView) {
            this.cMu.kz(1);
            return;
        }
        tbSettingTextTipView = this.cMt.cMq;
        if (view == tbSettingTextTipView) {
            this.cMu.kz(2);
            return;
        }
        textView = this.cMt.cMo;
        if (view == textView) {
            long currentTimeMillis = System.currentTimeMillis();
            j = this.cMt.lastClickTime;
            if (currentTimeMillis - j >= 2000) {
                this.cMt.cMl = 0;
            } else {
                c cVar = this.cMt;
                i = cVar.cMl;
                int i2 = i + 1;
                cVar.cMl = i2;
                if (i2 >= 14) {
                    this.cMu.kz(4);
                    this.cMt.cMl = 0;
                }
            }
            this.cMt.lastClickTime = System.currentTimeMillis();
        }
    }
}
