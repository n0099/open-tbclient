package com.baidu.tieba.write.write;

import android.graphics.drawable.BitmapDrawable;
import android.text.style.ImageSpan;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.editortools.emotiontool.RequestStaticEmotionMessage;
import com.baidu.tbadk.imageManager.TbFaceManager;
/* loaded from: classes.dex */
class ae implements TbFaceManager.a {
    final /* synthetic */ WriteActivity glP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(WriteActivity writeActivity) {
        this.glP = writeActivity;
    }

    @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
    public ImageSpan ga(String str) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new RequestStaticEmotionMessage(null, str), com.baidu.adp.widget.a.a.class);
        com.baidu.adp.widget.a.a aVar = runTask != null ? (com.baidu.adp.widget.a.a) runTask.getData() : null;
        if (aVar == null) {
            return null;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(aVar.kP());
        int width = aVar.getWidth();
        if (str.startsWith("#(meme,")) {
            bitmapDrawable.setBounds(0, 0, width, aVar.getHeight());
        } else {
            bitmapDrawable.setBounds(0, 0, width, width);
        }
        bitmapDrawable.setGravity(119);
        return new ImageSpan(bitmapDrawable, 0);
    }
}
