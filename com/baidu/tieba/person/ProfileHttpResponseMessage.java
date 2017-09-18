package com.baidu.tieba.person;

import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tieba.person.l;
import com.squareup.wire.Wire;
import java.util.List;
import tbclient.Anti;
import tbclient.DealWindow;
import tbclient.DynamicInfo;
import tbclient.Feedback;
import tbclient.ForumDynamic;
import tbclient.Highlist;
import tbclient.ModuleInfo;
import tbclient.PostInfoList;
import tbclient.Profile.NicknameInfo;
import tbclient.Profile.ProfileResIdl;
import tbclient.Profile.TAInfo;
import tbclient.Profile.UserAgreeInfo;
import tbclient.Profile.UserGodInfo;
import tbclient.TbBookrack;
import tbclient.User;
import tbclient.UserManChannelInfo;
/* loaded from: classes.dex */
public class ProfileHttpResponseMessage extends TbHttpResponsedMessage implements f {
    private static final String PROFILE_CACHE_KEY = "profile_cache_key";
    private Anti anti_stat;
    public TbBookrack bookrack;
    private List<ForumDynamic> concernedForumList;
    private List<DynamicInfo> dynamicInfoList;
    private boolean error_hint;
    private Feedback feedback;
    private boolean from_db;
    private Highlist highlist;
    private boolean isSelf;
    private AlaLiveInfoCoreData liveInfoData;
    private ModuleInfo moduleInfo;
    private NicknameInfo nicknameInfo;
    private int pageNum;
    private List<PostInfoList> post_list;
    private TAInfo tainfo;
    public l ucCardData;
    private User user;
    private UserAgreeInfo userAgreeInfo;
    private UserGodInfo userGodInfo;
    private UserManChannelInfo userManChannelInfo;
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

    public l getUcCardData() {
        return this.ucCardData;
    }

    @Override // com.baidu.tieba.person.f
    public TbBookrack getBookrackData() {
        return this.bookrack;
    }

    @Override // com.baidu.tieba.person.f
    public UserGodInfo getUserGodInfo() {
        return this.userGodInfo;
    }

    @Override // com.baidu.tieba.person.f
    public UserManChannelInfo getUserChannelInfo() {
        return this.userManChannelInfo;
    }

    public boolean isError() {
        return hasError();
    }

    public String getErrorMsg() {
        return getErrorString();
    }

    @Override // com.baidu.tieba.person.f
    public User GetUser() {
        return this.user;
    }

    public Anti GetAntiStat() {
        return this.anti_stat;
    }

    @Override // com.baidu.tieba.person.f
    public TAInfo getTaInfo() {
        return this.tainfo;
    }

    @Override // com.baidu.tieba.person.f
    public UserAgreeInfo getUserAgreeInfo() {
        return this.userAgreeInfo;
    }

    @Override // com.baidu.tieba.person.f
    public NicknameInfo getNicknameInfo() {
        return this.nicknameInfo;
    }

    @Override // com.baidu.tieba.person.f
    public List<PostInfoList> GetPostList() {
        return this.post_list;
    }

    public boolean isSelf() {
        return this.isSelf;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.a
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
                this.ucCardData = new l();
                this.ucCardData.a(profileResIdl.data.uc_card);
            }
            this.bookrack = profileResIdl.data.tbbookrack;
            this.highlist = profileResIdl.data.highs;
            this.window = profileResIdl.data.window;
            this.feedback = profileResIdl.data.feedback;
            this.concernedForumList = profileResIdl.data.concerned_forum_list;
            this.dynamicInfoList = profileResIdl.data.dynamic_list;
            this.moduleInfo = profileResIdl.data.module_info;
            if (profileResIdl.data.ala_live_info != null) {
                this.liveInfoData = new AlaLiveInfoCoreData();
                this.liveInfoData.parserProtoBuf(profileResIdl.data.ala_live_info);
            }
            this.userAgreeInfo = profileResIdl.data.user_agree_info;
            this.nicknameInfo = profileResIdl.data.nickname_info;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        com.baidu.adp.lib.cache.l<byte[]> N = com.baidu.tbadk.core.c.a.tk().N("tb_user_profile", TbadkCoreApplication.getCurrentAccountName());
        if (bArr != null && this.isSelf) {
            N.e(PROFILE_CACHE_KEY, bArr);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void beforeDispatchInBackGround(int i, byte[] bArr) {
        com.baidu.adp.lib.cache.l<String> O;
        super.beforeDispatchInBackGround(i, (int) bArr);
        if (this.ucCardData != null && (O = com.baidu.tbadk.core.c.a.tk().O("tb.person_wallet_new", TbadkCoreApplication.getCurrentAccount())) != null && this.isSelf) {
            List<l.a> list = this.ucCardData.ffk;
            if (v.u(list) > 4) {
                list.get(4).timeStamp = 8L;
                for (l.a aVar : list) {
                    if (aVar.timeStamp > com.baidu.adp.lib.g.b.c(O.get(aVar.title), 0L)) {
                        aVar.ffl = true;
                    } else {
                        aVar.ffl = false;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.person.f
    public int getErrorCode() {
        return getError();
    }

    public Feedback getFeedBack() {
        return this.feedback;
    }

    @Override // com.baidu.tieba.person.f
    public List<ForumDynamic> getConcernedForumList() {
        return this.concernedForumList;
    }

    @Override // com.baidu.tieba.person.f
    public List<DynamicInfo> getDynamicInfoList() {
        return this.dynamicInfoList;
    }

    @Override // com.baidu.tieba.person.f
    public ModuleInfo getModuleInfo() {
        return this.moduleInfo;
    }

    @Override // com.baidu.tieba.person.f
    public AlaLiveInfoCoreData getLiveInfo() {
        return this.liveInfoData;
    }
}
