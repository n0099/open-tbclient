package com.baidu.tieba.tbean;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.e.a.f;
import c.a.p0.i3.h0.g;
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
    public BuyTBeanActivity f56889e;

    /* renamed from: f  reason: collision with root package name */
    public e f56890f;

    /* renamed from: g  reason: collision with root package name */
    public List<c.a.p0.k3.e.b> f56891g;

    /* renamed from: h  reason: collision with root package name */
    public List<c.a.p0.k3.e.a> f56892h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.p0.k3.e.c f56893i;

    /* renamed from: j  reason: collision with root package name */
    public UserInfo f56894j;

    /* loaded from: classes7.dex */
    public class a extends c.a.e.c.g.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BuyTBeanModel f56895a;

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
            this.f56895a = buyTBeanModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) {
                if (socketResponsedMessage == null || !(socketResponsedMessage instanceof GetYinJiResponseMessage)) {
                    this.f56895a.f56890f.onFailed(this.f56895a.f56889e.getPageContext().getString(R.string.neterror));
                    return;
                }
                GetYinJiResponseMessage getYinJiResponseMessage = (GetYinJiResponseMessage) socketResponsedMessage;
                if (getYinJiResponseMessage.getError() != 0) {
                    if (!TextUtils.isEmpty(getYinJiResponseMessage.getErrorString())) {
                        this.f56895a.f56890f.onFailed(getYinJiResponseMessage.getErrorString());
                    } else {
                        this.f56895a.f56890f.onFailed(this.f56895a.f56889e.getPageContext().getString(R.string.neterror));
                    }
                    if (this.f56895a.f56889e == null || getYinJiResponseMessage.getError() != 1990055) {
                        return;
                    }
                    this.f56895a.f56889e.finish();
                    return;
                }
                this.f56895a.f56894j = getYinJiResponseMessage.getUserInfo();
                this.f56895a.A(getYinJiResponseMessage);
                if (getYinJiResponseMessage.getUserInfo() == null || ListUtils.isEmpty(getYinJiResponseMessage.getIconInfoList())) {
                    this.f56895a.f56890f.onFailed(this.f56895a.f56889e.getPageContext().getString(R.string.no_data_tip));
                } else {
                    this.f56895a.f56890f.onSuccess();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BuyTBeanModel f56896a;

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
            this.f56896a = buyTBeanModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && (httpResponsedMessage instanceof GetBigTbeanWalletH5ResponseMessage)) {
                GetBigTbeanWalletH5ResponseMessage getBigTbeanWalletH5ResponseMessage = (GetBigTbeanWalletH5ResponseMessage) httpResponsedMessage;
                if (getBigTbeanWalletH5ResponseMessage.getError() == 0 && this.f56896a.f56890f != null) {
                    this.f56896a.f56890f.onGetWalletUrl(getBigTbeanWalletH5ResponseMessage.url);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BuyTBeanModel f56897a;

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
            this.f56897a = buyTBeanModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                if (httpResponsedMessage == null || !(httpResponsedMessage instanceof GetYinJiHttpResponseMessage)) {
                    this.f56897a.f56890f.onFailed(this.f56897a.f56889e.getPageContext().getString(R.string.neterror));
                    return;
                }
                GetYinJiHttpResponseMessage getYinJiHttpResponseMessage = (GetYinJiHttpResponseMessage) httpResponsedMessage;
                if (getYinJiHttpResponseMessage.getError() != 0) {
                    if (!TextUtils.isEmpty(getYinJiHttpResponseMessage.getErrorString())) {
                        this.f56897a.f56890f.onFailed(getYinJiHttpResponseMessage.getErrorString());
                    } else {
                        this.f56897a.f56890f.onFailed(this.f56897a.f56889e.getPageContext().getString(R.string.neterror));
                    }
                    if (this.f56897a.f56889e == null || getYinJiHttpResponseMessage.getError() != 1990055) {
                        return;
                    }
                    this.f56897a.f56889e.finish();
                    return;
                }
                this.f56897a.f56894j = getYinJiHttpResponseMessage.getUserInfo();
                this.f56897a.A(getYinJiHttpResponseMessage);
                if (getYinJiHttpResponseMessage.getUserInfo() == null || ListUtils.isEmpty(getYinJiHttpResponseMessage.getIconInfoList())) {
                    this.f56897a.f56890f.onFailed(this.f56897a.f56889e.getPageContext().getString(R.string.no_data_tip));
                } else {
                    this.f56897a.f56890f.onSuccess();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BuyTBeanModel f56898a;

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
            this.f56898a = buyTBeanModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                if (httpResponsedMessage == null || !(httpResponsedMessage instanceof ResponseGetPayinfoMessage) || httpResponsedMessage.getCmd() != 1001505) {
                    if (this.f56898a.f56889e != null) {
                        this.f56898a.f56889e.showToast(R.string.neterror);
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
                        if (this.f56898a.f56889e != null) {
                            this.f56898a.f56889e.showToast(R.string.buy_tbean_failed_tip);
                            return;
                        }
                    } else {
                        int pay_status = responseGetPayinfoMessage.getPayInfoResultData().getPay_status();
                        if (pay_status != 0) {
                            if (this.f56898a.f56889e != null) {
                                this.f56898a.f56889e.showToast(R.string.buy_tbean_failed_tip);
                                return;
                            }
                        } else {
                            c.a.p0.k3.c.a("c10297");
                            String str = httpMessage.getExtra() instanceof String ? (String) httpMessage.getExtra() : "";
                            g gVar = new g();
                            gVar.d(str);
                            gVar.c(pay_status);
                            gVar.b(this.f56898a.f56889e.isFromDecreaseGiftStepStrategy());
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001227, gVar));
                            if (this.f56898a.f56889e != null) {
                                this.f56898a.f56889e.finish();
                                return;
                            }
                        }
                    }
                }
                if (!TextUtils.isEmpty(responseGetPayinfoMessage.getErrorString())) {
                    this.f56898a.f56889e.showToast(responseGetPayinfoMessage.getErrorString());
                } else {
                    this.f56898a.f56889e.showToast(R.string.neterror);
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
        this.f56891g = new LinkedList();
        this.f56892h = new LinkedList();
        this.f56889e = buyTBeanActivity;
        this.f56890f = eVar;
    }

    public final void A(c.a.p0.k3.f.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null || aVar.getUserInfo() == null || ListUtils.isEmpty(aVar.getIconInfoList())) {
            return;
        }
        List<c.a.p0.k3.e.b> list = this.f56891g;
        if (list != null) {
            list.clear();
        }
        List<c.a.p0.k3.e.a> list2 = this.f56892h;
        if (list2 != null) {
            list2.clear();
        }
        ArrayList<c.a.p0.k3.e.a> arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (!ListUtils.isEmpty(aVar.getCustomList())) {
            for (Custom custom : aVar.getCustomList()) {
                if (custom.is_custom_price.intValue() == 1) {
                    c.a.p0.k3.e.c cVar = new c.a.p0.k3.e.c();
                    cVar.f21226e = custom;
                    arrayList2.add(cVar);
                } else if (custom.is_custom_price.intValue() == 0) {
                    c.a.p0.k3.e.a aVar2 = new c.a.p0.k3.e.a();
                    aVar2.f21220e = custom;
                    arrayList.add(aVar2);
                }
            }
        }
        if (!ListUtils.isEmpty(arrayList)) {
            for (c.a.p0.k3.e.a aVar3 : arrayList) {
                aVar3.f21221f = aVar.getSetting();
                this.f56892h.add(aVar3);
            }
        }
        if (!ListUtils.isEmpty(aVar.getIconInfoList())) {
            for (IconInfo iconInfo : aVar.getIconInfoList()) {
                c.a.p0.k3.e.b bVar = new c.a.p0.k3.e.b();
                bVar.f21224f = iconInfo;
                aVar.getUserInfo();
                bVar.f21223e = aVar.getSetting();
                this.f56891g.add(bVar);
            }
        }
        if (ListUtils.isEmpty(arrayList2)) {
            return;
        }
        c.a.p0.k3.e.c cVar2 = (c.a.p0.k3.e.c) ListUtils.getItem(arrayList2, 0);
        this.f56893i = cVar2;
        cVar2.f21228g = aVar.getSetting();
        this.f56893i.f21227f = aVar.getUserInfo();
    }

    public List<c.a.p0.k3.e.b> B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f56891g : (List) invokeV.objValue;
    }

    public List<c.a.p0.k3.e.a> C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f56892h : (List) invokeV.objValue;
    }

    public c.a.p0.k3.e.c D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f56893i : (c.a.p0.k3.e.c) invokeV.objValue;
    }

    public UserInfo E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f56894j : (UserInfo) invokeV.objValue;
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
