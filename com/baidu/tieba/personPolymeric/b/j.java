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
import com.baidu.tieba.personPolymeric.c.k;
import java.util.List;
/* loaded from: classes.dex */
public class j implements b {
    private o fgl;
    private BdUniqueId mId;
    private List<com.baidu.tieba.person.data.f> mList;
    private TbPageContext mTbPageContext;
    private int eZG = 0;
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
                if (j.this.aWU() && j.this.mTbPageContext != null) {
                    j.this.mTbPageContext.showToast(d.l.privacy_setting_toast);
                }
                j.this.mStatus = 1;
            }
        }
    };

    public j(TbPageContext tbPageContext, o oVar, BdUniqueId bdUniqueId) {
        this.mTbPageContext = tbPageContext;
        this.fgl = oVar;
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
                            j.this.aWU();
                            return;
                        case 2:
                        case 3:
                        case 4:
                            j.this.aWV();
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
    public void aWy() {
        if (!com.baidu.adp.lib.util.j.hh()) {
            if (this.mTbPageContext != null) {
                this.mTbPageContext.showToast(d.l.neterror);
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
    public void aWz() {
        if (this.mTbPageContext != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ThreadPrivacyIntermediateActivityConfig(this.mTbPageContext.getContext())));
        }
        TiebaStatic.log(new ak("c12515").r("obj_locate", 2));
    }

    @Override // com.baidu.tieba.personPolymeric.b.b
    public void setData(int i) {
        this.eZG = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aWU() {
        if (v.u(this.mList) || this.fgl == null || this.eZG >= this.mList.size()) {
            return false;
        }
        boolean z = false;
        for (com.baidu.tieba.person.data.f fVar : this.mList) {
            if ((fVar instanceof com.baidu.tieba.person.data.f) && fVar.aVl() != null && (fVar.aVl().get(0) instanceof k)) {
                fVar.aVl().remove(0);
                z = true;
            }
        }
        if (z) {
            this.fgl.c(this.mList, this.eZG, false);
            return z;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWV() {
        if (!v.u(this.mList) && this.fgl != null && this.eZG < this.mList.size()) {
            boolean z = false;
            for (com.baidu.tieba.person.data.f fVar : this.mList) {
                if (fVar != null && fVar.aVl() != null && !(fVar.aVl().get(0) instanceof k)) {
                    fVar.aVl().add(0, new k());
                    z = true;
                }
            }
            if (z) {
                this.fgl.c(this.mList, this.eZG, true);
            }
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.b
    public void cD(List<com.baidu.tieba.person.data.f> list) {
        this.mList = list;
    }
}
