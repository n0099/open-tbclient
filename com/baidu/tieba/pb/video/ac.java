package com.baidu.tieba.pb.video;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.data.bs;
import com.baidu.tieba.tbadkCore.data.PostData;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class ac extends PostData {
    public static final BdUniqueId eAZ = BdUniqueId.gen();
    public String UL;
    public long channelId;
    public String channelName;
    public String eBa;
    public String eBb;
    public String eBc;
    public String eBd;
    public String eBe;
    public long eBf;
    public long forumId;
    public String threadId;
    public int videoDuration;
    public boolean cdg = false;
    public boolean eBg = true;
    public boolean eBh = false;
    public int position = 0;

    public void a(bl blVar, boolean z, boolean z2, boolean z3, int i) {
        if (blVar != null) {
            this.eBg = z;
            this.eBh = z2;
            this.cdg = z3;
            this.threadId = blVar.getTid();
            this.eBe = blVar.getTitle();
            this.forumId = blVar.getFid();
            this.eBa = blVar.YO;
            this.eBb = blVar.YM;
            this.eBc = blVar.YN;
            VideoInfo rL = blVar.rL();
            if (rL != null) {
                this.eBd = rL.thumbnail_url;
                this.videoDuration = rL.video_duration.intValue();
                this.eBf = rL.play_count.intValue();
            }
            bs sx = blVar.sx();
            if (sx != null && sx.channelId > 0) {
                this.channelName = sx.channelName;
                this.channelId = sx.channelId;
            } else if (blVar.getAuthor() != null) {
                this.UL = blVar.getAuthor().getUserName();
            }
            this.position = i;
        }
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eAZ;
    }
}
