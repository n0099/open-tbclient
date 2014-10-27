package com.baidu.tieba.pb.main;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.ArrayList;
/* loaded from: classes.dex */
class o implements com.baidu.tbadk.widget.richText.s {
    final /* synthetic */ PbActivity bvg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(PbActivity pbActivity) {
        this.bvg = pbActivity;
    }

    @Override // com.baidu.tbadk.widget.richText.s
    public void onClick(View view, String str, int i) {
        bn bnVar;
        com.baidu.tbadk.widget.richText.a K;
        int i2;
        bn bnVar2;
        String b;
        bn bnVar3;
        try {
            TiebaStatic.eventStat(this.bvg, "pic_pb", "");
            bnVar = this.bvg.buG;
            com.baidu.tieba.data.ah pbData = bnVar.getPbData();
            K = this.bvg.K(str, i);
            ArrayList<com.baidu.tbadk.widget.richText.c> vy = K.vy();
            i2 = this.bvg.bvc;
            com.baidu.tbadk.widget.richText.c cVar = vy.get(i2);
            if (cVar != null) {
                ArrayList<String> arrayList = new ArrayList<>();
                if (cVar.vD().vK()) {
                    int size = pbData.zL().size();
                    this.bvg.bvd = false;
                    String str2 = "";
                    int i3 = i;
                    for (int i4 = 0; i4 < size; i4++) {
                        com.baidu.tieba.data.ak akVar = pbData.zL().get(i4);
                        com.baidu.tbadk.widget.richText.a Af = akVar.Af();
                        int size2 = arrayList.size();
                        i3 = this.bvg.a(Af, K, i3, i, arrayList);
                        int size3 = arrayList.size();
                        if (size2 != size3) {
                            str2 = arrayList.get(size3 - 1);
                        }
                        ArrayList<com.baidu.tieba.data.ak> Ad = akVar.Ad();
                        int i5 = 0;
                        while (true) {
                            int i6 = i5;
                            if (i6 >= Ad.size()) {
                                break;
                            }
                            i3 = this.bvg.a(Ad.get(i6).Af(), K, i3, i, arrayList);
                            i5 = i6 + 1;
                        }
                    }
                    String str3 = null;
                    String str4 = null;
                    String str5 = null;
                    boolean z = false;
                    if (pbData != null) {
                        if (pbData.zJ() != null) {
                            str3 = pbData.zJ().getName();
                            str4 = pbData.zJ().getId();
                        }
                        if (pbData.zK() != null) {
                            str5 = pbData.zK().getId();
                        }
                        z = pbData.yU() == 1;
                    }
                    PbActivity pbActivity = this.bvg;
                    ImageViewerConfig imageViewerConfig = new ImageViewerConfig(this.bvg);
                    bnVar2 = this.bvg.buG;
                    pbActivity.sendMessage(new CustomMessage(2010000, imageViewerConfig.createConfig(arrayList, i3, str3, str4, str5, z, str2, bnVar2.WQ())));
                    return;
                }
                b = this.bvg.b(cVar);
                arrayList.add(b);
                String str6 = null;
                String str7 = null;
                String str8 = null;
                boolean z2 = false;
                if (pbData != null) {
                    if (pbData.zJ() != null) {
                        str6 = pbData.zJ().getName();
                        str7 = pbData.zJ().getId();
                    }
                    if (pbData.zK() != null) {
                        str8 = pbData.zK().getId();
                    }
                    z2 = pbData.yU() == 1;
                }
                PbActivity pbActivity2 = this.bvg;
                bnVar3 = this.bvg.buG;
                pbActivity2.sendMessage(new CustomMessage(2010000, new ImageViewerConfig(this.bvg).createConfig(arrayList, 0, str6, str7, str8, z2, arrayList.get(0), bnVar3.WQ())));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
