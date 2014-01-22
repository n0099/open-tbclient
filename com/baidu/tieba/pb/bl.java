package com.baidu.tieba.pb;

import android.view.View;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tieba.data.emotions.EmotionImageActivity;
/* loaded from: classes.dex */
class bl implements com.baidu.tbadk.widget.richText.q {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // com.baidu.tbadk.widget.richText.q
    public void a(View view, String str, String str2, String str3, String str4, String str5, String str6, int i, int i2) {
        cr crVar;
        com.baidu.tbadk.imageManager.c cVar;
        com.baidu.adp.widget.ImageView.d a;
        cr crVar2;
        com.baidu.tbadk.imageManager.c cVar2;
        GifView gifView = (GifView) view;
        com.baidu.tbadk.widget.richText.e tbRichTextEmotionINfo = gifView.getTbRichTextEmotionINfo();
        view.setTag(tbRichTextEmotionINfo.c);
        if (tbRichTextEmotionINfo.j) {
            tbRichTextEmotionINfo.j = false;
            if (com.baidu.tieba.util.i.b()) {
                crVar2 = this.a.A;
                com.baidu.tieba.util.i a2 = crVar2.i().a();
                cVar2 = this.a.ab;
                a = a2.a(str, str6, str5, true, cVar2);
            } else {
                crVar = this.a.A;
                com.baidu.tieba.util.i a3 = crVar.i().a();
                cVar = this.a.ab;
                a = a3.a(str, str6, str4, false, cVar);
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
