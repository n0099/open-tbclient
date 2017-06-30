package com.baidu.tieba.pb.pb.sub;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements TbRichTextView.e {
    final /* synthetic */ NewSubPbActivity eHC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(NewSubPbActivity newSubPbActivity) {
        this.eHC = newSubPbActivity;
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.e
    public void a(View view, String str, int i) {
        SubPbModel subPbModel;
        TbRichText ap;
        int a;
        String str2;
        boolean z;
        SubPbModel subPbModel2;
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap;
        ArrayList<String> arrayList;
        boolean z2;
        SubPbModel subPbModel3;
        SubPbModel subPbModel4;
        SubPbModel subPbModel5;
        SubPbModel subPbModel6;
        String c;
        boolean z3;
        String str3;
        boolean z4;
        SubPbModel subPbModel7;
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2;
        ArrayList<String> arrayList2;
        boolean z5;
        SubPbModel subPbModel8;
        SubPbModel subPbModel9;
        SubPbModel subPbModel10;
        int i2;
        try {
            subPbModel = this.eHC.eHl;
            com.baidu.tieba.pb.data.n aSm = subPbModel.aSm();
            ap = this.eHC.ap(str, i);
            TbRichTextData tbRichTextData = null;
            if (ap != null && ap.HU() != null) {
                ArrayList<TbRichTextData> HU = ap.HU();
                i2 = this.eHC.evU;
                tbRichTextData = HU.get(i2);
            }
            if (tbRichTextData != null) {
                ArrayList<String> arrayList3 = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                if (tbRichTextData.Ia().In()) {
                    this.eHC.evV = false;
                    String str4 = "";
                    TbRichText azb = aSm.aNd().azb();
                    int size = arrayList3.size();
                    a = this.eHC.a(azb, ap, i, i, arrayList3, concurrentHashMap3);
                    int size2 = arrayList3.size();
                    if (size != size2) {
                        str4 = arrayList3.get(size2 - 1);
                    }
                    String str5 = null;
                    String str6 = null;
                    String str7 = null;
                    if (aSm == null) {
                        str2 = null;
                        z = false;
                    } else {
                        if (aSm.aNj() != null) {
                            str5 = aSm.aNj().getName();
                            str6 = aSm.aNj().getId();
                        }
                        if (aSm.Mv() != null) {
                            str7 = aSm.Mv().getId();
                        }
                        str2 = str7;
                        z = true;
                    }
                    subPbModel2 = this.eHC.eHl;
                    if (subPbModel2.aSC() != null) {
                        subPbModel3 = this.eHC.eHl;
                        concurrentHashMap = subPbModel3.aSC();
                        subPbModel4 = this.eHC.eHl;
                        z2 = subPbModel4.aSE();
                        subPbModel5 = this.eHC.eHl;
                        arrayList = subPbModel5.aSD();
                        subPbModel6 = this.eHC.eHl;
                        a += subPbModel6.getOffset();
                    } else {
                        concurrentHashMap = concurrentHashMap3;
                        arrayList = arrayList3;
                        z2 = z;
                    }
                    this.eHC.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(this.eHC.getPageContext().getPageActivity()).createConfig(arrayList, a, str5, str6, str2, z2, str4, true, concurrentHashMap, true, false, false)));
                    return;
                }
                c = this.eHC.c(tbRichTextData);
                arrayList3.add(c);
                ImageUrlData imageUrlData = new ImageUrlData();
                imageUrlData.imageUrl = str;
                z3 = this.eHC.mIsFromCDN;
                imageUrlData.urlType = z3 ? 17 : 18;
                concurrentHashMap3.put(c, imageUrlData);
                String str8 = null;
                String str9 = null;
                String str10 = null;
                if (aSm == null) {
                    str3 = null;
                    z4 = false;
                } else {
                    if (aSm.aNj() != null) {
                        str8 = aSm.aNj().getName();
                        str9 = aSm.aNj().getId();
                    }
                    if (aSm.Mv() != null) {
                        str10 = aSm.Mv().getId();
                    }
                    str3 = str10;
                    z4 = true;
                }
                subPbModel7 = this.eHC.eHl;
                if (subPbModel7.aSC() != null) {
                    subPbModel8 = this.eHC.eHl;
                    concurrentHashMap2 = subPbModel8.aSC();
                    subPbModel9 = this.eHC.eHl;
                    z5 = subPbModel9.aSE();
                    subPbModel10 = this.eHC.eHl;
                    arrayList2 = subPbModel10.aSD();
                } else {
                    concurrentHashMap2 = concurrentHashMap3;
                    arrayList2 = arrayList3;
                    z5 = z4;
                }
                this.eHC.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(this.eHC.getPageContext().getPageActivity()).createConfig(arrayList2, 0, str8, str9, str3, z5, arrayList2.get(0), true, concurrentHashMap2, true, false, false)));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
