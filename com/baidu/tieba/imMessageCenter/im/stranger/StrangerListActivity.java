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
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.MemoryInitCompleteMessage;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
import com.baidu.tieba.im.message.ResponsedMemoryListMessage;
import com.baidu.tieba.t;
import java.util.List;
/* loaded from: classes.dex */
public class StrangerListActivity extends BaseActivity<StrangerListActivity> {
    private com.baidu.tbadk.core.dialog.a bwA;
    private j bwx;
    private StrangerListModel bwy;
    private StrangerListActivity bwz;
    private com.baidu.tbadk.core.dialog.d bwB = new e(this);
    private com.baidu.tbadk.core.dialog.d bwC = new f(this);
    private final CustomMessageListener bcz = new g(this, 0);
    private com.baidu.tieba.im.chat.notify.a bcA = new h(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bwz = this;
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

    private void registerListener() {
        registerListener(2016004, this.bcz);
        registerListener(2016007, this.bcz);
        registerListener(2016001, this.bcz);
        registerListener(2016011, this.bcz);
        registerListener(2016002, this.bcz);
    }

    private void a(StrangerListActivity strangerListActivity) {
        this.bwx = new j(strangerListActivity);
        this.bwA = new com.baidu.tbadk.core.dialog.a(strangerListActivity.getPageContext().getPageActivity());
        this.bwA.bu(t.sure_to_delete_all_stranger_msg);
        this.bwA.a(t.alert_yes_btn, this.bwB);
        this.bwA.b(t.cancel, this.bwC);
        this.bwA.b(strangerListActivity.getPageContext());
    }

    private void initData() {
        this.bwy = new StrangerListModel(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.bwx != null) {
            this.bwx.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ImMessageCenterShowItemData fT;
        if (this.bwx != null && this.bwx.Xn() != null && (fT = this.bwx.Xn().getItem(i)) != null) {
            sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(this.bwz.getPageContext().getContext(), com.baidu.adp.lib.g.c.c(fT.getFriendId(), 0L), fT.getFriendName(), fT.getFriendPortrait(), 0, 0)));
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        ImMessageCenterShowItemData fT;
        if (this.bwx == null || this.bwx.Xn() == null || (fT = this.bwx.Xn().getItem(i)) == null) {
            return false;
        }
        com.baidu.tbadk.coreExtra.util.a.a(getPageContext().getContext(), new i(this, this.bwy.getData().size(), fT));
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.bwx.Xo() && this.bwA != null) {
            this.bwA.rL();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.bwx != null && this.bwx.Xn() != null) {
            this.bwx.Xn().notifyDataSetChanged();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new com.baidu.tbadk.live.message.a("-1001", -7)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(CustomResponsedMessage<?> customResponsedMessage) {
        if ((customResponsedMessage instanceof MemoryInitCompleteMessage) && ((MemoryInitCompleteMessage) customResponsedMessage).getData().booleanValue()) {
            sendMessage(new RequestMemoryListMessage(3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof MemoryChangedMessage) {
            MemoryChangedMessage memoryChangedMessage = (MemoryChangedMessage) customResponsedMessage;
            ImMessageCenterPojo data = memoryChangedMessage.getData();
            if (memoryChangedMessage.getType() == 1) {
                if (this.bwy != null) {
                    this.bwy.insertOrUpdate(data, this.bcA);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.bwy != null) {
                this.bwy.remove(data, this.bcA);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 3 && this.bwy != null) {
                this.bwy.setData(data, this.bcA);
            }
        }
    }
}
