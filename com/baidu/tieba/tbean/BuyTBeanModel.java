package com.baidu.tieba.tbean;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.e.a.f;
import c.a.q0.i3.i0.g;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.pay.ResponseGetPayinfoMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.tbean.message.GetBigTbeanWalletH5ResponseMessage;
import com.baidu.tieba.tbean.message.GetYinJiHttpResponseMessage;
import com.baidu.tieba.tbean.message.GetYinJiRequestMessage;
import com.baidu.tieba.tbean.message.GetYinJiResponseMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import tbclient.GetIconList.Custom;
import tbclient.GetIconList.IconInfo;
import tbclient.GetIconList.UserInfo;
/* loaded from: classes7.dex */
public class BuyTBeanModel extends BdBaseModel<BuyTBeanActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String GET_BIG_TBEAN_WALLET_H5 = "tbmall/getPayUrl";
    public static final String GET_ICON_URL = "c/e/pay/geticonlist";
    public static final int SUPER_MEMBER = 2;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public BuyTBeanActivity f57054e;

    /* renamed from: f  reason: collision with root package name */
    public e f57055f;

    /* renamed from: g  reason: collision with root package name */
    public List<c.a.q0.k3.e.b> f57056g;

    /* renamed from: h  reason: collision with root package name */
    public List<c.a.q0.k3.e.a> f57057h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.q0.k3.e.c f57058i;

    /* renamed from: j  reason: collision with root package name */
    public UserInfo f57059j;

    /* loaded from: classes7.dex */
    public class a extends c.a.e.c.g.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BuyTBeanModel f57060a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(BuyTBeanModel buyTBeanModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {buyTBeanModel, Integer.valueOf(i2)};
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
            this.f57060a = buyTBeanModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) {
                if (socketResponsedMessage == null || !(socketResponsedMessage instanceof GetYinJiResponseMessage)) {
                    this.f57060a.f57055f.onFailed(this.f57060a.f57054e.getPageContext().getString(R.string.neterror));
                    return;
                }
                GetYinJiResponseMessage getYinJiResponseMessage = (GetYinJiResponseMessage) socketResponsedMessage;
                if (getYinJiResponseMessage.getError() != 0) {
                    if (!TextUtils.isEmpty(getYinJiResponseMessage.getErrorString())) {
                        this.f57060a.f57055f.onFailed(getYinJiResponseMessage.getErrorString());
                    } else {
                        this.f57060a.f57055f.onFailed(this.f57060a.f57054e.getPageContext().getString(R.string.neterror));
                    }
                    if (this.f57060a.f57054e == null || getYinJiResponseMessage.getError() != 1990055) {
                        return;
                    }
                    this.f57060a.f57054e.finish();
                    return;
                }
                this.f57060a.f57059j = getYinJiResponseMessage.getUserInfo();
                this.f57060a.A(getYinJiResponseMessage);
                if (getYinJiResponseMessage.getUserInfo() == null || ListUtils.isEmpty(getYinJiResponseMessage.getIconInfoList())) {
                    this.f57060a.f57055f.onFailed(this.f57060a.f57054e.getPageContext().getString(R.string.no_data_tip));
                } else {
                    this.f57060a.f57055f.onSuccess();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BuyTBeanModel f57061a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(BuyTBeanModel buyTBeanModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {buyTBeanModel, Integer.valueOf(i2)};
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
            this.f57061a = buyTBeanModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && (httpResponsedMessage instanceof GetBigTbeanWalletH5ResponseMessage)) {
                GetBigTbeanWalletH5ResponseMessage getBigTbeanWalletH5ResponseMessage = (GetBigTbeanWalletH5ResponseMessage) httpResponsedMessage;
                if (getBigTbeanWalletH5ResponseMessage.getError() == 0 && this.f57061a.f57055f != null) {
                    this.f57061a.f57055f.onGetWalletUrl(getBigTbeanWalletH5ResponseMessage.url);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BuyTBeanModel f57062a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(BuyTBeanModel buyTBeanModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {buyTBeanModel, Integer.valueOf(i2)};
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
            this.f57062a = buyTBeanModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                if (httpResponsedMessage == null || !(httpResponsedMessage instanceof GetYinJiHttpResponseMessage)) {
                    this.f57062a.f57055f.onFailed(this.f57062a.f57054e.getPageContext().getString(R.string.neterror));
                    return;
                }
                GetYinJiHttpResponseMessage getYinJiHttpResponseMessage = (GetYinJiHttpResponseMessage) httpResponsedMessage;
                if (getYinJiHttpResponseMessage.getError() != 0) {
                    if (!TextUtils.isEmpty(getYinJiHttpResponseMessage.getErrorString())) {
                        this.f57062a.f57055f.onFailed(getYinJiHttpResponseMessage.getErrorString());
                    } else {
                        this.f57062a.f57055f.onFailed(this.f57062a.f57054e.getPageContext().getString(R.string.neterror));
                    }
                    if (this.f57062a.f57054e == null || getYinJiHttpResponseMessage.getError() != 1990055) {
                        return;
                    }
                    this.f57062a.f57054e.finish();
                    return;
                }
                this.f57062a.f57059j = getYinJiHttpResponseMessage.getUserInfo();
                this.f57062a.A(getYinJiHttpResponseMessage);
                if (getYinJiHttpResponseMessage.getUserInfo() == null || ListUtils.isEmpty(getYinJiHttpResponseMessage.getIconInfoList())) {
                    this.f57062a.f57055f.onFailed(this.f57062a.f57054e.getPageContext().getString(R.string.no_data_tip));
                } else {
                    this.f57062a.f57055f.onSuccess();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BuyTBeanModel f57063a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(BuyTBeanModel buyTBeanModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {buyTBeanModel, Integer.valueOf(i2)};
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
            this.f57063a = buyTBeanModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                if (httpResponsedMessage == null || !(httpResponsedMessage instanceof ResponseGetPayinfoMessage) || httpResponsedMessage.getCmd() != 1001505) {
                    if (this.f57063a.f57054e != null) {
                        this.f57063a.f57054e.showToast(R.string.neterror);
                        return;
                    }
                    return;
                }
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                ResponseGetPayinfoMessage responseGetPayinfoMessage = (ResponseGetPayinfoMessage) httpResponsedMessage;
                HttpMessage httpMessage = (HttpMessage) responseGetPayinfoMessage.getOrginalMessage();
                if (statusCode == 200 && error == 0) {
                    if (responseGetPayinfoMessage.getPayInfoResultData() == null) {
                        if (this.f57063a.f57054e != null) {
                            this.f57063a.f57054e.showToast(R.string.buy_tbean_failed_tip);
                            return;
                        }
                    } else {
                        int pay_status = responseGetPayinfoMessage.getPayInfoResultData().getPay_status();
                        if (pay_status != 0) {
                            if (this.f57063a.f57054e != null) {
                                this.f57063a.f57054e.showToast(R.string.buy_tbean_failed_tip);
                                return;
                            }
                        } else {
                            c.a.q0.k3.c.a("c10297");
                            String str = httpMessage.getExtra() instanceof String ? (String) httpMessage.getExtra() : "";
                            g gVar = new g();
                            gVar.d(str);
                            gVar.c(pay_status);
                            gVar.b(this.f57063a.f57054e.isFromDecreaseGiftStepStrategy());
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001227, gVar));
                            if (this.f57063a.f57054e != null) {
                                this.f57063a.f57054e.finish();
                                return;
                            }
                        }
                    }
                }
                if (!TextUtils.isEmpty(responseGetPayinfoMessage.getErrorString())) {
                    this.f57063a.f57054e.showToast(responseGetPayinfoMessage.getErrorString());
                } else {
                    this.f57063a.f57054e.showToast(R.string.neterror);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface e {
        void onFailed(String str);

        void onGetWalletUrl(String str);

        void onSuccess();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BuyTBeanModel(BuyTBeanActivity buyTBeanActivity, e eVar) {
        super(buyTBeanActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {buyTBeanActivity, eVar};
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
        this.f57056g = new LinkedList();
        this.f57057h = new LinkedList();
        this.f57054e = buyTBeanActivity;
        this.f57055f = eVar;
    }

    public final void A(c.a.q0.k3.f.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null || aVar.getUserInfo() == null || ListUtils.isEmpty(aVar.getIconInfoList())) {
            return;
        }
        List<c.a.q0.k3.e.b> list = this.f57056g;
        if (list != null) {
            list.clear();
        }
        List<c.a.q0.k3.e.a> list2 = this.f57057h;
        if (list2 != null) {
            list2.clear();
        }
        ArrayList<c.a.q0.k3.e.a> arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (!ListUtils.isEmpty(aVar.getCustomList())) {
            for (Custom custom : aVar.getCustomList()) {
                if (custom.is_custom_price.intValue() == 1) {
                    c.a.q0.k3.e.c cVar = new c.a.q0.k3.e.c();
                    cVar.f21556e = custom;
                    arrayList2.add(cVar);
                } else if (custom.is_custom_price.intValue() == 0) {
                    c.a.q0.k3.e.a aVar2 = new c.a.q0.k3.e.a();
                    aVar2.f21550e = custom;
                    arrayList.add(aVar2);
                }
            }
        }
        if (!ListUtils.isEmpty(arrayList)) {
            for (c.a.q0.k3.e.a aVar3 : arrayList) {
                aVar3.f21551f = aVar.getSetting();
                this.f57057h.add(aVar3);
            }
        }
        if (!ListUtils.isEmpty(aVar.getIconInfoList())) {
            for (IconInfo iconInfo : aVar.getIconInfoList()) {
                c.a.q0.k3.e.b bVar = new c.a.q0.k3.e.b();
                bVar.f21554f = iconInfo;
                aVar.getUserInfo();
                bVar.f21553e = aVar.getSetting();
                this.f57056g.add(bVar);
            }
        }
        if (ListUtils.isEmpty(arrayList2)) {
            return;
        }
        c.a.q0.k3.e.c cVar2 = (c.a.q0.k3.e.c) ListUtils.getItem(arrayList2, 0);
        this.f57058i = cVar2;
        cVar2.f21558g = aVar.getSetting();
        this.f57058i.f21557f = aVar.getUserInfo();
    }

    public List<c.a.q0.k3.e.b> B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f57056g : (List) invokeV.objValue;
    }

    public List<c.a.q0.k3.e.a> C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f57057h : (List) invokeV.objValue;
    }

    public c.a.q0.k3.e.c D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f57058i : (c.a.q0.k3.e.c) invokeV.objValue;
    }

    public UserInfo E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f57059j : (UserInfo) invokeV.objValue;
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            registerListener(new b(this, CmdConfigHttp.CMD_HTTP_GET_BIG_TBEAN_URL));
        }
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            registerListener(new d(this, CmdConfigHttp.GETPAYINFO_CMD));
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            c cVar = new c(this, CmdConfigHttp.CMD_HTTP_GET_YINJI);
            cVar.setSelfListener(true);
            registerListener(cVar);
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            a aVar = new a(this, 306001);
            aVar.setSelfListener(true);
            registerListener(aVar);
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            sendMessage(new GetYinJiRequestMessage());
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }
}
