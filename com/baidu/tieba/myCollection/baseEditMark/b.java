package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes6.dex */
public class b extends com.baidu.tbadk.baseEditMark.a {
    private MarkModel hAv;

    public b(BaseActivity baseActivity) {
        this.hAv = null;
        this.hAv = new MarkModel(baseActivity);
    }

    public b(BaseFragmentActivity baseFragmentActivity) {
        this.hAv = null;
        this.hAv = new MarkModel(baseFragmentActivity);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void dO(boolean z) {
        this.hAv.dO(z);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public String afl() {
        return this.hAv.afl();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(a.InterfaceC0279a interfaceC0279a) {
        this.hAv.a(interfaceC0279a);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void afn() {
        this.hAv.afn();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void afo() {
        this.hAv.afo();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public MarkData afp() {
        return this.hAv.afp();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(MarkData markData) {
        this.hAv.a(markData);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public boolean afm() {
        return this.hAv.afm();
    }
}
