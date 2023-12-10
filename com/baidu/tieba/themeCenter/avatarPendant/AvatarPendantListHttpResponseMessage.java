package com.baidu.tieba.themeCenter.avatarPendant;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tieba.h2b;
import com.baidu.tieba.j3b;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.GetPendantByCategory.DataRes;
import tbclient.GetPendantByCategory.GetPendantByCategoryResIdl;
import tbclient.GetPendantByCategory.ThemePendantInMain;
/* loaded from: classes8.dex */
public class AvatarPendantListHttpResponseMessage extends TbHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<h2b> mAvatarPendantList;
    public j3b mRecommand;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AvatarPendantListHttpResponseMessage(int i) {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetPendantByCategoryResIdl getPendantByCategoryResIdl;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) != null) || (getPendantByCategoryResIdl = (GetPendantByCategoryResIdl) new Wire(new Class[0]).parseFrom(bArr, GetPendantByCategoryResIdl.class)) == null) {
            return;
        }
        Error error = getPendantByCategoryResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(getPendantByCategoryResIdl.error.usermsg);
        }
        DataRes dataRes = getPendantByCategoryResIdl.data;
        if (dataRes == null) {
            return;
        }
        if (dataRes.recommend != null) {
            j3b j3bVar = new j3b();
            this.mRecommand = j3bVar;
            j3bVar.d(getPendantByCategoryResIdl.data.recommend);
        }
        if (getPendantByCategoryResIdl.data.pendant != null) {
            this.mAvatarPendantList = new ArrayList();
            for (ThemePendantInMain themePendantInMain : getPendantByCategoryResIdl.data.pendant) {
                if (themePendantInMain != null && !StringUtils.isNull(themePendantInMain.pendant_category)) {
                    h2b h2bVar = new h2b();
                    h2bVar.c(themePendantInMain);
                    this.mAvatarPendantList.add(h2bVar);
                }
            }
        }
    }

    public List<h2b> getAvatarPendantListList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mAvatarPendantList;
        }
        return (List) invokeV.objValue;
    }

    public j3b getRecommand() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mRecommand;
        }
        return (j3b) invokeV.objValue;
    }
}
