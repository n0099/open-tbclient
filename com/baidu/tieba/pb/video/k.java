package com.baidu.tieba.pb.video;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tieba.tbadkCore.data.PostData;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class k extends PostData {
    public static final BdUniqueId eTR = BdUniqueId.gen();
    public String VW;
    public long channelId;
    public String channelName;
    public long cuH;
    public String eTS;
    public String eTT;
    public String eTU;
    public String eTV;
    public String eTW;
    public long forumId;
    public String threadId;
    public int videoDuration;
    public boolean cBz = false;
    public boolean eTX = true;
    public boolean eTY = false;
    public int position = 0;

    public void a(bh bhVar, boolean z, boolean z2, boolean z3, int i) {
        if (bhVar != null) {
            this.eTX = z;
            this.eTY = z2;
            this.cBz = z3;
            this.threadId = bhVar.getTid();
            this.eTW = bhVar.getTitle();
            this.forumId = bhVar.getFid();
            this.eTS = bhVar.ZJ;
            this.eTT = bhVar.ZH;
            this.eTU = bhVar.ZI;
            VideoInfo rM = bhVar.rM();
            if (rM != null) {
                this.eTV = rM.thumbnail_url;
                this.videoDuration = rM.video_duration.intValue();
                this.cuH = rM.play_count.intValue();
            }
            bm sz = bhVar.sz();
            if (sz != null && sz.channelId > 0) {
                this.channelName = sz.channelName;
                this.channelId = sz.channelId;
            } else if (bhVar.getAuthor() != null) {
                this.VW = bhVar.getAuthor().getUserName();
            }
            this.position = i;
        }
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return eTR;
    }
}
