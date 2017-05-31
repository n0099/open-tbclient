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
    final /* synthetic */ NewSubPbActivity eye;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(NewSubPbActivity newSubPbActivity) {
        this.eye = newSubPbActivity;
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
            subPbModel = this.eye.exN;
            com.baidu.tieba.pb.data.n aOn = subPbModel.aOn();
            an = this.eye.an(str, i);
            TbRichTextData tbRichTextData = null;
            if (an != null && an.Hx() != null) {
                ArrayList<TbRichTextData> Hx = an.Hx();
                i2 = this.eye.emQ;
                tbRichTextData = Hx.get(i2);
            }
            if (tbRichTextData != null) {
                ArrayList<String> arrayList3 = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                if (tbRichTextData.HD().HP()) {
                    this.eye.emR = false;
                    String str4 = "";
                    TbRichText avd = aOn.aJj().avd();
                    int size = arrayList3.size();
                    a = this.eye.a(avd, an, i, i, arrayList3, concurrentHashMap3);
                    int size2 = arrayList3.size();
                    if (size != size2) {
                        str4 = arrayList3.get(size2 - 1);
                    }
                    String str5 = null;
                    String str6 = null;
                    String str7 = null;
                    if (aOn == null) {
                        str2 = null;
                        z = false;
                    } else {
                        if (aOn.aJp() != null) {
                            str5 = aOn.aJp().getName();
                            str6 = aOn.aJp().getId();
                        }
                        if (aOn.LH() != null) {
                            str7 = aOn.LH().getId();
                        }
                        str2 = str7;
                        z = true;
                    }
                    subPbModel2 = this.eye.exN;
                    if (subPbModel2.aOD() != null) {
                        subPbModel3 = this.eye.exN;
                        concurrentHashMap = subPbModel3.aOD();
                        subPbModel4 = this.eye.exN;
                        z2 = subPbModel4.aOF();
                        subPbModel5 = this.eye.exN;
                        arrayList = subPbModel5.aOE();
                        subPbModel6 = this.eye.exN;
                        a += subPbModel6.getOffset();
                    } else {
                        concurrentHashMap = concurrentHashMap3;
                        arrayList = arrayList3;
                        z2 = z;
                    }
                    this.eye.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(this.eye.getPageContext().getPageActivity()).createConfig(arrayList, a, str5, str6, str2, z2, str4, true, concurrentHashMap, true, false, false)));
                    return;
                }
                c = this.eye.c(tbRichTextData);
                arrayList3.add(c);
                ImageUrlData imageUrlData = new ImageUrlData();
                imageUrlData.imageUrl = str;
                z3 = this.eye.mIsFromCDN;
                imageUrlData.urlType = z3 ? 17 : 18;
                concurrentHashMap3.put(c, imageUrlData);
                String str8 = null;
                String str9 = null;
                String str10 = null;
                if (aOn == null) {
                    str3 = null;
                    z4 = false;
                } else {
                    if (aOn.aJp() != null) {
                        str8 = aOn.aJp().getName();
                        str9 = aOn.aJp().getId();
                    }
                    if (aOn.LH() != null) {
                        str10 = aOn.LH().getId();
                    }
                    str3 = str10;
                    z4 = true;
                }
                subPbModel7 = this.eye.exN;
                if (subPbModel7.aOD() != null) {
                    subPbModel8 = this.eye.exN;
                    concurrentHashMap2 = subPbModel8.aOD();
                    subPbModel9 = this.eye.exN;
                    z5 = subPbModel9.aOF();
                    subPbModel10 = this.eye.exN;
                    arrayList2 = subPbModel10.aOE();
                } else {
                    concurrentHashMap2 = concurrentHashMap3;
                    arrayList2 = arrayList3;
                    z5 = z4;
                }
                this.eye.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(this.eye.getPageContext().getPageActivity()).createConfig(arrayList2, 0, str8, str9, str3, z5, arrayList2.get(0), true, concurrentHashMap2, true, false, false)));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
