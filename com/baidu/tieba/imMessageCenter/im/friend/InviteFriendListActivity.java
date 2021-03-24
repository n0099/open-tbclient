package com.baidu.tieba.imMessageCenter.im.friend;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.InviteFriendListActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tbadk.coreExtra.relationship.GetContactListRequestMessage;
import com.baidu.tbadk.coreExtra.relationship.GetContactListResponsedMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.im.message.ResponseCommitInviteMessage;
import com.baidu.tieba.imMessageCenter.im.chat.PersonalChatDisplayResponse;
import d.b.i0.e1.a.c.c;
import d.b.i0.e1.a.c.e;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes4.dex */
public class InviteFriendListActivity extends BaseActivity<InviteFriendListActivity> implements View.OnClickListener, AdapterView.OnItemClickListener {
    public static final int MAX_INVITED_COUNT = 100;
    public boolean isFromInviteChat;
    public boolean isFromSearch;
    public e mModel;
    public d.b.i0.e1.a.c.d mView;
    public boolean isLoaded = false;
    public List<d.b.h0.s.f.a> friendList = null;
    public LinkedList<d.b.h0.s.f.a> searchedList = new LinkedList<>();
    public final AtomicBoolean isLoading = new AtomicBoolean(false);
    public CustomMessageListener friendListResponsedMessageListener = new b(2001184);
    public final d.b.b.c.g.c mListener = new d(205002);

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof PersonalChatDisplayResponse) {
                InviteFriendListActivity.this.finish();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof GetContactListResponsedMessage) {
                InviteFriendListActivity.this.isLoaded = true;
                InviteFriendListActivity.this.isLoading.set(false);
                InviteFriendListActivity inviteFriendListActivity = InviteFriendListActivity.this;
                inviteFriendListActivity.hideLoadingView(inviteFriendListActivity.mView.y());
                List<d.b.h0.s.f.a> contacts = ((GetContactListResponsedMessage) customResponsedMessage).getContacts();
                if (contacts == null) {
                    contacts = new LinkedList<>();
                }
                InviteFriendListActivity inviteFriendListActivity2 = InviteFriendListActivity.this;
                inviteFriendListActivity2.friendList = contacts;
                if (inviteFriendListActivity2.mView == null) {
                    return;
                }
                InviteFriendListActivity.this.refreshWithCurrentData();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements DialogInterface.OnCancelListener {
        public c() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (InviteFriendListActivity.this.mModel != null) {
                InviteFriendListActivity.this.mModel.cancelLoadData();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends d.b.b.c.g.c {

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (InviteFriendListActivity.this.isFinishing()) {
                    return;
                }
                InviteFriendListActivity.this.finish();
            }
        }

        public d(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            InviteFriendListActivity.this.closeLoadingDialog();
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 205002 && (socketResponsedMessage instanceof ResponseCommitInviteMessage)) {
                ResponseCommitInviteMessage responseCommitInviteMessage = (ResponseCommitInviteMessage) socketResponsedMessage;
                if (responseCommitInviteMessage.getError() != 0) {
                    InviteFriendListActivity.this.showToast(StringUtils.isNull(responseCommitInviteMessage.getErrorString()) ? InviteFriendListActivity.this.getResources().getString(R.string.neterror) : responseCommitInviteMessage.getErrorString());
                    return;
                }
                InviteFriendListActivity inviteFriendListActivity = InviteFriendListActivity.this;
                inviteFriendListActivity.showToast(inviteFriendListActivity.getPageContext().getString(R.string.send_success), false);
                new Handler().postDelayed(new a(), 400L);
            }
        }
    }

    private void initModel() {
        this.mModel = new e(this);
    }

    private void initView() {
        d.b.i0.e1.a.c.d dVar = new d.b.i0.e1.a.c.d(this, this.isFromInviteChat);
        this.mView = dVar;
        dVar.O(100);
    }

    private void loadData() {
        refreshWithCurrentData();
    }

    private void registerFinishListener() {
        registerListener(new a(2001309));
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.mView.u();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        d.b.i0.e1.a.c.d dVar = this.mView;
        if (dVar == null) {
            return;
        }
        dVar.B();
        if (view.getId() == this.mView.x()) {
            showLoadingDialog();
            this.mModel.u(this.mView.v());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.mListener);
        registerListener(this.friendListResponsedMessageListener);
        Intent intent = getIntent();
        initModel();
        boolean z = false;
        if (intent != null) {
            this.isFromInviteChat = intent.getBooleanExtra(InviteFriendListActivityConfig.IS_FROM_INVITE_CHAT, false);
            z = intent.getBooleanExtra(InviteFriendListActivityConfig.KEY_FINISH_ACTIVITY, false);
            this.mModel.initWithIntent(intent);
        } else {
            this.isFromInviteChat = bundle.getBoolean(InviteFriendListActivityConfig.IS_FROM_INVITE_CHAT, false);
            this.mModel.initWithBundle(bundle);
        }
        initView();
        loadData();
        if (z) {
            registerFinishListener();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mModel.cancelLoadData();
        d.b.i0.e1.a.c.d dVar = this.mView;
        if (dVar != null) {
            dVar.J();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Object tag;
        super.onItemClick(adapterView, view, i, j);
        if (this.isFromInviteChat) {
            d.b.h0.s.f.a aVar = null;
            if (this.isFromSearch) {
                LinkedList<d.b.h0.s.f.a> linkedList = this.searchedList;
                if (linkedList != null && i < linkedList.size()) {
                    aVar = this.searchedList.get(i);
                }
            } else {
                List<d.b.h0.s.f.a> list = this.friendList;
                if (list != null && i < list.size()) {
                    aVar = this.friendList.get(i);
                }
            }
            if (aVar == null) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(getPageContext().getPageActivity(), aVar.e(), aVar.f(), aVar.g(), aVar.h(), 0)));
        } else if (view == null || (tag = view.getTag()) == null || !(tag instanceof c.a)) {
        } else {
            TbCheckBox tbCheckBox = ((c.a) tag).f54326d;
            tbCheckBox.setChecked(!tbCheckBox.d());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.mView.I()) {
            this.mView.E();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.mModel.t(bundle);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.mView.d();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.mView.e();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (!z || this.isLoaded) {
            return;
        }
        showLoadingView(this.mView.y(), true);
    }

    public void refreshWithCurrentData() {
        if (isFinishing()) {
            return;
        }
        if (this.friendList == null) {
            if (this.isLoading.get()) {
                return;
            }
            this.isLoading.set(true);
            super.sendMessage(new GetContactListRequestMessage());
            return;
        }
        String z = this.mView.z();
        String trim = z == null ? "" : z.trim();
        if (this.friendList.isEmpty() && trim.length() > 0) {
            showToast(getPageContext().getString(R.string.invite_friend_no_data_now));
        }
        if (trim.length() == 0) {
            this.isFromSearch = false;
            this.mView.K(this.friendList, false);
            return;
        }
        this.searchedList.clear();
        for (d.b.h0.s.f.a aVar : this.friendList) {
            String c2 = aVar.c();
            if (c2 != null && c2.contains(trim)) {
                this.searchedList.add(aVar);
            }
        }
        this.isFromSearch = true;
        this.mView.K(this.searchedList, true);
    }

    public void showLoadingDialog() {
        showLoadingDialog((String) null, new c());
    }
}
