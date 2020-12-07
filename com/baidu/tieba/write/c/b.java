package com.baidu.tieba.write.c;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.a.d;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.switchs.LimitLowQualityPicUploadSwitch;
import com.baidu.tieba.write.view.TitleTipView;
/* loaded from: classes3.dex */
public class b {
    private static boolean nYv = false;

    public static void dZu() {
        nYv = true;
    }

    public static boolean dZv() {
        return d.bkp();
    }

    public static void a(TitleTipView titleTipView) {
        if (titleTipView != null) {
            if (!dZv() || nYv || dZw() > 0) {
                titleTipView.setVisibility(8);
                return;
            }
            titleTipView.dZX();
            dZu();
            ar.BZ("c13996").btT();
        }
    }

    private static int dZw() {
        return com.baidu.tbadk.core.sharedPref.b.bsO().getInt("show_write_title_tip_count", 0);
    }

    public static void f(WriteData writeData) {
        if (writeData != null && dZv() && !TextUtils.isEmpty(writeData.getTitle())) {
            com.baidu.tbadk.core.sharedPref.b.bsO().putInt("show_write_title_tip_count", dZw() + 1);
        }
    }

    public static boolean l(ImageFileInfo imageFileInfo) {
        String filePath;
        if (LimitLowQualityPicUploadSwitch.isOff() || imageFileInfo == null || imageFileInfo.isGif() || (filePath = imageFileInfo.getFilePath()) == null) {
            return false;
        }
        long fileSize = n.getFileSize(filePath);
        if (fileSize < 20480) {
            bY(1, "" + fileSize);
            return true;
        }
        int[] imageFileWH = n.getImageFileWH(filePath);
        if (imageFileWH[0] < 120 || imageFileWH[1] < 120) {
            bY(2, imageFileWH[0] + "*" + imageFileWH[1]);
            return true;
        }
        return false;
    }

    private static void bY(int i, String str) {
        TiebaStatic.log(new ar("c14021").dY("uid", TbadkApplication.getCurrentAccount()).al("obj_type", i).dY("obj_param1", str));
    }
}
