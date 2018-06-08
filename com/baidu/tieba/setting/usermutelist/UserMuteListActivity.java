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
import com.baidu.tbadk.core.view.c;
import com.baidu.tieba.d;
import com.baidu.tieba.setting.usermutelist.UserMuteQueryModel;
import com.baidu.tieba.setting.usermutelist.a;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.response.UserMuteDelResponseMessage;
import java.util.ArrayList;
import tbclient.UserMuteQuery.MuteUser;
/* loaded from: classes3.dex */
public class UserMuteListActivity extends BaseActivity<UserMuteListActivity> {
    private static final BdUniqueId gwB = BdUniqueId.gen();
    private e frJ;
    private c frK;
    private UserMuteQueryModel gwA;
    private String gwC;
    private b gwy;
    private a gwz;
    private com.baidu.tbadk.core.view.a mWaitingDialog;
    private ArrayList<MuteUser> alt = new ArrayList<>();
    private boolean cnG = false;
    private int page = 1;
    private int gwD = 10;
    private UserMuteQueryModel.a gwE = new UserMuteQueryModel.a() { // from class: com.baidu.tieba.setting.usermutelist.UserMuteListActivity.1
        @Override // com.baidu.tieba.setting.usermutelist.UserMuteQueryModel.a
        public void a(ArrayList<MuteUser> arrayList, int i, String str) {
            UserMuteListActivity.this.mWaitingDialog.aM(false);
            if (i != UserMuteQueryModel.NET_SUCCESS) {
                UserMuteListActivity.this.gwy.axZ();
                UserMuteListActivity.this.showToast(str);
                return;
            }
            UserMuteListActivity.b(UserMuteListActivity.this);
            UserMuteListActivity.this.alt.addAll(arrayList);
            if (UserMuteListActivity.this.alt == null || UserMuteListActivity.this.alt.size() <= 0) {
                UserMuteListActivity.this.gwy.axZ();
            } else {
                UserMuteListActivity.this.gwz.setData(UserMuteListActivity.this.alt);
            }
        }
    };
    private CustomMessageListener fsn = new CustomMessageListener(2001428) { // from class: com.baidu.tieba.setting.usermutelist.UserMuteListActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getOrginalMessage() != null && customResponsedMessage.getOrginalMessage().getTag() == UserMuteListActivity.gwB) {
                UserMuteListActivity.this.mWaitingDialog.aM(false);
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    UserMuteListActivity.this.frK.i(UserMuteListActivity.this.frJ.getResources().getString(d.k.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (ao.isEmpty(muteMessage)) {
                    muteMessage = UserMuteListActivity.this.frJ.getResources().getString(d.k.un_mute_fail);
                }
                UserMuteListActivity.this.frK.j(muteMessage);
            }
        }
    };
    private CustomMessageListener gwF = new CustomMessageListener(2016304) { // from class: com.baidu.tieba.setting.usermutelist.UserMuteListActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UserMuteListActivity.this.cnG = true;
        }
    };
    private CustomMessageListener gwG = new CustomMessageListener(2016303) { // from class: com.baidu.tieba.setting.usermutelist.UserMuteListActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage != null || UserMuteListActivity.this.gwC == null) && UserMuteListActivity.this.alt != null && UserMuteListActivity.this.alt.size() > 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < UserMuteListActivity.this.alt.size()) {
                        MuteUser muteUser = (MuteUser) UserMuteListActivity.this.alt.get(i2);
                        if (muteUser != null && (muteUser.user_id + "").equals(UserMuteListActivity.this.gwC)) {
                            UserMuteListActivity.this.alt.remove(i2);
                            UserMuteListActivity.this.gwz.notifyDataSetChanged();
                            if (UserMuteListActivity.this.alt.size() == 0) {
                                UserMuteListActivity.this.gwy.axZ();
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
    private a.b gwH = new a.b() { // from class: com.baidu.tieba.setting.usermutelist.UserMuteListActivity.6
        @Override // com.baidu.tieba.setting.usermutelist.a.b
        public void q(long j, String str) {
            if (!j.jD()) {
                UserMuteListActivity.this.showToast(d.k.neterror);
                return;
            }
            TiebaStatic.log("c10047");
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
            userMuteAddAndDelCustomMessage.setData(true, j + "", str, null, null, 2, null, UserMuteListActivity.gwB);
            UserMuteListActivity.this.gwC = j + "";
            userMuteAddAndDelCustomMessage.setTag(UserMuteListActivity.gwB);
            UserMuteListActivity.this.a(true, userMuteAddAndDelCustomMessage, null, str);
        }
    };
    private a.InterfaceC0229a gwI = new a.InterfaceC0229a() { // from class: com.baidu.tieba.setting.usermutelist.UserMuteListActivity.7
        @Override // com.baidu.tieba.setting.usermutelist.a.InterfaceC0229a
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
        this.gwz = new a(this, this.gwH, this.gwI);
        this.gwA = new UserMuteQueryModel(this.gwE);
        this.gwy = new b(this, this.gwz);
        this.gwy.getListView().setAdapter((ListAdapter) this.gwz);
        this.gwy.getListView().setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.setting.usermutelist.UserMuteListActivity.8
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (absListView.getLastVisiblePosition() == absListView.getCount() - 1) {
                    UserMuteListActivity.this.gwA.f(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L), UserMuteListActivity.this.page, UserMuteListActivity.this.gwD);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        showLoadingDialog();
        registerListener(this.gwG);
        registerListener(this.gwF);
        this.gwA.cY(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
        this.frJ = getPageContext();
        this.frK = new c();
        this.frK.auA = 1000L;
        registerListener(this.fsn);
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
        userMuteAddAndDelCustomMessage.mId = gwB;
        userMuteAddAndDelCustomMessage.setTag(gwB);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.frJ = null;
        this.gwA.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.fsn);
        MessageManager.getInstance().unRegisterListener(gwB);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.cnG) {
            this.cnG = false;
            showLoadingDialog();
            this.gwA.cY(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingDialog() {
        if (!j.jD()) {
            this.gwy.bsk();
            return;
        }
        if (this.mWaitingDialog == null) {
            this.mWaitingDialog = new com.baidu.tbadk.core.view.a(getPageContext());
            this.mWaitingDialog.d(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.setting.usermutelist.UserMuteListActivity.9
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    if (UserMuteListActivity.this.gwA != null) {
                        UserMuteListActivity.this.gwA.cancelLoadData();
                    }
                    MessageManager.getInstance().removeMessage(UserMuteListActivity.gwB);
                }
            });
        }
        this.mWaitingDialog.aM(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.frJ.getPageActivity());
        if (ao.isEmpty(str)) {
            aVar.dB(this.frJ.getResources().getString(d.k.block_mute_message_alert, str2));
        } else {
            aVar.dB(str);
        }
        aVar.a(d.k.confirm, new a.b() { // from class: com.baidu.tieba.setting.usermutelist.UserMuteListActivity.10
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                UserMuteListActivity.this.showLoadingDialog();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                aVar2.dismiss();
            }
        });
        aVar.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.setting.usermutelist.UserMuteListActivity.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.frJ).xa();
    }
}
