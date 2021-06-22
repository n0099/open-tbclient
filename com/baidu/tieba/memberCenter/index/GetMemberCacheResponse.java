package com.baidu.tieba.memberCenter.index;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import d.a.o0.s1.c.b.m;
/* loaded from: classes4.dex */
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
