package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes3.dex */
public class b extends com.baidu.tbadk.baseEditMark.a {
    private MarkModel fzx;

    public b(BaseActivity baseActivity) {
        this.fzx = null;
        this.fzx = new MarkModel(baseActivity);
    }

    public b(BaseFragmentActivity baseFragmentActivity) {
        this.fzx = null;
        this.fzx = new MarkModel(baseFragmentActivity);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void ay(boolean z) {
        this.fzx.ay(z);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public String vb() {
        return this.fzx.vb();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(a.InterfaceC0120a interfaceC0120a) {
        this.fzx.a(interfaceC0120a);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void vd() {
        this.fzx.vd();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void ve() {
        this.fzx.ve();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public MarkData vf() {
        return this.fzx.vf();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(MarkData markData) {
        this.fzx.a(markData);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public boolean vc() {
        return this.fzx.vc();
    }
}
