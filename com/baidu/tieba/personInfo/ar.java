package com.baidu.tieba.personInfo;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar extends com.baidu.adp.base.g {
    final /* synthetic */ h this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(h hVar) {
        this.this$0 = hVar;
    }

    @Override // com.baidu.adp.base.g
    public void g(Object obj) {
        bq bqVar;
        bq bqVar2;
        bq bqVar3;
        bn bnVar;
        bq bqVar4;
        bn bnVar2;
        bq bqVar5;
        bq bqVar6;
        FrameLayout frameLayout;
        com.baidu.tieba.person.a.ar arVar;
        FrameLayout frameLayout2;
        com.baidu.tieba.person.a.ar arVar2;
        bn bnVar3;
        FrameLayout frameLayout3;
        bn bnVar4;
        this.this$0.eAK = false;
        bqVar = this.this$0.eAu;
        if (bqVar != null) {
            bqVar2 = this.this$0.eAu;
            bqVar2.aap();
            if (obj == null || !(obj instanceof Integer) || ((Integer) obj).intValue() != 3) {
                this.this$0.aPg();
                bqVar3 = this.this$0.eAu;
                bqVar3.d(new as(this));
                bnVar = this.this$0.ers;
                if (bnVar.aPR() != null) {
                    h hVar = this.this$0;
                    bnVar3 = this.this$0.ers;
                    hVar.eAE = bnVar3.aPR().getPhotoAlbum();
                }
                bqVar4 = this.this$0.eAu;
                com.baidu.tieba.person.a.b bVar = bqVar4.eCE;
                bnVar2 = this.this$0.ers;
                bVar.ap(bnVar2.getDataList());
                bqVar5 = this.this$0.eAu;
                bqVar5.eCE.notifyDataSetChanged();
                bqVar6 = this.this$0.eAu;
                bqVar6.aQj();
                if (obj != null && (obj instanceof Integer)) {
                    h hVar2 = this.this$0;
                    frameLayout = this.this$0.eAB;
                    hVar2.au(frameLayout);
                    arVar = this.this$0.eAC;
                    if (arVar != null) {
                        arVar2 = this.this$0.eAC;
                        arVar2.ir(false);
                    }
                    this.this$0.aPy();
                    if (((Integer) obj).intValue() == 1) {
                        this.this$0.dCV = true;
                        this.this$0.eAx = false;
                        this.this$0.IL();
                        return;
                    } else if (((Integer) obj).intValue() == 0 && this.this$0.getPageContext() != null && this.this$0.getPageContext().getResources() != null) {
                        h hVar3 = this.this$0;
                        frameLayout2 = this.this$0.eAB;
                        hVar3.showNetRefreshView(frameLayout2, this.this$0.getPageContext().getResources().getString(u.j.neterror), false);
                        return;
                    } else {
                        return;
                    }
                }
                return;
            }
            h hVar4 = this.this$0;
            frameLayout3 = this.this$0.eAB;
            hVar4.a((View) frameLayout3, false, -1);
            bnVar4 = this.this$0.ers;
            bnVar4.aPI();
        }
    }
}
