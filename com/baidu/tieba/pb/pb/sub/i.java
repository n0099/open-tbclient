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
    final /* synthetic */ NewSubPbActivity dqn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(NewSubPbActivity newSubPbActivity) {
        this.dqn = newSubPbActivity;
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.d
    public void a(View view, String str, int i) {
        ap apVar;
        com.baidu.tbadk.widget.richText.a ar;
        int a;
        String str2;
        String str3;
        boolean z;
        ap apVar2;
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap;
        ArrayList<String> arrayList;
        int i2;
        boolean z2;
        ap apVar3;
        ap apVar4;
        ap apVar5;
        ap apVar6;
        String c;
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
        int i3;
        try {
            apVar = this.dqn.dqc;
            com.baidu.tieba.pb.data.h aAq = apVar.aAq();
            ar = this.dqn.ar(str, i);
            com.baidu.tbadk.widget.richText.c cVar = null;
            if (ar != null && ar.GE() != null) {
                ArrayList<com.baidu.tbadk.widget.richText.c> GE = ar.GE();
                i3 = this.dqn.djt;
                cVar = GE.get(i3);
            }
            if (cVar != null) {
                ArrayList<String> arrayList3 = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                if (cVar.GJ().GV()) {
                    this.dqn.dju = false;
                    String str5 = "";
                    com.baidu.tieba.tbadkCore.data.s avR = aAq.avR();
                    com.baidu.tbadk.widget.richText.a amz = avR.amz();
                    int size = arrayList3.size();
                    a = this.dqn.a(amz, ar, i, i, arrayList3, concurrentHashMap3);
                    int size2 = arrayList3.size();
                    if (size != size2) {
                        str5 = arrayList3.get(size2 - 1);
                    }
                    ArrayList<com.baidu.tieba.tbadkCore.data.s> aTX = avR.aTX();
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        if (i5 >= aTX.size()) {
                            break;
                        }
                        a = this.dqn.a(aTX.get(i5).amz(), ar, a, i, arrayList3, concurrentHashMap3);
                        i4 = i5 + 1;
                    }
                    String str6 = null;
                    String str7 = null;
                    String str8 = null;
                    if (aAq == null) {
                        str2 = null;
                        str3 = null;
                        z = false;
                    } else {
                        if (aAq.avY() != null) {
                            str6 = aAq.avY().getName();
                            str7 = aAq.avY().getId();
                        }
                        if (aAq.Kn() != null) {
                            str8 = aAq.Kn().getId();
                        }
                        str2 = str8;
                        str3 = str6;
                        z = true;
                    }
                    apVar2 = this.dqn.dqc;
                    if (apVar2.aAH() != null) {
                        apVar3 = this.dqn.dqc;
                        concurrentHashMap = apVar3.aAH();
                        apVar4 = this.dqn.dqc;
                        z2 = apVar4.aAJ();
                        apVar5 = this.dqn.dqc;
                        arrayList = apVar5.aAI();
                        apVar6 = this.dqn.dqc;
                        i2 = a + apVar6.getOffset();
                    } else {
                        concurrentHashMap = concurrentHashMap3;
                        arrayList = arrayList3;
                        i2 = a;
                        z2 = z;
                    }
                    this.dqn.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(this.dqn.getPageContext().getPageActivity()).createConfig(arrayList, i2, str3, str7, str2, z2, str5, true, concurrentHashMap, true, false, false)));
                    return;
                }
                c = this.dqn.c(cVar);
                arrayList3.add(c);
                ImageUrlData imageUrlData = new ImageUrlData();
                imageUrlData.imageUrl = str;
                z3 = this.dqn.mIsFromCDN;
                imageUrlData.urlType = z3 ? 17 : 18;
                concurrentHashMap3.put(c, imageUrlData);
                String str9 = null;
                String str10 = null;
                String str11 = null;
                if (aAq == null) {
                    str4 = null;
                    z4 = false;
                } else {
                    if (aAq.avY() != null) {
                        str9 = aAq.avY().getName();
                        str10 = aAq.avY().getId();
                    }
                    if (aAq.Kn() != null) {
                        str11 = aAq.Kn().getId();
                    }
                    str4 = str11;
                    z4 = true;
                }
                apVar7 = this.dqn.dqc;
                if (apVar7.aAH() != null) {
                    apVar8 = this.dqn.dqc;
                    concurrentHashMap2 = apVar8.aAH();
                    apVar9 = this.dqn.dqc;
                    z5 = apVar9.aAJ();
                    apVar10 = this.dqn.dqc;
                    arrayList2 = apVar10.aAI();
                } else {
                    concurrentHashMap2 = concurrentHashMap3;
                    arrayList2 = arrayList3;
                    z5 = z4;
                }
                this.dqn.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(this.dqn.getPageContext().getPageActivity()).createConfig(arrayList2, 0, str9, str10, str4, z5, arrayList2.get(0), true, concurrentHashMap2, true, false, false)));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
