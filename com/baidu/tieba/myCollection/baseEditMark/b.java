package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes3.dex */
public class b extends com.baidu.tbadk.baseEditMark.a {
    private MarkModel fyS;

    public b(BaseActivity baseActivity) {
        this.fyS = null;
        this.fyS = new MarkModel(baseActivity);
    }

    public b(BaseFragmentActivity baseFragmentActivity) {
        this.fyS = null;
        this.fyS = new MarkModel(baseFragmentActivity);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void aL(boolean z) {
        this.fyS.aL(z);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public String vW() {
        return this.fyS.vW();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(a.InterfaceC0093a interfaceC0093a) {
        this.fyS.a(interfaceC0093a);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void vY() {
        this.fyS.vY();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void vZ() {
        this.fyS.vZ();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public MarkData wa() {
        return this.fyS.wa();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(MarkData markData) {
        this.fyS.a(markData);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public boolean vX() {
        return this.fyS.vX();
    }
}
