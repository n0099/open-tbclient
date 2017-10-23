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
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.d;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.MemoryInitCompleteMessage;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
import com.baidu.tieba.im.message.ResponsedMemoryListMessage;
import java.util.List;
/* loaded from: classes2.dex */
public class StrangerListActivity extends BaseActivity<StrangerListActivity> {
    private b dIR;
    private StrangerListModel dIS;
    private StrangerListActivity dIT;
    private com.baidu.tbadk.core.dialog.a dIU;
    private a.b dIV = new a.b() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.StrangerListActivity.2
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            StrangerListActivity.this.dIU.dismiss();
            StrangerListActivity.this.dIS.aAv();
            StrangerListActivity.this.showToast(d.l.delete_success, false);
            StrangerListActivity.this.finish();
        }
    };
    private a.b dIW = new a.b() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.StrangerListActivity.3
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            StrangerListActivity.this.dIU.dismiss();
        }
    };
    private final CustomMessageListener dpq = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.im.stranger.StrangerListActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (customResponsedMessage.getCmd() == 2016002) {
                    StrangerListActivity.this.e(customResponsedMessage);
                } else if (customResponsedMessage.getCmd() == 2016004) {
                    StrangerListActivity.this.f(customResponsedMessage);
                } else if (customResponsedMessage.getCmd() == 2016007) {
                    StrangerListActivity.this.g(customResponsedMessage);
                } else if (customResponsedMessage.getCmd() == 2016001) {
                    StrangerListActivity.this.dIS.setData(null, StrangerListActivity.this.dps);
                } else if (customResponsedMessage.getCmd() == 2016011 && StrangerListActivity.this.dIR != null && StrangerListActivity.this.dIR.aAw() != null) {
                    StrangerListActivity.this.dIR.aAw().notifyDataSetChanged();
                }
            }
        }
    };
    private com.baidu.tieba.im.chat.a.a dps = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.StrangerListActivity.5
        @Override // com.baidu.tieba.im.chat.a.a
        public void atd() {
            if (StrangerListActivity.this.dIR != null && StrangerListActivity.this.dIR.aAw() != null && StrangerListActivity.this.dIS != null) {
                if (StrangerListActivity.this.dIS.getData().size() == 0) {
                    StrangerListActivity.this.finish();
                }
                StrangerListActivity.this.dIR.aAw().setData(StrangerListActivity.this.dIS.getData());
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dIT = this;
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
        registerListener(CmdConfigCustom.MEMORY_CHANGED, this.dpq);
        registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.dpq);
        registerListener(CmdConfigCustom.MEMORY_CLEAR, this.dpq);
        registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.dpq);
        registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.dpq);
    }

    private void a(StrangerListActivity strangerListActivity) {
        this.dIR = new b(strangerListActivity);
        this.dIU = new com.baidu.tbadk.core.dialog.a(strangerListActivity.getPageContext().getPageActivity());
        this.dIU.cc(d.l.sure_to_delete_all_stranger_msg);
        this.dIU.a(d.l.confirm, this.dIV);
        this.dIU.b(d.l.cancel, this.dIW);
        this.dIU.b(strangerListActivity.getPageContext());
    }

    private void initData() {
        this.dIS = new StrangerListModel(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.dIR != null) {
            this.dIR.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ImMessageCenterShowItemData ml;
        if (this.dIR != null && this.dIR.aAw() != null && (ml = this.dIR.aAw().getItem(i)) != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(this.dIT.getPageContext().getContext(), com.baidu.adp.lib.g.b.c(ml.getFriendId(), 0L), ml.getFriendName(), ml.getFriendPortrait(), 0, 0)));
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        final ImMessageCenterShowItemData ml;
        if (this.dIR == null || this.dIR.aAw() == null || (ml = this.dIR.aAw().getItem(i)) == null) {
            return false;
        }
        final int size = this.dIS.getData().size();
        com.baidu.tbadk.coreExtra.e.a.a(getPageContext().getContext(), new b.InterfaceC0047b() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.StrangerListActivity.1
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i2, View view2) {
                bVar.dismiss();
                if (size == 1) {
                    StrangerListActivity.this.dIS.aAv();
                    StrangerListActivity.this.finish();
                    return;
                }
                StrangerListActivity.this.dIS.deleteItem(ml, StrangerListActivity.this.dps);
            }
        });
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.dIR.aAx() && this.dIU != null) {
            this.dIU.tb();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.dIR != null && this.dIR.aAw() != null) {
            this.dIR.aAw().notifyDataSetChanged();
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
                if (this.dIS != null) {
                    this.dIS.insertOrUpdate(data, this.dps);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.dIS != null) {
                this.dIS.remove(data, this.dps);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 3 && this.dIS != null) {
                this.dIS.setData(data, this.dps);
            }
        }
    }
}
