package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes3.dex */
public class b extends com.baidu.tbadk.baseEditMark.a {
    private MarkModel fgr;

    public b(BaseActivity baseActivity) {
        this.fgr = null;
        this.fgr = new MarkModel(baseActivity);
    }

    public b(BaseFragmentActivity baseFragmentActivity) {
        this.fgr = null;
        this.fgr = new MarkModel(baseFragmentActivity);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void ah(boolean z) {
        this.fgr.ah(z);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public String sb() {
        return this.fgr.sb();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(a.InterfaceC0099a interfaceC0099a) {
        this.fgr.a(interfaceC0099a);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void sd() {
        this.fgr.sd();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void se() {
        this.fgr.se();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public MarkData sf() {
        return this.fgr.sf();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(MarkData markData) {
        this.fgr.a(markData);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public boolean sc() {
        return this.fgr.sc();
    }
}
