package com.baidu.tieba.pb.main;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
/* loaded from: classes.dex */
class v implements com.baidu.tbadk.widget.richText.r {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // com.baidu.tbadk.widget.richText.r
    public void a(View view, String str, String str2, String str3, String str4, String str5, String str6, int i, int i2) {
        this.a.sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.m(this.a, str, str2, str3, str4, str5, str6, 1, i, i2)));
    }
}
