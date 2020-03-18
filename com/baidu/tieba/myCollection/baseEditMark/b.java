package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes11.dex */
public class b extends com.baidu.tbadk.baseEditMark.a {
    private MarkModel iuV;

    public b(BaseActivity baseActivity) {
        this.iuV = null;
        this.iuV = new MarkModel(baseActivity);
    }

    public b(BaseFragmentActivity baseFragmentActivity) {
        this.iuV = null;
        this.iuV = new MarkModel(baseFragmentActivity);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void fn(boolean z) {
        this.iuV.fn(z);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public String ayN() {
        return this.iuV.ayN();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(a.InterfaceC0374a interfaceC0374a) {
        this.iuV.a(interfaceC0374a);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void ayP() {
        this.iuV.ayP();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void ayQ() {
        this.iuV.ayQ();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public MarkData ayR() {
        return this.iuV.ayR();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(MarkData markData) {
        this.iuV.a(markData);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public boolean ayO() {
        return this.iuV.ayO();
    }
}
