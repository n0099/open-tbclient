package com.baidu.tieba.person;

import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.view.NavigationBar;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cw extends com.baidu.adp.base.h {
    final /* synthetic */ ct a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cw(ct ctVar) {
        this.a = ctVar;
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
        an anVar;
        com.baidu.tieba.model.av avVar;
        bd bdVar;
        BaseFragmentActivity baseFragmentActivity;
        com.baidu.tieba.model.av avVar2;
        com.baidu.tieba.model.av avVar3;
        com.baidu.tieba.model.av avVar4;
        com.baidu.tieba.model.av avVar5;
        com.baidu.tieba.model.av avVar6;
        com.baidu.tieba.model.av avVar7;
        com.baidu.tieba.model.av avVar8;
        com.baidu.tieba.model.av avVar9;
        com.baidu.tieba.model.av avVar10;
        com.baidu.tieba.model.av avVar11;
        bd bdVar2;
        com.baidu.tieba.model.av avVar12;
        com.baidu.tieba.model.av avVar13;
        com.baidu.tieba.model.av avVar14;
        com.baidu.tieba.model.av avVar15;
        com.baidu.tieba.model.av avVar16;
        com.baidu.tieba.model.av avVar17;
        com.baidu.tieba.model.av avVar18;
        com.baidu.tieba.model.av avVar19;
        com.baidu.tieba.model.av avVar20;
        PersonCenterListTopData personCenterListTopData;
        com.baidu.tieba.model.av avVar21;
        com.baidu.tieba.model.av avVar22;
        com.baidu.tieba.model.av avVar23;
        com.baidu.tieba.model.av avVar24;
        com.baidu.tieba.model.av avVar25;
        boolean z;
        com.baidu.tieba.model.av avVar26;
        boolean z2;
        com.baidu.tieba.model.av avVar27;
        BaseFragmentActivity baseFragmentActivity2;
        com.baidu.tieba.model.av avVar28;
        com.baidu.tieba.model.av avVar29;
        com.baidu.tieba.model.av avVar30;
        com.baidu.tieba.model.av avVar31;
        com.baidu.tieba.model.av avVar32;
        com.baidu.tieba.model.av avVar33;
        com.baidu.tieba.model.av avVar34;
        com.baidu.tieba.model.av avVar35;
        com.baidu.tieba.model.av avVar36;
        com.baidu.tieba.model.av avVar37;
        com.baidu.tieba.model.av avVar38;
        com.baidu.tieba.model.av avVar39;
        com.baidu.tieba.model.av avVar40;
        com.baidu.tieba.model.av avVar41;
        com.baidu.tieba.model.av avVar42;
        com.baidu.tieba.model.av avVar43;
        com.baidu.tieba.model.av avVar44;
        com.baidu.tieba.model.av avVar45;
        com.baidu.tieba.model.av avVar46;
        com.baidu.tieba.model.av avVar47;
        boolean z3;
        com.baidu.tieba.model.d dVar;
        bd bdVar3;
        com.baidu.tieba.model.av avVar48;
        com.baidu.tieba.model.av avVar49;
        bd bdVar4;
        com.baidu.tieba.model.av avVar50;
        com.baidu.tieba.model.av avVar51;
        com.baidu.tieba.model.av avVar52;
        com.baidu.tieba.model.av avVar53;
        bd bdVar5;
        BaseFragmentActivity baseFragmentActivity3;
        com.baidu.tieba.model.av avVar54;
        com.baidu.tieba.model.av avVar55;
        BaseFragmentActivity baseFragmentActivity4;
        com.baidu.tieba.model.av avVar56;
        com.baidu.tieba.model.av avVar57;
        BaseFragmentActivity baseFragmentActivity5;
        BaseFragmentActivity baseFragmentActivity6;
        BaseFragmentActivity baseFragmentActivity7;
        BaseFragmentActivity baseFragmentActivity8;
        an anVar2;
        String str = null;
        boolean z4 = false;
        anVar = this.a.o;
        if (anVar != null) {
            anVar2 = this.a.o;
            anVar2.f();
        }
        avVar = this.a.e;
        if (avVar.getLoadDataMode() != 1) {
            avVar52 = this.a.e;
            if (avVar52.getLoadDataMode() != 2) {
                avVar53 = this.a.e;
                if (avVar53.getLoadDataMode() == 3) {
                    bdVar5 = this.a.l;
                    if (bdVar5 != null) {
                        if (((Boolean) obj).booleanValue()) {
                            avVar55 = this.a.e;
                            if (avVar55 != null) {
                                avVar56 = this.a.e;
                                if (avVar56.k() != null) {
                                    avVar57 = this.a.e;
                                    if (avVar57.k().getHave_attention() == 1) {
                                        baseFragmentActivity6 = this.a.h;
                                        baseFragmentActivity7 = this.a.h;
                                        StringBuilder sb = new StringBuilder(String.valueOf(baseFragmentActivity7.getResources().getString(com.baidu.tieba.x.attention_cancel)));
                                        baseFragmentActivity8 = this.a.h;
                                        baseFragmentActivity6.a(sb.append(baseFragmentActivity8.getResources().getString(com.baidu.tieba.x.success)).toString());
                                    } else {
                                        baseFragmentActivity5 = this.a.h;
                                        baseFragmentActivity5.c(com.baidu.tieba.x.attention_success);
                                    }
                                    this.a.i();
                                    return;
                                }
                            }
                            baseFragmentActivity4 = this.a.h;
                            baseFragmentActivity4.c(com.baidu.tieba.x.success);
                            this.a.i();
                            return;
                        }
                        baseFragmentActivity3 = this.a.h;
                        avVar54 = this.a.e;
                        baseFragmentActivity3.a(avVar54.getErrorString());
                        return;
                    }
                    return;
                }
                return;
            }
        }
        if (((Boolean) obj).booleanValue()) {
            avVar3 = this.a.e;
            if (!avVar3.j()) {
                avVar47 = this.a.e;
                if (avVar47.k() != null) {
                    avVar51 = this.a.e;
                    z3 = avVar51.k().isMask();
                } else {
                    z3 = false;
                }
                dVar = this.a.f;
                dVar.a(z3 ? 1 : 0);
                bdVar3 = this.a.l;
                if (bdVar3.getNavigationBar() != null) {
                    avVar48 = this.a.e;
                    if (avVar48 != null) {
                        avVar49 = this.a.e;
                        if (avVar49.k() != null) {
                            bdVar4 = this.a.l;
                            NavigationBar navigationBar = bdVar4.getNavigationBar();
                            avVar50 = this.a.e;
                            navigationBar.a(avVar50.k().getName_show());
                        }
                    }
                }
            } else {
                avVar4 = this.a.e;
                if (avVar4.k() != null) {
                    avVar5 = this.a.e;
                    if (avVar5.k().getPersonPrivate() != null) {
                        avVar6 = this.a.e;
                        com.baidu.tbadk.core.account.o.a(1, avVar6.k().getPersonPrivate().a());
                        avVar7 = this.a.e;
                        com.baidu.tbadk.core.account.o.a(2, avVar7.k().getPersonPrivate().b());
                        avVar8 = this.a.e;
                        com.baidu.tbadk.core.account.o.a(3, avVar8.k().getPersonPrivate().c());
                        avVar9 = this.a.e;
                        com.baidu.tbadk.core.account.o.a(5, avVar9.k().getPersonPrivate().e());
                        avVar10 = this.a.e;
                        com.baidu.tbadk.core.account.o.a(4, avVar10.k().getPersonPrivate().d());
                    }
                }
            }
            avVar11 = this.a.e;
            if (!avVar11.j()) {
                avVar13 = this.a.e;
                if (avVar13.a() != null) {
                    avVar14 = this.a.e;
                    int g = avVar14.a().g();
                    avVar15 = this.a.e;
                    if (avVar15.b() != null) {
                        avVar16 = this.a.e;
                        if (avVar16.b().post_list == null) {
                            avVar19 = this.a.e;
                            avVar19.b().post_list = new ArrayList();
                            avVar20 = this.a.e;
                            avVar20.a(0);
                        } else {
                            avVar17 = this.a.e;
                            if (avVar17.b().post_list.size() == 0) {
                                avVar18 = this.a.e;
                                avVar18.a(0);
                            }
                        }
                    } else {
                        PersonPostListData personPostListData = new PersonPostListData();
                        avVar45 = this.a.e;
                        avVar45.a(personPostListData);
                        avVar46 = this.a.e;
                        avVar46.a(0);
                    }
                    if (g == 1) {
                        avVar40 = this.a.e;
                        PersonCenterListTopData personCenterListTopData2 = new PersonCenterListTopData(avVar40, 2);
                        avVar41 = this.a.e;
                        if (avVar41.b().post_list.size() != 0) {
                            avVar43 = this.a.e;
                            if (avVar43.b().post_list.get(0) instanceof PersonCenterListTopData) {
                                avVar44 = this.a.e;
                                avVar44.b().post_list.remove(0);
                            }
                        }
                        avVar42 = this.a.e;
                        avVar42.b().post_list.add(0, personCenterListTopData2);
                    } else {
                        if (g == 0) {
                            avVar39 = this.a.e;
                            personCenterListTopData = new PersonCenterListTopData(avVar39, 1);
                        } else if (g == 2) {
                            avVar21 = this.a.e;
                            personCenterListTopData = new PersonCenterListTopData(avVar21, 3);
                        } else {
                            personCenterListTopData = null;
                        }
                        avVar22 = this.a.e;
                        if (avVar22.b().post_list.size() != 0) {
                            avVar37 = this.a.e;
                            if (avVar37.b().post_list.get(0) instanceof PersonCenterListTopData) {
                                avVar38 = this.a.e;
                                avVar38.b().post_list.remove(0);
                            }
                        }
                        avVar23 = this.a.e;
                        avVar23.b().post_list.add(0, personCenterListTopData);
                        avVar24 = this.a.e;
                        if (avVar24.a().d() != null) {
                            avVar36 = this.a.e;
                            str = avVar36.a().d().a();
                        }
                        avVar25 = this.a.e;
                        if (avVar25.a().a() != null) {
                            avVar35 = this.a.e;
                            if (avVar35.a().a().size() != 0) {
                                z = true;
                                Boolean valueOf = Boolean.valueOf(z);
                                avVar26 = this.a.e;
                                if (avVar26.a().c() != null) {
                                    avVar34 = this.a.e;
                                    if (avVar34.a().c().size() != 0) {
                                        z2 = true;
                                        Boolean valueOf2 = Boolean.valueOf(z2);
                                        avVar27 = this.a.e;
                                        if (avVar27.a().b() != null) {
                                            avVar33 = this.a.e;
                                            if (avVar33.a().b().size() != 0) {
                                                z4 = true;
                                            }
                                        }
                                        Boolean valueOf3 = Boolean.valueOf(z4);
                                        if (str == null || valueOf.booleanValue() || valueOf2.booleanValue() || valueOf3.booleanValue()) {
                                            baseFragmentActivity2 = this.a.h;
                                            avVar28 = this.a.e;
                                            PersonRelationCardData personRelationCardData = new PersonRelationCardData(baseFragmentActivity2, avVar28);
                                            avVar29 = this.a.e;
                                            if (avVar29.b().post_list.size() > 1) {
                                                avVar31 = this.a.e;
                                                if (avVar31.b().post_list.get(1) instanceof PersonRelationCardData) {
                                                    avVar32 = this.a.e;
                                                    avVar32.b().post_list.remove(1);
                                                }
                                            }
                                            avVar30 = this.a.e;
                                            avVar30.b().post_list.add(1, personRelationCardData);
                                        }
                                    }
                                }
                                z2 = false;
                                Boolean valueOf22 = Boolean.valueOf(z2);
                                avVar27 = this.a.e;
                                if (avVar27.a().b() != null) {
                                }
                                Boolean valueOf32 = Boolean.valueOf(z4);
                                if (str == null) {
                                }
                                baseFragmentActivity2 = this.a.h;
                                avVar28 = this.a.e;
                                PersonRelationCardData personRelationCardData2 = new PersonRelationCardData(baseFragmentActivity2, avVar28);
                                avVar29 = this.a.e;
                                if (avVar29.b().post_list.size() > 1) {
                                }
                                avVar30 = this.a.e;
                                avVar30.b().post_list.add(1, personRelationCardData2);
                            }
                        }
                        z = false;
                        Boolean valueOf4 = Boolean.valueOf(z);
                        avVar26 = this.a.e;
                        if (avVar26.a().c() != null) {
                        }
                        z2 = false;
                        Boolean valueOf222 = Boolean.valueOf(z2);
                        avVar27 = this.a.e;
                        if (avVar27.a().b() != null) {
                        }
                        Boolean valueOf322 = Boolean.valueOf(z4);
                        if (str == null) {
                        }
                        baseFragmentActivity2 = this.a.h;
                        avVar28 = this.a.e;
                        PersonRelationCardData personRelationCardData22 = new PersonRelationCardData(baseFragmentActivity2, avVar28);
                        avVar29 = this.a.e;
                        if (avVar29.b().post_list.size() > 1) {
                        }
                        avVar30 = this.a.e;
                        avVar30.b().post_list.add(1, personRelationCardData22);
                    }
                }
            }
            this.a.n();
            bdVar2 = this.a.l;
            avVar12 = this.a.e;
            bdVar2.a(avVar12);
            return;
        }
        bdVar = this.a.l;
        bdVar.e();
        baseFragmentActivity = this.a.h;
        avVar2 = this.a.e;
        baseFragmentActivity.a(avVar2.getErrorString());
    }
}
