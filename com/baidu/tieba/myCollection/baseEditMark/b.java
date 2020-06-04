package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes11.dex */
public class b extends com.baidu.tbadk.baseEditMark.a {
    private MarkModel jvn;

    public b(BaseActivity baseActivity) {
        this.jvn = null;
        this.jvn = new MarkModel(baseActivity);
    }

    public b(BaseFragmentActivity baseFragmentActivity) {
        this.jvn = null;
        this.jvn = new MarkModel(baseFragmentActivity);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void gC(boolean z) {
        this.jvn.gC(z);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public String aMK() {
        return this.jvn.aMK();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(a.InterfaceC0471a interfaceC0471a) {
        this.jvn.a(interfaceC0471a);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void aMM() {
        this.jvn.aMM();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void aMN() {
        this.jvn.aMN();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public MarkData aMO() {
        return this.jvn.aMO();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(MarkData markData) {
        this.jvn.a(markData);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public boolean aML() {
        return this.jvn.aML();
    }
}
