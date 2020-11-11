package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes24.dex */
public class b extends com.baidu.tbadk.baseEditMark.a {
    private MarkModel laM;

    public b(BaseActivity baseActivity) {
        this.laM = null;
        this.laM = new MarkModel(baseActivity);
    }

    public b(BaseFragmentActivity baseFragmentActivity) {
        this.laM = null;
        this.laM = new MarkModel(baseFragmentActivity);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void iq(boolean z) {
        this.laM.iq(z);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public String biu() {
        return this.laM.biu();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(a.InterfaceC0573a interfaceC0573a) {
        this.laM.a(interfaceC0573a);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void biw() {
        this.laM.biw();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void bix() {
        this.laM.bix();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public MarkData biy() {
        return this.laM.biy();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(MarkData markData) {
        this.laM.a(markData);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public boolean biv() {
        return this.laM.biv();
    }
}
