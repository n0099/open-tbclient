package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.util.AdExtParam;
import com.squareup.wire.Wire;
import tbclient.PbPage.AdParam;
import tbclient.PbPage.DataReq;
import tbclient.PbPage.PbPageReqIdl;
/* loaded from: classes22.dex */
public class PbPageRequestMessage extends NetMessage {
    public static final Wire WIRE = new Wire(new Class[0]);
    private Integer arround;
    private Integer back;
    private Integer banner;
    private String cacheKey;
    private Context context;
    private Long forumId;
    private Integer fromSmartFrs;
    private int from_push;
    private boolean isFromMark;
    private boolean isJumpFloor;
    private Integer isReqAd;
    private boolean isSubPostDataReverse;
    private int jumpFloorNum;
    private long kz;
    private Integer last;
    private String lastids;
    private int loadCount;
    private Integer lz;
    private int mAfterAdThreadCount;
    private int mFloorSortType;
    private String mLocate;
    private String mSchemeUrl;
    private Integer mark;
    private String message_click;
    private Integer message_id;
    private Integer needRepostRecommendForum;
    private String objParam1;
    public String obj_source;
    private long officialBarMsgId;
    private long opMessageID;
    private int opStat;
    private String opType;
    private String opUrl;
    private String oriUgcNid;
    private String oriUgcTid;
    private int oriUgcType;
    private String oriUgcVid;
    private long pid;
    private Integer pn;
    private Integer q_type;
    private Integer r;
    private int refreshCount;
    private Integer rn;
    private double scr_dip;
    private Integer scr_h;
    private Integer scr_w;
    private String st_type;
    private Integer thread_type;
    private int updateType;
    private Integer with_floor;

    public PbPageRequestMessage() {
        super(1001801, CmdConfigSocket.CMD_PB_PAGE);
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
    }

    public void setRefreshCount(int i) {
        this.refreshCount = i;
    }

    public void setLoadCount(int i) {
        this.loadCount = i;
    }

    public Context getContext() {
        return this.context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void set_message_click(String str) {
        this.message_click = str;
    }

    public void set_last(Integer num) {
        this.last = num;
    }

    public void set_mark(Integer num) {
        this.mark = num;
    }

    public void set_back(Integer num) {
        this.back = num;
    }

    public long get_kz() {
        return this.kz;
    }

    public void set_kz(long j) {
        this.kz = j;
    }

    public void set_lz(Integer num) {
        this.lz = num;
    }

    public void set_r(Integer num) {
        this.r = num;
    }

    public void set_pid(long j) {
        this.pid = j;
    }

    public void set_with_floor(Integer num) {
        this.with_floor = num;
    }

    public void set_message_id(Integer num) {
        this.message_id = num;
    }

    public void setOpType(String str) {
        this.opType = str;
    }

    public void setOpUrl(String str) {
        this.opUrl = str;
    }

    public void setOpStat(int i) {
        this.opStat = i;
    }

    public void setOpMessageID(long j) {
        this.opMessageID = j;
    }

    public void set_rn(Integer num) {
        this.rn = num;
    }

    public void set_scr_w(Integer num) {
        this.scr_w = num;
    }

    public void set_scr_h(Integer num) {
        this.scr_h = num;
    }

    public void set_scr_dip(double d) {
        this.scr_dip = d;
    }

    public void set_q_type(Integer num) {
        this.q_type = num;
    }

    public void set_pn(Integer num) {
        this.pn = num;
    }

    public void set_st_type(String str) {
        this.st_type = str;
    }

    public void setLocate(String str) {
        this.mLocate = str;
    }

    public void set_thread_type(Integer num) {
        this.thread_type = num;
    }

    public void set_banner(Integer num) {
        this.banner = num;
    }

    public void set_arround(Integer num) {
        this.arround = num;
    }

    public int getUpdateType() {
        return this.updateType;
    }

    public void setUpdateType(int i) {
        this.updateType = i;
    }

    public String getCacheKey() {
        return this.cacheKey;
    }

    public void setCacheKey(String str) {
        this.cacheKey = str;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public void setIsFromMark(Boolean bool) {
        this.isFromMark = bool.booleanValue();
    }

    public void setLastids(String str) {
        this.lastids = str;
    }

    public void setIsSubPostDataReverse(boolean z) {
        this.isSubPostDataReverse = z;
    }

    public void setIsJumpFloor(boolean z) {
        this.isJumpFloor = z;
    }

    public void setJumpFloorNum(int i) {
        this.jumpFloorNum = i;
    }

    public void setObjParam1(String str) {
        this.objParam1 = str;
    }

    public void setFromSmartFrs(int i) {
        this.fromSmartFrs = Integer.valueOf(i);
    }

    public void setForumId(String str) {
        this.forumId = Long.valueOf(com.baidu.adp.lib.f.b.toLong(str, 0L));
    }

    public void setNeedRepostRecommendForum(boolean z) {
        this.needRepostRecommendForum = Integer.valueOf(z ? 1 : 0);
    }

    public void setIsReqAd(int i) {
        this.isReqAd = Integer.valueOf(i);
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

    public void setAfterAdThreadCount(int i) {
        this.mAfterAdThreadCount = i;
    }

    public Integer getR() {
        return this.r;
    }

    public Integer getPn() {
        return this.pn;
    }

    public String getSchemeUrl() {
        return this.mSchemeUrl;
    }

    public void setSchemeUrl(String str) {
        this.mSchemeUrl = str;
    }

    public void setFrom_push(int i) {
        this.from_push = i;
    }

    public void setOfficialBarMsgId(long j) {
        this.officialBarMsgId = j;
    }

    public void setFloorSortType(int i) {
        this.mFloorSortType = i;
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
            builder.floor_rn = 0;
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
            builder.app_pos = com.baidu.tieba.recapp.d.a.dyA().dyE();
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
            builder.ad_context_list = com.baidu.tieba.recapp.report.b.dyH().dyK();
            builder.up_schema = this.mSchemeUrl;
            builder.from_push = Integer.valueOf(this.from_push);
            builder.ad_ext_params = AdExtParam.a.bAE().rI(this.updateType).bAF();
            com.baidu.tbadk.util.u.a(builder, true, false, true);
            PbPageReqIdl.Builder builder3 = new PbPageReqIdl.Builder();
            builder3.data = builder.build(false);
            return builder3.build(false);
        } catch (Exception e) {
            return null;
        }
    }
}
