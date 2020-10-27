package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes24.dex */
public class b extends com.baidu.tbadk.baseEditMark.a {
    private MarkModel kUP;

    public b(BaseActivity baseActivity) {
        this.kUP = null;
        this.kUP = new MarkModel(baseActivity);
    }

    public b(BaseFragmentActivity baseFragmentActivity) {
        this.kUP = null;
        this.kUP = new MarkModel(baseFragmentActivity);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void ih(boolean z) {
        this.kUP.ih(z);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public String bfU() {
        return this.kUP.bfU();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(a.InterfaceC0561a interfaceC0561a) {
        this.kUP.a(interfaceC0561a);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void bfW() {
        this.kUP.bfW();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void bfX() {
        this.kUP.bfX();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public MarkData bfY() {
        return this.kUP.bfY();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(MarkData markData) {
        this.kUP.a(markData);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public boolean bfV() {
        return this.kUP.bfV();
    }
}
