package com.baidu.tieba.personInfo;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap extends com.baidu.adp.base.g {
    final /* synthetic */ f this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(f fVar) {
        this.this$0 = fVar;
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
        this.this$0.dCJ = false;
        biVar = this.this$0.dCt;
        if (biVar != null) {
            biVar2 = this.this$0.dCt;
            biVar2.Qo();
            if (obj == null || !(obj instanceof Integer) || ((Integer) obj).intValue() != 3) {
                this.this$0.aCJ();
                biVar3 = this.this$0.dCt;
                biVar3.b(new aq(this));
                bfVar = this.this$0.dvN;
                if (bfVar.aDu() != null) {
                    f fVar = this.this$0;
                    bfVar3 = this.this$0.dvN;
                    fVar.dCD = bfVar3.aDu().getPhotoAlbum();
                }
                biVar4 = this.this$0.dCt;
                com.baidu.tieba.person.a.b bVar = biVar4.dEz;
                bfVar2 = this.this$0.dvN;
                bVar.ab(bfVar2.getDataList());
                biVar5 = this.this$0.dCt;
                biVar5.dEz.notifyDataSetChanged();
                biVar6 = this.this$0.dCt;
                biVar6.aDM();
                if (obj != null && (obj instanceof Integer)) {
                    f fVar2 = this.this$0;
                    frameLayout = this.this$0.dCA;
                    fVar2.aD(frameLayout);
                    alVar = this.this$0.dCB;
                    if (alVar != null) {
                        alVar2 = this.this$0.dCB;
                        alVar2.gH(false);
                    }
                    this.this$0.aDa();
                    if (((Integer) obj).intValue() == 1) {
                        this.this$0.dbx = true;
                        this.this$0.dCw = false;
                        this.this$0.XY();
                        return;
                    } else if (((Integer) obj).intValue() == 0 && this.this$0.getPageContext() != null && this.this$0.getPageContext().getResources() != null) {
                        f fVar3 = this.this$0;
                        frameLayout2 = this.this$0.dCA;
                        fVar3.showNetRefreshView(frameLayout2, this.this$0.getPageContext().getResources().getString(t.j.neterror), false);
                        return;
                    } else {
                        return;
                    }
                }
                return;
            }
            f fVar4 = this.this$0;
            frameLayout3 = this.this$0.dCA;
            fVar4.a((View) frameLayout3, false, -1);
            bfVar4 = this.this$0.dvN;
            bfVar4.aDk();
        }
    }
}
