package com.baidu.tieba.setting.im.more;

import android.view.View;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.setting.im.more.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ i dIO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.dIO = iVar;
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
        aVar = this.dIO.dIN;
        if (aVar != null) {
            view2 = this.dIO.ajk;
            if (view != view2) {
                tbSettingTextTipView = this.dIO.dIy;
                if (view != tbSettingTextTipView) {
                    tbSettingTextTipView2 = this.dIO.dIz;
                    if (view != tbSettingTextTipView2) {
                        tbSettingTextTipView3 = this.dIO.dIA;
                        if (view != tbSettingTextTipView3) {
                            tbSettingTextTipView4 = this.dIO.dID;
                            if (view != tbSettingTextTipView4) {
                                tbSettingTextTipView5 = this.dIO.dII;
                                if (view != tbSettingTextTipView5) {
                                    tbSettingTextTipView6 = this.dIO.dIB;
                                    if (view != tbSettingTextTipView6) {
                                        return;
                                    }
                                    aVar2 = this.dIO.dIN;
                                    aVar2.aGw();
                                    return;
                                }
                                aVar3 = this.dIO.dIN;
                                aVar3.aGx();
                                return;
                            }
                            aVar4 = this.dIO.dIN;
                            aVar4.aGt();
                            return;
                        }
                        aVar5 = this.dIO.dIN;
                        aVar5.aGu();
                        return;
                    }
                    aVar6 = this.dIO.dIN;
                    aVar6.aGv();
                    return;
                }
                aVar7 = this.dIO.dIN;
                aVar7.aGs();
                return;
            }
            aVar8 = this.dIO.dIN;
            aVar8.onBackPressed();
        }
    }
}
