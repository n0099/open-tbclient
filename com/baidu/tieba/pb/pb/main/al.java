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
    final /* synthetic */ PbActivity evL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(PbActivity pbActivity) {
        this.evL = pbActivity;
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.e
    public void a(View view, String str, int i) {
        dj djVar;
        dj djVar2;
        dj djVar3;
        dj djVar4;
        try {
            TiebaStatic.eventStat(this.evL.getPageContext().getPageActivity(), "pic_pb", "");
            PbActivity.b bVar = new PbActivity.b();
            this.evL.a(str, i, bVar);
            if (!bVar.ewf) {
                djVar3 = this.evL.euf;
                boolean aQz = djVar3.aQz();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = bVar.ewd;
                djVar4 = this.evL.euf;
                ImageViewerConfig createConfig = new ImageViewerConfig(this.evL.getPageContext().getPageActivity()).createConfig(bVar.ewc, 0, bVar.forumName, bVar.forumId, bVar.threadId, bVar.ewe, bVar.ewc.get(0), aQz, concurrentHashMap, true, false, djVar4.getHostMode());
                createConfig.getIntent().putExtra("from", "pb");
                this.evL.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
            } else {
                ImageViewerConfig imageViewerConfig = new ImageViewerConfig(this.evL.getPageContext().getPageActivity());
                ArrayList<String> arrayList = bVar.ewc;
                int i2 = bVar.index;
                String str2 = bVar.forumName;
                String str3 = bVar.forumId;
                String str4 = bVar.threadId;
                boolean z = bVar.ewe;
                String str5 = bVar.lastId;
                djVar = this.evL.euf;
                boolean aQz2 = djVar.aQz();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2 = bVar.ewd;
                djVar2 = this.evL.euf;
                ImageViewerConfig createConfig2 = imageViewerConfig.createConfig(arrayList, i2, str2, str3, str4, z, str5, aQz2, concurrentHashMap2, true, false, djVar2.getHostMode());
                createConfig2.getIntent().putExtra("from", "pb");
                this.evL.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig2));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
