package com.baidu.tieba.pb.pb.main.a;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.EmotionImageActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements TbRichTextView.c {
    final /* synthetic */ a eiM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar) {
        this.eiM = aVar;
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.c
    public void a(View view, String str, String str2, String str3, String str4, String str5, String str6, int i, int i2) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        pbActivity = this.eiM.eat;
        EmotionImageActivityConfig emotionImageActivityConfig = new EmotionImageActivityConfig(pbActivity.getPageContext().getPageActivity(), str, str2, str3, str4, str5, str6, 1, i, i2);
        pbActivity2 = this.eiM.eat;
        pbActivity2.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_EMOTIONIMAGE, emotionImageActivityConfig));
    }
}
