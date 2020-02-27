package com.baidu.tieba.tbadkCore;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.squareup.wire.Message;
import tbclient.FrsPage.DataReq;
import tbclient.FrsPage.FrsPageReqIdl;
/* loaded from: classes8.dex */
public class FRSPageRequestMessage extends NetMessage {
    private int callFrom;
    private int categoryId;
    private int cid;
    private int ctime;
    private int dataSize;
    private int isGood;
    private String kw;
    private String lastId;
    private boolean needCache;
    private int netError;
    private int pn;
    private int qType;
    private int rn;
    private double scrDip;
    private int scrH;
    private int scrW;
    private int stParam;
    private String stType;
    private int updateType;
    private int withGroup;

    public FRSPageRequestMessage() {
        super(1001703, CmdConfigSocket.CMD_FRS_PAGE);
    }

    public boolean isNeedCache() {
        return this.needCache;
    }

    public void setNeedCache(boolean z) {
        this.needCache = z;
    }

    public int getUpdateType() {
        return this.updateType;
    }

    public void setUpdateType(int i) {
        this.updateType = i;
    }

    public String getLastId() {
        return this.lastId;
    }

    public void setLastId(String str) {
        this.lastId = str;
    }

    public String getStType() {
        return this.stType;
    }

    public void setStType(String str) {
        this.stType = str;
    }

    public String getKw() {
        return this.kw;
    }

    public void setKw(String str) {
        this.kw = str;
    }

    public int getPn() {
        return this.pn;
    }

    public void setPn(int i) {
        this.pn = i;
    }

    public int getRn() {
        return this.rn;
    }

    public void setRn(int i) {
        this.rn = i;
    }

    public int getWithGroup() {
        return this.withGroup;
    }

    public void setWithGroup(int i) {
        this.withGroup = i;
    }

    public int getIsGood() {
        return this.isGood;
    }

    public void setIsGood(int i) {
        this.isGood = i;
    }

    public int getCid() {
        return this.cid;
    }

    public void setCid(int i) {
        this.cid = i;
    }

    public int getScrW() {
        return this.scrW;
    }

    public void setScrW(int i) {
        this.scrW = i;
    }

    public int getScrH() {
        return this.scrH;
    }

    public void setScrH(int i) {
        this.scrH = i;
    }

    public double getScrDip() {
        return this.scrDip;
    }

    public void setScrDip(double d) {
        this.scrDip = d;
    }

    public int getqType() {
        return this.qType;
    }

    public void setqType(int i) {
        this.qType = i;
    }

    public int getStParam() {
        return this.stParam;
    }

    public void setStParam(int i) {
        this.stParam = i;
    }

    public int getCtime() {
        return this.ctime;
    }

    public void setCtime(int i) {
        this.ctime = i;
    }

    public int getDataSize() {
        return this.dataSize;
    }

    public void setDataSize(int i) {
        this.dataSize = i;
    }

    public int getNetError() {
        return this.netError;
    }

    public void setNetError(int i) {
        this.netError = i;
    }

    public int getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(int i) {
        this.categoryId = i;
    }

    public void setCallFrom(int i) {
        this.callFrom = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.NetMessage
    public Message encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.kw = this.kw;
        builder.pn = Integer.valueOf(this.pn);
        builder.rn = Integer.valueOf(this.rn);
        builder.with_group = Integer.valueOf(this.withGroup);
        builder.is_good = Integer.valueOf(this.isGood);
        builder.cid = Integer.valueOf(this.cid);
        builder.scr_w = Integer.valueOf(this.scrW);
        builder.scr_h = Integer.valueOf(this.scrH);
        builder.scr_dip = Double.valueOf(this.scrDip);
        builder.st_type = this.stType;
        builder.q_type = Integer.valueOf(this.qType);
        builder.st_param = Integer.valueOf(this.stParam);
        builder.ctime = Integer.valueOf(this.ctime);
        builder.data_size = Integer.valueOf(this.dataSize);
        builder.net_error = Integer.valueOf(this.netError);
        builder.lastids = this.lastId;
        builder.category_id = Integer.valueOf(this.categoryId);
        builder.call_from = Integer.valueOf(this.callFrom);
        builder.app_pos = com.baidu.tieba.recapp.d.a.cDi().cDl();
        com.baidu.tbadk.util.t.a(builder, true, false, true);
        FrsPageReqIdl.Builder builder2 = new FrsPageReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
