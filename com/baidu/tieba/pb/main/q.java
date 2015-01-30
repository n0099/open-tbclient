package com.baidu.tieba.pb.main;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.ArrayList;
/* loaded from: classes.dex */
class q implements com.baidu.tbadk.widget.richText.s {
    final /* synthetic */ PbActivity bAT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(PbActivity pbActivity) {
        this.bAT = pbActivity;
    }

    @Override // com.baidu.tbadk.widget.richText.s
    public void onClick(View view, String str, int i) {
        bq bqVar;
        com.baidu.tbadk.widget.richText.a R;
        int i2;
        bq bqVar2;
        String b;
        bq bqVar3;
        try {
            TiebaStatic.eventStat(this.bAT.getPageContext().getPageActivity(), "pic_pb", "");
            bqVar = this.bAT.bAs;
            com.baidu.tieba.tbadkCore.b.i pbData = bqVar.getPbData();
            R = this.bAT.R(str, i);
            ArrayList<com.baidu.tbadk.widget.richText.c> Af = R.Af();
            i2 = this.bAT.bAP;
            com.baidu.tbadk.widget.richText.c cVar = Af.get(i2);
            if (cVar != null) {
                ArrayList<String> arrayList = new ArrayList<>();
                if (cVar.Ak().Ar()) {
                    int size = pbData.ahk().size();
                    this.bAT.bAQ = false;
                    String str2 = "";
                    int i3 = i;
                    for (int i4 = 0; i4 < size; i4++) {
                        com.baidu.tieba.tbadkCore.b.k kVar = pbData.ahk().get(i4);
                        com.baidu.tbadk.widget.richText.a ahz = kVar.ahz();
                        int size2 = arrayList.size();
                        i3 = this.bAT.a(ahz, R, i3, i, arrayList);
                        int size3 = arrayList.size();
                        if (size2 != size3) {
                            str2 = arrayList.get(size3 - 1);
                        }
                        ArrayList<com.baidu.tieba.tbadkCore.b.k> ahx = kVar.ahx();
                        int i5 = 0;
                        while (true) {
                            int i6 = i5;
                            if (i6 >= ahx.size()) {
                                break;
                            }
                            i3 = this.bAT.a(ahx.get(i6).ahz(), R, i3, i, arrayList);
                            i5 = i6 + 1;
                        }
                    }
                    String str3 = null;
                    String str4 = null;
                    String str5 = null;
                    boolean z = false;
                    if (pbData != null) {
                        if (pbData.aeN() != null) {
                            str3 = pbData.aeN().getName();
                            str4 = pbData.aeN().getId();
                        }
                        if (pbData.ahj() != null) {
                            str5 = pbData.ahj().getId();
                        }
                        z = pbData.CH() == 1;
                    }
                    PbActivity pbActivity = this.bAT;
                    ImageViewerConfig imageViewerConfig = new ImageViewerConfig(this.bAT.getPageContext().getPageActivity());
                    bqVar2 = this.bAT.bAs;
                    pbActivity.sendMessage(new CustomMessage(2010000, imageViewerConfig.createConfig(arrayList, i3, str3, str4, str5, z, str2, bqVar2.XV())));
                    return;
                }
                b = this.bAT.b(cVar);
                arrayList.add(b);
                String str6 = null;
                String str7 = null;
                String str8 = null;
                boolean z2 = false;
                if (pbData != null) {
                    if (pbData.aeN() != null) {
                        str6 = pbData.aeN().getName();
                        str7 = pbData.aeN().getId();
                    }
                    if (pbData.ahj() != null) {
                        str8 = pbData.ahj().getId();
                    }
                    z2 = pbData.CH() == 1;
                }
                PbActivity pbActivity2 = this.bAT;
                bqVar3 = this.bAT.bAs;
                pbActivity2.sendMessage(new CustomMessage(2010000, new ImageViewerConfig(this.bAT.getPageContext().getPageActivity()).createConfig(arrayList, 0, str6, str7, str8, z2, arrayList.get(0), bqVar3.XV())));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
