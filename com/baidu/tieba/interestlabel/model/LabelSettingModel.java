package com.baidu.tieba.interestlabel.model;

import c.a.e.a.f;
import c.a.e.e.p.j;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.R;
import com.baidu.tieba.interestlabel.message.RequestGetLabelMessage;
import com.baidu.tieba.interestlabel.message.RequestSubLabelMessage;
import com.baidu.tieba.interestlabel.message.ResponseHttpGetLabelMessage;
import com.baidu.tieba.interestlabel.message.ResponseHttpSubLabelMessage;
import com.baidu.tieba.interestlabel.message.ResponseSocketGetLabelMessage;
import com.baidu.tieba.interestlabel.message.ResponseSocketSubLabelMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class LabelSettingModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f53546e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.q0.m1.c.a f53547f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.q0.m1.b.b f53548g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.e.c.g.a f53549h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.e.c.g.a f53550i;

    /* loaded from: classes7.dex */
    public class a extends c.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LabelSettingModel f53551a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(LabelSettingModel labelSettingModel, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {labelSettingModel, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53551a = labelSettingModel;
        }

        @Override // c.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null || responsedMessage.getOrginalMessage() == null) {
                return;
            }
            if (((responsedMessage instanceof ResponseHttpGetLabelMessage) || (responsedMessage instanceof ResponseSocketGetLabelMessage)) && this.f53551a.unique_id == responsedMessage.getOrginalMessage().getTag() && this.f53551a.f53547f != null) {
                this.f53551a.f53547f.callback(LabelRequestEnum.GET_LABEL, responsedMessage.getError() == 0 ? this.f53551a.f53548g : null, responsedMessage.getError());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends c.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LabelSettingModel f53552a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(LabelSettingModel labelSettingModel, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {labelSettingModel, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53552a = labelSettingModel;
        }

        @Override // c.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null || responsedMessage.getOrginalMessage() == null) {
                return;
            }
            if (((responsedMessage instanceof ResponseHttpSubLabelMessage) || (responsedMessage instanceof ResponseSocketSubLabelMessage)) && this.f53552a.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                if (responsedMessage.getError() != 0 && !StringUtils.isNull(responsedMessage.getErrorString())) {
                    this.f53552a.f53546e.showToast(responsedMessage.getErrorString());
                }
                if (this.f53552a.f53547f == null) {
                    return;
                }
                this.f53552a.f53547f.callback(LabelRequestEnum.SUB_LABEL, null, responsedMessage.getError());
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f53549h = new a(this, CmdConfigHttp.CMD_GET_INTEREST_LABEL_LIST, 309467);
        this.f53550i = new b(this, CmdConfigHttp.CMD_SUB_INTEREST_LABEL_LIST, 309468);
        this.f53546e = tbPageContext;
        this.f53548g = new c.a.q0.m1.b.b();
        registerListener(this.f53549h);
        registerListener(this.f53550i);
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (!j.A()) {
                c.a.q0.m1.c.a aVar = this.f53547f;
                if (aVar != null) {
                    aVar.callback(LabelRequestEnum.GET_LABEL, null, -1);
                    return;
                }
                return;
            }
            RequestGetLabelMessage requestGetLabelMessage = new RequestGetLabelMessage();
            requestGetLabelMessage.setFrom(1);
            requestGetLabelMessage.setLabelDataSet(this.f53548g);
            requestGetLabelMessage.setTag(this.unique_id);
            sendMessage(requestGetLabelMessage);
        }
    }

    public void C(List<Integer> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            if (!j.A()) {
                this.f53546e.showToast(R.string.neterror);
                return;
            }
            RequestSubLabelMessage requestSubLabelMessage = new RequestSubLabelMessage();
            requestSubLabelMessage.setLabelList(list);
            requestSubLabelMessage.setTag(this.unique_id);
            sendMessage(requestSubLabelMessage);
        }
    }

    public void D(c.a.q0.m1.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.f53547f = aVar;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            cancelMessage();
            return false;
        }
        return invokeV.booleanValue;
    }
}
