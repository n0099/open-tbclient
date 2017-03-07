package com.baidu.tieba.person;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.cache.o;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.person.f;
import com.squareup.wire.Wire;
import java.util.List;
import tbclient.Anti;
import tbclient.DealWindow;
import tbclient.Feedback;
import tbclient.Highlist;
import tbclient.PostInfoList;
import tbclient.Profile.ProfileResIdl;
import tbclient.Profile.TAInfo;
import tbclient.Profile.UserGodInfo;
import tbclient.TbBookrack;
import tbclient.User;
import tbclient.UserManChannelInfo;
/* loaded from: classes.dex */
public class ProfileSocketResponseMessage extends SocketResponsedMessage implements b {
    private static final String PROFILE_CACHE_KEY = "profile_cache_key";
    private Anti anti_stat;
    public TbBookrack bookrack;
    private boolean error_hint;
    private Feedback feedBack;
    private boolean from_db;
    private Highlist highlist;
    private boolean isSelf;
    private int pageNum;
    private List<PostInfoList> post_list;
    private TAInfo tainfo;
    public f ucCardData;
    private User user;
    private UserGodInfo userGodInfo;
    private UserManChannelInfo userManChannelInfo;
    public DealWindow window;

    public ProfileSocketResponseMessage() {
        super(303012);
    }

    public Highlist getHighlist() {
        return this.highlist;
    }

    public void setHighlist(Highlist highlist) {
        this.highlist = highlist;
    }

    public boolean isFrom_db() {
        return this.from_db;
    }

    public int getPageNum() {
        return this.pageNum;
    }

    public boolean isError_hint() {
        return this.error_hint;
    }

    @Override // com.baidu.tieba.person.b
    public f getUcCardData() {
        return this.ucCardData;
    }

    @Override // com.baidu.tieba.person.b
    public TbBookrack getBookrackData() {
        return this.bookrack;
    }

    @Override // com.baidu.tieba.person.b
    public UserGodInfo getUserGodInfo() {
        return this.userGodInfo;
    }

    @Override // com.baidu.tieba.person.b
    public UserManChannelInfo getUserChannelInfo() {
        return this.userManChannelInfo;
    }

    public boolean isError() {
        return hasError();
    }

    public String getErrorMsg() {
        return getErrorString();
    }

    @Override // com.baidu.tieba.person.b
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
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
            this.userManChannelInfo = profileResIdl.data.video_channel_info;
            this.user = profileResIdl.data.user;
            this.anti_stat = profileResIdl.data.anti_stat;
            this.tainfo = profileResIdl.data.tainfo;
            this.post_list = profileResIdl.data.post_list;
            if (profileResIdl.data.uc_card != null) {
                this.ucCardData = new f();
                this.ucCardData.a(profileResIdl.data.uc_card);
            }
            this.bookrack = profileResIdl.data.tbbookrack;
            this.highlist = profileResIdl.data.highs;
            this.window = profileResIdl.data.window;
            this.feedBack = profileResIdl.data.feedback;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void beforeDispatchInBackGround(int i, byte[] bArr) {
        o<String> L;
        super.beforeDispatchInBackGround(i, (int) bArr);
        if (this.ucCardData != null && (L = com.baidu.tbadk.core.c.a.to().L("tb.person_wallet_new", TbadkCoreApplication.getCurrentAccount())) != null && this.isSelf) {
            List<f.a> list = this.ucCardData.eBo;
            list.get(4).Hw = 8L;
            if (list != null) {
                for (f.a aVar : list) {
                    if (aVar.Hw > com.baidu.adp.lib.g.b.c(L.get(aVar.title), 0L)) {
                        aVar.eBp = true;
                    } else {
                        aVar.eBp = false;
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        o<byte[]> K = com.baidu.tbadk.core.c.a.to().K("tb_user_profile", TbadkCoreApplication.getCurrentAccountName());
        if (bArr != null && this.isSelf) {
            K.k(PROFILE_CACHE_KEY, bArr);
        }
    }

    @Override // com.baidu.tieba.person.b
    public int getErrorCode() {
        return getError();
    }

    @Override // com.baidu.tieba.person.b
    public Feedback getFeedBack() {
        return this.feedBack;
    }
}
