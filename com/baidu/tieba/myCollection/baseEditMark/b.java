package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes3.dex */
public class b extends com.baidu.tbadk.baseEditMark.a {
    private MarkModel fLx;

    public b(BaseActivity baseActivity) {
        this.fLx = null;
        this.fLx = new MarkModel(baseActivity);
    }

    public b(BaseFragmentActivity baseFragmentActivity) {
        this.fLx = null;
        this.fLx = new MarkModel(baseFragmentActivity);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void aQ(boolean z) {
        this.fLx.aQ(z);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public String ww() {
        return this.fLx.ww();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(a.InterfaceC0154a interfaceC0154a) {
        this.fLx.a(interfaceC0154a);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void wy() {
        this.fLx.wy();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void wz() {
        this.fLx.wz();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public MarkData wA() {
        return this.fLx.wA();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(MarkData markData) {
        this.fLx.a(markData);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public boolean wx() {
        return this.fLx.wx();
    }
}
