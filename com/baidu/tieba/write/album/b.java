package com.baidu.tieba.write.album;

import android.graphics.BitmapFactory;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements y {
    final /* synthetic */ AlbumActivity fCK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AlbumActivity albumActivity) {
        this.fCK = albumActivity;
    }

    @Override // com.baidu.tieba.write.album.y
    public boolean f(ImageFileInfo imageFileInfo) {
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
        this.fCK.showToastWithIcon(this.fCK.getPageContext().getPageActivity().getString(u.j.uploade_attation), u.f.icon_toast_game_error);
        return false;
    }
}
