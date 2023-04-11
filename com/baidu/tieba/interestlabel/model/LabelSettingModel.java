package com.baidu.tieba.interestlabel.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.R;
import com.baidu.tieba.a9;
import com.baidu.tieba.interestlabel.message.RequestGetLabelMessage;
import com.baidu.tieba.interestlabel.message.RequestSubLabelMessage;
import com.baidu.tieba.interestlabel.message.ResponseHttpGetLabelMessage;
import com.baidu.tieba.interestlabel.message.ResponseHttpSubLabelMessage;
import com.baidu.tieba.interestlabel.message.ResponseSocketGetLabelMessage;
import com.baidu.tieba.interestlabel.message.ResponseSocketSubLabelMessage;
import com.baidu.tieba.wc8;
import com.baidu.tieba.xc8;
import com.baidu.tieba.za;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class LabelSettingModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public xc8 b;
    public wc8 c;
    public za d;
    public za e;

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes5.dex */
    public class a extends za {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LabelSettingModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(LabelSettingModel labelSettingModel, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {labelSettingModel, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = labelSettingModel;
        }

        @Override // com.baidu.tieba.za
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            wc8 wc8Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) && responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                if (((responsedMessage instanceof ResponseHttpGetLabelMessage) || (responsedMessage instanceof ResponseSocketGetLabelMessage)) && this.a.unique_id == responsedMessage.getOrginalMessage().getTag() && this.a.b != null) {
                    xc8 xc8Var = this.a.b;
                    LabelRequestEnum labelRequestEnum = LabelRequestEnum.GET_LABEL;
                    if (responsedMessage.getError() == 0) {
                        wc8Var = this.a.c;
                    } else {
                        wc8Var = null;
                    }
                    xc8Var.a(labelRequestEnum, wc8Var, responsedMessage.getError());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends za {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LabelSettingModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(LabelSettingModel labelSettingModel, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {labelSettingModel, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = labelSettingModel;
        }

        @Override // com.baidu.tieba.za
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) && responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                if ((!(responsedMessage instanceof ResponseHttpSubLabelMessage) && !(responsedMessage instanceof ResponseSocketSubLabelMessage)) || this.a.unique_id != responsedMessage.getOrginalMessage().getTag()) {
                    return;
                }
                if (responsedMessage.getError() != 0 && !StringUtils.isNull(responsedMessage.getErrorString())) {
                    this.a.a.showToast(responsedMessage.getErrorString());
                }
                if (this.a.b == null) {
                    return;
                }
                this.a.b.a(LabelRequestEnum.SUB_LABEL, null, responsedMessage.getError());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LabelSettingModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((a9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = new a(this, CmdConfigHttp.CMD_GET_INTEREST_LABEL_LIST, 309467);
        this.e = new b(this, CmdConfigHttp.CMD_SUB_INTEREST_LABEL_LIST, 309468);
        this.a = tbPageContext;
        this.c = new wc8();
        registerListener(this.d);
        registerListener(this.e);
    }

    public void W(List<Integer> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            if (!BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                this.a.showToast((int) R.string.obfuscated_res_0x7f0f0d1b);
                return;
            }
            RequestSubLabelMessage requestSubLabelMessage = new RequestSubLabelMessage();
            requestSubLabelMessage.setLabelList(list);
            requestSubLabelMessage.setTag(this.unique_id);
            sendMessage(requestSubLabelMessage);
        }
    }

    public void X(xc8 xc8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, xc8Var) == null) {
            this.b = xc8Var;
        }
    }

    public void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (!BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                xc8 xc8Var = this.b;
                if (xc8Var != null) {
                    xc8Var.a(LabelRequestEnum.GET_LABEL, null, -1);
                    return;
                }
                return;
            }
            RequestGetLabelMessage requestGetLabelMessage = new RequestGetLabelMessage();
            requestGetLabelMessage.setFrom(1);
            requestGetLabelMessage.setLabelDataSet(this.c);
            requestGetLabelMessage.setTag(this.unique_id);
            sendMessage(requestGetLabelMessage);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            cancelMessage();
            return false;
        }
        return invokeV.booleanValue;
    }
}
