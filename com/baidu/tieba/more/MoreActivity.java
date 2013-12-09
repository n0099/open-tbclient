package com.baidu.tieba.more;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
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
public class MoreActivity extends com.baidu.tieba.j implements com.baidu.adp.widget.BdSwitchView.c {

    /* renamed from: a  reason: collision with root package name */
    private ah f2056a;
    private MoreModel b = null;
    private ag c = null;
    private com.baidu.tieba.util.i d = null;

    public static void a(Activity activity, int i, PersonChangeData personChangeData) {
        Intent intent = new Intent(activity, MoreActivity.class);
        intent.putExtra("person_change_data", personChangeData);
        activity.startActivityForResult(intent, i);
    }

    public static void a(Activity activity) {
        activity.startActivity(new Intent(activity, MoreActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f2056a = new ah(this, a());
        a(bundle);
        c();
        this.d = new com.baidu.tieba.util.i(this);
    }

    private ac a() {
        return new ad(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onResume() {
        super.onResume();
        if (TiebaApplication.o()) {
            if (TiebaApplication.B() == null || TiebaApplication.G() == null || TiebaApplication.G().equals("BaiduUser")) {
                this.f2056a.e();
            } else {
                this.f2056a.a();
            }
            this.f2056a.f();
        }
        if (this.f2056a != null) {
            this.f2056a.i();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.f2056a.a(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void onResourceRecycle() {
        setSkinType(-1);
        this.f2056a.j();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("person_change_data", this.b.b());
        super.onSaveInstanceState(bundle);
    }

    @Override // com.baidu.tieba.j, android.app.Activity, android.view.KeyEvent.Callback
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
                    if (personChangeData != null && personChangeData.getPhotoChanged() && this.f2056a != null) {
                        this.f2056a.h();
                        String portrait = personChangeData.getPortrait();
                        if (portrait != null && portrait.length() > 0 && this.f2056a != null) {
                            this.f2056a.b(portrait);
                            com.baidu.adp.widget.ImageView.e c = this.d.c(portrait);
                            if (c != null) {
                                this.f2056a.a(c);
                                return;
                            } else {
                                this.d.c(portrait, new ae(this));
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
            this.f2056a.a(personChangeData.getPortrait());
        }
        this.b = new MoreModel(personChangeData);
        this.b.setLoadDataCallBack(new af(this));
    }

    private void c() {
        this.c = new ag(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.baidu.tieba.broadcast.newversion");
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

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        String B = TiebaApplication.B();
        if (B == null || B.length() <= 0) {
            LoginActivity.a((Activity) this, getString(R.string.login_feedback), true, 12008);
            return;
        }
        AntiData antiData = new AntiData();
        antiData.setIfpost(1);
        WriteActivity.a(this, com.baidu.tieba.data.h.h(), com.baidu.tieba.data.h.g(), antiData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        String str;
        String str2 = com.baidu.tieba.data.h.h;
        if (str2.indexOf("?") < 0) {
            str2 = str2 + "?";
        } else if (!str2.endsWith("?") && !str2.endsWith("&")) {
            str2 = str2 + "&";
        }
        if (TiebaApplication.h().an() == 1) {
            str = str2 + "night_type=1";
        } else {
            str = str2 + "night_type=0";
        }
        AppsActivity.a(this, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        AboutActivity.a((Context) this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        BrowseSettingActivity.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (TiebaApplication.o()) {
            com.baidu.tieba.f.a(this, 0, 4, false);
            return;
        }
        String B = TiebaApplication.B();
        if ((B == null || B.length() <= 0) && DatabaseService.m() <= 0) {
            LoginActivity.a(this, 1, getString(R.string.login_manage_account), 11003);
        } else {
            AccountActivity.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        String B = TiebaApplication.B();
        if (B != null && B.length() > 0) {
            PersonChangeActivity.a(this, 101, this.b.b(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        b();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        MsgRemindActivity.a(this);
    }
}
