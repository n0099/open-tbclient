package com.baidu.tieba.tbadkCore;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.squareup.wire.Message;
import d.a.n0.z0.w;
import d.a.o0.t2.g0.a;
import tbclient.FrsPage.DataReq;
import tbclient.FrsPage.FrsPageReqIdl;
/* loaded from: classes5.dex */
public class FRSPageRequestMessage extends NetMessage {
    public int callFrom;
    public int categoryId;
    public int cid;
    public int ctime;
    public int dataSize;
    public int isGood;
    public String kw;
    public String lastId;
    public boolean needCache;
    public int netError;
    public int pn;
    public int qType;
    public int rn;
    public double scrDip;
    public int scrH;
    public int scrW;
    public int stParam;
    public String stType;
    public int updateType;
    public int withGroup;

    public FRSPageRequestMessage() {
        super(CmdConfigHttp.FRS_HTTP_CMD, 301001);
    }

    public int getCategoryId() {
        return this.categoryId;
    }

    public int getCid() {
        return this.cid;
    }

    public int getCtime() {
        return this.ctime;
    }

    public int getDataSize() {
        return this.dataSize;
    }

    public int getIsGood() {
        return this.isGood;
    }

    public String getKw() {
        return this.kw;
    }

    public String getLastId() {
        return this.lastId;
    }

    public int getNetError() {
        return this.netError;
    }

    public int getPn() {
        return this.pn;
    }

    public int getRn() {
        return this.rn;
    }

    public double getScrDip() {
        return this.scrDip;
    }

    public int getScrH() {
        return this.scrH;
    }

    public int getScrW() {
        return this.scrW;
    }

    public int getStParam() {
        return this.stParam;
    }

    public String getStType() {
        return this.stType;
    }

    public int getUpdateType() {
        return this.updateType;
    }

    public int getWithGroup() {
        return this.withGroup;
    }

    public int getqType() {
        return this.qType;
    }

    public boolean isNeedCache() {
        return this.needCache;
    }

    public void setCallFrom(int i2) {
        this.callFrom = i2;
    }

    public void setCategoryId(int i2) {
        this.categoryId = i2;
    }

    public void setCid(int i2) {
        this.cid = i2;
    }

    public void setCtime(int i2) {
        this.ctime = i2;
    }

    public void setDataSize(int i2) {
        this.dataSize = i2;
    }

    public void setIsGood(int i2) {
        this.isGood = i2;
    }

    public void setKw(String str) {
        this.kw = str;
    }

    public void setLastId(String str) {
        this.lastId = str;
    }

    public void setNeedCache(boolean z) {
        this.needCache = z;
    }

    public void setNetError(int i2) {
        this.netError = i2;
    }

    public void setPn(int i2) {
        this.pn = i2;
    }

    public void setRn(int i2) {
        this.rn = i2;
    }

    public void setScrDip(double d2) {
        this.scrDip = d2;
    }

    public void setScrH(int i2) {
        this.scrH = i2;
    }

    public void setScrW(int i2) {
        this.scrW = i2;
    }

    public void setStParam(int i2) {
        this.stParam = i2;
    }

    public void setStType(String str) {
        this.stType = str;
    }

    public void setUpdateType(int i2) {
        this.updateType = i2;
    }

    public void setWithGroup(int i2) {
        this.withGroup = i2;
    }

    public void setqType(int i2) {
        this.qType = i2;
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
        builder.app_pos = a.e().a();
        w.c(builder, true, false, true);
        FrsPageReqIdl.Builder builder2 = new FrsPageReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
