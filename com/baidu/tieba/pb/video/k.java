package com.baidu.tieba.pb.video;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.data.bq;
import com.baidu.tieba.tbadkCore.data.PostData;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class k extends PostData {
    public static final BdUniqueId eWY = BdUniqueId.gen();
    public String Vb;
    public long channelId;
    public String channelName;
    public String eWZ;
    public String eXa;
    public String eXb;
    public String eXc;
    public String eXd;
    public long eXe;
    public long forumId;
    public String threadId;
    public int videoDuration;
    public boolean crt = false;
    public boolean eXf = true;
    public boolean eXg = false;
    public int position = 0;

    public void a(bl blVar, boolean z, boolean z2, boolean z3, int i) {
        if (blVar != null) {
            this.eXf = z;
            this.eXg = z2;
            this.crt = z3;
            this.threadId = blVar.getTid();
            this.eXd = blVar.getTitle();
            this.forumId = blVar.getFid();
            this.eWZ = blVar.Zg;
            this.eXa = blVar.Ze;
            this.eXb = blVar.Zf;
            VideoInfo rM = blVar.rM();
            if (rM != null) {
                this.eXc = rM.thumbnail_url;
                this.videoDuration = rM.video_duration.intValue();
                this.eXe = rM.play_count.intValue();
            }
            bq sz = blVar.sz();
            if (sz != null && sz.channelId > 0) {
                this.channelName = sz.channelName;
                this.channelId = sz.channelId;
            } else if (blVar.getAuthor() != null) {
                this.Vb = blVar.getAuthor().getUserName();
            }
            this.position = i;
        }
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return eWY;
    }
}
