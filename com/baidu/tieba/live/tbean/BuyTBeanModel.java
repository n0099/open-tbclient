package com.baidu.tieba.live.tbean;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.widget.listview.IAdapterData;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.tieba.live.tbean.data.CustomData;
import com.baidu.tieba.live.tbean.data.GiftBagWrapperData;
import com.baidu.tieba.live.tbean.data.IconInfoData;
import com.baidu.tieba.live.tbean.data.IconInfoWrapperData;
import com.baidu.tieba.live.tbean.data.UserDefineTbeanWrapperData;
import com.baidu.tieba.live.tbean.data.UserInfoData;
import com.baidu.tieba.live.tbean.message.GetYinJiHttpResponseMessage;
import com.baidu.tieba.live.tbean.message.GetYinJiRequestMessage;
import com.baidu.tieba.live.tbean.message.IYinJiResponse;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class BuyTBeanModel extends BdBaseModel {
    public static final String GET_BIG_TBEAN_WALLET_H5 = "tbmall/getPayUrl";
    public static final String GET_ICON_URL = "tbmall/pay/geticonlist";
    public static final int SUPER_MEMBER = 2;
    private Activity activity;
    private BuyTBeanController buyTBeanController;
    private CallBack mCallBack;
    private List<IAdapterData> mCommodityList;
    private boolean mIsShowUserDifineTBeanItem;
    private UserDefineTbeanWrapperData mUserDefineTbeanWrapperData;
    private TbPageContext<?> tbPageContext;
    private UserInfoData userInfo;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface CallBack {
        void onFailed(String str);

        void onGetWalletUrl(String str);

        void onSuccess();
    }

    public BuyTBeanModel(TbPageContext<?> tbPageContext, BuyTBeanController buyTBeanController, CallBack callBack) {
        super(tbPageContext);
        this.mCommodityList = new ArrayList();
        this.tbPageContext = tbPageContext;
        this.buyTBeanController = buyTBeanController;
        this.activity = tbPageContext.getPageActivity();
        this.mCallBack = callBack;
    }

    public UserInfoData getUserInfo() {
        return this.userInfo;
    }

    public void requestYinJiInfo() {
        GetYinJiRequestMessage getYinJiRequestMessage = new GetYinJiRequestMessage();
        getYinJiRequestMessage.setParams();
        sendMessage(getYinJiRequestMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dealResonseData(IYinJiResponse iYinJiResponse) {
        if (iYinJiResponse != null && iYinJiResponse.getUserInfo() != null && !ListUtils.isEmpty(iYinJiResponse.getIconInfoList())) {
            if (this.mCommodityList != null) {
                this.mCommodityList.clear();
            }
            ArrayList<GiftBagWrapperData> arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (!ListUtils.isEmpty(iYinJiResponse.getCustomList())) {
                for (CustomData customData : iYinJiResponse.getCustomList()) {
                    if (customData.is_custom_price == 1) {
                        this.mIsShowUserDifineTBeanItem = true;
                        UserDefineTbeanWrapperData userDefineTbeanWrapperData = new UserDefineTbeanWrapperData();
                        userDefineTbeanWrapperData.mData = customData;
                        arrayList2.add(userDefineTbeanWrapperData);
                    } else if (customData.is_custom_price == 0) {
                        GiftBagWrapperData giftBagWrapperData = new GiftBagWrapperData();
                        giftBagWrapperData.mData = customData;
                        arrayList.add(giftBagWrapperData);
                    }
                }
            }
            if (!ListUtils.isEmpty(arrayList)) {
                for (GiftBagWrapperData giftBagWrapperData2 : arrayList) {
                    giftBagWrapperData2.mSetting = iYinJiResponse.getSetting();
                    this.mCommodityList.add(giftBagWrapperData2);
                }
            }
            if (!ListUtils.isEmpty(iYinJiResponse.getIconInfoList())) {
                for (IconInfoData iconInfoData : iYinJiResponse.getIconInfoList()) {
                    IconInfoWrapperData iconInfoWrapperData = new IconInfoWrapperData();
                    iconInfoWrapperData.info = iconInfoData;
                    iconInfoWrapperData.userInfo = iYinJiResponse.getUserInfo();
                    iconInfoWrapperData.mSetting = iYinJiResponse.getSetting();
                    this.mCommodityList.add(iconInfoWrapperData);
                }
            }
            if (!ListUtils.isEmpty(arrayList2)) {
                this.mUserDefineTbeanWrapperData = (UserDefineTbeanWrapperData) ListUtils.getItem(arrayList2, 0);
                this.mUserDefineTbeanWrapperData.mSetting = iYinJiResponse.getSetting();
                this.mUserDefineTbeanWrapperData.userInfo = iYinJiResponse.getUserInfo();
            }
        }
    }

    public void registerYinJiHttpListener() {
        HttpMessageListener httpMessageListener = new HttpMessageListener(1001533) { // from class: com.baidu.tieba.live.tbean.BuyTBeanModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || !(httpResponsedMessage instanceof GetYinJiHttpResponseMessage)) {
                    BuyTBeanModel.this.mCallBack.onFailed(BuyTBeanModel.this.activity.getString(a.i.sdk_neterror));
                    return;
                }
                GetYinJiHttpResponseMessage getYinJiHttpResponseMessage = (GetYinJiHttpResponseMessage) httpResponsedMessage;
                if (getYinJiHttpResponseMessage.getError() != 0) {
                    if (!TextUtils.isEmpty(getYinJiHttpResponseMessage.getErrorString())) {
                        BuyTBeanModel.this.mCallBack.onFailed(getYinJiHttpResponseMessage.getErrorString());
                    } else {
                        BuyTBeanModel.this.mCallBack.onFailed(BuyTBeanModel.this.activity.getString(a.i.sdk_neterror));
                    }
                    if (BuyTBeanModel.this.buyTBeanController != null && getYinJiHttpResponseMessage.getError() == 1990055) {
                        BuyTBeanModel.this.buyTBeanController.finish();
                        return;
                    }
                    return;
                }
                BuyTBeanModel.this.userInfo = getYinJiHttpResponseMessage.getUserInfo();
                BuyTBeanModel.this.dealResonseData(getYinJiHttpResponseMessage);
                if (getYinJiHttpResponseMessage.getUserInfo() == null || ListUtils.isEmpty(getYinJiHttpResponseMessage.getIconInfoList())) {
                    BuyTBeanModel.this.mCallBack.onFailed(BuyTBeanModel.this.activity.getString(a.i.sdk_tbn_no_data_tip));
                } else {
                    BuyTBeanModel.this.mCallBack.onSuccess();
                }
            }
        };
        httpMessageListener.setSelfListener(true);
        registerListener(httpMessageListener);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public List<IAdapterData> getCommodityList() {
        return this.mCommodityList;
    }

    public boolean isShowUserDifineTBeanItem() {
        return this.mIsShowUserDifineTBeanItem;
    }

    public UserDefineTbeanWrapperData getUserDefineTbeanWrapperData() {
        return this.mUserDefineTbeanWrapperData;
    }
}
