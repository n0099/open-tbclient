package com.baidu.tieba.person;

import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.co9;
import com.baidu.tieba.iz7;
import com.baidu.tieba.o55;
import com.baidu.tieba.re8;
import com.baidu.tieba.wg;
import com.baidu.tieba.xn9;
import com.baidu.tieba.ye;
import com.baidu.tieba.yn9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes7.dex */
public class ProfileSocketResponseMessage extends SocketResponsedMessage implements yn9 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PROFILE_CACHE_KEY = "profile_cache_key";
    public transient /* synthetic */ FieldHolder $fh;
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
    public iz7 mLiveGoodsWindowData;
    public int maskType;
    public MemberBlockInfo memberBlockInfo;
    public ModuleInfo moduleInfo;
    public List<ThreadInfo> newest_dynamic_list;
    public NicknameInfo nicknameInfo;
    public int pageNum;
    public List<PostInfoList> post_list;
    public List<SmartApp> recomSwanList;
    public TAInfo tainfo;
    public co9 ucCardData;
    public User user;
    public UserAgreeInfo userAgreeInfo;
    public UserGodInfo userGodInfo;
    public UserManChannelInfo userManChannelInfo;
    public DealWindow window;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileSocketResponseMessage() {
        super(303012);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.yn9
    public Anti GetAntiStat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.anti_stat;
        }
        return (Anti) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yn9
    public List<PostInfoList> GetPostList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.post_list;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yn9
    public User GetUser() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.user;
        }
        return (User) invokeV.objValue;
    }

    public List<BannerImage> getBannerList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.banner;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yn9
    public TbBookrack getBookrackData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.bookrack;
        }
        return (TbBookrack) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yn9
    public List<ForumDynamic> getConcernedForumList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.concernedForumList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yn9
    public List<DynamicInfo> getDynamicInfoList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.dynamicInfoList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yn9
    public int getErrorCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return getError();
        }
        return invokeV.intValue;
    }

    public String getErrorMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return getErrorString();
        }
        return (String) invokeV.objValue;
    }

    public Feedback getFeedBack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.feedBack;
        }
        return (Feedback) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yn9
    public iz7 getGoodsWindowInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.mLiveGoodsWindowData;
        }
        return (iz7) invokeV.objValue;
    }

    public Highlist getHighlist() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.highlist;
        }
        return (Highlist) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yn9
    public HotUserRankEntry getHotRankEntry() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.hotUserRankEntry;
        }
        return (HotUserRankEntry) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yn9
    public AlaLiveInfoCoreData getLiveInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.liveInfoData;
        }
        return (AlaLiveInfoCoreData) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yn9
    public List<AlaLiveInfoCoreData> getLiveReplayInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.liveReplayData;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yn9
    public int getMaskType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.maskType;
        }
        return invokeV.intValue;
    }

    public MemberBlockInfo getMemberBlockInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.memberBlockInfo;
        }
        return (MemberBlockInfo) invokeV.objValue;
    }

    public ModuleInfo getModuleInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.moduleInfo;
        }
        return (ModuleInfo) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yn9
    public List<ThreadInfo> getNewestThreadList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.newest_dynamic_list;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yn9
    public NicknameInfo getNicknameInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.nicknameInfo;
        }
        return (NicknameInfo) invokeV.objValue;
    }

    public int getPageNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.pageNum;
        }
        return invokeV.intValue;
    }

    public List<SmartApp> getRecomSwanList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.recomSwanList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yn9
    public TAInfo getTaInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.tainfo;
        }
        return (TAInfo) invokeV.objValue;
    }

    public co9 getUcCardData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.ucCardData;
        }
        return (co9) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yn9
    public UserAgreeInfo getUserAgreeInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.userAgreeInfo;
        }
        return (UserAgreeInfo) invokeV.objValue;
    }

    public UserManChannelInfo getUserChannelInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.userManChannelInfo;
        }
        return (UserManChannelInfo) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yn9
    public UserGodInfo getUserGodInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.userGodInfo;
        }
        return (UserGodInfo) invokeV.objValue;
    }

    public boolean isError() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return hasError();
        }
        return invokeV.booleanValue;
    }

    public boolean isError_hint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return this.error_hint;
        }
        return invokeV.booleanValue;
    }

    public boolean isFrom_db() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.from_db;
        }
        return invokeV.booleanValue;
    }

    public boolean isSelf() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return this.isSelf;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i, bArr) == null) {
            o55.e();
            ye<byte[]> d = o55.d("tb_user_profile", TbadkCoreApplication.getCurrentAccountName());
            if (bArr != null && this.isSelf) {
                d.g("profile_cache_key", bArr);
            }
            re8.b(this.isSelf, this.anti_stat);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void beforeDispatchInBackGround(int i, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048582, this, i, bArr) == null) {
            super.beforeDispatchInBackGround(i, (int) bArr);
            if (this.ucCardData != null) {
                o55.e();
                ye<String> g = o55.g("tb.person_wallet_new", TbadkCoreApplication.getCurrentAccount());
                if (g != null && this.isSelf) {
                    List<co9.a> list = this.ucCardData.a;
                    if (ListUtils.getCount(list) > 4) {
                        list.get(4).b = 8L;
                        for (co9.a aVar : list) {
                            if (aVar.b > wg.g(g.get(aVar.a), 0L)) {
                                aVar.c = true;
                            } else {
                                aVar.c = false;
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        DataRes dataRes;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048583, this, i, bArr)) == null) {
            ProfileRequestMessage profileRequestMessage = (ProfileRequestMessage) getOrginalMessage().getExtra();
            this.from_db = profileRequestMessage.is_from_db();
            this.error_hint = profileRequestMessage.is_error_hint();
            this.isSelf = profileRequestMessage.isSelf();
            if (profileRequestMessage.get_pn() != null) {
                this.pageNum = profileRequestMessage.get_pn().intValue();
            }
            boolean z2 = false;
            ProfileResIdl profileResIdl = (ProfileResIdl) new Wire(new Class[0]).parseFrom(bArr, ProfileResIdl.class);
            if (profileResIdl != null) {
                setError(profileResIdl.error.errorno.intValue());
                setErrorString(profileResIdl.error.usermsg);
            }
            if (getError() != 0) {
                return profileResIdl;
            }
            xn9 personCenterData = profileRequestMessage.getPersonCenterData();
            if (personCenterData != null) {
                personCenterData.b(profileResIdl);
            }
            if (profileResIdl != null && (dataRes = profileResIdl.data) != null) {
                this.userGodInfo = dataRes.user_god_info;
                this.userManChannelInfo = dataRes.video_channel_info;
                this.user = dataRes.user;
                this.anti_stat = dataRes.anti_stat;
                this.tainfo = dataRes.tainfo;
                this.post_list = dataRes.post_list;
                if (dataRes.uc_card != null) {
                    co9 co9Var = new co9();
                    this.ucCardData = co9Var;
                    co9Var.a(profileResIdl.data.uc_card);
                }
                DataRes dataRes2 = profileResIdl.data;
                this.bookrack = dataRes2.tbbookrack;
                this.highlist = dataRes2.highs;
                this.window = dataRes2.window;
                this.feedBack = dataRes2.feedback;
                this.concernedForumList = dataRes2.concerned_forum_list;
                this.dynamicInfoList = dataRes2.dynamic_list;
                this.moduleInfo = dataRes2.module_info;
                if (dataRes2.ala_live_info != null) {
                    AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                    this.liveInfoData = alaLiveInfoCoreData;
                    alaLiveInfoCoreData.parserProtoBuf(profileResIdl.data.ala_live_info);
                }
                if (profileResIdl.data.goods_win != null) {
                    iz7 iz7Var = new iz7();
                    this.mLiveGoodsWindowData = iz7Var;
                    iz7Var.b(profileResIdl.data.goods_win);
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
                this.recomSwanList = dataRes3.recom_naws_list;
                this.newest_dynamic_list = dataRes3.newest_dynamic_list;
                this.hotUserRankEntry = dataRes3.new_god_rankinfo;
                this.memberBlockInfo = dataRes3.block_info;
                User user = this.user;
                if (user != null && user.new_god_data != null && user.call_fans_info != null) {
                    TbSingleton tbSingleton = TbSingleton.getInstance();
                    if (this.user.new_god_data.status.intValue() == 3) {
                        z = true;
                    } else {
                        z = false;
                    }
                    tbSingleton.mShowCallFans = z;
                    TbSingleton tbSingleton2 = TbSingleton.getInstance();
                    if (this.user.call_fans_info.can_call.intValue() == 1) {
                        z2 = true;
                    }
                    tbSingleton2.mCanCallFans = z2;
                    TbSingleton.getInstance().mCallFansTid = String.valueOf(this.user.call_fans_info.thread_id);
                }
            }
            return profileResIdl;
        }
        return invokeIL.objValue;
    }

    public void setHighlist(Highlist highlist) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, highlist) == null) {
            this.highlist = highlist;
        }
    }
}
