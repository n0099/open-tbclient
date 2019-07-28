package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes6.dex */
public class b extends com.baidu.tbadk.baseEditMark.a {
    private MarkModel hyY;

    public b(BaseActivity baseActivity) {
        this.hyY = null;
        this.hyY = new MarkModel(baseActivity);
    }

    public b(BaseFragmentActivity baseFragmentActivity) {
        this.hyY = null;
        this.hyY = new MarkModel(baseFragmentActivity);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void dx(boolean z) {
        this.hyY.dx(z);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public String aaA() {
        return this.hyY.aaA();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(a.InterfaceC0238a interfaceC0238a) {
        this.hyY.a(interfaceC0238a);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void aaC() {
        this.hyY.aaC();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void aaD() {
        this.hyY.aaD();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public MarkData aaE() {
        return this.hyY.aaE();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(MarkData markData) {
        this.hyY.a(markData);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public boolean aaB() {
        return this.hyY.aaB();
    }
}
