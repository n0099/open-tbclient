package com.baidu.tieba.pb.video;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tieba.tbadkCore.data.PostData;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class k extends PostData {
    public static final BdUniqueId eTD = BdUniqueId.gen();
    public String VK;
    public long channelId;
    public String channelName;
    public long cuv;
    public String eTE;
    public String eTF;
    public String eTG;
    public String eTH;
    public String eTI;
    public long forumId;
    public String threadId;
    public int videoDuration;
    public boolean cBn = false;
    public boolean eTJ = true;
    public boolean eTK = false;
    public int position = 0;

    public void a(bh bhVar, boolean z, boolean z2, boolean z3, int i) {
        if (bhVar != null) {
            this.eTJ = z;
            this.eTK = z2;
            this.cBn = z3;
            this.threadId = bhVar.getTid();
            this.eTI = bhVar.getTitle();
            this.forumId = bhVar.getFid();
            this.eTE = bhVar.Zx;
            this.eTF = bhVar.Zv;
            this.eTG = bhVar.Zw;
            VideoInfo rF = bhVar.rF();
            if (rF != null) {
                this.eTH = rF.thumbnail_url;
                this.videoDuration = rF.video_duration.intValue();
                this.cuv = rF.play_count.intValue();
            }
            bm ss = bhVar.ss();
            if (ss != null && ss.channelId > 0) {
                this.channelName = ss.channelName;
                this.channelId = ss.channelId;
            } else if (bhVar.getAuthor() != null) {
                this.VK = bhVar.getAuthor().getUserName();
            }
            this.position = i;
        }
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return eTD;
    }
}
