package com.baidu.tieba.pb.pb.sub;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.EmotionImageActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.widget.richText.TbRichTextView;
/* loaded from: classes.dex */
class s implements TbRichTextView.c {
    final /* synthetic */ NewSubPbActivity doF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(NewSubPbActivity newSubPbActivity) {
        this.doF = newSubPbActivity;
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.c
    public void a(View view, String str, String str2, String str3, String str4, String str5, String str6, int i, int i2) {
        this.doF.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_EMOTIONIMAGE, new EmotionImageActivityConfig(this.doF.getPageContext().getPageActivity(), str, str2, str3, str4, str5, str6, 1, i, i2)));
    }
}
