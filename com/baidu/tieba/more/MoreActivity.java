package com.baidu.tieba.more;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.SecretSettingActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
import com.baidu.tieba.data.PersonChangeData;
import com.baidu.tieba.model.MoreModel;
import com.baidu.tieba.person.PersonChangeActivity;
/* loaded from: classes.dex */
public class MoreActivity extends BaseActivity implements com.baidu.adp.widget.BdSwitchView.c {
    private ag brh;
    private ac brj;
    private MoreModel bri = null;
    private ab brk = null;

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2015004, new x());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.brh = new ag(this, UO());
        k(bundle);
        nY();
    }

    private r UO() {
        return new y(this);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Jx();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.brh != null) {
            this.brh.refreshNewVersion();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.brh.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onResourceRecycle() {
        setSkinType(-1);
        this.brh.QR();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("person_change_data", this.bri.TQ());
        super.onSaveInstanceState(bundle);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            UP();
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        String portrait;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 101:
                    PersonChangeData personChangeData = (PersonChangeData) intent.getSerializableExtra("data");
                    this.bri.a(personChangeData);
                    this.bri.dG(true);
                    if (personChangeData != null && personChangeData.getPhotoChanged() && this.brh != null && (portrait = personChangeData.getPortrait()) != null && portrait.length() > 0 && this.brh != null) {
                        this.brh.w(portrait, true);
                        return;
                    }
                    return;
                case 12008:
                    UQ();
                    return;
                default:
                    return;
            }
        }
    }

    private void UP() {
        if (this.bri.TP()) {
            Intent intent = new Intent();
            intent.putExtra("person_change_data", this.bri.TQ());
            setResult(-1, intent);
        }
    }

    private void k(Bundle bundle) {
        PersonChangeData personChangeData;
        if (bundle != null) {
            personChangeData = (PersonChangeData) bundle.getSerializable("person_change_data");
        } else {
            personChangeData = (PersonChangeData) getIntent().getSerializableExtra("person_change_data");
        }
        if (personChangeData == null) {
            this.brj = new ac(this);
            this.brj.setUniqueId(getUniqueId());
            this.brj.setId(TbadkApplication.getCurrentAccount());
            this.brj.setLoadDataCallBack(new z(this));
            this.brj.c(true, true);
        }
        b(personChangeData);
    }

    public void b(PersonChangeData personChangeData) {
        if (personChangeData != null && personChangeData.getPortrait() != null) {
            this.brh.w(personChangeData.getPortrait(), false);
        }
        this.bri = new MoreModel(personChangeData);
        this.bri.setLoadDataCallBack(new aa(this));
    }

    private void nY() {
        this.brk = new ab(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
        registerReceiver(this.brk, intentFilter);
    }

    private void Jx() {
        if (this.brk != null) {
            unregisterReceiver(this.brk);
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
    }

    public void UQ() {
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            LoginActivity.a((Activity) this, getString(com.baidu.tieba.y.login_feedback), true, 12008);
            return;
        }
        AntiData antiData = new AntiData();
        antiData.setIfpost(1);
        if (antiData != null && antiData.getIfpost() == 0) {
            com.baidu.adp.lib.util.m.showToast(this, antiData.getForbid_info());
            return;
        }
        antiData.setIfVoice(false);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteActivityConfig(this, 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, antiData, 13003, true, false, null, false, false, null, null, null, 0)));
    }

    public void UR() {
        String str;
        String str2 = com.baidu.tieba.data.e.ajH;
        if (str2.indexOf("?") < 0) {
            str2 = String.valueOf(str2) + "?";
        } else if (!str2.endsWith("?") && !str2.endsWith("&")) {
            str2 = String.valueOf(str2) + "&";
        }
        if (TbadkApplication.m251getInst().getSkinType() == 1) {
            str = String.valueOf(str2) + "night_type=1";
        } else {
            str = String.valueOf(str2) + "night_type=0";
        }
        AppsActivity.startActivity(this, str);
    }

    public void US() {
        AboutActivity.ae(this);
    }

    public void UT() {
        BrowseSettingActivity.ae(this);
    }

    public void UU() {
        String currentAccount = TbadkApplication.getCurrentAccount();
        if ((currentAccount == null || currentAccount.length() <= 0) && com.baidu.tbadk.core.account.a.jz() <= 0) {
            LoginActivity.a(this, 1, getString(com.baidu.tieba.y.login_manage_account), 11003);
        } else {
            sendMessage(new CustomMessage(2015006, new com.baidu.tbadk.core.frameworkData.a(this)));
        }
    }

    public void UV() {
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            PersonChangeActivity.a(this, 101, this.bri.TQ(), false);
        }
    }

    public void UW() {
        UP();
        finish();
    }

    public void UX() {
        MsgRemindActivity.ae(this);
    }

    public void UY() {
        sendMessage(new CustomMessage(2002001, new SecretSettingActivityConfig(this)));
    }
}
