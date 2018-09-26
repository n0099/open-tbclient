package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes3.dex */
public class b extends com.baidu.tbadk.baseEditMark.a {
    private MarkModel frS;

    public b(BaseActivity baseActivity) {
        this.frS = null;
        this.frS = new MarkModel(baseActivity);
    }

    public b(BaseFragmentActivity baseFragmentActivity) {
        this.frS = null;
        this.frS = new MarkModel(baseFragmentActivity);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void an(boolean z) {
        this.frS.an(z);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public String sQ() {
        return this.frS.sQ();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(a.InterfaceC0096a interfaceC0096a) {
        this.frS.a(interfaceC0096a);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void sS() {
        this.frS.sS();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void sT() {
        this.frS.sT();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public MarkData sU() {
        return this.frS.sU();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(MarkData markData) {
        this.frS.a(markData);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public boolean sR() {
        return this.frS.sR();
    }
}
