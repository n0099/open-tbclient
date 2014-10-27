package com.baidu.tieba.pb.main;

import com.baidu.tbadk.core.data.AntiData;
import java.util.ArrayList;
/* loaded from: classes.dex */
class d implements com.baidu.tieba.pb.sub.g {
    final /* synthetic */ PbActivity bvg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PbActivity pbActivity) {
        this.bvg = pbActivity;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.tieba.pb.sub.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(boolean z, int i, String str, com.baidu.tieba.data.ar arVar) {
        bv bvVar;
        bv bvVar2;
        com.baidu.tieba.pb.sub.e eVar;
        bn bnVar;
        com.baidu.tieba.pb.sub.e eVar2;
        bv bvVar3;
        bn bnVar2;
        AntiData An;
        com.baidu.tieba.pb.sub.e eVar3;
        String str2;
        bv bvVar4;
        bn bnVar3;
        String str3;
        com.baidu.tieba.pb.sub.e eVar4;
        bn bnVar4;
        this.bvg.EA();
        bvVar = this.bvg.buL;
        bvVar.showToast(str);
        bvVar2 = this.bvg.buL;
        bvVar2.XM();
        if (!z) {
            if (i == 4 || i == 28) {
                bnVar4 = this.bvg.buG;
                if (bnVar4.WJ()) {
                    this.bvg.closeActivity();
                }
            }
        } else if (arVar != null) {
            eVar = this.bvg.buJ;
            String zV = eVar.zV();
            bnVar = this.bvg.buG;
            ArrayList<com.baidu.tieba.data.ak> zL = bnVar.getPbData().zL();
            int i2 = 0;
            while (true) {
                if (i2 < zL.size()) {
                    com.baidu.tieba.data.ak akVar = zL.get(i2);
                    if (akVar.getId() == null || !akVar.getId().equals(zV)) {
                        i2++;
                    } else {
                        ArrayList<com.baidu.tieba.data.ak> Au = arVar.Au();
                        akVar.ef(Au.size());
                        int size = akVar.Ab().size();
                        while (true) {
                            int i3 = size;
                            if (i3 >= 2 || i3 >= Au.size()) {
                                break;
                            }
                            akVar.Ab().add(arVar.Au().get(i3));
                            size = i3 + 1;
                        }
                    }
                } else {
                    break;
                }
            }
            eVar2 = this.bvg.buJ;
            String stType = eVar2.getStType();
            if (stType != null) {
                eVar3 = this.bvg.buJ;
                if ("mention".equals(eVar3.getStType()) || stType.equals("person_post_reply")) {
                    str2 = this.bvg.buR;
                    if (str2 != null) {
                        bvVar4 = this.bvg.buL;
                        bnVar3 = this.bvg.buG;
                        int zQ = bnVar3.getPbData().zQ();
                        str3 = this.bvg.buR;
                        boolean z2 = arVar.At() > 1;
                        eVar4 = this.bvg.buJ;
                        bvVar4.a(arVar, zQ, str3, z2, eVar4.Tu() == 1);
                        An = arVar.An();
                        if (An == null) {
                            Boolean valueOf = Boolean.valueOf(An.isIfvoice());
                            this.bvg.buF = An.getVoice_message();
                            if (arVar.Aw() != null) {
                                this.bvg.a(arVar.Aw().getName(), valueOf);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                }
            }
            bvVar3 = this.bvg.buL;
            bnVar2 = this.bvg.buG;
            bvVar3.a(arVar, bnVar2.getPbData().zQ());
            An = arVar.An();
            if (An == null) {
            }
        }
    }
}
