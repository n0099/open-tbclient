package com.baidu.tieba.pb.chosen.cache;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import d.a.o0.e2.g.c.a;
/* loaded from: classes5.dex */
public class ReadChosenPbCacheResponse extends CustomResponsedMessage<a> {
    public a chosenData;

    public ReadChosenPbCacheResponse(a aVar) {
        super(2001314);
        this.chosenData = aVar;
    }

    public a getChosenData() {
        return this.chosenData;
    }
}
