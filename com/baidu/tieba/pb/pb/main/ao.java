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
class ao implements TbRichTextView.e {
    final /* synthetic */ PbActivity enc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(PbActivity pbActivity) {
        this.enc = pbActivity;
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.e
    public void a(View view, String str, int i) {
        PbModel pbModel;
        PbModel pbModel2;
        PbModel pbModel3;
        PbModel pbModel4;
        try {
            TiebaStatic.eventStat(this.enc.getPageContext().getPageActivity(), "pic_pb", "");
            PbActivity.b bVar = new PbActivity.b();
            this.enc.a(str, i, bVar);
            if (!bVar.enw) {
                pbModel3 = this.enc.ele;
                boolean aKY = pbModel3.aKY();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = bVar.enu;
                pbModel4 = this.enc.ele;
                ImageViewerConfig createConfig = new ImageViewerConfig(this.enc.getPageContext().getPageActivity()).createConfig(bVar.ent, 0, bVar.forumName, bVar.forumId, bVar.threadId, bVar.env, bVar.ent.get(0), aKY, concurrentHashMap, true, false, pbModel4.getHostMode());
                createConfig.getIntent().putExtra("from", "pb");
                this.enc.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
            } else {
                ImageViewerConfig imageViewerConfig = new ImageViewerConfig(this.enc.getPageContext().getPageActivity());
                ArrayList<String> arrayList = bVar.ent;
                int i2 = bVar.index;
                String str2 = bVar.forumName;
                String str3 = bVar.forumId;
                String str4 = bVar.threadId;
                boolean z = bVar.env;
                String str5 = bVar.lastId;
                pbModel = this.enc.ele;
                boolean aKY2 = pbModel.aKY();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2 = bVar.enu;
                pbModel2 = this.enc.ele;
                ImageViewerConfig createConfig2 = imageViewerConfig.createConfig(arrayList, i2, str2, str3, str4, z, str5, aKY2, concurrentHashMap2, true, false, pbModel2.getHostMode());
                createConfig2.getIntent().putExtra("from", "pb");
                this.enc.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig2));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
