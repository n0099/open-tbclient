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
    private f bik;
    private StrangerListModel bil;
    private StrangerListActivity bim;
    private com.baidu.tbadk.core.dialog.a bin;
    private com.baidu.tbadk.core.dialog.d bio = new a(this);
    private com.baidu.tbadk.core.dialog.d bip = new b(this);
    private final CustomMessageListener aQA = new c(this, 0);
    private com.baidu.tieba.im.chat.notify.a aQB = new d(this);

    static {
        TbadkApplication.m251getInst().RegisterIntent(StrangerListActivityConfig.class, StrangerListActivity.class);
        isOpen = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bim = this;
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
        registerListener(2016003, this.aQA);
        registerListener(2016006, this.aQA);
        registerListener(2016000, this.aQA);
        registerListener(2016011, this.aQA);
        registerListener(2016001, this.aQA);
    }

    private void a(StrangerListActivity strangerListActivity) {
        this.bik = new f(strangerListActivity);
        this.bin = new com.baidu.tbadk.core.dialog.a(strangerListActivity);
        this.bin.aX(y.sure_to_delete_all_stranger_msg);
        this.bin.a(y.alert_yes_btn, this.bio);
        this.bin.b(y.cancel, this.bip);
        this.bin.kT();
    }

    private void initData() {
        this.bil = new StrangerListModel(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.bik != null) {
            this.bik.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ImMessageCenterShowItemData fr;
        if (this.bik != null && this.bik.RE() != null && (fr = this.bik.RE().getItem(i)) != null) {
            sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(this.bim, com.baidu.adp.lib.g.c.a(fr.getFriendId(), 0L), fr.getFriendName(), fr.getFriendPortrait(), 0, 0)));
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        ImMessageCenterShowItemData fr;
        if (this.bik == null || this.bik.RE() == null || (fr = this.bik.RE().getItem(i)) == null) {
            return false;
        }
        DialogUtil.deleteItem(this, new e(this, this.bil.getData().size(), fr));
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.bik.RF() && this.bin != null) {
            this.bin.kW();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.bik != null && this.bik.RE() != null) {
            this.bik.RE().notifyDataSetChanged();
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
                if (this.bil != null) {
                    this.bil.insertOrUpdate(data, this.aQB);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.bil != null) {
                this.bil.remove(data, this.aQB);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 3 && this.bil != null) {
                this.bil.setData(data, this.aQB);
            }
        }
    }
}
