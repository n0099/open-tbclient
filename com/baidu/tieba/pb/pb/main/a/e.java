package com.baidu.tieba.pb.pb.main.a;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.EmotionImageActivityConfig;
import com.baidu.tbadk.widget.richText.r;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements r {
    final /* synthetic */ a bON;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar) {
        this.bON = aVar;
    }

    @Override // com.baidu.tbadk.widget.richText.r
    public void a(View view, String str, String str2, String str3, String str4, String str5, String str6, int i, int i2) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        pbActivity = this.bON.bKZ;
        EmotionImageActivityConfig emotionImageActivityConfig = new EmotionImageActivityConfig(pbActivity.getPageContext().getPageActivity(), str, str2, str3, str4, str5, str6, 1, i, i2);
        pbActivity2 = this.bON.bKZ;
        pbActivity2.sendMessage(new CustomMessage(2902011, emotionImageActivityConfig));
    }
}
