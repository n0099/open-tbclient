package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes3.dex */
public class b extends com.baidu.tbadk.baseEditMark.a {
    private MarkModel fKC;

    public b(BaseActivity baseActivity) {
        this.fKC = null;
        this.fKC = new MarkModel(baseActivity);
    }

    public b(BaseFragmentActivity baseFragmentActivity) {
        this.fKC = null;
        this.fKC = new MarkModel(baseFragmentActivity);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void aP(boolean z) {
        this.fKC.aP(z);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public String wp() {
        return this.fKC.wp();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(a.InterfaceC0154a interfaceC0154a) {
        this.fKC.a(interfaceC0154a);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void wr() {
        this.fKC.wr();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void ws() {
        this.fKC.ws();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public MarkData wt() {
        return this.fKC.wt();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(MarkData markData) {
        this.fKC.a(markData);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public boolean wq() {
        return this.fKC.wq();
    }
}
