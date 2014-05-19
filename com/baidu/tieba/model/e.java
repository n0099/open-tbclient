package com.baidu.tieba.model;

import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.base.d {
    private RequestUpdateMaskInfoMessage a;
    private int b = 2;

    @Override // com.baidu.adp.base.d
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.d
    public boolean cancelLoadData() {
        super.cancelMessage();
        return false;
    }

    public void a(long j) {
        this.a = new RequestUpdateMaskInfoMessage();
        this.a.setIsMask(1);
        this.a.setMaskType(10);
        this.a.setList(String.valueOf(j));
        super.sendMessage(this.a);
    }

    public void b(long j) {
        this.a = new RequestUpdateMaskInfoMessage();
        this.a.setIsMask(0);
        this.a.setMaskType(10);
        this.a.setList(String.valueOf(j));
        super.sendMessage(this.a);
    }

    public int a() {
        return this.b;
    }

    public void a(int i) {
        this.b = i;
    }
}
