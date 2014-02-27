package com.baidu.tieba.more;

import android.app.Activity;
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
        activity.startActivityForResult(intent, SocialAPIErrorCodes.ERROR_INVALID_CLIENT_ID);
    }

    public static void a(Activity activity) {
        activity.startActivity(new Intent(activity, MoreActivity.class));
    }

    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = new ag(this, new ac(this));
        PersonChangeData personChangeData = bundle != null ? (PersonChangeData) bundle.getSerializable("person_change_data") : (PersonChangeData) getIntent().getSerializableExtra("person_change_data");
        if (personChangeData != null && personChangeData.getPortrait() != null) {
            this.a.a(personChangeData.getPortrait());
        }
        this.b = new MoreModel(personChangeData);
        this.b.setLoadDataCallBack(new ae(this));
        this.c = new af(this, (byte) 0);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(com.baidu.tieba.data.i.a());
        registerReceiver(this.c, intentFilter);
        this.d = new com.baidu.tieba.util.i(this);
    }

    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.c != null) {
            unregisterReceiver(this.c);
        }
    }

    @Override // com.baidu.tieba.f, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.a != null) {
            this.a.d();
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
        this.a.e();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("person_change_data", this.b.b());
        super.onSaveInstanceState(bundle);
    }

    @Override // com.baidu.tieba.f, android.app.Activity, android.view.KeyEvent.Callback
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
                case SocialAPIErrorCodes.ERROR_INVALID_CLIENT_ID /* 101 */:
                    PersonChangeData personChangeData = (PersonChangeData) intent.getSerializableExtra("data");
                    this.b.a(personChangeData);
                    this.b.a(true);
                    if (personChangeData != null && personChangeData.getPhotoChanged() && this.a != null) {
                        this.a.a();
                        String portrait = personChangeData.getPortrait();
                        if (portrait != null && portrait.length() > 0 && this.a != null) {
                            this.a.b(portrait);
                            com.baidu.tieba.util.i iVar = this.d;
                            com.baidu.adp.widget.ImageView.b b = com.baidu.tbadk.imageManager.e.a().b(portrait);
                            if (b != null) {
                                this.a.a(b);
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

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public final void a(View view, BdSwitchView.SwitchState switchState) {
    }

    public void b() {
        String v = TiebaApplication.v();
        if (v == null || v.length() <= 0) {
            LoginActivity.a((Activity) this, getString(R.string.login_feedback), true, 12008);
            return;
        }
        AntiData antiData = new AntiData();
        antiData.setIfpost(1);
        WriteActivity.a(this, com.baidu.tieba.data.i.s(), com.baidu.tieba.data.i.r(), antiData);
    }

    public static /* synthetic */ void i(MoreActivity moreActivity) {
        String str = com.baidu.tieba.data.i.g;
        if (str.indexOf("?") < 0) {
            str = String.valueOf(str) + "?";
        } else if (!str.endsWith("?") && !str.endsWith("&")) {
            str = String.valueOf(str) + "&";
        }
        AppsActivity.a(moreActivity, TiebaApplication.g().ae() == 1 ? String.valueOf(str) + "night_type=1" : String.valueOf(str) + "night_type=0");
    }

    public static /* synthetic */ void d(MoreActivity moreActivity) {
        String v = TiebaApplication.v();
        if ((v == null || v.length() <= 0) && DatabaseService.k() <= 0) {
            LoginActivity.a(moreActivity, 1, moreActivity.getString(R.string.login_manage_account), 11003);
        } else {
            AccountActivity.a(moreActivity);
        }
    }

    public static /* synthetic */ void c(MoreActivity moreActivity) {
        String v = TiebaApplication.v();
        if (v == null || v.length() <= 0) {
            return;
        }
        PersonChangeActivity.a(moreActivity, SocialAPIErrorCodes.ERROR_INVALID_CLIENT_ID, moreActivity.b.b(), false);
    }

    public static /* synthetic */ void b(MoreActivity moreActivity) {
        moreActivity.a();
        moreActivity.finish();
    }
}
