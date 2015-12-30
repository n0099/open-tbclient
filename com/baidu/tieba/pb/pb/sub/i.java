package com.baidu.tieba.pb.pb.sub;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements TbRichTextView.d {
    final /* synthetic */ NewSubPbActivity cLc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(NewSubPbActivity newSubPbActivity) {
        this.cLc = newSubPbActivity;
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.d
    public void a(View view, String str, int i) {
        ao aoVar;
        com.baidu.tbadk.widget.richText.a ac;
        int i2;
        int a;
        String str2;
        String d;
        boolean z;
        String str3;
        try {
            aoVar = this.cLc.cKR;
            com.baidu.tieba.pb.a.d anR = aoVar.anR();
            ac = this.cLc.ac(str, i);
            ArrayList<com.baidu.tbadk.widget.richText.c> FA = ac.FA();
            i2 = this.cLc.cFM;
            com.baidu.tbadk.widget.richText.c cVar = FA.get(i2);
            if (cVar != null) {
                ArrayList<String> arrayList = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                if (cVar.FF().FP()) {
                    this.cLc.cFN = false;
                    String str4 = "";
                    com.baidu.tieba.tbadkCore.data.r akS = anR.akS();
                    com.baidu.tbadk.widget.richText.a aFr = akS.aFr();
                    int size = arrayList.size();
                    a = this.cLc.a(aFr, ac, i, i, arrayList, concurrentHashMap);
                    int size2 = arrayList.size();
                    if (size != size2) {
                        str4 = arrayList.get(size2 - 1);
                    }
                    ArrayList<com.baidu.tieba.tbadkCore.data.r> aFp = akS.aFp();
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= aFp.size()) {
                            break;
                        }
                        a = this.cLc.a(aFp.get(i4).aFr(), ac, a, i, arrayList, concurrentHashMap);
                        i3 = i4 + 1;
                    }
                    String str5 = null;
                    String str6 = null;
                    String str7 = null;
                    boolean z2 = false;
                    if (anR == null) {
                        str2 = null;
                    } else {
                        if (anR.akZ() != null) {
                            str5 = anR.akZ().getName();
                            str6 = anR.akZ().getId();
                        }
                        if (anR.Iv() != null) {
                            str7 = anR.Iv().getId();
                        }
                        z2 = true;
                        str2 = str7;
                    }
                    this.cLc.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(this.cLc.getPageContext().getPageActivity()).createConfig(arrayList, a, str5, str6, str2, z2, str4, true, concurrentHashMap, false, true, false)));
                    return;
                }
                d = this.cLc.d(cVar);
                arrayList.add(d);
                ImageUrlData imageUrlData = new ImageUrlData();
                imageUrlData.imageUrl = str;
                z = this.cLc.mIsFromCDN;
                imageUrlData.urlType = z ? 17 : 18;
                concurrentHashMap.put(d, imageUrlData);
                String str8 = null;
                String str9 = null;
                String str10 = null;
                boolean z3 = false;
                if (anR == null) {
                    str3 = null;
                } else {
                    if (anR.akZ() != null) {
                        str8 = anR.akZ().getName();
                        str9 = anR.akZ().getId();
                    }
                    if (anR.Iv() != null) {
                        str10 = anR.Iv().getId();
                    }
                    z3 = true;
                    str3 = str10;
                }
                this.cLc.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(this.cLc.getPageContext().getPageActivity()).createConfig(arrayList, 0, str8, str9, str3, z3, arrayList.get(0), true, concurrentHashMap, false, true, false)));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
