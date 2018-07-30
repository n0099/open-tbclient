package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes3.dex */
public class b extends com.baidu.tbadk.baseEditMark.a {
    private MarkModel fkB;

    public b(BaseActivity baseActivity) {
        this.fkB = null;
        this.fkB = new MarkModel(baseActivity);
    }

    public b(BaseFragmentActivity baseFragmentActivity) {
        this.fkB = null;
        this.fkB = new MarkModel(baseFragmentActivity);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void ad(boolean z) {
        this.fkB.ad(z);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public String rM() {
        return this.fkB.rM();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(a.InterfaceC0097a interfaceC0097a) {
        this.fkB.a(interfaceC0097a);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void rO() {
        this.fkB.rO();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void rP() {
        this.fkB.rP();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public MarkData rQ() {
        return this.fkB.rQ();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(MarkData markData) {
        this.fkB.a(markData);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public boolean rN() {
        return this.fkB.rN();
    }
}
