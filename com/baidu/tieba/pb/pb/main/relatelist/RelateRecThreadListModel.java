package com.baidu.tieba.pb.pb.main.relatelist;

import android.util.Log;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.b9;
import com.repackage.el4;
import com.repackage.ig8;
import com.repackage.wa;
import tbclient.RelateRecThread.DataRes;
/* loaded from: classes3.dex */
public class RelateRecThreadListModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int SOURCE_FROM_SEARCH_CHANNEL_USER_ILLEGAL = -1;
    public static final int SOURCE_FROM_SEARCH_CHANNEL_USER_SHOUBAI = 5;
    public static final int SOURCE_FROM_SEARCH_CHANNEL_USER_WISE = 4;
    public static final int SOURCE_TYPE_SEARCH_CHANNEL_USER = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public RelateRecThreadRequestMessage b;
    public el4 c;
    public wa d;

    /* loaded from: classes3.dex */
    public class a extends wa {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RelateRecThreadListModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(RelateRecThreadListModel relateRecThreadListModel, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {relateRecThreadListModel, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = relateRecThreadListModel;
        }

        @Override // com.repackage.wa
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            RelateRecThreadRequestMessage relateRecThreadRequestMessage;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                Log.e("RecThreadList", "------onMessage----");
                this.a.a = false;
                if (responsedMessage == null || responsedMessage.getmOrginalMessage() == null || (relateRecThreadRequestMessage = (RelateRecThreadRequestMessage) responsedMessage.getmOrginalMessage().getExtra()) == null || this.a.b == null || this.a.b.threadId != relateRecThreadRequestMessage.threadId) {
                    return;
                }
                int error = responsedMessage.getError();
                String errorString = responsedMessage.getErrorString();
                if (error == 0 && !responsedMessage.hasError()) {
                    DataRes data = responsedMessage instanceof RelateRecThreadSocketResponseMessage ? ((RelateRecThreadSocketResponseMessage) responsedMessage).getData() : null;
                    if (responsedMessage instanceof RelateRecThreadHttpResponseMessage) {
                        data = ((RelateRecThreadHttpResponseMessage) responsedMessage).getData();
                    }
                    if (this.a.c != null) {
                        this.a.c.onSuccess(data);
                        return;
                    }
                    return;
                }
                Log.e("RecThreadList", "errno=" + error + ",errmsg=" + errorString);
                if (StringUtils.isNull(errorString)) {
                    errorString = this.a.C(R.string.obfuscated_res_0x7f0f05ac);
                }
                if (this.a.c != null) {
                    this.a.c.onError(error, errorString);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RelateRecThreadListModel(b9 b9Var, BdUniqueId bdUniqueId) {
        super(b9Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {b9Var, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((b9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = false;
        this.d = new a(this, CmdConfigHttp.CMD_RELATE_REC_THREAD, 309701);
        setUniqueId(bdUniqueId);
        D();
    }

    public final String C(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) ? TbadkCoreApplication.getInst().getString(i) : (String) invokeI.objValue;
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ig8.h(309701, RelateRecThreadSocketResponseMessage.class, false, false);
            ig8.c(309701, CmdConfigHttp.CMD_RELATE_REC_THREAD, TbConfig.URL_RELATE_REC_THREAD, RelateRecThreadHttpResponseMessage.class, true, false, true, false);
            this.d.getHttpMessageListener().setSelfListener(true);
            this.d.getSocketMessageListener().setSelfListener(true);
            registerListener(this.d);
        }
    }

    public boolean E(long j, long j2, int i, int i2, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Integer.valueOf(i2), str})) == null) {
            if (this.a) {
                return false;
            }
            RelateRecThreadRequestMessage relateRecThreadRequestMessage = new RelateRecThreadRequestMessage();
            relateRecThreadRequestMessage.threadId = j2;
            relateRecThreadRequestMessage.forumId = j;
            relateRecThreadRequestMessage.sourceFrom = i2;
            relateRecThreadRequestMessage.sourceType = i;
            relateRecThreadRequestMessage.eqid = str;
            sendMessage(relateRecThreadRequestMessage);
            this.b = relateRecThreadRequestMessage;
            this.a = true;
            Log.e("RecThreadList", "sendReqMessage-->forumId=" + j + ",threadId=" + j2);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public void F(el4 el4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, el4Var) == null) {
            this.c = el4Var;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.a = false;
            this.b = null;
            MessageManager.getInstance().unRegisterListener(this.d);
        }
    }
}
