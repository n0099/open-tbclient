package com.baidu.tieba.personExtra;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class e implements com.baidu.tieba.personPolymeric.b.b {
    private com.baidu.tieba.post.a.a iol;
    private BdUniqueId mId;
    private TbPageContext mTbPageContext;
    private int mStatus = 0;
    private HttpMessageListener mHttpMessageListener = new HttpMessageListener(CmdConfigHttp.SET_PRIVATE_CMD) { // from class: com.baidu.tieba.personExtra.e.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getOrginalMessage().getTag() == e.this.mId) {
                if (!httpResponsedMessage.isSuccess() || httpResponsedMessage.getError() != 0) {
                    if (e.this.mTbPageContext != null && !StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                        e.this.mTbPageContext.showToast(httpResponsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                if (e.this.mTbPageContext != null) {
                    e.this.mTbPageContext.showToast(R.string.privacy_setting_toast);
                }
                e.this.mStatus = 1;
                e.this.iol.startPullRefresh();
            }
        }
    };

    public e(TbPageContext tbPageContext, com.baidu.tieba.post.a.a aVar, BdUniqueId bdUniqueId) {
        this.mTbPageContext = tbPageContext;
        this.iol = aVar;
        this.mId = bdUniqueId;
        CustomMessageListener customMessageListener = new CustomMessageListener(2921065) { // from class: com.baidu.tieba.personExtra.e.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int intValue;
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921065 && customResponsedMessage.getData() != null && e.this.mStatus != (intValue = ((Integer) customResponsedMessage.getData()).intValue())) {
                    e.this.mStatus = intValue;
                    switch (intValue) {
                        case 0:
                        default:
                            return;
                        case 1:
                            e.this.iol.startPullRefresh();
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
    public void ccw() {
        if (!com.baidu.adp.lib.util.j.kc()) {
            if (this.mTbPageContext != null) {
                this.mTbPageContext.showToast(R.string.neterror);
                return;
            }
            return;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
        httpMessage.addParam("opt", "post");
        httpMessage.addParam("val", String.valueOf(1));
        httpMessage.setTag(this.mId);
        MessageManager.getInstance().sendMessage(httpMessage);
        TiebaStatic.log(new an("c12515").P("obj_locate", 1));
    }
}
