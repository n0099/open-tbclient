package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes24.dex */
public class b extends com.baidu.tbadk.baseEditMark.a {
    private MarkModel loF;

    public b(BaseActivity baseActivity) {
        this.loF = null;
        this.loF = new MarkModel(baseActivity);
    }

    public b(BaseFragmentActivity baseFragmentActivity) {
        this.loF = null;
        this.loF = new MarkModel(baseFragmentActivity);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void iH(boolean z) {
        this.loF.iH(z);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public String bkX() {
        return this.loF.bkX();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(a.InterfaceC0583a interfaceC0583a) {
        this.loF.a(interfaceC0583a);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void bkZ() {
        this.loF.bkZ();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void bla() {
        this.loF.bla();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public MarkData blb() {
        return this.loF.blb();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(MarkData markData) {
        this.loF.a(markData);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public boolean bkY() {
        return this.loF.bkY();
    }
}
