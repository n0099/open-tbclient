package com.baidu.tieba.person;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.squareup.wire.Wire;
import d.b.c.e.d.l;
import d.b.h0.r.r.a;
import d.b.i0.f2.c;
import d.b.i0.f2.g;
import d.b.i0.w0.b;
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
import tbclient.HotUserRankEntry;
import tbclient.ModuleInfo;
import tbclient.PostInfoList;
import tbclient.Profile.DataRes;
import tbclient.Profile.NicknameInfo;
import tbclient.Profile.ProfileResIdl;
import tbclient.Profile.TAInfo;
import tbclient.Profile.UserAgreeInfo;
import tbclient.Profile.UserGodInfo;
import tbclient.SmartApp;
import tbclient.TbBookrack;
import tbclient.ThreadInfo;
import tbclient.User;
import tbclient.UserManChannelInfo;
/* loaded from: classes3.dex */
public class ProfileSocketResponseMessage extends SocketResponsedMessage implements c {
    public static final String PROFILE_CACHE_KEY = "profile_cache_key";
    public Anti anti_stat;
    public List<BannerImage> banner;
    public TbBookrack bookrack;
    public List<ForumDynamic> concernedForumList;
    public List<DynamicInfo> dynamicInfoList;
    public boolean error_hint;
    public Feedback feedBack;
    public boolean from_db;
    public Highlist highlist;
    public HotUserRankEntry hotUserRankEntry;
    public boolean isSelf;
    public AlaLiveInfoCoreData liveInfoData;
    public List<AlaLiveInfoCoreData> liveReplayData;
    public b mLiveGoodsWindowData;
    public int maskType;
    public ModuleInfo moduleInfo;
    public List<ThreadInfo> newest_dynamic_list;
    public NicknameInfo nicknameInfo;
    public int pageNum;
    public List<PostInfoList> post_list;
    public List<SmartApp> recomSwanList;
    public TAInfo taInfo;
    public TAInfo tainfo;
    public g ucCardData;
    public User user;
    public UserAgreeInfo userAgreeInfo;
    public UserGodInfo userGodInfo;
    public UserManChannelInfo userManChannelInfo;
    public DealWindow window;

    public ProfileSocketResponseMessage() {
        super(303012);
    }

    @Override // d.b.i0.f2.c
    public Anti GetAntiStat() {
        return this.anti_stat;
    }

    @Override // d.b.i0.f2.c
    public List<PostInfoList> GetPostList() {
        return this.post_list;
    }

    public TAInfo GetTainfo() {
        return this.tainfo;
    }

    @Override // d.b.i0.f2.c
    public User GetUser() {
        return this.user;
    }

    public List<BannerImage> getBannerList() {
        return this.banner;
    }

    @Override // d.b.i0.f2.c
    public TbBookrack getBookrackData() {
        return this.bookrack;
    }

    @Override // d.b.i0.f2.c
    public List<ForumDynamic> getConcernedForumList() {
        return this.concernedForumList;
    }

    @Override // d.b.i0.f2.c
    public List<DynamicInfo> getDynamicInfoList() {
        return this.dynamicInfoList;
    }

    @Override // d.b.i0.f2.c
    public int getErrorCode() {
        return getError();
    }

    public String getErrorMsg() {
        return getErrorString();
    }

    public Feedback getFeedBack() {
        return this.feedBack;
    }

    @Override // d.b.i0.f2.c
    public b getGoodsWindowInfo() {
        return this.mLiveGoodsWindowData;
    }

    public Highlist getHighlist() {
        return this.highlist;
    }

    @Override // d.b.i0.f2.c
    public HotUserRankEntry getHotRankEntry() {
        return this.hotUserRankEntry;
    }

    @Override // d.b.i0.f2.c
    public AlaLiveInfoCoreData getLiveInfo() {
        return this.liveInfoData;
    }

    @Override // d.b.i0.f2.c
    public List<AlaLiveInfoCoreData> getLiveReplayInfo() {
        return this.liveReplayData;
    }

    @Override // d.b.i0.f2.c
    public int getMaskType() {
        return this.maskType;
    }

    public ModuleInfo getModuleInfo() {
        return this.moduleInfo;
    }

    @Override // d.b.i0.f2.c
    public List<ThreadInfo> getNewestThreadList() {
        return this.newest_dynamic_list;
    }

    @Override // d.b.i0.f2.c
    public NicknameInfo getNicknameInfo() {
        return this.nicknameInfo;
    }

    public int getPageNum() {
        return this.pageNum;
    }

    public List<SmartApp> getRecomSwanList() {
        return this.recomSwanList;
    }

    @Override // d.b.i0.f2.c
    public TAInfo getTaInfo() {
        return this.tainfo;
    }

    public g getUcCardData() {
        return this.ucCardData;
    }

    @Override // d.b.i0.f2.c
    public UserAgreeInfo getUserAgreeInfo() {
        return this.userAgreeInfo;
    }

    public UserManChannelInfo getUserChannelInfo() {
        return this.userManChannelInfo;
    }

    @Override // d.b.i0.f2.c
    public UserGodInfo getUserGodInfo() {
        return this.userGodInfo;
    }

    public boolean isError() {
        return hasError();
    }

    public boolean isError_hint() {
        return this.error_hint;
    }

    public boolean isFrom_db() {
        return this.from_db;
    }

    public boolean isSelf() {
        return this.isSelf;
    }

    public void setHighlist(Highlist highlist) {
        this.highlist = highlist;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        l<byte[]> e2 = a.f().e("tb_user_profile", TbadkCoreApplication.getCurrentAccountName());
        if (bArr == null || !this.isSelf) {
            return;
        }
        e2.g("profile_cache_key", bArr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void beforeDispatchInBackGround(int i, byte[] bArr) {
        l<String> h2;
        super.beforeDispatchInBackGround(i, (int) bArr);
        if (this.ucCardData == null || (h2 = a.f().h("tb.person_wallet_new", TbadkCoreApplication.getCurrentAccount())) == null || !this.isSelf) {
            return;
        }
        List<g.a> list = this.ucCardData.f55978a;
        if (ListUtils.getCount(list) > 4) {
            list.get(4).f55980b = 8L;
            for (g.a aVar : list) {
                if (aVar.f55980b > d.b.c.e.m.b.f(h2.get(aVar.f55979a), 0L)) {
                    aVar.f55981c = true;
                } else {
                    aVar.f55981c = false;
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        DataRes dataRes;
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
        if (getError() != 0) {
            return;
        }
        d.b.i0.f2.b personCenterData = profileRequestMessage.getPersonCenterData();
        if (personCenterData != null) {
            personCenterData.b(profileResIdl);
        }
        if (profileResIdl == null || (dataRes = profileResIdl.data) == null) {
            return;
        }
        this.userGodInfo = dataRes.user_god_info;
        this.userManChannelInfo = dataRes.video_channel_info;
        this.user = dataRes.user;
        this.anti_stat = dataRes.anti_stat;
        this.tainfo = dataRes.tainfo;
        this.post_list = dataRes.post_list;
        if (dataRes.uc_card != null) {
            g gVar = new g();
            this.ucCardData = gVar;
            gVar.a(profileResIdl.data.uc_card);
        }
        DataRes dataRes2 = profileResIdl.data;
        this.bookrack = dataRes2.tbbookrack;
        this.highlist = dataRes2.highs;
        this.window = dataRes2.window;
        this.feedBack = dataRes2.feedback;
        this.concernedForumList = dataRes2.concerned_forum_list;
        this.dynamicInfoList = dataRes2.dynamic_list;
        this.taInfo = dataRes2.tainfo;
        this.moduleInfo = dataRes2.module_info;
        if (dataRes2.ala_live_info != null) {
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            this.liveInfoData = alaLiveInfoCoreData;
            alaLiveInfoCoreData.parserProtoBuf(profileResIdl.data.ala_live_info);
        }
        if (profileResIdl.data.goods_win != null) {
            b bVar = new b();
            this.mLiveGoodsWindowData = bVar;
            bVar.b(profileResIdl.data.goods_win);
        }
        if (!ListUtils.isEmpty(profileResIdl.data.ala_live_record)) {
            this.liveReplayData = new ArrayList();
            for (AlaLiveInfo alaLiveInfo : profileResIdl.data.ala_live_record) {
                AlaLiveInfoCoreData alaLiveInfoCoreData2 = new AlaLiveInfoCoreData();
                alaLiveInfoCoreData2.parserProtoBuf(alaLiveInfo);
                this.liveReplayData.add(alaLiveInfoCoreData2);
            }
        }
        DataRes dataRes3 = profileResIdl.data;
        this.userAgreeInfo = dataRes3.user_agree_info;
        this.nicknameInfo = dataRes3.nickname_info;
        this.banner = dataRes3.banner;
        this.recomSwanList = dataRes3.recom_swan_list;
        this.newest_dynamic_list = dataRes3.newest_dynamic_list;
        this.hotUserRankEntry = dataRes3.new_god_rankinfo;
        User user = this.user;
        if (user == null || user.new_god_data == null || user.call_fans_info == null) {
            return;
        }
        TbSingleton.getInstance().mShowCallFans = this.user.new_god_data.status.intValue() == 3;
        TbSingleton.getInstance().mCanCallFans = this.user.call_fans_info.can_call.intValue() == 1;
        TbSingleton.getInstance().mCallFansTid = String.valueOf(this.user.call_fans_info.thread_id);
    }
}
