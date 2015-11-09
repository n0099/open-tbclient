package com.baidu.tieba.write.album;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements w {
    final /* synthetic */ AlbumActivity dlC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AlbumActivity albumActivity) {
        this.dlC = albumActivity;
    }

    @Override // com.baidu.tieba.write.album.w
    public boolean e(ImageFileInfo imageFileInfo) {
        if (imageFileInfo != null) {
            String filePath = imageFileInfo.getFilePath();
            if (!StringUtils.isNULL(filePath)) {
                Bitmap decodeFile = BitmapFactory.decodeFile(filePath);
                int width = decodeFile.getWidth();
                int height = decodeFile.getHeight();
                decodeFile.recycle();
                if (height >= 200 && width >= 200) {
                    return true;
                }
            }
        }
        this.dlC.showToastWithIcon(this.dlC.getPageContext().getPageActivity().getString(i.h.uploade_attation), i.e.icon_toast_game_error);
        return false;
    }
}
