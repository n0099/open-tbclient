package com.baidu.tieba.setting.more;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ c dJw;
    private final /* synthetic */ s dJx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, s sVar) {
        this.dJw = cVar;
        this.dJx = sVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SettingTextTestNewView settingTextTestNewView;
        TbSettingTextTipView tbSettingTextTipView;
        TextView textView;
        ImageView imageView;
        SettingTextTestNewView settingTextTestNewView2;
        long j;
        int i;
        long j2;
        int i2;
        settingTextTestNewView = this.dJw.dJq;
        if (view == settingTextTestNewView) {
            this.dJx.nI(1);
            return;
        }
        tbSettingTextTipView = this.dJw.dJt;
        if (view == tbSettingTextTipView) {
            this.dJx.nI(2);
            return;
        }
        textView = this.dJw.dJo;
        if (view == textView) {
            long currentTimeMillis = System.currentTimeMillis();
            j2 = this.dJw.lastClickTime;
            if (currentTimeMillis - j2 >= 2000) {
                this.dJw.dJj = 0;
            } else {
                c cVar = this.dJw;
                i2 = cVar.dJj;
                int i3 = i2 + 1;
                cVar.dJj = i3;
                if (i3 >= 14) {
                    this.dJx.nI(4);
                    this.dJw.dJj = 0;
                }
            }
            this.dJw.lastClickTime = System.currentTimeMillis();
            return;
        }
        imageView = this.dJw.dJs;
        if (view == imageView) {
            long currentTimeMillis2 = System.currentTimeMillis();
            j = this.dJw.dJl;
            if (currentTimeMillis2 - j >= 2000) {
                this.dJw.dJk = 0;
            } else {
                c cVar2 = this.dJw;
                i = cVar2.dJk;
                int i4 = i + 1;
                cVar2.dJk = i4;
                if (i4 >= 4) {
                    this.dJw.dJk = 0;
                    boolean z = com.baidu.tbadk.core.sharedPref.b.uO().getBoolean("debug_plugin_switcher", false);
                    com.baidu.tbadk.core.sharedPref.b.uO().putBoolean("debug_plugin_switcher", z ? false : true);
                    if (!z) {
                        this.dJx.nI(5);
                        this.dJw.nJ(0);
                    } else {
                        this.dJw.nJ(8);
                    }
                }
            }
            this.dJw.dJl = System.currentTimeMillis();
            return;
        }
        settingTextTestNewView2 = this.dJw.dJr;
        if (view == settingTextTestNewView2) {
            this.dJx.nI(6);
        }
    }
}
