package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes3.dex */
public class b extends com.baidu.tbadk.baseEditMark.a {
    private MarkModel fHK;

    public b(BaseActivity baseActivity) {
        this.fHK = null;
        this.fHK = new MarkModel(baseActivity);
    }

    public b(BaseFragmentActivity baseFragmentActivity) {
        this.fHK = null;
        this.fHK = new MarkModel(baseFragmentActivity);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void aP(boolean z) {
        this.fHK.aP(z);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public String wp() {
        return this.fHK.wp();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(a.InterfaceC0154a interfaceC0154a) {
        this.fHK.a(interfaceC0154a);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void wr() {
        this.fHK.wr();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void ws() {
        this.fHK.ws();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public MarkData wt() {
        return this.fHK.wt();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(MarkData markData) {
        this.fHK.a(markData);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public boolean wq() {
        return this.fHK.wq();
    }
}
