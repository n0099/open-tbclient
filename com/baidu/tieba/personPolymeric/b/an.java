package com.baidu.tieba.personPolymeric.b;

import com.baidu.tieba.e.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements a.InterfaceC0062a {
    final /* synthetic */ ak eVM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(ak akVar) {
        this.eVM = akVar;
    }

    @Override // com.baidu.tieba.e.a.InterfaceC0062a
    public void ah(int i, int i2) {
        at atVar;
        at atVar2;
        at atVar3;
        at atVar4;
        if (Y(i2)) {
            atVar = this.eVM.eVH;
            if (atVar != null) {
                atVar2 = this.eVM.eVH;
                if (atVar2.eVR != null) {
                    atVar3 = this.eVM.eVH;
                    atVar3.eVR.ee(false);
                    atVar4 = this.eVM.eVH;
                    atVar4.eVR.showFloatingView();
                }
            }
        }
    }

    @Override // com.baidu.tieba.e.a.InterfaceC0062a
    public void ai(int i, int i2) {
        at atVar;
        at atVar2;
        at atVar3;
        at atVar4;
        if (Y(i2)) {
            atVar = this.eVM.eVH;
            if (atVar != null) {
                atVar2 = this.eVM.eVH;
                if (atVar2.eVR != null) {
                    atVar3 = this.eVM.eVH;
                    atVar3.eVR.ee(true);
                    atVar4 = this.eVM.eVH;
                    atVar4.eVR.hideFloatingView();
                }
            }
        }
    }

    private boolean Y(float f) {
        return Math.abs(f) >= 1.0f;
    }
}
