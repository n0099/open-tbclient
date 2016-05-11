package com.baidu.tieba.person;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import java.util.List;
import tbclient.Anti;
import tbclient.Highlist;
import tbclient.PostInfoList;
import tbclient.Profile.ProfileResIdl;
import tbclient.Profile.TAInfo;
import tbclient.Profile.UserGodInfo;
import tbclient.UcCard;
import tbclient.User;
/* loaded from: classes.dex */
public class ProfileHttpResponseMessage extends TbHttpResponsedMessage {
    private static final String PROFILE_CACHE_KEY = "profile_cache_key";
    private Anti anti_stat;
    private boolean error_hint;
    private boolean from_db;
    private Highlist highlist;
    private boolean isSelf;
    private int pageNum;
    private List<PostInfoList> post_list;
    private TAInfo tainfo;
    private UcCard ucCard;
    private User user;
    private UserGodInfo userGodInfo;

    public ProfileHttpResponseMessage(int i) {
        super(i);
    }

    public Highlist getHighlist() {
        return this.highlist;
    }

    public void setHighlist(Highlist highlist) {
        this.highlist = highlist;
    }

    public int getPageNum() {
        return this.pageNum;
    }

    public boolean isFrom_db() {
        return this.from_db;
    }

    public boolean isError_hint() {
        return this.error_hint;
    }

    public UserGodInfo getUserGodInfo() {
        return this.userGodInfo;
    }

    public User GetUser() {
        return this.user;
    }

    public Anti GetAntiStat() {
        return this.anti_stat;
    }

    public TAInfo GetTainfo() {
        return this.tainfo;
    }

    public List<PostInfoList> GetPostList() {
        return this.post_list;
    }

    public UcCard getUcCard() {
        return this.ucCard;
    }

    public void setUcCard(UcCard ucCard) {
        this.ucCard = ucCard;
    }

    public boolean isSelf() {
        return this.isSelf;
    }

    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) {
        ProfileRequestMessage profileRequestMessage = (ProfileRequestMessage) getOrginalMessage().getExtra();
        this.from_db = profileRequestMessage.is_from_db();
        this.error_hint = profileRequestMessage.is_error_hint();
        this.isSelf = profileRequestMessage.isSelf();
        if (profileRequestMessage.get_pn() != null) {
            this.pageNum = profileRequestMessage.get_pn().intValue();
        }
        ProfileResIdl profileResIdl = (ProfileResIdl) new Wire(new Class[0]).parseFrom(bArr, ProfileResIdl.class);
        if (profileResIdl != null) {
            setError(profileResIdl.error.errorno.intValue());
            setErrorString(profileResIdl.error.usermsg);
        }
        if (getError() == 0) {
            this.userGodInfo = profileResIdl.data.user_god_info;
            this.user = profileResIdl.data.user;
            this.anti_stat = profileResIdl.data.anti_stat;
            this.tainfo = profileResIdl.data.tainfo;
            this.post_list = profileResIdl.data.post_list;
            this.ucCard = profileResIdl.data.uc_card;
            this.highlist = profileResIdl.data.highs;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        com.baidu.adp.lib.cache.o<byte[]> N = com.baidu.tbadk.core.b.a.rR().N("tb_user_profile", TbadkCoreApplication.getCurrentAccountName());
        if (bArr != null && this.isSelf) {
            N.e(PROFILE_CACHE_KEY, bArr);
        }
    }
}
