package com.baidu.tieba.more;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.data.PersonChangeData;
import com.baidu.tieba.model.MoreModel;
import com.baidu.tieba.person.PersonChangeActivity;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.write.WriteActivity;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class MoreActivity extends com.baidu.tieba.f implements com.baidu.adp.widget.BdSwitchView.c {
    private ag a;
    private MoreModel b = null;
    private af c = null;
    private com.baidu.tieba.util.i d = null;

    public static void a(Activity activity, int i, PersonChangeData personChangeData) {
        Intent intent = new Intent(activity, MoreActivity.class);
        intent.putExtra("person_change_data", personChangeData);
        activity.startActivityForResult(intent, i);
    }

    public static void a(Activity activity) {
        activity.startActivity(new Intent(activity, MoreActivity.class));
    }

    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = new ag(this, a());
        a(bundle);
        c();
        this.d = new com.baidu.tieba.util.i(this);
    }

    private ab a() {
        return new ac(this);
    }

    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        d();
    }

    @Override // com.baidu.tieba.f, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.a != null) {
            this.a.f();
        }
    }

    @Override // com.baidu.tieba.f
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.a.a(i);
    }

    @Override // com.baidu.tieba.f
    public void onResourceRecycle() {
        setSkinType(-1);
        this.a.g();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("person_change_data", this.b.b());
        super.onSaveInstanceState(bundle);
    }

    @Override // com.baidu.tieba.f, android.app.Activity, android.view.KeyEvent.Callback
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
                case SocialAPIErrorCodes.ERROR_INVALID_CLIENT_ID /* 101 */:
                    PersonChangeData personChangeData = (PersonChangeData) intent.getSerializableExtra("data");
                    this.b.a(personChangeData);
                    this.b.a(true);
                    if (personChangeData != null && personChangeData.getPhotoChanged() && this.a != null) {
                        this.a.e();
                        String portrait = personChangeData.getPortrait();
                        if (portrait != null && portrait.length() > 0 && this.a != null) {
                            this.a.b(portrait);
                            com.baidu.adp.widget.ImageView.b c = this.d.c(portrait);
                            if (c != null) {
                                this.a.a(c);
                                return;
                            } else {
                                this.d.a(portrait, new ad(this));
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
        if (personChangeData != null && personChangeData.getPortrait() != null) {
            this.a.a(personChangeData.getPortrait());
        }
        this.b = new MoreModel(personChangeData);
        this.b.setLoadDataCallBack(new ae(this));
    }

    private void c() {
        this.c = new af(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(com.baidu.tieba.data.i.a());
        registerReceiver(this.c, intentFilter);
    }

    private void d() {
        if (this.c != null) {
            unregisterReceiver(this.c);
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
    }

    public void e() {
        String A = TiebaApplication.A();
        if (A == null || A.length() <= 0) {
            LoginActivity.a((Activity) this, getString(R.string.login_feedback), true, 12008);
            return;
        }
        AntiData antiData = new AntiData();
        antiData.setIfpost(1);
        WriteActivity.a(this, com.baidu.tieba.data.i.s(), com.baidu.tieba.data.i.r(), antiData);
    }

    public void f() {
        String str;
        String str2 = com.baidu.tieba.data.i.g;
        if (str2.indexOf("?") < 0) {
            str2 = String.valueOf(str2) + "?";
        } else if (!str2.endsWith("?") && !str2.endsWith("&")) {
            str2 = String.valueOf(str2) + "&";
        }
        if (TiebaApplication.g().al() == 1) {
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
        String A = TiebaApplication.A();
        if ((A == null || A.length() <= 0) && DatabaseService.k() <= 0) {
            LoginActivity.a(this, 1, getString(R.string.login_manage_account), 11003);
        } else {
            AccountActivity.a(this);
        }
    }

    public void j() {
        String A = TiebaApplication.A();
        if (A != null && A.length() > 0) {
            PersonChangeActivity.a(this, SocialAPIErrorCodes.ERROR_INVALID_CLIENT_ID, this.b.b(), false);
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
        SecretSettingActivity.a(this);
    }
}
