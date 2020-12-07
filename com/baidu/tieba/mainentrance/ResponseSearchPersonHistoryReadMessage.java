package com.baidu.tieba.mainentrance;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import java.util.ArrayList;
/* loaded from: classes24.dex */
public class ResponseSearchPersonHistoryReadMessage extends CustomResponsedMessage<Object> {
    public final ArrayList<String> datas;

    public ResponseSearchPersonHistoryReadMessage() {
        super(CmdConfigCustom.CMD_READ_SEARCHPERSON_HISTORY);
        this.datas = new ArrayList<>(10);
    }
}
