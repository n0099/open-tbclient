package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
/* loaded from: classes.dex */
public class e extends com.baidu.tbadk.baseEditMark.a {
    private f bHA;

    public e(BaseActivity baseActivity) {
        this.bHA = null;
        this.bHA = new f(baseActivity);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void Z(boolean z) {
        this.bHA.Z(z);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public String pp() {
        return this.bHA.pp();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(com.baidu.tbadk.baseEditMark.b bVar) {
        this.bHA.a(bVar);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void pr() {
        this.bHA.pr();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void ps() {
        this.bHA.ps();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public MarkData pt() {
        return this.bHA.pt();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(MarkData markData) {
        this.bHA.a(markData);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public boolean pq() {
        return this.bHA.pq();
    }
}
