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
    final /* synthetic */ PbActivity cbo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(PbActivity pbActivity) {
        this.cbo = pbActivity;
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.c
    public void a(View view, String str, int i) {
        bk bkVar;
        com.baidu.tbadk.widget.richText.a S;
        int i2;
        bk bkVar2;
        String b;
        boolean z;
        bk bkVar3;
        try {
            TiebaStatic.eventStat(this.cbo.getPageContext().getPageActivity(), "pic_pb", "");
            bkVar = this.cbo.caL;
            com.baidu.tieba.pb.a.b pbData = bkVar.getPbData();
            S = this.cbo.S(str, i);
            ArrayList<com.baidu.tbadk.widget.richText.c> EW = S.EW();
            i2 = this.cbo.cbk;
            com.baidu.tbadk.widget.richText.c cVar = EW.get(i2);
            if (cVar != null) {
                ArrayList<String> arrayList = new ArrayList<>();
                HashMap<String, ImageUrlData> hashMap = new HashMap<>();
                if (cVar.Fb().Fj()) {
                    int size = pbData.acI().size();
                    this.cbo.cbl = false;
                    String str2 = "";
                    int i3 = i;
                    for (int i4 = 0; i4 < size; i4++) {
                        com.baidu.tieba.tbadkCore.data.i iVar = pbData.acI().get(i4);
                        com.baidu.tbadk.widget.richText.a apW = iVar.apW();
                        int size2 = arrayList.size();
                        i3 = this.cbo.a(apW, S, i3, i, arrayList, hashMap);
                        int size3 = arrayList.size();
                        if (size2 != size3) {
                            str2 = arrayList.get(size3 - 1);
                        }
                        ArrayList<com.baidu.tieba.tbadkCore.data.i> apU = iVar.apU();
                        int i5 = 0;
                        while (true) {
                            int i6 = i5;
                            if (i6 >= apU.size()) {
                                break;
                            }
                            i3 = this.cbo.a(apU.get(i6).apW(), S, i3, i, arrayList, hashMap);
                            i5 = i6 + 1;
                        }
                    }
                    String str3 = null;
                    String str4 = null;
                    String str5 = null;
                    boolean z2 = false;
                    if (pbData != null) {
                        if (pbData.acG() != null) {
                            str3 = pbData.acG().getName();
                            str4 = pbData.acG().getId();
                        }
                        if (pbData.acH() != null) {
                            str5 = pbData.acH().getId();
                        }
                        z2 = pbData.acL() == 1;
                    }
                    PbActivity pbActivity = this.cbo;
                    ImageViewerConfig imageViewerConfig = new ImageViewerConfig(this.cbo.getPageContext().getPageActivity());
                    bkVar2 = this.cbo.caL;
                    pbActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, imageViewerConfig.createConfig(arrayList, i3, str3, str4, str5, z2, str2, bkVar2.adI(), hashMap)));
                    return;
                }
                b = this.cbo.b(cVar);
                arrayList.add(b);
                ImageUrlData imageUrlData = new ImageUrlData();
                imageUrlData.imageUrl = str;
                z = this.cbo.mIsFromCDN;
                imageUrlData.urlType = z ? 17 : 18;
                hashMap.put(b, imageUrlData);
                String str6 = null;
                String str7 = null;
                String str8 = null;
                boolean z3 = false;
                if (pbData != null) {
                    if (pbData.acG() != null) {
                        str6 = pbData.acG().getName();
                        str7 = pbData.acG().getId();
                    }
                    if (pbData.acH() != null) {
                        str8 = pbData.acH().getId();
                    }
                    z3 = pbData.acL() == 1;
                }
                PbActivity pbActivity2 = this.cbo;
                bkVar3 = this.cbo.caL;
                pbActivity2.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(this.cbo.getPageContext().getPageActivity()).createConfig(arrayList, 0, str6, str7, str8, z3, arrayList.get(0), bkVar3.adI(), hashMap)));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
