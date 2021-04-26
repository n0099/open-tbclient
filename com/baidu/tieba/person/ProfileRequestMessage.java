package com.baidu.tieba.person;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.a.c.e.p.l;
import d.a.i0.r.k;
import d.a.i0.z0.w;
import d.a.j0.f2.b;
import tbclient.Profile.DataReq;
import tbclient.Profile.ProfileReqIdl;
/* loaded from: classes4.dex */
public class ProfileRequestMessage extends NetMessage {
    public boolean error_hint;
    public Long friend_uid;
    public String friend_uid_portrait;
    public boolean from_db;
    public Integer has_plist;
    public boolean isSelf;
    public Integer is_from_usercenter;
    public Integer is_guest;
    public b mPersonCenterData;
    public Integer need_post_count;
    public Integer page;
    public Integer pn;
    public Integer rn;
    public String st_type;
    public Long uid;

    public ProfileRequestMessage() {
        super(CmdConfigHttp.PROFILE_HTTP_CMD, 303012);
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
            int k = l.k(TbadkCoreApplication.getInst().getApp());
            int i2 = l.i(TbadkCoreApplication.getInst().getApp());
            int e2 = k.c().e();
            builder.scr_w = Integer.valueOf(k);
            builder.scr_h = Integer.valueOf(i2);
            builder.scr_dip = Double.valueOf(l.h(TbadkCoreApplication.getInst().getApp()));
            builder.q_type = Integer.valueOf(e2);
            if (z) {
                w.a(builder, true);
            }
            ProfileReqIdl.Builder builder2 = new ProfileReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        } catch (Exception unused) {
            return null;
        }
    }

    public Integer getPage() {
        return this.page;
    }

    public b getPersonCenterData() {
        return this.mPersonCenterData;
    }

    public Long get_friend_uid() {
        return this.friend_uid;
    }

    public String get_friend_uid_portrait() {
        return this.friend_uid_portrait;
    }

    public Integer get_has_plist() {
        return this.has_plist;
    }

    public Integer get_is_guest() {
        return this.is_guest;
    }

    public Integer get_need_post_count() {
        return this.need_post_count;
    }

    public Integer get_pn() {
        return this.pn;
    }

    public Integer get_rn() {
        return this.rn;
    }

    public String get_st_type() {
        return this.st_type;
    }

    public Long get_uid() {
        return this.uid;
    }

    public boolean isSelf() {
        return this.isSelf;
    }

    public boolean is_error_hint() {
        return this.error_hint;
    }

    public boolean is_from_db() {
        return this.from_db;
    }

    public Integer is_from_usercenter() {
        return this.is_from_usercenter;
    }

    public void setIs_from_usercenter(Integer num) {
        this.is_from_usercenter = num;
    }

    public void setPage(Integer num) {
        this.page = num;
    }

    public void setPersonCenterData(b bVar) {
        this.mPersonCenterData = bVar;
    }

    public void setSelf(boolean z) {
        this.isSelf = z;
    }

    public void set_error_hint(boolean z) {
        this.error_hint = z;
    }

    public void set_friend_uid(Long l) {
        this.friend_uid = l;
    }

    public void set_friend_uid_portrait(String str) {
        this.friend_uid_portrait = str;
    }

    public void set_from_db(boolean z) {
        this.from_db = z;
    }

    public void set_has_plist(Integer num) {
        this.has_plist = num;
    }

    public void set_is_guest(Integer num) {
        this.is_guest = num;
    }

    public void set_need_post_count(Integer num) {
        this.need_post_count = num;
    }

    public void set_pn(Integer num) {
        this.pn = num;
    }

    public void set_rn(Integer num) {
        this.rn = num;
    }

    public void set_uid(Long l) {
        this.uid = l;
    }
}
