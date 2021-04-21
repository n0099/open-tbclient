package com.baidu.tieba.setting.usermutelist;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.usermutelist.UserMuteQueryModel;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.response.UserMuteDelResponseMessage;
import d.b.c.e.p.k;
import d.b.i0.r.s.a;
import d.b.j0.v2.f.a;
import java.util.ArrayList;
import tbclient.UserMuteQuery.MuteUser;
/* loaded from: classes4.dex */
public class UserMuteListActivity extends BaseActivity<UserMuteListActivity> {
    public static final BdUniqueId MESSAGE_ID_USER_MUTE_LIST = BdUniqueId.gen();
    public String delUserId;
    public d.b.j0.v2.f.a mAdapter;
    public d.b.c.a.f mCtx;
    public d.b.i0.r.f0.c mToastMute;
    public UserMuteQueryModel mUserMuteQueryModel;
    public d.b.j0.v2.f.b mView;
    public d.b.i0.r.f0.a mWaitingDialog;
    public ArrayList<MuteUser> mData = new ArrayList<>();
    public boolean isNeedRefresh = false;
    public int page = 1;
    public int rN = 10;
    public UserMuteQueryModel.b mCallback = new b();
    public CustomMessageListener mUserMuteDelListener = new c(2001428);
    public CustomMessageListener mNeedRefreshListener = new d(2016304);
    public CustomMessageListener mRemoveItemListener = new e(2016303);
    public a.e mRemoveClickHandler = new f();
    public a.d mHeaderClickHandler = new g();

    /* loaded from: classes4.dex */
    public class a implements a.e {
        public a() {
        }

        @Override // d.b.i0.r.s.a.e
        public void onClick(d.b.i0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements UserMuteQueryModel.b {
        public b() {
        }

        @Override // com.baidu.tieba.setting.usermutelist.UserMuteQueryModel.b
        public void a(ArrayList<MuteUser> arrayList, int i, String str) {
            UserMuteListActivity.this.mWaitingDialog.h(false);
            if (i != UserMuteQueryModel.NET_SUCCESS) {
                UserMuteListActivity.this.mView.f();
                UserMuteListActivity.this.showToast(str);
                return;
            }
            UserMuteListActivity.access$108(UserMuteListActivity.this);
            UserMuteListActivity.this.mData.addAll(arrayList);
            if (UserMuteListActivity.this.mData == null || UserMuteListActivity.this.mData.size() <= 0) {
                UserMuteListActivity.this.mView.f();
            } else {
                UserMuteListActivity.this.mAdapter.d(UserMuteListActivity.this.mData);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public c(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getOrginalMessage() == null || customResponsedMessage.getOrginalMessage().getTag() != UserMuteListActivity.MESSAGE_ID_USER_MUTE_LIST) {
                return;
            }
            UserMuteListActivity.this.mWaitingDialog.h(false);
            UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
            if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                UserMuteListActivity.this.mToastMute.c(UserMuteListActivity.this.mCtx.getResources().getString(R.string.un_mute_success));
                return;
            }
            String muteMessage = userMuteDelResponseMessage.getMuteMessage();
            if (k.isEmpty(muteMessage)) {
                muteMessage = UserMuteListActivity.this.mCtx.getResources().getString(R.string.un_mute_fail);
            }
            UserMuteListActivity.this.mToastMute.b(muteMessage);
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
            UserMuteListActivity.this.isNeedRefresh = true;
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public e(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage != null || UserMuteListActivity.this.delUserId == null) && UserMuteListActivity.this.mData != null && UserMuteListActivity.this.mData.size() > 0) {
                for (int i = 0; i < UserMuteListActivity.this.mData.size(); i++) {
                    MuteUser muteUser = (MuteUser) UserMuteListActivity.this.mData.get(i);
                    if (muteUser != null) {
                        if ((muteUser.user_id + "").equals(UserMuteListActivity.this.delUserId)) {
                            UserMuteListActivity.this.mData.remove(i);
                            UserMuteListActivity.this.mAdapter.notifyDataSetChanged();
                            if (UserMuteListActivity.this.mData.size() == 0) {
                                UserMuteListActivity.this.mView.f();
                                return;
                            }
                            return;
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements a.e {
        public f() {
        }

        @Override // d.b.j0.v2.f.a.e
        public void a(long j, String str) {
            if (!d.b.c.e.p.j.z()) {
                UserMuteListActivity.this.showToast(R.string.neterror);
                return;
            }
            TiebaStatic.log("c10047");
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
            userMuteAddAndDelCustomMessage.setData(true, j + "", str, null, null, 2, null, UserMuteListActivity.MESSAGE_ID_USER_MUTE_LIST);
            UserMuteListActivity userMuteListActivity = UserMuteListActivity.this;
            userMuteListActivity.delUserId = j + "";
            userMuteAddAndDelCustomMessage.setTag(UserMuteListActivity.MESSAGE_ID_USER_MUTE_LIST);
            UserMuteListActivity.this.showUserMuteDialog(true, userMuteAddAndDelCustomMessage, null, str);
        }
    }

    /* loaded from: classes4.dex */
    public class g implements a.d {
        public g() {
        }

        @Override // d.b.j0.v2.f.a.d
        public void a(long j, String str) {
            UserMuteListActivity userMuteListActivity = UserMuteListActivity.this;
            Activity pageActivity = UserMuteListActivity.this.getPageContext().getPageActivity();
            userMuteListActivity.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(pageActivity, j + "", str)));
        }
    }

    /* loaded from: classes4.dex */
    public class h implements AbsListView.OnScrollListener {
        public h() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (absListView.getLastVisiblePosition() == absListView.getCount() - 1) {
                UserMuteListActivity.this.mUserMuteQueryModel.u(d.b.c.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L), UserMuteListActivity.this.page, UserMuteListActivity.this.rN);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements DialogInterface.OnCancelListener {
        public i() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (UserMuteListActivity.this.mUserMuteQueryModel != null) {
                UserMuteListActivity.this.mUserMuteQueryModel.cancelLoadData();
            }
            MessageManager.getInstance().removeMessage(UserMuteListActivity.MESSAGE_ID_USER_MUTE_LIST);
        }
    }

    /* loaded from: classes4.dex */
    public class j implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UserMuteAddAndDelCustomMessage f20791e;

        public j(UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
            this.f20791e = userMuteAddAndDelCustomMessage;
        }

        @Override // d.b.i0.r.s.a.e
        public void onClick(d.b.i0.r.s.a aVar) {
            UserMuteListActivity.this.showLoadingDialog();
            MessageManager.getInstance().sendMessage(this.f20791e);
            aVar.dismiss();
        }
    }

    public static /* synthetic */ int access$108(UserMuteListActivity userMuteListActivity) {
        int i2 = userMuteListActivity.page;
        userMuteListActivity.page = i2 + 1;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingDialog() {
        if (!d.b.c.e.p.j.z()) {
            this.mView.h();
            return;
        }
        if (this.mWaitingDialog == null) {
            d.b.i0.r.f0.a aVar = new d.b.i0.r.f0.a(getPageContext());
            this.mWaitingDialog = aVar;
            aVar.e(new i());
        }
        this.mWaitingDialog.h(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showUserMuteDialog(boolean z, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        d.b.i0.r.s.a aVar = new d.b.i0.r.s.a(this.mCtx.getPageActivity());
        if (k.isEmpty(str)) {
            aVar.setMessage(this.mCtx.getResources().getString(R.string.block_mute_message_alert, str2));
        } else {
            aVar.setMessage(str);
        }
        aVar.setPositiveButton(R.string.confirm, new j(userMuteAddAndDelCustomMessage));
        aVar.setNegativeButton(R.string.cancel, new a());
        aVar.create(this.mCtx).show();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mAdapter = new d.b.j0.v2.f.a(this, this.mRemoveClickHandler, this.mHeaderClickHandler);
        this.mUserMuteQueryModel = new UserMuteQueryModel(this.mCallback);
        d.b.j0.v2.f.b bVar = new d.b.j0.v2.f.b(this, this.mAdapter);
        this.mView = bVar;
        bVar.e().setAdapter((ListAdapter) this.mAdapter);
        this.mView.e().setOnScrollListener(new h());
        showLoadingDialog();
        registerListener(this.mRemoveItemListener);
        registerListener(this.mNeedRefreshListener);
        this.mUserMuteQueryModel.t(d.b.c.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L));
        this.mCtx = getPageContext();
        d.b.i0.r.f0.c cVar = new d.b.i0.r.f0.c();
        this.mToastMute = cVar;
        cVar.f51227a = 1000L;
        registerListener(this.mUserMuteDelListener);
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
        BdUniqueId bdUniqueId = MESSAGE_ID_USER_MUTE_LIST;
        userMuteAddAndDelCustomMessage.mId = bdUniqueId;
        userMuteAddAndDelCustomMessage.setTag(bdUniqueId);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mCtx = null;
        this.mUserMuteQueryModel.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.mUserMuteDelListener);
        MessageManager.getInstance().unRegisterListener(MESSAGE_ID_USER_MUTE_LIST);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.isNeedRefresh) {
            this.isNeedRefresh = false;
            showLoadingDialog();
            this.mUserMuteQueryModel.t(d.b.c.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L));
        }
    }
}
