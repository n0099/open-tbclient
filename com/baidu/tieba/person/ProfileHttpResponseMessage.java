package com.baidu.tieba.person;

import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.h.b;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tieba.person.g;
import com.squareup.wire.Wire;
import java.util.List;
import tbclient.Anti;
import tbclient.DealWindow;
import tbclient.Highlist;
import tbclient.PostInfoList;
import tbclient.Profile.ProfileResIdl;
import tbclient.Profile.TAInfo;
import tbclient.Profile.UserGodInfo;
import tbclient.TbBookrack;
import tbclient.User;
/* loaded from: classes.dex */
public class ProfileHttpResponseMessage extends TbHttpResponsedMessage implements c {
    private static final String PROFILE_CACHE_KEY = "profile_cache_key";
    private Anti anti_stat;
    public TbBookrack bookrack;
    private boolean error_hint;
    private boolean from_db;
    private Highlist highlist;
    private boolean isSelf;
    private int pageNum;
    private List<PostInfoList> post_list;
    private TAInfo tainfo;
    public g ucCardData;
    private User user;
    private UserGodInfo userGodInfo;
    public DealWindow window;

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

    @Override // com.baidu.tieba.person.c
    public g getUcCardData() {
        return this.ucCardData;
    }

    @Override // com.baidu.tieba.person.c
    public TbBookrack getBookrackData() {
        return this.bookrack;
    }

    @Override // com.baidu.tieba.person.c
    public UserGodInfo getUserGodInfo() {
        return this.userGodInfo;
    }

    public boolean isError() {
        return hasError();
    }

    public String getErrorMsg() {
        return getErrorString();
    }

    @Override // com.baidu.tieba.person.c
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

    public boolean isSelf() {
        return this.isSelf;
    }

    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
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
            if (profileResIdl.data.uc_card != null) {
                this.ucCardData = new g();
                this.ucCardData.a(profileResIdl.data.uc_card);
            }
            this.bookrack = profileResIdl.data.tbbookrack;
            this.highlist = profileResIdl.data.highs;
            this.window = profileResIdl.data.window;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        o<byte[]> M = com.baidu.tbadk.core.b.a.sT().M("tb_user_profile", TbadkCoreApplication.getCurrentAccountName());
        if (bArr != null && this.isSelf) {
            M.k(PROFILE_CACHE_KEY, bArr);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void beforeDispatchInBackGround(int i, byte[] bArr) {
        o<String> N;
        super.beforeDispatchInBackGround(i, (int) bArr);
        if (this.ucCardData != null && (N = com.baidu.tbadk.core.b.a.sT().N("tb.person_wallet_new", TbadkCoreApplication.getCurrentAccount())) != null && this.isSelf) {
            List<g.a> list = this.ucCardData.eBB;
            list.get(4).At = 8L;
            if (list != null) {
                for (g.a aVar : list) {
                    if (aVar.At > b.c(N.get(aVar.title), 0L)) {
                        aVar.eBC = true;
                    } else {
                        aVar.eBC = false;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.person.c
    public int getErrorCode() {
        return getError();
    }
}
