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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.c;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.usermutelist.UserMuteQueryModel;
import com.baidu.tieba.setting.usermutelist.a;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.response.UserMuteDelResponseMessage;
import java.util.ArrayList;
import tbclient.UserMuteQuery.MuteUser;
/* loaded from: classes26.dex */
public class UserMuteListActivity extends BaseActivity<UserMuteListActivity> {
    private static final BdUniqueId mZe = BdUniqueId.gen();
    private e lIo;
    private c lIp;
    private com.baidu.tbadk.core.view.a mWaitingDialog;
    private b mZb;
    private a mZc;
    private UserMuteQueryModel mZd;
    private String mZf;
    private ArrayList<MuteUser> eOt = new ArrayList<>();
    private boolean isNeedRefresh = false;
    private int page = 1;
    private int mZg = 10;
    private UserMuteQueryModel.a mZh = new UserMuteQueryModel.a() { // from class: com.baidu.tieba.setting.usermutelist.UserMuteListActivity.1
        @Override // com.baidu.tieba.setting.usermutelist.UserMuteQueryModel.a
        public void a(ArrayList<MuteUser> arrayList, int i, String str) {
            UserMuteListActivity.this.mWaitingDialog.setDialogVisiable(false);
            if (i != UserMuteQueryModel.NET_SUCCESS) {
                UserMuteListActivity.this.mZb.cIK();
                UserMuteListActivity.this.showToast(str);
                return;
            }
            UserMuteListActivity.b(UserMuteListActivity.this);
            UserMuteListActivity.this.eOt.addAll(arrayList);
            if (UserMuteListActivity.this.eOt == null || UserMuteListActivity.this.eOt.size() <= 0) {
                UserMuteListActivity.this.mZb.cIK();
            } else {
                UserMuteListActivity.this.mZc.setData(UserMuteListActivity.this.eOt);
            }
        }
    };
    private CustomMessageListener lIQ = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.setting.usermutelist.UserMuteListActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getOrginalMessage() != null && customResponsedMessage.getOrginalMessage().getTag() == UserMuteListActivity.mZe) {
                UserMuteListActivity.this.mWaitingDialog.setDialogVisiable(false);
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    UserMuteListActivity.this.lIp.showSuccessToast(UserMuteListActivity.this.lIo.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (au.isEmpty(muteMessage)) {
                    muteMessage = UserMuteListActivity.this.lIo.getResources().getString(R.string.un_mute_fail);
                }
                UserMuteListActivity.this.lIp.showFailToast(muteMessage);
            }
        }
    };
    private CustomMessageListener mZi = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_LIST_NEED_REFRESH) { // from class: com.baidu.tieba.setting.usermutelist.UserMuteListActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UserMuteListActivity.this.isNeedRefresh = true;
        }
    };
    private CustomMessageListener mZj = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_LIST_REMOVE_ITEM) { // from class: com.baidu.tieba.setting.usermutelist.UserMuteListActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage != null || UserMuteListActivity.this.mZf == null) && UserMuteListActivity.this.eOt != null && UserMuteListActivity.this.eOt.size() > 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < UserMuteListActivity.this.eOt.size()) {
                        MuteUser muteUser = (MuteUser) UserMuteListActivity.this.eOt.get(i2);
                        if (muteUser != null && (muteUser.user_id + "").equals(UserMuteListActivity.this.mZf)) {
                            UserMuteListActivity.this.eOt.remove(i2);
                            UserMuteListActivity.this.mZc.notifyDataSetChanged();
                            if (UserMuteListActivity.this.eOt.size() == 0) {
                                UserMuteListActivity.this.mZb.cIK();
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
    private a.b mZk = new a.b() { // from class: com.baidu.tieba.setting.usermutelist.UserMuteListActivity.6
        @Override // com.baidu.tieba.setting.usermutelist.a.b
        public void B(long j, String str) {
            if (!j.isNetWorkAvailable()) {
                UserMuteListActivity.this.showToast(R.string.neterror);
                return;
            }
            TiebaStatic.log("c10047");
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
            userMuteAddAndDelCustomMessage.setData(true, j + "", str, null, null, 2, null, UserMuteListActivity.mZe);
            UserMuteListActivity.this.mZf = j + "";
            userMuteAddAndDelCustomMessage.setTag(UserMuteListActivity.mZe);
            UserMuteListActivity.this.a(true, userMuteAddAndDelCustomMessage, null, str);
        }
    };
    private a.InterfaceC0861a mZl = new a.InterfaceC0861a() { // from class: com.baidu.tieba.setting.usermutelist.UserMuteListActivity.7
        @Override // com.baidu.tieba.setting.usermutelist.a.InterfaceC0861a
        public void C(long j, String str) {
            UserMuteListActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(UserMuteListActivity.this.getPageContext().getPageActivity(), j + "", str)));
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
        this.mZc = new a(this, this.mZk, this.mZl);
        this.mZd = new UserMuteQueryModel(this.mZh);
        this.mZb = new b(this, this.mZc);
        this.mZb.getListView().setAdapter((ListAdapter) this.mZc);
        this.mZb.getListView().setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.setting.usermutelist.UserMuteListActivity.8
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (absListView.getLastVisiblePosition() == absListView.getCount() - 1) {
                    UserMuteListActivity.this.mZd.h(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), UserMuteListActivity.this.page, UserMuteListActivity.this.mZg);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        showLoadingDialog();
        registerListener(this.mZj);
        registerListener(this.mZi);
        this.mZd.hE(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L));
        this.lIo = getPageContext();
        this.lIp = new c();
        this.lIp.toastTime = 1000L;
        registerListener(this.lIQ);
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.mId = mZe;
        userMuteAddAndDelCustomMessage.setTag(mZe);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.lIo = null;
        this.mZd.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.lIQ);
        MessageManager.getInstance().unRegisterListener(mZe);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.isNeedRefresh) {
            this.isNeedRefresh = false;
            showLoadingDialog();
            this.mZd.hE(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingDialog() {
        if (!j.isNetWorkAvailable()) {
            this.mZb.dKF();
            return;
        }
        if (this.mWaitingDialog == null) {
            this.mWaitingDialog = new com.baidu.tbadk.core.view.a(getPageContext());
            this.mWaitingDialog.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.setting.usermutelist.UserMuteListActivity.9
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    if (UserMuteListActivity.this.mZd != null) {
                        UserMuteListActivity.this.mZd.cancelLoadData();
                    }
                    MessageManager.getInstance().removeMessage(UserMuteListActivity.mZe);
                }
            });
        }
        this.mWaitingDialog.setDialogVisiable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.lIo.getPageActivity());
        if (au.isEmpty(str)) {
            aVar.Bq(this.lIo.getResources().getString(R.string.block_mute_message_alert, str2));
        } else {
            aVar.Bq(str);
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
        aVar.b(this.lIo).brv();
    }
}
