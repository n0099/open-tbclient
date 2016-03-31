package com.baidu.tieba.recommendfrs.data;

import com.squareup.wire.Message;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import tbclient.GodFeed.GodFeedResIdl;
/* loaded from: classes.dex */
public class r extends n {
    private long dWV;
    private int dXe = -1;

    @Override // com.baidu.tieba.recommendfrs.data.n, com.baidu.tbadk.mvc.b.j
    public void a(Message message) {
        GodFeedResIdl godFeedResIdl;
        if ((message instanceof GodFeedResIdl) && (godFeedResIdl = (GodFeedResIdl) message) != null && godFeedResIdl.error != null && godFeedResIdl.error.errorno.intValue() == 0 && godFeedResIdl.data != null) {
            this.mHasMore = godFeedResIdl.data.has_more.intValue() == 1;
            this.pn = godFeedResIdl.data.pn.intValue();
            this.dWV = godFeedResIdl.data.timeline.longValue();
            if (godFeedResIdl.data.thread_list != null) {
                this.dWY = new ArrayList();
                this.dWY.addAll(godFeedResIdl.data.thread_list);
            }
            this.dXe = godFeedResIdl.data.has_attention_god.intValue();
        }
    }

    @Override // com.baidu.tieba.recommendfrs.data.n, com.baidu.tbadk.mvc.b.b
    public boolean x(byte[] bArr) {
        try {
            a((GodFeedResIdl) new Wire(new Class[0]).parseFrom(bArr, GodFeedResIdl.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public long aMh() {
        return this.dWV;
    }

    public int aMt() {
        return this.dXe;
    }
}
