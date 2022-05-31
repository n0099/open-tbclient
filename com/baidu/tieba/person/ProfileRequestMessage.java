package com.baidu.tieba.person;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.switchs.SocketAddCommonParamSwitch;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.am4;
import com.repackage.cy7;
import com.repackage.dc5;
import com.repackage.li;
import tbclient.Profile.DataReq;
import tbclient.Profile.ProfileReqIdl;
/* loaded from: classes3.dex */
public class ProfileRequestMessage extends NetMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean error_hint;
    public Long friend_uid;
    public String friend_uid_portrait;
    public boolean from_db;
    public Integer has_plist;
    public boolean isSelf;
    public Integer is_from_usercenter;
    public Integer is_guest;
    public cy7 mPersonCenterData;
    public Integer need_post_count;
    public Integer page;
    public Integer pn;
    public Integer rn;
    public String st_type;
    public Long uid;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileRequestMessage() {
        super(CmdConfigHttp.PROFILE_HTTP_CMD, 303012);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                super(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
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
                int k = li.k(TbadkCoreApplication.getInst().getApp());
                int i = li.i(TbadkCoreApplication.getInst().getApp());
                int e = am4.c().e();
                builder.scr_w = Integer.valueOf(k);
                builder.scr_h = Integer.valueOf(i);
                builder.scr_dip = Double.valueOf(li.h(TbadkCoreApplication.getInst().getApp()));
                builder.q_type = Integer.valueOf(e);
                if (z || SocketAddCommonParamSwitch.getIsOn()) {
                    dc5.a(builder, true);
                }
                ProfileReqIdl.Builder builder2 = new ProfileReqIdl.Builder();
                builder2.data = builder.build(false);
                return builder2.build(false);
            } catch (Exception unused) {
                return null;
            }
        }
        return invokeZ.objValue;
    }

    public Integer getPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.page : (Integer) invokeV.objValue;
    }

    public cy7 getPersonCenterData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mPersonCenterData : (cy7) invokeV.objValue;
    }

    public Long get_friend_uid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.friend_uid : (Long) invokeV.objValue;
    }

    public String get_friend_uid_portrait() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.friend_uid_portrait : (String) invokeV.objValue;
    }

    public Integer get_has_plist() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.has_plist : (Integer) invokeV.objValue;
    }

    public Integer get_is_guest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.is_guest : (Integer) invokeV.objValue;
    }

    public Integer get_need_post_count() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.need_post_count : (Integer) invokeV.objValue;
    }

    public Integer get_pn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.pn : (Integer) invokeV.objValue;
    }

    public Integer get_rn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.rn : (Integer) invokeV.objValue;
    }

    public String get_st_type() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.st_type : (String) invokeV.objValue;
    }

    public Long get_uid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.uid : (Long) invokeV.objValue;
    }

    public boolean isSelf() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.isSelf : invokeV.booleanValue;
    }

    public boolean is_error_hint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.error_hint : invokeV.booleanValue;
    }

    public boolean is_from_db() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.from_db : invokeV.booleanValue;
    }

    public Integer is_from_usercenter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.is_from_usercenter : (Integer) invokeV.objValue;
    }

    public void setIs_from_usercenter(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, num) == null) {
            this.is_from_usercenter = num;
        }
    }

    public void setPage(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, num) == null) {
            this.page = num;
        }
    }

    public void setPersonCenterData(cy7 cy7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, cy7Var) == null) {
            this.mPersonCenterData = cy7Var;
        }
    }

    public void setSelf(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.isSelf = z;
        }
    }

    public void set_error_hint(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.error_hint = z;
        }
    }

    public void set_friend_uid(Long l) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, l) == null) {
            this.friend_uid = l;
        }
    }

    public void set_friend_uid_portrait(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.friend_uid_portrait = str;
        }
    }

    public void set_from_db(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.from_db = z;
        }
    }

    public void set_has_plist(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, num) == null) {
            this.has_plist = num;
        }
    }

    public void set_is_guest(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, num) == null) {
            this.is_guest = num;
        }
    }

    public void set_need_post_count(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, num) == null) {
            this.need_post_count = num;
        }
    }

    public void set_pn(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, num) == null) {
            this.pn = num;
        }
    }

    public void set_rn(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, num) == null) {
            this.rn = num;
        }
    }

    public void set_uid(Long l) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, l) == null) {
            this.uid = l;
        }
    }
}
