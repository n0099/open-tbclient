package com.baidu.tieba.person;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.data.PersonChangeData;
import com.baidu.tieba.data.UserData;
import com.baidu.tieba.faceshop.FaceShopActivity;
import com.baidu.tieba.more.MoreActivity;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.TbWebViewActivity;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class ai extends com.baidu.tieba.j {
    private static boolean e = false;
    private static boolean f = false;
    private com.baidu.tieba.k b;
    private an c;
    private al d;
    private ak g = null;

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.b = (com.baidu.tieba.k) activity;
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return a(layoutInflater);
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        a();
        c();
        if (TiebaApplication.A() != null && TiebaApplication.A().length() > 0) {
            this.c.f();
            d();
            DatabaseService.b((Boolean) true);
            return;
        }
        f = true;
        this.c.e();
    }

    public View a(LayoutInflater layoutInflater) {
        return layoutInflater.inflate(R.layout.more_discovery_activity, (ViewGroup) null);
    }

    public void a() {
        this.c = new an(this.b, this);
    }

    public void c() {
        if (!UtilHelper.b()) {
            f = true;
        }
        this.d = new al(this.b);
        this.d.a(TiebaApplication.A());
        this.d.setLoadDataCallBack(new aj(this));
    }

    private void d() {
        this.g = new ak(this, null);
        com.baidu.tieba.im.messageCenter.e.a().a(-124, this.g);
    }

    private void e() {
        com.baidu.tieba.im.messageCenter.e.a().a(this.g);
    }

    private void f() {
        if (this.c != null && this.d != null) {
            this.c.a(this.d);
            this.d.a(true, true);
        }
    }

    @Override // com.baidu.tieba.j, android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.user_info /* 2131100950 */:
                if (f && this.d != null) {
                    if (TiebaApplication.B()) {
                        UserData a = this.d.a();
                        cm.a(this.b, this.d.b(), a != null ? a.getName_show() : "");
                        this.d.b(true);
                        return;
                    }
                    LoginActivity.a((Activity) this.b, (String) null, true, 11003);
                    this.d.b(true);
                    return;
                }
                return;
            case R.id.my_collection /* 2131100957 */:
                if (TiebaApplication.A() != null && TiebaApplication.A().length() > 0) {
                    EditMarkActivity.a(this.b, (int) SocialAPIErrorCodes.ERROR_INVALID_SESSION_KEY);
                    this.d.a(true);
                    return;
                }
                LoginActivity.a((Activity) this.b, (String) null, true, 103);
                return;
            case R.id.member_benefits /* 2131100960 */:
                com.baidu.tieba.sharedPref.b.a().b("has_shown_member_benifit", true);
                if (!TiebaApplication.B()) {
                    LoginActivity.a((Activity) this.b, (String) null, true, (int) SocialAPIErrorCodes.ERROR_INVALID_SIGNATURE);
                    return;
                }
                com.baidu.tieba.sharedPref.b.a().b("has_shown_member_benifit", true);
                TbWebViewActivity.a(this.b, getString(R.string.member_benefits), String.valueOf(com.baidu.tieba.data.i.b) + "mo/q/tbeanwireless?_client_version=" + com.baidu.tieba.data.i.u());
                return;
            case R.id.face_store /* 2131100962 */:
                TiebaApplication.g().q(TiebaApplication.g().bi());
                TiebaApplication.g().A(false);
                FaceShopActivity.a(this.b, "faceshop_from_more");
                return;
            case R.id.settings /* 2131100965 */:
                if (this.d != null) {
                    PersonChangeData personChangeData = new PersonChangeData();
                    if (this.d.a() != null) {
                        personChangeData.setName(this.d.a().getName_show());
                        personChangeData.setIntro(this.d.a().getIntro());
                        personChangeData.setPortrait(this.d.a().getPortrait());
                        personChangeData.setSex(this.d.a().getSex());
                    }
                    MoreActivity.a(this.b, SocialAPIErrorCodes.ERROR_INVALID_CLIENT_ID, personChangeData);
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.tieba.j
    public void c(int i) {
        super.c(i);
        this.c.a(i);
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 11003) {
                if (TiebaApplication.A() != null) {
                    this.d.a(TiebaApplication.A());
                    this.d.b(TiebaApplication.F());
                    d();
                    f();
                }
            } else if (i == 103) {
                EditMarkActivity.a(this.b, (int) SocialAPIErrorCodes.ERROR_INVALID_SESSION_KEY);
            } else if (i == 104) {
                TbWebViewActivity.a(this.b, getString(R.string.member_benefits), String.valueOf(com.baidu.tieba.data.i.b) + "mo/q/tbeanwireless?_client_version=" + com.baidu.tieba.data.i.u());
            }
        }
    }

    private void a(PersonChangeData personChangeData) {
        if (personChangeData != null) {
            if (personChangeData != null && this.d.a() != null) {
                this.d.a(personChangeData);
                if (this.c != null) {
                    this.c.b(this.d);
                    if (personChangeData.getPhotoChanged()) {
                        this.c.a();
                        if (this.d.a() != null) {
                            this.d.g().e(this.d.a().getPortrait());
                        }
                    }
                }
            }
            TiebaApplication.g().a((PersonChangeData) null);
        }
    }

    public static void a(boolean z) {
        e = z;
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (b()) {
            if (this.c != null) {
                this.c.b();
                this.c.a(TiebaApplication.g().bj());
            }
            if (e) {
                f();
                e = false;
            } else if (this.d.b() == null || this.d.b().length() <= 0) {
                if (TiebaApplication.A() != null) {
                    this.d.a(TiebaApplication.A());
                    d();
                    f();
                }
            } else {
                if (!this.d.h()) {
                    f();
                }
                PersonChangeData bq = TiebaApplication.g().bq();
                if (bq != null) {
                    a(bq);
                }
                if (com.baidu.tieba.mention.v.a().o() != this.d.c()) {
                    this.d.a(com.baidu.tieba.mention.v.a().o());
                }
                if (com.baidu.tieba.mention.v.a().r() != this.d.d()) {
                    this.d.b(com.baidu.tieba.mention.v.a().r());
                }
                if (this.c != null) {
                    this.c.c(this.d);
                }
            }
        }
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.d != null) {
            if (this.d.b() != null && this.d.b().length() > 0) {
                e();
            }
            this.d.i();
        }
        if (this.c != null) {
            this.c.g();
        }
        super.onDestroy();
    }

    public void a(com.baidu.tieba.im.message.s sVar) {
        boolean z;
        boolean z2 = true;
        if (sVar != null) {
            if (!(sVar instanceof com.baidu.tieba.im.message.v)) {
                com.baidu.adp.lib.util.f.b("transform error");
                return;
            }
            com.baidu.tieba.im.message.v vVar = (com.baidu.tieba.im.message.v) sVar;
            int c = vVar.c();
            int e2 = vVar.e();
            if (this.d != null) {
                if (c != this.d.c()) {
                    this.d.a(c);
                    this.d.b(false);
                    z = true;
                } else {
                    z = false;
                }
                if (e2 > this.d.d()) {
                    this.d.b(e2);
                    this.d.a(false);
                } else if (e2 < this.d.d()) {
                    this.d.b(e2);
                    this.d.a(true);
                } else {
                    z2 = z;
                }
            } else {
                z2 = false;
            }
            if (this.c != null && z2) {
                this.c.c(this.d);
            }
        }
    }
}
