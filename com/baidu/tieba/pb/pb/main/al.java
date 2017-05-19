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
class al implements TbRichTextView.e {
    final /* synthetic */ PbActivity ehy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(PbActivity pbActivity) {
        this.ehy = pbActivity;
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.e
    public void a(View view, String str, int i) {
        PbModel pbModel;
        PbModel pbModel2;
        PbModel pbModel3;
        PbModel pbModel4;
        try {
            TiebaStatic.eventStat(this.ehy.getPageContext().getPageActivity(), "pic_pb", "");
            PbActivity.b bVar = new PbActivity.b();
            this.ehy.a(str, i, bVar);
            if (!bVar.ehS) {
                pbModel3 = this.ehy.efE;
                boolean aKe = pbModel3.aKe();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = bVar.ehQ;
                pbModel4 = this.ehy.efE;
                ImageViewerConfig createConfig = new ImageViewerConfig(this.ehy.getPageContext().getPageActivity()).createConfig(bVar.ehP, 0, bVar.forumName, bVar.forumId, bVar.threadId, bVar.ehR, bVar.ehP.get(0), aKe, concurrentHashMap, true, false, pbModel4.getHostMode());
                createConfig.getIntent().putExtra("from", "pb");
                this.ehy.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
            } else {
                ImageViewerConfig imageViewerConfig = new ImageViewerConfig(this.ehy.getPageContext().getPageActivity());
                ArrayList<String> arrayList = bVar.ehP;
                int i2 = bVar.index;
                String str2 = bVar.forumName;
                String str3 = bVar.forumId;
                String str4 = bVar.threadId;
                boolean z = bVar.ehR;
                String str5 = bVar.lastId;
                pbModel = this.ehy.efE;
                boolean aKe2 = pbModel.aKe();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2 = bVar.ehQ;
                pbModel2 = this.ehy.efE;
                ImageViewerConfig createConfig2 = imageViewerConfig.createConfig(arrayList, i2, str2, str3, str4, z, str5, aKe2, concurrentHashMap2, true, false, pbModel2.getHostMode());
                createConfig2.getIntent().putExtra("from", "pb");
                this.ehy.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig2));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
