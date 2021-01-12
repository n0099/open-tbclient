package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes7.dex */
public class b extends com.baidu.tbadk.baseEditMark.a {
    private MarkModel lpq;

    public b(BaseActivity baseActivity) {
        this.lpq = null;
        this.lpq = new MarkModel(baseActivity);
    }

    public b(BaseFragmentActivity baseFragmentActivity) {
        this.lpq = null;
        this.lpq = new MarkModel(baseFragmentActivity);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void iY(boolean z) {
        this.lpq.iY(z);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public String bjD() {
        return this.lpq.bjD();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(a.InterfaceC0557a interfaceC0557a) {
        this.lpq.a(interfaceC0557a);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void bjF() {
        this.lpq.bjF();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void bjG() {
        this.lpq.bjG();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public MarkData bjH() {
        return this.lpq.bjH();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(MarkData markData) {
        this.lpq.a(markData);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public boolean bjE() {
        return this.lpq.bjE();
    }
}
