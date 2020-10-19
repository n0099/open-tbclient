package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes24.dex */
public class b extends com.baidu.tbadk.baseEditMark.a {
    private MarkModel kIs;

    public b(BaseActivity baseActivity) {
        this.kIs = null;
        this.kIs = new MarkModel(baseActivity);
    }

    public b(BaseFragmentActivity baseFragmentActivity) {
        this.kIs = null;
        this.kIs = new MarkModel(baseFragmentActivity);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void hU(boolean z) {
        this.kIs.hU(z);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public String beb() {
        return this.kIs.beb();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(a.InterfaceC0547a interfaceC0547a) {
        this.kIs.a(interfaceC0547a);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void bed() {
        this.kIs.bed();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void bee() {
        this.kIs.bee();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public MarkData bef() {
        return this.kIs.bef();
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public void a(MarkData markData) {
        this.kIs.a(markData);
    }

    @Override // com.baidu.tbadk.baseEditMark.a
    public boolean bec() {
        return this.kIs.bec();
    }
}
