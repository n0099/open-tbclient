package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes7.dex */
public class b extends com.baidu.tbadk.baseEditMark.a {
    private MarkModel lzL;

    public b(BaseActivity baseActivity) {
        this.lzL = null;
        this.lzL = new MarkModel(baseActivity);
    }

    public b(BaseFragmentActivity baseFragmentActivity) {
        this.lzL = null;
        this.lzL = new MarkModel(baseFragmentActivity);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void ja(boolean z) {
        this.lzL.ja(z);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public String bka() {
        return this.lzL.bka();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(a.InterfaceC0560a interfaceC0560a) {
        this.lzL.a(interfaceC0560a);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void bkc() {
        this.lzL.bkc();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void bkd() {
        this.lzL.bkd();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public MarkData bke() {
        return this.lzL.bke();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(MarkData markData) {
        this.lzL.a(markData);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public boolean bkb() {
        return this.lzL.bkb();
    }
}
