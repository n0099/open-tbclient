package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes8.dex */
public class b extends com.baidu.tbadk.baseEditMark.a {
    private MarkModel lxu;

    public b(BaseActivity baseActivity) {
        this.lxu = null;
        this.lxu = new MarkModel(baseActivity);
    }

    public b(BaseFragmentActivity baseFragmentActivity) {
        this.lxu = null;
        this.lxu = new MarkModel(baseFragmentActivity);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void ja(boolean z) {
        this.lxu.ja(z);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public String bjY() {
        return this.lxu.bjY();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(a.InterfaceC0554a interfaceC0554a) {
        this.lxu.a(interfaceC0554a);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void bka() {
        this.lxu.bka();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void bkb() {
        this.lxu.bkb();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public MarkData bkc() {
        return this.lxu.bkc();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(MarkData markData) {
        this.lxu.a(markData);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public boolean bjZ() {
        return this.lxu.bjZ();
    }
}
