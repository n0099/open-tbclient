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
import com.baidu.tieba.d;
import com.baidu.tieba.im.db.e;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.MemoryInitCompleteMessage;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
import com.baidu.tieba.im.message.ResponsedMemoryListMessage;
import java.util.List;
/* loaded from: classes2.dex */
public class StrangerListActivity extends BaseActivity<StrangerListActivity> {
    private d dTl;
    private b emf;
    private StrangerListModel emg;
    private StrangerListActivity emh;
    private com.baidu.tbadk.core.dialog.a emi;
    private a.b emj = new a.b() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.StrangerListActivity.2
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            StrangerListActivity.this.emi.dismiss();
            StrangerListActivity.this.emg.a(StrangerListActivity.this.dTp);
        }
    };
    private a.b emk = new a.b() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.StrangerListActivity.3
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            StrangerListActivity.this.emi.dismiss();
        }
    };
    private final CustomMessageListener dTm = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.im.stranger.StrangerListActivity.4
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
                    StrangerListActivity.this.emg.setData(null, StrangerListActivity.this.dTo);
                } else if (customResponsedMessage.getCmd() == 2016011 && StrangerListActivity.this.emf != null && StrangerListActivity.this.emf.aIl() != null) {
                    StrangerListActivity.this.emf.aIl().notifyDataSetChanged();
                }
            }
        }
    };
    private com.baidu.tieba.im.chat.a.a dTo = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.StrangerListActivity.5
        @Override // com.baidu.tieba.im.chat.a.a
        public void aBd() {
            StrangerListActivity.this.aBs();
        }
    };
    private final com.baidu.tieba.im.chat.a.b dTp = new com.baidu.tieba.im.chat.a.b() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.StrangerListActivity.6
        @Override // com.baidu.tieba.im.chat.a.b
        public void onPreExecute() {
            StrangerListActivity.this.aBr();
        }

        @Override // com.baidu.tieba.im.chat.a.b
        public void onProgressUpdate(int i, String str, int i2) {
            if (StrangerListActivity.this.dTl != null) {
                StrangerListActivity.this.dTl.setPercent(i);
            }
            StrangerListActivity.this.notifyDataSetChanged();
        }

        @Override // com.baidu.tieba.im.chat.a.b
        public void onPostExecute() {
            StrangerListActivity.this.Vl();
            StrangerListActivity.this.showToast(d.k.delete_success, false);
            StrangerListActivity.this.aBs();
        }

        @Override // com.baidu.tieba.im.chat.a.b
        public void onCanceled() {
            StrangerListActivity.this.Vl();
            StrangerListActivity.this.aBs();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.emh = this;
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
        Vl();
        super.onDestroy();
    }

    private void registerListener() {
        registerListener(2016004, this.dTm);
        registerListener(2016007, this.dTm);
        registerListener(2016001, this.dTm);
        registerListener(2016011, this.dTm);
        registerListener(2016002, this.dTm);
    }

    private void a(StrangerListActivity strangerListActivity) {
        this.emf = new b(strangerListActivity);
        this.emi = new com.baidu.tbadk.core.dialog.a(strangerListActivity.getPageContext().getPageActivity());
        this.emi.bZ(d.k.sure_to_delete_all_stranger_msg);
        this.emi.a(d.k.confirm, this.emj);
        this.emi.b(d.k.cancel, this.emk);
        this.emi.b(strangerListActivity.getPageContext());
    }

    private void initData() {
        this.emg = new StrangerListModel(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.emf != null) {
            this.emf.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
        ImMessageCenterShowItemData ni;
        if (this.emf != null && this.emf.aIl() != null && (ni = this.emf.aIl().getItem(i)) != null) {
            PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(this.emh.getPageContext().getContext(), com.baidu.adp.lib.g.b.c(ni.getFriendId(), 0L), ni.getFriendName(), ni.getFriendPortrait(), 0, 0);
            personalChatActivityConfig.setFollowStatus(0);
            sendMessage(new CustomMessage(2002005, personalChatActivityConfig));
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view2, int i, long j) {
        final ImMessageCenterShowItemData ni;
        if (this.emf == null || this.emf.aIl() == null || (ni = this.emf.aIl().getItem(i)) == null) {
            return false;
        }
        final int size = this.emg.getData().size();
        com.baidu.tbadk.coreExtra.d.a.a(getPageContext().getContext(), new b.InterfaceC0086b() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.StrangerListActivity.1
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0086b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i2, View view3) {
                bVar.dismiss();
                if (size == 1) {
                    StrangerListActivity.this.emg.a(StrangerListActivity.this.dTp);
                } else {
                    StrangerListActivity.this.emg.asyncDeleteItem(ni, StrangerListActivity.this.dTp);
                }
            }
        });
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        super.onClick(view2);
        if (view2 == this.emf.aIm() && this.emi != null) {
            this.emi.tD();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.emf != null && this.emf.aIl() != null) {
            this.emf.aIl().notifyDataSetChanged();
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
                if (this.emg != null) {
                    this.emg.insertOrUpdate(data, this.dTo);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.emg != null) {
                this.emg.remove(data, this.dTo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 3 && this.emg != null) {
                this.emg.setData(data, this.dTo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBr() {
        Vl();
        if (this.dTl == null) {
            this.dTl = e.aDa().bz(getPageContext().getPageActivity());
        }
        this.dTl.show();
        this.dTl.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vl() {
        if (this.dTl != null && this.dTl.isShowing()) {
            this.dTl.dismiss();
            this.dTl = null;
        }
        closeLoadingDialog();
        dismissAllDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyDataSetChanged() {
        if (this.emf != null && this.emf.aIl() != null) {
            this.emf.aIl().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBs() {
        if (this.emf != null && this.emf.aIl() != null && this.emg != null) {
            if (this.emg != null && this.emg.isEmpty()) {
                finish();
            }
            this.emf.aIl().setData(this.emg.getData());
        }
    }
}
