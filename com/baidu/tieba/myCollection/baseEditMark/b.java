package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes11.dex */
public class b extends com.baidu.tbadk.baseEditMark.a {
    private MarkModel juh;

    public b(BaseActivity baseActivity) {
        this.juh = null;
        this.juh = new MarkModel(baseActivity);
    }

    public b(BaseFragmentActivity baseFragmentActivity) {
        this.juh = null;
        this.juh = new MarkModel(baseFragmentActivity);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void gC(boolean z) {
        this.juh.gC(z);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public String aMK() {
        return this.juh.aMK();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(a.InterfaceC0471a interfaceC0471a) {
        this.juh.a(interfaceC0471a);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void aMM() {
        this.juh.aMM();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void aMN() {
        this.juh.aMN();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public MarkData aMO() {
        return this.juh.aMO();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(MarkData markData) {
        this.juh.a(markData);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public boolean aML() {
        return this.juh.aML();
    }
}
