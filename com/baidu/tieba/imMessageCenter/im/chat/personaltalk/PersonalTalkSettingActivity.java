package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.util.u;
import com.baidu.tbadk.util.v;
import com.baidu.tieba.f;
import com.baidu.tieba.im.db.m;
import com.baidu.tieba.im.message.ClearChatMsgResponsedMessage;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.imMessageCenter.im.chat.personaltalk.f;
/* loaded from: classes2.dex */
public class PersonalTalkSettingActivity extends BaseActivity<PersonalTalkSettingActivity> implements BdSwitchView.a, f.a {
    private g eEp;
    private f eEq;
    private com.baidu.tieba.ueg.a eEr;
    private com.baidu.adp.framework.listener.c eEs = new com.baidu.adp.framework.listener.c(104102) { // from class: com.baidu.tieba.imMessageCenter.im.chat.personaltalk.PersonalTalkSettingActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonalTalkSettingActivity.this.closeLoadingDialog();
            if ((socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (socketResponsedMessage.getOrginalMessage() instanceof RequestUpdateMaskInfoMessage)) {
                RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) socketResponsedMessage.getOrginalMessage();
                ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage;
                if (requestUpdateMaskInfoMessage.getMaskType() == 9) {
                    PersonalTalkSettingActivity.this.D(!responseUpdateMaskInfoMessage.hasError(), requestUpdateMaskInfoMessage.isSettingMask());
                }
            }
        }
    };
    private long userId;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        initData(bundle);
        registerListener(205003, this.eEq.aOb());
        registerListener(104102, this.eEq.aOb());
        registerListener(2001115, this.eEq.aOc());
        registerListener(this.eEs);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.eEq.onDestory();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putLong("userId", this.userId);
    }

    private void initData(Bundle bundle) {
        if (bundle == null) {
            this.userId = getIntent().getLongExtra("userId", 0L);
        } else {
            this.userId = bundle.getLong("userId");
        }
        this.eEq = new f(this, this, this.userId);
    }

    private void initView() {
        this.eEp = new g(this);
        this.eEp.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        this.eEp.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        CustomResponsedMessage runTask;
        int id = view.getId();
        if (id == f.g.user_info_lin) {
            if (this.eEq != null && this.eEq.aNZ() != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getContext(), String.valueOf(this.userId), this.eEq.aNZ().name)));
            }
        } else if (id == f.g.remove_from_black_man) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.dB(getPageContext().getContext().getString(f.j.add_black_alert, this.eEq.aNZ().nameShow)).a(f.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.imMessageCenter.im.chat.personaltalk.PersonalTalkSettingActivity.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    PersonalTalkSettingActivity.this.eEq.hZ(false);
                }
            }).b(f.j.cancel, new a.b() { // from class: com.baidu.tieba.imMessageCenter.im.chat.personaltalk.PersonalTalkSettingActivity.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            }).b(getPageContext());
            aVar.xe();
        } else if (id == f.g.st_delete_talk_history) {
            com.baidu.tbadk.core.dialog.a aVar2 = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar2.dB(getPageContext().getContext().getString(f.j.remove_personal_history)).a(f.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.imMessageCenter.im.chat.personaltalk.PersonalTalkSettingActivity.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar3) {
                    aVar3.dismiss();
                    PersonalTalkSettingActivity.this.showLoadingDialog(null);
                    v.b(new u<Boolean>() { // from class: com.baidu.tieba.imMessageCenter.im.chat.personaltalk.PersonalTalkSettingActivity.5.1
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // com.baidu.tbadk.util.u
                        public Boolean doInBackground() {
                            return Boolean.valueOf(m.aJO().od(String.valueOf(PersonalTalkSettingActivity.this.userId)));
                        }
                    }, new com.baidu.tbadk.util.g<Boolean>() { // from class: com.baidu.tieba.imMessageCenter.im.chat.personaltalk.PersonalTalkSettingActivity.5.2
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.tbadk.util.g
                        public void onReturnDataInUI(Boolean bool) {
                            PersonalTalkSettingActivity.this.closeLoadingDialog();
                            MessageManager.getInstance().dispatchResponsedMessageToUI(new ClearChatMsgResponsedMessage());
                            PersonalTalkSettingActivity.this.showToast(f.j.delete_success, false);
                            MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(String.valueOf(PersonalTalkSettingActivity.this.userId), 2, null, 1)));
                        }
                    });
                }
            }).b(f.j.cancel, new a.b() { // from class: com.baidu.tieba.imMessageCenter.im.chat.personaltalk.PersonalTalkSettingActivity.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar3) {
                    aVar3.dismiss();
                }
            }).b(getPageContext());
            aVar2.xe();
        } else if (id == f.g.st_report) {
            if (this.eEr == null && (runTask = MessageManager.getInstance().runTask(2921343, com.baidu.tieba.ueg.a.class, getPageContext().getPageActivity())) != null) {
                this.eEr = (com.baidu.tieba.ueg.a) runTask.getData();
            }
            if (this.eEr != null) {
                this.eEr.o(getUniqueId());
                this.eEr.kE(String.valueOf(this.userId));
                TiebaStatic.log(new an("c13063").r("obj_locate", 2));
            }
        } else if (id == f.g.add_to_black) {
            com.baidu.tbadk.core.dialog.a aVar3 = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar3.dA(getPageContext().getContext().getString(f.j.sure_add_somebody_to_black, this.eEq.aNZ().nameShow));
            aVar3.dB(getPageContext().getContext().getString(f.j.remove_black_alert)).a(f.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.imMessageCenter.im.chat.personaltalk.PersonalTalkSettingActivity.7
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar4) {
                    aVar4.dismiss();
                    TiebaStatic.log("personalchat_morepage_addblack");
                    PersonalTalkSettingActivity.this.eEq.hZ(true);
                }
            }).b(f.j.cancel, new a.b() { // from class: com.baidu.tieba.imMessageCenter.im.chat.personaltalk.PersonalTalkSettingActivity.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar4) {
                    aVar4.dismiss();
                }
            }).b(getPageContext());
            aVar3.xe();
        }
    }

    @Override // com.baidu.tieba.imMessageCenter.im.chat.personaltalk.f.a
    public void Ap() {
        closeLoadingDialog();
        if (this.eEp != null && this.eEq != null) {
            this.eEp.e(this.eEq);
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        boolean z = BdSwitchView.SwitchState.ON == switchState;
        if (z) {
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.DS().DU() || !com.baidu.tbadk.coreExtra.messageCenter.c.DS().Ea()) {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
                aVar.cf(f.j.error_open_personal_single_alloff);
                aVar.b(getResources().getString(f.j.group_create_private_isee), new a.b() { // from class: com.baidu.tieba.imMessageCenter.im.chat.personaltalk.PersonalTalkSettingActivity.8
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar.dismiss();
                    }
                });
                aVar.b(getPageContext());
                aVar.xe();
                D(false, z);
                return;
            }
            closeLoadingDialog();
            showLoadingDialog(null);
            this.eEq.hY(z);
            return;
        }
        closeLoadingDialog();
        showLoadingDialog(null);
        this.eEq.hY(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(boolean z, final boolean z2) {
        if (z) {
            boolean aNY = this.eEq.aNY();
            this.eEq.hX(z2);
            this.eEp.ia(z2);
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.imMessageCenter.im.chat.personaltalk.PersonalTalkSettingActivity.10
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    if (!z2) {
                        com.baidu.tieba.im.settingcache.e.aNt().h(TbadkCoreApplication.getCurrentAccount(), String.valueOf(PersonalTalkSettingActivity.this.userId), false);
                        return null;
                    }
                    com.baidu.tieba.im.settingcache.e.aNt().h(TbadkCoreApplication.getCurrentAccount(), String.valueOf(PersonalTalkSettingActivity.this.userId), true);
                    return null;
                }
            }.execute(new Void[0]);
            if (aNY != this.eEq.aNY()) {
                MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(3));
                return;
            }
            return;
        }
        com.baidu.adp.lib.g.e.in().postDelayed(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.im.chat.personaltalk.PersonalTalkSettingActivity.2
            @Override // java.lang.Runnable
            public void run() {
                PersonalTalkSettingActivity.this.eEp.a((BdSwitchView.a) null);
                PersonalTalkSettingActivity.this.eEp.ia(!z2);
                PersonalTalkSettingActivity.this.eEp.a(PersonalTalkSettingActivity.this);
            }
        }, 500L);
    }
}
