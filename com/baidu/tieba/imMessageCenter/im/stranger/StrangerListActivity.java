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
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.R;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.MemoryInitCompleteMessage;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
import com.baidu.tieba.im.message.ResponsedMemoryListMessage;
import d.b.h0.r.s.a;
import d.b.h0.r.s.j;
import d.b.h0.r.s.l;
import java.util.List;
/* loaded from: classes4.dex */
public class StrangerListActivity extends BaseActivity<StrangerListActivity> {
    public StrangerListActivity mActivity;
    public d.b.h0.r.s.a mDelAllDialog;
    public StrangerListModel mModel;
    public d.b.h0.r.s.c mProgressDialog;
    public d.b.i0.f1.a.e.b mView;
    public a.e mDelAllClickListener = new b();
    public a.e mCancelClickListener = new c();
    public final CustomMessageListener mMemoryListener = new d(0);
    public d.b.i0.e1.f.i.a mCompleteProcess = new e();
    public final d.b.i0.e1.f.i.b IProcessImpl = new f();

    /* loaded from: classes4.dex */
    public class a implements l.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f17963e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f17964f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ImMessageCenterShowItemData f17965g;

        public a(j jVar, int i, ImMessageCenterShowItemData imMessageCenterShowItemData) {
            this.f17963e = jVar;
            this.f17964f = i;
            this.f17965g = imMessageCenterShowItemData;
        }

        @Override // d.b.h0.r.s.l.e
        public void onItemClick(l lVar, int i, View view) {
            j jVar = this.f17963e;
            if (jVar != null && jVar.isShowing()) {
                this.f17963e.dismiss();
            }
            if (this.f17964f == 1) {
                StrangerListActivity.this.mModel.s(StrangerListActivity.this.IProcessImpl);
            } else {
                StrangerListActivity.this.mModel.asyncDeleteItem(this.f17965g, StrangerListActivity.this.IProcessImpl);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.e {
        public b() {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            StrangerListActivity.this.mDelAllDialog.dismiss();
            StrangerListActivity.this.mModel.s(StrangerListActivity.this.IProcessImpl);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements a.e {
        public c() {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            StrangerListActivity.this.mDelAllDialog.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public d(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null) {
                return;
            }
            if (customResponsedMessage.getCmd() == 2016002) {
                StrangerListActivity.this.processMemoryInitComplete(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2016004) {
                StrangerListActivity.this.processMemoryChanged(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2016007) {
                StrangerListActivity.this.processResponsedMemoryList(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2016001) {
                StrangerListActivity.this.mModel.setData(null, StrangerListActivity.this.mCompleteProcess);
            } else if (customResponsedMessage.getCmd() != 2016011 || StrangerListActivity.this.mView == null || StrangerListActivity.this.mView.d() == null) {
            } else {
                StrangerListActivity.this.mView.d().notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements d.b.i0.e1.f.i.a {
        public e() {
        }

        @Override // d.b.i0.e1.f.i.a
        public void onComplete() {
            StrangerListActivity.this.onCompleteProcess();
        }
    }

    /* loaded from: classes4.dex */
    public class f implements d.b.i0.e1.f.i.b {
        public f() {
        }

        @Override // d.b.i0.e1.f.i.b
        public void onCanceled() {
            StrangerListActivity.this.dismissDialog();
            StrangerListActivity.this.onCompleteProcess();
        }

        @Override // d.b.i0.e1.f.i.b
        public void onPostExecute() {
            StrangerListActivity.this.dismissDialog();
            StrangerListActivity.this.showToast(R.string.delete_success, false);
            StrangerListActivity.this.onCompleteProcess();
        }

        @Override // d.b.i0.e1.f.i.b
        public void onPreExecute() {
            StrangerListActivity.this.showProgressDialog();
        }

        @Override // d.b.i0.e1.f.i.b
        public void onProgressUpdate(int i, String str, int i2) {
            if (StrangerListActivity.this.mProgressDialog != null) {
                StrangerListActivity.this.mProgressDialog.b(i);
            }
            StrangerListActivity.this.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissDialog() {
        d.b.h0.r.s.c cVar = this.mProgressDialog;
        if (cVar != null && cVar.isShowing()) {
            this.mProgressDialog.dismiss();
            this.mProgressDialog = null;
        }
        closeLoadingDialog();
        dismissAllDialog();
    }

    private void initData() {
        this.mModel = new StrangerListModel(getPageContext());
    }

    private void initUI(StrangerListActivity strangerListActivity) {
        this.mView = new d.b.i0.f1.a.e.b(strangerListActivity);
        d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(strangerListActivity.getPageContext().getPageActivity());
        this.mDelAllDialog = aVar;
        aVar.setMessageId(R.string.sure_to_delete_all_stranger_msg);
        this.mDelAllDialog.setPositiveButton(R.string.confirm, this.mDelAllClickListener);
        this.mDelAllDialog.setNegativeButton(R.string.cancel, this.mCancelClickListener);
        this.mDelAllDialog.create(strangerListActivity.getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyDataSetChanged() {
        d.b.i0.f1.a.e.b bVar = this.mView;
        if (bVar == null || bVar.d() == null) {
            return;
        }
        this.mView.d().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCompleteProcess() {
        StrangerListModel strangerListModel;
        d.b.i0.f1.a.e.b bVar = this.mView;
        if (bVar == null || bVar.d() == null || (strangerListModel = this.mModel) == null) {
            return;
        }
        if (strangerListModel != null && strangerListModel.isEmpty()) {
            finish();
        }
        this.mView.d().n(this.mModel.getData());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processMemoryChanged(CustomResponsedMessage<?> customResponsedMessage) {
        StrangerListModel strangerListModel;
        if (customResponsedMessage instanceof MemoryChangedMessage) {
            MemoryChangedMessage memoryChangedMessage = (MemoryChangedMessage) customResponsedMessage;
            ImMessageCenterPojo data = memoryChangedMessage.getData();
            if (memoryChangedMessage.getType() == 1) {
                StrangerListModel strangerListModel2 = this.mModel;
                if (strangerListModel2 != null) {
                    strangerListModel2.insertOrUpdate(data, this.mCompleteProcess);
                }
            } else if (memoryChangedMessage.getType() != 2 || (strangerListModel = this.mModel) == null) {
            } else {
                strangerListModel.remove(data, this.mCompleteProcess);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processMemoryInitComplete(CustomResponsedMessage<?> customResponsedMessage) {
        if ((customResponsedMessage instanceof MemoryInitCompleteMessage) && ((MemoryInitCompleteMessage) customResponsedMessage).getData().booleanValue()) {
            sendMessage(new RequestMemoryListMessage(3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processResponsedMemoryList(CustomResponsedMessage<?> customResponsedMessage) {
        StrangerListModel strangerListModel;
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() != 3 || (strangerListModel = this.mModel) == null) {
                return;
            }
            strangerListModel.setData(data, this.mCompleteProcess);
        }
    }

    private void registerListener() {
        registerListener(2016004, this.mMemoryListener);
        registerListener(2016007, this.mMemoryListener);
        registerListener(2016001, this.mMemoryListener);
        registerListener(2016011, this.mMemoryListener);
        registerListener(2016002, this.mMemoryListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showProgressDialog() {
        dismissDialog();
        if (this.mProgressDialog == null) {
            this.mProgressDialog = d.b.i0.e1.h.e.m().p(getPageContext().getPageActivity());
        }
        this.mProgressDialog.show();
        this.mProgressDialog.b(0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        d.b.i0.f1.a.e.b bVar = this.mView;
        if (bVar != null) {
            bVar.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        d.b.h0.r.s.a aVar;
        super.onClick(view);
        if (view != this.mView.e() || (aVar = this.mDelAllDialog) == null) {
            return;
        }
        aVar.show();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mActivity = this;
        initUI(this);
        initData();
        registerListener();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        dismissDialog();
        super.onDestroy();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ImMessageCenterShowItemData item;
        d.b.i0.f1.a.e.b bVar = this.mView;
        if (bVar == null || bVar.d() == null || (item = this.mView.d().getItem(i)) == null) {
            return;
        }
        PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(this.mActivity.getPageContext().getContext(), d.b.c.e.m.b.f(item.getFriendId(), 0L), item.getFriendName(), item.getFriendNameShow(), item.getFriendPortrait(), 0, 0);
        personalChatActivityConfig.setFollowStatus(0);
        sendMessage(new CustomMessage(2002005, personalChatActivityConfig));
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        ImMessageCenterShowItemData item;
        d.b.i0.f1.a.e.b bVar = this.mView;
        if (bVar == null || bVar.d() == null || (item = this.mView.d().getItem(i)) == null) {
            return false;
        }
        int size = this.mModel.getData().size();
        j jVar = new j(getPageContext());
        jVar.i(null, new String[]{TbadkCoreApplication.getInst().getString(R.string.delete_user_chat)}, new a(jVar, size, item));
        jVar.l();
        return true;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRestart() {
        super.onRestart();
        ChatStatusManager.getInst().setIsOpen(5, true);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        d.b.i0.f1.a.e.b bVar = this.mView;
        if (bVar != null && bVar.d() != null) {
            this.mView.d().notifyDataSetChanged();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(TbEnum.CustomGroupId.STRANGE_MERGE, -7)));
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        ChatStatusManager.getInst().setIsOpen(5, true);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        ChatStatusManager.getInst().setIsOpen(5, false);
    }
}
