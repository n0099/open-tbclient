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
import com.baidu.tieba.t;
import java.util.List;
/* loaded from: classes.dex */
public class StrangerListActivity extends BaseActivity<StrangerListActivity> {
    private i cxP;
    private StrangerListModel cxQ;
    private StrangerListActivity cxR;
    private com.baidu.tbadk.core.dialog.a cxS;
    private a.b cxT = new d(this);
    private a.b cxU = new e(this);
    private final CustomMessageListener cco = new f(this, 0);
    private com.baidu.tieba.im.chat.notify.a ccq = new g(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cxR = this;
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
        registerListener(CmdConfigCustom.MEMORY_CHANGED, this.cco);
        registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.cco);
        registerListener(CmdConfigCustom.MEMORY_CLEAR, this.cco);
        registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.cco);
        registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.cco);
    }

    private void a(StrangerListActivity strangerListActivity) {
        this.cxP = new i(strangerListActivity);
        this.cxS = new com.baidu.tbadk.core.dialog.a(strangerListActivity.getPageContext().getPageActivity());
        this.cxS.bL(t.j.sure_to_delete_all_stranger_msg);
        this.cxS.a(t.j.alert_yes_btn, this.cxT);
        this.cxS.b(t.j.cancel, this.cxU);
        this.cxS.b(strangerListActivity.getPageContext());
    }

    private void initData() {
        this.cxQ = new StrangerListModel(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.cxP != null) {
            this.cxP.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ImMessageCenterShowItemData iQ;
        if (this.cxP != null && this.cxP.alc() != null && (iQ = this.cxP.alc().getItem(i)) != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(this.cxR.getPageContext().getContext(), com.baidu.adp.lib.h.b.c(iQ.getFriendId(), 0L), iQ.getFriendName(), iQ.getFriendPortrait(), 0, 0)));
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        ImMessageCenterShowItemData iQ;
        if (this.cxP == null || this.cxP.alc() == null || (iQ = this.cxP.alc().getItem(i)) == null) {
            return false;
        }
        com.baidu.tbadk.coreExtra.e.a.a(getPageContext().getContext(), new h(this, this.cxQ.getData().size(), iQ));
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.cxP.ald() && this.cxS != null) {
            this.cxS.rV();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.cxP != null && this.cxP.alc() != null) {
            this.cxP.alc().notifyDataSetChanged();
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
                if (this.cxQ != null) {
                    this.cxQ.insertOrUpdate(data, this.ccq);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.cxQ != null) {
                this.cxQ.remove(data, this.ccq);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 3 && this.cxQ != null) {
                this.cxQ.setData(data, this.ccq);
            }
        }
    }
}
