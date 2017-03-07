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
    final /* synthetic */ NewSubPbActivity euQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(NewSubPbActivity newSubPbActivity) {
        this.euQ = newSubPbActivity;
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.e
    public void a(View view, String str, int i) {
        SubPbModel subPbModel;
        TbRichText am;
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
            subPbModel = this.euQ.euz;
            com.baidu.tieba.pb.data.j aOE = subPbModel.aOE();
            am = this.euQ.am(str, i);
            TbRichTextData tbRichTextData = null;
            if (am != null && am.HP() != null) {
                ArrayList<TbRichTextData> HP = am.HP();
                i2 = this.euQ.elC;
                tbRichTextData = HP.get(i2);
            }
            if (tbRichTextData != null) {
                ArrayList<String> arrayList3 = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                if (tbRichTextData.HV().Ih()) {
                    this.euQ.elD = false;
                    String str4 = "";
                    TbRichText aws = aOE.aJO().aws();
                    int size = arrayList3.size();
                    a = this.euQ.a(aws, am, i, i, arrayList3, concurrentHashMap3);
                    int size2 = arrayList3.size();
                    if (size != size2) {
                        str4 = arrayList3.get(size2 - 1);
                    }
                    String str5 = null;
                    String str6 = null;
                    String str7 = null;
                    if (aOE == null) {
                        str2 = null;
                        z = false;
                    } else {
                        if (aOE.aJU() != null) {
                            str5 = aOE.aJU().getName();
                            str6 = aOE.aJU().getId();
                        }
                        if (aOE.JN() != null) {
                            str7 = aOE.JN().getId();
                        }
                        str2 = str7;
                        z = true;
                    }
                    subPbModel2 = this.euQ.euz;
                    if (subPbModel2.aOU() != null) {
                        subPbModel3 = this.euQ.euz;
                        concurrentHashMap = subPbModel3.aOU();
                        subPbModel4 = this.euQ.euz;
                        z2 = subPbModel4.aOW();
                        subPbModel5 = this.euQ.euz;
                        arrayList = subPbModel5.aOV();
                        subPbModel6 = this.euQ.euz;
                        a += subPbModel6.getOffset();
                    } else {
                        concurrentHashMap = concurrentHashMap3;
                        arrayList = arrayList3;
                        z2 = z;
                    }
                    this.euQ.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(this.euQ.getPageContext().getPageActivity()).createConfig(arrayList, a, str5, str6, str2, z2, str4, true, concurrentHashMap, true, false, false)));
                    return;
                }
                c = this.euQ.c(tbRichTextData);
                arrayList3.add(c);
                ImageUrlData imageUrlData = new ImageUrlData();
                imageUrlData.imageUrl = str;
                z3 = this.euQ.mIsFromCDN;
                imageUrlData.urlType = z3 ? 17 : 18;
                concurrentHashMap3.put(c, imageUrlData);
                String str8 = null;
                String str9 = null;
                String str10 = null;
                if (aOE == null) {
                    str3 = null;
                    z4 = false;
                } else {
                    if (aOE.aJU() != null) {
                        str8 = aOE.aJU().getName();
                        str9 = aOE.aJU().getId();
                    }
                    if (aOE.JN() != null) {
                        str10 = aOE.JN().getId();
                    }
                    str3 = str10;
                    z4 = true;
                }
                subPbModel7 = this.euQ.euz;
                if (subPbModel7.aOU() != null) {
                    subPbModel8 = this.euQ.euz;
                    concurrentHashMap2 = subPbModel8.aOU();
                    subPbModel9 = this.euQ.euz;
                    z5 = subPbModel9.aOW();
                    subPbModel10 = this.euQ.euz;
                    arrayList2 = subPbModel10.aOV();
                } else {
                    concurrentHashMap2 = concurrentHashMap3;
                    arrayList2 = arrayList3;
                    z5 = z4;
                }
                this.euQ.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(this.euQ.getPageContext().getPageActivity()).createConfig(arrayList2, 0, str8, str9, str3, z5, arrayList2.get(0), true, concurrentHashMap2, true, false, false)));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
