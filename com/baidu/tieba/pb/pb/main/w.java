package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
class w implements TbRichTextView.d {
    final /* synthetic */ PbActivity cFS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(PbActivity pbActivity) {
        this.cFS = pbActivity;
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.d
    public void a(View view, String str, int i) {
        cf cfVar;
        com.baidu.tbadk.widget.richText.a ac;
        int i2;
        cf cfVar2;
        cf cfVar3;
        String d;
        boolean z;
        String b;
        long c;
        cf cfVar4;
        cf cfVar5;
        cf cfVar6;
        cf cfVar7;
        try {
            TiebaStatic.eventStat(this.cFS.getPageContext().getPageActivity(), "pic_pb", "");
            cfVar = this.cFS.cFl;
            com.baidu.tieba.pb.a.c pbData = cfVar.getPbData();
            ac = this.cFS.ac(str, i);
            ArrayList<com.baidu.tbadk.widget.richText.c> FA = ac.FA();
            i2 = this.cFS.cFM;
            com.baidu.tbadk.widget.richText.c cVar = FA.get(i2);
            if (cVar != null) {
                ArrayList<String> arrayList = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                if (cVar.FF().FP()) {
                    int size = pbData.akI().size();
                    this.cFS.cFN = false;
                    String str2 = "";
                    int i3 = i;
                    for (int i4 = 0; i4 < size; i4++) {
                        com.baidu.tieba.tbadkCore.data.r rVar = pbData.akI().get(i4);
                        com.baidu.tbadk.widget.richText.a aFr = rVar.aFr();
                        if (!dj.e(rVar)) {
                            i3 = this.cFS.a(aFr, ac, i3, i, arrayList, concurrentHashMap);
                        } else {
                            i3 = this.cFS.a(rVar, i3, arrayList, concurrentHashMap);
                        }
                        ArrayList<com.baidu.tieba.tbadkCore.data.r> aFp = rVar.aFp();
                        int i5 = 0;
                        while (true) {
                            int i6 = i5;
                            if (i6 >= aFp.size()) {
                                break;
                            }
                            i3 = this.cFS.a(aFp.get(i6).aFr(), ac, i3, i, arrayList, concurrentHashMap);
                            i5 = i6 + 1;
                        }
                    }
                    if (arrayList.size() > 0) {
                        str2 = arrayList.get(arrayList.size() - 1);
                    }
                    String str3 = null;
                    String str4 = null;
                    String str5 = null;
                    boolean z2 = false;
                    if (pbData != null) {
                        if (pbData.akG() != null) {
                            str3 = pbData.akG().getName();
                            str4 = pbData.akG().getId();
                        }
                        if (pbData.akH() != null) {
                            str5 = pbData.akH().getId();
                        }
                        z2 = pbData.akM() == 1;
                    }
                    ImageViewerConfig imageViewerConfig = new ImageViewerConfig(this.cFS.getPageContext().getPageActivity());
                    cfVar2 = this.cFS.cFl;
                    boolean alW = cfVar2.alW();
                    cfVar3 = this.cFS.cFl;
                    ImageViewerConfig createConfig = imageViewerConfig.createConfig(arrayList, i3, str3, str4, str5, z2, str2, alW, concurrentHashMap, true, false, cfVar3.getHostMode());
                    createConfig.getIntent().putExtra("from", "pb");
                    this.cFS.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
                    return;
                }
                d = this.cFS.d(cVar);
                arrayList.add(d);
                ImageUrlData imageUrlData = new ImageUrlData();
                imageUrlData.imageUrl = str;
                z = this.cFS.mIsFromCDN;
                imageUrlData.urlType = z ? 17 : 18;
                b = this.cFS.b(cVar);
                imageUrlData.originalUrl = b;
                c = this.cFS.c(cVar);
                imageUrlData.originalSize = c;
                imageUrlData.postId = ac.getPostId();
                cfVar4 = this.cFS.cFl;
                imageUrlData.mIsReserver = cfVar4.alW();
                cfVar5 = this.cFS.cFl;
                imageUrlData.mIsSeeHost = cfVar5.getHostMode();
                concurrentHashMap.put(d, imageUrlData);
                String str6 = null;
                String str7 = null;
                String str8 = null;
                boolean z3 = false;
                if (pbData != null) {
                    if (pbData.akG() != null) {
                        str6 = pbData.akG().getName();
                        str7 = pbData.akG().getId();
                    }
                    if (pbData.akH() != null) {
                        str8 = pbData.akH().getId();
                    }
                    z3 = pbData.akM() == 1;
                }
                imageUrlData.threadId = com.baidu.adp.lib.h.b.c(str8, -1L);
                cfVar6 = this.cFS.cFl;
                boolean alW2 = cfVar6.alW();
                cfVar7 = this.cFS.cFl;
                ImageViewerConfig createConfig2 = new ImageViewerConfig(this.cFS.getPageContext().getPageActivity()).createConfig(arrayList, 0, str6, str7, str8, z3, arrayList.get(0), alW2, concurrentHashMap, true, false, cfVar7.getHostMode());
                createConfig2.getIntent().putExtra("from", "pb");
                this.cFS.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig2));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
