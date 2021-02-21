package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes8.dex */
public class b extends com.baidu.tbadk.baseEditMark.a {
    private MarkModel lxI;

    public b(BaseActivity baseActivity) {
        this.lxI = null;
        this.lxI = new MarkModel(baseActivity);
    }

    public b(BaseFragmentActivity baseFragmentActivity) {
        this.lxI = null;
        this.lxI = new MarkModel(baseFragmentActivity);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void ja(boolean z) {
        this.lxI.ja(z);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public String bjY() {
        return this.lxI.bjY();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(a.InterfaceC0554a interfaceC0554a) {
        this.lxI.a(interfaceC0554a);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void bka() {
        this.lxI.bka();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void bkb() {
        this.lxI.bkb();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public MarkData bkc() {
        return this.lxI.bkc();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(MarkData markData) {
        this.lxI.a(markData);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public boolean bjZ() {
        return this.lxI.bjZ();
    }
}
