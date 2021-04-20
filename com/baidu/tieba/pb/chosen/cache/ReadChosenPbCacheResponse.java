package com.baidu.tieba.pb.chosen.cache;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import d.b.i0.d2.g.c.a;
/* loaded from: classes3.dex */
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
