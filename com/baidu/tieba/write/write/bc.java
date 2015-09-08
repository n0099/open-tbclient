package com.baidu.tieba.write.write;

import android.graphics.drawable.BitmapDrawable;
import android.text.style.ImageSpan;
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
import com.baidu.tbadk.imageManager.TbFaceManager;
/* loaded from: classes.dex */
class bc implements TbFaceManager.a {
    final /* synthetic */ WriteActivity ddQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(WriteActivity writeActivity) {
        this.ddQ = writeActivity;
    }

    @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
    public ImageSpan fg(String str) {
        com.baidu.adp.widget.a.a eN = com.baidu.tbadk.editortools.emotiontool.t.Bp().eN(str);
        if (eN == null) {
            eN = com.baidu.tbadk.editortools.emotiontool.t.Bp().am(null, str);
        }
        if (eN == null) {
            return null;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(eN.mZ());
        int width = eN.getWidth();
        bitmapDrawable.setBounds(0, 0, width, width);
        bitmapDrawable.setGravity(SocialAPIErrorCodes.ERROR_INVALID_SECRET_KEY);
        return new ImageSpan(bitmapDrawable, 0);
    }
}
