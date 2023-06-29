package com.baidu.tieba.themeCenter.avatarPendant;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.gaa;
import com.baidu.tieba.iba;
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
/* loaded from: classes7.dex */
public class AvatarPendantListSocketResponseMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<gaa> mAvatarPendantList;
    public iba mRecommand;

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

    public List<gaa> getAvatarPendantListList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mAvatarPendantList;
        }
        return (List) invokeV.objValue;
    }

    public iba getRecommand() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mRecommand;
        }
        return (iba) invokeV.objValue;
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
                iba ibaVar = new iba();
                this.mRecommand = ibaVar;
                ibaVar.d(getPendantByCategoryResIdl.data.recommend);
            }
            if (getPendantByCategoryResIdl.data.pendant != null) {
                this.mAvatarPendantList = new ArrayList();
                for (ThemePendantInMain themePendantInMain : getPendantByCategoryResIdl.data.pendant) {
                    if (themePendantInMain != null && !StringUtils.isNull(themePendantInMain.pendant_category)) {
                        gaa gaaVar = new gaa();
                        gaaVar.c(themePendantInMain);
                        this.mAvatarPendantList.add(gaaVar);
                    }
                }
            }
            return getPendantByCategoryResIdl;
        }
        return invokeIL.objValue;
    }
}
