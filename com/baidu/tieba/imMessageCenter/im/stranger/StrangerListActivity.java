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
    private b dZD;
    private StrangerListModel dZE;
    private StrangerListActivity dZF;
    private com.baidu.tbadk.core.dialog.a dZG;
    private a.b dZH = new a.b() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.StrangerListActivity.2
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            StrangerListActivity.this.dZG.dismiss();
            StrangerListActivity.this.dZE.aEC();
            StrangerListActivity.this.showToast(d.j.delete_success, false);
            StrangerListActivity.this.finish();
        }
    };
    private a.b dZI = new a.b() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.StrangerListActivity.3
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            StrangerListActivity.this.dZG.dismiss();
        }
    };
    private final CustomMessageListener dGr = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.im.stranger.StrangerListActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (customResponsedMessage.getCmd() == 2016002) {
                    StrangerListActivity.this.f(customResponsedMessage);
                } else if (customResponsedMessage.getCmd() == 2016004) {
                    StrangerListActivity.this.g(customResponsedMessage);
                } else if (customResponsedMessage.getCmd() == 2016007) {
                    StrangerListActivity.this.h(customResponsedMessage);
                } else if (customResponsedMessage.getCmd() == 2016001) {
                    StrangerListActivity.this.dZE.setData(null, StrangerListActivity.this.dGt);
                } else if (customResponsedMessage.getCmd() == 2016011 && StrangerListActivity.this.dZD != null && StrangerListActivity.this.dZD.aED() != null) {
                    StrangerListActivity.this.dZD.aED().notifyDataSetChanged();
                }
            }
        }
    };
    private com.baidu.tieba.im.chat.a.a dGt = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.StrangerListActivity.5
        @Override // com.baidu.tieba.im.chat.a.a
        public void axx() {
            if (StrangerListActivity.this.dZD != null && StrangerListActivity.this.dZD.aED() != null && StrangerListActivity.this.dZE != null) {
                if (StrangerListActivity.this.dZE.getData().size() == 0) {
                    StrangerListActivity.this.finish();
                }
                StrangerListActivity.this.dZD.aED().setData(StrangerListActivity.this.dZE.getData());
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dZF = this;
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
        registerListener(CmdConfigCustom.MEMORY_CHANGED, this.dGr);
        registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.dGr);
        registerListener(CmdConfigCustom.MEMORY_CLEAR, this.dGr);
        registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.dGr);
        registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.dGr);
    }

    private void a(StrangerListActivity strangerListActivity) {
        this.dZD = new b(strangerListActivity);
        this.dZG = new com.baidu.tbadk.core.dialog.a(strangerListActivity.getPageContext().getPageActivity());
        this.dZG.cd(d.j.sure_to_delete_all_stranger_msg);
        this.dZG.a(d.j.confirm, this.dZH);
        this.dZG.b(d.j.cancel, this.dZI);
        this.dZG.b(strangerListActivity.getPageContext());
    }

    private void initData() {
        this.dZE = new StrangerListModel(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.dZD != null) {
            this.dZD.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ImMessageCenterShowItemData mX;
        if (this.dZD != null && this.dZD.aED() != null && (mX = this.dZD.aED().getItem(i)) != null) {
            PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(this.dZF.getPageContext().getContext(), com.baidu.adp.lib.g.b.c(mX.getFriendId(), 0L), mX.getFriendName(), mX.getFriendPortrait(), 0, 0);
            personalChatActivityConfig.setFollowStatus(0);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, personalChatActivityConfig));
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        final ImMessageCenterShowItemData mX;
        if (this.dZD == null || this.dZD.aED() == null || (mX = this.dZD.aED().getItem(i)) == null) {
            return false;
        }
        final int size = this.dZE.getData().size();
        com.baidu.tbadk.coreExtra.d.a.a(getPageContext().getContext(), new b.InterfaceC0061b() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.StrangerListActivity.1
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0061b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i2, View view2) {
                bVar.dismiss();
                if (size == 1) {
                    StrangerListActivity.this.dZE.aEC();
                    StrangerListActivity.this.finish();
                    return;
                }
                StrangerListActivity.this.dZE.deleteItem(mX, StrangerListActivity.this.dGt);
            }
        });
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.dZD.aEE() && this.dZG != null) {
            this.dZG.th();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.dZD != null && this.dZD.aED() != null) {
            this.dZD.aED().notifyDataSetChanged();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a("-1001", -7)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(CustomResponsedMessage<?> customResponsedMessage) {
        if ((customResponsedMessage instanceof MemoryInitCompleteMessage) && ((MemoryInitCompleteMessage) customResponsedMessage).getData().booleanValue()) {
            sendMessage(new RequestMemoryListMessage(3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof MemoryChangedMessage) {
            MemoryChangedMessage memoryChangedMessage = (MemoryChangedMessage) customResponsedMessage;
            ImMessageCenterPojo data = memoryChangedMessage.getData();
            if (memoryChangedMessage.getType() == 1) {
                if (this.dZE != null) {
                    this.dZE.insertOrUpdate(data, this.dGt);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.dZE != null) {
                this.dZE.remove(data, this.dGt);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 3 && this.dZE != null) {
                this.dZE.setData(data, this.dGt);
            }
        }
    }
}
