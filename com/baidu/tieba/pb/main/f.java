package com.baidu.tieba.pb.main;

import com.baidu.tbadk.core.data.AntiData;
import java.util.ArrayList;
/* loaded from: classes.dex */
class f implements com.baidu.tieba.pb.sub.g {
    final /* synthetic */ PbActivity bAS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(PbActivity pbActivity) {
        this.bAS = pbActivity;
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
        AntiData abO;
        com.baidu.tieba.pb.sub.e eVar3;
        String str2;
        bz bzVar4;
        bq bqVar3;
        String str3;
        com.baidu.tieba.pb.sub.e eVar4;
        bq bqVar4;
        this.bAS.stopVoice();
        bzVar = this.bAS.bAw;
        bzVar.showToast(str);
        bzVar2 = this.bAS.bAw;
        bzVar2.YM();
        if (!z) {
            if (i == 4 || i == 28) {
                bqVar4 = this.bAS.bAr;
                if (bqVar4.XJ()) {
                    this.bAS.closeActivity();
                }
            }
        } else if (oVar != null) {
            eVar = this.bAS.bAu;
            String lm = eVar.lm();
            bqVar = this.bAS.bAr;
            ArrayList<com.baidu.tieba.tbadkCore.b.k> ahf = bqVar.getPbData().ahf();
            int i2 = 0;
            while (true) {
                if (i2 < ahf.size()) {
                    com.baidu.tieba.tbadkCore.b.k kVar = ahf.get(i2);
                    if (kVar.getId() == null || !kVar.getId().equals(lm)) {
                        i2++;
                    } else {
                        ArrayList<com.baidu.tieba.tbadkCore.b.k> ahE = oVar.ahE();
                        kVar.hW(ahE.size());
                        int size = kVar.ahq().size();
                        while (true) {
                            int i3 = size;
                            if (i3 >= 2 || i3 >= ahE.size()) {
                                break;
                            }
                            kVar.ahq().add(oVar.ahE().get(i3));
                            size = i3 + 1;
                        }
                    }
                } else {
                    break;
                }
            }
            eVar2 = this.bAS.bAu;
            String stType = eVar2.getStType();
            if (stType != null) {
                eVar3 = this.bAS.bAu;
                if ("mention".equals(eVar3.getStType()) || stType.equals("person_post_reply")) {
                    str2 = this.bAS.bAC;
                    if (str2 != null) {
                        bzVar4 = this.bAS.bAw;
                        bqVar3 = this.bAS.bAr;
                        int ahg = bqVar3.getPbData().ahg();
                        str3 = this.bAS.bAC;
                        boolean z2 = oVar.ahD() > 1;
                        eVar4 = this.bAS.bAu;
                        bzVar4.a(oVar, ahg, str3, z2, eVar4.UD() == 1);
                        abO = oVar.abO();
                        if (abO == null) {
                            Boolean valueOf = Boolean.valueOf(abO.isIfvoice());
                            this.bAS.bAq = abO.getVoice_message();
                            if (oVar.ahG() != null) {
                                this.bAS.a(oVar.ahG().getName(), valueOf);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                }
            }
            bzVar3 = this.bAS.bAw;
            bqVar2 = this.bAS.bAr;
            bzVar3.a(oVar, bqVar2.getPbData().ahg());
            abO = oVar.abO();
            if (abO == null) {
            }
        }
    }
}
