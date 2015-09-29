package com.baidu.tieba.setting.im.more;

import android.view.View;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.setting.im.more.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ i cLr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.cLr = iVar;
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
        aVar = this.cLr.cLq;
        if (aVar != null) {
            view2 = this.cLr.mBack;
            if (view != view2) {
                tbSettingTextTipView = this.cLr.cLb;
                if (view != tbSettingTextTipView) {
                    tbSettingTextTipView2 = this.cLr.cLc;
                    if (view != tbSettingTextTipView2) {
                        tbSettingTextTipView3 = this.cLr.cLd;
                        if (view != tbSettingTextTipView3) {
                            tbSettingTextTipView4 = this.cLr.cLg;
                            if (view != tbSettingTextTipView4) {
                                tbSettingTextTipView5 = this.cLr.cLl;
                                if (view != tbSettingTextTipView5) {
                                    tbSettingTextTipView6 = this.cLr.cLe;
                                    if (view != tbSettingTextTipView6) {
                                        return;
                                    }
                                    aVar2 = this.cLr.cLq;
                                    aVar2.arc();
                                    return;
                                }
                                aVar3 = this.cLr.cLq;
                                aVar3.ard();
                                return;
                            }
                            aVar4 = this.cLr.cLq;
                            aVar4.aqZ();
                            return;
                        }
                        aVar5 = this.cLr.cLq;
                        aVar5.ara();
                        return;
                    }
                    aVar6 = this.cLr.cLq;
                    aVar6.arb();
                    return;
                }
                aVar7 = this.cLr.cLq;
                aVar7.aqY();
                return;
            }
            aVar8 = this.cLr.cLq;
            aVar8.onBackPressed();
        }
    }
}
