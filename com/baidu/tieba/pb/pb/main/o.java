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
class o implements com.baidu.tbadk.widget.richText.s {
    final /* synthetic */ PbActivity bKT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(PbActivity pbActivity) {
        this.bKT = pbActivity;
    }

    @Override // com.baidu.tbadk.widget.richText.s
    public void a(View view, String str, int i) {
        bo boVar;
        com.baidu.tbadk.widget.richText.a O;
        int i2;
        bo boVar2;
        String b;
        boolean z;
        bo boVar3;
        try {
            TiebaStatic.eventStat(this.bKT.getPageContext().getPageActivity(), "pic_pb", "");
            boVar = this.bKT.bKv;
            com.baidu.tieba.pb.a.b pbData = boVar.getPbData();
            O = this.bKT.O(str, i);
            ArrayList<com.baidu.tbadk.widget.richText.c> El = O.El();
            i2 = this.bKT.bKP;
            com.baidu.tbadk.widget.richText.c cVar = El.get(i2);
            if (cVar != null) {
                ArrayList<String> arrayList = new ArrayList<>();
                HashMap<String, ImageUrlData> hashMap = new HashMap<>();
                if (cVar.Eq().Ex()) {
                    int size = pbData.aat().size();
                    this.bKT.bKQ = false;
                    String str2 = "";
                    int i3 = i;
                    for (int i4 = 0; i4 < size; i4++) {
                        com.baidu.tieba.tbadkCore.data.j jVar = pbData.aat().get(i4);
                        com.baidu.tbadk.widget.richText.a aoC = jVar.aoC();
                        int size2 = arrayList.size();
                        i3 = this.bKT.a(aoC, O, i3, i, arrayList, hashMap);
                        int size3 = arrayList.size();
                        if (size2 != size3) {
                            str2 = arrayList.get(size3 - 1);
                        }
                        ArrayList<com.baidu.tieba.tbadkCore.data.j> aoA = jVar.aoA();
                        int i5 = 0;
                        while (true) {
                            int i6 = i5;
                            if (i6 >= aoA.size()) {
                                break;
                            }
                            i3 = this.bKT.a(aoA.get(i6).aoC(), O, i3, i, arrayList, hashMap);
                            i5 = i6 + 1;
                        }
                    }
                    String str3 = null;
                    String str4 = null;
                    String str5 = null;
                    boolean z2 = false;
                    if (pbData != null) {
                        if (pbData.aar() != null) {
                            str3 = pbData.aar().getName();
                            str4 = pbData.aar().getId();
                        }
                        if (pbData.aas() != null) {
                            str5 = pbData.aas().getId();
                        }
                        z2 = pbData.aaw() == 1;
                    }
                    PbActivity pbActivity = this.bKT;
                    ImageViewerConfig imageViewerConfig = new ImageViewerConfig(this.bKT.getPageContext().getPageActivity());
                    boVar2 = this.bKT.bKv;
                    pbActivity.sendMessage(new CustomMessage(2010000, imageViewerConfig.createConfig(arrayList, i3, str3, str4, str5, z2, str2, boVar2.abz(), hashMap)));
                    return;
                }
                b = this.bKT.b(cVar);
                arrayList.add(b);
                ImageUrlData imageUrlData = new ImageUrlData();
                imageUrlData.imageUrl = str;
                z = this.bKT.mIsFromCDN;
                imageUrlData.urlType = z ? 17 : 18;
                hashMap.put(b, imageUrlData);
                String str6 = null;
                String str7 = null;
                String str8 = null;
                boolean z3 = false;
                if (pbData != null) {
                    if (pbData.aar() != null) {
                        str6 = pbData.aar().getName();
                        str7 = pbData.aar().getId();
                    }
                    if (pbData.aas() != null) {
                        str8 = pbData.aas().getId();
                    }
                    z3 = pbData.aaw() == 1;
                }
                PbActivity pbActivity2 = this.bKT;
                boVar3 = this.bKT.bKv;
                pbActivity2.sendMessage(new CustomMessage(2010000, new ImageViewerConfig(this.bKT.getPageContext().getPageActivity()).createConfig(arrayList, 0, str6, str7, str8, z3, arrayList.get(0), boVar3.abz(), hashMap)));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
