package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
class q implements com.baidu.tbadk.widget.richText.s {
    final /* synthetic */ PbActivity bIJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(PbActivity pbActivity) {
        this.bIJ = pbActivity;
    }

    @Override // com.baidu.tbadk.widget.richText.s
    public void onClick(View view, String str, int i) {
        br brVar;
        com.baidu.tbadk.widget.richText.a O;
        int i2;
        br brVar2;
        String b;
        boolean z;
        br brVar3;
        try {
            TiebaStatic.eventStat(this.bIJ.getPageContext().getPageActivity(), "pic_pb", "");
            brVar = this.bIJ.bIg;
            com.baidu.tieba.pb.a.b pbData = brVar.getPbData();
            O = this.bIJ.O(str, i);
            ArrayList<com.baidu.tbadk.widget.richText.c> DB = O.DB();
            i2 = this.bIJ.bIF;
            com.baidu.tbadk.widget.richText.c cVar = DB.get(i2);
            if (cVar != null) {
                ArrayList<String> arrayList = new ArrayList<>();
                HashMap<String, ImageUrlData> hashMap = new HashMap<>();
                if (cVar.DG().DN()) {
                    int size = pbData.Zc().size();
                    this.bIJ.bIG = false;
                    String str2 = "";
                    int i3 = i;
                    for (int i4 = 0; i4 < size; i4++) {
                        com.baidu.tieba.tbadkCore.c.j jVar = pbData.Zc().get(i4);
                        com.baidu.tbadk.widget.richText.a amQ = jVar.amQ();
                        int size2 = arrayList.size();
                        i3 = this.bIJ.a(amQ, O, i3, i, arrayList, hashMap);
                        int size3 = arrayList.size();
                        if (size2 != size3) {
                            str2 = arrayList.get(size3 - 1);
                        }
                        ArrayList<com.baidu.tieba.tbadkCore.c.j> amO = jVar.amO();
                        int i5 = 0;
                        while (true) {
                            int i6 = i5;
                            if (i6 >= amO.size()) {
                                break;
                            }
                            i3 = this.bIJ.a(amO.get(i6).amQ(), O, i3, i, arrayList, hashMap);
                            i5 = i6 + 1;
                        }
                    }
                    String str3 = null;
                    String str4 = null;
                    String str5 = null;
                    boolean z2 = false;
                    if (pbData != null) {
                        if (pbData.Za() != null) {
                            str3 = pbData.Za().getName();
                            str4 = pbData.Za().getId();
                        }
                        if (pbData.Zb() != null) {
                            str5 = pbData.Zb().getId();
                        }
                        z2 = pbData.Zf() == 1;
                    }
                    PbActivity pbActivity = this.bIJ;
                    ImageViewerConfig imageViewerConfig = new ImageViewerConfig(this.bIJ.getPageContext().getPageActivity());
                    brVar2 = this.bIJ.bIg;
                    pbActivity.sendMessage(new CustomMessage(2010000, imageViewerConfig.createConfig(arrayList, i3, str3, str4, str5, z2, str2, brVar2.aal(), hashMap)));
                    return;
                }
                b = this.bIJ.b(cVar);
                arrayList.add(b);
                ImageUrlData imageUrlData = new ImageUrlData();
                imageUrlData.imageUrl = str;
                z = this.bIJ.mIsFromCDN;
                imageUrlData.urlType = z ? 17 : 18;
                hashMap.put(b, imageUrlData);
                String str6 = null;
                String str7 = null;
                String str8 = null;
                boolean z3 = false;
                if (pbData != null) {
                    if (pbData.Za() != null) {
                        str6 = pbData.Za().getName();
                        str7 = pbData.Za().getId();
                    }
                    if (pbData.Zb() != null) {
                        str8 = pbData.Zb().getId();
                    }
                    z3 = pbData.Zf() == 1;
                }
                PbActivity pbActivity2 = this.bIJ;
                brVar3 = this.bIJ.bIg;
                pbActivity2.sendMessage(new CustomMessage(2010000, new ImageViewerConfig(this.bIJ.getPageContext().getPageActivity()).createConfig(arrayList, 0, str6, str7, str8, z3, arrayList.get(0), brVar3.aal(), hashMap)));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
