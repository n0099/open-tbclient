package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.util.ab;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.l;
import com.baidu.tieba.R;
import com.baidu.tieba.im.db.m;
import com.baidu.tieba.im.message.ClearChatMsgResponsedMessage;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.imMessageCenter.im.chat.personaltalk.f;
/* loaded from: classes9.dex */
public class PersonalTalkSettingActivity extends BaseActivity<PersonalTalkSettingActivity> implements BdSwitchView.a, f.a {
    private g hNG;
    private f hNH;
    private com.baidu.tieba.ueg.a hNI;
    private com.baidu.adp.framework.listener.c hNJ = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_UPDATE_MASK_INFO) { // from class: com.baidu.tieba.imMessageCenter.im.chat.personaltalk.PersonalTalkSettingActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonalTalkSettingActivity.this.closeLoadingDialog();
            if ((socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (socketResponsedMessage.getOrginalMessage() instanceof RequestUpdateMaskInfoMessage)) {
                RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) socketResponsedMessage.getOrginalMessage();
                ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage;
                if (requestUpdateMaskInfoMessage.getMaskType() == 9) {
                    PersonalTalkSettingActivity.this.U(!responseUpdateMaskInfoMessage.hasError(), requestUpdateMaskInfoMessage.isSettingMask());
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
        registerListener(CmdConfigSocket.CMD_QUERY_USER_INFO, this.hNH.bZd());
        registerListener(CmdConfigSocket.CMD_UPDATE_MASK_INFO, this.hNH.bZd());
        registerListener(CmdConfigCustom.CMD_UPDATE_ATTENTION, this.hNH.bZe());
        registerListener(this.hNJ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.hNH.onDestory();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putLong(TbEnum.SystemMessage.KEY_USER_ID, this.userId);
    }

    private void initData(Bundle bundle) {
        if (bundle == null) {
            this.userId = getIntent().getLongExtra(TbEnum.SystemMessage.KEY_USER_ID, 0L);
        } else {
            this.userId = bundle.getLong(TbEnum.SystemMessage.KEY_USER_ID);
        }
        this.hNH = new f(this, this, this.userId);
    }

    private void initView() {
        this.hNG = new g(this);
        this.hNG.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        this.hNG.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        CustomResponsedMessage runTask;
        int id = view.getId();
        if (id == R.id.user_info_lin) {
            if (this.hNH != null && this.hNH.bZb() != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getContext(), String.valueOf(this.userId), this.hNH.bZb().name)));
            }
        } else if (id == R.id.remove_from_black_man) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.sR(getPageContext().getContext().getString(R.string.add_black_alert, this.hNH.bZb().nameShow)).a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.imMessageCenter.im.chat.personaltalk.PersonalTalkSettingActivity.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    PersonalTalkSettingActivity.this.hNH.og(false);
                }
            }).b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.imMessageCenter.im.chat.personaltalk.PersonalTalkSettingActivity.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            }).b(getPageContext());
            aVar.aEG();
        } else if (id == R.id.st_delete_talk_history) {
            com.baidu.tbadk.core.dialog.a aVar2 = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar2.sR(getPageContext().getContext().getString(R.string.remove_personal_history)).a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.imMessageCenter.im.chat.personaltalk.PersonalTalkSettingActivity.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar3) {
                    aVar3.dismiss();
                    PersonalTalkSettingActivity.this.showLoadingDialog(null);
                    ac.b(new ab<Boolean>() { // from class: com.baidu.tieba.imMessageCenter.im.chat.personaltalk.PersonalTalkSettingActivity.5.1
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // com.baidu.tbadk.util.ab
                        public Boolean doInBackground() {
                            return Boolean.valueOf(m.bUX().CN(String.valueOf(PersonalTalkSettingActivity.this.userId)));
                        }
                    }, new l<Boolean>() { // from class: com.baidu.tieba.imMessageCenter.im.chat.personaltalk.PersonalTalkSettingActivity.5.2
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.tbadk.util.l
                        public void onReturnDataInUI(Boolean bool) {
                            PersonalTalkSettingActivity.this.closeLoadingDialog();
                            MessageManager.getInstance().dispatchResponsedMessageToUI(new ClearChatMsgResponsedMessage());
                            PersonalTalkSettingActivity.this.showToast(R.string.delete_success, false);
                            MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(String.valueOf(PersonalTalkSettingActivity.this.userId), 2, null, 1)));
                        }
                    });
                }
            }).b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.imMessageCenter.im.chat.personaltalk.PersonalTalkSettingActivity.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar3) {
                    aVar3.dismiss();
                }
            }).b(getPageContext());
            aVar2.aEG();
        } else if (id == R.id.st_report) {
            if (this.hNI == null && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMS_TBEAN_RESOURCE_URL_AND_PHOTO, com.baidu.tieba.ueg.a.class, getPageContext().getPageActivity())) != null) {
                this.hNI = (com.baidu.tieba.ueg.a) runTask.getData();
            }
            if (this.hNI != null) {
                this.hNI.t(getUniqueId());
                this.hNI.zD(String.valueOf(this.userId));
                TiebaStatic.log(new an("c13063").X("obj_locate", 2));
            }
        } else if (id == R.id.add_to_black) {
            com.baidu.tbadk.core.dialog.a aVar3 = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar3.sQ(getPageContext().getContext().getString(R.string.sure_add_somebody_to_black, this.hNH.bZb().nameShow));
            aVar3.sR(getPageContext().getContext().getString(R.string.remove_black_alert)).a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.imMessageCenter.im.chat.personaltalk.PersonalTalkSettingActivity.7
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar4) {
                    aVar4.dismiss();
                    TiebaStatic.log("personalchat_morepage_addblack");
                    PersonalTalkSettingActivity.this.hNH.og(true);
                }
            }).b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.imMessageCenter.im.chat.personaltalk.PersonalTalkSettingActivity.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar4) {
                    aVar4.dismiss();
                }
            }).b(getPageContext());
            aVar3.aEG();
        }
    }

    @Override // com.baidu.tieba.imMessageCenter.im.chat.personaltalk.f.a
    public void updateUI() {
        closeLoadingDialog();
        if (this.hNG != null && this.hNH != null) {
            this.hNG.e(this.hNH);
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        boolean z = BdSwitchView.SwitchState.ON == switchState;
        if (z) {
            if (!com.baidu.tbadk.coreExtra.messageCenter.d.aLq().aLs() || !com.baidu.tbadk.coreExtra.messageCenter.d.aLq().aLy()) {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
                aVar.jW(R.string.error_open_personal_single_alloff);
                aVar.b(getResources().getString(R.string.group_create_private_isee), new a.b() { // from class: com.baidu.tieba.imMessageCenter.im.chat.personaltalk.PersonalTalkSettingActivity.8
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar.dismiss();
                    }
                });
                aVar.b(getPageContext());
                aVar.aEG();
                U(false, z);
                return;
            }
            closeLoadingDialog();
            showLoadingDialog(null);
            this.hNH.of(z);
            return;
        }
        closeLoadingDialog();
        showLoadingDialog(null);
        this.hNH.of(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(boolean z, final boolean z2) {
        if (z) {
            boolean bZa = this.hNH.bZa();
            this.hNH.oe(z2);
            this.hNG.oh(z2);
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.imMessageCenter.im.chat.personaltalk.PersonalTalkSettingActivity.10
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    if (!z2) {
                        com.baidu.tieba.im.settingcache.e.bYv().y(TbadkCoreApplication.getCurrentAccount(), String.valueOf(PersonalTalkSettingActivity.this.userId), false);
                        return null;
                    }
                    com.baidu.tieba.im.settingcache.e.bYv().y(TbadkCoreApplication.getCurrentAccount(), String.valueOf(PersonalTalkSettingActivity.this.userId), true);
                    return null;
                }
            }.execute(new Void[0]);
            if (bZa != this.hNH.bZa()) {
                MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(3));
                return;
            }
            return;
        }
        com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.im.chat.personaltalk.PersonalTalkSettingActivity.2
            @Override // java.lang.Runnable
            public void run() {
                PersonalTalkSettingActivity.this.hNG.a((BdSwitchView.a) null);
                PersonalTalkSettingActivity.this.hNG.oh(!z2);
                PersonalTalkSettingActivity.this.hNG.a(PersonalTalkSettingActivity.this);
            }
        }, 500L);
    }
}
