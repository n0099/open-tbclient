package com.baidu.tieba.pb.video;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bo;
import com.baidu.tieba.tbadkCore.data.PostData;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class k extends PostData {
    public static final BdUniqueId eYO = BdUniqueId.gen();
    public String VI;
    public long channelId;
    public String channelName;
    public long ctk;
    public String eYP;
    public String eYQ;
    public String eYR;
    public String eYS;
    public String eYT;
    public long forumId;
    public String threadId;
    public int videoDuration;
    public boolean czO = false;
    public boolean eYU = true;
    public boolean eYV = false;
    public int position = 0;

    public void a(bj bjVar, boolean z, boolean z2, boolean z3, int i) {
        if (bjVar != null) {
            this.eYU = z;
            this.eYV = z2;
            this.czO = z3;
            this.threadId = bjVar.getTid();
            this.eYT = bjVar.getTitle();
            this.forumId = bjVar.getFid();
            this.eYP = bjVar.ZJ;
            this.eYQ = bjVar.ZH;
            this.eYR = bjVar.ZI;
            VideoInfo rS = bjVar.rS();
            if (rS != null) {
                this.eYS = rS.thumbnail_url;
                this.videoDuration = rS.video_duration.intValue();
                this.ctk = rS.play_count.intValue();
            }
            bo sF = bjVar.sF();
            if (sF != null && sF.channelId > 0) {
                this.channelName = sF.channelName;
                this.channelId = sF.channelId;
            } else if (bjVar.getAuthor() != null) {
                this.VI = bjVar.getAuthor().getUserName();
            }
            this.position = i;
        }
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return eYO;
    }
}
