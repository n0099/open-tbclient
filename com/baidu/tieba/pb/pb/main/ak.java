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
    final /* synthetic */ PbActivity ejU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(PbActivity pbActivity) {
        this.ejU = pbActivity;
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.e
    public void a(View view, String str, int i) {
        PbModel pbModel;
        PbModel pbModel2;
        PbModel pbModel3;
        PbModel pbModel4;
        try {
            TiebaStatic.eventStat(this.ejU.getPageContext().getPageActivity(), "pic_pb", "");
            PbActivity.b bVar = new PbActivity.b();
            this.ejU.a(str, i, bVar);
            if (!bVar.eko) {
                pbModel3 = this.ejU.eif;
                boolean aLO = pbModel3.aLO();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = bVar.ekm;
                pbModel4 = this.ejU.eif;
                ImageViewerConfig createConfig = new ImageViewerConfig(this.ejU.getPageContext().getPageActivity()).createConfig(bVar.ekl, 0, bVar.forumName, bVar.forumId, bVar.threadId, bVar.ekn, bVar.ekl.get(0), aLO, concurrentHashMap, true, false, pbModel4.getHostMode());
                createConfig.getIntent().putExtra("from", "pb");
                this.ejU.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
            } else {
                ImageViewerConfig imageViewerConfig = new ImageViewerConfig(this.ejU.getPageContext().getPageActivity());
                ArrayList<String> arrayList = bVar.ekl;
                int i2 = bVar.index;
                String str2 = bVar.forumName;
                String str3 = bVar.forumId;
                String str4 = bVar.threadId;
                boolean z = bVar.ekn;
                String str5 = bVar.lastId;
                pbModel = this.ejU.eif;
                boolean aLO2 = pbModel.aLO();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2 = bVar.ekm;
                pbModel2 = this.ejU.eif;
                ImageViewerConfig createConfig2 = imageViewerConfig.createConfig(arrayList, i2, str2, str3, str4, z, str5, aLO2, concurrentHashMap2, true, false, pbModel2.getHostMode());
                createConfig2.getIntent().putExtra("from", "pb");
                this.ejU.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig2));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
