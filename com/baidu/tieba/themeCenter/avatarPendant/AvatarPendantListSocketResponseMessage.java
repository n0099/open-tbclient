package com.baidu.tieba.themeCenter.avatarPendant;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.d4a;
import com.baidu.tieba.f5a;
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
    public List<d4a> mAvatarPendantList;
    public f5a mRecommand;

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

    public List<d4a> getAvatarPendantListList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mAvatarPendantList;
        }
        return (List) invokeV.objValue;
    }

    public f5a getRecommand() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mRecommand;
        }
        return (f5a) invokeV.objValue;
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
                f5a f5aVar = new f5a();
                this.mRecommand = f5aVar;
                f5aVar.d(getPendantByCategoryResIdl.data.recommend);
            }
            if (getPendantByCategoryResIdl.data.pendant != null) {
                this.mAvatarPendantList = new ArrayList();
                for (ThemePendantInMain themePendantInMain : getPendantByCategoryResIdl.data.pendant) {
                    if (themePendantInMain != null && !StringUtils.isNull(themePendantInMain.pendant_category)) {
                        d4a d4aVar = new d4a();
                        d4aVar.c(themePendantInMain);
                        this.mAvatarPendantList.add(d4aVar);
                    }
                }
            }
            return getPendantByCategoryResIdl;
        }
        return invokeIL.objValue;
    }
}
