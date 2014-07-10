package com.baidu.tieba.more;

import android.app.Activity;
import android.content.Context;
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
import com.baidu.tbadk.core.atomData.bk;
import com.baidu.tbadk.core.atomData.bv;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
import com.baidu.tieba.data.PersonChangeData;
import com.baidu.tieba.model.MoreModel;
import com.baidu.tieba.person.PersonChangeActivity;
/* loaded from: classes.dex */
public class MoreActivity extends BaseActivity implements com.baidu.adp.widget.BdSwitchView.c {
    private w a;
    private com.baidu.tieba.person.o c;
    private MoreModel b = null;
    private v d = null;
    private com.baidu.tbadk.editortool.aa e = null;

    public static void a(Activity activity, int i, PersonChangeData personChangeData) {
        Intent intent = new Intent(activity, MoreActivity.class);
        intent.putExtra("person_change_data", personChangeData);
        activity.startActivityForResult(intent, i);
    }

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2015004, new q());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = new w(this, a());
        a(bundle);
        c();
        this.e = new com.baidu.tbadk.editortool.aa(this);
    }

    private p a() {
        return new r(this);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        d();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.a != null) {
            this.a.c();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.a.a(i);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onResourceRecycle() {
        setSkinType(-1);
        this.a.d();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("person_change_data", this.b.b());
        super.onSaveInstanceState(bundle);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            b();
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 101:
                    PersonChangeData personChangeData = (PersonChangeData) intent.getSerializableExtra("data");
                    this.b.a(personChangeData);
                    this.b.a(true);
                    if (personChangeData != null && personChangeData.getPhotoChanged() && this.a != null) {
                        this.a.b();
                        String portrait = personChangeData.getPortrait();
                        if (portrait != null && portrait.length() > 0 && this.a != null) {
                            this.a.b(portrait);
                            com.baidu.adp.widget.a.a c = this.e.c(portrait);
                            if (c != null) {
                                this.a.a(c);
                                return;
                            } else {
                                this.e.a(portrait, new s(this));
                                return;
                            }
                        }
                        return;
                    }
                    return;
                case 12008:
                    e();
                    return;
                default:
                    return;
            }
        }
    }

    private void b() {
        if (this.b.a()) {
            Intent intent = new Intent();
            intent.putExtra("person_change_data", this.b.b());
            setResult(-1, intent);
        }
    }

    private void a(Bundle bundle) {
        PersonChangeData personChangeData;
        if (bundle != null) {
            personChangeData = (PersonChangeData) bundle.getSerializable("person_change_data");
        } else {
            personChangeData = (PersonChangeData) getIntent().getSerializableExtra("person_change_data");
        }
        if (personChangeData == null) {
            this.c = new com.baidu.tieba.person.o(this);
            this.c.a(TbadkApplication.getCurrentAccount());
            this.c.setLoadDataCallBack(new t(this));
            this.c.a(true, true);
        }
        a(personChangeData);
    }

    public void a(PersonChangeData personChangeData) {
        if (personChangeData != null && personChangeData.getPortrait() != null) {
            this.a.a(personChangeData.getPortrait());
        }
        this.b = new MoreModel(personChangeData);
        this.b.setLoadDataCallBack(new u(this));
    }

    private void c() {
        this.d = new v(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
        registerReceiver(this.d, intentFilter);
    }

    private void d() {
        if (this.d != null) {
            unregisterReceiver(this.d);
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
    }

    public void e() {
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            LoginActivity.a((Activity) this, getString(com.baidu.tieba.y.login_feedback), true, 12008);
            return;
        }
        AntiData antiData = new AntiData();
        antiData.setIfpost(1);
        if (antiData != null && antiData.getIfpost() == 0) {
            com.baidu.adp.lib.util.j.a((Context) this, antiData.getForbid_info());
            return;
        }
        antiData.setIfVoice(false);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new bv(this, 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, antiData, 13003, true, false, null, false, false, null, null, null, 0)));
    }

    public void f() {
        String str;
        String str2 = com.baidu.tieba.data.e.f;
        if (str2.indexOf("?") < 0) {
            str2 = String.valueOf(str2) + "?";
        } else if (!str2.endsWith("?") && !str2.endsWith("&")) {
            str2 = String.valueOf(str2) + "&";
        }
        if (TbadkApplication.m252getInst().getSkinType() == 1) {
            str = String.valueOf(str2) + "night_type=1";
        } else {
            str = String.valueOf(str2) + "night_type=0";
        }
        AppsActivity.a(this, str);
    }

    public void g() {
        AboutActivity.a((Context) this);
    }

    public void h() {
        BrowseSettingActivity.a(this);
    }

    public void i() {
        String currentAccount = TbadkApplication.getCurrentAccount();
        if ((currentAccount == null || currentAccount.length() <= 0) && com.baidu.tbadk.core.account.a.b() <= 0) {
            LoginActivity.a(this, 1, getString(com.baidu.tieba.y.login_manage_account), 11003);
        } else {
            sendMessage(new CustomMessage(2015006, new com.baidu.tbadk.core.frameworkData.a(this)));
        }
    }

    public void j() {
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            PersonChangeActivity.a(this, 101, this.b.b(), false);
        }
    }

    public void k() {
        b();
        finish();
    }

    public void l() {
        MsgRemindActivity.a(this);
    }

    public void m() {
        sendMessage(new CustomMessage(2002001, new bk(this)));
    }
}
