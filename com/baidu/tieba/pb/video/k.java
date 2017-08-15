package com.baidu.tieba.pb.video;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.data.bq;
import com.baidu.tieba.tbadkCore.data.PostData;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class k extends PostData {
    public static final BdUniqueId fad = BdUniqueId.gen();
    public String Wz;
    public long channelId;
    public String channelName;
    public String fae;
    public String faf;
    public String fag;
    public String fah;
    public String fai;
    public long faj;
    public long forumId;
    public String threadId;
    public int videoDuration;
    public boolean ctl = false;
    public boolean fak = true;
    public boolean fal = false;
    public int position = 0;

    public void a(bl blVar, boolean z, boolean z2, boolean z3, int i) {
        if (blVar != null) {
            this.fak = z;
            this.fal = z2;
            this.ctl = z3;
            this.threadId = blVar.getTid();
            this.fai = blVar.getTitle();
            this.forumId = blVar.getFid();
            this.fae = blVar.aaE;
            this.faf = blVar.aaC;
            this.fag = blVar.aaD;
            VideoInfo rW = blVar.rW();
            if (rW != null) {
                this.fah = rW.thumbnail_url;
                this.videoDuration = rW.video_duration.intValue();
                this.faj = rW.play_count.intValue();
            }
            bq sJ = blVar.sJ();
            if (sJ != null && sJ.channelId > 0) {
                this.channelName = sJ.channelName;
                this.channelId = sJ.channelId;
            } else if (blVar.getAuthor() != null) {
                this.Wz = blVar.getAuthor().getUserName();
            }
            this.position = i;
        }
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return fad;
    }
}
