package com.baidu.tieba.tbean;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
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
import com.repackage.b9;
import com.repackage.fm8;
import com.repackage.hm8;
import com.repackage.im8;
import com.repackage.jm8;
import com.repackage.km8;
import com.repackage.rj8;
import com.repackage.ya;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import tbclient.GetIconList.Custom;
import tbclient.GetIconList.IconInfo;
import tbclient.GetIconList.UserInfo;
/* loaded from: classes4.dex */
public class BuyTBeanModel extends BdBaseModel<BuyTBeanActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String GET_BIG_TBEAN_WALLET_H5 = "tbmall/getPayUrl";
    public static final String GET_ICON_URL = "c/e/pay/geticonlist";
    public static final int SUPER_MEMBER = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public BuyTBeanActivity a;
    public e b;
    public List<im8> c;
    public List<hm8> d;
    public jm8 e;
    public UserInfo f;

    /* loaded from: classes4.dex */
    public class a extends ya {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BuyTBeanModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(BuyTBeanModel buyTBeanModel, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {buyTBeanModel, Integer.valueOf(i)};
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
            this.a = buyTBeanModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) {
                if (socketResponsedMessage == null || !(socketResponsedMessage instanceof GetYinJiResponseMessage)) {
                    this.a.b.onFailed(this.a.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0c2d));
                    return;
                }
                GetYinJiResponseMessage getYinJiResponseMessage = (GetYinJiResponseMessage) socketResponsedMessage;
                if (getYinJiResponseMessage.getError() != 0) {
                    if (!TextUtils.isEmpty(getYinJiResponseMessage.getErrorString())) {
                        this.a.b.onFailed(getYinJiResponseMessage.getErrorString());
                    } else {
                        this.a.b.onFailed(this.a.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0c2d));
                    }
                    if (this.a.a == null || getYinJiResponseMessage.getError() != 1990055) {
                        return;
                    }
                    this.a.a.finish();
                    return;
                }
                this.a.f = getYinJiResponseMessage.getUserInfo();
                this.a.C(getYinJiResponseMessage);
                if (getYinJiResponseMessage.getUserInfo() == null || ListUtils.isEmpty(getYinJiResponseMessage.getIconInfoList())) {
                    this.a.b.onFailed(this.a.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0c46));
                } else {
                    this.a.b.onSuccess();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BuyTBeanModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(BuyTBeanModel buyTBeanModel, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {buyTBeanModel, Integer.valueOf(i)};
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
            this.a = buyTBeanModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && (httpResponsedMessage instanceof GetBigTbeanWalletH5ResponseMessage)) {
                GetBigTbeanWalletH5ResponseMessage getBigTbeanWalletH5ResponseMessage = (GetBigTbeanWalletH5ResponseMessage) httpResponsedMessage;
                if (getBigTbeanWalletH5ResponseMessage.getError() == 0 && this.a.b != null) {
                    this.a.b.onGetWalletUrl(getBigTbeanWalletH5ResponseMessage.url);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BuyTBeanModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(BuyTBeanModel buyTBeanModel, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {buyTBeanModel, Integer.valueOf(i)};
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
            this.a = buyTBeanModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                if (httpResponsedMessage == null || !(httpResponsedMessage instanceof GetYinJiHttpResponseMessage)) {
                    this.a.b.onFailed(this.a.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0c2d));
                    return;
                }
                GetYinJiHttpResponseMessage getYinJiHttpResponseMessage = (GetYinJiHttpResponseMessage) httpResponsedMessage;
                if (getYinJiHttpResponseMessage.getError() != 0) {
                    if (!TextUtils.isEmpty(getYinJiHttpResponseMessage.getErrorString())) {
                        this.a.b.onFailed(getYinJiHttpResponseMessage.getErrorString());
                    } else {
                        this.a.b.onFailed(this.a.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0c2d));
                    }
                    if (this.a.a == null || getYinJiHttpResponseMessage.getError() != 1990055) {
                        return;
                    }
                    this.a.a.finish();
                    return;
                }
                this.a.f = getYinJiHttpResponseMessage.getUserInfo();
                this.a.C(getYinJiHttpResponseMessage);
                if (getYinJiHttpResponseMessage.getUserInfo() == null || ListUtils.isEmpty(getYinJiHttpResponseMessage.getIconInfoList())) {
                    this.a.b.onFailed(this.a.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0c46));
                } else {
                    this.a.b.onSuccess();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BuyTBeanModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(BuyTBeanModel buyTBeanModel, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {buyTBeanModel, Integer.valueOf(i)};
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
            this.a = buyTBeanModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                if (httpResponsedMessage == null || !(httpResponsedMessage instanceof ResponseGetPayinfoMessage) || httpResponsedMessage.getCmd() != 1001505) {
                    if (this.a.a != null) {
                        this.a.a.showToast(R.string.obfuscated_res_0x7f0f0c2d);
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
                        if (this.a.a != null) {
                            this.a.a.showToast(R.string.obfuscated_res_0x7f0f0359);
                            return;
                        }
                    } else {
                        int pay_status = responseGetPayinfoMessage.getPayInfoResultData().getPay_status();
                        if (pay_status != 0) {
                            if (this.a.a != null) {
                                this.a.a.showToast(R.string.obfuscated_res_0x7f0f0359);
                                return;
                            }
                        } else {
                            fm8.a("c10297");
                            String str = httpMessage.getExtra() instanceof String ? (String) httpMessage.getExtra() : "";
                            rj8 rj8Var = new rj8();
                            rj8Var.d(str);
                            rj8Var.c(pay_status);
                            rj8Var.b(this.a.a.isFromDecreaseGiftStepStrategy());
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001227, rj8Var));
                            if (this.a.a != null) {
                                this.a.a.finish();
                                return;
                            }
                        }
                    }
                }
                if (!TextUtils.isEmpty(responseGetPayinfoMessage.getErrorString())) {
                    this.a.a.showToast(responseGetPayinfoMessage.getErrorString());
                } else {
                    this.a.a.showToast(R.string.obfuscated_res_0x7f0f0c2d);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((b9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = new LinkedList();
        this.d = new LinkedList();
        this.a = buyTBeanActivity;
        this.b = eVar;
    }

    public final void C(km8 km8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, km8Var) == null) || km8Var == null || km8Var.getUserInfo() == null || ListUtils.isEmpty(km8Var.getIconInfoList())) {
            return;
        }
        List<im8> list = this.c;
        if (list != null) {
            list.clear();
        }
        List<hm8> list2 = this.d;
        if (list2 != null) {
            list2.clear();
        }
        ArrayList<hm8> arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (!ListUtils.isEmpty(km8Var.getCustomList())) {
            for (Custom custom : km8Var.getCustomList()) {
                if (custom.is_custom_price.intValue() == 1) {
                    jm8 jm8Var = new jm8();
                    jm8Var.a = custom;
                    arrayList2.add(jm8Var);
                } else if (custom.is_custom_price.intValue() == 0) {
                    hm8 hm8Var = new hm8();
                    hm8Var.a = custom;
                    arrayList.add(hm8Var);
                }
            }
        }
        if (!ListUtils.isEmpty(arrayList)) {
            for (hm8 hm8Var2 : arrayList) {
                hm8Var2.b = km8Var.getSetting();
                this.d.add(hm8Var2);
            }
        }
        if (!ListUtils.isEmpty(km8Var.getIconInfoList())) {
            for (IconInfo iconInfo : km8Var.getIconInfoList()) {
                im8 im8Var = new im8();
                im8Var.b = iconInfo;
                km8Var.getUserInfo();
                im8Var.a = km8Var.getSetting();
                this.c.add(im8Var);
            }
        }
        if (ListUtils.isEmpty(arrayList2)) {
            return;
        }
        jm8 jm8Var2 = (jm8) ListUtils.getItem(arrayList2, 0);
        this.e = jm8Var2;
        jm8Var2.c = km8Var.getSetting();
        this.e.b = km8Var.getUserInfo();
    }

    public List<im8> D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.c : (List) invokeV.objValue;
    }

    public List<hm8> E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.d : (List) invokeV.objValue;
    }

    public jm8 F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.e : (jm8) invokeV.objValue;
    }

    public UserInfo G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f : (UserInfo) invokeV.objValue;
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            registerListener(new b(this, CmdConfigHttp.CMD_HTTP_GET_BIG_TBEAN_URL));
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            registerListener(new d(this, CmdConfigHttp.GETPAYINFO_CMD));
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            c cVar = new c(this, CmdConfigHttp.CMD_HTTP_GET_YINJI);
            cVar.setSelfListener(true);
            registerListener(cVar);
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            a aVar = new a(this, 306001);
            aVar.setSelfListener(true);
            registerListener(aVar);
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            sendMessage(new GetYinJiRequestMessage());
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }
}
