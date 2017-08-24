package com.baidu.tieba.pb.video;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.data.bq;
import com.baidu.tieba.tbadkCore.data.PostData;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class k extends PostData {
    public static final BdUniqueId faf = BdUniqueId.gen();
    public String WA;
    public long channelId;
    public String channelName;
    public String fag;
    public String fah;
    public String fai;
    public String faj;
    public String fak;
    public long fal;
    public long forumId;
    public String threadId;
    public int videoDuration;
    public boolean ctl = false;
    public boolean fam = true;
    public boolean fan = false;
    public int position = 0;

    public void a(bl blVar, boolean z, boolean z2, boolean z3, int i) {
        if (blVar != null) {
            this.fam = z;
            this.fan = z2;
            this.ctl = z3;
            this.threadId = blVar.getTid();
            this.fak = blVar.getTitle();
            this.forumId = blVar.getFid();
            this.fag = blVar.aaE;
            this.fah = blVar.aaC;
            this.fai = blVar.aaD;
            VideoInfo rX = blVar.rX();
            if (rX != null) {
                this.faj = rX.thumbnail_url;
                this.videoDuration = rX.video_duration.intValue();
                this.fal = rX.play_count.intValue();
            }
            bq sK = blVar.sK();
            if (sK != null && sK.channelId > 0) {
                this.channelName = sK.channelName;
                this.channelId = sK.channelId;
            } else if (blVar.getAuthor() != null) {
                this.WA = blVar.getAuthor().getUserName();
            }
            this.position = i;
        }
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return faf;
    }
}
