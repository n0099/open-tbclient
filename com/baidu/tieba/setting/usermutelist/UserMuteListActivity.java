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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
import com.baidu.tieba.setting.usermutelist.UserMuteQueryModel;
import com.baidu.tieba.setting.usermutelist.a;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.response.UserMuteDelResponseMessage;
import java.util.ArrayList;
import tbclient.UserMuteQuery.MuteUser;
/* loaded from: classes3.dex */
public class UserMuteListActivity extends BaseActivity<UserMuteListActivity> {
    private static final BdUniqueId gOU = BdUniqueId.gen();
    private e fLA;
    private com.baidu.tbadk.core.view.e fLB;
    private b gOR;
    private a gOS;
    private UserMuteQueryModel gOT;
    private String gOV;
    private com.baidu.tbadk.core.view.b mWaitingDialog;
    private ArrayList<MuteUser> aRZ = new ArrayList<>();
    private boolean cOy = false;
    private int page = 1;
    private int gOW = 10;
    private UserMuteQueryModel.a gOX = new UserMuteQueryModel.a() { // from class: com.baidu.tieba.setting.usermutelist.UserMuteListActivity.1
        @Override // com.baidu.tieba.setting.usermutelist.UserMuteQueryModel.a
        public void a(ArrayList<MuteUser> arrayList, int i, String str) {
            UserMuteListActivity.this.mWaitingDialog.bq(false);
            if (i != UserMuteQueryModel.NET_SUCCESS) {
                UserMuteListActivity.this.gOR.bse();
                UserMuteListActivity.this.showToast(str);
                return;
            }
            UserMuteListActivity.b(UserMuteListActivity.this);
            UserMuteListActivity.this.aRZ.addAll(arrayList);
            if (UserMuteListActivity.this.aRZ == null || UserMuteListActivity.this.aRZ.size() <= 0) {
                UserMuteListActivity.this.gOR.bse();
            } else {
                UserMuteListActivity.this.gOS.setData(UserMuteListActivity.this.aRZ);
            }
        }
    };
    private CustomMessageListener fMe = new CustomMessageListener(2001428) { // from class: com.baidu.tieba.setting.usermutelist.UserMuteListActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getOrginalMessage() != null && customResponsedMessage.getOrginalMessage().getTag() == UserMuteListActivity.gOU) {
                UserMuteListActivity.this.mWaitingDialog.bq(false);
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    UserMuteListActivity.this.fLB.q(UserMuteListActivity.this.fLA.getResources().getString(d.j.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (am.isEmpty(muteMessage)) {
                    muteMessage = UserMuteListActivity.this.fLA.getResources().getString(d.j.un_mute_fail);
                }
                UserMuteListActivity.this.fLB.r(muteMessage);
            }
        }
    };
    private CustomMessageListener gOY = new CustomMessageListener(2016304) { // from class: com.baidu.tieba.setting.usermutelist.UserMuteListActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UserMuteListActivity.this.cOy = true;
        }
    };
    private CustomMessageListener gOZ = new CustomMessageListener(2016303) { // from class: com.baidu.tieba.setting.usermutelist.UserMuteListActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage != null || UserMuteListActivity.this.gOV == null) && UserMuteListActivity.this.aRZ != null && UserMuteListActivity.this.aRZ.size() > 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < UserMuteListActivity.this.aRZ.size()) {
                        MuteUser muteUser = (MuteUser) UserMuteListActivity.this.aRZ.get(i2);
                        if (muteUser != null && (muteUser.user_id + "").equals(UserMuteListActivity.this.gOV)) {
                            UserMuteListActivity.this.aRZ.remove(i2);
                            UserMuteListActivity.this.gOS.notifyDataSetChanged();
                            if (UserMuteListActivity.this.aRZ.size() == 0) {
                                UserMuteListActivity.this.gOR.bse();
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
    private a.b gPa = new a.b() { // from class: com.baidu.tieba.setting.usermutelist.UserMuteListActivity.6
        @Override // com.baidu.tieba.setting.usermutelist.a.b
        public void p(long j, String str) {
            if (!j.oJ()) {
                UserMuteListActivity.this.showToast(d.j.neterror);
                return;
            }
            TiebaStatic.log("c10047");
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
            userMuteAddAndDelCustomMessage.setData(true, j + "", str, null, null, 2, null, UserMuteListActivity.gOU);
            UserMuteListActivity.this.gOV = j + "";
            userMuteAddAndDelCustomMessage.setTag(UserMuteListActivity.gOU);
            UserMuteListActivity.this.a(true, userMuteAddAndDelCustomMessage, null, str);
        }
    };
    private a.InterfaceC0231a gPb = new a.InterfaceC0231a() { // from class: com.baidu.tieba.setting.usermutelist.UserMuteListActivity.7
        @Override // com.baidu.tieba.setting.usermutelist.a.InterfaceC0231a
        public void q(long j, String str) {
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
        this.gOS = new a(this, this.gPa, this.gPb);
        this.gOT = new UserMuteQueryModel(this.gOX);
        this.gOR = new b(this, this.gOS);
        this.gOR.getListView().setAdapter((ListAdapter) this.gOS);
        this.gOR.getListView().setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.setting.usermutelist.UserMuteListActivity.8
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (absListView.getLastVisiblePosition() == absListView.getCount() - 1) {
                    UserMuteListActivity.this.gOT.f(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L), UserMuteListActivity.this.page, UserMuteListActivity.this.gOW);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        showLoadingDialog();
        registerListener(this.gOZ);
        registerListener(this.gOY);
        this.gOT.cO(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
        this.fLA = getPageContext();
        this.fLB = new com.baidu.tbadk.core.view.e();
        this.fLB.baX = 1000L;
        registerListener(this.fMe);
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
        userMuteAddAndDelCustomMessage.mId = gOU;
        userMuteAddAndDelCustomMessage.setTag(gOU);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.fLA = null;
        this.gOT.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.fMe);
        MessageManager.getInstance().unRegisterListener(gOU);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.cOy) {
            this.cOy = false;
            showLoadingDialog();
            this.gOT.cO(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingDialog() {
        if (!j.oJ()) {
            this.gOR.bsf();
            return;
        }
        if (this.mWaitingDialog == null) {
            this.mWaitingDialog = new com.baidu.tbadk.core.view.b(getPageContext());
            this.mWaitingDialog.d(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.setting.usermutelist.UserMuteListActivity.9
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    if (UserMuteListActivity.this.gOT != null) {
                        UserMuteListActivity.this.gOT.cancelLoadData();
                    }
                    MessageManager.getInstance().removeMessage(UserMuteListActivity.gOU);
                }
            });
        }
        this.mWaitingDialog.bq(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fLA.getPageActivity());
        if (am.isEmpty(str)) {
            aVar.dk(this.fLA.getResources().getString(d.j.block_mute_message_alert, str2));
        } else {
            aVar.dk(str);
        }
        aVar.a(d.j.confirm, new a.b() { // from class: com.baidu.tieba.setting.usermutelist.UserMuteListActivity.10
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                UserMuteListActivity.this.showLoadingDialog();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                aVar2.dismiss();
            }
        });
        aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.setting.usermutelist.UserMuteListActivity.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.fLA).AV();
    }
}
