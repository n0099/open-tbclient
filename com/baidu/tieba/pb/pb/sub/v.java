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
    final /* synthetic */ NewSubPbActivity eqU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(NewSubPbActivity newSubPbActivity) {
        this.eqU = newSubPbActivity;
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.e
    public void a(View view, String str, int i) {
        SubPbModel subPbModel;
        TbRichText an;
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
            subPbModel = this.eqU.eqD;
            com.baidu.tieba.pb.data.l aNe = subPbModel.aNe();
            an = this.eqU.an(str, i);
            TbRichTextData tbRichTextData = null;
            if (an != null && an.HC() != null) {
                ArrayList<TbRichTextData> HC = an.HC();
                i2 = this.eqU.ehm;
                tbRichTextData = HC.get(i2);
            }
            if (tbRichTextData != null) {
                ArrayList<String> arrayList3 = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                if (tbRichTextData.HI().HU()) {
                    this.eqU.ehn = false;
                    String str4 = "";
                    TbRichText aui = aNe.aIr().aui();
                    int size = arrayList3.size();
                    a = this.eqU.a(aui, an, i, i, arrayList3, concurrentHashMap3);
                    int size2 = arrayList3.size();
                    if (size != size2) {
                        str4 = arrayList3.get(size2 - 1);
                    }
                    String str5 = null;
                    String str6 = null;
                    String str7 = null;
                    if (aNe == null) {
                        str2 = null;
                        z = false;
                    } else {
                        if (aNe.aIx() != null) {
                            str5 = aNe.aIx().getName();
                            str6 = aNe.aIx().getId();
                        }
                        if (aNe.JB() != null) {
                            str7 = aNe.JB().getId();
                        }
                        str2 = str7;
                        z = true;
                    }
                    subPbModel2 = this.eqU.eqD;
                    if (subPbModel2.aNu() != null) {
                        subPbModel3 = this.eqU.eqD;
                        concurrentHashMap = subPbModel3.aNu();
                        subPbModel4 = this.eqU.eqD;
                        z2 = subPbModel4.aNw();
                        subPbModel5 = this.eqU.eqD;
                        arrayList = subPbModel5.aNv();
                        subPbModel6 = this.eqU.eqD;
                        a += subPbModel6.getOffset();
                    } else {
                        concurrentHashMap = concurrentHashMap3;
                        arrayList = arrayList3;
                        z2 = z;
                    }
                    this.eqU.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(this.eqU.getPageContext().getPageActivity()).createConfig(arrayList, a, str5, str6, str2, z2, str4, true, concurrentHashMap, true, false, false)));
                    return;
                }
                c = this.eqU.c(tbRichTextData);
                arrayList3.add(c);
                ImageUrlData imageUrlData = new ImageUrlData();
                imageUrlData.imageUrl = str;
                z3 = this.eqU.mIsFromCDN;
                imageUrlData.urlType = z3 ? 17 : 18;
                concurrentHashMap3.put(c, imageUrlData);
                String str8 = null;
                String str9 = null;
                String str10 = null;
                if (aNe == null) {
                    str3 = null;
                    z4 = false;
                } else {
                    if (aNe.aIx() != null) {
                        str8 = aNe.aIx().getName();
                        str9 = aNe.aIx().getId();
                    }
                    if (aNe.JB() != null) {
                        str10 = aNe.JB().getId();
                    }
                    str3 = str10;
                    z4 = true;
                }
                subPbModel7 = this.eqU.eqD;
                if (subPbModel7.aNu() != null) {
                    subPbModel8 = this.eqU.eqD;
                    concurrentHashMap2 = subPbModel8.aNu();
                    subPbModel9 = this.eqU.eqD;
                    z5 = subPbModel9.aNw();
                    subPbModel10 = this.eqU.eqD;
                    arrayList2 = subPbModel10.aNv();
                } else {
                    concurrentHashMap2 = concurrentHashMap3;
                    arrayList2 = arrayList3;
                    z5 = z4;
                }
                this.eqU.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(this.eqU.getPageContext().getPageActivity()).createConfig(arrayList2, 0, str8, str9, str3, z5, arrayList2.get(0), true, concurrentHashMap2, true, false, false)));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
