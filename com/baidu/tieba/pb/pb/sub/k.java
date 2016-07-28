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
    final /* synthetic */ NewSubPbActivity ejr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(NewSubPbActivity newSubPbActivity) {
        this.ejr = newSubPbActivity;
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.d
    public void a(View view, String str, int i) {
        aw awVar;
        com.baidu.tbadk.widget.richText.a az;
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
            awVar = this.ejr.eje;
            com.baidu.tieba.pb.data.m aLS = awVar.aLS();
            az = this.ejr.az(str, i);
            com.baidu.tbadk.widget.richText.c cVar = null;
            if (az != null && az.GD() != null) {
                ArrayList<com.baidu.tbadk.widget.richText.c> GD = az.GD();
                i3 = this.ejr.ebI;
                cVar = GD.get(i3);
            }
            if (cVar != null) {
                ArrayList<String> arrayList3 = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                if (cVar.GI().GU()) {
                    this.ejr.ebJ = false;
                    String str5 = "";
                    com.baidu.tieba.tbadkCore.data.s aHp = aLS.aHp();
                    com.baidu.tbadk.widget.richText.a avx = aHp.avx();
                    int size = arrayList3.size();
                    a = this.ejr.a(avx, az, i, i, arrayList3, concurrentHashMap3);
                    int size2 = arrayList3.size();
                    if (size != size2) {
                        str5 = arrayList3.get(size2 - 1);
                    }
                    ArrayList<com.baidu.tieba.tbadkCore.data.s> bfA = aHp.bfA();
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        if (i5 >= bfA.size()) {
                            break;
                        }
                        a = this.ejr.a(bfA.get(i5).avx(), az, a, i, arrayList3, concurrentHashMap3);
                        i4 = i5 + 1;
                    }
                    String str6 = null;
                    String str7 = null;
                    String str8 = null;
                    if (aLS == null) {
                        str2 = null;
                        str3 = null;
                        z = false;
                    } else {
                        if (aLS.aHv() != null) {
                            str6 = aLS.aHv().getName();
                            str7 = aLS.aHv().getId();
                        }
                        if (aLS.Iw() != null) {
                            str8 = aLS.Iw().getId();
                        }
                        str2 = str8;
                        str3 = str6;
                        z = true;
                    }
                    awVar2 = this.ejr.eje;
                    if (awVar2.aMi() != null) {
                        awVar3 = this.ejr.eje;
                        concurrentHashMap = awVar3.aMi();
                        awVar4 = this.ejr.eje;
                        z2 = awVar4.aMk();
                        awVar5 = this.ejr.eje;
                        arrayList = awVar5.aMj();
                        awVar6 = this.ejr.eje;
                        i2 = a + awVar6.getOffset();
                    } else {
                        concurrentHashMap = concurrentHashMap3;
                        arrayList = arrayList3;
                        i2 = a;
                        z2 = z;
                    }
                    this.ejr.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(this.ejr.getPageContext().getPageActivity()).createConfig(arrayList, i2, str3, str7, str2, z2, str5, true, concurrentHashMap, true, false, false)));
                    return;
                }
                c = this.ejr.c(cVar);
                arrayList3.add(c);
                ImageUrlData imageUrlData = new ImageUrlData();
                imageUrlData.imageUrl = str;
                z3 = this.ejr.mIsFromCDN;
                imageUrlData.urlType = z3 ? 17 : 18;
                concurrentHashMap3.put(c, imageUrlData);
                String str9 = null;
                String str10 = null;
                String str11 = null;
                if (aLS == null) {
                    str4 = null;
                    z4 = false;
                } else {
                    if (aLS.aHv() != null) {
                        str9 = aLS.aHv().getName();
                        str10 = aLS.aHv().getId();
                    }
                    if (aLS.Iw() != null) {
                        str11 = aLS.Iw().getId();
                    }
                    str4 = str11;
                    z4 = true;
                }
                awVar7 = this.ejr.eje;
                if (awVar7.aMi() != null) {
                    awVar8 = this.ejr.eje;
                    concurrentHashMap2 = awVar8.aMi();
                    awVar9 = this.ejr.eje;
                    z5 = awVar9.aMk();
                    awVar10 = this.ejr.eje;
                    arrayList2 = awVar10.aMj();
                } else {
                    concurrentHashMap2 = concurrentHashMap3;
                    arrayList2 = arrayList3;
                    z5 = z4;
                }
                this.ejr.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(this.ejr.getPageContext().getPageActivity()).createConfig(arrayList2, 0, str9, str10, str4, z5, arrayList2.get(0), true, concurrentHashMap2, true, false, false)));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
