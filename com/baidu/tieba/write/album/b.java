package com.baidu.tieba.write.album;

import android.graphics.BitmapFactory;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements y {
    final /* synthetic */ AlbumActivity eGN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AlbumActivity albumActivity) {
        this.eGN = albumActivity;
    }

    @Override // com.baidu.tieba.write.album.y
    public boolean e(ImageFileInfo imageFileInfo) {
        if (imageFileInfo != null) {
            String filePath = imageFileInfo.getFilePath();
            if (!StringUtils.isNULL(filePath)) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(filePath, options);
                int i = options.outWidth;
                if (options.outHeight >= 200 && i >= 200) {
                    return true;
                }
            }
        }
        this.eGN.showToastWithIcon(this.eGN.getPageContext().getPageActivity().getString(t.j.uploade_attation), t.f.icon_toast_game_error);
        return false;
    }
}
