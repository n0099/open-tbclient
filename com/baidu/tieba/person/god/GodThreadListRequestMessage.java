package com.baidu.tieba.person.god;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.l;
import tbclient.GodThreadList.DataReq;
import tbclient.GodThreadList.GodThreadListReqIdl;
/* loaded from: classes.dex */
public class GodThreadListRequestMessage extends NetMessage {
    private int num;
    private int pn;
    private long userId;

    public GodThreadListRequestMessage() {
        super(CmdConfigHttp.CMD_GOD_THREAD_LIST, 309291);
    }

    public int getNum() {
        return this.num;
    }

    public void setNum(int i) {
        this.num = i;
    }

    public int getPn() {
        return this.pn;
    }

    public void setPn(int i) {
        this.pn = i;
    }

    public long getUserId() {
        return this.userId;
    }

    public void setUserId(long j) {
        this.userId = j;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        try {
            DataReq.Builder builder = new DataReq.Builder();
            builder.user_id = Long.valueOf(this.userId);
            builder.pn = Integer.valueOf(this.pn);
            builder.num = Integer.valueOf(this.num);
            int K = k.K(TbadkCoreApplication.m411getInst().getApp());
            int L = k.L(TbadkCoreApplication.m411getInst().getApp());
            int viewImageQuality = l.rn().getViewImageQuality();
            builder.scr_w = Integer.valueOf(K);
            builder.scr_h = Integer.valueOf(L);
            builder.scr_dip = Double.valueOf(k.M(TbadkCoreApplication.m411getInst().getApp()));
            builder.q_type = Integer.valueOf(viewImageQuality);
            if (z) {
                com.baidu.tbadk.util.i.a(builder, true);
            }
            GodThreadListReqIdl.Builder builder2 = new GodThreadListReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        } catch (Exception e) {
            return null;
        }
    }
}
