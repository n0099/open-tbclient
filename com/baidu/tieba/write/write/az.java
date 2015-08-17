package com.baidu.tieba.write.write;

import android.graphics.drawable.BitmapDrawable;
import android.text.style.ImageSpan;
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
import com.baidu.tbadk.imageManager.TbFaceManager;
/* loaded from: classes.dex */
class az implements TbFaceManager.a {
    final /* synthetic */ WriteActivity cUM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(WriteActivity writeActivity) {
        this.cUM = writeActivity;
    }

    @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
    public ImageSpan eY(String str) {
        com.baidu.adp.widget.a.a eF = com.baidu.tbadk.editortools.emotiontool.t.Bc().eF(str);
        if (eF == null) {
            eF = com.baidu.tbadk.editortools.emotiontool.t.Bc().al(null, str);
        }
        if (eF == null) {
            return null;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(eF.nc());
        int width = eF.getWidth();
        bitmapDrawable.setBounds(0, 0, width, width);
        bitmapDrawable.setGravity(SocialAPIErrorCodes.ERROR_INVALID_SECRET_KEY);
        return new ImageSpan(bitmapDrawable, 0);
    }
}
