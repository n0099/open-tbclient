package com.baidu.tieba.pb.video;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.bo;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class l extends com.baidu.tieba.tbadkCore.data.p {
    public static final BdUniqueId etB = BdUniqueId.gen();
    public String PZ;
    public long channelId;
    public String channelName;
    public String etC;
    public String etD;
    public String etE;
    public String etF;
    public String etG;
    public long etH;
    public long forumId;
    public String threadId;
    public int videoDuration;
    public boolean bPT = false;
    public boolean etI = true;
    public boolean etJ = false;
    public int position = 0;

    public void a(bh bhVar, boolean z, boolean z2, boolean z3, int i) {
        if (bhVar != null) {
            this.etI = z;
            this.etJ = z2;
            this.bPT = z3;
            this.threadId = bhVar.getTid();
            this.etG = bhVar.getTitle();
            this.forumId = bhVar.getFid();
            this.etC = bhVar.TY;
            this.etD = bhVar.TW;
            this.etE = bhVar.TX;
            VideoInfo rN = bhVar.rN();
            if (rN != null) {
                this.etF = rN.thumbnail_url;
                this.videoDuration = rN.video_duration.intValue();
                this.etH = rN.play_count.intValue();
            }
            bo sz = bhVar.sz();
            if (sz != null && sz.channelId > 0) {
                this.channelName = sz.channelName;
                this.channelId = sz.channelId;
            } else if (bhVar.getAuthor() != null) {
                this.PZ = bhVar.getAuthor().getUserName();
            }
            this.position = i;
        }
    }

    @Override // com.baidu.tieba.tbadkCore.data.p, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return etB;
    }
}
