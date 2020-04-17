package com.baidu.tieba.person;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.util.t;
import tbclient.Profile.DataReq;
import tbclient.Profile.ProfileReqIdl;
/* loaded from: classes.dex */
public class ProfileRequestMessage extends NetMessage {
    private boolean error_hint;
    private Long friend_uid;
    private String friend_uid_portrait;
    private boolean from_db;
    private Integer has_plist;
    private boolean isSelf;
    private Integer is_from_usercenter;
    private Integer is_guest;
    private b mPersonCenterData;
    private Integer need_post_count;
    private Integer page;
    private Integer pn;
    private Integer rn;
    private String st_type;
    private Long uid;

    public ProfileRequestMessage() {
        super(1002700, CmdConfigSocket.CMD_PROFILE);
    }

    public boolean isSelf() {
        return this.isSelf;
    }

    public void setSelf(boolean z) {
        this.isSelf = z;
    }

    public boolean is_from_db() {
        return this.from_db;
    }

    public void set_from_db(boolean z) {
        this.from_db = z;
    }

    public boolean is_error_hint() {
        return this.error_hint;
    }

    public void set_error_hint(boolean z) {
        this.error_hint = z;
    }

    public Long get_uid() {
        return this.uid;
    }

    public void set_uid(Long l) {
        this.uid = l;
    }

    public Integer get_need_post_count() {
        return this.need_post_count;
    }

    public void set_need_post_count(Integer num) {
        this.need_post_count = num;
    }

    public Long get_friend_uid() {
        return this.friend_uid;
    }

    public void set_friend_uid(Long l) {
        this.friend_uid = l;
    }

    public String get_friend_uid_portrait() {
        return this.friend_uid_portrait;
    }

    public void set_friend_uid_portrait(String str) {
        this.friend_uid_portrait = str;
    }

    public Integer get_is_guest() {
        return this.is_guest;
    }

    public void set_is_guest(Integer num) {
        this.is_guest = num;
    }

    public String get_st_type() {
        return this.st_type;
    }

    public Integer get_pn() {
        return this.pn;
    }

    public void set_pn(Integer num) {
        this.pn = num;
    }

    public Integer get_rn() {
        return this.rn;
    }

    public void set_rn(Integer num) {
        this.rn = num;
    }

    public Integer get_has_plist() {
        return this.has_plist;
    }

    public void set_has_plist(Integer num) {
        this.has_plist = num;
    }

    public Integer is_from_usercenter() {
        return this.is_from_usercenter;
    }

    public void setIs_from_usercenter(Integer num) {
        this.is_from_usercenter = num;
    }

    public Integer getPage() {
        return this.page;
    }

    public void setPage(Integer num) {
        this.page = num;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        try {
            DataReq.Builder builder = new DataReq.Builder();
            builder.uid = get_uid();
            builder.need_post_count = get_need_post_count();
            builder.friend_uid = get_friend_uid();
            builder.friend_uid_portrait = get_friend_uid_portrait();
            builder.is_guest = get_is_guest();
            builder.st_type = get_st_type();
            builder.pn = get_pn();
            builder.rn = get_rn();
            builder.has_plist = get_has_plist();
            builder.is_from_usercenter = is_from_usercenter();
            builder.page = getPage();
            double equipmentDensity = l.getEquipmentDensity(TbadkCoreApplication.getInst().getApp());
            int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp());
            int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp());
            int viewImageQuality = i.aIe().getViewImageQuality();
            builder.scr_w = Integer.valueOf(equipmentWidth);
            builder.scr_h = Integer.valueOf(equipmentHeight);
            builder.scr_dip = Double.valueOf(equipmentDensity);
            builder.q_type = Integer.valueOf(viewImageQuality);
            if (z) {
                t.a(builder, true);
            }
            ProfileReqIdl.Builder builder2 = new ProfileReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        } catch (Exception e) {
            return null;
        }
    }

    public void setPersonCenterData(b bVar) {
        this.mPersonCenterData = bVar;
    }

    public b getPersonCenterData() {
        return this.mPersonCenterData;
    }
}
