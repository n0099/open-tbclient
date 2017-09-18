package com.baidu.tieba.pb.video;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bo;
import com.baidu.tieba.tbadkCore.data.PostData;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class k extends PostData {
    public static final BdUniqueId eZI = BdUniqueId.gen();
    public String VI;
    public long channelId;
    public String channelName;
    public long cud;
    public String eZJ;
    public String eZK;
    public String eZL;
    public String eZM;
    public String eZN;
    public long forumId;
    public String threadId;
    public int videoDuration;
    public boolean cAG = false;
    public boolean eZO = true;
    public boolean eZP = false;
    public int position = 0;

    public void a(bj bjVar, boolean z, boolean z2, boolean z3, int i) {
        if (bjVar != null) {
            this.eZO = z;
            this.eZP = z2;
            this.cAG = z3;
            this.threadId = bjVar.getTid();
            this.eZN = bjVar.getTitle();
            this.forumId = bjVar.getFid();
            this.eZJ = bjVar.ZJ;
            this.eZK = bjVar.ZH;
            this.eZL = bjVar.ZI;
            VideoInfo rS = bjVar.rS();
            if (rS != null) {
                this.eZM = rS.thumbnail_url;
                this.videoDuration = rS.video_duration.intValue();
                this.cud = rS.play_count.intValue();
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
        return eZI;
    }
}
