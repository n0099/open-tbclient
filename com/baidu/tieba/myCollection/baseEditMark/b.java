package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes8.dex */
public class b extends com.baidu.tbadk.baseEditMark.a {
    private MarkModel inI;

    public b(BaseActivity baseActivity) {
        this.inI = null;
        this.inI = new MarkModel(baseActivity);
    }

    public b(BaseFragmentActivity baseFragmentActivity) {
        this.inI = null;
        this.inI = new MarkModel(baseFragmentActivity);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void fa(boolean z) {
        this.inI.fa(z);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public String awc() {
        return this.inI.awc();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(a.InterfaceC0362a interfaceC0362a) {
        this.inI.a(interfaceC0362a);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void awe() {
        this.inI.awe();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void awf() {
        this.inI.awf();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public MarkData awg() {
        return this.inI.awg();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(MarkData markData) {
        this.inI.a(markData);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public boolean awd() {
        return this.inI.awd();
    }
}
