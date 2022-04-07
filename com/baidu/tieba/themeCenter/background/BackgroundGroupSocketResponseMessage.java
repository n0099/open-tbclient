package com.baidu.tieba.themeCenter.background;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.fr8;
import com.repackage.iq8;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.GetBgByCategory.DataRes;
import tbclient.GetBgByCategory.GetBgByCategoryResIdl;
import tbclient.GetBgByCategory.ThemeBgInMain;
/* loaded from: classes4.dex */
public class BackgroundGroupSocketResponseMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<iq8> mBackgroundGroupList;
    public fr8 mRecommand;

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

    public List<iq8> getGroupList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mBackgroundGroupList : (List) invokeV.objValue;
    }

    public fr8 getRecommand() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mRecommand : (fr8) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetBgByCategoryResIdl getBgByCategoryResIdl;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) || (getBgByCategoryResIdl = (GetBgByCategoryResIdl) new Wire(new Class[0]).parseFrom(bArr, GetBgByCategoryResIdl.class)) == null) {
            return;
        }
        Error error = getBgByCategoryResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(getBgByCategoryResIdl.error.usermsg);
        }
        DataRes dataRes = getBgByCategoryResIdl.data;
        if (dataRes != null) {
            if (dataRes.recommend != null) {
                fr8 fr8Var = new fr8();
                this.mRecommand = fr8Var;
                fr8Var.d(getBgByCategoryResIdl.data.recommend);
            }
            if (getBgByCategoryResIdl.data.bgs != null) {
                this.mBackgroundGroupList = new ArrayList();
                for (ThemeBgInMain themeBgInMain : getBgByCategoryResIdl.data.bgs) {
                    if (themeBgInMain != null && !StringUtils.isNull(themeBgInMain.bg_category)) {
                        iq8 iq8Var = new iq8();
                        iq8Var.c(themeBgInMain);
                        this.mBackgroundGroupList.add(iq8Var);
                    }
                }
            }
        }
    }
}
