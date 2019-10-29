package com.baidu.tieba.pb.pb.godreply;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.r;
import java.util.List;
import tbclient.GetPostList.DataReq;
import tbclient.GetPostList.GetPostListReqIdl;
/* loaded from: classes4.dex */
public class LookMoreReqMessage extends NetMessage {
    public int is_comm_reverse;
    public Long kz;
    public List<Long> post_id;
    public int scr_h;
    public int scr_w;
    public int st_type;
    public int with_floor;

    public void setKz(Long l) {
        this.kz = l;
    }

    public void setWith_floor(int i) {
        this.with_floor = i;
    }

    public void setPost_id(List<Long> list) {
        this.post_id = list;
    }

    public void setScr_w(int i) {
        this.scr_w = i;
    }

    public void setScr_h(int i) {
        this.scr_h = i;
    }

    public void setSt_type(int i) {
        this.st_type = i;
    }

    public LookMoreReqMessage() {
        super(1001603, CmdConfigSocket.CMD_SOCKET_GOD_REPLY_LOOKMORE);
        setNetType(NetMessage.NetType.AUTO);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        try {
            int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
            int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst());
            DataReq.Builder builder = new DataReq.Builder();
            builder.kz = this.kz;
            builder.with_floor = Integer.valueOf(this.with_floor);
            builder.post_id = this.post_id;
            builder.scr_w = Integer.valueOf(equipmentWidth);
            builder.scr_h = Integer.valueOf(equipmentHeight);
            builder.st_type = Integer.valueOf(this.st_type);
            builder.is_comm_reverse = Integer.valueOf(this.is_comm_reverse);
            if (z) {
                r.a(builder, true);
            }
            GetPostListReqIdl.Builder builder2 = new GetPostListReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        } catch (Exception e) {
            return null;
        }
    }
}
