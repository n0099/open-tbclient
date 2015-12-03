package com.baidu.tieba.setting.im.more;

import android.view.View;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.setting.im.more.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ i dlD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.dlD = iVar;
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
        aVar = this.dlD.dlC;
        if (aVar != null) {
            view2 = this.dlD.mBack;
            if (view != view2) {
                tbSettingTextTipView = this.dlD.dln;
                if (view != tbSettingTextTipView) {
                    tbSettingTextTipView2 = this.dlD.dlo;
                    if (view != tbSettingTextTipView2) {
                        tbSettingTextTipView3 = this.dlD.dlp;
                        if (view != tbSettingTextTipView3) {
                            tbSettingTextTipView4 = this.dlD.dls;
                            if (view != tbSettingTextTipView4) {
                                tbSettingTextTipView5 = this.dlD.dlx;
                                if (view != tbSettingTextTipView5) {
                                    tbSettingTextTipView6 = this.dlD.dlq;
                                    if (view != tbSettingTextTipView6) {
                                        return;
                                    }
                                    aVar2 = this.dlD.dlC;
                                    aVar2.axi();
                                    return;
                                }
                                aVar3 = this.dlD.dlC;
                                aVar3.axj();
                                return;
                            }
                            aVar4 = this.dlD.dlC;
                            aVar4.axf();
                            return;
                        }
                        aVar5 = this.dlD.dlC;
                        aVar5.axg();
                        return;
                    }
                    aVar6 = this.dlD.dlC;
                    aVar6.axh();
                    return;
                }
                aVar7 = this.dlD.dlC;
                aVar7.axe();
                return;
            }
            aVar8 = this.dlD.dlC;
            aVar8.onBackPressed();
        }
    }
}
