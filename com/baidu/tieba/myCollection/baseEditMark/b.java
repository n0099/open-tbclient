package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes3.dex */
public class b extends com.baidu.tbadk.baseEditMark.a {
    private MarkModel fkp;

    public b(BaseActivity baseActivity) {
        this.fkp = null;
        this.fkp = new MarkModel(baseActivity);
    }

    public b(BaseFragmentActivity baseFragmentActivity) {
        this.fkp = null;
        this.fkp = new MarkModel(baseFragmentActivity);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void ah(boolean z) {
        this.fkp.ah(z);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public String sb() {
        return this.fkp.sb();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(a.InterfaceC0100a interfaceC0100a) {
        this.fkp.a(interfaceC0100a);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void sd() {
        this.fkp.sd();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void se() {
        this.fkp.se();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public MarkData sf() {
        return this.fkp.sf();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(MarkData markData) {
        this.fkp.a(markData);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public boolean sc() {
        return this.fkp.sc();
    }
}
