package com.baidu.tieba.pb.video;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bq;
import com.baidu.tieba.tbadkCore.data.PostData;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class s extends PostData {
    public static final BdUniqueId ewW = BdUniqueId.gen();
    public String Vm;
    public long channelId;
    public String channelName;
    public String ewX;
    public String ewY;
    public String ewZ;
    public String exa;
    public String exb;
    public long exc;
    public long forumId;
    public String threadId;
    public int videoDuration;
    public boolean bXb = false;
    public boolean exd = true;
    public boolean exe = false;
    public int position = 0;

    public void a(bj bjVar, boolean z, boolean z2, boolean z3, int i) {
        if (bjVar != null) {
            this.exd = z;
            this.exe = z2;
            this.bXb = z3;
            this.threadId = bjVar.getTid();
            this.exb = bjVar.getTitle();
            this.forumId = bjVar.getFid();
            this.ewX = bjVar.Zj;
            this.ewY = bjVar.Zh;
            this.ewZ = bjVar.Zi;
            VideoInfo sh = bjVar.sh();
            if (sh != null) {
                this.exa = sh.thumbnail_url;
                this.videoDuration = sh.video_duration.intValue();
                this.exc = sh.play_count.intValue();
            }
            bq sU = bjVar.sU();
            if (sU != null && sU.channelId > 0) {
                this.channelName = sU.channelName;
                this.channelId = sU.channelId;
            } else if (bjVar.getAuthor() != null) {
                this.Vm = bjVar.getAuthor().getUserName();
            }
            this.position = i;
        }
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return ewW;
    }
}
