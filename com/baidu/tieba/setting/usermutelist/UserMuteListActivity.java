package com.baidu.tieba.setting.usermutelist;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.e;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.d;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.e;
import com.baidu.tieba.setting.usermutelist.UserMuteQueryModel;
import com.baidu.tieba.setting.usermutelist.a;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.response.UserMuteDelResponseMessage;
import java.util.ArrayList;
import tbclient.UserMuteQuery.MuteUser;
/* loaded from: classes3.dex */
public class UserMuteListActivity extends BaseActivity<UserMuteListActivity> {
    private static final BdUniqueId gQH = BdUniqueId.gen();
    private e fKZ;
    private g fLa;
    private b gQE;
    private a gQF;
    private UserMuteQueryModel gQG;
    private String gQI;
    private d mWaitingDialog;
    private ArrayList<MuteUser> mData = new ArrayList<>();
    private boolean eVZ = false;
    private int page = 1;
    private int gQJ = 10;
    private UserMuteQueryModel.a gQK = new UserMuteQueryModel.a() { // from class: com.baidu.tieba.setting.usermutelist.UserMuteListActivity.1
        @Override // com.baidu.tieba.setting.usermutelist.UserMuteQueryModel.a
        public void a(ArrayList<MuteUser> arrayList, int i, String str) {
            UserMuteListActivity.this.mWaitingDialog.bj(false);
            if (i != UserMuteQueryModel.NET_SUCCESS) {
                UserMuteListActivity.this.gQE.aEI();
                UserMuteListActivity.this.showToast(str);
                return;
            }
            UserMuteListActivity.b(UserMuteListActivity.this);
            UserMuteListActivity.this.mData.addAll(arrayList);
            if (UserMuteListActivity.this.mData == null || UserMuteListActivity.this.mData.size() <= 0) {
                UserMuteListActivity.this.gQE.aEI();
            } else {
                UserMuteListActivity.this.gQF.setData(UserMuteListActivity.this.mData);
            }
        }
    };
    private CustomMessageListener fLD = new CustomMessageListener(2001428) { // from class: com.baidu.tieba.setting.usermutelist.UserMuteListActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getOrginalMessage() != null && customResponsedMessage.getOrginalMessage().getTag() == UserMuteListActivity.gQH) {
                UserMuteListActivity.this.mWaitingDialog.bj(false);
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    UserMuteListActivity.this.fLa.e(UserMuteListActivity.this.fKZ.getResources().getString(e.j.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (ao.isEmpty(muteMessage)) {
                    muteMessage = UserMuteListActivity.this.fKZ.getResources().getString(e.j.un_mute_fail);
                }
                UserMuteListActivity.this.fLa.f(muteMessage);
            }
        }
    };
    private CustomMessageListener gQL = new CustomMessageListener(2016304) { // from class: com.baidu.tieba.setting.usermutelist.UserMuteListActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UserMuteListActivity.this.eVZ = true;
        }
    };
    private CustomMessageListener gQM = new CustomMessageListener(2016303) { // from class: com.baidu.tieba.setting.usermutelist.UserMuteListActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage != null || UserMuteListActivity.this.gQI == null) && UserMuteListActivity.this.mData != null && UserMuteListActivity.this.mData.size() > 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < UserMuteListActivity.this.mData.size()) {
                        MuteUser muteUser = (MuteUser) UserMuteListActivity.this.mData.get(i2);
                        if (muteUser != null && (muteUser.user_id + "").equals(UserMuteListActivity.this.gQI)) {
                            UserMuteListActivity.this.mData.remove(i2);
                            UserMuteListActivity.this.gQF.notifyDataSetChanged();
                            if (UserMuteListActivity.this.mData.size() == 0) {
                                UserMuteListActivity.this.gQE.aEI();
                                return;
                            }
                            return;
                        }
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
            }
        }
    };
    private a.b gQN = new a.b() { // from class: com.baidu.tieba.setting.usermutelist.UserMuteListActivity.6
        @Override // com.baidu.tieba.setting.usermutelist.a.b
        public void s(long j, String str) {
            if (!j.kX()) {
                UserMuteListActivity.this.showToast(e.j.neterror);
                return;
            }
            TiebaStatic.log("c10047");
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
            userMuteAddAndDelCustomMessage.setData(true, j + "", str, null, null, 2, null, UserMuteListActivity.gQH);
            UserMuteListActivity.this.gQI = j + "";
            userMuteAddAndDelCustomMessage.setTag(UserMuteListActivity.gQH);
            UserMuteListActivity.this.a(true, userMuteAddAndDelCustomMessage, null, str);
        }
    };
    private a.InterfaceC0272a gQO = new a.InterfaceC0272a() { // from class: com.baidu.tieba.setting.usermutelist.UserMuteListActivity.7
        @Override // com.baidu.tieba.setting.usermutelist.a.InterfaceC0272a
        public void t(long j, String str) {
            UserMuteListActivity.this.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(UserMuteListActivity.this.getPageContext().getPageActivity(), j + "", str)));
        }
    };

    static /* synthetic */ int b(UserMuteListActivity userMuteListActivity) {
        int i = userMuteListActivity.page;
        userMuteListActivity.page = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gQF = new a(this, this.gQN, this.gQO);
        this.gQG = new UserMuteQueryModel(this.gQK);
        this.gQE = new b(this, this.gQF);
        this.gQE.getListView().setAdapter((ListAdapter) this.gQF);
        this.gQE.getListView().setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.setting.usermutelist.UserMuteListActivity.8
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (absListView.getLastVisiblePosition() == absListView.getCount() - 1) {
                    UserMuteListActivity.this.gQG.c(com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L), UserMuteListActivity.this.page, UserMuteListActivity.this.gQJ);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        showLoadingDialog();
        registerListener(this.gQM);
        registerListener(this.gQL);
        this.gQG.db(com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L));
        this.fKZ = getPageContext();
        this.fLa = new g();
        this.fLa.aCM = 1000L;
        registerListener(this.fLD);
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
        userMuteAddAndDelCustomMessage.mId = gQH;
        userMuteAddAndDelCustomMessage.setTag(gQH);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.fKZ = null;
        this.gQG.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.fLD);
        MessageManager.getInstance().unRegisterListener(gQH);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.eVZ) {
            this.eVZ = false;
            showLoadingDialog();
            this.gQG.db(com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingDialog() {
        if (!j.kX()) {
            this.gQE.bxi();
            return;
        }
        if (this.mWaitingDialog == null) {
            this.mWaitingDialog = new d(getPageContext());
            this.mWaitingDialog.d(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.setting.usermutelist.UserMuteListActivity.9
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    if (UserMuteListActivity.this.gQG != null) {
                        UserMuteListActivity.this.gQG.cancelLoadData();
                    }
                    MessageManager.getInstance().removeMessage(UserMuteListActivity.gQH);
                }
            });
        }
        this.mWaitingDialog.bj(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fKZ.getPageActivity());
        if (ao.isEmpty(str)) {
            aVar.ej(this.fKZ.getResources().getString(e.j.block_mute_message_alert, str2));
        } else {
            aVar.ej(str);
        }
        aVar.a(e.j.confirm, new a.b() { // from class: com.baidu.tieba.setting.usermutelist.UserMuteListActivity.10
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                UserMuteListActivity.this.showLoadingDialog();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                aVar2.dismiss();
            }
        });
        aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.setting.usermutelist.UserMuteListActivity.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.fKZ).Au();
    }
}
