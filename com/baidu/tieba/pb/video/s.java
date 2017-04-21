package com.baidu.tieba.pb.video;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bp;
import com.baidu.tieba.tbadkCore.data.PostData;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class s extends PostData {
    public static final BdUniqueId exs = BdUniqueId.gen();
    public String VG;
    public long channelId;
    public String channelName;
    public String exu;
    public String exv;
    public String exw;
    public String exx;
    public String exy;
    public long exz;
    public long forumId;
    public String threadId;
    public int videoDuration;
    public boolean bZh = false;
    public boolean exA = true;
    public boolean exB = false;
    public int position = 0;

    public void a(bi biVar, boolean z, boolean z2, boolean z3, int i) {
        if (biVar != null) {
            this.exA = z;
            this.exB = z2;
            this.bZh = z3;
            this.threadId = biVar.getTid();
            this.exy = biVar.getTitle();
            this.forumId = biVar.getFid();
            this.exu = biVar.ZA;
            this.exv = biVar.Zy;
            this.exw = biVar.Zz;
            VideoInfo sF = biVar.sF();
            if (sF != null) {
                this.exx = sF.thumbnail_url;
                this.videoDuration = sF.video_duration.intValue();
                this.exz = sF.play_count.intValue();
            }
            bp ts = biVar.ts();
            if (ts != null && ts.channelId > 0) {
                this.channelName = ts.channelName;
                this.channelId = ts.channelId;
            } else if (biVar.getAuthor() != null) {
                this.VG = biVar.getAuthor().getUserName();
            }
            this.position = i;
        }
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return exs;
    }
}
