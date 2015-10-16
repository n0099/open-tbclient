package com.baidu.tieba.write.write;

import android.graphics.drawable.BitmapDrawable;
import android.text.style.ImageSpan;
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
import com.baidu.tbadk.imageManager.TbFaceManager;
/* loaded from: classes.dex */
class bc implements TbFaceManager.a {
    final /* synthetic */ WriteActivity dqi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(WriteActivity writeActivity) {
        this.dqi = writeActivity;
    }

    @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
    public ImageSpan fl(String str) {
        com.baidu.adp.widget.a.a eS = com.baidu.tbadk.editortools.emotiontool.r.Bc().eS(str);
        if (eS == null) {
            eS = com.baidu.tbadk.editortools.emotiontool.r.Bc().al(null, str);
        }
        if (eS == null) {
            return null;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(eS.na());
        int width = eS.getWidth();
        bitmapDrawable.setBounds(0, 0, width, width);
        bitmapDrawable.setGravity(SocialAPIErrorCodes.ERROR_INVALID_SECRET_KEY);
        return new ImageSpan(bitmapDrawable, 0);
    }
}
