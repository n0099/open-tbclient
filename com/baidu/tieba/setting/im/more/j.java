package com.baidu.tieba.setting.im.more;

import android.view.View;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.setting.im.more.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ i cvU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.cvU = iVar;
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
        aVar = this.cvU.cvT;
        if (aVar != null) {
            view2 = this.cvU.mBack;
            if (view != view2) {
                tbSettingTextTipView = this.cvU.cvE;
                if (view != tbSettingTextTipView) {
                    tbSettingTextTipView2 = this.cvU.cvF;
                    if (view != tbSettingTextTipView2) {
                        tbSettingTextTipView3 = this.cvU.cvG;
                        if (view != tbSettingTextTipView3) {
                            tbSettingTextTipView4 = this.cvU.cvJ;
                            if (view != tbSettingTextTipView4) {
                                tbSettingTextTipView5 = this.cvU.cvO;
                                if (view != tbSettingTextTipView5) {
                                    tbSettingTextTipView6 = this.cvU.cvH;
                                    if (view != tbSettingTextTipView6) {
                                        return;
                                    }
                                    aVar2 = this.cvU.cvT;
                                    aVar2.akD();
                                    return;
                                }
                                aVar3 = this.cvU.cvT;
                                aVar3.akE();
                                return;
                            }
                            aVar4 = this.cvU.cvT;
                            aVar4.akA();
                            return;
                        }
                        aVar5 = this.cvU.cvT;
                        aVar5.akB();
                        return;
                    }
                    aVar6 = this.cvU.cvT;
                    aVar6.akC();
                    return;
                }
                aVar7 = this.cvU.cvT;
                aVar7.akz();
                return;
            }
            aVar8 = this.cvU.cvT;
            aVar8.onBackPressed();
        }
    }
}
