package com.baidu.tieba.personInfo;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak extends com.baidu.adp.base.g {
    final /* synthetic */ d cWV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(d dVar) {
        this.cWV = dVar;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        be beVar;
        be beVar2;
        be beVar3;
        bb bbVar;
        be beVar4;
        bb bbVar2;
        be beVar5;
        be beVar6;
        FrameLayout frameLayout;
        com.baidu.tieba.person.a.ah ahVar;
        FrameLayout frameLayout2;
        com.baidu.tieba.person.a.ah ahVar2;
        bb bbVar3;
        FrameLayout frameLayout3;
        bb bbVar4;
        this.cWV.cWy = false;
        beVar = this.cWV.cWi;
        if (beVar != null) {
            beVar2 = this.cWV.cWi;
            beVar2.hideProgress();
            if (obj == null || !(obj instanceof Integer) || ((Integer) obj).intValue() != 3) {
                beVar3 = this.cWV.cWi;
                beVar3.b(new al(this));
                bbVar = this.cWV.cRx;
                if (bbVar.aqF() != null) {
                    d dVar = this.cWV;
                    bbVar3 = this.cWV.cRx;
                    dVar.cWs = bbVar3.aqF().getPhotoAlbum();
                }
                beVar4 = this.cWV.cWi;
                com.baidu.tieba.person.a.b bVar = beVar4.cYm;
                bbVar2 = this.cWV.cRx;
                bVar.Z(bbVar2.getDataList());
                beVar5 = this.cWV.cWi;
                beVar5.cYm.notifyDataSetChanged();
                beVar6 = this.cWV.cWi;
                beVar6.aqQ();
                if (obj != null && (obj instanceof Integer)) {
                    d dVar2 = this.cWV;
                    frameLayout = this.cWV.cWp;
                    dVar2.au(frameLayout);
                    ahVar = this.cWV.cWq;
                    if (ahVar != null) {
                        ahVar2 = this.cWV.cWq;
                        ahVar2.fF(false);
                    }
                    this.cWV.aqd();
                    if (((Integer) obj).intValue() == 1) {
                        this.cWV.cBJ = true;
                        this.cWV.cWl = false;
                        this.cWV.aqe();
                        return;
                    } else if (((Integer) obj).intValue() == 0 && this.cWV.getPageContext() != null && this.cWV.getPageContext().getResources() != null) {
                        d dVar3 = this.cWV;
                        frameLayout2 = this.cWV.cWp;
                        dVar3.showNetRefreshView(frameLayout2, this.cWV.getPageContext().getResources().getString(n.j.neterror), false);
                        return;
                    } else {
                        return;
                    }
                }
                return;
            }
            d dVar4 = this.cWV;
            frameLayout3 = this.cWV.cWp;
            dVar4.a((View) frameLayout3, false, -1);
            bbVar4 = this.cWV.cRx;
            bbVar4.aqu();
        }
    }
}
