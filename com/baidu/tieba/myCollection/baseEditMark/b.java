package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes3.dex */
public class b extends com.baidu.tbadk.baseEditMark.a {
    private MarkModel eTT;

    public b(BaseActivity baseActivity) {
        this.eTT = null;
        this.eTT = new MarkModel(baseActivity);
    }

    public b(BaseFragmentActivity baseFragmentActivity) {
        this.eTT = null;
        this.eTT = new MarkModel(baseFragmentActivity);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void ae(boolean z) {
        this.eTT.ae(z);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public String oH() {
        return this.eTT.oH();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(a.InterfaceC0082a interfaceC0082a) {
        this.eTT.a(interfaceC0082a);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void oJ() {
        this.eTT.oJ();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void oK() {
        this.eTT.oK();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public MarkData oL() {
        return this.eTT.oL();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(MarkData markData) {
        this.eTT.a(markData);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public boolean oI() {
        return this.eTT.oI();
    }
}
