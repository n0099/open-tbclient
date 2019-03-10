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
    private d geg;
    private b gwZ;
    private StrangerListModel gxa;
    private StrangerListActivity gxb;
    private com.baidu.tbadk.core.dialog.a gxc;
    private a.b gxd = new a.b() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.StrangerListActivity.2
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            StrangerListActivity.this.gxc.dismiss();
            StrangerListActivity.this.gxa.a(StrangerListActivity.this.gek);
        }
    };
    private a.b gxe = new a.b() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.StrangerListActivity.3
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            StrangerListActivity.this.gxc.dismiss();
        }
    };
    private final CustomMessageListener geh = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.im.stranger.StrangerListActivity.4
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
                    StrangerListActivity.this.gxa.setData(null, StrangerListActivity.this.gej);
                } else if (customResponsedMessage.getCmd() == 2016011 && StrangerListActivity.this.gwZ != null && StrangerListActivity.this.gwZ.bxr() != null) {
                    StrangerListActivity.this.gwZ.bxr().notifyDataSetChanged();
                }
            }
        }
    };
    private com.baidu.tieba.im.chat.a.a gej = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.StrangerListActivity.5
        @Override // com.baidu.tieba.im.chat.a.a
        public void onComplete() {
            StrangerListActivity.this.bqC();
        }
    };
    private final com.baidu.tieba.im.chat.a.b gek = new com.baidu.tieba.im.chat.a.b() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.StrangerListActivity.6
        @Override // com.baidu.tieba.im.chat.a.b
        public void onPreExecute() {
            StrangerListActivity.this.ban();
        }

        @Override // com.baidu.tieba.im.chat.a.b
        public void onProgressUpdate(int i, String str, int i2) {
            if (StrangerListActivity.this.geg != null) {
                StrangerListActivity.this.geg.setPercent(i);
            }
            StrangerListActivity.this.notifyDataSetChanged();
        }

        @Override // com.baidu.tieba.im.chat.a.b
        public void onPostExecute() {
            StrangerListActivity.this.atz();
            StrangerListActivity.this.showToast(d.j.delete_success, false);
            StrangerListActivity.this.bqC();
        }

        @Override // com.baidu.tieba.im.chat.a.b
        public void onCanceled() {
            StrangerListActivity.this.atz();
            StrangerListActivity.this.bqC();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gxb = this;
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
        atz();
        super.onDestroy();
    }

    private void registerListener() {
        registerListener(2016004, this.geh);
        registerListener(2016007, this.geh);
        registerListener(2016001, this.geh);
        registerListener(2016011, this.geh);
        registerListener(2016002, this.geh);
    }

    private void a(StrangerListActivity strangerListActivity) {
        this.gwZ = new b(strangerListActivity);
        this.gxc = new com.baidu.tbadk.core.dialog.a(strangerListActivity.getPageContext().getPageActivity());
        this.gxc.gD(d.j.sure_to_delete_all_stranger_msg);
        this.gxc.a(d.j.confirm, this.gxd);
        this.gxc.b(d.j.cancel, this.gxe);
        this.gxc.b(strangerListActivity.getPageContext());
    }

    private void initData() {
        this.gxa = new StrangerListModel(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.gwZ != null) {
            this.gwZ.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ImMessageCenterShowItemData tB;
        if (this.gwZ != null && this.gwZ.bxr() != null && (tB = this.gwZ.bxr().getItem(i)) != null) {
            PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(this.gxb.getPageContext().getContext(), com.baidu.adp.lib.g.b.d(tB.getFriendId(), 0L), tB.getFriendName(), tB.getFriendNameShow(), tB.getFriendPortrait(), 0, 0);
            personalChatActivityConfig.setFollowStatus(0);
            sendMessage(new CustomMessage(2002005, personalChatActivityConfig));
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        final ImMessageCenterShowItemData tB;
        if (this.gwZ == null || this.gwZ.bxr() == null || (tB = this.gwZ.bxr().getItem(i)) == null) {
            return false;
        }
        final int size = this.gxa.getData().size();
        final g gVar = new g(getPageContext());
        gVar.a(null, new String[]{TbadkCoreApplication.getInst().getString(d.j.delete_user_chat)}, new i.c() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.StrangerListActivity.1
            @Override // com.baidu.tbadk.core.dialog.i.c
            public void a(i iVar, int i2, View view2) {
                if (gVar != null && gVar.isShowing()) {
                    gVar.dismiss();
                }
                if (size == 1) {
                    StrangerListActivity.this.gxa.a(StrangerListActivity.this.gek);
                } else {
                    StrangerListActivity.this.gxa.asyncDeleteItem(tB, StrangerListActivity.this.gek);
                }
            }
        });
        gVar.showDialog();
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.gwZ.bxs() && this.gxc != null) {
            this.gxc.aaZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.gwZ != null && this.gwZ.bxr() != null) {
            this.gwZ.bxr().notifyDataSetChanged();
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
                if (this.gxa != null) {
                    this.gxa.insertOrUpdate(data, this.gej);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.gxa != null) {
                this.gxa.remove(data, this.gej);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 3 && this.gxa != null) {
                this.gxa.setData(data, this.gej);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ban() {
        atz();
        if (this.geg == null) {
            this.geg = e.bsk().dZ(getPageContext().getPageActivity());
        }
        this.geg.show();
        this.geg.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atz() {
        if (this.geg != null && this.geg.isShowing()) {
            this.geg.dismiss();
            this.geg = null;
        }
        closeLoadingDialog();
        dismissAllDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyDataSetChanged() {
        if (this.gwZ != null && this.gwZ.bxr() != null) {
            this.gwZ.bxr().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqC() {
        if (this.gwZ != null && this.gwZ.bxr() != null && this.gxa != null) {
            if (this.gxa != null && this.gxa.isEmpty()) {
                finish();
            }
            this.gwZ.bxr().setData(this.gxa.getData());
        }
    }
}
