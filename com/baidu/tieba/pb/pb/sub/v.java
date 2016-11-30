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
public class v implements TbRichTextView.e {
    final /* synthetic */ NewSubPbActivity eEs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(NewSubPbActivity newSubPbActivity) {
        this.eEs = newSubPbActivity;
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.e
    public void a(View view, String str, int i) {
        bc bcVar;
        com.baidu.tbadk.widget.richText.a ay;
        int a;
        String str2;
        boolean z;
        bc bcVar2;
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap;
        ArrayList<String> arrayList;
        boolean z2;
        bc bcVar3;
        bc bcVar4;
        bc bcVar5;
        bc bcVar6;
        String c;
        boolean z3;
        String str3;
        boolean z4;
        bc bcVar7;
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2;
        ArrayList<String> arrayList2;
        boolean z5;
        bc bcVar8;
        bc bcVar9;
        bc bcVar10;
        int i2;
        try {
            bcVar = this.eEs.eEb;
            com.baidu.tieba.pb.data.n aTA = bcVar.aTA();
            ay = this.eEs.ay(str, i);
            com.baidu.tbadk.widget.richText.c cVar = null;
            if (ay != null && ay.Ic() != null) {
                ArrayList<com.baidu.tbadk.widget.richText.c> Ic = ay.Ic();
                i2 = this.eEs.evA;
                cVar = Ic.get(i2);
            }
            if (cVar != null) {
                ArrayList<String> arrayList3 = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                if (cVar.Ih().Iu()) {
                    this.eEs.evB = false;
                    String str4 = "";
                    com.baidu.tbadk.widget.richText.a aCE = aTA.aOG().aCE();
                    int size = arrayList3.size();
                    a = this.eEs.a(aCE, ay, i, i, arrayList3, concurrentHashMap3);
                    int size2 = arrayList3.size();
                    if (size != size2) {
                        str4 = arrayList3.get(size2 - 1);
                    }
                    String str5 = null;
                    String str6 = null;
                    String str7 = null;
                    if (aTA == null) {
                        str2 = null;
                        z = false;
                    } else {
                        if (aTA.aOM() != null) {
                            str5 = aTA.aOM().getName();
                            str6 = aTA.aOM().getId();
                        }
                        if (aTA.Jz() != null) {
                            str7 = aTA.Jz().getId();
                        }
                        str2 = str7;
                        z = true;
                    }
                    bcVar2 = this.eEs.eEb;
                    if (bcVar2.aTQ() != null) {
                        bcVar3 = this.eEs.eEb;
                        concurrentHashMap = bcVar3.aTQ();
                        bcVar4 = this.eEs.eEb;
                        z2 = bcVar4.aTS();
                        bcVar5 = this.eEs.eEb;
                        arrayList = bcVar5.aTR();
                        bcVar6 = this.eEs.eEb;
                        a += bcVar6.getOffset();
                    } else {
                        concurrentHashMap = concurrentHashMap3;
                        arrayList = arrayList3;
                        z2 = z;
                    }
                    this.eEs.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(this.eEs.getPageContext().getPageActivity()).createConfig(arrayList, a, str5, str6, str2, z2, str4, true, concurrentHashMap, true, false, false)));
                    return;
                }
                c = this.eEs.c(cVar);
                arrayList3.add(c);
                ImageUrlData imageUrlData = new ImageUrlData();
                imageUrlData.imageUrl = str;
                z3 = this.eEs.mIsFromCDN;
                imageUrlData.urlType = z3 ? 17 : 18;
                concurrentHashMap3.put(c, imageUrlData);
                String str8 = null;
                String str9 = null;
                String str10 = null;
                if (aTA == null) {
                    str3 = null;
                    z4 = false;
                } else {
                    if (aTA.aOM() != null) {
                        str8 = aTA.aOM().getName();
                        str9 = aTA.aOM().getId();
                    }
                    if (aTA.Jz() != null) {
                        str10 = aTA.Jz().getId();
                    }
                    str3 = str10;
                    z4 = true;
                }
                bcVar7 = this.eEs.eEb;
                if (bcVar7.aTQ() != null) {
                    bcVar8 = this.eEs.eEb;
                    concurrentHashMap2 = bcVar8.aTQ();
                    bcVar9 = this.eEs.eEb;
                    z5 = bcVar9.aTS();
                    bcVar10 = this.eEs.eEb;
                    arrayList2 = bcVar10.aTR();
                } else {
                    concurrentHashMap2 = concurrentHashMap3;
                    arrayList2 = arrayList3;
                    z5 = z4;
                }
                this.eEs.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(this.eEs.getPageContext().getPageActivity()).createConfig(arrayList2, 0, str8, str9, str3, z5, arrayList2.get(0), true, concurrentHashMap2, true, false, false)));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
