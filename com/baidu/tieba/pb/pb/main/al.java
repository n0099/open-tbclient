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
    final /* synthetic */ PbActivity eqa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(PbActivity pbActivity) {
        this.eqa = pbActivity;
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.e
    public void a(View view, String str, int i) {
        dh dhVar;
        dh dhVar2;
        dh dhVar3;
        dh dhVar4;
        try {
            TiebaStatic.eventStat(this.eqa.getPageContext().getPageActivity(), "pic_pb", "");
            PbActivity.b bVar = new PbActivity.b();
            this.eqa.a(str, i, bVar);
            if (!bVar.eqr) {
                dhVar3 = this.eqa.eov;
                boolean aOG = dhVar3.aOG();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = bVar.eqp;
                dhVar4 = this.eqa.eov;
                ImageViewerConfig createConfig = new ImageViewerConfig(this.eqa.getPageContext().getPageActivity()).createConfig(bVar.eqo, 0, bVar.forumName, bVar.forumId, bVar.threadId, bVar.eqq, bVar.eqo.get(0), aOG, concurrentHashMap, true, false, dhVar4.getHostMode());
                createConfig.getIntent().putExtra("from", "pb");
                this.eqa.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
            } else {
                ImageViewerConfig imageViewerConfig = new ImageViewerConfig(this.eqa.getPageContext().getPageActivity());
                ArrayList<String> arrayList = bVar.eqo;
                int i2 = bVar.index;
                String str2 = bVar.forumName;
                String str3 = bVar.forumId;
                String str4 = bVar.threadId;
                boolean z = bVar.eqq;
                String str5 = bVar.lastId;
                dhVar = this.eqa.eov;
                boolean aOG2 = dhVar.aOG();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2 = bVar.eqp;
                dhVar2 = this.eqa.eov;
                ImageViewerConfig createConfig2 = imageViewerConfig.createConfig(arrayList, i2, str2, str3, str4, z, str5, aOG2, concurrentHashMap2, true, false, dhVar2.getHostMode());
                createConfig2.getIntent().putExtra("from", "pb");
                this.eqa.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig2));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
