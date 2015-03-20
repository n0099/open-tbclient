package com.baidu.tieba.setting.im.more;

import android.view.View;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    final /* synthetic */ g bZD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.bZD = gVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        j jVar;
        View view2;
        TbSettingTextTipView tbSettingTextTipView;
        TbSettingTextTipView tbSettingTextTipView2;
        TbSettingTextTipView tbSettingTextTipView3;
        TbSettingTextTipView tbSettingTextTipView4;
        j jVar2;
        j jVar3;
        j jVar4;
        j jVar5;
        j jVar6;
        jVar = this.bZD.bZm;
        if (jVar != null) {
            view2 = this.bZD.mBack;
            if (view != view2) {
                tbSettingTextTipView = this.bZD.bZt;
                if (view != tbSettingTextTipView) {
                    tbSettingTextTipView2 = this.bZD.bZu;
                    if (view != tbSettingTextTipView2) {
                        tbSettingTextTipView3 = this.bZD.bZv;
                        if (view != tbSettingTextTipView3) {
                            tbSettingTextTipView4 = this.bZD.bZx;
                            if (view != tbSettingTextTipView4) {
                                return;
                            }
                            jVar2 = this.bZD.bZm;
                            jVar2.agc();
                            return;
                        }
                        jVar3 = this.bZD.bZm;
                        jVar3.agd();
                        return;
                    }
                    jVar4 = this.bZD.bZm;
                    jVar4.age();
                    return;
                }
                jVar5 = this.bZD.bZm;
                jVar5.agb();
                return;
            }
            jVar6 = this.bZD.bZm;
            jVar6.onBackPressed();
        }
    }
}
