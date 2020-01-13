package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes9.dex */
public class b extends com.baidu.tbadk.baseEditMark.a {
    private MarkModel irm;

    public b(BaseActivity baseActivity) {
        this.irm = null;
        this.irm = new MarkModel(baseActivity);
    }

    public b(BaseFragmentActivity baseFragmentActivity) {
        this.irm = null;
        this.irm = new MarkModel(baseFragmentActivity);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void ff(boolean z) {
        this.irm.ff(z);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public String awv() {
        return this.irm.awv();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(a.InterfaceC0364a interfaceC0364a) {
        this.irm.a(interfaceC0364a);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void awx() {
        this.irm.awx();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void awy() {
        this.irm.awy();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public MarkData awz() {
        return this.irm.awz();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(MarkData markData) {
        this.irm.a(markData);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public boolean aww() {
        return this.irm.aww();
    }
}
