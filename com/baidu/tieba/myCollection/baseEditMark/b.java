package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes11.dex */
public class b extends com.baidu.tbadk.baseEditMark.a {
    private MarkModel itv;

    public b(BaseActivity baseActivity) {
        this.itv = null;
        this.itv = new MarkModel(baseActivity);
    }

    public b(BaseFragmentActivity baseFragmentActivity) {
        this.itv = null;
        this.itv = new MarkModel(baseFragmentActivity);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void fm(boolean z) {
        this.itv.fm(z);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public String ayK() {
        return this.itv.ayK();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(a.InterfaceC0374a interfaceC0374a) {
        this.itv.a(interfaceC0374a);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void ayM() {
        this.itv.ayM();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void ayN() {
        this.itv.ayN();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public MarkData ayO() {
        return this.itv.ayO();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(MarkData markData) {
        this.itv.a(markData);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public boolean ayL() {
        return this.itv.ayL();
    }
}
