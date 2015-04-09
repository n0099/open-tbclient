package com.baidu.tieba.setting.im.more;

import android.view.View;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    final /* synthetic */ g bZS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.bZS = gVar;
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
        jVar = this.bZS.bZB;
        if (jVar != null) {
            view2 = this.bZS.mBack;
            if (view != view2) {
                tbSettingTextTipView = this.bZS.bZI;
                if (view != tbSettingTextTipView) {
                    tbSettingTextTipView2 = this.bZS.bZJ;
                    if (view != tbSettingTextTipView2) {
                        tbSettingTextTipView3 = this.bZS.bZK;
                        if (view != tbSettingTextTipView3) {
                            tbSettingTextTipView4 = this.bZS.bZM;
                            if (view != tbSettingTextTipView4) {
                                return;
                            }
                            jVar2 = this.bZS.bZB;
                            jVar2.agr();
                            return;
                        }
                        jVar3 = this.bZS.bZB;
                        jVar3.ags();
                        return;
                    }
                    jVar4 = this.bZS.bZB;
                    jVar4.agt();
                    return;
                }
                jVar5 = this.bZS.bZB;
                jVar5.agq();
                return;
            }
            jVar6 = this.bZS.bZB;
            jVar6.onBackPressed();
        }
    }
}
