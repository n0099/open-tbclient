package com.baidu.tieba.personInfo;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq extends com.baidu.adp.base.g {
    final /* synthetic */ f this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(f fVar) {
        this.this$0 = fVar;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        bj bjVar;
        bj bjVar2;
        bj bjVar3;
        bg bgVar;
        bj bjVar4;
        bg bgVar2;
        bj bjVar5;
        bj bjVar6;
        FrameLayout frameLayout;
        com.baidu.tieba.person.a.as asVar;
        FrameLayout frameLayout2;
        com.baidu.tieba.person.a.as asVar2;
        bg bgVar3;
        FrameLayout frameLayout3;
        bg bgVar4;
        this.this$0.dFQ = false;
        bjVar = this.this$0.dFA;
        if (bjVar != null) {
            bjVar2 = this.this$0.dFA;
            bjVar2.Pn();
            if (obj == null || !(obj instanceof Integer) || ((Integer) obj).intValue() != 3) {
                this.this$0.aDg();
                bjVar3 = this.this$0.dFA;
                bjVar3.d(new ar(this));
                bgVar = this.this$0.dyP;
                if (bgVar.aDT() != null) {
                    f fVar = this.this$0;
                    bgVar3 = this.this$0.dyP;
                    fVar.dFK = bgVar3.aDT().getPhotoAlbum();
                }
                bjVar4 = this.this$0.dFA;
                com.baidu.tieba.person.a.b bVar = bjVar4.dHO;
                bgVar2 = this.this$0.dyP;
                bVar.ac(bgVar2.getDataList());
                bjVar5 = this.this$0.dFA;
                bjVar5.dHO.notifyDataSetChanged();
                bjVar6 = this.this$0.dFA;
                bjVar6.aEm();
                if (obj != null && (obj instanceof Integer)) {
                    f fVar2 = this.this$0;
                    frameLayout = this.this$0.dFH;
                    fVar2.aH(frameLayout);
                    asVar = this.this$0.dFI;
                    if (asVar != null) {
                        asVar2 = this.this$0.dFI;
                        asVar2.hn(false);
                    }
                    this.this$0.aDy();
                    if (((Integer) obj).intValue() == 1) {
                        this.this$0.cST = true;
                        this.this$0.dFD = false;
                        this.this$0.Pg();
                        return;
                    } else if (((Integer) obj).intValue() == 0 && this.this$0.getPageContext() != null && this.this$0.getPageContext().getResources() != null) {
                        f fVar3 = this.this$0;
                        frameLayout2 = this.this$0.dFH;
                        fVar3.showNetRefreshView(frameLayout2, this.this$0.getPageContext().getResources().getString(t.j.neterror), false);
                        return;
                    } else {
                        return;
                    }
                }
                return;
            }
            f fVar4 = this.this$0;
            frameLayout3 = this.this$0.dFH;
            fVar4.a((View) frameLayout3, false, -1);
            bgVar4 = this.this$0.dyP;
            bgVar4.aDI();
        }
    }
}
