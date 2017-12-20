package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.util.h;
import com.baidu.tbadk.util.u;
import com.baidu.tbadk.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.im.db.l;
import com.baidu.tieba.im.message.ClearChatMsgResponsedMessage;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.imMessageCenter.im.chat.personaltalk.f;
/* loaded from: classes2.dex */
public class PersonalTalkSettingActivity extends BaseActivity<PersonalTalkSettingActivity> implements BdSwitchView.a, f.a {
    private g dXN;
    private f dXO;
    private com.baidu.adp.framework.listener.c dXP = new com.baidu.adp.framework.listener.c(104102) { // from class: com.baidu.tieba.imMessageCenter.im.chat.personaltalk.PersonalTalkSettingActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonalTalkSettingActivity.this.closeLoadingDialog();
            if ((socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (socketResponsedMessage.getOrginalMessage() instanceof RequestUpdateMaskInfoMessage)) {
                RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) socketResponsedMessage.getOrginalMessage();
                ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage;
                if (requestUpdateMaskInfoMessage.getMaskType() == 9) {
                    PersonalTalkSettingActivity.this.B(!responseUpdateMaskInfoMessage.hasError(), requestUpdateMaskInfoMessage.isSettingMask());
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
        registerListener(205003, this.dXO.aDW());
        registerListener(104102, this.dXO.aDW());
        registerListener(CmdConfigCustom.CMD_UPDATE_ATTENTION, this.dXO.aDX());
        registerListener(this.dXP);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.dXO.onDestory();
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
        this.dXO = new f(this, this, this.userId);
    }

    private void initView() {
        this.dXN = new g(this);
        this.dXN.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ag(i == 1);
        this.dXN.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == d.g.user_info_lin) {
            if (this.dXO != null && this.dXO.aDU() != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getContext(), String.valueOf(this.userId), this.dXO.aDU().name)));
            }
        } else if (id == d.g.remove_from_black_man) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.cS(getPageContext().getContext().getString(d.j.add_black_alert, this.dXO.aDU().name)).a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.imMessageCenter.im.chat.personaltalk.PersonalTalkSettingActivity.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    PersonalTalkSettingActivity.this.dXO.ho(false);
                }
            }).b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.imMessageCenter.im.chat.personaltalk.PersonalTalkSettingActivity.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            }).b(getPageContext());
            aVar.th();
        } else if (id == d.g.st_delete_talk_history) {
            com.baidu.tbadk.core.dialog.a aVar2 = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar2.cS(getPageContext().getContext().getString(d.j.remove_personal_history)).a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.imMessageCenter.im.chat.personaltalk.PersonalTalkSettingActivity.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar3) {
                    aVar3.dismiss();
                    PersonalTalkSettingActivity.this.showLoadingDialog(null);
                    v.b(new u<Boolean>() { // from class: com.baidu.tieba.imMessageCenter.im.chat.personaltalk.PersonalTalkSettingActivity.5.1
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // com.baidu.tbadk.util.u
                        public Boolean doInBackground() {
                            return Boolean.valueOf(l.azF().mD(String.valueOf(PersonalTalkSettingActivity.this.userId)));
                        }
                    }, new h<Boolean>() { // from class: com.baidu.tieba.imMessageCenter.im.chat.personaltalk.PersonalTalkSettingActivity.5.2
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.tbadk.util.h
                        public void onReturnDataInUI(Boolean bool) {
                            PersonalTalkSettingActivity.this.closeLoadingDialog();
                            MessageManager.getInstance().dispatchResponsedMessageToUI(new ClearChatMsgResponsedMessage());
                            PersonalTalkSettingActivity.this.showToast(d.j.delete_success, false);
                            MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(String.valueOf(PersonalTalkSettingActivity.this.userId), 2, null, 1)));
                        }
                    });
                }
            }).b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.imMessageCenter.im.chat.personaltalk.PersonalTalkSettingActivity.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar3) {
                    aVar3.dismiss();
                }
            }).b(getPageContext());
            aVar2.th();
        } else if (id == d.g.add_to_black) {
            com.baidu.tbadk.core.dialog.a aVar3 = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar3.cR(getPageContext().getContext().getString(d.j.sure_add_somebody_to_black, this.dXO.aDU().name));
            aVar3.cS(getPageContext().getContext().getString(d.j.remove_black_alert)).a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.imMessageCenter.im.chat.personaltalk.PersonalTalkSettingActivity.7
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar4) {
                    aVar4.dismiss();
                    TiebaStatic.log("personalchat_morepage_addblack");
                    PersonalTalkSettingActivity.this.dXO.ho(true);
                }
            }).b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.imMessageCenter.im.chat.personaltalk.PersonalTalkSettingActivity.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar4) {
                    aVar4.dismiss();
                }
            }).b(getPageContext());
            aVar3.th();
        }
    }

    @Override // com.baidu.tieba.imMessageCenter.im.chat.personaltalk.f.a
    public void wp() {
        closeLoadingDialog();
        if (this.dXN != null && this.dXO != null) {
            this.dXN.e(this.dXO);
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        boolean z = BdSwitchView.SwitchState.ON == switchState;
        if (z) {
            if (!com.baidu.tbadk.coreExtra.messageCenter.b.zk().zm() || !com.baidu.tbadk.coreExtra.messageCenter.b.zk().zs()) {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
                aVar.cd(d.j.error_open_personal_single_alloff);
                aVar.b(getResources().getString(d.j.group_create_private_isee), new a.b() { // from class: com.baidu.tieba.imMessageCenter.im.chat.personaltalk.PersonalTalkSettingActivity.8
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar.dismiss();
                    }
                });
                aVar.b(getPageContext());
                aVar.th();
                B(false, z);
                return;
            }
            closeLoadingDialog();
            showLoadingDialog(null);
            this.dXO.hn(z);
            return;
        }
        closeLoadingDialog();
        showLoadingDialog(null);
        this.dXO.hn(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(boolean z, final boolean z2) {
        if (z) {
            boolean aDT = this.dXO.aDT();
            this.dXO.hm(z2);
            this.dXN.hp(z2);
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.imMessageCenter.im.chat.personaltalk.PersonalTalkSettingActivity.10
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    if (!z2) {
                        com.baidu.tieba.im.settingcache.e.aDi().h(TbadkCoreApplication.getCurrentAccount(), String.valueOf(PersonalTalkSettingActivity.this.userId), false);
                        return null;
                    }
                    com.baidu.tieba.im.settingcache.e.aDi().h(TbadkCoreApplication.getCurrentAccount(), String.valueOf(PersonalTalkSettingActivity.this.userId), true);
                    return null;
                }
            }.execute(new Void[0]);
            if (aDT != this.dXO.aDT()) {
                MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(3));
                return;
            }
            return;
        }
        com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.im.chat.personaltalk.PersonalTalkSettingActivity.2
            @Override // java.lang.Runnable
            public void run() {
                PersonalTalkSettingActivity.this.dXN.a((BdSwitchView.a) null);
                PersonalTalkSettingActivity.this.dXN.hp(!z2);
                PersonalTalkSettingActivity.this.dXN.a(PersonalTalkSettingActivity.this);
            }
        }, 500L);
    }
}
