package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes3.dex */
public class b extends com.baidu.tbadk.baseEditMark.a {
    private MarkModel fzi;

    public b(BaseActivity baseActivity) {
        this.fzi = null;
        this.fzi = new MarkModel(baseActivity);
    }

    public b(BaseFragmentActivity baseFragmentActivity) {
        this.fzi = null;
        this.fzi = new MarkModel(baseFragmentActivity);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void aL(boolean z) {
        this.fzi.aL(z);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public String vW() {
        return this.fzi.vW();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(a.InterfaceC0093a interfaceC0093a) {
        this.fzi.a(interfaceC0093a);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void vY() {
        this.fzi.vY();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void vZ() {
        this.fzi.vZ();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public MarkData wa() {
        return this.fzi.wa();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(MarkData markData) {
        this.fzi.a(markData);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public boolean vX() {
        return this.fzi.vX();
    }
}
