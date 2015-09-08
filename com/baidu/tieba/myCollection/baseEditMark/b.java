package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
/* loaded from: classes.dex */
public class b extends com.baidu.tbadk.baseEditMark.a {
    private c bYk;

    public b(BaseActivity baseActivity) {
        this.bYk = null;
        this.bYk = new c(baseActivity);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void ab(boolean z) {
        this.bYk.ab(z);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public String qn() {
        return this.bYk.qn();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(a.InterfaceC0039a interfaceC0039a) {
        this.bYk.a(interfaceC0039a);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void qp() {
        this.bYk.qp();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void qq() {
        this.bYk.qq();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public MarkData qr() {
        return this.bYk.qr();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(MarkData markData) {
        this.bYk.a(markData);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public boolean qo() {
        return this.bYk.qo();
    }
}
