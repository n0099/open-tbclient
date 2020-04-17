package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes11.dex */
public class b extends com.baidu.tbadk.baseEditMark.a {
    private MarkModel jfa;

    public b(BaseActivity baseActivity) {
        this.jfa = null;
        this.jfa = new MarkModel(baseActivity);
    }

    public b(BaseFragmentActivity baseFragmentActivity) {
        this.jfa = null;
        this.jfa = new MarkModel(baseFragmentActivity);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void gk(boolean z) {
        this.jfa.gk(z);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public String aGY() {
        return this.jfa.aGY();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(a.InterfaceC0404a interfaceC0404a) {
        this.jfa.a(interfaceC0404a);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void aHa() {
        this.jfa.aHa();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void aHb() {
        this.jfa.aHb();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public MarkData aHc() {
        return this.jfa.aHc();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(MarkData markData) {
        this.jfa.a(markData);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public boolean aGZ() {
        return this.jfa.aGZ();
    }
}
