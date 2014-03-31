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
    private static boolean d = false;
    private static boolean e = false;
    private com.baidu.tbadk.core.e a;
    private v b;
    private t c;
    private final com.baidu.adp.framework.c.a f;

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onAttach(Activity activity) {
        super.onAttach(activity);
        this.a = (com.baidu.tbadk.core.e) activity;
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
        this.b = new v(this.a, this);
        if (!UtilHelper.a()) {
            e = true;
        }
        this.c = new t(this.a);
        this.c.a(TbadkApplication.E());
        this.c.setLoadDataCallBack(new s(this));
        if (TbadkApplication.E() != null && TbadkApplication.E().length() > 0) {
            this.b.e();
            a();
            com.baidu.tieba.util.k.a((Boolean) true);
            return;
        }
        e = true;
        this.b.d();
    }

    private void a() {
        com.baidu.adp.framework.c.a().a(this.f);
    }

    private void b() {
        if (this.b != null && this.c != null) {
            this.b.a(this.c);
            this.c.a(true, true);
        }
    }

    @Override // com.baidu.tbadk.core.d, android.view.View.OnClickListener
    public final void onClick(View view) {
        int id = view.getId();
        if (id == com.baidu.tieba.a.h.user_info) {
            if (e && this.c != null) {
                if (TbadkApplication.F()) {
                    UserData a = this.c.a();
                    com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001003, new com.baidu.tbadk.core.b.ag(this.a, this.c.b(), a != null ? a.getName_show() : "")));
                    this.c.b(true);
                    return;
                }
                LoginActivity.a((Activity) this.a, (String) null, true, 11003);
                this.c.b(true);
            }
        } else if (id == com.baidu.tieba.a.h.my_collection) {
            if (TbadkApplication.E() != null && TbadkApplication.E().length() > 0) {
                sendMessage(new com.baidu.adp.framework.message.a(2015005, new com.baidu.tbadk.core.frameworkData.a(this.a)));
                this.c.a(true);
                return;
            }
            LoginActivity.a((Activity) this.a, (String) null, true, (int) PersonInfoActivity.REQUSET_MY_BAR);
        } else if (id == com.baidu.tieba.a.h.member_benefits) {
            com.baidu.tbadk.core.sharedPref.b.a().b("has_shown_member_benifit", true);
            if (!TbadkApplication.F()) {
                LoginActivity.a((Activity) this.a, (String) null, true, (int) PersonInfoActivity.REQUSET_MY_MENTION);
                return;
            }
            com.baidu.tbadk.core.sharedPref.b.a().b("has_shown_member_benifit", true);
            TbWebViewActivity.a(this.a, getString(com.baidu.tieba.a.k.member_benefits), String.valueOf(com.baidu.tieba.data.d.a) + "mo/q/tbeanmall?_client_version=" + com.baidu.tbadk.core.data.n.c());
        } else if (id == com.baidu.tieba.a.h.face_store) {
            TbadkApplication.j().g(TbadkApplication.j().at());
            TbadkApplication.j().f(false);
            sendMessage(new com.baidu.adp.framework.message.a(2001001, new com.baidu.tbadk.core.b.j(this.a, "faceshop_from_more")));
        } else if (id == com.baidu.tieba.a.h.settings && this.c != null) {
            PersonChangeData personChangeData = new PersonChangeData();
            if (this.c.a() != null) {
                personChangeData.setName(this.c.a().getName_show());
                personChangeData.setIntro(this.c.a().getIntro());
                personChangeData.setPortrait(this.c.a().getPortrait());
                personChangeData.setSex(this.c.a().getSex());
            }
            MoreActivity.a(this.a, PersonInfoActivity.REQUSET_CHANGE, personChangeData);
        }
    }

    @Override // com.baidu.tbadk.core.d
    public final void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.b.a(i);
    }

    @Override // android.support.v4.app.Fragment
    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 11003) {
                if (TbadkApplication.E() != null) {
                    this.c.a(TbadkApplication.E());
                    this.c.b(TbadkApplication.O());
                    a();
                    b();
                }
            } else if (i == 103) {
                sendMessage(new com.baidu.adp.framework.message.a(2015005, new com.baidu.tbadk.core.frameworkData.a(this.a)));
            } else if (i == 104) {
                TbWebViewActivity.a(this.a, getString(com.baidu.tieba.a.k.member_benefits), String.valueOf(com.baidu.tieba.data.d.a) + "mo/q/tbeanmall?_client_version=" + com.baidu.tbadk.core.data.n.c());
            }
        }
    }

    public static void a(boolean z) {
        d = true;
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onResume() {
        super.onResume();
        if (this.b != null) {
            v vVar = this.b;
            vVar.b();
            vVar.c();
            this.b.a(TbadkApplication.j().ac());
        }
        if (d) {
            b();
            d = false;
        } else if (this.c.b() == null || this.c.b().length() <= 0) {
            if (TbadkApplication.E() != null) {
                this.c.a(TbadkApplication.E());
                a();
                b();
            }
        } else {
            if (!this.c.h()) {
                b();
            }
            PersonChangeData Q = com.baidu.tieba.r.c().Q();
            if (Q != null && Q != null) {
                if (Q != null && this.c.a() != null) {
                    this.c.a(Q);
                    if (this.b != null) {
                        this.b.b(this.c);
                        if (Q.getPhotoChanged()) {
                            this.b.a();
                            if (this.c.a() != null) {
                                this.c.g();
                                com.baidu.tbadk.imageManager.e.a().a(this.c.a().getPortrait());
                            }
                        }
                    }
                }
                com.baidu.tieba.r.c().a((PersonChangeData) null);
            }
            if (com.baidu.tbadk.coreExtra.messageCenter.a.a().k() != this.c.c()) {
                this.c.a(com.baidu.tbadk.coreExtra.messageCenter.a.a().k());
            }
            if (com.baidu.tbadk.coreExtra.messageCenter.a.a().n() != this.c.d()) {
                this.c.b(com.baidu.tbadk.coreExtra.messageCenter.a.a().n());
            }
            if (this.b != null) {
                this.b.c(this.c);
            }
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onDestroy() {
        if (this.c != null) {
            if (this.c.b() != null && this.c.b().length() > 0) {
                com.baidu.adp.framework.c.a().b(this.f);
            }
            this.c.i();
        }
        if (this.b != null) {
            this.b.f();
        }
        super.onDestroy();
    }
}
