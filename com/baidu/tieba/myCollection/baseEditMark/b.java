package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes18.dex */
public class b extends com.baidu.tbadk.baseEditMark.a {
    private MarkModel jVc;

    public b(BaseActivity baseActivity) {
        this.jVc = null;
        this.jVc = new MarkModel(baseActivity);
    }

    public b(BaseFragmentActivity baseFragmentActivity) {
        this.jVc = null;
        this.jVc = new MarkModel(baseFragmentActivity);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void he(boolean z) {
        this.jVc.he(z);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public String aSi() {
        return this.jVc.aSi();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(a.InterfaceC0489a interfaceC0489a) {
        this.jVc.a(interfaceC0489a);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void aSk() {
        this.jVc.aSk();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void aSl() {
        this.jVc.aSl();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public MarkData aSm() {
        return this.jVc.aSm();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(MarkData markData) {
        this.jVc.a(markData);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public boolean aSj() {
        return this.jVc.aSj();
    }
}
