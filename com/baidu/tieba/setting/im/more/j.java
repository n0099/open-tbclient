package com.baidu.tieba.setting.im.more;

import android.view.View;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.setting.im.more.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ i cEq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.cEq = iVar;
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
        aVar = this.cEq.cEp;
        if (aVar != null) {
            view2 = this.cEq.mBack;
            if (view != view2) {
                tbSettingTextTipView = this.cEq.cEa;
                if (view != tbSettingTextTipView) {
                    tbSettingTextTipView2 = this.cEq.cEb;
                    if (view != tbSettingTextTipView2) {
                        tbSettingTextTipView3 = this.cEq.cEc;
                        if (view != tbSettingTextTipView3) {
                            tbSettingTextTipView4 = this.cEq.cEf;
                            if (view != tbSettingTextTipView4) {
                                tbSettingTextTipView5 = this.cEq.cEk;
                                if (view != tbSettingTextTipView5) {
                                    tbSettingTextTipView6 = this.cEq.cEd;
                                    if (view != tbSettingTextTipView6) {
                                        return;
                                    }
                                    aVar2 = this.cEq.cEp;
                                    aVar2.aoK();
                                    return;
                                }
                                aVar3 = this.cEq.cEp;
                                aVar3.aoL();
                                return;
                            }
                            aVar4 = this.cEq.cEp;
                            aVar4.aoH();
                            return;
                        }
                        aVar5 = this.cEq.cEp;
                        aVar5.aoI();
                        return;
                    }
                    aVar6 = this.cEq.cEp;
                    aVar6.aoJ();
                    return;
                }
                aVar7 = this.cEq.cEp;
                aVar7.aoG();
                return;
            }
            aVar8 = this.cEq.cEp;
            aVar8.onBackPressed();
        }
    }
}
