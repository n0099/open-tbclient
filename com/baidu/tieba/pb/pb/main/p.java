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
class p implements com.baidu.tbadk.widget.richText.s {
    final /* synthetic */ PbActivity bIv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(PbActivity pbActivity) {
        this.bIv = pbActivity;
    }

    @Override // com.baidu.tbadk.widget.richText.s
    public void onClick(View view, String str, int i) {
        bq bqVar;
        com.baidu.tbadk.widget.richText.a O;
        int i2;
        bq bqVar2;
        String b;
        boolean z;
        bq bqVar3;
        try {
            TiebaStatic.eventStat(this.bIv.getPageContext().getPageActivity(), "pic_pb", "");
            bqVar = this.bIv.bHT;
            com.baidu.tieba.pb.a.b pbData = bqVar.getPbData();
            O = this.bIv.O(str, i);
            ArrayList<com.baidu.tbadk.widget.richText.c> Dv = O.Dv();
            i2 = this.bIv.bIr;
            com.baidu.tbadk.widget.richText.c cVar = Dv.get(i2);
            if (cVar != null) {
                ArrayList<String> arrayList = new ArrayList<>();
                HashMap<String, ImageUrlData> hashMap = new HashMap<>();
                if (cVar.DA().DH()) {
                    int size = pbData.YQ().size();
                    this.bIv.bIs = false;
                    String str2 = "";
                    int i3 = i;
                    for (int i4 = 0; i4 < size; i4++) {
                        com.baidu.tieba.tbadkCore.c.j jVar = pbData.YQ().get(i4);
                        com.baidu.tbadk.widget.richText.a amB = jVar.amB();
                        int size2 = arrayList.size();
                        i3 = this.bIv.a(amB, O, i3, i, arrayList, hashMap);
                        int size3 = arrayList.size();
                        if (size2 != size3) {
                            str2 = arrayList.get(size3 - 1);
                        }
                        ArrayList<com.baidu.tieba.tbadkCore.c.j> amz = jVar.amz();
                        int i5 = 0;
                        while (true) {
                            int i6 = i5;
                            if (i6 >= amz.size()) {
                                break;
                            }
                            i3 = this.bIv.a(amz.get(i6).amB(), O, i3, i, arrayList, hashMap);
                            i5 = i6 + 1;
                        }
                    }
                    String str3 = null;
                    String str4 = null;
                    String str5 = null;
                    boolean z2 = false;
                    if (pbData != null) {
                        if (pbData.YO() != null) {
                            str3 = pbData.YO().getName();
                            str4 = pbData.YO().getId();
                        }
                        if (pbData.YP() != null) {
                            str5 = pbData.YP().getId();
                        }
                        z2 = pbData.YT() == 1;
                    }
                    PbActivity pbActivity = this.bIv;
                    ImageViewerConfig imageViewerConfig = new ImageViewerConfig(this.bIv.getPageContext().getPageActivity());
                    bqVar2 = this.bIv.bHT;
                    pbActivity.sendMessage(new CustomMessage(2010000, imageViewerConfig.createConfig(arrayList, i3, str3, str4, str5, z2, str2, bqVar2.ZY(), hashMap)));
                    return;
                }
                b = this.bIv.b(cVar);
                arrayList.add(b);
                ImageUrlData imageUrlData = new ImageUrlData();
                imageUrlData.imageUrl = str;
                z = this.bIv.mIsFromCDN;
                imageUrlData.urlType = z ? 17 : 18;
                hashMap.put(b, imageUrlData);
                String str6 = null;
                String str7 = null;
                String str8 = null;
                boolean z3 = false;
                if (pbData != null) {
                    if (pbData.YO() != null) {
                        str6 = pbData.YO().getName();
                        str7 = pbData.YO().getId();
                    }
                    if (pbData.YP() != null) {
                        str8 = pbData.YP().getId();
                    }
                    z3 = pbData.YT() == 1;
                }
                PbActivity pbActivity2 = this.bIv;
                bqVar3 = this.bIv.bHT;
                pbActivity2.sendMessage(new CustomMessage(2010000, new ImageViewerConfig(this.bIv.getPageContext().getPageActivity()).createConfig(arrayList, 0, str6, str7, str8, z3, arrayList.get(0), bqVar3.ZY(), hashMap)));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
