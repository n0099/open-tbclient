package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
/* loaded from: classes.dex */
public class e extends com.baidu.tbadk.baseEditMark.a {
    private f bEs;

    public e(BaseActivity baseActivity) {
        this.bEs = null;
        this.bEs = new f(baseActivity);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void W(boolean z) {
        this.bEs.W(z);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public String oP() {
        return this.bEs.oP();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(com.baidu.tbadk.baseEditMark.b bVar) {
        this.bEs.a(bVar);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void oR() {
        this.bEs.oR();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void oS() {
        this.bEs.oS();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public MarkData oT() {
        return this.bEs.oT();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(MarkData markData) {
        this.bEs.a(markData);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public boolean oQ() {
        return this.bEs.oQ();
    }
}
