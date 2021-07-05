package com.baidu.tieba.interestlabel.model;

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
import d.a.c.a.f;
import d.a.c.e.p.j;
import java.util.List;
/* loaded from: classes5.dex */
public class LabelSettingModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f18027e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.s0.l1.c.a f18028f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.s0.l1.b.b f18029g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.c.c.g.a f18030h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.c.c.g.a f18031i;

    /* loaded from: classes5.dex */
    public class a extends d.a.c.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LabelSettingModel f18032a;

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
            this.f18032a = labelSettingModel;
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null || responsedMessage.getOrginalMessage() == null) {
                return;
            }
            if (((responsedMessage instanceof ResponseHttpGetLabelMessage) || (responsedMessage instanceof ResponseSocketGetLabelMessage)) && this.f18032a.unique_id == responsedMessage.getOrginalMessage().getTag() && this.f18032a.f18028f != null) {
                this.f18032a.f18028f.callback(LabelRequestEnum.GET_LABEL, responsedMessage.getError() == 0 ? this.f18032a.f18029g : null, responsedMessage.getError());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends d.a.c.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LabelSettingModel f18033a;

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
            this.f18033a = labelSettingModel;
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null || responsedMessage.getOrginalMessage() == null) {
                return;
            }
            if (((responsedMessage instanceof ResponseHttpSubLabelMessage) || (responsedMessage instanceof ResponseSocketSubLabelMessage)) && this.f18033a.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                if (responsedMessage.getError() != 0 && !StringUtils.isNull(responsedMessage.getErrorString())) {
                    this.f18033a.f18027e.showToast(responsedMessage.getErrorString());
                }
                if (this.f18033a.f18028f == null) {
                    return;
                }
                this.f18033a.f18028f.callback(LabelRequestEnum.SUB_LABEL, null, responsedMessage.getError());
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
        this.f18030h = new a(this, CmdConfigHttp.CMD_GET_INTEREST_LABEL_LIST, 309467);
        this.f18031i = new b(this, CmdConfigHttp.CMD_SUB_INTEREST_LABEL_LIST, 309468);
        this.f18027e = tbPageContext;
        this.f18029g = new d.a.s0.l1.b.b();
        registerListener(this.f18030h);
        registerListener(this.f18031i);
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (!j.A()) {
                d.a.s0.l1.c.a aVar = this.f18028f;
                if (aVar != null) {
                    aVar.callback(LabelRequestEnum.GET_LABEL, null, -1);
                    return;
                }
                return;
            }
            RequestGetLabelMessage requestGetLabelMessage = new RequestGetLabelMessage();
            requestGetLabelMessage.setFrom(1);
            requestGetLabelMessage.setLabelDataSet(this.f18029g);
            requestGetLabelMessage.setTag(this.unique_id);
            sendMessage(requestGetLabelMessage);
        }
    }

    public void C(List<Integer> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            if (!j.A()) {
                this.f18027e.showToast(R.string.neterror);
                return;
            }
            RequestSubLabelMessage requestSubLabelMessage = new RequestSubLabelMessage();
            requestSubLabelMessage.setLabelList(list);
            requestSubLabelMessage.setTag(this.unique_id);
            sendMessage(requestSubLabelMessage);
        }
    }

    public void D(d.a.s0.l1.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.f18028f = aVar;
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
