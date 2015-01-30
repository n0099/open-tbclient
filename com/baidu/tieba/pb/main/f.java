package com.baidu.tieba.pb.main;

import com.baidu.tbadk.core.data.AntiData;
import java.util.ArrayList;
/* loaded from: classes.dex */
class f implements com.baidu.tieba.pb.sub.g {
    final /* synthetic */ PbActivity bAT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(PbActivity pbActivity) {
        this.bAT = pbActivity;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.tieba.pb.sub.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(boolean z, int i, String str, com.baidu.tieba.tbadkCore.b.o oVar) {
        bz bzVar;
        bz bzVar2;
        com.baidu.tieba.pb.sub.e eVar;
        bq bqVar;
        com.baidu.tieba.pb.sub.e eVar2;
        bz bzVar3;
        bq bqVar2;
        AntiData abT;
        com.baidu.tieba.pb.sub.e eVar3;
        String str2;
        bz bzVar4;
        bq bqVar3;
        String str3;
        com.baidu.tieba.pb.sub.e eVar4;
        bq bqVar4;
        this.bAT.stopVoice();
        bzVar = this.bAT.bAx;
        bzVar.showToast(str);
        bzVar2 = this.bAT.bAx;
        bzVar2.YR();
        if (!z) {
            if (i == 4 || i == 28) {
                bqVar4 = this.bAT.bAs;
                if (bqVar4.XO()) {
                    this.bAT.closeActivity();
                }
            }
        } else if (oVar != null) {
            eVar = this.bAT.bAv;
            String lt = eVar.lt();
            bqVar = this.bAT.bAs;
            ArrayList<com.baidu.tieba.tbadkCore.b.k> ahk = bqVar.getPbData().ahk();
            int i2 = 0;
            while (true) {
                if (i2 < ahk.size()) {
                    com.baidu.tieba.tbadkCore.b.k kVar = ahk.get(i2);
                    if (kVar.getId() == null || !kVar.getId().equals(lt)) {
                        i2++;
                    } else {
                        ArrayList<com.baidu.tieba.tbadkCore.b.k> ahJ = oVar.ahJ();
                        kVar.hW(ahJ.size());
                        int size = kVar.ahv().size();
                        while (true) {
                            int i3 = size;
                            if (i3 >= 2 || i3 >= ahJ.size()) {
                                break;
                            }
                            kVar.ahv().add(oVar.ahJ().get(i3));
                            size = i3 + 1;
                        }
                    }
                } else {
                    break;
                }
            }
            eVar2 = this.bAT.bAv;
            String stType = eVar2.getStType();
            if (stType != null) {
                eVar3 = this.bAT.bAv;
                if ("mention".equals(eVar3.getStType()) || stType.equals("person_post_reply")) {
                    str2 = this.bAT.bAD;
                    if (str2 != null) {
                        bzVar4 = this.bAT.bAx;
                        bqVar3 = this.bAT.bAs;
                        int ahl = bqVar3.getPbData().ahl();
                        str3 = this.bAT.bAD;
                        boolean z2 = oVar.ahI() > 1;
                        eVar4 = this.bAT.bAv;
                        bzVar4.a(oVar, ahl, str3, z2, eVar4.UI() == 1);
                        abT = oVar.abT();
                        if (abT == null) {
                            Boolean valueOf = Boolean.valueOf(abT.isIfvoice());
                            this.bAT.bAr = abT.getVoice_message();
                            if (oVar.ahL() != null) {
                                this.bAT.a(oVar.ahL().getName(), valueOf);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                }
            }
            bzVar3 = this.bAT.bAx;
            bqVar2 = this.bAT.bAs;
            bzVar3.a(oVar, bqVar2.getPbData().ahl());
            abT = oVar.abT();
            if (abT == null) {
            }
        }
    }
}
