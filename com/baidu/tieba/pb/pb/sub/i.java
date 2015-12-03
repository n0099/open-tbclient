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
public class i implements TbRichTextView.d {
    final /* synthetic */ NewSubPbActivity cHd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(NewSubPbActivity newSubPbActivity) {
        this.cHd = newSubPbActivity;
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.d
    public void a(View view, String str, int i) {
        an anVar;
        com.baidu.tbadk.widget.richText.a ac;
        int i2;
        int a;
        String str2;
        String d;
        boolean z;
        String str3;
        try {
            anVar = this.cHd.cGS;
            com.baidu.tieba.pb.a.d amF = anVar.amF();
            ac = this.cHd.ac(str, i);
            ArrayList<com.baidu.tbadk.widget.richText.c> FL = ac.FL();
            i2 = this.cHd.cCg;
            com.baidu.tbadk.widget.richText.c cVar = FL.get(i2);
            if (cVar != null) {
                ArrayList<String> arrayList = new ArrayList<>();
                HashMap<String, ImageUrlData> hashMap = new HashMap<>();
                if (cVar.FQ().Ga()) {
                    this.cHd.cCh = false;
                    String str4 = "";
                    com.baidu.tieba.tbadkCore.data.o ajK = amF.ajK();
                    com.baidu.tbadk.widget.richText.a aDe = ajK.aDe();
                    int size = arrayList.size();
                    a = this.cHd.a(aDe, ac, i, i, arrayList, hashMap);
                    int size2 = arrayList.size();
                    if (size != size2) {
                        str4 = arrayList.get(size2 - 1);
                    }
                    ArrayList<com.baidu.tieba.tbadkCore.data.o> aDc = ajK.aDc();
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= aDc.size()) {
                            break;
                        }
                        a = this.cHd.a(aDc.get(i4).aDe(), ac, a, i, arrayList, hashMap);
                        i3 = i4 + 1;
                    }
                    String str5 = null;
                    String str6 = null;
                    String str7 = null;
                    boolean z2 = false;
                    if (amF == null) {
                        str2 = null;
                    } else {
                        if (amF.ajR() != null) {
                            str5 = amF.ajR().getName();
                            str6 = amF.ajR().getId();
                        }
                        if (amF.ajT() != null) {
                            str7 = amF.ajT().getId();
                        }
                        z2 = true;
                        str2 = str7;
                    }
                    this.cHd.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(this.cHd.getPageContext().getPageActivity()).createConfig(arrayList, a, str5, str6, str2, z2, str4, true, hashMap, false, true, false)));
                    return;
                }
                d = this.cHd.d(cVar);
                arrayList.add(d);
                ImageUrlData imageUrlData = new ImageUrlData();
                imageUrlData.imageUrl = str;
                z = this.cHd.mIsFromCDN;
                imageUrlData.urlType = z ? 17 : 18;
                hashMap.put(d, imageUrlData);
                String str8 = null;
                String str9 = null;
                String str10 = null;
                boolean z3 = false;
                if (amF == null) {
                    str3 = null;
                } else {
                    if (amF.ajR() != null) {
                        str8 = amF.ajR().getName();
                        str9 = amF.ajR().getId();
                    }
                    if (amF.ajT() != null) {
                        str10 = amF.ajT().getId();
                    }
                    z3 = true;
                    str3 = str10;
                }
                this.cHd.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(this.cHd.getPageContext().getPageActivity()).createConfig(arrayList, 0, str8, str9, str3, z3, arrayList.get(0), true, hashMap, false, true, false)));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
