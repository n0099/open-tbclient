package com.baidu.tieba.memberCenter.index;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes8.dex */
public class GetMemberCacheRequest extends CustomMessage<Object> {
    public GetMemberCacheRequest() {
        super(CmdConfigCustom.CMD_GET_MEMBER_CENTER_CACHE);
    }
}
