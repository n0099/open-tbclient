package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes6.dex */
public class b extends com.baidu.tbadk.baseEditMark.a {
    private MarkModel hsM;

    public b(BaseActivity baseActivity) {
        this.hsM = null;
        this.hsM = new MarkModel(baseActivity);
    }

    public b(BaseFragmentActivity baseFragmentActivity) {
        this.hsM = null;
        this.hsM = new MarkModel(baseFragmentActivity);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void ds(boolean z) {
        this.hsM.ds(z);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public String ZB() {
        return this.hsM.ZB();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(a.InterfaceC0236a interfaceC0236a) {
        this.hsM.a(interfaceC0236a);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void ZD() {
        this.hsM.ZD();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void ZE() {
        this.hsM.ZE();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public MarkData ZF() {
        return this.hsM.ZF();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(MarkData markData) {
        this.hsM.a(markData);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public boolean ZC() {
        return this.hsM.ZC();
    }
}
