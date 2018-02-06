package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes3.dex */
public class b extends com.baidu.tbadk.baseEditMark.a {
    private MarkModel fze;

    public b(BaseActivity baseActivity) {
        this.fze = null;
        this.fze = new MarkModel(baseActivity);
    }

    public b(BaseFragmentActivity baseFragmentActivity) {
        this.fze = null;
        this.fze = new MarkModel(baseFragmentActivity);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void aL(boolean z) {
        this.fze.aL(z);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public String vW() {
        return this.fze.vW();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(a.InterfaceC0092a interfaceC0092a) {
        this.fze.a(interfaceC0092a);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void vY() {
        this.fze.vY();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void vZ() {
        this.fze.vZ();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public MarkData wa() {
        return this.fze.wa();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(MarkData markData) {
        this.fze.a(markData);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public boolean vX() {
        return this.fze.vX();
    }
}
