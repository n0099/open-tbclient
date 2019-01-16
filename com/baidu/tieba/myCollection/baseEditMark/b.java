package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes3.dex */
public class b extends com.baidu.tbadk.baseEditMark.a {
    private MarkModel fLw;

    public b(BaseActivity baseActivity) {
        this.fLw = null;
        this.fLw = new MarkModel(baseActivity);
    }

    public b(BaseFragmentActivity baseFragmentActivity) {
        this.fLw = null;
        this.fLw = new MarkModel(baseFragmentActivity);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void aQ(boolean z) {
        this.fLw.aQ(z);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public String ww() {
        return this.fLw.ww();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(a.InterfaceC0154a interfaceC0154a) {
        this.fLw.a(interfaceC0154a);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void wy() {
        this.fLw.wy();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void wz() {
        this.fLw.wz();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public MarkData wA() {
        return this.fLw.wA();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(MarkData markData) {
        this.fLw.a(markData);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public boolean wx() {
        return this.fLw.wx();
    }
}
