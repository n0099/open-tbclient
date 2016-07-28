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
class ak implements TbRichTextView.d {
    final /* synthetic */ PbActivity ebT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(PbActivity pbActivity) {
        this.ebT = pbActivity;
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.d
    public void a(View view, String str, int i) {
        dh dhVar;
        dh dhVar2;
        dh dhVar3;
        dh dhVar4;
        try {
            TiebaStatic.eventStat(this.ebT.getPageContext().getPageActivity(), "pic_pb", "");
            PbActivity.b bVar = new PbActivity.b();
            this.ebT.a(str, i, bVar);
            if (!bVar.eck) {
                dhVar3 = this.ebT.eas;
                boolean aJh = dhVar3.aJh();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = bVar.eci;
                dhVar4 = this.ebT.eas;
                ImageViewerConfig createConfig = new ImageViewerConfig(this.ebT.getPageContext().getPageActivity()).createConfig(bVar.ech, 0, bVar.forumName, bVar.forumId, bVar.threadId, bVar.ecj, bVar.ech.get(0), aJh, concurrentHashMap, true, false, dhVar4.getHostMode());
                createConfig.getIntent().putExtra("from", "pb");
                this.ebT.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
            } else {
                ImageViewerConfig imageViewerConfig = new ImageViewerConfig(this.ebT.getPageContext().getPageActivity());
                ArrayList<String> arrayList = bVar.ech;
                int i2 = bVar.index;
                String str2 = bVar.forumName;
                String str3 = bVar.forumId;
                String str4 = bVar.threadId;
                boolean z = bVar.ecj;
                String str5 = bVar.lastId;
                dhVar = this.ebT.eas;
                boolean aJh2 = dhVar.aJh();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2 = bVar.eci;
                dhVar2 = this.ebT.eas;
                ImageViewerConfig createConfig2 = imageViewerConfig.createConfig(arrayList, i2, str2, str3, str4, z, str5, aJh2, concurrentHashMap2, true, false, dhVar2.getHostMode());
                createConfig2.getIntent().putExtra("from", "pb");
                this.ebT.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig2));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
