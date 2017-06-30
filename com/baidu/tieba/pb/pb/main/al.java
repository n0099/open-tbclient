package com.baidu.tieba.pb.pb.main;

import android.widget.AbsListView;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
/* loaded from: classes.dex */
class al implements AbsListView.OnScrollListener {
    final /* synthetic */ PbActivity ewh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(PbActivity pbActivity) {
        this.ewh = pbActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        int i2;
        boolean oG;
        gg ggVar;
        com.baidu.tieba.pb.pb.main.a.f fVar;
        com.baidu.tbadk.j.e eVar;
        com.baidu.tbadk.j.e eVar2;
        com.baidu.tbadk.j.e eVar3;
        PbModel pbModel;
        gg ggVar2;
        com.baidu.tbadk.j.e eVar4;
        gg ggVar3;
        PbModel pbModel2;
        PbModel pbModel3;
        PbModel pbModel4;
        com.baidu.tbadk.j.e eVar5;
        com.baidu.tieba.pb.pb.main.a.f fVar2;
        boolean oG2;
        gg ggVar4;
        boolean z;
        gg ggVar5;
        gg ggVar6;
        com.baidu.tbadk.editortools.pb.c cVar;
        gg ggVar7;
        gg ggVar8;
        gg ggVar9;
        com.baidu.tbadk.editortools.pb.c cVar2;
        boolean z2 = true;
        PbActivity pbActivity = this.ewh;
        i2 = this.ewh.mLastScrollState;
        oG = pbActivity.oG(i2);
        if (!oG) {
            oG2 = this.ewh.oG(i);
            if (oG2) {
                ggVar4 = this.ewh.euU;
                if (ggVar4 != null) {
                    ggVar6 = this.ewh.euU;
                    ggVar6.azw();
                    cVar = this.ewh.evh;
                    if (cVar != null) {
                        ggVar8 = this.ewh.euU;
                        if (!ggVar8.aQf()) {
                            ggVar9 = this.ewh.euU;
                            cVar2 = this.ewh.evh;
                            ggVar9.gT(cVar2.Dm());
                        }
                    }
                    ggVar7 = this.ewh.euU;
                    ggVar7.aOk();
                }
                z = this.ewh.euE;
                if (!z) {
                    this.ewh.euE = true;
                    ggVar5 = this.ewh.euU;
                    ggVar5.aQM();
                }
            }
        }
        ggVar = this.ewh.euU;
        ggVar.onScrollStateChanged(absListView, i);
        fVar = this.ewh.euw;
        if (fVar != null) {
            fVar2 = this.ewh.euw;
            fVar2.onScrollStateChanged(absListView, i);
        }
        eVar = this.ewh.euF;
        if (eVar == null) {
            this.ewh.euF = new com.baidu.tbadk.j.e();
            eVar5 = this.ewh.euF;
            eVar5.fd(1001);
        }
        if (i == 0) {
            pbModel = this.ewh.eue;
            if (pbModel != null) {
                pbModel2 = this.ewh.eue;
                if (pbModel2.getPbData() != null) {
                    pbModel3 = this.ewh.eue;
                    if (pbModel3.getPbData().aMv() != null) {
                        pbModel4 = this.ewh.eue;
                        if (pbModel4.getPbData().aMv().se()) {
                            z2 = false;
                        }
                    }
                }
            }
            ggVar2 = this.ewh.euU;
            if (ggVar2.aQs() != null && z2) {
                ggVar3 = this.ewh.euU;
                ggVar3.aQs().notifyDataSetChanged();
            }
            eVar4 = this.ewh.euF;
            eVar4.FI();
        } else if (i == 1) {
            eVar3 = this.ewh.euF;
            eVar3.FI();
        } else {
            eVar2 = this.ewh.euF;
            eVar2.FI();
        }
        this.ewh.mLastScrollState = i;
        if (i == 0) {
            this.ewh.a(false, (PostData) null);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        PbModel pbModel;
        PbModel pbModel2;
        gg ggVar;
        gg ggVar2;
        gg ggVar3;
        com.baidu.tieba.pb.pb.main.a.f fVar;
        PbModel pbModel3;
        PbModel pbModel4;
        gg ggVar4;
        PbModel pbModel5;
        boolean z;
        com.baidu.tieba.pb.pb.main.a.f fVar2;
        pbModel = this.ewh.eue;
        if (pbModel != null) {
            pbModel2 = this.ewh.eue;
            if (pbModel2.getPbData() != null) {
                ggVar = this.ewh.euU;
                if (ggVar != null) {
                    ggVar2 = this.ewh.euU;
                    if (ggVar2.aQs() != null) {
                        ggVar3 = this.ewh.euU;
                        ggVar3.onScroll(absListView, i, i2, i3);
                        fVar = this.ewh.euw;
                        if (fVar != null) {
                            fVar2 = this.ewh.euw;
                            fVar2.onScroll(absListView, i, i2, i3);
                        }
                        pbModel3 = this.ewh.eue;
                        if (pbModel3.aOZ()) {
                            pbModel4 = this.ewh.eue;
                            ArrayList<PostData> aMx = pbModel4.getPbData().aMx();
                            if (aMx != null && !aMx.isEmpty()) {
                                ggVar4 = this.ewh.euU;
                                int aOu = ((i + i2) - ggVar4.aQs().aOu()) - 1;
                                pbModel5 = this.ewh.eue;
                                com.baidu.tieba.pb.data.f pbData = pbModel5.getPbData();
                                if (pbData != null) {
                                    if (pbData.aMy() != null && pbData.aMy().hasData()) {
                                        aOu--;
                                    }
                                    if (pbData.aMz() != null && pbData.aMz().hasData()) {
                                        aOu--;
                                    }
                                    z = this.ewh.euH;
                                    if (z) {
                                        aOu--;
                                    }
                                    int size = aMx.size();
                                    if (aOu < 0 || aOu >= size) {
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
