package com.baidu.tieba.pb.video;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.data.bt;
import com.baidu.tieba.tbadkCore.data.PostData;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class ac extends PostData {
    public static final BdUniqueId eKx = BdUniqueId.gen();
    public String UK;
    public long channelId;
    public String channelName;
    public String eKA;
    public String eKB;
    public String eKC;
    public long eKD;
    public String eKy;
    public String eKz;
    public long forumId;
    public String threadId;
    public int videoDuration;
    public boolean cls = false;
    public boolean eKE = true;
    public boolean eKF = false;
    public int position = 0;

    public void a(bm bmVar, boolean z, boolean z2, boolean z3, int i) {
        if (bmVar != null) {
            this.eKE = z;
            this.eKF = z2;
            this.cls = z3;
            this.threadId = bmVar.getTid();
            this.eKC = bmVar.getTitle();
            this.forumId = bmVar.getFid();
            this.eKy = bmVar.YP;
            this.eKz = bmVar.YN;
            this.eKA = bmVar.YO;
            VideoInfo rI = bmVar.rI();
            if (rI != null) {
                this.eKB = rI.thumbnail_url;
                this.videoDuration = rI.video_duration.intValue();
                this.eKD = rI.play_count.intValue();
            }
            bt sv = bmVar.sv();
            if (sv != null && sv.channelId > 0) {
                this.channelName = sv.channelName;
                this.channelId = sv.channelId;
            } else if (bmVar.getAuthor() != null) {
                this.UK = bmVar.getAuthor().getUserName();
            }
            this.position = i;
        }
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eKx;
    }
}
