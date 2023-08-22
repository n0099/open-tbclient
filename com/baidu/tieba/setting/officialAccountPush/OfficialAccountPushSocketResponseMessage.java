package com.baidu.tieba.setting.officialAccountPush;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import tbclient.Error;
import tbclient.GetOfficialSwitch.DataRes;
import tbclient.GetOfficialSwitch.GetOfficialSwitchResIdl;
/* loaded from: classes8.dex */
public class OfficialAccountPushSocketResponseMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<OfficialAccountPushInfo> official_list;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfficialAccountPushSocketResponseMessage() {
        super(309620);
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

    public ArrayList<OfficialAccountPushInfo> getList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.official_list;
        }
        return (ArrayList) invokeV.objValue;
    }

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        String str;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            if (bArr == null) {
                return null;
            }
            GetOfficialSwitchResIdl getOfficialSwitchResIdl = (GetOfficialSwitchResIdl) new Wire(new Class[0]).parseFrom(bArr, GetOfficialSwitchResIdl.class);
            if (getOfficialSwitchResIdl == null) {
                return null;
            }
            Error error = getOfficialSwitchResIdl.error;
            if (error != null && (num = error.errorno) != null) {
                setError(num.intValue());
            }
            Error error2 = getOfficialSwitchResIdl.error;
            if (error2 != null && (str = error2.usermsg) != null && str.length() > 0) {
                setErrorString(getOfficialSwitchResIdl.error.usermsg);
            }
            DataRes dataRes = getOfficialSwitchResIdl.data;
            if (dataRes != null && dataRes.official_list != null) {
                this.official_list = new ArrayList<>();
                for (int i2 = 0; i2 < getOfficialSwitchResIdl.data.official_list.size(); i2++) {
                    OfficialAccountPushInfo officialAccountPushInfo = new OfficialAccountPushInfo();
                    officialAccountPushInfo.parser(getOfficialSwitchResIdl.data.official_list.get(i2));
                    this.official_list.add(officialAccountPushInfo);
                }
            }
            return getOfficialSwitchResIdl;
        }
        return invokeIL.objValue;
    }
}
