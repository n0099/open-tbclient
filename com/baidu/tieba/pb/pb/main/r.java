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
    final /* synthetic */ PbActivity ccj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(PbActivity pbActivity) {
        this.ccj = pbActivity;
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.c
    public void a(View view, String str, int i) {
        bk bkVar;
        com.baidu.tbadk.widget.richText.a T;
        int i2;
        bk bkVar2;
        String b;
        boolean z;
        bk bkVar3;
        try {
            TiebaStatic.eventStat(this.ccj.getPageContext().getPageActivity(), "pic_pb", "");
            bkVar = this.ccj.cbG;
            com.baidu.tieba.pb.a.b pbData = bkVar.getPbData();
            T = this.ccj.T(str, i);
            ArrayList<com.baidu.tbadk.widget.richText.c> Fg = T.Fg();
            i2 = this.ccj.ccf;
            com.baidu.tbadk.widget.richText.c cVar = Fg.get(i2);
            if (cVar != null) {
                ArrayList<String> arrayList = new ArrayList<>();
                HashMap<String, ImageUrlData> hashMap = new HashMap<>();
                if (cVar.Fl().Ft()) {
                    int size = pbData.acR().size();
                    this.ccj.ccg = false;
                    String str2 = "";
                    int i3 = i;
                    for (int i4 = 0; i4 < size; i4++) {
                        com.baidu.tieba.tbadkCore.data.i iVar = pbData.acR().get(i4);
                        com.baidu.tbadk.widget.richText.a auk = iVar.auk();
                        int size2 = arrayList.size();
                        i3 = this.ccj.a(auk, T, i3, i, arrayList, hashMap);
                        int size3 = arrayList.size();
                        if (size2 != size3) {
                            str2 = arrayList.get(size3 - 1);
                        }
                        ArrayList<com.baidu.tieba.tbadkCore.data.i> aui = iVar.aui();
                        int i5 = 0;
                        while (true) {
                            int i6 = i5;
                            if (i6 >= aui.size()) {
                                break;
                            }
                            i3 = this.ccj.a(aui.get(i6).auk(), T, i3, i, arrayList, hashMap);
                            i5 = i6 + 1;
                        }
                    }
                    String str3 = null;
                    String str4 = null;
                    String str5 = null;
                    boolean z2 = false;
                    if (pbData != null) {
                        if (pbData.acP() != null) {
                            str3 = pbData.acP().getName();
                            str4 = pbData.acP().getId();
                        }
                        if (pbData.acQ() != null) {
                            str5 = pbData.acQ().getId();
                        }
                        z2 = pbData.acV() == 1;
                    }
                    PbActivity pbActivity = this.ccj;
                    ImageViewerConfig imageViewerConfig = new ImageViewerConfig(this.ccj.getPageContext().getPageActivity());
                    bkVar2 = this.ccj.cbG;
                    pbActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, imageViewerConfig.createConfig(arrayList, i3, str3, str4, str5, z2, str2, bkVar2.adW(), hashMap)));
                    return;
                }
                b = this.ccj.b(cVar);
                arrayList.add(b);
                ImageUrlData imageUrlData = new ImageUrlData();
                imageUrlData.imageUrl = str;
                z = this.ccj.mIsFromCDN;
                imageUrlData.urlType = z ? 17 : 18;
                hashMap.put(b, imageUrlData);
                String str6 = null;
                String str7 = null;
                String str8 = null;
                boolean z3 = false;
                if (pbData != null) {
                    if (pbData.acP() != null) {
                        str6 = pbData.acP().getName();
                        str7 = pbData.acP().getId();
                    }
                    if (pbData.acQ() != null) {
                        str8 = pbData.acQ().getId();
                    }
                    z3 = pbData.acV() == 1;
                }
                PbActivity pbActivity2 = this.ccj;
                bkVar3 = this.ccj.cbG;
                pbActivity2.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(this.ccj.getPageContext().getPageActivity()).createConfig(arrayList, 0, str6, str7, str8, z3, arrayList.get(0), bkVar3.adW(), hashMap)));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
