package com.baidu.tieba.pb.pb.sub;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import java.util.ArrayList;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements TbRichTextView.d {
    final /* synthetic */ NewSubPbActivity cnS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(NewSubPbActivity newSubPbActivity) {
        this.cnS = newSubPbActivity;
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.d
    public void a(View view, String str, int i) {
        am amVar;
        com.baidu.tbadk.widget.richText.a W;
        int i2;
        int a;
        String str2;
        String d;
        boolean z;
        String str3;
        try {
            amVar = this.cnS.cnH;
            com.baidu.tieba.pb.a.d aic = amVar.aic();
            W = this.cnS.W(str, i);
            ArrayList<com.baidu.tbadk.widget.richText.c> EI = W.EI();
            i2 = this.cnS.cjJ;
            com.baidu.tbadk.widget.richText.c cVar = EI.get(i2);
            if (cVar != null) {
                ArrayList<String> arrayList = new ArrayList<>();
                HashMap<String, ImageUrlData> hashMap = new HashMap<>();
                if (cVar.EN().EX()) {
                    this.cnS.cjK = false;
                    String str4 = "";
                    com.baidu.tieba.tbadkCore.data.o afs = aic.afs();
                    com.baidu.tbadk.widget.richText.a axu = afs.axu();
                    int size = arrayList.size();
                    a = this.cnS.a(axu, W, i, i, arrayList, hashMap);
                    int size2 = arrayList.size();
                    if (size != size2) {
                        str4 = arrayList.get(size2 - 1);
                    }
                    ArrayList<com.baidu.tieba.tbadkCore.data.o> axs = afs.axs();
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= axs.size()) {
                            break;
                        }
                        a = this.cnS.a(axs.get(i4).axu(), W, a, i, arrayList, hashMap);
                        i3 = i4 + 1;
                    }
                    String str5 = null;
                    String str6 = null;
                    String str7 = null;
                    boolean z2 = false;
                    if (aic == null) {
                        str2 = null;
                    } else {
                        if (aic.afz() != null) {
                            str5 = aic.afz().getName();
                            str6 = aic.afz().getId();
                        }
                        if (aic.afB() != null) {
                            str7 = aic.afB().getId();
                        }
                        z2 = true;
                        str2 = str7;
                    }
                    this.cnS.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(this.cnS.getPageContext().getPageActivity()).createConfig(arrayList, a, str5, str6, str2, z2, str4, true, hashMap, false, true)));
                    return;
                }
                d = this.cnS.d(cVar);
                arrayList.add(d);
                ImageUrlData imageUrlData = new ImageUrlData();
                imageUrlData.imageUrl = str;
                z = this.cnS.mIsFromCDN;
                imageUrlData.urlType = z ? 17 : 18;
                hashMap.put(d, imageUrlData);
                String str8 = null;
                String str9 = null;
                String str10 = null;
                boolean z3 = false;
                if (aic == null) {
                    str3 = null;
                } else {
                    if (aic.afz() != null) {
                        str8 = aic.afz().getName();
                        str9 = aic.afz().getId();
                    }
                    if (aic.afB() != null) {
                        str10 = aic.afB().getId();
                    }
                    z3 = true;
                    str3 = str10;
                }
                this.cnS.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(this.cnS.getPageContext().getPageActivity()).createConfig(arrayList, 0, str8, str9, str3, z3, arrayList.get(0), true, hashMap, false, true)));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
