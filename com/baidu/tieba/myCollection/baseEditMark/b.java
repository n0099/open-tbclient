package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes6.dex */
public class b extends com.baidu.tbadk.baseEditMark.a {
    private MarkModel hbD;

    public b(BaseActivity baseActivity) {
        this.hbD = null;
        this.hbD = new MarkModel(baseActivity);
    }

    public b(BaseFragmentActivity baseFragmentActivity) {
        this.hbD = null;
        this.hbD = new MarkModel(baseFragmentActivity);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void cZ(boolean z) {
        this.hbD.cZ(z);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public String Va() {
        return this.hbD.Va();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(a.InterfaceC0221a interfaceC0221a) {
        this.hbD.a(interfaceC0221a);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void Vc() {
        this.hbD.Vc();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void Vd() {
        this.hbD.Vd();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public MarkData Ve() {
        return this.hbD.Ve();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(MarkData markData) {
        this.hbD.a(markData);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public boolean Vb() {
        return this.hbD.Vb();
    }
}
