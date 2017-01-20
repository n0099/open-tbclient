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
    final /* synthetic */ NewSubPbActivity erC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(NewSubPbActivity newSubPbActivity) {
        this.erC = newSubPbActivity;
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.e
    public void a(View view, String str, int i) {
        SubPbModel subPbModel;
        TbRichText at;
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
            subPbModel = this.erC.erl;
            com.baidu.tieba.pb.data.j aPn = subPbModel.aPn();
            at = this.erC.at(str, i);
            TbRichTextData tbRichTextData = null;
            if (at != null && at.Hq() != null) {
                ArrayList<TbRichTextData> Hq = at.Hq();
                i2 = this.erC.eiJ;
                tbRichTextData = Hq.get(i2);
            }
            if (tbRichTextData != null) {
                ArrayList<String> arrayList3 = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                if (tbRichTextData.Hv().HH()) {
                    this.erC.eiK = false;
                    String str4 = "";
                    TbRichText awW = aPn.aKw().awW();
                    int size = arrayList3.size();
                    a = this.erC.a(awW, at, i, i, arrayList3, concurrentHashMap3);
                    int size2 = arrayList3.size();
                    if (size != size2) {
                        str4 = arrayList3.get(size2 - 1);
                    }
                    String str5 = null;
                    String str6 = null;
                    String str7 = null;
                    if (aPn == null) {
                        str2 = null;
                        z = false;
                    } else {
                        if (aPn.aKC() != null) {
                            str5 = aPn.aKC().getName();
                            str6 = aPn.aKC().getId();
                        }
                        if (aPn.Ji() != null) {
                            str7 = aPn.Ji().getId();
                        }
                        str2 = str7;
                        z = true;
                    }
                    subPbModel2 = this.erC.erl;
                    if (subPbModel2.aPD() != null) {
                        subPbModel3 = this.erC.erl;
                        concurrentHashMap = subPbModel3.aPD();
                        subPbModel4 = this.erC.erl;
                        z2 = subPbModel4.aPF();
                        subPbModel5 = this.erC.erl;
                        arrayList = subPbModel5.aPE();
                        subPbModel6 = this.erC.erl;
                        a += subPbModel6.getOffset();
                    } else {
                        concurrentHashMap = concurrentHashMap3;
                        arrayList = arrayList3;
                        z2 = z;
                    }
                    this.erC.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(this.erC.getPageContext().getPageActivity()).createConfig(arrayList, a, str5, str6, str2, z2, str4, true, concurrentHashMap, true, false, false)));
                    return;
                }
                c = this.erC.c(tbRichTextData);
                arrayList3.add(c);
                ImageUrlData imageUrlData = new ImageUrlData();
                imageUrlData.imageUrl = str;
                z3 = this.erC.mIsFromCDN;
                imageUrlData.urlType = z3 ? 17 : 18;
                concurrentHashMap3.put(c, imageUrlData);
                String str8 = null;
                String str9 = null;
                String str10 = null;
                if (aPn == null) {
                    str3 = null;
                    z4 = false;
                } else {
                    if (aPn.aKC() != null) {
                        str8 = aPn.aKC().getName();
                        str9 = aPn.aKC().getId();
                    }
                    if (aPn.Ji() != null) {
                        str10 = aPn.Ji().getId();
                    }
                    str3 = str10;
                    z4 = true;
                }
                subPbModel7 = this.erC.erl;
                if (subPbModel7.aPD() != null) {
                    subPbModel8 = this.erC.erl;
                    concurrentHashMap2 = subPbModel8.aPD();
                    subPbModel9 = this.erC.erl;
                    z5 = subPbModel9.aPF();
                    subPbModel10 = this.erC.erl;
                    arrayList2 = subPbModel10.aPE();
                } else {
                    concurrentHashMap2 = concurrentHashMap3;
                    arrayList2 = arrayList3;
                    z5 = z4;
                }
                this.erC.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(this.erC.getPageContext().getPageActivity()).createConfig(arrayList2, 0, str8, str9, str3, z5, arrayList2.get(0), true, concurrentHashMap2, true, false, false)));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
