package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
/* loaded from: classes.dex */
public class b extends com.baidu.tbadk.baseEditMark.a {
    private c cbW;

    public b(BaseActivity baseActivity) {
        this.cbW = null;
        this.cbW = new c(baseActivity);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void ab(boolean z) {
        this.cbW.ab(z);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public String qj() {
        return this.cbW.qj();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(a.InterfaceC0039a interfaceC0039a) {
        this.cbW.a(interfaceC0039a);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void ql() {
        this.cbW.ql();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void qm() {
        this.cbW.qm();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public MarkData qn() {
        return this.cbW.qn();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(MarkData markData) {
        this.cbW.a(markData);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public boolean qk() {
        return this.cbW.qk();
    }
}
