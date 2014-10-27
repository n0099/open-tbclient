package com.baidu.tieba.person;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import tbclient.Profile.DataReq;
import tbclient.Profile.ProfileReqIdl;
/* loaded from: classes.dex */
public class ProfileRequestMessage extends NetMessage {
    private boolean error_hint;
    private Long friend_uid;
    private boolean from_db;
    private Integer has_plist;
    private boolean isSelf;
    private Integer is_guest;
    private Integer need_post_count;
    private Integer pn;
    private Integer rn;
    private String st_type;
    private Integer uid;

    public ProfileRequestMessage() {
        super(CmdConfigHttp.PROFILE_HTTP_CMD, 303012);
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

    public Integer get_uid() {
        return this.uid;
    }

    public void set_uid(Integer num) {
        this.uid = num;
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

    public Integer get_is_guest() {
        return this.is_guest;
    }

    public void set_is_guest(Integer num) {
        this.is_guest = num;
    }

    public String get_st_type() {
        return this.st_type;
    }

    public void set_st_type(String str) {
        this.st_type = str;
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

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        try {
            DataReq.Builder builder = new DataReq.Builder();
            builder.uid = get_uid();
            builder.need_post_count = get_need_post_count();
            builder.friend_uid = get_friend_uid();
            builder.is_guest = get_is_guest();
            builder.st_type = get_st_type();
            builder.pn = get_pn();
            builder.rn = get_rn();
            builder.has_plist = get_has_plist();
            if (z) {
                com.baidu.tbadk.util.g.a(builder, true);
            }
            ProfileReqIdl.Builder builder2 = new ProfileReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        } catch (Exception e) {
            return null;
        }
    }
}
