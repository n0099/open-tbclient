package com.baidu.tieba.pb.pb.godreply;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.b.c.e.p.l;
import d.b.h0.z0.w;
import java.util.List;
import tbclient.GetPostList.DataReq;
import tbclient.GetPostList.GetPostListReqIdl;
/* loaded from: classes3.dex */
public class LookMoreReqMessage extends NetMessage {
    public int is_comm_reverse;
    public Long kz;
    public List<Long> post_id;
    public int scr_h;
    public int scr_w;
    public int st_type;
    public int with_floor;

    public LookMoreReqMessage() {
        super(CmdConfigHttp.CMD_PB_GOD_MORE, 309446);
        setNetType(NetMessage.NetType.AUTO);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        try {
            int k = l.k(TbadkCoreApplication.getInst());
            int i = l.i(TbadkCoreApplication.getInst());
            DataReq.Builder builder = new DataReq.Builder();
            builder.kz = this.kz;
            builder.with_floor = Integer.valueOf(this.with_floor);
            builder.post_id = this.post_id;
            builder.scr_w = Integer.valueOf(k);
            builder.scr_h = Integer.valueOf(i);
            builder.st_type = Integer.valueOf(this.st_type);
            builder.is_comm_reverse = Integer.valueOf(this.is_comm_reverse);
            if (z) {
                w.a(builder, true);
            }
            GetPostListReqIdl.Builder builder2 = new GetPostListReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        } catch (Exception unused) {
            return null;
        }
    }

    public void setKz(Long l) {
        this.kz = l;
    }

    public void setPost_id(List<Long> list) {
        this.post_id = list;
    }

    public void setScr_h(int i) {
        this.scr_h = i;
    }

    public void setScr_w(int i) {
        this.scr_w = i;
    }

    public void setSt_type(int i) {
        this.st_type = i;
    }

    public void setWith_floor(int i) {
        this.with_floor = i;
    }
}
