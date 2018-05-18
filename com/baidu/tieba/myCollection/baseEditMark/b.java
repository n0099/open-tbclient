package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes3.dex */
public class b extends com.baidu.tbadk.baseEditMark.a {
    private MarkModel eUX;

    public b(BaseActivity baseActivity) {
        this.eUX = null;
        this.eUX = new MarkModel(baseActivity);
    }

    public b(BaseFragmentActivity baseFragmentActivity) {
        this.eUX = null;
        this.eUX = new MarkModel(baseFragmentActivity);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void ae(boolean z) {
        this.eUX.ae(z);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public String oG() {
        return this.eUX.oG();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(a.InterfaceC0082a interfaceC0082a) {
        this.eUX.a(interfaceC0082a);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void oI() {
        this.eUX.oI();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void oJ() {
        this.eUX.oJ();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public MarkData oK() {
        return this.eUX.oK();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(MarkData markData) {
        this.eUX.a(markData);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public boolean oH() {
        return this.eUX.oH();
    }
}
