package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
/* loaded from: classes.dex */
public class e extends com.baidu.tbadk.baseEditMark.a {
    private f bEF;

    public e(BaseActivity baseActivity) {
        this.bEF = null;
        this.bEF = new f(baseActivity);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void W(boolean z) {
        this.bEF.W(z);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public String oP() {
        return this.bEF.oP();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(com.baidu.tbadk.baseEditMark.b bVar) {
        this.bEF.a(bVar);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void oR() {
        this.bEF.oR();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void oS() {
        this.bEF.oS();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public MarkData oT() {
        return this.bEF.oT();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(MarkData markData) {
        this.bEF.a(markData);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public boolean oQ() {
        return this.bEF.oQ();
    }
}
