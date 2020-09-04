package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes18.dex */
public class b extends com.baidu.tbadk.baseEditMark.a {
    private MarkModel kkH;

    public b(BaseActivity baseActivity) {
        this.kkH = null;
        this.kkH = new MarkModel(baseActivity);
    }

    public b(BaseFragmentActivity baseFragmentActivity) {
        this.kkH = null;
        this.kkH = new MarkModel(baseFragmentActivity);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void hB(boolean z) {
        this.kkH.hB(z);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public String baz() {
        return this.kkH.baz();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(a.InterfaceC0535a interfaceC0535a) {
        this.kkH.a(interfaceC0535a);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void baB() {
        this.kkH.baB();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void baC() {
        this.kkH.baC();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public MarkData baD() {
        return this.kkH.baD();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(MarkData markData) {
        this.kkH.a(markData);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public boolean baA() {
        return this.kkH.baA();
    }
}
