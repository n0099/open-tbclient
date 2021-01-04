package com.baidu.tieba.pb.pb.sub;

import android.content.Context;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.util.t;
import tbclient.PbFloor.DataReq;
import tbclient.PbFloor.PbFloorReqIdl;
/* loaded from: classes2.dex */
public class SubPbRequestMessage extends NetMessage {
    private long forumId;
    private int is_comm_reverse;
    private long kz;
    private String oriUgcNid;
    private String oriUgcTid;
    private String oriUgcTopPid;
    private int oriUgcType;
    private String oriUgcVid;
    private long pid;
    private int pn;
    private Context richTextClickListener;
    private double scr_dip;
    private int scr_h;
    private int scr_w;
    private long spid;
    private String stType;
    private boolean treatDelPage;

    public SubPbRequestMessage(Context context, long j, long j2, long j3, int i, int i2, int i3, double d, String str, int i4) {
        super(1002100, CmdConfigSocket.CMD_SUBPB_FLOOR);
        this.richTextClickListener = context;
        this.kz = j;
        this.pid = j2;
        this.spid = j3;
        this.pn = i;
        this.scr_w = i2;
        this.scr_h = i3;
        this.scr_dip = d;
        this.stType = str;
        this.is_comm_reverse = i4;
    }

    public void setOriUgcNid(String str) {
        this.oriUgcNid = str;
    }

    public void setOriUgcTid(String str) {
        this.oriUgcTid = str;
    }

    public void setOriUgcType(int i) {
        this.oriUgcType = i;
    }

    public void setOriUgcVid(String str) {
        this.oriUgcVid = str;
    }

    public void setOriUgcTopPid(String str) {
        this.oriUgcTopPid = str;
    }

    public void setForumId(long j) {
        this.forumId = j;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.kz = Long.valueOf(this.kz);
        builder.pid = Long.valueOf(this.pid);
        builder.spid = Long.valueOf(this.spid);
        builder.pn = Integer.valueOf(this.pn);
        builder.scr_w = Integer.valueOf(this.scr_w);
        builder.scr_h = Integer.valueOf(this.scr_h);
        builder.scr_dip = Double.valueOf(this.scr_dip);
        builder.st_type = this.stType;
        builder.is_comm_reverse = Integer.valueOf(this.is_comm_reverse);
        builder.ori_ugc_nid = this.oriUgcNid;
        builder.ori_ugc_tid = this.oriUgcTid;
        builder.ori_ugc_type = Integer.valueOf(this.oriUgcType);
        builder.ori_ugc_vid = this.oriUgcVid;
        builder.top_ugc_pid = this.oriUgcTopPid;
        builder.forum_id = Long.valueOf(this.forumId);
        if (z) {
            t.b(builder, true);
        }
        PbFloorReqIdl.Builder builder2 = new PbFloorReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public Context getRichTextClickListener() {
        return this.richTextClickListener;
    }

    public boolean isTreatDelPage() {
        return this.treatDelPage;
    }

    public void setTreatDelPage(boolean z) {
        this.treatDelPage = z;
    }
}
