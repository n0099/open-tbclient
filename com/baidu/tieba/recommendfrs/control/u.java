package com.baidu.tieba.recommendfrs.control;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.c.c;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements c.InterfaceC0053c {
    final int bhm = com.baidu.adp.lib.util.k.c(TbadkCoreApplication.m11getInst(), t.e.ds98);
    final /* synthetic */ q dZi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(q qVar) {
        this.dZi = qVar;
    }

    @Override // com.baidu.tieba.c.c.InterfaceC0053c
    public void O(int i, int i2) {
        m mVar;
        m mVar2;
        m mVar3;
        if (v(i2)) {
            mVar = this.dZi.dYj;
            if (mVar != null) {
                mVar2 = this.dZi.dYj;
                mVar2.cX(false);
                mVar3 = this.dZi.dYj;
                mVar3.iN(false);
            }
        }
    }

    @Override // com.baidu.tieba.c.c.InterfaceC0053c
    public void P(int i, int i2) {
        m mVar;
        m mVar2;
        m mVar3;
        if (v(i2)) {
            mVar = this.dZi.dYj;
            if (mVar != null) {
                mVar2 = this.dZi.dYj;
                mVar2.cX(true);
                if (Math.abs(i2) > this.bhm) {
                    mVar3 = this.dZi.dYj;
                    mVar3.iM(false);
                }
            }
        }
    }

    private boolean v(float f) {
        return Math.abs(f) >= 1.0f;
    }
}
