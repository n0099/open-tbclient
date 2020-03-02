package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes11.dex */
public class b extends com.baidu.tbadk.baseEditMark.a {
    private MarkModel itj;

    public b(BaseActivity baseActivity) {
        this.itj = null;
        this.itj = new MarkModel(baseActivity);
    }

    public b(BaseFragmentActivity baseFragmentActivity) {
        this.itj = null;
        this.itj = new MarkModel(baseFragmentActivity);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void fm(boolean z) {
        this.itj.fm(z);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public String ayK() {
        return this.itj.ayK();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(a.InterfaceC0374a interfaceC0374a) {
        this.itj.a(interfaceC0374a);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void ayM() {
        this.itj.ayM();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void ayN() {
        this.itj.ayN();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public MarkData ayO() {
        return this.itj.ayO();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(MarkData markData) {
        this.itj.a(markData);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public boolean ayL() {
        return this.itj.ayL();
    }
}
