package com.baidu.tieba.im.stranger;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.bc;
import com.baidu.tbadk.core.atomData.bq;
import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class StrangerListActivity extends BaseActivity {
    public static boolean a;
    private v b;
    private o c;
    private StrangerListActivity d;
    private com.baidu.tbadk.core.dialog.a e;
    private final com.baidu.tieba.im.a<Void> f = new f(this);
    private CustomMessageListener g = new g(this, 0);
    private com.baidu.tbadk.core.dialog.d h = new h(this);
    private com.baidu.tbadk.core.dialog.d i = new i(this);
    private l j = new j(this);

    static {
        TbadkApplication.m252getInst().RegisterIntent(bq.class, StrangerListActivity.class);
        a = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.d = this;
        f(this);
        a();
        registerListener(2001140, this.g);
    }

    private void f(StrangerListActivity strangerListActivity) {
        this.b = new v(strangerListActivity);
        showLoadingDialog(getString(y.loading), null);
        this.e = new com.baidu.tbadk.core.dialog.a(strangerListActivity);
        this.e.b(y.sure_to_delete_all_stranger_msg);
        this.e.a(y.alert_yes_btn, this.h);
        this.e.b(y.cancel, this.i);
        this.e.a();
    }

    private void a() {
        this.c = new o();
        this.c.a(this.f);
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
            item.setUnReadCount(0);
            this.b.a().notifyDataSetChanged();
            sendMessage(new CustomMessage(2002005, new bc(this.d, com.baidu.adp.lib.f.b.a(item.getFriendId(), 0L), item.getFriendName(), item.getFriendPortrait(), 0, 0)));
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        ImMessageCenterShowItemData item;
        if (this.b == null || this.b.a() == null || (item = this.b.a().getItem(i)) == null) {
            return false;
        }
        com.baidu.tieba.im.e.b.b(this, new k(this, this.b.a().getCount(), item));
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.b.b() && this.e != null) {
            this.e.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.b != null && this.b.a() != null) {
            this.b.a().notifyDataSetChanged();
        }
        a = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        a = false;
        com.baidu.tieba.im.model.p.b(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        a = false;
    }
}
