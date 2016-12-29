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
    final /* synthetic */ NewSubPbActivity eis;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(NewSubPbActivity newSubPbActivity) {
        this.eis = newSubPbActivity;
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.e
    public void a(View view, String str, int i) {
        bc bcVar;
        com.baidu.tbadk.widget.richText.a at;
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
            bcVar = this.eis.eib;
            com.baidu.tieba.pb.data.j aNr = bcVar.aNr();
            at = this.eis.at(str, i);
            com.baidu.tbadk.widget.richText.c cVar = null;
            if (at != null && at.Hy() != null) {
                ArrayList<com.baidu.tbadk.widget.richText.c> Hy = at.Hy();
                i2 = this.eis.dZW;
                cVar = Hy.get(i2);
            }
            if (cVar != null) {
                ArrayList<String> arrayList3 = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                if (cVar.HD().HP()) {
                    this.eis.dZX = false;
                    String str4 = "";
                    com.baidu.tbadk.widget.richText.a avP = aNr.aIF().avP();
                    int size = arrayList3.size();
                    a = this.eis.a(avP, at, i, i, arrayList3, concurrentHashMap3);
                    int size2 = arrayList3.size();
                    if (size != size2) {
                        str4 = arrayList3.get(size2 - 1);
                    }
                    String str5 = null;
                    String str6 = null;
                    String str7 = null;
                    if (aNr == null) {
                        str2 = null;
                        z = false;
                    } else {
                        if (aNr.aIL() != null) {
                            str5 = aNr.aIL().getName();
                            str6 = aNr.aIL().getId();
                        }
                        if (aNr.IU() != null) {
                            str7 = aNr.IU().getId();
                        }
                        str2 = str7;
                        z = true;
                    }
                    bcVar2 = this.eis.eib;
                    if (bcVar2.aNH() != null) {
                        bcVar3 = this.eis.eib;
                        concurrentHashMap = bcVar3.aNH();
                        bcVar4 = this.eis.eib;
                        z2 = bcVar4.aNJ();
                        bcVar5 = this.eis.eib;
                        arrayList = bcVar5.aNI();
                        bcVar6 = this.eis.eib;
                        a += bcVar6.getOffset();
                    } else {
                        concurrentHashMap = concurrentHashMap3;
                        arrayList = arrayList3;
                        z2 = z;
                    }
                    this.eis.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(this.eis.getPageContext().getPageActivity()).createConfig(arrayList, a, str5, str6, str2, z2, str4, true, concurrentHashMap, true, false, false)));
                    return;
                }
                c = this.eis.c(cVar);
                arrayList3.add(c);
                ImageUrlData imageUrlData = new ImageUrlData();
                imageUrlData.imageUrl = str;
                z3 = this.eis.mIsFromCDN;
                imageUrlData.urlType = z3 ? 17 : 18;
                concurrentHashMap3.put(c, imageUrlData);
                String str8 = null;
                String str9 = null;
                String str10 = null;
                if (aNr == null) {
                    str3 = null;
                    z4 = false;
                } else {
                    if (aNr.aIL() != null) {
                        str8 = aNr.aIL().getName();
                        str9 = aNr.aIL().getId();
                    }
                    if (aNr.IU() != null) {
                        str10 = aNr.IU().getId();
                    }
                    str3 = str10;
                    z4 = true;
                }
                bcVar7 = this.eis.eib;
                if (bcVar7.aNH() != null) {
                    bcVar8 = this.eis.eib;
                    concurrentHashMap2 = bcVar8.aNH();
                    bcVar9 = this.eis.eib;
                    z5 = bcVar9.aNJ();
                    bcVar10 = this.eis.eib;
                    arrayList2 = bcVar10.aNI();
                } else {
                    concurrentHashMap2 = concurrentHashMap3;
                    arrayList2 = arrayList3;
                    z5 = z4;
                }
                this.eis.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(this.eis.getPageContext().getPageActivity()).createConfig(arrayList2, 0, str8, str9, str3, z5, arrayList2.get(0), true, concurrentHashMap2, true, false, false)));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
