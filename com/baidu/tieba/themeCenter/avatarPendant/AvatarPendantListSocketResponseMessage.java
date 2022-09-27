package com.baidu.tieba.themeCenter.avatarPendant;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.qs8;
import com.baidu.tieba.st8;
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
/* loaded from: classes6.dex */
public class AvatarPendantListSocketResponseMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<qs8> mAvatarPendantList;
    public st8 mRecommand;

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

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            GetPendantByCategoryResIdl getPendantByCategoryResIdl = (GetPendantByCategoryResIdl) new Wire(new Class[0]).parseFrom(bArr, GetPendantByCategoryResIdl.class);
            if (getPendantByCategoryResIdl == null) {
                return null;
            }
            Error error = getPendantByCategoryResIdl.error;
            if (error != null) {
                setError(error.errorno.intValue());
                setErrorString(getPendantByCategoryResIdl.error.usermsg);
            }
            DataRes dataRes = getPendantByCategoryResIdl.data;
            if (dataRes == null) {
                return getPendantByCategoryResIdl;
            }
            if (dataRes.recommend != null) {
                st8 st8Var = new st8();
                this.mRecommand = st8Var;
                st8Var.d(getPendantByCategoryResIdl.data.recommend);
            }
            if (getPendantByCategoryResIdl.data.pendant != null) {
                this.mAvatarPendantList = new ArrayList();
                for (ThemePendantInMain themePendantInMain : getPendantByCategoryResIdl.data.pendant) {
                    if (themePendantInMain != null && !StringUtils.isNull(themePendantInMain.pendant_category)) {
                        qs8 qs8Var = new qs8();
                        qs8Var.c(themePendantInMain);
                        this.mAvatarPendantList.add(qs8Var);
                    }
                }
            }
            return getPendantByCategoryResIdl;
        }
        return invokeIL.objValue;
    }

    public List<qs8> getAvatarPendantListList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mAvatarPendantList : (List) invokeV.objValue;
    }

    public st8 getRecommand() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mRecommand : (st8) invokeV.objValue;
    }
}
