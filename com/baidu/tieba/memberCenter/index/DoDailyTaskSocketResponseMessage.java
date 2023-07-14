package com.baidu.tieba.memberCenter.index;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
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
/* loaded from: classes7.dex */
public class DoDailyTaskSocketResponseMessage extends SocketResponsedMessage {
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
    public DoDailyTaskSocketResponseMessage() {
        super(309405);
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
        this.needDialog = 0;
        this.isFinished = 0;
        this.title = "";
        this.content = "";
    }

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            DoDailyTaskResIdl doDailyTaskResIdl = (DoDailyTaskResIdl) new Wire(new Class[0]).parseFrom(bArr, DoDailyTaskResIdl.class);
            if (doDailyTaskResIdl == null) {
                return null;
            }
            Error error = doDailyTaskResIdl.error;
            if (error != null) {
                setError(error.errorno.intValue());
                setErrorString(doDailyTaskResIdl.error.errmsg);
            }
            DataRes dataRes = doDailyTaskResIdl.data;
            if (dataRes == null) {
                return doDailyTaskResIdl;
            }
            RetDataList retDataList = dataRes.ret_data;
            DialogItem dialogItem = retDataList.dialog;
            this.title = dialogItem.title;
            this.content = dialogItem.content;
            this.buttonItems = dialogItem.button;
            this.needDialog = retDataList.need_dialog.intValue();
            this.isFinished = doDailyTaskResIdl.data.ret_data.task_info.is_finish.intValue();
            if (getOrginalMessage() != null && getOrginalMessage().getExtra() != null) {
                DoDailyTaskRequestMessage doDailyTaskRequestMessage = (DoDailyTaskRequestMessage) getOrginalMessage().getExtra();
                this.userId = doDailyTaskRequestMessage.getUserId();
                this.taskId = doDailyTaskRequestMessage.getTaskId();
            }
            return doDailyTaskResIdl;
        }
        return invokeIL.objValue;
    }
}
