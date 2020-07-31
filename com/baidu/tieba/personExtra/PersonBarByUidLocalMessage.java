package com.baidu.tieba.personExtra;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes18.dex */
public class PersonBarByUidLocalMessage extends CustomMessage<String> {
    public PersonBarByUidLocalMessage() {
        super(CmdConfigCustom.CMD_QUERY_PERSON_BAR_LOCAL_HISTORY);
    }
}
