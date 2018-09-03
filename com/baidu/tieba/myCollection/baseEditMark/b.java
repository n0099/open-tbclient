package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes3.dex */
public class b extends com.baidu.tbadk.baseEditMark.a {
    private MarkModel fkv;

    public b(BaseActivity baseActivity) {
        this.fkv = null;
        this.fkv = new MarkModel(baseActivity);
    }

    public b(BaseFragmentActivity baseFragmentActivity) {
        this.fkv = null;
        this.fkv = new MarkModel(baseFragmentActivity);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void ae(boolean z) {
        this.fkv.ae(z);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public String rK() {
        return this.fkv.rK();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(a.InterfaceC0097a interfaceC0097a) {
        this.fkv.a(interfaceC0097a);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void rM() {
        this.fkv.rM();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void rN() {
        this.fkv.rN();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public MarkData rO() {
        return this.fkv.rO();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(MarkData markData) {
        this.fkv.a(markData);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public boolean rL() {
        return this.fkv.rL();
    }
}
