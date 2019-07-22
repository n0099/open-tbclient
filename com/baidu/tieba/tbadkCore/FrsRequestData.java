package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.TbConfig;
import java.util.HashMap;
import tbclient.FrsPage.AdParam;
import tbclient.FrsPage.DataReq;
import tbclient.FrsPage.FrsPageReqIdl;
/* loaded from: classes3.dex */
public class FrsRequestData extends OrmObject implements com.baidu.tbadk.mvc.b.e, com.baidu.tbadk.mvc.b.h {
    public static final String CATEGORY_ID_KEY = "categoryid";
    public static final int FRS_SMARTLOAD_TYPE_BY_REFRESH = 1;
    public static final int FRS_SMART_LOAD_TYPE_BY_MORE = 2;
    public static final int FRS_SORT_TYPE_BY_LIKED_SORT = 4;
    public static final int FRS_SORT_TYPE_BY_LIKE_USER = 2;
    public static final int FRS_SORT_TYPE_BY_REPLY_TIME = 0;
    public static final int FRS_SORT_TYPE_BY_SEND_TYPE = 1;
    public static final int FRS_SORT_TYPE_BY_SMART_SORT = 3;
    public static final int FRS_SORT_TYPE_DEFAULT_VALUE = -1;
    public static final int IS_GOOD = 1;
    public static final int IS_NOT_GOOD = 0;
    public static final int THREAD_NUM_LOAD = 30;
    public static final int THREAD_NUM_PAGE = 90;
    private int categoryId;
    private int cid;
    private int ctime;
    private int dataSize;
    private int isGood;
    private String jds;
    private String jdt;
    private String kw;
    private String lastId;
    private int loadCount;
    private long mLastClickTid;
    private boolean needCache;
    private int netError;
    private int pn;
    private int qType;
    private int refreshCount;
    private double scrDip;
    private int scrH;
    private int scrW;
    private int stParam;
    private String stType;
    private int updateType;
    private int withGroup;
    private int rn = 90;
    private int jdr = 30;
    private String cbH = "";
    private int mSortType = -1;
    private int mLoadType = 1;
    private int jdu = 0;
    private int callFrom = 0;
    private HashMap<String, String> headers = null;
    private long jdv = 0;

    public void setLastClickTid(long j) {
        this.mLastClickTid = j;
    }

    public void setSortType(int i) {
        this.mSortType = i;
    }

    public int getSortType() {
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
        return this.mLoadType;
    }

    public void setLoadType(int i) {
        this.mLoadType = i;
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
        this.cbH = str;
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

    public void setLoadCount(int i) {
        this.loadCount = i;
    }

    public void setRefreshCount(int i) {
        this.refreshCount = i;
    }

    public void Ez(String str) {
        this.jds = str;
    }

    public void setObjSource(String str) {
        this.jdt = str;
    }

    public void AW(int i) {
        this.jdu = i;
    }

    public void setCallFrom(int i) {
        this.callFrom = i;
    }

    @Override // com.baidu.tbadk.mvc.b.g
    public HashMap<String, Object> aug() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.g
    public HashMap<String, String> auh() {
        return this.headers;
    }

    public void ek(String str, String str2) {
        if (this.headers == null) {
            this.headers = new HashMap<>();
        }
        this.headers.put(str, str2);
    }

    @Override // com.baidu.tbadk.mvc.b.k
    public Object fw(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.kw = this.kw;
        builder.pn = Integer.valueOf(this.pn);
        builder.rn = Integer.valueOf(this.rn);
        builder.rn_need = Integer.valueOf(this.jdr);
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
        builder.yuelaou_locate = this.cbH;
        builder.sort_type = Integer.valueOf(this.mSortType);
        builder.last_click_tid = Long.valueOf(this.mLastClickTid);
        builder.app_pos = com.baidu.tieba.recapp.d.a.cit().ciw();
        builder.load_type = Integer.valueOf(this.mLoadType);
        builder.obj_locate = this.jds;
        builder.obj_source = this.jdt;
        builder.is_selection = Integer.valueOf(this.jdu);
        builder.call_from = Integer.valueOf(this.callFrom);
        builder.hot_thread_id = Long.valueOf(this.jdv);
        AdParam.Builder builder2 = new AdParam.Builder();
        builder2.refresh_count = Integer.valueOf(this.refreshCount);
        builder2.load_count = Integer.valueOf(this.loadCount);
        builder2.yoga_lib_version = TbConfig.getCriusLibVersion();
        builder.ad_param = builder2.build(false);
        com.baidu.tbadk.util.s.bindCommonParamsToProtobufData(builder, true, false, true);
        FrsPageReqIdl.Builder builder3 = new FrsPageReqIdl.Builder();
        builder3.data = builder.build(false);
        return builder3.build(false);
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public String aud() {
        return null;
    }

    public void ex(long j) {
        this.jdv = j;
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public boolean aue() {
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

    public void AX(int i) {
        this.jdr = i;
    }
}
