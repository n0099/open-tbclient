package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes8.dex */
public class b extends com.baidu.tbadk.baseEditMark.a {
    private MarkModel ltW;

    public b(BaseActivity baseActivity) {
        this.ltW = null;
        this.ltW = new MarkModel(baseActivity);
    }

    public b(BaseFragmentActivity baseFragmentActivity) {
        this.ltW = null;
        this.ltW = new MarkModel(baseFragmentActivity);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void jc(boolean z) {
        this.ltW.jc(z);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public String bnw() {
        return this.ltW.bnw();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(a.InterfaceC0574a interfaceC0574a) {
        this.ltW.a(interfaceC0574a);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void bny() {
        this.ltW.bny();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void bnz() {
        this.ltW.bnz();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public MarkData bnA() {
        return this.ltW.bnA();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(MarkData markData) {
        this.ltW.a(markData);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public boolean bnx() {
        return this.ltW.bnx();
    }
}
