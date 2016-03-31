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
    final /* synthetic */ NewSubPbActivity doF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(NewSubPbActivity newSubPbActivity) {
        this.doF = newSubPbActivity;
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.d
    public void a(View view, String str, int i) {
        ap apVar;
        com.baidu.tbadk.widget.richText.a am;
        int i2;
        int a;
        String str2;
        String str3;
        boolean z;
        ap apVar2;
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap;
        ArrayList<String> arrayList;
        int i3;
        boolean z2;
        ap apVar3;
        ap apVar4;
        ap apVar5;
        ap apVar6;
        String e;
        boolean z3;
        String str4;
        boolean z4;
        ap apVar7;
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2;
        ArrayList<String> arrayList2;
        boolean z5;
        ap apVar8;
        ap apVar9;
        ap apVar10;
        try {
            apVar = this.doF.dou;
            com.baidu.tieba.pb.data.g aAg = apVar.aAg();
            am = this.doF.am(str, i);
            ArrayList<com.baidu.tbadk.widget.richText.c> Im = am.Im();
            i2 = this.doF.dhj;
            com.baidu.tbadk.widget.richText.c cVar = Im.get(i2);
            if (cVar != null) {
                ArrayList<String> arrayList3 = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                if (cVar.Ir().IC()) {
                    this.doF.dhk = false;
                    String str5 = "";
                    com.baidu.tieba.tbadkCore.data.s avI = aAg.avI();
                    com.baidu.tbadk.widget.richText.a amn = avI.amn();
                    int size = arrayList3.size();
                    a = this.doF.a(amn, am, i, i, arrayList3, concurrentHashMap3);
                    int size2 = arrayList3.size();
                    if (size != size2) {
                        str5 = arrayList3.get(size2 - 1);
                    }
                    ArrayList<com.baidu.tieba.tbadkCore.data.s> aTr = avI.aTr();
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        if (i5 >= aTr.size()) {
                            break;
                        }
                        a = this.doF.a(aTr.get(i5).amn(), am, a, i, arrayList3, concurrentHashMap3);
                        i4 = i5 + 1;
                    }
                    String str6 = null;
                    String str7 = null;
                    String str8 = null;
                    if (aAg == null) {
                        str2 = null;
                        str3 = null;
                        z = false;
                    } else {
                        if (aAg.avP() != null) {
                            str6 = aAg.avP().getName();
                            str7 = aAg.avP().getId();
                        }
                        if (aAg.LC() != null) {
                            str8 = aAg.LC().getId();
                        }
                        str2 = str8;
                        str3 = str6;
                        z = true;
                    }
                    apVar2 = this.doF.dou;
                    if (apVar2.aAw() != null) {
                        apVar3 = this.doF.dou;
                        concurrentHashMap = apVar3.aAw();
                        apVar4 = this.doF.dou;
                        z2 = apVar4.aAy();
                        apVar5 = this.doF.dou;
                        arrayList = apVar5.aAx();
                        apVar6 = this.doF.dou;
                        i3 = a + apVar6.getOffset();
                    } else {
                        concurrentHashMap = concurrentHashMap3;
                        arrayList = arrayList3;
                        i3 = a;
                        z2 = z;
                    }
                    this.doF.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(this.doF.getPageContext().getPageActivity()).createConfig(arrayList, i3, str3, str7, str2, z2, str5, true, concurrentHashMap, true, false, false)));
                    return;
                }
                e = this.doF.e(cVar);
                arrayList3.add(e);
                ImageUrlData imageUrlData = new ImageUrlData();
                imageUrlData.imageUrl = str;
                z3 = this.doF.mIsFromCDN;
                imageUrlData.urlType = z3 ? 17 : 18;
                concurrentHashMap3.put(e, imageUrlData);
                String str9 = null;
                String str10 = null;
                String str11 = null;
                if (aAg == null) {
                    str4 = null;
                    z4 = false;
                } else {
                    if (aAg.avP() != null) {
                        str9 = aAg.avP().getName();
                        str10 = aAg.avP().getId();
                    }
                    if (aAg.LC() != null) {
                        str11 = aAg.LC().getId();
                    }
                    str4 = str11;
                    z4 = true;
                }
                apVar7 = this.doF.dou;
                if (apVar7.aAw() != null) {
                    apVar8 = this.doF.dou;
                    concurrentHashMap2 = apVar8.aAw();
                    apVar9 = this.doF.dou;
                    z5 = apVar9.aAy();
                    apVar10 = this.doF.dou;
                    arrayList2 = apVar10.aAx();
                } else {
                    concurrentHashMap2 = concurrentHashMap3;
                    arrayList2 = arrayList3;
                    z5 = z4;
                }
                this.doF.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(this.doF.getPageContext().getPageActivity()).createConfig(arrayList2, 0, str9, str10, str4, z5, arrayList2.get(0), true, concurrentHashMap2, true, false, false)));
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }
}
