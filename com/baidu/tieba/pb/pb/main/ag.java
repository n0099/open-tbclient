package com.baidu.tieba.pb.pb.main;

import android.widget.AbsListView;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
/* loaded from: classes.dex */
class ag implements AbsListView.OnScrollListener {
    final /* synthetic */ PbActivity ehy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(PbActivity pbActivity) {
        this.ehy = pbActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        int i2;
        boolean nX;
        fm fmVar;
        com.baidu.tieba.pb.pb.main.a.f fVar;
        com.baidu.tbadk.j.e eVar;
        com.baidu.tbadk.j.e eVar2;
        com.baidu.tbadk.j.e eVar3;
        PbModel pbModel;
        fm fmVar2;
        com.baidu.tbadk.j.e eVar4;
        fm fmVar3;
        PbModel pbModel2;
        PbModel pbModel3;
        PbModel pbModel4;
        com.baidu.tbadk.j.e eVar5;
        com.baidu.tieba.pb.pb.main.a.f fVar2;
        boolean nX2;
        fm fmVar4;
        boolean z;
        fm fmVar5;
        fm fmVar6;
        com.baidu.tbadk.editortools.pb.c cVar;
        fm fmVar7;
        fm fmVar8;
        fm fmVar9;
        com.baidu.tbadk.editortools.pb.c cVar2;
        boolean z2 = true;
        PbActivity pbActivity = this.ehy;
        i2 = this.ehy.cyd;
        nX = pbActivity.nX(i2);
        if (!nX) {
            nX2 = this.ehy.nX(i);
            if (nX2) {
                fmVar4 = this.ehy.egt;
                if (fmVar4 != null) {
                    fmVar6 = this.ehy.egt;
                    fmVar6.auE();
                    cVar = this.ehy.egG;
                    if (cVar != null) {
                        fmVar8 = this.ehy.egt;
                        if (!fmVar8.aLm()) {
                            fmVar9 = this.ehy.egt;
                            cVar2 = this.ehy.egG;
                            fmVar9.gm(cVar2.CY());
                        }
                    }
                    fmVar7 = this.ehy.egt;
                    fmVar7.aLl();
                }
                z = this.ehy.egf;
                if (!z) {
                    this.ehy.egf = true;
                    fmVar5 = this.ehy.egt;
                    fmVar5.aLU();
                }
            }
        }
        fmVar = this.ehy.egt;
        fmVar.onScrollStateChanged(absListView, i);
        fVar = this.ehy.efX;
        if (fVar != null) {
            fVar2 = this.ehy.efX;
            fVar2.onScrollStateChanged(absListView, i);
        }
        eVar = this.ehy.egg;
        if (eVar == null) {
            this.ehy.egg = new com.baidu.tbadk.j.e();
            eVar5 = this.ehy.egg;
            eVar5.fa(1001);
        }
        if (i == 0) {
            pbModel = this.ehy.efE;
            if (pbModel != null) {
                pbModel2 = this.ehy.efE;
                if (pbModel2.getPbData() != null) {
                    pbModel3 = this.ehy.efE;
                    if (pbModel3.getPbData().aHG() != null) {
                        pbModel4 = this.ehy.efE;
                        if (pbModel4.getPbData().aHG().sl()) {
                            z2 = false;
                        }
                    }
                }
            }
            fmVar2 = this.ehy.egt;
            if (fmVar2.aLy() != null && z2) {
                fmVar3 = this.ehy.egt;
                fmVar3.aLy().notifyDataSetChanged();
            }
            eVar4 = this.ehy.egg;
            eVar4.Fr();
        } else if (i == 1) {
            eVar3 = this.ehy.egg;
            eVar3.Fr();
        } else {
            eVar2 = this.ehy.egg;
            eVar2.Fr();
        }
        this.ehy.cyd = i;
        if (i == 0) {
            this.ehy.a(false, (PostData) null);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        PbModel pbModel;
        PbModel pbModel2;
        fm fmVar;
        fm fmVar2;
        fm fmVar3;
        com.baidu.tieba.pb.pb.main.a.f fVar;
        PbModel pbModel3;
        PbModel pbModel4;
        fm fmVar4;
        PbModel pbModel5;
        boolean z;
        com.baidu.tieba.pb.pb.main.a.f fVar2;
        pbModel = this.ehy.efE;
        if (pbModel != null) {
            pbModel2 = this.ehy.efE;
            if (pbModel2.getPbData() != null) {
                fmVar = this.ehy.egt;
                if (fmVar != null) {
                    fmVar2 = this.ehy.egt;
                    if (fmVar2.aLy() != null) {
                        fmVar3 = this.ehy.egt;
                        fmVar3.onScroll(absListView, i, i2, i3);
                        fVar = this.ehy.efX;
                        if (fVar != null) {
                            fVar2 = this.ehy.efX;
                            fVar2.onScroll(absListView, i, i2, i3);
                        }
                        pbModel3 = this.ehy.efE;
                        if (pbModel3.aKi()) {
                            pbModel4 = this.ehy.efE;
                            ArrayList<PostData> aHI = pbModel4.getPbData().aHI();
                            if (aHI != null && !aHI.isEmpty()) {
                                fmVar4 = this.ehy.egt;
                                int aJC = ((i + i2) - fmVar4.aLy().aJC()) - 1;
                                pbModel5 = this.ehy.efE;
                                com.baidu.tieba.pb.data.f pbData = pbModel5.getPbData();
                                if (pbData != null) {
                                    if (pbData.aHJ() != null && pbData.aHJ().hasData()) {
                                        aJC--;
                                    }
                                    if (pbData.aHK() != null && pbData.aHK().hasData()) {
                                        aJC--;
                                    }
                                    z = this.ehy.egi;
                                    if (z) {
                                        aJC--;
                                    }
                                    int size = aHI.size();
                                    if (aJC < 0 || aJC >= size) {
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
