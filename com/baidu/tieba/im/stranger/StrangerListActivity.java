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
import com.baidu.tbadk.core.atomData.bk;
import com.baidu.tbadk.core.atomData.ca;
import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.MemoryClearUnreadCountMessage;
import com.baidu.tieba.im.message.MemoryInitCompleteMessage;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
import com.baidu.tieba.im.message.ResponsedMemoryListMessage;
import com.baidu.tieba.x;
import java.util.List;
/* loaded from: classes.dex */
public class StrangerListActivity extends BaseActivity {
    public static boolean a;
    private i b;
    private h c;
    private StrangerListActivity d;
    private com.baidu.tbadk.core.dialog.a e;
    private com.baidu.tbadk.core.dialog.d f = new a(this);
    private com.baidu.tbadk.core.dialog.d g = new b(this);
    private final CustomMessageListener h = new c(this, 0);
    private com.baidu.tieba.im.chat.notify.a i = new d(this);

    static {
        TbadkApplication.m252getInst().RegisterIntent(ca.class, StrangerListActivity.class);
        a = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.d = this;
        e(this);
        b();
        a();
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        a = true;
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        a = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        a = false;
    }

    private void a() {
        registerListener(2016003, this.h);
        registerListener(2016006, this.h);
        registerListener(2016000, this.h);
        registerListener(2016011, this.h);
        registerListener(2016001, this.h);
    }

    private void e(StrangerListActivity strangerListActivity) {
        this.b = new i(strangerListActivity);
        this.e = new com.baidu.tbadk.core.dialog.a(strangerListActivity);
        this.e.b(x.sure_to_delete_all_stranger_msg);
        this.e.a(x.alert_yes_btn, this.f);
        this.e.b(x.cancel, this.g);
        this.e.a();
    }

    private void b() {
        this.c = new h();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.b != null) {
            this.b.a(i);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ImMessageCenterShowItemData item;
        if (this.b != null && this.b.a() != null && (item = this.b.a().getItem(i)) != null) {
            sendMessage(new CustomMessage(2002005, new bk(this.d, com.baidu.adp.lib.e.c.a(item.getFriendId(), 0L), item.getFriendName(), item.getFriendPortrait(), 0, 0)));
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        ImMessageCenterShowItemData item;
        if (this.b == null || this.b.a() == null || (item = this.b.a().getItem(i)) == null) {
            return false;
        }
        com.baidu.tieba.im.d.b.b(this, new e(this, this.c.a().size(), item));
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.b.b() && this.e != null) {
            this.e.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.b != null && this.b.a() != null) {
            this.b.a().notifyDataSetChanged();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new com.baidu.tieba.im.message.f("-1001", -7)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CustomResponsedMessage<?> customResponsedMessage) {
        if ((customResponsedMessage instanceof MemoryInitCompleteMessage) && ((MemoryInitCompleteMessage) customResponsedMessage).getData().booleanValue()) {
            sendMessage(new RequestMemoryListMessage(3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof MemoryChangedMessage) {
            MemoryChangedMessage memoryChangedMessage = (MemoryChangedMessage) customResponsedMessage;
            ImMessageCenterPojo data = memoryChangedMessage.getData();
            if (memoryChangedMessage.getType() == 1) {
                if (this.c != null) {
                    this.c.a(data, this.i);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.c != null) {
                this.c.b(data, this.i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 3 && this.c != null) {
                this.c.a(data, this.i);
            }
        }
    }
}
