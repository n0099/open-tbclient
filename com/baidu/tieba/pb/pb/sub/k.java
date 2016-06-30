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
public class k implements TbRichTextView.d {
    final /* synthetic */ NewSubPbActivity dWP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(NewSubPbActivity newSubPbActivity) {
        this.dWP = newSubPbActivity;
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.d
    public void a(View view, String str, int i) {
        aw awVar;
        com.baidu.tbadk.widget.richText.a ay;
        int a;
        String str2;
        String str3;
        boolean z;
        aw awVar2;
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap;
        ArrayList<String> arrayList;
        int i2;
        boolean z2;
        aw awVar3;
        aw awVar4;
        aw awVar5;
        aw awVar6;
        String c;
        boolean z3;
        String str4;
        boolean z4;
        aw awVar7;
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2;
        ArrayList<String> arrayList2;
        boolean z5;
        aw awVar8;
        aw awVar9;
        aw awVar10;
        int i3;
        try {
            awVar = this.dWP.dWC;
            com.baidu.tieba.pb.data.m aIH = awVar.aIH();
            ay = this.dWP.ay(str, i);
            com.baidu.tbadk.widget.richText.c cVar = null;
            if (ay != null && ay.GF() != null) {
                ArrayList<com.baidu.tbadk.widget.richText.c> GF = ay.GF();
                i3 = this.dWP.dPu;
                cVar = GF.get(i3);
            }
            if (cVar != null) {
                ArrayList<String> arrayList3 = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                if (cVar.GK().GW()) {
                    this.dWP.dPv = false;
                    String str5 = "";
                    com.baidu.tieba.tbadkCore.data.s aEe = aIH.aEe();
                    com.baidu.tbadk.widget.richText.a auL = aEe.auL();
                    int size = arrayList3.size();
                    a = this.dWP.a(auL, ay, i, i, arrayList3, concurrentHashMap3);
                    int size2 = arrayList3.size();
                    if (size != size2) {
                        str5 = arrayList3.get(size2 - 1);
                    }
                    ArrayList<com.baidu.tieba.tbadkCore.data.s> bcl = aEe.bcl();
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        if (i5 >= bcl.size()) {
                            break;
                        }
                        a = this.dWP.a(bcl.get(i5).auL(), ay, a, i, arrayList3, concurrentHashMap3);
                        i4 = i5 + 1;
                    }
                    String str6 = null;
                    String str7 = null;
                    String str8 = null;
                    if (aIH == null) {
                        str2 = null;
                        str3 = null;
                        z = false;
                    } else {
                        if (aIH.aEl() != null) {
                            str6 = aIH.aEl().getName();
                            str7 = aIH.aEl().getId();
                        }
                        if (aIH.Ix() != null) {
                            str8 = aIH.Ix().getId();
                        }
                        str2 = str8;
                        str3 = str6;
                        z = true;
                    }
                    awVar2 = this.dWP.dWC;
                    if (awVar2.aIX() != null) {
                        awVar3 = this.dWP.dWC;
                        concurrentHashMap = awVar3.aIX();
                        awVar4 = this.dWP.dWC;
                        z2 = awVar4.aIZ();
                        awVar5 = this.dWP.dWC;
                        arrayList = awVar5.aIY();
                        awVar6 = this.dWP.dWC;
                        i2 = a + awVar6.getOffset();
                    } else {
                        concurrentHashMap = concurrentHashMap3;
                        arrayList = arrayList3;
                        i2 = a;
                        z2 = z;
                    }
                    this.dWP.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(this.dWP.getPageContext().getPageActivity()).createConfig(arrayList, i2, str3, str7, str2, z2, str5, true, concurrentHashMap, true, false, false)));
                    return;
                }
                c = this.dWP.c(cVar);
                arrayList3.add(c);
                ImageUrlData imageUrlData = new ImageUrlData();
                imageUrlData.imageUrl = str;
                z3 = this.dWP.mIsFromCDN;
                imageUrlData.urlType = z3 ? 17 : 18;
                concurrentHashMap3.put(c, imageUrlData);
                String str9 = null;
                String str10 = null;
                String str11 = null;
                if (aIH == null) {
                    str4 = null;
                    z4 = false;
                } else {
                    if (aIH.aEl() != null) {
                        str9 = aIH.aEl().getName();
                        str10 = aIH.aEl().getId();
                    }
                    if (aIH.Ix() != null) {
                        str11 = aIH.Ix().getId();
                    }
                    str4 = str11;
                    z4 = true;
                }
                awVar7 = this.dWP.dWC;
                if (awVar7.aIX() != null) {
                    awVar8 = this.dWP.dWC;
                    concurrentHashMap2 = awVar8.aIX();
                    awVar9 = this.dWP.dWC;
                    z5 = awVar9.aIZ();
                    awVar10 = this.dWP.dWC;
                    arrayList2 = awVar10.aIY();
                } else {
                    concurrentHashMap2 = concurrentHashMap3;
                    arrayList2 = arrayList3;
                    z5 = z4;
                }
                this.dWP.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(this.dWP.getPageContext().getPageActivity()).createConfig(arrayList2, 0, str9, str10, str4, z5, arrayList2.get(0), true, concurrentHashMap2, true, false, false)));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
