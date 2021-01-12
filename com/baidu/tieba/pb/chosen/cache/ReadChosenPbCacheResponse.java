package com.baidu.tieba.pb.chosen.cache;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes7.dex */
public class ReadChosenPbCacheResponse extends CustomResponsedMessage<com.baidu.tieba.pb.chosen.net.a> {
    private com.baidu.tieba.pb.chosen.net.a chosenData;

    public ReadChosenPbCacheResponse(com.baidu.tieba.pb.chosen.net.a aVar) {
        super(CmdConfigCustom.CMD_CHOSEN_PB_READ_CACHE);
        this.chosenData = aVar;
    }

    public com.baidu.tieba.pb.chosen.net.a getChosenData() {
        return this.chosenData;
    }
}
