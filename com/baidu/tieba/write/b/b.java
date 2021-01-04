package com.baidu.tieba.write.b;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.a.d;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.switchs.LimitLowQualityPicUploadSwitch;
import com.baidu.tieba.write.view.TitleTipView;
/* loaded from: classes8.dex */
public class b {
    private static boolean obr = false;

    public static void dYS() {
        obr = true;
    }

    public static boolean dYT() {
        return d.bmD();
    }

    public static void a(TitleTipView titleTipView) {
        if (titleTipView != null) {
            if (!dYT() || obr || dYU() > 0) {
                titleTipView.setVisibility(8);
                return;
            }
            titleTipView.dZh();
            dYS();
            aq.BY("c13996").bwn();
        }
    }

    private static int dYU() {
        return com.baidu.tbadk.core.sharedPref.b.bvq().getInt("show_write_title_tip_count", 0);
    }

    public static void g(WriteData writeData) {
        if (writeData != null && dYT() && !TextUtils.isEmpty(writeData.getTitle())) {
            com.baidu.tbadk.core.sharedPref.b.bvq().putInt("show_write_title_tip_count", dYU() + 1);
        }
    }

    public static boolean j(ImageFileInfo imageFileInfo) {
        String filePath;
        if (LimitLowQualityPicUploadSwitch.isOff() || imageFileInfo == null || imageFileInfo.isGif() || (filePath = imageFileInfo.getFilePath()) == null) {
            return false;
        }
        long fileSize = n.getFileSize(filePath);
        if (fileSize < 5120) {
            bY(1, "" + fileSize);
            return true;
        }
        int[] imageFileWH = n.getImageFileWH(filePath);
        if (imageFileWH[0] < 100 || imageFileWH[1] < 100) {
            bY(2, imageFileWH[0] + "*" + imageFileWH[1]);
            return true;
        }
        return false;
    }

    private static void bY(int i, String str) {
        TiebaStatic.log(new aq("c14021").dX("uid", TbadkApplication.getCurrentAccount()).an("obj_type", i).dX("obj_param1", str));
    }
}
