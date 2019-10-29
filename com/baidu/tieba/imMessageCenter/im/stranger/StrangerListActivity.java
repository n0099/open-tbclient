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
/* loaded from: classes4.dex */
public class StrangerListActivity extends BaseActivity<StrangerListActivity> {
    private d gCd;
    private b gUX;
    private StrangerListModel gUY;
    private StrangerListActivity gUZ;
    private com.baidu.tbadk.core.dialog.a gVa;
    private a.b gVb = new a.b() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.StrangerListActivity.2
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            StrangerListActivity.this.gVa.dismiss();
            StrangerListActivity.this.gUY.a(StrangerListActivity.this.gCh);
        }
    };
    private a.b gVc = new a.b() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.StrangerListActivity.3
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            StrangerListActivity.this.gVa.dismiss();
        }
    };
    private final CustomMessageListener gCe = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.im.stranger.StrangerListActivity.4
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
                    StrangerListActivity.this.gUY.setData(null, StrangerListActivity.this.gCg);
                } else if (customResponsedMessage.getCmd() == 2016011 && StrangerListActivity.this.gUX != null && StrangerListActivity.this.gUX.bFs() != null) {
                    StrangerListActivity.this.gUX.bFs().notifyDataSetChanged();
                }
            }
        }
    };
    private com.baidu.tieba.im.chat.a.a gCg = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.StrangerListActivity.5
        @Override // com.baidu.tieba.im.chat.a.a
        public void onComplete() {
            StrangerListActivity.this.byF();
        }
    };
    private final com.baidu.tieba.im.chat.a.b gCh = new com.baidu.tieba.im.chat.a.b() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.StrangerListActivity.6
        @Override // com.baidu.tieba.im.chat.a.b
        public void onPreExecute() {
            StrangerListActivity.this.byE();
        }

        @Override // com.baidu.tieba.im.chat.a.b
        public void onProgressUpdate(int i, String str, int i2) {
            if (StrangerListActivity.this.gCd != null) {
                StrangerListActivity.this.gCd.setPercent(i);
            }
            StrangerListActivity.this.notifyDataSetChanged();
        }

        @Override // com.baidu.tieba.im.chat.a.b
        public void onPostExecute() {
            StrangerListActivity.this.aAm();
            StrangerListActivity.this.showToast(R.string.delete_success, false);
            StrangerListActivity.this.byF();
        }

        @Override // com.baidu.tieba.im.chat.a.b
        public void onCanceled() {
            StrangerListActivity.this.aAm();
            StrangerListActivity.this.byF();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gUZ = this;
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
        aAm();
        super.onDestroy();
    }

    private void registerListener() {
        registerListener(CmdConfigCustom.MEMORY_CHANGED, this.gCe);
        registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.gCe);
        registerListener(CmdConfigCustom.MEMORY_CLEAR, this.gCe);
        registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.gCe);
        registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.gCe);
    }

    private void a(StrangerListActivity strangerListActivity) {
        this.gUX = new b(strangerListActivity);
        this.gVa = new com.baidu.tbadk.core.dialog.a(strangerListActivity.getPageContext().getPageActivity());
        this.gVa.hU(R.string.sure_to_delete_all_stranger_msg);
        this.gVa.a(R.string.confirm, this.gVb);
        this.gVa.b(R.string.cancel, this.gVc);
        this.gVa.b(strangerListActivity.getPageContext());
    }

    private void initData() {
        this.gUY = new StrangerListModel(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.gUX != null) {
            this.gUX.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ImMessageCenterShowItemData tQ;
        if (this.gUX != null && this.gUX.bFs() != null && (tQ = this.gUX.bFs().getItem(i)) != null) {
            PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(this.gUZ.getPageContext().getContext(), com.baidu.adp.lib.g.b.toLong(tQ.getFriendId(), 0L), tQ.getFriendName(), tQ.getFriendNameShow(), tQ.getFriendPortrait(), 0, 0);
            personalChatActivityConfig.setFollowStatus(0);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, personalChatActivityConfig));
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        final ImMessageCenterShowItemData tQ;
        if (this.gUX == null || this.gUX.bFs() == null || (tQ = this.gUX.bFs().getItem(i)) == null) {
            return false;
        }
        final int size = this.gUY.getData().size();
        final i iVar = new i(getPageContext());
        iVar.a(null, new String[]{TbadkCoreApplication.getInst().getString(R.string.delete_user_chat)}, new k.c() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.StrangerListActivity.1
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i2, View view2) {
                if (iVar != null && iVar.isShowing()) {
                    iVar.dismiss();
                }
                if (size == 1) {
                    StrangerListActivity.this.gUY.a(StrangerListActivity.this.gCh);
                } else {
                    StrangerListActivity.this.gUY.asyncDeleteItem(tQ, StrangerListActivity.this.gCh);
                }
            }
        });
        iVar.showDialog();
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.gUX.bFt() && this.gVa != null) {
            this.gVa.akO();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.gUX != null && this.gUX.bFs() != null) {
            this.gUX.bFs().notifyDataSetChanged();
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
                if (this.gUY != null) {
                    this.gUY.insertOrUpdate(data, this.gCg);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.gUY != null) {
                this.gUY.remove(data, this.gCg);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 3 && this.gUY != null) {
                this.gUY.setData(data, this.gCg);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byE() {
        aAm();
        if (this.gCd == null) {
            this.gCd = e.bAn().dE(getPageContext().getPageActivity());
        }
        this.gCd.show();
        this.gCd.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAm() {
        if (this.gCd != null && this.gCd.isShowing()) {
            this.gCd.dismiss();
            this.gCd = null;
        }
        closeLoadingDialog();
        dismissAllDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyDataSetChanged() {
        if (this.gUX != null && this.gUX.bFs() != null) {
            this.gUX.bFs().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byF() {
        if (this.gUX != null && this.gUX.bFs() != null && this.gUY != null) {
            if (this.gUY != null && this.gUY.isEmpty()) {
                finish();
            }
            this.gUX.bFs().setData(this.gUY.getData());
        }
    }
}
