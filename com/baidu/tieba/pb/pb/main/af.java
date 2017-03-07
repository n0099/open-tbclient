package com.baidu.tieba.pb.pb.main;

import android.widget.AbsListView;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
/* loaded from: classes.dex */
class af implements AbsListView.OnScrollListener {
    final /* synthetic */ PbActivity elO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(PbActivity pbActivity) {
        this.elO = pbActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        int i2;
        boolean od;
        fa faVar;
        com.baidu.tieba.pb.pb.main.a.f fVar;
        com.baidu.tbadk.performanceLog.e eVar;
        com.baidu.tbadk.performanceLog.e eVar2;
        com.baidu.tbadk.performanceLog.e eVar3;
        PbModel pbModel;
        fa faVar2;
        com.baidu.tbadk.performanceLog.e eVar4;
        fa faVar3;
        PbModel pbModel2;
        PbModel pbModel3;
        PbModel pbModel4;
        com.baidu.tbadk.performanceLog.e eVar5;
        com.baidu.tieba.pb.pb.main.a.f fVar2;
        boolean od2;
        fa faVar4;
        boolean z;
        fa faVar5;
        fa faVar6;
        com.baidu.tbadk.editortools.pb.c cVar;
        fa faVar7;
        fa faVar8;
        fa faVar9;
        com.baidu.tbadk.editortools.pb.c cVar2;
        boolean z2 = true;
        PbActivity pbActivity = this.elO;
        i2 = this.elO.cDd;
        od = pbActivity.od(i2);
        if (!od) {
            od2 = this.elO.od(i);
            if (od2) {
                faVar4 = this.elO.ekM;
                if (faVar4 != null) {
                    faVar6 = this.elO.ekM;
                    faVar6.awO();
                    cVar = this.elO.ekY;
                    if (cVar != null) {
                        faVar8 = this.elO.ekM;
                        if (!faVar8.aML()) {
                            faVar9 = this.elO.ekM;
                            cVar2 = this.elO.ekY;
                            faVar9.gB(cVar2.Dw());
                        }
                    }
                    faVar7 = this.elO.ekM;
                    faVar7.aMK();
                }
                z = this.elO.ekz;
                if (!z) {
                    this.elO.ekz = true;
                    faVar5 = this.elO.ekM;
                    faVar5.aNt();
                }
            }
        }
        faVar = this.elO.ekM;
        faVar.onScrollStateChanged(absListView, i);
        fVar = this.elO.eks;
        if (fVar != null) {
            fVar2 = this.elO.eks;
            fVar2.onScrollStateChanged(absListView, i);
        }
        eVar = this.elO.ekA;
        if (eVar == null) {
            this.elO.ekA = new com.baidu.tbadk.performanceLog.e();
            eVar5 = this.elO.ekA;
            eVar5.fb(1001);
        }
        if (i == 0) {
            pbModel = this.elO.ejZ;
            if (pbModel != null) {
                pbModel2 = this.elO.ejZ;
                if (pbModel2.getPbData() != null) {
                    pbModel3 = this.elO.ejZ;
                    if (pbModel3.getPbData().aJq() != null) {
                        pbModel4 = this.elO.ejZ;
                        if (pbModel4.getPbData().aJq().sD()) {
                            z2 = false;
                        }
                    }
                }
            }
            faVar2 = this.elO.ekM;
            if (faVar2.aMX() != null && z2) {
                faVar3 = this.elO.ekM;
                faVar3.aMX().notifyDataSetChanged();
            }
            eVar4 = this.elO.ekA;
            eVar4.FP();
        } else if (i == 1) {
            eVar3 = this.elO.ekA;
            eVar3.FP();
        } else {
            eVar2 = this.elO.ekA;
            eVar2.FP();
        }
        this.elO.cDd = i;
        if (i == 0) {
            this.elO.a(false, (PostData) null);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        PbModel pbModel;
        PbModel pbModel2;
        fa faVar;
        fa faVar2;
        fa faVar3;
        com.baidu.tieba.pb.pb.main.a.f fVar;
        PbModel pbModel3;
        PbModel pbModel4;
        fa faVar4;
        PbModel pbModel5;
        boolean z;
        com.baidu.tieba.pb.pb.main.a.f fVar2;
        pbModel = this.elO.ejZ;
        if (pbModel != null) {
            pbModel2 = this.elO.ejZ;
            if (pbModel2.getPbData() != null) {
                faVar = this.elO.ekM;
                if (faVar != null) {
                    faVar2 = this.elO.ekM;
                    if (faVar2.aMX() != null) {
                        faVar3 = this.elO.ekM;
                        faVar3.onScroll(absListView, i, i2, i3);
                        fVar = this.elO.eks;
                        if (fVar != null) {
                            fVar2 = this.elO.eks;
                            fVar2.onScroll(absListView, i, i2, i3);
                        }
                        pbModel3 = this.elO.ejZ;
                        if (pbModel3.aLJ()) {
                            pbModel4 = this.elO.ejZ;
                            ArrayList<PostData> aJs = pbModel4.getPbData().aJs();
                            if (aJs != null && !aJs.isEmpty()) {
                                faVar4 = this.elO.ekM;
                                int aKU = ((i + i2) - faVar4.aMX().aKU()) - 1;
                                pbModel5 = this.elO.ejZ;
                                com.baidu.tieba.pb.data.f pbData = pbModel5.getPbData();
                                if (pbData != null) {
                                    if (pbData.aJt() != null && pbData.aJt().hasData()) {
                                        aKU--;
                                    }
                                    if (pbData.aJu() != null && pbData.aJu().hasData()) {
                                        aKU--;
                                    }
                                    z = this.elO.ekC;
                                    if (z) {
                                        aKU--;
                                    }
                                    int size = aJs.size();
                                    if (aKU < 0 || aKU >= size) {
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
