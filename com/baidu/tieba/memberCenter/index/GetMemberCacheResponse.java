package com.baidu.tieba.memberCenter.index;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tieba.memberCenter.index.a.m;
/* loaded from: classes8.dex */
public class GetMemberCacheResponse extends CustomResponsedMessage<Object> {
    private m mMembercenter;

    public GetMemberCacheResponse() {
        super(CmdConfigCustom.CMD_GET_MEMBER_CENTER_CACHE);
    }

    public void setMemberCenterData(m mVar) {
        this.mMembercenter = mVar;
    }

    public m getMembercenterData() {
        return this.mMembercenter;
    }
}
