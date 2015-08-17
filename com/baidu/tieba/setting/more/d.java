package com.baidu.tieba.setting.more;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ c cww;
    private final /* synthetic */ r cwx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, r rVar) {
        this.cww = cVar;
        this.cwx = rVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SettingTextTestNewView settingTextTestNewView;
        TbSettingTextTipView tbSettingTextTipView;
        TextView textView;
        long j;
        int i;
        settingTextTestNewView = this.cww.cws;
        if (view == settingTextTestNewView) {
            this.cwx.jo(1);
            return;
        }
        tbSettingTextTipView = this.cww.cwt;
        if (view == tbSettingTextTipView) {
            this.cwx.jo(2);
            return;
        }
        textView = this.cww.cwr;
        if (view == textView) {
            long currentTimeMillis = System.currentTimeMillis();
            j = this.cww.lastClickTime;
            if (currentTimeMillis - j >= 2000) {
                this.cww.cwo = 0;
            } else {
                c cVar = this.cww;
                i = cVar.cwo;
                int i2 = i + 1;
                cVar.cwo = i2;
                if (i2 >= 14) {
                    this.cwx.jo(4);
                    this.cww.cwo = 0;
                }
            }
            this.cww.lastClickTime = System.currentTimeMillis();
        }
    }
}
