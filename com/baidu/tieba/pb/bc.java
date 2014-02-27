package com.baidu.tieba.pb;

import android.view.View;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tieba.data.emotions.EmotionImageActivity;
/* loaded from: classes.dex */
final class bc implements com.baidu.tbadk.widget.richText.q {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // com.baidu.tbadk.widget.richText.q
    public final void a(View view, String str, String str2, String str3, String str4, String str5, String str6, int i, int i2) {
        cu cuVar;
        com.baidu.tbadk.imageManager.d dVar;
        com.baidu.adp.widget.ImageView.b a;
        cu cuVar2;
        com.baidu.tbadk.imageManager.d dVar2;
        GifView gifView = (GifView) view;
        com.baidu.tbadk.widget.richText.e tbRichTextEmotionINfo = gifView.getTbRichTextEmotionINfo();
        view.setTag(tbRichTextEmotionINfo.c);
        if (tbRichTextEmotionINfo.j || tbRichTextEmotionINfo.k) {
            tbRichTextEmotionINfo.j = false;
            tbRichTextEmotionINfo.k = false;
            if (com.baidu.tieba.util.i.b()) {
                cuVar2 = this.a.C;
                com.baidu.tieba.util.i a2 = cuVar2.g().a();
                dVar2 = this.a.ae;
                a = a2.a(str, str6, str5, true, dVar2);
            } else {
                cuVar = this.a.C;
                com.baidu.tieba.util.i a3 = cuVar.g().a();
                dVar = this.a.ae;
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
        EmotionImageActivity.a(this.a, str, str2, str3, str4, str5, str6, 1, i, i2);
    }
}
