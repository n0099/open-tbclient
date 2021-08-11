package com.baidu.tieba.themeCenter.background;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.GetBackground.GetBackgroundResIdl;
/* loaded from: classes7.dex */
public class BackgroundGetHttpResponseMessage extends TbHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DressItemData mBgItem;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackgroundGetHttpResponseMessage() {
        super(CmdConfigHttp.CMD_PERSONAL_BACKGROUND_GET);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
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

    public DressItemData getBgItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mBgItem : (DressItemData) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        GetBackgroundResIdl getBackgroundResIdl;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bArr) == null) || (getBackgroundResIdl = (GetBackgroundResIdl) new Wire(new Class[0]).parseFrom(bArr, GetBackgroundResIdl.class)) == null) {
            return;
        }
        Error error = getBackgroundResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(getBackgroundResIdl.error.usermsg);
        }
        if (getBackgroundResIdl.data != null) {
            DressItemData dressItemData = new DressItemData();
            this.mBgItem = dressItemData;
            dressItemData.setTitle(getBackgroundResIdl.data.title);
            this.mBgItem.setDescription(getBackgroundResIdl.data.description);
            this.mBgItem.setExampleImgUrl(getBackgroundResIdl.data.pic_url);
            this.mBgItem.setFreeUserLevel(getBackgroundResIdl.data.free_user_level.intValue());
            this.mBgItem.setPermissionImgUrl(getBackgroundResIdl.data.permission);
            this.mBgItem.setPropsStateImg(getBackgroundResIdl.data.props_state_img);
            this.mBgItem.setActivityFinish(getBackgroundResIdl.data.is_finished.intValue());
            this.mBgItem.setActivityUrl(getBackgroundResIdl.data.activity_url);
            this.mBgItem.setDailyPrevilegeStatus(getBackgroundResIdl.data.daily_previlege_status.intValue());
        }
    }
}
