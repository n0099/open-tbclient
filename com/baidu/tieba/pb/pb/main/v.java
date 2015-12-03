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
class v implements TbRichTextView.d {
    final /* synthetic */ PbActivity cCm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(PbActivity pbActivity) {
        this.cCm = pbActivity;
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.d
    public void a(View view, String str, int i) {
        cc ccVar;
        com.baidu.tbadk.widget.richText.a ac;
        int i2;
        cc ccVar2;
        cc ccVar3;
        String d;
        boolean z;
        String b;
        long c;
        cc ccVar4;
        cc ccVar5;
        try {
            TiebaStatic.eventStat(this.cCm.getPageContext().getPageActivity(), "pic_pb", "");
            ccVar = this.cCm.cBG;
            com.baidu.tieba.pb.a.c pbData = ccVar.getPbData();
            ac = this.cCm.ac(str, i);
            ArrayList<com.baidu.tbadk.widget.richText.c> FL = ac.FL();
            i2 = this.cCm.cCg;
            com.baidu.tbadk.widget.richText.c cVar = FL.get(i2);
            if (cVar != null) {
                ArrayList<String> arrayList = new ArrayList<>();
                HashMap<String, ImageUrlData> hashMap = new HashMap<>();
                if (cVar.FQ().Ga()) {
                    int size = pbData.ajA().size();
                    this.cCm.cCh = false;
                    String str2 = "";
                    int i3 = i;
                    for (int i4 = 0; i4 < size; i4++) {
                        com.baidu.tieba.tbadkCore.data.o oVar = pbData.ajA().get(i4);
                        com.baidu.tbadk.widget.richText.a aDe = oVar.aDe();
                        int size2 = arrayList.size();
                        i3 = this.cCm.a(aDe, ac, i3, i, arrayList, hashMap);
                        int size3 = arrayList.size();
                        if (size2 != size3) {
                            str2 = arrayList.get(size3 - 1);
                        }
                        ArrayList<com.baidu.tieba.tbadkCore.data.o> aDc = oVar.aDc();
                        int i5 = 0;
                        while (true) {
                            int i6 = i5;
                            if (i6 >= aDc.size()) {
                                break;
                            }
                            i3 = this.cCm.a(aDc.get(i6).aDe(), ac, i3, i, arrayList, hashMap);
                            i5 = i6 + 1;
                        }
                    }
                    String str3 = null;
                    String str4 = null;
                    String str5 = null;
                    boolean z2 = false;
                    if (pbData != null) {
                        if (pbData.ajy() != null) {
                            str3 = pbData.ajy().getName();
                            str4 = pbData.ajy().getId();
                        }
                        if (pbData.ajz() != null) {
                            str5 = pbData.ajz().getId();
                        }
                        z2 = pbData.ajE() == 1;
                    }
                    ImageViewerConfig imageViewerConfig = new ImageViewerConfig(this.cCm.getPageContext().getPageActivity());
                    ccVar2 = this.cCm.cBG;
                    boolean akP = ccVar2.akP();
                    ccVar3 = this.cCm.cBG;
                    ImageViewerConfig createConfig = imageViewerConfig.createConfig(arrayList, i3, str3, str4, str5, z2, str2, akP, hashMap, true, false, ccVar3.getHostMode());
                    createConfig.getIntent().putExtra("from", "pb");
                    this.cCm.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
                    return;
                }
                d = this.cCm.d(cVar);
                arrayList.add(d);
                ImageUrlData imageUrlData = new ImageUrlData();
                imageUrlData.imageUrl = str;
                z = this.cCm.mIsFromCDN;
                imageUrlData.urlType = z ? 17 : 18;
                b = this.cCm.b(cVar);
                imageUrlData.originalUrl = b;
                c = this.cCm.c(cVar);
                imageUrlData.originalSize = c;
                hashMap.put(d, imageUrlData);
                String str6 = null;
                String str7 = null;
                String str8 = null;
                boolean z3 = false;
                if (pbData != null) {
                    if (pbData.ajy() != null) {
                        str6 = pbData.ajy().getName();
                        str7 = pbData.ajy().getId();
                    }
                    if (pbData.ajz() != null) {
                        str8 = pbData.ajz().getId();
                    }
                    z3 = pbData.ajE() == 1;
                }
                ccVar4 = this.cCm.cBG;
                boolean akP2 = ccVar4.akP();
                ccVar5 = this.cCm.cBG;
                ImageViewerConfig createConfig2 = new ImageViewerConfig(this.cCm.getPageContext().getPageActivity()).createConfig(arrayList, 0, str6, str7, str8, z3, arrayList.get(0), akP2, hashMap, true, false, ccVar5.getHostMode());
                createConfig2.getIntent().putExtra("from", "pb");
                this.cCm.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig2));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
