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
/* loaded from: classes16.dex */
public class StrangerListActivity extends BaseActivity<StrangerListActivity> {
    private b jDn;
    private StrangerListModel jDo;
    private StrangerListActivity jDp;
    private com.baidu.tbadk.core.dialog.a jDq;
    private d jiM;
    private a.b jDr = new a.b() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.StrangerListActivity.2
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            StrangerListActivity.this.jDq.dismiss();
            StrangerListActivity.this.jDo.a(StrangerListActivity.this.jiQ);
        }
    };
    private a.b jDs = new a.b() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.StrangerListActivity.3
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            StrangerListActivity.this.jDq.dismiss();
        }
    };
    private final CustomMessageListener jiN = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.im.stranger.StrangerListActivity.4
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
                    StrangerListActivity.this.jDo.setData(null, StrangerListActivity.this.jiP);
                } else if (customResponsedMessage.getCmd() == 2016011 && StrangerListActivity.this.jDn != null && StrangerListActivity.this.jDn.cJy() != null) {
                    StrangerListActivity.this.jDn.cJy().notifyDataSetChanged();
                }
            }
        }
    };
    private com.baidu.tieba.im.chat.a.a jiP = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.StrangerListActivity.5
        @Override // com.baidu.tieba.im.chat.a.a
        public void onComplete() {
            StrangerListActivity.this.cCq();
        }
    };
    private final com.baidu.tieba.im.chat.a.b jiQ = new com.baidu.tieba.im.chat.a.b() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.StrangerListActivity.6
        @Override // com.baidu.tieba.im.chat.a.b
        public void onPreExecute() {
            StrangerListActivity.this.cCp();
        }

        @Override // com.baidu.tieba.im.chat.a.b
        public void onProgressUpdate(int i, String str, int i2) {
            if (StrangerListActivity.this.jiM != null) {
                StrangerListActivity.this.jiM.setPercent(i);
            }
            StrangerListActivity.this.notifyDataSetChanged();
        }

        @Override // com.baidu.tieba.im.chat.a.b
        public void onPostExecute() {
            StrangerListActivity.this.Fd();
            StrangerListActivity.this.showToast(R.string.delete_success, false);
            StrangerListActivity.this.cCq();
        }

        @Override // com.baidu.tieba.im.chat.a.b
        public void onCanceled() {
            StrangerListActivity.this.Fd();
            StrangerListActivity.this.cCq();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jDp = this;
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
        Fd();
        super.onDestroy();
    }

    private void registerListener() {
        registerListener(CmdConfigCustom.MEMORY_CHANGED, this.jiN);
        registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.jiN);
        registerListener(CmdConfigCustom.MEMORY_CLEAR, this.jiN);
        registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.jiN);
        registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.jiN);
    }

    private void a(StrangerListActivity strangerListActivity) {
        this.jDn = new b(strangerListActivity);
        this.jDq = new com.baidu.tbadk.core.dialog.a(strangerListActivity.getPageContext().getPageActivity());
        this.jDq.nt(R.string.sure_to_delete_all_stranger_msg);
        this.jDq.a(R.string.confirm, this.jDr);
        this.jDq.b(R.string.cancel, this.jDs);
        this.jDq.b(strangerListActivity.getPageContext());
    }

    private void initData() {
        this.jDo = new StrangerListModel(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.jDn != null) {
            this.jDn.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ImMessageCenterShowItemData AM;
        if (this.jDn != null && this.jDn.cJy() != null && (AM = this.jDn.cJy().getItem(i)) != null) {
            PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(this.jDp.getPageContext().getContext(), com.baidu.adp.lib.f.b.toLong(AM.getFriendId(), 0L), AM.getFriendName(), AM.getFriendNameShow(), AM.getFriendPortrait(), 0, 0);
            personalChatActivityConfig.setFollowStatus(0);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, personalChatActivityConfig));
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        final ImMessageCenterShowItemData AM;
        if (this.jDn == null || this.jDn.cJy() == null || (AM = this.jDn.cJy().getItem(i)) == null) {
            return false;
        }
        final int size = this.jDo.getData().size();
        final i iVar = new i(getPageContext());
        iVar.a(null, new String[]{TbadkCoreApplication.getInst().getString(R.string.delete_user_chat)}, new k.c() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.StrangerListActivity.1
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i2, View view2) {
                if (iVar != null && iVar.isShowing()) {
                    iVar.dismiss();
                }
                if (size == 1) {
                    StrangerListActivity.this.jDo.a(StrangerListActivity.this.jiQ);
                } else {
                    StrangerListActivity.this.jDo.asyncDeleteItem(AM, StrangerListActivity.this.jiQ);
                }
            }
        });
        iVar.Nv();
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.jDn.cJz() && this.jDq != null) {
            this.jDq.bhg();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.jDn != null && this.jDn.cJy() != null) {
            this.jDn.cJy().notifyDataSetChanged();
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
                if (this.jDo != null) {
                    this.jDo.insertOrUpdate(data, this.jiP);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.jDo != null) {
                this.jDo.remove(data, this.jiP);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 3 && this.jDo != null) {
                this.jDo.setData(data, this.jiP);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCp() {
        Fd();
        if (this.jiM == null) {
            this.jiM = e.cDY().fl(getPageContext().getPageActivity());
        }
        this.jiM.show();
        this.jiM.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fd() {
        if (this.jiM != null && this.jiM.isShowing()) {
            this.jiM.dismiss();
            this.jiM = null;
        }
        closeLoadingDialog();
        dismissAllDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyDataSetChanged() {
        if (this.jDn != null && this.jDn.cJy() != null) {
            this.jDn.cJy().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCq() {
        if (this.jDn != null && this.jDn.cJy() != null && this.jDo != null) {
            if (this.jDo != null && this.jDo.isEmpty()) {
                finish();
            }
            this.jDn.cJy().setData(this.jDo.getData());
        }
    }
}
