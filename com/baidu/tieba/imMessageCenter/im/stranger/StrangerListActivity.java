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
    private b dLV;
    private StrangerListModel dLW;
    private StrangerListActivity dLX;
    private com.baidu.tbadk.core.dialog.a dLY;
    private a.b dLZ = new a.b() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.StrangerListActivity.2
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            StrangerListActivity.this.dLY.dismiss();
            StrangerListActivity.this.dLW.aBE();
            StrangerListActivity.this.showToast(d.l.delete_success, false);
            StrangerListActivity.this.finish();
        }
    };
    private a.b dMa = new a.b() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.StrangerListActivity.3
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            StrangerListActivity.this.dLY.dismiss();
        }
    };
    private final CustomMessageListener dss = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.im.stranger.StrangerListActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (customResponsedMessage.getCmd() == 2016002) {
                    StrangerListActivity.this.d(customResponsedMessage);
                } else if (customResponsedMessage.getCmd() == 2016004) {
                    StrangerListActivity.this.e(customResponsedMessage);
                } else if (customResponsedMessage.getCmd() == 2016007) {
                    StrangerListActivity.this.f(customResponsedMessage);
                } else if (customResponsedMessage.getCmd() == 2016001) {
                    StrangerListActivity.this.dLW.setData(null, StrangerListActivity.this.dsu);
                } else if (customResponsedMessage.getCmd() == 2016011 && StrangerListActivity.this.dLV != null && StrangerListActivity.this.dLV.aBF() != null) {
                    StrangerListActivity.this.dLV.aBF().notifyDataSetChanged();
                }
            }
        }
    };
    private com.baidu.tieba.im.chat.a.a dsu = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.StrangerListActivity.5
        @Override // com.baidu.tieba.im.chat.a.a
        public void aum() {
            if (StrangerListActivity.this.dLV != null && StrangerListActivity.this.dLV.aBF() != null && StrangerListActivity.this.dLW != null) {
                if (StrangerListActivity.this.dLW.getData().size() == 0) {
                    StrangerListActivity.this.finish();
                }
                StrangerListActivity.this.dLV.aBF().setData(StrangerListActivity.this.dLW.getData());
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dLX = this;
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
        registerListener(CmdConfigCustom.MEMORY_CHANGED, this.dss);
        registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.dss);
        registerListener(CmdConfigCustom.MEMORY_CLEAR, this.dss);
        registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.dss);
        registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.dss);
    }

    private void a(StrangerListActivity strangerListActivity) {
        this.dLV = new b(strangerListActivity);
        this.dLY = new com.baidu.tbadk.core.dialog.a(strangerListActivity.getPageContext().getPageActivity());
        this.dLY.cc(d.l.sure_to_delete_all_stranger_msg);
        this.dLY.a(d.l.confirm, this.dLZ);
        this.dLY.b(d.l.cancel, this.dMa);
        this.dLY.b(strangerListActivity.getPageContext());
    }

    private void initData() {
        this.dLW = new StrangerListModel(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.dLV != null) {
            this.dLV.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ImMessageCenterShowItemData mo;
        if (this.dLV != null && this.dLV.aBF() != null && (mo = this.dLV.aBF().getItem(i)) != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(this.dLX.getPageContext().getContext(), com.baidu.adp.lib.g.b.c(mo.getFriendId(), 0L), mo.getFriendName(), mo.getFriendPortrait(), 0, 0)));
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        final ImMessageCenterShowItemData mo;
        if (this.dLV == null || this.dLV.aBF() == null || (mo = this.dLV.aBF().getItem(i)) == null) {
            return false;
        }
        final int size = this.dLW.getData().size();
        com.baidu.tbadk.coreExtra.e.a.a(getPageContext().getContext(), new b.InterfaceC0047b() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.StrangerListActivity.1
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i2, View view2) {
                bVar.dismiss();
                if (size == 1) {
                    StrangerListActivity.this.dLW.aBE();
                    StrangerListActivity.this.finish();
                    return;
                }
                StrangerListActivity.this.dLW.deleteItem(mo, StrangerListActivity.this.dsu);
            }
        });
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.dLV.aBG() && this.dLY != null) {
            this.dLY.to();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.dLV != null && this.dLV.aBF() != null) {
            this.dLV.aBF().notifyDataSetChanged();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a("-1001", -7)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        if ((customResponsedMessage instanceof MemoryInitCompleteMessage) && ((MemoryInitCompleteMessage) customResponsedMessage).getData().booleanValue()) {
            sendMessage(new RequestMemoryListMessage(3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof MemoryChangedMessage) {
            MemoryChangedMessage memoryChangedMessage = (MemoryChangedMessage) customResponsedMessage;
            ImMessageCenterPojo data = memoryChangedMessage.getData();
            if (memoryChangedMessage.getType() == 1) {
                if (this.dLW != null) {
                    this.dLW.insertOrUpdate(data, this.dsu);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.dLW != null) {
                this.dLW.remove(data, this.dsu);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 3 && this.dLW != null) {
                this.dLW.setData(data, this.dsu);
            }
        }
    }
}
