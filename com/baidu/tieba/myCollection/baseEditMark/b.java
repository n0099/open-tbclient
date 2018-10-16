package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes3.dex */
public class b extends com.baidu.tbadk.baseEditMark.a {
    private MarkModel fzw;

    public b(BaseActivity baseActivity) {
        this.fzw = null;
        this.fzw = new MarkModel(baseActivity);
    }

    public b(BaseFragmentActivity baseFragmentActivity) {
        this.fzw = null;
        this.fzw = new MarkModel(baseFragmentActivity);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void ay(boolean z) {
        this.fzw.ay(z);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public String vb() {
        return this.fzw.vb();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(a.InterfaceC0120a interfaceC0120a) {
        this.fzw.a(interfaceC0120a);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void vd() {
        this.fzw.vd();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void ve() {
        this.fzw.ve();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public MarkData vf() {
        return this.fzw.vf();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(MarkData markData) {
        this.fzw.a(markData);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public boolean vc() {
        return this.fzw.vc();
    }
}
