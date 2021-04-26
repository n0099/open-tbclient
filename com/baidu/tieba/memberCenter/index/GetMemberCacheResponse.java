package com.baidu.tieba.memberCenter.index;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import d.a.j0.r1.c.b.m;
/* loaded from: classes3.dex */
public class GetMemberCacheResponse extends CustomResponsedMessage<Object> {
    public m mMembercenter;

    public GetMemberCacheResponse() {
        super(2016460);
    }

    public m getMembercenterData() {
        return this.mMembercenter;
    }

    public void setMemberCenterData(m mVar) {
        this.mMembercenter = mVar;
    }
}
