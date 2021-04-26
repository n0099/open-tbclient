package com.baidu.tieba.tbean;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.pay.ResponseGetPayinfoMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.tbean.message.GetBigTbeanWalletH5ResponseMessage;
import com.baidu.tieba.tbean.message.GetYinJiHttpResponseMessage;
import com.baidu.tieba.tbean.message.GetYinJiRequestMessage;
import com.baidu.tieba.tbean.message.GetYinJiResponseMessage;
import d.a.j0.d3.h0.g;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import tbclient.GetIconList.Custom;
import tbclient.GetIconList.IconInfo;
import tbclient.GetIconList.UserInfo;
/* loaded from: classes5.dex */
public class BuyTBeanModel extends BdBaseModel<BuyTBeanActivity> {
    public static final String GET_BIG_TBEAN_WALLET_H5 = "tbmall/getPayUrl";
    public static final String GET_ICON_URL = "c/e/pay/geticonlist";
    public static final int SUPER_MEMBER = 2;

    /* renamed from: e  reason: collision with root package name */
    public BuyTBeanActivity f21746e;

    /* renamed from: f  reason: collision with root package name */
    public e f21747f;

    /* renamed from: g  reason: collision with root package name */
    public List<d.a.j0.f3.e.b> f21748g;

    /* renamed from: h  reason: collision with root package name */
    public List<d.a.j0.f3.e.a> f21749h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.j0.f3.e.c f21750i;
    public UserInfo j;

    /* loaded from: classes5.dex */
    public class a extends d.a.c.c.g.c {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage == null || !(socketResponsedMessage instanceof GetYinJiResponseMessage)) {
                BuyTBeanModel.this.f21747f.onFailed(BuyTBeanModel.this.f21746e.getPageContext().getString(R.string.neterror));
                return;
            }
            GetYinJiResponseMessage getYinJiResponseMessage = (GetYinJiResponseMessage) socketResponsedMessage;
            if (getYinJiResponseMessage.getError() != 0) {
                if (!TextUtils.isEmpty(getYinJiResponseMessage.getErrorString())) {
                    BuyTBeanModel.this.f21747f.onFailed(getYinJiResponseMessage.getErrorString());
                } else {
                    BuyTBeanModel.this.f21747f.onFailed(BuyTBeanModel.this.f21746e.getPageContext().getString(R.string.neterror));
                }
                if (BuyTBeanModel.this.f21746e == null || getYinJiResponseMessage.getError() != 1990055) {
                    return;
                }
                BuyTBeanModel.this.f21746e.finish();
                return;
            }
            BuyTBeanModel.this.j = getYinJiResponseMessage.getUserInfo();
            BuyTBeanModel.this.w(getYinJiResponseMessage);
            if (getYinJiResponseMessage.getUserInfo() == null || ListUtils.isEmpty(getYinJiResponseMessage.getIconInfoList())) {
                BuyTBeanModel.this.f21747f.onFailed(BuyTBeanModel.this.f21746e.getPageContext().getString(R.string.no_data_tip));
            } else {
                BuyTBeanModel.this.f21747f.onSuccess();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends HttpMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || !(httpResponsedMessage instanceof GetBigTbeanWalletH5ResponseMessage)) {
                return;
            }
            GetBigTbeanWalletH5ResponseMessage getBigTbeanWalletH5ResponseMessage = (GetBigTbeanWalletH5ResponseMessage) httpResponsedMessage;
            if (getBigTbeanWalletH5ResponseMessage.getError() == 0 && BuyTBeanModel.this.f21747f != null) {
                BuyTBeanModel.this.f21747f.onGetWalletUrl(getBigTbeanWalletH5ResponseMessage.url);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends HttpMessageListener {
        public c(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || !(httpResponsedMessage instanceof GetYinJiHttpResponseMessage)) {
                BuyTBeanModel.this.f21747f.onFailed(BuyTBeanModel.this.f21746e.getPageContext().getString(R.string.neterror));
                return;
            }
            GetYinJiHttpResponseMessage getYinJiHttpResponseMessage = (GetYinJiHttpResponseMessage) httpResponsedMessage;
            if (getYinJiHttpResponseMessage.getError() != 0) {
                if (!TextUtils.isEmpty(getYinJiHttpResponseMessage.getErrorString())) {
                    BuyTBeanModel.this.f21747f.onFailed(getYinJiHttpResponseMessage.getErrorString());
                } else {
                    BuyTBeanModel.this.f21747f.onFailed(BuyTBeanModel.this.f21746e.getPageContext().getString(R.string.neterror));
                }
                if (BuyTBeanModel.this.f21746e == null || getYinJiHttpResponseMessage.getError() != 1990055) {
                    return;
                }
                BuyTBeanModel.this.f21746e.finish();
                return;
            }
            BuyTBeanModel.this.j = getYinJiHttpResponseMessage.getUserInfo();
            BuyTBeanModel.this.w(getYinJiHttpResponseMessage);
            if (getYinJiHttpResponseMessage.getUserInfo() == null || ListUtils.isEmpty(getYinJiHttpResponseMessage.getIconInfoList())) {
                BuyTBeanModel.this.f21747f.onFailed(BuyTBeanModel.this.f21746e.getPageContext().getString(R.string.no_data_tip));
            } else {
                BuyTBeanModel.this.f21747f.onSuccess();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends HttpMessageListener {
        public d(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || !(httpResponsedMessage instanceof ResponseGetPayinfoMessage) || httpResponsedMessage.getCmd() != 1001505) {
                if (BuyTBeanModel.this.f21746e != null) {
                    BuyTBeanModel.this.f21746e.showToast(R.string.neterror);
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
                    if (BuyTBeanModel.this.f21746e != null) {
                        BuyTBeanModel.this.f21746e.showToast(R.string.buy_tbean_failed_tip);
                        return;
                    }
                } else {
                    int pay_status = responseGetPayinfoMessage.getPayInfoResultData().getPay_status();
                    if (pay_status != 0) {
                        if (BuyTBeanModel.this.f21746e != null) {
                            BuyTBeanModel.this.f21746e.showToast(R.string.buy_tbean_failed_tip);
                            return;
                        }
                    } else {
                        d.a.j0.f3.c.a("c10297");
                        String str = httpMessage.getExtra() instanceof String ? (String) httpMessage.getExtra() : "";
                        g gVar = new g();
                        gVar.d(str);
                        gVar.c(pay_status);
                        gVar.b(BuyTBeanModel.this.f21746e.isFromDecreaseGiftStepStrategy());
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001227, gVar));
                        if (BuyTBeanModel.this.f21746e != null) {
                            BuyTBeanModel.this.f21746e.finish();
                            return;
                        }
                    }
                }
            }
            if (!TextUtils.isEmpty(responseGetPayinfoMessage.getErrorString())) {
                BuyTBeanModel.this.f21746e.showToast(responseGetPayinfoMessage.getErrorString());
            } else {
                BuyTBeanModel.this.f21746e.showToast(R.string.neterror);
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface e {
        void onFailed(String str);

        void onGetWalletUrl(String str);

        void onSuccess();
    }

    public BuyTBeanModel(BuyTBeanActivity buyTBeanActivity, e eVar) {
        super(buyTBeanActivity.getPageContext());
        this.f21748g = new LinkedList();
        this.f21749h = new LinkedList();
        this.f21746e = buyTBeanActivity;
        this.f21747f = eVar;
    }

    public UserInfo A() {
        return this.j;
    }

    public void B() {
        registerListener(new b(CmdConfigHttp.CMD_HTTP_GET_BIG_TBEAN_URL));
    }

    public void C() {
        registerListener(new d(CmdConfigHttp.GETPAYINFO_CMD));
    }

    public void D() {
        c cVar = new c(CmdConfigHttp.CMD_HTTP_GET_YINJI);
        cVar.setSelfListener(true);
        registerListener(cVar);
    }

    public void E() {
        a aVar = new a(306001);
        aVar.setSelfListener(true);
        registerListener(aVar);
    }

    public void F() {
        sendMessage(new GetYinJiRequestMessage());
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public final void w(d.a.j0.f3.f.a aVar) {
        if (aVar == null || aVar.getUserInfo() == null || ListUtils.isEmpty(aVar.getIconInfoList())) {
            return;
        }
        List<d.a.j0.f3.e.b> list = this.f21748g;
        if (list != null) {
            list.clear();
        }
        List<d.a.j0.f3.e.a> list2 = this.f21749h;
        if (list2 != null) {
            list2.clear();
        }
        ArrayList<d.a.j0.f3.e.a> arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (!ListUtils.isEmpty(aVar.getCustomList())) {
            for (Custom custom : aVar.getCustomList()) {
                if (custom.is_custom_price.intValue() == 1) {
                    d.a.j0.f3.e.c cVar = new d.a.j0.f3.e.c();
                    cVar.f54349e = custom;
                    arrayList2.add(cVar);
                } else if (custom.is_custom_price.intValue() == 0) {
                    d.a.j0.f3.e.a aVar2 = new d.a.j0.f3.e.a();
                    aVar2.f54343e = custom;
                    arrayList.add(aVar2);
                }
            }
        }
        if (!ListUtils.isEmpty(arrayList)) {
            for (d.a.j0.f3.e.a aVar3 : arrayList) {
                aVar3.f54344f = aVar.getSetting();
                this.f21749h.add(aVar3);
            }
        }
        if (!ListUtils.isEmpty(aVar.getIconInfoList())) {
            for (IconInfo iconInfo : aVar.getIconInfoList()) {
                d.a.j0.f3.e.b bVar = new d.a.j0.f3.e.b();
                bVar.f54347f = iconInfo;
                aVar.getUserInfo();
                bVar.f54346e = aVar.getSetting();
                this.f21748g.add(bVar);
            }
        }
        if (ListUtils.isEmpty(arrayList2)) {
            return;
        }
        d.a.j0.f3.e.c cVar2 = (d.a.j0.f3.e.c) ListUtils.getItem(arrayList2, 0);
        this.f21750i = cVar2;
        cVar2.f54351g = aVar.getSetting();
        this.f21750i.f54350f = aVar.getUserInfo();
    }

    public List<d.a.j0.f3.e.b> x() {
        return this.f21748g;
    }

    public List<d.a.j0.f3.e.a> y() {
        return this.f21749h;
    }

    public d.a.j0.f3.e.c z() {
        return this.f21750i;
    }
}
