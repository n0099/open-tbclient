package com.baidu.tieba.stampmission.message;

import android.text.TextUtils;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes13.dex */
public class StampMissionHttpRequestMessage extends HttpMessage {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_TASK_TYPE = "task_type";
    public static final String KEY_TYPE = "type";
    public static final String TASK_FOLLOW = "follow_task";
    public static final String TASK_LIKE = "like_task";
    public static final String TASK_REPLY = "reply_task";
    public static final String TYPE_START = "start";
    public static final String TYPE_SYNC = "sync";
    public transient /* synthetic */ FieldHolder $fh;
    public String taskType;
    public String type;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StampMissionHttpRequestMessage(String str, String str2) {
        super(CmdConfigHttp.CMD_GET_SYNC_ICON_TASK);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
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
        this.type = str;
        this.taskType = str2;
        if (!TextUtils.isEmpty(str)) {
            addParam("type", str);
        }
        if (!TYPE_SYNC.equals(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        addParam(KEY_TASK_TYPE, str2);
    }

    public static StampMissionHttpRequestMessage newStartHttpMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new StampMissionHttpRequestMessage("start", null) : (StampMissionHttpRequestMessage) invokeV.objValue;
    }

    public static StampMissionHttpRequestMessage newSyncHttpMessage(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? new StampMissionHttpRequestMessage(TYPE_SYNC, str) : (StampMissionHttpRequestMessage) invokeL.objValue;
    }
}
