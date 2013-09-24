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
import com.baidu.zeus.WebChromeClient;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class MoreActivity extends com.baidu.tieba.j implements com.baidu.adp.widget.BdSwitchView.c {

    /* renamed from: a */
    private af f1467a;
    private MoreModel b = null;
    private ae c = null;

    public static void a(com.baidu.tieba.j jVar, int i, PersonChangeData personChangeData) {
        Intent intent = new Intent(jVar, MoreActivity.class);
        intent.putExtra("person_change_data", personChangeData);
        jVar.startActivityForResult(intent, i);
    }

    public static void a(Activity activity) {
        activity.startActivity(new Intent(activity, MoreActivity.class));
    }

    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1467a = new af(this, b());
        a(bundle);
        d();
    }

    private aa b() {
        return new ab(this);
    }

    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        e();
    }

    @Override // com.baidu.tieba.j, android.app.Activity
    public void onResume() {
        super.onResume();
        if (TiebaApplication.n()) {
            if (TiebaApplication.C() == null || TiebaApplication.G() == null || TiebaApplication.G().equals("BaiduUser")) {
                this.f1467a.c();
            } else {
                this.f1467a.b();
            }
            this.f1467a.d();
        }
        if (this.f1467a != null) {
            this.f1467a.g();
        }
    }

    @Override // com.baidu.tieba.j
    public void a(int i) {
        super.a(i);
        this.f1467a.a(i);
    }

    @Override // com.baidu.tieba.j
    public void j() {
        d(-1);
        this.f1467a.h();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("person_change_data", this.b.c());
        super.onSaveInstanceState(bundle);
    }

    @Override // com.baidu.tieba.j, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            c();
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case WebChromeClient.STRING_DLG_TITLE_DATETIME /* 101 */:
                    PersonChangeData personChangeData = (PersonChangeData) intent.getSerializableExtra("data");
                    this.b.a(personChangeData);
                    this.b.a(true);
                    if (personChangeData != null && personChangeData.getPhotoChanged() && this.f1467a != null) {
                        this.f1467a.f();
                        String portrait = personChangeData.getPortrait();
                        if (portrait != null && portrait.length() > 0 && this.f1467a != null) {
                            this.f1467a.b(portrait);
                            new ad(this, null).execute(new Object[0]);
                            return;
                        }
                        return;
                    }
                    return;
                case 12008:
                    m();
                    return;
                default:
                    return;
            }
        }
    }

    private void c() {
        if (this.b.a()) {
            Intent intent = new Intent();
            intent.putExtra("person_change_data", this.b.c());
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
            this.f1467a.a(personChangeData.getPortrait());
        }
        this.b = new MoreModel(personChangeData);
        this.b.setLoadDataCallBack(new ac(this));
    }

    private void d() {
        this.c = new ae(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.baidu.tieba.broadcast.newversion");
        registerReceiver(this.c, intentFilter);
    }

    private void e() {
        if (this.c != null) {
            unregisterReceiver(this.c);
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
    }

    public void m() {
        String C = TiebaApplication.C();
        if (C == null || C.length() <= 0) {
            LoginActivity.a((Activity) this, getString(R.string.login_feedback), true, 12008);
            return;
        }
        AntiData antiData = new AntiData();
        antiData.setIfpost(1);
        WriteActivity.a(this, com.baidu.tieba.data.g.h(), com.baidu.tieba.data.g.g(), antiData);
    }

    public void n() {
        String str;
        String str2 = com.baidu.tieba.data.g.g;
        if (str2.indexOf("?") < 0) {
            str2 = String.valueOf(str2) + "?";
        } else if (!str2.endsWith("?") && !str2.endsWith("&")) {
            str2 = String.valueOf(str2) + "&";
        }
        if (TiebaApplication.g().ap() == 1) {
            str = String.valueOf(str2) + "night_type=1";
        } else {
            str = String.valueOf(str2) + "night_type=0";
        }
        AppsActivity.a(this, str);
    }

    public void o() {
        AboutActivity.a((Context) this);
    }

    public void p() {
        BrowseSettingActivity.a(this);
    }

    public void q() {
        if (TiebaApplication.n()) {
            com.baidu.tieba.f.a(this, 0, 4, false);
            return;
        }
        String C = TiebaApplication.C();
        if ((C == null || C.length() <= 0) && DatabaseService.m() <= 0) {
            LoginActivity.a(this, 1, getString(R.string.login_manage_account), 11003);
        } else {
            AccountActivity.a(this);
        }
    }

    public void r() {
        String C = TiebaApplication.C();
        if (C != null && C.length() > 0) {
            PersonChangeActivity.a(this, WebChromeClient.STRING_DLG_TITLE_DATETIME, this.b.c(), false);
        }
    }

    public void s() {
        c();
        finish();
    }

    public void t() {
        MsgRemindActivity.a(this);
    }
}
