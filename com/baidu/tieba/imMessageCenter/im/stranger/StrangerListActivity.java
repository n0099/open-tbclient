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
import com.baidu.tbadk.core.dialog.d;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.f;
import com.baidu.tieba.im.db.e;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.MemoryInitCompleteMessage;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
import com.baidu.tieba.im.message.ResponsedMemoryListMessage;
import java.util.List;
/* loaded from: classes2.dex */
public class StrangerListActivity extends BaseActivity<StrangerListActivity> {
    private b eGh;
    private StrangerListModel eGi;
    private StrangerListActivity eGj;
    private com.baidu.tbadk.core.dialog.a eGk;
    private d enj;
    private a.b eGl = new a.b() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.StrangerListActivity.2
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            StrangerListActivity.this.eGk.dismiss();
            StrangerListActivity.this.eGi.a(StrangerListActivity.this.enn);
        }
    };
    private a.b eGm = new a.b() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.StrangerListActivity.3
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            StrangerListActivity.this.eGk.dismiss();
        }
    };
    private final CustomMessageListener enk = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.im.stranger.StrangerListActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (customResponsedMessage.getCmd() == 2016002) {
                    StrangerListActivity.this.c(customResponsedMessage);
                } else if (customResponsedMessage.getCmd() == 2016004) {
                    StrangerListActivity.this.e(customResponsedMessage);
                } else if (customResponsedMessage.getCmd() == 2016007) {
                    StrangerListActivity.this.d(customResponsedMessage);
                } else if (customResponsedMessage.getCmd() == 2016001) {
                    StrangerListActivity.this.eGi.setData(null, StrangerListActivity.this.enm);
                } else if (customResponsedMessage.getCmd() == 2016011 && StrangerListActivity.this.eGh != null && StrangerListActivity.this.eGh.aOH() != null) {
                    StrangerListActivity.this.eGh.aOH().notifyDataSetChanged();
                }
            }
        }
    };
    private com.baidu.tieba.im.chat.a.a enm = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.StrangerListActivity.5
        @Override // com.baidu.tieba.im.chat.a.a
        public void aHB() {
            StrangerListActivity.this.aHP();
        }
    };
    private final com.baidu.tieba.im.chat.a.b enn = new com.baidu.tieba.im.chat.a.b() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.StrangerListActivity.6
        @Override // com.baidu.tieba.im.chat.a.b
        public void onPreExecute() {
            StrangerListActivity.this.asg();
        }

        @Override // com.baidu.tieba.im.chat.a.b
        public void onProgressUpdate(int i, String str, int i2) {
            if (StrangerListActivity.this.enj != null) {
                StrangerListActivity.this.enj.setPercent(i);
            }
            StrangerListActivity.this.notifyDataSetChanged();
        }

        @Override // com.baidu.tieba.im.chat.a.b
        public void onPostExecute() {
            StrangerListActivity.this.ZD();
            StrangerListActivity.this.showToast(f.j.delete_success, false);
            StrangerListActivity.this.aHP();
        }

        @Override // com.baidu.tieba.im.chat.a.b
        public void onCanceled() {
            StrangerListActivity.this.ZD();
            StrangerListActivity.this.aHP();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eGj = this;
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        ZD();
        super.onDestroy();
    }

    private void registerListener() {
        registerListener(2016004, this.enk);
        registerListener(2016007, this.enk);
        registerListener(2016001, this.enk);
        registerListener(2016011, this.enk);
        registerListener(2016002, this.enk);
    }

    private void a(StrangerListActivity strangerListActivity) {
        this.eGh = new b(strangerListActivity);
        this.eGk = new com.baidu.tbadk.core.dialog.a(strangerListActivity.getPageContext().getPageActivity());
        this.eGk.cf(f.j.sure_to_delete_all_stranger_msg);
        this.eGk.a(f.j.confirm, this.eGl);
        this.eGk.b(f.j.cancel, this.eGm);
        this.eGk.b(strangerListActivity.getPageContext());
    }

    private void initData() {
        this.eGi = new StrangerListModel(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.eGh != null) {
            this.eGh.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ImMessageCenterShowItemData nO;
        if (this.eGh != null && this.eGh.aOH() != null && (nO = this.eGh.aOH().getItem(i)) != null) {
            PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(this.eGj.getPageContext().getContext(), com.baidu.adp.lib.g.b.c(nO.getFriendId(), 0L), nO.getFriendName(), nO.getFriendNameShow(), nO.getFriendPortrait(), 0, 0);
            personalChatActivityConfig.setFollowStatus(0);
            sendMessage(new CustomMessage(2002005, personalChatActivityConfig));
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        final ImMessageCenterShowItemData nO;
        if (this.eGh == null || this.eGh.aOH() == null || (nO = this.eGh.aOH().getItem(i)) == null) {
            return false;
        }
        final int size = this.eGi.getData().size();
        com.baidu.tbadk.coreExtra.d.a.a(getPageContext().getContext(), new b.InterfaceC0101b() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.StrangerListActivity.1
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0101b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i2, View view2) {
                bVar.dismiss();
                if (size == 1) {
                    StrangerListActivity.this.eGi.a(StrangerListActivity.this.enn);
                } else {
                    StrangerListActivity.this.eGi.asyncDeleteItem(nO, StrangerListActivity.this.enn);
                }
            }
        });
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.eGh.aOI() && this.eGk != null) {
            this.eGk.xe();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.eGh != null && this.eGh.aOH() != null) {
            this.eGh.aOH().notifyDataSetChanged();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a("-1001", -7)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(CustomResponsedMessage<?> customResponsedMessage) {
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
                if (this.eGi != null) {
                    this.eGi.insertOrUpdate(data, this.enm);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.eGi != null) {
                this.eGi.remove(data, this.enm);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 3 && this.eGi != null) {
                this.eGi.setData(data, this.enm);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asg() {
        ZD();
        if (this.enj == null) {
            this.enj = e.aJy().bK(getPageContext().getPageActivity());
        }
        this.enj.show();
        this.enj.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZD() {
        if (this.enj != null && this.enj.isShowing()) {
            this.enj.dismiss();
            this.enj = null;
        }
        closeLoadingDialog();
        dismissAllDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyDataSetChanged() {
        if (this.eGh != null && this.eGh.aOH() != null) {
            this.eGh.aOH().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHP() {
        if (this.eGh != null && this.eGh.aOH() != null && this.eGi != null) {
            if (this.eGi != null && this.eGi.isEmpty()) {
                finish();
            }
            this.eGh.aOH().setData(this.eGi.getData());
        }
    }
}
