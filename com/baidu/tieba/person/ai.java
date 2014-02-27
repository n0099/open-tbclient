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
public final class ai extends com.baidu.tieba.j {
    private static boolean e = false;
    private static boolean f = false;
    private com.baidu.tieba.k b;
    private an c;
    private al d;
    private ak g = null;

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public final void onAttach(Activity activity) {
        super.onAttach(activity);
        this.b = (com.baidu.tieba.k) activity;
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.more_discovery_activity, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.c = new an(this.b, this);
        if (!UtilHelper.b()) {
            f = true;
        }
        this.d = new al(this.b);
        this.d.a(TiebaApplication.v());
        this.d.setLoadDataCallBack(new aj(this));
        if (TiebaApplication.v() != null && TiebaApplication.v().length() > 0) {
            this.c.e();
            a();
            DatabaseService.a((Boolean) true);
            return;
        }
        f = true;
        this.c.d();
    }

    private void a() {
        this.g = new ak(this, (byte) 0);
        com.baidu.tieba.im.messageCenter.d.a().a(-124, this.g);
    }

    private void b() {
        if (this.c != null && this.d != null) {
            this.c.a(this.d);
            this.d.a(true, true);
        }
    }

    @Override // com.baidu.tieba.j, android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (view.getId()) {
            case R.id.user_info /* 2131100943 */:
                if (f && this.d != null) {
                    if (TiebaApplication.w()) {
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
            case R.id.my_collection /* 2131100950 */:
                if (TiebaApplication.v() != null && TiebaApplication.v().length() > 0) {
                    EditMarkActivity.a(this.b, (int) SocialAPIErrorCodes.ERROR_INVALID_SESSION_KEY);
                    this.d.a(true);
                    return;
                }
                LoginActivity.a((Activity) this.b, (String) null, true, 103);
                return;
            case R.id.member_benefits /* 2131100953 */:
                com.baidu.tieba.sharedPref.b.a().b("has_shown_member_benifit", true);
                if (!TiebaApplication.w()) {
                    LoginActivity.a((Activity) this.b, (String) null, true, (int) SocialAPIErrorCodes.ERROR_INVALID_SIGNATURE);
                    return;
                }
                com.baidu.tieba.sharedPref.b.a().b("has_shown_member_benifit", true);
                TbWebViewActivity.a(this.b, getString(R.string.member_benefits), String.valueOf(com.baidu.tieba.data.i.b) + "mo/q/tbeanwireless?_client_version=" + com.baidu.tieba.data.i.u());
                return;
            case R.id.face_store /* 2131100955 */:
                TiebaApplication.g().q(TiebaApplication.g().ba());
                TiebaApplication.g().z(false);
                FaceShopActivity.a(this.b, "faceshop_from_more");
                return;
            case R.id.settings /* 2131100958 */:
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
    public final void c(int i) {
        super.c(i);
        this.c.a(i);
    }

    @Override // android.support.v4.app.Fragment
    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 11003) {
                if (TiebaApplication.v() != null) {
                    this.d.a(TiebaApplication.v());
                    this.d.b(TiebaApplication.z());
                    a();
                    b();
                }
            } else if (i == 103) {
                EditMarkActivity.a(this.b, (int) SocialAPIErrorCodes.ERROR_INVALID_SESSION_KEY);
            } else if (i == 104) {
                TbWebViewActivity.a(this.b, getString(R.string.member_benefits), String.valueOf(com.baidu.tieba.data.i.b) + "mo/q/tbeanwireless?_client_version=" + com.baidu.tieba.data.i.u());
            }
        }
    }

    public static void a(boolean z) {
        e = true;
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public final void onResume() {
        super.onResume();
        if (d()) {
            if (this.c != null) {
                an anVar = this.c;
                anVar.b();
                anVar.c();
                this.c.a(TiebaApplication.g().bb());
            }
            if (e) {
                b();
                e = false;
            } else if (this.d.b() == null || this.d.b().length() <= 0) {
                if (TiebaApplication.v() != null) {
                    this.d.a(TiebaApplication.v());
                    a();
                    b();
                }
            } else {
                if (!this.d.h()) {
                    b();
                }
                PersonChangeData bi = TiebaApplication.g().bi();
                if (bi != null && bi != null) {
                    if (bi != null && this.d.a() != null) {
                        this.d.a(bi);
                        if (this.c != null) {
                            this.c.b(this.d);
                            if (bi.getPhotoChanged()) {
                                this.c.a();
                                if (this.d.a() != null) {
                                    this.d.g();
                                    com.baidu.tbadk.imageManager.e.a().a(this.d.a().getPortrait());
                                }
                            }
                        }
                    }
                    TiebaApplication.g().a((PersonChangeData) null);
                }
                if (com.baidu.tieba.mention.v.a().m() != this.d.c()) {
                    this.d.a(com.baidu.tieba.mention.v.a().m());
                }
                if (com.baidu.tieba.mention.v.a().p() != this.d.d()) {
                    this.d.b(com.baidu.tieba.mention.v.a().p());
                }
                if (this.c != null) {
                    this.c.c(this.d);
                }
            }
        }
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public final void onDestroy() {
        if (this.d != null) {
            if (this.d.b() != null && this.d.b().length() > 0) {
                com.baidu.tieba.im.messageCenter.d.a().a(this.g);
            }
            this.d.i();
        }
        if (this.c != null) {
            this.c.f();
        }
        super.onDestroy();
    }

    public static /* synthetic */ void a(ai aiVar, com.baidu.tieba.im.message.s sVar) {
        boolean z;
        boolean z2 = true;
        if (sVar != null) {
            if (!(sVar instanceof com.baidu.tieba.im.message.v)) {
                com.baidu.adp.lib.util.e.b("transform error");
                return;
            }
            com.baidu.tieba.im.message.v vVar = (com.baidu.tieba.im.message.v) sVar;
            int c = vVar.c();
            int e2 = vVar.e();
            if (aiVar.d != null) {
                if (c != aiVar.d.c()) {
                    aiVar.d.a(c);
                    aiVar.d.b(false);
                    z = true;
                } else {
                    z = false;
                }
                if (e2 > aiVar.d.d()) {
                    aiVar.d.b(e2);
                    aiVar.d.a(false);
                } else if (e2 < aiVar.d.d()) {
                    aiVar.d.b(e2);
                    aiVar.d.a(true);
                } else {
                    z2 = z;
                }
            } else {
                z2 = false;
            }
            if (aiVar.c == null || !z2) {
                return;
            }
            aiVar.c.c(aiVar.d);
        }
    }
}
