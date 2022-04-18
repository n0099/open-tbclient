package com.baidu.tieba.themeCenter.avatarPendant;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.kq8;
import com.repackage.mr8;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.GetPendantByCategory.DataRes;
import tbclient.GetPendantByCategory.GetPendantByCategoryResIdl;
import tbclient.GetPendantByCategory.ThemePendantInMain;
/* loaded from: classes4.dex */
public class AvatarPendantListSocketResponseMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<kq8> mAvatarPendantList;
    public mr8 mRecommand;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AvatarPendantListSocketResponseMessage() {
        super(309371);
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

    public List<kq8> getAvatarPendantListList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mAvatarPendantList : (List) invokeV.objValue;
    }

    public mr8 getRecommand() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mRecommand : (mr8) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetPendantByCategoryResIdl getPendantByCategoryResIdl;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) || (getPendantByCategoryResIdl = (GetPendantByCategoryResIdl) new Wire(new Class[0]).parseFrom(bArr, GetPendantByCategoryResIdl.class)) == null) {
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
            mr8 mr8Var = new mr8();
            this.mRecommand = mr8Var;
            mr8Var.d(getPendantByCategoryResIdl.data.recommend);
        }
        if (getPendantByCategoryResIdl.data.pendant != null) {
            this.mAvatarPendantList = new ArrayList();
            for (ThemePendantInMain themePendantInMain : getPendantByCategoryResIdl.data.pendant) {
                if (themePendantInMain != null && !StringUtils.isNull(themePendantInMain.pendant_category)) {
                    kq8 kq8Var = new kq8();
                    kq8Var.c(themePendantInMain);
                    this.mAvatarPendantList.add(kq8Var);
                }
            }
        }
    }
}
