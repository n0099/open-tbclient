package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import tbclient.CommonReq;
import tbclient.PbPage.DataReq;
import tbclient.PbPage.PbPageReqIdl;
/* loaded from: classes.dex */
public class PbPageRequestMessage extends NetMessage {
    private Integer arround;
    private Integer back;
    private Integer banner;
    private String cacheKey;
    private CommonReq common;
    private Context context;
    private Integer floor_rn;
    private boolean isFromMark;
    private boolean isJumpFloor;
    private boolean isSubPostDataReverse;
    private int jumpFloorNum;
    private long kz;
    private Integer last;
    private String lastids;
    private Integer lz;
    private Integer mark;
    private String message_click;
    private Integer message_id;
    private long opMessageID;
    private int opStat;
    private String opType;
    private String opUrl;
    private Integer pb_rn;
    private long pid;
    private Integer pn;
    private Integer q_type;
    private Integer r;
    private Integer rn;
    private Integer s_model;
    private double scr_dip;
    private Integer scr_h;
    private Integer scr_w;
    private String st_type;
    private Integer thread_type;
    private int updateType;
    private Integer weipost;
    private Integer with_floor;

    public PbPageRequestMessage() {
        super(CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001);
        this.isSubPostDataReverse = false;
        this.isJumpFloor = false;
        this.jumpFloorNum = 0;
        this.opType = null;
        this.opUrl = null;
    }

    public Context getContext() {
        return this.context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public Integer get_pb_rn() {
        return this.pb_rn;
    }

    public void set_pb_rn(Integer num) {
        this.pb_rn = num;
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

    public Integer get_floor_rn() {
        return this.floor_rn;
    }

    public void set_floor_rn(Integer num) {
        this.floor_rn = num;
    }

    public Integer get_weipost() {
        return this.weipost;
    }

    public void set_weipost(Integer num) {
        this.weipost = num;
    }

    public Integer get_message_id() {
        return this.message_id;
    }

    public void set_message_id(Integer num) {
        this.message_id = num;
    }

    public String getOpType() {
        return this.opType;
    }

    public void setOpType(String str) {
        this.opType = str;
    }

    public String getOpUrl() {
        return this.opUrl;
    }

    public void setOpUrl(String str) {
        this.opUrl = str;
    }

    public int getOpStat() {
        return this.opStat;
    }

    public void setOpStat(int i) {
        this.opStat = i;
    }

    public long getOpMessageID() {
        return this.opMessageID;
    }

    public void setOpMessageID(long j) {
        this.opMessageID = j;
    }

    public Integer get_s_model() {
        return this.s_model;
    }

    public void set_s_model(Integer num) {
        this.s_model = num;
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

    public CommonReq get_common() {
        return this.common;
    }

    public void set_common(CommonReq commonReq) {
        this.common = commonReq;
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

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        try {
            DataReq.Builder builder = new DataReq.Builder();
            builder.pb_rn = get_pb_rn();
            builder.mark = get_mark();
            builder.back = get_back();
            builder.kz = Long.valueOf(get_kz());
            builder.lz = get_lz();
            builder.r = get_r();
            builder.pid = Long.valueOf(get_pid());
            builder.with_floor = get_with_floor();
            builder.floor_rn = get_floor_rn();
            builder.weipost = get_weipost();
            builder.message_id = get_message_id();
            builder.s_model = get_s_model();
            builder.rn = get_rn();
            builder.scr_w = get_scr_w();
            builder.scr_h = get_scr_h();
            builder.scr_dip = Double.valueOf(get_scr_dip());
            builder.q_type = get_q_type();
            builder.pn = get_pn();
            builder.st_type = get_st_type();
            builder.thread_type = get_thread_type();
            builder.banner = get_banner();
            builder.arround = get_arround();
            builder.common = get_common();
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
            if (z) {
                com.baidu.tbadk.util.h.a(builder, true);
            }
            PbPageReqIdl.Builder builder2 = new PbPageReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        } catch (Exception e) {
            return null;
        }
    }
}
