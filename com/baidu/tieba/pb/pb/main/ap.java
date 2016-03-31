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
class ap implements TbRichTextView.d {
    final /* synthetic */ PbActivity dht;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(PbActivity pbActivity) {
        this.dht = pbActivity;
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.d
    public void a(View view, String str, int i) {
        df dfVar;
        df dfVar2;
        df dfVar3;
        df dfVar4;
        try {
            TiebaStatic.eventStat(this.dht.getPageContext().getPageActivity(), "pic_pb", "");
            PbActivity.b bVar = new PbActivity.b();
            this.dht.a(str, i, bVar);
            if (!bVar.dhN) {
                dfVar3 = this.dht.dfV;
                boolean axo = dfVar3.axo();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = bVar.dhL;
                dfVar4 = this.dht.dfV;
                ImageViewerConfig createConfig = new ImageViewerConfig(this.dht.getPageContext().getPageActivity()).createConfig(bVar.dhK, 0, bVar.forumName, bVar.forumId, bVar.threadId, bVar.dhM, bVar.dhK.get(0), axo, concurrentHashMap, true, false, dfVar4.getHostMode());
                createConfig.getIntent().putExtra("from", "pb");
                this.dht.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
            } else {
                ImageViewerConfig imageViewerConfig = new ImageViewerConfig(this.dht.getPageContext().getPageActivity());
                ArrayList<String> arrayList = bVar.dhK;
                int i2 = bVar.index;
                String str2 = bVar.forumName;
                String str3 = bVar.forumId;
                String str4 = bVar.threadId;
                boolean z = bVar.dhM;
                String str5 = bVar.lastId;
                dfVar = this.dht.dfV;
                boolean axo2 = dfVar.axo();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2 = bVar.dhL;
                dfVar2 = this.dht.dfV;
                ImageViewerConfig createConfig2 = imageViewerConfig.createConfig(arrayList, i2, str2, str3, str4, z, str5, axo2, concurrentHashMap2, true, false, dfVar2.getHostMode());
                createConfig2.getIntent().putExtra("from", "pb");
                this.dht.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig2));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
