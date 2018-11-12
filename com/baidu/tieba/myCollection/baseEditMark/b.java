package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes3.dex */
public class b extends com.baidu.tbadk.baseEditMark.a {
    private MarkModel fAU;

    public b(BaseActivity baseActivity) {
        this.fAU = null;
        this.fAU = new MarkModel(baseActivity);
    }

    public b(BaseFragmentActivity baseFragmentActivity) {
        this.fAU = null;
        this.fAU = new MarkModel(baseFragmentActivity);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void aO(boolean z) {
        this.fAU.aO(z);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public String vl() {
        return this.fAU.vl();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(a.InterfaceC0144a interfaceC0144a) {
        this.fAU.a(interfaceC0144a);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void vn() {
        this.fAU.vn();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void vo() {
        this.fAU.vo();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public MarkData vp() {
        return this.fAU.vp();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(MarkData markData) {
        this.fAU.a(markData);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public boolean vm() {
        return this.fAU.vm();
    }
}
