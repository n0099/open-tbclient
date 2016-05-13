package com.baidu.tieba.recommendfrs.data;

import com.squareup.wire.Message;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import tbclient.GodFeed.GodFeedResIdl;
/* loaded from: classes.dex */
public class r extends n {
    private long eae;
    private int ean = -1;

    @Override // com.baidu.tieba.recommendfrs.data.n, com.baidu.tbadk.mvc.b.j
    public void a(Message message) {
        GodFeedResIdl godFeedResIdl;
        if ((message instanceof GodFeedResIdl) && (godFeedResIdl = (GodFeedResIdl) message) != null && godFeedResIdl.error != null && godFeedResIdl.error.errorno.intValue() == 0 && godFeedResIdl.data != null) {
            this.mHasMore = godFeedResIdl.data.has_more.intValue() == 1;
            this.pn = godFeedResIdl.data.pn.intValue();
            this.eae = godFeedResIdl.data.timeline.longValue();
            if (godFeedResIdl.data.thread_list != null) {
                this.eah = new ArrayList();
                this.eah.addAll(godFeedResIdl.data.thread_list);
            }
            this.ean = godFeedResIdl.data.has_attention_god.intValue();
        }
    }

    @Override // com.baidu.tieba.recommendfrs.data.n, com.baidu.tbadk.mvc.b.b
    public boolean w(byte[] bArr) {
        try {
            a((GodFeedResIdl) new Wire(new Class[0]).parseFrom(bArr, GodFeedResIdl.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public long aMv() {
        return this.eae;
    }

    public int aMH() {
        return this.ean;
    }
}
