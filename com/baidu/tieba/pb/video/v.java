package com.baidu.tieba.pb.video;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.data.br;
import com.baidu.tieba.tbadkCore.data.PostData;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class v extends PostData {
    public static final BdUniqueId etd = BdUniqueId.gen();
    public String UZ;
    public long channelId;
    public String channelName;
    public String ete;
    public String etf;
    public String etg;
    public String eth;
    public String eti;
    public long etj;
    public long forumId;
    public String threadId;
    public int videoDuration;
    public boolean bXh = false;
    public boolean etk = true;
    public boolean etl = false;
    public int position = 0;

    public void a(bk bkVar, boolean z, boolean z2, boolean z3, int i) {
        if (bkVar != null) {
            this.etk = z;
            this.etl = z2;
            this.bXh = z3;
            this.threadId = bkVar.getTid();
            this.eti = bkVar.getTitle();
            this.forumId = bkVar.getFid();
            this.ete = bkVar.YS;
            this.etf = bkVar.YQ;
            this.etg = bkVar.YR;
            VideoInfo rP = bkVar.rP();
            if (rP != null) {
                this.eth = rP.thumbnail_url;
                this.videoDuration = rP.video_duration.intValue();
                this.etj = rP.play_count.intValue();
            }
            br sC = bkVar.sC();
            if (sC != null && sC.channelId > 0) {
                this.channelName = sC.channelName;
                this.channelId = sC.channelId;
            } else if (bkVar.getAuthor() != null) {
                this.UZ = bkVar.getAuthor().getUserName();
            }
            this.position = i;
        }
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return etd;
    }
}
