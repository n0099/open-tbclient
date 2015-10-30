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
class r implements TbRichTextView.c {
    final /* synthetic */ PbActivity ciK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(PbActivity pbActivity) {
        this.ciK = pbActivity;
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.c
    public void a(View view, String str, int i) {
        bl blVar;
        com.baidu.tbadk.widget.richText.a W;
        int i2;
        bl blVar2;
        String d;
        boolean z;
        String b;
        long c;
        bl blVar3;
        try {
            TiebaStatic.eventStat(this.ciK.getPageContext().getPageActivity(), "pic_pb", "");
            blVar = this.ciK.cih;
            com.baidu.tieba.pb.a.b pbData = blVar.getPbData();
            W = this.ciK.W(str, i);
            ArrayList<com.baidu.tbadk.widget.richText.c> EP = W.EP();
            i2 = this.ciK.ciG;
            com.baidu.tbadk.widget.richText.c cVar = EP.get(i2);
            if (cVar != null) {
                ArrayList<String> arrayList = new ArrayList<>();
                HashMap<String, ImageUrlData> hashMap = new HashMap<>();
                if (cVar.EU().Fc()) {
                    int size = pbData.aeL().size();
                    this.ciK.ciH = false;
                    String str2 = "";
                    int i3 = i;
                    for (int i4 = 0; i4 < size; i4++) {
                        com.baidu.tieba.tbadkCore.data.k kVar = pbData.aeL().get(i4);
                        com.baidu.tbadk.widget.richText.a awF = kVar.awF();
                        int size2 = arrayList.size();
                        i3 = this.ciK.a(awF, W, i3, i, arrayList, hashMap);
                        int size3 = arrayList.size();
                        if (size2 != size3) {
                            str2 = arrayList.get(size3 - 1);
                        }
                        ArrayList<com.baidu.tieba.tbadkCore.data.k> awD = kVar.awD();
                        int i5 = 0;
                        while (true) {
                            int i6 = i5;
                            if (i6 >= awD.size()) {
                                break;
                            }
                            i3 = this.ciK.a(awD.get(i6).awF(), W, i3, i, arrayList, hashMap);
                            i5 = i6 + 1;
                        }
                    }
                    String str3 = null;
                    String str4 = null;
                    String str5 = null;
                    boolean z2 = false;
                    if (pbData != null) {
                        if (pbData.aeJ() != null) {
                            str3 = pbData.aeJ().getName();
                            str4 = pbData.aeJ().getId();
                        }
                        if (pbData.aeK() != null) {
                            str5 = pbData.aeK().getId();
                        }
                        z2 = pbData.aeP() == 1;
                    }
                    ImageViewerConfig imageViewerConfig = new ImageViewerConfig(this.ciK.getPageContext().getPageActivity());
                    blVar2 = this.ciK.cih;
                    ImageViewerConfig createConfig = imageViewerConfig.createConfig(arrayList, i3, str3, str4, str5, z2, str2, blVar2.afQ(), hashMap, true);
                    createConfig.getIntent().putExtra("from", "pb");
                    this.ciK.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
                    return;
                }
                d = this.ciK.d(cVar);
                arrayList.add(d);
                ImageUrlData imageUrlData = new ImageUrlData();
                imageUrlData.imageUrl = str;
                z = this.ciK.mIsFromCDN;
                imageUrlData.urlType = z ? 17 : 18;
                b = this.ciK.b(cVar);
                imageUrlData.originalUrl = b;
                c = this.ciK.c(cVar);
                imageUrlData.originalSize = c;
                hashMap.put(d, imageUrlData);
                String str6 = null;
                String str7 = null;
                String str8 = null;
                boolean z3 = false;
                if (pbData != null) {
                    if (pbData.aeJ() != null) {
                        str6 = pbData.aeJ().getName();
                        str7 = pbData.aeJ().getId();
                    }
                    if (pbData.aeK() != null) {
                        str8 = pbData.aeK().getId();
                    }
                    z3 = pbData.aeP() == 1;
                }
                blVar3 = this.ciK.cih;
                ImageViewerConfig createConfig2 = new ImageViewerConfig(this.ciK.getPageContext().getPageActivity()).createConfig(arrayList, 0, str6, str7, str8, z3, arrayList.get(0), blVar3.afQ(), hashMap, true);
                createConfig2.getIntent().putExtra("from", "pb");
                this.ciK.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig2));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
