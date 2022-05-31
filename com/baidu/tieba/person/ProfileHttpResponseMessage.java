package com.baidu.tieba.person;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.cq4;
import com.repackage.cy7;
import com.repackage.dy7;
import com.repackage.hy7;
import com.repackage.jg;
import com.repackage.mq6;
import com.repackage.qe;
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
import tbclient.HotUserRankEntry;
import tbclient.ModuleInfo;
import tbclient.PostInfoList;
import tbclient.Profile.DataRes;
import tbclient.Profile.MemberBlockInfo;
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
public class ProfileHttpResponseMessage extends TbHttpResponsedMessage implements dy7 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PROFILE_CACHE_KEY = "profile_cache_key";
    public transient /* synthetic */ FieldHolder $fh;
    public Anti anti_stat;
    public List<BannerImage> banner;
    public TbBookrack bookrack;
    public List<ForumDynamic> concernedForumList;
    public List<DynamicInfo> dynamicInfoList;
    public boolean error_hint;
    public Feedback feedback;
    public boolean from_db;
    public Highlist highlist;
    public HotUserRankEntry hotUserRankEntry;
    public boolean isSelf;
    public AlaLiveInfoCoreData liveInfoData;
    public List<AlaLiveInfoCoreData> liveReplayData;
    public mq6 mLiveGoodsWindowData;
    public int maskType;
    public MemberBlockInfo memberBlockInfo;
    public ModuleInfo moduleInfo;
    public List<ThreadInfo> newest_dynamic_list;
    public NicknameInfo nicknameInfo;
    public int pageNum;
    public List<PostInfoList> post_list;
    public List<SmartApp> recomSwanList;
    public TAInfo tainfo;
    public hy7 ucCardData;
    public User user;
    public UserAgreeInfo userAgreeInfo;
    public UserGodInfo userGodInfo;
    public UserManChannelInfo userManChannelInfo;
    public DealWindow window;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileHttpResponseMessage(int i) {
        super(i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.dy7
    public Anti GetAntiStat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.anti_stat : (Anti) invokeV.objValue;
    }

    @Override // com.repackage.dy7
    public List<PostInfoList> GetPostList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.post_list : (List) invokeV.objValue;
    }

    @Override // com.repackage.dy7
    public User GetUser() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.user : (User) invokeV.objValue;
    }

    public List<BannerImage> getBannerList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.banner : (List) invokeV.objValue;
    }

    @Override // com.repackage.dy7
    public TbBookrack getBookrackData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.bookrack : (TbBookrack) invokeV.objValue;
    }

    @Override // com.repackage.dy7
    public List<ForumDynamic> getConcernedForumList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.concernedForumList : (List) invokeV.objValue;
    }

    @Override // com.repackage.dy7
    public List<DynamicInfo> getDynamicInfoList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.dynamicInfoList : (List) invokeV.objValue;
    }

    @Override // com.repackage.dy7
    public int getErrorCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? getError() : invokeV.intValue;
    }

    public String getErrorMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? getErrorString() : (String) invokeV.objValue;
    }

    public Feedback getFeedBack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.feedback : (Feedback) invokeV.objValue;
    }

    @Override // com.repackage.dy7
    public mq6 getGoodsWindowInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.mLiveGoodsWindowData : (mq6) invokeV.objValue;
    }

    public Highlist getHighlist() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.highlist : (Highlist) invokeV.objValue;
    }

    @Override // com.repackage.dy7
    public HotUserRankEntry getHotRankEntry() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.hotUserRankEntry : (HotUserRankEntry) invokeV.objValue;
    }

    @Override // com.repackage.dy7
    public AlaLiveInfoCoreData getLiveInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.liveInfoData : (AlaLiveInfoCoreData) invokeV.objValue;
    }

    @Override // com.repackage.dy7
    public List<AlaLiveInfoCoreData> getLiveReplayInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.liveReplayData : (List) invokeV.objValue;
    }

    @Override // com.repackage.dy7
    public int getMaskType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.maskType : invokeV.intValue;
    }

    public MemberBlockInfo getMemberBlockInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.memberBlockInfo : (MemberBlockInfo) invokeV.objValue;
    }

    public ModuleInfo getModuleInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.moduleInfo : (ModuleInfo) invokeV.objValue;
    }

    @Override // com.repackage.dy7
    public List<ThreadInfo> getNewestThreadList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.newest_dynamic_list : (List) invokeV.objValue;
    }

    @Override // com.repackage.dy7
    public NicknameInfo getNicknameInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.nicknameInfo : (NicknameInfo) invokeV.objValue;
    }

    public int getPageNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.pageNum : invokeV.intValue;
    }

    public List<SmartApp> getRecomSwanList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.recomSwanList : (List) invokeV.objValue;
    }

    @Override // com.repackage.dy7
    public TAInfo getTaInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.tainfo : (TAInfo) invokeV.objValue;
    }

    public hy7 getUcCardData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.ucCardData : (hy7) invokeV.objValue;
    }

    @Override // com.repackage.dy7
    public UserAgreeInfo getUserAgreeInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.userAgreeInfo : (UserAgreeInfo) invokeV.objValue;
    }

    public UserManChannelInfo getUserChannelInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.userManChannelInfo : (UserManChannelInfo) invokeV.objValue;
    }

    @Override // com.repackage.dy7
    public UserGodInfo getUserGodInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.userGodInfo : (UserGodInfo) invokeV.objValue;
    }

    public boolean isError() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? hasError() : invokeV.booleanValue;
    }

    public boolean isError_hint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.error_hint : invokeV.booleanValue;
    }

    public boolean isFrom_db() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.from_db : invokeV.booleanValue;
    }

    public boolean isSelf() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.isSelf : invokeV.booleanValue;
    }

    public void setHighlist(Highlist highlist) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, highlist) == null) {
            this.highlist = highlist;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i, bArr) == null) {
            cq4.f();
            qe<byte[]> e = cq4.e("tb_user_profile", TbadkCoreApplication.getCurrentAccountName());
            if (bArr == null || !this.isSelf) {
                return;
            }
            e.g("profile_cache_key", bArr);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void beforeDispatchInBackGround(int i, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048582, this, i, bArr) == null) {
            super.beforeDispatchInBackGround(i, (int) bArr);
            if (this.ucCardData != null) {
                cq4.f();
                qe<String> h = cq4.h("tb.person_wallet_new", TbadkCoreApplication.getCurrentAccount());
                if (h == null || !this.isSelf) {
                    return;
                }
                List<hy7.a> list = this.ucCardData.a;
                if (ListUtils.getCount(list) > 4) {
                    list.get(4).b = 8L;
                    for (hy7.a aVar : list) {
                        if (aVar.b > jg.g(h.get(aVar.a), 0L)) {
                            aVar.c = true;
                        } else {
                            aVar.c = false;
                        }
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        DataRes dataRes;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, bArr) == null) {
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
            cy7 personCenterData = profileRequestMessage.getPersonCenterData();
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
                hy7 hy7Var = new hy7();
                this.ucCardData = hy7Var;
                hy7Var.a(profileResIdl.data.uc_card);
            }
            DataRes dataRes2 = profileResIdl.data;
            this.bookrack = dataRes2.tbbookrack;
            this.highlist = dataRes2.highs;
            this.window = dataRes2.window;
            this.feedback = dataRes2.feedback;
            this.concernedForumList = dataRes2.concerned_forum_list;
            this.dynamicInfoList = dataRes2.dynamic_list;
            this.moduleInfo = dataRes2.module_info;
            if (dataRes2.ala_live_info != null) {
                AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                this.liveInfoData = alaLiveInfoCoreData;
                alaLiveInfoCoreData.parserProtoBuf(profileResIdl.data.ala_live_info);
            }
            if (profileResIdl.data.goods_win != null) {
                mq6 mq6Var = new mq6();
                this.mLiveGoodsWindowData = mq6Var;
                mq6Var.b(profileResIdl.data.goods_win);
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
            this.memberBlockInfo = dataRes3.block_info;
            User user = this.user;
            if (user == null || user.new_god_data == null || user.call_fans_info == null) {
                return;
            }
            TbSingleton.getInstance().mShowCallFans = this.user.new_god_data.status.intValue() == 3;
            TbSingleton.getInstance().mCanCallFans = this.user.call_fans_info.can_call.intValue() == 1;
            TbSingleton.getInstance().mCallFansTid = String.valueOf(this.user.call_fans_info.thread_id);
        }
    }
}
