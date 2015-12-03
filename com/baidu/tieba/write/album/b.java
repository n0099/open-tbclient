package com.baidu.tieba.write.album;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements y {
    final /* synthetic */ AlbumActivity dKG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AlbumActivity albumActivity) {
        this.dKG = albumActivity;
    }

    @Override // com.baidu.tieba.write.album.y
    public boolean c(ImageFileInfo imageFileInfo) {
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
        this.dKG.showToastWithIcon(this.dKG.getPageContext().getPageActivity().getString(n.i.uploade_attation), n.e.icon_toast_game_error);
        return false;
    }
}
