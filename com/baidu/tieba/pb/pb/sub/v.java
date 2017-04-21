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
    final /* synthetic */ NewSubPbActivity evm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(NewSubPbActivity newSubPbActivity) {
        this.evm = newSubPbActivity;
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
            subPbModel = this.evm.euV;
            com.baidu.tieba.pb.data.j aPO = subPbModel.aPO();
            am = this.evm.am(str, i);
            TbRichTextData tbRichTextData = null;
            if (am != null && am.Io() != null) {
                ArrayList<TbRichTextData> Io = am.Io();
                i2 = this.evm.elY;
                tbRichTextData = Io.get(i2);
            }
            if (tbRichTextData != null) {
                ArrayList<String> arrayList3 = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                if (tbRichTextData.Iu().IG()) {
                    this.evm.elZ = false;
                    String str4 = "";
                    TbRichText axm = aPO.aKW().axm();
                    int size = arrayList3.size();
                    a = this.evm.a(axm, am, i, i, arrayList3, concurrentHashMap3);
                    int size2 = arrayList3.size();
                    if (size != size2) {
                        str4 = arrayList3.get(size2 - 1);
                    }
                    String str5 = null;
                    String str6 = null;
                    String str7 = null;
                    if (aPO == null) {
                        str2 = null;
                        z = false;
                    } else {
                        if (aPO.aLc() != null) {
                            str5 = aPO.aLc().getName();
                            str6 = aPO.aLc().getId();
                        }
                        if (aPO.Kn() != null) {
                            str7 = aPO.Kn().getId();
                        }
                        str2 = str7;
                        z = true;
                    }
                    subPbModel2 = this.evm.euV;
                    if (subPbModel2.aQe() != null) {
                        subPbModel3 = this.evm.euV;
                        concurrentHashMap = subPbModel3.aQe();
                        subPbModel4 = this.evm.euV;
                        z2 = subPbModel4.aQg();
                        subPbModel5 = this.evm.euV;
                        arrayList = subPbModel5.aQf();
                        subPbModel6 = this.evm.euV;
                        a += subPbModel6.getOffset();
                    } else {
                        concurrentHashMap = concurrentHashMap3;
                        arrayList = arrayList3;
                        z2 = z;
                    }
                    this.evm.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(this.evm.getPageContext().getPageActivity()).createConfig(arrayList, a, str5, str6, str2, z2, str4, true, concurrentHashMap, true, false, false)));
                    return;
                }
                c = this.evm.c(tbRichTextData);
                arrayList3.add(c);
                ImageUrlData imageUrlData = new ImageUrlData();
                imageUrlData.imageUrl = str;
                z3 = this.evm.mIsFromCDN;
                imageUrlData.urlType = z3 ? 17 : 18;
                concurrentHashMap3.put(c, imageUrlData);
                String str8 = null;
                String str9 = null;
                String str10 = null;
                if (aPO == null) {
                    str3 = null;
                    z4 = false;
                } else {
                    if (aPO.aLc() != null) {
                        str8 = aPO.aLc().getName();
                        str9 = aPO.aLc().getId();
                    }
                    if (aPO.Kn() != null) {
                        str10 = aPO.Kn().getId();
                    }
                    str3 = str10;
                    z4 = true;
                }
                subPbModel7 = this.evm.euV;
                if (subPbModel7.aQe() != null) {
                    subPbModel8 = this.evm.euV;
                    concurrentHashMap2 = subPbModel8.aQe();
                    subPbModel9 = this.evm.euV;
                    z5 = subPbModel9.aQg();
                    subPbModel10 = this.evm.euV;
                    arrayList2 = subPbModel10.aQf();
                } else {
                    concurrentHashMap2 = concurrentHashMap3;
                    arrayList2 = arrayList3;
                    z5 = z4;
                }
                this.evm.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(this.evm.getPageContext().getPageActivity()).createConfig(arrayList2, 0, str8, str9, str3, z5, arrayList2.get(0), true, concurrentHashMap2, true, false, false)));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
