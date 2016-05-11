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
class ah implements TbRichTextView.d {
    final /* synthetic */ PbActivity djE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(PbActivity pbActivity) {
        this.djE = pbActivity;
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.d
    public void a(View view, String str, int i) {
        cw cwVar;
        cw cwVar2;
        cw cwVar3;
        cw cwVar4;
        try {
            TiebaStatic.eventStat(this.djE.getPageContext().getPageActivity(), "pic_pb", "");
            PbActivity.b bVar = new PbActivity.b();
            this.djE.a(str, i, bVar);
            if (!bVar.djV) {
                cwVar3 = this.djE.dih;
                boolean axL = cwVar3.axL();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = bVar.djT;
                cwVar4 = this.djE.dih;
                ImageViewerConfig createConfig = new ImageViewerConfig(this.djE.getPageContext().getPageActivity()).createConfig(bVar.djS, 0, bVar.forumName, bVar.forumId, bVar.threadId, bVar.djU, bVar.djS.get(0), axL, concurrentHashMap, true, false, cwVar4.getHostMode());
                createConfig.getIntent().putExtra("from", "pb");
                this.djE.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
            } else {
                ImageViewerConfig imageViewerConfig = new ImageViewerConfig(this.djE.getPageContext().getPageActivity());
                ArrayList<String> arrayList = bVar.djS;
                int i2 = bVar.index;
                String str2 = bVar.forumName;
                String str3 = bVar.forumId;
                String str4 = bVar.threadId;
                boolean z = bVar.djU;
                String str5 = bVar.lastId;
                cwVar = this.djE.dih;
                boolean axL2 = cwVar.axL();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2 = bVar.djT;
                cwVar2 = this.djE.dih;
                ImageViewerConfig createConfig2 = imageViewerConfig.createConfig(arrayList, i2, str2, str3, str4, z, str5, axL2, concurrentHashMap2, true, false, cwVar2.getHostMode());
                createConfig2.getIntent().putExtra("from", "pb");
                this.djE.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig2));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
