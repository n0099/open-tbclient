package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes23.dex */
public class b extends com.baidu.tbadk.baseEditMark.a {
    private MarkModel ktg;

    public b(BaseActivity baseActivity) {
        this.ktg = null;
        this.ktg = new MarkModel(baseActivity);
    }

    public b(BaseFragmentActivity baseFragmentActivity) {
        this.ktg = null;
        this.ktg = new MarkModel(baseFragmentActivity);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void hy(boolean z) {
        this.ktg.hy(z);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public String bbt() {
        return this.ktg.bbt();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(a.InterfaceC0530a interfaceC0530a) {
        this.ktg.a(interfaceC0530a);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void bbv() {
        this.ktg.bbv();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void bbw() {
        this.ktg.bbw();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public MarkData bbx() {
        return this.ktg.bbx();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(MarkData markData) {
        this.ktg.a(markData);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public boolean bbu() {
        return this.ktg.bbu();
    }
}
