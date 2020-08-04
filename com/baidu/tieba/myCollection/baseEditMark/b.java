package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes18.dex */
public class b extends com.baidu.tbadk.baseEditMark.a {
    private MarkModel jVe;

    public b(BaseActivity baseActivity) {
        this.jVe = null;
        this.jVe = new MarkModel(baseActivity);
    }

    public b(BaseFragmentActivity baseFragmentActivity) {
        this.jVe = null;
        this.jVe = new MarkModel(baseFragmentActivity);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void he(boolean z) {
        this.jVe.he(z);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public String aSi() {
        return this.jVe.aSi();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(a.InterfaceC0489a interfaceC0489a) {
        this.jVe.a(interfaceC0489a);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void aSk() {
        this.jVe.aSk();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void aSl() {
        this.jVe.aSl();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public MarkData aSm() {
        return this.jVe.aSm();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(MarkData markData) {
        this.jVe.a(markData);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public boolean aSj() {
        return this.jVe.aSj();
    }
}
