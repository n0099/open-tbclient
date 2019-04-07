package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes6.dex */
public class b extends com.baidu.tbadk.baseEditMark.a {
    private MarkModel hbq;

    public b(BaseActivity baseActivity) {
        this.hbq = null;
        this.hbq = new MarkModel(baseActivity);
    }

    public b(BaseFragmentActivity baseFragmentActivity) {
        this.hbq = null;
        this.hbq = new MarkModel(baseFragmentActivity);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void cZ(boolean z) {
        this.hbq.cZ(z);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public String UX() {
        return this.hbq.UX();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(a.InterfaceC0221a interfaceC0221a) {
        this.hbq.a(interfaceC0221a);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void UZ() {
        this.hbq.UZ();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void Va() {
        this.hbq.Va();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public MarkData Vb() {
        return this.hbq.Vb();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(MarkData markData) {
        this.hbq.a(markData);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public boolean UY() {
        return this.hbq.UY();
    }
}
