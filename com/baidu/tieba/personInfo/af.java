package com.baidu.tieba.personInfo;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af extends com.baidu.adp.base.g {
    final /* synthetic */ d cSn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(d dVar) {
        this.cSn = dVar;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        az azVar;
        az azVar2;
        az azVar3;
        aw awVar;
        az azVar4;
        aw awVar2;
        az azVar5;
        az azVar6;
        FrameLayout frameLayout;
        com.baidu.tieba.person.a.ad adVar;
        FrameLayout frameLayout2;
        com.baidu.tieba.person.a.ad adVar2;
        aw awVar3;
        FrameLayout frameLayout3;
        aw awVar4;
        azVar = this.cSn.cRH;
        if (azVar != null) {
            azVar2 = this.cSn.cRH;
            azVar2.hideProgress();
            if (obj == null || !(obj instanceof Integer) || ((Integer) obj).intValue() != 3) {
                azVar3 = this.cSn.cRH;
                azVar3.b(new ag(this));
                awVar = this.cSn.cMT;
                if (awVar.apq() != null) {
                    d dVar = this.cSn;
                    awVar3 = this.cSn.cMT;
                    dVar.cRP = awVar3.apq().getPhotoAlbum();
                }
                azVar4 = this.cSn.cRH;
                com.baidu.tieba.person.a.b bVar = azVar4.cTA;
                awVar2 = this.cSn.cMT;
                bVar.J(awVar2.getDataList());
                azVar5 = this.cSn.cRH;
                azVar5.cTA.notifyDataSetChanged();
                azVar6 = this.cSn.cRH;
                azVar6.apB();
                if (obj != null && (obj instanceof Integer)) {
                    d dVar2 = this.cSn;
                    frameLayout = this.cSn.cRM;
                    dVar2.ao(frameLayout);
                    adVar = this.cSn.cRN;
                    if (adVar != null) {
                        adVar2 = this.cSn.cRN;
                        adVar2.fG(false);
                    }
                    this.cSn.aoS();
                    if (((Integer) obj).intValue() == 1) {
                        this.cSn.cyc = true;
                        this.cSn.cRK = false;
                        this.cSn.TI();
                        return;
                    } else if (((Integer) obj).intValue() == 0 && this.cSn.getPageContext() != null && this.cSn.getPageContext().getResources() != null) {
                        d dVar3 = this.cSn;
                        frameLayout2 = this.cSn.cRM;
                        dVar3.showNetRefreshView(frameLayout2, this.cSn.getPageContext().getResources().getString(n.i.neterror), false);
                        return;
                    } else {
                        return;
                    }
                }
                return;
            }
            d dVar4 = this.cSn;
            frameLayout3 = this.cSn.cRM;
            dVar4.a((View) frameLayout3, false, -1);
            awVar4 = this.cSn.cMT;
            awVar4.aph();
        }
    }
}
