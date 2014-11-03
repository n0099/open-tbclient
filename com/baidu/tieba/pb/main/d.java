package com.baidu.tieba.pb.main;

import com.baidu.tbadk.core.data.AntiData;
import java.util.ArrayList;
/* loaded from: classes.dex */
class d implements com.baidu.tieba.pb.sub.g {
    final /* synthetic */ PbActivity bvu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PbActivity pbActivity) {
        this.bvu = pbActivity;
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
        AntiData Ap;
        com.baidu.tieba.pb.sub.e eVar3;
        String str2;
        bv bvVar4;
        bn bnVar3;
        String str3;
        com.baidu.tieba.pb.sub.e eVar4;
        bn bnVar4;
        this.bvu.EC();
        bvVar = this.bvu.buZ;
        bvVar.showToast(str);
        bvVar2 = this.bvu.buZ;
        bvVar2.XP();
        if (!z) {
            if (i == 4 || i == 28) {
                bnVar4 = this.bvu.buU;
                if (bnVar4.WM()) {
                    this.bvu.closeActivity();
                }
            }
        } else if (arVar != null) {
            eVar = this.bvu.buX;
            String zX = eVar.zX();
            bnVar = this.bvu.buU;
            ArrayList<com.baidu.tieba.data.ak> zN = bnVar.getPbData().zN();
            int i2 = 0;
            while (true) {
                if (i2 < zN.size()) {
                    com.baidu.tieba.data.ak akVar = zN.get(i2);
                    if (akVar.getId() == null || !akVar.getId().equals(zX)) {
                        i2++;
                    } else {
                        ArrayList<com.baidu.tieba.data.ak> Aw = arVar.Aw();
                        akVar.ef(Aw.size());
                        int size = akVar.Ad().size();
                        while (true) {
                            int i3 = size;
                            if (i3 >= 2 || i3 >= Aw.size()) {
                                break;
                            }
                            akVar.Ad().add(arVar.Aw().get(i3));
                            size = i3 + 1;
                        }
                    }
                } else {
                    break;
                }
            }
            eVar2 = this.bvu.buX;
            String stType = eVar2.getStType();
            if (stType != null) {
                eVar3 = this.bvu.buX;
                if ("mention".equals(eVar3.getStType()) || stType.equals("person_post_reply")) {
                    str2 = this.bvu.bvf;
                    if (str2 != null) {
                        bvVar4 = this.bvu.buZ;
                        bnVar3 = this.bvu.buU;
                        int zS = bnVar3.getPbData().zS();
                        str3 = this.bvu.bvf;
                        boolean z2 = arVar.Av() > 1;
                        eVar4 = this.bvu.buX;
                        bvVar4.a(arVar, zS, str3, z2, eVar4.Tx() == 1);
                        Ap = arVar.Ap();
                        if (Ap == null) {
                            Boolean valueOf = Boolean.valueOf(Ap.isIfvoice());
                            this.bvu.buT = Ap.getVoice_message();
                            if (arVar.Ay() != null) {
                                this.bvu.a(arVar.Ay().getName(), valueOf);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                }
            }
            bvVar3 = this.bvu.buZ;
            bnVar2 = this.bvu.buU;
            bvVar3.a(arVar, bnVar2.getPbData().zS());
            Ap = arVar.Ap();
            if (Ap == null) {
            }
        }
    }
}
