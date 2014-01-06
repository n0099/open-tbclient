package com.baidu.tieba.person;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tieba.BaseFragment;
import com.baidu.tieba.BaseFragmentActivity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.data.PersonChangeData;
import com.baidu.tieba.data.UserData;
import com.baidu.tieba.faceshop.FaceShopActivity;
import com.baidu.tieba.home.ForumTopicActivity;
import com.baidu.tieba.more.MoreActivity;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class MoreDiscoveryActivity extends BaseFragment {
    private static boolean d = false;
    private static boolean e = false;
    private BaseFragmentActivity a;
    private ah b;
    private ae c;
    private ad f = null;

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void a(Activity activity) {
        super.a(activity);
        this.a = (BaseFragmentActivity) activity;
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return a(layoutInflater);
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void a(Bundle bundle) {
        super.a(bundle);
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void d(Bundle bundle) {
        super.d(bundle);
        a();
        G();
        if (TiebaApplication.A() != null && TiebaApplication.A().length() > 0) {
            this.b.f();
            H();
            DatabaseService.b((Boolean) true);
            return;
        }
        e = true;
        this.b.e();
    }

    public View a(LayoutInflater layoutInflater) {
        return layoutInflater.inflate(R.layout.more_discovery_activity, (ViewGroup) null);
    }

    public void a() {
        this.b = new ah(this.a, this);
    }

    public void G() {
        if (!UtilHelper.b()) {
            e = true;
        }
        this.c = new ae(this.a);
        this.c.a(TiebaApplication.A());
        this.c.setLoadDataCallBack(new ac(this));
    }

    private void H() {
        this.f = new ad(this, null);
        com.baidu.tieba.im.messageCenter.e.a().a(-124, this.f);
    }

    private void I() {
        com.baidu.tieba.im.messageCenter.e.a().a(this.f);
    }

    private void J() {
        if (this.b != null && this.c != null) {
            this.b.a(this.c);
            this.c.a(true, true);
        }
    }

    @Override // com.baidu.tieba.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.user_info /* 2131100698 */:
                if (e && this.c != null) {
                    if (TiebaApplication.B()) {
                        UserData a = this.c.a();
                        PersonInfoActivity.a(this.a, this.c.b(), a != null ? a.getName_show() : "");
                        this.c.b(true);
                        return;
                    }
                    LoginActivity.a((Activity) this.a, (String) null, true, 11003);
                    this.c.b(true);
                    return;
                }
                return;
            case R.id.user_photo /* 2131100699 */:
            case R.id.user_layout /* 2131100700 */:
            case R.id.user_signature /* 2131100701 */:
            case R.id.user_login /* 2131100702 */:
            case R.id.user_remind /* 2131100703 */:
            default:
                return;
            case R.id.my_collection /* 2131100704 */:
                if (TiebaApplication.A() != null && TiebaApplication.A().length() > 0) {
                    EditMarkActivity.a(this.a, 102);
                    this.c.a(true);
                    return;
                }
                LoginActivity.a((Activity) this.a, (String) null, true, 103);
                return;
            case R.id.member_benefits /* 2131100705 */:
                com.baidu.tieba.sharedPref.b.a().b("has_shown_member_benifit", true);
                if (!TiebaApplication.B()) {
                    LoginActivity.a((Activity) this.a, (String) null, true, 104);
                    return;
                }
                com.baidu.tieba.sharedPref.b.a().b("has_shown_member_benifit", true);
                ForumTopicActivity.a(this.a, a(R.string.member_benefits), com.baidu.tieba.data.h.b + com.baidu.tieba.data.h.d + com.baidu.tieba.data.h.j());
                return;
            case R.id.face_store /* 2131100706 */:
                TiebaApplication.g().q(TiebaApplication.g().bj());
                TiebaApplication.g().y(false);
                FaceShopActivity.a(this.a, "faceshop_from_more");
                return;
            case R.id.settings /* 2131100707 */:
                if (this.c != null) {
                    PersonChangeData personChangeData = new PersonChangeData();
                    if (this.c.a() != null) {
                        personChangeData.setName(this.c.a().getName_show());
                        personChangeData.setIntro(this.c.a().getIntro());
                        personChangeData.setPortrait(this.c.a().getPortrait());
                    }
                    MoreActivity.a(this.a, 101, personChangeData);
                    return;
                }
                return;
        }
    }

    @Override // com.baidu.tieba.BaseFragment
    public void c(int i) {
        super.c(i);
        this.b.a(i);
    }

    @Override // android.support.v4.app.Fragment
    public void a(int i, int i2, Intent intent) {
        super.a(i, i2, intent);
        if (i2 == -1) {
            if (i == 11003) {
                if (TiebaApplication.A() != null) {
                    this.c.a(TiebaApplication.A());
                    this.c.b(TiebaApplication.G());
                    H();
                    J();
                }
            } else if (i == 103) {
                EditMarkActivity.a(this.a, 102);
            } else if (i == 104) {
                ForumTopicActivity.a(this.a, a(R.string.member_benefits), com.baidu.tieba.data.h.b + com.baidu.tieba.data.h.d + com.baidu.tieba.data.h.j());
            }
        }
    }

    private void a(PersonChangeData personChangeData) {
        if (personChangeData != null) {
            if (personChangeData != null && this.c.a() != null) {
                this.c.a(personChangeData);
                if (this.b != null) {
                    this.b.b(this.c);
                    if (personChangeData.getPhotoChanged()) {
                        this.b.a();
                        if (this.c.a() != null) {
                            this.c.g().e(this.c.a().getPortrait());
                        }
                    }
                }
            }
            TiebaApplication.g().a((PersonChangeData) null);
        }
    }

    public static void a(boolean z) {
        d = z;
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void r() {
        super.r();
        if (F()) {
            if (this.b != null) {
                this.b.b();
                this.b.a(TiebaApplication.g().bk());
            }
            if (d) {
                J();
                d = false;
            } else if (this.c.b() == null || this.c.b().length() <= 0) {
                if (TiebaApplication.A() != null) {
                    this.c.a(TiebaApplication.A());
                    H();
                    J();
                }
            } else {
                if (!this.c.h()) {
                    J();
                }
                PersonChangeData bl = TiebaApplication.g().bl();
                if (bl != null) {
                    a(bl);
                }
                if (com.baidu.tieba.mention.s.a().o() != this.c.c()) {
                    this.c.a(com.baidu.tieba.mention.s.a().o());
                }
                if (com.baidu.tieba.mention.s.a().r() != this.c.d()) {
                    this.c.b(com.baidu.tieba.mention.s.a().r());
                }
                if (this.b != null) {
                    this.b.c(this.c);
                }
            }
        }
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void t() {
        if (this.c != null) {
            if (this.c.b() != null && this.c.b().length() > 0) {
                I();
            }
            this.c.i();
        }
        if (this.b != null) {
            this.b.g();
        }
        super.t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.im.message.o oVar) {
        boolean z;
        boolean z2 = true;
        if (oVar != null) {
            if (!(oVar instanceof com.baidu.tieba.im.message.r)) {
                com.baidu.adp.lib.h.e.a("transform error");
                return;
            }
            com.baidu.tieba.im.message.r rVar = (com.baidu.tieba.im.message.r) oVar;
            int c = rVar.c();
            int e2 = rVar.e();
            if (this.c != null) {
                if (c != this.c.c()) {
                    this.c.a(c);
                    this.c.b(false);
                    z = true;
                } else {
                    z = false;
                }
                if (e2 > this.c.d()) {
                    this.c.b(e2);
                    this.c.a(false);
                } else if (e2 < this.c.d()) {
                    this.c.b(e2);
                    this.c.a(true);
                } else {
                    z2 = z;
                }
            } else {
                z2 = false;
            }
            if (this.b != null && z2) {
                this.b.c(this.c);
            }
        }
    }
}
