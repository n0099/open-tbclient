package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.imageManager.f;
import com.baidu.tbadk.widget.richText.TbRichTextMemeInfo;
/* loaded from: classes.dex */
class at implements c.b {
    final /* synthetic */ PbActivity ewh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(PbActivity pbActivity) {
        this.ewh = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        com.baidu.adp.widget.a.a aVar;
        String str;
        hs hsVar;
        hs hsVar2;
        String str2;
        com.baidu.adp.widget.a.a aVar2;
        TbRichTextMemeInfo tbRichTextMemeInfo;
        String str3;
        TbRichTextMemeInfo tbRichTextMemeInfo2;
        TbRichTextMemeInfo tbRichTextMemeInfo3;
        String sb;
        String str4;
        cVar.dismiss();
        aVar = this.ewh.evq;
        if (aVar != null) {
            str = this.ewh.evr;
            if (!TextUtils.isEmpty(str)) {
                if (i == 0) {
                    tbRichTextMemeInfo = this.ewh.evs;
                    if (tbRichTextMemeInfo == null) {
                        MessageManager messageManager = MessageManager.getInstance();
                        str4 = this.ewh.evr;
                        messageManager.dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, str4));
                    } else {
                        f.a aVar3 = new f.a();
                        str3 = this.ewh.evr;
                        aVar3.url = str3;
                        tbRichTextMemeInfo2 = this.ewh.evs;
                        if (tbRichTextMemeInfo2.memeInfo.pck_id.intValue() < 0) {
                            sb = "";
                        } else {
                            StringBuilder sb2 = new StringBuilder();
                            tbRichTextMemeInfo3 = this.ewh.evs;
                            sb = sb2.append(tbRichTextMemeInfo3.memeInfo.pck_id).toString();
                        }
                        aVar3.aDX = sb;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar3));
                    }
                } else if (i == 1) {
                    hsVar = this.ewh.evp;
                    if (hsVar == null) {
                        this.ewh.evp = new hs(this.ewh.getPageContext());
                    }
                    hsVar2 = this.ewh.evp;
                    str2 = this.ewh.evr;
                    aVar2 = this.ewh.evq;
                    hsVar2.h(str2, aVar2.kS());
                }
                this.ewh.evq = null;
                this.ewh.evr = null;
            }
        }
    }
}
