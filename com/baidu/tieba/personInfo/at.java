package com.baidu.tieba.personInfo;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at extends com.baidu.adp.base.g {
    final /* synthetic */ f this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(f fVar) {
        this.this$0 = fVar;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        bs bsVar;
        bs bsVar2;
        bs bsVar3;
        bp bpVar;
        bs bsVar4;
        bp bpVar2;
        bs bsVar5;
        bs bsVar6;
        FrameLayout frameLayout;
        com.baidu.tieba.person.a.at atVar;
        FrameLayout frameLayout2;
        com.baidu.tieba.person.a.at atVar2;
        bp bpVar3;
        FrameLayout frameLayout3;
        bp bpVar4;
        this.this$0.eoU = false;
        bsVar = this.this$0.eoE;
        if (bsVar != null) {
            bsVar2 = this.this$0.eoE;
            bsVar2.US();
            if (obj == null || !(obj instanceof Integer) || ((Integer) obj).intValue() != 3) {
                this.this$0.aMb();
                bsVar3 = this.this$0.eoE;
                bsVar3.d(new au(this));
                bpVar = this.this$0.eht;
                if (bpVar.aMO() != null) {
                    f fVar = this.this$0;
                    bpVar3 = this.this$0.eht;
                    fVar.eoO = bpVar3.aMO().getPhotoAlbum();
                }
                bsVar4 = this.this$0.eoE;
                com.baidu.tieba.person.a.b bVar = bsVar4.eqT;
                bpVar2 = this.this$0.eht;
                bVar.an(bpVar2.getDataList());
                bsVar5 = this.this$0.eoE;
                bsVar5.eqT.notifyDataSetChanged();
                bsVar6 = this.this$0.eoE;
                bsVar6.aNg();
                if (obj != null && (obj instanceof Integer)) {
                    f fVar2 = this.this$0;
                    frameLayout = this.this$0.eoL;
                    fVar2.aw(frameLayout);
                    atVar = this.this$0.eoM;
                    if (atVar != null) {
                        atVar2 = this.this$0.eoM;
                        atVar2.ii(false);
                    }
                    this.this$0.aMt();
                    if (((Integer) obj).intValue() == 1) {
                        this.this$0.dyP = true;
                        this.this$0.eoH = false;
                        this.this$0.IM();
                        return;
                    } else if (((Integer) obj).intValue() == 0 && this.this$0.getPageContext() != null && this.this$0.getPageContext().getResources() != null) {
                        f fVar3 = this.this$0;
                        frameLayout2 = this.this$0.eoL;
                        fVar3.showNetRefreshView(frameLayout2, this.this$0.getPageContext().getResources().getString(u.j.neterror), false);
                        return;
                    } else {
                        return;
                    }
                }
                return;
            }
            f fVar4 = this.this$0;
            frameLayout3 = this.this$0.eoL;
            fVar4.a((View) frameLayout3, false, -1);
            bpVar4 = this.this$0.eht;
            bpVar4.aMD();
        }
    }
}
