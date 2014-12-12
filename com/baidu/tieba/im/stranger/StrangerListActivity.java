package com.baidu.tieba.im.stranger;

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
import com.baidu.tbadk.core.atomData.StrangerListActivityConfig;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.MemoryInitCompleteMessage;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
import com.baidu.tieba.im.message.ResponsedMemoryListMessage;
import com.baidu.tieba.z;
import java.util.List;
/* loaded from: classes.dex */
public class StrangerListActivity extends BaseActivity<StrangerListActivity> {
    private f bnO;
    private StrangerListModel bnP;
    private StrangerListActivity bnQ;
    private com.baidu.tbadk.core.dialog.a bnR;
    private com.baidu.tbadk.core.dialog.d bnS = new a(this);
    private com.baidu.tbadk.core.dialog.d bnT = new b(this);
    private final CustomMessageListener aSs = new c(this, 0);
    private com.baidu.tieba.im.chat.notify.a aSt = new d(this);

    static {
        TbadkCoreApplication.m255getInst().RegisterIntent(StrangerListActivityConfig.class, StrangerListActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bnQ = this;
        a(this);
        initData();
        registerListener();
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        ChatStatusManager.getInst().setIsOpen(5, true);
    }

    @Override // android.app.Activity
    protected void onStart() {
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
        registerListener(2016003, this.aSs);
        registerListener(2016006, this.aSs);
        registerListener(2016000, this.aSs);
        registerListener(2016011, this.aSs);
        registerListener(2016001, this.aSs);
    }

    private void a(StrangerListActivity strangerListActivity) {
        this.bnO = new f(strangerListActivity);
        this.bnR = new com.baidu.tbadk.core.dialog.a(strangerListActivity.getPageContext().getPageActivity());
        this.bnR.bt(z.sure_to_delete_all_stranger_msg);
        this.bnR.a(z.alert_yes_btn, this.bnS);
        this.bnR.b(z.cancel, this.bnT);
        this.bnR.b(strangerListActivity.getPageContext());
    }

    private void initData() {
        this.bnP = new StrangerListModel(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.bnO != null) {
            this.bnO.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ImMessageCenterShowItemData fu;
        if (this.bnO != null && this.bnO.Tb() != null && (fu = this.bnO.Tb().getItem(i)) != null) {
            sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(this.bnQ.getPageContext().getContext(), com.baidu.adp.lib.g.c.a(fu.getFriendId(), 0L), fu.getFriendName(), fu.getFriendPortrait(), 0, 0)));
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        ImMessageCenterShowItemData fu;
        if (this.bnO == null || this.bnO.Tb() == null || (fu = this.bnO.Tb().getItem(i)) == null) {
            return false;
        }
        com.baidu.tbadk.coreExtra.util.a.a(getPageContext().getContext(), new e(this, this.bnP.getData().size(), fu));
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.bnO.Tc() && this.bnR != null) {
            this.bnR.nU();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.bnO != null && this.bnO.Tb() != null) {
            this.bnO.Tb().notifyDataSetChanged();
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
                if (this.bnP != null) {
                    this.bnP.insertOrUpdate(data, this.aSt);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.bnP != null) {
                this.bnP.remove(data, this.aSt);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 3 && this.bnP != null) {
                this.bnP.setData(data, this.aSt);
            }
        }
    }
}
