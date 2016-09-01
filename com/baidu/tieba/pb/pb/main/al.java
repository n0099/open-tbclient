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
class al implements TbRichTextView.d {
    final /* synthetic */ PbActivity eob;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(PbActivity pbActivity) {
        this.eob = pbActivity;
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.d
    public void a(View view, String str, int i) {
        dh dhVar;
        dh dhVar2;
        dh dhVar3;
        dh dhVar4;
        try {
            TiebaStatic.eventStat(this.eob.getPageContext().getPageActivity(), "pic_pb", "");
            PbActivity.b bVar = new PbActivity.b();
            this.eob.a(str, i, bVar);
            if (!bVar.eot) {
                dhVar3 = this.eob.emx;
                boolean aNY = dhVar3.aNY();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = bVar.eor;
                dhVar4 = this.eob.emx;
                ImageViewerConfig createConfig = new ImageViewerConfig(this.eob.getPageContext().getPageActivity()).createConfig(bVar.eoq, 0, bVar.forumName, bVar.forumId, bVar.threadId, bVar.eos, bVar.eoq.get(0), aNY, concurrentHashMap, true, false, dhVar4.getHostMode());
                createConfig.getIntent().putExtra("from", "pb");
                this.eob.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
            } else {
                ImageViewerConfig imageViewerConfig = new ImageViewerConfig(this.eob.getPageContext().getPageActivity());
                ArrayList<String> arrayList = bVar.eoq;
                int i2 = bVar.index;
                String str2 = bVar.forumName;
                String str3 = bVar.forumId;
                String str4 = bVar.threadId;
                boolean z = bVar.eos;
                String str5 = bVar.lastId;
                dhVar = this.eob.emx;
                boolean aNY2 = dhVar.aNY();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2 = bVar.eor;
                dhVar2 = this.eob.emx;
                ImageViewerConfig createConfig2 = imageViewerConfig.createConfig(arrayList, i2, str2, str3, str4, z, str5, aNY2, concurrentHashMap2, true, false, dhVar2.getHostMode());
                createConfig2.getIntent().putExtra("from", "pb");
                this.eob.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig2));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
