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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.usermutelist.UserMuteQueryModel;
import com.baidu.tieba.setting.usermutelist.a;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.response.UserMuteDelResponseMessage;
import java.util.ArrayList;
import tbclient.UserMuteQuery.MuteUser;
/* loaded from: classes3.dex */
public class UserMuteListActivity extends BaseActivity<UserMuteListActivity> {
    private static final BdUniqueId iXn = BdUniqueId.gen();
    private e hNO;
    private com.baidu.tbadk.core.view.e hNP;
    private b iXk;
    private a iXl;
    private UserMuteQueryModel iXm;
    private String iXo;
    private com.baidu.tbadk.core.view.b mWaitingDialog;
    private ArrayList<MuteUser> aIL = new ArrayList<>();
    private boolean isNeedRefresh = false;
    private int page = 1;
    private int iXp = 10;
    private UserMuteQueryModel.a iXq = new UserMuteQueryModel.a() { // from class: com.baidu.tieba.setting.usermutelist.UserMuteListActivity.1
        @Override // com.baidu.tieba.setting.usermutelist.UserMuteQueryModel.a
        public void a(ArrayList<MuteUser> arrayList, int i, String str) {
            UserMuteListActivity.this.mWaitingDialog.em(false);
            if (i != UserMuteQueryModel.NET_SUCCESS) {
                UserMuteListActivity.this.iXk.brN();
                UserMuteListActivity.this.showToast(str);
                return;
            }
            UserMuteListActivity.b(UserMuteListActivity.this);
            UserMuteListActivity.this.aIL.addAll(arrayList);
            if (UserMuteListActivity.this.aIL == null || UserMuteListActivity.this.aIL.size() <= 0) {
                UserMuteListActivity.this.iXk.brN();
            } else {
                UserMuteListActivity.this.iXl.setData(UserMuteListActivity.this.aIL);
            }
        }
    };
    private CustomMessageListener hOr = new CustomMessageListener(2001428) { // from class: com.baidu.tieba.setting.usermutelist.UserMuteListActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getOrginalMessage() != null && customResponsedMessage.getOrginalMessage().getTag() == UserMuteListActivity.iXn) {
                UserMuteListActivity.this.mWaitingDialog.em(false);
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    UserMuteListActivity.this.hNP.i(UserMuteListActivity.this.hNO.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (aq.isEmpty(muteMessage)) {
                    muteMessage = UserMuteListActivity.this.hNO.getResources().getString(R.string.un_mute_fail);
                }
                UserMuteListActivity.this.hNP.j(muteMessage);
            }
        }
    };
    private CustomMessageListener iXr = new CustomMessageListener(2016304) { // from class: com.baidu.tieba.setting.usermutelist.UserMuteListActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UserMuteListActivity.this.isNeedRefresh = true;
        }
    };
    private CustomMessageListener iXs = new CustomMessageListener(2016303) { // from class: com.baidu.tieba.setting.usermutelist.UserMuteListActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage != null || UserMuteListActivity.this.iXo == null) && UserMuteListActivity.this.aIL != null && UserMuteListActivity.this.aIL.size() > 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < UserMuteListActivity.this.aIL.size()) {
                        MuteUser muteUser = (MuteUser) UserMuteListActivity.this.aIL.get(i2);
                        if (muteUser != null && (muteUser.user_id + "").equals(UserMuteListActivity.this.iXo)) {
                            UserMuteListActivity.this.aIL.remove(i2);
                            UserMuteListActivity.this.iXl.notifyDataSetChanged();
                            if (UserMuteListActivity.this.aIL.size() == 0) {
                                UserMuteListActivity.this.iXk.brN();
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
    private a.b iXt = new a.b() { // from class: com.baidu.tieba.setting.usermutelist.UserMuteListActivity.6
        @Override // com.baidu.tieba.setting.usermutelist.a.b
        public void q(long j, String str) {
            if (!j.kc()) {
                UserMuteListActivity.this.showToast(R.string.neterror);
                return;
            }
            TiebaStatic.log("c10047");
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
            userMuteAddAndDelCustomMessage.setData(true, j + "", str, null, null, 2, null, UserMuteListActivity.iXn);
            UserMuteListActivity.this.iXo = j + "";
            userMuteAddAndDelCustomMessage.setTag(UserMuteListActivity.iXn);
            UserMuteListActivity.this.a(true, userMuteAddAndDelCustomMessage, null, str);
        }
    };
    private a.InterfaceC0417a iXu = new a.InterfaceC0417a() { // from class: com.baidu.tieba.setting.usermutelist.UserMuteListActivity.7
        @Override // com.baidu.tieba.setting.usermutelist.a.InterfaceC0417a
        public void r(long j, String str) {
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
        this.iXl = new a(this, this.iXt, this.iXu);
        this.iXm = new UserMuteQueryModel(this.iXq);
        this.iXk = new b(this, this.iXl);
        this.iXk.getListView().setAdapter((ListAdapter) this.iXl);
        this.iXk.getListView().setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.setting.usermutelist.UserMuteListActivity.8
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (absListView.getLastVisiblePosition() == absListView.getCount() - 1) {
                    UserMuteListActivity.this.iXm.c(com.baidu.adp.lib.g.b.e(TbadkCoreApplication.getCurrentAccount(), 0L), UserMuteListActivity.this.page, UserMuteListActivity.this.iXp);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        showLoadingDialog();
        registerListener(this.iXs);
        registerListener(this.iXr);
        this.iXm.ey(com.baidu.adp.lib.g.b.e(TbadkCoreApplication.getCurrentAccount(), 0L));
        this.hNO = getPageContext();
        this.hNP = new com.baidu.tbadk.core.view.e();
        this.hNP.bZH = 1000L;
        registerListener(this.hOr);
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
        userMuteAddAndDelCustomMessage.mId = iXn;
        userMuteAddAndDelCustomMessage.setTag(iXn);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.hNO = null;
        this.iXm.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.hOr);
        MessageManager.getInstance().unRegisterListener(iXn);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.isNeedRefresh) {
            this.isNeedRefresh = false;
            showLoadingDialog();
            this.iXm.ey(com.baidu.adp.lib.g.b.e(TbadkCoreApplication.getCurrentAccount(), 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingDialog() {
        if (!j.kc()) {
            this.iXk.cmL();
            return;
        }
        if (this.mWaitingDialog == null) {
            this.mWaitingDialog = new com.baidu.tbadk.core.view.b(getPageContext());
            this.mWaitingDialog.e(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.setting.usermutelist.UserMuteListActivity.9
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    if (UserMuteListActivity.this.iXm != null) {
                        UserMuteListActivity.this.iXm.cancelLoadData();
                    }
                    MessageManager.getInstance().removeMessage(UserMuteListActivity.iXn);
                }
            });
        }
        this.mWaitingDialog.em(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hNO.getPageActivity());
        if (aq.isEmpty(str)) {
            aVar.mQ(this.hNO.getResources().getString(R.string.block_mute_message_alert, str2));
        } else {
            aVar.mQ(str);
        }
        aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.setting.usermutelist.UserMuteListActivity.10
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                UserMuteListActivity.this.showLoadingDialog();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                aVar2.dismiss();
            }
        });
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.setting.usermutelist.UserMuteListActivity.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.hNO).agO();
    }
}
