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
    private d gef;
    private b gwY;
    private StrangerListModel gwZ;
    private StrangerListActivity gxa;
    private com.baidu.tbadk.core.dialog.a gxb;
    private a.b gxc = new a.b() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.StrangerListActivity.2
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            StrangerListActivity.this.gxb.dismiss();
            StrangerListActivity.this.gwZ.a(StrangerListActivity.this.gej);
        }
    };
    private a.b gxd = new a.b() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.StrangerListActivity.3
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            StrangerListActivity.this.gxb.dismiss();
        }
    };
    private final CustomMessageListener geg = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.im.stranger.StrangerListActivity.4
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
                    StrangerListActivity.this.gwZ.setData(null, StrangerListActivity.this.gei);
                } else if (customResponsedMessage.getCmd() == 2016011 && StrangerListActivity.this.gwY != null && StrangerListActivity.this.gwY.bxq() != null) {
                    StrangerListActivity.this.gwY.bxq().notifyDataSetChanged();
                }
            }
        }
    };
    private com.baidu.tieba.im.chat.a.a gei = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.StrangerListActivity.5
        @Override // com.baidu.tieba.im.chat.a.a
        public void onComplete() {
            StrangerListActivity.this.bqB();
        }
    };
    private final com.baidu.tieba.im.chat.a.b gej = new com.baidu.tieba.im.chat.a.b() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.StrangerListActivity.6
        @Override // com.baidu.tieba.im.chat.a.b
        public void onPreExecute() {
            StrangerListActivity.this.bam();
        }

        @Override // com.baidu.tieba.im.chat.a.b
        public void onProgressUpdate(int i, String str, int i2) {
            if (StrangerListActivity.this.gef != null) {
                StrangerListActivity.this.gef.setPercent(i);
            }
            StrangerListActivity.this.notifyDataSetChanged();
        }

        @Override // com.baidu.tieba.im.chat.a.b
        public void onPostExecute() {
            StrangerListActivity.this.aty();
            StrangerListActivity.this.showToast(d.j.delete_success, false);
            StrangerListActivity.this.bqB();
        }

        @Override // com.baidu.tieba.im.chat.a.b
        public void onCanceled() {
            StrangerListActivity.this.aty();
            StrangerListActivity.this.bqB();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gxa = this;
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
        aty();
        super.onDestroy();
    }

    private void registerListener() {
        registerListener(2016004, this.geg);
        registerListener(2016007, this.geg);
        registerListener(2016001, this.geg);
        registerListener(2016011, this.geg);
        registerListener(2016002, this.geg);
    }

    private void a(StrangerListActivity strangerListActivity) {
        this.gwY = new b(strangerListActivity);
        this.gxb = new com.baidu.tbadk.core.dialog.a(strangerListActivity.getPageContext().getPageActivity());
        this.gxb.gD(d.j.sure_to_delete_all_stranger_msg);
        this.gxb.a(d.j.confirm, this.gxc);
        this.gxb.b(d.j.cancel, this.gxd);
        this.gxb.b(strangerListActivity.getPageContext());
    }

    private void initData() {
        this.gwZ = new StrangerListModel(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.gwY != null) {
            this.gwY.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ImMessageCenterShowItemData tB;
        if (this.gwY != null && this.gwY.bxq() != null && (tB = this.gwY.bxq().getItem(i)) != null) {
            PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(this.gxa.getPageContext().getContext(), com.baidu.adp.lib.g.b.d(tB.getFriendId(), 0L), tB.getFriendName(), tB.getFriendNameShow(), tB.getFriendPortrait(), 0, 0);
            personalChatActivityConfig.setFollowStatus(0);
            sendMessage(new CustomMessage(2002005, personalChatActivityConfig));
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        final ImMessageCenterShowItemData tB;
        if (this.gwY == null || this.gwY.bxq() == null || (tB = this.gwY.bxq().getItem(i)) == null) {
            return false;
        }
        final int size = this.gwZ.getData().size();
        final g gVar = new g(getPageContext());
        gVar.a(null, new String[]{TbadkCoreApplication.getInst().getString(d.j.delete_user_chat)}, new i.c() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.StrangerListActivity.1
            @Override // com.baidu.tbadk.core.dialog.i.c
            public void a(i iVar, int i2, View view2) {
                if (gVar != null && gVar.isShowing()) {
                    gVar.dismiss();
                }
                if (size == 1) {
                    StrangerListActivity.this.gwZ.a(StrangerListActivity.this.gej);
                } else {
                    StrangerListActivity.this.gwZ.asyncDeleteItem(tB, StrangerListActivity.this.gej);
                }
            }
        });
        gVar.showDialog();
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.gwY.bxr() && this.gxb != null) {
            this.gxb.aaZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.gwY != null && this.gwY.bxq() != null) {
            this.gwY.bxq().notifyDataSetChanged();
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
                if (this.gwZ != null) {
                    this.gwZ.insertOrUpdate(data, this.gei);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.gwZ != null) {
                this.gwZ.remove(data, this.gei);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 3 && this.gwZ != null) {
                this.gwZ.setData(data, this.gei);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bam() {
        aty();
        if (this.gef == null) {
            this.gef = e.bsj().dY(getPageContext().getPageActivity());
        }
        this.gef.show();
        this.gef.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aty() {
        if (this.gef != null && this.gef.isShowing()) {
            this.gef.dismiss();
            this.gef = null;
        }
        closeLoadingDialog();
        dismissAllDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyDataSetChanged() {
        if (this.gwY != null && this.gwY.bxq() != null) {
            this.gwY.bxq().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqB() {
        if (this.gwY != null && this.gwY.bxq() != null && this.gwZ != null) {
            if (this.gwZ != null && this.gwZ.isEmpty()) {
                finish();
            }
            this.gwY.bxq().setData(this.gwZ.getData());
        }
    }
}
