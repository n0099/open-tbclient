package com.baidu.tieba.person;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.browser.TbWebViewActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
import com.baidu.tieba.data.PersonChangeData;
import com.baidu.tieba.more.MoreActivity;
/* loaded from: classes.dex */
public class m extends com.baidu.tbadk.core.d {
    private static boolean e = false;
    private static boolean f = false;
    private BaseFragmentActivity b;
    private q c;
    private o d;
    private final CustomMessageListener g;

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.b = (BaseFragmentActivity) activity;
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return a(layoutInflater);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        a();
        f();
        if (TbadkApplication.getCurrentAccount() != null && TbadkApplication.getCurrentAccount().length() > 0) {
            this.c.f();
            g();
            com.baidu.tieba.util.k.b((Boolean) true);
            return;
        }
        f = true;
        this.c.e();
    }

    public View a(LayoutInflater layoutInflater) {
        return layoutInflater.inflate(com.baidu.tieba.v.more_discovery_activity, (ViewGroup) null);
    }

    public void a() {
        this.c = new q(this.b, this);
    }

    public void f() {
        if (!UtilHelper.isNetOk()) {
            f = true;
        }
        this.d = new o(this.b);
        this.d.a(TbadkApplication.getCurrentAccount());
        this.d.setLoadDataCallBack(new n(this));
    }

    private void g() {
        MessageManager.getInstance().registerListener(this.g);
    }

    private void h() {
        MessageManager.getInstance().unRegisterListener(this.g);
    }

    private void i() {
        if (this.c != null && this.d != null) {
            this.c.a(this.d);
            this.d.a(true, true);
        }
    }

    @Override // com.baidu.tbadk.core.d, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == com.baidu.tieba.u.user_info) {
            if (f && this.d != null) {
                if (TbadkApplication.isLogin()) {
                    UserData a = this.d.a();
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new com.baidu.tbadk.core.atomData.bg(this.b, this.d.b(), a != null ? a.getName_show() : "")));
                    this.d.b(true);
                    return;
                }
                LoginActivity.a((Activity) this.b, (String) null, true, 11003);
                this.d.b(true);
            }
        } else if (id == com.baidu.tieba.u.my_collection) {
            if (TbadkApplication.getCurrentAccount() != null && TbadkApplication.getCurrentAccount().length() > 0) {
                a(new CustomMessage(2015005, new com.baidu.tbadk.core.frameworkData.a(this.b)));
                this.d.a(true);
                return;
            }
            LoginActivity.a((Activity) this.b, (String) null, true, 103);
        } else if (id == com.baidu.tieba.u.member_benefits) {
            com.baidu.tbadk.core.sharedPref.b.a().b("has_shown_member_benifit", true);
            if (!TbadkApplication.isLogin()) {
                LoginActivity.a((Activity) this.b, (String) null, true, 104);
                return;
            }
            com.baidu.tbadk.core.sharedPref.b.a().b("has_shown_member_benifit", true);
            TbWebViewActivity.startActivityWithCookie(this.b, getString(com.baidu.tieba.x.member_benefits), String.valueOf(com.baidu.tieba.data.e.a) + "mo/q/tbeanmall?_client_version=" + TbConfig.getVersion());
        } else if (id == com.baidu.tieba.u.face_store) {
            TbadkApplication.m252getInst().setFaceShopVersion(TbadkApplication.m252getInst().getTempFaceShopVersion());
            TbadkApplication.m252getInst().setFaceShopNew(false);
            a(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.p(this.b, "faceshop_from_more")));
        } else if (id == com.baidu.tieba.u.settings && this.d != null) {
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
    public void c(int i) {
        super.c(i);
        this.c.a(i);
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 11003) {
                if (TbadkApplication.getCurrentAccount() != null) {
                    this.d.a(TbadkApplication.getCurrentAccount());
                    this.d.b(TbadkApplication.getCurrentAccountName());
                    g();
                    i();
                }
            } else if (i == 103) {
                a(new CustomMessage(2015005, new com.baidu.tbadk.core.frameworkData.a(this.b)));
            } else if (i == 104) {
                TbWebViewActivity.startActivityWithCookie(this.b, getString(com.baidu.tieba.x.member_benefits), String.valueOf(com.baidu.tieba.data.e.a) + "mo/q/tbeanmall?_client_version=" + TbConfig.getVersion());
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
                            com.baidu.tbadk.imageManager.e.a().a(this.d.a().getPortrait());
                        }
                    }
                }
            }
            com.baidu.tieba.ai.c().a((PersonChangeData) null);
        }
    }

    public static void a(boolean z) {
        e = z;
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.c != null) {
            this.c.b();
            this.c.a(TbadkApplication.m252getInst().isFaceShopNew());
        }
        if (e) {
            i();
            e = false;
        } else if (this.d.b() == null || this.d.b().length() <= 0) {
            if (TbadkApplication.getCurrentAccount() != null) {
                this.d.a(TbadkApplication.getCurrentAccount());
                g();
                i();
            }
        } else {
            if (!this.d.e()) {
                i();
            }
            PersonChangeData N = com.baidu.tieba.ai.c().N();
            if (N != null) {
                a(N);
            }
            if (com.baidu.tbadk.coreExtra.messageCenter.a.a().r() != this.d.c()) {
                this.d.a(com.baidu.tbadk.coreExtra.messageCenter.a.a().r());
            }
            if (this.c != null) {
                this.c.c(this.d);
            }
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.d != null) {
            if (this.d.b() != null && this.d.b().length() > 0) {
                h();
            }
            this.d.f();
        }
        if (this.c != null) {
            this.c.g();
        }
        super.onDestroy();
    }
}
