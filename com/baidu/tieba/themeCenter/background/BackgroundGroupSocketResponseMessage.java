package com.baidu.tieba.themeCenter.background;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ny9;
import com.baidu.tieba.qx9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.GetBgByCategory.DataRes;
import tbclient.GetBgByCategory.GetBgByCategoryResIdl;
import tbclient.GetBgByCategory.ThemeBgInMain;
/* loaded from: classes7.dex */
public class BackgroundGroupSocketResponseMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<qx9> mBackgroundGroupList;
    public ny9 mRecommand;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackgroundGroupSocketResponseMessage() {
        super(309020);
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

    public List<qx9> getGroupList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mBackgroundGroupList;
        }
        return (List) invokeV.objValue;
    }

    public ny9 getRecommand() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mRecommand;
        }
        return (ny9) invokeV.objValue;
    }

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            GetBgByCategoryResIdl getBgByCategoryResIdl = (GetBgByCategoryResIdl) new Wire(new Class[0]).parseFrom(bArr, GetBgByCategoryResIdl.class);
            if (getBgByCategoryResIdl == null) {
                return null;
            }
            Error error = getBgByCategoryResIdl.error;
            if (error != null) {
                setError(error.errorno.intValue());
                setErrorString(getBgByCategoryResIdl.error.usermsg);
            }
            DataRes dataRes = getBgByCategoryResIdl.data;
            if (dataRes != null) {
                if (dataRes.recommend != null) {
                    ny9 ny9Var = new ny9();
                    this.mRecommand = ny9Var;
                    ny9Var.d(getBgByCategoryResIdl.data.recommend);
                }
                if (getBgByCategoryResIdl.data.bgs != null) {
                    this.mBackgroundGroupList = new ArrayList();
                    for (ThemeBgInMain themeBgInMain : getBgByCategoryResIdl.data.bgs) {
                        if (themeBgInMain != null && !StringUtils.isNull(themeBgInMain.bg_category)) {
                            qx9 qx9Var = new qx9();
                            qx9Var.c(themeBgInMain);
                            this.mBackgroundGroupList.add(qx9Var);
                        }
                    }
                }
            }
            return getBgByCategoryResIdl;
        }
        return invokeIL.objValue;
    }
}
