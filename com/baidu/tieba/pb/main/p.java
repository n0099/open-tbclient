package com.baidu.tieba.pb.main;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.ArrayList;
/* loaded from: classes.dex */
class p implements com.baidu.tbadk.widget.richText.s {
    final /* synthetic */ PbActivity bzj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(PbActivity pbActivity) {
        this.bzj = pbActivity;
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
            TiebaStatic.eventStat(this.bzj.getPageContext().getPageActivity(), "pic_pb", "");
            bqVar = this.bzj.byJ;
            com.baidu.tieba.tbadkCore.b.i pbData = bqVar.getPbData();
            R = this.bzj.R(str, i);
            ArrayList<com.baidu.tbadk.widget.richText.c> zL = R.zL();
            i2 = this.bzj.bzf;
            com.baidu.tbadk.widget.richText.c cVar = zL.get(i2);
            if (cVar != null) {
                ArrayList<String> arrayList = new ArrayList<>();
                if (cVar.zQ().zX()) {
                    int size = pbData.agF().size();
                    this.bzj.bzg = false;
                    String str2 = "";
                    int i3 = i;
                    for (int i4 = 0; i4 < size; i4++) {
                        com.baidu.tieba.tbadkCore.b.k kVar = pbData.agF().get(i4);
                        com.baidu.tbadk.widget.richText.a agU = kVar.agU();
                        int size2 = arrayList.size();
                        i3 = this.bzj.a(agU, R, i3, i, arrayList);
                        int size3 = arrayList.size();
                        if (size2 != size3) {
                            str2 = arrayList.get(size3 - 1);
                        }
                        ArrayList<com.baidu.tieba.tbadkCore.b.k> agS = kVar.agS();
                        int i5 = 0;
                        while (true) {
                            int i6 = i5;
                            if (i6 >= agS.size()) {
                                break;
                            }
                            i3 = this.bzj.a(agS.get(i6).agU(), R, i3, i, arrayList);
                            i5 = i6 + 1;
                        }
                    }
                    String str3 = null;
                    String str4 = null;
                    String str5 = null;
                    boolean z = false;
                    if (pbData != null) {
                        if (pbData.aej() != null) {
                            str3 = pbData.aej().getName();
                            str4 = pbData.aej().getId();
                        }
                        if (pbData.agE() != null) {
                            str5 = pbData.agE().getId();
                        }
                        z = pbData.Ci() == 1;
                    }
                    PbActivity pbActivity = this.bzj;
                    ImageViewerConfig imageViewerConfig = new ImageViewerConfig(this.bzj.getPageContext().getPageActivity());
                    bqVar2 = this.bzj.byJ;
                    pbActivity.sendMessage(new CustomMessage(2010000, imageViewerConfig.createConfig(arrayList, i3, str3, str4, str5, z, str2, bqVar2.Xq())));
                    return;
                }
                b = this.bzj.b(cVar);
                arrayList.add(b);
                String str6 = null;
                String str7 = null;
                String str8 = null;
                boolean z2 = false;
                if (pbData != null) {
                    if (pbData.aej() != null) {
                        str6 = pbData.aej().getName();
                        str7 = pbData.aej().getId();
                    }
                    if (pbData.agE() != null) {
                        str8 = pbData.agE().getId();
                    }
                    z2 = pbData.Ci() == 1;
                }
                PbActivity pbActivity2 = this.bzj;
                bqVar3 = this.bzj.byJ;
                pbActivity2.sendMessage(new CustomMessage(2010000, new ImageViewerConfig(this.bzj.getPageContext().getPageActivity()).createConfig(arrayList, 0, str6, str7, str8, z2, arrayList.get(0), bqVar3.Xq())));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
