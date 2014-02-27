package com.baidu.tieba.pb;

import android.view.View;
import com.baidu.tbadk.gif.GifView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class eo implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ ed a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public eo(ed edVar) {
        this.a = edVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public final void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        View findViewWithTag = this.a.m.findViewWithTag(str);
        while (findViewWithTag != null) {
            GifView gifView = (GifView) findViewWithTag;
            com.baidu.tbadk.widget.richText.e tbRichTextEmotionINfo = gifView.getTbRichTextEmotionINfo();
            if (tbRichTextEmotionINfo != null) {
                if (bVar != null) {
                    tbRichTextEmotionINfo.j = false;
                } else {
                    tbRichTextEmotionINfo.j = true;
                }
            }
            gifView.setGif(bVar);
            gifView.setIsLoading(false);
            gifView.setTag(null);
            findViewWithTag = this.a.m.findViewWithTag(str);
        }
    }
}
