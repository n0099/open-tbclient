package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes6.dex */
public class b extends com.baidu.tbadk.baseEditMark.a {
    private MarkModel hzQ;

    public b(BaseActivity baseActivity) {
        this.hzQ = null;
        this.hzQ = new MarkModel(baseActivity);
    }

    public b(BaseFragmentActivity baseFragmentActivity) {
        this.hzQ = null;
        this.hzQ = new MarkModel(baseFragmentActivity);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void dx(boolean z) {
        this.hzQ.dx(z);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public String aaA() {
        return this.hzQ.aaA();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(a.InterfaceC0238a interfaceC0238a) {
        this.hzQ.a(interfaceC0238a);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void aaC() {
        this.hzQ.aaC();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void aaD() {
        this.hzQ.aaD();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public MarkData aaE() {
        return this.hzQ.aaE();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(MarkData markData) {
        this.hzQ.a(markData);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public boolean aaB() {
        return this.hzQ.aaB();
    }
}
