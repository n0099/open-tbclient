package com.baidu.tieba.memberCenter.index;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.util.List;
import tbclient.DoDailyTask.ButtonItem;
import tbclient.DoDailyTask.DataRes;
import tbclient.DoDailyTask.DialogItem;
import tbclient.DoDailyTask.DoDailyTaskResIdl;
import tbclient.DoDailyTask.RetDataList;
import tbclient.Error;
/* loaded from: classes12.dex */
public class DoDailyTaskHttpResponseMessage extends TbHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<ButtonItem> buttonItems;
    public String content;
    public int isFinished;
    public int needDialog;
    public long taskId;
    public String title;
    public long userId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DoDailyTaskHttpResponseMessage(int i2) {
        super(i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.needDialog = 0;
        this.isFinished = 0;
        this.title = "";
        this.content = "";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        DoDailyTaskResIdl doDailyTaskResIdl;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bArr) == null) || (doDailyTaskResIdl = (DoDailyTaskResIdl) new Wire(new Class[0]).parseFrom(bArr, DoDailyTaskResIdl.class)) == null) {
            return;
        }
        Error error = doDailyTaskResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(doDailyTaskResIdl.error.errmsg);
        }
        DataRes dataRes = doDailyTaskResIdl.data;
        if (dataRes == null) {
            return;
        }
        RetDataList retDataList = dataRes.ret_data;
        DialogItem dialogItem = retDataList.dialog;
        this.title = dialogItem.title;
        this.content = dialogItem.content;
        this.buttonItems = dialogItem.button;
        this.needDialog = retDataList.need_dialog.intValue();
        this.isFinished = doDailyTaskResIdl.data.ret_data.task_info.is_finish.intValue();
        if (getOrginalMessage() == null || getOrginalMessage().getExtra() == null) {
            return;
        }
        DoDailyTaskRequestMessage doDailyTaskRequestMessage = (DoDailyTaskRequestMessage) getOrginalMessage().getExtra();
        this.userId = doDailyTaskRequestMessage.getUserId();
        this.taskId = doDailyTaskRequestMessage.getTaskId();
    }
}
