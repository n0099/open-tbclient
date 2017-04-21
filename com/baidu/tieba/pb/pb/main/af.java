package com.baidu.tieba.pb.pb.main;

import android.widget.AbsListView;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
/* loaded from: classes.dex */
class af implements AbsListView.OnScrollListener {
    final /* synthetic */ PbActivity emk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(PbActivity pbActivity) {
        this.emk = pbActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        int i2;
        boolean oh;
        ey eyVar;
        com.baidu.tieba.pb.pb.main.a.f fVar;
        com.baidu.tbadk.j.e eVar;
        com.baidu.tbadk.j.e eVar2;
        com.baidu.tbadk.j.e eVar3;
        PbModel pbModel;
        ey eyVar2;
        com.baidu.tbadk.j.e eVar4;
        ey eyVar3;
        PbModel pbModel2;
        PbModel pbModel3;
        PbModel pbModel4;
        com.baidu.tbadk.j.e eVar5;
        com.baidu.tieba.pb.pb.main.a.f fVar2;
        boolean oh2;
        ey eyVar4;
        boolean z;
        ey eyVar5;
        ey eyVar6;
        com.baidu.tbadk.editortools.pb.c cVar;
        ey eyVar7;
        ey eyVar8;
        ey eyVar9;
        com.baidu.tbadk.editortools.pb.c cVar2;
        boolean z2 = true;
        PbActivity pbActivity = this.emk;
        i2 = this.emk.cDT;
        oh = pbActivity.oh(i2);
        if (!oh) {
            oh2 = this.emk.oh(i);
            if (oh2) {
                eyVar4 = this.emk.eli;
                if (eyVar4 != null) {
                    eyVar6 = this.emk.eli;
                    eyVar6.axI();
                    cVar = this.emk.elu;
                    if (cVar != null) {
                        eyVar8 = this.emk.eli;
                        if (!eyVar8.aNV()) {
                            eyVar9 = this.emk.eli;
                            cVar2 = this.emk.elu;
                            eyVar9.gL(cVar2.DU());
                        }
                    }
                    eyVar7 = this.emk.eli;
                    eyVar7.aNU();
                }
                z = this.emk.ekU;
                if (!z) {
                    this.emk.ekU = true;
                    eyVar5 = this.emk.eli;
                    eyVar5.aOD();
                }
            }
        }
        eyVar = this.emk.eli;
        eyVar.onScrollStateChanged(absListView, i);
        fVar = this.emk.ekO;
        if (fVar != null) {
            fVar2 = this.emk.ekO;
            fVar2.onScrollStateChanged(absListView, i);
        }
        eVar = this.emk.ekV;
        if (eVar == null) {
            this.emk.ekV = new com.baidu.tbadk.j.e();
            eVar5 = this.emk.ekV;
            eVar5.fe(1001);
        }
        if (i == 0) {
            pbModel = this.emk.ekv;
            if (pbModel != null) {
                pbModel2 = this.emk.ekv;
                if (pbModel2.getPbData() != null) {
                    pbModel3 = this.emk.ekv;
                    if (pbModel3.getPbData().aKy() != null) {
                        pbModel4 = this.emk.ekv;
                        if (pbModel4.getPbData().aKy().tb()) {
                            z2 = false;
                        }
                    }
                }
            }
            eyVar2 = this.emk.eli;
            if (eyVar2.aOh() != null && z2) {
                eyVar3 = this.emk.eli;
                eyVar3.aOh().notifyDataSetChanged();
            }
            eVar4 = this.emk.ekV;
            eVar4.Gn();
        } else if (i == 1) {
            eVar3 = this.emk.ekV;
            eVar3.Gn();
        } else {
            eVar2 = this.emk.ekV;
            eVar2.Gn();
        }
        this.emk.cDT = i;
        if (i == 0) {
            this.emk.a(false, (PostData) null);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        PbModel pbModel;
        PbModel pbModel2;
        ey eyVar;
        ey eyVar2;
        ey eyVar3;
        com.baidu.tieba.pb.pb.main.a.f fVar;
        PbModel pbModel3;
        PbModel pbModel4;
        ey eyVar4;
        PbModel pbModel5;
        boolean z;
        com.baidu.tieba.pb.pb.main.a.f fVar2;
        pbModel = this.emk.ekv;
        if (pbModel != null) {
            pbModel2 = this.emk.ekv;
            if (pbModel2.getPbData() != null) {
                eyVar = this.emk.eli;
                if (eyVar != null) {
                    eyVar2 = this.emk.eli;
                    if (eyVar2.aOh() != null) {
                        eyVar3 = this.emk.eli;
                        eyVar3.onScroll(absListView, i, i2, i3);
                        fVar = this.emk.ekO;
                        if (fVar != null) {
                            fVar2 = this.emk.ekO;
                            fVar2.onScroll(absListView, i, i2, i3);
                        }
                        pbModel3 = this.emk.ekv;
                        if (pbModel3.aMT()) {
                            pbModel4 = this.emk.ekv;
                            ArrayList<PostData> aKA = pbModel4.getPbData().aKA();
                            if (aKA != null && !aKA.isEmpty()) {
                                eyVar4 = this.emk.eli;
                                int aMd = ((i + i2) - eyVar4.aOh().aMd()) - 1;
                                pbModel5 = this.emk.ekv;
                                com.baidu.tieba.pb.data.f pbData = pbModel5.getPbData();
                                if (pbData != null) {
                                    if (pbData.aKB() != null && pbData.aKB().hasData()) {
                                        aMd--;
                                    }
                                    if (pbData.aKC() != null && pbData.aKC().hasData()) {
                                        aMd--;
                                    }
                                    z = this.emk.ekX;
                                    if (z) {
                                        aMd--;
                                    }
                                    int size = aKA.size();
                                    if (aMd < 0 || aMd >= size) {
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
