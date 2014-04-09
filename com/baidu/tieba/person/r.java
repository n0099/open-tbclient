package com.baidu.tieba.person;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.browser.TbWebViewActivity;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
import com.baidu.tieba.data.PersonChangeData;
import com.baidu.tieba.more.MoreActivity;
/* loaded from: classes.dex */
public final class r extends com.baidu.tbadk.core.d {
    private static boolean e = false;
    private static boolean f = false;
    private com.baidu.tbadk.core.e b;
    private v c;
    private t d;
    private final com.baidu.adp.framework.c.a g;

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onAttach(Activity activity) {
        super.onAttach(activity);
        this.b = (com.baidu.tbadk.core.e) activity;
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(com.baidu.tieba.a.i.more_discovery_activity, (ViewGroup) null);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.c = new v(this.b, this);
        if (!UtilHelper.a()) {
            f = true;
        }
        this.d = new t(this.b);
        this.d.a(TbadkApplication.E());
        this.d.setLoadDataCallBack(new s(this));
        if (TbadkApplication.E() != null && TbadkApplication.E().length() > 0) {
            this.c.e();
            a();
            com.baidu.tieba.util.k.a((Boolean) true);
            return;
        }
        f = true;
        this.c.d();
    }

    private void a() {
        com.baidu.adp.framework.c.a().a(this.g);
    }

    private void b() {
        if (this.c != null && this.d != null) {
            this.c.a(this.d);
            this.d.a(true, true);
        }
    }

    @Override // com.baidu.tbadk.core.d, android.view.View.OnClickListener
    public final void onClick(View view) {
        int id = view.getId();
        if (id == com.baidu.tieba.a.h.user_info) {
            if (f && this.d != null) {
                if (TbadkApplication.F()) {
                    UserData a = this.d.a();
                    com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001003, new com.baidu.tbadk.core.b.ag(this.b, this.d.b(), a != null ? a.getName_show() : "")));
                    this.d.b(true);
                    return;
                }
                LoginActivity.a((Activity) this.b, (String) null, true, 11003);
                this.d.b(true);
            }
        } else if (id == com.baidu.tieba.a.h.my_collection) {
            if (TbadkApplication.E() != null && TbadkApplication.E().length() > 0) {
                a(new com.baidu.adp.framework.message.a(2015005, new com.baidu.tbadk.core.frameworkData.a(this.b)));
                this.d.a(true);
                return;
            }
            LoginActivity.a((Activity) this.b, (String) null, true, 103);
        } else if (id == com.baidu.tieba.a.h.member_benefits) {
            com.baidu.tbadk.core.sharedPref.b.a().b("has_shown_member_benifit", true);
            if (!TbadkApplication.F()) {
                LoginActivity.a((Activity) this.b, (String) null, true, 104);
                return;
            }
            com.baidu.tbadk.core.sharedPref.b.a().b("has_shown_member_benifit", true);
            TbWebViewActivity.a(this.b, getString(com.baidu.tieba.a.k.member_benefits), String.valueOf(com.baidu.tieba.data.d.a) + "mo/q/tbeanmall?_client_version=" + com.baidu.tbadk.core.data.n.c());
        } else if (id == com.baidu.tieba.a.h.face_store) {
            TbadkApplication.j().g(TbadkApplication.j().av());
            TbadkApplication.j().h(false);
            a(new com.baidu.adp.framework.message.a(2001001, new com.baidu.tbadk.core.b.j(this.b, "faceshop_from_more")));
        } else if (id == com.baidu.tieba.a.h.settings && this.d != null) {
            PersonChangeData personChangeData = new PersonChangeData();
            if (this.d.a() != null) {
                personChangeData.setName(this.d.a().getName_show());
                personChangeData.setIntro(this.d.a().getIntro());
                personChangeData.setPortrait(this.d.a().getPortrait());
                personChangeData.setSex(this.d.a().getSex());
            }
            MoreActivity.a(this.b, 101, personChangeData);
        }
    }

    @Override // com.baidu.tbadk.core.d
    public final void c(int i) {
        super.c(i);
        this.c.a(i);
    }

    @Override // android.support.v4.app.Fragment
    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 11003) {
                if (TbadkApplication.E() != null) {
                    this.d.a(TbadkApplication.E());
                    this.d.b(TbadkApplication.O());
                    a();
                    b();
                }
            } else if (i == 103) {
                a(new com.baidu.adp.framework.message.a(2015005, new com.baidu.tbadk.core.frameworkData.a(this.b)));
            } else if (i == 104) {
                TbWebViewActivity.a(this.b, getString(com.baidu.tieba.a.k.member_benefits), String.valueOf(com.baidu.tieba.data.d.a) + "mo/q/tbeanmall?_client_version=" + com.baidu.tbadk.core.data.n.c());
            }
        }
    }

    public static void a(boolean z) {
        e = true;
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onResume() {
        super.onResume();
        if (this.c != null) {
            v vVar = this.c;
            vVar.b();
            vVar.c();
            this.c.a(TbadkApplication.j().ae());
        }
        if (e) {
            b();
            e = false;
        } else if (this.d.b() == null || this.d.b().length() <= 0) {
            if (TbadkApplication.E() != null) {
                this.d.a(TbadkApplication.E());
                a();
                b();
            }
        } else {
            if (!this.d.h()) {
                b();
            }
            PersonChangeData M = com.baidu.tieba.p.c().M();
            if (M != null && M != null) {
                if (M != null && this.d.a() != null) {
                    this.d.a(M);
                    if (this.c != null) {
                        this.c.b(this.d);
                        if (M.getPhotoChanged()) {
                            this.c.a();
                            if (this.d.a() != null) {
                                this.d.g();
                                com.baidu.tbadk.imageManager.e.a().a(this.d.a().getPortrait());
                            }
                        }
                    }
                }
                com.baidu.tieba.p.c().a((PersonChangeData) null);
            }
            if (com.baidu.tbadk.coreExtra.messageCenter.a.a().k() != this.d.c()) {
                this.d.a(com.baidu.tbadk.coreExtra.messageCenter.a.a().k());
            }
            if (com.baidu.tbadk.coreExtra.messageCenter.a.a().n() != this.d.d()) {
                this.d.b(com.baidu.tbadk.coreExtra.messageCenter.a.a().n());
            }
            if (this.c != null) {
                this.c.c(this.d);
            }
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onDestroy() {
        if (this.d != null) {
            if (this.d.b() != null && this.d.b().length() > 0) {
                com.baidu.adp.framework.c.a().b(this.g);
            }
            this.d.i();
        }
        if (this.c != null) {
            this.c.f();
        }
        super.onDestroy();
    }
}
