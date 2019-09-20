package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes6.dex */
public class b extends com.baidu.tbadk.baseEditMark.a {
    private MarkModel hBM;

    public b(BaseActivity baseActivity) {
        this.hBM = null;
        this.hBM = new MarkModel(baseActivity);
    }

    public b(BaseFragmentActivity baseFragmentActivity) {
        this.hBM = null;
        this.hBM = new MarkModel(baseFragmentActivity);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void dx(boolean z) {
        this.hBM.dx(z);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public String aaE() {
        return this.hBM.aaE();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(a.InterfaceC0247a interfaceC0247a) {
        this.hBM.a(interfaceC0247a);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void aaG() {
        this.hBM.aaG();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void aaH() {
        this.hBM.aaH();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public MarkData aaI() {
        return this.hBM.aaI();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(MarkData markData) {
        this.hBM.a(markData);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public boolean aaF() {
        return this.hBM.aaF();
    }
}
