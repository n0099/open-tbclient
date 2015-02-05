package com.baidu.tieba.pb.main;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.ArrayList;
/* loaded from: classes.dex */
class q implements com.baidu.tbadk.widget.richText.s {
    final /* synthetic */ PbActivity bAS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(PbActivity pbActivity) {
        this.bAS = pbActivity;
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
            TiebaStatic.eventStat(this.bAS.getPageContext().getPageActivity(), "pic_pb", "");
            bqVar = this.bAS.bAr;
            com.baidu.tieba.tbadkCore.b.i pbData = bqVar.getPbData();
            R = this.bAS.R(str, i);
            ArrayList<com.baidu.tbadk.widget.richText.c> zZ = R.zZ();
            i2 = this.bAS.bAO;
            com.baidu.tbadk.widget.richText.c cVar = zZ.get(i2);
            if (cVar != null) {
                ArrayList<String> arrayList = new ArrayList<>();
                if (cVar.Ae().Al()) {
                    int size = pbData.ahf().size();
                    this.bAS.bAP = false;
                    String str2 = "";
                    int i3 = i;
                    for (int i4 = 0; i4 < size; i4++) {
                        com.baidu.tieba.tbadkCore.b.k kVar = pbData.ahf().get(i4);
                        com.baidu.tbadk.widget.richText.a ahu = kVar.ahu();
                        int size2 = arrayList.size();
                        i3 = this.bAS.a(ahu, R, i3, i, arrayList);
                        int size3 = arrayList.size();
                        if (size2 != size3) {
                            str2 = arrayList.get(size3 - 1);
                        }
                        ArrayList<com.baidu.tieba.tbadkCore.b.k> ahs = kVar.ahs();
                        int i5 = 0;
                        while (true) {
                            int i6 = i5;
                            if (i6 >= ahs.size()) {
                                break;
                            }
                            i3 = this.bAS.a(ahs.get(i6).ahu(), R, i3, i, arrayList);
                            i5 = i6 + 1;
                        }
                    }
                    String str3 = null;
                    String str4 = null;
                    String str5 = null;
                    boolean z = false;
                    if (pbData != null) {
                        if (pbData.aeI() != null) {
                            str3 = pbData.aeI().getName();
                            str4 = pbData.aeI().getId();
                        }
                        if (pbData.ahe() != null) {
                            str5 = pbData.ahe().getId();
                        }
                        z = pbData.CB() == 1;
                    }
                    PbActivity pbActivity = this.bAS;
                    ImageViewerConfig imageViewerConfig = new ImageViewerConfig(this.bAS.getPageContext().getPageActivity());
                    bqVar2 = this.bAS.bAr;
                    pbActivity.sendMessage(new CustomMessage(2010000, imageViewerConfig.createConfig(arrayList, i3, str3, str4, str5, z, str2, bqVar2.XQ())));
                    return;
                }
                b = this.bAS.b(cVar);
                arrayList.add(b);
                String str6 = null;
                String str7 = null;
                String str8 = null;
                boolean z2 = false;
                if (pbData != null) {
                    if (pbData.aeI() != null) {
                        str6 = pbData.aeI().getName();
                        str7 = pbData.aeI().getId();
                    }
                    if (pbData.ahe() != null) {
                        str8 = pbData.ahe().getId();
                    }
                    z2 = pbData.CB() == 1;
                }
                PbActivity pbActivity2 = this.bAS;
                bqVar3 = this.bAS.bAr;
                pbActivity2.sendMessage(new CustomMessage(2010000, new ImageViewerConfig(this.bAS.getPageContext().getPageActivity()).createConfig(arrayList, 0, str6, str7, str8, z2, arrayList.get(0), bqVar3.XQ())));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
