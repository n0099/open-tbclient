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
    final /* synthetic */ NewSubPbActivity esV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(NewSubPbActivity newSubPbActivity) {
        this.esV = newSubPbActivity;
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
            subPbModel = this.esV.esE;
            com.baidu.tieba.pb.data.j aON = subPbModel.aON();
            am = this.esV.am(str, i);
            TbRichTextData tbRichTextData = null;
            if (am != null && am.Io() != null) {
                ArrayList<TbRichTextData> Io = am.Io();
                i2 = this.esV.ejI;
                tbRichTextData = Io.get(i2);
            }
            if (tbRichTextData != null) {
                ArrayList<String> arrayList3 = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                if (tbRichTextData.Iu().IG()) {
                    this.esV.ejJ = false;
                    String str4 = "";
                    TbRichText awl = aON.aJV().awl();
                    int size = arrayList3.size();
                    a = this.esV.a(awl, am, i, i, arrayList3, concurrentHashMap3);
                    int size2 = arrayList3.size();
                    if (size != size2) {
                        str4 = arrayList3.get(size2 - 1);
                    }
                    String str5 = null;
                    String str6 = null;
                    String str7 = null;
                    if (aON == null) {
                        str2 = null;
                        z = false;
                    } else {
                        if (aON.aKb() != null) {
                            str5 = aON.aKb().getName();
                            str6 = aON.aKb().getId();
                        }
                        if (aON.Kn() != null) {
                            str7 = aON.Kn().getId();
                        }
                        str2 = str7;
                        z = true;
                    }
                    subPbModel2 = this.esV.esE;
                    if (subPbModel2.aPd() != null) {
                        subPbModel3 = this.esV.esE;
                        concurrentHashMap = subPbModel3.aPd();
                        subPbModel4 = this.esV.esE;
                        z2 = subPbModel4.aPf();
                        subPbModel5 = this.esV.esE;
                        arrayList = subPbModel5.aPe();
                        subPbModel6 = this.esV.esE;
                        a += subPbModel6.getOffset();
                    } else {
                        concurrentHashMap = concurrentHashMap3;
                        arrayList = arrayList3;
                        z2 = z;
                    }
                    this.esV.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(this.esV.getPageContext().getPageActivity()).createConfig(arrayList, a, str5, str6, str2, z2, str4, true, concurrentHashMap, true, false, false)));
                    return;
                }
                c = this.esV.c(tbRichTextData);
                arrayList3.add(c);
                ImageUrlData imageUrlData = new ImageUrlData();
                imageUrlData.imageUrl = str;
                z3 = this.esV.mIsFromCDN;
                imageUrlData.urlType = z3 ? 17 : 18;
                concurrentHashMap3.put(c, imageUrlData);
                String str8 = null;
                String str9 = null;
                String str10 = null;
                if (aON == null) {
                    str3 = null;
                    z4 = false;
                } else {
                    if (aON.aKb() != null) {
                        str8 = aON.aKb().getName();
                        str9 = aON.aKb().getId();
                    }
                    if (aON.Kn() != null) {
                        str10 = aON.Kn().getId();
                    }
                    str3 = str10;
                    z4 = true;
                }
                subPbModel7 = this.esV.esE;
                if (subPbModel7.aPd() != null) {
                    subPbModel8 = this.esV.esE;
                    concurrentHashMap2 = subPbModel8.aPd();
                    subPbModel9 = this.esV.esE;
                    z5 = subPbModel9.aPf();
                    subPbModel10 = this.esV.esE;
                    arrayList2 = subPbModel10.aPe();
                } else {
                    concurrentHashMap2 = concurrentHashMap3;
                    arrayList2 = arrayList3;
                    z5 = z4;
                }
                this.esV.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(this.esV.getPageContext().getPageActivity()).createConfig(arrayList2, 0, str8, str9, str3, z5, arrayList2.get(0), true, concurrentHashMap2, true, false, false)));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
