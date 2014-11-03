package com.baidu.tieba.im.stranger;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.StrangerListActivityConfig;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.MemoryInitCompleteMessage;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
import com.baidu.tieba.im.message.ResponsedMemoryListMessage;
import com.baidu.tieba.im.util.DialogUtil;
import com.baidu.tieba.y;
import java.util.List;
/* loaded from: classes.dex */
public class StrangerListActivity extends BaseActivity {
    public static boolean isOpen;
    private StrangerListActivity biA;
    private com.baidu.tbadk.core.dialog.a biB;
    private f biy;
    private StrangerListModel biz;
    private com.baidu.tbadk.core.dialog.d biC = new a(this);
    private com.baidu.tbadk.core.dialog.d biD = new b(this);
    private final CustomMessageListener aQO = new c(this, 0);
    private com.baidu.tieba.im.chat.notify.a aQP = new d(this);

    static {
        TbadkApplication.m251getInst().RegisterIntent(StrangerListActivityConfig.class, StrangerListActivity.class);
        isOpen = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.biA = this;
        a(this);
        initData();
        registerListener();
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        isOpen = true;
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        isOpen = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        isOpen = false;
    }

    private void registerListener() {
        registerListener(2016003, this.aQO);
        registerListener(2016006, this.aQO);
        registerListener(2016000, this.aQO);
        registerListener(2016011, this.aQO);
        registerListener(2016001, this.aQO);
    }

    private void a(StrangerListActivity strangerListActivity) {
        this.biy = new f(strangerListActivity);
        this.biB = new com.baidu.tbadk.core.dialog.a(strangerListActivity);
        this.biB.aX(y.sure_to_delete_all_stranger_msg);
        this.biB.a(y.alert_yes_btn, this.biC);
        this.biB.b(y.cancel, this.biD);
        this.biB.kT();
    }

    private void initData() {
        this.biz = new StrangerListModel(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.biy != null) {
            this.biy.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ImMessageCenterShowItemData fr;
        if (this.biy != null && this.biy.RH() != null && (fr = this.biy.RH().getItem(i)) != null) {
            sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(this.biA, com.baidu.adp.lib.g.c.a(fr.getFriendId(), 0L), fr.getFriendName(), fr.getFriendPortrait(), 0, 0)));
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        ImMessageCenterShowItemData fr;
        if (this.biy == null || this.biy.RH() == null || (fr = this.biy.RH().getItem(i)) == null) {
            return false;
        }
        DialogUtil.deleteItem(this, new e(this, this.biz.getData().size(), fr));
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.biy.RI() && this.biB != null) {
            this.biB.kW();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.biy != null && this.biy.RH() != null) {
            this.biy.RH().notifyDataSetChanged();
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
                if (this.biz != null) {
                    this.biz.insertOrUpdate(data, this.aQP);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.biz != null) {
                this.biz.remove(data, this.aQP);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 3 && this.biz != null) {
                this.biz.setData(data, this.aQP);
            }
        }
    }
}
