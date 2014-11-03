package com.baidu.tieba.pb.main;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.ArrayList;
/* loaded from: classes.dex */
class o implements com.baidu.tbadk.widget.richText.s {
    final /* synthetic */ PbActivity bvu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(PbActivity pbActivity) {
        this.bvu = pbActivity;
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
            TiebaStatic.eventStat(this.bvu, "pic_pb", "");
            bnVar = this.bvu.buU;
            com.baidu.tieba.data.ah pbData = bnVar.getPbData();
            K = this.bvu.K(str, i);
            ArrayList<com.baidu.tbadk.widget.richText.c> vA = K.vA();
            i2 = this.bvu.bvq;
            com.baidu.tbadk.widget.richText.c cVar = vA.get(i2);
            if (cVar != null) {
                ArrayList<String> arrayList = new ArrayList<>();
                if (cVar.vF().vM()) {
                    int size = pbData.zN().size();
                    this.bvu.bvr = false;
                    String str2 = "";
                    int i3 = i;
                    for (int i4 = 0; i4 < size; i4++) {
                        com.baidu.tieba.data.ak akVar = pbData.zN().get(i4);
                        com.baidu.tbadk.widget.richText.a Ah = akVar.Ah();
                        int size2 = arrayList.size();
                        i3 = this.bvu.a(Ah, K, i3, i, arrayList);
                        int size3 = arrayList.size();
                        if (size2 != size3) {
                            str2 = arrayList.get(size3 - 1);
                        }
                        ArrayList<com.baidu.tieba.data.ak> Af = akVar.Af();
                        int i5 = 0;
                        while (true) {
                            int i6 = i5;
                            if (i6 >= Af.size()) {
                                break;
                            }
                            i3 = this.bvu.a(Af.get(i6).Ah(), K, i3, i, arrayList);
                            i5 = i6 + 1;
                        }
                    }
                    String str3 = null;
                    String str4 = null;
                    String str5 = null;
                    boolean z = false;
                    if (pbData != null) {
                        if (pbData.zL() != null) {
                            str3 = pbData.zL().getName();
                            str4 = pbData.zL().getId();
                        }
                        if (pbData.zM() != null) {
                            str5 = pbData.zM().getId();
                        }
                        z = pbData.yW() == 1;
                    }
                    PbActivity pbActivity = this.bvu;
                    ImageViewerConfig imageViewerConfig = new ImageViewerConfig(this.bvu);
                    bnVar2 = this.bvu.buU;
                    pbActivity.sendMessage(new CustomMessage(2010000, imageViewerConfig.createConfig(arrayList, i3, str3, str4, str5, z, str2, bnVar2.WT())));
                    return;
                }
                b = this.bvu.b(cVar);
                arrayList.add(b);
                String str6 = null;
                String str7 = null;
                String str8 = null;
                boolean z2 = false;
                if (pbData != null) {
                    if (pbData.zL() != null) {
                        str6 = pbData.zL().getName();
                        str7 = pbData.zL().getId();
                    }
                    if (pbData.zM() != null) {
                        str8 = pbData.zM().getId();
                    }
                    z2 = pbData.yW() == 1;
                }
                PbActivity pbActivity2 = this.bvu;
                bnVar3 = this.bvu.buU;
                pbActivity2.sendMessage(new CustomMessage(2010000, new ImageViewerConfig(this.bvu).createConfig(arrayList, 0, str6, str7, str8, z2, arrayList.get(0), bnVar3.WT())));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
