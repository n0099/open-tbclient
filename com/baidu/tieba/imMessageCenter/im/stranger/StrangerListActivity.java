package com.baidu.tieba.imMessageCenter.im.stranger;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.MemoryInitCompleteMessage;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
import com.baidu.tieba.im.message.ResponsedMemoryListMessage;
import com.baidu.tieba.n;
import java.util.List;
/* loaded from: classes.dex */
public class StrangerListActivity extends BaseActivity<StrangerListActivity> {
    private i chO;
    private StrangerListModel chP;
    private StrangerListActivity chQ;
    private com.baidu.tbadk.core.dialog.a chR;
    private a.b chS = new d(this);
    private a.b chT = new e(this);
    private final CustomMessageListener bNr = new f(this, 0);
    private com.baidu.tieba.im.chat.notify.a bNs = new g(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.chQ = this;
        a(this);
        initData();
        registerListener();
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        ChatStatusManager.getInst().setIsOpen(5, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        ChatStatusManager.getInst().setIsOpen(5, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        ChatStatusManager.getInst().setIsOpen(5, false);
    }

    private void registerListener() {
        registerListener(CmdConfigCustom.MEMORY_CHANGED, this.bNr);
        registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.bNr);
        registerListener(CmdConfigCustom.MEMORY_CLEAR, this.bNr);
        registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.bNr);
        registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.bNr);
    }

    private void a(StrangerListActivity strangerListActivity) {
        this.chO = new i(strangerListActivity);
        this.chR = new com.baidu.tbadk.core.dialog.a(strangerListActivity.getPageContext().getPageActivity());
        this.chR.bG(n.j.sure_to_delete_all_stranger_msg);
        this.chR.a(n.j.alert_yes_btn, this.chS);
        this.chR.b(n.j.cancel, this.chT);
        this.chR.b(strangerListActivity.getPageContext());
    }

    private void initData() {
        this.chP = new StrangerListModel(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.chO != null) {
            this.chO.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ImMessageCenterShowItemData ij;
        if (this.chO != null && this.chO.aeq() != null && (ij = this.chO.aeq().getItem(i)) != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(this.chQ.getPageContext().getContext(), com.baidu.adp.lib.h.b.c(ij.getFriendId(), 0L), ij.getFriendName(), ij.getFriendPortrait(), 0, 0)));
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        ImMessageCenterShowItemData ij;
        if (this.chO == null || this.chO.aeq() == null || (ij = this.chO.aeq().getItem(i)) == null) {
            return false;
        }
        com.baidu.tbadk.coreExtra.e.a.a(getPageContext().getContext(), new h(this, this.chP.getData().size(), ij));
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.chO.aer() && this.chR != null) {
            this.chR.tf();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.chO != null && this.chO.aeq() != null) {
            this.chO.aeq().notifyDataSetChanged();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a("-1001", -7)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(CustomResponsedMessage<?> customResponsedMessage) {
        if ((customResponsedMessage instanceof MemoryInitCompleteMessage) && ((MemoryInitCompleteMessage) customResponsedMessage).getData().booleanValue()) {
            sendMessage(new RequestMemoryListMessage(3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof MemoryChangedMessage) {
            MemoryChangedMessage memoryChangedMessage = (MemoryChangedMessage) customResponsedMessage;
            ImMessageCenterPojo data = memoryChangedMessage.getData();
            if (memoryChangedMessage.getType() == 1) {
                if (this.chP != null) {
                    this.chP.insertOrUpdate(data, this.bNs);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.chP != null) {
                this.chP.remove(data, this.bNs);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 3 && this.chP != null) {
                this.chP.setData(data, this.bNs);
            }
        }
    }
}
