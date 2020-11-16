package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes23.dex */
public class b extends com.baidu.tbadk.baseEditMark.a {
    private MarkModel lbf;

    public b(BaseActivity baseActivity) {
        this.lbf = null;
        this.lbf = new MarkModel(baseActivity);
    }

    public b(BaseFragmentActivity baseFragmentActivity) {
        this.lbf = null;
        this.lbf = new MarkModel(baseFragmentActivity);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void is(boolean z) {
        this.lbf.is(z);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public String bhO() {
        return this.lbf.bhO();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(a.InterfaceC0571a interfaceC0571a) {
        this.lbf.a(interfaceC0571a);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void bhQ() {
        this.lbf.bhQ();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void bhR() {
        this.lbf.bhR();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public MarkData bhS() {
        return this.lbf.bhS();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(MarkData markData) {
        this.lbf.a(markData);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public boolean bhP() {
        return this.lbf.bhP();
    }
}
