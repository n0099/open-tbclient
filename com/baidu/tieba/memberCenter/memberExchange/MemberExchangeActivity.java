package com.baidu.tieba.memberCenter.memberExchange;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.MemberExchangeActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
/* loaded from: classes5.dex */
public class MemberExchangeActivity extends BaseActivity<MemberExchangeActivity> implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String descStr;
    public String dueDate;
    public HttpMessageListener getTCodeInfoListener;
    public d.a.s0.v1.d.a mView;
    public String memberImage;
    public String memberLevelIcon;
    public String memberName;

    /* loaded from: classes5.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MemberExchangeActivity f18546a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(MemberExchangeActivity memberExchangeActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {memberExchangeActivity, Integer.valueOf(i2)};
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
            this.f18546a = memberExchangeActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && (httpResponsedMessage instanceof GetTCodeResMessage)) {
                GetTCodeResMessage getTCodeResMessage = (GetTCodeResMessage) httpResponsedMessage;
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    if (getTCodeResMessage.getTCodeInfo() != null) {
                        if (getTCodeResMessage.getTCodeInfo().f68296a.equals("0")) {
                            this.f18546a.showToast(R.string.exchange_success);
                            return;
                        } else {
                            this.f18546a.showToast(R.string.exchange_error);
                            return;
                        }
                    }
                    this.f18546a.showToast(R.string.neterror);
                    return;
                }
                String errorString = httpResponsedMessage.getErrorString();
                if (StringUtils.isNull(errorString) || StringUtil.NULL_STRING.equals(errorString)) {
                    errorString = this.f18546a.getResources().getString(R.string.neterror);
                }
                this.f18546a.showToast(errorString);
            }
        }
    }

    public MemberExchangeActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.getTCodeInfoListener = new a(this, CmdConfigHttp.CMD_GET_TCODE_INFO_CMD);
    }

    private void initListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            registerListener(this.getTCodeInfoListener);
        }
    }

    private void initTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_TCODE_INFO_CMD, TbConfig.SERVER_ADDRESS + TbConfig.GET_T_CODE_INFO);
            tbHttpMessageTask.setResponsedClass(GetTCodeResMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    private void requestTCodeInfo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_TCODE_INFO_CMD);
            httpMessage.addParam(GetTCodeResMessage.ACTIVATION_CODE, this.mView.b().getText().toString());
            sendMessage(httpMessage);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null) {
            return;
        }
        if (view.getId() == R.id.go_to_exchange) {
            requestTCodeInfo();
        } else {
            l.x(getPageContext().getPageActivity(), this.mView.b());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            if (bundle != null) {
                this.memberImage = bundle.getString(MemberExchangeActivityConfig.MEMBER_IMAGE);
                this.memberName = bundle.getString(MemberExchangeActivityConfig.MEMBER_NAME);
                this.memberLevelIcon = bundle.getString(MemberExchangeActivityConfig.MEMBER_LEVEL_IMAGE);
                this.dueDate = bundle.getString(MemberExchangeActivityConfig.DUE_DATE);
                this.descStr = bundle.getString(MemberExchangeActivityConfig.DESC_STR);
            } else if (getIntent() != null) {
                this.memberImage = getIntent().getStringExtra(MemberExchangeActivityConfig.MEMBER_IMAGE);
                this.memberName = getIntent().getStringExtra(MemberExchangeActivityConfig.MEMBER_NAME);
                this.memberLevelIcon = getIntent().getStringExtra(MemberExchangeActivityConfig.MEMBER_LEVEL_IMAGE);
                this.dueDate = getIntent().getStringExtra(MemberExchangeActivityConfig.DUE_DATE);
                this.descStr = getIntent().getStringExtra(MemberExchangeActivityConfig.DESC_STR);
            }
            initTask();
            initListener();
            d.a.s0.v1.d.a aVar = new d.a.s0.v1.d.a(this);
            this.mView = aVar;
            aVar.a(this.memberImage, this.memberName, this.memberLevelIcon, this.dueDate, this.descStr);
        }
    }
}
