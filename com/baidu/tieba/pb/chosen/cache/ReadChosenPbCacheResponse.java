package com.baidu.tieba.pb.chosen.cache;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class ReadChosenPbCacheResponse extends CustomResponsedMessage<com.baidu.tieba.pb.chosen.net.a> {
    private com.baidu.tieba.pb.chosen.net.a chosenData;

    public ReadChosenPbCacheResponse(com.baidu.tieba.pb.chosen.net.a aVar) {
        super(2001321);
        this.chosenData = aVar;
    }

    public com.baidu.tieba.pb.chosen.net.a getChosenData() {
        return this.chosenData;
    }
}
