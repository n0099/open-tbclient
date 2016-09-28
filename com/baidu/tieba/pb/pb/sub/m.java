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
public class m implements TbRichTextView.e {
    final /* synthetic */ NewSubPbActivity exF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(NewSubPbActivity newSubPbActivity) {
        this.exF = newSubPbActivity;
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.e
    public void a(View view, String str, int i) {
        ax axVar;
        com.baidu.tbadk.widget.richText.a ay;
        int a;
        String str2;
        String str3;
        boolean z;
        ax axVar2;
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap;
        ArrayList<String> arrayList;
        int i2;
        boolean z2;
        ax axVar3;
        ax axVar4;
        ax axVar5;
        ax axVar6;
        String c;
        boolean z3;
        String str4;
        boolean z4;
        ax axVar7;
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2;
        ArrayList<String> arrayList2;
        boolean z5;
        ax axVar8;
        ax axVar9;
        ax axVar10;
        int i3;
        try {
            axVar = this.exF.exr;
            com.baidu.tieba.pb.data.n aRs = axVar.aRs();
            ay = this.exF.ay(str, i);
            com.baidu.tbadk.widget.richText.c cVar = null;
            if (ay != null && ay.HZ() != null) {
                ArrayList<com.baidu.tbadk.widget.richText.c> HZ = ay.HZ();
                i3 = this.exF.epP;
                cVar = HZ.get(i3);
            }
            if (cVar != null) {
                ArrayList<String> arrayList3 = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                if (cVar.Ie().Ir()) {
                    this.exF.epQ = false;
                    String str5 = "";
                    com.baidu.tieba.tbadkCore.data.q aMN = aRs.aMN();
                    com.baidu.tbadk.widget.richText.a aAI = aMN.aAI();
                    int size = arrayList3.size();
                    a = this.exF.a(aAI, ay, i, i, arrayList3, concurrentHashMap3);
                    int size2 = arrayList3.size();
                    if (size != size2) {
                        str5 = arrayList3.get(size2 - 1);
                    }
                    ArrayList<com.baidu.tieba.tbadkCore.data.q> bjN = aMN.bjN();
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        if (i5 >= bjN.size()) {
                            break;
                        }
                        a = this.exF.a(bjN.get(i5).aAI(), ay, a, i, arrayList3, concurrentHashMap3);
                        i4 = i5 + 1;
                    }
                    String str6 = null;
                    String str7 = null;
                    String str8 = null;
                    if (aRs == null) {
                        str2 = null;
                        str3 = null;
                        z = false;
                    } else {
                        if (aRs.aMT() != null) {
                            str6 = aRs.aMT().getName();
                            str7 = aRs.aMT().getId();
                        }
                        if (aRs.Jv() != null) {
                            str8 = aRs.Jv().getId();
                        }
                        str2 = str8;
                        str3 = str6;
                        z = true;
                    }
                    axVar2 = this.exF.exr;
                    if (axVar2.aRI() != null) {
                        axVar3 = this.exF.exr;
                        concurrentHashMap = axVar3.aRI();
                        axVar4 = this.exF.exr;
                        z2 = axVar4.aRK();
                        axVar5 = this.exF.exr;
                        arrayList = axVar5.aRJ();
                        axVar6 = this.exF.exr;
                        i2 = a + axVar6.getOffset();
                    } else {
                        concurrentHashMap = concurrentHashMap3;
                        arrayList = arrayList3;
                        i2 = a;
                        z2 = z;
                    }
                    this.exF.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(this.exF.getPageContext().getPageActivity()).createConfig(arrayList, i2, str3, str7, str2, z2, str5, true, concurrentHashMap, true, false, false)));
                    return;
                }
                c = this.exF.c(cVar);
                arrayList3.add(c);
                ImageUrlData imageUrlData = new ImageUrlData();
                imageUrlData.imageUrl = str;
                z3 = this.exF.mIsFromCDN;
                imageUrlData.urlType = z3 ? 17 : 18;
                concurrentHashMap3.put(c, imageUrlData);
                String str9 = null;
                String str10 = null;
                String str11 = null;
                if (aRs == null) {
                    str4 = null;
                    z4 = false;
                } else {
                    if (aRs.aMT() != null) {
                        str9 = aRs.aMT().getName();
                        str10 = aRs.aMT().getId();
                    }
                    if (aRs.Jv() != null) {
                        str11 = aRs.Jv().getId();
                    }
                    str4 = str11;
                    z4 = true;
                }
                axVar7 = this.exF.exr;
                if (axVar7.aRI() != null) {
                    axVar8 = this.exF.exr;
                    concurrentHashMap2 = axVar8.aRI();
                    axVar9 = this.exF.exr;
                    z5 = axVar9.aRK();
                    axVar10 = this.exF.exr;
                    arrayList2 = axVar10.aRJ();
                } else {
                    concurrentHashMap2 = concurrentHashMap3;
                    arrayList2 = arrayList3;
                    z5 = z4;
                }
                this.exF.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(this.exF.getPageContext().getPageActivity()).createConfig(arrayList2, 0, str9, str10, str4, z5, arrayList2.get(0), true, concurrentHashMap2, true, false, false)));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
