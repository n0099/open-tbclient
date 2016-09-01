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
public class m implements TbRichTextView.d {
    final /* synthetic */ NewSubPbActivity evy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(NewSubPbActivity newSubPbActivity) {
        this.evy = newSubPbActivity;
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.d
    public void a(View view, String str, int i) {
        ax axVar;
        com.baidu.tbadk.widget.richText.a az;
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
            axVar = this.evy.evl;
            com.baidu.tieba.pb.data.m aQK = axVar.aQK();
            az = this.evy.az(str, i);
            com.baidu.tbadk.widget.richText.c cVar = null;
            if (az != null && az.Ia() != null) {
                ArrayList<com.baidu.tbadk.widget.richText.c> Ia = az.Ia();
                i3 = this.evy.enQ;
                cVar = Ia.get(i3);
            }
            if (cVar != null) {
                ArrayList<String> arrayList3 = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                if (cVar.If().Is()) {
                    this.evy.enR = false;
                    String str5 = "";
                    com.baidu.tieba.tbadkCore.data.q aMh = aQK.aMh();
                    com.baidu.tbadk.widget.richText.a aAk = aMh.aAk();
                    int size = arrayList3.size();
                    a = this.evy.a(aAk, az, i, i, arrayList3, concurrentHashMap3);
                    int size2 = arrayList3.size();
                    if (size != size2) {
                        str5 = arrayList3.get(size2 - 1);
                    }
                    ArrayList<com.baidu.tieba.tbadkCore.data.q> bjb = aMh.bjb();
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        if (i5 >= bjb.size()) {
                            break;
                        }
                        a = this.evy.a(bjb.get(i5).aAk(), az, a, i, arrayList3, concurrentHashMap3);
                        i4 = i5 + 1;
                    }
                    String str6 = null;
                    String str7 = null;
                    String str8 = null;
                    if (aQK == null) {
                        str2 = null;
                        str3 = null;
                        z = false;
                    } else {
                        if (aQK.aMn() != null) {
                            str6 = aQK.aMn().getName();
                            str7 = aQK.aMn().getId();
                        }
                        if (aQK.Kw() != null) {
                            str8 = aQK.Kw().getId();
                        }
                        str2 = str8;
                        str3 = str6;
                        z = true;
                    }
                    axVar2 = this.evy.evl;
                    if (axVar2.aRa() != null) {
                        axVar3 = this.evy.evl;
                        concurrentHashMap = axVar3.aRa();
                        axVar4 = this.evy.evl;
                        z2 = axVar4.aRc();
                        axVar5 = this.evy.evl;
                        arrayList = axVar5.aRb();
                        axVar6 = this.evy.evl;
                        i2 = a + axVar6.getOffset();
                    } else {
                        concurrentHashMap = concurrentHashMap3;
                        arrayList = arrayList3;
                        i2 = a;
                        z2 = z;
                    }
                    this.evy.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(this.evy.getPageContext().getPageActivity()).createConfig(arrayList, i2, str3, str7, str2, z2, str5, true, concurrentHashMap, true, false, false)));
                    return;
                }
                c = this.evy.c(cVar);
                arrayList3.add(c);
                ImageUrlData imageUrlData = new ImageUrlData();
                imageUrlData.imageUrl = str;
                z3 = this.evy.mIsFromCDN;
                imageUrlData.urlType = z3 ? 17 : 18;
                concurrentHashMap3.put(c, imageUrlData);
                String str9 = null;
                String str10 = null;
                String str11 = null;
                if (aQK == null) {
                    str4 = null;
                    z4 = false;
                } else {
                    if (aQK.aMn() != null) {
                        str9 = aQK.aMn().getName();
                        str10 = aQK.aMn().getId();
                    }
                    if (aQK.Kw() != null) {
                        str11 = aQK.Kw().getId();
                    }
                    str4 = str11;
                    z4 = true;
                }
                axVar7 = this.evy.evl;
                if (axVar7.aRa() != null) {
                    axVar8 = this.evy.evl;
                    concurrentHashMap2 = axVar8.aRa();
                    axVar9 = this.evy.evl;
                    z5 = axVar9.aRc();
                    axVar10 = this.evy.evl;
                    arrayList2 = axVar10.aRb();
                } else {
                    concurrentHashMap2 = concurrentHashMap3;
                    arrayList2 = arrayList3;
                    z5 = z4;
                }
                this.evy.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(this.evy.getPageContext().getPageActivity()).createConfig(arrayList2, 0, str9, str10, str4, z5, arrayList2.get(0), true, concurrentHashMap2, true, false, false)));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
