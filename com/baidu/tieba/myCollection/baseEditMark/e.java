package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
/* loaded from: classes.dex */
public class e extends com.baidu.tbadk.baseEditMark.a {
    private f bHB;

    public e(BaseActivity baseActivity) {
        this.bHB = null;
        this.bHB = new f(baseActivity);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void Z(boolean z) {
        this.bHB.Z(z);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public String pp() {
        return this.bHB.pp();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(com.baidu.tbadk.baseEditMark.b bVar) {
        this.bHB.a(bVar);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void pr() {
        this.bHB.pr();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void ps() {
        this.bHB.ps();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public MarkData pt() {
        return this.bHB.pt();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(MarkData markData) {
        this.bHB.a(markData);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public boolean pq() {
        return this.bHB.pq();
    }
}
