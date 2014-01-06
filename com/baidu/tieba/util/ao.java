package com.baidu.tieba.util;

import android.view.View;
import android.widget.ListView;
import com.baidu.tbadk.gif.GifView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ao implements com.baidu.tbadk.imageManager.c {
    final /* synthetic */ ListView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(ListView listView) {
        this.a = listView;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.d dVar, String str, boolean z) {
        com.baidu.adp.lib.h.e.e("LoadImageHelper", "imageLoaded", "callback:" + str);
        View findViewWithTag = this.a.findViewWithTag(str);
        while (findViewWithTag != null) {
            com.baidu.adp.lib.h.e.e("LoadImageHelper", "imageLoaded", "gif set");
            GifView gifView = (GifView) findViewWithTag;
            com.baidu.tbadk.widget.richText.e tbRichTextEmotionINfo = gifView.getTbRichTextEmotionINfo();
            if (dVar == null) {
                if (tbRichTextEmotionINfo != null) {
                    tbRichTextEmotionINfo.j = true;
                }
            } else if (tbRichTextEmotionINfo != null) {
                tbRichTextEmotionINfo.j = false;
            }
            gifView.setGif(dVar);
            gifView.setIsLoading(false);
            gifView.setTag(null);
            findViewWithTag = this.a.findViewWithTag(str);
        }
    }
}
