package com.baidu.tieba.tbean;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.pay.ResponseGetPayinfoMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.live.tbean.TbeanStatisticKey;
import com.baidu.tieba.tbadkCore.data.g;
import com.baidu.tieba.tbean.message.GetBigTbeanWalletH5ResponseMessage;
import com.baidu.tieba.tbean.message.GetYinJiHttpResponseMessage;
import com.baidu.tieba.tbean.message.GetYinJiRequestMessage;
import com.baidu.tieba.tbean.message.GetYinJiResponseMessage;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import tbclient.GetIconList.Custom;
import tbclient.GetIconList.IconInfo;
import tbclient.GetIconList.UserInfo;
/* loaded from: classes9.dex */
public class BuyTBeanModel extends BdBaseModel<BuyTBeanActivity> {
    public static final String GET_BIG_TBEAN_WALLET_H5 = "tbmall/getPayUrl";
    public static final String GET_ICON_URL = "c/e/pay/geticonlist";
    public static final int SUPER_MEMBER = 2;
    private boolean mIsShowUserDifineTBeanItem;
    private BuyTBeanActivity nCg;
    private a nCh;
    private List<com.baidu.tieba.tbean.b.b> nCi;
    private List<com.baidu.tieba.tbean.b.a> nCj;
    private com.baidu.tieba.tbean.b.c nCk;
    private UserInfo userInfo;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public interface a {
        void onFailed(String str);

        void onGetWalletUrl(String str);

        void onSuccess();
    }

    public BuyTBeanModel(BuyTBeanActivity buyTBeanActivity, a aVar) {
        super(buyTBeanActivity.getPageContext());
        this.nCi = new LinkedList();
        this.nCj = new LinkedList();
        this.nCg = buyTBeanActivity;
        this.nCh = aVar;
    }

    public UserInfo getUserInfo() {
        return this.userInfo;
    }

    public void requestYinJiInfo() {
        sendMessage(new GetYinJiRequestMessage());
    }

    public void dPM() {
        com.baidu.adp.framework.listener.c cVar = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_GET_YINJI) { // from class: com.baidu.tieba.tbean.BuyTBeanModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage == null || !(socketResponsedMessage instanceof GetYinJiResponseMessage)) {
                    BuyTBeanModel.this.nCh.onFailed(BuyTBeanModel.this.nCg.getPageContext().getString(R.string.neterror));
                    return;
                }
                GetYinJiResponseMessage getYinJiResponseMessage = (GetYinJiResponseMessage) socketResponsedMessage;
                if (getYinJiResponseMessage.getError() != 0) {
                    if (!TextUtils.isEmpty(getYinJiResponseMessage.getErrorString())) {
                        BuyTBeanModel.this.nCh.onFailed(getYinJiResponseMessage.getErrorString());
                    } else {
                        BuyTBeanModel.this.nCh.onFailed(BuyTBeanModel.this.nCg.getPageContext().getString(R.string.neterror));
                    }
                    if (BuyTBeanModel.this.nCg != null && getYinJiResponseMessage.getError() == 1990055) {
                        BuyTBeanModel.this.nCg.finish();
                        return;
                    }
                    return;
                }
                BuyTBeanModel.this.userInfo = getYinJiResponseMessage.getUserInfo();
                BuyTBeanModel.this.a(getYinJiResponseMessage);
                if (getYinJiResponseMessage.getUserInfo() == null || y.isEmpty(getYinJiResponseMessage.getIconInfoList())) {
                    BuyTBeanModel.this.nCh.onFailed(BuyTBeanModel.this.nCg.getPageContext().getString(R.string.no_data_tip));
                } else {
                    BuyTBeanModel.this.nCh.onSuccess();
                }
            }
        };
        cVar.setSelfListener(true);
        registerListener(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbean.message.a aVar) {
        if (aVar != null && aVar.getUserInfo() != null && !y.isEmpty(aVar.getIconInfoList())) {
            if (this.nCi != null) {
                this.nCi.clear();
            }
            if (this.nCj != null) {
                this.nCj.clear();
            }
            ArrayList<com.baidu.tieba.tbean.b.a> arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (!y.isEmpty(aVar.getCustomList())) {
                for (Custom custom : aVar.getCustomList()) {
                    if (custom.is_custom_price.intValue() == 1) {
                        this.mIsShowUserDifineTBeanItem = true;
                        com.baidu.tieba.tbean.b.c cVar = new com.baidu.tieba.tbean.b.c();
                        cVar.nCQ = custom;
                        arrayList2.add(cVar);
                    } else if (custom.is_custom_price.intValue() == 0) {
                        com.baidu.tieba.tbean.b.a aVar2 = new com.baidu.tieba.tbean.b.a();
                        aVar2.nCQ = custom;
                        arrayList.add(aVar2);
                    }
                }
            }
            if (!y.isEmpty(arrayList)) {
                for (com.baidu.tieba.tbean.b.a aVar3 : arrayList) {
                    aVar3.nCR = aVar.getSetting();
                    this.nCj.add(aVar3);
                }
            }
            if (!y.isEmpty(aVar.getIconInfoList())) {
                for (IconInfo iconInfo : aVar.getIconInfoList()) {
                    com.baidu.tieba.tbean.b.b bVar = new com.baidu.tieba.tbean.b.b();
                    bVar.nCS = iconInfo;
                    bVar.userInfo = aVar.getUserInfo();
                    bVar.nCR = aVar.getSetting();
                    this.nCi.add(bVar);
                }
            }
            if (!y.isEmpty(arrayList2)) {
                this.nCk = (com.baidu.tieba.tbean.b.c) y.getItem(arrayList2, 0);
                this.nCk.nCR = aVar.getSetting();
                this.nCk.userInfo = aVar.getUserInfo();
            }
        }
    }

    public void dPN() {
        registerListener(new HttpMessageListener(1003410) { // from class: com.baidu.tieba.tbean.BuyTBeanModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetBigTbeanWalletH5ResponseMessage)) {
                    GetBigTbeanWalletH5ResponseMessage getBigTbeanWalletH5ResponseMessage = (GetBigTbeanWalletH5ResponseMessage) httpResponsedMessage;
                    if (getBigTbeanWalletH5ResponseMessage.getError() == 0 && BuyTBeanModel.this.nCh != null) {
                        BuyTBeanModel.this.nCh.onGetWalletUrl(getBigTbeanWalletH5ResponseMessage.url);
                    }
                }
            }
        });
    }

    public void registerYinJiHttpListener() {
        HttpMessageListener httpMessageListener = new HttpMessageListener(1001533) { // from class: com.baidu.tieba.tbean.BuyTBeanModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || !(httpResponsedMessage instanceof GetYinJiHttpResponseMessage)) {
                    BuyTBeanModel.this.nCh.onFailed(BuyTBeanModel.this.nCg.getPageContext().getString(R.string.neterror));
                    return;
                }
                GetYinJiHttpResponseMessage getYinJiHttpResponseMessage = (GetYinJiHttpResponseMessage) httpResponsedMessage;
                if (getYinJiHttpResponseMessage.getError() != 0) {
                    if (!TextUtils.isEmpty(getYinJiHttpResponseMessage.getErrorString())) {
                        BuyTBeanModel.this.nCh.onFailed(getYinJiHttpResponseMessage.getErrorString());
                    } else {
                        BuyTBeanModel.this.nCh.onFailed(BuyTBeanModel.this.nCg.getPageContext().getString(R.string.neterror));
                    }
                    if (BuyTBeanModel.this.nCg != null && getYinJiHttpResponseMessage.getError() == 1990055) {
                        BuyTBeanModel.this.nCg.finish();
                        return;
                    }
                    return;
                }
                BuyTBeanModel.this.userInfo = getYinJiHttpResponseMessage.getUserInfo();
                BuyTBeanModel.this.a(getYinJiHttpResponseMessage);
                if (getYinJiHttpResponseMessage.getUserInfo() == null || y.isEmpty(getYinJiHttpResponseMessage.getIconInfoList())) {
                    BuyTBeanModel.this.nCh.onFailed(BuyTBeanModel.this.nCg.getPageContext().getString(R.string.no_data_tip));
                } else {
                    BuyTBeanModel.this.nCh.onSuccess();
                }
            }
        };
        httpMessageListener.setSelfListener(true);
        registerListener(httpMessageListener);
    }

    public void dPO() {
        registerListener(new HttpMessageListener(1001505) { // from class: com.baidu.tieba.tbean.BuyTBeanModel.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                String str;
                if (httpResponsedMessage == null || !(httpResponsedMessage instanceof ResponseGetPayinfoMessage) || httpResponsedMessage.getCmd() != 1001505) {
                    if (BuyTBeanModel.this.nCg != null) {
                        BuyTBeanModel.this.nCg.showToast(R.string.neterror);
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
                        if (BuyTBeanModel.this.nCg != null) {
                            BuyTBeanModel.this.nCg.showToast(R.string.buy_tbean_failed_tip);
                            return;
                        }
                    } else {
                        int pay_status = responseGetPayinfoMessage.getPayInfoResultData().getPay_status();
                        if (pay_status != 0) {
                            if (BuyTBeanModel.this.nCg != null) {
                                BuyTBeanModel.this.nCg.showToast(R.string.buy_tbean_failed_tip);
                                return;
                            }
                        } else {
                            c.Pf(TbeanStatisticKey.BUY_TBEAN_SUCCESS);
                            if (!(httpMessage.getExtra() instanceof String)) {
                                str = "";
                            } else {
                                str = (String) httpMessage.getExtra();
                            }
                            g gVar = new g();
                            gVar.setTBeanNum(str);
                            gVar.setStatus(pay_status);
                            gVar.setFromDecreaseGiftStepStrategy(BuyTBeanModel.this.nCg.isFromDecreaseGiftStepStrategy());
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_BUY_YINJI_SUCCESS, gVar));
                            if (BuyTBeanModel.this.nCg != null) {
                                BuyTBeanModel.this.nCg.finish();
                                return;
                            }
                        }
                    }
                }
                if (!TextUtils.isEmpty(responseGetPayinfoMessage.getErrorString())) {
                    BuyTBeanModel.this.nCg.showToast(responseGetPayinfoMessage.getErrorString());
                } else {
                    BuyTBeanModel.this.nCg.showToast(R.string.neterror);
                }
            }
        });
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public List<com.baidu.tieba.tbean.b.b> dPP() {
        return this.nCi;
    }

    public List<com.baidu.tieba.tbean.b.a> dPQ() {
        return this.nCj;
    }

    public com.baidu.tieba.tbean.b.c dPR() {
        return this.nCk;
    }
}
