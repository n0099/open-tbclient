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
    final /* synthetic */ NewSubPbActivity cTK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(NewSubPbActivity newSubPbActivity) {
        this.cTK = newSubPbActivity;
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.d
    public void a(View view, String str, int i) {
        ao aoVar;
        com.baidu.tbadk.widget.richText.a ae;
        int i2;
        int a;
        String str2;
        String str3;
        boolean z;
        ao aoVar2;
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap;
        ArrayList<String> arrayList;
        int i3;
        boolean z2;
        ao aoVar3;
        ao aoVar4;
        ao aoVar5;
        ao aoVar6;
        String e;
        boolean z3;
        String str4;
        boolean z4;
        ao aoVar7;
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2;
        ArrayList<String> arrayList2;
        boolean z5;
        ao aoVar8;
        ao aoVar9;
        ao aoVar10;
        try {
            aoVar = this.cTK.cTz;
            com.baidu.tieba.pb.a.d asw = aoVar.asw();
            ae = this.cTK.ae(str, i);
            ArrayList<com.baidu.tbadk.widget.richText.c> GS = ae.GS();
            i2 = this.cTK.cNk;
            com.baidu.tbadk.widget.richText.c cVar = GS.get(i2);
            if (cVar != null) {
                ArrayList<String> arrayList3 = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                if (cVar.GX().Hh()) {
                    this.cTK.cNl = false;
                    String str5 = "";
                    com.baidu.tieba.tbadkCore.data.r aoQ = asw.aoQ();
                    com.baidu.tbadk.widget.richText.a aiT = aoQ.aiT();
                    int size = arrayList3.size();
                    a = this.cTK.a(aiT, ae, i, i, arrayList3, concurrentHashMap3);
                    int size2 = arrayList3.size();
                    if (size != size2) {
                        str5 = arrayList3.get(size2 - 1);
                    }
                    ArrayList<com.baidu.tieba.tbadkCore.data.r> aMv = aoQ.aMv();
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        if (i5 >= aMv.size()) {
                            break;
                        }
                        a = this.cTK.a(aMv.get(i5).aiT(), ae, a, i, arrayList3, concurrentHashMap3);
                        i4 = i5 + 1;
                    }
                    String str6 = null;
                    String str7 = null;
                    String str8 = null;
                    if (asw == null) {
                        str2 = null;
                        str3 = null;
                        z = false;
                    } else {
                        if (asw.aoX() != null) {
                            str6 = asw.aoX().getName();
                            str7 = asw.aoX().getId();
                        }
                        if (asw.Ki() != null) {
                            str8 = asw.Ki().getId();
                        }
                        str2 = str8;
                        str3 = str6;
                        z = true;
                    }
                    aoVar2 = this.cTK.cTz;
                    if (aoVar2.asM() != null) {
                        aoVar3 = this.cTK.cTz;
                        concurrentHashMap = aoVar3.asM();
                        aoVar4 = this.cTK.cTz;
                        z2 = aoVar4.asO();
                        aoVar5 = this.cTK.cTz;
                        arrayList = aoVar5.asN();
                        aoVar6 = this.cTK.cTz;
                        i3 = a + aoVar6.getOffset();
                    } else {
                        concurrentHashMap = concurrentHashMap3;
                        arrayList = arrayList3;
                        i3 = a;
                        z2 = z;
                    }
                    this.cTK.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(this.cTK.getPageContext().getPageActivity()).createConfig(arrayList, i3, str3, str7, str2, z2, str5, true, concurrentHashMap, true, false, false)));
                    return;
                }
                e = this.cTK.e(cVar);
                arrayList3.add(e);
                ImageUrlData imageUrlData = new ImageUrlData();
                imageUrlData.imageUrl = str;
                z3 = this.cTK.mIsFromCDN;
                imageUrlData.urlType = z3 ? 17 : 18;
                concurrentHashMap3.put(e, imageUrlData);
                String str9 = null;
                String str10 = null;
                String str11 = null;
                if (asw == null) {
                    str4 = null;
                    z4 = false;
                } else {
                    if (asw.aoX() != null) {
                        str9 = asw.aoX().getName();
                        str10 = asw.aoX().getId();
                    }
                    if (asw.Ki() != null) {
                        str11 = asw.Ki().getId();
                    }
                    str4 = str11;
                    z4 = true;
                }
                aoVar7 = this.cTK.cTz;
                if (aoVar7.asM() != null) {
                    aoVar8 = this.cTK.cTz;
                    concurrentHashMap2 = aoVar8.asM();
                    aoVar9 = this.cTK.cTz;
                    z5 = aoVar9.asO();
                    aoVar10 = this.cTK.cTz;
                    arrayList2 = aoVar10.asN();
                } else {
                    concurrentHashMap2 = concurrentHashMap3;
                    arrayList2 = arrayList3;
                    z5 = z4;
                }
                this.cTK.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(this.cTK.getPageContext().getPageActivity()).createConfig(arrayList2, 0, str9, str10, str4, z5, arrayList2.get(0), true, concurrentHashMap2, true, false, false)));
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }
}
