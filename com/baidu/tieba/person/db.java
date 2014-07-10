package com.baidu.tieba.person;

import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.view.NavigationBar;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class db extends com.baidu.adp.base.h {
    final /* synthetic */ cr a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public db(cr crVar) {
        this.a = crVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x02d1  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x02fa  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0315  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x034a  */
    @Override // com.baidu.adp.base.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Object obj) {
        ao aoVar;
        com.baidu.tieba.model.au auVar;
        az azVar;
        BaseFragmentActivity baseFragmentActivity;
        com.baidu.tieba.model.au auVar2;
        com.baidu.tieba.model.au auVar3;
        com.baidu.tieba.model.au auVar4;
        com.baidu.tieba.model.au auVar5;
        com.baidu.tieba.model.au auVar6;
        com.baidu.tieba.model.au auVar7;
        com.baidu.tieba.model.au auVar8;
        com.baidu.tieba.model.au auVar9;
        com.baidu.tieba.model.au auVar10;
        com.baidu.tieba.model.au auVar11;
        az azVar2;
        com.baidu.tieba.model.au auVar12;
        com.baidu.tieba.model.au auVar13;
        com.baidu.tieba.model.au auVar14;
        com.baidu.tieba.model.au auVar15;
        com.baidu.tieba.model.au auVar16;
        com.baidu.tieba.model.au auVar17;
        com.baidu.tieba.model.au auVar18;
        com.baidu.tieba.model.au auVar19;
        com.baidu.tieba.model.au auVar20;
        PersonCenterListTopData personCenterListTopData;
        com.baidu.tieba.model.au auVar21;
        com.baidu.tieba.model.au auVar22;
        com.baidu.tieba.model.au auVar23;
        com.baidu.tieba.model.au auVar24;
        com.baidu.tieba.model.au auVar25;
        boolean z;
        com.baidu.tieba.model.au auVar26;
        boolean z2;
        com.baidu.tieba.model.au auVar27;
        BaseFragmentActivity baseFragmentActivity2;
        com.baidu.tieba.model.au auVar28;
        com.baidu.tieba.model.au auVar29;
        com.baidu.tieba.model.au auVar30;
        com.baidu.tieba.model.au auVar31;
        com.baidu.tieba.model.au auVar32;
        com.baidu.tieba.model.au auVar33;
        com.baidu.tieba.model.au auVar34;
        com.baidu.tieba.model.au auVar35;
        com.baidu.tieba.model.au auVar36;
        com.baidu.tieba.model.au auVar37;
        com.baidu.tieba.model.au auVar38;
        com.baidu.tieba.model.au auVar39;
        com.baidu.tieba.model.au auVar40;
        com.baidu.tieba.model.au auVar41;
        com.baidu.tieba.model.au auVar42;
        com.baidu.tieba.model.au auVar43;
        com.baidu.tieba.model.au auVar44;
        com.baidu.tieba.model.au auVar45;
        com.baidu.tieba.model.au auVar46;
        com.baidu.tieba.model.au auVar47;
        boolean z3;
        com.baidu.tieba.model.c cVar;
        az azVar3;
        com.baidu.tieba.model.au auVar48;
        com.baidu.tieba.model.au auVar49;
        az azVar4;
        com.baidu.tieba.model.au auVar50;
        com.baidu.tieba.model.au auVar51;
        com.baidu.tieba.model.au auVar52;
        com.baidu.tieba.model.au auVar53;
        az azVar5;
        BaseFragmentActivity baseFragmentActivity3;
        com.baidu.tieba.model.au auVar54;
        BaseFragmentActivity baseFragmentActivity4;
        BaseFragmentActivity baseFragmentActivity5;
        ao aoVar2;
        String str = null;
        boolean z4 = false;
        aoVar = this.a.o;
        if (aoVar != null) {
            aoVar2 = this.a.o;
            aoVar2.d();
        }
        auVar = this.a.e;
        if (auVar.getLoadDataMode() != 1) {
            auVar52 = this.a.e;
            if (auVar52.getLoadDataMode() != 2) {
                auVar53 = this.a.e;
                if (auVar53.getLoadDataMode() == 3) {
                    azVar5 = this.a.l;
                    if (azVar5 != null) {
                        if (((Boolean) obj).booleanValue()) {
                            baseFragmentActivity4 = this.a.h;
                            baseFragmentActivity5 = this.a.h;
                            baseFragmentActivity4.a(baseFragmentActivity5.getResources().getString(com.baidu.tieba.y.success));
                            this.a.h();
                            return;
                        }
                        baseFragmentActivity3 = this.a.h;
                        auVar54 = this.a.e;
                        baseFragmentActivity3.a(auVar54.getErrorString());
                        return;
                    }
                    return;
                }
                return;
            }
        }
        if (((Boolean) obj).booleanValue()) {
            auVar3 = this.a.e;
            if (!auVar3.i()) {
                auVar47 = this.a.e;
                if (auVar47.j() != null) {
                    auVar51 = this.a.e;
                    z3 = auVar51.j().isMask();
                } else {
                    z3 = false;
                }
                cVar = this.a.f;
                cVar.a(z3 ? 1 : 0);
                azVar3 = this.a.l;
                if (azVar3.getNavigationBar() != null) {
                    auVar48 = this.a.e;
                    if (auVar48 != null) {
                        auVar49 = this.a.e;
                        if (auVar49.j() != null) {
                            azVar4 = this.a.l;
                            NavigationBar navigationBar = azVar4.getNavigationBar();
                            auVar50 = this.a.e;
                            navigationBar.a(auVar50.j().getName_show());
                        }
                    }
                }
            } else {
                auVar4 = this.a.e;
                if (auVar4.j() != null) {
                    auVar5 = this.a.e;
                    if (auVar5.j().getPersonPrivate() != null) {
                        auVar6 = this.a.e;
                        com.baidu.tbadk.core.account.o.a(1, auVar6.j().getPersonPrivate().a());
                        auVar7 = this.a.e;
                        com.baidu.tbadk.core.account.o.a(2, auVar7.j().getPersonPrivate().b());
                        auVar8 = this.a.e;
                        com.baidu.tbadk.core.account.o.a(3, auVar8.j().getPersonPrivate().c());
                        auVar9 = this.a.e;
                        com.baidu.tbadk.core.account.o.a(5, auVar9.j().getPersonPrivate().e());
                        auVar10 = this.a.e;
                        com.baidu.tbadk.core.account.o.a(4, auVar10.j().getPersonPrivate().d());
                    }
                }
            }
            auVar11 = this.a.e;
            if (!auVar11.i()) {
                auVar13 = this.a.e;
                if (auVar13.a() != null) {
                    auVar14 = this.a.e;
                    int g = auVar14.a().g();
                    auVar15 = this.a.e;
                    if (auVar15.b() != null) {
                        auVar16 = this.a.e;
                        if (auVar16.b().post_list == null) {
                            auVar19 = this.a.e;
                            auVar19.b().post_list = new ArrayList();
                            auVar20 = this.a.e;
                            auVar20.a(0);
                        } else {
                            auVar17 = this.a.e;
                            if (auVar17.b().post_list.size() == 0) {
                                auVar18 = this.a.e;
                                auVar18.a(0);
                            }
                        }
                    } else {
                        PersonPostListData personPostListData = new PersonPostListData();
                        auVar45 = this.a.e;
                        auVar45.a(personPostListData);
                        auVar46 = this.a.e;
                        auVar46.a(0);
                    }
                    if (g == 1) {
                        auVar40 = this.a.e;
                        PersonCenterListTopData personCenterListTopData2 = new PersonCenterListTopData(auVar40, 2);
                        auVar41 = this.a.e;
                        if (auVar41.b().post_list.size() != 0) {
                            auVar43 = this.a.e;
                            if (auVar43.b().post_list.get(0) instanceof PersonCenterListTopData) {
                                auVar44 = this.a.e;
                                auVar44.b().post_list.remove(0);
                            }
                        }
                        auVar42 = this.a.e;
                        auVar42.b().post_list.add(0, personCenterListTopData2);
                    } else {
                        if (g == 0) {
                            auVar39 = this.a.e;
                            personCenterListTopData = new PersonCenterListTopData(auVar39, 1);
                        } else if (g == 2) {
                            auVar21 = this.a.e;
                            personCenterListTopData = new PersonCenterListTopData(auVar21, 3);
                        } else {
                            personCenterListTopData = null;
                        }
                        auVar22 = this.a.e;
                        if (auVar22.b().post_list.size() != 0) {
                            auVar37 = this.a.e;
                            if (auVar37.b().post_list.get(0) instanceof PersonCenterListTopData) {
                                auVar38 = this.a.e;
                                auVar38.b().post_list.remove(0);
                            }
                        }
                        auVar23 = this.a.e;
                        auVar23.b().post_list.add(0, personCenterListTopData);
                        auVar24 = this.a.e;
                        if (auVar24.a().d() != null) {
                            auVar36 = this.a.e;
                            str = auVar36.a().d().a();
                        }
                        auVar25 = this.a.e;
                        if (auVar25.a().a() != null) {
                            auVar35 = this.a.e;
                            if (auVar35.a().a().size() != 0) {
                                z = true;
                                Boolean valueOf = Boolean.valueOf(z);
                                auVar26 = this.a.e;
                                if (auVar26.a().c() != null) {
                                    auVar34 = this.a.e;
                                    if (auVar34.a().c().size() != 0) {
                                        z2 = true;
                                        Boolean valueOf2 = Boolean.valueOf(z2);
                                        auVar27 = this.a.e;
                                        if (auVar27.a().b() != null) {
                                            auVar33 = this.a.e;
                                            if (auVar33.a().b().size() != 0) {
                                                z4 = true;
                                            }
                                        }
                                        Boolean valueOf3 = Boolean.valueOf(z4);
                                        if (str == null || valueOf.booleanValue() || valueOf2.booleanValue() || valueOf3.booleanValue()) {
                                            baseFragmentActivity2 = this.a.h;
                                            auVar28 = this.a.e;
                                            PersonRelationCardData personRelationCardData = new PersonRelationCardData(baseFragmentActivity2, auVar28);
                                            auVar29 = this.a.e;
                                            if (auVar29.b().post_list.size() > 1) {
                                                auVar31 = this.a.e;
                                                if (auVar31.b().post_list.get(1) instanceof PersonRelationCardData) {
                                                    auVar32 = this.a.e;
                                                    auVar32.b().post_list.remove(1);
                                                }
                                            }
                                            auVar30 = this.a.e;
                                            auVar30.b().post_list.add(1, personRelationCardData);
                                        }
                                    }
                                }
                                z2 = false;
                                Boolean valueOf22 = Boolean.valueOf(z2);
                                auVar27 = this.a.e;
                                if (auVar27.a().b() != null) {
                                }
                                Boolean valueOf32 = Boolean.valueOf(z4);
                                if (str == null) {
                                }
                                baseFragmentActivity2 = this.a.h;
                                auVar28 = this.a.e;
                                PersonRelationCardData personRelationCardData2 = new PersonRelationCardData(baseFragmentActivity2, auVar28);
                                auVar29 = this.a.e;
                                if (auVar29.b().post_list.size() > 1) {
                                }
                                auVar30 = this.a.e;
                                auVar30.b().post_list.add(1, personRelationCardData2);
                            }
                        }
                        z = false;
                        Boolean valueOf4 = Boolean.valueOf(z);
                        auVar26 = this.a.e;
                        if (auVar26.a().c() != null) {
                        }
                        z2 = false;
                        Boolean valueOf222 = Boolean.valueOf(z2);
                        auVar27 = this.a.e;
                        if (auVar27.a().b() != null) {
                        }
                        Boolean valueOf322 = Boolean.valueOf(z4);
                        if (str == null) {
                        }
                        baseFragmentActivity2 = this.a.h;
                        auVar28 = this.a.e;
                        PersonRelationCardData personRelationCardData22 = new PersonRelationCardData(baseFragmentActivity2, auVar28);
                        auVar29 = this.a.e;
                        if (auVar29.b().post_list.size() > 1) {
                        }
                        auVar30 = this.a.e;
                        auVar30.b().post_list.add(1, personRelationCardData22);
                    }
                }
            }
            this.a.k();
            azVar2 = this.a.l;
            auVar12 = this.a.e;
            azVar2.a(auVar12);
            return;
        }
        azVar = this.a.l;
        azVar.f();
        baseFragmentActivity = this.a.h;
        auVar2 = this.a.e;
        baseFragmentActivity.a(auVar2.getErrorString());
    }
}
