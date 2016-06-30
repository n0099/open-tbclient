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
    final /* synthetic */ PbActivity dPF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(PbActivity pbActivity) {
        this.dPF = pbActivity;
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.d
    public void a(View view, String str, int i) {
        dg dgVar;
        dg dgVar2;
        dg dgVar3;
        dg dgVar4;
        try {
            TiebaStatic.eventStat(this.dPF.getPageContext().getPageActivity(), "pic_pb", "");
            PbActivity.b bVar = new PbActivity.b();
            this.dPF.a(str, i, bVar);
            if (!bVar.dPW) {
                dgVar3 = this.dPF.dOf;
                boolean aFW = dgVar3.aFW();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = bVar.dPU;
                dgVar4 = this.dPF.dOf;
                ImageViewerConfig createConfig = new ImageViewerConfig(this.dPF.getPageContext().getPageActivity()).createConfig(bVar.dPT, 0, bVar.forumName, bVar.forumId, bVar.threadId, bVar.dPV, bVar.dPT.get(0), aFW, concurrentHashMap, true, false, dgVar4.getHostMode());
                createConfig.getIntent().putExtra("from", "pb");
                this.dPF.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
            } else {
                ImageViewerConfig imageViewerConfig = new ImageViewerConfig(this.dPF.getPageContext().getPageActivity());
                ArrayList<String> arrayList = bVar.dPT;
                int i2 = bVar.index;
                String str2 = bVar.forumName;
                String str3 = bVar.forumId;
                String str4 = bVar.threadId;
                boolean z = bVar.dPV;
                String str5 = bVar.lastId;
                dgVar = this.dPF.dOf;
                boolean aFW2 = dgVar.aFW();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2 = bVar.dPU;
                dgVar2 = this.dPF.dOf;
                ImageViewerConfig createConfig2 = imageViewerConfig.createConfig(arrayList, i2, str2, str3, str4, z, str5, aFW2, concurrentHashMap2, true, false, dgVar2.getHostMode());
                createConfig2.getIntent().putExtra("from", "pb");
                this.dPF.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig2));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
