package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes6.dex */
public class b extends com.baidu.tbadk.baseEditMark.a {
    private MarkModel hsI;

    public b(BaseActivity baseActivity) {
        this.hsI = null;
        this.hsI = new MarkModel(baseActivity);
    }

    public b(BaseFragmentActivity baseFragmentActivity) {
        this.hsI = null;
        this.hsI = new MarkModel(baseFragmentActivity);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void ds(boolean z) {
        this.hsI.ds(z);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public String ZB() {
        return this.hsI.ZB();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(a.InterfaceC0236a interfaceC0236a) {
        this.hsI.a(interfaceC0236a);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void ZD() {
        this.hsI.ZD();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void ZE() {
        this.hsI.ZE();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public MarkData ZF() {
        return this.hsI.ZF();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(MarkData markData) {
        this.hsI.a(markData);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public boolean ZC() {
        return this.hsI.ZC();
    }
}
