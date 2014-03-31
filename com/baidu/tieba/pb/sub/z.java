package com.baidu.tieba.pb.sub;

import android.view.View;
import com.baidu.tbadk.gif.GifView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class z implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ m a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(m mVar) {
        this.a = mVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public final void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        View findViewWithTag = this.a.n.findViewWithTag(str);
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
            findViewWithTag = this.a.n.findViewWithTag(str);
        }
    }
}
