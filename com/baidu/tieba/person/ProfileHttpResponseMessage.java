package com.baidu.tieba.person;

import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tieba.person.g;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import tbclient.AlaLiveInfo;
import tbclient.Anti;
import tbclient.BannerImage;
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
public class ProfileHttpResponseMessage extends TbHttpResponsedMessage implements c {
    private static final String PROFILE_CACHE_KEY = "profile_cache_key";
    private Anti anti_stat;
    private List<BannerImage> banner;
    public TbBookrack bookrack;
    private List<ForumDynamic> concernedForumList;
    private List<DynamicInfo> dynamicInfoList;
    private boolean error_hint;
    private Feedback feedback;
    private boolean from_db;
    private Highlist highlist;
    private boolean isSelf;
    private AlaLiveInfoCoreData liveInfoData;
    private List<AlaLiveInfoCoreData> liveReplayData;
    private int maskType;
    private ModuleInfo moduleInfo;
    private NicknameInfo nicknameInfo;
    private int pageNum;
    private List<PostInfoList> post_list;
    private TAInfo tainfo;
    public g ucCardData;
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

    @Override // com.baidu.tieba.person.c
    public UserManChannelInfo getUserChannelInfo() {
        return this.userManChannelInfo;
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

    @Override // com.baidu.tieba.person.c
    public Anti GetAntiStat() {
        return this.anti_stat;
    }

    @Override // com.baidu.tieba.person.c
    public TAInfo getTaInfo() {
        return this.tainfo;
    }

    @Override // com.baidu.tieba.person.c
    public UserAgreeInfo getUserAgreeInfo() {
        return this.userAgreeInfo;
    }

    @Override // com.baidu.tieba.person.c
    public NicknameInfo getNicknameInfo() {
        return this.nicknameInfo;
    }

    @Override // com.baidu.tieba.person.c
    public List<PostInfoList> GetPostList() {
        return this.post_list;
    }

    @Override // com.baidu.tieba.person.c
    public int getMaskType() {
        return this.maskType;
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
            b personCenterData = profileRequestMessage.getPersonCenterData();
            if (personCenterData != null) {
                personCenterData.a(profileResIdl);
            }
            if (profileResIdl != null && profileResIdl.data != null) {
                this.userGodInfo = profileResIdl.data.user_god_info;
                this.userManChannelInfo = profileResIdl.data.video_channel_info;
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
                this.feedback = profileResIdl.data.feedback;
                this.concernedForumList = profileResIdl.data.concerned_forum_list;
                this.dynamicInfoList = profileResIdl.data.dynamic_list;
                this.moduleInfo = profileResIdl.data.module_info;
                if (profileResIdl.data.ala_live_info != null) {
                    this.liveInfoData = new AlaLiveInfoCoreData();
                    this.liveInfoData.parserProtoBuf(profileResIdl.data.ala_live_info);
                }
                if (!v.I(profileResIdl.data.ala_live_record)) {
                    this.liveReplayData = new ArrayList();
                    for (AlaLiveInfo alaLiveInfo : profileResIdl.data.ala_live_record) {
                        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                        alaLiveInfoCoreData.parserProtoBuf(alaLiveInfo);
                        this.liveReplayData.add(alaLiveInfoCoreData);
                    }
                }
                this.userAgreeInfo = profileResIdl.data.user_agree_info;
                this.nicknameInfo = profileResIdl.data.nickname_info;
                this.banner = profileResIdl.data.banner;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        l<byte[]> an = com.baidu.tbadk.core.c.a.BO().an("tb_user_profile", TbadkCoreApplication.getCurrentAccountName());
        if (bArr != null && this.isSelf) {
            an.e(PROFILE_CACHE_KEY, bArr);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void beforeDispatchInBackGround(int i, byte[] bArr) {
        l<String> ao;
        super.beforeDispatchInBackGround(i, (int) bArr);
        if (this.ucCardData != null && (ao = com.baidu.tbadk.core.c.a.BO().ao("tb.person_wallet_new", TbadkCoreApplication.getCurrentAccount())) != null && this.isSelf) {
            List<g.a> list = this.ucCardData.guf;
            if (v.H(list) > 4) {
                list.get(4).timeStamp = 8L;
                for (g.a aVar : list) {
                    if (aVar.timeStamp > com.baidu.adp.lib.g.b.d(ao.get(aVar.title), 0L)) {
                        aVar.gug = true;
                    } else {
                        aVar.gug = false;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.person.c
    public int getErrorCode() {
        return getError();
    }

    public Feedback getFeedBack() {
        return this.feedback;
    }

    @Override // com.baidu.tieba.person.c
    public List<ForumDynamic> getConcernedForumList() {
        return this.concernedForumList;
    }

    @Override // com.baidu.tieba.person.c
    public List<DynamicInfo> getDynamicInfoList() {
        return this.dynamicInfoList;
    }

    public ModuleInfo getModuleInfo() {
        return this.moduleInfo;
    }

    @Override // com.baidu.tieba.person.c
    public AlaLiveInfoCoreData getLiveInfo() {
        return this.liveInfoData;
    }

    @Override // com.baidu.tieba.person.c
    public List<AlaLiveInfoCoreData> getLiveReplayInfo() {
        return this.liveReplayData;
    }

    public List<BannerImage> getBannerList() {
        return this.banner;
    }
}
