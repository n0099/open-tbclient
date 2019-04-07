package com.baidu.tieba.personExtra;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
/* loaded from: classes6.dex */
public class d implements com.baidu.tieba.personPolymeric.b.b {
    private com.baidu.tieba.post.a.a hPt;
    private BdUniqueId mId;
    private TbPageContext mTbPageContext;
    private int mStatus = 0;
    private HttpMessageListener mHttpMessageListener = new HttpMessageListener(CmdConfigHttp.SET_PRIVATE_CMD) { // from class: com.baidu.tieba.personExtra.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getOrginalMessage().getTag() == d.this.mId) {
                if (!httpResponsedMessage.isSuccess() || httpResponsedMessage.getError() != 0) {
                    if (d.this.mTbPageContext != null && !StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                        d.this.mTbPageContext.showToast(httpResponsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                if (d.this.mTbPageContext != null) {
                    d.this.mTbPageContext.showToast(d.j.privacy_setting_toast);
                }
                d.this.mStatus = 1;
                d.this.hPt.startPullRefresh();
            }
        }
    };

    public d(TbPageContext tbPageContext, com.baidu.tieba.post.a.a aVar, BdUniqueId bdUniqueId) {
        this.mTbPageContext = tbPageContext;
        this.hPt = aVar;
        this.mId = bdUniqueId;
        CustomMessageListener customMessageListener = new CustomMessageListener(2921065) { // from class: com.baidu.tieba.personExtra.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int intValue;
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921065 && customResponsedMessage.getData() != null && d.this.mStatus != (intValue = ((Integer) customResponsedMessage.getData()).intValue())) {
                    d.this.mStatus = intValue;
                    switch (intValue) {
                        case 0:
                        default:
                            return;
                        case 1:
                            d.this.hPt.startPullRefresh();
                            return;
                    }
                }
            }
        };
        this.mHttpMessageListener.setTag(this.mId);
        customMessageListener.setTag(this.mId);
        MessageManager.getInstance().registerListener(this.mHttpMessageListener);
        MessageManager.getInstance().registerListener(customMessageListener);
    }

    @Override // com.baidu.tieba.personPolymeric.b.b
    public void bRx() {
        if (!j.kY()) {
            if (this.mTbPageContext != null) {
                this.mTbPageContext.showToast(d.j.neterror);
                return;
            }
            return;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
        httpMessage.addParam("opt", "post");
        httpMessage.addParam("val", String.valueOf(1));
        httpMessage.setTag(this.mId);
        MessageManager.getInstance().sendMessage(httpMessage);
        TiebaStatic.log(new am("c12515").T("obj_locate", 1));
    }
}
