package com.baidu.tieba.themeCenter.background;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.uoa;
import com.baidu.tieba.xna;
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
/* loaded from: classes8.dex */
public class BackgroundGroupSocketResponseMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<xna> mBackgroundGroupList;
    public uoa mRecommand;

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

    public List<xna> getGroupList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mBackgroundGroupList;
        }
        return (List) invokeV.objValue;
    }

    public uoa getRecommand() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mRecommand;
        }
        return (uoa) invokeV.objValue;
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
                    uoa uoaVar = new uoa();
                    this.mRecommand = uoaVar;
                    uoaVar.d(getBgByCategoryResIdl.data.recommend);
                }
                if (getBgByCategoryResIdl.data.bgs != null) {
                    this.mBackgroundGroupList = new ArrayList();
                    for (ThemeBgInMain themeBgInMain : getBgByCategoryResIdl.data.bgs) {
                        if (themeBgInMain != null && !StringUtils.isNull(themeBgInMain.bg_category)) {
                            xna xnaVar = new xna();
                            xnaVar.c(themeBgInMain);
                            this.mBackgroundGroupList.add(xnaVar);
                        }
                    }
                }
            }
            return getBgByCategoryResIdl;
        }
        return invokeIL.objValue;
    }
}
