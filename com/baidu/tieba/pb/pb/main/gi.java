package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PbSearchEmotionActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.main.emotion.data.EmotionImageData;
import com.baidu.tieba.pb.pb.main.emotion.view.a;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class gi implements a.InterfaceC0075a {
    final /* synthetic */ gg eEv;
    private final /* synthetic */ com.baidu.tieba.pb.pb.main.emotion.a eEw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gi(gg ggVar, com.baidu.tieba.pb.pb.main.emotion.a aVar) {
        this.eEv = ggVar;
        this.eEw = aVar;
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.view.a.InterfaceC0075a
    public void c(EmotionImageData emotionImageData) {
        if (this.eEw != null) {
            this.eEw.b(emotionImageData);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.view.a.InterfaceC0075a
    public void cl(List<String> list) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        pbActivity = this.eEv.euf;
        CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbSearchEmotionActivityConfig(pbActivity.getPageContext().getPageActivity(), 25016, (ArrayList) list));
        pbActivity2 = this.eEv.euf;
        pbActivity2.sendMessage(customMessage);
    }
}
