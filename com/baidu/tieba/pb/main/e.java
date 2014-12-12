package com.baidu.tieba.pb.main;

import com.baidu.tbadk.core.data.AntiData;
import java.util.ArrayList;
/* loaded from: classes.dex */
class e implements com.baidu.tieba.pb.sub.g {
    final /* synthetic */ PbActivity bzj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PbActivity pbActivity) {
        this.bzj = pbActivity;
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
        AntiData abp;
        com.baidu.tieba.pb.sub.e eVar3;
        String str2;
        bz bzVar4;
        bq bqVar3;
        String str3;
        com.baidu.tieba.pb.sub.e eVar4;
        bq bqVar4;
        this.bzj.stopVoice();
        bzVar = this.bzj.byO;
        bzVar.showToast(str);
        bzVar2 = this.bzj.byO;
        bzVar2.Ym();
        if (!z) {
            if (i == 4 || i == 28) {
                bqVar4 = this.bzj.byJ;
                if (bqVar4.Xj()) {
                    this.bzj.closeActivity();
                }
            }
        } else if (oVar != null) {
            eVar = this.bzj.byM;
            String lt = eVar.lt();
            bqVar = this.bzj.byJ;
            ArrayList<com.baidu.tieba.tbadkCore.b.k> agF = bqVar.getPbData().agF();
            int i2 = 0;
            while (true) {
                if (i2 < agF.size()) {
                    com.baidu.tieba.tbadkCore.b.k kVar = agF.get(i2);
                    if (kVar.getId() == null || !kVar.getId().equals(lt)) {
                        i2++;
                    } else {
                        ArrayList<com.baidu.tieba.tbadkCore.b.k> ahe = oVar.ahe();
                        kVar.hN(ahe.size());
                        int size = kVar.agQ().size();
                        while (true) {
                            int i3 = size;
                            if (i3 >= 2 || i3 >= ahe.size()) {
                                break;
                            }
                            kVar.agQ().add(oVar.ahe().get(i3));
                            size = i3 + 1;
                        }
                    }
                } else {
                    break;
                }
            }
            eVar2 = this.bzj.byM;
            String stType = eVar2.getStType();
            if (stType != null) {
                eVar3 = this.bzj.byM;
                if ("mention".equals(eVar3.getStType()) || stType.equals("person_post_reply")) {
                    str2 = this.bzj.byU;
                    if (str2 != null) {
                        bzVar4 = this.bzj.byO;
                        bqVar3 = this.bzj.byJ;
                        int agG = bqVar3.getPbData().agG();
                        str3 = this.bzj.byU;
                        boolean z2 = oVar.ahd() > 1;
                        eVar4 = this.bzj.byM;
                        bzVar4.a(oVar, agG, str3, z2, eVar4.Ul() == 1);
                        abp = oVar.abp();
                        if (abp == null) {
                            Boolean valueOf = Boolean.valueOf(abp.isIfvoice());
                            this.bzj.byI = abp.getVoice_message();
                            if (oVar.ahg() != null) {
                                this.bzj.a(oVar.ahg().getName(), valueOf);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                }
            }
            bzVar3 = this.bzj.byO;
            bqVar2 = this.bzj.byJ;
            bzVar3.a(oVar, bqVar2.getPbData().agG());
            abp = oVar.abp();
            if (abp == null) {
            }
        }
    }
}
