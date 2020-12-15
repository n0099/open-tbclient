package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes24.dex */
public class b extends com.baidu.tbadk.baseEditMark.a {
    private MarkModel loH;

    public b(BaseActivity baseActivity) {
        this.loH = null;
        this.loH = new MarkModel(baseActivity);
    }

    public b(BaseFragmentActivity baseFragmentActivity) {
        this.loH = null;
        this.loH = new MarkModel(baseFragmentActivity);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void iH(boolean z) {
        this.loH.iH(z);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public String bkX() {
        return this.loH.bkX();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(a.InterfaceC0583a interfaceC0583a) {
        this.loH.a(interfaceC0583a);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void bkZ() {
        this.loH.bkZ();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void bla() {
        this.loH.bla();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public MarkData blb() {
        return this.loH.blb();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(MarkData markData) {
        this.loH.a(markData);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public boolean bkY() {
        return this.loH.bkY();
    }
}
