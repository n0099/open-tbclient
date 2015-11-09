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
import com.baidu.tieba.i;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.MemoryInitCompleteMessage;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
import com.baidu.tieba.im.message.ResponsedMemoryListMessage;
import java.util.List;
/* loaded from: classes.dex */
public class StrangerListActivity extends BaseActivity<StrangerListActivity> {
    private i bOL;
    private StrangerListModel bOM;
    private StrangerListActivity bON;
    private com.baidu.tbadk.core.dialog.a bOO;
    private a.b bOP = new d(this);
    private a.b bOQ = new e(this);
    private final CustomMessageListener buE = new f(this, 0);
    private com.baidu.tieba.im.chat.notify.a buF = new g(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bON = this;
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
        registerListener(CmdConfigCustom.MEMORY_CHANGED, this.buE);
        registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.buE);
        registerListener(CmdConfigCustom.MEMORY_CLEAR, this.buE);
        registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.buE);
        registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.buE);
    }

    private void a(StrangerListActivity strangerListActivity) {
        this.bOL = new i(strangerListActivity);
        this.bOO = new com.baidu.tbadk.core.dialog.a(strangerListActivity.getPageContext().getPageActivity());
        this.bOO.bF(i.h.sure_to_delete_all_stranger_msg);
        this.bOO.a(i.h.alert_yes_btn, this.bOP);
        this.bOO.b(i.h.cancel, this.bOQ);
        this.bOO.b(strangerListActivity.getPageContext());
    }

    private void initData() {
        this.bOM = new StrangerListModel(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.bOL != null) {
            this.bOL.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ImMessageCenterShowItemData gX;
        if (this.bOL != null && this.bOL.aab() != null && (gX = this.bOL.aab().getItem(i)) != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(this.bON.getPageContext().getContext(), com.baidu.adp.lib.g.b.c(gX.getFriendId(), 0L), gX.getFriendName(), gX.getFriendPortrait(), 0, 0)));
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        ImMessageCenterShowItemData gX;
        if (this.bOL == null || this.bOL.aab() == null || (gX = this.bOL.aab().getItem(i)) == null) {
            return false;
        }
        com.baidu.tbadk.coreExtra.e.a.a(getPageContext().getContext(), new h(this, this.bOM.getData().size(), gX));
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.bOL.aac() && this.bOO != null) {
            this.bOO.sR();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.bOL != null && this.bOL.aab() != null) {
            this.bOL.aab().notifyDataSetChanged();
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
                if (this.bOM != null) {
                    this.bOM.insertOrUpdate(data, this.buF);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.bOM != null) {
                this.bOM.remove(data, this.buF);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 3 && this.bOM != null) {
                this.bOM.setData(data, this.buF);
            }
        }
    }
}
