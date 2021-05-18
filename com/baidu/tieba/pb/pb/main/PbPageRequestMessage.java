package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.AdExtParam;
import com.squareup.wire.Wire;
import d.a.j0.z0.w;
import d.a.k0.s2.g0.a;
import d.a.k0.s2.i0.b;
import tbclient.PbPage.AdParam;
import tbclient.PbPage.DataReq;
import tbclient.PbPage.PbPageReqIdl;
/* loaded from: classes5.dex */
public class PbPageRequestMessage extends NetMessage {
    public static final Wire WIRE = new Wire(new Class[0]);
    public Integer arround;
    public Integer back;
    public Integer banner;
    public String cacheKey;
    public Context context;
    public int floor_rn;
    public Long forumId;
    public Integer fromSmartFrs;
    public int from_push;
    public boolean isFromMark;
    public boolean isJumpFloor;
    public Integer isReqAd;
    public boolean isSubPostDataReverse;
    public int jumpFloorNum;
    public long kz;
    public Integer last;
    public String lastids;
    public int loadCount;
    public Integer lz;
    public int mAfterAdThreadCount;
    public int mFloorSortType;
    public String mLocate;
    public String mSchemeUrl;
    public Integer mark;
    public String message_click;
    public Integer message_id;
    public Integer needRepostRecommendForum;
    public String objParam1;
    public String obj_source;
    public long officialBarMsgId;
    public long opMessageID;
    public int opStat;
    public String opType;
    public String opUrl;
    public String oriUgcNid;
    public String oriUgcTid;
    public int oriUgcType;
    public String oriUgcVid;
    public long pid;
    public Integer pn;
    public Integer q_type;
    public Integer r;
    public int refreshCount;
    public Integer rn;
    public double scr_dip;
    public Integer scr_h;
    public Integer scr_w;
    public int sourceType;
    public String st_type;
    public Integer thread_type;
    public int updateType;
    public Integer with_floor;

    public PbPageRequestMessage() {
        super(CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001);
        this.isSubPostDataReverse = false;
        this.isJumpFloor = false;
        this.jumpFloorNum = 0;
        this.opType = null;
        this.opUrl = null;
        this.objParam1 = "";
        this.obj_source = "";
        this.fromSmartFrs = 0;
        this.isReqAd = 0;
        this.mSchemeUrl = "";
        this.sourceType = 2;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        try {
            DataReq.Builder builder = new DataReq.Builder();
            builder.pb_rn = 0;
            builder.mark = this.mark;
            builder.back = this.back;
            builder.kz = Long.valueOf(this.kz);
            builder.lz = this.lz;
            builder.r = this.r;
            builder.pid = Long.valueOf(this.pid);
            builder.with_floor = this.with_floor;
            builder.floor_rn = Integer.valueOf(this.floor_rn);
            builder.weipost = 0;
            builder.message_id = this.message_id;
            builder.s_model = 0;
            builder.rn = this.rn;
            builder.scr_w = this.scr_w;
            builder.scr_h = this.scr_h;
            builder.scr_dip = Double.valueOf(this.scr_dip);
            builder.q_type = this.q_type;
            builder.pn = this.pn;
            builder.st_type = this.st_type;
            builder.yuelaou_locate = this.mLocate;
            builder.thread_type = this.thread_type;
            builder.banner = this.banner;
            builder.arround = this.arround;
            builder.msg_click = this.message_click;
            builder.last = this.last;
            builder.lastids = this.lastids;
            builder.is_comm_reverse = Integer.valueOf(this.isSubPostDataReverse ? 1 : 0);
            builder.is_jumpfloor = Integer.valueOf(this.isJumpFloor ? 1 : 0);
            builder.jumpfloor_num = Integer.valueOf(this.jumpFloorNum);
            builder.broadcast_id = Long.valueOf(this.officialBarMsgId);
            builder.floor_sort_type = Integer.valueOf(this.mFloorSortType);
            if (this.opType != null) {
                builder.st_from = this.opType;
                builder.st_link = this.opUrl;
                builder.st_stat = Integer.valueOf(this.opStat);
                builder.st_task = Long.valueOf(this.opMessageID);
            }
            builder.obj_param1 = this.objParam1;
            builder.obj_source = this.obj_source;
            builder.from_smart_frs = this.fromSmartFrs;
            builder.app_pos = a.e().a();
            builder.forum_id = this.forumId;
            builder.need_repost_recommend_forum = this.needRepostRecommendForum;
            AdParam.Builder builder2 = new AdParam.Builder();
            builder2.refresh_count = Integer.valueOf(this.refreshCount);
            builder2.load_count = Integer.valueOf(this.loadCount);
            builder2.is_req_ad = this.isReqAd;
            builder.ad_param = builder2.build(false);
            builder.ori_ugc_nid = this.oriUgcNid;
            builder.ori_ugc_tid = this.oriUgcTid;
            builder.ori_ugc_type = Integer.valueOf(this.oriUgcType);
            builder.ori_ugc_vid = this.oriUgcVid;
            builder.after_ad_thread_count = Integer.valueOf(this.mAfterAdThreadCount);
            builder.ad_context_list = b.f().d("PB");
            builder.up_schema = this.mSchemeUrl;
            builder.from_push = Integer.valueOf(this.from_push);
            AdExtParam.a b2 = AdExtParam.a.b();
            b2.h(this.updateType);
            builder.ad_ext_params = b2.a();
            builder.source_type = Integer.valueOf(this.sourceType);
            w.c(builder, true, false, true);
            PbPageReqIdl.Builder builder3 = new PbPageReqIdl.Builder();
            builder3.data = builder.build(false);
            return builder3.build(false);
        } catch (Exception unused) {
            return null;
        }
    }

    public String getCacheKey() {
        return this.cacheKey;
    }

    public Context getContext() {
        return this.context;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public Integer getPn() {
        return this.pn;
    }

    public Integer getR() {
        return this.r;
    }

    public String getSchemeUrl() {
        return this.mSchemeUrl;
    }

    public int getUpdateType() {
        return this.updateType;
    }

    public long get_kz() {
        return this.kz;
    }

    public void setAfterAdThreadCount(int i2) {
        this.mAfterAdThreadCount = i2;
    }

    public void setCacheKey(String str) {
        this.cacheKey = str;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void setFloorSortType(int i2) {
        this.mFloorSortType = i2;
    }

    public void setFloor_rn(int i2) {
        this.floor_rn = i2;
    }

    public void setForumId(String str) {
        this.forumId = Long.valueOf(d.a.c.e.m.b.f(str, 0L));
    }

    public void setFromSmartFrs(int i2) {
        this.fromSmartFrs = Integer.valueOf(i2);
    }

    public void setFrom_push(int i2) {
        this.from_push = i2;
    }

    public void setIsFromMark(Boolean bool) {
        this.isFromMark = bool.booleanValue();
    }

    public void setIsJumpFloor(boolean z) {
        this.isJumpFloor = z;
    }

    public void setIsReqAd(int i2) {
        this.isReqAd = Integer.valueOf(i2);
    }

    public void setIsSubPostDataReverse(boolean z) {
        this.isSubPostDataReverse = z;
    }

    public void setJumpFloorNum(int i2) {
        this.jumpFloorNum = i2;
    }

    public void setLastids(String str) {
        this.lastids = str;
    }

    public void setLoadCount(int i2) {
        this.loadCount = i2;
    }

    public void setLocate(String str) {
        this.mLocate = str;
    }

    public void setNeedRepostRecommendForum(boolean z) {
        this.needRepostRecommendForum = Integer.valueOf(z ? 1 : 0);
    }

    public void setObjParam1(String str) {
        this.objParam1 = str;
    }

    public void setOfficialBarMsgId(long j) {
        this.officialBarMsgId = j;
    }

    public void setOpMessageID(long j) {
        this.opMessageID = j;
    }

    public void setOpStat(int i2) {
        this.opStat = i2;
    }

    public void setOpType(String str) {
        this.opType = str;
    }

    public void setOpUrl(String str) {
        this.opUrl = str;
    }

    public void setOriUgcNid(String str) {
        this.oriUgcNid = str;
    }

    public void setOriUgcTid(String str) {
        this.oriUgcTid = str;
    }

    public void setOriUgcType(int i2) {
        this.oriUgcType = i2;
    }

    public void setOriUgcVid(String str) {
        this.oriUgcVid = str;
    }

    public void setRefreshCount(int i2) {
        this.refreshCount = i2;
    }

    public void setSchemeUrl(String str) {
        this.mSchemeUrl = str;
    }

    public void setSourceType(int i2) {
        this.sourceType = i2;
    }

    public void setUpdateType(int i2) {
        this.updateType = i2;
    }

    public void set_arround(Integer num) {
        this.arround = num;
    }

    public void set_back(Integer num) {
        this.back = num;
    }

    public void set_banner(Integer num) {
        this.banner = num;
    }

    public void set_kz(long j) {
        this.kz = j;
    }

    public void set_last(Integer num) {
        this.last = num;
    }

    public void set_lz(Integer num) {
        this.lz = num;
    }

    public void set_mark(Integer num) {
        this.mark = num;
    }

    public void set_message_click(String str) {
        this.message_click = str;
    }

    public void set_message_id(Integer num) {
        this.message_id = num;
    }

    public void set_pid(long j) {
        this.pid = j;
    }

    public void set_pn(Integer num) {
        this.pn = num;
    }

    public void set_q_type(Integer num) {
        this.q_type = num;
    }

    public void set_r(Integer num) {
        this.r = num;
    }

    public void set_rn(Integer num) {
        this.rn = num;
    }

    public void set_scr_dip(double d2) {
        this.scr_dip = d2;
    }

    public void set_scr_h(Integer num) {
        this.scr_h = num;
    }

    public void set_scr_w(Integer num) {
        this.scr_w = num;
    }

    public void set_st_type(String str) {
        this.st_type = str;
    }

    public void set_thread_type(Integer num) {
        this.thread_type = num;
    }

    public void set_with_floor(Integer num) {
        this.with_floor = num;
    }
}
