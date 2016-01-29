package com.baidu.tieba.recommendfrs.data;

import com.squareup.wire.Message;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import tbclient.GodFeed.GodFeedResIdl;
/* loaded from: classes.dex */
public class n extends j {
    private long dET;
    private int dFe = -1;

    @Override // com.baidu.tieba.recommendfrs.data.j, com.baidu.tbadk.mvc.b.j
    public void a(Message message) {
        GodFeedResIdl godFeedResIdl;
        if ((message instanceof GodFeedResIdl) && (godFeedResIdl = (GodFeedResIdl) message) != null && godFeedResIdl.error != null && godFeedResIdl.error.errorno.intValue() == 0 && godFeedResIdl.data != null) {
            this.mHasMore = godFeedResIdl.data.has_more.intValue() == 1;
            this.pn = godFeedResIdl.data.pn.intValue();
            this.dET = godFeedResIdl.data.timeline.longValue();
            if (godFeedResIdl.data.thread_list != null) {
                this.dEW = new ArrayList();
                this.dEW.addAll(godFeedResIdl.data.thread_list);
            }
            this.dFe = godFeedResIdl.data.has_attention_god.intValue();
        }
    }

    @Override // com.baidu.tieba.recommendfrs.data.j, com.baidu.tbadk.mvc.b.b
    public boolean Q(byte[] bArr) {
        try {
            a((GodFeedResIdl) new Wire(new Class[0]).parseFrom(bArr, GodFeedResIdl.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public long aFt() {
        return this.dET;
    }

    public int aFF() {
        return this.dFe;
    }
}
