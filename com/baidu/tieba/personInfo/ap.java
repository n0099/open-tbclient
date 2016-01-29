package com.baidu.tieba.personInfo;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap extends com.baidu.adp.base.g {
    final /* synthetic */ f diG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(f fVar) {
        this.diG = fVar;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        bi biVar;
        bi biVar2;
        bi biVar3;
        bf bfVar;
        bi biVar4;
        bf bfVar2;
        bi biVar5;
        bi biVar6;
        FrameLayout frameLayout;
        com.baidu.tieba.person.a.al alVar;
        FrameLayout frameLayout2;
        com.baidu.tieba.person.a.al alVar2;
        bf bfVar3;
        FrameLayout frameLayout3;
        bf bfVar4;
        this.diG.dih = false;
        biVar = this.diG.dhR;
        if (biVar != null) {
            biVar2 = this.diG.dhR;
            biVar2.Oz();
            if (obj == null || !(obj instanceof Integer) || ((Integer) obj).intValue() != 3) {
                this.diG.avd();
                biVar3 = this.diG.dhR;
                biVar3.b(new aq(this));
                bfVar = this.diG.dbl;
                if (bfVar.avP() != null) {
                    f fVar = this.diG;
                    bfVar3 = this.diG.dbl;
                    fVar.dib = bfVar3.avP().getPhotoAlbum();
                }
                biVar4 = this.diG.dhR;
                com.baidu.tieba.person.a.b bVar = biVar4.djZ;
                bfVar2 = this.diG.dbl;
                bVar.aa(bfVar2.getDataList());
                biVar5 = this.diG.dhR;
                biVar5.djZ.notifyDataSetChanged();
                biVar6 = this.diG.dhR;
                biVar6.awh();
                if (obj != null && (obj instanceof Integer)) {
                    f fVar2 = this.diG;
                    frameLayout = this.diG.dhY;
                    fVar2.aK(frameLayout);
                    alVar = this.diG.dhZ;
                    if (alVar != null) {
                        alVar2 = this.diG.dhZ;
                        alVar2.fU(false);
                    }
                    this.diG.avu();
                    if (((Integer) obj).intValue() == 1) {
                        this.diG.cIp = true;
                        this.diG.dhU = false;
                        this.diG.avv();
                        return;
                    } else if (((Integer) obj).intValue() == 0 && this.diG.getPageContext() != null && this.diG.getPageContext().getResources() != null) {
                        f fVar3 = this.diG;
                        frameLayout2 = this.diG.dhY;
                        fVar3.showNetRefreshView(frameLayout2, this.diG.getPageContext().getResources().getString(t.j.neterror), false);
                        return;
                    } else {
                        return;
                    }
                }
                return;
            }
            f fVar4 = this.diG;
            frameLayout3 = this.diG.dhY;
            fVar4.a((View) frameLayout3, false, -1);
            bfVar4 = this.diG.dbl;
            bfVar4.avF();
        }
    }
}
