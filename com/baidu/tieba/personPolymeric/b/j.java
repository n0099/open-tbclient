package com.baidu.tieba.personPolymeric.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ThreadPrivacyIntermediateActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.personPolymeric.a.o;
import java.util.List;
/* loaded from: classes.dex */
public class j implements b {
    private o fok;
    private BdUniqueId mId;
    private List<com.baidu.tieba.person.data.f> mList;
    private TbPageContext mTbPageContext;
    private int fol = 0;
    private int mStatus = 0;
    private HttpMessageListener mHttpMessageListener = new HttpMessageListener(CmdConfigHttp.SET_PRIVATE_CMD) { // from class: com.baidu.tieba.personPolymeric.b.j.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getOrginalMessage().getTag() == j.this.mId) {
                if (!httpResponsedMessage.isSuccess() || httpResponsedMessage.getError() != 0) {
                    if (j.this.mTbPageContext != null && !StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                        j.this.mTbPageContext.showToast(httpResponsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                if (j.this.aZT() && j.this.mTbPageContext != null) {
                    j.this.mTbPageContext.showToast(d.j.privacy_setting_toast);
                }
                j.this.mStatus = 1;
            }
        }
    };

    public j(TbPageContext tbPageContext, o oVar, BdUniqueId bdUniqueId) {
        this.mTbPageContext = tbPageContext;
        this.fok = oVar;
        this.mId = bdUniqueId;
        CustomMessageListener customMessageListener = new CustomMessageListener(CmdConfigCustom.CMD_PRIVACY_STATUS) { // from class: com.baidu.tieba.personPolymeric.b.j.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int intValue;
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921065 && customResponsedMessage.getData() != null && j.this.mStatus != (intValue = ((Integer) customResponsedMessage.getData()).intValue())) {
                    j.this.mStatus = intValue;
                    switch (intValue) {
                        case 0:
                        default:
                            return;
                        case 1:
                            j.this.aZT();
                            return;
                        case 2:
                        case 3:
                        case 4:
                            j.this.aZU();
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
    public void aZw() {
        if (!com.baidu.adp.lib.util.j.hh()) {
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
        TiebaStatic.log(new ak("c12515").r("obj_locate", 1));
    }

    @Override // com.baidu.tieba.personPolymeric.b.b
    public void aZx() {
        if (this.mTbPageContext != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ThreadPrivacyIntermediateActivityConfig(this.mTbPageContext.getContext())));
        }
        TiebaStatic.log(new ak("c12515").r("obj_locate", 2));
    }

    @Override // com.baidu.tieba.personPolymeric.b.b
    public void setData(int i) {
        this.fol = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aZT() {
        if (v.v(this.mList) || this.fok == null || this.fol >= this.mList.size()) {
            return false;
        }
        boolean z = false;
        for (com.baidu.tieba.person.data.f fVar : this.mList) {
            if ((fVar instanceof com.baidu.tieba.person.data.f) && fVar.aYj() != null && (fVar.aYj().get(0) instanceof com.baidu.tieba.personPolymeric.c.k)) {
                fVar.aYj().remove(0);
                z = true;
            }
        }
        if (z) {
            this.fok.c(this.mList, this.fol, false);
            return z;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZU() {
        if (!v.v(this.mList) && this.fok != null && this.fol < this.mList.size()) {
            boolean z = false;
            for (com.baidu.tieba.person.data.f fVar : this.mList) {
                if (fVar != null && fVar.aYj() != null && !(fVar.aYj().get(0) instanceof com.baidu.tieba.personPolymeric.c.k)) {
                    fVar.aYj().add(0, new com.baidu.tieba.personPolymeric.c.k());
                    z = true;
                }
            }
            if (z) {
                this.fok.c(this.mList, this.fol, true);
            }
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.b
    public void cE(List<com.baidu.tieba.person.data.f> list) {
        this.mList = list;
    }
}
