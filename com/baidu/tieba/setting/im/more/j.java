package com.baidu.tieba.setting.im.more;

import android.view.View;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.setting.im.more.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ i cNm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.cNm = iVar;
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
        aVar = this.cNm.cNl;
        if (aVar != null) {
            view2 = this.cNm.mBack;
            if (view != view2) {
                tbSettingTextTipView = this.cNm.cMW;
                if (view != tbSettingTextTipView) {
                    tbSettingTextTipView2 = this.cNm.cMX;
                    if (view != tbSettingTextTipView2) {
                        tbSettingTextTipView3 = this.cNm.cMY;
                        if (view != tbSettingTextTipView3) {
                            tbSettingTextTipView4 = this.cNm.cNb;
                            if (view != tbSettingTextTipView4) {
                                tbSettingTextTipView5 = this.cNm.cNg;
                                if (view != tbSettingTextTipView5) {
                                    tbSettingTextTipView6 = this.cNm.cMZ;
                                    if (view != tbSettingTextTipView6) {
                                        return;
                                    }
                                    aVar2 = this.cNm.cNl;
                                    aVar2.arK();
                                    return;
                                }
                                aVar3 = this.cNm.cNl;
                                aVar3.arL();
                                return;
                            }
                            aVar4 = this.cNm.cNl;
                            aVar4.arH();
                            return;
                        }
                        aVar5 = this.cNm.cNl;
                        aVar5.arI();
                        return;
                    }
                    aVar6 = this.cNm.cNl;
                    aVar6.arJ();
                    return;
                }
                aVar7 = this.cNm.cNl;
                aVar7.arG();
                return;
            }
            aVar8 = this.cNm.cNl;
            aVar8.onBackPressed();
        }
    }
}
