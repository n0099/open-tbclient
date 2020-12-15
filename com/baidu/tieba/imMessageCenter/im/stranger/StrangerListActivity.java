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
/* loaded from: classes22.dex */
public class StrangerListActivity extends BaseActivity<StrangerListActivity> {
    private b kHu;
    private StrangerListModel kHv;
    private StrangerListActivity kHw;
    private com.baidu.tbadk.core.dialog.a kHx;
    private d knf;
    private a.b kHy = new a.b() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.StrangerListActivity.2
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            StrangerListActivity.this.kHx.dismiss();
            StrangerListActivity.this.kHv.a(StrangerListActivity.this.knj);
        }
    };
    private a.b kHz = new a.b() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.StrangerListActivity.3
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            StrangerListActivity.this.kHx.dismiss();
        }
    };
    private final CustomMessageListener kng = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.im.stranger.StrangerListActivity.4
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
                    StrangerListActivity.this.kHv.setData(null, StrangerListActivity.this.kni);
                } else if (customResponsedMessage.getCmd() == 2016011 && StrangerListActivity.this.kHu != null && StrangerListActivity.this.kHu.dbo() != null) {
                    StrangerListActivity.this.kHu.dbo().notifyDataSetChanged();
                }
            }
        }
    };
    private com.baidu.tieba.im.chat.a.a kni = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.StrangerListActivity.5
        @Override // com.baidu.tieba.im.chat.a.a
        public void onComplete() {
            StrangerListActivity.this.cUj();
        }
    };
    private final com.baidu.tieba.im.chat.a.b knj = new com.baidu.tieba.im.chat.a.b() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.StrangerListActivity.6
        @Override // com.baidu.tieba.im.chat.a.b
        public void onPreExecute() {
            StrangerListActivity.this.cUi();
        }

        @Override // com.baidu.tieba.im.chat.a.b
        public void onProgressUpdate(int i, String str, int i2) {
            if (StrangerListActivity.this.knf != null) {
                StrangerListActivity.this.knf.setPercent(i);
            }
            StrangerListActivity.this.notifyDataSetChanged();
        }

        @Override // com.baidu.tieba.im.chat.a.b
        public void onPostExecute() {
            StrangerListActivity.this.ID();
            StrangerListActivity.this.showToast(R.string.delete_success, false);
            StrangerListActivity.this.cUj();
        }

        @Override // com.baidu.tieba.im.chat.a.b
        public void onCanceled() {
            StrangerListActivity.this.ID();
            StrangerListActivity.this.cUj();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kHw = this;
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
        ID();
        super.onDestroy();
    }

    private void registerListener() {
        registerListener(CmdConfigCustom.MEMORY_CHANGED, this.kng);
        registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.kng);
        registerListener(CmdConfigCustom.MEMORY_CLEAR, this.kng);
        registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.kng);
        registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.kng);
    }

    private void a(StrangerListActivity strangerListActivity) {
        this.kHu = new b(strangerListActivity);
        this.kHx = new com.baidu.tbadk.core.dialog.a(strangerListActivity.getPageContext().getPageActivity());
        this.kHx.oQ(R.string.sure_to_delete_all_stranger_msg);
        this.kHx.a(R.string.confirm, this.kHy);
        this.kHx.b(R.string.cancel, this.kHz);
        this.kHx.b(strangerListActivity.getPageContext());
    }

    private void initData() {
        this.kHv = new StrangerListModel(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.kHu != null) {
            this.kHu.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ImMessageCenterShowItemData DM;
        if (this.kHu != null && this.kHu.dbo() != null && (DM = this.kHu.dbo().getItem(i)) != null) {
            PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(this.kHw.getPageContext().getContext(), com.baidu.adp.lib.f.b.toLong(DM.getFriendId(), 0L), DM.getFriendName(), DM.getFriendNameShow(), DM.getFriendPortrait(), 0, 0);
            personalChatActivityConfig.setFollowStatus(0);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, personalChatActivityConfig));
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        final ImMessageCenterShowItemData DM;
        if (this.kHu == null || this.kHu.dbo() == null || (DM = this.kHu.dbo().getItem(i)) == null) {
            return false;
        }
        final int size = this.kHv.getData().size();
        final i iVar = new i(getPageContext());
        iVar.a(null, new String[]{TbadkCoreApplication.getInst().getString(R.string.delete_user_chat)}, new k.c() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.StrangerListActivity.1
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i2, View view2) {
                if (iVar != null && iVar.isShowing()) {
                    iVar.dismiss();
                }
                if (size == 1) {
                    StrangerListActivity.this.kHv.a(StrangerListActivity.this.knj);
                } else {
                    StrangerListActivity.this.kHv.asyncDeleteItem(DM, StrangerListActivity.this.knj);
                }
            }
        });
        iVar.RU();
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.kHu.dbp() && this.kHx != null) {
            this.kHx.brv();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.kHu != null && this.kHu.dbo() != null) {
            this.kHu.dbo().notifyDataSetChanged();
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
                if (this.kHv != null) {
                    this.kHv.insertOrUpdate(data, this.kni);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.kHv != null) {
                this.kHv.remove(data, this.kni);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 3 && this.kHv != null) {
                this.kHv.setData(data, this.kni);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cUi() {
        ID();
        if (this.knf == null) {
            this.knf = e.cVR().gf(getPageContext().getPageActivity());
        }
        this.knf.show();
        this.knf.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ID() {
        if (this.knf != null && this.knf.isShowing()) {
            this.knf.dismiss();
            this.knf = null;
        }
        closeLoadingDialog();
        dismissAllDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyDataSetChanged() {
        if (this.kHu != null && this.kHu.dbo() != null) {
            this.kHu.dbo().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cUj() {
        if (this.kHu != null && this.kHu.dbo() != null && this.kHv != null) {
            if (this.kHv != null && this.kHv.isEmpty()) {
                finish();
            }
            this.kHu.dbo().setData(this.kHv.getData());
        }
    }
}
