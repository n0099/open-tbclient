package com.baidu.tieba.pb.main;

import android.view.View;
import com.baidu.tbadk.gif.GifView;
/* loaded from: classes.dex */
final class v implements com.baidu.tbadk.widget.richText.q {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // com.baidu.tbadk.widget.richText.q
    public final void a(View view, String str, String str2, String str3, String str4, String str5, String str6, int i, int i2) {
        bm bmVar;
        com.baidu.tbadk.imageManager.d dVar;
        com.baidu.adp.widget.ImageView.b a;
        bm bmVar2;
        com.baidu.tbadk.imageManager.d dVar2;
        GifView gifView = (GifView) view;
        com.baidu.tbadk.widget.richText.e tbRichTextEmotionINfo = gifView.getTbRichTextEmotionINfo();
        view.setTag(tbRichTextEmotionINfo.c);
        if (tbRichTextEmotionINfo.j || tbRichTextEmotionINfo.k) {
            tbRichTextEmotionINfo.j = false;
            tbRichTextEmotionINfo.k = false;
            if (com.baidu.tbadk.core.util.b.b()) {
                bmVar2 = this.a.D;
                com.baidu.tbadk.editortool.ab a2 = bmVar2.l().a();
                dVar2 = this.a.am;
                a = a2.a(str, str6, str5, true, dVar2);
            } else {
                bmVar = this.a.D;
                com.baidu.tbadk.editortool.ab a3 = bmVar.l().a();
                dVar = this.a.am;
                a = a3.a(str, str6, str4, false, dVar);
            }
            if (a == null) {
                gifView.setIsLoading(true);
                return;
            }
            gifView.setGif(a);
            gifView.setIsLoading(false);
            tbRichTextEmotionINfo.j = false;
            return;
        }
        this.a.sendMessage(new com.baidu.adp.framework.message.a(2001001, new com.baidu.tbadk.core.b.h(this.a, str, str2, str3, str4, str5, str6, 1, i, i2)));
    }
}
