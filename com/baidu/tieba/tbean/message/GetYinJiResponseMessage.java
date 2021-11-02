package com.baidu.tieba.tbean.message;

import b.a.r0.n3.f.a;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.util.List;
import tbclient.GetIconList.Custom;
import tbclient.GetIconList.DataRes;
import tbclient.GetIconList.GetIconListResIdl;
import tbclient.GetIconList.IconInfo;
import tbclient.GetIconList.Setting;
import tbclient.GetIconList.UserInfo;
/* loaded from: classes9.dex */
public class GetYinJiResponseMessage extends SocketResponsedMessage implements a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<Custom> customList;
    public List<IconInfo> iconInfoList;
    public Setting setting;
    public UserInfo userInfo;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetYinJiResponseMessage() {
        super(306001);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
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

    @Override // b.a.r0.n3.f.a
    public List<Custom> getCustomList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.customList : (List) invokeV.objValue;
    }

    @Override // b.a.r0.n3.f.a
    public List<IconInfo> getIconInfoList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.iconInfoList : (List) invokeV.objValue;
    }

    @Override // b.a.r0.n3.f.a
    public Setting getSetting() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.setting : (Setting) invokeV.objValue;
    }

    @Override // b.a.r0.n3.f.a
    public UserInfo getUserInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.userInfo : (UserInfo) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bArr) == null) {
            GetIconListResIdl getIconListResIdl = (GetIconListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetIconListResIdl.class);
            setError(getIconListResIdl.error.errorno.intValue());
            setErrorString(getIconListResIdl.error.usermsg);
            if (getError() != 0) {
                return;
            }
            DataRes dataRes = getIconListResIdl.data;
            this.userInfo = dataRes.user_info;
            this.iconInfoList = dataRes.icon_info;
            this.customList = dataRes.custom;
            this.setting = dataRes.setting;
        }
    }
}
