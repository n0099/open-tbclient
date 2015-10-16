package com.baidu.tieba.setting.im.more;

import android.view.View;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.setting.im.more.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ i cLQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.cLQ = iVar;
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
        aVar = this.cLQ.cLP;
        if (aVar != null) {
            view2 = this.cLQ.mBack;
            if (view != view2) {
                tbSettingTextTipView = this.cLQ.cLA;
                if (view != tbSettingTextTipView) {
                    tbSettingTextTipView2 = this.cLQ.cLB;
                    if (view != tbSettingTextTipView2) {
                        tbSettingTextTipView3 = this.cLQ.cLC;
                        if (view != tbSettingTextTipView3) {
                            tbSettingTextTipView4 = this.cLQ.cLF;
                            if (view != tbSettingTextTipView4) {
                                tbSettingTextTipView5 = this.cLQ.cLK;
                                if (view != tbSettingTextTipView5) {
                                    tbSettingTextTipView6 = this.cLQ.cLD;
                                    if (view != tbSettingTextTipView6) {
                                        return;
                                    }
                                    aVar2 = this.cLQ.cLP;
                                    aVar2.ari();
                                    return;
                                }
                                aVar3 = this.cLQ.cLP;
                                aVar3.arj();
                                return;
                            }
                            aVar4 = this.cLQ.cLP;
                            aVar4.arf();
                            return;
                        }
                        aVar5 = this.cLQ.cLP;
                        aVar5.arg();
                        return;
                    }
                    aVar6 = this.cLQ.cLP;
                    aVar6.arh();
                    return;
                }
                aVar7 = this.cLQ.cLP;
                aVar7.are();
                return;
            }
            aVar8 = this.cLQ.cLP;
            aVar8.onBackPressed();
        }
    }
}
