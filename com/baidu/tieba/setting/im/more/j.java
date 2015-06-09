package com.baidu.tieba.setting.im.more;

import android.view.View;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ i ceq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.ceq = iVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        l lVar;
        View view2;
        TbSettingTextTipView tbSettingTextTipView;
        TbSettingTextTipView tbSettingTextTipView2;
        TbSettingTextTipView tbSettingTextTipView3;
        TbSettingTextTipView tbSettingTextTipView4;
        TbSettingTextTipView tbSettingTextTipView5;
        l lVar2;
        l lVar3;
        l lVar4;
        l lVar5;
        l lVar6;
        l lVar7;
        lVar = this.ceq.cdT;
        if (lVar != null) {
            view2 = this.ceq.mBack;
            if (view != view2) {
                tbSettingTextTipView = this.ceq.cec;
                if (view != tbSettingTextTipView) {
                    tbSettingTextTipView2 = this.ceq.ced;
                    if (view != tbSettingTextTipView2) {
                        tbSettingTextTipView3 = this.ceq.cee;
                        if (view != tbSettingTextTipView3) {
                            tbSettingTextTipView4 = this.ceq.ceg;
                            if (view != tbSettingTextTipView4) {
                                tbSettingTextTipView5 = this.ceq.cel;
                                if (view != tbSettingTextTipView5) {
                                    return;
                                }
                                lVar2 = this.ceq.cdT;
                                lVar2.ain();
                                return;
                            }
                            lVar3 = this.ceq.cdT;
                            lVar3.aik();
                            return;
                        }
                        lVar4 = this.ceq.cdT;
                        lVar4.ail();
                        return;
                    }
                    lVar5 = this.ceq.cdT;
                    lVar5.aim();
                    return;
                }
                lVar6 = this.ceq.cdT;
                lVar6.aij();
                return;
            }
            lVar7 = this.ceq.cdT;
            lVar7.onBackPressed();
        }
    }
}
