package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.squareup.wire.Wire;
import tbclient.PbPage.AdParam;
import tbclient.PbPage.DataReq;
import tbclient.PbPage.PbPageReqIdl;
/* loaded from: classes6.dex */
public class PbPageRequestMessage extends NetMessage {
    public static final Wire WIRE = new Wire(new Class[0]);
    private Integer arround;
    private Integer back;
    private Integer banner;
    private String cacheKey;
    private Context context;
    private Long forumId;
    private Integer fromSmartFrs;
    private boolean isFromMark;
    private boolean isJumpFloor;
    private boolean isSubPostDataReverse;
    private int jumpFloorNum;
    private long kz;
    private Integer last;
    private String lastids;
    private int loadCount;
    private Integer lz;
    private String mLocate;
    private Integer mark;
    private String message_click;
    private Integer message_id;
    private Integer needRepostRecommendForum;
    private String objParam1;
    public String obj_source;
    private long opMessageID;
    private int opStat;
    private String opType;
    private String opUrl;
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
        super(CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001);
        this.isSubPostDataReverse = false;
        this.isJumpFloor = false;
        this.jumpFloorNum = 0;
        this.opType = null;
        this.opUrl = null;
        this.objParam1 = "";
        this.obj_source = "";
        this.fromSmartFrs = 0;
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

    public Integer get_mark() {
        return this.mark;
    }

    public String get_message_click() {
        return this.message_click;
    }

    public void set_message_click(String str) {
        this.message_click = str;
    }

    public Integer get_last() {
        return this.last;
    }

    public void set_last(Integer num) {
        this.last = num;
    }

    public void set_mark(Integer num) {
        this.mark = num;
    }

    public Integer get_back() {
        return this.back;
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

    public Integer get_lz() {
        return this.lz;
    }

    public void set_lz(Integer num) {
        this.lz = num;
    }

    public Integer get_r() {
        return this.r;
    }

    public void set_r(Integer num) {
        this.r = num;
    }

    public long get_pid() {
        return this.pid;
    }

    public void set_pid(long j) {
        this.pid = j;
    }

    public Integer get_with_floor() {
        return this.with_floor;
    }

    public void set_with_floor(Integer num) {
        this.with_floor = num;
    }

    public Integer get_message_id() {
        return this.message_id;
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

    public Integer get_rn() {
        return this.rn;
    }

    public void set_rn(Integer num) {
        this.rn = num;
    }

    public Integer get_scr_w() {
        return this.scr_w;
    }

    public void set_scr_w(Integer num) {
        this.scr_w = num;
    }

    public Integer get_scr_h() {
        return this.scr_h;
    }

    public void set_scr_h(Integer num) {
        this.scr_h = num;
    }

    public double get_scr_dip() {
        return this.scr_dip;
    }

    public void set_scr_dip(double d) {
        this.scr_dip = d;
    }

    public Integer get_q_type() {
        return this.q_type;
    }

    public void set_q_type(Integer num) {
        this.q_type = num;
    }

    public Integer get_pn() {
        return this.pn;
    }

    public void set_pn(Integer num) {
        this.pn = num;
    }

    public String get_st_type() {
        return this.st_type;
    }

    public void set_st_type(String str) {
        this.st_type = str;
    }

    public String getLocate() {
        return this.mLocate;
    }

    public void setLocate(String str) {
        this.mLocate = str;
    }

    public Integer get_thread_type() {
        return this.thread_type;
    }

    public void set_thread_type(Integer num) {
        this.thread_type = num;
    }

    public Integer get_banner() {
        return this.banner;
    }

    public void set_banner(Integer num) {
        this.banner = num;
    }

    public Integer get_arround() {
        return this.arround;
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

    public String getLastids() {
        return this.lastids;
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
        this.forumId = Long.valueOf(com.baidu.adp.lib.g.b.d(str, 0L));
    }

    public void setNeedRepostRecommendForum(boolean z) {
        this.needRepostRecommendForum = Integer.valueOf(z ? 1 : 0);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        try {
            DataReq.Builder builder = new DataReq.Builder();
            builder.pb_rn = 0;
            builder.mark = get_mark();
            builder.back = get_back();
            builder.kz = Long.valueOf(get_kz());
            builder.lz = get_lz();
            builder.r = get_r();
            builder.pid = Long.valueOf(get_pid());
            builder.with_floor = get_with_floor();
            builder.floor_rn = 0;
            builder.weipost = 0;
            builder.message_id = get_message_id();
            builder.s_model = 0;
            builder.rn = get_rn();
            builder.scr_w = get_scr_w();
            builder.scr_h = get_scr_h();
            builder.scr_dip = Double.valueOf(get_scr_dip());
            builder.q_type = get_q_type();
            builder.pn = get_pn();
            builder.st_type = get_st_type();
            builder.yuelaou_locate = getLocate();
            builder.thread_type = get_thread_type();
            builder.banner = get_banner();
            builder.arround = get_arround();
            builder.msg_click = get_message_click();
            builder.last = get_last();
            builder.lastids = getLastids();
            builder.is_comm_reverse = Integer.valueOf(this.isSubPostDataReverse ? 1 : 0);
            builder.is_jumpfloor = Integer.valueOf(this.isJumpFloor ? 1 : 0);
            builder.jumpfloor_num = Integer.valueOf(this.jumpFloorNum);
            if (this.opType != null) {
                builder.st_from = this.opType;
                builder.st_link = this.opUrl;
                builder.st_stat = Integer.valueOf(this.opStat);
                builder.st_task = Long.valueOf(this.opMessageID);
            }
            builder.obj_param1 = this.objParam1;
            builder.obj_source = this.obj_source;
            builder.from_smart_frs = this.fromSmartFrs;
            builder.app_pos = com.baidu.tieba.recapp.d.a.bwa().bwd();
            builder.forum_id = this.forumId;
            builder.need_repost_recommend_forum = this.needRepostRecommendForum;
            AdParam.Builder builder2 = new AdParam.Builder();
            builder2.refresh_count = Integer.valueOf(this.refreshCount);
            builder2.load_count = Integer.valueOf(this.loadCount);
            builder.ad_param = builder2.build(false);
            com.baidu.tbadk.util.p.bindCommonParamsToProtobufData(builder, true, false, true);
            PbPageReqIdl.Builder builder3 = new PbPageReqIdl.Builder();
            builder3.data = builder.build(false);
            return builder3.build(false);
        } catch (Exception e) {
            return null;
        }
    }
}
