package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
/* loaded from: classes.dex */
public class b extends com.baidu.tbadk.baseEditMark.a {
    private c cch;

    public b(BaseActivity baseActivity) {
        this.cch = null;
        this.cch = new c(baseActivity);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void ab(boolean z) {
        this.cch.ab(z);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public String qj() {
        return this.cch.qj();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(a.InterfaceC0039a interfaceC0039a) {
        this.cch.a(interfaceC0039a);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void ql() {
        this.cch.ql();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void qm() {
        this.cch.qm();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public MarkData qn() {
        return this.cch.qn();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(MarkData markData) {
        this.cch.a(markData);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public boolean qk() {
        return this.cch.qk();
    }
}
