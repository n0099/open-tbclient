package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
/* loaded from: classes.dex */
public class b extends com.baidu.tbadk.baseEditMark.a {
    private c cFq;

    public b(BaseActivity baseActivity) {
        this.cFq = null;
        this.cFq = new c(baseActivity);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void Y(boolean z) {
        this.cFq.Y(z);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public String qf() {
        return this.cFq.qf();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(a.InterfaceC0041a interfaceC0041a) {
        this.cFq.a(interfaceC0041a);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void qh() {
        this.cFq.qh();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void qi() {
        this.cFq.qi();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public MarkData qj() {
        return this.cFq.qj();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(MarkData markData) {
        this.cFq.a(markData);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public boolean qg() {
        return this.cFq.qg();
    }
}
