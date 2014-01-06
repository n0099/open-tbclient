package com.baidu.tieba.pb;

import android.view.View;
import com.baidu.tbadk.gif.GifView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class en implements com.baidu.tbadk.imageManager.c {
    final /* synthetic */ ed a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public en(ed edVar) {
        this.a = edVar;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.d dVar, String str, boolean z) {
        View findViewWithTag = this.a.m.findViewWithTag(str);
        while (findViewWithTag != null) {
            GifView gifView = (GifView) findViewWithTag;
            com.baidu.tbadk.widget.richText.e tbRichTextEmotionINfo = gifView.getTbRichTextEmotionINfo();
            if (tbRichTextEmotionINfo != null) {
                if (dVar != null) {
                    tbRichTextEmotionINfo.j = false;
                } else {
                    tbRichTextEmotionINfo.j = true;
                }
            }
            gifView.setGif(dVar);
            gifView.setIsLoading(false);
            gifView.setTag(null);
            findViewWithTag = this.a.m.findViewWithTag(str);
        }
    }
}
