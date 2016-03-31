package com.baidu.tieba.setting.im.more;

import android.view.View;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.setting.im.more.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ i ebi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.ebi = iVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        i.a aVar;
        View view2;
        TbSettingTextTipView tbSettingTextTipView;
        TbSettingTextTipView tbSettingTextTipView2;
        TbSettingTextTipView tbSettingTextTipView3;
        TbSettingTextTipView tbSettingTextTipView4;
        TbSettingTextTipView tbSettingTextTipView5;
        TbSettingTextTipView tbSettingTextTipView6;
        i.a aVar2;
        i.a aVar3;
        i.a aVar4;
        i.a aVar5;
        i.a aVar6;
        i.a aVar7;
        i.a aVar8;
        aVar = this.ebi.ebh;
        if (aVar != null) {
            view2 = this.ebi.ajA;
            if (view != view2) {
                tbSettingTextTipView = this.ebi.eaS;
                if (view != tbSettingTextTipView) {
                    tbSettingTextTipView2 = this.ebi.eaT;
                    if (view != tbSettingTextTipView2) {
                        tbSettingTextTipView3 = this.ebi.eaU;
                        if (view != tbSettingTextTipView3) {
                            tbSettingTextTipView4 = this.ebi.eaX;
                            if (view != tbSettingTextTipView4) {
                                tbSettingTextTipView5 = this.ebi.ebc;
                                if (view != tbSettingTextTipView5) {
                                    tbSettingTextTipView6 = this.ebi.eaV;
                                    if (view != tbSettingTextTipView6) {
                                        return;
                                    }
                                    aVar2 = this.ebi.ebh;
                                    aVar2.aNg();
                                    return;
                                }
                                aVar3 = this.ebi.ebh;
                                aVar3.aNh();
                                return;
                            }
                            aVar4 = this.ebi.ebh;
                            aVar4.aNd();
                            return;
                        }
                        aVar5 = this.ebi.ebh;
                        aVar5.aNe();
                        return;
                    }
                    aVar6 = this.ebi.ebh;
                    aVar6.aNf();
                    return;
                }
                aVar7 = this.ebi.ebh;
                aVar7.aNc();
                return;
            }
            aVar8 = this.ebi.ebh;
            aVar8.onBackPressed();
        }
    }
}
