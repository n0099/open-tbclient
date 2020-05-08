package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes11.dex */
public class b extends com.baidu.tbadk.baseEditMark.a {
    private MarkModel jfe;

    public b(BaseActivity baseActivity) {
        this.jfe = null;
        this.jfe = new MarkModel(baseActivity);
    }

    public b(BaseFragmentActivity baseFragmentActivity) {
        this.jfe = null;
        this.jfe = new MarkModel(baseFragmentActivity);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void gk(boolean z) {
        this.jfe.gk(z);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public String aGW() {
        return this.jfe.aGW();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(a.InterfaceC0425a interfaceC0425a) {
        this.jfe.a(interfaceC0425a);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void aGY() {
        this.jfe.aGY();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void aGZ() {
        this.jfe.aGZ();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public MarkData aHa() {
        return this.jfe.aHa();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(MarkData markData) {
        this.jfe.a(markData);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public boolean aGX() {
        return this.jfe.aGX();
    }
}
