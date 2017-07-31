package com.baidu.tieba.pb.video;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.data.bq;
import com.baidu.tieba.tbadkCore.data.PostData;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class k extends PostData {
    public static final BdUniqueId eYk = BdUniqueId.gen();
    public String Wx;
    public long channelId;
    public String channelName;
    public String eYl;
    public String eYm;
    public String eYn;
    public String eYo;
    public String eYp;
    public long eYq;
    public long forumId;
    public String threadId;
    public int videoDuration;
    public boolean csE = false;
    public boolean eYr = true;
    public boolean eYs = false;
    public int position = 0;

    public void a(bl blVar, boolean z, boolean z2, boolean z3, int i) {
        if (blVar != null) {
            this.eYr = z;
            this.eYs = z2;
            this.csE = z3;
            this.threadId = blVar.getTid();
            this.eYp = blVar.getTitle();
            this.forumId = blVar.getFid();
            this.eYl = blVar.aaC;
            this.eYm = blVar.aaA;
            this.eYn = blVar.aaB;
            VideoInfo rW = blVar.rW();
            if (rW != null) {
                this.eYo = rW.thumbnail_url;
                this.videoDuration = rW.video_duration.intValue();
                this.eYq = rW.play_count.intValue();
            }
            bq sJ = blVar.sJ();
            if (sJ != null && sJ.channelId > 0) {
                this.channelName = sJ.channelName;
                this.channelId = sJ.channelId;
            } else if (blVar.getAuthor() != null) {
                this.Wx = blVar.getAuthor().getUserName();
            }
            this.position = i;
        }
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return eYk;
    }
}
