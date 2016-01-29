package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.main.PbActivity;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
class aa implements TbRichTextView.d {
    final /* synthetic */ PbActivity cNq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(PbActivity pbActivity) {
        this.cNq = pbActivity;
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.d
    public void a(View view, String str, int i) {
        cm cmVar;
        cm cmVar2;
        cm cmVar3;
        cm cmVar4;
        try {
            TiebaStatic.eventStat(this.cNq.getPageContext().getPageActivity(), "pic_pb", "");
            PbActivity.b bVar = new PbActivity.b();
            this.cNq.a(str, i, bVar);
            if (!bVar.cNJ) {
                cmVar3 = this.cNq.cMF;
                boolean apZ = cmVar3.apZ();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = bVar.cNH;
                cmVar4 = this.cNq.cMF;
                ImageViewerConfig createConfig = new ImageViewerConfig(this.cNq.getPageContext().getPageActivity()).createConfig(bVar.cNG, 0, bVar.forumName, bVar.forumId, bVar.threadId, bVar.cNI, bVar.cNG.get(0), apZ, concurrentHashMap, true, false, cmVar4.getHostMode());
                createConfig.getIntent().putExtra("from", "pb");
                this.cNq.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
            } else {
                ImageViewerConfig imageViewerConfig = new ImageViewerConfig(this.cNq.getPageContext().getPageActivity());
                ArrayList<String> arrayList = bVar.cNG;
                int i2 = bVar.index;
                String str2 = bVar.forumName;
                String str3 = bVar.forumId;
                String str4 = bVar.threadId;
                boolean z = bVar.cNI;
                String str5 = bVar.lastId;
                cmVar = this.cNq.cMF;
                boolean apZ2 = cmVar.apZ();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2 = bVar.cNH;
                cmVar2 = this.cNq.cMF;
                ImageViewerConfig createConfig2 = imageViewerConfig.createConfig(arrayList, i2, str2, str3, str4, z, str5, apZ2, concurrentHashMap2, true, false, cmVar2.getHostMode());
                createConfig2.getIntent().putExtra("from", "pb");
                this.cNq.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig2));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
