package com.baidu.tieba.setting.im.more;

import android.view.View;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.setting.im.more.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ i dsK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.dsK = iVar;
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
        aVar = this.dsK.dsJ;
        if (aVar != null) {
            view2 = this.dsK.mBack;
            if (view != view2) {
                tbSettingTextTipView = this.dsK.dsu;
                if (view != tbSettingTextTipView) {
                    tbSettingTextTipView2 = this.dsK.dsv;
                    if (view != tbSettingTextTipView2) {
                        tbSettingTextTipView3 = this.dsK.dsw;
                        if (view != tbSettingTextTipView3) {
                            tbSettingTextTipView4 = this.dsK.dsz;
                            if (view != tbSettingTextTipView4) {
                                tbSettingTextTipView5 = this.dsK.dsE;
                                if (view != tbSettingTextTipView5) {
                                    tbSettingTextTipView6 = this.dsK.dsx;
                                    if (view != tbSettingTextTipView6) {
                                        return;
                                    }
                                    aVar2 = this.dsK.dsJ;
                                    aVar2.azp();
                                    return;
                                }
                                aVar3 = this.dsK.dsJ;
                                aVar3.azq();
                                return;
                            }
                            aVar4 = this.dsK.dsJ;
                            aVar4.azm();
                            return;
                        }
                        aVar5 = this.dsK.dsJ;
                        aVar5.azn();
                        return;
                    }
                    aVar6 = this.dsK.dsJ;
                    aVar6.azo();
                    return;
                }
                aVar7 = this.dsK.dsJ;
                aVar7.azl();
                return;
            }
            aVar8 = this.dsK.dsJ;
            aVar8.onBackPressed();
        }
    }
}
