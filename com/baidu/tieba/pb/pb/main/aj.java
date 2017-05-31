package com.baidu.tieba.pb.pb.main;

import android.widget.AbsListView;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
/* loaded from: classes.dex */
class aj implements AbsListView.OnScrollListener {
    final /* synthetic */ PbActivity enc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(PbActivity pbActivity) {
        this.enc = pbActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        int i2;
        boolean oq;
        fx fxVar;
        com.baidu.tieba.pb.pb.main.a.f fVar;
        com.baidu.tbadk.j.e eVar;
        com.baidu.tbadk.j.e eVar2;
        com.baidu.tbadk.j.e eVar3;
        PbModel pbModel;
        fx fxVar2;
        com.baidu.tbadk.j.e eVar4;
        fx fxVar3;
        PbModel pbModel2;
        PbModel pbModel3;
        PbModel pbModel4;
        com.baidu.tbadk.j.e eVar5;
        com.baidu.tieba.pb.pb.main.a.f fVar2;
        boolean oq2;
        fx fxVar4;
        boolean z;
        fx fxVar5;
        fx fxVar6;
        com.baidu.tbadk.editortools.pb.c cVar;
        fx fxVar7;
        fx fxVar8;
        fx fxVar9;
        com.baidu.tbadk.editortools.pb.c cVar2;
        boolean z2 = true;
        PbActivity pbActivity = this.enc;
        i2 = this.enc.mLastScrollState;
        oq = pbActivity.oq(i2);
        if (!oq) {
            oq2 = this.enc.oq(i);
            if (oq2) {
                fxVar4 = this.enc.elU;
                if (fxVar4 != null) {
                    fxVar6 = this.enc.elU;
                    fxVar6.avy();
                    cVar = this.enc.emh;
                    if (cVar != null) {
                        fxVar8 = this.enc.elU;
                        if (!fxVar8.aMh()) {
                            fxVar9 = this.enc.elU;
                            cVar2 = this.enc.emh;
                            fxVar9.gz(cVar2.CS());
                        }
                    }
                    fxVar7 = this.enc.elU;
                    fxVar7.aKn();
                }
                z = this.enc.elE;
                if (!z) {
                    this.enc.elE = true;
                    fxVar5 = this.enc.elU;
                    fxVar5.aMO();
                }
            }
        }
        fxVar = this.enc.elU;
        fxVar.onScrollStateChanged(absListView, i);
        fVar = this.enc.elw;
        if (fVar != null) {
            fVar2 = this.enc.elw;
            fVar2.onScrollStateChanged(absListView, i);
        }
        eVar = this.enc.elF;
        if (eVar == null) {
            this.enc.elF = new com.baidu.tbadk.j.e();
            eVar5 = this.enc.elF;
            eVar5.fb(1001);
        }
        if (i == 0) {
            pbModel = this.enc.ele;
            if (pbModel != null) {
                pbModel2 = this.enc.ele;
                if (pbModel2.getPbData() != null) {
                    pbModel3 = this.enc.ele;
                    if (pbModel3.getPbData().aIB() != null) {
                        pbModel4 = this.enc.ele;
                        if (pbModel4.getPbData().aIB().sh()) {
                            z2 = false;
                        }
                    }
                }
            }
            fxVar2 = this.enc.elU;
            if (fxVar2.aMu() != null && z2) {
                fxVar3 = this.enc.elU;
                fxVar3.aMu().notifyDataSetChanged();
            }
            eVar4 = this.enc.elF;
            eVar4.Fl();
        } else if (i == 1) {
            eVar3 = this.enc.elF;
            eVar3.Fl();
        } else {
            eVar2 = this.enc.elF;
            eVar2.Fl();
        }
        this.enc.mLastScrollState = i;
        if (i == 0) {
            this.enc.a(false, (PostData) null);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        PbModel pbModel;
        PbModel pbModel2;
        fx fxVar;
        fx fxVar2;
        fx fxVar3;
        com.baidu.tieba.pb.pb.main.a.f fVar;
        PbModel pbModel3;
        PbModel pbModel4;
        fx fxVar4;
        PbModel pbModel5;
        boolean z;
        com.baidu.tieba.pb.pb.main.a.f fVar2;
        pbModel = this.enc.ele;
        if (pbModel != null) {
            pbModel2 = this.enc.ele;
            if (pbModel2.getPbData() != null) {
                fxVar = this.enc.elU;
                if (fxVar != null) {
                    fxVar2 = this.enc.elU;
                    if (fxVar2.aMu() != null) {
                        fxVar3 = this.enc.elU;
                        fxVar3.onScroll(absListView, i, i2, i3);
                        fVar = this.enc.elw;
                        if (fVar != null) {
                            fVar2 = this.enc.elw;
                            fVar2.onScroll(absListView, i, i2, i3);
                        }
                        pbModel3 = this.enc.ele;
                        if (pbModel3.aLc()) {
                            pbModel4 = this.enc.ele;
                            ArrayList<PostData> aID = pbModel4.getPbData().aID();
                            if (aID != null && !aID.isEmpty()) {
                                fxVar4 = this.enc.elU;
                                int aKx = ((i + i2) - fxVar4.aMu().aKx()) - 1;
                                pbModel5 = this.enc.ele;
                                com.baidu.tieba.pb.data.f pbData = pbModel5.getPbData();
                                if (pbData != null) {
                                    if (pbData.aIE() != null && pbData.aIE().hasData()) {
                                        aKx--;
                                    }
                                    if (pbData.aIF() != null && pbData.aIF().hasData()) {
                                        aKx--;
                                    }
                                    z = this.enc.elH;
                                    if (z) {
                                        aKx--;
                                    }
                                    int size = aID.size();
                                    if (aKx < 0 || aKx >= size) {
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
