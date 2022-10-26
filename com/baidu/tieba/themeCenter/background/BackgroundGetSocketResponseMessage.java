package com.baidu.tieba.themeCenter.background;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.GetBackground.DataRes;
import tbclient.GetBackground.GetBackgroundResIdl;
/* loaded from: classes6.dex */
public class BackgroundGetSocketResponseMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DressItemData mBgItem;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackgroundGetSocketResponseMessage() {
        super(309023);
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

    public DressItemData getBgItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mBgItem;
        }
        return (DressItemData) invokeV.objValue;
    }

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            GetBackgroundResIdl getBackgroundResIdl = (GetBackgroundResIdl) new Wire(new Class[0]).parseFrom(bArr, GetBackgroundResIdl.class);
            if (getBackgroundResIdl == null) {
                return null;
            }
            Error error = getBackgroundResIdl.error;
            if (error != null) {
                setError(error.errorno.intValue());
                setErrorString(getBackgroundResIdl.error.usermsg);
            }
            DataRes dataRes = getBackgroundResIdl.data;
            if (dataRes != null && !StringUtils.isNull(dataRes.title)) {
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
                this.mBgItem.setDailyPrevilegeStatus(getBackgroundResIdl.data.daily_privilege_status.intValue());
            }
            return getBackgroundResIdl;
        }
        return invokeIL.objValue;
    }
}
