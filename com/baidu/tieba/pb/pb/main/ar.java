package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.NewFaceShopActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.main.PbActivity;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
class ar implements TbRichTextView.e {
    final /* synthetic */ PbActivity ewh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(PbActivity pbActivity) {
        this.ewh = pbActivity;
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.e
    public void a(View view, String str, int i) {
        TbRichText ap;
        int i2;
        int i3;
        int i4;
        PbModel pbModel;
        PbModel pbModel2;
        PbModel pbModel3;
        PbModel pbModel4;
        TbRichText ap2;
        int i5;
        try {
            TiebaStatic.eventStat(this.ewh.getPageContext().getPageActivity(), "pic_pb", "");
            PbActivity.b bVar = new PbActivity.b();
            this.ewh.a(str, i, bVar);
            if (!bVar.ewC) {
                if (!bVar.ewB) {
                    pbModel3 = this.ewh.eue;
                    boolean aOV = pbModel3.aOV();
                    ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = bVar.ewz;
                    pbModel4 = this.ewh.eue;
                    ImageViewerConfig createConfig = new ImageViewerConfig(this.ewh.getPageContext().getPageActivity()).createConfig(bVar.ewy, 0, bVar.forumName, bVar.forumId, bVar.threadId, bVar.ewA, bVar.ewy.get(0), aOV, concurrentHashMap, true, false, pbModel4.getHostMode());
                    createConfig.getIntent().putExtra("from", "pb");
                    this.ewh.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
                    return;
                }
                ap = this.ewh.ap(str, i);
                if (ap != null) {
                    i2 = this.ewh.evU;
                    if (i2 >= 0) {
                        i3 = this.ewh.evU;
                        if (i3 < ap.HU().size()) {
                            ArrayList<TbRichTextData> HU = ap.HU();
                            i4 = this.ewh.evU;
                            String c = com.baidu.tieba.pb.data.g.c(HU.get(i4));
                            int i6 = 0;
                            while (true) {
                                int i7 = i6;
                                if (i7 >= bVar.ewy.size()) {
                                    break;
                                } else if (!bVar.ewy.get(i7).equals(c)) {
                                    i6 = i7 + 1;
                                } else {
                                    bVar.index = i7;
                                    break;
                                }
                            }
                            ImageViewerConfig imageViewerConfig = new ImageViewerConfig(this.ewh.getPageContext().getPageActivity());
                            ArrayList<String> arrayList = bVar.ewy;
                            int i8 = bVar.index;
                            String str2 = bVar.forumName;
                            String str3 = bVar.forumId;
                            String str4 = bVar.threadId;
                            boolean z = bVar.ewA;
                            String str5 = bVar.lastId;
                            pbModel = this.ewh.eue;
                            boolean aOV2 = pbModel.aOV();
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2 = bVar.ewz;
                            pbModel2 = this.ewh.eue;
                            ImageViewerConfig createConfig2 = imageViewerConfig.createConfig(arrayList, i8, str2, str3, str4, z, str5, aOV2, concurrentHashMap2, true, false, pbModel2.getHostMode());
                            createConfig2.getIntent().putExtra("from", "pb");
                            this.ewh.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig2));
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            ap2 = this.ewh.ap(str, i);
            if (ap2 != null) {
                ArrayList<TbRichTextData> HU2 = ap2.HU();
                i5 = this.ewh.evU;
                TbRichTextData tbRichTextData = HU2.get(i5);
                if (tbRichTextData != null && tbRichTextData.Ig() != null && tbRichTextData.Ig().memeInfo != null && !TextUtils.isEmpty(tbRichTextData.Ig().memeInfo.detail_link)) {
                    this.ewh.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewFaceShopActivityConfig(this.ewh.getPageContext().getPageActivity(), tbRichTextData.Ig().memeInfo.detail_link)));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
