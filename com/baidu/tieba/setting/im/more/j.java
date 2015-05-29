package com.baidu.tieba.setting.im.more;

import android.view.View;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ i cep;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.cep = iVar;
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
        lVar = this.cep.cdS;
        if (lVar != null) {
            view2 = this.cep.mBack;
            if (view != view2) {
                tbSettingTextTipView = this.cep.ceb;
                if (view != tbSettingTextTipView) {
                    tbSettingTextTipView2 = this.cep.cec;
                    if (view != tbSettingTextTipView2) {
                        tbSettingTextTipView3 = this.cep.ced;
                        if (view != tbSettingTextTipView3) {
                            tbSettingTextTipView4 = this.cep.cef;
                            if (view != tbSettingTextTipView4) {
                                tbSettingTextTipView5 = this.cep.cek;
                                if (view != tbSettingTextTipView5) {
                                    return;
                                }
                                lVar2 = this.cep.cdS;
                                lVar2.aim();
                                return;
                            }
                            lVar3 = this.cep.cdS;
                            lVar3.aij();
                            return;
                        }
                        lVar4 = this.cep.cdS;
                        lVar4.aik();
                        return;
                    }
                    lVar5 = this.cep.cdS;
                    lVar5.ail();
                    return;
                }
                lVar6 = this.cep.cdS;
                lVar6.aii();
                return;
            }
            lVar7 = this.cep.cdS;
            lVar7.onBackPressed();
        }
    }
}
