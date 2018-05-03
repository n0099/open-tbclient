package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes3.dex */
public class b extends com.baidu.tbadk.baseEditMark.a {
    private MarkModel eTQ;

    public b(BaseActivity baseActivity) {
        this.eTQ = null;
        this.eTQ = new MarkModel(baseActivity);
    }

    public b(BaseFragmentActivity baseFragmentActivity) {
        this.eTQ = null;
        this.eTQ = new MarkModel(baseFragmentActivity);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void ae(boolean z) {
        this.eTQ.ae(z);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public String oH() {
        return this.eTQ.oH();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(a.InterfaceC0082a interfaceC0082a) {
        this.eTQ.a(interfaceC0082a);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void oJ() {
        this.eTQ.oJ();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void oK() {
        this.eTQ.oK();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public MarkData oL() {
        return this.eTQ.oL();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(MarkData markData) {
        this.eTQ.a(markData);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public boolean oI() {
        return this.eTQ.oI();
    }
}
