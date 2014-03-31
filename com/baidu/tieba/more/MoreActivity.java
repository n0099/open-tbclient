package com.baidu.tieba.more;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.b.av;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
import com.baidu.tieba.data.PersonChangeData;
import com.baidu.tieba.model.MoreModel;
import com.baidu.tieba.person.PersonChangeActivity;
import com.baidu.tieba.person.PersonInfoActivity;
/* loaded from: classes.dex */
public class MoreActivity extends com.baidu.tbadk.a implements com.baidu.adp.widget.BdSwitchView.c {
    private w a;
    private com.baidu.tieba.person.t c;
    private MoreModel b = null;
    private v d = null;
    private com.baidu.tbadk.editortool.aa e = null;

    public static void a(Activity activity, int i, PersonChangeData personChangeData) {
        Intent intent = new Intent(activity, MoreActivity.class);
        intent.putExtra("person_change_data", personChangeData);
        activity.startActivityForResult(intent, PersonInfoActivity.REQUSET_CHANGE);
    }

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2015004, new q());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        com.baidu.adp.framework.c.a().a(customMessageTask);
    }

    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = new w(this, new r(this));
        PersonChangeData personChangeData = bundle != null ? (PersonChangeData) bundle.getSerializable("person_change_data") : (PersonChangeData) getIntent().getSerializableExtra("person_change_data");
        if (personChangeData == null) {
            this.c = new com.baidu.tieba.person.t(this);
            this.c.a(TbadkApplication.E());
            this.c.setLoadDataCallBack(new t(this));
            this.c.a(true, true);
        }
        a(personChangeData);
        this.d = new v(this, (byte) 0);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(com.baidu.tbadk.core.data.n.z());
        registerReceiver(this.d, intentFilter);
        this.e = new com.baidu.tbadk.editortool.aa(this);
    }

    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.d != null) {
            unregisterReceiver(this.d);
        }
    }

    @Override // com.baidu.tbadk.a, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.a != null) {
            this.a.d();
        }
    }

    @Override // com.baidu.tbadk.a
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.a.a(i);
    }

    @Override // com.baidu.tbadk.a
    public void onResourceRecycle() {
        setSkinType(-1);
        this.a.e();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("person_change_data", this.b.b());
        super.onSaveInstanceState(bundle);
    }

    @Override // com.baidu.tbadk.a, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            a();
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case PersonInfoActivity.REQUSET_CHANGE /* 101 */:
                    PersonChangeData personChangeData = (PersonChangeData) intent.getSerializableExtra("data");
                    this.b.a(personChangeData);
                    this.b.a(true);
                    if (personChangeData != null && personChangeData.getPhotoChanged() && this.a != null) {
                        this.a.a();
                        String portrait = personChangeData.getPortrait();
                        if (portrait != null && portrait.length() > 0 && this.a != null) {
                            this.a.b(portrait);
                            com.baidu.tbadk.editortool.aa aaVar = this.e;
                            com.baidu.adp.widget.ImageView.b b = com.baidu.tbadk.imageManager.e.a().b(portrait);
                            if (b != null) {
                                this.a.a(b);
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
                    b();
                    return;
                default:
                    return;
            }
        }
    }

    private void a() {
        if (this.b.a()) {
            Intent intent = new Intent();
            intent.putExtra("person_change_data", this.b.b());
            setResult(-1, intent);
        }
    }

    public void a(PersonChangeData personChangeData) {
        if (personChangeData != null && personChangeData.getPortrait() != null) {
            this.a.a(personChangeData.getPortrait());
        }
        this.b = new MoreModel(personChangeData);
        this.b.setLoadDataCallBack(new u(this));
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public final void a(View view, BdSwitchView.SwitchState switchState) {
    }

    public void b() {
        String E = TbadkApplication.E();
        if (E == null || E.length() <= 0) {
            LoginActivity.a((Activity) this, getString(com.baidu.tieba.a.k.login_feedback), true, 12008);
            return;
        }
        AntiData antiData = new AntiData();
        antiData.setIfpost(1);
        if (antiData.getIfpost() == 0) {
            com.baidu.adp.lib.util.i.a((Context) this, antiData.getForbid_info());
            return;
        }
        antiData.setIfVoice(false);
        com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001001, new av(this, 0, com.baidu.tbadk.core.data.n.y(), com.baidu.tbadk.core.data.n.x(), null, null, 0, antiData, 13003, true, false, null, false, false, null, null, null)));
    }

    public static /* synthetic */ void i(MoreActivity moreActivity) {
        String str = com.baidu.tieba.data.d.f;
        if (str.indexOf("?") < 0) {
            str = String.valueOf(str) + "?";
        } else if (!str.endsWith("?") && !str.endsWith("&")) {
            str = String.valueOf(str) + "&";
        }
        AppsActivity.a(moreActivity, TbadkApplication.j().l() == 1 ? String.valueOf(str) + "night_type=1" : String.valueOf(str) + "night_type=0");
    }

    public static /* synthetic */ void d(MoreActivity moreActivity) {
        String E = TbadkApplication.E();
        if ((E == null || E.length() <= 0) && com.baidu.tbadk.core.a.o.b() <= 0) {
            LoginActivity.a(moreActivity, 1, moreActivity.getString(com.baidu.tieba.a.k.login_manage_account), 11003);
        } else {
            moreActivity.sendMessage(new com.baidu.adp.framework.message.a(2015006, new com.baidu.tbadk.core.frameworkData.a(moreActivity)));
        }
    }

    public static /* synthetic */ void c(MoreActivity moreActivity) {
        String E = TbadkApplication.E();
        if (E == null || E.length() <= 0) {
            return;
        }
        PersonChangeActivity.a(moreActivity, PersonInfoActivity.REQUSET_CHANGE, moreActivity.b.b(), false);
    }

    public static /* synthetic */ void b(MoreActivity moreActivity) {
        moreActivity.a();
        moreActivity.finish();
    }
}
