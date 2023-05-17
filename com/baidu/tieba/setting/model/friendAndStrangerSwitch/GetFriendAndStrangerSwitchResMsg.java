package com.baidu.tieba.setting.model.friendAndStrangerSwitch;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class GetFriendAndStrangerSwitchResMsg extends JsonHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int INVALID_TYPE = -1;
    public transient /* synthetic */ FieldHolder $fh;
    public int mMaskType;
    public int mPushType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetFriendAndStrangerSwitchResMsg() {
        super(CmdConfigHttp.CMD_GET_FRIEND_AND_STRANGER_MSG_SWITCH);
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
        this.mMaskType = -1;
        this.mPushType = -1;
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, jSONObject) == null) {
            try {
                this.mMaskType = jSONObject.getInt("data");
                this.mPushType = jSONObject.getInt("need_push");
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }
}
