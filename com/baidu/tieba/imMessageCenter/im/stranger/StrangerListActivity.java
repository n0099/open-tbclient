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
/* loaded from: classes9.dex */
public class StrangerListActivity extends BaseActivity<StrangerListActivity> {
    private b iOc;
    private StrangerListModel iOd;
    private StrangerListActivity iOe;
    private com.baidu.tbadk.core.dialog.a iOf;
    private d ivj;
    private a.b iOg = new a.b() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.StrangerListActivity.2
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            StrangerListActivity.this.iOf.dismiss();
            StrangerListActivity.this.iOd.a(StrangerListActivity.this.ivn);
        }
    };
    private a.b iOh = new a.b() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.StrangerListActivity.3
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            StrangerListActivity.this.iOf.dismiss();
        }
    };
    private final CustomMessageListener ivk = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.im.stranger.StrangerListActivity.4
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
                    StrangerListActivity.this.iOd.setData(null, StrangerListActivity.this.ivm);
                } else if (customResponsedMessage.getCmd() == 2016011 && StrangerListActivity.this.iOc != null && StrangerListActivity.this.iOc.cqF() != null) {
                    StrangerListActivity.this.iOc.cqF().notifyDataSetChanged();
                }
            }
        }
    };
    private com.baidu.tieba.im.chat.a.a ivm = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.StrangerListActivity.5
        @Override // com.baidu.tieba.im.chat.a.a
        public void onComplete() {
            StrangerListActivity.this.cjW();
        }
    };
    private final com.baidu.tieba.im.chat.a.b ivn = new com.baidu.tieba.im.chat.a.b() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.StrangerListActivity.6
        @Override // com.baidu.tieba.im.chat.a.b
        public void onPreExecute() {
            StrangerListActivity.this.cjV();
        }

        @Override // com.baidu.tieba.im.chat.a.b
        public void onProgressUpdate(int i, String str, int i2) {
            if (StrangerListActivity.this.ivj != null) {
                StrangerListActivity.this.ivj.setPercent(i);
            }
            StrangerListActivity.this.notifyDataSetChanged();
        }

        @Override // com.baidu.tieba.im.chat.a.b
        public void onPostExecute() {
            StrangerListActivity.this.yy();
            StrangerListActivity.this.showToast(R.string.delete_success, false);
            StrangerListActivity.this.cjW();
        }

        @Override // com.baidu.tieba.im.chat.a.b
        public void onCanceled() {
            StrangerListActivity.this.yy();
            StrangerListActivity.this.cjW();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iOe = this;
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
        yy();
        super.onDestroy();
    }

    private void registerListener() {
        registerListener(CmdConfigCustom.MEMORY_CHANGED, this.ivk);
        registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.ivk);
        registerListener(CmdConfigCustom.MEMORY_CLEAR, this.ivk);
        registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.ivk);
        registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.ivk);
    }

    private void a(StrangerListActivity strangerListActivity) {
        this.iOc = new b(strangerListActivity);
        this.iOf = new com.baidu.tbadk.core.dialog.a(strangerListActivity.getPageContext().getPageActivity());
        this.iOf.kD(R.string.sure_to_delete_all_stranger_msg);
        this.iOf.a(R.string.confirm, this.iOg);
        this.iOf.b(R.string.cancel, this.iOh);
        this.iOf.b(strangerListActivity.getPageContext());
    }

    private void initData() {
        this.iOd = new StrangerListModel(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.iOc != null) {
            this.iOc.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ImMessageCenterShowItemData xo;
        if (this.iOc != null && this.iOc.cqF() != null && (xo = this.iOc.cqF().getItem(i)) != null) {
            PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(this.iOe.getPageContext().getContext(), com.baidu.adp.lib.f.b.toLong(xo.getFriendId(), 0L), xo.getFriendName(), xo.getFriendNameShow(), xo.getFriendPortrait(), 0, 0);
            personalChatActivityConfig.setFollowStatus(0);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, personalChatActivityConfig));
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        final ImMessageCenterShowItemData xo;
        if (this.iOc == null || this.iOc.cqF() == null || (xo = this.iOc.cqF().getItem(i)) == null) {
            return false;
        }
        final int size = this.iOd.getData().size();
        final i iVar = new i(getPageContext());
        iVar.a(null, new String[]{TbadkCoreApplication.getInst().getString(R.string.delete_user_chat)}, new k.c() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.StrangerListActivity.1
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i2, View view2) {
                if (iVar != null && iVar.isShowing()) {
                    iVar.dismiss();
                }
                if (size == 1) {
                    StrangerListActivity.this.iOd.a(StrangerListActivity.this.ivn);
                } else {
                    StrangerListActivity.this.iOd.asyncDeleteItem(xo, StrangerListActivity.this.ivn);
                }
            }
        });
        iVar.showDialog();
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.iOc.cqG() && this.iOf != null) {
            this.iOf.aST();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.iOc != null && this.iOc.cqF() != null) {
            this.iOc.cqF().notifyDataSetChanged();
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
                if (this.iOd != null) {
                    this.iOd.insertOrUpdate(data, this.ivm);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.iOd != null) {
                this.iOd.remove(data, this.ivm);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 3 && this.iOd != null) {
                this.iOd.setData(data, this.ivm);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjV() {
        yy();
        if (this.ivj == null) {
            this.ivj = e.clD().eV(getPageContext().getPageActivity());
        }
        this.ivj.show();
        this.ivj.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yy() {
        if (this.ivj != null && this.ivj.isShowing()) {
            this.ivj.dismiss();
            this.ivj = null;
        }
        closeLoadingDialog();
        dismissAllDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyDataSetChanged() {
        if (this.iOc != null && this.iOc.cqF() != null) {
            this.iOc.cqF().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjW() {
        if (this.iOc != null && this.iOc.cqF() != null && this.iOd != null) {
            if (this.iOd != null && this.iOd.isEmpty()) {
                finish();
            }
            this.iOc.cqF().setData(this.iOd.getData());
        }
    }
}
