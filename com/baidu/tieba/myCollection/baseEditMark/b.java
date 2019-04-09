package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes6.dex */
public class b extends com.baidu.tbadk.baseEditMark.a {
    private MarkModel hbr;

    public b(BaseActivity baseActivity) {
        this.hbr = null;
        this.hbr = new MarkModel(baseActivity);
    }

    public b(BaseFragmentActivity baseFragmentActivity) {
        this.hbr = null;
        this.hbr = new MarkModel(baseFragmentActivity);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void cZ(boolean z) {
        this.hbr.cZ(z);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public String UX() {
        return this.hbr.UX();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(a.InterfaceC0221a interfaceC0221a) {
        this.hbr.a(interfaceC0221a);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void UZ() {
        this.hbr.UZ();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void Va() {
        this.hbr.Va();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public MarkData Vb() {
        return this.hbr.Vb();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(MarkData markData) {
        this.hbr.a(markData);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public boolean UY() {
        return this.hbr.UY();
    }
}
