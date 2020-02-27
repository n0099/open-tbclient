package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes11.dex */
public class b extends com.baidu.tbadk.baseEditMark.a {
    private MarkModel ith;

    public b(BaseActivity baseActivity) {
        this.ith = null;
        this.ith = new MarkModel(baseActivity);
    }

    public b(BaseFragmentActivity baseFragmentActivity) {
        this.ith = null;
        this.ith = new MarkModel(baseFragmentActivity);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void fm(boolean z) {
        this.ith.fm(z);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public String ayI() {
        return this.ith.ayI();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(a.InterfaceC0374a interfaceC0374a) {
        this.ith.a(interfaceC0374a);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void ayK() {
        this.ith.ayK();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void ayL() {
        this.ith.ayL();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public MarkData ayM() {
        return this.ith.ayM();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(MarkData markData) {
        this.ith.a(markData);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public boolean ayJ() {
        return this.ith.ayJ();
    }
}
