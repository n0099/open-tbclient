package com.baidu.tieba.imMessageCenter.im.stranger;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.d;
import com.baidu.tbadk.core.dialog.i;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.R;
import com.baidu.tieba.im.db.e;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.MemoryInitCompleteMessage;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
import com.baidu.tieba.im.message.ResponsedMemoryListMessage;
import java.util.List;
/* loaded from: classes2.dex */
public class StrangerListActivity extends BaseActivity<StrangerListActivity> {
    private d kDA;
    private b kQp;
    private StrangerListModel kQq;
    private StrangerListActivity kQr;
    private com.baidu.tbadk.core.dialog.a kQs;
    private a.b kQt = new a.b() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.StrangerListActivity.2
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            StrangerListActivity.this.kQs.dismiss();
            StrangerListActivity.this.kQq.a(StrangerListActivity.this.kDE);
        }
    };
    private a.b kQu = new a.b() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.StrangerListActivity.3
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            StrangerListActivity.this.kQs.dismiss();
        }
    };
    private final CustomMessageListener kDB = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.im.stranger.StrangerListActivity.4
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
                    StrangerListActivity.this.kQq.setData(null, StrangerListActivity.this.kDD);
                } else if (customResponsedMessage.getCmd() == 2016011 && StrangerListActivity.this.kQp != null && StrangerListActivity.this.kQp.cZf() != null) {
                    StrangerListActivity.this.kQp.cZf().notifyDataSetChanged();
                }
            }
        }
    };
    private com.baidu.tieba.im.chat.a.a kDD = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.StrangerListActivity.5
        @Override // com.baidu.tieba.im.chat.a.a
        public void onComplete() {
            StrangerListActivity.this.cVj();
        }
    };
    private final com.baidu.tieba.im.chat.a.b kDE = new com.baidu.tieba.im.chat.a.b() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.StrangerListActivity.6
        @Override // com.baidu.tieba.im.chat.a.b
        public void onPreExecute() {
            StrangerListActivity.this.cVi();
        }

        @Override // com.baidu.tieba.im.chat.a.b
        public void onProgressUpdate(int i, String str, int i2) {
            if (StrangerListActivity.this.kDA != null) {
                StrangerListActivity.this.kDA.setPercent(i);
            }
            StrangerListActivity.this.notifyDataSetChanged();
        }

        @Override // com.baidu.tieba.im.chat.a.b
        public void onPostExecute() {
            StrangerListActivity.this.FA();
            StrangerListActivity.this.showToast(R.string.delete_success, false);
            StrangerListActivity.this.cVj();
        }

        @Override // com.baidu.tieba.im.chat.a.b
        public void onCanceled() {
            StrangerListActivity.this.FA();
            StrangerListActivity.this.cVj();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kQr = this;
        a(this);
        initData();
        registerListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRestart() {
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
        FA();
        super.onDestroy();
    }

    private void registerListener() {
        registerListener(CmdConfigCustom.MEMORY_CHANGED, this.kDB);
        registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.kDB);
        registerListener(CmdConfigCustom.MEMORY_CLEAR, this.kDB);
        registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.kDB);
        registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.kDB);
    }

    private void a(StrangerListActivity strangerListActivity) {
        this.kQp = new b(strangerListActivity);
        this.kQs = new com.baidu.tbadk.core.dialog.a(strangerListActivity.getPageContext().getPageActivity());
        this.kQs.nx(R.string.sure_to_delete_all_stranger_msg);
        this.kQs.a(R.string.confirm, this.kQt);
        this.kQs.b(R.string.cancel, this.kQu);
        this.kQs.b(strangerListActivity.getPageContext());
    }

    private void initData() {
        this.kQq = new StrangerListModel(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.kQp != null) {
            this.kQp.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ImMessageCenterShowItemData CJ;
        if (this.kQp != null && this.kQp.cZf() != null && (CJ = this.kQp.cZf().getItem(i)) != null) {
            PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(this.kQr.getPageContext().getContext(), com.baidu.adp.lib.f.b.toLong(CJ.getFriendId(), 0L), CJ.getFriendName(), CJ.getFriendNameShow(), CJ.getFriendPortrait(), 0, 0);
            personalChatActivityConfig.setFollowStatus(0);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, personalChatActivityConfig));
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        final ImMessageCenterShowItemData CJ;
        if (this.kQp == null || this.kQp.cZf() == null || (CJ = this.kQp.cZf().getItem(i)) == null) {
            return false;
        }
        final int size = this.kQq.getData().size();
        final i iVar = new i(getPageContext());
        iVar.a(null, new String[]{TbadkCoreApplication.getInst().getString(R.string.delete_user_chat)}, new k.c() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.StrangerListActivity.1
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i2, View view2) {
                if (iVar != null && iVar.isShowing()) {
                    iVar.dismiss();
                }
                if (size == 1) {
                    StrangerListActivity.this.kQq.a(StrangerListActivity.this.kDE);
                } else {
                    StrangerListActivity.this.kQq.asyncDeleteItem(CJ, StrangerListActivity.this.kDE);
                }
            }
        });
        iVar.QE();
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.kQp.cZg() && this.kQs != null) {
            this.kQs.bqx();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.kQp != null && this.kQp.cZf() != null) {
            this.kQp.cZf().notifyDataSetChanged();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(TbEnum.CustomGroupId.STRANGE_MERGE, -7)));
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
                if (this.kQq != null) {
                    this.kQq.insertOrUpdate(data, this.kDD);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.kQq != null) {
                this.kQq.remove(data, this.kDD);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 3 && this.kQq != null) {
                this.kQq.setData(data, this.kDD);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cVi() {
        FA();
        if (this.kDA == null) {
            this.kDA = e.cVB().gw(getPageContext().getPageActivity());
        }
        this.kDA.show();
        this.kDA.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FA() {
        if (this.kDA != null && this.kDA.isShowing()) {
            this.kDA.dismiss();
            this.kDA = null;
        }
        closeLoadingDialog();
        dismissAllDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyDataSetChanged() {
        if (this.kQp != null && this.kQp.cZf() != null) {
            this.kQp.cZf().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cVj() {
        if (this.kQp != null && this.kQp.cZf() != null && this.kQq != null) {
            if (this.kQq != null && this.kQq.isEmpty()) {
                finish();
            }
            this.kQp.cZf().setData(this.kQq.getData());
        }
    }
}
