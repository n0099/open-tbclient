package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes11.dex */
public class b extends com.baidu.tbadk.baseEditMark.a {
    private MarkModel jME;

    public b(BaseActivity baseActivity) {
        this.jME = null;
        this.jME = new MarkModel(baseActivity);
    }

    public b(BaseFragmentActivity baseFragmentActivity) {
        this.jME = null;
        this.jME = new MarkModel(baseFragmentActivity);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void gJ(boolean z) {
        this.jME.gJ(z);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public String aOn() {
        return this.jME.aOn();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(a.InterfaceC0477a interfaceC0477a) {
        this.jME.a(interfaceC0477a);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void aOp() {
        this.jME.aOp();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void aOq() {
        this.jME.aOq();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public MarkData aOr() {
        return this.jME.aOr();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(MarkData markData) {
        this.jME.a(markData);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public boolean aOo() {
        return this.jME.aOo();
    }
}
