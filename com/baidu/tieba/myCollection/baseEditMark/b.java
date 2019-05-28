package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes6.dex */
public class b extends com.baidu.tbadk.baseEditMark.a {
    private MarkModel hsL;

    public b(BaseActivity baseActivity) {
        this.hsL = null;
        this.hsL = new MarkModel(baseActivity);
    }

    public b(BaseFragmentActivity baseFragmentActivity) {
        this.hsL = null;
        this.hsL = new MarkModel(baseFragmentActivity);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void ds(boolean z) {
        this.hsL.ds(z);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public String ZB() {
        return this.hsL.ZB();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(a.InterfaceC0236a interfaceC0236a) {
        this.hsL.a(interfaceC0236a);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void ZD() {
        this.hsL.ZD();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void ZE() {
        this.hsL.ZE();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public MarkData ZF() {
        return this.hsL.ZF();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(MarkData markData) {
        this.hsL.a(markData);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public boolean ZC() {
        return this.hsL.ZC();
    }
}
