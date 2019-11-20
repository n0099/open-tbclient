package com.baidu.tieba.personExtra;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes6.dex */
public class i {
    private a ipj;
    private boolean isLoading = false;
    private com.baidu.adp.framework.listener.a bRo = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_HISTORY_SWAN, 309638) { // from class: com.baidu.tieba.personExtra.i.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            i.this.isLoading = false;
            if (responsedMessage == null || responsedMessage.getError() != 0) {
                i.this.b(false, null);
            } else if (responsedMessage instanceof SmartAppBrowseHistorySocketResponsedMessage) {
                i.this.b(true, ((SmartAppBrowseHistorySocketResponsedMessage) responsedMessage).getData());
            } else if (responsedMessage instanceof SmartAppBrowseHistoryHttpResponsedMessage) {
                i.this.b(true, ((SmartAppBrowseHistoryHttpResponsedMessage) responsedMessage).getData());
            }
        }
    };

    /* loaded from: classes6.dex */
    public interface a {
        void a(boolean z, com.baidu.tieba.personExtra.a aVar);
    }

    public i() {
        registerTask();
        registerListener();
    }

    private void registerTask() {
        com.baidu.tieba.tbadkCore.a.a.c(309638, SmartAppBrowseHistorySocketResponsedMessage.class, false);
        com.baidu.tieba.tbadkCore.a.a.a(309638, CmdConfigHttp.CMD_HISTORY_SWAN, TbConfig.URL_HISTORY_SWAN, SmartAppBrowseHistoryHttpResponsedMessage.class, false, false, true, false);
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(this.bRo);
    }

    public void aNO() {
        if (!this.isLoading) {
            this.isLoading = true;
            MessageManager.getInstance().sendMessage(new SmartAppBrowseHistoryRequestMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, com.baidu.tieba.personExtra.a aVar) {
        if (this.ipj != null) {
            this.ipj.a(z, aVar);
        }
    }

    public void a(a aVar) {
        this.ipj = aVar;
    }
}
