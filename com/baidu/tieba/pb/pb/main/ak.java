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
    final /* synthetic */ PbActivity eiV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(PbActivity pbActivity) {
        this.eiV = pbActivity;
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.e
    public void a(View view, String str, int i) {
        PbModel pbModel;
        PbModel pbModel2;
        PbModel pbModel3;
        PbModel pbModel4;
        try {
            TiebaStatic.eventStat(this.eiV.getPageContext().getPageActivity(), "pic_pb", "");
            PbActivity.b bVar = new PbActivity.b();
            this.eiV.a(str, i, bVar);
            if (!bVar.ejq) {
                pbModel3 = this.eiV.ehh;
                boolean aMj = pbModel3.aMj();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = bVar.ejo;
                pbModel4 = this.eiV.ehh;
                ImageViewerConfig createConfig = new ImageViewerConfig(this.eiV.getPageContext().getPageActivity()).createConfig(bVar.ejn, 0, bVar.forumName, bVar.forumId, bVar.threadId, bVar.ejp, bVar.ejn.get(0), aMj, concurrentHashMap, true, false, pbModel4.getHostMode());
                createConfig.getIntent().putExtra("from", "pb");
                this.eiV.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
            } else {
                ImageViewerConfig imageViewerConfig = new ImageViewerConfig(this.eiV.getPageContext().getPageActivity());
                ArrayList<String> arrayList = bVar.ejn;
                int i2 = bVar.index;
                String str2 = bVar.forumName;
                String str3 = bVar.forumId;
                String str4 = bVar.threadId;
                boolean z = bVar.ejp;
                String str5 = bVar.lastId;
                pbModel = this.eiV.ehh;
                boolean aMj2 = pbModel.aMj();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2 = bVar.ejo;
                pbModel2 = this.eiV.ehh;
                ImageViewerConfig createConfig2 = imageViewerConfig.createConfig(arrayList, i2, str2, str3, str4, z, str5, aMj2, concurrentHashMap2, true, false, pbModel2.getHostMode());
                createConfig2.getIntent().putExtra("from", "pb");
                this.eiV.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig2));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
