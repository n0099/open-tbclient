package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
class u implements TbRichTextView.d {
    final /* synthetic */ PbActivity cjN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(PbActivity pbActivity) {
        this.cjN = pbActivity;
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.d
    public void a(View view, String str, int i) {
        ca caVar;
        com.baidu.tbadk.widget.richText.a W;
        int i2;
        ca caVar2;
        String d;
        boolean z;
        String b;
        long c;
        ca caVar3;
        try {
            TiebaStatic.eventStat(this.cjN.getPageContext().getPageActivity(), "pic_pb", "");
            caVar = this.cjN.cjj;
            com.baidu.tieba.pb.a.c pbData = caVar.getPbData();
            W = this.cjN.W(str, i);
            ArrayList<com.baidu.tbadk.widget.richText.c> EI = W.EI();
            i2 = this.cjN.cjJ;
            com.baidu.tbadk.widget.richText.c cVar = EI.get(i2);
            if (cVar != null) {
                ArrayList<String> arrayList = new ArrayList<>();
                HashMap<String, ImageUrlData> hashMap = new HashMap<>();
                if (cVar.EN().EX()) {
                    int size = pbData.afi().size();
                    this.cjN.cjK = false;
                    String str2 = "";
                    int i3 = i;
                    for (int i4 = 0; i4 < size; i4++) {
                        com.baidu.tieba.tbadkCore.data.o oVar = pbData.afi().get(i4);
                        com.baidu.tbadk.widget.richText.a axu = oVar.axu();
                        int size2 = arrayList.size();
                        i3 = this.cjN.a(axu, W, i3, i, arrayList, hashMap);
                        int size3 = arrayList.size();
                        if (size2 != size3) {
                            str2 = arrayList.get(size3 - 1);
                        }
                        ArrayList<com.baidu.tieba.tbadkCore.data.o> axs = oVar.axs();
                        int i5 = 0;
                        while (true) {
                            int i6 = i5;
                            if (i6 >= axs.size()) {
                                break;
                            }
                            i3 = this.cjN.a(axs.get(i6).axu(), W, i3, i, arrayList, hashMap);
                            i5 = i6 + 1;
                        }
                    }
                    String str3 = null;
                    String str4 = null;
                    String str5 = null;
                    boolean z2 = false;
                    if (pbData != null) {
                        if (pbData.afg() != null) {
                            str3 = pbData.afg().getName();
                            str4 = pbData.afg().getId();
                        }
                        if (pbData.afh() != null) {
                            str5 = pbData.afh().getId();
                        }
                        z2 = pbData.afm() == 1;
                    }
                    ImageViewerConfig imageViewerConfig = new ImageViewerConfig(this.cjN.getPageContext().getPageActivity());
                    caVar2 = this.cjN.cjj;
                    ImageViewerConfig createConfig = imageViewerConfig.createConfig(arrayList, i3, str3, str4, str5, z2, str2, caVar2.agv(), hashMap, true);
                    createConfig.getIntent().putExtra("from", "pb");
                    this.cjN.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
                    return;
                }
                d = this.cjN.d(cVar);
                arrayList.add(d);
                ImageUrlData imageUrlData = new ImageUrlData();
                imageUrlData.imageUrl = str;
                z = this.cjN.mIsFromCDN;
                imageUrlData.urlType = z ? 17 : 18;
                b = this.cjN.b(cVar);
                imageUrlData.originalUrl = b;
                c = this.cjN.c(cVar);
                imageUrlData.originalSize = c;
                hashMap.put(d, imageUrlData);
                String str6 = null;
                String str7 = null;
                String str8 = null;
                boolean z3 = false;
                if (pbData != null) {
                    if (pbData.afg() != null) {
                        str6 = pbData.afg().getName();
                        str7 = pbData.afg().getId();
                    }
                    if (pbData.afh() != null) {
                        str8 = pbData.afh().getId();
                    }
                    z3 = pbData.afm() == 1;
                }
                caVar3 = this.cjN.cjj;
                ImageViewerConfig createConfig2 = new ImageViewerConfig(this.cjN.getPageContext().getPageActivity()).createConfig(arrayList, 0, str6, str7, str8, z3, arrayList.get(0), caVar3.agv(), hashMap, true);
                createConfig2.getIntent().putExtra("from", "pb");
                this.cjN.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig2));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
