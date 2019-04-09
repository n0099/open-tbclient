package com.baidu.tieba.imMessageCenter.im.stranger;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.d;
import com.baidu.tbadk.core.dialog.g;
import com.baidu.tbadk.core.dialog.i;
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
/* loaded from: classes4.dex */
public class StrangerListActivity extends BaseActivity<StrangerListActivity> {
    private d gdT;
    private b gwM;
    private StrangerListModel gwN;
    private StrangerListActivity gwO;
    private com.baidu.tbadk.core.dialog.a gwP;
    private a.b gwQ = new a.b() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.StrangerListActivity.2
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            StrangerListActivity.this.gwP.dismiss();
            StrangerListActivity.this.gwN.a(StrangerListActivity.this.gdX);
        }
    };
    private a.b gwR = new a.b() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.StrangerListActivity.3
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            StrangerListActivity.this.gwP.dismiss();
        }
    };
    private final CustomMessageListener gdU = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.im.stranger.StrangerListActivity.4
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
                    StrangerListActivity.this.gwN.setData(null, StrangerListActivity.this.gdW);
                } else if (customResponsedMessage.getCmd() == 2016011 && StrangerListActivity.this.gwM != null && StrangerListActivity.this.gwM.bxn() != null) {
                    StrangerListActivity.this.gwM.bxn().notifyDataSetChanged();
                }
            }
        }
    };
    private com.baidu.tieba.im.chat.a.a gdW = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.StrangerListActivity.5
        @Override // com.baidu.tieba.im.chat.a.a
        public void onComplete() {
            StrangerListActivity.this.bqy();
        }
    };
    private final com.baidu.tieba.im.chat.a.b gdX = new com.baidu.tieba.im.chat.a.b() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.StrangerListActivity.6
        @Override // com.baidu.tieba.im.chat.a.b
        public void onPreExecute() {
            StrangerListActivity.this.bak();
        }

        @Override // com.baidu.tieba.im.chat.a.b
        public void onProgressUpdate(int i, String str, int i2) {
            if (StrangerListActivity.this.gdT != null) {
                StrangerListActivity.this.gdT.setPercent(i);
            }
            StrangerListActivity.this.notifyDataSetChanged();
        }

        @Override // com.baidu.tieba.im.chat.a.b
        public void onPostExecute() {
            StrangerListActivity.this.atv();
            StrangerListActivity.this.showToast(d.j.delete_success, false);
            StrangerListActivity.this.bqy();
        }

        @Override // com.baidu.tieba.im.chat.a.b
        public void onCanceled() {
            StrangerListActivity.this.atv();
            StrangerListActivity.this.bqy();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gwO = this;
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
        atv();
        super.onDestroy();
    }

    private void registerListener() {
        registerListener(2016004, this.gdU);
        registerListener(2016007, this.gdU);
        registerListener(2016001, this.gdU);
        registerListener(2016011, this.gdU);
        registerListener(2016002, this.gdU);
    }

    private void a(StrangerListActivity strangerListActivity) {
        this.gwM = new b(strangerListActivity);
        this.gwP = new com.baidu.tbadk.core.dialog.a(strangerListActivity.getPageContext().getPageActivity());
        this.gwP.gC(d.j.sure_to_delete_all_stranger_msg);
        this.gwP.a(d.j.confirm, this.gwQ);
        this.gwP.b(d.j.cancel, this.gwR);
        this.gwP.b(strangerListActivity.getPageContext());
    }

    private void initData() {
        this.gwN = new StrangerListModel(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.gwM != null) {
            this.gwM.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ImMessageCenterShowItemData tx;
        if (this.gwM != null && this.gwM.bxn() != null && (tx = this.gwM.bxn().getItem(i)) != null) {
            PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(this.gwO.getPageContext().getContext(), com.baidu.adp.lib.g.b.d(tx.getFriendId(), 0L), tx.getFriendName(), tx.getFriendNameShow(), tx.getFriendPortrait(), 0, 0);
            personalChatActivityConfig.setFollowStatus(0);
            sendMessage(new CustomMessage(2002005, personalChatActivityConfig));
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        final ImMessageCenterShowItemData tx;
        if (this.gwM == null || this.gwM.bxn() == null || (tx = this.gwM.bxn().getItem(i)) == null) {
            return false;
        }
        final int size = this.gwN.getData().size();
        final g gVar = new g(getPageContext());
        gVar.a(null, new String[]{TbadkCoreApplication.getInst().getString(d.j.delete_user_chat)}, new i.c() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.StrangerListActivity.1
            @Override // com.baidu.tbadk.core.dialog.i.c
            public void a(i iVar, int i2, View view2) {
                if (gVar != null && gVar.isShowing()) {
                    gVar.dismiss();
                }
                if (size == 1) {
                    StrangerListActivity.this.gwN.a(StrangerListActivity.this.gdX);
                } else {
                    StrangerListActivity.this.gwN.asyncDeleteItem(tx, StrangerListActivity.this.gdX);
                }
            }
        });
        gVar.showDialog();
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.gwM.bxo() && this.gwP != null) {
            this.gwP.aaW();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.gwM != null && this.gwM.bxn() != null) {
            this.gwM.bxn().notifyDataSetChanged();
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
                if (this.gwN != null) {
                    this.gwN.insertOrUpdate(data, this.gdW);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.gwN != null) {
                this.gwN.remove(data, this.gdW);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 3 && this.gwN != null) {
                this.gwN.setData(data, this.gdW);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bak() {
        atv();
        if (this.gdT == null) {
            this.gdT = e.bsg().dY(getPageContext().getPageActivity());
        }
        this.gdT.show();
        this.gdT.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atv() {
        if (this.gdT != null && this.gdT.isShowing()) {
            this.gdT.dismiss();
            this.gdT = null;
        }
        closeLoadingDialog();
        dismissAllDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyDataSetChanged() {
        if (this.gwM != null && this.gwM.bxn() != null) {
            this.gwM.bxn().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqy() {
        if (this.gwM != null && this.gwM.bxn() != null && this.gwN != null) {
            if (this.gwN != null && this.gwN.isEmpty()) {
                finish();
            }
            this.gwM.bxn().setData(this.gwN.getData());
        }
    }
}
