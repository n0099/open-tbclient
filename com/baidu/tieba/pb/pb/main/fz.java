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
public class fz implements a.InterfaceC0072a {
    final /* synthetic */ fx evi;
    private final /* synthetic */ com.baidu.tieba.pb.pb.main.emotion.a evj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fz(fx fxVar, com.baidu.tieba.pb.pb.main.emotion.a aVar) {
        this.evi = fxVar;
        this.evj = aVar;
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.view.a.InterfaceC0072a
    public void c(EmotionImageData emotionImageData) {
        if (this.evj != null) {
            this.evj.b(emotionImageData);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.view.a.InterfaceC0072a
    public void bW(List<String> list) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        pbActivity = this.evi.elf;
        CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbSearchEmotionActivityConfig(pbActivity.getPageContext().getPageActivity(), 25016, (ArrayList) list));
        pbActivity2 = this.evi.elf;
        pbActivity2.sendMessage(customMessage);
    }
}
