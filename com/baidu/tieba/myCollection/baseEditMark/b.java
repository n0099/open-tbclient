package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes18.dex */
public class b extends com.baidu.tbadk.baseEditMark.a {
    private MarkModel kkA;

    public b(BaseActivity baseActivity) {
        this.kkA = null;
        this.kkA = new MarkModel(baseActivity);
    }

    public b(BaseFragmentActivity baseFragmentActivity) {
        this.kkA = null;
        this.kkA = new MarkModel(baseFragmentActivity);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void hA(boolean z) {
        this.kkA.hA(z);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public String baz() {
        return this.kkA.baz();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(a.InterfaceC0535a interfaceC0535a) {
        this.kkA.a(interfaceC0535a);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void baB() {
        this.kkA.baB();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void baC() {
        this.kkA.baC();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public MarkData baD() {
        return this.kkA.baD();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(MarkData markData) {
        this.kkA.a(markData);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public boolean baA() {
        return this.kkA.baA();
    }
}
