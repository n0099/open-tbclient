package com.baidu.tieba.pb.pb.main;

import android.widget.AbsListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class af implements AbsListView.OnScrollListener {
    final /* synthetic */ PbActivity eiV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(PbActivity pbActivity) {
        this.eiV = pbActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        int i2;
        boolean op;
        com.baidu.tieba.pb.pb.main.a.f fVar;
        com.baidu.tbadk.performanceLog.e eVar;
        com.baidu.tbadk.performanceLog.e eVar2;
        com.baidu.tbadk.performanceLog.e eVar3;
        PbModel pbModel;
        ez ezVar;
        com.baidu.tbadk.performanceLog.e eVar4;
        ez ezVar2;
        PbModel pbModel2;
        PbModel pbModel3;
        PbModel pbModel4;
        com.baidu.tbadk.performanceLog.e eVar5;
        ez ezVar3;
        com.baidu.tieba.pb.pb.main.a.f fVar2;
        boolean op2;
        ez ezVar4;
        boolean z;
        ez ezVar5;
        ez ezVar6;
        com.baidu.tbadk.editortools.pb.c cVar;
        ez ezVar7;
        ez ezVar8;
        ez ezVar9;
        com.baidu.tbadk.editortools.pb.c cVar2;
        boolean z2 = true;
        PbActivity pbActivity = this.eiV;
        i2 = this.eiV.cBH;
        op = pbActivity.op(i2);
        if (!op) {
            op2 = this.eiV.op(i);
            if (op2) {
                ezVar4 = this.eiV.ehV;
                if (ezVar4 != null) {
                    ezVar6 = this.eiV.ehV;
                    ezVar6.axs();
                    cVar = this.eiV.eih;
                    if (cVar != null) {
                        ezVar8 = this.eiV.ehV;
                        if (!ezVar8.aNs()) {
                            ezVar9 = this.eiV.ehV;
                            cVar2 = this.eiV.eih;
                            ezVar9.gK(cVar2.Dd());
                        }
                    }
                    ezVar7 = this.eiV.ehV;
                    ezVar7.aNr();
                }
                z = this.eiV.ehH;
                if (!z) {
                    this.eiV.ehH = true;
                    ezVar5 = this.eiV.ehV;
                    ezVar5.aNZ();
                }
            }
        }
        fVar = this.eiV.ehA;
        if (fVar != null) {
            ezVar3 = this.eiV.ehV;
            if (!ezVar3.aNR()) {
                fVar2 = this.eiV.ehA;
                fVar2.onScrollStateChanged(absListView, i);
            }
        }
        eVar = this.eiV.ehI;
        if (eVar == null) {
            this.eiV.ehI = new com.baidu.tbadk.performanceLog.e();
            eVar5 = this.eiV.ehI;
            eVar5.fh(1001);
        }
        if (i == 0) {
            pbModel = this.eiV.ehh;
            if (pbModel != null) {
                pbModel2 = this.eiV.ehh;
                if (pbModel2.getPbData() != null) {
                    pbModel3 = this.eiV.ehh;
                    if (pbModel3.getPbData().aJZ() != null) {
                        pbModel4 = this.eiV.ehh;
                        if (pbModel4.getPbData().aJZ().si()) {
                            z2 = false;
                        }
                    }
                }
            }
            ezVar = this.eiV.ehV;
            if (ezVar.aNE() != null && z2) {
                ezVar2 = this.eiV.ehV;
                ezVar2.aNE().notifyDataSetChanged();
            }
            eVar4 = this.eiV.ehI;
            eVar4.Fv();
        } else if (i == 1) {
            eVar3 = this.eiV.ehI;
            eVar3.Fv();
        } else {
            eVar2 = this.eiV.ehI;
            eVar2.Fv();
        }
        this.eiV.cBH = i;
        if (i == 0) {
            this.eiV.a(false, (com.baidu.tieba.tbadkCore.data.p) null);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        PbModel pbModel;
        PbModel pbModel2;
        ez ezVar;
        ez ezVar2;
        ez ezVar3;
        com.baidu.tieba.pb.pb.main.a.f fVar;
        PbModel pbModel3;
        PbModel pbModel4;
        ez ezVar4;
        PbModel pbModel5;
        boolean z;
        com.baidu.tieba.pb.pb.main.a.f fVar2;
        pbModel = this.eiV.ehh;
        if (pbModel != null) {
            pbModel2 = this.eiV.ehh;
            if (pbModel2.getPbData() != null) {
                ezVar = this.eiV.ehV;
                if (ezVar != null) {
                    ezVar2 = this.eiV.ehV;
                    if (ezVar2.aNE() != null) {
                        ezVar3 = this.eiV.ehV;
                        ezVar3.onScroll(absListView, i, i2, i3);
                        fVar = this.eiV.ehA;
                        if (fVar != null) {
                            fVar2 = this.eiV.ehA;
                            fVar2.onScroll(absListView, i, i2, i3);
                        }
                        pbModel3 = this.eiV.ehh;
                        if (pbModel3.aMn()) {
                            pbModel4 = this.eiV.ehh;
                            ArrayList<com.baidu.tieba.tbadkCore.data.p> aKb = pbModel4.getPbData().aKb();
                            if (aKb != null && !aKb.isEmpty()) {
                                ezVar4 = this.eiV.ehV;
                                int aLz = ((i + i2) - ezVar4.aNE().aLz()) - 1;
                                pbModel5 = this.eiV.ehh;
                                com.baidu.tieba.pb.data.f pbData = pbModel5.getPbData();
                                if (pbData != null) {
                                    if (pbData.aKc() != null && pbData.aKc().hasData()) {
                                        aLz--;
                                    }
                                    if (pbData.aKd() != null && pbData.aKd().hasData()) {
                                        aLz--;
                                    }
                                    z = this.eiV.ehK;
                                    if (z) {
                                        aLz--;
                                    }
                                    int size = aKb.size();
                                    if (aLz < 0 || aLz >= size) {
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
