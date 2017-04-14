package com.baidu.tieba.pb.pb.main;

import android.widget.AbsListView;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
/* loaded from: classes.dex */
class af implements AbsListView.OnScrollListener {
    final /* synthetic */ PbActivity ejU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(PbActivity pbActivity) {
        this.ejU = pbActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        int i2;
        boolean ob;
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
        boolean ob2;
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
        PbActivity pbActivity = this.ejU;
        i2 = this.ejU.cBC;
        ob = pbActivity.ob(i2);
        if (!ob) {
            ob2 = this.ejU.ob(i);
            if (ob2) {
                eyVar4 = this.ejU.eiS;
                if (eyVar4 != null) {
                    eyVar6 = this.ejU.eiS;
                    eyVar6.awH();
                    cVar = this.ejU.eje;
                    if (cVar != null) {
                        eyVar8 = this.ejU.eiS;
                        if (!eyVar8.aMU()) {
                            eyVar9 = this.ejU.eiS;
                            cVar2 = this.ejU.eje;
                            eyVar9.gB(cVar2.DU());
                        }
                    }
                    eyVar7 = this.ejU.eiS;
                    eyVar7.aMT();
                }
                z = this.ejU.eiE;
                if (!z) {
                    this.ejU.eiE = true;
                    eyVar5 = this.ejU.eiS;
                    eyVar5.aNC();
                }
            }
        }
        eyVar = this.ejU.eiS;
        eyVar.onScrollStateChanged(absListView, i);
        fVar = this.ejU.eiy;
        if (fVar != null) {
            fVar2 = this.ejU.eiy;
            fVar2.onScrollStateChanged(absListView, i);
        }
        eVar = this.ejU.eiF;
        if (eVar == null) {
            this.ejU.eiF = new com.baidu.tbadk.j.e();
            eVar5 = this.ejU.eiF;
            eVar5.fe(1001);
        }
        if (i == 0) {
            pbModel = this.ejU.eif;
            if (pbModel != null) {
                pbModel2 = this.ejU.eif;
                if (pbModel2.getPbData() != null) {
                    pbModel3 = this.ejU.eif;
                    if (pbModel3.getPbData().aJx() != null) {
                        pbModel4 = this.ejU.eif;
                        if (pbModel4.getPbData().aJx().tb()) {
                            z2 = false;
                        }
                    }
                }
            }
            eyVar2 = this.ejU.eiS;
            if (eyVar2.aNg() != null && z2) {
                eyVar3 = this.ejU.eiS;
                eyVar3.aNg().notifyDataSetChanged();
            }
            eVar4 = this.ejU.eiF;
            eVar4.Gn();
        } else if (i == 1) {
            eVar3 = this.ejU.eiF;
            eVar3.Gn();
        } else {
            eVar2 = this.ejU.eiF;
            eVar2.Gn();
        }
        this.ejU.cBC = i;
        if (i == 0) {
            this.ejU.a(false, (PostData) null);
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
        pbModel = this.ejU.eif;
        if (pbModel != null) {
            pbModel2 = this.ejU.eif;
            if (pbModel2.getPbData() != null) {
                eyVar = this.ejU.eiS;
                if (eyVar != null) {
                    eyVar2 = this.ejU.eiS;
                    if (eyVar2.aNg() != null) {
                        eyVar3 = this.ejU.eiS;
                        eyVar3.onScroll(absListView, i, i2, i3);
                        fVar = this.ejU.eiy;
                        if (fVar != null) {
                            fVar2 = this.ejU.eiy;
                            fVar2.onScroll(absListView, i, i2, i3);
                        }
                        pbModel3 = this.ejU.eif;
                        if (pbModel3.aLS()) {
                            pbModel4 = this.ejU.eif;
                            ArrayList<PostData> aJz = pbModel4.getPbData().aJz();
                            if (aJz != null && !aJz.isEmpty()) {
                                eyVar4 = this.ejU.eiS;
                                int aLc = ((i + i2) - eyVar4.aNg().aLc()) - 1;
                                pbModel5 = this.ejU.eif;
                                com.baidu.tieba.pb.data.f pbData = pbModel5.getPbData();
                                if (pbData != null) {
                                    if (pbData.aJA() != null && pbData.aJA().hasData()) {
                                        aLc--;
                                    }
                                    if (pbData.aJB() != null && pbData.aJB().hasData()) {
                                        aLc--;
                                    }
                                    z = this.ejU.eiH;
                                    if (z) {
                                        aLc--;
                                    }
                                    int size = aJz.size();
                                    if (aLc < 0 || aLc >= size) {
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
