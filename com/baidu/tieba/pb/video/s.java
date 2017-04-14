package com.baidu.tieba.pb.video;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bp;
import com.baidu.tieba.tbadkCore.data.PostData;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class s extends PostData {
    public static final BdUniqueId evc = BdUniqueId.gen();
    public String VE;
    public long channelId;
    public String channelName;
    public String evd;
    public String eve;
    public String evf;
    public String evg;
    public String evh;
    public long evi;
    public long forumId;
    public String threadId;
    public int videoDuration;
    public boolean bWQ = false;
    public boolean evj = true;
    public boolean evk = false;
    public int position = 0;

    public void a(bi biVar, boolean z, boolean z2, boolean z3, int i) {
        if (biVar != null) {
            this.evj = z;
            this.evk = z2;
            this.bWQ = z3;
            this.threadId = biVar.getTid();
            this.evh = biVar.getTitle();
            this.forumId = biVar.getFid();
            this.evd = biVar.Zz;
            this.eve = biVar.Zx;
            this.evf = biVar.Zy;
            VideoInfo sF = biVar.sF();
            if (sF != null) {
                this.evg = sF.thumbnail_url;
                this.videoDuration = sF.video_duration.intValue();
                this.evi = sF.play_count.intValue();
            }
            bp ts = biVar.ts();
            if (ts != null && ts.channelId > 0) {
                this.channelName = ts.channelName;
                this.channelId = ts.channelId;
            } else if (biVar.getAuthor() != null) {
                this.VE = biVar.getAuthor().getUserName();
            }
            this.position = i;
        }
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return evc;
    }
}
