package com.baidu.tieba.person;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class PersonBarByUidLocalMessage extends CustomMessage<String> {
    public PersonBarByUidLocalMessage() {
        super(CmdConfigCustom.CMD_QUERY_PERSON_BAR_LOCAL_HISTORY);
    }
}
