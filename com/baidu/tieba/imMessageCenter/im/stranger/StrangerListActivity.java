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
import com.baidu.tieba.e;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.MemoryInitCompleteMessage;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
import com.baidu.tieba.im.message.ResponsedMemoryListMessage;
import java.util.List;
/* loaded from: classes4.dex */
public class StrangerListActivity extends BaseActivity<StrangerListActivity> {
    private d eCr;
    private b eVf;
    private StrangerListModel eVg;
    private StrangerListActivity eVh;
    private com.baidu.tbadk.core.dialog.a eVi;
    private a.b eVj = new a.b() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.StrangerListActivity.2
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            StrangerListActivity.this.eVi.dismiss();
            StrangerListActivity.this.eVg.a(StrangerListActivity.this.eCv);
        }
    };
    private a.b eVk = new a.b() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.StrangerListActivity.3
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            StrangerListActivity.this.eVi.dismiss();
        }
    };
    private final CustomMessageListener eCs = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.im.stranger.StrangerListActivity.4
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
                    StrangerListActivity.this.eVg.setData(null, StrangerListActivity.this.eCu);
                } else if (customResponsedMessage.getCmd() == 2016011 && StrangerListActivity.this.eVf != null && StrangerListActivity.this.eVf.aUk() != null) {
                    StrangerListActivity.this.eVf.aUk().notifyDataSetChanged();
                }
            }
        }
    };
    private com.baidu.tieba.im.chat.a.a eCu = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.StrangerListActivity.5
        @Override // com.baidu.tieba.im.chat.a.a
        public void onComplete() {
            StrangerListActivity.this.aNu();
        }
    };
    private final com.baidu.tieba.im.chat.a.b eCv = new com.baidu.tieba.im.chat.a.b() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.StrangerListActivity.6
        @Override // com.baidu.tieba.im.chat.a.b
        public void onPreExecute() {
            StrangerListActivity.this.axq();
        }

        @Override // com.baidu.tieba.im.chat.a.b
        public void onProgressUpdate(int i, String str, int i2) {
            if (StrangerListActivity.this.eCr != null) {
                StrangerListActivity.this.eCr.setPercent(i);
            }
            StrangerListActivity.this.notifyDataSetChanged();
        }

        @Override // com.baidu.tieba.im.chat.a.b
        public void onPostExecute() {
            StrangerListActivity.this.RM();
            StrangerListActivity.this.showToast(e.j.delete_success, false);
            StrangerListActivity.this.aNu();
        }

        @Override // com.baidu.tieba.im.chat.a.b
        public void onCanceled() {
            StrangerListActivity.this.RM();
            StrangerListActivity.this.aNu();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eVh = this;
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
        RM();
        super.onDestroy();
    }

    private void registerListener() {
        registerListener(2016004, this.eCs);
        registerListener(2016007, this.eCs);
        registerListener(2016001, this.eCs);
        registerListener(2016011, this.eCs);
        registerListener(2016002, this.eCs);
    }

    private void a(StrangerListActivity strangerListActivity) {
        this.eVf = new b(strangerListActivity);
        this.eVi = new com.baidu.tbadk.core.dialog.a(strangerListActivity.getPageContext().getPageActivity());
        this.eVi.cz(e.j.sure_to_delete_all_stranger_msg);
        this.eVi.a(e.j.confirm, this.eVj);
        this.eVi.b(e.j.cancel, this.eVk);
        this.eVi.b(strangerListActivity.getPageContext());
    }

    private void initData() {
        this.eVg = new StrangerListModel(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.eVf != null) {
            this.eVf.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ImMessageCenterShowItemData oQ;
        if (this.eVf != null && this.eVf.aUk() != null && (oQ = this.eVf.aUk().getItem(i)) != null) {
            PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(this.eVh.getPageContext().getContext(), com.baidu.adp.lib.g.b.d(oQ.getFriendId(), 0L), oQ.getFriendName(), oQ.getFriendNameShow(), oQ.getFriendPortrait(), 0, 0);
            personalChatActivityConfig.setFollowStatus(0);
            sendMessage(new CustomMessage(2002005, personalChatActivityConfig));
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        final ImMessageCenterShowItemData oQ;
        if (this.eVf == null || this.eVf.aUk() == null || (oQ = this.eVf.aUk().getItem(i)) == null) {
            return false;
        }
        final int size = this.eVg.getData().size();
        com.baidu.tbadk.coreExtra.d.a.a(getPageContext().getContext(), new b.InterfaceC0124b() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.StrangerListActivity.1
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0124b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i2, View view2) {
                bVar.dismiss();
                if (size == 1) {
                    StrangerListActivity.this.eVg.a(StrangerListActivity.this.eCv);
                } else {
                    StrangerListActivity.this.eVg.asyncDeleteItem(oQ, StrangerListActivity.this.eCv);
                }
            }
        });
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.eVf.aUl() && this.eVi != null) {
            this.eVi.Au();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.eVf != null && this.eVf.aUk() != null) {
            this.eVf.aUk().notifyDataSetChanged();
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
                if (this.eVg != null) {
                    this.eVg.insertOrUpdate(data, this.eCu);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.eVg != null) {
                this.eVg.remove(data, this.eCu);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 3 && this.eVg != null) {
                this.eVg.setData(data, this.eCu);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axq() {
        RM();
        if (this.eCr == null) {
            this.eCr = com.baidu.tieba.im.db.e.aPc().cE(getPageContext().getPageActivity());
        }
        this.eCr.show();
        this.eCr.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void RM() {
        if (this.eCr != null && this.eCr.isShowing()) {
            this.eCr.dismiss();
            this.eCr = null;
        }
        closeLoadingDialog();
        dismissAllDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyDataSetChanged() {
        if (this.eVf != null && this.eVf.aUk() != null) {
            this.eVf.aUk().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNu() {
        if (this.eVf != null && this.eVf.aUk() != null && this.eVg != null) {
            if (this.eVg != null && this.eVg.isEmpty()) {
                finish();
            }
            this.eVf.aUk().setData(this.eVg.getData());
        }
    }
}
