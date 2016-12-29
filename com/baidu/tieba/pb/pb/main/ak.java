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
class ak implements TbRichTextView.e {
    final /* synthetic */ PbActivity eah;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(PbActivity pbActivity) {
        this.eah = pbActivity;
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.e
    public void a(View view, String str, int i) {
        dc dcVar;
        dc dcVar2;
        dc dcVar3;
        dc dcVar4;
        try {
            TiebaStatic.eventStat(this.eah.getPageContext().getPageActivity(), "pic_pb", "");
            PbActivity.b bVar = new PbActivity.b();
            this.eah.a(str, i, bVar);
            if (!bVar.eaB) {
                dcVar3 = this.eah.dYA;
                boolean aKw = dcVar3.aKw();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = bVar.eaz;
                dcVar4 = this.eah.dYA;
                ImageViewerConfig createConfig = new ImageViewerConfig(this.eah.getPageContext().getPageActivity()).createConfig(bVar.eay, 0, bVar.forumName, bVar.forumId, bVar.threadId, bVar.eaA, bVar.eay.get(0), aKw, concurrentHashMap, true, false, dcVar4.getHostMode());
                createConfig.getIntent().putExtra("from", "pb");
                this.eah.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
            } else {
                ImageViewerConfig imageViewerConfig = new ImageViewerConfig(this.eah.getPageContext().getPageActivity());
                ArrayList<String> arrayList = bVar.eay;
                int i2 = bVar.index;
                String str2 = bVar.forumName;
                String str3 = bVar.forumId;
                String str4 = bVar.threadId;
                boolean z = bVar.eaA;
                String str5 = bVar.lastId;
                dcVar = this.eah.dYA;
                boolean aKw2 = dcVar.aKw();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2 = bVar.eaz;
                dcVar2 = this.eah.dYA;
                ImageViewerConfig createConfig2 = imageViewerConfig.createConfig(arrayList, i2, str2, str3, str4, z, str5, aKw2, concurrentHashMap2, true, false, dcVar2.getHostMode());
                createConfig2.getIntent().putExtra("from", "pb");
                this.eah.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig2));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
