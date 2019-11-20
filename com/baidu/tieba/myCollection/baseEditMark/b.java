package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes6.dex */
public class b extends com.baidu.tbadk.baseEditMark.a {
    private MarkModel hzE;

    public b(BaseActivity baseActivity) {
        this.hzE = null;
        this.hzE = new MarkModel(baseActivity);
    }

    public b(BaseFragmentActivity baseFragmentActivity) {
        this.hzE = null;
        this.hzE = new MarkModel(baseFragmentActivity);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void dO(boolean z) {
        this.hzE.dO(z);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public String afj() {
        return this.hzE.afj();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(a.InterfaceC0279a interfaceC0279a) {
        this.hzE.a(interfaceC0279a);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void afl() {
        this.hzE.afl();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void afm() {
        this.hzE.afm();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public MarkData afn() {
        return this.hzE.afn();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(MarkData markData) {
        this.hzE.a(markData);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public boolean afk() {
        return this.hzE.afk();
    }
}
