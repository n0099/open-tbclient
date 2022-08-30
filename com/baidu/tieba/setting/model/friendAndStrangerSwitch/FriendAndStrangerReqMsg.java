package com.baidu.tieba.setting.model.friendAndStrangerSwitch;

import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class FriendAndStrangerReqMsg extends HttpMessage {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MASK_ALL = 3;
    public static final int MASK_STRANGER = 1;
    public static final String MASK_TYPE = "maskType";
    public static final int NO_MASK = 0;
    public static final String PUSH_TYPE = "pushType";
    public static final int PUSH_TYPE_CLOSE = 2;
    public static final int PUSH_TYPE_NO = 0;
    public static final int PUSH_TYPE_OPEN = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public int mMaskType;
    public int mPushType;
    public int mRequestType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FriendAndStrangerReqMsg(int i, int i2, int i3) {
        super(CmdConfigHttp.CMD_FRIEND_AND_STRANGER_MSG_SWITCH);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mMaskType = 0;
        this.mRequestType = 0;
        this.mPushType = 0;
        this.mRequestType = i2;
        if (i3 != 0) {
            this.mPushType = i3;
            addParam(PUSH_TYPE, i3);
            return;
        }
        this.mMaskType = i;
        addParam("maskType", i);
    }
}
