package com.baidu.tieba.themeCenter.background;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.po8;
import com.repackage.sn8;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.GetBgByCategory.DataRes;
import tbclient.GetBgByCategory.GetBgByCategoryResIdl;
import tbclient.GetBgByCategory.ThemeBgInMain;
/* loaded from: classes4.dex */
public class BackgroundGroupHttpResponseMessage extends TbHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<sn8> mBackgroundGroupList;
    public po8 mRecommand;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackgroundGroupHttpResponseMessage(int i) {
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

    public List<sn8> getGroupList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mBackgroundGroupList : (List) invokeV.objValue;
    }

    public po8 getRecommand() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mRecommand : (po8) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
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
                po8 po8Var = new po8();
                this.mRecommand = po8Var;
                po8Var.d(getBgByCategoryResIdl.data.recommend);
            }
            if (getBgByCategoryResIdl.data.bgs != null) {
                this.mBackgroundGroupList = new ArrayList();
                for (ThemeBgInMain themeBgInMain : getBgByCategoryResIdl.data.bgs) {
                    if (themeBgInMain != null && !StringUtils.isNull(themeBgInMain.bg_category)) {
                        sn8 sn8Var = new sn8();
                        sn8Var.c(themeBgInMain);
                        this.mBackgroundGroupList.add(sn8Var);
                    }
                }
            }
        }
    }
}
