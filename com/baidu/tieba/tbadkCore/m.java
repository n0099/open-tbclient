package com.baidu.tieba.tbadkCore;

import java.util.HashMap;
import tbclient.FrsPage.DataReq;
import tbclient.FrsPage.FrsPageReqIdl;
/* loaded from: classes.dex */
public class m extends com.baidu.adp.lib.a.b.a.a.i implements com.baidu.tbadk.mvc.b.e, com.baidu.tbadk.mvc.b.h {
    private int categoryId;
    private int cid;
    private int ctime;
    private int dataSize;
    private int isGood;
    private String kw;
    private String lastId;
    private long mLastClickTid;
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
    private String ahC = "";
    private int mSortType = -1;
    private int bPd = 1;

    public void setLastClickTid(long j) {
        this.mLastClickTid = j;
    }

    public void setSortType(int i) {
        this.mSortType = i;
    }

    public int agy() {
        return this.mSortType;
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

    public void setRn(int i) {
        this.rn = i;
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

    public void setScrW(int i) {
        this.scrW = i;
    }

    public void setScrH(int i) {
        this.scrH = i;
    }

    public void setScrDip(double d) {
        this.scrDip = d;
    }

    public void setqType(int i) {
        this.qType = i;
    }

    public void setCtime(int i) {
        this.ctime = i;
    }

    public void setDataSize(int i) {
        this.dataSize = i;
    }

    public void setNetError(int i) {
        this.netError = i;
    }

    public int getLoadType() {
        return this.bPd;
    }

    public void setLoadType(int i) {
        this.bPd = i;
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

    public void setYuelaouLocate(String str) {
        this.ahC = str;
    }

    public void setLastId(String str) {
        this.lastId = str;
    }

    public void setStType(String str) {
        this.stType = str;
    }

    public int getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(int i) {
        this.categoryId = i;
    }

    @Override // com.baidu.tbadk.mvc.b.g
    public HashMap<String, Object> mb() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.k
    public Object aa(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.kw = this.kw;
        builder.pn = Integer.valueOf(this.pn);
        builder.rn = 90;
        builder.rn_need = 30;
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
        builder.yuelaou_locate = this.ahC;
        builder.sort_type = Integer.valueOf(this.mSortType);
        builder.last_click_tid = Long.valueOf(this.mLastClickTid);
        builder.app_pos = com.baidu.tieba.recapp.c.a.beA().beD();
        builder.load_type = Integer.valueOf(this.bPd);
        com.baidu.tbadk.util.n.a(builder, true, false, true);
        FrsPageReqIdl.Builder builder2 = new FrsPageReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public String EN() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public boolean EO() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public boolean isNeedUid() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.b.d
    public String getCacheKey() {
        return null;
    }
}
